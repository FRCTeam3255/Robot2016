package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.DriverStation;

/**
 *
 */
public class DriveToAutoYaw extends CommandBase {
	
	double angle = 0.0;

    public DriveToAutoYaw() {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	DriverStation.reportError("Started Lane Angle", false);
    	getAngle();
    	navYawPID.setSetpoint(angle);
    	
    	drivetrain.shiftLow();
    	
    	navYawPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(0.0, navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (navYawPID.onRawTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    	DriverStation.reportError("Finished Lane Angle", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
    
    protected void getAngle() {
    	int lane = CommandBase.telemetry.getLane();
    	double laneAngle = 0;
		
		switch(lane) {
			case 1:
				laneAngle = RobotPreferences.angleOuterLane();
				break;
			case 5:
				laneAngle = -RobotPreferences.angleOuterLane();
				break;
			case 2:
				laneAngle = RobotPreferences.angleInnerLane();
				break;
			case 4:
				laneAngle = -RobotPreferences.angleInnerLane();
				break;
			case 3:
				laneAngle = RobotPreferences.angleCenterLane();
				break;
		}
		
		angle = laneAngle;
    }
}
