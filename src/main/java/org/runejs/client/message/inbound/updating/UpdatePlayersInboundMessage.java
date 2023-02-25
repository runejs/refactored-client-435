package org.runejs.client.message.inbound.updating;

import org.runejs.client.message.InboundMessage;
import org.runejs.client.net.PacketBuffer;

public class UpdatePlayersInboundMessage implements InboundMessage {
    public final LocalPlayerMovementUpdate localPlayerMovement;
    public final OtherPlayersMovementUpdate otherPlayersMovement;
    public final RegisterNewPlayersUpdate newPlayers;

    /**
     * The appearance updates for the players.
     * 
     * TODO (James) we should create proper classes for this, but it's too much work for now.
     */
    public final PacketBuffer appearanceUpdates;

    public UpdatePlayersInboundMessage(LocalPlayerMovementUpdate localPlayerMovement, OtherPlayersMovementUpdate otherPlayersMovement, RegisterNewPlayersUpdate newPlayers, PacketBuffer appearanceUpdates) {
        this.localPlayerMovement = localPlayerMovement;
        this.otherPlayersMovement = otherPlayersMovement;
        this.newPlayers = newPlayers;
        this.appearanceUpdates = appearanceUpdates;
    }
}
