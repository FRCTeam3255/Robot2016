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
	
	public static double getDrivetrainPulsesPer5Feet() {
		return Preferences.getInstance().getDouble("DrivePulsesPer5Ft", 0.6);
	}
	
	public static double maxYawSpeed() {
		return Preferences.getInstance().getDouble("MaxYawSpeed", 0.6);
	}
	
	// ================== Shooter ==================
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("ShooterVoltageRamp", 0.0);
	}

	public static double shooterVoltage() {
		return Preferences.getInstance().getDouble("ShooterVoltage", 0.0);
	}

	public static double shooterSpeed() {
		return Preferences.getInstance().getDouble("ShooterSpeed", 0.0);
	}
	
	public static double shooterSpinUpDelay() {
		return Preferences.getInstance().getDouble("ShooterSpinUpDelay", 0.0);
	}
	
	// ================== Encoder Ratios ==================
	public static double getDrivetrainPulsePer5Feet(){
		return Preferences.getInstance().getDouble("DriveTrainPulsePer5Feet", 0.0);
	}
	
	public static double getObstacleArmPulsePerRotation(){
		return Preferences.getInstance().getDouble("ObstacleArmPulsePerRotation", 0.0);
	}
	
	public static double getShooterPulsePerRotation(){
		return Preferences.getInstance().getDouble("ShooterPulsePerRotation", 0.0);
	}
	public static double getCollectorPulsePerRotation(){
		return Preferences.getInstance().getDouble("CollectorPulsePerRotation", 0.0);
	}

	public static double sallyPortPosition() {
		return Preferences.getInstance().getDouble("SallyPortPosition", 0.0);
	}
	
	public static double obstaclearmHomePosition() {
		return Preferences.getInstance().getDouble("HomePosition", 0.0);
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
		return Preferences.getInstance().getInt("HueMin", 30);
	}

	public static int visionSatMin() {
		return Preferences.getInstance().getInt("SatMin", 30);
	}

	public static int visionValMin() {
		return Preferences.getInstance().getInt("ValMin", 30);
	}

	public static int visionHueMax() {
		return Preferences.getInstance().getInt("HueMax", 60);
	}

	public static int visionSatMax() {
		return Preferences.getInstance().getInt("SatMax", 60);
	}

	public static int visionValMax() {
		return Preferences.getInstance().getInt("ValMax", 60);
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
	
	public static double driveDistanceTolerance() {
		return Preferences.getInstance().getDouble("DriveDistanceTolerance", 0.0);
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
	
	public static double navYawTolerance() {
		return Preferences.getInstance().getDouble("NavYawTolerance", 0.0);
	}

	// ================== Vision Rotate PID ==================
	public static double visionRotateP() {
		return Preferences.getInstance().getDouble("VisionRotateP", 0.0);
	}

	public static double visionRotateI() {
		return Preferences.getInstance().getDouble("VisionRotateI", 0.0);
	}
	
	public static double visionRotateD() {
		return Preferences.getInstance().getDouble("VisionRotateD", 0.0);
	}

	// ================== Vision Move PID ==================
	public static double visionMoveP() {
		return Preferences.getInstance().getDouble("VisionMoveP", 0.0);
	}
	
	public static double visionMoveI() {
		return Preferences.getInstance().getDouble("VisionMoveI", 0.0);
	}
	
	public static double visionMoveD() {
		return Preferences.getInstance().getDouble("VisionMoveD", 0.0);
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
		return Preferences.getInstance().getDouble("CollectorIntakeSpeed", 0.0);
	}
	
	// ================== Sally Arm ==================
	public static double sallyArmSensitivity() {
		return Preferences.getInstance().getDouble("SallySensitivity", 0.5);
	}
}
