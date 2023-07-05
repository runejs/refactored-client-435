package org.runejs.client.message.inbound.widget.visibility;

import org.runejs.client.message.InboundMessage;

/**
 * Sets the widget to be displayed when a user opens a given tab.
 *
 * Note that this doesn't replace the entire tab area but rather it permanently sets
 * the contents of a given tab.
 */
public class ReplaceTabWidgetInboundMessage implements InboundMessage {
    /**
     * The widget to display
     */
    public final int widgetId;

    /**
     * The tab to display the widget on
     */
    public final int tabIndex;

    public ReplaceTabWidgetInboundMessage(int widgetId, int tabIndex) {
        this.widgetId = widgetId;
        this.tabIndex = tabIndex;
    }
}
