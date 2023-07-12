package org.runejs.client.message.inbound.widget;

import org.runejs.client.message.InboundMessage;

public class SetWidgetPositionInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int x;

    public final int y;

    public SetWidgetPositionInboundMessage(int widgetId, int childId, int x, int y) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.x = x;
        this.y = y;
    }
}
