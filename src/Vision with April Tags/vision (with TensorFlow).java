package org.firstinspires.ftc.teamcode;

import android.util.Size;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;
import org.firstinspires.ftc.vision.tfod.TfodProcessor;

import java.util.List;


/* This file stores code for computer vision and april tag functionality. Currently, it generates telemetry data using the Logitech
 * C270 HD camera and april tag processing. Be sure to use with official 2023-2024 FTC CENTERSTAGE april tags for correct functionality.
 * Link to CENTERSTAGE april tags PDF: https://firstinspiresst01.blob.core.windows.net/first-in-show-ftc/apriltag-us-letter.pdf */

/* Make sure you have FTC robot controller and its files  open in Android Studio. This code was written in VScode and transferred
 * to Android Studio.=*/

@TeleOp
public class Vision extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        // ~~~~~ Put current code here (Initialization and methods)
        // INITIALIZATIONS
        WebcamName camera = hardwareMap.get(WebcamName.class, "Webcam 1");
        // VisionPortal visionPortal = VisionPortal.easyCreateWithDefaults(camera, visionProcessors); // Error with 2nd parameter. May not be needed.

        // TensorFlow Processor **
        TfodProcessor tfodProcessor = TfodProcessor.easyCreateWithDefaults();
        // Creates VisionPortal using TensorFlow processor
        VisionPortal visionPortalTF = VisionPortal.easyCreateWithDefaults(camera, tfodProcessor);

        // April tag processor
        AprilTagProcessor aprilTagProcessor = AprilTagProcessor.easyCreateWithDefaults();
        // Create VisionPortal with April Tag Processor
        VisionPortal visionPortalAT = VisionPortal.easyCreateWithDefaults(camera, aprilTagProcessor);

        /* ****APRIL TAG TELEMETRY (OLD CODE)
        // April tag processing
        AprilTagProcessor tagProcessor = new AprilTagProcessor.Builder()
                // Sets up the april tag functionality for the driver hub FTC software
                .setDrawAxes(true)
                .setDrawCubeProjection(true)
                .setDrawTagID(true)
                .setDrawTagOutline(true)
                .build();

        VisionPortal visionPortal = new VisionPortal.Builder()
                .addProcessor(tagProcessor)
                .setCamera(hardwareMap.get(WebcamName.class, "Webcam 1"))
                .setCameraResolution(new Size(640, 480))
                .build();
         */

        waitForStart();


        // Running opMode
        while (!isStopRequested() && opModeIsActive()) {
            // ~~~~ Put current code here

            /* ***VisionPortal management code (unimportant) */
            // Set current frame rate to estimate CPU load
            float fps = visionPortalTF.getFps();
            /* Disable features to manage CPU load
            visionPortal.setProcessorEnabled(visionProcessor, false);
            visionPortal.stopLiveView();
            visionPortal.stopSteaming();
            */

            /* Close VisionPortal to stop everything
            visionPortal.close();
            */

            // *** TENSORFLOW
            // Get recognized objects from TensorFlow
            List<Recognition> recognitions = tfodProcessor.getRecognitions();

            // Iterate through each recognized object in the List
            for (Recognition recognition : recognitions)
            {
                // Get label of this recognized object
                String label = recognition.getLabel();

                // Get label of this recognized object
                float confidence = recognition.getConfidence();

                // Add this label and confidence to the telemetry. Most important data from objects.
                telemetry.addLine("Recognized object: " + label);
                // Note: Confidence is how likely an object is correct identified by the code.
                telemetry.addLine("Confidence: " + confidence);

            }

            // *** APRIL TAGS


            /* ****Also part of april tag telemetry
            if (tagProcessor.getDetections().size() > 0) {
                AprilTagDetection tag = tagProcessor.getDetections().get(0);

                // Telemetry data is stored using the below:
                telemetry.addData("x", tag.ftcPose.x);
                telemetry.addData("y", tag.ftcPose.y);
                telemetry.addData("z", tag.ftcPose.z);
                telemetry.addData("roll", tag.ftcPose.roll);
                telemetry.addData("pitch", tag.ftcPose.pitch);
                telemetry.addData("yaw", tag.ftcPose.yaw);
            }

            telemetry.update();
             */

        }
    }
}