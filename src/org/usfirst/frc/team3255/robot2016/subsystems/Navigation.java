package org.usfirst.frc.team3255.robot2016.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Navigation extends Subsystem {
	
	public static AHRS ahrs = null;
	
	public Navigation() {
		super();
		
		init();
	}
	
	public Navigation(String name) {
		super(name);
		
		init();
	}
	
	public void init() {
        try {
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
            ahrs = new AHRS(SPI.Port.kMXP); 
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
	}
	
	public double getYaw() {
		return ahrs.getYaw();
	}
	
	public double getPitch() {
		// Due to orientation of RoboRIO Pitch & Roll are switched
		return ahrs.getRoll();
	}

	public void resetYaw() {
		ahrs.reset();
	}
	
	public boolean isCalibrating() {
		return ahrs.isCalibrating();
	}
	
	public double getAccel() {
		// might need to be linear acceleration
		return ahrs.getRawAccelX();
	}

    public void initDefaultCommand() {
    	
    }
}

