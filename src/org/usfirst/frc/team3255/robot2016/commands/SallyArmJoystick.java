package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.OI;
import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class SallyArmJoystick extends CommandBase {

    public SallyArmJoystick() {
        requires(sallyArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double speed = OI.manipulatorStick.getRawAxis(RobotMap.MANIPULATOR_AXIS_Y);
    	
    	sallyArm.setSpeed(speed * RobotPreferences.sallyArmSensitivity());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	sallyArm.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
