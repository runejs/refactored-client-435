package org.runejs.client.message.inbound.camera;

import org.runejs.client.message.InboundMessage;

public class ShakeCameraInboundMessage implements InboundMessage {
    public final int cameraType;
    public final int jitter;
    public final int amplitude;
    public final int frequency;

    public ShakeCameraInboundMessage(int cameraType, int jitter, int amplitude, int frequency) {
        this.cameraType = cameraType;
        this.jitter = jitter;
        this.amplitude = amplitude;
        this.frequency = frequency;
    }
}
