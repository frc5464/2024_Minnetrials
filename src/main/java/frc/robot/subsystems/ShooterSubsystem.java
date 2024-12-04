package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.motorcontrol.Talon;

public class ShooterSubsystem {
    
    //Talon shooter = new Talon(0);
    CANSparkMax shootmotor = new CANSparkMax(8, MotorType.kBrushed);
    

    public void shootshooter(){
        shootmotor.set(1);
        

    }

    public void intakeshooter(){
        shootmotor.set(-1);
        
    }

    public void stopshooter(){
        shootmotor.set(0);
        
    }




}
