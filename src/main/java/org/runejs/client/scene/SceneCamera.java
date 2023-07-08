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

    // camera effects, jitter etc

    public static boolean[] customCameraActive = new boolean[5];

    public static int[] customCameraJitter = new int[5];
    public static int[] customCameraTimer = new int[5];
    public static int[] customCameraFrequency = new int[5];
    public static int[] customCameraAmplitude = new int[5];
}
