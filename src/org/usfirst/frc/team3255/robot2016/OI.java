package org.usfirst.frc.team3255.robot2016;

import org.usfirst.frc.team3255.robot2016.commands.*;
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
	public static Joystick autoStick = new Joystick(RobotMap.JOYSTICK_AUTO);
	
	// manipulatorStick
	Button M1 = new JoystickButton(manipulatorStick, 1);
	Button M2 = new JoystickButton(manipulatorStick, 2);
	Button M3 = new JoystickButton(manipulatorStick, 3);
	Button M4 = new JoystickButton(manipulatorStick, 4);
	Button M7 = new JoystickButton(manipulatorStick, 7);
	Button M8 = new JoystickButton(manipulatorStick, 8);
	Button M9 = new JoystickButton(manipulatorStick, 9);
	Button M10 = new JoystickButton(manipulatorStick, 10);
	Button M11 = new JoystickButton(manipulatorStick, 11);
	Button M12 = new JoystickButton(manipulatorStick, 12);
	
	// driveStick
	Button D1 = new JoystickButton(driverStick, 1);
	Button D2 = new JoystickButton(driverStick, 2);
	Button D3 = new JoystickButton(driverStick, 3);
	Button D4 = new JoystickButton(driverStick, 4);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	
	public OI() {
		// manipulatorStick
		M1.whileHeld(new ShooterShoot());
		M2.whenPressed(new ShooterPrep());
		M3.whenPressed(new CollectBall());
		M4.whileHeld(new CollectorJoystickArm());
		M7.whileHeld(new CollectorJoystickIntake());
		M8.whileHeld(new SallyJoystick());
		M9.whenPressed(new SallyDeploy());
		M10.whenPressed(new SallyRetract());
		M11.whenPressed(new ShooterPitchUp());
		M12.whenPressed(new ShooterPitchDown());
		
		// driveStick
		D1.whenPressed(new VisionPrevImage());
		D2.whileHeld(new DriveSpeed());
		D3.whenPressed(new VisionNextImage());
		D4.whenPressed(new VisionToggleCameraFile());
		D7.whenPressed(new DriveShiftUp());
		D8.whenPressed(new DriveShiftDown());
		
	}
	
	public int getLane() {
		int lane = 1;
		
		double stickValue = autoStick.getRawAxis(RobotMap.AUTO_AXIS_SELECTOR);
		
		if(stickValue > 0.75) {
			lane = 1;
		}		
		else if (stickValue > 0.25) {
			lane = 2;
		}
		else if (stickValue > -0.25) {
			lane = 3;
		}		
		else if (stickValue > -0.75) {
			lane = 4;
		}		
		else {
			lane = 5;
		}
		return lane;
	}
	
	public boolean isLowSpeed() {
		return driverStick.getRawButton(5);
	}
}

