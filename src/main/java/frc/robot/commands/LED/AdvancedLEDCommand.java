package frc.robot.commands.LED;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LEDSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.Constants;

public class AdvancedLEDCommand extends CommandBase {
  LEDSubsystem m_led;
  ShooterSubsystem m_shooter;
  VisionSubsystem m_vision;

  public AdvancedLEDCommand(VisionSubsystem m_vision, ShooterSubsystem m_shooter, LEDSubsystem m_led) {
    this.m_led = m_led;
    this.m_shooter = m_shooter;
    this.m_vision = m_vision;
    addRequirements(m_led);
  }

  @Override
  public void initialize(){}

  @Override
  public void execute() {
    if (m_vision.getHoopB() == 0 ) {
      // m_led.setOneSide(, color);
    }
      else {
      if (m_shooter.required_rpm - 7 < m_shooter.getShooterEncoderRPM()
          && m_shooter.required_rpm + 7 > m_shooter.getShooterEncoderRPM()){
        if (m_vision.getHoopB() == 1) {
          m_led.setAll(Color.kTurquoise);
        } else if (m_shooter.required_rpm - 10 < m_shooter.getShooterEncoderRPM()
        && m_shooter.required_rpm + 10 > m_shooter.getShooterEncoderRPM()) {
          if (m_vision.getHoopB() == 1) {
            m_led.setAll(Color.kViolet);
          }
          else {
            m_led.setAll(Color.kYellow);
          }
        }
      } else {
        m_led.setAll(Color.kRed);
        Timer.delay(0.1);
        m_led.setAll(Color.kBlack);
        Timer.delay(0.1);
      }
    }
  }

  @Override
  public void end(boolean interrupted) {
    m_led.setAll(Color.kWhite);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
