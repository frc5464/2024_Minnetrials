package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class RotationSubsystem {
    
    //Talon rotation = new Talon(0);
    CANSparkMax leftrot = new CANSparkMax(6, MotorType.kBrushless);
    CANSparkMax rightrot = new CANSparkMax(7,MotorType.kBrushless);

    public void rotArmUp(){
        leftrot.set(0.5);
        rightrot.set(0.5);
    }

    public void rotArmDowners(){
        leftrot.set(-0.5);
        rightrot.set(-0.5);
    }

    public void stopArm(){
        leftrot.set(0);
        rightrot.set(0);
    }

}
