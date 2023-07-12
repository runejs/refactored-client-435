package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Displays a widget over the tabarea.
 *
 * Note that this is used for temporary overlays, not for replacing the contents of a specific
 * tab.
 *
 * If you want to control a tab's contents, see {@link ReplaceTabWidgetInboundMessage}
 */
public class ShowTabWidgetInboundMessage implements InboundMessage {

    public final int widgetId;

    public ShowTabWidgetInboundMessage(int widgetId) {
        this.widgetId = widgetId;
    }
}
