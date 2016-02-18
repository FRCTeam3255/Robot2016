package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class SallyDrawbridge extends CommandGroup {
    
    public  SallyDrawbridge() {
    	addSequential(new DriveResetEncoders());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveSallyDistance());
    	addSequential(new DoDelay(1.0));
    	addSequential(new SallyRetract());
    	addSequential(new DriveResetEncoders());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveSallyDistance2());
    	addSequential(new DoDelay(1.0));
    	addParallel(new SallyMoveToDrawbridge());
    	addParallel(new DriveSallyDistance3());
    	addParallel(new DoDelay(3.0));
    	addSequential(new CollectorMoveToLow());
    }
}
