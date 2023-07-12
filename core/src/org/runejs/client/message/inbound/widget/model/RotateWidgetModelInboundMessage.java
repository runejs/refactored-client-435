package org.runejs.client.message.inbound.widget.model;

import org.runejs.client.message.InboundMessage;

public class RotateWidgetModelInboundMessage implements InboundMessage {
    public final int widgetId;

    public final int childId;

    public final int rotationX;

    public final int rotationZ;

    public final int zoom;

    public RotateWidgetModelInboundMessage(int widgetId, int childId, int rotationX, int rotationZ, int zoom) {
        this.widgetId = widgetId;
        this.childId = childId;
        this.rotationX = rotationX;
        this.rotationZ = rotationZ;
        this.zoom = zoom;
    }
}
