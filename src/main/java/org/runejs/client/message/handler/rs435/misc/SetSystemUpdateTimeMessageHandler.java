package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.Class40_Sub5_Sub15;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetSystemUpdateTimeInboundMessage;

public class SetSystemUpdateTimeMessageHandler implements MessageHandler<SetSystemUpdateTimeInboundMessage> {
    @Override
    public void handle(SetSystemUpdateTimeInboundMessage message) {
        Class40_Sub5_Sub15.systemUpdateTime = message.time;
    }
}
