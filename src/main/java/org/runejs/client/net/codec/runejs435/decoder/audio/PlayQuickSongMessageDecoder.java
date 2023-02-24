package org.runejs.client.net.codec.runejs435.decoder.audio;

import org.runejs.client.message.inbound.audio.PlaySongInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes the PlayQuickSong message
 */
public class PlayQuickSongMessageDecoder implements MessageDecoder<PlaySongInboundMessage> {
    @Override
    public PlaySongInboundMessage decode(PacketBuffer buffer) {
        int songId = buffer.getUnsignedShortLE();
        if(songId == 65535)
            songId = -1;

        return new PlaySongInboundMessage(songId);
    }
}
