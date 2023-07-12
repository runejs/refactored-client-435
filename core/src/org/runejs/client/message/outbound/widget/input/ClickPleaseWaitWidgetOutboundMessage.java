package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.message.OutboundMessage;

/**
 * Sent when the player clicks a "Please wait..." widget
 *
 * e.g. dialogues in the chatbox
 */
public class ClickPleaseWaitWidgetOutboundMessage implements OutboundMessage {
    public final int widgetId;

    public final int childId;

    public final int option;

    public ClickPleaseWaitWidgetOutboundMessage(int widgetId, int childId, int option) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.option = option;
    }
}
