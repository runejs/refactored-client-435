package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class SetWidgetNPCChatheadModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int npcId;

    public SetWidgetNPCChatheadModelInboundMessage(int widgetId, int childId, int npcId) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.npcId = npcId;
    }
}
