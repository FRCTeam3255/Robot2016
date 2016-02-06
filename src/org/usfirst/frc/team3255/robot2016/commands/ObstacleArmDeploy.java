package org.usfirst.frc.team3255.robot2016.commands;

import org.usfirst.frc.team3255.robot2016.RobotPreferences;

/**
 *
 */
public class ObstacleArmDeploy extends CommandBase {

    public ObstacleArmDeploy() {
    	requires(obstaclearm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	obstaclearm.setSpeed(0.8);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (obstaclearm.getArmEncoderDistance() > RobotPreferences.sallyPortPosition());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}