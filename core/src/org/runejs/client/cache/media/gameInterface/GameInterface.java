package org.runejs.client.cache.media.gameInterface;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.cs.ClientScript;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.chat.ChatColorEffect;
import org.runejs.client.chat.ChatShapeEffect;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.console.Console;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.message.outbound.chat.*;
import org.runejs.client.message.outbound.examine.*;
import org.runejs.client.message.outbound.interactions.*;
import org.runejs.client.message.outbound.magic.*;
import org.runejs.client.message.outbound.useitem.*;
import org.runejs.client.message.outbound.widget.CloseWidgetsOutboundMessage;
import org.runejs.client.message.outbound.widget.container.DropWidgetItemOutboundMessage;
import org.runejs.client.message.outbound.widget.input.*;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;
import org.runejs.client.util.TextUtils;
import org.runejs.client.*;
import org.runejs.Configuration;

public class GameInterface extends CachedNode {
    public static GameInterface[][] cachedInterfaces;
    public static int gameScreenInterfaceId = -1;
    public static int tabAreaInterfaceId = -1;
    public static int chatboxInterfaceId = -1;
    public static int fullscreenInterfaceId = -1;
    public static int fullscreenSiblingInterfaceId = -1;
    public static boolean[] loadedInterfaces;
    public static boolean drawTabIcons = false;
    public static boolean redrawTabArea = false;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the left-hand side of the top,
     * but not the furthest-left (see `tabHighlightImageTopLeftEdge` for that).
     */
    public static IndexedImage tabHighlightImageTopLeft;
    public static int anInt1233 = 0;
    public static GameInterface aGameInterface_353 = null;
    public static int crossX = 0;
    public static int crossY = 0;
    public static int reportAbuseInterfaceID = -1;
    public static boolean aBoolean2177 = false;
    public static int atInventoryInterfaceType = 0;
    public static int reportAbuseWidgetId = -1;
    public static int anInt876 = 0;
    public static int selectedSpell;
    public static int anInt1171 = 0;
    public static boolean hiddenButtonTest = false;
    /**
     * The player that the local player is sending a PM to.
     */
    public static long sendingMessageTo = 0L;
    /**
     * The widget ID on which the item was selected.
     */
    public static int itemSelectedWidgetId;
    /**
     * The item ID currently selected on a widget.
     */
    public static int itemSelectedItemId;
    /**
     * The slot within the container of the currently selected item.
     */
    public static int itemSelectedContainerSlot;
    /**
     * Is an item currently selected?
     */
    public static int itemCurrentlySelected = 0;
    public static int anInt704 = 0;
    public static NodeCache interfaceItemImageCache = new NodeCache(200);
    public static NodeCache interfaceModelCache = new NodeCache(50);
    public static NodeCache interfaceTypefaceCache = new NodeCache(20);
    public static int selectedInventorySlot = 0;
    public static int activeInterfaceType = 0;
    public static int modifiedWidgetId = 0;
    public static int walkableWidgetId = -1;
    public static int lastActiveInvInterface = 0;
    /**
     * Some kind of timer for item-on-widget clicks (e.g. triggered when taking items from bank)
     */
    public static int anInt1651 = 0;
    public static int lastItemDragTime = 0;
    /**
     * The lightened edge (top and left) color of the scroll indicator chip.
     */
    private static int SCROLLBAR_COLOR_CHIP_EDGE_LIGHT = 0x766654;
    /**
     * The darkened edge (bottom and right) color of the scroll indicator chip.
     */
    private static int SCROLLBAR_COLOR_CHIP_EDGE_DARK = 0x332D25;
    /**
     * The background color of the scrollbar.
     */
    private static int SCROLLBAR_COLOR_BACKGROUND = 0x23201B;
    /**
     * The fill colour of the scroll indicator chip.
     */
    private static int SCROLLBAR_COLOR_CHIP_FILL = 0x4D4233;
    private static boolean aBoolean1444 = false;

    public boolean isNewInterfaceFormat = false;
    public int contentType;
    public String alternateText;
    public boolean tiled;
    public int fontId;
    public int originalHeight;
    public Object[] anObjectArray2644;
    public boolean filled;
    public int textColor;
    public int parentId;
    public int originalX;
    public Object[] anObjectArray2650;
    public InterfaceModelType alternateModelType = InterfaceModelType.MODEL;
    public int alternateAnimation;
    public int animationFrame;
    public boolean itemUsable;
    public int currentX;
    public int rotationZ;
    public Object[] anObjectArray2658;
    public int animation;
    public int remainingAnimationTime;
    public String[] aClass1Array2661;
    public int alternateHoveredTextColor;
    public String targetVerb;
    public boolean textShadowed;
    public int itemSpritePadsY;
    public String disabledText;
    public Object[] anObjectArray2669;
    public int alternateSpriteId;
    public Object[] anObjectArray2672;
    public int modelId;
    public String tooltip;
    public Object[] onLoadListeners;
    public int offsetY2d;
    public Object[] anObjectArray2680;
    public Object[] anObjectArray2681;
    public boolean aBoolean2682;
    public GameInterfaceType type;
    public int[] items;
    public InterfaceModelType modelType;
    public boolean hasListeners;
    public int id;
    public int rotationX;
    public int originalWidth;
    public int[] alternateRhs;
    public boolean lockScroll;
    public Object[] anObjectArray2695;
    public int currentY;
    public String[] configActions;
    public int[] images;
    public boolean orthogonal;
    public int clickMask;
    public boolean itemSwapable;
    public int[] imageY;
    public Object[] anObjectArray2707;
    public int[] imageX;
    public String spellName;
    public int[] itemAmounts;
    public int alternateModelId;
    public Object[] anObjectArray2712;
    public GameInterface[] children;
    public int actionType;
    public int yTextAlignment;
    public int itemId;
    public int hoveredTextColor;
    public int scrollHeight;
    public int hoveredSiblingId;
    public int rotationSpeed;
    public boolean itemDeletesDraged;
    public int rotationY;
    public int alternateTextColor;
    public boolean isInventory;
    public int modelZoom;
    public boolean aBoolean2730;
    public int scrollPosition;
    public int lineHeight;
    public int xTextAlignment;
    public int itemAmount;
    public int anInt2736;
    public int offsetX2d;
    public int anInt2738;
    public int[] alternateOperators;
    public int originalY;
    public int spriteId;
    public int opacity;
    public int scrollWidth;
    public Object[] anObjectArray2747;
    public int[][] clientScripts;
    public int itemSpritePadsX;
    public boolean isHidden;
    public int textureId;

    public GameInterface() {
        contentType = 0;
        rotationZ = 0;
        textShadowed = false;
        tiled = false;
        targetVerb = "";
        animationFrame = 0;
        tooltip = English.ok;
        itemSpritePadsY = 0;
        remainingAnimationTime = 0;
        modelType = InterfaceModelType.MODEL;
        alternateAnimation = -1;
        textColor = 0;
        aBoolean2682 = false;
        modelId = -1;
        rotationX = 0;
        clickMask = 0;
        lockScroll = false;
        parentId = -1;
        alternateHoveredTextColor = 0;
        hasListeners = false;
        alternateSpriteId = -1;
        currentY = 0;
        alternateModelId = -1;
        originalX = 0;
        isInventory = false;
        alternateText = "";
        itemSwapable = false;
        hoveredTextColor = 0;
        originalWidth = 0;
        animation = -1;
        xTextAlignment = 0;
        hoveredSiblingId = -1;
        spellName = "";
        offsetY2d = 0;
        itemAmount = 0;
        disabledText = "";
        id = -1;
        lineHeight = 0;
        itemUsable = false;
        filled = false;
        anInt2738 = -1;
        modelZoom = 100;
        itemDeletesDraged = false;
        rotationSpeed = 0;
        yTextAlignment = 0;
        currentX = 0;
        orthogonal = false;
        spriteId = -1;
        aBoolean2730 = false;
        originalHeight = 0;
        opacity = 0;
        originalY = 0;
        rotationY = 0;
        scrollWidth = 0;
        offsetX2d = 0;
        isHidden = false;
        alternateTextColor = 0;
        scrollHeight = 0;
        scrollPosition = 0;
        anInt2736 = 0;
        itemId = -1;
        itemSpritePadsX = 0;
        actionType = 0;
        textureId = 0;
    }

    public static void method639() {
        synchronized(Game.keyFocusListener) {
            MovedStatics.anInt1389 = MovedStatics.anInt1214;
            if(KeyFocusListener.anInt2543 < 0) {
                for(int i = 0; i < 112; i++) {
                    MovedStatics.obfuscatedKeyStatus[i] = false;
                }
                KeyFocusListener.anInt2543 = MovedStatics.anInt2183;
            } else {
                while(KeyFocusListener.anInt2543 != MovedStatics.anInt2183) {
                    int i = MovedStatics.keyCodes[MovedStatics.anInt2183];
                    MovedStatics.anInt2183 = 0x7f & MovedStatics.anInt2183 + 1;
                    if(i < 0) {
                        MovedStatics.obfuscatedKeyStatus[i ^ 0xffffffff] = false;
                    } else {
                        MovedStatics.obfuscatedKeyStatus[i] = true;
                    }
                }
            }
            MovedStatics.anInt1214 = MovedStatics.anInt2598;
        }
    }


    public static String getShortenedAmountText(int amount) {
        if(amount < 100000) {
            return "<col=ffff00>" + amount + "</col>";
        }
        if(amount < 10000000) {
            return "<col=ffffff>" + amount / 1000 + "K" + "</col>";
        }
        return "<col=00ff80>" + amount / 1000000 + "M" + "</col>";
    }

    public static GameInterface getInterface(int interfaceData) {
        int parentInterfaceId = interfaceData >> 16;
        int childInterfaceId = 0xffff & interfaceData;
        if(cachedInterfaces[parentInterfaceId] == null || cachedInterfaces[parentInterfaceId][childInterfaceId] == null) {
            if(!decodeGameInterface(parentInterfaceId)) {
                return null;
            }
        }

        return cachedInterfaces[parentInterfaceId][childInterfaceId];
    }

    public static void updateGameInterface(GameInterface gameInterface) {
        int type = gameInterface.contentType;
        if(type >= 1 && type <= 100 || type >= 701 && type <= 800) {
            if(type == 1 && Player.friendListStatus == 0) {
                gameInterface.disabledText = English.loadingFriendList;
                gameInterface.actionType = 0;
            } else if(type == 1 && Player.friendListStatus == 1) {
                gameInterface.disabledText = English.connectingToFriendserver;
                gameInterface.actionType = 0;
            } else if(type == 2 && Player.friendListStatus != 2) {
                gameInterface.actionType = 0;
                gameInterface.disabledText = English.pleaseWait;
            } else {
                int fCount = Player.friendsCount;
                if(type > 700)
                    type -= 601;
                else
                    type--;
                if(Player.friendListStatus != 2)
                    fCount = 0;
                if(fCount <= type) {
                    gameInterface.disabledText = "";
                    gameInterface.actionType = 0;
                } else {
                    gameInterface.disabledText = Player.friendUsernames[type];
                    gameInterface.actionType = 1;
                }
            }
        } else if(type >= 101 && type <= 200 || type >= 801 && type <= 900) {
            if(type <= 800)
                type -= 101;
            else
                type -= 701;
            int count = Player.friendsCount;
            if(Player.friendListStatus != 2)
                count = 0;
            if(type >= count) {
                gameInterface.disabledText = "";
                gameInterface.actionType = 0;
            } else {
                if(Player.friendWorlds[type] == 0) {
                    gameInterface.disabledText = Native.red + English.offline;
                } else if(Player.friendWorlds[type] < 5000) {
                    if(Player.friendWorlds[type] == Player.worldId) {
                        gameInterface.disabledText = Native.green + English.world + Player.friendWorlds[type];
                    } else {
                        gameInterface.disabledText = Native.yellow + English.world + Player.friendWorlds[type];
                    }
                } else if(Player.worldId == Player.friendWorlds[type]) {
                    gameInterface.disabledText = Native.green + English.classic + (-5000 + Player.friendWorlds[type]);
                } else {
                    gameInterface.disabledText = Native.yellow + English.classic + (Player.friendWorlds[type] + -5000);
                }
                gameInterface.actionType = 1;
            }
        } else if(type == 203) {
            int count = Player.friendsCount;
            if(Player.friendListStatus != 2)
                count = 0;
            gameInterface.scrollHeight = 20 + 15 * count;
            if(gameInterface.originalHeight >= gameInterface.scrollHeight)
                gameInterface.scrollHeight = 1 + gameInterface.originalHeight;
        } else if(type >= 401 && type <= 500) {
            type -= 401;
            if(type == 0 && Player.friendListStatus == 0) {
                gameInterface.disabledText = English.loadingIgnoreList;
                gameInterface.actionType = 0;
            } else if(type == 1 && Player.friendListStatus == 0) {
                gameInterface.disabledText = English.pleaseWait;
                gameInterface.actionType = 0;
            } else {
                int i_4_ = Player.ignoresCount;
                if(Player.friendListStatus == 0)
                    i_4_ = 0;
                if(i_4_ <= type) {
                    gameInterface.actionType = 0;
                    gameInterface.disabledText = "";
                } else {
                    gameInterface.disabledText = TextUtils.formatName(TextUtils.longToName(Player.ignores[type]));
                    gameInterface.actionType = 1;
                }
            }
        } else if(type == 503) {
            gameInterface.scrollHeight = 15 * Player.ignoresCount + 20;
            if(gameInterface.scrollHeight <= gameInterface.originalHeight)
                gameInterface.scrollHeight = gameInterface.originalHeight + 1;
        } else if(type == 324) {
            if(MovedStatics.anInt1511 == -1) {
                MovedStatics.anInt1511 = gameInterface.spriteId;
                Game.anInt1769 = gameInterface.alternateSpriteId;
            }
            if(!Player.activePlayerAppearance.gender)
                gameInterface.spriteId = Game.anInt1769;
            else
                gameInterface.spriteId = MovedStatics.anInt1511;
        } else if(type == 325) {
            if(MovedStatics.anInt1511 == -1) {
                Game.anInt1769 = gameInterface.alternateSpriteId;
                MovedStatics.anInt1511 = gameInterface.spriteId;
            }
            if(Player.activePlayerAppearance.gender)
                gameInterface.spriteId = Game.anInt1769;
            else
                gameInterface.spriteId = MovedStatics.anInt1511;
        } else if(type == 327) {
            gameInterface.rotationX = 150;
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) MovedStatics.pulseCycle / 40.0));
            gameInterface.modelId = 0;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 328) {
            gameInterface.rotationX = 150;
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) MovedStatics.pulseCycle / 40.0));
            gameInterface.modelId = 1;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 600)
            gameInterface.disabledText = Native.reportedName + Native.yellowBar;
        else if(type == 620) {
            if(Game.playerRights >= 1) {
                if(MovedStatics.reportMutePlayer) {
                    gameInterface.textColor = 0xff0000;
                    gameInterface.disabledText = English.moderatorOptionMutePlayerFor48HoursON;
                } else {
                    gameInterface.textColor = 0xffffff;
                    gameInterface.disabledText = English.moderatorOptionMutePlayerFor48HoursOFF;
                }
            } else
                gameInterface.disabledText = "";
        }
    }

    public static void drawScrollBar(int x, int y, int height, int scrollPosition, int scrollMaximum) {
        int length = (-32 + height) * height / scrollMaximum;
        MovedStatics.scrollbarArrowImages[0].drawImage(x, y);
        MovedStatics.scrollbarArrowImages[1].drawImage(x, y - (-height + 16));
        Rasterizer.drawFilledRectangle(x, y + 16, 16, height + -32, SCROLLBAR_COLOR_BACKGROUND);
        if(length < 8)
            length = 8;
        int scrollCurrent = (-32 + height - length) * scrollPosition / (-height + scrollMaximum);
        Rasterizer.drawFilledRectangle(x, 16 + y + scrollCurrent, 16, length, SCROLLBAR_COLOR_CHIP_FILL);
        Rasterizer.drawVerticalLine(x, 16 + y + scrollCurrent, length, SCROLLBAR_COLOR_CHIP_EDGE_LIGHT);
        Rasterizer.drawVerticalLine(1 + x, scrollCurrent + y + 16, length, SCROLLBAR_COLOR_CHIP_EDGE_LIGHT);
        Rasterizer.drawHorizontalLine(x, scrollCurrent + y + 16, 16, SCROLLBAR_COLOR_CHIP_EDGE_LIGHT);
        Rasterizer.drawHorizontalLine(x, 17 + y + scrollCurrent, 16, SCROLLBAR_COLOR_CHIP_EDGE_LIGHT);
        Rasterizer.drawVerticalLine(x + 15, y + 16 + scrollCurrent, length, SCROLLBAR_COLOR_CHIP_EDGE_DARK);
        Rasterizer.drawVerticalLine(x + 14, scrollCurrent + 17 + y, length - 1, SCROLLBAR_COLOR_CHIP_EDGE_DARK);
        Rasterizer.drawHorizontalLine(x, length + scrollCurrent + 15 + y, 16, SCROLLBAR_COLOR_CHIP_EDGE_DARK);
        Rasterizer.drawHorizontalLine(x + 1, 14 + y + scrollCurrent + length, 15, SCROLLBAR_COLOR_CHIP_EDGE_DARK);
    }

    public static boolean decodeGameInterface(int interfaceId) {
        if(loadedInterfaces[interfaceId]) {
            return true;
        }

        if(!CacheArchive.gameInterfaceCacheArchive.fileExists(interfaceId)) {
            return false;
        }

        int gameInterfaceCount = CacheArchive.gameInterfaceCacheArchive.fileLength(interfaceId);
        if(gameInterfaceCount == 0) {
            loadedInterfaces[interfaceId] = true;
            return true;
        }

        if(cachedInterfaces[interfaceId] == null) {
            cachedInterfaces[interfaceId] = new GameInterface[gameInterfaceCount];
        }

        for(int i = 0; i < gameInterfaceCount; i++) {
            if(cachedInterfaces[interfaceId][i] == null) {
                byte[] interfaceFileData = CacheArchive.gameInterfaceCacheArchive.getFile(interfaceId, i);

                if(interfaceFileData != null) {
                    cachedInterfaces[interfaceId][i] = new GameInterface();
                    cachedInterfaces[interfaceId][i].id = (interfaceId << 16) + i;
                    if(interfaceFileData[0] == -1) {
                        cachedInterfaces[interfaceId][i].decodeIf3(new Buffer(interfaceFileData));
                    } else {
                        cachedInterfaces[interfaceId][i].decodeIf1(new Buffer(interfaceFileData));
                    }
                }
            }
        }

        loadedInterfaces[interfaceId] = true;
        return true;
    }

    public static void resetInterfaceAnimations(int interfaceId) {
        if(decodeGameInterface(interfaceId)) {
            GameInterface[] interfaceChildren = cachedInterfaces[interfaceId];
            for(GameInterface interfaceChild : interfaceChildren) {
                if(interfaceChild != null) {
                    interfaceChild.remainingAnimationTime = 0;
                    interfaceChild.animationFrame = 0;
                }
            }
        }
    }

    public static void resetInterface(int interfaceId) {
        if(interfaceId == -1 || !loadedInterfaces[interfaceId]) {
            return;
        }

        CacheArchive.gameInterfaceCacheArchive.unloadFile(1, interfaceId);

        if(cachedInterfaces[interfaceId] != null) {
            boolean deleteFromCache = true;

            for(int i = 0; cachedInterfaces[interfaceId].length > i; i++) {
                if(cachedInterfaces[interfaceId][i] != null) {
                    if(cachedInterfaces[interfaceId][i].type != GameInterfaceType.INVENTORY)
                        cachedInterfaces[interfaceId][i] = null;
                    else
                        deleteFromCache = false;
                }
            }

            if(deleteFromCache) {
                cachedInterfaces[interfaceId] = null;
            }

            loadedInterfaces[interfaceId] = false;
        }
    }

    public static void createInterfaceMemoryBuffers() {
        cachedInterfaces = new GameInterface
                [CacheArchive.gameInterfaceCacheArchive.getLength()][];
        loadedInterfaces = new boolean
                [CacheArchive.gameInterfaceCacheArchive.getLength()];
    }

    public static void callOnLoadListeners(int interfaceId) {
        if(decodeGameInterface(interfaceId)) {
            GameInterface[] gameInterfaces = cachedInterfaces[interfaceId];
            for(GameInterface gameInterface : gameInterfaces) {
                if(gameInterface.onLoadListeners != null) {
                    ClientScriptRunner.runClientScripts(gameInterface.onLoadListeners, 0, 0, gameInterface, 0);
                }
            }
        }
    }

    public static Object[] decodeListener(Buffer buffer) {
        int length = buffer.getUnsignedByte();
        if(length == 0) {
            return null;
        }
        Object[] objects = new Object[length];
        for(int i = 0; i < length; i++) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0)
                objects[i] = new Integer(buffer.getIntBE());
            else if(opcode == 1)
                objects[i] = buffer.getRSString();
        }
        return objects;
    }

    public static void processMenuActions(int arg1) {
        // TODO (Jameskmonger) there used to be a dummy here, but it was removed.
        //     if (true) kept to make the diff smaller.
        if(true) {
            int i = MovedStatics.firstMenuOperand[arg1];
            int i_10_ = MovedStatics.secondMenuOperand[arg1];
            int action = MovedStatics.menuActionTypes[arg1];
            if(action >= ActionRowType.LOW_PRIORITY_MODIFIER) {
                action -= ActionRowType.LOW_PRIORITY_MODIFIER;
            }

            int npcIdx = MovedStatics.selectedMenuActions[arg1];
            if(ChatBox.inputType != 0 && action != ActionRowType.CANCEL.getId()) {
                ChatBox.inputType = 0;
                ChatBox.redrawChatbox = true;
            }
            if(action == ActionRowType.CAST_MAGIC_ON_WIDGET_ITEM.getId()) {
                int widgetId = (i_10_ >> 16) & 0xFFFF;
                int containerId = i_10_ & 0xFFFF;

                OutgoingPackets.sendMessage(
                    new CastMagicOnWidgetItemOutboundMessage(
                        selectedSpell,
                        npcIdx,
                        widgetId,
                        containerId,
                        i
                    )
                );

                atInventoryInterfaceType = 2;
                anInt1233 = i;
                anInt1651 = 0;
                if(gameScreenInterfaceId == i_10_ >> 16) {
                    atInventoryInterfaceType = 1;
                }
                anInt704 = i_10_;
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    atInventoryInterfaceType = 3;
                }
            }
            if(action == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_2.getId()) {
                Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                MovedStatics.crossIndex = 0;
                crossY = MouseHandler.clickY;
                crossX = MouseHandler.clickX;
                MovedStatics.crossType = 2;

                OutgoingPackets.sendMessage(
                    new WorldItemInteractionOutboundMessage(
                        2,
                        npcIdx,
                        MovedStatics.baseX + i,
                        MovedStatics.baseY + i_10_
                    )
                );
            }
            if(action == ActionRowType.EXAMINE_OBJECT.getId()) { // examine object
                crossY = MouseHandler.clickY;
                crossX = MouseHandler.clickX;
                MovedStatics.crossType = 2;
                MovedStatics.crossIndex = 0;

                int objectId = npcIdx >> 14 & 0x7fff;

                OutgoingPackets.sendMessage(new ExamineObjectOutboundMessage(objectId));
            }
            if(action == ActionRowType.INTERACT_WITH_OBJECT_OPTION_4.getId()) {
                MovedStatics.method596(i, npcIdx, (byte) -79, i_10_);

                int objectX = MovedStatics.baseX + i;
                int objectId = (0x1ffffd20 & npcIdx) >> 14;
                int objectY = MovedStatics.baseY + i_10_;

                OutgoingPackets.sendMessage(
                    new ObjectInteractionOutboundMessage(
                        4,
                        objectId,
                        objectX,
                        objectY
                    )
                );
            }
            if(action == ActionRowType.CAST_MAGIC_ON_PLAYER.getId()) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[npcIdx];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathY[0], class40_sub5_sub17_sub4_sub1.pathX[0], 1, 1);
                    crossX = MouseHandler.clickX;
                    MovedStatics.crossIndex = 0;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;

                    OutgoingPackets.sendMessage(
                        new CastMagicOnPlayerOutboundMessage(
                            selectedSpell,
                            npcIdx
                        )
                    );
                }
            }
            if(action == ActionRowType.ACCEPT_TRADE.getId() || action == ActionRowType.ACCEPT_CHALLENGE.getId()) {
                String name = MovedStatics.menuActionTexts[arg1];
                int i_13_ = name.indexOf(Native.white);
                if(i_13_ != -1) {
                    name = name.substring(i_13_ + 5).trim();
                    String username = TextUtils.formatName(TextUtils.longToName(TextUtils.nameToLong(name)));
                    boolean bool = false;
                    for(int i_15_ = 0; i_15_ < Player.localPlayerCount; i_15_++) {
                        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[Player.trackedPlayerIndices[i_15_]];
                        if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.playerName != null && class40_sub5_sub17_sub4_sub1.playerName.equalsIgnoreCase(username)) {
                            bool = true;
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathY[0], class40_sub5_sub17_sub4_sub1.pathX[0], 1, 1);

                            AcceptRequestOutboundMessage.RequestType requestType = AcceptRequestOutboundMessage.RequestType.INVALID;

                            if(action == ActionRowType.ACCEPT_TRADE.getId()) {
                                requestType = AcceptRequestOutboundMessage.RequestType.TRADE;

                            }
                            if(action == ActionRowType.ACCEPT_CHALLENGE.getId()) {
                                requestType = AcceptRequestOutboundMessage.RequestType.CHALLENGE;
                            }

                            if (requestType != AcceptRequestOutboundMessage.RequestType.INVALID) {
                                OutgoingPackets.sendMessage(
                                    new AcceptRequestOutboundMessage(
                                        requestType,
                                        Player.trackedPlayerIndices[i_15_]
                                    )
                                );
                            }

                            break;
                        }
                    }
                    if(!bool) {
                        ChatBox.addChatMessage("", English.unableToFind + username, 0);
                    }
                }
            }
            if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3.getId()) {
                int widgetId = (i_10_ >> 16) & 0xFFFF;
                int containerId = i_10_ & 0xFFFF;

                OutgoingPackets.sendMessage(
                    new WidgetV1ItemInteractionOutboundMessage(
                        3,
                        widgetId,
                        containerId,
                        i,
                        npcIdx
                    )
                );

                anInt704 = i_10_;
                anInt1651 = 0;
                anInt1233 = i;
                atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    atInventoryInterfaceType = 3;
                }
            }
            if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1.getId()) {
                int widgetId = (i_10_ >> 16) & 0xFFFF;
                int containerId = i_10_ & 0xFFFF;

                OutgoingPackets.sendMessage(
                    new WidgetV1ItemInteractionOutboundMessage(
                        1,
                        widgetId,
                        containerId,
                        i,
                        npcIdx
                    )
                );

                anInt1233 = i;
                atInventoryInterfaceType = 2;
                anInt1651 = 0;
                anInt704 = i_10_;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    atInventoryInterfaceType = 3;
                }
            }
            if(action == ActionRowType.BUTTON_SET_VARP_VALUE.getId()) {
                int widgetId = (i_10_ >> 16) & 0xFFFF;
                int childId = i_10_ & 0xFFFF;

                OutgoingPackets.sendMessage(new ClickWidgetButtonOutboundMessage(widgetId, childId));

                GameInterface gameInterface = getInterface(i_10_);
                if(gameInterface.clientScripts != null && gameInterface.clientScripts[0][0] == 5) {
                    int i_16_ = gameInterface.clientScripts[0][1];
                    if(gameInterface.alternateRhs[0] != VarPlayerDefinition.varPlayers[i_16_]) {
                        VarPlayerDefinition.varPlayers[i_16_] = gameInterface.alternateRhs[0];
                        MovedStatics.handleVarPlayers(i_16_);
                        redrawTabArea = true;
                    }
                }
            }
            if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId()) {
                int widgetId = (i_10_ >> 16) & 0xFFFF;
                int containerId = i_10_ & 0xFFFF;

                OutgoingPackets.sendMessage(
                    new WidgetV2ItemInteractionOutboundMessage(
                        1,
                        widgetId,
                        containerId,
                        i,
                        npcIdx
                    )
                );

                anInt1233 = i;
                anInt704 = i_10_;
                anInt1651 = 0;
                atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    atInventoryInterfaceType = 3;
                }
            }
            if(action == ActionRowType.INTERACT_WITH_PLAYER_OPTION_1.getId()) {
                Player otherPlayer = Player.trackedPlayers[npcIdx];
                if(otherPlayer != null) {
                    Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], otherPlayer.pathY[0], otherPlayer.pathX[0], 1, 1);
                    crossX = MouseHandler.clickX;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;
                    MovedStatics.crossIndex = 0;

                    OutgoingPackets.sendMessage(new PlayerInteractionOutboundMessage(1, npcIdx));
                }
            }
            if(action == ActionRowType.INTERACT_WITH_PLAYER_OPTION_4.getId()) {
                Player otherPlayer = Player.trackedPlayers[npcIdx];
                if(otherPlayer != null) {
                    Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], otherPlayer.pathY[0], otherPlayer.pathX[0], 1, 1);
                    MovedStatics.crossIndex = 0;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;
                    crossX = MouseHandler.clickX;

                    OutgoingPackets.sendMessage(new PlayerInteractionOutboundMessage(4, npcIdx));
                }
            }
            if(action == ActionRowType.EXAMINE_NPC.getId()) {
                crossX = MouseHandler.clickX;
                MovedStatics.crossType = 2;
                crossY = MouseHandler.clickY;
                MovedStatics.crossIndex = 0;
                Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    ActorDefinition class40_sub5_sub5 = class40_sub5_sub17_sub4_sub2.actorDefinition;
                    if(class40_sub5_sub5.childIds != null) {
                        class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition();
                    }
                    if(class40_sub5_sub5 != null) {
                        OutgoingPackets.sendMessage(new ExamineNPCOutboundMessage(class40_sub5_sub5.id));
                    }
                }
            }
            if(action == ActionRowType.USE_ITEM_ON_PLAYER.getId()) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[npcIdx];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathY[0], class40_sub5_sub17_sub4_sub1.pathX[0], 1, 1);
                    crossX = MouseHandler.clickX;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;
                    MovedStatics.crossIndex = 0;
                    
                    int widgetId = (itemSelectedWidgetId >> 16) & 0xFFFF;
                    int containerId = itemSelectedWidgetId & 0xFFFF;

                    OutgoingPackets.sendMessage(
                        new UseItemOnPlayerOutboundMessage(
                            itemSelectedItemId,
                            widgetId,
                            containerId,
                            itemSelectedContainerSlot,
                            npcIdx
                        )
                    );
                }
            }
            if(action == ActionRowType.SELECT_ITEM_ON_WIDGET.getId()) {
                itemSelectedItemId = npcIdx;
                itemSelectedContainerSlot = i;
                itemSelectedWidgetId = i_10_;
                itemCurrentlySelected = 1;
                Native.selectedItemName = Native.lightRed + ItemDefinition.forId(npcIdx, 10).name + Native.white;
                Game.widgetSelected = 0;
                if(Native.selectedItemName == null) {
                    Native.selectedItemName = "null";
                }
                redrawTabArea = true;
            } else {
                if(action == ActionRowType.CAST_MAGIC_ON_WORLD_ITEM.getId()) {
                    Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                    MovedStatics.crossIndex = 0;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;
                    crossX = MouseHandler.clickX;

                    OutgoingPackets.sendMessage(
                        new CastMagicOnWorldItemOutboundMessage(
                            selectedSpell,
                            npcIdx,
                            MovedStatics.baseX + i,
                            MovedStatics.baseY + i_10_
                        )
                    );
                }
                if(action == ActionRowType.BUTTON_TOGGLE_VARP.getId()) {
                    int widgetId = (i_10_ >> 16) & 0xFFFF;
                    int childId = i_10_ & 0xFFFF;

                    OutgoingPackets.sendMessage(new ClickWidgetButtonOutboundMessage(widgetId, childId));

                    GameInterface gameInterface = getInterface(i_10_);
                    if(gameInterface.clientScripts != null && gameInterface.clientScripts[0][0] == 5) {
                        int i_17_ = gameInterface.clientScripts[0][1];
                        VarPlayerDefinition.varPlayers[i_17_] = -VarPlayerDefinition.varPlayers[i_17_] + 1;
                        MovedStatics.handleVarPlayers(i_17_);
                        redrawTabArea = true;
                    }
                }
                if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4.getId()) {
                    int widgetId = (i_10_ >> 16) & 0xFFFF;
                    int containerId = i_10_ & 0xFFFF;

                    OutgoingPackets.sendMessage(
                        new WidgetV1ItemInteractionOutboundMessage(
                            4,
                            widgetId,
                            containerId,
                            i,
                            npcIdx
                        )
                    );

                    atInventoryInterfaceType = 2;
                    anInt1233 = i;
                    anInt704 = i_10_;
                    if(gameScreenInterfaceId == i_10_ >> 16) {
                        atInventoryInterfaceType = 1;
                    }
                    if(chatboxInterfaceId == i_10_ >> 16) {
                        atInventoryInterfaceType = 3;
                    }
                    anInt1651 = 0;
                }
                if(action == ActionRowType.MESSAGE_FRIEND.getId()) {
                    String class1 = MovedStatics.menuActionTexts[arg1];
                    int i_18_ = class1.indexOf(Native.white);
                    if(i_18_ != -1) {
                        long l = TextUtils.nameToLong(class1.substring(i_18_ + 5).trim());
                        int i_19_ = -1;
                        for(int i_20_ = 0; i_20_ < Player.friendsCount; i_20_++) {
                            if(Player.friends[i_20_] == l) {
                                i_19_ = i_20_;
                                break;
                            }
                        }
                        if(i_19_ != -1 && Player.friendWorlds[i_19_] > 0) {
                            anInt876 = 3;
                            ChatBox.redrawChatbox = true;
                            ChatBox.inputType = 0;
                            ChatBox.chatMessage = "";
                            ChatBox.messagePromptRaised = true;
                            sendingMessageTo = Player.friends[i_19_];
                            Native.enterPlayerNameHeader = English.prefixEnterMessageToSendTo + Player.friendUsernames[i_19_];
                        }
                    }
                }
                if(action == ActionRowType.EXAMINE_ITEM.getId()) { // examine item
                    MovedStatics.crossIndex = 0;
                    MovedStatics.crossType = 2;
                    crossY = MouseHandler.clickY;
                    crossX = MouseHandler.clickX;

                    OutgoingPackets.sendMessage(new ExamineItemOutboundMessage(npcIdx));
                }
                if(action == ActionRowType.INTERACT_WITH_OBJECT_OPTION_5.getId()) {
                    MovedStatics.method596(i, npcIdx, (byte) -11, i_10_);

                    int objectId = (0x1ffffd20 & npcIdx) >> 14;
                    int objectY = i_10_ + MovedStatics.baseY;
                    int objectX = i + MovedStatics.baseX;

                    OutgoingPackets.sendMessage(
                        new ObjectInteractionOutboundMessage(
                            5,
                            objectId,
                            objectX,
                            objectY
                        )
                    );
                }
                if(action == ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId()) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                        MovedStatics.crossIndex = 0;
                        crossX = MouseHandler.clickX;
                        crossY = MouseHandler.clickY;
                        MovedStatics.crossType = 2;

                        OutgoingPackets.sendMessage(new NPCInteractionOutboundMessage(2, npcIdx));
                    }
                }
                if(action == ActionRowType.USE_ITEM_ON_NPC.getId()) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                        crossX = MouseHandler.clickX;
                        crossY = MouseHandler.clickY;
                        MovedStatics.crossIndex = 0;
                        MovedStatics.crossType = 2;

                        int widgetId = (itemSelectedWidgetId >> 16) & 0xFFFF;
                        int containerId = itemSelectedWidgetId & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new UseItemOnPlayerOutboundMessage(
                                itemSelectedItemId,
                                widgetId,
                                containerId,
                                itemSelectedContainerSlot,
                                npcIdx
                            )
                        );
                    }
                }
                if(action == ActionRowType.INTERACT_WITH_OBJECT_OPTION_2.getId()) {
                    MovedStatics.method596(i, npcIdx, (byte) -77, i_10_);

                    int objectX = i + MovedStatics.baseX;
                    int objectY = i_10_ + MovedStatics.baseY;
                    int objectId = npcIdx >> 14 & 0x7fff;

                    OutgoingPackets.sendMessage(
                        new ObjectInteractionOutboundMessage(
                            2,
                            objectId,
                            objectX,
                            objectY
                        )
                    );
                }
                if(action == ActionRowType.USE_ITEM_ON_OBJECT.getId() && MovedStatics.method596(i, npcIdx, (byte) -104, i_10_)) {
                    int widgetId = (itemSelectedWidgetId >> 16) & 0xFFFF;
                    int containerId = itemSelectedWidgetId & 0xFFFF;

                    OutgoingPackets.sendMessage(
                        new UseItemOnObjectOutboundMessage(
                            itemSelectedItemId,
                            widgetId,
                            containerId,
                            itemSelectedContainerSlot,
                            (npcIdx & 0x1fffccf7) >> 14,
                            i + MovedStatics.baseX,
                            i_10_ + MovedStatics.baseY
                        )
                    );
                }
                if(action == ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId()) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                        MovedStatics.crossIndex = 0;
                        MovedStatics.crossType = 2;
                        crossX = MouseHandler.clickX;
                        crossY = MouseHandler.clickY;

                        OutgoingPackets.sendMessage(new NPCInteractionOutboundMessage(4, npcIdx));
                    }
                }
                if(action == ActionRowType.USE_ITEM_ON_INVENTORY_ITEM.getId()) {
                    int widgetId = (itemSelectedWidgetId >> 16) & 0xFFFF;
                    int containerId = itemSelectedWidgetId & 0xFFFF;

                    int targetWidgetId = (i_10_ >> 16) & 0xFFFF;
                    int targetContainerId = i_10_ & 0xFFFF;

                    OutgoingPackets.sendMessage(
                        new UseItemOnWidgetItemOutboundMessage(
                            itemSelectedItemId,
                            widgetId,
                            containerId,
                            itemSelectedContainerSlot,
                            npcIdx,
                            targetWidgetId,
                            targetContainerId,
                            i
                        )
                    );

                    anInt704 = i_10_;
                    anInt1651 = 0;
                    anInt1233 = i;
                    atInventoryInterfaceType = 2;
                    if(gameScreenInterfaceId == i_10_ >> 16) {
                        atInventoryInterfaceType = 1;
                    }
                    if(chatboxInterfaceId == i_10_ >> 16) {
                        atInventoryInterfaceType = 3;
                    }
                }
                if(action == ActionRowType.SELECT_SPELL_ON_WIDGET.getId()) {
                    GameInterface gameInterface = getInterface(i_10_);
                    redrawTabArea = true;
                    Game.widgetSelected = 1;
                    Native.selectedSpellVerb = gameInterface.targetVerb;
                    MovedStatics.selectedMask = gameInterface.clickMask;
                    itemCurrentlySelected = 0;
                    selectedSpell = i_10_;
                    Native.selectedSpellName = Native.green + gameInterface.spellName + Native.white;
                    if(MovedStatics.selectedMask == 16) {
                        drawTabIcons = true;
                        Game.currentTabId = 3;
                        redrawTabArea = true;
                    }
                } else {
                    if(action == ActionRowType.EXAMINE_ITEM_ON_V2_WIDGET.getId()) {
                        GameInterface gameInterface = getInterface(i_10_);
                        if(gameInterface != null && gameInterface.children != null && i != -1) {
                            gameInterface = gameInterface.children[i];
                        }
                        if(gameInterface == null || gameInterface.itemAmount < 100000) {
                            OutgoingPackets.sendMessage(new ExamineItemOutboundMessage(npcIdx));
                        } else {
                            ChatBox.addChatMessage("", gameInterface.itemAmount + Native.amountSeparatorX + ItemDefinition.forId(npcIdx, 10).name, 0);
                        }
                    }
                    if(action == 42) {
                        GameInterface gameInterface = getInterface(i_10_);
                        boolean bool = true;
                        if(gameInterface.contentType > 0) {
                            bool = method166((byte) 88, gameInterface);
                        }
                        if(bool) {
                            int widgetId = (i_10_ >> 16) & 0xFFFF;
                            int childId = i_10_ & 0xFFFF;

                            OutgoingPackets.sendMessage(new ClickWidgetButtonOutboundMessage(widgetId, childId));
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new WidgetV2ItemInteractionOutboundMessage(
                                3,
                                widgetId,
                                containerId,
                                i,
                                npcIdx
                            )
                        );

                        anInt1233 = i;
                        atInventoryInterfaceType = 2;
                        anInt704 = i_10_;
                        anInt1651 = 0;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId()) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                            crossX = MouseHandler.clickX;
                            crossY = MouseHandler.clickY;
                            MovedStatics.crossIndex = 0;
                            MovedStatics.crossType = 2;

                            OutgoingPackets.sendMessage(new NPCInteractionOutboundMessage(1, npcIdx));
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_1.getId()) {
                        Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                        MovedStatics.crossType = 2;
                        MovedStatics.crossIndex = 0;
                        crossX = MouseHandler.clickX;
                        crossY = MouseHandler.clickY;

                        OutgoingPackets.sendMessage(
                            new WorldItemInteractionOutboundMessage(
                                1,
                                npcIdx,
                                MovedStatics.baseX + i,
                                MovedStatics.baseY + i_10_
                            )
                        );
                    }
                    if(action == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_3.getId()) {
                        Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                        MovedStatics.crossIndex = 0;
                        crossX = MouseHandler.clickX;
                        MovedStatics.crossType = 2;
                        crossY = MouseHandler.clickY;

                        OutgoingPackets.sendMessage(
                            new WorldItemInteractionOutboundMessage(
                                3,
                                npcIdx,
                                MovedStatics.baseX + i,
                                MovedStatics.baseY + i_10_
                            )
                        );
                    }
                    if(action == ActionRowType.CAST_MAGIC_ON_NPC.getId()) {
                        Npc npc = Player.npcs[npcIdx];
                        if(npc != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], npc.pathY[0], npc.pathX[0], 1, 1);
                            crossX = MouseHandler.clickX;
                            crossY = MouseHandler.clickY;
                            MovedStatics.crossIndex = 0;
                            MovedStatics.crossType = 2;

                            OutgoingPackets.sendMessage(
                                new CastMagicOnNPCOutboundMessage(
                                    selectedSpell,
                                    npcIdx
                                )
                            );
                        }
                    }
                    if(action == ActionRowType.ADD_FRIEND.getId() || action == ActionRowType.ADD_IGNORE.getId() || action == ActionRowType.REMOVE_FRIEND.getId() || action == ActionRowType.REMOVE_IGNORE.getId()) {
                        String s = MovedStatics.menuActionTexts[arg1];
                        int l1 = s.indexOf(Native.white);
                        if(l1 != -1) {
                            long l = TextUtils.nameToLong(s.substring(l1 + 5).trim());
                            if(action == ActionRowType.ADD_FRIEND.getId()) {
                                addFriend(l);
                            }
                            if(action == ActionRowType.ADD_IGNORE.getId()) {
                                addIgnore(l);
                            }
                            if(action == ActionRowType.REMOVE_FRIEND.getId()) {
                                removeFriend(l);
                            }
                            if(action == ActionRowType.REMOVE_IGNORE.getId()) {
                                removeIgnore(l);
                            }
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_PLAYER_OPTION_3.getId()) {
                        Player otherPlayer = Player.trackedPlayers[npcIdx];
                        if(otherPlayer != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], otherPlayer.pathY[0], otherPlayer.pathX[0], 1, 1);
                            MovedStatics.crossType = 2;
                            MovedStatics.crossIndex = 0;
                            crossX = MouseHandler.clickX;
                            crossY = MouseHandler.clickY;

                            OutgoingPackets.sendMessage(new PlayerInteractionOutboundMessage(3, npcIdx));
                        }
                    }
                    if(action == ActionRowType.WALK_HERE.getId()) {
                        if(MovedStatics.menuOpen) {
                            Game.currentScene.click(-4 + i, -4 + i_10_);
                        } else {
                            Game.currentScene.click(MouseHandler.clickX - 4, -4 + MouseHandler.clickY);
                        }
                    }
                    if(action == ActionRowType.EXAMINE_ITEM_ON_V1_WIDGET.getId()) {
                        GameInterface gameInterface = getInterface(i_10_);
                        if(gameInterface == null || gameInterface.itemAmounts[i] < 100000) {
                            OutgoingPackets.sendMessage(new ExamineItemOutboundMessage(npcIdx));
                        } else {
                            ChatBox.addChatMessage("", gameInterface.itemAmounts[i] + Native.amountSeparatorX + ItemDefinition.forId(npcIdx, 10).name, 0);
                        }
                        anInt1233 = i;
                        anInt1651 = 0;
                        anInt704 = i_10_;
                        atInventoryInterfaceType = 2;
                        if(i_10_ >> 16 == gameScreenInterfaceId) {
                            atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_OBJECT_OPTION_3.getId()) {
                        MovedStatics.method596(i, npcIdx, (byte) -104, i_10_);

                        int objectY = i_10_ + MovedStatics.baseY;
                        int objectId = npcIdx >> 14 & 0x7fff;
                        int objectX = i + MovedStatics.baseX;

                        OutgoingPackets.sendMessage(
                            new ObjectInteractionOutboundMessage(
                                3,
                                objectId,
                                objectX,
                                objectY
                            )
                        );
                    }
                    if(action == 50) {
                        ClientScriptRunner.method406(i, npcIdx, i_10_);
                    }
                    if(action == ActionRowType.CLOSE_PERMANENT_CHATBOX_WIDGET.getId()) {
                        resetInterface(ChatBox.dialogueId);
                        ChatBox.dialogueId = -1;
                        ChatBox.redrawChatbox = true;
                    }
                    if(action == ActionRowType.CAST_MAGIC_ON_OBJECT.getId() && MovedStatics.method596(i, npcIdx, (byte) -27, i_10_)) {
                        OutgoingPackets.sendMessage(
                            new CastMagicOnObjectOutboundMessage(
                                selectedSpell,
                                npcIdx >> 14 & 0x7fff,
                                i + MovedStatics.baseX,
                                i_10_ + MovedStatics.baseY
                            )
                        );
                    }
                    if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new WidgetV1ItemInteractionOutboundMessage(
                                2,
                                widgetId,
                                containerId,
                                i,
                                npcIdx
                            )
                        );

                        anInt1651 = 0;
                        atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                        anInt704 = i_10_;
                        anInt1233 = i;
                    }
                    if(action == ActionRowType.DROP_ITEM.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(new DropWidgetItemOutboundMessage(
                            widgetId,
                            containerId,
                            npcIdx,
                            i
                        ));

                        anInt1233 = i;
                        anInt704 = i_10_;
                        atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                        anInt1651 = 0;
                    }
                    if(action == ActionRowType.INTERACT_WITH_PLAYER_OPTION_5.getId()) {
                        Player otherPlayer = Player.trackedPlayers[npcIdx];
                        if(otherPlayer != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], otherPlayer.pathY[0], otherPlayer.pathX[0], 1, 1);
                            MovedStatics.crossType = 2;
                            crossY = MouseHandler.clickY;
                            crossX = MouseHandler.clickX;
                            MovedStatics.crossIndex = 0;

                            OutgoingPackets.sendMessage(new PlayerInteractionOutboundMessage(5, npcIdx));
                        }
                    }
                    if(action == ActionRowType.REPORT_ABUSE.getId()) {
                        String class1 = MovedStatics.menuActionTexts[arg1];
                        int i_22_ = class1.indexOf(Native.white);
                        if(i_22_ != -1) {
                            if(gameScreenInterfaceId == -1) {
                                closeAllWidgets();
                                if(reportAbuseWidgetId != -1) {
                                    Native.reportedName = class1.substring(i_22_ + 5).trim();
                                    reportAbuseInterfaceID = gameScreenInterfaceId = reportAbuseWidgetId;
                                    MovedStatics.reportMutePlayer = false;
                                }
                            } else {
                                ChatBox.addChatMessage("", English.pleaseCloseInterfaceBeforeReportAbuse, 0);
                            }
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_4.getId()) {
                        Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                        crossX = MouseHandler.clickX;
                        MovedStatics.crossIndex = 0;
                        MovedStatics.crossType = 2;
                        crossY = MouseHandler.clickY;

                        OutgoingPackets.sendMessage(
                            new WorldItemInteractionOutboundMessage(
                                4,
                                npcIdx,
                                MovedStatics.baseX + i,
                                MovedStatics.baseY + i_10_
                            )
                        );
                    }
                    if(action == ActionRowType.CLOSE_WIDGET.getId()) {
                        closeAllWidgets();
                    }
                    if(action == 54 && MovedStatics.lastContinueTextWidgetId == -1) { // Click to continue
                        method517(0, i_10_);
                        MovedStatics.lastContinueTextWidgetId = i_10_;
                    }
                    if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new WidgetV2ItemInteractionOutboundMessage(
                                4,
                                widgetId,
                                containerId,
                                i,
                                npcIdx
                            )
                        );

                        anInt1651 = 0;
                        atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 1;
                        }
                        anInt1233 = i;
                        anInt704 = i_10_;
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_5.getId()) {
                        Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                        crossY = MouseHandler.clickY;
                        MovedStatics.crossType = 2;
                        MovedStatics.crossIndex = 0;
                        crossX = MouseHandler.clickX;

                        OutgoingPackets.sendMessage(
                            new WorldItemInteractionOutboundMessage(
                                5,
                                npcIdx,
                                MovedStatics.baseX + i,
                                MovedStatics.baseY + i_10_
                            )
                        );
                    }
                    if(action == ActionRowType.INTERACT_WITH_PLAYER_OPTION_2.getId()) {
                        Player otherPlayer = Player.trackedPlayers[npcIdx];
                        if(otherPlayer != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], otherPlayer.pathY[0], otherPlayer.pathX[0], 1, 1);
                            MovedStatics.crossIndex = 0;
                            crossX = MouseHandler.clickX;
                            MovedStatics.crossType = 2;
                            crossY = MouseHandler.clickY;

                            OutgoingPackets.sendMessage(new PlayerInteractionOutboundMessage(2, npcIdx));
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new WidgetV1ItemInteractionOutboundMessage(
                                5,
                                widgetId,
                                containerId,
                                i,
                                npcIdx
                            )
                        );

                        anInt704 = i_10_;
                        anInt1651 = 0;
                        anInt1233 = i;
                        atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 1;
                        }
                        if(chatboxInterfaceId == i_10_ >> 16) {
                            atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_OBJECT_OPTION_1.getId()) {
                        MovedStatics.method596(i, npcIdx, (byte) -47, i_10_);
                        int objectId = 0x7fff & npcIdx >> 14;
                        int objectX = i + MovedStatics.baseX;
                        int objectY = i_10_ + MovedStatics.baseY;

                        OutgoingPackets.sendMessage(
                            new ObjectInteractionOutboundMessage(
                                1,
                                objectId,
                                objectX,
                                objectY
                            )
                        );
                    }
                    if(action == ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId()) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                            MovedStatics.crossType = 2;
                            crossX = MouseHandler.clickX;
                            crossY = MouseHandler.clickY;
                            MovedStatics.crossIndex = 0;

                            OutgoingPackets.sendMessage(new NPCInteractionOutboundMessage(5, npcIdx));
                        }
                    }
                    if(action == ActionRowType.USE_ITEM_ON_WORLD_ITEM.getId()) {
                        Pathfinding.doWorldItemWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], i, i_10_);
                        crossX = MouseHandler.clickX;
                        crossY = MouseHandler.clickY;
                        MovedStatics.crossIndex = 0;
                        MovedStatics.crossType = 2;

                        int widgetId = (itemSelectedWidgetId >> 16) & 0xFFFF;
                        int containerId = itemSelectedWidgetId & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new UseItemOnWorldItemOutboundMessage(
                                itemSelectedItemId,
                                widgetId,
                                containerId,
                                itemSelectedContainerSlot,
                                npcIdx,
                                i + MovedStatics.baseX,
                                MovedStatics.baseY + i_10_
                            )
                        );
                    }
                    if(action == ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId()) {
                        int widgetId = (i_10_ >> 16) & 0xFFFF;
                        int containerId = i_10_ & 0xFFFF;

                        OutgoingPackets.sendMessage(
                            new WidgetV2ItemInteractionOutboundMessage(
                                2,
                                widgetId,
                                containerId,
                                i,
                                npcIdx
                            )
                        );

                        anInt1233 = i;
                        anInt1651 = 0;
                        atInventoryInterfaceType = 2;
                        anInt704 = i_10_;
                        if(i_10_ >> 16 == gameScreenInterfaceId) {
                            atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId()) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[npcIdx];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doEntityWalkTo(Player.localPlayer.pathY[0], Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathY[0], class40_sub5_sub17_sub4_sub2.pathX[0], 1, 1);
                            MovedStatics.crossType = 2;
                            crossX = MouseHandler.clickX;
                            MovedStatics.crossIndex = 0;
                            crossY = MouseHandler.clickY;

                            OutgoingPackets.sendMessage(new NPCInteractionOutboundMessage(3, npcIdx));
                        }
                    }
                    if(itemCurrentlySelected != 0) {
                        itemCurrentlySelected = 0;
                        redrawTabArea = true;
                    }
                    if(Game.widgetSelected != 0) {
                        redrawTabArea = true;
                        Game.widgetSelected = 0;
                    }
                }
            }
        }
    }

    public static void runClientScriptsForParentInterface(int arg1, int arg2, int arg3, int widgetId, int arg5, int arg6) {
        if (!decodeGameInterface(widgetId)) {
            return;
        }

        runClientScriptsForInterface(arg5, arg3, 0, arg2, arg6, -1, cachedInterfaces[widgetId], arg1, 0);

        if(aGameInterface_353 != null) {
            GameInterface gameInterface = aGameInterface_353;
            GameInterface gameInterface_24_ = method878(gameInterface);
            if(gameInterface_24_ != null) {
                int[] is = method247(gameInterface_24_);
                int[] is_25_ = method247(gameInterface);
                int i = is_25_[1] - is[1] + -MovedStatics.anInt2621 + MouseHandler.mouseY;
                int i_26_ = -is[0] + is_25_[0] + MouseHandler.mouseX + -MovedStatics.anInt1996;
                if(i < 0) {
                    i = 0;
                }
                if(gameInterface_24_.originalHeight < i + gameInterface.originalHeight) {
                    i = -gameInterface.originalHeight + gameInterface_24_.originalHeight;
                }
                if(i_26_ < 0) {
                    i_26_ = 0;
                }
                if(gameInterface_24_.originalWidth < gameInterface.originalWidth + i_26_) {
                    i_26_ = gameInterface_24_.originalWidth - gameInterface.originalWidth;
                }
                if(aGameInterface_353.anObjectArray2669 != null && (arg2 & 0x200) != 0) {
                    ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2669, 0, i, gameInterface, i_26_);
                }
                if(MouseHandler.currentMouseButtonPressed == 0 && (arg2 & 0x400) != 0) {
                    if(aGameInterface_353.anObjectArray2695 != null) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2695, 0, i, gameInterface, i_26_);
                    }
                    aGameInterface_353 = null;
                }
            }
        }
    }

    public static GameInterface method361(GameInterface[] arg0, int arg1, boolean arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg0 == null) {
            return null;
        }
        GameInterface gameInterface = null;
        for(int i = 0; arg0.length > i; i++) {
            GameInterface gameInterface_27_ = arg0[i];
            if(gameInterface_27_ != null && gameInterface_27_.parentId == arg4) {
                int i_28_ = arg3 + gameInterface_27_.currentY;
                int i_29_ = arg5 + gameInterface_27_.currentX;
                if(i_29_ <= arg6 && i_28_ <= arg1 && i_29_ + gameInterface_27_.originalWidth > arg6 && arg1 < i_28_ + gameInterface_27_.originalHeight && !gameInterface_27_.isHidden) {
                    if(gameInterface_27_.id < 0 && arg2 || gameInterface_27_.id >= 0 && !arg2) {
                        gameInterface = gameInterface_27_;
                    }
                    if(gameInterface_27_.type == GameInterfaceType.LAYER) {
                        GameInterface gameInterface_30_ = method361(arg0, arg1, arg2, -gameInterface_27_.scrollPosition + gameInterface_27_.currentY, i, gameInterface_27_.currentX - gameInterface_27_.scrollWidth, arg6, 398);
                        if(gameInterface_30_ != null) {
                            gameInterface = gameInterface_30_;
                        }
                        if(arg2 && gameInterface_27_.children != null) {
                            GameInterface gameInterface_31_ = method361(gameInterface_27_.children, arg1, arg2, gameInterface_27_.currentY + -gameInterface_27_.scrollPosition, gameInterface_27_.id, gameInterface_27_.currentX - gameInterface_27_.scrollWidth, arg6, 398);
                            if(gameInterface_31_ != null) {
                                gameInterface = gameInterface_31_;
                            }
                        }
                    }
                }
            }
        }
        if(arg7 != 398) {
            English.take = null;
        }
        return gameInterface;
    }

    public static void scrollInterface(int arg0, int arg1, int arg2, int arg3, GameInterface arg5, int arg6, int arg7, int arg8) {
        if(aBoolean1444)
            anInt1171 = 32;
        else
            anInt1171 = 0;
        aBoolean1444 = false;
        if(arg2 >= arg6 && arg2 < arg6 + 16 && arg1 >= arg8 && 16 + arg8 > arg1) {
            arg5.scrollPosition -= MovedStatics.anInt3294 * 4;
            if(arg7 == 1)
                redrawTabArea = true;
            if(arg7 == 2 || arg7 == 3)
                ChatBox.redrawChatbox = true;
        } else if(arg6 > arg2 || arg6 + 16 <= arg2 || arg1 < arg8 + arg0 + -16 || arg1 >= arg8 + arg0) {
            if(-anInt1171 + arg6 <= arg2 && 16 + arg6 + anInt1171 > arg2 && arg8 + 16 <= arg1 && arg1 < -16 + arg8 + arg0 && MovedStatics.anInt3294 > 0) {
                aBoolean1444 = true;
                int i = (-32 + arg0) * arg0 / arg3;
                if(arg7 == 2 || arg7 == 3)
                    ChatBox.redrawChatbox = true;
                if(arg7 == 1)
                    redrawTabArea = true;
                if(i < 8)
                    i = 8;
                int i_17_ = -i + arg0 + -32;
                int i_18_ = -(i / 2) + -arg8 + arg1 + -16;
                arg5.scrollPosition = (arg3 + -arg0) * i_18_ / i_17_;
            }
        } else {
            arg5.scrollPosition += 4 * MovedStatics.anInt3294;
            if(arg7 == 2 || arg7 == 3)
                ChatBox.redrawChatbox = true;
            if(arg7 == 1)
                redrawTabArea = true;
        }
    }

    public static boolean method166(byte arg0, GameInterface arg1) {
        int i = arg1.contentType;
        if(Player.friendListStatus == 2) {
            if(i == 201) {
                anInt876 = 1;
                Native.enterPlayerNameHeader = English.enterNameOfFriendToAddToList;
                ChatBox.messagePromptRaised = true;
                ChatBox.inputType = 0;
                ChatBox.chatMessage = "";
                ChatBox.redrawChatbox = true;
            }
            if(i == 202) {
                anInt876 = 2;
                Native.enterPlayerNameHeader = English.enterNameOfFriendToDeleteFromList;
                ChatBox.redrawChatbox = true;
                ChatBox.inputType = 0;
                ChatBox.messagePromptRaised = true;
                ChatBox.chatMessage = "";
            }
        }
        if(i == 205) {
            Game.idleLogout = 250;
            return true;
        }
        if(i == 501) {
            ChatBox.inputType = 0;
            anInt876 = 4;
            ChatBox.redrawChatbox = true;
            Native.enterPlayerNameHeader = English.enterNameOfPlayerToAddToList;
            ChatBox.chatMessage = "";
            ChatBox.messagePromptRaised = true;
        }
        if(i == 502) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
            anInt876 = 5;
            ChatBox.messagePromptRaised = true;
            ChatBox.chatMessage = "";
            Native.enterPlayerNameHeader = English.enterNameOfPlayerToDeleteFromList;
        }
        if(i >= 300 && i <= 313) {
            int i_13_ = (-300 + i) / 2;
            int i_14_ = 0x1 & i;
            Player.activePlayerAppearance.loadCachedAppearance(i_13_, i_14_ == 1);
        }
        if(i >= 314 && i <= 323) {
            int i_15_ = (i + -314) / 2;
            int i_16_ = i & 0x1;
            Player.activePlayerAppearance.updateAppearanceColors(i_16_ == 1, i_15_);
        }
        if(i == 324)
            Player.activePlayerAppearance.setGender(false);
        if(i == 325)
            Player.activePlayerAppearance.setGender(true);
        if(i == 326) {
            OutgoingPackets.sendMessage(new SubmitAppearanceOutboundMessage(Player.activePlayerAppearance));

            return true;
        }
        if(i == 620)
            MovedStatics.reportMutePlayer = !MovedStatics.reportMutePlayer;
        if(i >= 601 && i <= 613) {
            closeAllWidgets();
            if(Native.reportedName.length() > 0) {
                OutgoingPackets.sendMessage(
                    new SubmitReportAbuseOutboundMessage(
                        TextUtils.nameToLong(Native.reportedName),
                        i - 601,
                        MovedStatics.reportMutePlayer
                    )
                );
            }
        }
        return false;
    }

    public static void runClientScriptsForInterface(int minY, int arg1, int scrollWidth, int arg3, int minX, int parentId, GameInterface[] interfaceCollection, int arg8, int scrollHeight) {
        for (int i = 0; i < interfaceCollection.length; i++) {
            GameInterface gameInterface = interfaceCollection[i];
            if (gameInterface != null && (gameInterface.type == GameInterfaceType.LAYER || gameInterface.hasListeners) && parentId == gameInterface.parentId && (!gameInterface.isHidden || hiddenButtonTest)) {
                int absoluteX = minX + gameInterface.currentX;
                int absoluteY = minY + gameInterface.currentY;
                if (!gameInterface.lockScroll)
                    absoluteY -= scrollHeight;
                int bottomLeftY = absoluteY + gameInterface.originalHeight;
                int i_4_ = Math.max(minY, absoluteY);
                if (!gameInterface.lockScroll)
                    absoluteX -= scrollWidth;
                int topRightX = absoluteX + gameInterface.originalWidth;
                int i_6_ = Math.max(minX, absoluteX);
                int i_7_ = Math.min(arg1, bottomLeftY);
                int i_8_ = Math.min(topRightX, arg8);
                if (gameInterface.type == GameInterfaceType.LAYER) {
                    runClientScriptsForInterface(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, i, interfaceCollection, i_8_, gameInterface.scrollPosition);
                    if (gameInterface.children != null)
                        runClientScriptsForInterface(i_4_, i_7_, gameInterface.scrollWidth, arg3, i_6_, gameInterface.id, gameInterface.children, i_8_, gameInterface.scrollPosition);
                }
                if (gameInterface.hasListeners) {
                    boolean bool;
                    bool = MouseHandler.mouseX >= i_6_ && i_4_ <= MouseHandler.mouseY && i_8_ > MouseHandler.mouseX && i_7_ > MouseHandler.mouseY;
                    boolean bool_9_ = false;
                    if (MouseHandler.currentMouseButtonPressed == 1 && bool)
                        bool_9_ = true;
                    boolean bool_10_ = false;
                    if (gameInterface.anInt2738 != -1 && bool_9_ && aGameInterface_353 == null) {
                        MovedStatics.anInt1996 = MouseHandler.mouseX;
                        aGameInterface_353 = gameInterface;
                        MovedStatics.anInt2621 = MouseHandler.mouseY;
                    }
                    if (MouseHandler.clickType == 1 && i_6_ <= MouseHandler.clickX && MouseHandler.clickY >= i_4_ && MouseHandler.clickX < i_8_ && MouseHandler.clickY < i_7_)
                        bool_10_ = true;
                    if (aGameInterface_353 != null) {
                        bool_9_ = false;
                        bool = false;
                        bool_10_ = false;
                    }
                    if (!gameInterface.aBoolean2730 && bool_10_ && (0x1 & arg3) != 0) {
                        gameInterface.aBoolean2730 = true;
                        if (gameInterface.anObjectArray2681 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2681, 0, MouseHandler.clickY + -absoluteY, gameInterface, MouseHandler.clickX - absoluteX);
                    }
                    if (gameInterface.aBoolean2730 && bool_9_ && (arg3 & 0x4) != 0 && gameInterface.anObjectArray2747 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2747, 0, -absoluteY + MouseHandler.mouseY, gameInterface, -absoluteX + MouseHandler.mouseX);
                    if (gameInterface.aBoolean2730 && !bool_9_ && (0x2 & arg3) != 0) {
                        gameInterface.aBoolean2730 = false;
                        if (gameInterface.anObjectArray2707 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2707, 0, MouseHandler.mouseY - absoluteY, gameInterface, MouseHandler.mouseX - absoluteX);
                    }
                    if (bool_9_ && (arg3 & 0x8) != 0 && gameInterface.anObjectArray2644 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2644, 0, -absoluteY + MouseHandler.mouseY, gameInterface, -absoluteX + MouseHandler.mouseX);
                    if (!gameInterface.aBoolean2682 && bool && (0x10 & arg3) != 0) {
                        gameInterface.aBoolean2682 = true;
                        if (gameInterface.anObjectArray2658 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2658, 0, MouseHandler.mouseY - absoluteY, gameInterface, MouseHandler.mouseX - absoluteX);
                    }
                    if (gameInterface.aBoolean2682 && bool && (0x40 & arg3) != 0 && gameInterface.anObjectArray2680 != null)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2680, 0, -absoluteY + MouseHandler.mouseY, gameInterface, -absoluteX + MouseHandler.mouseX);
                    if (gameInterface.aBoolean2682 && !bool && (arg3 & 0x20) != 0) {
                        gameInterface.aBoolean2682 = false;
                        if (gameInterface.anObjectArray2672 != null)
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2672, 0, -absoluteY + MouseHandler.mouseY, gameInterface, -absoluteX + MouseHandler.mouseX);
                    }
                    if (gameInterface.anObjectArray2712 != null && (arg3 & 0x80) != 0)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2712, 0, 0, gameInterface, 0);
                    if (MovedStatics.anInt2480 == MovedStatics.pulseCycle && gameInterface.anObjectArray2650 != null && (arg3 & 0x100) != 0)
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2650, 0, 0, gameInterface, 0);
                }
            }
        }

    }

    public static void removeFriend(long nameAsLong) {
        if (nameAsLong != 0) {
            int i = 0;
            for (/**/; Player.friendsCount > i; i++) {
                if (Player.friends[i] == nameAsLong) {
                    Player.friendsCount--;
                    redrawTabArea = true;
                    for (int i_13_ = i; i_13_ < Player.friendsCount; i_13_++) {
                        Player.friendUsernames[i_13_] = Player.friendUsernames[1 + i_13_];
                        Player.friendWorlds[i_13_] = Player.friendWorlds[i_13_ + 1];
                        Player.friends[i_13_] = Player.friends[1 + i_13_];
                    }

                    OutgoingPackets.sendMessage(
                        new ModifySocialListOutboundMessage(nameAsLong, ModifySocialListOutboundMessage.SocialList.FRIEND, ModifySocialListOutboundMessage.SocialListAction.REMOVE));
                    break;
                }
            }
        }
    }

    public static boolean isHovering(int areaId, int widgetChildId) {
        if(areaId == 0 && MovedStatics.anInt2850 == widgetChildId)
            return true;

        if(areaId == 1 && widgetChildId == MovedStatics.currentHoveredWidgetChildId)
            return true;

        if((areaId == 2 || areaId == 3) && MovedStatics.currentHoveredChatboxWidgetChildId == widgetChildId)
            return true;

        return false;
    }

    public static void manageTextInputs() {
        while(MovedStatics.method416()) {
            if(MovedStatics.anInt2854 == 28) {
                break;
            }
            if(Console.console.consoleOpen) {
                Console.console.handleInput();
                break;
            }
            if(gameScreenInterfaceId != -1 && reportAbuseInterfaceID == gameScreenInterfaceId) {
                if(MovedStatics.anInt2854 == 85 && Native.reportedName.length() > 0)
                    Native.reportedName = Native.reportedName.substring(0, -1 + Native.reportedName.length());
                if((MovedStatics.method735(MovedStatics.anInt1388) || MovedStatics.anInt1388 == 32) && Native.reportedName.length() < 12)
                    Native.reportedName = Native.reportedName + (char) MovedStatics.anInt1388;
            } else if(ChatBox.messagePromptRaised) {
                if(MovedStatics.anInt2854 == 85 && ChatBox.chatMessage.length() > 0) {
                    ChatBox.chatMessage = ChatBox.chatMessage.substring(0, -1 + ChatBox.chatMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.method793(MovedStatics.anInt1388) && ChatBox.chatMessage.length() < 80) {
                    ChatBox.chatMessage = ChatBox.chatMessage + (char) MovedStatics.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.anInt2854 == 84) {
                    ChatBox.messagePromptRaised = false;
                    ChatBox.redrawChatbox = true;
                    if(anInt876 == 1) {
                        long l = MovedStatics.nameToLong(ChatBox.chatMessage);
                        addFriend(l);
                    }
                    if(anInt876 == 2 && Player.friendsCount > 0) {
                        long l = MovedStatics.nameToLong(ChatBox.chatMessage);
                        removeFriend(l);
                    }
                    if(anInt876 == 3 && ChatBox.chatMessage.length() > 0) {
// private messages
                        ChatBox.filterInput();

OutgoingPackets.sendMessage(new SendPrivateMessageOutboundMessage(sendingMessageTo, ChatBox.chatboxInput));

                        if(ChatBox.privateChatMode == 2) {
                            ChatBox.privateChatMode = 1;
                            MovedStatics.redrawChatbox = true;

OutgoingPackets.sendMessage(new SetChatOptionsOutboundMessage(
ChatBox.publicChatMode,
ChatBox.privateChatMode,
ChatBox.tradeMode
));
                        }
                    }
                    if(anInt876 == 4 && Player.ignoresCount < 100) {
                        long l = MovedStatics.nameToLong(ChatBox.chatMessage);
                        addIgnore(l);
                    }
                    if(anInt876 == 5 && Player.ignoresCount > 0) {
                        long l = MovedStatics.nameToLong(ChatBox.chatMessage);
                        removeIgnore(l);
                    }
                }
            } else if(ChatBox.inputType == 1) {
                if(MovedStatics.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if(method1027(MovedStatics.anInt1388) && ChatBox.inputMessage.length() < 10) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) MovedStatics.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.anInt2854 == 84) {
                    if(ChatBox.inputMessage.length() > 0) {
                        int inputValue = 0;
                        try {
                            inputValue = Integer.parseInt(ChatBox.inputMessage);
                        } catch(Exception _ex) {
                            /* empty */
                        }

OutgoingPackets.sendMessage(new SubmitChatboxWidgetNumericInputOutboundMessage(inputValue));
                    }
                    ChatBox.redrawChatbox = true;
                    ChatBox.inputType = 0;
                }
            } else if(ChatBox.inputType == 2) {
                if(MovedStatics.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, -1 + ChatBox.inputMessage.length());
                    ChatBox.redrawChatbox = true;
                }
                if((MovedStatics.method735(MovedStatics.anInt1388) || MovedStatics.anInt1388 == 32) && ChatBox.inputMessage.length() < 12) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) MovedStatics.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.anInt2854 == 84) {
                    if(ChatBox.inputMessage.length() > 0) {
long name = MovedStatics.nameToLong(ChatBox.inputMessage);

OutgoingPackets.sendMessage(new SubmitChatboxWidgetNameInputOutboundMessage(name));
                    }
                    ChatBox.inputType = 0;
                    ChatBox.redrawChatbox = true;
                }
            } else if(ChatBox.inputType == 3) {
                if(MovedStatics.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
                    ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 10);
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.method793(MovedStatics.anInt1388) && ChatBox.inputMessage.length() < 40) {
                    ChatBox.inputMessage = ChatBox.inputMessage + (char) MovedStatics.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
            } else if(chatboxInterfaceId == -1 && fullscreenInterfaceId == -1) {
                if(MovedStatics.anInt2854 == 85 && ChatBox.chatboxInput.length() > 0) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput.substring(0, ChatBox.chatboxInput.length() - 1);
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.method793(MovedStatics.anInt1388) && ChatBox.chatboxInput.length() < 80) {
                    ChatBox.chatboxInput = ChatBox.chatboxInput + (char) MovedStatics.anInt1388;
                    ChatBox.redrawChatbox = true;
                }
                if(MovedStatics.anInt2854 == 84 && ChatBox.chatboxInput.length() > 0) {
                    if(Game.playerRights > 1) {
                        if(ChatBox.chatboxInput.equals(English.commandClientDrop))
                            Game.dropClient();
                        if(ChatBox.chatboxInput.equals(English.commandFpson)) {
                            MovedStatics.showFps = true;
                            ChatBox.inputType = 3;
                        }
                        if(ChatBox.chatboxInput.startsWith("::region")) {
                            for(int qq = 0; qq < 469; qq++) {
                                if(decodeGameInterface(qq)) {
                                    GameInterface[] gameInterfaces = cachedInterfaces[qq];
                                    for(int y = 0; gameInterfaces.length > y; y++) {
                                        GameInterface gameInterface = gameInterfaces[y];
                                        if(gameInterface.disabledText != null) {
                                            String text = gameInterface.disabledText.toString().toLowerCase();
                                            if(gameInterface.disabledText.toString().toLowerCase().contains("bank")) {
                                                System.out.println(qq + " contains " + text);
                                            }
                                        }
                                    }
                                }
                            }
                        }

                        if(ChatBox.chatboxInput.equals(Native.cmd_fpsoff))
                            MovedStatics.showFps = false;
                        if(ChatBox.chatboxInput.equals(English.commandNoclip)) {
                            for(int i = 0; i < 4; i++) {
                                for(int i_9_ = 1; i_9_ < 103; i_9_++) {
                                    for(int i_10_ = 1; i_10_ < 103; i_10_++)
                                        Landscape.currentCollisionMap[i].clippingData[i_9_][i_10_] = 0;
                                }
                            }
                        }
                        if(ChatBox.chatboxInput.equals(English.commandErrorTest) && Game.modewhere == 2)
                            throw new RuntimeException();
                        if(ChatBox.chatboxInput.equals(Native.cmd_hiddenbuttontest))
                            hiddenButtonTest = true;
                    }
                    if(ChatBox.chatboxInput.startsWith(Native.cmd_prefix)) {
// remove the :: prefix
String command = ChatBox.chatboxInput.substring(2);

OutgoingPackets.sendMessage(new ChatCommandOutboundMessage(command));
                    } else {
                        ChatColorEffect chatColorEffect = ChatColorEffect.fromString(ChatBox.chatboxInput.toLowerCase());

if (chatColorEffect != null) {
ChatBox.chatboxInput = ChatBox.chatboxInput.substring(chatColorEffect.getPrefixLength());
}

ChatShapeEffect chatShapeEffect = ChatShapeEffect.fromString(ChatBox.chatboxInput.toLowerCase());

if (chatShapeEffect != null) {
ChatBox.chatboxInput = ChatBox.chatboxInput.substring(chatShapeEffect.getPrefixLength());
}

                        ChatBox.filterInput();

SendChatMessageOutboundMessage message = new SendChatMessageOutboundMessage(
chatColorEffect != null ? chatColorEffect : ChatColorEffect.YELLOW,
chatShapeEffect != null ? chatShapeEffect : ChatShapeEffect.NONE,
ChatBox.chatboxInput
);

OutgoingPackets.sendMessage(message);

// I guess resets from 'off' to... 'friends'? public?
                        if(ChatBox.publicChatMode == 2) {
                            MovedStatics.redrawChatbox = true;
                            ChatBox.publicChatMode = 3;

OutgoingPackets.sendMessage(new SetChatOptionsOutboundMessage(
ChatBox.publicChatMode,
ChatBox.privateChatMode,
ChatBox.tradeMode
));
                        }
                    }
                    ChatBox.redrawChatbox = true;
                    ChatBox.chatboxInput = "";
                }
            }
        }

    }

    private static void addFriend(long name) {
        if(name != 0L) {
            if(Player.friendsCount >= 100 && MovedStatics.anInt1049 != 1 || Player.friendsCount >= 200) {
                ChatBox.addChatMessage("", English.friendsListIsFull, 0);
            } else {
                String username = TextUtils.formatName(TextUtils.longToName(name));
                for(int i = 0; Player.friendsCount > i; i++) {
                    if(Player.friends[i] == name) {
                        ChatBox.addChatMessage("", username + English.isAlreadyOnYourFriendList, 0);
                        return;
                    }
                }
                for(int i = 0; Player.ignoresCount > i; i++) {
                    if(Player.ignores[i] == name) {
                        ChatBox.addChatMessage("", English.pleaseRemove + username + English.suffixFromYourIgnoreListFirst, 0);
                        return;
                    }
                }
                if(!username.equals(Player.localPlayer.playerName)) {
                    Player.friendUsernames[Player.friendsCount] = username;
                    Player.friends[Player.friendsCount] = name;
                    Player.friendWorlds[Player.friendsCount] = 0;
                    Player.friendsCount++;
                    redrawTabArea = true;

                    OutgoingPackets.sendMessage(
                        new ModifySocialListOutboundMessage(name, ModifySocialListOutboundMessage.SocialList.FRIEND, ModifySocialListOutboundMessage.SocialListAction.ADD));
                }
            }
        }
    }

    private static void removeIgnore(long arg1) {
        for (int i = 0; i < Player.ignoresCount; i++) {
            if (Player.ignores[i] == arg1) {
                redrawTabArea = true;
                Player.ignoresCount--;
                for (int i_16_ = i; Player.ignoresCount > i_16_; i_16_++)
                    Player.ignores[i_16_] = Player.ignores[1 + i_16_];

                OutgoingPackets.sendMessage(
                    new ModifySocialListOutboundMessage(arg1, ModifySocialListOutboundMessage.SocialList.IGNORE, ModifySocialListOutboundMessage.SocialListAction.REMOVE));
                break;
            }
        }
    }

    private static void addIgnore(long arg1) {
        if(arg1 != 0L) {
            if(Player.ignoresCount >= 100)
                ChatBox.addChatMessage("", English.yourIgnoreListIsFull.toString(), 0);
            else {
                String class1 = TextUtils.formatName(TextUtils.longToName(arg1));
                for(int i = 0; i < Player.ignoresCount; i++) {
                    if(arg1 == Player.ignores[i]) {
                        ChatBox.addChatMessage("", class1 + English.suffixIsAlreadyOnYourIgnoreList, 0);
                        return;
                    }
                }
                for(int i = 0; Player.friendsCount > i; i++) {
                    if(Player.friends[i] == arg1) {
                        ChatBox.addChatMessage("", English.pleaseRemove + class1 + English.fromYourFriendListFirst, 0);
                        return;
                    }
                }
                if(!class1.equals(Player.localPlayer.playerName)) {
                    Player.ignores[Player.ignoresCount++] = arg1;
                    redrawTabArea = true;

                    OutgoingPackets.sendMessage(
                        new ModifySocialListOutboundMessage(arg1, ModifySocialListOutboundMessage.SocialList.IGNORE, ModifySocialListOutboundMessage.SocialListAction.ADD));
                }
            }
        }
    }

    private static boolean method1027(int arg0) {
        return arg0 >= 48 && arg0 <= 57;
    }

    public static GameInterface method878(GameInterface arg1) {
        int i;
        if(arg1.id < 0)
            i = arg1.parentId >> 16;
        else
            i = arg1.id >> 16;
        if(!decodeGameInterface(i))
            return null;
        if(arg1.anInt2738 >= 0)
            return cachedInterfaces[i][0xffff & arg1.anInt2738];
        GameInterface gameInterface = cachedInterfaces[i][(0x7fff99d9 & arg1.anInt2738) >> 15];
        return gameInterface.children[arg1.anInt2738 & 0x7fff];
    }

    public static boolean checkForAlternateAction(GameInterface gameInterface) {
        if(gameInterface.alternateOperators == null) {
            return false;
        }
        for(int scriptIndex = 0; gameInterface.alternateOperators.length > scriptIndex; scriptIndex++) {
            int i_10_ = ClientScript.parseClientScripts(scriptIndex, gameInterface);
            int rhsValue = gameInterface.alternateRhs[scriptIndex]; // 1
            if(gameInterface.alternateOperators[scriptIndex] == 2) {
                if(rhsValue <= i_10_) {
                    return false;
                }
            } else if(gameInterface.alternateOperators[scriptIndex] == 3) {
                if(rhsValue >= i_10_) {
                    return false;
                }
            } else if(gameInterface.alternateOperators[scriptIndex] == 4) {
                if(rhsValue == i_10_) {
                    return false;
                }
            } else if(i_10_ != rhsValue) {
                return false;
            }
        }
        return true;
    }

    public static int[] method247(GameInterface arg0) {
        int i;
        if(arg0.id < 0)
            i = arg0.parentId >> 16;
        else
            i = arg0.id >> 16;
        if(!decodeGameInterface(i))
            return null;
        int i_11_ = arg0.currentX;
        int i_12_ = arg0.currentY;
        int i_13_ = arg0.parentId;
        while(i_13_ != -1) {
            GameInterface gameInterface = cachedInterfaces[i][i_13_ & 0xffff];
            i_11_ += gameInterface.currentX;
            if(!arg0.lockScroll)
                i_11_ -= gameInterface.scrollWidth;
            i_12_ += gameInterface.currentY;
            i_13_ = gameInterface.parentId;
            if(!arg0.lockScroll)
                i_12_ -= gameInterface.scrollPosition;
        }
        int[] is = new int[2];
        is[0] = i_11_;
        is[1] = i_12_;
        return is;
    }

    public static void closeAllWidgets() {
        OutgoingPackets.sendMessage(new CloseWidgetsOutboundMessage());

        if(tabAreaInterfaceId != -1) {
            resetInterface(tabAreaInterfaceId);
            MovedStatics.lastContinueTextWidgetId = -1;
            drawTabIcons = true;
            redrawTabArea = true;
            tabAreaInterfaceId = -1;
        }
        if(chatboxInterfaceId != -1) {
            resetInterface(chatboxInterfaceId);
            MovedStatics.lastContinueTextWidgetId = -1;
            ChatBox.redrawChatbox = true;
            chatboxInterfaceId = -1;
        }
        if(fullscreenInterfaceId != -1) {
            resetInterface(fullscreenInterfaceId);
            fullscreenInterfaceId = -1;
            MovedStatics.processGameStatus(30);
        }
        if(fullscreenSiblingInterfaceId != -1) {
            resetInterface(fullscreenSiblingInterfaceId);
            fullscreenSiblingInterfaceId = -1;
        }
        if(gameScreenInterfaceId != -1) {
            resetInterface(gameScreenInterfaceId);
            gameScreenInterfaceId = -1;
            MovedStatics.lastContinueTextWidgetId = -1;
        }
    }

    public static void method517(int option, int interfaceData) {
        int widgetId = (interfaceData >> 16) & 0xFFFF;
        int childId = interfaceData & 0xFFFF;

        OutgoingPackets.sendMessage(
            new ClickPleaseWaitWidgetOutboundMessage(
                widgetId,
                childId,
                option
            )
        );
    }

    public static void clearInterfaceCaches() {
        interfaceItemImageCache.clear();
        interfaceModelCache.clear();
        interfaceTypefaceCache.clear();
    }

    public static boolean handleSequences(int arg1) {
        if(!decodeGameInterface(arg1))
            return false;
        GameInterface[] gameInterfaces = cachedInterfaces[arg1];
        boolean bool = false;
        for(int i = 0; gameInterfaces.length > i; i++) {
            GameInterface gameInterface = gameInterfaces[i];
            if(gameInterface != null && gameInterface.type == GameInterfaceType.MODEL) {
                if(gameInterface.animation != -1 || gameInterface.alternateAnimation != -1) {
                    boolean bool_0_ = checkForAlternateAction(gameInterface);
                    int i_1_;
                    if(bool_0_)
                        i_1_ = gameInterface.alternateAnimation;
                    else
                        i_1_ = gameInterface.animation;
                    if(i_1_ != -1) {
                        AnimationSequence animationSequence = AnimationSequence.getAnimationSequence(i_1_);
                        gameInterface.remainingAnimationTime += MovedStatics.anInt199;
                        while(animationSequence.frameLengths[gameInterface.animationFrame] < gameInterface.remainingAnimationTime) {
                            bool = true;
                            gameInterface.remainingAnimationTime -= animationSequence.frameLengths[gameInterface.animationFrame];
                            gameInterface.animationFrame++;
                            if(gameInterface.animationFrame >= animationSequence.frameIds.length) {
                                gameInterface.animationFrame -= animationSequence.frameStep;
                                if(gameInterface.animationFrame < 0 || animationSequence.frameIds.length <= gameInterface.animationFrame)
                                    gameInterface.animationFrame = 0;
                            }
                        }
                    }
                }
                if(gameInterface.rotationSpeed != 0) {
                    bool = true;
                    int i_2_ = gameInterface.rotationSpeed >> 16;
                    int i_3_ = gameInterface.rotationSpeed << 16 >> 16;
                    i_2_ *= MovedStatics.anInt199;
                    gameInterface.rotationX = 0x7ff & i_2_ + gameInterface.rotationX;
                    i_3_ *= MovedStatics.anInt199;
                    gameInterface.rotationZ = 0x7ff & gameInterface.rotationZ + i_3_;
                }
            }
        }
        return bool;
    }

    public void swapItems(int arg0, boolean arg1, int arg2) {
        int i = items[arg2];
        items[arg2] = items[arg0];
        items[arg0] = i;
        i = itemAmounts[arg2];
        itemAmounts[arg2] = itemAmounts[arg0];
        if(arg1) {
            clientScripts = null;
        }
        itemAmounts[arg0] = i;
    }

    public void decodeIf1(Buffer buffer) {
        isNewInterfaceFormat = false;
        type = GameInterfaceType.get(buffer.getUnsignedByte());
        actionType = buffer.getUnsignedByte();
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE(); // originalX
        originalY = currentY = buffer.getShortBE(); // originalY
        originalWidth = buffer.getUnsignedShortBE();
        originalHeight = buffer.getUnsignedShortBE();
        opacity = buffer.getUnsignedByte();
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        hoveredSiblingId = buffer.getUnsignedShortBE();
        if(hoveredSiblingId == 0xFFFF) {
            hoveredSiblingId = -1;
        }
        int var2 = buffer.getUnsignedByte();
        int var3;
        if(var2 > 0) {
            alternateOperators = new int[var2];
            alternateRhs = new int[var2];
            for(var3 = 0; var2 > var3; var3++) {
                alternateOperators[var3] = buffer.getUnsignedByte();
                alternateRhs[var3] = buffer.getUnsignedShortBE();
            }
        }
        var3 = buffer.getUnsignedByte();
        if(var3 > 0) {
            clientScripts = new int[var3][];
            for(int i_2_ = 0; i_2_ < var3; i_2_++) {
                int i_3_ = buffer.getUnsignedShortBE();
                clientScripts[i_2_] = new int[i_3_];
                for(int i_4_ = 0; i_3_ > i_4_; i_4_++) {
                    clientScripts[i_2_][i_4_] = buffer.getUnsignedShortBE();
                    if(clientScripts[i_2_][i_4_] == 65535) {
                        clientScripts[i_2_][i_4_] = -1;
                    }
                }
            }
        }
        if(type == GameInterfaceType.LAYER) {
            scrollHeight = buffer.getUnsignedShortBE();
            isHidden = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.UNKNOWN) {
            buffer.getUnsignedShortBE();
            buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.INVENTORY) {
            items = new int[originalHeight * originalWidth];
            itemAmounts = new int[originalHeight * originalWidth];
            itemSwapable = buffer.getUnsignedByte() == 1;
            isInventory = buffer.getUnsignedByte() == 1;
            itemUsable = buffer.getUnsignedByte() == 1;
            itemDeletesDraged = buffer.getUnsignedByte() == 1;
            itemSpritePadsX = buffer.getUnsignedByte();
            itemSpritePadsY = buffer.getUnsignedByte();
            imageX = new int[20];
            imageY = new int[20];
            images = new int[20];
            for(int sprite = 0; sprite < 20; sprite++) {
                int hasSprite = buffer.getUnsignedByte();
                if(hasSprite == 1) {
                    images[sprite] = buffer.getShortBE();
                    imageX[sprite] = buffer.getShortBE();
                    imageY[sprite] = buffer.getIntBE();
                } else {
                    imageY[sprite] = -1;
                }
            }
            configActions = new String[5];
            for(int i_7_ = 0; i_7_ < 5; i_7_++) {
                configActions[i_7_] = buffer.getString();
                if(configActions[i_7_].length() == 0) {
                    configActions[i_7_] = null;
                }
            }
        }
        if(type == GameInterfaceType.RECTANGLE) {
            filled = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT || type == GameInterfaceType.UNKNOWN) {
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            lineHeight = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT) {
            disabledText = buffer.getString();
            alternateText = buffer.getString();
        }
        if(type == GameInterfaceType.UNKNOWN || type == GameInterfaceType.RECTANGLE || type == GameInterfaceType.TEXT) {
            textColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.RECTANGLE || type == GameInterfaceType.TEXT) {
            alternateTextColor = buffer.getIntBE();
            hoveredTextColor = buffer.getIntBE();
            alternateHoveredTextColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.GRAPHIC) {
            spriteId = buffer.getIntBE();
            alternateSpriteId = buffer.getIntBE();
        }
        if(type == GameInterfaceType.MODEL) {
            modelType = InterfaceModelType.MODEL;
            modelId = buffer.getUnsignedShortBE();
            if(modelId == 0xFFFF) {
                modelId = -1;
            }
            alternateModelType = InterfaceModelType.MODEL;
            alternateModelId = buffer.getUnsignedShortBE();
            if(alternateModelId == 0xFFFF) {
                alternateModelId = -1;
            }
            animation = buffer.getUnsignedShortBE();
            if(animation == 0xFFFF) {
                animation = -1;
            }
            alternateAnimation = buffer.getUnsignedShortBE();
            if(alternateAnimation == 0xFFFF) {
                alternateAnimation = -1;
            }
            modelZoom = buffer.getUnsignedShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
        }
        if(type == GameInterfaceType.TEXT_INVENTORY) {
            items = new int[originalWidth * originalHeight];
            itemAmounts = new int[originalWidth * originalHeight];
            xTextAlignment = buffer.getUnsignedByte();
            fontId = buffer.getUnsignedShortBE();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
            itemSpritePadsX = buffer.getShortBE();
            itemSpritePadsY = buffer.getShortBE();
            isInventory = buffer.getUnsignedByte() == 1;
            configActions = new String[5];
            for(int i_8_ = 0; i_8_ < 5; i_8_++) {
                configActions[i_8_] = buffer.getString();
                if(configActions[i_8_].length() == 0) {
                    configActions[i_8_] = null;
                }
            }
        }
        if(type == GameInterfaceType.IF1_TOOLTIP) {
            disabledText = buffer.getString();
        }
        if(actionType == 2 || type == GameInterfaceType.INVENTORY) {
            targetVerb = buffer.getString();
            spellName = buffer.getString();
            clickMask = buffer.getUnsignedShortBE();
        }
        if(actionType == 1 || actionType == 4 || actionType == 5 || actionType == 6) {
            tooltip = buffer.getString();
            if(tooltip.length() == 0) {
                if(actionType == 1) {
                    tooltip = English.ok;
                }
                if(actionType == 4) {
                    tooltip = English.select;
                }
                if(actionType == 5) {
                    tooltip = English.select;
                }
                if(actionType == 6) {
                    tooltip = English.sContinue;
                }
            }
        }
    }

    public ImageRGB method638(int arg1) {
        aBoolean2177 = false;
        if(arg1 < 0 || imageY.length <= arg1) {
            return null;
        }
        int i = imageY[arg1];
        if(i == -1) {
            return null;
        }
        ImageRGB class40_sub5_sub14_sub4 = (ImageRGB) interfaceItemImageCache.get((long) i);
        if(class40_sub5_sub14_sub4 != null) {
            return class40_sub5_sub14_sub4;
        }
        class40_sub5_sub14_sub4 = MovedStatics.method927(0, CacheArchive.gameImageCacheArchive, i);
        if(class40_sub5_sub14_sub4 == null) {
            aBoolean2177 = true;
        } else {
            interfaceItemImageCache.put((long) i, class40_sub5_sub14_sub4);
        }
        return class40_sub5_sub14_sub4;
    }

    public ImageRGB getImageRgb(boolean useAlternateImage) {
        aBoolean2177 = false;

        int i;
        if(useAlternateImage) {
            i = alternateSpriteId;
        } else {
            i = spriteId;
        }
        if(Configuration.FREE_TELEPORTS) {
            switch(id) {
                case 12582924:
                case 12582927:
                case 12582930:
                case 12583493:
                case 12582934:
                case 12583300:
                case 12583301:
                case 12583404:
                case 12583481:
                    i = alternateSpriteId;
                    break;
                default:
                    break;
            }
        }
        if(i == -1) {
            return null;
        }
        ImageRGB imageRGB = (ImageRGB) interfaceItemImageCache.get((long) i);

        if(imageRGB != null) {
            return imageRGB;
        }
        imageRGB = MovedStatics.method927(0, CacheArchive.gameImageCacheArchive, i);
        if(imageRGB == null) {
            aBoolean2177 = true;
        } else {
            interfaceItemImageCache.put((long) i, imageRGB);
        }
        return imageRGB;
    }

    public void decodeIf3(Buffer buffer) {
        buffer.getUnsignedByte();
        isNewInterfaceFormat = true;
        type = GameInterfaceType.get(buffer.getUnsignedByte());
        contentType = buffer.getUnsignedShortBE();
        originalX = currentX = buffer.getShortBE();
        originalY = currentY = buffer.getShortBE();
        originalWidth = buffer.getUnsignedShortBE();
        if(type == GameInterfaceType.LINE) {
            originalHeight = buffer.getShortBE();
        } else {
            originalHeight = buffer.getUnsignedShortBE();
        }
        parentId = buffer.getUnsignedShortBE();
        if(parentId == 0xFFFF) {
            parentId = -1;
        }
        isHidden = buffer.getUnsignedByte() == 1;
        hasListeners = buffer.getUnsignedByte() == 1;
        if(type == GameInterfaceType.LAYER) {
            scrollWidth = buffer.getUnsignedShortBE();
            scrollPosition = buffer.getUnsignedShortBE();
        }
        if(type == GameInterfaceType.GRAPHIC) {
            spriteId = buffer.getIntBE();
            textureId = buffer.getUnsignedShortBE();
            tiled = buffer.getUnsignedByte() == 1;
            opacity = buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.MODEL) {
            modelType = InterfaceModelType.MODEL;
            modelId = buffer.getUnsignedShortBE();
            if(modelId == 65535) {
                modelId = -1;
            }
            offsetX2d = buffer.getShortBE();
            offsetY2d = buffer.getShortBE();
            rotationX = buffer.getUnsignedShortBE();
            rotationZ = buffer.getUnsignedShortBE();
            rotationY = buffer.getUnsignedShortBE();
            modelZoom = buffer.getUnsignedShortBE();
            animation = buffer.getUnsignedShortBE();
            if(animation == 65535) {
                animation = -1;
            }
            orthogonal = buffer.getUnsignedByte() == 1;
        }
        if(type == GameInterfaceType.TEXT) {
            fontId = buffer.getUnsignedShortBE();
            disabledText = buffer.getString();
            lineHeight = buffer.getUnsignedByte();
            xTextAlignment = buffer.getUnsignedByte();
            yTextAlignment = buffer.getUnsignedByte();
            textShadowed = buffer.getUnsignedByte() == 1;
            textColor = buffer.getIntBE();
        }
        if(type == GameInterfaceType.RECTANGLE) {
            textColor = buffer.getIntBE();
            filled = buffer.getUnsignedByte() == 1;
            opacity = buffer.getUnsignedByte();
        }
        if(type == GameInterfaceType.LINE) {
            buffer.getUnsignedByte();
            textColor = buffer.getIntBE();
        }
        if(hasListeners) {
            // various interface action listeners (click, mouse move, onload, etc)
            onLoadListeners = decodeListener(buffer);
            anObjectArray2681 = decodeListener(buffer);
            anObjectArray2644 = decodeListener(buffer);
            anObjectArray2707 = decodeListener(buffer);
            anObjectArray2658 = decodeListener(buffer);
            anObjectArray2672 = decodeListener(buffer);
            anObjectArray2669 = decodeListener(buffer);
            decodeListener(buffer);
            anObjectArray2650 = decodeListener(buffer);
            anObjectArray2712 = decodeListener(buffer);
            decodeListener(buffer);
            anObjectArray2695 = decodeListener(buffer);
            anObjectArray2747 = decodeListener(buffer);
            anObjectArray2680 = decodeListener(buffer);
            isInventory = buffer.getUnsignedByte() == 1;
            anInt2736 = buffer.getUnsignedShortBE();
            lockScroll = buffer.getUnsignedByte() == 1;
            buffer.getUnsignedByte();
            int i = buffer.getUnsignedByte();
            if(i > 0) {
                aClass1Array2661 = new String[i];
                for(int i_10_ = 0; i_10_ < i; i_10_++) {
                    aClass1Array2661[i_10_] = buffer.getString();
                }
            }
            anInt2738 = buffer.getUnsignedShortBE();
            if(anInt2738 == 65535) {
                anInt2738 = -1;
            }
        }
    }

    public Model getModelForInterface(AnimationSequence animationSequence, int animationFrame, boolean applyAlternateAction, PlayerAppearance playerAppearance) {
        aBoolean2177 = false;
        InterfaceModelType modelType;
        int modelId;
        if(applyAlternateAction) {
            modelId = alternateModelId;
            modelType = alternateModelType;
        } else {
            modelType = this.modelType;
            modelId = this.modelId;
        }
        if(modelType == InterfaceModelType.NULL) {
            return null;
        }
        if(modelType == InterfaceModelType.MODEL && modelId == -1) {
            return null;
        }

        Model model = (Model) interfaceModelCache.get((long) ((modelType.ordinal() << 16) + modelId));
        if(model == null) {
            if(modelType == InterfaceModelType.MODEL) {
                model = Model.getModel(CacheArchive.modelCacheArchive, modelId);
                if(model == null) {
                    aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.NPC_CHATHEAD) {
                model = ActorDefinition.getDefinition(modelId).getHeadModel();
                if(model == null) {
                    aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.LOCAL_PLAYER_CHATHEAD) {
                if(playerAppearance == null) {
                    return null;
                }
                model = playerAppearance.getStaticModel();
                if(model == null) {
                    aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.ITEM) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(modelId, 10);
                model = class40_sub5_sub16.asGroundStack(false, 10);
                if(model == null) {
                    aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                // TODO: Theres a bug with smelting bars and stacked items in inventory, please figure this out
                try {
                    model.applyLighting(64 + class40_sub5_sub16.ambient, 768 + class40_sub5_sub16.contrast, -50, -10, -50, true);
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
            interfaceModelCache.put((long) ((modelType.ordinal() << 16) + modelId), model);
        }
        if(animationSequence != null) {
            model = animationSequence.method598(animationFrame, model);
        }
        return model;
    }

    public TypeFace getTypeFace() {
        aBoolean2177 = false;
        if(fontId == 65535) {
            return null;
        }
        TypeFace typeFace = (TypeFace) interfaceTypefaceCache.get(fontId);

        if(typeFace != null) {
            return typeFace;
        }

        typeFace = TypeFace.getFont(CacheArchive.gameImageCacheArchive, 0, fontId);

        if(typeFace == null) {
            aBoolean2177 = true;
        } else {
            interfaceTypefaceCache.put(fontId, typeFace);
        }

        return typeFace;
    }
}
