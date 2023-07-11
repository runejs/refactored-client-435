package org.runejs.client.message.handler.rs435.world;

import org.runejs.client.Class43;
import org.runejs.client.MovedStatics;
import org.runejs.client.Projectile;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.CreateProjectileInboundMessage;
import org.runejs.client.scene.Scene;

public class CreateProjectileMessageHandler implements MessageHandler<CreateProjectileInboundMessage> {
    @Override
    public void handle(CreateProjectileInboundMessage message) {
        int startY = message.y + MovedStatics.placementY;
        int startX = message.x + MovedStatics.placementX;
        int endX = startX + message.endX;
        int endY = startY + message.endY;

        if (startX >= 0 && startY >= 0 && startX < 104 && startY < 104 && endX >= 0 && endY >= 0 && endX < 104 && endY < 104 && message.gfxId != 65535) {
            endX = 64 + 128 * endX;
            startX = 64 + 128 * startX;
            startY = startY * 128 + 64;
            Projectile projectile = new Projectile(message.gfxId, Player.worldLevel, startX, startY, Scene.getFloorDrawHeight(Player.worldLevel, startX, startY) - message.startHeight, message.delay + MovedStatics.pulseCycle, message.speed + MovedStatics.pulseCycle, message.startSlope, message.startDistance, message.entityIndex, message.endHeight);
            endY = 128 * endY + 64;
            projectile.trackTarget(message.delay + MovedStatics.pulseCycle, 0, endY, Scene.getFloorDrawHeight(Player.worldLevel, endX, endY) - message.endHeight, endX);
            Class43.projectileQueue.addLast(projectile);
        }
    }
}
