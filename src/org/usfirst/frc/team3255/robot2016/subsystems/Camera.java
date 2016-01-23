package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Camera extends Subsystem {
	
	int session;
    Image frame;
	
	public void cameraInit() {
    	frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        // the camera name (ex "cam0") can be found through the roborio web interface
        session = NIVision.IMAQdxOpenCamera(RobotPreferences.cameraName(),
                NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        NIVision.IMAQdxConfigureGrab(session);
    }
	

    public void cameraStart() {
    	NIVision.IMAQdxStartAcquisition(session);
    }
    
    public void cameraUpdate() {
    	 NIVision.IMAQdxGrab(session, frame, 1);
         CameraServer.getInstance().setImage(frame);
    }
    
    public void cameraStop() {
    	NIVision.IMAQdxStopAcquisition(session);
    }

    public void initDefaultCommand() {
    	
    }
}

