package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObstacleToTarget extends CommandGroup {
    
	DriveToYaw yawCommand = null;
	
    public  DriveOverObstacleToTarget() {
    	// Drive over Obstacle
    	addSequential(new NavigationCalibrate());
    	addSequential(new DriveEnableBraking(true));
    	addSequential(new DoDelay(0.5));
    	addSequential(new DriveUntilPitched(true));
    	addSequential(new DriveResetEncoders());
    	
    	addSequential(new DriveLaneFlatDistance());
    	
    	// yaw command angle will get updated when this command group initializes
    	// yawCommand = new DriveToYaw(0.0);
    	// addSequential(yawCommand);
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveToAutoYaw());
    	addSequential(new NavigationZeroYaw());
    	addSequential(new DoDelay(0.3));
    	addSequential(new DriveUntilStopped());
    	addSequential(new DriveEnableBraking(false));
    }
    
    /*
    protected void initialize() {
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
		
		yawCommand.setAngle(laneAngle);
    }
    */
}
