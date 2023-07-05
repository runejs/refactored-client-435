package org.runejs.client.message.inbound.updating;

import org.runejs.client.message.InboundMessage;
import org.runejs.client.message.inbound.updating.movement.ActorGroupMovementUpdate;
import org.runejs.client.message.inbound.updating.movement.LocalPlayerMovementUpdate;
import org.runejs.client.message.inbound.updating.registration.RegisterNewPlayersUpdate;
import org.runejs.client.net.PacketBuffer;

/**
 * The inbound message containing updates for all players, including the local player.
 */
public class UpdatePlayersInboundMessage implements InboundMessage {
    /**
     * The movement update for the local player.
     */
    public final LocalPlayerMovementUpdate localPlayerMovement;

    /**
     * The movement updates for all non-local players.
     */
    public final ActorGroupMovementUpdate otherPlayersMovement;

    /**
     * The new players to register.
     */
    public final RegisterNewPlayersUpdate newPlayers;

    /**
     * The appearance updates for the players.
     * 
     * TODO (James) we should create a class to contain this rather than using a `PacketBuffer`,
     * but it's a lot of work for now. Revisit this later.
     */
    public final PacketBuffer appearanceUpdates;

    public UpdatePlayersInboundMessage(LocalPlayerMovementUpdate localPlayerMovement, ActorGroupMovementUpdate otherPlayersMovement, RegisterNewPlayersUpdate newPlayers, PacketBuffer appearanceUpdates) {
        this.localPlayerMovement = localPlayerMovement;
        this.otherPlayersMovement = otherPlayersMovement;
        this.newPlayers = newPlayers;
        this.appearanceUpdates = appearanceUpdates;
    }
}
