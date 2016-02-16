package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class SallyArm extends PIDSubsystem {
    
	// Talons
	CANTalon armTalon = null;
    
	// Solenoids
    DoubleSolenoid armSolenoid = null;
    
    // Limit Switches
    DigitalInput sallyStowSwitch = null;
    
    boolean deployed = false;
    
    public SallyArm() {
		super(0, 0, 0);
		
		init();
	}

	public SallyArm(String name) {
		super(name, 0, 0, 0);
		
		init();
	}
    
    public void init() {
    	// Talons
    	armTalon = new CANTalon(RobotMap.SALLYARM_TALON);
    	
    	armTalon.setSafetyEnabled(false);
    	
    	armTalon.enableBrakeMode(true);
    	
    	// Solenoids
    	armSolenoid = new DoubleSolenoid(RobotMap.SALLYARM_SOLENOID_DEPLOY, 
    			RobotMap.SALLYARM_SOLENOID_RETRACT);
    	
    	// Limit Switches
    	sallyStowSwitch = new DigitalInput(RobotMap.SALLY_STOW_SWITCH);
    }
    
    public void enable() {
		getPIDController().setPID(RobotPreferences.sallyP(),
				RobotPreferences.sallyI(),
				RobotPreferences.sallyD());
		this.setAbsoluteTolerance(RobotPreferences.sallyTolerance());
		double maxSpeed = RobotPreferences.maxSallySpeed();
		this.setOutputRange(-maxSpeed, maxSpeed);
		super.enable();
	}
    
 // ================== PID ==================
    @Override
	protected double returnPIDInput() {
		return getEncoderPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		setSpeed(output);
	}
	
	public boolean onRawTarget() {
		if (Math.abs(getEncoderPosition() - getPIDController().getSetpoint()) < RobotPreferences.sallyTolerance()) {
			return true;
		}
		else {
			return false;
		}
	}
    
    // ================== Talons ==================
    public void setSpeed(double s) {
    	if (s < 0 && isSallyStowed()) {
    		s = 0.0;
    	}
    	armTalon.set(s);
	}
    
    public double getEncoderPosition() {
    	return armTalon.getEncPosition() * RobotPreferences.sallyEncoderCompression();
    }
    
    public void resetEncoders() {
    	armTalon.setEncPosition(0);
    }
    
    public double getSallySpeed() {
    	return armTalon.get();
    }
    
    // ================== Solenoids ==================
    public void deploy() {
    	armSolenoid.set(Value.kReverse);
    	deployed = true;
    }
    
    public void retract() {
    	armSolenoid.set(Value.kForward);
    	deployed = false;
    }
    
    public boolean isDeployed() {
    	return deployed;
    }
    
    //================== Limit Switches ==================
    public boolean isSallyStowed() {
    	return sallyStowSwitch.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

