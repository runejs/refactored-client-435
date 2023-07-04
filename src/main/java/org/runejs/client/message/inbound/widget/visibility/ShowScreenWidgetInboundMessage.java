package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

public class ShowScreenWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public ShowScreenWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
