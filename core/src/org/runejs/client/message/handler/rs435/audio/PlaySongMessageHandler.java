package org.runejs.client.message.handler.rs435.audio;

import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.audio.PlaySongInboundMessage;
import org.runejs.client.sound.MusicSystem;

public class PlaySongMessageHandler implements MessageHandler<PlaySongInboundMessage> {
    @Override
    public void handle(PlaySongInboundMessage message) {
        MusicSystem.playSong(message.songId);
    }
}
