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
	public static Joystick calibrationStick = new Joystick(RobotMap.CALIBRATION_STICK);
	
	// manipulatorStick
	Button M1 = new JoystickButton(manipulatorStick, 1);
	Button M2 = new JoystickButton(manipulatorStick, 2);
	Button M3 = new JoystickButton(manipulatorStick, 3);
	Button M4 = new JoystickButton(manipulatorStick, 4);
	Button M5 = new JoystickButton(manipulatorStick, 5);
	Button M6 = new JoystickButton(manipulatorStick, 6);
	Button M7 = new JoystickButton(manipulatorStick, 7);
	Button M8 = new JoystickButton(manipulatorStick, 8);
	Button M9 = new JoystickButton(manipulatorStick, 9);
	Button M10 = new JoystickButton(manipulatorStick, 10);
	Button M11 = new JoystickButton(manipulatorStick, 11);
	Button M12 = new JoystickButton(manipulatorStick, 12);
	
	// driveStick
	Button D1 = new JoystickButton(driverStick, 1);
	Button D2 = new JoystickButton(driverStick, 2);
	Button D4 = new JoystickButton(driverStick, 4);
	Button D5 = new JoystickButton(driverStick, 5);
	Button D6 = new JoystickButton(driverStick, 6);
	Button D7 = new JoystickButton(driverStick, 7);
	Button D8 = new JoystickButton(driverStick, 8);
	Button D9 = new JoystickButton(driverStick, 9);
	Button D10 = new JoystickButton(driverStick, 10);
	
	// calibrationStick
	Button C1 = new JoystickButton(calibrationStick, 1);
	Button C2 = new JoystickButton(calibrationStick, 2);
	Button C3 = new JoystickButton(calibrationStick, 3);
	Button C4 = new JoystickButton(calibrationStick, 4);
	Button C6 = new JoystickButton(calibrationStick, 6);
	
	public OI() {
		// manipulatorStick
		M1.whileHeld(new ShooterShoot(false));
		M1.whenReleased(new CollectorMoveToStow());
		M2.whenPressed(new ShooterPrep(false));
		M3.whenPressed(new CollectBall());
		M4.whileHeld(new CollectorJoystickArm());
		M5.whileHeld(new CollectorLowGoal());
		M5.whenReleased(new CollectorMoveToStow());
		M6.whenPressed(new VisionSaveFile());
		M7.whileHeld(new CollectorMoveToLow());
		M7.whenReleased(new CollectorMoveToStow());
		M8.whenPressed(new ShooterStop());
		M9.whileHeld(new ShooterRemoveBall());
		M11.whenPressed(new ShooterPitchUp());
		M12.whenPressed(new ShooterPitchDown());
		
		// driveStick
		D1.whenPressed(new VisionToggleCamera());
		D2.whileHeld(new DriveStraight());
		D4.whenPressed(new EjectBall());
		D5.whileHeld(new DriveEnableBraking(true));
		D5.whenReleased(new DriveEnableBraking(false));
		// D5.whileHeld(new DriveToTarget());
		// D6: Slow Drive
		D6.whenPressed(new SallyDeploy());
		D6.whenReleased(new SallyRetract());
		D7.whenPressed(new DriveShiftDown());
		D8.whenPressed(new DriveShiftUp());
		
		//calibrationStick
		C1.whenPressed(new CalibrationPrev());
		C2.whenPressed(new CalibrationNext());
		C3.whenPressed(new VisionToggleEnabled());
		C4.whenPressed(new VisionToggleProcessedImage());
		C6.whenPressed(new CalibrationSave());
	}

/*
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
*/
	public int getLane() {
		return 1;
	}
	
	public boolean isLowSpeed() {
		return driverStick.getRawButton(6);
	}
	
	public double getCalibrationStickValue(int stickAxis, double min, double max) {
		double stickValue = calibrationStick.getRawAxis(stickAxis);
		
		double x = (stickValue + 1.0)/2.0;
		
		double y = max + ((min - max) * x);
		
		if(y < min) {
			y = min;
		}
		else if(y > max) {
			y = max;
		}
		
		return y;
	}
}

