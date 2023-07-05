package org.runejs.client.message.inbound.widget.container;

import org.runejs.client.message.InboundMessage;

public class UpdateSpecificWidgetItemsInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;
    public final WidgetItem[] items;

    public UpdateSpecificWidgetItemsInboundMessage(int widgetId, int childId, WidgetItem[] items) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.items = items;
    }
}
