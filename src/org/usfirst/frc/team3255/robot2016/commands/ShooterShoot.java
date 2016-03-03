package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class ShooterShoot extends CommandBase {
	
	boolean eject = false;
    
    public  ShooterShoot(boolean ejectShot) {
    	requires(collector);
    	requires(shooter);
    	requires(lighting);
    	eject = ejectShot;
    }

	protected void initialize() {
		if (eject) {
			this.startTimer(1.0);
		}
		else {
			vision.saveFrame();
		}
		collector.setIntakeSpeed(RobotPreferences.collectorIntakeSpeed());
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		if (!eject) {
			return false;
		}
		return this.isTimerExpired();
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
