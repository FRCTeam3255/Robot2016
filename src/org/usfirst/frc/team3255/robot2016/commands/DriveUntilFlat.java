package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveUntilFlat extends CommandBase {
	
	double distanceFlat;

    public DriveUntilFlat() {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();

    	navYawPID.setSetpoint(0.0);
    	navYawPID.enable();
    	distanceFlat = 0.0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(navigation.getPitch()) > RobotPreferences.autoPitchThreshold()) {
    		drivetrain.resetEncoders();
    	}
    	drivetrain.arcadeDrive(RobotPreferences.autoObstacleDriveSpeed(), navYawPID.getOutput());
    	distanceFlat = drivetrain.getEncoderDistance();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (distanceFlat > RobotPreferences.autoObstacleDistance());
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
