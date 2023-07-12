package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.ClientScriptRunner;
import org.runejs.client.Game;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.UpdateRunEnergyMessage;

/**
 * A {@link MessageHandler} that handles {@link UpdateRunEnergyMessage}s.
 */
public class UpdateRunEnergyMessageHandler implements MessageHandler<UpdateRunEnergyMessage> {
    @Override
    public void handle(UpdateRunEnergyMessage message) {
        if(Game.currentTabId == 12)
            GameInterface.redrawTabArea = true;
        ClientScriptRunner.runEnergy = message.amount;
    }
}
