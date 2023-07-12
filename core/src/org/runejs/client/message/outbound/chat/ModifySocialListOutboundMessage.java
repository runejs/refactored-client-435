package org.runejs.client.message.outbound.chat;

import org.runejs.client.message.OutboundMessage;

/**
 * This message represents an attempt to modify the friend/ignore list,
 * i.e. adding or removing people from them.
 */
public class ModifySocialListOutboundMessage implements OutboundMessage {
    /**
     * The list to modify.
     */
    public enum SocialList {
        FRIEND,
        IGNORE
    }

    /**
     * The action to perform on the list.
     */
    public enum SocialListAction {
        ADD,
        REMOVE
    }

    /**
     * The target to add or remove from the list.
     */
    public final long target;

    /**
     * The list to modify.
     */
    public final SocialList list;

    /**
     * The action to perform on the list.
     */
    public final SocialListAction action;

    /**
     * Create a new {@link ModifySocialListOutboundMessage}
     * @param target The target to add or remove from the list.
     * @param list The list to modify.
     * @param action The action to perform on the list.
     */
    public ModifySocialListOutboundMessage(long target, SocialList list, SocialListAction action) {
        this.target = target;
        this.list = list;
        this.action = action;
    }
}
