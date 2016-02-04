package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
 
	CANTalon leftTalon = null;
	CANTalon rightTalon = null;
	
	DigitalInput inputSwitch = null;
	DigitalInput outputSwitch = null;
	
	DoubleSolenoid pitchSolenoid = null;
	
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
		leftTalon = new CANTalon(RobotMap.SHOOTER_LEFT_TALON);
		rightTalon = new CANTalon(RobotMap.SHOOTER_RIGHT_TALON);
		
		leftTalon.setSafetyEnabled(false);
		rightTalon.setSafetyEnabled(false);

		// Limit Switches
		inputSwitch = new DigitalInput(RobotMap.SHOOTER_INPUT_SWITCH);
		outputSwitch = new DigitalInput(RobotMap.SHOOTER_OUTPUT_SWITCH);
		
		// Solenoid
		pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_CHA, RobotMap.SHOOTER_PITCH_SOLENOID_CHB);
	}
	
	// Talons
	public void set(double s){
		leftTalon.set(s);
		rightTalon.set(-s);
	}
	
	// Limit Switches
	public boolean isInputSwitchClosed() {
		return (inputSwitch.get() == false);
	}
	
	public boolean isOutputSwitchClosed() {
		return (outputSwitch.get() == false);
	}
	
	// Encoders
	public void updateEncoderRatio() {
		// pitchEncoder.setDistancePerPulse(1.0 / RobotPreferences.getShooterPulsePerRotation());
	}
	
	public void resetEncoders() {
		// pitchEncoder.reset();
	}
	
	// TODO Do we need this?
	public double getShooterEncoderCount(){
		return 0.0;
	}
	
	public double getShooterEncoderDistance(){
		return leftTalon.getEncPosition();
	}
	
	public void pitchUp() {
		pitchSolenoid.set(Value.kForward);
	}
	
	public void pitchDown() {
		pitchSolenoid.set(Value.kReverse);
	}
	
	public void setControlMode(TalonControlMode mode) {
		leftTalon.changeControlMode(mode);
		rightTalon.changeControlMode(mode);
	}
	
	public void setTalonVoltageRamp(double v) {
		// 0V to 12V in 500ms with value of 24.0
		leftTalon.setVoltageCompensationRampRate(v);
		rightTalon.setVoltageCompensationRampRate(v);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

