package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CollectorPickUp extends CommandGroup {
    
    public  CollectorPickUp() {
    	addSequential(new CollectorResetEncoders());
    	addSequential(new CollectorMoveToPickup());
    	addSequential(new CollectorWaitForBall());
    	addSequential(new CollectorMoveToHome());
    }
}
