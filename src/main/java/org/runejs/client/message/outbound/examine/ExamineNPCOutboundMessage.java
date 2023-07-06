package org.runejs.client.message.outbound.examine;

import org.runejs.client.message.OutboundMessage;

/**
 * An {@link OutboundMessage} sent to the server to examine an NPC.
 */
public class ExamineNPCOutboundMessage implements OutboundMessage {
    /**
     * The id of the NPC to examine.
     */
    public final int npcId;

    /**
     * Creates a new {@link ExamineNPCOutboundMessage}.
     * @param npcId The id of the NPC to examine.
     */
    public ExamineNPCOutboundMessage(int npcId) {
        this.npcId = npcId;
    }
}
