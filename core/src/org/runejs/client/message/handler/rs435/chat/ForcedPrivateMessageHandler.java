package org.runejs.client.message.handler.rs435.chat;

import org.runejs.client.frame.ChatBox;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.chat.ForcedPrivateMessageInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link ForcedPrivateMessageInboundMessage}s.
 */
public class ForcedPrivateMessageHandler implements MessageHandler<ForcedPrivateMessageInboundMessage> {
    @Override
    public void handle(ForcedPrivateMessageInboundMessage message) {
        ChatBox.addChatMessage(Player.longToUsername(message.username).method85().toString(), message.message, 6);
    }
}
