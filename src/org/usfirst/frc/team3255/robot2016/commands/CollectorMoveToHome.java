package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CollectorMoveToHome extends CommandBase {

    public CollectorMoveToHome() {
    	requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.setArmSpeed(-0.3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (collector.getCollectorEncoderDistance() < RobotPreferences.CollectorHomePosition()) {
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
