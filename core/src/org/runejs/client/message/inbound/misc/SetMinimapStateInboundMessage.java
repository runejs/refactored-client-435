package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class SetMinimapStateInboundMessage implements InboundMessage {
    /**
     * The new minimap state.
     *
     * TODO (James) make an enum for this
     */
    public final int state;

    public SetMinimapStateInboundMessage(int state) {
        this.state = state;
    }
}
