package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverLowBar extends CommandGroup {
    
    public  DriveOverLowBar() {
    	addSequential(new CollectorMoveToLow());
    	addSequential(new DriveUntilPitched());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveUntilFlat());
    	addSequential(new CollectorMoveToStow());
    }
}
