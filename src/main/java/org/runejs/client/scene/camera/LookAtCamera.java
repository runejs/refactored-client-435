package org.runejs.client.scene.camera;

import org.runejs.client.scene.Point3d;

public class LookAtCamera extends GameCamera implements Camera {
    private Point3d lookAt = new Point3d(0, 0, 0);

    @Override
    protected void onRotationUpdate(CameraRotation newRotation, CameraRotation oldRotation) {
        // no action needed on rotation update
    }

    public void setLookAt(Point3d newLookAt) {
        this.lookAt = newLookAt;
    }
}
