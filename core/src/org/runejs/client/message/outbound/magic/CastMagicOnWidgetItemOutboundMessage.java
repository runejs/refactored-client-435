package org.runejs.client.message.outbound.magic;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to cast a magic spell on a widget item.
 */
public class CastMagicOnWidgetItemOutboundMessage extends BaseCastMagicOutboundMessage implements OutboundMessage {
    /**
     * The id of the item to cast the spell on.
     */
    public final int itemId;

    /**
     * The id of the widget.
     */
    public final int widgetId;

    /**
     * The id of the container.
     */
    public final int containerId;

    /**
     * The slot of the item.
     */
    public final int slot;

    /**
     * Creates a new {@link CastMagicOnWidgetItemOutboundMessage}.
     *
     * @param spellId     The id of the spell to cast.
     * @param itemId      The id of the item to cast the spell on.
     * @param widgetId    The id of the widget.
     * @param containerId The id of the container.
     * @param slot        The slot of the item.
     */
    public CastMagicOnWidgetItemOutboundMessage(int spellId, int itemId, int widgetId, int containerId, int slot) {
        super(spellId);
        this.itemId = itemId;
        this.widgetId = widgetId;
        this.containerId = containerId;
        this.slot = slot;
    }
}
