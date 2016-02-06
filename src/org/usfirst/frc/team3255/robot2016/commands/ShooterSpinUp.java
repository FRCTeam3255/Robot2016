package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

/**
 *
 */
public class ShooterSpinUp extends CommandBase {
//2
    public ShooterSpinUp() {
    	requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	shooter.setControlMode(TalonControlMode.Voltage);
    	shooter.setTalonVoltageRamp(RobotPreferences.shooterVoltageRamp());
    	shooter.set(RobotPreferences.shooterVoltage());
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
