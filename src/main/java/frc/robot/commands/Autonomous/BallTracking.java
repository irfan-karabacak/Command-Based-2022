package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class BallTracking extends PIDCommand {

  public BallTracking(DriveSubsystem m_drive, VisionSubsystem m_vision) {
    super(
        new PIDController(0, 0, 0),
        () -> m_vision.getBallR(),
        () -> 0,
        output -> {
          if (Math.abs(m_vision.getBallR()) > 10) {
            m_drive.arcadeDrive(0, output);
          }
        });
    addRequirements(m_drive, m_vision);
  }

  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
