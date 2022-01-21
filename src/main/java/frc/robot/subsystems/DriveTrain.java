// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /** Creates a new DriveTrain. */
  //gyro
  public ADXRS450_Gyro gyro = new ADXRS450_Gyro();
  //declarando speedcontrollers
  SpeedControllerGroup leftMotors;
  SpeedControllerGroup rightMotors;
  //declarando motores left
  public WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.leftMasterID);
  public WPI_TalonSRX leftSlave = new WPI_TalonSRX(Constants.leftSlaveID);

  //declarando motores right
  public WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.rightMasterID);
  public WPI_TalonSRX rightSlave = new WPI_TalonSRX(Constants.rightSlaveID);
  //diferential Drive
  DifferentialDrive m_drive;
  

  public DriveTrain() {
    leftMaster.configFactoryDefault();
    leftSlave.configFactoryDefault();
    rightMaster.configFactoryDefault();
    rightSlave.configFactoryDefault();

    rightMaster.setInverted(true);
    leftMaster.setInverted(false);

    

    //definindo speedcontrollers
    leftMotors = new SpeedControllerGroup(leftMaster, leftSlave);
    rightMotors = new SpeedControllerGroup(rightMaster, rightSlave);
    //definindo differential drive
    m_drive = new DifferentialDrive(leftMotors, rightMotors);
  }
 @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void driveWithJoysticks(Joystick stick, double speed){

  m_drive.arcadeDrive(stick.getRawAxis(Constants.yID)*speed, stick.getRawAxis(Constants.xID)*speed);
  }
  public void arcadeAutonomousMove(double moveSpeed, double turnSpeed, double speed){
    m_drive.arcadeDrive(moveSpeed*speed, turnSpeed*speed);
  }

  public void stop(){
    m_drive.stopMotor();
  }



}



