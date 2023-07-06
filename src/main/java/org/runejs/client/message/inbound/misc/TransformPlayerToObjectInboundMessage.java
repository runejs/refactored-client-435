package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * Transforms a player into an object.
 * 
 * TODO this class could use a bit more investigation and renaming
 */
public class TransformPlayerToObjectInboundMessage implements InboundMessage {
    /**
     * The player to transform
     */
    public final int playerId;

    /**
     * The object to transform into
     */
    public final int objectId;

    public final int x;
    public final int y;

    /**
     * The type of the object
     */
    public final int type;

    /**
     * The orientation of the object
     */
    public final int orientation;

    /**
     * Time to transform for.
     */
    public final int duration;

    /**
     * Time to wait before transforming.
     */
    public final int delay;

    /**
     * TODO please investigate and rename this
     */
    public final int unknownXMin;

    /**
     * TODO please investigate and rename this
     */
    public final int unknownXMax;

    /**
     * TODO please investigate and rename this
     */
    public final int unknownYMin;

    /**
     * TODO please investigate and rename this
     */
    public final int unknownYMax;

    public TransformPlayerToObjectInboundMessage(int playerId, int objectId, int x, int y, int type, int orientation, int duration, int delay, int unknownXMin, int unknownXMax, int unknownYMin, int unknownYMax) {
        this.playerId = playerId;
        this.objectId = objectId;
        this.x = x;
        this.y = y;
        this.type = type;
        this.orientation = orientation;
        this.duration = duration;
        this.delay = delay;
        this.unknownXMin = unknownXMin;
        this.unknownXMax = unknownXMax;
        this.unknownYMin = unknownYMin;
        this.unknownYMax = unknownYMax;
    }
}
