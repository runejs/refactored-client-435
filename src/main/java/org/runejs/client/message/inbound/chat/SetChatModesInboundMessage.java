package org.runejs.client.message.inbound.chat;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent from the server to the client to set the chat modes.
 * 
 * For example, this is used to set the chat modes to public, friends, and private.
 */
public class SetChatModesInboundMessage implements InboundMessage {
    /**
     * The public chat mode.
     */
    public final int publicChatMode;
    
    /**
     * The private chat mode.
     */
    public final int privateChatMode;
    
    /**
     * The trade mode.
     */
    public final int tradeMode;

    /**
     * Constructs a new SetChatModesInboundMessage
     * 
     * @param publicChatMode The public chat mode.
     * @param privateChatMode The private chat mode.
     * @param tradeMode The trade mode.
     */
    public SetChatModesInboundMessage(int publicChatMode, int privateChatMode, int tradeMode) {
        this.publicChatMode = publicChatMode;
        this.privateChatMode = privateChatMode;
        this.tradeMode = tradeMode;
    }
}
