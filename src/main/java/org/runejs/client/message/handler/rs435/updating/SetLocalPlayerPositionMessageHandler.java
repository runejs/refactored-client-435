package org.runejs.client.message.handler.rs435.updating;

import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.SetLocalPlayerPositionInboundMessage;

public class SetLocalPlayerPositionMessageHandler implements MessageHandler<SetLocalPlayerPositionInboundMessage> {
    @Override
    public void handle(SetLocalPlayerPositionInboundMessage message) {
        Player.worldLevel = message.level;
        Player.localPlayer.method787(message.x, message.shouldTeleport, message.y);
    }
}
