package org.runejs.client.message.handler.rs435.widget.input;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.input.ShowNumberInputWidgetInboundMessage;

/**
 * Shows the "Enter amount:" input.
 *
 * This message has no properties.
 */
public class ShowNumberInputWidgetMessageHandler implements MessageHandler<ShowNumberInputWidgetInboundMessage> {
    @Override
    public void handle(ShowNumberInputWidgetInboundMessage message) {
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            GameInterface.chatboxInterfaceId = -1;
        }
        ChatBox.inputMessage = "";
        ChatBox.inputType = 1; // "Enter amount:"
        ChatBox.redrawChatbox = true;
        ChatBox.messagePromptRaised = false;
    }
}
