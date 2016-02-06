package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	CANTalon intakeTalon = null;
	CANTalon armTalon = null;
	
	DigitalInput homePosition = null;
    
    public Collector() {
		super();
		
		init();
	}

	public Collector(String name) {
		super(name);
		
		init();
	}

	public void init(){
		intakeTalon = new CANTalon(RobotMap.COLLECTOR_INTAKE_TALON);
		armTalon = new CANTalon(RobotMap.COLLECTOR_ARM_TALON);
		
		intakeTalon.setSafetyEnabled(false);
		armTalon.setSafetyEnabled(false);
	}
	
	// Talons
	public void setIntakeSpeed(double s){
		intakeTalon.set(s);
	}
	
	public void resetEncoders(){
		armTalon.setEncPosition(0);
	}
	
	public double getEncoderPosition() {
		return armTalon.getEncPosition();
	}
	
	public void setArmSpeed (double s) {
		armTalon.set(s);
	}
	
	public boolean isCollectorHome() {
		if (homePosition.get()) {
			return true;
		}
		else {
			return false;
		}
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

