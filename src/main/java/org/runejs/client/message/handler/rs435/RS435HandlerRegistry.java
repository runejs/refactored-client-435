package org.runejs.client.message.handler.rs435;

import org.runejs.client.message.handler.MessageHandlerRegistry;
import org.runejs.client.message.handler.rs435.audio.*;
import org.runejs.client.message.handler.rs435.widget.*;
import org.runejs.client.message.handler.rs435.widget.input.*;
import org.runejs.client.message.handler.rs435.widget.model.*;
import org.runejs.client.message.handler.rs435.widget.text.*;
import org.runejs.client.message.handler.rs435.widget.visibility.*;
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
import org.runejs.client.message.inbound.widget.*;
import org.runejs.client.message.inbound.widget.input.*;
import org.runejs.client.message.inbound.widget.model.*;
import org.runejs.client.message.inbound.widget.text.*;
import org.runejs.client.message.inbound.widget.visibility.*;

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
        register(SetCurrentTabInboundMessage.class, new SetCurrentTabMessageHandler());
        register(SetMinimapStateInboundMessage.class, new SetMinimapStateMessageHandler());
        register(SetMultiCombatStateInboundMessage.class, new SetMultiCombatStateMessageHandler());
        register(SetSystemUpdateTimeInboundMessage.class, new SetSystemUpdateTimeMessageHandler());

        register(UpdateCarryWeightMessage.class, new UpdateCarryWeightMessageHandler());
        register(UpdateRunEnergyMessage.class, new UpdateRunEnergyMessageHandler());
        register(UpdateSkillMessage.class, new UpdateSkillMessageHandler());
        register(UpdatePlayersInboundMessage.class, new UpdatePlayersMessageHandler());

        // widget
        register(SetWidgetTextInboundMessage.class, new SetWidgetTextMessageHandler());
        register(SetWidgetTextColorInboundMessage.class, new SetWidgetTextColorMessageHandler());
        register(SetWidgetScrollPositionInboundMessage.class, new SetWidgetScrollPositionMessageHandler());
        register(SetWidgetModelInboundMessage.class, new SetWidgetModelMessageHandler());
        register(SetWidgetItemModelInboundMessage.class, new SetWidgetItemModelMessageHandler());
        register(SetWidgetNPCChatheadModelInboundMessage.class, new SetWidgetNPCChatheadModelMessageHandler());
        register(SetWidgetLocalPlayerChatheadModelInboundMessage.class, new SetWidgetLocalPlayerChatheadModelMessageHandler());
        register(RotateWidgetModelInboundMessage.class, new RotateWidgetModelMessageHandler());
        register(AnimateWidgetModelInboundMessage.class, new AnimateWidgetModelMessageHandler());
        register(SetWidgetModelRotationSpeedInboundMessage.class, new SetWidgetModelRotationSpeedMessageHandler());
        register(CloseAllWidgetsInboundMessage.class, new CloseAllWidgetsMessageHandler());
        register(ShowTextInputWidgetInboundMessage.class, new ShowTextInputWidgetMessageHandler());
        register(ShowScreenWidgetInboundMessage.class, new ShowScreenWidgetMessageHandler());
        register(ShowFullScreenWidgetInboundMessage.class, new ShowFullScreenWidgetMessageHandler());
        register(ShowChatboxWidgetInboundMessage.class, new ShowChatboxWidgetMessageHandler());
        register(ShowWalkableScreenWidgetInboundMessage.class, new ShowWalkableScreenWidgetMessageHandler());
        register(ReplaceTabWidgetInboundMessage.class, new ReplaceTabWidgetMessageHandler());
        register(ShowTabAndScreenWidgetInboundMessage.class, new ShowTabAndScreenWidgetMessageHandler());
        register(ShowTabWidgetInboundMessage.class, new ShowTabWidgetMessageHandler());
        register(ShowNumberInputWidgetInboundMessage.class, new ShowNumberInputWidgetMessageHandler());
        register(SetWidgetPositionInboundMessage.class, new SetWidgetPositionMessageHandler());
    }
}
