package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Blinker;
import com.qualcomm.robotcore.hardware.Gyroscope;

@Autonomous(name="shakursautonomous")
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

    private void moveForward(int time) {
        topLeft.setPower(0.5);
        topRight.setPower(0.5);
        backLeft.setPower(0.5);
        backRight.setPower(0.5);
        
        sleep(time);
        end();
    }

    private void moveBackwards(int time) {
        topLeft.setPower(-1);
        topRight.setPower(-1);
        backLeft.setPower(-1);
        backRight.setPower(-1);
        
        sleep(time);
        end();
    }

    private void turnRight(int time) {
        topLeft.setPower(-1);
        topRight.setPower(1);
        backLeft.setPower(-1);
        backRight.setPower(1);
        
        sleep(time);
        end();
    } 

    private void turnLeft(int time) {
        topLeft.setPower(1);
        topRight.setPower(-1);
        backLeft.setPower(1);
        backRight.setPower(-1);

        sleep(time);
        end();
    } 

    private void strafeLeft(int time) {
        topLeft.setPower(-1);
        topRight.setPower(1);
        backLeft.setPower(1);
        backRight.setPower(-1);

        sleep(time);
        end();
    }

    private void strafeRight(int time){
        topLeft.setPower(1);
        topRight.setPower(-1);
        backLeft.setPower(-1);
        backRight.setPower(1);

        sleep(time);
        end();
    }

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
            moveForward(1000);
            turnLeft(940);
            turnRight(940);
            moveForward(1000);
            turnRight(940);
            intakeIn(500);
            intakeOut(500);
        }
    }
} 
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        

        /* Everything here is from the code used DIRECTLY ON THE ROBOT. The purpose of this file is for us to have 
         * an up to date reference for all methods we are using on the robot. This file is forked from the 
         * current_methods_ftcsim.java file, but has additions and changes for use with the actual robot. */


        // Method where everything runs in FTC SIM. Included. We don't fully understand how this works yet.
        public class MyFIRSTJavaOpMode extends LinearOpMode {
            CRServo leftWheel;
            CRServo rightWheel;
            DcMotor backLeftDrive;
            DcMotor backRightDrive;
            DcMotor frontLeftDrive;
            DcMotor frontRightDrive;
            DcMotor wrist;
            DcMotor leftShoulder;
            DcMotor rightShoulder;
            BNO055IMU imu;
        
            
            // MOVEMENT METHODS (written by the team) 

              /* This moveForward function works for 4 wheel drive robots, which is ours. The original moveForward() only
               * works with the 2 motor robot in the practice simulations.
              */

            public void moveForward(int moveTime) {
              // Note: The parameter is for how long the robot should move forward.
              backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              backRightDrive.setDirection(DcMotor.Direction.FORWARD);
              frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
              
              backLeftDrive.setPower(-1);
              backRightDrive.setPower(1);
              frontLeftDrive.setPower(-1);
              frontRightDrive.setPower(1);
                
              sleep(moveTime);
                
              backLeftDrive.setPower(0);
              backRightDrive.setPower(0);
              frontLeftDrive.setPower(0); 
              frontRightDrive.setPower(0);
            }
              
              // Turning methods 
            public void turnLeft(int turnTime) {
              backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              backRightDrive.setDirection(DcMotor.Direction.REVERSE);
              frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
              
              frontLeftDrive.setPower(0.5);
              backLeftDrive.setPower(0.5);
              frontRightDrive.setPower(-0.5);
              backRightDrive.setPower(-0.5);
                
              /* The time needed to turn 90 degrees in FTC SIM is 940.
               * miliseconds. This is what is the normal value for the 
               * turnTime parameter. */
              sleep(turnTime);
                          
              frontLeftDrive.setPower(0);
              backLeftDrive.setPower(0);
              frontRightDrive.setPower(0);
              backRightDrive.setPower(0);
            }

            public void turnRight(int turnTime) {
              backLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              backRightDrive.setDirection(DcMotor.Direction.REVERSE);
              frontLeftDrive.setDirection(DcMotor.Direction.FORWARD);
              frontRightDrive.setDirection(DcMotor.Direction.REVERSE);
                
              frontLeftDrive.setPower(-0.5);
              backLeftDrive.setPower(-0.5);
              frontRightDrive.setPower(0.5);
              backRightDrive.setPower(0.5);
                
              /* The time needed to turn 90 degrees in FTC SIM is 940.
               * miliseconds. This is what is the normal value for the 
               * turnTime parameter. */
              sleep(turnTime);
                          
              frontLeftDrive.setPower(0);
              backLeftDrive.setPower(0);
              frontRightDrive.setPower(0);
              backRightDrive.setPower(0);
            }

            // Strafing methods (10/19/23). 
            /* These help the robot move side to side using the mechanum wheels. They are currently set as private methods, 
             * as this is how they were originally. This could be changed in the future. */
            private void StrafeLeft() {
              BackLeft.setPower(1);
              TopLeft.setPower(-1);
              BackRight.setPower(-1);
              TopRight.setPower(1);
            }

            private void StrafeRight() {
              BackLeft.setPower(-1);
              TopLeft.setPower(1);
              BackRight.setPower(1);
              TopRight.setPower(-1);
            }


        @Override
            // The run method of the FTC Java file.
            public void runOpMode() {
              leftWheel = hardwareMap.get(CRServo.class, "leftWheel");
              rightWheel = hardwareMap.get(CRServo.class, "rightWheel");
              backLeftDrive = hardwareMap.get(DcMotor.class, "backLeftDrive");
              backRightDrive = hardwareMap.get(DcMotor.class, "backRightDrive");
              frontLeftDrive = hardwareMap.get(DcMotor.class, "frontLeftDrive");
              frontRightDrive = hardwareMap.get(DcMotor.class, "frontRightDrive");
              wrist = hardwareMap.get(DcMotor.class, "wrist");
              leftShoulder = hardwareMap.get(DcMotor.class, "leftShoulder");
              rightShoulder = hardwareMap.get(DcMotor.class, "rightShoulder");
              imu = hardwareMap.get(BNO055IMU.class, "imu"); // Sensors. We don't understand how these work yet.
              
              // Movement method calls for testing. You can ignore these, but this is how they'd be called.
              moveForward(1200);
              turnRight(940);
            }
        }
    }
}