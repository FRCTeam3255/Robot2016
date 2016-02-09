package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class SallyArm extends Subsystem {
    
	// Talons
	CANTalon armTalon = null;
    
	// Solenoids
    DoubleSolenoid armSolenoid = null;
    
    // Limit Switches
    DigitalInput retractSwitch = null;
    
    public SallyArm() {
		super();
		
		init();
	}

	public SallyArm(String name) {
		super(name);
		
		init();
	}
    
    public void init() {
    	// Talons
    	armTalon = new CANTalon(RobotMap.SALLYARM_TALON);
    	
    	armTalon.setSafetyEnabled(false);
    	
    	// Solenoids
    	armSolenoid = new DoubleSolenoid(RobotMap.SALLYARM_SOLENOID_DEPLOY, 
    			RobotMap.SALLYARM_SOLENOID_RETRACT);
    	
    	// Limit Switches
    	retractSwitch = new DigitalInput(RobotMap.SALLYARM_RETRACTED_SWITCH);
    }
    
    // ================== Talons ==================
    public void setSpeed(double s) {
    	armTalon.set(s);
	}
    
    // ================== Solenoids ==================
    public void deploy() {
    	armSolenoid.set(Value.kForward);
    }
    
    public void retract() {
    	armSolenoid.set(Value.kReverse);
    }
    
    // ================== Limit Switches ==================
    public boolean isRetracted() {
    	return !retractSwitch.get();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

