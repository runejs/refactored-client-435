package org.runejs.client.scene.camera;

import org.runejs.client.media.renderable.Model;

public class CameraRotation {
    public final int yaw;
    public final int yawSine;
    public final int yawCosine;
    public final int pitch;
    public final int pitchSine;
    public final int pitchCosine;

    public CameraRotation(int yaw, int pitch) {
        this.yaw = yaw & 0x7ff;
        this.pitch = pitch;

        pitchSine = Model.SINE[pitch];
        pitchCosine = Model.COSINE[pitch];
        yawSine = Model.SINE[yaw];
        yawCosine = Model.COSINE[yaw];
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
