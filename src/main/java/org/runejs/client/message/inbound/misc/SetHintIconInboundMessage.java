package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class SetHintIconInboundMessage implements InboundMessage {
    public enum HintIconTargetType {
        NONE,
        POSITION,
        NPC,
        PLAYER,
    }

    public static class PositionHintIcon {
        public final int x;
        public final int y;
        public final int drawHeight;
        public final int drawOffsetX;
        public final int drawOffsetY;

        public PositionHintIcon(int x, int y, int drawHeight, int drawOffsetX, int drawOffsetY) {
            this.x = x;
            this.y = y;
            this.drawHeight = drawHeight;
            this.drawOffsetX = drawOffsetX;
            this.drawOffsetY = drawOffsetY;
        }
    }

    public static class ActorHintIcon {
        public final int id;

        public ActorHintIcon(int id) {
            this.id = id;
        }
    }

    public final HintIconTargetType type;

    /**
     * The position, or null if this hint icon isn't targeting a position.
     */
    public final PositionHintIcon positionInfo;

    /**
     * The actor info, or null if this hint icon isn't targeting an actor.
     */
    public final ActorHintIcon actorInfo;


    public SetHintIconInboundMessage(HintIconTargetType type, PositionHintIcon positionInfo, ActorHintIcon actorInfo) {
        this.type = type;
        this.positionInfo = positionInfo;
        this.actorInfo = actorInfo;
    }
}
