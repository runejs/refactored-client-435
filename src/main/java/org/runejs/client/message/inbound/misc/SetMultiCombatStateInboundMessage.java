package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class SetMultiCombatStateInboundMessage implements InboundMessage {
    /**
     * The new multi combat state.
     *
     * TODO (James) make an enum for this
     */
    public final int state;

    public SetMultiCombatStateInboundMessage(int state) {
        this.state = state;
    }
}
