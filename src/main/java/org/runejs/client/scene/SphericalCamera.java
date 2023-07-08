package org.runejs.client.scene;

public class SphericalCamera {
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

    // TODO velocity here too ?

    public void setOrigin(int x, int y, int z) {
        originX = x;
        originY = y;
        originZ = z;
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
    }

    public void setYaw(int yaw) {
        this.yaw = yaw;
    }

    public int getYaw() {
        return yaw;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
        this.clampPitch();
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
}
