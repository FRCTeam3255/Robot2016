package org.usfirst.frc.team3255.robot2016;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

	// Joysticks
	public static final int JOYSTICK_DRIVER = 0;
	public static final int JOYSTICK_MANIPULATOR = 1;
	
	// Axes
	public static final int DRIVER_AXIS_MOVE = 1;
	public static final int DRIVER_AXIS_ROTATE = 2;
	
	public static final int MANIPULATOR_AXIS_INTAKE = 1;
	
	// CANTalons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 0;
	public static final int DRIVETRAIN_LEFT_MIDDLE_TALON = 1;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 2;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_MIDDLE_TALON = 4;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 5;
	
	public static final int SHOOTER_LEFT_TALON = 6;
	public static final int SHOOTER_RIGHT_TALON = 7;
	
	public static final int OBSTACLEARM_TALON = 8;
	
	public static final int COLLECTOR_INTAKE_TALON = 9;
	public static final int COLLECTOR_ARM_TALON = 10;
	
	// Digital Inputs
	public static final int SHOOTER_BALL_HOLD_SWITCH = 0;
	
	public static final int OBSTACLEARM_DEPLOYED_SWITCH = 2;
	public static final int OBSTACLEARM_RETRACTED_SWITCH = 3;
	
	// Solenoids
	public static final int OBSTACLEARM_SOLENOID_CHA = 0;
	public static final int OBSTACLEARM_SOLENOID_CHB = 1;
	
	public static final int SHOOTER_PITCH_SOLENOID_CHA = 2;
	public static final int SHOOTER_PITCH_SOLENOID_CHB = 3;
	
	public static final int DRIVETRAIN_SHIFT_UP = 4;
	public static final int DRIVETRAIN_SHIFT_DOWN = 5;
	
	// Relays
	public static final int LIGHTING_BLUE_RELAY = 0;
	public static final int LIGHTING_RED_RELAY = 1;
}
