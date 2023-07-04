package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent to update the client's run energy amount.
 */
public class UpdateRunEnergyMessage implements InboundMessage {
    /**
     * The amount of run energy.
     */
    public final int amount;

    /**
     * Constructs a new {@link UpdateRunEnergyMessage}.
     *
     * @param amount The new run energy amount.
     */
    public UpdateRunEnergyMessage(int amount) {
        this.amount = amount;
    }
}
