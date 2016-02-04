package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.Preferences;

public class RobotPreferences {

	// Ordered by Subsystems
	
	// Camera
	public static String cameraName() {
		return Preferences.getInstance().getString("CameraName", "cam0");
	}
	
	// Drivetrain
	public static double driveSensitivity() {
		return Preferences.getInstance().getDouble("DriveSensitivity", 1.0);
	}
	
	// Shooter
	public static double shooterVoltageRamp() {
		return Preferences.getInstance().getDouble("shooterVoltageRamp", 0.0);
	}

	public static double talonVoltageSpeed() {
		return Preferences.getInstance().getDouble("shooterVoltageSpeed", 0.0);
	}

	public static double talonVBusSpeed() {
		return Preferences.getInstance().getDouble("shooterVBusSpeed", 0.0);
	}
	
	// Encoder Ratios
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
	
}
