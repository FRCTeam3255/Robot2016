package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveSallyDistance3 extends CommandBase {
	
    public DriveSallyDistance3() {
    	requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.resetEncoders();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (Math.abs(RobotPreferences.driveSallyDistance3() - drivetrain.getEncoderDistance()) < 0.1);
    }

    // Called once after isFinished returns true
    protected void end() {
    	drivetrain.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
