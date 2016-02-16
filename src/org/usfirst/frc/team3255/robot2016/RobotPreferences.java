package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

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
		return Preferences.getInstance().getDouble("DriveSpeed", 0.7);
	}
	
	public static double lowSpeedMax() {
		return Preferences.getInstance().getDouble("LowSpeedMax", 0.7);
	}
	
	// ================== Shooter ==================
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("ShooterVoltageRamp", 48.0);
	}

	public static double shooterVoltage() {
		return Preferences.getInstance().getDouble("ShooterVoltage", 7.0);
	}

	public static double shooterSpinUpDelay() {
		return Preferences.getInstance().getDouble("ShooterSpinUpDelay", 0.0);
	}
	
	// ================== Collector ==================
	public static double collectorP() {
		return Preferences.getInstance().getDouble("CollectorP", 0.04);
	}
	
	public static double collectorI() {
		return Preferences.getInstance().getDouble("CollectorI", 0.01);
	}
	
	public static double collectorD() {
		return Preferences.getInstance().getDouble("CollectorD", 0.04);
	}

	public static double maxCollectorSpeed() {
		return Preferences.getInstance().getDouble("CollectorMax", 0.2);
	}

	public static double collectorPickupPosition() {
		return Preferences.getInstance().getDouble("CollectorPickup", -20.0);
	}

	public static double collectorLowPosition() {
		return Preferences.getInstance().getDouble("CollectorLow", -25.0);
	}

	public static double collectorStowPosition() {
		return Preferences.getInstance().getDouble("CollectorStow", 0.0);
	}

	public static double collectorTimeout() {
		return Preferences.getInstance().getDouble("CollectorTimeout", 0.0);
	}
	
	public static double collectorIntakeSpeed() {
		return Preferences.getInstance().getDouble("CollectorIntakeSpeed", 1.0);
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
		return Preferences.getInstance().getDouble("SallyGrab", 38.0);
	}
	
	public static double sallyStowPosition() {
		return Preferences.getInstance().getDouble("SallyStow", 0.0);
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
	
	// ================== Auto ==================
	public static double autoPitchThreshold() {
		return Preferences.getInstance().getDouble("AutoPitchThreshold", 5.0);
	}

	public static double autoObstacleDriveSpeed() {
		return Preferences.getInstance().getDouble("AutoObstacleDriveSpeed", 0.5);
	}

	public static double autoObstacleDistance() {
		return Preferences.getInstance().getDouble("AutoObstacleDistance", 0.0);
	}

	public static double autoFlatDistance() {
		return Preferences.getInstance().getDouble("AutoFlatDistance", 0.0);
	}
	
	public static double autoRotateSpeed() {
		return Preferences.getInstance().getDouble("AutoRotateSpeed", 0.0);
	}
	
	// ================== Lane Distances ==================
	public static double distanceLane1() {
		return Preferences.getInstance().getDouble("DistanceLane1", 0.0);
	}
	
	public static double distanceLane2() {
		return Preferences.getInstance().getDouble("DistanceLane2", 0.0);
	}
	
	public static double distanceLane3() {
		return Preferences.getInstance().getDouble("DistanceLane3", 0.0);
	}
	
	public static double distanceLane4() {
		return Preferences.getInstance().getDouble("DistanceLane4", 0.0);
	}
	
	public static double distanceLane5() {
		return Preferences.getInstance().getDouble("DistanceLane5", 0.0);
	}
	
	// ================== PID Tolerances ==================
	public static double distanceTolerance() {
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.2);
	}
	
	public static double yawTolerance() {
		return Preferences.getInstance().getDouble("YawTolerance", 1.0);
	}
	
	public static double collectorTolerance() {
		return Preferences.getInstance().getDouble("CollectorTolerance", 3.0);
	}
	
	// ================== Drivetrain Distance PID ==================
	public static double driveDistanceP() {
		return Preferences.getInstance().getDouble("DriveDistanceP", 0.3);
	}
	
	public static double driveDistanceI() {
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.0);
	}
	
	public static double driveDistanceD() {
		return Preferences.getInstance().getDouble("DriveDistanceD", 0.2);
	}

	public static double driveDistance() {
		return Preferences.getInstance().getDouble("DriveDistance", 5.0);
	}
	
	// ================== Navigation Yaw PID ==================
	public static double navYawP() {
		return Preferences.getInstance().getDouble("NavYawP", 0.03);
	}

	public static double navYawI() {
		return Preferences.getInstance().getDouble("NavYawI", 0.002);
	}

	public static double navYawD() {
		return Preferences.getInstance().getDouble("NavYawD", 0.0);
	}

	// ================== Vision Yaw PID ==================
	public static double visionYawP() {
		return Preferences.getInstance().getDouble("VisionYawP", 0.0);
	}

	public static double visionYawI() {
		return Preferences.getInstance().getDouble("VisionYawI", 0.0);
	}
	
	public static double visionYawD() {
		return Preferences.getInstance().getDouble("VisionYawD", 0.0);
	}

	// ================== Vision Distance PID ==================
	public static double visionDistanceP() {
		return Preferences.getInstance().getDouble("VisionDistanceP", 0.0);
	}
	
	public static double visionDistanceI() {
		return Preferences.getInstance().getDouble("VisionDistanceI", 0.0);
	}
	
	public static double visionDistanceD() {
		return Preferences.getInstance().getDouble("VisionDistanceD", 0.0);
	}
	
	public static double targetDistance() {
		return Preferences.getInstance().getDouble("TargetDistance", 6.0);
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
	
	public static boolean visionEnabled() {
		return Preferences.getInstance().getBoolean("VisionEnabled", true);
	}

	public static boolean visionProcessedImage() {
		return Preferences.getInstance().getBoolean("ProcessedImage", false);
	}

	public static int visionHueMin() {
		return Preferences.getInstance().getInt("HueMin", 119);
	}

	public static int visionHueMax() {
		return Preferences.getInstance().getInt("HueMax", 203);
	}

	public static int visionSatMin() {
		return Preferences.getInstance().getInt("SatMin", 41);
	}

	public static int visionSatMax() {
		return Preferences.getInstance().getInt("SatMax", 255);
	}

	public static int visionValMin() {
		return Preferences.getInstance().getInt("ValMin", 114);
	}

	public static int visionValMax() {
		return Preferences.getInstance().getInt("ValMax", 246);
	}
	
	public static double visionDistance() {
		return Preferences.getInstance().getDouble("VisionDistance", 5.0);
	}
	
	public static double visionAreaMin() {
		return Preferences.getInstance().getDouble("VisionAreaMin", 0.0);
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
}
