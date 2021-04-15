package com.jagex.runescape.cache.media.gameInterface;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Pathfinding;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.TextUtils;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

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
    public int anInt2722;
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
        anInt2722 = 0;
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

    public static void method639(int arg0) {
        synchronized(Class59.keyFocusListener) {
            Class59.anInt1389 = GenericTile.anInt1214;
            if(GameObjectDefinition.anInt2543 < 0) {
                for(int i = 0; i < 112; i++) {
                    Item.obfuscatedKeyStatus[i] = false;
                }
                GameObjectDefinition.anInt2543 = FramemapDefinition.anInt2183;
            } else {
                while(GameObjectDefinition.anInt2543 != FramemapDefinition.anInt2183) {
                    int i = RSString.keyCodes[FramemapDefinition.anInt2183];
                    FramemapDefinition.anInt2183 = 0x7f & FramemapDefinition.anInt2183 + 1;
                    if(i < 0) {
                        Item.obfuscatedKeyStatus[i ^ 0xffffffff] = false;
                    } else {
                        Item.obfuscatedKeyStatus[i] = true;
                    }
                }
            }
            GenericTile.anInt1214 = IdentityKit.anInt2598;
        }
        if(arg0 <= 121) {
            English.startingGameEngine = null;
        }
    }

    public static void method640() {
        ProducingGraphicsBuffer.aClass9_1615.clear();
    }


    public static void method642(Component arg0, int arg1) {
        if(arg1 != -10) {
            method639(-106);
        }
        Method method = Signlink.aMethod729;
        if(method != null) {
            try {
                method.invoke(arg0, Boolean.FALSE);
            } catch(Throwable throwable) {
                /* empty */
            }
        }
        arg0.addKeyListener(Class59.keyFocusListener);
        arg0.addFocusListener(Class59.keyFocusListener);
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
                int i_4_ = Class42.anInt1008;
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
            gameInterface.scrollHeight = 15 * Class42.anInt1008 + 20;
            if(gameInterface.scrollHeight <= gameInterface.originalHeight)
                gameInterface.scrollHeight = gameInterface.originalHeight + 1;
        } else if(type == 324) {
            if(Class64.anInt1511 == -1) {
                Class64.anInt1511 = gameInterface.spriteId;
                Main.anInt1769 = gameInterface.alternateSpriteId;
            }
            if(!Player.activePlayerAppearance.gender)
                gameInterface.spriteId = Main.anInt1769;
            else
                gameInterface.spriteId = Class64.anInt1511;
        } else if(type == 325) {
            if(Class64.anInt1511 == -1) {
                Main.anInt1769 = gameInterface.alternateSpriteId;
                Class64.anInt1511 = gameInterface.spriteId;
            }
            if(Player.activePlayerAppearance.gender)
                gameInterface.spriteId = Main.anInt1769;
            else
                gameInterface.spriteId = Class64.anInt1511;
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
            if(InteractiveObject.playerRights >= 1) {
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

    public static void drawScrollBar(int x, int y, int height, int scrollPosition, int scrollMaximum, int unknownArrayIndex) {
        int length = (-32 + height) * height / scrollMaximum;
        MovedStatics.aClass40_Sub5_Sub14_Sub2Array215[unknownArrayIndex].drawImage(x, y);
        MovedStatics.aClass40_Sub5_Sub14_Sub2Array215[1].drawImage(x, y - (-height + 16));
        Rasterizer.drawFilledRectangle(x, y + 16, 16, height + -32, Class55.anInt1299);
        if(length < 8)
            length = 8;
        int scrollCurrent = (-32 + height - length) * scrollPosition / (-height + scrollMaximum);
        Rasterizer.drawFilledRectangle(x, 16 + y + scrollCurrent, 16, length, MovedStatics.anInt321);
        Rasterizer.drawVerticalLine(x, 16 + y + scrollCurrent, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(1 + x, scrollCurrent + y + 16, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, scrollCurrent + y + 16, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, 17 + y + scrollCurrent, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(x + 15, y + 16 + scrollCurrent, length, MovedStatics.anInt1318);
        Rasterizer.drawVerticalLine(x + 14, scrollCurrent + 17 + y, length - 1, MovedStatics.anInt1318);
        Rasterizer.drawHorizontalLine(x, length + scrollCurrent + 15 + y, 16, MovedStatics.anInt1318);
        Rasterizer.drawHorizontalLine(x + 1, 14 + y + scrollCurrent + length, 15, MovedStatics.anInt1318);
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

    public static boolean isActionWhitelisted(int action) {
        List<Integer> whitelistedActionsDuringAnimation = new ArrayList();

        // TODO add more actions that should work during a cutscene
        whitelistedActionsDuringAnimation.add(54); // Click here to continue
        whitelistedActionsDuringAnimation.add(1005); // Cancel

        return whitelistedActionsDuringAnimation.contains(action);
    }

    public static void processMenuActions(int arg0, int arg1) {
        if(arg1 >= 0) {
            int i = InteractiveObject.firstMenuOperand[arg1];
            int i_10_ = Class59.secondMenuOperand[arg1];
            int action = MovedStatics.menuActionTypes[arg1];
            if(action >= 2000) {
                action -= 2000;
            }

            if (Player.cutsceneActive && !GameInterface.isActionWhitelisted(action)) {
                return;
            }

            int i_12_ = Class33.selectedMenuActions[arg1];
            if(ChatBox.inputType != 0 && action != 1005) {
                ChatBox.inputType = 0;
                ChatBox.redrawChatbox = true;
            }
            if(action == 37) {
                SceneCluster.packetBuffer.putPacket(21);
                SceneCluster.packetBuffer.putIntLE(Class60.anInt1417);
                SceneCluster.packetBuffer.putIntME2(i_10_);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortBE(i);
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                GenericTile.anInt1233 = i;
                RSRuntimeException.anInt1651 = 0;
                if(gameScreenInterfaceId == i_10_ >> 16) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                }
                PlayerAppearance.anInt704 = i_10_;
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
            }
            if(action == 38) {
                boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                if(!bool) {
                    bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                }
                OverlayDefinition.crossIndex = 0;
                MovedStatics.crossY = RSString.clickY;
                ClientScriptRunner.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                SceneCluster.packetBuffer.putPacket(190);
                SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
            }
            if(action == 1004) {
                MovedStatics.crossY = RSString.clickY;
                ClientScriptRunner.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                OverlayDefinition.crossIndex = 0;
                SceneCluster.packetBuffer.putPacket(148);
                SceneCluster.packetBuffer.putShortLE(i_12_ >> 14 & 0x7fff);
            }
            if(action == 27) {
                AnimationSequence.method596(i, i_12_, (byte) -79, i_10_);
                SceneCluster.packetBuffer.putPacket(229);
                SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                SceneCluster.packetBuffer.putShortLE((0x1ffffd20 & i_12_) >> 14);
                SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
            }
            if(action == 1) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    ClientScriptRunner.crossX = Class57.clickX;
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    SceneCluster.packetBuffer.putPacket(221);
                    SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
            }
            if(action == 26 || action == 46) {
                String name = Landscape.menuActionTexts[arg1];
                int i_13_ = name.indexOf(Native.white);
                if(i_13_ != -1) {
                    name = name.substring(i_13_ + 5).trim();
                    String username = TextUtils.formatName(TextUtils.longToName(TextUtils.nameToLong(name)));
                    boolean bool = false;
                    for(int i_15_ = 0; i_15_ < Player.localPlayerCount; i_15_++) {
                        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[Player.trackedPlayerIndices[i_15_]];
                        if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.playerName != null && class40_sub5_sub17_sub4_sub1.playerName.equalsIgnoreCase(username)) {
                            bool = true;
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                            if(action == 26) {
                                SceneCluster.packetBuffer.putPacket(96);
                                SceneCluster.packetBuffer.putShortBE(Player.trackedPlayerIndices[i_15_]);
                            }
                            if(action == 46) {
                                SceneCluster.packetBuffer.putPacket(68);
                                SceneCluster.packetBuffer.putShortLE(Player.trackedPlayerIndices[i_15_]);
                            }
                            break;
                        }
                    }
                    if(!bool) {
                        ChatBox.addChatMessage("", English.unableToFind + username, 0);
                    }
                }
            }
            if(action == 55) {
                SceneCluster.packetBuffer.putPacket(26);
                SceneCluster.packetBuffer.putShortBE(i);
                SceneCluster.packetBuffer.putIntLE(i_10_);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                PlayerAppearance.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                GenericTile.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
            }
            if(action == 53) {
                SceneCluster.packetBuffer.putPacket(38);
                SceneCluster.packetBuffer.putShortBE(i_12_);
                SceneCluster.packetBuffer.putShortLE(i);
                SceneCluster.packetBuffer.putIntME1(i_10_);
                GenericTile.anInt1233 = i;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                RSRuntimeException.anInt1651 = 0;
                PlayerAppearance.anInt704 = i_10_;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
            }
            if(action == 57) {
                System.out.println("action 57");
                SceneCluster.packetBuffer.putPacket(64);
                SceneCluster.packetBuffer.putIntBE(i_10_);
                GameInterface gameInterface = getInterface(i_10_);
                if(gameInterface.clientScripts != null && gameInterface.clientScripts[0][0] == 5) {
                    int i_16_ = gameInterface.clientScripts[0][1];
                    if(gameInterface.alternateRhs[0] != GroundItemTile.varbitMasks[i_16_]) {
                        GroundItemTile.varbitMasks[i_16_] = gameInterface.alternateRhs[0];
                        Class22.method309(-1, i_16_);
                        redrawTabArea = true;
                    }
                }
            }
            if(action == 52) {
                SceneCluster.packetBuffer.putPacket(240);
                SceneCluster.packetBuffer.putShortLE(i);
                SceneCluster.packetBuffer.putShortLE(i_12_);
                SceneCluster.packetBuffer.putIntME2(i_10_);
                GenericTile.anInt1233 = i;
                PlayerAppearance.anInt704 = i_10_;
                RSRuntimeException.anInt1651 = 0;
                Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                if(i_10_ >> 16 == gameScreenInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                }
                if(i_10_ >> 16 == chatboxInterfaceId) {
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                }
            }
            if(action == 10) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    ClientScriptRunner.crossX = Class57.clickX;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    OverlayDefinition.crossIndex = 0;
                    SceneCluster.packetBuffer.putPacket(68);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
            }
            if(action == 14) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    ClientScriptRunner.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(96);
                    SceneCluster.packetBuffer.putShortBE(i_12_);
                }
            }
            if(action == 1001) {
                ClientScriptRunner.crossX = Class57.clickX;
                LinkedList.crossType = 2;
                MovedStatics.crossY = RSString.clickY;
                OverlayDefinition.crossIndex = 0;
                Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                if(class40_sub5_sub17_sub4_sub2 != null) {
                    ActorDefinition class40_sub5_sub5 = class40_sub5_sub17_sub4_sub2.actorDefinition;
                    if(class40_sub5_sub5.childrenIds != null) {
                        class40_sub5_sub5 = class40_sub5_sub5.getChildDefinition(-1);
                    }
                    if(class40_sub5_sub5 != null) {
                        SceneCluster.packetBuffer.putPacket(247);
                        SceneCluster.packetBuffer.putShortLE(class40_sub5_sub5.id);
                    }
                }
            }
            if(action == 22) {
                Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                if(class40_sub5_sub17_sub4_sub1 != null) {
                    Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                    ClientScriptRunner.crossX = Class57.clickX;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    OverlayDefinition.crossIndex = 0;
                    SceneCluster.packetBuffer.putPacket(110);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putIntME1(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                }
            }
            if(action == 19) {
                Class49.anInt1154 = i_12_;
                LinkedList.anInt1061 = i;
                ISAAC.anInt525 = i_10_;
                Class8.itemSelected = 1;
                Native.aClass1_3295 = Native.lightRed + ItemDefinition.forId(i_12_, 10).name + Native.white;
                Main.widgetSelected = 0;
                if(Native.aClass1_3295 == null) {
                    Native.aClass1_3295 = "null";
                }
                redrawTabArea = true;
            } else {
                if(action == 15) {
                    boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                    if(!bool) {
                        bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                    }
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    ClientScriptRunner.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(168);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putShortBE(SpotAnimDefinition.baseX + i);
                    SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                    SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                }
                if(action == 23) {
                    SceneCluster.packetBuffer.putPacket(64);
                    SceneCluster.packetBuffer.putIntBE(i_10_);

                    GameInterface gameInterface = getInterface(i_10_);
                    if(gameInterface.clientScripts != null && gameInterface.clientScripts[0][0] == 5) {
                        int i_17_ = gameInterface.clientScripts[0][1];
                        GroundItemTile.varbitMasks[i_17_] = -GroundItemTile.varbitMasks[i_17_] + 1;
                        Class22.method309(-1, i_17_);
                        redrawTabArea = true;
                    }
                }
                if(action == 48) {
                    SceneCluster.packetBuffer.putPacket(147);
                    SceneCluster.packetBuffer.putShortBE(i_12_);
                    SceneCluster.packetBuffer.putShortLE(i);
                    SceneCluster.packetBuffer.putIntLE(i_10_);
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    GenericTile.anInt1233 = i;
                    PlayerAppearance.anInt704 = i_10_;
                    if(gameScreenInterfaceId == i_10_ >> 16) {
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    }
                    if(chatboxInterfaceId == i_10_ >> 16) {
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                    RSRuntimeException.anInt1651 = 0;
                }
                if(action == 18) {
                    String class1 = Landscape.menuActionTexts[arg1];
                    int i_18_ = class1.indexOf(Native.white);
                    if(i_18_ != -1) {
                        long l = TextUtils.nameToLong(class1.substring(i_18_ + 5).trim());
                        int i_19_ = -1;
                        for(int i_20_ = 0; i_20_ < Player.friendsCount; i_20_++) {
                            if(Class59.friends[i_20_] == l) {
                                i_19_ = i_20_;
                                break;
                            }
                        }
                        if(i_19_ != -1 && Player.friendWorlds[i_19_] > 0) {
                            Class37.anInt876 = 3;
                            ChatBox.redrawChatbox = true;
                            ChatBox.inputType = 0;
                            ChatBox.chatMessage = "";
                            ChatBox.messagePromptRaised = true;
                            PacketBuffer.aLong2241 = Class59.friends[i_19_];
                            Native.aClass1_1563 = English.prefixEnterMessageToSendTo + Player.friendUsernames[i_19_];
                        }
                    }
                }
                if(action == 1003) {
                    OverlayDefinition.crossIndex = 0;
                    LinkedList.crossType = 2;
                    MovedStatics.crossY = RSString.clickY;
                    ClientScriptRunner.crossX = Class57.clickX;
                    SceneCluster.packetBuffer.putPacket(151);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                }
                if(action == 1002) {
                    AnimationSequence.method596(i, i_12_, (byte) -11, i_10_);
                    SceneCluster.packetBuffer.putPacket(62);
                    SceneCluster.packetBuffer.putShortBE((0x1fffd05d & i_12_) >> 14);
                    SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                    SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                }
                if(action == 30) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        OverlayDefinition.crossIndex = 0;
                        ClientScriptRunner.crossX = Class57.clickX;
                        MovedStatics.crossY = RSString.clickY;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(57);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                }
                if(action == 49) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        ClientScriptRunner.crossX = Class57.clickX;
                        MovedStatics.crossY = RSString.clickY;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(208);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                        SceneCluster.packetBuffer.putShortLE(LinkedList.anInt1061);
                        SceneCluster.packetBuffer.putIntBE(ISAAC.anInt525);
                    }
                }
                if(action == 29) {
                    AnimationSequence.method596(i, i_12_, (byte) -77, i_10_);
                    SceneCluster.packetBuffer.putPacket(164);
                    SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                    SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
                    SceneCluster.packetBuffer.putShortLE(i_12_ >> 14 & 0x7fff);
                }
                if(action == 5 && AnimationSequence.method596(i, i_12_, (byte) -104, i_10_)) {
                    SceneCluster.packetBuffer.putPacket(24);
                    SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                    SceneCluster.packetBuffer.putShortBE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortLE((i_12_ & 0x1fffccf7) >> 14);
                    SceneCluster.packetBuffer.putShortLE(LinkedList.anInt1061);
                    SceneCluster.packetBuffer.putIntME1(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                }
                if(action == 34) {
                    Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        ClientScriptRunner.crossX = Class57.clickX;
                        MovedStatics.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(0);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                }
                if(action == 56) {
                    SceneCluster.packetBuffer.putPacket(40);
                    SceneCluster.packetBuffer.putShortLE(i_12_);
                    SceneCluster.packetBuffer.putShortLE(i);
                    SceneCluster.packetBuffer.putIntLE(i_10_);
                    SceneCluster.packetBuffer.putIntLE(ISAAC.anInt525);
                    SceneCluster.packetBuffer.putShortLE(Class49.anInt1154);
                    SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                    PlayerAppearance.anInt704 = i_10_;
                    RSRuntimeException.anInt1651 = 0;
                    GenericTile.anInt1233 = i;
                    Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                    if(gameScreenInterfaceId == i_10_ >> 16) {
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                    }
                    if(chatboxInterfaceId == i_10_ >> 16) {
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                    }
                }
                if(action == 33) {
                    GameInterface gameInterface = getInterface(i_10_);
                    redrawTabArea = true;
                    Main.widgetSelected = 1;
                    Native.aClass1_1918 = gameInterface.targetVerb;
                    ItemDefinition.selectedMask = gameInterface.clickMask;
                    Class8.itemSelected = 0;
                    Class60.anInt1417 = i_10_;
                    Native.aClass1_611 = Native.green + gameInterface.spellName + Native.white;
                    if(ItemDefinition.selectedMask == 16) {
                        drawTabIcons = true;
                        Player.currentTabId = 3;
                        redrawTabArea = true;
                    }
                } else {
                    if(action == 1007) {
                        GameInterface gameInterface = getInterface(i_10_);
                        if(gameInterface != null && gameInterface.children != null && i != -1) {
                            gameInterface = gameInterface.children[i];
                        }
                        if(gameInterface == null || gameInterface.itemAmount < 100000) {
                            SceneCluster.packetBuffer.putPacket(151);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        } else {
                            ChatBox.addChatMessage("", gameInterface.itemAmount + Native.aClass1_1536 + ItemDefinition.forId(i_12_, 10).name, 0);
                        }
                    }
                    if(action == 42) {
                        GameInterface gameInterface = getInterface(i_10_);
                        boolean bool = true;
                        if(gameInterface.contentType > 0) {
                            bool = method166((byte) 88, gameInterface);
                        }
                        if(bool) {
                            SceneCluster.packetBuffer.putPacket(64);
                            SceneCluster.packetBuffer.putIntBE(i_10_);
                        }
                    }
                    if(action == 31) {
                        SceneCluster.packetBuffer.putPacket(163);
                        SceneCluster.packetBuffer.putShortLE(i);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        SceneCluster.packetBuffer.putIntBE(i_10_);
                        GenericTile.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        PlayerAppearance.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == 12) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                            ClientScriptRunner.crossX = Class57.clickX;
                            MovedStatics.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            LinkedList.crossType = 2;
                            SceneCluster.packetBuffer.putPacket(63);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 2) {
                        boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                        if(!bool) {
                            bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                        }
                        LinkedList.crossType = 2;
                        OverlayDefinition.crossIndex = 0;
                        ClientScriptRunner.crossX = Class57.clickX;
                        MovedStatics.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(244);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                    }
                    if(action == 3) {
                        boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                        if(!bool) {
                            bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                        }
                        OverlayDefinition.crossIndex = 0;
                        ClientScriptRunner.crossX = Class57.clickX;
                        LinkedList.crossType = 2;
                        MovedStatics.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(85);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 21) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                            ClientScriptRunner.crossX = Class57.clickX;
                            MovedStatics.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            LinkedList.crossType = 2;
                            SceneCluster.packetBuffer.putPacket(253);
                            SceneCluster.packetBuffer.putShortBE(i_12_);
                            SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                        }
                    }
                    if(action == 45 || action == 51 || action == 13 || action == 35) {
                        String s = Landscape.menuActionTexts[arg1];
                        int l1 = s.indexOf(Native.white);
                        if(l1 != -1) {
                            long l = TextUtils.nameToLong(s.substring(l1 + 5).trim());
                            if(action == 45) {
                                UnderlayDefinition.addFriend(l);
                            }
                            if(action == 51) {
                                Class17.method275(l);
                            }
                            if(action == 13) {
                                GameShell.method28(l);
                            }
                            if(action == 35) {
                                MovedStatics.method838(0, l);
                            }
                        }
                    }
                    if(action == 44) {
                        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                            LinkedList.crossType = 2;
                            OverlayDefinition.crossIndex = 0;
                            ClientScriptRunner.crossX = Class57.clickX;
                            MovedStatics.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(220);
                            SceneCluster.packetBuffer.putShortBE(i_12_);
                        }
                    }
                    if(arg0 < 51) {
                        MovedStatics.mapDots = null;
                    }
                    if(action == 7) {
                        if(MovedStatics.menuOpen) {
                            Npc.currentScene.method120(-4 + i, -4 + i_10_);
                        } else {
                            Npc.currentScene.method120(Class57.clickX - 4, -4 + RSString.clickY);
                        }
                    }
                    if(action == 1006) {
                        GameInterface gameInterface = getInterface(i_10_);
                        if(gameInterface == null || gameInterface.itemAmounts[i] < 100000) {
                            SceneCluster.packetBuffer.putPacket(151);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        } else {
                            ChatBox.addChatMessage("", gameInterface.itemAmounts[i] + Native.aClass1_1536 + ItemDefinition.forId(i_12_, 10).name, 0);
                        }
                        GenericTile.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        PlayerAppearance.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(i_10_ >> 16 == gameScreenInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == 17) {
                        AnimationSequence.method596(i, i_12_, (byte) -104, i_10_);
                        SceneCluster.packetBuffer.putPacket(183);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        SceneCluster.packetBuffer.putShortBE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 50) {
                        Class33.method406(i, i_12_, i_10_, -121);
                    }
                    if(action == 40) {
                        resetInterface(ChatBox.dialogueId);
                        ChatBox.dialogueId = -1;
                        ChatBox.redrawChatbox = true;
                    }
                    if(action == 32 && AnimationSequence.method596(i, i_12_, (byte) -27, i_10_)) {
                        SceneCluster.packetBuffer.putPacket(225);
                        SceneCluster.packetBuffer.putShortBE(i_12_ >> 14 & 0x7fff);
                        SceneCluster.packetBuffer.putShortLE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putIntME1(Class60.anInt1417);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 25) {
                        SceneCluster.packetBuffer.putPacket(228);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortLE(i);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                        PlayerAppearance.anInt704 = i_10_;
                        GenericTile.anInt1233 = i;
                    }
                    if(action == 11) {
                        SceneCluster.packetBuffer.putPacket(29);
                        SceneCluster.packetBuffer.putIntME1(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putShortLE(i_12_);
                        GenericTile.anInt1233 = i;
                        PlayerAppearance.anInt704 = i_10_;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                        RSRuntimeException.anInt1651 = 0;
                    }
                    if(action == 41) {
                        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                            LinkedList.crossType = 2;
                            MovedStatics.crossY = RSString.clickY;
                            ClientScriptRunner.crossX = Class57.clickX;
                            OverlayDefinition.crossIndex = 0;
                            SceneCluster.packetBuffer.putPacket(187);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 28) {
                        String class1 = Landscape.menuActionTexts[arg1];
                        int i_22_ = class1.indexOf(Native.white);
                        if(i_22_ != -1) {
                            if(gameScreenInterfaceId == -1) {
                                PacketBuffer.closeAllWidgets();
                                if(MovedStatics.anInt854 != -1) {
                                    Native.reportedName = class1.substring(i_22_ + 5).trim();
                                    HuffmanEncoding.reportAbuseInterfaceID = gameScreenInterfaceId = MovedStatics.anInt854;
                                    MovedStatics.reportMutePlayer = false;
                                }
                            } else {
                                ChatBox.addChatMessage("", English.pleaseCloseInterfaceBeforeReportAbuse, 0);
                            }
                        }
                    }
                    if(action == 8) {
                        boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                        if(!bool) {
                            bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                        }
                        ClientScriptRunner.crossX = Class57.clickX;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        MovedStatics.crossY = RSString.clickY;
                        SceneCluster.packetBuffer.putPacket(65);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                        SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + i);
                    }
                    if(action == 9) {
                        PacketBuffer.closeAllWidgets();
                    }
                    if(action == 54 && MovedStatics.lastContinueTextWidgetId == -1) { // Click to continue
                        PacketBuffer.method517(0, i_10_);
                        MovedStatics.lastContinueTextWidgetId = i_10_;
                    }
                    if(action == 43) {
                        SceneCluster.packetBuffer.putPacket(98);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putIntME1(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        GenericTile.anInt1233 = i;
                        PlayerAppearance.anInt704 = i_10_;
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == 36) {
                        boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                        if(!bool) {
                            bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                        }
                        MovedStatics.crossY = RSString.clickY;
                        LinkedList.crossType = 2;
                        OverlayDefinition.crossIndex = 0;
                        ClientScriptRunner.crossX = Class57.clickX;
                        SceneCluster.packetBuffer.putPacket(27);
                        SceneCluster.packetBuffer.putShortBE(SpotAnimDefinition.baseX + i);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putShortBE(i_10_ + Class26.baseY);
                    }
                    if(action == 39) {
                        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_12_];
                        if(class40_sub5_sub17_sub4_sub1 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub1.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub1.pathX[0], 2);
                            OverlayDefinition.crossIndex = 0;
                            ClientScriptRunner.crossX = Class57.clickX;
                            LinkedList.crossType = 2;
                            MovedStatics.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(211);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 24) {
                        SceneCluster.packetBuffer.putPacket(124);
                        SceneCluster.packetBuffer.putShortBE(i);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        PlayerAppearance.anInt704 = i_10_;
                        RSRuntimeException.anInt1651 = 0;
                        GenericTile.anInt1233 = i;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        if(gameScreenInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(chatboxInterfaceId == i_10_ >> 16) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == 16) {
                        AnimationSequence.method596(i, i_12_, (byte) -47, i_10_);
                        SceneCluster.packetBuffer.putPacket(30);
                        SceneCluster.packetBuffer.putShortBE(0x7fff & i_12_ >> 14);
                        SceneCluster.packetBuffer.putShortBE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortLE(i + SpotAnimDefinition.baseX);
                    }
                    if(action == 20) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                            LinkedList.crossType = 2;
                            ClientScriptRunner.crossX = Class57.clickX;
                            MovedStatics.crossY = RSString.clickY;
                            OverlayDefinition.crossIndex = 0;
                            SceneCluster.packetBuffer.putPacket(153);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(action == 47) {
                        boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 0, Player.localPlayer.pathX[0], i_10_, 2);
                        if(!bool) {
                            bool = Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], i, 0, false, 0, 1, Player.localPlayer.pathX[0], i_10_, 2);
                        }
                        ClientScriptRunner.crossX = Class57.clickX;
                        MovedStatics.crossY = RSString.clickY;
                        OverlayDefinition.crossIndex = 0;
                        LinkedList.crossType = 2;
                        SceneCluster.packetBuffer.putPacket(172);
                        SceneCluster.packetBuffer.putShortBE(i + SpotAnimDefinition.baseX);
                        SceneCluster.packetBuffer.putShortBE(LinkedList.anInt1061);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        SceneCluster.packetBuffer.putIntME2(ISAAC.anInt525);
                        SceneCluster.packetBuffer.putShortLE(Class26.baseY + i_10_);
                        SceneCluster.packetBuffer.putShortLE(Class49.anInt1154);
                    }
                    if(action == 6) {
                        SceneCluster.packetBuffer.putPacket(102);
                        SceneCluster.packetBuffer.putIntLE(i_10_);
                        SceneCluster.packetBuffer.putShortLE(i);
                        SceneCluster.packetBuffer.putShortBE(i_12_);
                        GenericTile.anInt1233 = i;
                        RSRuntimeException.anInt1651 = 0;
                        Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 2;
                        PlayerAppearance.anInt704 = i_10_;
                        if(i_10_ >> 16 == gameScreenInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 1;
                        }
                        if(i_10_ >> 16 == chatboxInterfaceId) {
                            Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType = 3;
                        }
                    }
                    if(action == 4) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_12_];
                        if(class40_sub5_sub17_sub4_sub2 != null) {
                            Pathfinding.doWalkTo(1, 0, Player.localPlayer.pathY[0], class40_sub5_sub17_sub4_sub2.pathY[0], 0, false, 0, 1, Player.localPlayer.pathX[0], class40_sub5_sub17_sub4_sub2.pathX[0], 2);
                            LinkedList.crossType = 2;
                            ClientScriptRunner.crossX = Class57.clickX;
                            OverlayDefinition.crossIndex = 0;
                            MovedStatics.crossY = RSString.clickY;
                            SceneCluster.packetBuffer.putPacket(116);
                            SceneCluster.packetBuffer.putShortLE(i_12_);
                        }
                    }
                    if(Class8.itemSelected != 0) {
                        Class8.itemSelected = 0;
                        redrawTabArea = true;
                    }
                    if(Main.widgetSelected != 0) {
                        redrawTabArea = true;
                        Main.widgetSelected = 0;
                    }
                }
            }
        }
    }

    public static void method360(byte arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        if(decodeGameInterface(arg4)) {
            if(arg0 != 125) {
                drawScrollBar(-118, 12, 65, -60, 59, -24);
            }
            GameShell.method20(arg5, arg3, 0, arg2, arg6, -1, 1, cachedInterfaces[arg4], arg1, 0);
            if(Wall.aGameInterface_353 != null) {
                GameInterface gameInterface = Wall.aGameInterface_353;
                GameInterface gameInterface_24_ = FramemapDefinition.method878(gameInterface);
                if(gameInterface_24_ != null) {
                    int[] is = Class13.method247(gameInterface_24_, (byte) 97);
                    int[] is_25_ = Class13.method247(gameInterface, (byte) 110);
                    int i = is_25_[1] - is[1] + -Class40_Sub5_Sub11.anInt2621 + Landscape.mouseY;
                    int i_26_ = -is[0] + is_25_[0] + Class13.mouseX + -MovedStatics.anInt1996;
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
                    if(Wall.aGameInterface_353.anObjectArray2669 != null && (arg2 & 0x200) != 0) {
                        ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2669, 0, i, gameInterface, i_26_);
                    }
                    if(SpotAnimDefinition.mouseButtonPressed == 0 && (arg2 & 0x400) != 0) {
                        if(Wall.aGameInterface_353.anObjectArray2695 != null) {
                            ClientScriptRunner.runClientScripts(gameInterface.anObjectArray2695, 0, i, gameInterface, i_26_);
                        }
                        Wall.aGameInterface_353 = null;
                    }
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
        if(MovedStatics.aBoolean1444)
            Landscape.anInt1171 = 32;
        else
            Landscape.anInt1171 = 0;
        MovedStatics.aBoolean1444 = false;
        if(arg2 >= arg6 && arg2 < arg6 + 16 && arg1 >= arg8 && 16 + arg8 > arg1) {
            arg5.scrollPosition -= Npc.anInt3294 * 4;
            if(arg7 == 1)
                redrawTabArea = true;
            if(arg7 == 2 || arg7 == 3)
                ChatBox.redrawChatbox = true;
        } else if(arg6 > arg2 || arg6 + 16 <= arg2 || arg1 < arg8 + arg0 + -16 || arg1 >= arg8 + arg0) {
            if(-Landscape.anInt1171 + arg6 <= arg2 && 16 + arg6 + Landscape.anInt1171 > arg2 && arg8 + 16 <= arg1 && arg1 < -16 + arg8 + arg0 && Npc.anInt3294 > 0) {
                MovedStatics.aBoolean1444 = true;
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
            arg5.scrollPosition += 4 * Npc.anInt3294;
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
                Class37.anInt876 = 1;
                Native.aClass1_1563 = English.enterNameOfFriendToAddToList;
                ChatBox.messagePromptRaised = true;
                ChatBox.inputType = 0;
                ChatBox.chatMessage = "";
                ChatBox.redrawChatbox = true;
            }
            if(i == 202) {
                Class37.anInt876 = 2;
                Native.aClass1_1563 = English.enterNameOfFriendToDeleteFromList;
                ChatBox.redrawChatbox = true;
                ChatBox.inputType = 0;
                ChatBox.messagePromptRaised = true;
                ChatBox.chatMessage = "";
            }
        }
        if(i == 205) {
            SceneCluster.idleLogout = 250;
            return true;
        }
        if(i == 501) {
            ChatBox.inputType = 0;
            Class37.anInt876 = 4;
            ChatBox.redrawChatbox = true;
            Native.aClass1_1563 = English.enterNameOfPlayerToAddToList;
            ChatBox.chatMessage = "";
            ChatBox.messagePromptRaised = true;
        }
        if(i == 502) {
            ChatBox.redrawChatbox = true;
            ChatBox.inputType = 0;
            Class37.anInt876 = 5;
            ChatBox.messagePromptRaised = true;
            ChatBox.chatMessage = "";
            Native.aClass1_1563 = English.enterNameOfPlayerToDeleteFromList;
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
            SceneCluster.packetBuffer.putPacket(231);
            Player.activePlayerAppearance.sendAppearanceData(arg0 ^ 0x58, SceneCluster.packetBuffer);
            return true;
        }
        if(i == 620)
            MovedStatics.reportMutePlayer = !MovedStatics.reportMutePlayer;
        if(i >= 601 && i <= 613) {
            PacketBuffer.closeAllWidgets();
            if(Native.reportedName.length() > 0) {
                SceneCluster.packetBuffer.putPacket(202);
                SceneCluster.packetBuffer.putLongBE(TextUtils.nameToLong(Native.reportedName));
                SceneCluster.packetBuffer.putByte(-601 + i);
                SceneCluster.packetBuffer.putByte(MovedStatics.reportMutePlayer ? 1 : 0);
            }
        }
        return false;
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

    public ImageRGB method638(byte arg0, int arg1) {
        FramemapDefinition.aBoolean2177 = false;
        if(arg1 < 0 || imageY.length <= arg1) {
            return null;
        }
        int i = imageY[arg1];
        if(i == -1) {
            return null;
        }
        int i_9_ = 124 % ((-15 - arg0) / 34);
        ImageRGB class40_sub5_sub14_sub4 = (ImageRGB) ImageRGB.imageRgbCache.get((long) i);
        if(class40_sub5_sub14_sub4 != null) {
            return class40_sub5_sub14_sub4;
        }
        class40_sub5_sub14_sub4 = Class48.method927(0, CacheArchive.gameImageCacheArchive, true, i);
        if(class40_sub5_sub14_sub4 == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            ImageRGB.imageRgbCache.put((long) i, class40_sub5_sub14_sub4);
        }
        return class40_sub5_sub14_sub4;
    }

    public ImageRGB getImageRgb(boolean useAlternateImage) {
        FramemapDefinition.aBoolean2177 = false;

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
        ImageRGB imageRGB = (ImageRGB) ImageRGB.imageRgbCache.get((long) i);

        if(imageRGB != null) {
            return imageRGB;
        }
        imageRGB = Class48.method927(0, CacheArchive.gameImageCacheArchive, true, i);
        if(imageRGB == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            ImageRGB.imageRgbCache.put((long) i, imageRGB);
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
        FramemapDefinition.aBoolean2177 = false;
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

        Model model = (Model) WallDecoration.aClass9_1264.get((long) ((modelType.ordinal() << 16) + modelId));
        if(model == null) {
            if(modelType == InterfaceModelType.MODEL) {
                model = Model.getModel(CacheArchive.modelCacheArchive, modelId);
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.NPC_CHATHEAD) {
                model = ActorDefinition.getDefinition(modelId).getHeadModel();
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
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
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.ITEM) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(modelId, 10);
                model = class40_sub5_sub16.asGroundStack(false, 10);
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
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
            WallDecoration.aClass9_1264.put((long) ((modelType.ordinal() << 16) + modelId), model);
        }
        if(animationSequence != null) {
            model = animationSequence.method598(animationFrame, model, true);
        }
        return model;
    }

    public TypeFace getTypeFace() {
        FramemapDefinition.aBoolean2177 = false;
        if(fontId == 65535) {
            return null;
        }
        TypeFace typeFace = (TypeFace) TypeFace.typeFaceCache.get(fontId);

        if(typeFace != null) {
            return typeFace;
        }

        typeFace = TypeFace.getFont(CacheArchive.gameImageCacheArchive, 0, fontId);

        if(typeFace == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            TypeFace.typeFaceCache.put(fontId, typeFace);
        }

        return typeFace;
    }
}
