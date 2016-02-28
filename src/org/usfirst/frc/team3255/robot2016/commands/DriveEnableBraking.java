package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class DriveEnableBraking extends CommandBase {
	
	private boolean brakingOn = false;

    public DriveEnableBraking(boolean on) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(drivetrain);
    	brakingOn = on;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.setBraking(brakingOn);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
