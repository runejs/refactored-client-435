package org.runejs.client.message.inbound.camera;

import org.runejs.client.message.InboundMessage;

/**
 * Switch to cutscene camera mode, and move the camera to a position.
 */
public class CutsceneCameraMoveToInboundMessage implements InboundMessage {
    public final int targetX;

    public final int targetY;

    public final int height;

    public final int speedBase;

    public final int speedScale;

    public CutsceneCameraMoveToInboundMessage(int targetX, int targetY, int height, int speedBase, int speedScale) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.height = height;
        this.speedBase = speedBase;
        this.speedScale = speedScale;
    }
}
