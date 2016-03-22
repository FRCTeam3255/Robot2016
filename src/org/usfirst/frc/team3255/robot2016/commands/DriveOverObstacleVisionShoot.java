package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObstacleVisionShoot extends CommandGroup {
    
    public  DriveOverObstacleVisionShoot() {
    	addSequential(new DriveOverObstacleToVisionTarget());
    	addSequential(new ShooterPrep(false));
    	addSequential(new ShooterShoot(false));
    }
}
