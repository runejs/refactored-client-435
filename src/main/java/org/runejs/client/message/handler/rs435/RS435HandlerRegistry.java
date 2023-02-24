package org.runejs.client.message.handler.rs435;

import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.handler.rs435.audio.PlaySongMessageHandler;
import org.runejs.client.message.inbound.audio.PlaySongInboundMessage;

public class RS435HandlerRegistry extends MessageHandlerRegistry {
    public RS435HandlerRegistry() {
        register(PlaySongInboundMessage.class, new PlaySongMessageHandler());
    }
}
