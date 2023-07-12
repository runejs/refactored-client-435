package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class UpdatePlayerOptionsInboundMessage implements InboundMessage {
    /**
     * The option to update.
     */
    public final int index;

    /**
     * The text of the option.
     */
    public final String option;

    /**
     * Used to push options to the bottom.
     */
    public final boolean lowPriority;

    public UpdatePlayerOptionsInboundMessage(int index, String option, boolean lowPriority) {
        this.index = index;
        this.option = option;
        this.lowPriority = lowPriority;
    }
}
