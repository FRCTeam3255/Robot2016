package org.usfirst.frc.team3255.robot2016.subsystems;

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
		SmartDashboard.putData("Drive 5 Feet", new DriveDistance(5.0));
		SmartDashboard.putData("Drive Straight 5 Feet", new DriveStraightDistance(5.0));
		
		// Collector
		SmartDashboard.putData("Collector Reset Encoders", new CollectorResetEncoders());
		SmartDashboard.putData("Collector Low", new CollectorMoveToLow());
		SmartDashboard.putData("Collector Pickup", new CollectorMoveToPickup());
		SmartDashboard.putData("Collector Stow", new CollectorMoveToStow());
		
		// Sally Arm
		SmartDashboard.putData("Sally Reset Encoders", new SallyResetEncoders());
		SmartDashboard.putData("Sally Grab", new SallyMoveToGrab());
		SmartDashboard.putData("Sally Stow", new SallyMoveToStow());
	}
	
	public void update() {
		// Drivetrain
		SmartDashboard.putNumber("Drivetrain Position", CommandBase.drivetrain.getEncoderPosition());
		SmartDashboard.putNumber("Drivetrain Distance", CommandBase.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getDriveSpeed());
		
		// Collector
		SmartDashboard.putNumber("Collector Position", CommandBase.collector.getEncoderPosition());
		SmartDashboard.putNumber("Collector Arm Output", CommandBase.collector.getArmSpeed());
		
		// Sally Arm
		SmartDashboard.putNumber("Sally Position", CommandBase.sallyArm.getEncoderPosition());
		SmartDashboard.putNumber("Sally Output", CommandBase.sallyArm.getSallySpeed());
		SmartDashboard.putBoolean("Sally Deployed", CommandBase.sallyArm.isDeployed());
		
		// Shooter
		SmartDashboard.putBoolean("Ball Switched Closed", CommandBase.shooter.isBallHoldSwitchClosed());
		
		// Navigation
		SmartDashboard.putNumber("Yaw", CommandBase.navigation.getYaw());
		SmartDashboard.putNumber("Pitch", CommandBase.navigation.getPitch());
		SmartDashboard.putBoolean("Calibrated", !CommandBase.navigation.isCalibrating());
	}

	// ================== Vision ==================
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
}

