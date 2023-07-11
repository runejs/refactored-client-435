package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.UpdateCarryWeightMessage;

/**
 * A {@link MessageHandler} that handles {@link UpdateCarryWeightMessage}s.
 */
public class UpdateCarryWeightMessageHandler implements MessageHandler<UpdateCarryWeightMessage> {
    @Override
    public void handle(UpdateCarryWeightMessage message) {
        if(Player.currentTabId == 12)
            GameInterface.redrawTabArea = true;
        MovedStatics.carryWeight = message.amount;
    }
}
