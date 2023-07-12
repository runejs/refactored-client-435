package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class AnimateWidgetModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int animationId;

    public AnimateWidgetModelInboundMessage(int widgetId, int childId, int animationId) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.animationId = animationId;
    }
}
