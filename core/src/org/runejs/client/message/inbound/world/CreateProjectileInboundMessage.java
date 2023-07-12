package org.runejs.client.message.inbound.world;

import org.runejs.client.message.InboundMessage;

public class CreateProjectileInboundMessage implements InboundMessage {
    public final int x;

    public final int y;

    public final int endX;

    public final int endY;

    /**
     * Targeted player or NPC (negative if it's player, positive for NPC)
     */
    public final int entityIndex;

    public final int gfxId;

    public final int startHeight;

    public final int endHeight;

    /**
     * TODO please investigate and explain this more
     */
    public final int startSlope;

    /**
     * TODO please investigate and explain this more
     */
    public final int startDistance;

    public final int delay;

    public final int speed;

    public CreateProjectileInboundMessage(int x, int y, int endX, int endY, int entityIndex, int gfxId, int startHeight, int endHeight, int startSlope, int startDistance, int delay, int speed) {
        this.x = x;
        this.y = y;
        this.endX = endX;
        this.endY = endY;
        this.entityIndex = entityIndex;
        this.gfxId = gfxId;
        this.startHeight = startHeight;
        this.endHeight = endHeight;
        this.startSlope = startSlope;
        this.startDistance = startDistance;
        this.delay = delay;
        this.speed = speed;
    }
}
