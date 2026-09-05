package org.runejs.client.scene;

import org.runejs.Configuration;
import org.runejs.client.Game;

/**
 * Temporary holding ground for camera code
 *
 * JKM will refactor this soon
 */
public class SceneCamera {
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
    public static int cameraVelocityZoom = 0;

    // camera effects, jitter etc

    public static boolean[] customCameraActive = new boolean[5];

    public static int[] customCameraJitter = new int[5];
    public static int[] customCameraTimer = new int[5];
    public static int[] customCameraFrequency = new int[5];
    public static int[] customCameraAmplitude = new int[5];

    /**
     * Set the maximum height of the player's surrounding terrain.
     *
     * Used to control the minimum allowed pitch. Higher number = camera forced higher up
     */
    public static void setMaxSurroundingTerrainHeight(int i_3_) {
        int i_9_ = i_3_ * 192;
        if (i_9_ > 383 * 256)
            i_9_ = 383 * 256;
        if (i_9_ < minimumPitch() * 256)
            i_9_ = minimumPitch() * 256;
        if (cameraTerrainMinScaledPitch < i_9_) {
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 24;
        } else if (cameraTerrainMinScaledPitch > i_9_)
            cameraTerrainMinScaledPitch += (-cameraTerrainMinScaledPitch + i_9_) / 80;
    }

    public static int getClampedPitch(int pitch) {
        if (pitch < minimumPitch())
            return minimumPitch();
        if (pitch > 383)
            return 383;
        return pitch;
    }

    /**
     * The flattest the camera may look. The software renderer's tile visibility tables start at 128; only the GPU
     * renderer, which draws the whole region and beyond, can go lower, by {@code gpu.minPitch} in the config.
     */
    public static int minimumPitch() {
        if (Game.sceneRenderer != null && Game.sceneRenderer.isGpu()) {
            return Math.max(1, Math.min(128, Configuration.GPU_MIN_PITCH));
        }
        return 128;
    }
}
