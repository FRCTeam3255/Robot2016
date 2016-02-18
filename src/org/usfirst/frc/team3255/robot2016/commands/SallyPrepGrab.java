package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class SallyPrepGrab extends CommandBase {

    public SallyPrepGrab() {
    	requires(sallyArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	sallyArm.setSetpoint(RobotPreferences.sallyGrabPosition());
    	sallyArm.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return sallyArm.onRawTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	sallyArm.disable();
    	sallyArm.deploy();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
