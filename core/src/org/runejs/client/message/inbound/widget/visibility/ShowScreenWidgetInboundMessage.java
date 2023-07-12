package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Display a widget in the game screen (3d window).
 */
public class ShowScreenWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public ShowScreenWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
