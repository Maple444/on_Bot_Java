package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

// The primary teleop file we use during our competition. Updated often.

@TeleOp(name = "MainThing Main")
public class MainThingy extends LinearOpMode {
    private DcMotor Lift;
    private DcMotor FrontRight;
    private DcMotor BackRight;
    private DcMotor FrontLeft;
    private DcMotor BackLeft;
    private DcMotor Intake;

    private DcMotor Lift2;
    private Servo IntakeServo;



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
            FrontLeft.setPower(1);
            FrontRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(1);

        }
    }

    private void DPadBackwards() {
        if (gamepad1.dpad_down) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(-1);

        }
    }

    private void DPadRight() {
        if (gamepad1.dpad_right) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void DPadLeft() {
        if (gamepad1.dpad_left) {
            FrontLeft.setPower(1);
            FrontRight.setPower(-1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeLeft() {
        if (gamepad1.left_stick_button) {
            FrontLeft.setPower(-1);
            FrontRight.setPower(1);
            BackLeft.setPower(1);
            BackRight.setPower(-1);
        }
    }

    private void StrafeRight() {
        if (gamepad1.right_stick_button) {
            FrontLeft.setPower(1);
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
            BackRight.setPower(1);
        }
    }

    private void Diag1() {
        if (gamepad1.left_bumper) {
            FrontRight.setPower(1);
            BackLeft.setPower(1);

        }
    }

    private void Diag2() {
        if (gamepad1.right_bumper) {
            FrontLeft.setPower(1);
            BackRight.setPower(1);
        }
    }

    private void Diag3() {
        if (gamepad1.y) {
            FrontLeft.setPower(-1);
            BackRight.setPower(-1);
        }
    }

    private void Diag4() {
        if (gamepad1.a) {
            FrontRight.setPower(-1);
            BackLeft.setPower(-1);
        }
    }

    private void LiftUp() {
        if (gamepad2.y) {
            Lift.setPower(-1);
            Lift2.setPower(-1);
        } else {
            Lift.setPower(0);
            Lift2.setPower(0);
        }
    }

    private void LiftDown() {
        if (gamepad2.a) {
            Lift.setPower(1);
            Lift2.setPower(1);
        } else {
            Lift.setPower(0);
            Lift.setPower(0);
        }
    }
private void IntakeUp() {
if (gamepad2.dpad_left) {
    IntakeServo.setPosition(1);
}
}
private void IntakeDown() {
        if (gamepad2.dpad_right) {
            IntakeServo.setPosition(0);
        }
}

    @Override
    public void runOpMode() {
        Lift = hardwareMap.get(DcMotor.class, "Lift");
        Lift2 = hardwareMap.get(DcMotor.class, "Lift2");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        IntakeServo = hardwareMap.get(Servo.class, "IntakeServo");
        // Put initialization blocks here.
        waitForStart();
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);


        if (opModeIsActive()) {
            // Put run blocks here.


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
                    IntakeDown();
                    IntakeUp();
                    FrontRight.setPower(-gamepad1.right_stick_y);
                    BackRight.setPower(-gamepad1.right_stick_y);
                    FrontLeft.setPower(-gamepad1.left_stick_y);
                    BackLeft.setPower(-gamepad1.left_stick_y);
                    telemetry.update();
                    // Put loop blocks here.
                    telemetry.update();

                    double power = FrontLeft.getPower();
                    double power2 = FrontRight.getPower();
                    double power3 = BackLeft.getPower();
                    double power4 = BackRight.getPower();
                    double Lift1Power = Lift.getPower();
                    double Lift2Power = Lift2.getPower();
                    double IntakePower = Intake.getPower();
                    double IntakePosition = IntakeServo.getPosition();
                    telemetry.addData("Front Left Power", power);
                    telemetry.addData("Front Right Power", power2);
                    telemetry.addData("Back Left Power", power3);
                    telemetry.addData("Back Right Power", power4);
                    telemetry.addData("Lift 1 Power", Lift1Power);
                    telemetry.addData("Lift 2 Power", Lift2Power);
                    telemetry.addData("Intake Power(PROBABLY 0 LOL)", IntakePower);
                    telemetry.addData("IntakeSPosition", IntakePosition);
                }
            }
        }
    }
}