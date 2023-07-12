package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.message.OutboundMessage;

/**
 * Submit a name input into a chatbox widget, e.g. an "Enter name" widget.
 */
public class SubmitChatboxWidgetNameInputOutboundMessage implements OutboundMessage {
    /**
     * The name to send, as a long
     */
    public final long name;

    public SubmitChatboxWidgetNameInputOutboundMessage(long name) {
        this.name = name;
    }
}
