package org.runejs.client.message.handler.rs435.world;

import org.runejs.client.SpotAnim;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.CreateStationaryGFXInboundMessage;
import org.runejs.client.scene.Scene;

public class CreateStationaryGFXMessageHandler implements MessageHandler<CreateStationaryGFXInboundMessage> {
    @Override
    public void handle(CreateStationaryGFXInboundMessage message) {
        int x = message.x + MovedStatics.placementX;
        int y = message.y + MovedStatics.placementY;
        if (x >= 0 && y >= 0 && x < 104 && y < 104) {
            y = 128 * y + 64;
            x = x * 128 + 64;
            SpotAnim gfx = new SpotAnim(message.id, Player.worldLevel, x, y, -message.drawHeight + Scene.getFloorDrawHeight(Player.worldLevel, x, y), message.delay, MovedStatics.pulseCycle);
            MovedStatics.aLinkedList_1332.addLast(gfx);
        }
    }
}
