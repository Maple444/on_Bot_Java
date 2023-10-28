package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TeleOP3 (Blocks to Java)")
public class TankTestTeleOp extends LinearOpMode {

    private DcMotor BackRight;
    private DcMotor BackLeft;
    private DcMotor TopLeft;
    private DcMotor TopRight;
    private DcMotor Intake;

    /**
     * This function is executed when this OpMode is selected from the Driver Station.
     */
    
    @Override
    public void runOpMode() {
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        TopLeft = hardwareMap.get(DcMotor.class, "TopLeft");
        TopRight = hardwareMap.get(DcMotor.class, "TopRight");
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        TopLeft.setDirection(DcMotor.Direction.REVERSE);
        // Put initialization blocks here.
        waitForStart();
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
                MoveForwardDPad();
                TurnLeftDPad();
                TurnRightDPad();
                TurnBackwardsDPad();
                IntakeIn();
                IntakeOut();
                IntakeIn2();
                IntakeOut2();
                telemetry.update();
            }
        }
    }

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

    private void MoveForwardDPad() {
        if (gamepad1.dpad_up) {
            BackLeft.setPower(1);
            TopLeft.setPower(1);
            BackRight.setPower(1);
            TopRight.setPower(1);
        }
    }

    private void TurnLeftDPad() {
        if (gamepad1.dpad_left) {
            BackLeft.setPower(1);
            TopLeft.setPower(1);
            BackRight.setPower(-1);
            TopRight.setPower(-1);
        }
    }

    private void TurnRightDPad() {
        if (gamepad1.dpad_right) {
            BackLeft.setPower(-1);
            TopLeft.setPower(-1);
            BackRight.setPower(1);
            TopRight.setPower(1);
        }
    }

    private void TurnBackwardsDPad() {
        if (gamepad1.dpad_left) {
            BackLeft.setPower(-1);
            TopLeft.setPower(-1);
            BackRight.setPower(-1);
            TopRight.setPower(-1);
        }
    }

    private void IntakeIn() {
        if (gamepad1.y) {
            Intake.setPower(-1);
        } else {
            Intake.setPower(0);
        }
    }

    private void IntakeOut() {
        if (gamepad1.a) {
            Intake.setPower(0.5);
        } else {
            Intake.setPower(0);
        }
    }

    private void IntakeOut2() {
        if (gamepad2.a) {
            Intake.setPower(0.5);
        } else {
            Intake.setPower(0);
        }
    }

    private void IntakeIn2() {
        if (gamepad2.y) {
            Intake.setPower(-1);
        } else {
            Intake.setPower(0);
        }
    }
}