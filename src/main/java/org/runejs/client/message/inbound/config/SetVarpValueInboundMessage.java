package org.runejs.client.message.inbound.config;

import org.runejs.client.message.InboundMessage;

/**
 * Sets a varp to a given value.
 *
 * Note that this message relates to two packets: one with the value
 * as a byte, and one with the value as an int.
 */
public class SetVarpValueInboundMessage implements InboundMessage {
    public final int index;

    public final int value;

    public SetVarpValueInboundMessage(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
