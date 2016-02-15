package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class DriveToYaw extends CommandBase {

    public DriveToYaw(double a) {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    	
    	navYawPID.setSetpoint(a);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	
    	navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(0.0, navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (navYawPID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
