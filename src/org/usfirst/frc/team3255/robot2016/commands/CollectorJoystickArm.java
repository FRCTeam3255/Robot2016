package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.OI;
import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class CollectorJoystickArm extends CommandBase {

    public CollectorJoystickArm() {
        requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	collector.setArmSpeed(-OI.manipulatorStick.getRawAxis(RobotMap.MANIPULATOR_AXIS_Y));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (collector.getArmSpeed() > 0.0 && collector.getEncoderPosition() < RobotPreferences.collectorLowPosition()) {
        	return true;
        }
        else {
        	return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
    	collector.setArmSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
