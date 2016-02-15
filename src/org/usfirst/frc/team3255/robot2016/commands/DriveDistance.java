package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveDistance extends CommandBase {

	
    public DriveDistance() {
    	requires(drivetrain);
    	requires(driveDistancePID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	drivetrain.resetEncoders();
    	
    	driveDistancePID.setSetpoint(RobotPreferences.driveDistance());
    	driveDistancePID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(driveDistancePID.getOutput(), 0.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (driveDistancePID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveDistancePID.disable();
    	
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
