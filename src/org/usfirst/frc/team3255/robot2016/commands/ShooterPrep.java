package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterPrep extends CommandGroup {
    
    public  ShooterPrep() {
    	addSequential(new CollectorReverseToSwitch());
    	// addSequential(new CollectorMoveToPickup());
    	addSequential(new ShooterSpinUp());
    }
}
