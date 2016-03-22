package org.usfirst.frc.team3255.robot2016;

import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {
	
	private static int calibrationMode = 0;

	// ================== Calibration Modes ==================
	public static String getCalibrationMode() {
		switch(calibrationMode) {
			case 0:
				return "Disabled";
			case 1:
				return "Target X";
			case 2:
				return "Target Y";
			case 3:
				return "Hue";
			case 4:
				return "Saturation";
			case 5:
				return "Value";
		}
		return "";
	}
	
	public static void nextCalibrationMode() {
		calibrationMode++;
		
		if (calibrationMode > 5) {
			calibrationMode = 0;
		}
	}
	
	public static void prevCalibrationMode() {
		calibrationMode--;
		
		if (calibrationMode < 0) {
			calibrationMode = 5;
		}
	}
	
	public static void saveCalibration() {
		switch(calibrationMode) {
			case 0: /* disabled */
				break;
			case 1: /* Target X */
				Preferences.getInstance().putInt("TargetXMin", (int) CommandBase.oi.getCalibrationStickValue(0, 0, 160));
				Preferences.getInstance().putInt("TargetXMax", (int) CommandBase.oi.getCalibrationStickValue(1, 0, 160));
				break;				
			case 2: /* Target Y */
				Preferences.getInstance().putInt("TargetYMin", (int) CommandBase.oi.getCalibrationStickValue(0, 0, 160));
				Preferences.getInstance().putInt("TargetYMax", (int) CommandBase.oi.getCalibrationStickValue(1, 0, 160));
				break;				
			case 3: /* Hue */
				Preferences.getInstance().putInt("HueMin", (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255));
				Preferences.getInstance().putInt("HueMax", (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255));
				break;				
			case 4: /* Saturation */
				Preferences.getInstance().putInt("SatMin", (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255));
				Preferences.getInstance().putInt("SatMax", (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255));
				break;
			case 5: /* Value */
				Preferences.getInstance().putInt("ValMin", (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255));
				Preferences.getInstance().putInt("ValMax", (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255));
				break;
		}
	}

	// Ordered by Subsystems

	// ================== Drivetrain ==================
	public static double maxMoveSpeed() {
		return Preferences.getInstance().getDouble("MaxMoveSpeed", 0.6);
	}
	
	public static double drivetrainPulsesPer5Feet() {
		return Preferences.getInstance().getDouble("DrivePulsesPer5Ft", -19.796);
	}
	
	public static double maxYawSpeed() {
		return Preferences.getInstance().getDouble("MaxYawSpeed", 0.6);
	}
	
	public static double driveSpeed() {
		return Preferences.getInstance().getDouble("DriveSpeed", -0.7);
	}
	
	public static double lowSpeedMax() {
		return Preferences.getInstance().getDouble("LowSpeedMax", 0.7);
	}
	
	public static double driveSallyDistance() {
		return Preferences.getInstance().getDouble("driveSallyDistance", 0.6);
	}
	
	public static double driveSallyDistance2() {
		return Preferences.getInstance().getDouble("driveSallyDistance2", 0.8);
	}
	
	public static double driveSallyDistance3() {
		return Preferences.getInstance().getDouble("driveSallyDistance3", 1.0);
	}
	
	// ================== Shooter ==================
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("ShooterVoltageRamp", 48.0);
	}

	public static double shooterVoltage() {
		return Preferences.getInstance().getDouble("ShooterVoltage", 6.0);
	}
	
	public static double ejectVoltage() {
		return Preferences.getInstance().getDouble("EjectVoltage", 6.0);
	}
	
	public static double shooterSpikeVoltage() {
		return Preferences.getInstance().getDouble("ShooterSpikeVoltage", 8.0);
	}

	public static double removeBallVoltage() {
		return Preferences.getInstance().getDouble("RemoveVoltage", 7.0);
	}
	
	public static double shooterSpinUpDelay() {
		return Preferences.getInstance().getDouble("ShooterSpinUpDelay", 0.5);
	}
	
	public static double shooterEjectDelay() {
		return Preferences.getInstance().getDouble("ShooterEjectDelay", 1.0);
	}
	
	// ================== Collector ==================
	public static double collectorP() {
		return Preferences.getInstance().getDouble("CollectorP", 0.04);
	}
	
	public static double collectorI() {
		return Preferences.getInstance().getDouble("CollectorI", 0.005);
	}
	
	public static double collectorD() {
		return Preferences.getInstance().getDouble("CollectorD", 0.08);
	}

	public static double maxCollectorSpeed() {
		return Preferences.getInstance().getDouble("CollectorMax", 0.3);
	}

	public static double collectorPickupPosition() {
		return Preferences.getInstance().getDouble("CollectorPickup", -22.0);
	}

	public static double collectorLowPosition() {
		return Preferences.getInstance().getDouble("CollectorLow", -26.0);
	}

	public static double collectorStowPosition() {
		return Preferences.getInstance().getDouble("CollectorStow", 0.0);
	}
	
	public static double collectorShootPosition() {
		return Preferences.getInstance().getDouble("CollectorShoot", -8.0);
	}

	public static double collectorForwardTimeout() {
		return Preferences.getInstance().getDouble("CollectorForwardTimeout", 0.2);
	}
	
	public static double collectorReverseTimeout() {
		return Preferences.getInstance().getDouble("CollectorReverseTimeout", 0.05);
	}
	
	public static double collectorIntakeSpeed() {
		return Preferences.getInstance().getDouble("CollectorIntakeSpeed", 0.8);
	}
	
	public static double collectorShootSpeed() {
		return Preferences.getInstance().getDouble("CollectorShootSpeed", 0.6);
	}
	
	public static double collectorIntakeReverseSpeed() {
		return Preferences.getInstance().getDouble("CollectorIntakeReverseSpeed", 0.5);
	}
	
	public static double collectorEncoderCompression() {
		return Preferences.getInstance().getDouble("CollectorEncoderCompression", 0.01);
	}
	
	public static double collectorPIDTimeout() {
		return Preferences.getInstance().getDouble("CollectorPIDTimeout", 5.0);
	}
	
	// ================== Sally Arm ==================
	public static double sallyArmSensitivity() {
		return Preferences.getInstance().getDouble("SallySensitivity", 1.0);
	}
	
	public static double sallyP() {
		return Preferences.getInstance().getDouble("SallyP", 0.03);
	}
	
	public static double sallyI() {
		return Preferences.getInstance().getDouble("SallyI", 0.0015);
	}
	
	public static double sallyD() {
		return Preferences.getInstance().getDouble("SallyD", 0.008);
	}
	
	public static double sallyGrabPosition() {
		return Preferences.getInstance().getDouble("SallyGrab", 34.0);
	}
	
	public static double sallyStowPosition() {
		return Preferences.getInstance().getDouble("SallyStow", 0.0);
	}
	
	public static double sallyDrawbridgePosition() {
		return Preferences.getInstance().getDouble("SallyDrawbridge", 50.0);
	}

	public static double maxSallySpeed() {
		return Preferences.getInstance().getDouble("SallyMax", 1.0);
	}
		
	public static double sallyTolerance() {
		return Preferences.getInstance().getDouble("SallyTolerance", 1.0);
	}
	
	public static double sallyEncoderCompression() {
		return Preferences.getInstance().getDouble("SallyEncoderCompression", 0.1);
	}
	
	public static double sallyDriveSpeed() {
		return Preferences.getInstance().getDouble("SallyDriveSpeed", -0.5);
	}

	public static double sallyDeploySafety() {
		return Preferences.getInstance().getDouble("SallyDeploySafety", 1.0);
	}
	
	// ================== Auto ==================
	public static double autoPitchThreshold() {
		return Preferences.getInstance().getDouble("AutoPitchThreshold", 8.0);
	}
	
	public static double autoFlatThreshold() {
		return Preferences.getInstance().getDouble("AutoFlatThreshold", 5.0);
	}

	public static double autoObstacleDriveSpeed() {
		return Preferences.getInstance().getDouble("AutoObstacleDriveSpeed", 0.8);
	}

	public static double autoObstacleDistance() {
		return Preferences.getInstance().getDouble("AutoObstacleDistance", 3.0);
	}

	public static double autoFlatDistance() {
		return Preferences.getInstance().getDouble("AutoFlatDistance", 0.0);
	}
	
	public static double autoRotateSpeed() {
		return Preferences.getInstance().getDouble("AutoRotateSpeed", 0.0);
	}
	
	public static double autoCommandTimeout() {
		return Preferences.getInstance().getDouble("AutoCommandTimeout", 4.0);
	}
	
	public static double laneDistanceTimeout() {
		return Preferences.getInstance().getDouble("LaneDistanceTimeout", 4.0);
	}
	
	public static double autoDecelerationThreshold() {
		return Preferences.getInstance().getDouble("AutoDecelerationThreshold", 0.0);
	}
	
	
	// ================== Lane Distances ==================
	public static double distanceOuterLane() {
		return Preferences.getInstance().getDouble("DistanceOuterLane", 0.0);
	}
	
	public static double distanceInnerLane() {
		return Preferences.getInstance().getDouble("DistanceInnerLane", 0.0);
	}
	
	public static double distanceCenterLane() {
		return Preferences.getInstance().getDouble("DistanceCenterLane", 0.0);
	}
	
	public static double angleOuterLane() {
		return Preferences.getInstance().getDouble("AngleOuterLane", 0.0);
	}
	
	public static double angleInnerLane() {
		return Preferences.getInstance().getDouble("AngleInnerLane", 0.0);
	}
	
	public static double angleCenterLane() {
		return Preferences.getInstance().getDouble("AngleCenterLane", 0.0);
	}
	
	// ================== PID Tolerances ==================
	public static double distanceTolerance() {
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.2);
	}
	
	public static double autoDistanceTolerance() {
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.3);
	}
	
	public static double yawTolerance() {
		return Preferences.getInstance().getDouble("YawTolerance", 2.0);
	}
	
	public static double collectorTolerance() {
		return Preferences.getInstance().getDouble("CollectorTolerance", 0.5);
	}
	
	public static double targetXThreshold() {
		return Preferences.getInstance().getDouble("TargetXThreshold", 2.0);
	}
	
	// ================== Drivetrain Distance PID ==================
	public static double driveDistanceP() {
		return Preferences.getInstance().getDouble("DriveDistanceP", 0.7);
	}
	
	public static double driveDistanceI() {
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.04);
	}
	
	public static double driveDistanceD() {
		return Preferences.getInstance().getDouble("DriveDistanceD", 5.0);
	}

	public static double driveDistance() {
		return Preferences.getInstance().getDouble("DriveDistance", 3.0);
	}
	
	// ================== Navigation Yaw PID ==================
	public static double navYawP() {
		return Preferences.getInstance().getDouble("NavYawP", 0.06);
	}

	public static double navYawI() {
		return Preferences.getInstance().getDouble("NavYawI", 0.002);
	}

	public static double navYawD() {
		return Preferences.getInstance().getDouble("NavYawD", 0.2);
	}

	// ================== Vision Yaw PID ==================
	public static double visionYawP() {
		return Preferences.getInstance().getDouble("VisionYawP", 0.06);
	}

	public static double visionYawI() {
		return Preferences.getInstance().getDouble("VisionYawI", 0.002);
	}
	
	public static double visionYawD() {
		return Preferences.getInstance().getDouble("VisionYawD", 0.2);
	}

	// ================== Vision Distance PID ==================
	public static double visionDistanceP() {
		return Preferences.getInstance().getDouble("VisionDistanceP", 0.7);
	}
	
	public static double visionDistanceI() {
		return Preferences.getInstance().getDouble("VisionDistanceI", 0.04);
	}
	
	public static double visionDistanceD() {
		return Preferences.getInstance().getDouble("VisionDistanceD", 5.0);
	}
	
	public static double targetDistance() {
		return Preferences.getInstance().getDouble("TargetDistance", 5.6);
	}

	public static double targetDistanceThreshold() {
		return Preferences.getInstance().getDouble("TargetDistanceThreshold", 0.1);
	}

	// ================== Vision ==================
	public static String cameraName() {
		return Preferences.getInstance().getString("CameraName", "cam0");
	}
	
	public static String frontCamera() {
		return Preferences.getInstance().getString("FrontCamera", "cam0");
	}

	public static String rearCamera() {
		return Preferences.getInstance().getString("RearCamera", "cam1");
	}

	public static int visionHueMin() {
		if(calibrationMode != 3) {
			return Preferences.getInstance().getInt("HueMin", 119);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255);
	}

	public static int visionHueMax() {
		if(calibrationMode != 3) {
			return Preferences.getInstance().getInt("HueMax", 203);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255);
	}

	public static int visionSatMin() {
		if(calibrationMode != 4) {
			return Preferences.getInstance().getInt("SatMin", 41);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255);
	}

	public static int visionSatMax() {
		if(calibrationMode != 4) {
			return Preferences.getInstance().getInt("SatMax", 255);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255);
	}

	public static int visionValMin() {
		if(calibrationMode != 5) {
			return Preferences.getInstance().getInt("ValMin", 114);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(0, 0, 255);
	}

	public static int visionValMax() {
		if(calibrationMode != 5) {
			return Preferences.getInstance().getInt("ValMax", 246);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(1, 0, 255);
	}
	
	public static double visionDistance() {
		return Preferences.getInstance().getDouble("VisionDistance", 5.1);
	}
	
	public static double visionAreaMin() {
		return Preferences.getInstance().getDouble("VisionAreaMin", 0.5);
	}
	
	public static int imageReplayMin() {
		return Preferences.getInstance().getInt("ImageReplayMin", 0);
	}
	
	public static int imageReplayMax() {
		return Preferences.getInstance().getInt("ImageReplayMax", 542);
	}

	public static int imageSaveNumber() {
		return Preferences.getInstance().getInt("ImageSaveNumber", 0);
	}

	public static boolean useCamera() {
		return Preferences.getInstance().getBoolean("UseCamera", true);
	}
	
	public static double visionAspectMin() {
		return Preferences.getInstance().getDouble("AspectMin", 1.3);
	}
	
	public static int targetXMin() {
		if(calibrationMode != 1) {
			return Preferences.getInstance().getInt("TargetXMin", 0);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(0, 0, 160);
	}
	
	public static int targetXMax() {
		if(calibrationMode != 1) {
			return Preferences.getInstance().getInt("TargetXMax", 160);	
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(1, 0, 160);
	}
	
	public static int targetYMin() {
		if(calibrationMode != 2) {
			return Preferences.getInstance().getInt("TargetYMin", 0);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(0, 0, 160);	
	}
	
	public static int targetYMax() {
		if(calibrationMode != 2) {
			return Preferences.getInstance().getInt("TargetYMax", 160);
		}
		
		return (int) CommandBase.oi.getCalibrationStickValue(1, 0, 160);	
	}
}
