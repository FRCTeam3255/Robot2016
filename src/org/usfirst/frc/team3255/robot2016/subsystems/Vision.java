package org.usfirst.frc.team3255.robot2016.subsystems;

import java.util.Comparator;
import java.util.Vector;

import org.usfirst.frc.team3255.robot2016.commands.CommandBase;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ImageType;
import com.ni.vision.NIVision.ScalingMode;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {
	public class ParticleReport implements Comparator<ParticleReport>, Comparable<ParticleReport>{
		double PercentAreaToImageArea;
		double Area;
		double ConvexHullArea;
		double BoundingRectLeft;
		double BoundingRectTop;
		double BoundingRectRight;
		double BoundingRectBottom;
		@Override
		public int compareTo(ParticleReport r) {
			return (int)(r.Area - this.Area);
		}
		@Override
		public int compare(ParticleReport r1, ParticleReport r2) {
			return (int)(r1.Area - r2.Area);
		}
	};
	
	//Structure to represent the scores for the various tests used for target identification
	public class Scores {
		double LongAspect;
		double ShortAspect;
		double AreaToConvexHullArea;
	};
	
	//Images
	private Image frame;
	private Image HSVFrame;
	private Image binaryFrame;
	
	private int frontSession, rearSession, currSession;
	
	private int numRawParticles = 0;
	private int numParticles = 0;
	
	private boolean isTarget = false;
	private double distance = 0.0;
	private boolean started = false;
	
	private boolean frontCamera = true;
	
	// variables for navigating image files
	private String imagePrefix = "/home/lvuser/SampleImages/";
	private String imageSuffix = ".jpg";
	private int imageReplayMin = RobotPreferences.imageReplayMin();
	private int imageReplayMax = RobotPreferences.imageReplayMax();;
	private int imageReplayNumber = imageReplayMin;
	private int imageSaveNumber = RobotPreferences.imageSaveNumber();
	
	int newSession;
	NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
	
	//Constants
	final double FOV_DEGREES = 68.5;
	final double FOV_RADIANS = (FOV_DEGREES/180) * Math.PI;
	final double IMAGE_WIDTH_PIXELS = 160;
	final double TARGET_WIDTH_INCHES = 20;
	public static NIVision.Range TARGET_HUE_RANGE = new NIVision.Range(RobotPreferences.visionHueMin(), RobotPreferences.visionHueMax());	//Default hue range for yellow tote
	public static NIVision.Range TARGET_SAT_RANGE = new NIVision.Range(RobotPreferences.visionSatMin(), RobotPreferences.visionSatMax());	//Default saturation range for yellow tote
	public static NIVision.Range TARGET_VAL_RANGE = new NIVision.Range(RobotPreferences.visionValMin(), RobotPreferences.visionValMax());	//Default value range for yellow tote
	public static double AREA_MINIMUM = 0.5; //Default Area minimum for particle as a percentage of total image area
	double HORIZONTAL_RECTANGLE = 2.22; //Tote long side = 26.9 / Tote height = 12.1 = 2.22
	double VERTICAL_RECTANGLE = 1.4; //Tote short side = 16.9 / Tote height = 12.1 = 1.4
	double SCORE_MIN = 75.0;  //Minimum score to be considered a tote
	double VIEW_ANGLE = 49.4; //View angle fo camera, set to Axis m1011 by default, 64 for m1013, 51.7 for 206, 52 for HD3000 square, 60 for HD3000 640x480
	NIVision.ParticleFilterCriteria2 criteria[] = new NIVision.ParticleFilterCriteria2[1];
	NIVision.ParticleFilterOptions2 filterOptions = new NIVision.ParticleFilterOptions2(0,0,1,1);
	Scores scores = new Scores();
	
	public Vision() {
		// create images
		frame = NIVision.imaqCreateImage(ImageType.IMAGE_RGB, 0);
		HSVFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		binaryFrame = NIVision.imaqCreateImage(ImageType.IMAGE_U8, 0);
		criteria[0] = new NIVision.ParticleFilterCriteria2(NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA, AREA_MINIMUM, 100.0, 0, 0);

        // the camera name (ex "cam0") can be found through the roborio web interface
        try {
			frontSession = NIVision.IMAQdxOpenCamera(RobotPreferences.frontCamera(),
			        NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception e) {
			DriverStation.reportError("Camera " + RobotPreferences.frontCamera() + " not found", false);
			frontSession = -1;
		}

        try {
	        rearSession = NIVision.IMAQdxOpenCamera(RobotPreferences.rearCamera(),
	                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		} catch (Exception e) {
			DriverStation.reportError("Camera " + RobotPreferences.rearCamera() + " not found", false);
			rearSession = -1;
		}
        
        currSession = frontSession;
        if(currSession >= 0) {
        	NIVision.IMAQdxConfigureGrab(currSession);
			NIVision.IMAQdxStartAcquisition(currSession);
        }
    }
	
	public void setTargetInvalid() {
		distance = 0;
		isTarget = false;
	}
	
	public void update() {
		if(frontCamera) {
			newSession = frontSession;
		}
		else {
			newSession = rearSession;
		}
		
		if(newSession != currSession) {
			if(currSession >= 0) {
				NIVision.IMAQdxStopAcquisition(currSession);
			}

			currSession = newSession;
			if(currSession >= 0) {
		        NIVision.IMAQdxConfigureGrab(currSession);
				NIVision.IMAQdxStartAcquisition(currSession);
			}
		}
		
		if(RobotPreferences.useCamera()) {
			if(currSession < 0) {
				setTargetInvalid();
				return;
			}
	        NIVision.IMAQdxGrab(currSession, frame, 1);

	        // scale the image down by a factor of two in both directions
			NIVision.imaqScale(frame, frame, 4, 4, ScalingMode.SCALE_SMALLER, NIVision.NO_RECT);
		}
		else {
			//read file in from disk. For this example to run you need to copy image20.jpg from the SampleImages folder to the
			//directory shown below using FTP or SFTP: http://wpilib.screenstepslive.com/s/4485/m/24166/l/282299-roborio-ftp
			boolean imageFound = false;
			int maxImages = imageReplayMax - imageReplayMin + 1;
			for(int i = 0; i < maxImages; i++) {
				try {
					NIVision.imaqReadFile(frame, imagePrefix + imageReplayNumber + imageSuffix);
					imageFound = true;
					break;
				}
				catch(Exception e) {
					nextImage();
				}
			}
			
			if(!imageFound) {
				DriverStation.reportError("No images found", false);
				setTargetInvalid();
				return;
			}
		}
        
		//Update threshold values from SmartDashboard. For performance reasons it is recommended to remove this after calibration is finished.
		TARGET_HUE_RANGE.minValue = RobotPreferences.visionHueMin();
		TARGET_HUE_RANGE.maxValue = RobotPreferences.visionHueMax();
		TARGET_SAT_RANGE.minValue = RobotPreferences.visionSatMin();
		TARGET_SAT_RANGE.maxValue = RobotPreferences.visionSatMax();
		TARGET_VAL_RANGE.minValue = RobotPreferences.visionValMin();
		TARGET_VAL_RANGE.maxValue = RobotPreferences.visionValMax();

		//Threshold the image looking for yellow (tote color)
		NIVision.imaqColorThreshold(HSVFrame, frame, 255, NIVision.ColorMode.HSV, TARGET_HUE_RANGE, TARGET_SAT_RANGE, TARGET_VAL_RANGE);
		
		// NIVision.imaqConvexHull(HSVFrame, HSVFrame, 0);
		
		if (!RobotPreferences.visionEnabled()) {
			// Send images to Dashboard
			if(RobotPreferences.visionProcessedImage()) {
				CameraServer.getInstance().setImage(HSVFrame);
			}
			else {
				CameraServer.getInstance().setImage(frame);
			}
			
			setTargetInvalid();
			return;
		}

		//Send particle count to dashboard
		numRawParticles = NIVision.imaqCountParticles(HSVFrame, 1);

		//filter out small particles
		float areaMin = (float) RobotPreferences.visionAreaMin();
		criteria[0].lower = areaMin;
		NIVision.imaqParticleFilter4(binaryFrame, HSVFrame, criteria, filterOptions, null);

		//Send particle count after filtering to dashboard
		numParticles = NIVision.imaqCountParticles(binaryFrame, 1);

		if(numParticles > 0) {
			//Measure particles and sort by particle size
			Vector<ParticleReport> particles = new Vector<ParticleReport>();
			for(int particleIndex = 0; particleIndex < numParticles; particleIndex++) {
				ParticleReport par = new ParticleReport();
				par.PercentAreaToImageArea = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA_BY_IMAGE_AREA);
				par.Area = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_AREA);
				par.ConvexHullArea = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_CONVEX_HULL_AREA);
				par.BoundingRectTop = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_TOP);
				par.BoundingRectLeft = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_LEFT);
				par.BoundingRectBottom = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_BOTTOM);
				par.BoundingRectRight = NIVision.imaqMeasureParticle(binaryFrame, particleIndex, 0, NIVision.MeasurementType.MT_BOUNDING_RECT_RIGHT);
				particles.add(par);
			}
			particles.sort(null);

			rect.top = (int) particles.elementAt(0).BoundingRectTop;
			rect.left = (int) particles.elementAt(0).BoundingRectLeft;
			rect.height = (int) particles.elementAt(0).BoundingRectBottom - rect.top;
			rect.width = (int) particles.elementAt(0).BoundingRectRight - rect.left;
			
            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

            NIVision.imaqDrawShapeOnImage(HSVFrame, HSVFrame, rect,
                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);

			//This example only scores the largest particle. Extending to score all particles and choosing the desired one is left as an exercise
			//for the reader. Note that the long and short side scores expect a single tote and will not work for a stack of 2 or more totes.
			//Modification of the code to accommodate 2 or more stacked totes is left as an exercise for the reader.
			double aspectRatio = ((double) (rect.width))/rect.height;
            if (aspectRatio > RobotPreferences.visionAspectMin()) {
            	isTarget = true;
            	distance = computeDistance(rect.width);
            }
            else {
    			setTargetInvalid();
            }
            
            /*
            scores.LongAspect = horizontalRectangleScore(particles.elementAt(0));
			scores.ShortAspect = verticalRectanlgeScore(particles.elementAt(0));
			scores.AreaToConvexHullArea = ConvexHullAreaScore(particles.elementAt(0));
			boolean isLong = scores.LongAspect > scores.ShortAspect;
			distance = computeDistance(binaryFrame, particles.elementAt(0), isLong);
			isTarget = (scores.LongAspect > SCORE_MIN || scores.ShortAspect > SCORE_MIN) && scores.AreaToConvexHullArea > SCORE_MIN;
			*/
		} 
		else {
			setTargetInvalid();
		}

		if (isTarget) {
			boolean centered = Math.abs(getTargetCenterX()) < RobotPreferences.targetXThreshold();
			boolean atDistance = Math.abs(distance - RobotPreferences.targetDistance()) < RobotPreferences.targetDistanceThreshold();
			
			if(centered && atDistance) {
				CommandBase.lighting.redOn(true);
				CommandBase.lighting.blueOn(false);
			}
			else {
				CommandBase.lighting.blueOn(true);
				CommandBase.lighting.redOn(false);
			}
		}
		else {
			CommandBase.lighting.blueOn(false);
			CommandBase.lighting.redOn(false);	
		}

		// Send images to Dashboard
		if(RobotPreferences.visionProcessedImage()) {
			CameraServer.getInstance().setImage(HSVFrame);
		}
		else {
			CameraServer.getInstance().setImage(frame);
		}
	}
	
	public void nextImage() {
		imageReplayNumber++;
		if(imageReplayNumber > imageReplayMax) {
			imageReplayNumber = imageReplayMin;
		}
	}
	
	public void prevImage() {
		imageReplayNumber--;
		if(imageReplayNumber < imageReplayMin) {
			imageReplayNumber = imageReplayMax;
		}
	}
	
	public void cameraStart() {
		// return if the camera is already started
		if(started) {
			return;
		}
		
		NIVision.IMAQdxStartAcquisition(currSession);
		started = true;
	}
	
	public void cameraStop() {
		// return if the camera is already stopped
		if(!started) {
			return;
		}
		
		NIVision.IMAQdxStopAcquisition(currSession);
		started = false;
	}
	
	public void useFrontCamera(boolean front) {
		frontCamera = front;
	}
	
	public boolean isFrontCamera() {
		return frontCamera;
	}
	
	public boolean isTarget() {
		return isTarget;
	}
	
	public double getTargetCenterX() {
		double offset = ((rect.left + (rect.width / 2))-(IMAGE_WIDTH_PIXELS / 2)) / (IMAGE_WIDTH_PIXELS / 2);
		return -offset * (FOV_DEGREES / 2.0);
	}
	
	public double getTargetDistance() {
		return distance;
	}
	
	public int getNumRawParticles() {
		return numRawParticles;
	}
	
	public int getNumParticles() {
		return numParticles;
	}
	
	public double getLongAspectScore() {
		return scores.LongAspect;
	}
	
	public double getShortAspectScore() {
		return scores.ShortAspect;
	}
	
	public double getConvexAreaScore() {
		return scores.AreaToConvexHullArea;
	}
	
	double ratioToScore(double ratio) {
		return (Math.max(0, Math.min(100*(1-Math.abs(1-ratio)), 100)));
	}

	double TrapezoidScore(ParticleReport report) {
		return ratioToScore(report.ConvexHullArea/((report.BoundingRectRight-report.BoundingRectLeft)*(report.BoundingRectBottom-report.BoundingRectTop)*.954));
	}
	
	double horizontalRectangleScore(ParticleReport report) {
		return ratioToScore(((report.BoundingRectRight-report.BoundingRectLeft)/(report.BoundingRectBottom-report.BoundingRectTop))/HORIZONTAL_RECTANGLE);
	}

	double verticalRectanlgeScore(ParticleReport report){
		return ratioToScore(((report.BoundingRectRight-report.BoundingRectLeft)/(report.BoundingRectBottom-report.BoundingRectTop))/VERTICAL_RECTANGLE);
	}
	
	double ConvexHullAreaScore(ParticleReport report) {
		return ratioToScore((report.Area/report.ConvexHullArea)*1.18);
	}

	double computeDistance(Image image, ParticleReport report, boolean isLong) {
		double normalizedWidth, targetWidth;
		NIVision.GetImageSizeResult size;

		size = NIVision.imaqGetImageSize(image);
		normalizedWidth = 2*(report.BoundingRectRight - report.BoundingRectLeft)/size.width;
		targetWidth = isLong ? 26.0 : 16.9;

		return  targetWidth/(normalizedWidth*12*Math.tan(VIEW_ANGLE*Math.PI/(180*2)));
	}
	
	// returns target distance in feet
	double computeDistance(int targetWidthPixels) {
		double alpha;
		double distance;

		alpha = (FOV_RADIANS * targetWidthPixels)/IMAGE_WIDTH_PIXELS;
		
		// compute distance in inches
		distance = TARGET_WIDTH_INCHES/(2 * Math.tan(alpha/2));
		
		// convert distance to feet
		distance = distance / 12;
		
		return distance;
	}
	
	public void updateReplayRange() {
		imageReplayMin = RobotPreferences.imageReplayMin();
		imageReplayMax = RobotPreferences.imageReplayMax();
		imageSaveNumber = RobotPreferences.imageSaveNumber();
		imageReplayNumber = imageReplayMin;
	}
	
	public void saveFrame() {
		// TODO May need a color table for the save frame
		NIVision.imaqWriteFile(frame, imagePrefix + imageSaveNumber + imageSuffix, null);
		imageSaveNumber++;
	}
	
	@Override
	protected void initDefaultCommand() {
		// setDefaultCommand(new VisionUpdate());
	}
}

