// TankDriveTeleOpRight10-28-23.java
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/* This file is solely to prevent glitches that can occur as a result of having the
 * moveForward() and moveBackward() functions in the same file */ 

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
                
                rightDrive();
                telemetry.update();
            }
        }
    }


    // The backward method
    private void rightDrive() {
        if (gamepad1.right_stick_y) {
            BackLeft.setPower(gamepad1.left_stick_y);
            TopLeft.setPower(gamepad1.left_stick_y);
            BackRight.setPower(gamepad1.right_stick_y);
            TopRight.setPower(gamepad1.right_stick_y);
        }
    }
}