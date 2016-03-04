package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterRemoveBall extends CommandGroup {
    
    public  ShooterRemoveBall() {
    	addSequential(new CollectorMoveToShoot());
    	addSequential(new ShooterSetSpeed());
    }
}
