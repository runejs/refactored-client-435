package org.runejs.client.message.outbound.widget.container;

import org.runejs.client.message.OutboundMessage;

public class DropWidgetItemOutboundMessage implements OutboundMessage {
    public final int widgetId;

    public final int containerId;

    public final int itemId;

    public final int slot;

    public DropWidgetItemOutboundMessage(int widgetId, int containerId, int itemId, int slot) {
        this.widgetId = widgetId;
        this.containerId = containerId;
        this.itemId = itemId;
        this.slot = slot;
    }
}
