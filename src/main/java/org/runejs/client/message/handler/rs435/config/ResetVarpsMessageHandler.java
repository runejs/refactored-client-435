package org.runejs.client.message.handler.rs435.config;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.config.ResetVarpsInboundMessage;

public class ResetVarpsMessageHandler implements MessageHandler<ResetVarpsInboundMessage> {
    @Override
    public void handle(ResetVarpsInboundMessage message) {
        for(int varPlayerIndex = 0; varPlayerIndex < VarPlayerDefinition.varPlayers.length; varPlayerIndex++) {
            if(Buffer.anIntArray1984[varPlayerIndex] != VarPlayerDefinition.varPlayers[varPlayerIndex]) {
                VarPlayerDefinition.varPlayers[varPlayerIndex] = Buffer.anIntArray1984[varPlayerIndex];
                MovedStatics.handleVarPlayers(varPlayerIndex);
                GameInterface.redrawTabArea = true;
            }
        }
    }
}
