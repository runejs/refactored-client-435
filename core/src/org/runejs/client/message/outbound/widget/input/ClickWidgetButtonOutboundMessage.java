package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.message.OutboundMessage;

public class ClickWidgetButtonOutboundMessage implements OutboundMessage {
    public final int widgetId;
    public final int childId;

    public ClickWidgetButtonOutboundMessage(int widgetId, int childId) {
        this.widgetId = widgetId;
        this.childId = childId;
    }
}
