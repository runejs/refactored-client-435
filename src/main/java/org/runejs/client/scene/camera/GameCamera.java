package org.runejs.client.scene.camera;

import org.runejs.client.scene.Point3d;

public abstract class GameCamera implements Camera {
    /**
     * The camera's current rotation.
     */
    protected CameraRotation rotation = new CameraRotation(0, 128);

    /**
     * The camera's current position.
     */
    protected Point3d position = new Point3d(0, 0, 0);

    /**
     * The camera's current rotational offset, used for the "shake camera" effect.
     */
    protected CameraRotation offsetRotation = new CameraRotation(0, 0);

    /**
     * The camera's current offset, used for the "shake camera" effect.
     */
    protected Point3d offsetPosition = new Point3d(0, 0, 0);

    /**
     * Called when the camera's rotation is updated.
     */
    protected abstract void onRotationUpdate(CameraRotation newRotation, CameraRotation oldRotation);

    @Override
    public CameraRotation getRotation() {
        // (jkm) there's a chance that this won't play nicely with the offsets, and maybe we should create
        //       a `getRawRotation` function or something to get rotation without offsets. Revisit this and
        //       check it's all working perfectly in all edge cases.
        return this.rotation.add(this.offsetRotation);
    }

    public void setYaw(int yaw) {
        this.rotate(yaw, this.rotation.pitch);
    }

    public void setPitch(int pitch) {
        this.rotate(this.rotation.yaw, pitch);
    }

    /**
     * Sets the camera's offset position.
     */
    @Override
    public void setOffsetPosition(Point3d newOffset) {
        this.offsetPosition = newOffset;
    }

    /**
     * Sets the camera's offset rotation.
     */
    @Override
    public void setOffsetRotation(CameraRotation newOffset) {
        this.offsetRotation = newOffset;
    }

    public void rotate(int yaw, int pitch) {
        CameraRotation oldRotation = this.rotation;
        this.rotation = new CameraRotation(yaw, this.getClampedPitch(pitch));

        this.onRotationUpdate(this.rotation, oldRotation);
    }

    /**
     * Clamps the pitch to a valid value.
     */
    private int getClampedPitch(int pitch) {
        return Math.max(128, Math.min(pitch, 383));
    }

    @Override
    public Point3d getPosition() {
        // (jkm) there's a chance that this won't play nicely with the offsets, and maybe we should create
        //       a `getRawPosition` function or something to get position without offsets. Revisit this and
        //       check it's all working perfectly in all edge cases.
        return this.position.add(this.offsetPosition);
    }

    public void setPosition(Point3d position) {
        this.position = position;
    }
}
