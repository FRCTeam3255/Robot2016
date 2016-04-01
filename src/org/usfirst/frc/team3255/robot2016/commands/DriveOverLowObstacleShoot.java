package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverLowObstacleShoot extends CommandGroup {
    
    public  DriveOverLowObstacleShoot() {
    	addSequential(new CollectorMoveToLow());
    	addSequential(new DriveOverObstacleToTarget());
    	addSequential(new ShooterPrep(false)); // Adjust spin up delay
    	addSequential(new ShooterShoot(false));
    	addSequential(new DoDelay(1.0));
    	addSequential(new ShooterStop());
    }
}
