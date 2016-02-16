package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class RotateUntilTargetCentered extends CommandBase {

    public RotateUntilTargetCentered() {
    	requires(drivetrain);
    	requires(visionYawPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	visionYawPID.setSetpoint(0.0);
    	visionYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(0.0, visionYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (visionYawPID.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	visionYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
