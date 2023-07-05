package org.runejs.client.message.outbound.misc;

import org.runejs.client.message.OutboundMessage;

/**
 * Sent when the user clicks/opens a flashing tab icon.
 */
public class ClickFlashingTabIconOutboundMessage implements OutboundMessage {
    public final int tabId;

    public ClickFlashingTabIconOutboundMessage(int tabId) {
        this.tabId = tabId;
    }
}
