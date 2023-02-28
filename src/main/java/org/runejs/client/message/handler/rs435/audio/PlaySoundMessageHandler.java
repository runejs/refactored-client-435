package org.runejs.client.message.handler.rs435.audio;

import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.audio.PlaySoundInboundMessage;
import org.runejs.client.sound.SoundSystem;

public class PlaySoundMessageHandler implements MessageHandler<PlaySoundInboundMessage> {
    @Override
    public void handle(PlaySoundInboundMessage message) {

        SoundSystem.play(message.soundId, message.volume, message.delay);
    }
}
