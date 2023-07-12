package org.runejs.client.message.inbound.widget.container;

import org.runejs.client.message.InboundMessage;

public class ClearWidgetItemsInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public ClearWidgetItemsInboundMessage(int widgetId, int childId) {
        this.widgetId = widgetId;
        this.childId = childId;
    }
}
