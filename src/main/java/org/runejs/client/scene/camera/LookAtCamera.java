package org.runejs.client.scene.camera;

import org.runejs.client.scene.Point3d;

public class LookAtCamera extends GameCamera {
    private Point3d moveTo = new Point3d(0, 0, 0);
    private CameraAdjustmentSpeed movementSpeed = new CameraAdjustmentSpeed(0, 0);
    private Point3d lookAt = new Point3d(0, 0, 0);

    private CameraAdjustmentSpeed turnSpeed = new CameraAdjustmentSpeed(0, 0);

    @Override
    protected void onRotationUpdate(CameraRotation newRotation, CameraRotation oldRotation) {
        // no action needed on rotation update
    }

    /**
     * The position the camera is moving to.
     */
    public Point3d getMoveTo() {
        return this.moveTo;
    }

    /**
     * Sets the position the camera is moving to.
     */
    public void setMoveTo(Point3d newMoveTo) {
        this.moveTo = newMoveTo;
    }

    /**
     * The speed at which the camera moves.
     */
    public CameraAdjustmentSpeed getMovementSpeed() {
        return this.movementSpeed;
    }

    /**
     * Sets the speed at which the camera moves.
     */
    public void setMovementSpeed(int base, int scale) {
        this.movementSpeed = new CameraAdjustmentSpeed(base, scale);
    }

    /**
     * The position the camera is looking at.
     */
    public Point3d getLookAt() {
        return this.lookAt;
    }

    /**
     * Sets the position the camera is looking at.
     */
    public void setLookAt(Point3d newLookAt) {
        this.lookAt = newLookAt;
    }

    /**
     * The speed at which the camera turns.
     */
    public CameraAdjustmentSpeed getTurnSpeed() {
        return turnSpeed;
    }

    /**
     * Sets the speed at which the camera turns.
     */
    public void setTurnSpeed(int base, int scale) {
        this.turnSpeed = new CameraAdjustmentSpeed(base, scale);
    }
}
