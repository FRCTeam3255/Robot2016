package org.usfirst.frc.team3255.robot2016.subsystems;
import org.usfirst.frc.team3255.robot2016.RobotMap;
import org.usfirst.frc.team3255.robot2016.OI;
import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.DriveArcade;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class Drivetrain extends PIDSubsystem {
	
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
	
	// Encoders
	Encoder leftDriveTrainEncoder = null;
	Encoder rightDriveTrainEncoder = null;
	
	// Double Solenoids
	DoubleSolenoid shifterSolenoid = null;
	
	public void init() {
		// CANTalons
		leftFrontTalon = new CANTalon(RobotMap.LEFT_FRONT_TALON);
		leftMiddleTalon = new CANTalon(RobotMap.LEFT_MIDDLE_TALON);
		leftBackTalon = new CANTalon(RobotMap.LEFT_BACK_TALON);
		rightFrontTalon = new CANTalon(RobotMap.RIGHT_FRONT_TALON);
		rightMiddleTalon = new CANTalon(RobotMap.RIGHT_MIDDLE_TALON);
		rightBackTalon = new CANTalon(RobotMap.RIGHT_BACK_TALON);
		
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
		
		// Encoders
		leftDriveTrainEncoder = new Encoder(RobotMap.LEFT_DRIVETRAIN_ENCODER_CHA, RobotMap.LEFT_DRIVETRAIN_ENCODER_CHB);
		rightDriveTrainEncoder = new Encoder(RobotMap.RIGHT_DRIVETRAIN_ENCODER_CHA, RobotMap.RIGHT_DRIVETRAIN_ENCODER_CHB);
		
		// Double Solenoids
		shifterSolenoid = new DoubleSolenoid(RobotMap.DRIVETRAIN_SHIFTER_UP, RobotMap.DRIVETRAIN_SHIFTER_DOWN);
	}

    public Drivetrain(double p, double i, double d) {
		super(p, i, d);
	}

	@Override
	protected double returnPIDInput() {
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		
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
	
	// Solenoids
	public void shiftUp() {
		shifterSolenoid.set(Value.kForward);
	}

	public void shiftDown() {
		shifterSolenoid.set(Value.kReverse);
	}
	
	// Encoders
	public void resetEncoders() {
		leftDriveTrainEncoder.reset();
		rightDriveTrainEncoder.reset();
	}
	
	public void updateEncoderRatio() {
		// TODO Set constants for encoder distance
	}
	
	public double getEncoderDistance() {
		return leftDriveTrainEncoder.getDistance();
	}
	
	public double getEncoderRaw() {
		return leftDriveTrainEncoder.getRaw();
	}
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveArcade());
    }
}

