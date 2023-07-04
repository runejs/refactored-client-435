package org.runejs.client.message.handler.rs435;

import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.handler.rs435.audio.*;
import org.runejs.client.message.inbound.audio.*;
import org.runejs.client.message.handler.rs435.chat.*;
import org.runejs.client.message.handler.rs435.console.*;
import org.runejs.client.message.handler.rs435.misc.*;
import org.runejs.client.message.inbound.chat.*;
import org.runejs.client.message.handler.rs435.audio.PlayQuickSongMessageHandler;
import org.runejs.client.message.handler.rs435.audio.PlaySongMessageHandler;
import org.runejs.client.message.handler.rs435.audio.PlaySoundMessageHandler;
import org.runejs.client.message.inbound.audio.PlayQuickSongInboundMessage;
import org.runejs.client.message.inbound.audio.PlaySongInboundMessage;
import org.runejs.client.message.inbound.audio.PlaySoundInboundMessage;
import org.runejs.client.message.inbound.console.*;
import org.runejs.client.message.inbound.misc.*;
import org.runejs.client.message.inbound.updating.UpdatePlayersInboundMessage;

/**
 * A {@link MessageHandlerRegistry} for the RS revision 435 client.
 */
public class RS435HandlerRegistry extends MessageHandlerRegistry {
    public RS435HandlerRegistry() {
        super();

        register(ReceivePrivateMessageInboundMessage.class, new ReceivePrivateMessageHandler());
        register(ReceiveChatboxMessageInboundMessage.class, new ReceiveChatboxMessageHandler());
        register(ForcedPrivateMessageInboundMessage.class, new ForcedPrivateMessageHandler());
        register(FriendChangedWorldInboundMessage.class, new FriendChangedWorldMessageHandler());
        register(SetChatModesInboundMessage.class, new SetChatModesMessageHandler());
        register(SetFriendsListStatusInboundMessage.class, new SetFriendsListStatusMessageHandler());
        register(PlaySongInboundMessage.class, new PlaySongMessageHandler());
        register(PlayQuickSongInboundMessage.class, new PlayQuickSongMessageHandler());
        register(PlaySoundInboundMessage.class, new PlaySoundMessageHandler());

        // console
        register(ReceiveConsoleCommandMessage.class, new ReceiveConsoleCommandMessageHandler());
        register(ReceiveConsoleLogMessage.class, new ReceiveConsoleLogMessageHandler());

        // misc
        register(LogoutMessage.class, new LogoutMessageHandler());
        register(SetMinimapStateInboundMessage.class, new SetMinimapStateMessageHandler());
        register(SetMultiCombatStateInboundMessage.class, new SetMultiCombatStateMessageHandler());

        register(UpdateCarryWeightMessage.class, new UpdateCarryWeightMessageHandler());
        register(UpdateRunEnergyMessage.class, new UpdateRunEnergyMessageHandler());
        register(UpdateSkillMessage.class, new UpdateSkillMessageHandler());
        register(UpdatePlayersInboundMessage.class, new UpdatePlayersMessageHandler());
    }
}
