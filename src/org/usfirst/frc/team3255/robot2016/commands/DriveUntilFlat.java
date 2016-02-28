package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveUntilFlat extends CommandBase {
	
	double distanceFlat;
	double targetDistance;
	double pitchThreshold;
	double moveSpeed;
	
	boolean driveForward = true;

    public DriveUntilFlat(boolean isForward) {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    	
    	driveForward = isForward;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	drivetrain.resetEncoders();

    	navYawPID.setSetpoint(0.0);
    	navYawPID.enable();
    	
    	distanceFlat = 0.0;
    	targetDistance = RobotPreferences.autoObstacleDistance();
    	pitchThreshold = RobotPreferences.autoFlatThreshold();
    	moveSpeed = RobotPreferences.autoObstacleDriveSpeed();
    	
    	if (!driveForward) {
    		moveSpeed = -moveSpeed;
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(moveSpeed, navYawPID.getOutput());
    	
    	if (Math.abs(navigation.getPitch()) > pitchThreshold) {
    		drivetrain.resetEncoders();
    		distanceFlat = 0.0;
    	}
    	else {
    		distanceFlat = drivetrain.getEncoderDistance();
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(distanceFlat) > targetDistance);
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
