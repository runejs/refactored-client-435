package org.runejs.client.message.inbound.updating;

import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.registration.ActorGroupRegistrationUpdate;
import org.runejs.client.message.inbound.updating.registration.NPCRegistration;
import org.runejs.client.net.PacketBuffer;

public class UpdateNPCsInboundMessage implements InboundMessage {
    public final ActorGroupMovementUpdate trackedNPCMovement;

    /**
     * The new NPCs to register.
     */
    public final ActorGroupRegistrationUpdate<NPCRegistration> newNPCs;

    /**
     * The appearance updates for the NPCs.
     *
     * TODO (James) we should create a class to contain this rather than using a `PacketBuffer`,
     * but it's a lot of work for now. Revisit this later.
     */
    public final PacketBuffer appearanceUpdates;

    public UpdateNPCsInboundMessage(
        ActorGroupMovementUpdate trackedNPCMovement,
        ActorGroupRegistrationUpdate<NPCRegistration> newNPCs,
        PacketBuffer appearanceUpdates
    ) {
        this.trackedNPCMovement = trackedNPCMovement;
        this.newNPCs = newNPCs;
        this.appearanceUpdates = appearanceUpdates;
    }
}
