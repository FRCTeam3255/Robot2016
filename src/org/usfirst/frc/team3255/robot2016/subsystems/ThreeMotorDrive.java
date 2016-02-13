package org.usfirst.frc.team3255.robot2016.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 */
public class ThreeMotorDrive implements SpeedController {

	private SpeedController sc1;
	private SpeedController sc2;
	private SpeedController sc3;
	
	public ThreeMotorDrive(SpeedController m1, SpeedController m2, SpeedController m3) {
		sc1 = m1;
		sc2 = m2;
		sc3 = m3;
	}

	@Override
	public void pidWrite(double output) {
		sc1.pidWrite(output);
		sc2.pidWrite(output);
		sc3.pidWrite(output);
	}

	@Override
	public double get() {
		return sc1.get();
	}

	@Override
	public void set(double speed, byte syncGroup) {
		sc1.set(speed, syncGroup);
		sc2.set(speed, syncGroup);
		sc3.set(speed, syncGroup);
	}

	@Override
	public void set(double speed) {
		sc1.set(speed);
		sc2.set(speed);
		sc3.set(speed);
	}

	@Override
	public void setInverted(boolean isInverted) {
		sc1.setInverted(isInverted);
		sc2.setInverted(isInverted);
		sc3.setInverted(isInverted);
	}

	@Override
	public boolean getInverted() {
		return sc1.getInverted();
	}

	@Override
	public void disable() {
		sc1.disable();
		sc2.disable();
		sc3.disable();
	}

	@Override
	public void stopMotor() {
		// TODO Auto-generated method stub
		
	}
}

