package frc.robot;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public class open_autos {
    //change these values
    public static double max_velocity = 1; 
    public static double max_acceleration = 1;

    private static final TrapezoidProfile profile = new TrapezoidProfile(new TrapezoidProfile.Constraints(max_velocity, max_acceleration));

    public interface tank_function {
        public void drive(double speed, double turn_angle);
    }

    //all commands are for tank drive for now.
    public static Command move_forward(tank_function func, double distance, double t) {
        var current = new TrapezoidProfile.State();
        var goal = new TrapezoidProfile.State(distance, 0);
        var setpoint = profile.calculate(t, current, goal); 
        return Commands.runOnce(() -> {
            func.drive(setpoint.velocity, 0);
        });
    }

    //suppose robot initial pos: (6.6, 4) (blue side middle of a line)
    public static Command move_to_l1(tank_function func) { 
        return move_forward(func, 2, 2); //L1 pos: (5.23, 4.06)
    }

    //would they feed algae? anyways, something like this
    //bottom algae pos: (1.53, 2.2), top algae pos: (1.53, 5.9), middle pos: (1.53, 4)
    public static Command algae_bottom(tank_function func) {         return Commands.sequence(
            Commands.runOnce(() -> {
                var current = new TrapezoidProfile.State();
                var y = new TrapezoidProfile.State(2, 0);
                func.drive(profile.calculate(2, current, y).velocity, - Math.PI /2);
            }),
            Commands.runOnce(() -> {
                var current = new TrapezoidProfile.State();
                var x = new TrapezoidProfile.State(5, 0);
                func.drive(profile.calculate(5, current, x).velocity, Math.PI /2);
            })
        );
    }
}
