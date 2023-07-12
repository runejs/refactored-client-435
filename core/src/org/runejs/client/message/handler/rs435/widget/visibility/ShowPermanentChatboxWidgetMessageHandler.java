package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowPermanentChatboxWidgetInboundMessage;

public class ShowPermanentChatboxWidgetMessageHandler implements MessageHandler<ShowPermanentChatboxWidgetInboundMessage> {
    @Override
    public void handle(ShowPermanentChatboxWidgetInboundMessage message) {
        if(ChatBox.dialogueId != message.widgetId) {
            GameInterface.resetInterface(ChatBox.dialogueId);
            ChatBox.dialogueId = message.widgetId;
        }
        ChatBox.redrawChatbox = true;
        MovedStatics.lastContinueTextWidgetId = -1;
    }
}
