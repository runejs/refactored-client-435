package org.runejs.client.message.outbound.widget.container;

import org.runejs.client.message.OutboundMessage;

public class DragWidgetItemOutboundMessage implements OutboundMessage {
    /**
     * 0: swap items
     * 1: move item
     *
     * TODO make an enum for this and further clarify usages
     */
    public final int moveType;

    public final int widgetId;

    public final int fromSlot;

    public final int toSlot;

    public DragWidgetItemOutboundMessage(int moveType, int widgetId, int fromSlot, int toSlot) {
        this.moveType = moveType;
        this.widgetId = widgetId;
        this.fromSlot = fromSlot;
        this.toSlot = toSlot;
    }
}
