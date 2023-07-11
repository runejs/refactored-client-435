package org.runejs.client.message.handler.rs435;

import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.BulkInboundMessage;

/**
 * Handles a bulk message.
 *
 * Some of this code is similar to the handling step in IncomingPackets. We could probably reuse some of it.
 */
public class BulkMessageHandler implements MessageHandler<BulkInboundMessage> {
    @Override
    public void handle(BulkInboundMessage message) {
        MovedStatics.placementX = message.x;
        MovedStatics.placementY = message.y;

        for (InboundMessage childMessage : message.messages) {
            MessageHandler handler = Game.handlerRegistry.getMessageHandler(childMessage.getClass());

            if (handler == null)
                throw new RuntimeException("No handler for message: " + childMessage.getClass().getName());

            handler.handle(childMessage);
        }
    }
}
