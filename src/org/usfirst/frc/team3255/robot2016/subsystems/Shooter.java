package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

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
	
	DigitalInput ballHoldSwitch = null;
	
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

		setVoltageMode();

		// Limit Switches
		ballHoldSwitch = new DigitalInput(RobotMap.SHOOTER_BALL_HOLD_SWITCH);
		
		// Solenoid
		pitchSolenoid = new DoubleSolenoid(RobotMap.SHOOTER_PITCH_SOLENOID_DEPLOY, RobotMap.SHOOTER_PITCH_SOLENOID_RETRACT);
	}
	
	private void setVoltageMode() {
		leftTalon.changeControlMode(TalonControlMode.Voltage);
		rightTalon.changeControlMode(TalonControlMode.Voltage);
		
		double rampRate = RobotPreferences.shooterVoltageRamp();
		leftTalon.setVoltageCompensationRampRate(rampRate);
		rightTalon.setVoltageCompensationRampRate(rampRate);
	}
	
	// Talons
	public void set(double s){
		leftTalon.set(s);
		rightTalon.set(-s);
	}
	
	// Limit Switches
	public boolean isBallHoldSwitchClosed() {
		return (ballHoldSwitch.get() == false);
	}
	
	public void pitchUp() {
		pitchSolenoid.set(Value.kForward);
	}
	
	public void pitchDown() {
		pitchSolenoid.set(Value.kReverse);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

