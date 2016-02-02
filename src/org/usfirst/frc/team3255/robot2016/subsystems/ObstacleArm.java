package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ObstacleArm extends Subsystem {
    

	Talon armTalon = null;
    
    DoubleSolenoid armSolenoid = null;
    
    DigitalInput deployPosition = null;
    DigitalInput retractPosition = null;
    
    public ObstacleArm() {
		super();
		
		init();
	}

	public ObstacleArm(String name) {
		super(name);
		
		init();
	}
    
    public void init() {
    	armTalon = new Talon(RobotMap.OBSTACLEARM_TALON);
    	
    	armTalon.setSafetyEnabled(false);
    	
    	armSolenoid = new DoubleSolenoid(RobotMap.OBSTACLEARM_SOLENOID_CHA, RobotMap.OBSTACLEARM_SOLENOID_CHB);
    	
    	deployPosition = new DigitalInput(RobotMap.OBSTACLEARM_DEPLOYED_SWITCH);
    	retractPosition = new DigitalInput(RobotMap.OBSTACLEARM_RETRACTED_SWITCH);
    	//TODO shooterEncoder.setDistancePerPulse(12.0 / ENCODER_COUNT_PER_ROTATION);
    }
    
    // Talons
    public void setSpeed(double s) {
    	armTalon.set(s);
	}
    
    // Solenoids
    public void open() {
    	armSolenoid.set(Value.kForward);
    }
    
    public void close() {
    	armSolenoid.set(Value.kReverse);
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

