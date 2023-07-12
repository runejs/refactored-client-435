package org.runejs.client.message.inbound.widget.text;

import org.runejs.client.message.InboundMessage;

public class SetWidgetTextInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final String text;

    public SetWidgetTextInboundMessage(int widgetId, int childId, String text) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.text = text;
    }
}
