package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

public class SetChatOptionsOutboundMessage implements OutboundMessage {
    public final int publicMode;

    public final int privateMode;

    public final int tradeMode;

    public SetChatOptionsOutboundMessage(int publicMode, int privateMode, int tradeMode) {
        this.publicMode = publicMode;
        this.privateMode = privateMode;
        this.tradeMode = tradeMode;
    }
}
