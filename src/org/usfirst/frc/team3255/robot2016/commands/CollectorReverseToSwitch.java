package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class CollectorReverseToSwitch extends CommandBase {
	
    public CollectorReverseToSwitch() {
    	requires(collector);
    	requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.setIntakeSpeed(-RobotPreferences.collectorIntakeSpeed());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return shooter.isBallHoldSwitchClosed();

    }

    // Called once after isFinished returns true
    protected void end() {
    	collector.setIntakeSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
