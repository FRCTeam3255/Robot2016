package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.subsystems.Telemetry;
import org.usfirst.frc.team3255.robot2016.OI;
import org.usfirst.frc.team3255.robot2016.subsystems.*;

import edu.wpi.first.wpilibj.command.Command;

//Test

public abstract class CommandBase extends Command {
	//Keep Navigation at the top!
	public static Navigation navigation;
	//Keep Navigation at the top!
	
	public static Drivetrain drivetrain;
	public static Collector collector;
	public static SallyArm sallyArm;
	public static Shooter shooter;
	public static Lighting lighting;
	public static Vision vision;
	public static DrivetrainDistancePID driveDistancePID;
	public static NavigationYawPID navYawPID;
	public static VisionDistancePID visionDistancePID;
	public static VisionYawPID visionYawPID;
	public static Telemetry telemetry;
	public static OI oi;
	
	protected double expireTime = 0;
	
	public CommandBase() {	
	}

	public static void init() {
		//Keep Navigation at the top!
		navigation = new Navigation();
		//Keep Navigation at the top!
		
		drivetrain = new Drivetrain();
		collector = new Collector();
		sallyArm = new SallyArm();
		shooter = new Shooter();
		lighting = new Lighting();
		vision = new Vision();
		driveDistancePID = new DrivetrainDistancePID();
		navYawPID = new NavigationYawPID();
		visionDistancePID = new VisionDistancePID();
		visionYawPID = new VisionYawPID();
		telemetry = new Telemetry();
		oi = new OI();
	}
	
	/*
	 * The startTimer and isTimerExpired methods of the Command class only work for times
	 * relative to the start of the initialization. Specifically, if you call
	 * startTimer(3 seconds) 2 seconds after your command initialized, isTimerExpired
	 * becomes true 1 second later.
	 * 
	 * Because we want the ability to set a timer that expires relative to when
	 * the timer was set, the methods setTimer and isTimerExpired create that
	 * functionality.
	 */
	protected void startTimer(double seconds) {
		expireTime = timeSinceInitialized() + seconds;
	}
	
	protected boolean isTimerExpired() {
		return (timeSinceInitialized() >= expireTime);
	}
}
