package org.runejs.client.message.handler.rs435.chat;

import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.chat.UpdateIgnoreListInboundMessage;

public class UpdateIgnoreListMessageHandler implements MessageHandler<UpdateIgnoreListInboundMessage> {
    @Override
    public void handle(UpdateIgnoreListInboundMessage message) {
        Player.ignoresCount = message.ignores.length;

        for(int i = 0; i < message.ignores.length; i++)
            Player.ignores[i] = message.ignores[i];
    }
}
