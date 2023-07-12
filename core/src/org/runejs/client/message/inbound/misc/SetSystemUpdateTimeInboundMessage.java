package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class SetSystemUpdateTimeInboundMessage implements InboundMessage {
    /**
     * The time until the system update occurs.
     */
    public final int time;

    public SetSystemUpdateTimeInboundMessage(int time) {
        this.time = time;
    }
}
