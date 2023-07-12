package org.runejs.client.message.handler.rs435.updating;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.updating.ClearLocalPlayerDestinationInboundMessage;

public class ClearLocalPlayerDestinationMessageHandler implements MessageHandler<ClearLocalPlayerDestinationInboundMessage> {
    @Override
    public void handle(ClearLocalPlayerDestinationInboundMessage message) {
        MovedStatics.destinationX = 0;
    }
}
