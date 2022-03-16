package frc.robot.commandgroups.Autonomous.ThreeBalls;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commandgroups.AutoDriveWithHeading;
import frc.robot.commandgroups.Shoot;
import frc.robot.commandgroups.ShootAuto;
import frc.robot.commands.Autonomous.AutoAngleTurn;
import frc.robot.commands.Autonomous.TakeAim;
import frc.robot.commands.Feeder.FeederTurn;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class Blue31 extends SequentialCommandGroup {
  public Blue31(
      DriveSubsystem m_drive,
      FeederSubsystem m_feeder,
      IntakeSubsystem m_intake,
      ShooterSubsystem m_shooter,
      VisionSubsystem m_vision) {
    addCommands(
        new InstantCommand(() -> m_shooter.runShooter(0.7))
            .alongWith(
                new WaitCommand(0.3)
                    .andThen(new InstantCommand(() -> m_feeder.runFeeder(1)))
                    .andThen(new WaitCommand(0.5))
                    .andThen(
                        new InstantCommand(
                            new Runnable() {
                              @Override
                              public void run() {
                                m_feeder.stopFeeder();
                                m_shooter.stopShooter();
                              }
                            }))
                    .andThen(
                        new InstantCommand(() -> m_intake.runIntake(1))
                            .alongWith(new AutoDriveWithHeading(m_drive, 1, 180, false)))
                    .andThen(new AutoDriveWithHeading(m_drive, 2.5, 90, false))
                    .alongWith(
                        new FeederTurn(m_feeder, 1).withInterrupt(() -> m_feeder.getSwitchValue()))
                    .andThen(new AutoAngleTurn(m_drive, 60))
                    .andThen(new TakeAim(m_drive, m_vision))
                    .andThen(new ShootAuto(m_shooter, m_vision))
                    .alongWith(
                        new WaitCommand(0.5)
                            .andThen(new InstantCommand(() -> m_feeder.runFeeder(1))))));
  }
}
