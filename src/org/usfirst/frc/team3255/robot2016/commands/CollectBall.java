package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectBall extends CommandGroup {
    
    public  CollectBall() {
    	// addSequential(new ShooterPitchUp());
    	addParallel(new CollectorMoveToPickup());
    	addSequential(new CollectorForwardToSwitch());
    	// addSequential(new ShooterPitchDown());
    	addSequential(new CollectorMoveToStow());
    }
}
