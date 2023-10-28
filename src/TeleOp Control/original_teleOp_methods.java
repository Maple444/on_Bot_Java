// TankDriveTeleOp10-28-23.java
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/* This file is meant to store the original editions of all teleOP files. The code in this
 * file itself likely cannot be run due to reported issues with the left and right drive
 * code for tank drive causes issues when stored in the same file. This is why there are 
 * separate files for each.
 */

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


        // If the program is active
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
                telemetry.update();
            }
        }
    }


    // General movement methods
    private void leftDrive() {
        if (gamepad1.left_stick_y) {
            BackLeft.setPower(gamepad1.left_stick_y);
            TopLeft.setPower(gamepad1.left_stick_y);
            BackRight.setPower(gamepad1.right_stick_y);
            TopRight.setPower(gamepad1.right_stick_y);
        }
    }

    private void rightDrive() {
        if (gamepad1.left_stick_y) {
            BackLeft.setPower(gamepad1.left_stick_y);
            TopLeft.setPower(gamepad1.left_stick_y);
            BackRight.setPower(gamepad1.right_stick_y);
            TopRight.setPower(gamepad1.right_stick_y);
        }
    }

    
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



// Not completely sure why this code is commented out. Left alone until further notice.


// TeleOP.java (#2)
// package org.firstinspires.ftc.teamcode;
// 
// import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
// import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
// import com.qualcomm.robotcore.hardware.DcMotor;
// 
// @TeleOp(name = "TeleOP (Blocks to Java)", group = "private void StrafeLeft(){        BackLeft.setPower(1);   TopLeft.setPower(-1);   BackRight.setPower(-1);   TopRight.setPower(1);       }  private void StrafeRight(){           BackLeft.setPower(-1);   TopLeft.setPower(1);   BackRight.setPower(1);   TopRight.setPower(-1);       }")
// public class TeleOP extends LinearOpMode {
// 
//   private DcMotor BackRight;
//   private DcMotor BackLeft;
//   private DcMotor TopLeft;
//   private DcMotor TopRight;
// 
//   /**
//    * This function is executed when this OpMode is selected from the Driver Station.
//    */
//   @Override
//   public void runOpMode() {
//     BackRight = hardwareMap.get(DcMotor.class, "BackRight");
//     BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
//     TopLeft = hardwareMap.get(DcMotor.class, "TopLeft");
//     TopRight = hardwareMap.get(DcMotor.class, "TopRight");
// 
//     BackRight.setDirection(DcMotor.Direction.REVERSE);
//     // Put initialization blocks here.
//     waitForStart();
//     if (opModeIsActive()) {
//       // Put run blocks here.
//       while (opModeIsActive()) {
//         // Put loop blocks here.
//         BackLeft.setPower(gamepad1.right_stick_y);
//         BackRight.setPower(gamepad1.right_stick_y);
//         TopLeft.setPower(gamepad1.left_stick_y);
//         TopRight.setPower(gamepad1.left_stick_y);
//         telemetry.update();
//       }
//     }
//   }
// 
//   /**
//    * Describe this function...
//    */
//   private void StrafeLeft() {
//     BackLeft.setPower(1);
//   }
//   private void StrafeRight();
// }
// 
