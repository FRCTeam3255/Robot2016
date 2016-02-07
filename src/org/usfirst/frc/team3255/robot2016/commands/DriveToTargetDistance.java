package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveToTargetDistance extends CommandBase {

    public DriveToTargetDistance() {
    	requires(drivetrain);
    	requires(visionDistancePID);
    	requires(visionYawPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	visionDistancePID.setSetpoint(RobotPreferences.targetDistance());
    	visionYawPID.setSetpoint(0.0);
    	
    	visionDistancePID.enable();
    	visionYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(visionDistancePID.getOutput(), visionYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (visionDistancePID.onTarget() && visionYawPID.onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	visionDistancePID.disable();
    	visionYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
