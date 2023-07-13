package org.runejs.client.scene;

import org.runejs.client.scene.camera.Camera;

public class Util3d {
    /**
     * Applies the camera's yaw and pitch rotation to a point in 3D space.
     * If the y-coordinate of the rotated point is less than 50, the function returns null,
     * indicating that the point should not be processed further.
     *
     * @param x The x-coordinate of a point.
     * @param y The y-coordinate of a point.
     * @param z The z-coordinate of a point.
     * @param currentCamera The camera object with rotation (yaw and pitch) information.
     * @return An array of three integers representing the transformed x, y, z coordinates,
     *         or null if the y-coordinate of the rotated point is less than 50.
     */
    public static int[] getProjectedPoint(Camera camera, int x, int y, int z) {
        // Get the sine and cosine of the camera's yaw and pitch rotations
        int sinX = camera.getRotation().yawSine;
        int cosineX = camera.getRotation().yawCosine;
        int sinY = camera.getRotation().pitchSine;
        int cosineY = camera.getRotation().pitchCosine;

        // Apply the yaw rotation to the point
        int temp = (y * sinX + x * cosineX) >> 16;
        y = (y * cosineX - x * sinX) >> 16;
        x = temp;

        // Apply the pitch rotation to the point
        temp = (z * cosineY - y * sinY) >> 16;
        y = (z * sinY + y * cosineY) >> 16;
        z = temp;

        // If the y-coordinate of the rotated point is less than 50, return null
        if (y < 50) {
            return null;
        }

        // Return the transformed point
        return new int[]{x, y, z};
    }
}
