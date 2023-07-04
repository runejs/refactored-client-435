package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Display a widget in the chatbox.
 */
public class ShowChatboxWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public ShowChatboxWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
