package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverObsatcleAndBack extends CommandGroup {
    
    public  DriveOverObsatcleAndBack() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new DriveOverObstacle());
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveUntilPitched(false));
    	addSequential(new DoDelay(0.1));
    	addSequential(new DriveUntilFlat(false));
    	addSequential(new DriveToYaw(0.0));
    }
}
