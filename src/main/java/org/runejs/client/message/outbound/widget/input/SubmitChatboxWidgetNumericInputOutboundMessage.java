package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.message.OutboundMessage;

/**
 * Submit a numeric input into a chatbox widget, e.g. an "Enter amount" widget.
 */
public class SubmitChatboxWidgetNumericInputOutboundMessage implements OutboundMessage {
    public final int value;

    public SubmitChatboxWidgetNumericInputOutboundMessage(int value) {
        this.value = value;
    }
}
