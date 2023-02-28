package org.runejs.client.message.handler.rs435.audio;

import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.audio.PlayQuickSongInboundMessage;
import org.runejs.client.sound.MusicSystem;

public class PlayQuickSongMessageHandler implements MessageHandler<PlayQuickSongInboundMessage> {
    @Override
    public void handle(PlayQuickSongInboundMessage message) {
        MusicSystem.playSoundJingle(message.songTimeout, message.songId);
    }
}
