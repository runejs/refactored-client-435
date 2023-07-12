package org.runejs.client.net.codec.runejs435.decoder.world;

import org.runejs.client.message.inbound.world.PlaySoundAtPositionInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class PlaySoundAtPositionMessageDecoder implements MessageDecoder<PlaySoundAtPositionInboundMessage> {
    @Override
    public PlaySoundAtPositionInboundMessage decode(PacketBuffer buffer) {
        int offset = buffer.getUnsignedByte();
        int y = (offset & 0x7);
        int x = (0x7 & offset >> 4);
        int soundId = buffer.getUnsignedShortBE();

        int soundData = buffer.getUnsignedByte();
        int radius = soundData >> 4 & 0xf;
        int volume = 0x7 & soundData;
        int delay = buffer.getUnsignedByte();

        return new PlaySoundAtPositionInboundMessage(x, y, soundId, radius, volume, delay);
    }
}
