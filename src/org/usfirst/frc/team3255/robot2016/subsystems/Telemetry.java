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
	
	public void init() {
		// DriveTrain
		SmartDashboard.putData("Reset Encoders", new DriveResetEncoders());
		
		// Vision
		SmartDashboard.putNumber("Area min %", Vision.AREA_MINIMUM);

		SmartDashboard.putBoolean("Processed Image", false);

	}
	
	public void update() {
		// Drivetrain
		SmartDashboard.putNumber("getEncPosition", CommandBase.drivetrain.getEncoderPosition());
	}

	// ================== Vision ==================
	public double getAreaMin() {
		return SmartDashboard.getNumber("Area min %");
	}

	public boolean isProcessed() {
		return SmartDashboard.getBoolean("Processed Image");
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
}

