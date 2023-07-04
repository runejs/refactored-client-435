package org.runejs.client.message.inbound.widget;

import org.runejs.client.message.InboundMessage;

public class SetWidgetScrollPositionInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int scrollPosition;

    public SetWidgetScrollPositionInboundMessage(int widgetId, int childId, int scrollPosition) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.scrollPosition = scrollPosition;
    }
}
