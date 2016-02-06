package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionRotatePID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public VisionRotatePID() {
        super(0, 0, 0);
        updatePIDValues();
        this.setSetpoint(0.0);
    }
    
    public void updatePIDValues() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionRotateP(),
    			RobotPreferences.visionRotateI(),
    			RobotPreferences.visionRotateD());
    	
    	double maxSpeed = RobotPreferences.maxYawCorrectSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    }
    
    public double returnPIDInput() {
    	// TODO Change isTote to isTarget
    	if(CommandBase.vision.isTote() == false) {
    		outputValid = false;
    		return this.getSetpoint();
    	}
    	outputValid = true;
    	// TODO Change getToteCenterX to getTargetCenterX
    	return CommandBase.vision.getToteCenterX();
    }
    
    
    protected void usePIDOutput(double output) {
    	this.output = output;
    }
    
    public double getOutput() {
    	if(this.getPIDController().isEnabled() == false || outputValid == false) {
    		return 0.0;
    	}
    	return output;
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
