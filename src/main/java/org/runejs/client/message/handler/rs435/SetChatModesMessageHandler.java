package org.runejs.client.message.handler.rs435;

import org.runejs.client.MovedStatics;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.SetChatModesInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link SetChatModesInboundMessage}s.
 */
public class SetChatModesMessageHandler implements MessageHandler<SetChatModesInboundMessage> {
    @Override
    public void handle(SetChatModesInboundMessage message) {
        ChatBox.publicChatMode = message.publicChatMode;
        ChatBox.privateChatMode = message.privateChatMode;
        ChatBox.tradeMode = message.tradeMode;
        ChatBox.redrawChatbox = true;
        MovedStatics.redrawChatbox = true;
    }
}
