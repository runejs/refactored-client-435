package org.runejs.client.message.handler.rs435.widget.visibility;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.widget.visibility.ShowFullScreenWidgetInboundMessage;

public class ShowFullScreenWidgetMessageHandler implements MessageHandler<ShowFullScreenWidgetInboundMessage> {
    @Override
    public void handle(ShowFullScreenWidgetInboundMessage message) {
        int interfaceId = message.widgetId;
        int siblingInterfaceId = message.childId;

        GameInterface.resetInterfaceAnimations(interfaceId);

        if(siblingInterfaceId != -1) {
            GameInterface.resetInterfaceAnimations(siblingInterfaceId);
        }
        if(GameInterface.gameScreenInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
            GameInterface.gameScreenInterfaceId = -1;
        }
        if(GameInterface.tabAreaInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
            GameInterface.tabAreaInterfaceId = -1;
        }
        if(GameInterface.chatboxInterfaceId != -1) {
            GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
            GameInterface.chatboxInterfaceId = -1;
        }
        if(interfaceId != GameInterface.fullscreenInterfaceId) {
            GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
            GameInterface.fullscreenInterfaceId = interfaceId;
            MovedStatics.processGameStatus(35);
        }
        if(interfaceId != GameInterface.fullscreenSiblingInterfaceId) {
            GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
            GameInterface.fullscreenSiblingInterfaceId = siblingInterfaceId;
        }
        MovedStatics.lastContinueTextWidgetId = -1;
        ChatBox.inputType = 0;
    }
}
