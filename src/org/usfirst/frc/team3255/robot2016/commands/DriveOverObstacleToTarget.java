package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObstacleToTarget extends CommandGroup {
    
	DriveToYaw yawCommand = null;
	
    public  DriveOverObstacleToTarget() {
    	addSequential(new DriveOverObstacle());
    	addSequential(new DriveUntilPitched(false));
    	addSequential(new DriveLaneDistance());
    	
    	// yaw command angle will get updated when this command group initializes
    	yawCommand = new DriveToYaw(0.0);
    	addSequential(yawCommand);
    	
    	addSequential(new DriveUntilStopped());
    }
    
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
}
