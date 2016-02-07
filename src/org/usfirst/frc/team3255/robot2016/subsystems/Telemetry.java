package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.commands.CommandBase;
import org.usfirst.frc.team3255.robot2016.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Telemetry extends Subsystem {
	
	public Telemetry() {
		super();
		
		init();
	}
	
	public Telemetry(String name) {
		super(name);
		
		init();
	}
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public void init() {
		// DriveTrain Commands
		SmartDashboard.putData("Reset Encoders", new DriveResetEncoders());
	}
	
	public void update() {
		SmartDashboard.putNumber("getEncPosition", CommandBase.drivetrain.getEncoderPosition());
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }

	public float getAreaMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isProcessed() {
		// TODO Auto-generated method stub
		return false;
	}
}

