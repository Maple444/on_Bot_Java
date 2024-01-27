package org.firstinspires.ftc.teamcode.TeleOp;

import static org.firstinspires.ftc.onbotjava.OnBotJavaManager.initialize;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

// An experimental teleop file that is field oriented rather than robot oriented.
// Uses the embedded gyroscope.

@TeleOp
public class FieldOrientedDriving extends LinearOpMode {
    private DcMotor FrontLeft;
    private DcMotor FrontRight;
    private DcMotor BackLeft;
    private DcMotor BackRight;
    private DcMotor Lift;
private DcMotor Intake;
    private DcMotor Lift2;
    BNO055IMU imu;
    Orientation angles = new Orientation();


    double initYaw;
    double adjustedYaw;


    private void LiftUp() {
        if (gamepad2.dpad_up){
            Lift.setPower(1);
            Lift2.setPower(1);
        } else {
            Lift.setPower(0);
            Lift2.setPower(0);
        }
    }
    private void LiftDown() {
        if (gamepad2.dpad_down){
            Lift.setPower(-1);
            Lift2.setPower(-1);
        } else {
            Lift.setPower(0);
            Lift2.setPower(0);
        }
    }
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





    public void runOpMode()  {
        // Field oriented code. We don't understand how this works yet.
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;


        imu = hardwareMap.get(BNO055IMU.class, "imu");
        imu. initialize(parameters);


        angles = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);


        initYaw = angles.firstAngle;


        FrontLeft = hardwareMap.get(DcMotor.class, "FrontLeft");
        FrontRight = hardwareMap.get(DcMotor.class, "FrontRight");
        BackLeft = hardwareMap.get(DcMotor.class, "BackLeft");
        BackRight = hardwareMap.get(DcMotor.class, "BackRight");
        Lift = hardwareMap.get(DcMotor.class, "Lift");
        Lift2 = hardwareMap.get(DcMotor.class, "Lift2");
        Intake = hardwareMap.get(DcMotor.class, "Intake");
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);


        waitForStart();


        while (opModeIsActive()) {
            angles=imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

            adjustedYaw = angles.firstAngle-initYaw;
            double zerodYaw = -initYaw+angles.firstAngle;

            double x = gamepad1.left_stick_x;
            double y = -gamepad1.left_stick_y;
            double turn = gamepad1.right_stick_x;

            double theta = Math.atan2(y, x) * 180/Math.PI;
            double realTheta;
            realTheta = (360 - zerodYaw) + theta;
            double power = Math.hypot(x, y);

            double sin = Math.sin((realTheta * (Math.PI / 180)) - (Math.PI / 4));
            double cos = Math.cos((realTheta * (Math.PI / 180)) - (Math.PI / 4));
            double maxSinCos = Math.max((Math.abs(sin)), Math.abs(cos));

            double leftFront = (power * cos / maxSinCos + turn);
            double rightFront = (power * sin / maxSinCos - turn);
            double leftBack = (power * sin / maxSinCos + turn);
            double rightBack = (power * cos / maxSinCos - turn);


            if ((power + Math.abs(turn)) > 1) {
                leftFront /= power + turn;
                rightFront /= power - turn;
                leftBack /= power + turn;
                rightBack /= power - turn;
            }

            FrontLeft.setPower(leftFront);
            FrontRight.setPower(rightFront);
            BackLeft.setPower(leftBack);
            BackRight.setPower(rightBack);

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
            telemetry.update();
            // Put loop blocks here.
            telemetry.update();

            double power1 = FrontLeft.getPower();
            double power2 = FrontRight.getPower();
            double power3 = BackLeft.getPower();
            double power4 = BackRight.getPower();
            double Lift1Power = Lift.getPower();
            double Lift2Power = Lift2.getPower();
            double IntakePower = Intake.getPower();

            telemetry.addData("Front Left Power", power1);
            telemetry.addData("Front Right Power", power2);
            telemetry.addData("Back Left Power", power3);
            telemetry.addData("Back Right Power", power4);
            telemetry.addData("Lift 1 Power", Lift1Power);
            telemetry.addData("Lift 2 Power", Lift2Power);
            telemetry.addData("Intake Power(PROBABLY 0 LOL)", IntakePower);
        }
    }
}
