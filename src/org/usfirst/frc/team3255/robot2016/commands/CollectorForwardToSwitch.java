package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class CollectorForwardToSwitch extends CommandBase {

	boolean sawSwitch = false;
	
    public CollectorForwardToSwitch() {
    	requires(collector);
    	requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.setIntakeSpeed(RobotPreferences.collectorIntakeSpeed());
    	sawSwitch = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((sawSwitch == false) && (shooter.isBallHoldSwitchClosed())) {
    		sawSwitch = true;
    		this.setTimeout(RobotPreferences.collectorTimeout());
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if((sawSwitch) && isTimedOut()) {
    		return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	collector.disable();
    	collector.setIntakeSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
