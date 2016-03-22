package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveUntilStopped extends CommandBase {
	
	double moveSpeed;
	double decelerationThreshold;

    public DriveUntilStopped() {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    	requires(sallyArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();

    	navYawPID.setSetpoint(0.0);
    	navYawPID.enable();
    	
    	moveSpeed = RobotPreferences.autoObstacleDriveSpeed();
    	decelerationThreshold = RobotPreferences.autoDecelerationThreshold();
    	sallyArm.deploy();
    	
    	// May need to be adjusted so command doesn't stop prematurely
    	startTimer(RobotPreferences.autoCommandTimeout());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(moveSpeed, navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ((navigation.getAccel() < -decelerationThreshold) || isTimerExpired());
    }

    // Called once after isFinished returns true
    protected void end() {
    	navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    	sallyArm.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
