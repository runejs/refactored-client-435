package org.runejs.client.scene.camera;

import org.runejs.client.scene.Point3d;

public interface Camera {
    CameraRotation getRotation();
    Point3d getPosition();

    void setOffset(Point3d offset);
}
