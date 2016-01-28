package org.usfirst.frc.team3255.robot2016;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	//Joysticks
	public static Joystick manipulatorStick = new Joystick(RobotMap.JOYSTICK_MANIPULATOR);
	public static Joystick driverStick = new Joystick(RobotMap.JOYSTICK_DRIVER);
	
	// manipulatorStick
	Button M1 = new JoystickButton(manipulatorStick, 1);
	
	// driveStick
	Button D5 = new JoystickButton(driverStick, 5);
	
	public OI() {
		// manipulatorStick	
		
		// driveStick
	}
}

