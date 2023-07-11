package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.*;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetHintIconInboundMessage;

public class SetHintIconMessageHandler implements MessageHandler<SetHintIconInboundMessage> {
    @Override
    public void handle(SetHintIconInboundMessage message) {
        switch (message.type) {
            case NONE:
                this.handleNoneType(message);
                return;
            case NPC:
                this.handleNPCType(message);
                return;
            case POSITION:
                this.handlePositionType(message);
                return;
            case PLAYER:
                this.handlePlayerType(message);
                return;
            default:
                throw new RuntimeException("Unexpected hint icon type: " + message.type);
        }
    }

    private void handleNoneType(SetHintIconInboundMessage message) {
        Player.headIconDrawType = 0;
    }

    private void handlePositionType(SetHintIconInboundMessage message) {
        Player.headIconDrawType = 2;
        ProducingGraphicsBuffer.hintIconPosX = message.positionInfo.x;
        MovedStatics.hintIconPosY = message.positionInfo.y;
        MovedStatics.hintIconPosZ = message.positionInfo.drawHeight;
        Landscape.hintIconInnerPosX = message.positionInfo.drawOffsetX;
        Class35.hintIconInnerPosY = message.positionInfo.drawOffsetY;
    }

    private void handleNPCType(SetHintIconInboundMessage message) {
        Player.headIconDrawType = 1;
        MovedStatics.anInt1545 = message.actorInfo.id;
    }

    private void handlePlayerType(SetHintIconInboundMessage message) {
        Player.headIconDrawType = 10;
        ProducingGraphicsBuffer.anInt1623 = message.actorInfo.id;
    }
}
