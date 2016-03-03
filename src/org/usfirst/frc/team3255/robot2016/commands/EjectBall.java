package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EjectBall extends CommandGroup {
    
    public  EjectBall() {
    	addSequential(new ShooterPrep(true));
    	addSequential(new ShooterShoot(true));
    	addSequential(new CollectorMoveToStow());
    }
}
