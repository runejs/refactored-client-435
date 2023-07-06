package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.*;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.inbound.misc.SetHintIconInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetHintIconMessageDecoder implements MessageDecoder<SetHintIconInboundMessage> {
    @Override
    public SetHintIconInboundMessage decode(PacketBuffer buffer) {
        int headIconDrawType = buffer.getUnsignedByte();
        if(headIconDrawType == 1) {
            int npcId = buffer.getUnsignedShortBE();

            return new SetHintIconInboundMessage(
                SetHintIconInboundMessage.HintIconTargetType.NPC,
                null,
                new SetHintIconInboundMessage.ActorHintIcon(npcId)
            );
        }
        if(headIconDrawType >= 2 && Player.headIconDrawType <= 6) {
            int drawX = 64;
            int drawY = 64;
            
            if(headIconDrawType == 2) {
                drawY = 64;
                drawX = 64;
            }
            if(headIconDrawType == 3) {
                drawY = 64;
                drawX = 0;
            }
            if(headIconDrawType == 4) {
                drawY = 64;
                drawX = 128;
            }
            if(headIconDrawType == 5) {
                drawX = 64;
                drawY = 0;
            }
            if(headIconDrawType == 6) {
                drawX = 64;
                drawY = 128;
            }

            int worldX = buffer.getUnsignedShortBE();
            int worldY = buffer.getUnsignedShortBE();
            int drawHeight = buffer.getUnsignedByte();

            return new SetHintIconInboundMessage(
                SetHintIconInboundMessage.HintIconTargetType.NPC,
                new SetHintIconInboundMessage.PositionHintIcon(
                    worldX,
                    worldY,
                    drawHeight,
                    drawX,
                    drawY
                ),
                null
            );
        }
        if(headIconDrawType == 10) {
            int playerId = buffer.getUnsignedShortBE();

            return new SetHintIconInboundMessage(
                SetHintIconInboundMessage.HintIconTargetType.PLAYER,
                null,
                new SetHintIconInboundMessage.ActorHintIcon(playerId)
            );
        }

        return new SetHintIconInboundMessage(SetHintIconInboundMessage.HintIconTargetType.NONE, null, null);
    }
}
