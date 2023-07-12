package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.Game;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraMoveToInboundMessage;
import org.runejs.client.scene.Point3d;
import org.runejs.client.scene.Scene;

public class CutsceneCameraMoveToMessageHandler implements MessageHandler<CutsceneCameraMoveToInboundMessage> {
    @Override
    public void handle(CutsceneCameraMoveToInboundMessage message) {
        Player.cutsceneActive = true;

        Game.cutsceneCamera.setMoveTo(
            new Point3d(
                // convert tile coordinates to 3d coordinates
                64 + 128 * message.targetX,
                64 + 128 * message.targetY,
                message.height
            )
        );
        Game.cutsceneCamera.setMovementSpeed(message.speedBase, message.speedScale);

        if(message.speedScale >= 100) {
            int x = Game.cutsceneCamera.getMoveTo().x;
            int y = Game.cutsceneCamera.getMoveTo().y;
            int z = Game.currentScene.getFloorDrawHeight(Player.worldLevel, x, y) - Game.cutsceneCamera.getMoveTo().z;

            Game.cutsceneCamera.setPosition(new Point3d(x, y, z));
        }
    }
}
