package org.runejs.client.scene;

/**
 * Represents a 3d point within the scene.
 *
 * Do not confuse this with the discrete (x/y/plane) tile coordinates. These are 3d coordinates.
 */
public class Point3d {
    public final int x;
    public final int y;
    public final int z;

    /**
     * The x coordinate (0-104) of the scene tile at this Point3d.
     */
    public final int tileX;
    /**
     * The y coordinate (0-104) the scene tile at this Point3d.
     */
    public final int tileY;

    public Point3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.tileX = x / 128;
        this.tileY = y / 128;
    }

    public Point3d add(Point3d other) {
        return new Point3d(x + other.x, y + other.y, z + other.z);
    }

    public Point3d addX(int x) {
        return new Point3d(this.x + x, this.y, this.z );
    }

    public Point3d addY(int y) {
        return new Point3d(this.x, this.y + y, this.z );
    }

    public Point3d addZ(int z) {
        return new Point3d(this.x, this.y, this.z + z );
    }

    // TODO (jkm) make a `Point3d fromTile(x, y)`
}
