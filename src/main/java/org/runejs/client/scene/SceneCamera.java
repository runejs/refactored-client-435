package org.runejs.client.scene;

import org.runejs.client.media.renderable.Model;

/**
 * Temporary holding ground for camera code
 *
 * JKM will refactor this soon
 */
public class SceneCamera {
    public static int cameraHorizontalRotation;
    public static int cameraVerticalRotation;
    public static int cameraZoom = 600;
    public static int cameraX;
    public static int cameraY;
    public static int cameraZ;

    /**
     * The minimum pitch for the camera, based on the surrounding terrain. Scaled up and must be
     * divided before comparing to pitches directly.
     *
     * Lifts the camera up when there are mountains around, etc.
     */
    public static int cameraTerrainMinScaledPitch = 0;

    // movement velocity of camera

    public static int cameraVelocityYaw = 0;
    public static int cameraVelocityPitch = 0;

    // positions that the camera is moving "towards" - why are these calculated separately and not just immediately applied?


    public static int cameraTargetX;
    public static int cameraTargetY;
    public static int cameraTargetYaw = 0;
    public static int cameraTargetPitch = 128;

    // camera effects, jitter etc

    public static boolean[] customCameraActive = new boolean[5];

    public static int[] customCameraJitter = new int[5];
    public static int[] customCameraTimer = new int[5];
    public static int[] customCameraFrequency = new int[5];
    public static int[] customCameraAmplitude = new int[5];

    public static void setCameraPosition(int pitch, int x, int z, int yaw, int y, int ___pitch, int arg6) {
        cameraHorizontalRotation = yaw;
        cameraVerticalRotation = pitch;

        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = arg6 + pitch * 3;
        if(pitchDifference != 0) {
            int cosine = Model.COSINE[pitchDifference];
            int sine = Model.SINE[pitchDifference];
            int temp = zOffset * cosine + -(sine * yOffset) >> 16;
            yOffset = cosine * yOffset + sine * zOffset >> 16;
            zOffset = temp;
        }
        if(yawDifference != 0) {
            int cosine = Model.COSINE[yawDifference];
            int sine = Model.SINE[yawDifference];
            int temp = cosine * xOffset + yOffset * sine >> 16;
            yOffset = -(xOffset * sine) + yOffset * cosine >> 16;
            xOffset = temp;
        }

        cameraX = -xOffset + x;
        cameraY = y + -yOffset;
        cameraZ = -zOffset + z;
    }

    /**
     * Set the maximum height of the player's surrounding terrain.
     *
     * Used to control the minimum allowed pitch. Higher number = camera forced higher up
     */
    public static void setMaxSurroundingTerrainHeight(int i_3_) {
        int i_9_ = i_3_ * 192;
        if (i_9_ > 98048)
            i_9_ = 98048;
        if (i_9_ < 32768)
            i_9_ = 32768;
        if (cameraTerrainMinScaledPitch < i_9_) {
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 24;
        } else if (cameraTerrainMinScaledPitch > i_9_)
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 80;
    }
}
