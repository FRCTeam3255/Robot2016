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
		SmartDashboard.putData("Drive Reset Encoders", new DriveResetEncoders());
		
		// Collector
		SmartDashboard.putData("Collector Reset Encoders", new CollectorResetEncoders());
		SmartDashboard.putData("Collector Low", new CollectorMoveToLow());
		SmartDashboard.putData("Collector Pickup", new CollectorMoveToPickup());
		
		// Vision
		SmartDashboard.putNumber("Area min %", Vision.AREA_MINIMUM);

		SmartDashboard.putBoolean("Processed Image", false);
	}
	
	public void update() {
		// Drivetrain
		SmartDashboard.putNumber("getDrivetrainPosition", CommandBase.drivetrain.getEncoderPosition());
		
		// Collector
		SmartDashboard.putNumber("getCollectorPosition", CommandBase.collector.getEncoderPosition());
		
		// Shooter
		SmartDashboard.putBoolean("isBallSwitchedClosed", CommandBase.shooter.isBallHoldSwitchClosed());
		
		// Navigation
		SmartDashboard.putNumber("getYaw", CommandBase.navigation.getYaw());
		SmartDashboard.putNumber("getPitch", CommandBase.navigation.getPitch());
		
		SmartDashboard.putBoolean("isCalibrating", CommandBase.navigation.isCalibrating());
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

