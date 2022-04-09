package frc.robot.commandgroups.LEDCGs;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.LEDSubsystem;
import edu.wpi.first.wpilibj.util.Color;


public class Scorpions extends SequentialCommandGroup{
    LEDSubsystem m_led;
    Color sRed = new Color(192,41,47);
    Color sYellow = new Color(255,180,32);
    Color sWhite = new Color(255,255,255);

    public Scorpions(LEDSubsystem m_led){
        this.m_led = m_led;
        addCommands(
            new RunCommand(() -> m_led.DividThreeColorMode(sRed,sYellow,sWhite), m_led).withTimeout(0.05),
            new RunCommand(() -> m_led.DividThreeColorMode(sYellow,sWhite,sRed), m_led).withTimeout(0.05),
            new RunCommand(() -> m_led.DividThreeColorMode(sWhite,sRed,sYellow), m_led).withTimeout(0.05));
        }
    @Override
    public void end(boolean interrupted) {
        m_led.turnOff();
        super.end(interrupted);
      }
}
