package org.runejs.client.message.inbound.updating.registration;

/**
 * Registration details for a single NPC.
 */
public class NPCRegistration extends ActorRegistration {
    /**
     * The definition id of the NPC.
     * 
     * e.g. the index of the NPC in the cache.
     */
    public final int definitionId;

    public NPCRegistration(int index, int offsetX, int offsetY, int faceDirection, boolean updateRequired, boolean discardWalkingQueue, int definitionId) {
        super(index, offsetX, offsetY, faceDirection, updateRequired, discardWalkingQueue);
        this.definitionId = definitionId;
    }
}
