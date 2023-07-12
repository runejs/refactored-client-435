package org.runejs.client.message.handler.rs435.widget.model;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.model.SetWidgetLocalPlayerChatheadModelInboundMessage;

public class SetWidgetLocalPlayerChatheadModelMessageHandler implements MessageHandler<SetWidgetLocalPlayerChatheadModelInboundMessage> {
    @Override
    public void handle(SetWidgetLocalPlayerChatheadModelInboundMessage message) {
        GameInterface gameInterface = GameInterface.getInterface((message.widgetId << 16) | message.childId);

        gameInterface.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
        gameInterface.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
    }
}
