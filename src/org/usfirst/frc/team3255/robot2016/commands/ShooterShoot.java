package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterShoot extends CommandGroup {
    
    public  ShooterShoot() {
    	addSequential(new ShooterResetEncoders());
    	addSequential(new ShooterSpinUp());
    	//TODO Add stop for shooter
    }
}
