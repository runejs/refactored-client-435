package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent to update the client's current carry weight.
 */
public class UpdateCarryWeightMessage implements InboundMessage {
    /**
     * The amount of weight carried.
     */
    public final int amount;

    /**
     * Constructs a new {@link UpdateCarryWeightMessage}.
     *
     * @param amount The new carried weight.
     */
    public UpdateCarryWeightMessage(int amount) {
        this.amount = amount;
    }
}
