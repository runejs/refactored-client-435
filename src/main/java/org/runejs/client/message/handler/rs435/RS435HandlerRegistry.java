package org.runejs.client.message.handler.rs435;

import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;

/**
 * A {@link MessageHandlerRegistry} for the RS revision 435 client.
 */
public class RS435HandlerRegistry extends MessageHandlerRegistry {
    public RS435HandlerRegistry() {
        super();

        register(UpdatePlayersInboundMessage.class, new UpdatePlayersMessageHandler());
    }
}
