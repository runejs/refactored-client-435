package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetSystemUpdateTimeInboundMessage;

public class SetSystemUpdateTimeMessageHandler implements MessageHandler<SetSystemUpdateTimeInboundMessage> {
    @Override
    public void handle(SetSystemUpdateTimeInboundMessage message) {
        MovedStatics.systemUpdateTime = message.time;
    }
}
