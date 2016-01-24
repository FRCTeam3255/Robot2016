package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.DigitalSource;

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
	public static final int LEFT_DRIVETRAIN_ENCODER_CHA = 0;
	public static final int LEFT_DRIVETRAIN_ENCODER_CHB = 1;
	public static final int RIGHT_DRIVETRAIN_ENCODER_CHA = 2;
	public static final int RIGHT_DRIVETRAIN_ENCODER_CHB = 3;

	public static final int COLLECTOR_INTAKE_SWITCH = 4;
	
	public static final int SHOOTER_SHOOT_SWITCH = 5;
	
	public static final int SHOOTER_ENCODER_CHA = 6;
	public static final int SHOOTER_ENCODER_CHB = 7;
	
	public static final int OBSTACLEARM_ENCODER_CHA = 8;
	public static final int OBSTACLEARM_ENCODER_CHB = 9;
	
	public static final int COLLECTOR_ENCODER_CHA = 10;
	public static final int COLLECTOR_ENCODER_CHB = 11;
	
	// Solenoids
	public static final int DRIVETRAIN_SHIFTER_UP = 0;
	public static final int DRIVETRAIN_SHIFTER_DOWN = 1;
	
	public static final int OBSTACLEARM_SOLENOID_CHA = 2;
	public static final int OBSTACLEARM_SOLENOID_CHB = 3;
	
}
