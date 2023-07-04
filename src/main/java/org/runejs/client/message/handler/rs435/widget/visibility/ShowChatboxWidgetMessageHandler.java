package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowChatboxWidgetInboundMessage;

public class ShowChatboxWidgetMessageHandler implements MessageHandler<ShowChatboxWidgetInboundMessage> {
    @Override
    public void handle(ShowChatboxWidgetInboundMessage message) {
        GameInterface.resetInterfaceAnimations(message.widgetId);
        if(GameInterface.tabAreaInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.drawTabIcons = true;
            GameInterface.tabAreaInterfaceId = -1;
            GameInterface.redrawTabArea = true;
        }
        if(GameInterface.fullscreenInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
            GameInterface.fullscreenInterfaceId = -1;
            MovedStatics.processGameStatus(30);
        }
        if(GameInterface.fullscreenSiblingInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
            GameInterface.fullscreenSiblingInterfaceId = -1;
        }
        if(GameInterface.gameScreenInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
            GameInterface.gameScreenInterfaceId = -1;
        }
        if(GameInterface.chatboxInterfaceId != message.widgetId) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            GameInterface.chatboxInterfaceId = message.widgetId;
        }

        ChatBox.redrawChatbox = true;
        MovedStatics.lastContinueTextWidgetId = -1;
    }
}
