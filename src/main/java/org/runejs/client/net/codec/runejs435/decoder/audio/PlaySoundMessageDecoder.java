package org.runejs.client.net.codec.runejs435.decoder.audio;

import org.runejs.client.message.inbound.audio.PlaySoundInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes the PlaySoundInboundMessage
 */
public class PlaySoundMessageDecoder implements MessageDecoder<PlaySoundInboundMessage> {
    @Override
    public PlaySoundInboundMessage decode(PacketBuffer buffer) {
        int soundId = buffer.getUnsignedShortBE();
        int volume = buffer.getUnsignedByte();
        int delay = buffer.getUnsignedShortBE();

        return new PlaySoundInboundMessage(soundId, volume, delay);
    }
}
