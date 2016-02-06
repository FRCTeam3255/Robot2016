package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class AutoInitialFlat extends CommandBase {

    public AutoInitialFlat() {
    	requires(drivetrain);
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.visionDrive();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (navigation.getPitch() < RobotPreferences.autoOnRampConstant()) {
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
