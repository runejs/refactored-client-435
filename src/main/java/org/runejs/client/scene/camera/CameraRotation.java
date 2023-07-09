package org.runejs.client.scene.camera;

public class CameraRotation {
    public final int yaw;
    public final int pitch;

    public CameraRotation(int yaw, int pitch) {
        this.yaw = yaw & 0x7ff;
        this.pitch = pitch;
    }

    public CameraRotation add(CameraRotation other) {
        return new CameraRotation(yaw + other.yaw, pitch + other.pitch);
    }

    public CameraRotation addPitch(int pitch) {
        return new CameraRotation(this.yaw, this.pitch + pitch);
    }

    public CameraRotation addYaw(int yaw) {
        return new CameraRotation(this.yaw + yaw, this.pitch);
    }
}
