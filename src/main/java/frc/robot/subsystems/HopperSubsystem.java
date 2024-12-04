package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class HopperSubsystem {
    
    //Talon hopper = new Talon(0);
    CANSparkMax hoppermotor = new CANSparkMax(9, MotorType.kBrushed);

    public void shootHopper(){
        hoppermotor.set(-1);
    }

    public void reverseHopper(){
        hoppermotor.set(0.5);
    }

    public void stopHopper(){
        hoppermotor.set(0);
    }
}
