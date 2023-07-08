package org.runejs.client.scene;

import org.runejs.client.media.renderable.Model;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;

public class SphericalCamera implements Camera {
    /**
     * The camera's current origin X coordinate.
     *
     * This is generally the player's position in the Scene, but it is dampened slightly
     * and not attached directly to the player.
     */
    private int originX = 0;

    /**
     * The camera's current origin Y coordinate.
     *
     * This is generally the player's position in the Scene, but it is dampened slightly
     * and not attached directly to the player.
     */
    private int originY = 0;
    private int originZ = 0;

    private int yaw = 0;
    private int pitch = 128;
    private int zoom = 600;

    private Point3d cartesian = new Point3d(0, 0, 0);

    // TODO velocity here too ?

    public Point3d getPosition() {
        return this.cartesian;
    }

    public CameraRotation getRotation() {
        return new CameraRotation(yaw, pitch);
    }

    public void setOrigin(int x, int y, int z) {
        originX = x;
        originY = y;
        originZ = z;
        this.updateCartesian();
    }

    public int getOriginX() {
        return originX;
    }

    public int getOriginY() {
        return originY;
    }

    public int getOriginZ() {
        return originZ;
    }

    public void rotate(int yaw, int pitch, int zoom) {
        this.yaw = yaw;
        this.pitch = pitch;
        this.zoom = zoom;

        this.clampPitch();
        this.updateCartesian();
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
        this.updateCartesian();
    }

    public int getYaw() {
        return yaw;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
        this.clampPitch();
        this.updateCartesian();
    }

    public int getPitch() {
        return pitch;
    }

    public int getZoom() {
        return zoom;
    }

    public void clampPitch() {
        pitch = Math.max(128, Math.min(pitch, 383));
    }

    /**
     * Returns the camera's current cartesian coordinates.
     */
    public Point3d getCartesian() {
        return cartesian;
    }

    /**
     * Updates the camera's cartesian coordinates based on the current spherical coordinates.
     */
    private void updateCartesian() {
        int xOffset = 0;
        int yawDifference = 0x7ff & -yaw + 2048;
        int zOffset = 0;
        int pitchDifference = 2048 - pitch & 0x7ff;
        int yOffset = zoom + pitch * 3;
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

        int cameraX = -xOffset + originX;
        int cameraY = originY + -yOffset;
        int cameraZ = -zOffset + originZ;

        this.cartesian = new Point3d(cameraX, cameraY, cameraZ);
    }
}
