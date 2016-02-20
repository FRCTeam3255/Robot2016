package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverLowBar extends CommandGroup {
    
    public  DriveOverLowBar() {
    	addSequential(new CollectorMoveToLow());
    	addSequential(new DriveOverLowBar());
    	addSequential(new CollectorMoveToStow());
    }
}
