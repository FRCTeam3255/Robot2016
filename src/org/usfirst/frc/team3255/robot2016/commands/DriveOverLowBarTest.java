package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverLowBarTest extends CommandGroup {
    
    public  DriveOverLowBarTest() {
    	addSequential(new CollectorMoveToShoot());
    	addSequential(new DriveOverObstacle());
    }
}
