package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.scene.InteractiveObjectTemporary;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.ClearChunkInboundMessage;

/**
 * Clears a chunk of the map.
 */
public class ClearChunkMessageHandler implements MessageHandler<ClearChunkInboundMessage> {
    @Override
    public void handle(ClearChunkInboundMessage message) {
        MovedStatics.placementX = message.x;
        MovedStatics.placementY = message.y;
        for(int i_51_ = MovedStatics.placementX; i_51_ < 8 + MovedStatics.placementX; i_51_++) {
            for(int i_52_ = MovedStatics.placementY; 8 + MovedStatics.placementY > i_52_; i_52_++) {
                if(MovedStatics.groundItems[Player.worldLevel][i_51_][i_52_] != null) {
                    MovedStatics.groundItems[Player.worldLevel][i_51_][i_52_] = null;
                    MovedStatics.spawnGroundItem(i_52_, i_51_);
                }
            }
        }
        for(InteractiveObjectTemporary interactiveObjectTemporary = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.peekFirst(); interactiveObjectTemporary != null; interactiveObjectTemporary = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.pollFirst()) {
            if(interactiveObjectTemporary.x >= MovedStatics.placementX && MovedStatics.placementX + 8 > interactiveObjectTemporary.x && interactiveObjectTemporary.y >= MovedStatics.placementY && MovedStatics.placementY + 8 > interactiveObjectTemporary.y && Player.worldLevel == interactiveObjectTemporary.plane)
                interactiveObjectTemporary.duration = 0;
        }
    }
}
