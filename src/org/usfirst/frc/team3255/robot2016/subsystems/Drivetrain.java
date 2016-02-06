package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.OI;
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

	// Double Solenoids
	DoubleSolenoid shifterSolenoid = null;
	
	// PID Navigation Control
	NavigationRotatePID navigationRotatePID = null;
	
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
		
		// Double Solenoids
		shifterSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFT_UP, RobotMap.DRIVETRAIN_SHIFT_DOWN);
		
		// PID Navigation Control
		navigationRotatePID = new NavigationRotatePID();
	}
	
	// Talons
	public void setSpeed(double s) {
		leftThreeMotorDrive.set(s);
		rightThreeMotorDrive.set(-s);
	}
	
	public void arcadeDrive() {
		// negate the drive axis so that pushing stick forward is +1
		double moveSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_MOVE);
		double rotateSpeed = -OI.driverStick.getRawAxis(RobotMap.AXIS_ARCADE_ROTATE);
		double arcadeSensitivity = RobotPreferences.driveSensitivity();
		
		robotDrive.arcadeDrive(moveSpeed * arcadeSensitivity, rotateSpeed * arcadeSensitivity);
	}
	
	public void straightDrive(){
		double moveSpeed = RobotPreferences.autoObstacleDriveSpeed();
		double moveRotate = -navigationRotatePID.getOutput();
		
		robotDrive.arcadeDrive(moveSpeed, moveRotate);
	}
	
	// Solenoids
	public void shiftUp() {
		shifterSolenoid.set(Value.kForward);
	}

	public void shiftDown() {
		shifterSolenoid.set(Value.kReverse);
	}
	
	// Encoders
	public void resetEncoders() {
		leftFrontTalon.setEncPosition(0);
	}
	
	public void updateEncoderRatio() {
		// DriveTrainEncoder.setDistancePerPulse(5.0 / RobotPreferences.getDriveTrainPulsePer5Feet());
	}
	
	public double getEncoderDistance() {
		return leftFrontTalon.getEncPosition();
	}

	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade());
    }
}

