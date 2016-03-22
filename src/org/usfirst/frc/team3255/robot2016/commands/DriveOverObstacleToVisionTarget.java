package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObstacleToVisionTarget extends CommandGroup {
    
    public  DriveOverObstacleToVisionTarget() {
    	addSequential(new DriveOverObstacle());
    	addSequential(new DriveUntilTargetAcquired());
    	addSequential(new DriveToTarget());
    }
}
