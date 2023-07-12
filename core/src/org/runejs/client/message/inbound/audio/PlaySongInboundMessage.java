package org.runejs.client.message.inbound.audio;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the client to the server to play a song
 */
public class PlaySongInboundMessage implements InboundMessage {
    /**
     * The song id to play
     */
    public final int songId;

    /**
     * Creates a new PlaySongInboundMessage
     */
    public PlaySongInboundMessage(int songId) {
        this.songId = songId;
    }
}
