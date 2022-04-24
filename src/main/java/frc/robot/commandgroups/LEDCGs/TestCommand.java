// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandgroups.LEDCGs;

import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.LEDSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class DenemeBalls extends SequentialCommandGroup {
  LEDSubsystem m_led;

  public DenemeBalls(LEDSubsystem m_led) {
    this.m_led = m_led;
    Color sRed = Color.kMediumVioletRed;
    Color sYellow = Color.kYellow;
    Color sWhite = Color.kWhiteSmoke;
    addCommands(
        new RunCommand(() -> m_led.setOne(0, sRed), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(1, sYellow), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(2, sWhite), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(3, sRed), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(4, sYellow), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(5, sWhite), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(6, sRed), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(7, sYellow), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(8, sWhite), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(9, sRed), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(10, sYellow), m_led).withTimeout(0.05),
        new RunCommand(() -> m_led.setOne(11, sRed), m_led).withTimeout(0.05));
  }

  @Override
  public void end(boolean interrupted) {
    super.end(interrupted);
    m_led.turnOff();
  }
}
