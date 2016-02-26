package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionYawPID extends PIDSubsystem {
	
	double inputValue = 0;
	boolean inputValid = false;
	double outputValue = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public VisionYawPID() {
        super(0, 0, 0);
        // TODO Do we need to call enable() here?
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionYawP(),
    			RobotPreferences.visionYawI(),
    			RobotPreferences.visionYawD());
    	
        this.setSetpoint(0.0);
    	
    	double maxSpeed = RobotPreferences.maxYawSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	inputValid = false;
    	outputValid = false;
    	
    	super.enable();
    }
    
    public double returnPIDInput() {
    	// TODO Change isTote to isTarget
    	if(CommandBase.vision.isTarget() == false) {
    		inputValid = false;
    		return this.getSetpoint();
    	}

    	inputValue = CommandBase.vision.getTargetCenterX();
    	inputValid = true;
    	
    	return inputValue;
    }
    
    
    protected void usePIDOutput(double output) {
    	this.outputValue = -output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || inputValid == false || outputValid == false) {
    		return 0.0;
    	}
    	return outputValue;
    }
    
	public boolean onRawTarget() {
		if(inputValid == false) {
			return false;
		}

		// return (abs(input-setpoint) < threshold)
		return (Math.abs(inputValue - getPIDController().getSetpoint()) < RobotPreferences.targetXThreshold());
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
