package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObstacleToTarget extends CommandGroup {
    
    public  DriveOverObstacleToTarget() {
    	addSequential(new DriveOverObstacle());
    	addSequential(new DriveUntilTargetAcquired());
    	addSequential(new DriveToTarget());
    }
}
