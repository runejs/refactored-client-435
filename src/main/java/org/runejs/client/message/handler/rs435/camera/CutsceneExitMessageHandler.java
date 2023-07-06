package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.Projectile;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.CutsceneExitInboundMessage;

public class CutsceneExitMessageHandler implements MessageHandler<CutsceneExitInboundMessage> {
    @Override
    public void handle(CutsceneExitInboundMessage message) {
        Player.cutsceneActive = false;
        for(int cameraType = 0; cameraType < 5; cameraType++)
            Projectile.customCameraActive[cameraType] = false;
    }
}
