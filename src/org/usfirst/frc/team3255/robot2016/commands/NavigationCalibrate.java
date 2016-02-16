package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class NavigationCalibrate extends CommandBase {

    public NavigationCalibrate() {
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // isFinished will return true when the navigation system is not calibrating
    protected boolean isFinished() {
    	return !navigation.isCalibrating();
    }

    // Called once after isFinished returns true
    protected void end() {
    	navigation.resetYaw();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
