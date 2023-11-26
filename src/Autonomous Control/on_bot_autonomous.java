package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;

@Autonomous(name="autonomous")
public class AutonomousAttempt extends LinearOpMode {

    private DcMotor backLeft;
    private DcMotor backRight;
    private Blinker control_Hub;
    private Blinker expansion_Hub_6;
    private DcMotor intake;
    private DcMotor lift;
    private DcMotor topLeft;
    private DcMotor topRight;
    private Gyroscope imu;

    // Stops all movement for movement methods that are below it.
    private void end() {
        topLeft.setPower(0);
        topRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    // Note: The time parameter defines how long the method will run.
    
    // Intake methods (complete)
    private void intakeOut(int time) {
        intake.setPower(1);
        sleep(time);
        end();
    }

    private void intakeIn(int time) {
        intake.setPower(-1);
        sleep(time);
        end();
    } 

    // Straight line movement (complete)
    private void moveForward(int time) {
        topLeft.setPower(0.5);
        topRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
        
        sleep(time);
        end();
    }

    private void moveBackwards(int time) {
        topLeft.setPower(-0.5);
        topRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(-0.5);
        
        sleep(time);
        end();
    }

    // Turning (needs work)
    private void turnRight(int time) {
        topLeft.setPower(-0.5);
        topRight.setPower(0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(0.5);
        
        sleep(time);
        end();
    } 

    private void turnLeft(int time) {
        topLeft.setPower(0.5);
        topRight.setPower(-0.5);
        backLeft.setPower(0.5);
        backRight.setPower(-0.5);

        sleep(time);
        end();
    } 

    // Strafing (needs work)
    private void strafeLeft(int time) {
        topLeft.setPower(-0.5);
        topRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(-0.5);

        sleep(time);
        end();
    }

    private void strafeRight(int time){
        topLeft.setPower(0.5);
        topRight.setPower(-0.5);
        backLeft.setPower(-0.5);
        backRight.setPower(0.5);

        sleep(time);
        end();
    }

    // Lift (not used on robot currently)
    private void liftUp(int time){
        lift.setPower(0.5);
        sleep(time);
        end();
    }

    private void liftDown(int time){
        lift.setPower(-0.5);
        sleep(time);
        end();
    }
  

    @Override
    // Run method
    public void runOpMode() {
        lift = hardwareMap.get(DcMotor.class, "Lift");
        topRight = hardwareMap.get(DcMotor.class, "TopRight");
        backRight = hardwareMap.get(DcMotor.class, "BackRight");
        topLeft = hardwareMap.get(DcMotor.class, "TopLeft");
        backLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        intake = hardwareMap.get(DcMotor.class, "Intake");

        // Put initialization blocks here.
        waitForStart();
        topRight.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        if (opModeIsActive()) {
            // Put run blocks here.
            /* Below code is just testing. 4 second starting delay, 
             * 2 second delay between movements. */
            sleep(4000);
            moveForward(1000);
            
            sleep(2000);
            turnLeft(940);
            
            sleep(2000);
            turnRight(940);
            
            sleep(2000);
            moveForward(1000);
            
            sleep(2000);
            turnRight(940);

            sleep(2000);
            strafeLeft(1000);
            
            sleep(2000);
            strafeRight(1000);
            
            /* sleep(2000);
            intakeIn(500);
            
            sleep(2000);
            intakeOut(500); */
        }
    }
}