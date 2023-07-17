package org.runejs.client.message.handler.rs435.chat;

import org.runejs.client.Game;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.chat.UpdateIgnoreListInboundMessage;

public class UpdateIgnoreListMessageHandler implements MessageHandler<UpdateIgnoreListInboundMessage> {
    @Override
    public void handle(UpdateIgnoreListInboundMessage message) {
        Game.ignoreList.setPlayers(message.ignores);
    }
}
