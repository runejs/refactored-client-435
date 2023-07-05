package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Show a walkable widget in the game (3d) screen.
 */
public class ShowWalkableScreenWidgetInboundMessage implements InboundMessage {
    public final int widgetId;

    public ShowWalkableScreenWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
