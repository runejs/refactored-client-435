package org.runejs.client.message.inbound.widget.container;

import org.runejs.client.message.InboundMessage;

public class UpdateAllWidgetItemsInboundMessage implements InboundMessage {

    public static class WidgetItem {
        public final int index;
        public final int id;
        public final int amount;

        public WidgetItem(int index, int id, int amount) {
            this.index = index;
            this.id = id;
            this.amount = amount;
        }
    }

    public final int widgetId;

    public final int childId;

    public final WidgetItem[] items;

    public UpdateAllWidgetItemsInboundMessage(int widgetId, int childId, WidgetItem[] items) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.items = items;
    }
}
