package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorPrepShooter extends CommandGroup {
    
    public  CollectorPrepShooter() {
    	addSequential(new CollectorMoveToPickup());
    	// This command doesn't stop the motors!
    	addSequential(new CollectorPickUpBall());
    	addSequential(new DoDelay(0.1));
    	addSequential(new CollectorStowBall());
    	addSequential(new CollectorMoveToStow());
    }
}
