package org.runejs.client.message.handler.rs435.config;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.io.Buffer;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.config.SetVarpValueInboundMessage;

public class SetVarpValueMessageHandler implements MessageHandler<SetVarpValueInboundMessage> {
    @Override
    public void handle(SetVarpValueInboundMessage message) {
        Buffer.anIntArray1984[message.index] = message.value;
        if(VarPlayerDefinition.varPlayers[message.index] != message.value) {
            VarPlayerDefinition.varPlayers[message.index] = message.value;
            MovedStatics.handleVarPlayers(message.index);
            GameInterface.redrawTabArea = true;
            if(ChatBox.dialogueId != -1)
                ChatBox.redrawChatbox = true;
        }
    }
}
