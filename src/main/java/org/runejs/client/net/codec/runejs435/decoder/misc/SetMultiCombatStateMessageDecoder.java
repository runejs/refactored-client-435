package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.SetMultiCombatStateInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

public class SetMultiCombatStateMessageDecoder implements MessageDecoder<SetMultiCombatStateInboundMessage> {
    @Override
    public SetMultiCombatStateInboundMessage decode(PacketBuffer buffer) {
        int multiCombatState = buffer.getUnsignedByte();
        return new SetMultiCombatStateInboundMessage(multiCombatState);
    }
}
