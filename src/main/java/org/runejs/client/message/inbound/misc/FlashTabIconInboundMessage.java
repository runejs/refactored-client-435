package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * Flashes the tab icon of the specified tab.
 */
public class FlashTabIconInboundMessage implements InboundMessage {
    public final int tabId;

    public FlashTabIconInboundMessage(int tabId) {
        this.tabId = tabId;
    }
}
