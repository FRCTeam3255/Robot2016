package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Shooter extends Subsystem {
 
	Talon leftTalon = null;
	Talon rightTalon = null;
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public void init() {
		leftTalon = new Talon(RobotMap.LEFT_SHOOTER_TALON);
		rightTalon = new Talon(RobotMap.RIGHT_SHOOTER_TALON);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

