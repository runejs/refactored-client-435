package org.runejs.client.message.inbound.camera;

import org.runejs.client.message.InboundMessage;

/**
 * Switch to cutscene camera mode, and rotate the camera towards a position.
 */
public class CutsceneCameraLookToInboundMessage implements InboundMessage {
    public final int targetX;

    public final int targetY;

    public final int height;

    public final int speedBase;

    public final int speedScale;

    public CutsceneCameraLookToInboundMessage(int targetX, int targetY, int height, int speedBase, int speedScale) {
        this.targetX = targetX;
        this.targetY = targetY;
        this.height = height;
        this.speedBase = speedBase;
        this.speedScale = speedScale;
    }
}
