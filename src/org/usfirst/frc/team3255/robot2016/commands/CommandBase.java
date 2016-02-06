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
	public static Telemetry telemetry;
	public static OI oi;
	
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
		telemetry = new Telemetry();
		oi = new OI();
	}

}
