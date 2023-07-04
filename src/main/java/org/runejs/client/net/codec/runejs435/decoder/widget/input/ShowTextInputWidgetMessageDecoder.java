package org.runejs.client.net.codec.runejs435.decoder.widget.input;

import org.runejs.client.message.inbound.widget.input.ShowTextInputWidgetInboundMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * Shows the "Enter name:" input.
 *
 * This message has no properties.
 */
public class ShowTextInputWidgetMessageDecoder implements MessageDecoder<ShowTextInputWidgetInboundMessage> {
    @Override
    public ShowTextInputWidgetInboundMessage decode(PacketBuffer buffer) {
        return new ShowTextInputWidgetInboundMessage();
    }
}
