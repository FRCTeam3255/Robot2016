package org.usfirst.frc.team3255.robot2016.commands;

/**
 *
 */
public class CollectorStop extends CommandBase {

    public CollectorStop() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(collector);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	collector.setIntakeSpeed(0.0);
    	collector.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
