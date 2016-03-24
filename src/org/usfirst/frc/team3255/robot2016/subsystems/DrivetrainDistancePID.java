package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class DrivetrainDistancePID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public DrivetrainDistancePID() {
        super(0, 0, 0);
        this.setSetpoint(0.0);
        // TODO Do we need to call enable() here?
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.driveDistanceP(),
    			RobotPreferences.driveDistanceI(),
    			RobotPreferences.driveDistanceD());
    	
    	setAbsoluteTolerance(RobotPreferences.distanceTolerance());
    	
    	double maxSpeed = RobotPreferences.maxMoveSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	outputValid = false;
    	
    	super.enable();
    }
    
    public double returnPIDInput() {
    	return CommandBase.drivetrain.getEncoderDistance();
    }

    protected void usePIDOutput(double output) {
    	this.output = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    
	public boolean onRawTarget() {
		if (Math.abs(CommandBase.drivetrain.getEncoderDistance() - getPIDController().getSetpoint()) < RobotPreferences.distanceTolerance()) {
			return true;
		}
		else {
			return false;
		}
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
