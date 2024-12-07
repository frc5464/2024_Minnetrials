package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class DriveSubsystem {
    
    CANSparkMax frontLeft = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax backLeft = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax backRight = new CANSparkMax(5, MotorType.kBrushless);

    public void crawl(double Axi2, double Axi6){
        double maxSpeed = 0.7;
        frontLeft.set(Axi2*maxSpeed);
        backLeft.set(Axi2*maxSpeed);
        frontRight.set(Axi6*maxSpeed);
        backRight.set(Axi6*maxSpeed);
    }
}