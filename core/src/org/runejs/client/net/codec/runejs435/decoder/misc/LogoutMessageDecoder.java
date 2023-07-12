package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.LogoutMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link LogoutMessage}s.
 */
public class LogoutMessageDecoder implements MessageDecoder<LogoutMessage> {
    @Override
    public LogoutMessage decode(PacketBuffer buffer) {
        return new LogoutMessage();
    }
}
