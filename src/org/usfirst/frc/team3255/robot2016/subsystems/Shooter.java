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
public class Shooter extends Subsystem {
 
	Talon leftTalon = null;
	Talon rightTalon = null;
	
	DigitalInput shootSwitch = null;
	
	Encoder shooterEncoder = null;
	
    public Shooter() {
		super();
		
		init();
	}

	public Shooter(String name) {
		super(name);
		
		init();
	}

	public void init() {
		// Talons
		leftTalon = new Talon(RobotMap.SHOOTER_LEFT_TALON);
		rightTalon = new Talon(RobotMap.SHOOTER_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);

		//Limit Switches
		shootSwitch = new DigitalInput(RobotMap.SHOOTER_SHOOT_SWITCH);
		
		//Encoders
		shooterEncoder = new Encoder(RobotMap.SHOOTER_ENCODER_CHA,RobotMap.SHOOTER_ENCODER_CHB);
	}
	
	public void setSpeed(double s){
		leftTalon.set(s);
		rightTalon.set(-s);
	}
	
	// Limit Switches
	
	public boolean isShootSwitchClosed() {
		return (shootSwitch.get() == false);
	}
	
	public void updateEncoderRatio() {
		// TODO Set constants for encoder distance
		shooterEncoder.setDistancePerPulse(1.0 / RobotPreferences.getShooterPulsePerRotation());
	}
	
	public void resetEncoders() {
		shooterEncoder.reset();
	}
		
	public double getShooterEncoderCount(){
		return shooterEncoder.get();
	}
	
	public double getShooterEncoderDistance(){
		return shooterEncoder.getDistance();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

