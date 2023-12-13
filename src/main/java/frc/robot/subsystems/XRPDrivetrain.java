// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.xrp.XRPGyro;
import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class XRPDrivetrain extends SubsystemBase {
  private static final double kGearRatio =
      (30.0 / 14.0) * (28.0 / 16.0) * (36.0 / 9.0) * (26.0 / 8.0); // 48.75:1
  private static final double kCountsPerMotorShaftRev = 12.0;
  private static final double kCountsPerRevolution = kCountsPerMotorShaftRev * kGearRatio; // 585.0
  private static final double kWheelDiameterInch = 2.3622; // 60 mm

  // The XRP has the left and right motors set to
  // channels 0 and 1 respectively
  private final XRPMotor m_leftMotor = new XRPMotor(0);
  private final XRPMotor m_rightMotor = new XRPMotor(1);

  // The XRP has onboard encoders that are hardcoded
  // to use DIO pins 4/5 and 6/7 for the left and right
  private final Encoder m_leftEncoder = new Encoder(4, 5);
  private final Encoder m_rightEncoder = new Encoder(6, 7);

  // Set up the differential drive controller
  private final DifferentialDrive m_diffDrive = new DifferentialDrive(m_leftMotor, m_rightMotor);

  // Set up the XRPGyro
  private final XRPGyro m_gyro = new XRPGyro();

  /** Creates a new XRPDrivetrain. */
  public XRPDrivetrain() {
    // Use inches as unit for encoder distances
    m_leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    m_rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();

    // Invert right side since motor is flipped
    m_rightMotor.setInverted(true);
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) {
    //TODO finish implementing the arcade drive using the given member objects
    m_diffDrive.arcadeDrive(xaxisSpeed,
            zaxisRotate);
  }

  public void resetEncoders() {
    //TODO reset the left and right encoders to 0
    m_leftEncoder.reset();
    m_rightEncoder.reset();
  }

  public double getLeftDistanceInch() {
    //TODO get the left encoder distance in inches
    // hint, look at what line 39/40 is doing
    return m_leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    //TODO get the right encoder distance in inches
    // hint, look at what line 35/36 is doing
    return m_rightEncoder.getDistance();
  }

  public double getGyroHeading() {
    //TODO get the heading of the robot using the gyro
    return 0;
  }

  // Neither of these periodic methods are needed, but you can add things to them
  // to tinker

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
