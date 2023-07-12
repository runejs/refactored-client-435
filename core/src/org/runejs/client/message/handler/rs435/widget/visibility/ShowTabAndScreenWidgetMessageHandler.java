package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowTabAndScreenWidgetInboundMessage;

public class ShowTabAndScreenWidgetMessageHandler implements MessageHandler<ShowTabAndScreenWidgetInboundMessage> {
    @Override
    public void handle(ShowTabAndScreenWidgetInboundMessage message) {
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            ChatBox.redrawChatbox = true;
            GameInterface.chatboxInterfaceId = -1;
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
        if(GameInterface.gameScreenInterfaceId != message.screenWidgetId) {
            GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
            GameInterface.gameScreenInterfaceId = message.screenWidgetId;
        }
        if(GameInterface.tabAreaInterfaceId != message.tabWidgetId) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.tabAreaInterfaceId = message.tabWidgetId;
        }
        MovedStatics.lastContinueTextWidgetId = -1;
        if(ChatBox.inputType != 0) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
        }
        GameInterface.redrawTabArea = true;
        GameInterface.drawTabIcons = true;
    }
}
