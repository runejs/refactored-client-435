package org.runejs.client.message.handler.rs435.camera;

import org.runejs.client.GameShell;
import org.runejs.client.MovedStatics;
import org.runejs.client.Projectile;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.camera.ShakeCameraInboundMessage;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.SceneCamera;

public class ShakeCameraMessageHandler implements MessageHandler<ShakeCameraInboundMessage> {
    @Override
    public void handle(ShakeCameraInboundMessage message) {
        /**
         * 0: east to west
         * 1: up down
         * 2: north to south
         * 3: yaw
         * 4: pitch
         */
        SceneCamera.customCameraActive[message.cameraType] = true;
        SceneCamera.customCameraJitter[message.cameraType] = message.jitter;
        SceneCamera.customCameraAmplitude[message.cameraType] = message.amplitude;
        SceneCamera.customCameraFrequency[message.cameraType] = message.frequency;
        SceneCamera.customCameraTimer[message.cameraType] = 0;
    }
}
