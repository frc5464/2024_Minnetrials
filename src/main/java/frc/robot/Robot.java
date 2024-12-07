// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.HopperSubsystem;
import frc.robot.subsystems.RotationSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private RobotContainer m_robotContainer;

  private DriveSubsystem driveSubsystem;
  
  public ShooterSubsystem shooterSubsystem;

  public RotationSubsystem rotationSubsystem;

  public HopperSubsystem hopperSubsystem;

  public int autoSteps = 0;

   Timer autoFirstTimer = new Timer();
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    driveSubsystem = new DriveSubsystem();
    shooterSubsystem = new ShooterSubsystem();
    rotationSubsystem = new RotationSubsystem();
    hopperSubsystem = new HopperSubsystem();
  }



  // adds two numbers and returns the result of them added
  public int getTheSum(int a, int b){
    int c = a + b;
    return c;
  }

  Joystick motionController = new Joystick(0);
  Joystick shellController = new Joystick(1);

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();
      SmartDashboard.putNumber("autoTimer", autoFirstTimer.get());

   
      autoFirstTimer.reset();
      autoFirstTimer.start();

      autoSteps = 1;

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    if(autoSteps == 1) {
      driveSubsystem.crawl(-0.3, -0.3);
      if (autoFirstTimer.get() > 3) {
        autoSteps = 2;
      }
     }
    if (autoSteps == 2) {
      driveSubsystem.crawl(0, 0);
      if (autoFirstTimer.get() > 2) {
        autoSteps = 3;
      }
    }
    if (autoSteps == 3) {
      driveSubsystem.crawl(0.3, -0.3);
      if(autoFirstTimer.get() > 2) {
        autoSteps = 4;
      }
    }
  }
  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    double leftstickval = motionController.getRawAxis(1);
    double rightstickval = motionController.getRawAxis(5);

    double leftstickvalue = shellController.getRawAxis(1);
    //double leftstickvalue1 = shellController.getRawAxis(5)
    
    if(shellController.getRawButton(2)){
      hopperSubsystem.shootHopper();
    } else if(shellController.getRawButton(6)){
      hopperSubsystem.reverseHopper();
    } else {
      hopperSubsystem.stopHopper();
    }

    if(shellController.getRawButton(5)){
      shooterSubsystem.shootshooter();
    } else if(shellController.getRawButton(6)){
      shooterSubsystem.intakeshooter();
    } else {
      shooterSubsystem.stopshooter();
    }
    
    // DIGITAL ARM CONTROL
    if(shellController.getPOV() == 180){
      rotationSubsystem.rotArmUp();
    } else if(shellController.getPOV() == 0){
      rotationSubsystem.rotArmDowners();
    } else {
      rotationSubsystem.stopArm();
    }

    // rotationSubsystem.moveArm(leftstickvalue);

    driveSubsystem.crawl(leftstickval, rightstickval);
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {
    int shoot;
    
  }

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {

  }

  public boolean MoveArm(){
    return true;
  }
  public void botton(){
  
  }
}
