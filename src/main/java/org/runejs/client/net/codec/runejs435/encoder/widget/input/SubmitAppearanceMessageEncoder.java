package org.runejs.client.net.codec.runejs435.encoder.widget.input;

import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.outbound.widget.input.SubmitAppearanceOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageEncoder;

public class SubmitAppearanceMessageEncoder implements MessageEncoder<SubmitAppearanceOutboundMessage> {
    @Override
    public PacketBuffer encode(SubmitAppearanceOutboundMessage message) {
        PacketBuffer buffer = OutgoingPackets.openFixedSizePacket(13, 231);

        buffer.putByte(message.appearance.isFemale ? 1 : 0);
        for(int i = 0; i < 7; i++) {
            int i_0_ = message.appearance.appearance[PlayerAppearance.APPEARANCE_INDICES[i]];
            if(i_0_ != 0)
                buffer.putByte(-256 + i_0_);
            else
                buffer.putByte(-1);
        }
        for(int i = 0; i < 5; i++)
            buffer.putByte(message.appearance.appearanceColors[i]);

        return buffer;
    }
}
