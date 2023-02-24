package org.runejs.client.message.handler.rs435;

import org.runejs.client.MovedStatics;
import org.runejs.client.RSString;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.ReceiveChatboxMessageInboundMessage;
import org.runejs.client.message.inbound.ReceivePrivateMessageInboundMessage;

/**
 * A {@link MessageHandler} that handles {@link ReceiveChatboxMessageInboundMessage}s.
 * 
 * Responsible for displaying general chat messages and trade/duel requests.
 */
public class ReceiveChatboxMessageHandler implements MessageHandler<ReceiveChatboxMessageInboundMessage> {
    @Override
    public void handle(ReceiveChatboxMessageInboundMessage message) {
        String chatMessage = message.message;

        if(chatMessage.endsWith(Native.tradeRequest)) {
            String username = chatMessage.substring(0, chatMessage.indexOf(Native.colon));
            long l = RSString.nameToLong(username);
            boolean bool = false;
            for(int i_33_ = 0; i_33_ < MovedStatics.anInt1008; i_33_++) {
                if(l == Player.ignores[i_33_]) {
                    bool = true;
                    break;
                }
            }
            if(!bool && !Player.inTutorialIsland)
                ChatBox.addChatMessage(username, "wishes to trade with you.", 4);
        } else if(chatMessage.endsWith(Native.duelRequest)) {
            String username = chatMessage.substring(0, chatMessage.indexOf(Native.colon));
            long l = RSString.nameToLong(username);
            boolean bool = false;
            for(int i_31_ = 0; MovedStatics.anInt1008 > i_31_; i_31_++) {
                if(l == Player.ignores[i_31_]) {
                    bool = true;
                    break;
                }
            }
            if(!bool && !Player.inTutorialIsland)
                ChatBox.addChatMessage(username, English.suffixWishesToDuelWithYou, 8);
        } else if(chatMessage.endsWith(Native.challengeRequest)) {
            String username = chatMessage.substring(0, chatMessage.indexOf(Native.colon));
            long l = RSString.nameToLong(username);
            boolean bool = false;
            for(int i_28_ = 0; i_28_ < MovedStatics.anInt1008; i_28_++) {
                if(l == Player.ignores[i_28_]) {
                    bool = true;
                    break;
                }
            }
            if(!bool && !Player.inTutorialIsland) {
                String challengeMessage = chatMessage.substring(1 + chatMessage.indexOf(Native.colon), -9 + chatMessage.length());
                ChatBox.addChatMessage(username, challengeMessage, 8);
            }
        } else {
            ChatBox.addChatMessage("", chatMessage, 0);
        }
    }
}
