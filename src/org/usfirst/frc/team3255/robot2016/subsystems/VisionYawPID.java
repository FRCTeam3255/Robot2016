package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionYawPID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public VisionYawPID() {
        super(0, 0, 0);
    }
    
    public void enable() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionYawP(),
    			RobotPreferences.visionYawI(),
    			RobotPreferences.visionYawD());
    	
    	this.setAbsoluteTolerance(RobotPreferences.yawTolerance());
    	
        this.setSetpoint(0.0);
    	
    	double maxSpeed = RobotPreferences.maxYawSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
    	super.enable();
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
