package org.runejs.client.message.handler.rs435;

import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.handler.rs435.chat.*;
import org.runejs.client.message.inbound.chat.*;
import org.runejs.client.message.handler.rs435.audio.PlayQuickSongMessageHandler;
import org.runejs.client.message.handler.rs435.audio.PlaySongMessageHandler;
import org.runejs.client.message.handler.rs435.audio.PlaySoundMessageHandler;
import org.runejs.client.message.inbound.audio.PlayQuickSongInboundMessage;
import org.runejs.client.message.inbound.audio.PlaySongInboundMessage;
import org.runejs.client.message.inbound.audio.PlaySoundInboundMessage;

/**
 * A {@link MessageHandlerRegistry} for the RS revision 435 client.
 */
public class RS435HandlerRegistry extends MessageHandlerRegistry {
    public RS435HandlerRegistry() {
        register(ReceivePrivateMessageInboundMessage.class, new ReceivePrivateMessageHandler());
        register(ReceiveChatboxMessageInboundMessage.class, new ReceiveChatboxMessageHandler());
        register(ForcedPrivateMessageInboundMessage.class, new ForcedPrivateMessageHandler());
        register(FriendChangedWorldInboundMessage.class, new FriendChangedWorldMessageHandler());
        register(SetChatModesInboundMessage.class, new SetChatModesMessageHandler());
        register(SetFriendsListStatusInboundMessage.class, new SetFriendsListStatusMessageHandler());
        register(PlaySongInboundMessage.class, new PlaySongMessageHandler());
        register(PlayQuickSongInboundMessage.class, new PlayQuickSongMessageHandler());
        register(PlaySoundInboundMessage.class, new PlaySoundMessageHandler());
    }
}
