package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.*;
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
        Game.currentHintIconType = 0;
    }

    private void handlePositionType(SetHintIconInboundMessage message) {
        Game.currentHintIconType = 2;
        MovedStatics.hintIconPosX = message.positionInfo.x;
        MovedStatics.hintIconPosY = message.positionInfo.y;
        MovedStatics.hintIconPosZ = message.positionInfo.drawHeight;
        MovedStatics.hintIconInnerPosX = message.positionInfo.drawOffsetX;
        MovedStatics.hintIconInnerPosY = message.positionInfo.drawOffsetY;
    }

    private void handleNPCType(SetHintIconInboundMessage message) {
        Game.currentHintIconType = 1;
        MovedStatics.hintIconNpcTarget = message.actorInfo.id;
    }

    private void handlePlayerType(SetHintIconInboundMessage message) {
        Game.currentHintIconType = 10;
        MovedStatics.hintIconPlayerTarget = message.actorInfo.id;
    }
}
