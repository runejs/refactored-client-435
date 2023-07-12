package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.SetWidgetModelRotationSpeedInboundMessage;

public class SetWidgetModelRotationSpeedMessageHandler implements MessageHandler<SetWidgetModelRotationSpeedInboundMessage> {
    @Override
    public void handle(SetWidgetModelRotationSpeedInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.rotationSpeed = message.speed;
    }
}
