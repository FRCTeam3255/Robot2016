package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class DriveLaneFlatDistance extends CommandBase {

	double pitchThreshold;
	
    public DriveLaneFlatDistance() {
    	requires(drivetrain);
    	requires(driveDistancePID);
    	requires(navYawPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	
    	drivetrain.resetEncoders();
    	
    	double laneDistance = getLaneDistance();
    	pitchThreshold = RobotPreferences.autoFlatThreshold();

    	DriverStation.reportError("Started Lane Distance = " + laneDistance + " threshold = " + pitchThreshold, false);
    	
    	driveDistancePID.setSetpoint(laneDistance);
    	navYawPID.setSetpoint(0.0);
    	
    	driveDistancePID.enable();
    	navYawPID.enable();
    	startTimer(RobotPreferences.laneDistanceTimeout());
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Math.abs(navigation.getPitch()) > pitchThreshold) {
    		drivetrain.resetEncoders();
    	}
    	drivetrain.arcadeDrive(driveDistancePID.getOutput(), navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	boolean expired = isTimerExpired();
    	
    	if(expired) {
    		DriverStation.reportError("Drive Lane Flat Distance: timer expired", false);
    	}
    	
    	boolean distanceReached = driveDistancePID.onRawTarget();
    	if(distanceReached) {
    		DriverStation.reportError("Drive Lane Flat Distance: distance reached = " + drivetrain.getEncoderDistance(), false);
    	}
    	
    	boolean yawReached = navYawPID.onRawTarget();
    	if(yawReached) {
    		// DriverStation.reportError("Drive Lane Flat Distance: yaw reached = " + navigation.getYaw(), false);
    	}
    	
    	return ((distanceReached && yawReached) || expired);
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveDistancePID.disable();
    	navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    	DriverStation.reportError("Finished Lane Distance", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double getLaneDistance() {
    	int lane = CommandBase.telemetry.getLane();
		
		switch(lane) {
			case 1:
			case 5:
				return RobotPreferences.distanceOuterLane();
			case 2:
			case 4:
				return RobotPreferences.distanceInnerLane();
			case 3:
				return RobotPreferences.distanceCenterLane();
		}
		return 0.0;
    }
}
