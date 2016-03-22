package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class DriveStraight extends CommandBase {

    public DriveStraight() {
    	requires(drivetrain);
    	requires(navYawPID);
    	requires(navigation);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drivetrain.shiftLow();
    	drivetrain.resetEncoders();
    	navigation.resetYaw();
    	
    	navYawPID.disable();
    	
    	navYawPID.setSetpoint(0.0);

    	navYawPID.enable();
    	sallyArm.deploy();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.arcadeDrive(RobotPreferences.autoObstacleDriveSpeed(), navYawPID.getOutput());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	// driveDistancePID.disable();
    	// navYawPID.disable();
    	
    	drivetrain.setSpeed(0.0);
    	sallyArm.retract();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	navYawPID.disable();
    	
    	end();
    }
}
