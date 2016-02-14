package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.DriveArcade;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {
	
	boolean lowGear = true;
	
	// CAN Talons
	CANTalon leftFrontTalon = null;
	CANTalon leftMiddleTalon = null;
	CANTalon leftBackTalon = null;
	CANTalon rightFrontTalon = null;
	CANTalon rightMiddleTalon = null;
	CANTalon rightBackTalon = null;
	
	// Three Motor Drive
	ThreeMotorDrive leftThreeMotorDrive = null;
	ThreeMotorDrive rightThreeMotorDrive = null;
	
	// Robot Drive
	RobotDrive robotDrive = null;

	// Solenoids
	DoubleSolenoid shifterSolenoid = null;
	
    public Drivetrain() {
		super();
    	
		init();
	}

	public Drivetrain(String name) {
		super(name);
		
		init();
	}

	public void init() {
		// CANTalons
		leftFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftMiddleTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_MIDDLE_TALON);
		leftBackTalon = new CANTalon(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightMiddleTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_MIDDLE_TALON);
		rightBackTalon = new CANTalon(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		leftFrontTalon.setSafetyEnabled(false);
		leftMiddleTalon.setSafetyEnabled(false);
		leftBackTalon.setSafetyEnabled(false);
		rightFrontTalon.setSafetyEnabled(false);
		rightMiddleTalon.setSafetyEnabled(false);
		rightBackTalon.setSafetyEnabled(false);
		
		// Three Motor Drive
		leftThreeMotorDrive = new ThreeMotorDrive(leftFrontTalon, leftMiddleTalon, leftBackTalon);
		rightThreeMotorDrive = new ThreeMotorDrive(rightFrontTalon, rightMiddleTalon, rightBackTalon);
		
		// RobotDrive
		robotDrive = new RobotDrive(leftThreeMotorDrive, rightThreeMotorDrive);
		robotDrive.setSafetyEnabled(false);
		
		// Solenoids
		shifterSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_UP, RobotMap.DRIVETRAIN_SHIFT_DOWN);
	}
	
	// ================== Talons ==================
	public void setSpeed(double s) {
		leftThreeMotorDrive.set(s);
		rightThreeMotorDrive.set(-s);
	}
	
	public void arcadeDrive(double moveSpeed, double rotateSpeed){
		robotDrive.arcadeDrive(-moveSpeed, -rotateSpeed);
	}
	
	public double getDriveSpeed() {
		return leftFrontTalon.get();
	}
	
	// ================== Solenoids ==================
	public void shiftHi() {
		shifterSolenoid.set(Value.kReverse);
		lowGear = false;
	}

	public void shiftLow() {
		shifterSolenoid.set(Value.kForward);
		lowGear = true;
	}
	
	public boolean isLowGear() {
		return lowGear;
	}
	
	// ================== Encoders ==================
	public void resetEncoders() {
		leftBackTalon.setEncPosition(0);
	}
	
	public double getEncoderPosition() {
		return leftBackTalon.getEncPosition() * 0.001;
	}

	public double getEncoderDistance() {
		return (getEncoderPosition() / RobotPreferences.drivetrainPulsesPer5Feet()) * 5;
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade());
    }
}

