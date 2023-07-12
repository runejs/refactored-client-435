package org.runejs.client.message.handler.rs435.world;

import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.world.PlaySoundAtPositionInboundMessage;
import org.runejs.client.sound.SoundSystem;

public class PlaySoundAtPositionMessageHandler implements MessageHandler<PlaySoundAtPositionInboundMessage> {
    @Override
    public void handle(PlaySoundAtPositionInboundMessage message) {
        int localY = message.y + MovedStatics.placementY;
        int localX = message.x + MovedStatics.placementX;

        if (localX >= 0 && localY >= 0 && localX < 104 && localY < 104) {
            int i_26_ = 1 + message.radius;
            if (Player.localPlayer.pathY[0] >= localX - i_26_ && Player.localPlayer.pathY[0] <= localX + i_26_ && localY - i_26_ <= Player.localPlayer.pathX[0] && localY + i_26_ >= Player.localPlayer.pathX[0]) {
                SoundSystem.play(message.soundId, message.volume, message.delay, message.radius + (localY << 8) + (localX << 16));
            }
        }
    }
}
