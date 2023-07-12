package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class SetWidgetItemModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int itemId;

    public final int itemZoom;

    public SetWidgetItemModelInboundMessage(int widgetId, int childId, int itemId, int itemZoom) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.itemId = itemId;
        this.itemZoom = itemZoom;
    }
}
