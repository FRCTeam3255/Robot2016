package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class ShooterShoot extends CommandBase {
    
    public  ShooterShoot() {
    	requires(collector);
    	requires(shooter);
    	requires(lighting);
    }

	protected void initialize() {
		collector.setIntakeSpeed(RobotPreferences.collectorIntakeSpeed());
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		// command never finishes, but gets interrupted when button released
		return false;
	}

	protected void end() {
		collector.setIntakeSpeed(0.0);
		shooter.set(0.0);
		lighting.redOn(false);
	}

	protected void interrupted() {
		end();
	}
}
