package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Collector extends Subsystem {
	
	Talon intakeTalon = null;
	Talon armTalon = null;
    
    public Collector() {
		super();
		
		init();
	}

	public Collector(String name) {
		super(name);
		
		init();
	}

	public void init(){
		intakeTalon = new Talon(RobotMap.COLLECTOR_INTAKE_TALON);
		armTalon = new Talon(RobotMap.COLLECTOR_ARM_TALON);
		
		intakeTalon.setSafetyEnabled(false);
		armTalon.setSafetyEnabled(false);
	}
	
	// Talons
	public void setIntakeSpeed(double s){
		intakeTalon.set(s);
	}
	
	public void setArmSpeed (double s){
		armTalon.set(s);
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

