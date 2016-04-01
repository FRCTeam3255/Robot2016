package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class DriveUntilPitched extends CommandBase {
	
	boolean driveForward = true;
	
	double moveSpeed;
	double pitchThreshold;

    public DriveUntilPitched(boolean isForward) {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    	
    	driveForward = isForward;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();

    	navYawPID.setSetpoint(0.0);
    	navYawPID.enable();
    	
    	moveSpeed = RobotPreferences.autoObstacleDriveSpeed();
    	pitchThreshold = RobotPreferences.autoPitchThreshold();
    	
    	if (!driveForward) {
    		moveSpeed = -moveSpeed;
    	}
    	
    	startTimer(RobotPreferences.autoPitchedTimeout());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(moveSpeed, navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ((Math.abs(navigation.getPitch()) > pitchThreshold) || isTimerExpired());
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
