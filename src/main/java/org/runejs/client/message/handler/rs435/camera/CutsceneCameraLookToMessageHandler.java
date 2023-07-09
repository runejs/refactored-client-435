package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.*;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraLookToInboundMessage;
import org.runejs.client.scene.SceneCamera;

public class CutsceneCameraLookToMessageHandler implements MessageHandler<CutsceneCameraLookToInboundMessage> {
    @Override
    public void handle(CutsceneCameraLookToInboundMessage message) {
        Player.cutsceneActive = true;
        SceneCamera.cutscene.lookToTileX = message.targetX;
        SceneCamera.cutscene.lookToTileY = message.targetY;
        SceneCamera.cutscene.lookToHeight = message.height;
        SceneCamera.cutscene.rotationBaseAdjust = message.speedBase;
        SceneCamera.cutscene.rotationScaleAdjust = message.speedScale;
        if(SceneCamera.cutscene.rotationScaleAdjust >= 100) {
            int x = 128 * SceneCamera.cutscene.lookToTileX + 64;
            int y = 128 * SceneCamera.cutscene.lookToTileY + 64;
            int z = Class37.getFloorDrawHeight(Player.worldLevel, x, y) - SceneCamera.cutscene.lookToHeight;

            int deltaX = x - SceneCamera.cameraX;
            int deltaY = y - SceneCamera.cameraY;
            int deltaZ = z - SceneCamera.cameraZ;

            int horizontalDistance = (int) Math.sqrt((double) (deltaY * deltaY + deltaX * deltaX));

            // (maybe) convert radians to 2048-step rotational unit
            SceneCamera.cameraPitch = (int) (325.949 * Math.atan2((double) deltaZ, (double) horizontalDistance)) & 0x7ff;
            SceneCamera.cameraYaw = (int) (-325.949 * Math.atan2((double) deltaX, (double) deltaY)) & 0x7ff;

            SceneCamera.clampPitch();
        }
    }
}
