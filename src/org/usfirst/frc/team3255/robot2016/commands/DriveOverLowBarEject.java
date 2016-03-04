package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverLowBarEject extends CommandGroup {
    
    public  DriveOverLowBarEject() {
    	addSequential(new CollectorMoveToLow());
        addSequential(new DriveOverObstacle());
        addSequential(new EjectBall());
    }
}
