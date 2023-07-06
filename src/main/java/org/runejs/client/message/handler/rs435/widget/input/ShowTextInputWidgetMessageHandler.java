package org.runejs.client.message.handler.rs435.widget.input;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.input.ShowTextInputWidgetInboundMessage;

/**
 * Shows the "Enter name:" input.
 *
 * This message has no properties.
 */
public class ShowTextInputWidgetMessageHandler implements MessageHandler<ShowTextInputWidgetInboundMessage> {
    @Override
    public void handle(ShowTextInputWidgetInboundMessage message) {
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            GameInterface.chatboxInterfaceId = -1;
        }
        ChatBox.redrawChatbox = true;
        ChatBox.inputMessage = "";
        ChatBox.inputType = 2;
        ChatBox.messagePromptRaised = false;
    }
}
