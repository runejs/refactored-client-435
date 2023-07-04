package org.runejs.client.message.outbound.magic;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to cast a magic spell on a world item.
 */
public class CastMagicOnWorldItemOutboundMessage extends BaseCastMagicOutboundMessage implements OutboundMessage {
    /**
     * The id of the item to cast the spell on.
     */
    public final int itemId;

    /**
     * The x coordinate of the item.
     */
    public final int x;

    /**
     * The y coordinate of the item.
     */
    public final int y;

    /**
     * Creates a new {@link CastMagicOnWorldItemOutboundMessage}.
     *
     * @param spellId The id of the spell to cast.
     * @param itemId The id of the item to cast the spell on.
     * @param x The x coordinate of the item.
     * @param y The y coordinate of the item.
     */
    public CastMagicOnWorldItemOutboundMessage(int spellId, int itemId, int x, int y) {
        super(spellId);
        this.itemId = itemId;
        this.x = x;
        this.y = y;
    }
}
