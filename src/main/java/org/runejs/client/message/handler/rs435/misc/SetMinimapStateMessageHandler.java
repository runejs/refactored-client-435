package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetMinimapStateInboundMessage;

public class SetMinimapStateMessageHandler implements MessageHandler<SetMinimapStateInboundMessage> {
    @Override
    public void handle(SetMinimapStateInboundMessage message) {
        MovedStatics.minimapState = message.state;
    }
}
