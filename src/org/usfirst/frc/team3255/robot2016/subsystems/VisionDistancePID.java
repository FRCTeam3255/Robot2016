package org.usfirst.frc.team3255.robot2016.subsystems;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;
import org.usfirst.frc.team3255.robot2016.commands.CommandBase;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class VisionDistancePID extends PIDSubsystem {
    
	private double output = 0;
	private boolean outputValid = false;
	
	public VisionDistancePID() {
		super(0, 0, 0);
		updatePIDValues();
	}

	// update the PID values based on preferences set from the dashboard
	public void updatePIDValues() {
		this.getPIDController().setPID(
				RobotPreferences.VisionDistancePIDP(),
				RobotPreferences.VisionDistancePIDI(),
				RobotPreferences.VisionDistancePIDD());
				
		double maxSpeed = RobotPreferences.MoveSpeedMax();
		this.setOutputRange(-maxSpeed, maxSpeed);
		
		// This controller uses the distance to the vision target as the sensed value.
		// Therefore the setpoint is set to the desired distance from the vision target.
		this.setSetpoint(RobotPreferences.VisionDistance());
	}

	@Override
	protected double returnPIDInput() {
		// if the vision system did not detect a tote, then return the current
		// setpoint as the PID input so that no additional error is accumulated
		// in the PID controller. Also mark the output as invalid to make sure
		// the output of the PID controller is forced to zero.
		if (CommandBase.vision.isTote() == false) {
			outputValid = false;
			return this.getSetpoint();
		}

		// mark the output of the PID controller as valid because a tote was found
		outputValid = true;		
		
		// return the distance to the tote
		return CommandBase.vision.getToteDistance();
	}

	@Override
	protected void usePIDOutput(double output) {
		this.output = output;
	}
	
	/*
	 * This method returns the most recent cached value from the PID output
	 */
	public double getOuptut() {
		// return 0 if the PID controller is disabled or if the cached value is not valid
		if((this.getPIDController().isEnabled() == false) || (outputValid == false)) {
			return 0;
		}
		return output;
	}

	@Override
	protected void initDefaultCommand() {
	}
}
