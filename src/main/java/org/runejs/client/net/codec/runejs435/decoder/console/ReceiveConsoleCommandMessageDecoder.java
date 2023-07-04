package org.runejs.client.net.codec.runejs435.decoder.console;

import org.runejs.client.message.inbound.console.ReceiveConsoleCommandMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link ReceiveConsoleCommandMessage}s.
 */
public class ReceiveConsoleCommandMessageDecoder implements MessageDecoder<ReceiveConsoleCommandMessage> {
    @Override
    public ReceiveConsoleCommandMessage decode(PacketBuffer buffer) {
        String command = buffer.getString();
        String help = buffer.getString();

        return new ReceiveConsoleCommandMessage(command, help);
    }
}
