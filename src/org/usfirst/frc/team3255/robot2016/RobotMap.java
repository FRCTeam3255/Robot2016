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
	public static final int JOYSTICK_AUTO = 3;
	public static final int CALIBRATION_STICK = 2;
	
	// Axes
	public static final int DRIVER_AXIS_MOVE = 1;
	public static final int DRIVER_AXIS_ROTATE = 2;
	
	public static final int MANIPULATOR_AXIS_Y = 1;
	
	public static final int AUTO_AXIS_SELECTOR = 0;
	
	// CANTalons
	public static final int DRIVETRAIN_LEFT_FRONT_TALON = 1;
	public static final int DRIVETRAIN_LEFT_MIDDLE_TALON = 2;
	public static final int DRIVETRAIN_LEFT_BACK_TALON = 3;
	public static final int DRIVETRAIN_RIGHT_FRONT_TALON = 4;
	public static final int DRIVETRAIN_RIGHT_MIDDLE_TALON = 5;
	public static final int DRIVETRAIN_RIGHT_BACK_TALON = 6;
	
	public static final int SHOOTER_LEFT_TALON = 7;
	public static final int SHOOTER_RIGHT_TALON = 8;
	
	public static final int SALLYARM_TALON = 9;
	
	public static final int COLLECTOR_INTAKE_TALON = 10;
	public static final int COLLECTOR_ARM_TALON = 11;
	
	// Digital Inputs
	public static final int SHOOTER_BALL_HOLD_SWITCH = 0;
	
	public static final int SALLY_STOW_SWITCH = 1;
	
	// Solenoids
	public static final int SALLYARM_SOLENOID_DEPLOY = 0;
	public static final int SALLYARM_SOLENOID_RETRACT = 1;
	
	public static final int SHOOTER_PITCH_SOLENOID_DEPLOY = 2;
	public static final int SHOOTER_PITCH_SOLENOID_RETRACT = 3;
	
	public static final int DRIVETRAIN_SHIFT_UP = 4;
	public static final int DRIVETRAIN_SHIFT_DOWN = 5;
	
	// Relays
	public static final int LIGHTING_BLUE_RELAY = 0;
	public static final int LIGHTING_RED_RELAY = 1;

}
