package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.Commands.*;
import frc.robot.Subsystems.*;

public class RobotContainer 
{
	private final Joystick m_controller = new Joystick(Constants.DrivetrainConstants.controller_port);
	private final Joystick m_testcontroller = new Joystick(1);
	private final DrivetrainSubsystem m_drivetrain = new DrivetrainSubsystem();
	private final ElevatorSubsystem m_elevator = new ElevatorSubsystem();
	private final WristSubsystem m_wrist = new WristSubsystem();
	private final ManipulatorSubsystem m_manipulatorSubsystem = new ManipulatorSubsystem();

	public RobotContainer() 
	{
		configureBindings();
	}

	private void configureBindings() 
	{
		m_drivetrain.setDefaultCommand(
			new driveArcade(() -> m_controller.getY(), () -> m_controller.getX(), m_drivetrain));

		//  m_elevator.setDefaultCommand(
		// 	new ElevatorMindCommand(() -> m_controller.getPOV(), () -> m_controller.getRawButtonPressed(3), () -> m_controller.getRawButton(4), m_elevator, m_wrist));

		m_elevator.setDefaultCommand(
			new moveElevatorCommand(() -> m_testcontroller.getY(), m_elevator));

		m_wrist.setDefaultCommand(
			new moveWristCommand(() -> m_testcontroller.getX(), m_wrist));
	}

	public Command getAutonomousCommand() 
	{
		return Commands.print("No autonomous command configured");
	}
}
