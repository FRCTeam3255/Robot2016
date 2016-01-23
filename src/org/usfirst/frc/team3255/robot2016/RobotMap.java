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
	public static final int AXIS_ARCADE_MOVE = 1;
	public static final int AXIS_ARCADE_ROTATE = 2;
	
	// CANTalons
	public static final int LEFT_FRONT_TALON = 0;
	public static final int LEFT_MIDDLE_TALON = 1;
	public static final int LEFT_BACK_TALON = 2;
	public static final int RIGHT_FRONT_TALON = 3;
	public static final int RIGHT_MIDDLE_TALON = 4;
	public static final int RIGHT_BACK_TALON = 5;
	
	// Digital Inputs
	public static final int LEFT_DRIVETRAIN_ENCODER_CHA = 0;
	public static final int LEFT_DRIVETRAIN_ENCODER_CHB = 1;
	public static final int RIGHT_DRIVETRAIN_ENCODER_CHA = 2;
	public static final int RIGHT_DRIVETRAIN_ENCODER_CHB = 3;
	
	// Solenoids
	public static final int DRIVETRAIN_SHIFTER_UP = 0;
	public static final int DRIVETRAIN_SHIFTER_DOWN = 1;
	
	// Shooter
	public static final int LEFT_SHOOTER_TALON = 0;
	public static final int RIGHT_SHOOTER_TALON = 1;
}
