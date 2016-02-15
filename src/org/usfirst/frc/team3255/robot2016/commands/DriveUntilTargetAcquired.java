package org.usfirst.frc.team3255.robot2016.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveUntilTargetAcquired extends CommandGroup {

	/*
	 * PseudoCode:
	 * 	DriveStraightDistance based on lane
	 *  Rotate based on lane until target in FOV
	 *  Rotate until target centered
	 *  Drive forward keeping target centered until distance = shooting distance
	 */

	public DriveUntilTargetAcquired() {
		addSequential(new DriveLaneDistance());
		addSequential(new RotateUntilTargetVisible());
    }
}
