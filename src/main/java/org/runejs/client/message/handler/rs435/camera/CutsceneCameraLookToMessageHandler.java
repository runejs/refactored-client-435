package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.*;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraLookToInboundMessage;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.scene.SceneCluster;

public class CutsceneCameraLookToMessageHandler implements MessageHandler<CutsceneCameraLookToInboundMessage> {
    @Override
    public void handle(CutsceneCameraLookToInboundMessage message) {
        Player.cutsceneActive = true;
        MovedStatics.anInt564 = message.targetX;
        MovedStatics.anInt2576 = message.targetY;
        MovedStatics.anInt892 = message.height;
        Class60.cutsceneCameraRotationBaseAdjust = message.speedBase;
        MovedStatics.cutsceneCameraRotationScaleAdjust = message.speedScale;
        if(MovedStatics.cutsceneCameraRotationScaleAdjust >= 100) {
            int x = 128 * MovedStatics.anInt564 + 64;
            int y = 128 * MovedStatics.anInt2576 + 64;
            int z = Class37.getFloorDrawHeight(Player.worldLevel, x, y) - MovedStatics.anInt892;

            int deltaX = x - SceneCamera.cameraX;
            int deltaY = y - SceneCamera.cameraY;
            int deltaZ = z - SceneCamera.cameraZ;

            int horizontalDistance = (int) Math.sqrt((double) (deltaY * deltaY + deltaX * deltaX));

            // (maybe) convert radians to 2048-step rotational unit
            SceneCamera.cameraVerticalRotation = (int) (325.949 * Math.atan2((double) deltaZ, (double) horizontalDistance)) & 0x7ff;
            SceneCamera.cameraHorizontalRotation = (int) (-325.949 * Math.atan2((double) deltaX, (double) deltaY)) & 0x7ff;

            if(SceneCamera.cameraVerticalRotation < 128)
                SceneCamera.cameraVerticalRotation = 128;
            if(SceneCamera.cameraVerticalRotation > 383)
                SceneCamera.cameraVerticalRotation = 383;
        }
    }
}
