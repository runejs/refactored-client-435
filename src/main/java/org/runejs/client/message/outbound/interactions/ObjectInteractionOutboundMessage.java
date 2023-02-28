package org.runejs.client.message.outbound.interactions;

import org.runejs.client.message.OutboundMessage;

/**
 * Represents a message sent to the server when a player interacts with an object.
 * 
 * e.g. clicking on a tree to chop it down
 */
public class ObjectInteractionOutboundMessage implements OutboundMessage {
    /**
     * Which option on the object was clicked
     * 
     * i.e. 1 = first option, 2 = second option, etc.
     */
    public final int option;

    /**
     * The id of the object
     */
    public final int objectId;

    /**
     * The x coordinate of the object
     */
    public final int x;

    /**
     * The y coordinate of the object
     */
    public final int y;

    public ObjectInteractionOutboundMessage(int option, int objectId, int x, int y) {
        this.option = option;
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }
}
