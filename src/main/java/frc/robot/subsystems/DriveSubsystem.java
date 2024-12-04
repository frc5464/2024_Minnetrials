package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveSubsystem {
    
    CANSparkMax frontLeft = new CANSparkMax(2, MotorType.kBrushless);
    CANSparkMax frontRight = new CANSparkMax(3, MotorType.kBrushless);
    CANSparkMax backLeft = new CANSparkMax(4, MotorType.kBrushless);
    CANSparkMax backRight = new CANSparkMax(5, MotorType.kBrushless);

    public void crawl(double Axi2, double Axi6){
        frontLeft.set(Axi2);
        backLeft.set(Axi2);
        frontRight.set(Axi6);
        backRight.set(Axi6);
    }
}