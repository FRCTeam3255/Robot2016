package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterShoot extends CommandGroup {
    
    public  ShooterShoot() {
    	//1
    	addParallel(new CollectorFeed());
    	addParallel(new DoDelay(0.3));
    }
}
