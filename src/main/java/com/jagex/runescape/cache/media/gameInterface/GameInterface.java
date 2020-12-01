package com.jagex.runescape.cache.media.gameInterface;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.TextUtils;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.lang.reflect.Method;

public class GameInterface extends SubNode {
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
    public boolean aBoolean2641;
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
    public boolean aBoolean2694;
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
    public int anInt2746;
    public Object[] anObjectArray2747;
    public int[][] clientScripts;
    public int itemSpritePadsX;
    public boolean isHidden;
    public int anInt2751;

    public GameInterface() {
        contentType = 0;
        rotationZ = 0;
        textShadowed = false;
        aBoolean2641 = false;
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
        aBoolean2694 = false;
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
        anInt2746 = 0;
        offsetX2d = 0;
        isHidden = false;
        alternateTextColor = 0;
        scrollHeight = 0;
        scrollPosition = 0;
        anInt2736 = 0;
        itemId = -1;
        itemSpritePadsX = 0;
        actionType = 0;
        anInt2751 = 0;
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
        ProducingGraphicsBuffer.aClass9_1615.method235();
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

    public static void method645() {
        GroundItemTile.aClass9_1364.method235();
        VertexNormal.aClass9_1102.method235();
        InteractiveObject.aClass9_470.method235();
        Class49.aClass9_1145.method235();
    }

    public static String getShortenedAmountText(int coins) {
        if(coins < 100000) {
            return String.valueOf(coins);
        }
        if(coins < 10000000) {
            return coins / 1000 + "K";
        }
        return coins / 0xf4240 + "M";
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
                gameInterface.disabledText = PacketBuffer.str_Please_Wait;
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
                    gameInterface.disabledText = ClientScriptRunner.friendUsernames[type];
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
                    gameInterface.disabledText = Native.aClass1_610 + English.offline;
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
                gameInterface.disabledText = PacketBuffer.str_Please_Wait;
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
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) pulseCycle / 40.0));
            gameInterface.modelId = 0;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 328) {
            gameInterface.rotationX = 150;
            gameInterface.rotationZ = 0x7ff & (int) (256.0 * Math.sin((double) pulseCycle / 40.0));
            gameInterface.modelId = 1;
            gameInterface.modelType = InterfaceModelType.PLAYER;
        } else if(type == 600)
            gameInterface.disabledText = Native.reportedName + Native.prefixYellowBar;
        else if(type == 620) {
            if(InteractiveObject.playerRights >= 1) {
                if(Class67.reportMutePlayer) {
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
        CacheIndex.aClass40_Sub5_Sub14_Sub2Array215[unknownArrayIndex].drawImage(x, y);
        CacheIndex.aClass40_Sub5_Sub14_Sub2Array215[1].drawImage(x, y - (-height + 16));
        Rasterizer.drawFilledRectangle(x, y + 16, 16, height + -32, Class55.anInt1299);
        if(length < 8)
            length = 8;
        int scrollCurrent = (-32 + height - length) * scrollPosition / (-height + scrollMaximum);
        Rasterizer.drawFilledRectangle(x, 16 + y + scrollCurrent, 16, length, MemoryCache.anInt321);
        Rasterizer.drawVerticalLine(x, 16 + y + scrollCurrent, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(1 + x, scrollCurrent + y + 16, length, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, scrollCurrent + y + 16, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawHorizontalLine(x, 17 + y + scrollCurrent, 16, HuffmanEncoding.anInt1559);
        Rasterizer.drawVerticalLine(x + 15, y + 16 + scrollCurrent, length, Class56.anInt1318);
        Rasterizer.drawVerticalLine(x + 14, scrollCurrent + 17 + y, length - 1, Class56.anInt1318);
        Rasterizer.drawHorizontalLine(x, length + scrollCurrent + 15 + y, 16, Class56.anInt1318);
        Rasterizer.drawHorizontalLine(x + 1, 14 + y + scrollCurrent + length, 15, Class56.anInt1318);
    }

    public static boolean decodeGameInterface(int interfaceId) {
        if(loadedInterfaces[interfaceId]) {
            return true;
        }

        if(!MemoryCache.gameInterfaceCacheIndex.fileExists(interfaceId)) {
            return false;
        }

        int gameInterfaceCount = MemoryCache.gameInterfaceCacheIndex.fileLength(interfaceId);
        if(gameInterfaceCount == 0) {
            loadedInterfaces[interfaceId] = true;
            return true;
        }

        if(cachedInterfaces[interfaceId] == null) {
            cachedInterfaces[interfaceId] = new GameInterface[gameInterfaceCount];
        }

        for(int i = 0; i < gameInterfaceCount; i++) {
            if(cachedInterfaces[interfaceId][i] == null) {
                byte[] interfaceFileData = MemoryCache.gameInterfaceCacheIndex.getFile(i, interfaceId);

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

        MemoryCache.gameInterfaceCacheIndex.unloadFile(1, interfaceId);

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
                [MemoryCache.gameInterfaceCacheIndex.getLength()][];
        loadedInterfaces = new boolean
                [MemoryCache.gameInterfaceCacheIndex.getLength()];
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
        class40_sub5_sub14_sub4 = Class48.method927(0, MemoryCache.gameImageCacheIndex, true, i);
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
        imageRGB = Class48.method927(0, MemoryCache.gameImageCacheIndex, true, i);
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
            anInt2746 = buffer.getUnsignedShortBE();
            scrollPosition = buffer.getUnsignedShortBE();
        }
        if(type == GameInterfaceType.GRAPHIC) {
            spriteId = buffer.getIntBE();
            anInt2751 = buffer.getUnsignedShortBE();
            aBoolean2641 = buffer.getUnsignedByte() == 1;
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
            aBoolean2694 = buffer.getUnsignedByte() == 1;
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

    public Model method646(byte arg0, AnimationSequence arg1, int arg2, boolean arg3, PlayerAppearance arg4) {
        FramemapDefinition.aBoolean2177 = false;
        InterfaceModelType modelType;
        int i_11_;
        if(arg3) {
            i_11_ = alternateModelId;
            modelType = alternateModelType;
        } else {
            modelType = this.modelType;
            i_11_ = modelId;
        }
        if(modelType == InterfaceModelType.NULL) {
            return null;
        }
        if(modelType == InterfaceModelType.MODEL && i_11_ == -1) {
            return null;
        }
        if(arg0 <= 25) {
            hasListeners = true;
        }
        Model model = (Model) WallDecoration.aClass9_1264.get((long) ((modelType.ordinal() << 16) + i_11_));
        if(model == null) {
            if(modelType == InterfaceModelType.MODEL) {
                model = Model.getModel(MemoryCache.modelCacheIndex, i_11_, 0);
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.NPC_CHATHEAD) {
                model = ActorDefinition.getDefinition(i_11_).getHeadModel();
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.LOCAL_PLAYER_CHATHEAD) {
                if(arg4 == null) {
                    return null;
                }
                model = arg4.getStaticModel();
                if(model == null) {
                    FramemapDefinition.aBoolean2177 = true;
                    return null;
                }
                model.createBones();
                model.applyLighting(64, 768, -50, -10, -50, true);
            }
            if(modelType == InterfaceModelType.ITEM) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_11_, 10);
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
            WallDecoration.aClass9_1264.put((long) ((modelType.ordinal() << 16) + i_11_), model);
        }
        if(arg1 != null) {
            model = arg1.method598(arg2, model, true);
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

        typeFace = TypeFace.getFont(MemoryCache.gameImageCacheIndex, 0, fontId);

        if(typeFace == null) {
            FramemapDefinition.aBoolean2177 = true;
        } else {
            TypeFace.typeFaceCache.put(fontId, typeFace);
        }

        return typeFace;
    }
}
