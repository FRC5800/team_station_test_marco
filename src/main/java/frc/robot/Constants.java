// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	//portes:
    public static int leftMasterID = 2;
    public static int leftSlaveID = 1;
    public static int rightMasterID= 4;
    public static int rightSlaveID = 3;
    //portes dos eixos
	public static int xID = 0;
    public static int yID = 1;
    //velocidade geral do robô teleoperado:
    public static double robot_speed = 0.5;
    //velocidade geral do robô autonomo:
    public static double turnSpeed;
    public static double moveSpeed;
    //tempo de movimento autonomo(provavelmente vai ser inútil):
    public static double timeForward = 3.0;
    //porta do joystick
    public static int joytickID = 0;
    //gyro ID
    public static int gyroID = 0;

}
