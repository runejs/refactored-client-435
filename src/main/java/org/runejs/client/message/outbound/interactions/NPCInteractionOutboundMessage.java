package org.runejs.client.message.outbound.interactions;

import org.runejs.client.message.OutboundMessage;

/**
 * Represents a message sent to the server when a player interacts with an NPC.
 * 
 * e.g. talking, trading or pickpocketing
 */
public class NPCInteractionOutboundMessage implements OutboundMessage {
    /**
     * Which option on the npc was clicked
     * 
     * i.e. 1 = first option, 2 = second option, etc.
     */
    public final int option;

    /**
     * The index of the npc
     */
    public final int npcIndex;

    public NPCInteractionOutboundMessage(int option, int npcIndex) {
        this.option = option;
        this.npcIndex = npcIndex;
    }
}
