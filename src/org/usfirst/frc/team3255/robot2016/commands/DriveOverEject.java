package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveOverEject extends CommandGroup {
    
    public  DriveOverEject() {
        addSequential(new DriveOverObstacle());
        addSequential(new EjectBall());
    }
}
