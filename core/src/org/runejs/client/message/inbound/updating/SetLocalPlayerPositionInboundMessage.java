package org.runejs.client.message.inbound.updating;

import org.runejs.client.message.InboundMessage;

/**
 * Updates the local player's position
 */
public class SetLocalPlayerPositionInboundMessage implements InboundMessage {
    /**
     * Local x coordinate (not world coordinate)
     */
    public final int x;

    /**
     * Local y coordinate (not world coordinate)
     */
    public final int y;

    /**
     * World height level
     */
    public final int level;

    /**
     * Whether they should teleport or walk
     */
    public final boolean shouldTeleport;

    public SetLocalPlayerPositionInboundMessage(int x, int y, int level, boolean shouldTeleport) {
        this.x = x;
        this.y = y;
        this.level = level;
        this.shouldTeleport = shouldTeleport;
    }
}
