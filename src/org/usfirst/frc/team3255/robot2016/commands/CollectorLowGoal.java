package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorLowGoal extends CommandGroup {
    
    public  CollectorLowGoal() {
    	addSequential(new CollectorMoveToPickup());
    	addSequential(new CollectorReverse());
    }
}
