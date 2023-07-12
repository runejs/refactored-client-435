package org.runejs.client.message.handler.rs435.config;

import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.config.ResetVarbitsInboundMessage;

public class ResetVarbitsMessageHandler implements MessageHandler<ResetVarbitsInboundMessage> {
    @Override
    public void handle(ResetVarbitsInboundMessage message) {
        for(int varPlayerIndex = 0; VarPlayerDefinition.varPlayerDefinitionsSize > varPlayerIndex; varPlayerIndex++) {
            VarPlayerDefinition varPlayerDefinition = VarPlayerDefinition.getDefinition(varPlayerIndex);
            if(varPlayerDefinition.type == 0) {
                VarPlayerDefinition.varpCache[varPlayerIndex] = 0;
                VarPlayerDefinition.varPlayers[varPlayerIndex] = 0;
            }
        }
        if(ChatBox.dialogueId != -1)
            ChatBox.redrawChatbox = true;
        GameInterface.redrawTabArea = true;
    }
}
