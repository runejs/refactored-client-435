package org.runejs.client.message.inbound.widget.text;

import org.runejs.client.message.InboundMessage;

public class SetWidgetTextColorInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int color;

    public SetWidgetTextColorInboundMessage(int widgetId, int childId, int color) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.color = color;
    }
}
