package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.Class37;
import org.runejs.client.Class59;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneCameraMoveToInboundMessage;
import org.runejs.client.scene.SceneCamera;

public class CutsceneCameraMoveToMessageHandler implements MessageHandler<CutsceneCameraMoveToInboundMessage> {
    @Override
    public void handle(CutsceneCameraMoveToInboundMessage message) {
        Player.cutsceneActive = true;
        // cutscene camera will be positioned on this tile in the region
        SceneCamera.cutscene.tilePosX = message.targetX;
        SceneCamera.cutscene.tilePosY = message.targetY;
        SceneCamera.cutscene.height = message.height;
        SceneCamera.cutscene.positionBaseAdjust = message.speedBase;
        SceneCamera.cutscene.positionScaleAdjust = message.speedScale;
        if(SceneCamera.cutscene.positionScaleAdjust >= 100) {
            SceneCamera.cameraY = 64 + SceneCamera.cutscene.tilePosY * 128;
            SceneCamera.cameraX = SceneCamera.cutscene.tilePosX * 128 + 64;
            SceneCamera.cameraZ = Class37.getFloorDrawHeight(Player.worldLevel, SceneCamera.cameraX, SceneCamera.cameraY) - SceneCamera.cutscene.height;
        }
    }
}
