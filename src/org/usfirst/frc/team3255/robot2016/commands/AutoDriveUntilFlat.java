package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class AutoDriveUntilFlat extends CommandBase {
	
	double distanceFlat;

    public AutoDriveUntilFlat() {
    	requires(drivetrain);
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    	distanceFlat = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(navigation.getPitch()) > RobotPreferences.autoFlatThreshold()) {
    		drivetrain.resetEncoders();
    	}
    	drivetrain.straightDrive();
    	distanceFlat = drivetrain.getEncoderDistance();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if (distanceFlat > RobotPreferences.autoFlatDistance()) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
