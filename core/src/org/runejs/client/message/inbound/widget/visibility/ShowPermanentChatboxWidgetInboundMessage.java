package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

public class ShowPermanentChatboxWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public ShowPermanentChatboxWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
