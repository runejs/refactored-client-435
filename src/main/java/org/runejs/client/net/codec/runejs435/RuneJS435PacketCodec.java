package org.runejs.client.net.codec.runejs435;

import org.runejs.client.net.PacketType;
import org.runejs.client.net.codec.MessagePacketCodec;
import org.runejs.client.message.outbound.chat.*;
import org.runejs.client.message.outbound.console.*;
import org.runejs.client.message.outbound.examine.*;
import org.runejs.client.message.outbound.interactions.*;
import org.runejs.client.message.outbound.magic.*;
import org.runejs.client.message.outbound.useitem.*;
import org.runejs.client.message.outbound.widget.input.*;
import org.runejs.client.net.codec.runejs435.decoder.audio.*;
import org.runejs.client.net.codec.runejs435.decoder.chat.*;
import org.runejs.client.net.codec.runejs435.decoder.console.ReceiveConsoleCommandMessageDecoder;
import org.runejs.client.net.codec.runejs435.decoder.console.ReceiveConsoleLogMessageDecoder;
import org.runejs.client.net.codec.runejs435.decoder.misc.*;
import org.runejs.client.net.codec.runejs435.decoder.region.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.container.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.input.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.model.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.text.*;
import org.runejs.client.net.codec.runejs435.decoder.widget.visibility.*;
import org.runejs.client.net.codec.runejs435.encoder.chat.*;
import org.runejs.client.net.codec.runejs435.encoder.console.*;
import org.runejs.client.net.codec.runejs435.encoder.examine.*;
import org.runejs.client.net.codec.runejs435.encoder.interactions.*;
import org.runejs.client.net.codec.runejs435.encoder.magic.*;
import org.runejs.client.net.codec.runejs435.encoder.useitem.*;
import org.runejs.client.net.codec.runejs435.encoder.widget.input.*;
import org.runejs.client.net.codec.runejs435.decoder.updating.UpdatePlayersMessageDecoder;

/**
 * A {@link MessagePacketCodec} for the RuneJS customised 435 protocol.
 */
public class RuneJS435PacketCodec extends MessagePacketCodec {
    public RuneJS435PacketCodec() {
        super(PacketType.incomingPacketSizes);

        this.registerEncoders();
        this.registerDecoders();
    }

    private void registerEncoders() {
        register(AcceptRequestOutboundMessage.class, new AcceptRequestMessageEncoder());
        register(ModifySocialListOutboundMessage.class, new ModifySocialListMessageEncoder());
        register(SendChatMessageOutboundMessage.class, new SendChatMessageMessageEncoder());
        register(SendPrivateMessageOutboundMessage.class, new SendPrivateMessageMessageEncoder());
        register(ChatCommandOutboundMessage.class, new ChatCommandMessageEncoder());
        
        register(PlayerInteractionOutboundMessage.class, new PlayerInteractionMessageEncoder());
        register(NPCInteractionOutboundMessage.class, new NPCInteractionMessageEncoder());
        register(ObjectInteractionOutboundMessage.class, new ObjectInteractionMessageEncoder());
        register(WorldItemInteractionOutboundMessage.class, new WorldItemInteractionMessageEncoder());
        register(WidgetV1ItemInteractionOutboundMessage.class, new WidgetV1ItemInteractionMessageEncoder());
        register(WidgetV2ItemInteractionOutboundMessage.class, new WidgetV2ItemInteractionMessageEncoder());
        
        register(ChatCommandOutboundMessage.class, new ChatCommandMessageEncoder());

        // console
        register(ConsoleCommandOutboundMessage.class, new ConsoleCommandMessageEncoder());

        // magic
        register(CastMagicOnPlayerOutboundMessage.class, new CastMagicOnPlayerMessageEncoder());
        register(CastMagicOnObjectOutboundMessage.class, new CastMagicOnObjectMessageEncoder());
        register(CastMagicOnWidgetItemOutboundMessage.class, new CastMagicOnWidgetItemMessageEncoder());
        register(CastMagicOnWorldItemOutboundMessage.class, new CastMagicOnWorldItemMessageEncoder());
        register(CastMagicOnNPCOutboundMessage.class, new CastMagicOnNPCMessageEncoder());

        // use item on
        register(UseItemOnPlayerOutboundMessage.class, new UseItemOnPlayerMessageEncoder());
        register(UseItemOnNPCOutboundMessage.class, new UseItemOnNPCMessageEncoder());
        register(UseItemOnObjectOutboundMessage.class, new UseItemOnObjectMessageEncoder());
        register(UseItemOnWorldItemOutboundMessage.class, new UseItemOnWorldItemMessageEncoder());
        register(UseItemOnWidgetItemOutboundMessage.class, new UseItemOnWidgetItemMessageEncoder());
        
        // examine
        register(ExamineItemOutboundMessage.class, new ExamineItemMessageEncoder());
        register(ExamineNPCOutboundMessage.class, new ExamineNPCMessageEncoder());
        register(ExamineObjectOutboundMessage.class, new ExamineObjectMessageEncoder());

        // widget
        register(SubmitChatboxWidgetNumericInputOutboundMessage.class, new SubmitChatboxWidgetNumericInputMessageEncoder());
    }

    private void registerDecoders() {
        register(PacketType.PRIVATE_MESSAGE_RECEIVED.getOpcode(), new ReceivePrivateMessageDecoder());
        register(PacketType.CHATBOX_MESSAGE_RECEIVED.getOpcode(), new ReceiveChatboxMessageDecoder());
        register(PacketType.FORCE_PRIVATE_MESSAGE.getOpcode(), new ForcedPrivateMessageDecoder());
        register(PacketType.FRIEND_LOGGED_IN.getOpcode(), new FriendChangedWorldMessageDecoder());
        register(PacketType.SET_CHAT_MODES.getOpcode(), new SetChatModesMessageDecoder());
        register(PacketType.SET_FRIEND_LIST_STATUS.getOpcode(), new SetFriendsListStatusMessageDecoder());
        register(PacketType.PLAY_SONG.getOpcode(), new PlaySongMessageDecoder());
        register(PacketType.PLAY_QUICK_SONG.getOpcode(), new PlayQuickSongMessageDecoder());
        register(PacketType.PLAY_SOUND.getOpcode(), new PlaySoundMessageDecoder());

        // console
        register(PacketType.RECEIVE_CONSOLE_COMMAND.getOpcode(), new ReceiveConsoleCommandMessageDecoder());
        register(PacketType.RECEIVE_CONSOLE_LOG.getOpcode(), new ReceiveConsoleLogMessageDecoder());

        // misc
        register(PacketType.LOGOUT.getOpcode(), new LogoutMessageDecoder());
        register(PacketType.SET_CURRENT_TAB.getOpcode(), new SetCurrentTabMessageDecoder());
        register(PacketType.SET_MINIMAP_STATE.getOpcode(), new SetMinimapStateMessageDecoder());
        register(PacketType.SET_MULTI_COMBAT.getOpcode(), new SetMultiCombatStateMessageDecoder());
        register(PacketType.SET_SYSTEM_UPDATE_TIME.getOpcode(), new SetSystemUpdateTimeMessageDecoder());
        register(PacketType.FLASH_TAB_ICON.getOpcode(), new FlashTabIconMessageDecoder());

        register(PacketType.UPDATE_CARRY_WEIGHT.getOpcode(), new UpdateCarryWeightMessageDecoder());
        register(PacketType.UPDATE_RUN_ENERGY.getOpcode(), new UpdateRunEnergyMessageDecoder());
        register(PacketType.UPDATE_SKILL.getOpcode(), new UpdateSkillMessageDecoder());
        register(PacketType.UPDATE_PLAYER_OPTIONS.getOpcode(), new UpdatePlayerOptionsMessageDecoder());
        register(PacketType.UPDATE_PLAYERS.getOpcode(), new UpdatePlayersMessageDecoder());

        // widget
        register(PacketType.UPDATE_WIDGET_TEXT_COLOR.getOpcode(), new SetWidgetTextColorMessageDecoder());
        register(PacketType.UPDATE_WIDGET_TEXT.getOpcode(), new SetWidgetTextMessageDecoder());
        register(PacketType.SET_WIDGET_SCROLL_POSITION.getOpcode(), new SetWidgetScrollPositionMessageDecoder());
        register(PacketType.SET_WIDGET_MODEL.getOpcode(), new SetWidgetModelMessageDecoder());
        register(PacketType.SET_WIDGET_ITEM_MODEL.getOpcode(), new SetWidgetItemModelMessageDecoder());
        register(PacketType.SET_WIDGET_NPC_HEAD.getOpcode(), new SetWidgetNPCChatheadModelMessageDecoder());
        register(PacketType.SET_WIDGET_PLAYER_HEAD.getOpcode(), new SetWidgetLocalPlayerChatheadModelMessageDecoder());
        register(PacketType.ROTATE_WIDGET_MODEL.getOpcode(), new RotateWidgetModelMessageDecoder());
        register(PacketType.PLAY_WIDGET_ANIMATION.getOpcode(), new AnimateWidgetModelMessageDecoder());
        register(PacketType.SET_WIDGET_MODEL_ROTATION_SPEED.getOpcode(), new SetWidgetModelRotationSpeedMessageDecoder());
        register(PacketType.CLOSE_ALL_WIDGETS.getOpcode(), new CloseAllWidgetsMessageDecoder());
        register(PacketType.SHOW_TEXT_INPUT_WIDGET.getOpcode(), new ShowTextInputWidgetMessageDecoder());
        register(PacketType.SHOW_SCREEN_WIDGET.getOpcode(), new ShowScreenWidgetMessageDecoder());
        register(PacketType.SHOW_FULLSCREEN_INTERFACE.getOpcode(), new ShowFullScreenWidgetMessageDecoder());
        register(PacketType.SHOW_CHATBOX_WIDGET.getOpcode(), new ShowChatboxWidgetMessageDecoder());
        register(PacketType.SHOW_WALKABLE_SCREEN_WIDGET.getOpcode(), new ShowWalkableScreenWidgetMessageDecoder());
        register(PacketType.SET_TAB_WIDGET.getOpcode(), new ReplaceTabWidgetMessageDecoder());
        register(PacketType.SHOW_TAB_WIDGET.getOpcode(), new ShowTabWidgetMessageDecoder());
        register(PacketType.SHOW_TAB_AND_SCREEN_WIDGETS.getOpcode(), new ShowTabAndScreenWidgetMessageDecoder());
        register(PacketType.SHOW_PERMANENT_CHATBOX_WIDGET.getOpcode(), new ShowPermanentChatboxWidgetMessageDecoder());
        register(PacketType.SHOW_NUMBER_INPUT_WIDGET.getOpcode(), new ShowNumberInputWidgetMessageDecoder());
        register(PacketType.MOVE_WIDGET_CHILD.getOpcode(), new SetWidgetPositionMessageDecoder());
        register(PacketType.SET_REPORT_ABUSE_WIDGET.getOpcode(), new SetReportAbuseWidgetMessageDecoder());

        // widget container
        register(PacketType.UPDATE_ALL_WIDGET_ITEMS.getOpcode(), new UpdateAllWidgetItemsMessageDecoder());
        register(PacketType.UPDATE_SPECIFIC_WIDGET_ITEMS.getOpcode(), new UpdateSpecificWidgetItemsMessageDecoder());
        register(PacketType.CLEAR_WIDGET_ITEMS.getOpcode(), new ClearWidgetItemsMessageDecoder());

        // region
        register(PacketType.CLEAR_MAP_CHUNK.getOpcode(), new ClearChunkMessageDecoder());
        register(PacketType.SET_MAP_CHUNK.getOpcode(), new LoadStandardRegionMessageDecoder());
        register(PacketType.LOAD_CONSTRUCTED_MAP_REGION.getOpcode(), new LoadConstructedRegionMessageDecoder());
        register(PacketType.UPDATE_REFERENCE_POSITION.getOpcode(), new UpdateReferencePositionMessageDecoder());
    }
}
