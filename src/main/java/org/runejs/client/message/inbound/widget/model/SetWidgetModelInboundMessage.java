package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class SetWidgetModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int modelId;

    public SetWidgetModelInboundMessage(int widgetId, int childId, int modelId) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.modelId = modelId;
    }
}
