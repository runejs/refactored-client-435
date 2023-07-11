package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.frame.Minimap;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetMinimapStateInboundMessage;

public class SetMinimapStateMessageHandler implements MessageHandler<SetMinimapStateInboundMessage> {
    @Override
    public void handle(SetMinimapStateInboundMessage message) {
        Minimap.minimapState = message.state;
    }
}
