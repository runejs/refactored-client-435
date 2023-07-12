package org.runejs.client.net.codec.runejs435.decoder.console;

import org.runejs.client.RSString;
import org.runejs.client.message.inbound.console.ReceiveConsoleLogMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link ReceiveConsoleLogMessage}s.
 */
public class ReceiveConsoleLogMessageDecoder implements MessageDecoder<ReceiveConsoleLogMessage> {
    @Override
    public ReceiveConsoleLogMessage decode(PacketBuffer buffer) {
        RSString message = buffer.getRSString();

        return new ReceiveConsoleLogMessage(message);
    }
}
