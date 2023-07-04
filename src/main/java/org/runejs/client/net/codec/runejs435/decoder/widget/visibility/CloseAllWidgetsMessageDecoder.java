package org.runejs.client.net.codec.runejs435.decoder.widget.visibility;

import org.runejs.client.message.inbound.widget.visibility.CloseAllWidgetsInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Decodes {@link CloseAllWidgetsInboundMessage}.
 * 
 * This message has no properties.
 */
public class CloseAllWidgetsMessageDecoder implements MessageDecoder<CloseAllWidgetsInboundMessage> {
    @Override
    public CloseAllWidgetsInboundMessage decode(PacketBuffer buffer) {
        return new CloseAllWidgetsInboundMessage();
    }
}
