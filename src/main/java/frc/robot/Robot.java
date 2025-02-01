package frc.robot;


import com.ctre.phoenix6.hardware.core.CoreTalonFX;
import com.ctre.phoenix6.controls.VelocityVoltage;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  //change drive motor with what you use.
  private CoreTalonFX fr = new CoreTalonFX(0);
  private CoreTalonFX fl = new CoreTalonFX(1);
  private CoreTalonFX br = new CoreTalonFX(2);
  private CoreTalonFX bl = new CoreTalonFX(3);

  public Robot() {
  }

  private void set_velocity(double velocity) {
    fr.setControl(new VelocityVoltage(velocity));
    fl.setControl(new VelocityVoltage(velocity));
    br.setControl(new VelocityVoltage(velocity));
    bl.setControl(new VelocityVoltage(velocity));
  }

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {}

  @Override
  public void disabledInit() {
    set_velocity(0);
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
