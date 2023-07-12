package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.MovedStatics;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.SetMultiCombatStateInboundMessage;

public class SetMultiCombatStateMessageHandler implements MessageHandler<SetMultiCombatStateInboundMessage> {
    @Override
    public void handle(SetMultiCombatStateInboundMessage message) {
        MovedStatics.multiCombatState = message.state;
    }
}
