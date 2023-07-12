package org.runejs.client.message.outbound.widget.input;

import org.runejs.client.message.OutboundMessage;

/**
 * Submit a name input into a chatbox widget, e.g. an "Enter name" widget.
 */
public class SubmitReportAbuseOutboundMessage implements OutboundMessage {
    /**
     * The name to send, as a long
     */
    public final long name;

    public final int reason;

    /**
     * Whether the player should be muted (if reporter is a moderator)
     */
    public final boolean mutePlayer;

    public SubmitReportAbuseOutboundMessage(long name, int reason, boolean mutePlayer) {
        this.name = name;
        this.reason = reason;
        this.mutePlayer = mutePlayer;
    }
}
