// TankDriveTeleOpLeft10-28-23.java
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/* This file contains most of the current teleOp methods. moveBackward()
 * is in a different function to prevent possible glitches from occuring. 
 * Many are directly from the OnBot Java program. */ 

@TeleOp(name = "TeleOP3 (Blocks to Java)")
public class TankTestTeleOp extends LinearOpMode {

    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor TopLeft;
    private DcMotor TopRight;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        TopLeft = hardwareMap.get(DcMotor.class, "TopLeft");
        TopRight = hardwareMap.get(DcMotor.class, "TopRight");
        // Below is also part of initialization
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        // Put initialization blocks here.
        waitForStart();


         // If the program is active...this runs. Put anything.
        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here.
                TopRight.setPower(gamepad1.right_stick_y);
                BackRight.setPower(gamepad1.right_stick_y);
                TopLeft.setPower(gamepad1.left_stick_y);
                BackLeft.setPower(gamepad1.left_stick_y);
                StrafeLeft();
                StrafeRight();
                leftDrive();
                telemetry.update();
            }
        }
    }


    // y-axis methods
    private void leftDrive() {
        if (gamepad1.left_stick_y) {
            BackLeft.setPower(gamepad1.left_stick_y);
            TopLeft.setPower(gamepad1.left_stick_y);
            BackRight.setPower(gamepad1.right_stick_y);
            TopRight.setPower(gamepad1.right_stick_y);
        }
    }

    // The rightDrive() function is in the teleOp2_backward.java file.
    
    // Strafing methods
    private void StrafeLeft() {
        if (gamepad1.x) {
            BackLeft.setPower(1);
            TopLeft.setPower(-1);
            BackRight.setPower(-1);
            TopRight.setPower(1);
        }
    }

    private void StrafeRight() {
        if (gamepad1.b) {
            BackLeft.setPower(-1);
            TopLeft.setPower(1);
            BackRight.setPower(1);
            TopRight.setPower(-1);
        }
    }
}
