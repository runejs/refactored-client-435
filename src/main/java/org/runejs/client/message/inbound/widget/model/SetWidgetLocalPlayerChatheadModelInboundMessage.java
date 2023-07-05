package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class SetWidgetLocalPlayerChatheadModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public SetWidgetLocalPlayerChatheadModelInboundMessage(int widgetId, int childId) {
        this.widgetId = widgetId;
        this.childId = childId;
    }
}
