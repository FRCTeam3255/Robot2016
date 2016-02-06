package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionMovePID extends PIDSubsystem {
	
	double output = 0.0;
	boolean outputValid = false;

    // Initialize your subsystem here
    public VisionMovePID() {
        super(0, 0, 0);
        updatePIDValues();
    }
    
    public void updatePIDValues() {
    	this.getPIDController().setPID(
    			RobotPreferences.visionMoveP(),
    			RobotPreferences.visionMoveI(),
    			RobotPreferences.visionMoveD());
    	
    	double maxSpeed = RobotPreferences.maxMoveSpeed();
    	this.setOutputRange(-maxSpeed, maxSpeed);
    	
        this.setSetpoint(RobotPreferences.maxMoveSpeed());
    }
    
    public double returnPIDInput() {
    	// TODO Change isTote to isTarget
    	if(CommandBase.vision.isTote() == false) {
    		outputValid = false;
    		return this.getSetpoint();
    	}
    	outputValid = true;
    	// TODO Change getToteDistance to getTargetDistance
    	return CommandBase.vision.getToteDistance();
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
