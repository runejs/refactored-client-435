package org.runejs.client.net.codec.runejs435.decoder.updating;

import org.runejs.client.message.inbound.updating.ClearLocalPlayerDestinationInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Clear the local player's walking destination (i.e. the flag on the minimap)
 *
 * This message has no properties.
 */
public class ClearLocalPlayerDestinationMessageDecoder implements MessageDecoder<ClearLocalPlayerDestinationInboundMessage> {
    @Override
    public ClearLocalPlayerDestinationInboundMessage decode(PacketBuffer buffer) {
        return new ClearLocalPlayerDestinationInboundMessage();
    }
}
