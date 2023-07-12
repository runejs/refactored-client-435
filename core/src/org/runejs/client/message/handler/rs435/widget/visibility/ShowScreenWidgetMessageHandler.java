package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowScreenWidgetInboundMessage;

public class ShowScreenWidgetMessageHandler implements MessageHandler<ShowScreenWidgetInboundMessage> {
    @Override
    public void handle(ShowScreenWidgetInboundMessage message) {
        GameInterface.resetInterfaceAnimations(message.widgetId);
        if(GameInterface.tabAreaInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.drawTabIcons = true;
            GameInterface.tabAreaInterfaceId = -1;
            GameInterface.redrawTabArea = true;
        }
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
        if(message.widgetId != GameInterface.gameScreenInterfaceId) {
            GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
            GameInterface.gameScreenInterfaceId = message.widgetId;
        }
        MovedStatics.lastContinueTextWidgetId = -1;
        if(ChatBox.inputType != 0) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
        }
        GameInterface.callOnLoadListeners(GameInterface.gameScreenInterfaceId);
    }
}
