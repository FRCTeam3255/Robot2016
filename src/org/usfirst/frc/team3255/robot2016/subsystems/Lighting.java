package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lighting extends Subsystem {
	
	// Relays
	Relay blueRelay = null;
	Relay redRelay = null;
	
    public Lighting() {
		super();

		init();
	}

	public Lighting(String name) {
		super(name);

		init();
	}
	
	public void init() {	
		//relays
		blueRelay = new Relay(RobotMap.LIGHTING_BLUE_RELAY);
		blueRelay.setDirection(Direction.kForward);

		redRelay = new Relay(RobotMap.LIGHTING_RED_RELAY);
		redRelay.setDirection(Direction.kForward);
	}
	
	// ================== Relays ==================
	
	public void blueOn(boolean on) {
		if(on) {
			blueRelay.set(Relay.Value.kOn);
		}
		else {
			blueRelay.set(Relay.Value.kOff);
		}
	}
	
	public void redOn(boolean on) {
		if(on) {
			redRelay.set(Relay.Value.kOn);
		}
		else {
			redRelay.set(Relay.Value.kOff);
		}
	}

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

