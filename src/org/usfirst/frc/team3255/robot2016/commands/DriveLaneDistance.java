package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveLaneDistance extends CommandBase {

    public DriveLaneDistance() {
    	requires(drivetrain);
    	requires(driveDistancePID);
    	requires(navYawPID);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	drivetrain.resetEncoders();
    	
    	driveDistancePID.setSetpoint(getLaneDistance());
    	navYawPID.setSetpoint(0.0);
    	
    	driveDistancePID.enable();
    	navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(driveDistancePID.getOutput(), navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (driveDistancePID.onRawTarget() && navYawPID.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	driveDistancePID.disable();
    	navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    private double getLaneDistance() {
    	int lane = CommandBase.oi.getLane();
		
		switch(lane) {
			case 1:
				return RobotPreferences.distanceLane1();
			case 2:
				return RobotPreferences.distanceLane2();
			case 3:
				return RobotPreferences.distanceLane3();
			case 4:
				return RobotPreferences.distanceLane4();
			case 5:
				return RobotPreferences.distanceLane5();
		}
		return 0.0;
    }
}
