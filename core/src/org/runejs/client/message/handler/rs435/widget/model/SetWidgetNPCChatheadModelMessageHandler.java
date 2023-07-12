package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.SetWidgetNPCChatheadModelInboundMessage;

public class SetWidgetNPCChatheadModelMessageHandler implements MessageHandler<SetWidgetNPCChatheadModelInboundMessage> {
    @Override
    public void handle(SetWidgetNPCChatheadModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.modelType = InterfaceModelType.NPC_CHATHEAD;
        gameInterface.modelId = message.npcId;
    }
}
