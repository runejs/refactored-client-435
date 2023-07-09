package org.runejs.client.scene;

public class Point3d {
    public final int x;
    public final int y;
    public final int z;

    public Point3d(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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
}
