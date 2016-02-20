package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class CollectorReverse extends CommandBase {

    public CollectorReverse() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.setIntakeSpeed(-1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	collector.setIntakeSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
