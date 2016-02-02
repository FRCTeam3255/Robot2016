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
	public static ObstacleArm obstaclearm;
	public static Shooter shooter;
	public static Vision vision;
	public static Telemetry telemetry;
	public static OI oi;
	
	public CommandBase() {
		
	}

	public static void init() {
		//Keep Navigation at the top!
		navigation = new Navigation();
		//Keep Navigation at the top!
		
		drivetrain = new Drivetrain(1.0, 2.0, 0.5);
		collector = new Collector();
		obstaclearm = new ObstacleArm();
		shooter = new Shooter();
		vision = new Vision();
		telemetry = new Telemetry();
		oi = new OI();
	}

}
