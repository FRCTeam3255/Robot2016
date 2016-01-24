package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	Talon intakeTalon = null;
	Talon armTalon = null;
	
	DigitalInput intakeSwitch = null;

	Encoder collectorEncoder = null;
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void init(){
		intakeTalon = new Talon(RobotMap.COLLECTOR_INTAKE_TALON);
		armTalon = new Talon(RobotMap.COLLECTOR_ARM_TALON);
		
		intakeTalon.setSafetyEnabled(false);
		armTalon.setSafetyEnabled(false);
		
		intakeSwitch = new DigitalInput(RobotMap.COLLECTOR_INTAKE_SWITCH);
		
		collectorEncoder = new Encoder(RobotMap.COLLECTOR_ENCODER_CHA, RobotMap.COLLECTOR_ENCODER_CHB);
	}
	
	// Talons
	
	public void setIntakeSpeed(double s){
		intakeTalon.set(s);
	}
	public void setArmSpeed (double s){
		armTalon.set(s);
	}
	
	// Limit Switches
	public boolean isIntakeSwitchClosed(){
		return (intakeSwitch.get() == false);
	}
	
	// Encoders
	
	public void updateEncoderRatio() {
		// TODO Set constants for encoder distance
		collectorEncoder.setDistancePerPulse(1.0 / RobotPreferences.getCollectorPulsePerRotation());
	}
	
	public void resetEncoders() {
			collectorEncoder.reset();
	}
	
	public double getCollectorEncoderCount(){
		return collectorEncoder.get();
	}
	
	public double getCollectorEncoderDistance(){
		return collectorEncoder.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

