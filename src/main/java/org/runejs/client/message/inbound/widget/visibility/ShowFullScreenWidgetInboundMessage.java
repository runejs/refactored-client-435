package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Show a widget in full screen mode.
 */
public class ShowFullScreenWidgetInboundMessage implements InboundMessage {

    public final int widgetId;

    public final int childId;

    public ShowFullScreenWidgetInboundMessage(int widgetId, int childId) {
        this.widgetId = widgetId;
        this.childId = childId;
    }
}
