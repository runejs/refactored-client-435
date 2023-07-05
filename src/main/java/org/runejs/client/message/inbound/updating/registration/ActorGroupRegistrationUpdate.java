package org.runejs.client.message.inbound.updating.registration;

/**
 * The update message containing details about a group of new actors that should be registered.
 */
public class ActorGroupRegistrationUpdate<TActorRegistration extends ActorRegistration> {

    /**
     * The list of new actors that should be registered.
     */
    public final TActorRegistration[] players;

    public ActorGroupRegistrationUpdate(TActorRegistration[] players) {
        this.players = players;
    }
}
