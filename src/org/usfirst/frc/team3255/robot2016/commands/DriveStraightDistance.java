package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class DriveStraightDistance extends CommandBase {

    public DriveStraightDistance(double d) {
    	requires(drivetrain);
    	requires(driveDistancePID);
    	requires(navYawPID);
    	
    	driveDistancePID.setSetpoint(d);
    	navYawPID.setSetpoint(0.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveDistancePID.enable();
    	navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(driveDistancePID.getOutput(), navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (driveDistancePID.onTarget() && navYawPID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveDistancePID.disable();
    	navYawPID.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
