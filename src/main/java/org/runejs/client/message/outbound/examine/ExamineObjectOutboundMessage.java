package org.runejs.client.message.outbound.examine;

import org.runejs.client.message.OutboundMessage;

/**
 * An {@link OutboundMessage} sent to the server to examine an object.
 */
public class ExamineObjectOutboundMessage implements OutboundMessage {
    /**
     * The id of the object to examine.
     */
    public final int objectId;

    /**
     * Creates a new {@link ExamineObjectOutboundMessage}.
     * @param objectId The id of the object to examine.
     */
    public ExamineObjectOutboundMessage(int objectId) {
        this.objectId = objectId;
    }
}
