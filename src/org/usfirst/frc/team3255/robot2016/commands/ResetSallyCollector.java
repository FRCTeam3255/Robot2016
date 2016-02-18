package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ResetSallyCollector extends CommandGroup {
    
    public  ResetSallyCollector() {
    	addSequential(new SallyRetract());
    	addParallel(new CollectorMoveToStow());
    	addParallel(new SallyMoveToStow());
    }
}
