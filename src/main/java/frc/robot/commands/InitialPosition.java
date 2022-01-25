// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class InitialPosition extends CommandBase {
  /** Creates a new InitialPosition. */
  private DriveTrain driveTrain;
  private double positionTime;
  private double positionAxis;
  private int location;
  
  public InitialPosition(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    driveTrain = dt;
    addRequirements(dt);
    location = DriverStation.getInstance().getLocation();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.timer.reset();
    Robot.timer.start();

    driveTrain.gyro.reset();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    positionTime = Robot.timer.get();
    positionAxis = driveTrain.gyro.getAngle();
    if (location == 1){
      if(positionAxis < 45){
        //se angulo for abaixo de 45, mover pra direita
        driveTrain.arcadeAutonomousMove(0.0, 1.0, Constants.robot_speed);
      }else if (positionAxis > 45 && positionAxis < 48){
        //se estiver entre 45 e 48, mover pra frente
        driveTrain.arcadeAutonomousMove(1.0, 0, Constants.robot_speed);
      }else if (positionAxis > 48){
        //se angulo for acima de 48, mover pra esquerda
        driveTrain.arcadeAutonomousMove(0.0, -1.0, Constants.robot_speed);
      }
      
    }else if(location == 2){
      //mover pra frente
      driveTrain.arcadeAutonomousMove(1.0, 0.0, Constants.robot_speed);
    

    }else if (location == 3){
      if(positionAxis > -45){
        //se angulo for acima de -45, mover pra esquerda
        driveTrain.arcadeAutonomousMove(0.0, -1.0, Constants.robot_speed);
      }else if (positionAxis < -45 && positionAxis > -48){
        //se angulo estiver entre -45 e -48, mover pra frente
        driveTrain.arcadeAutonomousMove(1.0, 0.0, Constants.robot_speed);
      }else if (positionAxis < -48){
        //se angulo for abaixo de -48, mover pra direita
        driveTrain.arcadeAutonomousMove(0.0, 1.0, Constants.robot_speed);
      }
    
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override

  public boolean isFinished() {
    if(location == 1 || location == 3){
      return positionTime > 3.0;
    }else{ 
    return positionTime > 2.0;
    }
  }
}
