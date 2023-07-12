package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.UpdatePlayerOptionsInboundMessage;

public class UpdatePlayerOptionsMessageHandler implements MessageHandler<UpdatePlayerOptionsInboundMessage> {
    @Override
    public void handle(UpdatePlayerOptionsInboundMessage message) {
        if(message.index >= 1 && message.index <= 5) {
            String option = message.option;
            if(option.equalsIgnoreCase("null"))
                option = null;
            Player.playerActions[message.index - 1] = option;
            Player.playerActionsLowPriority[message.index - 1] = message.lowPriority;
        }
    }
}
