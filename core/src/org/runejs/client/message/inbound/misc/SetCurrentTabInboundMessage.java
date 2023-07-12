package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

public class SetCurrentTabInboundMessage implements InboundMessage {
    /**
     * The new tab id;
     */
    public final int tabId;

    public SetCurrentTabInboundMessage(int tabId) {
        this.tabId = tabId;
    }
}
