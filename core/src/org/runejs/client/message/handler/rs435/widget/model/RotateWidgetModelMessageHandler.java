package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.RotateWidgetModelInboundMessage;

public class RotateWidgetModelMessageHandler implements MessageHandler<RotateWidgetModelInboundMessage> {
    @Override
    public void handle(RotateWidgetModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.rotationZ = message.rotationZ;
        gameInterface.modelZoom = message.zoom;
        gameInterface.rotationX = message.rotationX;
    }
}
