package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class ShooterShoot extends CommandBase {
	
	boolean eject = false;
    
    public  ShooterShoot(boolean ejectShot) {
    	requires(shooter);
    }

	protected void initialize() {
		collector.setIntakeSpeed(RobotPreferences.collectorShootSpeed());
		shooter.set((RobotPreferences.shooterVoltage()));
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		collector.setIntakeSpeed(0.0);
		shooter.set(0.0);
	}

	protected void interrupted() {
		end();
	}
}
