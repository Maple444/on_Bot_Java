public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        

        /* Everything here is from our practice in FTC SIM *courses*. These are not our current functions 
         The purpose of this file is for us to have something to go back to and identify root problems in code 
         or restart from scratch in creating a certain method. */


        // Method where everything runs in FTC SIM. Included. We don't fully understand how this works yet.
        public class MyFIRSTJavaOpMode extends LinearOpMode {
            DcMotor motorLeft;
            DcMotor motorRight;
            DcMotor frontLeft;
            DcMotor frontRight;
            ColorSensor color1;
            DistanceSensor distance1;
            BNO055IMU imu;
        
            // MOVEMENT METHODS (written by the team) 
              public void moveForward() {
                  frontLeft.setDirection(DcMotor.Direction.REVERSE);
                  motorLeft.setDirection(DcMotor.Direction.REVERSE);
                  
                  motorLeft.setPower(1);
                  frontLeft.setPower(1);
                  motorRight.setPower(1);
                  frontRight.setPower(1);
              }
                
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

              public void turnRight() {
                  frontLeft.setDirection(DcMotor.Direction.REVERSE);
                  motorLeft.setDirection(DcMotor.Direction.REVERSE);
                  
                  motorLeft.setPower(0.5);
                  frontLeft.setPower(0.5);
                  motorRight.setPower(-0.5);
                  frontRight.setPower(-0.5);
                  sleep(240);
                  
                  motorLeft.setPower(0);
                  frontLeft.setPower(0);
                  motorRight.setPower(0);
                  frontRight.setPower(0);
              }
              
        @Override
            // The run method of the FTC Java file.
            public void runOpMode() {
              motorLeft = hardwareMap.get(DcMotor.class, "motorLeft");
              motorRight = hardwareMap.get(DcMotor.class, "motorRight");
              frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
              frontRight = hardwareMap.get(DcMotor.class, "frontRight");
              color1 = hardwareMap.get(ColorSensor.class, "color1"); // Sensors. We don't understand these yet from our practice with FTC SIM.
              distance1 = hardwareMap.get(DistanceSensor.class, "distance1"); 
              imu = hardwareMap.get(BNO055IMU.class, "imu");
              
              // Movement method calls for testing. You can ignore these, but this is how they'd be called.
              turnRight();
              turnRight();
              moveForward();
            }  
        }
    }
}
