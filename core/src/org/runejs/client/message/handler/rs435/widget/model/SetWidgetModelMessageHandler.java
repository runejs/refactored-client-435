package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.SetWidgetModelInboundMessage;

public class SetWidgetModelMessageHandler implements MessageHandler<SetWidgetModelInboundMessage> {
    @Override
    public void handle(SetWidgetModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);
        gameInterface.modelId = message.modelId;
        gameInterface.modelType = InterfaceModelType.MODEL;
    }
}
