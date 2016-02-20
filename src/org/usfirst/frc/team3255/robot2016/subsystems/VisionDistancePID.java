package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionDistancePID extends PIDSubsystem {
	
	double inputValue = 0.0;
	boolean inputValid = false;
	double outputValue = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public VisionDistancePID() {
        super(0, 0, 0);
        // TODO Do we need to call enable() here?
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionDistanceP(),
    			RobotPreferences.visionDistanceI(),
    			RobotPreferences.visionDistanceD());
    	
        this.setSetpoint(RobotPreferences.targetDistance());
    	
    	double maxSpeed = RobotPreferences.maxMoveSpeed();
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

    	inputValue = CommandBase.vision.getTargetDistance();
    	inputValid = true;
    	
    	return inputValue;
    }
    
    
    protected void usePIDOutput(double output) {
    	this.outputValue = output;
    	outputValid = true;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || inputValid == false || outputValid == false) {
    		return 0.0;
    	}
    	return outputValue;
    }
    
	public boolean onRawTarget() {
		if (inputValid == false) {
			return false;
		}
		
		return (Math.abs(inputValue - getPIDController().getSetpoint()) < RobotPreferences.targetDistanceThreshold());
	}
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
