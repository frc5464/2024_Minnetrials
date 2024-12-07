package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotationSubsystem {
    
    public void init(){
        leftRelativeEncoder = leftrot.getEncoder();
    }

    //Talon rotation = new Talon(0);
    CANSparkMax leftrot = new CANSparkMax(6, MotorType.kBrushless);
    CANSparkMax rightrot = new CANSparkMax(7,MotorType.kBrushless);

    RelativeEncoder leftRelativeEncoder;
    public double encoderPos;
    public void periodic(){
        encoderPos = leftRelativeEncoder.getPosition();
        SmartDashboard.putNumber("Encoder", encoderPos);
    }

    public void rotArmUp(){
        leftrot.set(0.3);
        rightrot.set(0.3);
    }

    public void rotArmDowners(){
        leftrot.set(-0.3);
        rightrot.set(-0.3);
    }

    public void moveArm(double speed){
        if(Math.abs(speed) < 0.1){
            speed = 0;
        }
        double maxSpeed = 0.304;
        leftrot.set(speed * maxSpeed);
        rightrot.set(speed * maxSpeed);        
    }

    public void stopArm(){
        leftrot.set(0);
        rightrot.set(0);
    }

    // public void rotArmBoth(double Axis1, double Axis5){
    //     leftrot.set(Axis1);
    //     rightrot.set(Axis1);
    //     leftrot.set(Axis5);
    //     rightrot.set(Axis5);
    // }
}
