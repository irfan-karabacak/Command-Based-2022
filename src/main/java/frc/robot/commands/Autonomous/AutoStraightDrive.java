

package frc.robot.commands.Autonomous;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;


public class AutoStraightDrive extends PIDCommand {


  public AutoStraightDrive(DriveSubsystem m_drive, double meters) {
    super(
        new PIDController(Constants.PID.kP, Constants.PID.kI, Constants.PID.kD),
        () -> m_drive.getStraightDriveDistance(),
        () -> meters,
        output -> {
          m_drive.arcadeDrive(output, 0);
        });
        m_drive.resetEncoders();
  }


  @Override
  public boolean isFinished() {
    return getController().atSetpoint();
  }
}
