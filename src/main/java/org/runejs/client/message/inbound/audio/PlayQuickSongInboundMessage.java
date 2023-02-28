package org.runejs.client.message.inbound.audio;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the client to the server to play a song
 */
public class PlayQuickSongInboundMessage implements InboundMessage {
    /**
     * The song id to play
     */
    public final int songId;

    /**
     * The song timeout.
     */
    public final int songTimeout;

    /**
     * Creates a new PlaySongInboundMessage
     */
    public PlayQuickSongInboundMessage(int songId, int songTimeout) {
        this.songId = songId;
        this.songTimeout = songTimeout;
    }
}
