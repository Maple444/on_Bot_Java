public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        
        // Everything here is from our practice in FTC SIM
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
