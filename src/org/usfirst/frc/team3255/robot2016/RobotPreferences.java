package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	// Ordered by Subsystems
	
	// ================== Drivetrain ==================
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}
	
	public static double maxMoveSpeed() {
		return Preferences.getInstance().getDouble("MaxMoveSpeed", 0.6);
	}
	
	public static double drivetrainPulsesPer5Feet() {
		return Preferences.getInstance().getDouble("DrivePulsesPer5Ft", 0.6);
	}
	
	public static double maxYawSpeed() {
		return Preferences.getInstance().getDouble("MaxYawSpeed", 0.6);
	}
	
	public static double driveUserSpeed() {
		return Preferences.getInstance().getDouble("DriveUserSpeed", 1.0);
	}
	
	// ================== Shooter ==================
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("ShooterVoltageRamp", 0.0);
	}

	public static double shooterVoltage() {
		return Preferences.getInstance().getDouble("ShooterVoltage", 7.0);
	}

	public static double shooterSpeed() {
		return Preferences.getInstance().getDouble("ShooterSpeed", 0.0);
	}
	
	public static double shooterSpinUpDelay() {
		return Preferences.getInstance().getDouble("ShooterSpinUpDelay", 0.0);
	}
	
	public static double shooterPulsePerRotation(){
		return Preferences.getInstance().getDouble("ShooterPulsePerRotation", 0.0);
	}
	
	// ================== Collector ==================
	public static double collectorP() {
		return Preferences.getInstance().getDouble("CollectorP", 0.0);
	}
	
	public static double collectorI() {
		return Preferences.getInstance().getDouble("CollectorI", 0.0);
	}
	
	public static double collectorD() {
		return Preferences.getInstance().getDouble("CollectorD", 0.0);
	}

	public static double collectorPickupPosition() {
		return Preferences.getInstance().getDouble("CollectorPickup", 0.0);
	}

	public static double collectorLowPosition() {
		return Preferences.getInstance().getDouble("CollectorLow", 0.0);
	}
	
	public static double collectorTolerance() {
		return Preferences.getInstance().getDouble("CollectorTolerance", 0.0);
	}

	public static double collectorTimeout() {
		return Preferences.getInstance().getDouble("CollectorTimeout", 0.0);
	}
	
	public static double collectorIntakeSpeed() {
		return Preferences.getInstance().getDouble("CollectorIntakeSpeed", 1.0);
	}
	
	public static double collectorPulsePerRotation() {
		return Preferences.getInstance().getDouble("CollectorPulsePerRotation", 0.0);
	}
	
	// ================== Sally Arm ==================
	public static double sallyArmSensitivity() {
		return Preferences.getInstance().getDouble("SallySensitivity", 0.5);
	}
	
	public static double sallyArmPulsePerRotation(){
		return Preferences.getInstance().getDouble("SallyArmPulsePerRotation", 0.0);
	}
	
	public static double sallyPortPosition() {
		return Preferences.getInstance().getDouble("SallyPortPosition", 0.0);
	}
	
	public static double sallyArmHomePosition() {
		return Preferences.getInstance().getDouble("SallyArmHomePosition", 0.0);
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
		return Preferences.getInstance().getDouble("AutoRotateSpeed", 0.);
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
		return Preferences.getInstance().getDouble("DistanceTolerance", 0.0);
	}
	
	public static double yawTolerance() {
		return Preferences.getInstance().getDouble("YawTolerance", 0.0);
	}
	
	// ================== Drivetrain Distance PID ==================
	public static double driveDistanceP() {
		return Preferences.getInstance().getDouble("DriveDistanceP", 0.0);
	}
	
	public static double driveDistanceI() {
		return Preferences.getInstance().getDouble("DriveDistanceI", 0.0);
	}
	
	public static double driveDistanceD() {
		return Preferences.getInstance().getDouble("DriveDistanceD", 0.0);
	}
	
	// ================== Navigation Yaw PID ==================
	public static double navYawP() {
		return Preferences.getInstance().getDouble("NavYawP", 0.0);
	}

	public static double navYawI() {
		return Preferences.getInstance().getDouble("NavYawI", 0.0);
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
		return Preferences.getInstance().getDouble("targetDistance", 6.0);
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
	
	// P value for Vision Rotate PID
	public static double VisionRotatePIDP() {
		return Preferences.getInstance().getDouble("RotateP", 0.8);
	}

	// I value for Vision Rotate PID
	public static double VisionRotatePIDI() {
		return Preferences.getInstance().getDouble("RotateI", 0.0);
	}

	// D value for Vision Rotate PID
	public static double VisionRotatePIDD() {
		return Preferences.getInstance().getDouble("RotateD", 0.6);
	}
	
	// defines the absolute value of the maximum output for the rotate PID
	public static double RotateSpeedMax() {
		return Preferences.getInstance().getDouble("RotateMax", 0.6);
	}
	
	// P value for Vision Distance PID
	public static double VisionDistancePIDP() {
		return Preferences.getInstance().getDouble("VisionDistanceP", 0.4);
	}

	// I value for Vision Distance PID
	public static double VisionDistancePIDI() {
		return Preferences.getInstance().getDouble("VisionDistanceI", 0.0);
	}

	// D value for Vision Distance PID
	public static double VisionDistancePIDD() {
		return Preferences.getInstance().getDouble("VisionDistanceD", 0.6);
	}
	
	public static double VisionDistance() {
		return Preferences.getInstance().getDouble("VisionDistance", 5.0);
	}
	
	// defines the absolute value of the maximum output for the rotate PID
	public static double MoveSpeedMax() {
		return Preferences.getInstance().getDouble("MoveMax", 0.6);
	}
}
