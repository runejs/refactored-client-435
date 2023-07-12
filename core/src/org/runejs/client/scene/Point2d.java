package org.runejs.client.scene;

public class Point2d {
    public final int x;
    public final int y;

    public Point2d(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2d add(Point2d other) {
        return new Point2d(x + other.x, y + other.y);
    }

    public Point2d addX(int x) {
        return new Point2d(this.x + x, this.y );
    }

    public Point2d addY(int y) {
        return new Point2d(this.x, this.y + y );
    }
}
