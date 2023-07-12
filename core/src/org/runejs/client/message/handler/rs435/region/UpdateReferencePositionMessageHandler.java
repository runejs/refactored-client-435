package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.UpdateReferencePositionInboundMessage;

/**
 * Updates the reference position of the client.
 */
public class UpdateReferencePositionMessageHandler implements MessageHandler<UpdateReferencePositionInboundMessage> {
    @Override
    public void handle(UpdateReferencePositionInboundMessage message) {
        MovedStatics.placementX = message.x;
        MovedStatics.placementY = message.y;
    }
}
