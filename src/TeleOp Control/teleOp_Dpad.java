package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// The file is currently called mainthingy.java on the robot's storage...?
@TeleOp(name = "MainThingy (Blocks to Java)")
public class MainThingy extends LinearOpMode {

    private DcMotor Lift;
    private DcMotor TopRight;
    private DcMotor BackRight;
    private DcMotor TopLeft;
    private DcMotor BackLeft;
    private DcMotor Intake;

    private void IntakeOut() {
        if (gamepad2.b) {
            Intake.setPower(1);
        } else {
            Intake.setPower(0);
        }
    }

    private void IntakeIn() {
        if (gamepad2.x) {
            Intake.setPower(-1);
        } else {
            Intake.setPower(0);
        }
    }

    private void DPadUp() {
        if (gamepad1.dpad_up) {
            TopLeft.setPower(1);
            TopRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(1);
        }
    }

    private void DPadBackwards() {
        if (gamepad1.dpad_down) {
            TopLeft.setPower(-1);
            TopRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(-1);
        }
    }

    private void DPadRight() {
        if (gamepad1.dpad_right) {
            TopLeft.setPower(-1);
            TopRight.setPower(1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void DPadLeft() {
        if (gamepad1.dpad_left) {
            TopLeft.setPower(1);
            TopRight.setPower(-1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeLeft() {
        if (gamepad1.x) {
            TopLeft.setPower(-1);
            TopRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeRight() {
        if (gamepad1.b) {
            TopLeft.setPower(1);
            TopRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void Diag1() {
        if (gamepad1.left_bumper) {
            TopRight.setPower(1);
            BackLeft.setPower(1);
        }
    }

    private void Diag2() {
        if (gamepad1.right_bumper) {
            TopLeft.setPower(1);
            BackRight.setPower(1);
        }
    }

    private void Diag3() {
        if (gamepad1.y) {
            TopLeft.setPower(-1);
            BackRight.setPower(-1);
        }
    }

    private void Diag4() {
        if (gamepad1.a) {
            TopRight.setPower(-1);
            BackLeft.setPower(-1);
        }
    }

    private void LiftUp() {
        if (gamepad2.y) {
            Lift.setPower(1);
        }
    }

    private void LiftDown() {
        if (gamepad2.a) {
            Lift.setPower(-1);
        }
    }

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    @Override
    public void runOpMode() {
        Lift = hardwareMap.get(DcMotor.class, "Lift");
        TopRight = hardwareMap.get(DcMotor.class, "TopRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        TopLeft = hardwareMap.get(DcMotor.class, "TopLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        Intake = hardwareMap.get(DcMotor.class, "Intake");

        // Put initialization blocks here.
        waitForStart();
        TopRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);

        if (opModeIsActive()) {
            // Put run blocks here.
            while (opModeIsActive()) {
                // Put loop blocks here
                LiftUp();
                LiftDown();
                IntakeIn();
                IntakeOut();
                DPadLeft();
                DPadRight();
                DPadUp();
                DPadBackwards();
                StrafeLeft();
                StrafeRight();
                Diag1();
                Diag2();
                Diag3();
                Diag4();
                TopRight.setPower(-gamepad1.right_stick_y);
                BackRight.setPower(-gamepad1.right_stick_y);
                TopLeft.setPower(-gamepad1.left_stick_y);
                BackLeft.setPower(-gamepad1.left_stick_y);
                telemetry.update();
                // Put loop blocks here.
                telemetry.update();
            }
        }
    }
}
