package org.runejs.client.scene;

import org.runejs.client.scene.camera.CameraRotation;

/**
 * A class to hold the precomputed tile visibility information.
 */
public class CameraTileVisibility {
    private int viewportWidth;
    private int viewportWidthMidpoint;
    private int viewportHeight;
    private int viewportHeightMidpoint;

    private int drawDistance;

    public final boolean[][][][] visibilityInfo;

    public CameraTileVisibility(int viewportWidth, int viewportHeight, int drawDistance, int minHeight, int maxHeight, int[] heightsForPitch) {
        this.viewportWidth = viewportWidth;
        this.viewportHeight = viewportHeight;
        this.viewportWidthMidpoint = viewportWidth / 2;
        this.viewportHeightMidpoint = viewportHeight / 2;

        this.drawDistance = drawDistance;

        visibilityInfo = new boolean[8][32][(drawDistance * 2) + 1][(drawDistance * 2) + 1];

        this.computeTileVisibilityMaps(minHeight, maxHeight, heightsForPitch);
    }

    /**
     * Precomputes visibility information for the game world's tiles based on possible camera positions and orientations.
     *
     * This helps to quickly determine which tiles need to be rendered based on the camera's current position and orientation.
     *
     * It then interpolates this data, ensuring that the nearby tiles around visible tiles are also visible.
     * This interpolation helps to prevent sudden changes in tile visiblity as the camera moves or rotates.
     *
     * @param minHeight The minimum height to check for visibility.
     * @param maxHeight The maximum height to check for visibility.
     * @param width The width of the viewport.
     * @param height The height of the viewport.
     * @param arg0 An array containing height values for each camera pitch angle.
     */
    private void computeTileVisibilityMaps(int minHeight, int maxHeight, int[] arg0) {
        final int cameraAngles = 9;
        final int rotationsPerCircle = 32;

        boolean[][][][] visibilityMaps = new boolean[cameraAngles][rotationsPerCircle][(this.drawDistance * 2) + 3][(this.drawDistance * 2) + 3];

        // Iterating over different camera pitch angles (from 128 to 384)
        for (int pitch = 128; pitch <= 384; pitch += 32) {
            // Iterating over different camera yaw angles (from 0 to 2048)
            for (int yaw = 0; yaw < 2048; yaw += 64) {
                CameraRotation camera = new CameraRotation(yaw, pitch);

                int pitchIndex = (pitch - 128) / 32;
                int yawIndex = yaw / 64;

                // Iterating over different tile positions around the camera
                for (int tileX = -26; tileX <= 26; tileX++) {
                    for (int tileY = -26; tileY <= 26; tileY++) {
                        int absoluteTileX = tileX * 128;
                        int absoluteTileY = tileY * 128;
                        boolean isVisible = false;

                        // Checking visibility at different heights
                        for (int h = -minHeight; h <= maxHeight; h += 128) {
                            if (isPointVisibleOnScreen(absoluteTileX, arg0[pitchIndex] + h, absoluteTileY, camera)) {
                                isVisible = true;
                                break;
                            }
                        }
                        visibilityMaps[pitchIndex][yawIndex][tileX + this.drawDistance + 1][tileY + this.drawDistance + 1] = isVisible;
                    }
                }
            }
        }

        // smooth out any gaps in the visibility maps by checking adjacent values
        final int maxPitchIndex = 8;
        final int maxYawIndex = 32;

        for (int pitchIndex = 0; pitchIndex < maxPitchIndex; pitchIndex++) {
            for (int yawIndex = 0; yawIndex < maxYawIndex; yawIndex++) {
                for (int tileX = -this.drawDistance; tileX < this.drawDistance; tileX++) {
                    for (int tileY = -this.drawDistance; tileY < this.drawDistance; tileY++) {
                        boolean isVisible = false;

                        checkVisibility:
                        for (int xOffset = -1; xOffset <= 1; xOffset++) {
                            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                                // Check visibility at the current pitch and yaw, adjusted by the offset
                                if (visibilityMaps[pitchIndex][yawIndex][tileX + xOffset + this.drawDistance + 1][tileY + yOffset + this.drawDistance + 1]) {
                                    isVisible = true;
                                    break checkVisibility;
                                }
                                // Check visibility at the current pitch and next yaw, adjusted by the offset
                                if (visibilityMaps[pitchIndex][(yawIndex + 1) % 31][tileX + xOffset + this.drawDistance + 1][tileY + yOffset + this.drawDistance + 1]) {
                                    isVisible = true;
                                    break checkVisibility;
                                }
                                // Check visibility at the next pitch and current yaw, adjusted by the offset
                                if (visibilityMaps[pitchIndex + 1][yawIndex][tileX + xOffset + this.drawDistance + 1][tileY + yOffset + this.drawDistance + 1]) {
                                    isVisible = true;
                                    break checkVisibility;
                                }
                                // Check visibility at the next pitch and next yaw, adjusted by the offset
                                if (visibilityMaps[pitchIndex + 1][(yawIndex + 1) % 31][tileX + xOffset + this.drawDistance + 1][tileY + yOffset + this.drawDistance + 1]) {
                                    isVisible = true;
                                    break checkVisibility;
                                }
                            }
                        }
                        visibilityInfo[pitchIndex][yawIndex][tileX + this.drawDistance][tileY + this.drawDistance] = isVisible;
                    }
                }
            }
        }
    }

    /**
     * Checks if a point in 3D space projects onto the screen, after rotation and perspective transformation.
     *
     * @param x The x-coordinate of the point in 3D space.
     * @param y The y-coordinate of the point in 3D space.
     * @param z The z-coordinate of the point in 3D space.
     * @return Returns true if the projected point falls within the screen boundaries; otherwise false.
     */
    public boolean isPointVisibleOnScreen(int x, int y, int z, CameraRotation cameraRotation) {
        // Rotate around the X axis
        int rotatedX = z * cameraRotation.yawSine + x * cameraRotation.yawCosine >> 16;
        int rotatedZ = z * cameraRotation.yawCosine - x * cameraRotation.yawSine >> 16;

        // Rotate around the Y axis
        int rotatedY = y * cameraRotation.pitchSine + rotatedZ * cameraRotation.pitchCosine >> 16;
        int finalZ = y * cameraRotation.pitchCosine - rotatedZ * cameraRotation.pitchSine >> 16;

        // Check if the point is behind the near clipping plane (too close to the camera)
        if (rotatedY < 50/* || rotatedY > 3500*/) {
            return false;
        }

        // Apply perspective division and translate to screen space
        int screenX = this.viewportWidthMidpoint + (rotatedX << 9) / rotatedY;
        int screenY = this.viewportHeightMidpoint + (finalZ << 9) / rotatedY;

        // Check if the point is within the screen bounds
        return screenX >= 0 && screenX <= this.viewportWidth && screenY >= 0 && screenY <= this.viewportHeight;
    }
}
