package org.runejs.client.message.outbound.magic;

import org.runejs.client.message.OutboundMessage;

/**
 * A message sent to the server to cast a magic spell on a NPC.
 */
public class CastMagicOnNPCOutboundMessage extends BaseCastMagicOutboundMessage implements OutboundMessage {
    /**
     * The id of the NPC to cast the spell on.
     */
    public final int npcId;

    /**
     * Creates a new {@link CastMagicOnNPCOutboundMessage}.
     * @param spellId The id of the spell to cast.
     * @param npcId The id of the NPC to cast the spell on.
     */
    public CastMagicOnNPCOutboundMessage(int spellId, int npcId) {
        super(spellId);
        this.npcId = npcId;
    }
}
