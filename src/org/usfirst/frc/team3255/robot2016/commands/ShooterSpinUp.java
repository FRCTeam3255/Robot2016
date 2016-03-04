package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class ShooterSpinUp extends CommandBase {

	boolean eject = false;
	
    public ShooterSpinUp(boolean ejectShot) {
    	requires(shooter);
    	eject = ejectShot;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (!eject) {
        	shooter.set(RobotPreferences.shooterSpikeVoltage());
        	this.startTimer(RobotPreferences.shooterSpinUpDelay());
    	}
    	else {
    		shooter.set(RobotPreferences.ejectVoltage());
    		this.startTimer(RobotPreferences.shooterEjectDelay());
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return this.isTimerExpired();
    }

    // Called once after isFinished returns true
    protected void end() {
    	if (!eject) {
    		shooter.set(RobotPreferences.shooterVoltage());
    	}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	shooter.set(0.0);
    }
}
