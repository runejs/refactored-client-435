package org.runejs.client.message.handler.rs435.world.object;

import org.runejs.client.MovedStatics;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.object.CreateObjectInboundMessage;

/**
 * Remove a game object.
 *
 * This has a very similar implementation to {@link RemoveObjectMessageHandler}, maybe we will
 * want to combine them in the future.
 */
public class CreateObjectMessageHandler implements MessageHandler<CreateObjectInboundMessage> {
    @Override
    public void handle(CreateObjectInboundMessage message) {
        int x = message.x + MovedStatics.placementX;
        int y = message.y + OverlayDefinition.placementY;

        if (x >= 0 && y >= 0 && x < 104 && y < 104)
            GameObjectDefinition.method609(message.id, x, message.orientation, -1, Player.worldLevel, y, Npc.anIntArray3304[message.type], message.type, 0);
    }
}
