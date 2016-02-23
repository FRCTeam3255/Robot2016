package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class CollectorMoveToLow extends CommandBase {

    public CollectorMoveToLow() {
    	requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.disable();
    	startTimer(RobotPreferences.collectorPIDTimeout());
    	collector.setSetpoint(RobotPreferences.collectorLowPosition());
    	collector.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return collector.onRawTarget() || isTimerExpired();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
