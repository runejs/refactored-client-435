package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Class13;
import org.runejs.client.Game;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.UpdatePlayerOptionsInboundMessage;

public class UpdatePlayerOptionsMessageHandler implements MessageHandler<UpdatePlayerOptionsInboundMessage> {
    @Override
    public void handle(UpdatePlayerOptionsInboundMessage message) {
        if(message.index >= 1 && message.index <= 5) {
            String option = message.option;
            if(option.equalsIgnoreCase("null"))
                option = null;
            Game.playerActions[message.index - 1] = option;
            Class13.playerArray[message.index - 1] = message.lowPriority;
        }
    }
}
