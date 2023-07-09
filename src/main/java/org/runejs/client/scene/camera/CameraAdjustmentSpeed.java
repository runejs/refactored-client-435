package org.runejs.client.scene.camera;

/**
 * Represents the speed at which the camera turns or moves.
 */
public class CameraAdjustmentSpeed {
    /**
     * The base step movement value
     */
    public final int base;

    /**
     * The scaling step movement value
     *
     * Multiplies the difference between the current and target position.
     */
    public final int scale;

    public CameraAdjustmentSpeed(int base, int scale) {
        this.base = base;
        this.scale = scale;
    }
}
