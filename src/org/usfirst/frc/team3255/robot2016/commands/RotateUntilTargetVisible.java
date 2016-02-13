package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class RotateUntilTargetVisible extends CommandBase {

    public RotateUntilTargetVisible() {
    	requires(drivetrain);
    	requires(vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		double rotateSpeed = RobotPreferences.autoRotateSpeed();
		if(CommandBase.oi.getLane() < 4) {
			rotateSpeed = -rotateSpeed;
		}
		
		drivetrain.arcadeDrive(0.0, rotateSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (vision.isTarget());
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
