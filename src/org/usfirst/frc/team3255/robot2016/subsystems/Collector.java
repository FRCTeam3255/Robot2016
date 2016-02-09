package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Collector extends PIDSubsystem {
	
	CANTalon intakeTalon = null;
	CANTalon armTalon = null;
	
	DigitalInput homePosition = null;
    
    public Collector() {
		super(0, 0, 0);
		
		init();
	}

	public Collector(String name) {
		super(name, 0, 0, 0);
		
		init();
	}

	public void init(){
		intakeTalon = new CANTalon(RobotMap.COLLECTOR_INTAKE_TALON);
		armTalon = new CANTalon(RobotMap.COLLECTOR_ARM_TALON);
		
		intakeTalon.setSafetyEnabled(false);
		armTalon.setSafetyEnabled(false);
		
		armTalon.enableBrakeMode(true);
	}
	
	public void enable() {
		getPIDController().setPID(RobotPreferences.collectorP(),
				RobotPreferences.collectorI(),
				RobotPreferences.collectorD());
		this.setAbsoluteTolerance(RobotPreferences.collectorTolerance());
		super.enable();
	}
	
	// ================== PID ==================
	@Override
	protected double returnPIDInput() {
		return getEncoderPosition();
	}

	@Override
	protected void usePIDOutput(double output) {
		setArmSpeed(output);
	}
	
	// ================== Talons ==================
	public void setIntakeSpeed(double s){
		intakeTalon.set(s);
	}
	
	public void resetEncoders(){
		armTalon.setEncPosition(0);
	}
	
	public double getEncoderPosition() {
		return armTalon.getEncPosition();
	}
	
	public void setArmSpeed(double s) {
		armTalon.set(s);
	}
	
	// ================== Limit Switches ==================
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

