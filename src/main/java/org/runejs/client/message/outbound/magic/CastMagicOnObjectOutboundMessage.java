package org.runejs.client.message.outbound.magic;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to cast a magic spell on an object.
 */
public class CastMagicOnObjectOutboundMessage extends BaseCastMagicOutboundMessage implements OutboundMessage {
    /**
     * The id of the object to cast the spell on.
     */
    public final int objectId;

    /**
     * The x coordinate of the object.
     */
    public final int x;

    /**
     * The y coordinate of the object.
     */
    public final int y;

    /**
     * Creates a new {@link CastMagicOnObjectOutboundMessage}.
     *
     * @param spellId  The id of the spell to cast.
     * @param objectId The id of the object to cast the spell on.
     * @param x The x coordinate of the object.
     * @param y The y coordinate of the object.
     */
    public CastMagicOnObjectOutboundMessage(int spellId, int objectId, int x, int y) {
        super(spellId);
        this.objectId = objectId;
        this.x = x;
        this.y = y;
    }
}
