package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	// Ordered by Subsystems
	
	// ================== Drivetrain ==================
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}
	
	public static double maxYawCorrectSpeed() {
		return Preferences.getInstance().getDouble("maxYawCorrectSpeed", 0.5);
	}
	
	public static double yawScale() {
		return Preferences.getInstance().getDouble("yawScale", (maxYawCorrectSpeed() / 180.0));
	}
	
	// ================== Shooter ==================
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("shooterVoltageRamp", 0.0);
	}

	public static double talonVoltageSpeed() {
		return Preferences.getInstance().getDouble("shooterVoltageSpeed", 0.0);
	}

	public static double talonVBusSpeed() {
		return Preferences.getInstance().getDouble("shooterVBusSpeed", 0.0);
	}
	
	// ================== Encoder Ratios ==================
	public static double getDriveTrainPulsePer5Feet(){
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

	public static double collectorDeployPosition() {
		return Preferences.getInstance().getDouble("CollectorDeploy", 0.0);
	}

	public static double CollectorHomePosition() {
		return Preferences.getInstance().getDouble("CollectorHome", 0.0);
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
		return Preferences.getInstance().getDouble("DistanceP", 0.4);
	}

	// I value for Vision Distance PID
	public static double VisionDistancePIDI() {
		return Preferences.getInstance().getDouble("DistanceI", 0.0);
	}

	// D value for Vision Distance PID
	public static double VisionDistancePIDD() {
		return Preferences.getInstance().getDouble("DistanceD", 0.6);
	}
	
	public static double VisionDistance() {
		return Preferences.getInstance().getDouble("VisionDistance", 5.0);
	}
	
	// defines the absolute value of the maximum output for the rotate PID
	public static double MoveSpeedMax() {
		return Preferences.getInstance().getDouble("MoveMax", 0.6);
	}

	// ================== Auto ==================
	public static double autoFlatThreshold() {
		return Preferences.getInstance().getDouble("AutoFlatThreshold", 0.0);
	}

	public static double autoObstacleDriveSpeed() {
		return Preferences.getInstance().getDouble("AutoFlatThreshold", 0.0);
	}

	public static double autoFlatDistance() {
		return Preferences.getInstance().getDouble("AutoFlatThreshold", 0.0);
	}
	
}
