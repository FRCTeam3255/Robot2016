package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionDistancePID extends PIDSubsystem {
	
	double output = 0.0;
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
    	
    	this.setAbsoluteTolerance(RobotPreferences.distanceTolerance());
    	
        this.setSetpoint(RobotPreferences.targetDistance());
    	
    	double maxSpeed = RobotPreferences.maxMoveSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	   
        super.enable();
    }
    
    public double returnPIDInput() {
    	// TODO Change isTote to isTarget
    	if(CommandBase.vision.isTarget() == false) {
    		outputValid = false;
    		return this.getSetpoint();
    	}
    	outputValid = true;
    	// TODO Change getToteDistance to getTargetDistance
    	return CommandBase.vision.getTargetDistance();
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
