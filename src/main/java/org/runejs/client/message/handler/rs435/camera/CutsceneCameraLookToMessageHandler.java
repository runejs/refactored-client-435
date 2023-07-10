package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.*;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraLookToInboundMessage;
import org.runejs.client.scene.Point3d;
import org.runejs.client.scene.Scene;

public class CutsceneCameraLookToMessageHandler implements MessageHandler<CutsceneCameraLookToInboundMessage> {
    @Override
    public void handle(CutsceneCameraLookToInboundMessage message) {
        Player.cutsceneActive = true;

        Main.cutsceneCamera.setLookAt(
            new Point3d(
                // convert tile coordinates to 3d coordinates
                64 + 128 * message.targetX,
                64 + 128 * message.targetY,
                message.height
            )
        );
        Main.cutsceneCamera.setTurnSpeed(message.speedBase, message.speedScale);

        // apply immediately
        if(message.speedScale >= 100) {
            int x = Main.cutsceneCamera.getLookAt().x;
            int y = Main.cutsceneCamera.getLookAt().y;
            int z = Scene.getFloorDrawHeight(Player.worldLevel, x, y) - Main.cutsceneCamera.getLookAt().z;

            Point3d cameraPos = Main.cutsceneCamera.getPosition();

            int deltaX = x - cameraPos.x;
            int deltaY = y - cameraPos.y;
            int deltaZ = z - cameraPos.z;

            int horizontalDistance = (int) Math.sqrt((double) (deltaY * deltaY + deltaX * deltaX));

            // (maybe) convert radians to 2048-step rotational unit
            Main.cutsceneCamera.setPitch((int) (325.949 * Math.atan2((double) deltaZ, (double) horizontalDistance)) & 0x7ff);
            Main.cutsceneCamera.setYaw((int) (-325.949 * Math.atan2((double) deltaX, (double) deltaY)) & 0x7ff);
        }
    }
}
