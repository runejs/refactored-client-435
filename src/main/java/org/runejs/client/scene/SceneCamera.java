package org.runejs.client.scene;

/**
 * Temporary holding ground for camera code
 *
 * JKM will refactor this soon
 */
public class SceneCamera {
    public static int cameraHorizontalRotation;
    public static int cameraVerticalRotation;
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

    // camera effects, jitter etc

    public static boolean[] customCameraActive = new boolean[5];

    public static int[] customCameraJitter = new int[5];
    public static int[] customCameraTimer = new int[5];
    public static int[] customCameraFrequency = new int[5];
    public static int[] customCameraAmplitude = new int[5];
}
