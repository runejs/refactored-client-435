package org.runejs.client.net.codec.runejs435.decoder.widget.input;

import org.runejs.client.message.inbound.widget.input.ShowNumberInputWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Shows the "Enter amount:" input.
 *
 * This message has no properties.
 */
public class ShowNumberInputWidgetMessageDecoder implements MessageDecoder<ShowNumberInputWidgetInboundMessage> {
    @Override
    public ShowNumberInputWidgetInboundMessage decode(PacketBuffer buffer) {
        return new ShowNumberInputWidgetInboundMessage();
    }
}
