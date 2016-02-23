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
		SmartDashboard.putData("Drive Distance", new DriveDistance());
		SmartDashboard.putData("Drive Straight Distance", new DriveStraightDistance());
		SmartDashboard.putData("Drive Hold 0 Yaw", new DriveHoldZeroYaw());
		
		// Collector
		SmartDashboard.putData("Collector Reset Encoders", new CollectorResetEncoders());
		SmartDashboard.putData("Collector Low", new CollectorMoveToLow());
		SmartDashboard.putData("Collector Pickup", new CollectorMoveToPickup());
		SmartDashboard.putData("Collector Stow", new CollectorMoveToStow());
		SmartDashboard.putData("Collector Forward To Switch", new CollectorForwardToSwitch());
		
		// Sally Arm
		SmartDashboard.putData("Sally Reset Encoders", new SallyResetEncoders());
		SmartDashboard.putData("Sally Grab", new SallyMoveToGrab());
		SmartDashboard.putData("Sally Stow", new SallyMoveToStow());
		SmartDashboard.putData("Sally Stow Switch", new SallyMoveToStowSwitch());
		SmartDashboard.putData("Sally Prep Grab", new SallyPrepGrab());
		SmartDashboard.putData("Sally Drawbridge", new SallyDrawbridge());
		SmartDashboard.putData("Sally Retract", new SallyRetract());
		
		// Lighting
		SmartDashboard.putData("Blue LED", new LightingBlueOn());
		SmartDashboard.putData("Red LED", new LightingRedOn());
		SmartDashboard.putData("LEDs off", new LightingOff());
		
		// Navigation
		SmartDashboard.putData("Reset Yaw", new NavigationZeroYaw());
		
		// Vision
		SmartDashboard.putData("Update Replay Range", new VisionUpdateReplayRange());
		SmartDashboard.putData("Next Image", new VisionNextImage());
		SmartDashboard.putData("Prev Image", new VisionPrevImage());
		
		// Auto
		SmartDashboard.putData("Drive Over Obstacle", new DriveOverObstacle());
		SmartDashboard.putData("Drive Until Pitched", new DriveUntilPitched());
		SmartDashboard.putData("Drive Until Flat", new DriveUntilFlat());
		SmartDashboard.putData("Drive to Target", new DriveToTarget());
		SmartDashboard.putData("Drive Over Obstacle To Target", new DriveOverObstacleToTarget());
		SmartDashboard.putData("Drive to Target Acquired", new DriveUntilTargetAcquired());
		SmartDashboard.putData("Drive to Target", new DriveToTarget());
		SmartDashboard.putData("Drive Over Obstacle Shoot", new DriveOverObstacleShoot());
	}
	
	public void update() {
		// Drivetrain
		SmartDashboard.putNumber("Drivetrain Position", CommandBase.drivetrain.getEncoderPosition());
		SmartDashboard.putNumber("Drivetrain Distance", CommandBase.drivetrain.getEncoderDistance());
		SmartDashboard.putNumber("Drive Speed", CommandBase.drivetrain.getDriveSpeed());
		SmartDashboard.putBoolean("Low Gear", CommandBase.drivetrain.isLowGear());
		
		// Collector
		SmartDashboard.putNumber("Collector Position", CommandBase.collector.getEncoderPosition());
		SmartDashboard.putNumber("Collector Arm Output", CommandBase.collector.getArmSpeed());
		
		// Sally Arm
		SmartDashboard.putNumber("Sally Position", CommandBase.sallyArm.getEncoderPosition());
		SmartDashboard.putNumber("Sally Output", CommandBase.sallyArm.getSallySpeed());
		SmartDashboard.putBoolean("Sally Deployed", CommandBase.sallyArm.isDeployed());
		SmartDashboard.putBoolean("Sally Stowed", CommandBase.sallyArm.isSallyStowed());
		
		// Shooter
		SmartDashboard.putBoolean("Ball Switched Closed", CommandBase.shooter.isBallHoldSwitchClosed());
		
		// Navigation
		SmartDashboard.putNumber("Yaw", CommandBase.navigation.getYaw());
		SmartDashboard.putNumber("Pitch", CommandBase.navigation.getPitch());
		SmartDashboard.putBoolean("Calibrated", !CommandBase.navigation.isCalibrating());
		
		// Vision
		SmartDashboard.putNumber("Raw Particles", CommandBase.vision.getNumRawParticles());
		SmartDashboard.putNumber("Particles", CommandBase.vision.getNumParticles());
		SmartDashboard.putBoolean("Is Target", CommandBase.vision.isTarget());
		SmartDashboard.putNumber("Target X", CommandBase.vision.getTargetCenterX());
		SmartDashboard.putNumber("Target Distance", CommandBase.vision.getTargetDistance());
	}

	// ================== Vision ==================
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new TelemetryUpdate());
    }
}

