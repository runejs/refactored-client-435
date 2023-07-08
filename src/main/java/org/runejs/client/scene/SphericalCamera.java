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
}
