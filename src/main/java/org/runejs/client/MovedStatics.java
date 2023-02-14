package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Console;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.util.TextUtils;
import org.runejs.client.cache.def.*;
import org.runejs.client.media.renderable.actor.*;
import org.runejs.client.scene.tile.*;
import org.runejs.Configuration;

import java.awt.*;
import java.io.DataInputStream;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Calendar;

public class MovedStatics {

    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[][] anIntArrayArray1435 = new int[104][104];
    public static ProducingGraphicsBuffer tabPieceUpperRight;
    public static boolean aBoolean1444 = false;
    public static int[] anIntArray1445;
    public static ProducingGraphicsBuffer chatboxRight;
    public static int crossY = 0;
    public static int anInt2280 = 0;
    public static int anInt321 = 5063219;
    public static volatile int eventMouseY = -1;
    public static boolean redrawChatbox = false;
    public static ImageRGB[] mapDots;
    public static CacheArchive aCacheArchive_654;
    public static int minimapState = 0;
    public static int[] anIntArray666 = new int[]{1, 0, -1, 0};
    public static int pulseCycle = 0;
    public static int anInt938 = 500;
    public static int loginScreenFocus = 0;
    public static boolean aBoolean2083 = false;
    public static ProducingGraphicsBuffer tabImageProducer;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_549;
    public static int anInt564;
    public static boolean aBoolean565 = false;
    public static boolean aBoolean571;
    public static int anInt573 = -1;
    public static boolean menuOpen = false;
    public static volatile long aLong174 = 0L;
    public static int anInt175 = 0;
    public static int[] anIntArray178;
    public static int anInt188;
    public static int anInt194;
    public static int anInt195 = 1;
    public static int[] chatboxLineOffsets;
    public static int anInt199 = 0;
    public static volatile boolean aBoolean1575 = false;
    public static CacheArchive aCacheArchive_1577;
    public static int[] blendedHueMultiplier;
    public static int anInt1586 = -1;
    public static boolean reportMutePlayer = false;
    public static int anInt1607 = 10;
    public static NodeCache aClass9_1611 = new NodeCache(50);
    public static long[] tickSamples = new long[32];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1315;
    public static int anInt1318 = 3353893;
    public static IndexedImage tabBottomBack;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array215;
    public static NodeCache modelCache = new NodeCache(260);
    public static boolean showChatPanelRedrawnText = false;
    public static int[][][] tileCullingBitsets;
    public static int lastContinueTextWidgetId = -1;
    public static GameSocket gameServerSocket;
    public static int[][][] tile_height = new int[4][105][105];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2105;
    public static int[] anIntArray2106 = {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    public static int secondaryCameraVertical = 0;
    public static int[] anIntArray2113 = new int[128];
    public static GameInterface aGameInterface_2116;
    public static int anInt2118 = 0;
    public static int placementX;
    public static int onBuildTimePlane = 0;
    public static int anInt1996 = 0;
    public static HashTable aClass23_805;
    public static int anInt848 = 0;
    public static int currentCameraPositionV;
    public static int[] anIntArray852;
    public static long aLong853;
    public static int anInt854 = -1;
    public static IndexedImage minimapBackgroundImage;
    public static int anInt2621 = 0;
    public static volatile int eventClickY = 0;
    public static int anInt2628 = 0;
    public static volatile boolean clearScreen = true;
    public static ProducingGraphicsBuffer gameScreenImageProducer;
    public static int anInt2359 = 0;
    public static int[] anIntArray2361 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, 2147483647, -1};
    public static CacheArchive aCacheArchive_2364;
    public static int destinationX = 0;
    public static int anInt1511 = -1;
    public static int lowestPlane = 99;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array2567;
    public static int anInt2576;
    public static int anInt2581;
    public static CacheArchive aCacheArchive_2582;
    public static ImageRGB minimapEdge;
    public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array2301;
    public static int baseX;
    public static byte[][][] tile_underlayids;
    public static NodeCache aClass9_998 = new NodeCache(100);
    public static int anInt1008 = 0;
    public static int anInt1010 = 2;
    public static int[] anIntArray1013;
    public static IndexedImage[] moderatorIcon;
    public static int[] anIntArray2764 = new int[128];
    public static ImageRGB minimapImage;
    public static void method440() {
        if (ISAAC.aBoolean512) {
            Class51.anIntArray1198 = null;
            GameObject.flameRightBackground = null;
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = null;
            Class51.aProducingGraphicsBuffer_1206 = null;
            Landscape.anIntArray1168 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = null;
            Class59.imgLoginScreenButton = null;
            anIntArray1445 = null;
            Class40_Sub5_Sub15.loginScreenBox = null;
            Renderable.anIntArray2865 = null;
            MovedStatics.flameLeftBackground = null;
            Class39.aProducingGraphicsBuffer_907 = null;
            GameObjectDefinition.aProducingGraphicsBuffer_2524 = null;
            Class39.aClass40_Sub5_Sub14_Sub4_918 = null;
            MovedStatics.aClass40_Sub5_Sub14_Sub2Array535 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = null;
            MovedStatics.loginBoxGraphics = null;
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = null;
            anIntArray178 = null;
            KeyFocusListener.aProducingGraphicsBuffer_1285 = null;
            Class17.aProducingGraphicsBuffer_463 = null;
            anIntArray1013 = null;
            MusicSystem.method405(10);
            UpdateServer.resetUpdateServerRequests(true);
            ISAAC.aBoolean512 = false;
        }
    }

    public static int[] menuActionTypes = new int[500];
    public static ProducingGraphicsBuffer loginBoxGraphics;
    public static int anInt892;
    public static boolean showSidePanelRedrawnText = false;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
    public static int anInt1923 = 0;

    public static void method445() {
        if (CollisionMap.anInt165 != 0) {
            int i = 0;
            if (Class40_Sub5_Sub15.systemUpdateTime != 0)
                i = 1;
            for (int i_1_ = 0; i_1_ < 100; i_1_++) {
                if (ChatBox.chatMessages[i_1_] != null) {
                    int i_2_ = ChatBox.chatTypes[i_1_];
                    String username = ChatBox.chatPlayerNames[i_1_];
                    if (username != null && username.startsWith(Native.whiteCrown))
                        username = username.substring(5);
                    if (username != null && username.startsWith(Native.goldCrown))
                        username = username.substring(5);
                    if ((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(username))) {
                        int i_3_ = 329 + -(13 * i);
                        i++;
                        if (Class13.mouseX > 4 && i_3_ + -10 < Landscape.mouseY + -4 && -4 + Landscape.mouseY <= i_3_ + 3) {
                            int i_4_ = 25 + WallDecoration.fontNormal.getStringWidth(English.from + Native.prefixColon + username + ChatBox.chatMessages[i_1_]);
                            if (i_4_ > 450)
                                i_4_ = 450;
                            if (Class13.mouseX < 4 + i_4_) {
                                int actionRowOffset = 2000;
                                if (InteractiveObject.playerRights >= 1) {
                                    addActionRow(English.reportAbuse, 0, 0, 0, actionRowOffset + ActionRowType.REPORT_ABUSE.getId(), Native.white + username);
                                }
                                addActionRow(English.addIgnore, 0, 0, 0, actionRowOffset + ActionRowType.ADD_IGNORE.getId(), Native.white + username);
                                addActionRow(English.addFriend, 0, 0, 0, actionRowOffset + ActionRowType.ADD_FRIEND.getId(), Native.white + username);
                            }
                        }
                        if (i >= 5)
                            return;
                    }
                    if ((i_2_ == 5 || i_2_ == 6) && ChatBox.privateChatMode < 2 && ++i >= 5)
                        return;
                }
            }
        }
    }

    public static void method996() {
        tabImageProducer.prepareRasterizer();
        if (ScreenController.frameMode == ScreenMode.FIXED) {
            FloorDecoration.inventoryBackgroundImage.drawImage(0, 0);

        } else {
            int currentX = 0;
            int currentY = 0;
            while (currentX < tabImageProducer.width || currentY < tabImageProducer.height) {
                ImageRGB part = TabParts.GetPart("side_panel_background");
                if (currentX > tabImageProducer.width) {
                    currentX = 0;
                    currentY += part.imageHeight;
                }
                part.drawImage(currentX, currentY);
                currentX += part.imageWidth;
            }
        }


        ActorDefinition.sidebarOffsets = Rasterizer3D.setLineOffsets(ActorDefinition.sidebarOffsets);
    }

    public static void method997() {
        // (Jameskmonger) I think this is something to do with keycode remapping, though Im not sure
        if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") == -1) {
            HuffmanEncoding.anIntArray1564[44] = 71;
            HuffmanEncoding.anIntArray1564[45] = 26;
            HuffmanEncoding.anIntArray1564[46] = 72;
            HuffmanEncoding.anIntArray1564[47] = 73;
            HuffmanEncoding.anIntArray1564[59] = 57;
            HuffmanEncoding.anIntArray1564[61] = 27;
            HuffmanEncoding.anIntArray1564[91] = 42;
            HuffmanEncoding.anIntArray1564[92] = 74;
            HuffmanEncoding.anIntArray1564[93] = 43;
            if (Signlink.aMethod729 == null) {
                HuffmanEncoding.anIntArray1564[192] = 58;
                HuffmanEncoding.anIntArray1564[222] = 59;
            } else {
                HuffmanEncoding.anIntArray1564[192] = 28;
                HuffmanEncoding.anIntArray1564[222] = 58;
                HuffmanEncoding.anIntArray1564[520] = 59;
            }
        } else {
            HuffmanEncoding.anIntArray1564[186] = 57;
            HuffmanEncoding.anIntArray1564[187] = 27;
            HuffmanEncoding.anIntArray1564[188] = 71;
            HuffmanEncoding.anIntArray1564[189] = 26;
            HuffmanEncoding.anIntArray1564[190] = 72;
            HuffmanEncoding.anIntArray1564[191] = 73;
            HuffmanEncoding.anIntArray1564[192] = 58;
            HuffmanEncoding.anIntArray1564[219] = 42;
            HuffmanEncoding.anIntArray1564[220] = 74;
            HuffmanEncoding.anIntArray1564[221] = 43;
            HuffmanEncoding.anIntArray1564[222] = 59;
            HuffmanEncoding.anIntArray1564[223] = 28;
        }

    }

    public static void initiateVertexHeights(int offsetY, int sizeY, int sizeX, int offsetX) {
        for (int y = offsetY; y <= offsetY + sizeY; y++) {
            for (int x = offsetX; sizeX + offsetX >= x; x++) {
                if (x >= 0 && x < 104 && y >= 0 && y < 104) {
                    InteractiveObject.tileShadowIntensity[0][x][y] = (byte) 127;
                    if (offsetX == x && x > 0)
                        tile_height[0][x][y] = tile_height[0][-1 + x][y];
                    if (offsetX + sizeX == x && x < 103)
                        tile_height[0][x][y] = tile_height[0][x + 1][y];
                    if (y == offsetY && y > 0)
                        tile_height[0][x][y] = tile_height[0][x][y + -1];
                    if (y == offsetY + sizeY && y < 103)
                        tile_height[0][x][y] = tile_height[0][x][1 + y];
                }
            }
        }
    }

    public static void method1000() {
        for (Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.peekFirst(); class40_sub5_sub17_sub6 != null; class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.pollFirst()) {
            if (Player.worldLevel == class40_sub5_sub17_sub6.anInt3239 && !class40_sub5_sub17_sub6.aBoolean3237) {
                if (pulseCycle >= class40_sub5_sub17_sub6.anInt3230) {
                    class40_sub5_sub17_sub6.method834(anInt199);
                    if (class40_sub5_sub17_sub6.aBoolean3237)
                        class40_sub5_sub17_sub6.unlink();
                    else
                        Npc.currentScene.method134(class40_sub5_sub17_sub6.anInt3239, class40_sub5_sub17_sub6.anInt3244, class40_sub5_sub17_sub6.anInt3235, class40_sub5_sub17_sub6.anInt3231, 60, class40_sub5_sub17_sub6, 0, -1, false);
                }
            } else
                class40_sub5_sub17_sub6.unlink();
        }
    }

    public static int method546() {
        if (!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        int i = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, MovedStatics.cameraY);
        if (i + -SceneCluster.cameraZ < 800 && (OverlayDefinition.tile_flags[Player.worldLevel][Class12.cameraX >> 7][MovedStatics.cameraY >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

    public static void method233() {
        OverlayDefinition.overlayDefinitionCache.clear();
    }

    public static void initializeAnimationCaches(CacheArchive skinArchive, CacheArchive definitionArchive, CacheArchive skeletonArchive) {
        ClientScriptRunner.aCacheArchive_2162 = skinArchive;
        aCacheArchive_2364 = skeletonArchive;
        AnimationSequence.aCacheArchive_2484 = definitionArchive;
    }

    public static void method455(int arg0, int arg1, int arg3) {
        for (int i = 0; i < 8; i++) {
            for (int i_0_ = 0; i_0_ < 8; i_0_++)
                tile_height[arg1][arg3 + i][arg0 + i_0_] = 0;
        }
        if (arg3 > 0) {
            for (int i = 1; i < 8; i++)
                tile_height[arg1][arg3][arg0 + i] = tile_height[arg1][-1 + arg3][i + arg0];
        }
        if (arg0 > 0) {
            for (int i = 1; i < 8; i++)
                tile_height[arg1][i + arg3][arg0] = tile_height[arg1][i + arg3][-1 + arg0];
        }
        if (arg3 > 0 && tile_height[arg1][-1 + arg3][arg0] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][arg3 - 1][arg0];
        else if (arg0 > 0 && tile_height[arg1][arg3][arg0 - 1] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][arg3][-1 + arg0];
        else if (arg3 > 0 && arg0 > 0 && tile_height[arg1][arg3 + -1][-1 + arg0] != 0)
            tile_height[arg1][arg3][arg0] = tile_height[arg1][-1 + arg3][arg0 - 1];
    }

    public static boolean method459(int arg0, int arg1) {
        if (arg0 == 11)
            arg0 = 10;
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
        if (arg0 >= 5 && arg0 <= 8)
            arg0 = 4;
        return gameObjectDefinition.method610(arg0);
    }

    public static IndexedImage method538() {
        IndexedImage class40_sub5_sub14_sub2 = new IndexedImage();
        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub2.maxHeight = GameShell.anInt31;
        class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[0];
        class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[0];
        class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[0];
        class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
        class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[0];
        ActorDefinition.method569();
        return class40_sub5_sub14_sub2;
    }

    public static void method540() {
        KeyFocusListener.aLinkedList_1278 = new LinkedList();
    }

    public static void method332(int arg0) {
        synchronized (CollisionMap.anObject162) {
            if (Buffer.anInt1987 == 0)
                Main.signlink.createThreadNode(5, new Class44());
            Buffer.anInt1987 = arg0;
        }
    }

    public static RSString intToStr(int arg0) {
        return PacketBuffer.method521(false, 10, arg0);
    }

    public static void method335() {
        Projectile projectile = (Projectile) Class43.projectileQueue.peekFirst();
        for (/**/; projectile != null; projectile = (Projectile) Class43.projectileQueue.pollFirst()) {
            if (Player.worldLevel == projectile.anInt2981 && pulseCycle <= projectile.endCycle) {
                if (projectile.delay <= pulseCycle) {
                    if (projectile.entityIndex > 0) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[-1 + projectile.entityIndex];
                        if (class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.worldX >= 0 && class40_sub5_sub17_sub4_sub2.worldX < 13312 && class40_sub5_sub17_sub4_sub2.worldY >= 0 && class40_sub5_sub17_sub4_sub2.worldY < 13312)
                            projectile.trackTarget(pulseCycle, 61 + -61, class40_sub5_sub17_sub4_sub2.worldY, Class37.getFloorDrawHeight(projectile.anInt2981, class40_sub5_sub17_sub4_sub2.worldX, class40_sub5_sub17_sub4_sub2.worldY) - projectile.endHeight, class40_sub5_sub17_sub4_sub2.worldX);
                    }
                    if (projectile.entityIndex < 0) {
                        int i = -1 + -projectile.entityIndex;
                        Player class40_sub5_sub17_sub4_sub1;
                        if (i != PlayerAppearance.anInt708)
                            class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i];
                        else
                            class40_sub5_sub17_sub4_sub1 = Player.localPlayer;
                        if (class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.worldX >= 0 && class40_sub5_sub17_sub4_sub1.worldX < 13312 && class40_sub5_sub17_sub4_sub1.worldY >= 0 && class40_sub5_sub17_sub4_sub1.worldY < 13312)
                            projectile.trackTarget(pulseCycle, 0, class40_sub5_sub17_sub4_sub1.worldY, Class37.getFloorDrawHeight(projectile.anInt2981, class40_sub5_sub17_sub4_sub1.worldX, class40_sub5_sub17_sub4_sub1.worldY) - projectile.endHeight, class40_sub5_sub17_sub4_sub1.worldX);
                    }
                    projectile.move(anInt199);
                    Npc.currentScene.method134(Player.worldLevel, (int) projectile.currentX, (int) projectile.currentY, (int) projectile.currentHeight, 60, projectile, projectile.anInt3013, -1, false);
                }
            } else
                projectile.unlink();
        }
    }

    public static int perlinNoise(int x, int y, int scale) {
        int muX = x & -1 + scale;
        int scaledY = y / scale;
        int muY = scale - 1 & y;
        int scaledX = x / scale;
        int a = CollisionMap.randomNoiseWeightedSum(scaledX, scaledY);
        int b = CollisionMap.randomNoiseWeightedSum(1 + scaledX, scaledY);
        int c = CollisionMap.randomNoiseWeightedSum(scaledX, 1 + scaledY);
        int d = CollisionMap.randomNoiseWeightedSum(1 + scaledX, 1 + scaledY);
        int i1 = GameShell.interpolate(a, scale, b, true, muX);
        int i2 = GameShell.interpolate(c, scale, d, true, muX);
        return GameShell.interpolate(i1, scale, i2, true, muY);
    }

    public static int calculateCrc8(int offset, int size, byte[] data) {
        int crc = -1;
        for (int currentByte = offset; currentByte < size; currentByte++) {
            int tableIndex = 0xff & (crc ^ data[currentByte]);
            crc = KeyFocusListener.crc8LookupTable[tableIndex] ^ crc >>> 8;
        }
        crc ^= 0xffffffff;
        return crc;
    }

    /**
     * Iterate through the list of input options and return a new list containing
     * all 5 option indices with their value (including empty rows)
     *
     * @param inputOptions The available options
     * @return A list of all 5 option indices
     */
    public static String[] getAllOptionsWithIndices(String[] inputOptions) {
        String[] allOptions = new String[5];

        for (int i = 0; i < 5; i++) {
            allOptions[i] = i + Native.COLON_CHARACTER;
            if (inputOptions != null && inputOptions[i] != null)
                allOptions[i] = allOptions[i] + inputOptions[i];
        }

        return allOptions;
    }

    public static void method973() {
        blendedHueMultiplier = null;
        SceneTile.blendedLightness = null;
        FloorDecoration.blendDirectionTracker = null;
        tileCullingBitsets = null;
        AnimationSequence.tileLightIntensity = null;
        Class35.tile_overlay_rotation = null;
        Class59.blendedSaturation = null;
        InteractiveObject.tileShadowIntensity = null;
        OverlayDefinition.tile_underlay_path = null;
        MouseHandler.tile_overlayids = null;
        tile_underlayids = null;
        Class40_Sub5_Sub17_Sub6.blendedHue = null;
    }

    public static void printException(String arg0, Throwable exception) {
            try {
                String string = "";
                if (exception != null)
                    string = Class55.parseException(exception);
                if (arg0 != null) {
                    if (exception != null)
                        string += " | ";
                    string += arg0;
                }
                System.out.println("Error: " + string);
                string = string.replace(':', '.');
                string = string.replace('@', '_');
                string = string.replace('&', '_');
                string = string.replace('#', '_');
                SignlinkNode signlinkNode = Actor.signlink.addType4Node(new URL(Actor.signlink.gameShell.getCodeBase(), "clienterror.ws?c=" + Class39.anInt901 + "&u=" + aLong853 + "&v1=" + Signlink.javaVendor + "&v2=" + Signlink.javaVersion + "&e=" + string));
                while (signlinkNode.status == 0)
                    Class43.threadSleep(1L);
                if (signlinkNode.status != 1)
                    return;
                DataInputStream datainputstream = (DataInputStream) signlinkNode.value;
                datainputstream.read();
                datainputstream.close();
            } catch (Exception ignored) { }
    }

    public static void method184(byte[] data, int arg1) {
        Buffer buffer = new Buffer(data);
        buffer.currentPosition = -2 + data.length;
        anInt2581 = buffer.getUnsignedShortBE();
        Actor.anIntArray3111 = new int[anInt2581];
        GroundItemTile.aByteArrayArray1370 = new byte[anInt2581][];
        Class17.anIntArray456 = new int[anInt2581];
        Npc.anIntArray3312 = new int[anInt2581];
        Class57.anIntArray1347 = new int[anInt2581];

        buffer.currentPosition = data.length + -7 + -(anInt2581 * 8);
        ItemDefinition.anInt2846 = buffer.getUnsignedShortBE();
        GameShell.anInt31 = buffer.getUnsignedShortBE();
        int i = 1 + (buffer.getUnsignedByte() & 0xff);
        for (int i_34_ = 0; i_34_ < anInt2581; i_34_++)
            Class57.anIntArray1347[i_34_] = buffer.getUnsignedShortBE();
        for (int i_35_ = arg1; i_35_ < anInt2581; i_35_++)
            Actor.anIntArray3111[i_35_] = buffer.getUnsignedShortBE();
        for (int i_36_ = 0; i_36_ < anInt2581; i_36_++)
            Class17.anIntArray456[i_36_] = buffer.getUnsignedShortBE();
        for (int i_37_ = 0; anInt2581 > i_37_; i_37_++)
            Npc.anIntArray3312[i_37_] = buffer.getUnsignedShortBE();

        buffer.currentPosition = data.length - (7 + anInt2581 * 8 + -3 + i * 3);
        Buffer.anIntArray1972 = new int[i];
        for (int i_38_ = 1; i > i_38_; i_38_++) {
            Buffer.anIntArray1972[i_38_] = buffer.getMediumBE();
            if (Buffer.anIntArray1972[i_38_] == 0)
                Buffer.anIntArray1972[i_38_] = 1;
        }
        buffer.currentPosition = 0;
        for (int i_39_ = 0; anInt2581 > i_39_; i_39_++) {
            int i_40_ = Npc.anIntArray3312[i_39_];
            int i_41_ = Class17.anIntArray456[i_39_];
            int i_42_ = i_40_ * i_41_;
            byte[] is = new byte[i_42_];
            GroundItemTile.aByteArrayArray1370[i_39_] = is;
            int i_43_ = buffer.getUnsignedByte();
            if (i_43_ == 0) {
                for (int i_46_ = 0; i_42_ > i_46_; i_46_++)
                    is[i_46_] = buffer.getByte();
            } else if (i_43_ == 1) {
                for (int i_44_ = 0; i_41_ > i_44_; i_44_++) {
                    for (int i_45_ = 0; i_40_ > i_45_; i_45_++)
                        is[i_41_ * i_45_ + i_44_] = buffer.getByte();
                }
            }
        }
    }

    public static void method188() {
        MovedStatics.aClass9_2439.clear();
        aClass9_998.clear();
    }

    public static String method204(int arg0) {
        return (0xff & arg0 >> 24) + Native.period + ((arg0 & 0xffca88) >> 16) + Native.period + ((0xfff8 & arg0) >> 8) + Native.period + (0xff & arg0);
    }

    public static void method836(int arg0) {
        int i = 256;
        for (int i_0_ = 10; i_0_ < 117; i_0_++) {
            int i_1_ = (int) (Math.random() * 100.0);
            if (i_1_ < 50)
                anIntArray178[(i - 2 << 7) + i_0_] = 255;
        }
        for (int i_2_ = 0; i_2_ < 100; i_2_++) {
            int i_3_ = (int) (Math.random() * 124.0) + 2;
            int i_4_ = 128 + (int) (Math.random() * 128.0);
            int i_5_ = i_3_ + (i_4_ << 7);
            anIntArray178[i_5_] = 192;
        }
        for (int i_6_ = 1; i_6_ < i - 1; i_6_++) {
            for (int i_7_ = 1; i_7_ < 127; i_7_++) {
                int i_8_ = i_7_ + (i_6_ << 7);
                Class40_Sub5_Sub17_Sub6.anIntArray3255[i_8_] = (anIntArray178[i_8_ + 1] + anIntArray178[i_8_ - 1] - (-anIntArray178[-128 + i_8_] - anIntArray178[128 + i_8_])) / 4;
            }
        }
        RSRuntimeException.anInt1641 += 128;
        if (RSRuntimeException.anInt1641 > Landscape.anIntArray1168.length) {
            RSRuntimeException.anInt1641 -= Landscape.anIntArray1168.length;
            int i_9_ = (int) (12.0 * Math.random());
            FramemapDefinition.method879(MovedStatics.aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
        }
        for (int i_10_ = 1; i_10_ < -1 + i; i_10_++) {
            for (int i_11_ = 1; i_11_ < 127; i_11_++) {
                int i_12_ = i_11_ + (i_10_ << 7);
                int i_13_ = -(Landscape.anIntArray1168[i_12_ + RSRuntimeException.anInt1641 & -1 + Landscape.anIntArray1168.length] / 5) + Class40_Sub5_Sub17_Sub6.anIntArray3255[i_12_ + 128];
                if (i_13_ < 0)
                    i_13_ = 0;
                anIntArray178[i_12_] = i_13_;
            }
        }
        for (int i_14_ = 0; i_14_ < i + -1; i_14_++)
            Class17.anIntArray466[i_14_] = Class17.anIntArray466[i_14_ + 1];
        Class17.anIntArray466[i - arg0] = (int) (16.0 * Math.sin((double) pulseCycle / 14.0) + 14.0 * Math.sin((double) pulseCycle / 15.0) + 12.0 * Math.sin((double) pulseCycle / 16.0));
        if (MovedStatics.anInt2452 > 0)
            MovedStatics.anInt2452 -= 4;
        if (IdentityKit.anInt2613 > 0)
            IdentityKit.anInt2613 -= 4;
        if (MovedStatics.anInt2452 == 0 && IdentityKit.anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                MovedStatics.anInt2452 = 1024;
            if (i_15_ == 1)
                IdentityKit.anInt2613 = 1024;
        }
    }

    public static void method838(long arg1) {
        for (int i = 0; i < anInt1008; i++) {
            if (Player.ignores[i] == arg1) {
                GameInterface.redrawTabArea = true;
                anInt1008--;
                for (int i_16_ = i; anInt1008 > i_16_; i_16_++)
                    Player.ignores[i_16_] = Player.ignores[1 + i_16_];
                SceneCluster.packetBuffer.putPacket(28);
                SceneCluster.packetBuffer.putLongBE(arg1);
                break;
            }
        }
    }

    public static ImageRGB[] method526(CacheArchive arg0, String arg2, String arg3) {
        int i = arg0.getHash(arg2);
        int i_4_ = arg0.method179(i, arg3);
        return GenericTile.method944((byte) -3, i, arg0, i_4_);
    }

    public static void method527(int currentTabId, int[] tabWidgetIds, boolean arg3, int arg4) {
        InteractiveObject.tabTop.prepareRasterizer();
        Buffer.tabTopBack.drawImage(0, 0);
        if (arg3) {
            if (tabWidgetIds[currentTabId] != -1) {
                if (currentTabId == 0)
                    aClass40_Sub5_Sub14_Sub2_1315.drawImage(22, 10);
                if (currentTabId == 1)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(54, 8);
                if (currentTabId == 2)
                    GameShell.aClass40_Sub5_Sub14_Sub2_1.drawImage(82, 8);
                if (currentTabId == 3)
                    Class35.aClass40_Sub5_Sub14_Sub2_1744.drawImage(110, 8);
                if (currentTabId == 4)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(153, 8);
                if (currentTabId == 5)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(181, 8);
                if (currentTabId == 6)
                    aClass40_Sub5_Sub14_Sub2_2105.drawImage(209, 9);
            }
            if (tabWidgetIds[0] != -1 && arg4 != 0)
                Class40_Sub5_Sub15.tabIcons[0].drawImage(29, 13);
            if (tabWidgetIds[1] != -1 && arg4 != 1)
                Class40_Sub5_Sub15.tabIcons[1].drawImage(53, 11);
            if (tabWidgetIds[2] != -1 && arg4 != 2)
                Class40_Sub5_Sub15.tabIcons[2].drawImage(82, 11);
            if (tabWidgetIds[3] != -1 && arg4 != 3)
                Class40_Sub5_Sub15.tabIcons[3].drawImage(115, 12);
            if (tabWidgetIds[4] != -1 && arg4 != 4)
                Class40_Sub5_Sub15.tabIcons[4].drawImage(153, 13);
            if (tabWidgetIds[5] != -1 && arg4 != 5)
                Class40_Sub5_Sub15.tabIcons[5].drawImage(180, 11);
            if (tabWidgetIds[6] != -1 && arg4 != 6)
                Class40_Sub5_Sub15.tabIcons[6].drawImage(208, 13);
        }
        RSCanvas.tabBottom.prepareRasterizer();
        tabBottomBack.drawImage(0, 0);
        if (4 != 4)
            Player.hasFriend(null);
        if (arg3) {
            if (tabWidgetIds[currentTabId] != -1) {
                if (currentTabId == 7)
                    Renderable.aClass40_Sub5_Sub14_Sub2_2860.drawImage(42, 0);
                if (currentTabId == 8)
                    aClass40_Sub5_Sub14_Sub2_549.drawImage(74, 0);
                if (currentTabId == 9)
                    aClass40_Sub5_Sub14_Sub2_549.drawImage(102, 0);
                if (currentTabId == 10)
                    aClass40_Sub5_Sub14_Sub2_1919.drawImage(130, 1);
                if (currentTabId == 11)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(173, 0);
                if (currentTabId == 12)
                    Class13.aClass40_Sub5_Sub14_Sub2_418.drawImage(201, 0);
                if (currentTabId == 13)
                    ISAAC.aClass40_Sub5_Sub14_Sub2_524.drawImage(229, 0);
            }
            if (tabWidgetIds[8] != -1 && arg4 != 8)
                Class40_Sub5_Sub15.tabIcons[7].drawImage(74, 2);
            if (tabWidgetIds[9] != -1 && arg4 != 9)
                Class40_Sub5_Sub15.tabIcons[8].drawImage(102, 3);
            if (tabWidgetIds[10] != -1 && arg4 != 10)
                Class40_Sub5_Sub15.tabIcons[9].drawImage(137, 4);
            if (tabWidgetIds[11] != -1 && arg4 != 11)
                Class40_Sub5_Sub15.tabIcons[10].drawImage(174, 2);
            if (tabWidgetIds[12] != -1 && arg4 != 12)
                Class40_Sub5_Sub15.tabIcons[11].drawImage(201, 2);
            if (tabWidgetIds[13] != -1 && arg4 != 13)
                Class40_Sub5_Sub15.tabIcons[12].drawImage(226, 2);
        }
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            if (ScreenController.frameMode == ScreenMode.FIXED) {
                InteractiveObject.tabTop.drawGraphics(516, 160, graphics);
                RSCanvas.tabBottom.drawGraphics(496, 466, graphics);
            }
        } catch (Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static boolean method416() {
        synchronized (Class59.keyFocusListener) {
            if (Class59.anInt1389 == GenericTile.anInt1214)
                return false;
            ItemDefinition.anInt2854 = anIntArray2113[Class59.anInt1389];
            Class59.anInt1388 = anIntArray2764[Class59.anInt1389];
            Class59.anInt1389 = Class59.anInt1389 + 1 & 0x7f;
            return true;
        }
    }

    public static int mixLightnessSigned(int hsl, int lightness) {
        if (hsl == -2)
            return 12345678;
            
        if (hsl == -1) {
            if (lightness < 0)
                lightness = 0;
            else if (lightness > 127)
                lightness = 127;
            lightness = -lightness + 127;
            return lightness;
        }

        lightness = lightness * (hsl & 0x7f) / 128;
        if (lightness < 2)
            lightness = 2;
        else if (lightness > 126)
            lightness = 126;
        return (0xff80 & hsl) + lightness;
    }

    public static void addFriend(long name) {
        if(name != 0L) {
            if(Player.friendsCount >= 100 && Class44.anInt1049 != 1 || Player.friendsCount >= 200) {
                ChatBox.addChatMessage("", English.friendsListIsFull, 0);
            } else {
                String username = TextUtils.formatName(TextUtils.longToName(name));
                for(int i = 0; Player.friendsCount > i; i++) {
                    if(Class59.friends[i] == name) {
                        ChatBox.addChatMessage("", username + English.isAlreadyOnYourFriendList, 0);
                        return;
                    }
                }
                for(int i = 0; anInt1008 > i; i++) {
                    if(Player.ignores[i] == name) {
                        ChatBox.addChatMessage("", English.pleaseRemove + username + English.suffixFromYourIgnoreListFirst, 0);
                        return;
                    }
                }
                if(!username.equals(Player.localPlayer.playerName)) {
                    Player.friendUsernames[Player.friendsCount] = username;
                    Class59.friends[Player.friendsCount] = name;
                    Player.friendWorlds[Player.friendsCount] = 0;
                    Player.friendsCount++;
                    GameInterface.redrawTabArea = true;
                    SceneCluster.packetBuffer.putPacket(114);
                    SceneCluster.packetBuffer.putLongBE(name);
                }
            }
        }
    }

    public static void method1013() {
        int lasthash = -1;
        if (MovedStatics.itemSelected == 0 && Main.widgetSelected == 0) {
            String tileCoords = "";
            if (Configuration.DEBUG_CONTEXT) {
                tileCoords = MessageFormat.format("<col=8F8FFF>({0}, {1})</col>", Integer.toString(Scene.hoveredTileX + baseX), Integer.toString(Scene.hoveredTileY + Class26.baseY));
            }

            addActionRow(English.walkHere, 0, Class13.mouseX, Landscape.mouseY, ActionRowType.WALK_HERE.getId(), tileCoords);
        }

        for (int idx = 0; Model.resourceCount > idx; idx++) {
            int hash = Model.hoveredHash[idx];
            int x = 0x7f & hash;
            int y = hash >> 7 & 0x7f;
            int type = hash >> 29 & 0x3;
            int index = (hash & 0x1fffcccc) >> 14;
            if (lasthash != hash) {
                lasthash = hash;
                if (type == 2 && Npc.currentScene.getArrangement(Player.worldLevel, x, y, hash) >= 0) {
                    GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(index);
                    if (gameObjectDefinition.childIds != null)
                        gameObjectDefinition = gameObjectDefinition.getChildDefinition();
                    if (gameObjectDefinition == null)
                        continue;
                    if (MovedStatics.itemSelected == 1) {
                        addActionRow(English.use, hash, x, y, ActionRowType.USE_ITEM_ON_OBJECT.getId(), Native.selectedItemName + Native.toCyan + gameObjectDefinition.name);
                    } else if (Main.widgetSelected != 1) {
                        String[] options = gameObjectDefinition.actions;
                        if (Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS)
                            options = getAllOptionsWithIndices(options);
                        if (options != null) {
                            for (int i_7_ = 4; i_7_ >= 0; i_7_--) {
                                if (options[i_7_] != null) {
                                    int actionType = 0;
                                    if (i_7_ == 0)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_1.getId();
                                    if (i_7_ == 1)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_2.getId();
                                    if (i_7_ == 2)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_3.getId();
                                    if (i_7_ == 3)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_4.getId();
                                    if (i_7_ == 4)
                                        actionType = ActionRowType.INTERACT_WITH_OBJECT_OPTION_5.getId();
                                    addActionRow(options[i_7_], hash, x, y, actionType, Native.cyan + gameObjectDefinition.name);
                                }
                            }
                        }
                        StringBuilder examineText = new StringBuilder();
                        examineText.append(MessageFormat.format("<col=00ffff>{0}</col>", gameObjectDefinition.name));
                        if (Configuration.DEBUG_CONTEXT) {
                            examineText.append(" <col=00ff00>(</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}</col>",
                                            Integer.toString(gameObjectDefinition.id)
                                    )
                            );
                            examineText.append("<col=00ff00>) (</col>");
                            examineText.append(
                                    MessageFormat.format("<col=ffffff>{0}, {1}</col>",
                                            Integer.toString(x + baseX),
                                            Integer.toString(y + Class26.baseY)
                                    )
                            );
                            examineText.append("<col=00ff00>)</col>");


                        }
                        addActionRow(English.examine, gameObjectDefinition.id << 14, x, y, ActionRowType.EXAMINE_OBJECT.getId(), examineText.toString());
                    } else if ((ItemDefinition.selectedMask & 0x4) == 4) {
                        addActionRow(Native.selectedSpellVerb, hash, x, y, ActionRowType.CAST_MAGIC_ON_OBJECT.getId(), Native.selectedSpellName + Native.toCyan + gameObjectDefinition.name);
                    }
                }
                if (type == 1) {
                    Npc npc = Player.npcs[index];
                    if (npc.actorDefinition.boundaryDimension == 1 && (npc.worldX & 0x7f) == 64 && (0x7f & npc.worldY) == 64) {
                        for (int i_9_ = 0; Player.npcCount > i_9_; i_9_++) {
                            Npc npc1 = Player.npcs[Player.npcIds[i_9_]];
                            if (npc1 != null && npc1 != npc && npc1.actorDefinition.boundaryDimension == 1 && npc1.worldX == npc.worldX && npc1.worldY == npc.worldY)
                                HuffmanEncoding.processNpcMenuOptions(npc1.actorDefinition, x, y, Player.npcIds[i_9_]);
                        }
                        for (int i_11_ = 0; i_11_ < Player.localPlayerCount; i_11_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_11_]];
                            if (player != null && npc.worldX == player.worldX && player.worldY == npc.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_11_]);
                        }
                    }
                    HuffmanEncoding.processNpcMenuOptions(npc.actorDefinition, x, y, index);
                }
                if (type == 0) {
                    Player player1 = Player.trackedPlayers[index];
                    if ((0x7f & player1.worldX) == 64 && (0x7f & player1.worldY) == 64) {
                        for (int i_12_ = 0; i_12_ < Player.npcCount; i_12_++) {
                            Npc npc = Player.npcs[Player.npcIds[i_12_]];
                            if (npc != null && npc.actorDefinition.boundaryDimension == 1 && npc.worldX == player1.worldX && npc.worldY == player1.worldY)
                                HuffmanEncoding.processNpcMenuOptions(npc.actorDefinition, x, y, Player.npcIds[i_12_]);
                        }
                        for (int i_13_ = 0; i_13_ < Player.localPlayerCount; i_13_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_13_]];
                            if (player != null && player != player1 && player1.worldX == player.worldX && player1.worldY == player.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_13_]);
                        }
                    }
                    Player.processPlayerMenuOptions(player1, x, y, index);
                }
                if (type == 3) {
                    LinkedList itemList = Wall.groundItems[Player.worldLevel][x][y];
                    if (itemList != null) {
                        for (Item item = (Item) itemList.peekLast(); item != null; item = (Item) itemList.pollLast()) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(item.itemId, 10);
                            if (MovedStatics.itemSelected == 1) {
                                addActionRow(English.use, item.itemId, x, y, ActionRowType.USE_ITEM_ON_WORLD_ITEM.getId(), Native.selectedItemName + Native.toLightRed + itemDefinition.name);
                            } else if (Main.widgetSelected != 1) {
                                String[] class1s = itemDefinition.groundOptions;
                                if (Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS)
                                    class1s = getAllOptionsWithIndices(class1s);
                                for (int i_15_ = 4; i_15_ >= 0; i_15_--) {
                                    if (class1s == null || class1s[i_15_] == null) {
                                        if (i_15_ == 2) {
                                            // TODO (jameskmonger) this is the same id as WORLD_ITEM_INTERACTION_OPTION_3
                                            addActionRow(English.take, item.itemId, x, y, 3, Native.lightRed + itemDefinition.name);
                                        }
                                    } else {
                                        int actionType = 0;
                                        if (i_15_ == 0)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_1.getId();
                                        if (i_15_ == 1)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_2.getId();
                                        if (i_15_ == 2)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_3.getId();
                                        if (i_15_ == 3)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_4.getId();
                                        if (i_15_ == 4)
                                            actionType = ActionRowType.INTERACT_WITH_WORLD_ITEM_OPTION_5.getId();
                                        addActionRow(class1s[i_15_], item.itemId, x, y, actionType, Native.lightRed +  itemDefinition.name);
                                    }
                                }
                                addActionRow(English.examine, item.itemId, x, y, ActionRowType.EXAMINE_ITEM.getId(), Native.lightRed + itemDefinition.name);
                            } else if ((0x1 & ItemDefinition.selectedMask) == 1) {
                                addActionRow(Native.selectedSpellVerb, item.itemId, x, y, ActionRowType.CAST_MAGIC_ON_WORLD_ITEM.getId(), Native.selectedSpellName + Native.toLightRed + itemDefinition.name);
                            }
                        }
                    }
                }
            }
        }

    }

    public static void method1015() {
        synchronized (GameObject.frame) {
            MouseHandler.currentMouseButtonPressed = MouseHandler.mouseButtonPressed;
            Class13.mouseX = Class12.eventMouseX;
            Landscape.mouseY = eventMouseY;
            MouseHandler.clickType = MouseHandler.eventMouseButtonPressed;
            Class57.clickX = Class55.eventClickX;
            RSString.clickY = eventClickY;
            GameObjectDefinition.aLong2561 = OverlayDefinition.lastClick;
            MouseHandler.eventMouseButtonPressed = 0;
        }
    }

    public static int method614(int arg1, int arg2, int arg3) {
        int i_7_ = 256 + -arg3;
        return (arg3 * (0xff00 & arg2) + i_7_ * (0xff00 & arg1) & 0xff0000) + (~0xff00ff & (0xff00ff & arg1) * i_7_ + arg3 * (0xff00ff & arg2)) >> 8;
    }

    public static void drawMinimapMark(ImageRGB sprite, int mapX, int mapY) {
        int len = mapX * mapX + mapY * mapY;
        if (len > 4225 && len < 90000) {
            int theta = 0x7ff & GroundItemTile.cameraHorizontal + Class43.cameraYawOffset;
            int sine = Model.SINE[theta];
            int cosine = Model.COSINE[theta];
            sine = sine * 256 / (Class51.mapZoomOffset + 256);
            cosine = cosine * 256 / (Class51.mapZoomOffset + 256);
            int y = cosine * mapY - sine * mapX >> 16;
            int x = mapX * cosine + mapY * sine >> 16;
            double angle = Math.atan2(x, y);
            int drawX = (int) (Math.sin(angle) * 63.0);
            int drawY = (int) (57.0 * Math.cos(angle));
            minimapEdge.drawRotated(-10 + 94 + drawX + 4, 83 + -drawY + -20, 15, 15, 20, 20, 256, angle);
        } else {
            SceneTile.drawOnMinimap(mapY, mapX, sprite);
        }
    }

    /**
     * Processes a new status code
     * @param statusCode Can be one of these values:
     *                 5 = Login background
     *                 10 = Login screen
     *                 20 = Empty login box
     *                 25 = Game overlay
     *                 30 = 3D game area
     *                 40 = Connection lost, attempting to re-establish
     *                 1000 = Client fatal error
     */
    public static void processGameStatus(int statusCode) {
        if (statusCode != Class51.gameStatusCode) {
            if (Class51.gameStatusCode == 0)
                CollisionMap.method144(12433);
            if (statusCode == 20 || statusCode == 40) {
                Main.anInt1756 = 0;
                OverlayDefinition.anInt2321 = 0;
                Class40_Sub3.loginStatus = 0;
            }
            if (statusCode != 20 && statusCode != 40 && PlayerAppearance.lostConnectionSocket != null) {
                PlayerAppearance.lostConnectionSocket.kill();
                PlayerAppearance.lostConnectionSocket = null;
            }
            if (Class51.gameStatusCode == 25 || Class51.gameStatusCode == 40) {
                Class65.method1018();
                Rasterizer.resetPixels();
            }
            if (Class51.gameStatusCode == 25) {
                Class37.anInt874 = 0;
                PacketBuffer.anInt2231 = 1;
                IdentityKit.anInt2591 = 0;
                GameObject.anInt3048 = 1;
                ProducingGraphicsBuffer.anInt1634 = 0;
            }
            if (statusCode == 0 || statusCode == 35) {
                FloorDecoration.method344(-40);
                method440();
                if (ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 == null)
                    ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = createGraphicsBuffer(765, 503, MouseHandler.gameCanvas);
            }
            if (statusCode == 5 || statusCode == 10 || statusCode == 20) {
                ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = null;
                FloorDecoration.method344(-69);
                Item.renderLoginScreen(MouseHandler.gameCanvas, CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
            }
            if (statusCode == 25 || statusCode == 30 || statusCode == 40) {
                ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = null;
                method440();
                Projectile.method763(MouseHandler.gameCanvas, CacheArchive.gameImageCacheArchive);
            }
            Class51.gameStatusCode = statusCode;
            clearScreen = true;
        }
    }

    public static void addActionRow(String string, int menuAction, int firstMenuOperand, int secondMenuOperand, int actionType, String arg6) {
        if (ActorDefinition.menuActionRow < 500) {
            if (arg6.length() <= 0)
                Landscape.menuActionTexts[ActorDefinition.menuActionRow] = string;
            else
                Landscape.menuActionTexts[ActorDefinition.menuActionRow] = string + Native.whitespace + arg6;
            menuActionTypes[ActorDefinition.menuActionRow] = actionType;
            Class33.selectedMenuActions[ActorDefinition.menuActionRow] = menuAction;
            InteractiveObject.firstMenuOperand[ActorDefinition.menuActionRow] = firstMenuOperand;
            Class59.secondMenuOperand[ActorDefinition.menuActionRow] = secondMenuOperand;
            ActorDefinition.menuActionRow++;
        }
    }

    public static int randomNoise(int x, int y) {
        int i = 57 * y + x;
        i ^= i << 13;
        int i_2_ = 1376312589 + (i * i * 15731 + 789221) * i & 0x7fffffff;
        return i_2_ >> 19 & 0xff;
    }


    public static void initializeItemDefinitionCache(CacheArchive definitionCache, boolean arg1, CacheArchive arg2) {
        IdentityKit.membersServer = arg1;
        MovedStatics.aCacheArchive_284 = arg2;
        Class26.aCacheArchive_632 = definitionCache;
        ItemDefinition.count = Class26.aCacheArchive_632.fileLength(10);
    }

    public static int method888(int x, int y) {
        int vertexHeight = -128 + perlinNoise(x + 45365, 91923 + y, 4) - (-(perlinNoise(x + 10294, 37821 + y, 2) - 128 >> 1) + -(-128 + perlinNoise(x, y, 1) >> 2));
        vertexHeight = 35 + (int) (0.3 * (double) vertexHeight);

        if(vertexHeight >= 10) {
            if(vertexHeight > 60)
                vertexHeight = 60;
        } else
            vertexHeight = 10;

        return vertexHeight;
    }

    public static ProducingGraphicsBuffer createGraphicsBuffer(int width, int height, Component component) {
        try {
            ProducingGraphicsBuffer producingGraphicsBuffer = new ProducingGraphicsBuffer_Sub2();
            producingGraphicsBuffer.method1041(13, width, component, height);
            return producingGraphicsBuffer;
        } catch(Throwable throwable) {
            ProducingGraphicsBuffer_Sub1 class68_sub1 = new ProducingGraphicsBuffer_Sub1();
            class68_sub1.method1041(44, width, component, height);
            return class68_sub1;
        }
    }

    public static void method650(int arg1) {
        LinkedList.anInt1073 = arg1;
    }

    public static void method652() {
        for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.peekFirst(); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.pollFirst()) {
            if(class40_sub3.anInt2031 > 0)
                class40_sub3.anInt2031--;
            if(class40_sub3.anInt2031 == 0) {
                if(class40_sub3.anInt2028 < 0 || method459(class40_sub3.anInt2036, class40_sub3.anInt2028)) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2028, class40_sub3.anInt2039, class40_sub3.anInt2036, class40_sub3.anInt2025, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.unlink();
                }
            } else {
                if(class40_sub3.anInt2033 > 0)
                    class40_sub3.anInt2033--;
                if(class40_sub3.anInt2033 == 0 && class40_sub3.anInt2039 >= 1 && class40_sub3.anInt2038 >= 1 && class40_sub3.anInt2039 <= 102 && class40_sub3.anInt2038 <= 102 && (class40_sub3.anInt2017 < 0 || method459(class40_sub3.anInt2030, class40_sub3.anInt2017))) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2017, class40_sub3.anInt2039, class40_sub3.anInt2030, class40_sub3.anInt2035, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.anInt2033 = -1;
                    if(class40_sub3.anInt2028 == class40_sub3.anInt2017 && class40_sub3.anInt2028 == -1)
                        class40_sub3.unlink();
                    else if(class40_sub3.anInt2028 == class40_sub3.anInt2017 && class40_sub3.anInt2025 == class40_sub3.anInt2035 && class40_sub3.anInt2030 == class40_sub3.anInt2036)
                        class40_sub3.unlink();
                }
            }
        }
    }

	public static void logout() {
	    if(gameServerSocket != null) {
	        gameServerSocket.kill();
	        gameServerSocket = null;
	    }
	    RSCanvas.clearCaches();
	    Npc.currentScene.initToNull();
	    int i = 0;
	    for(/**/; i < 4; i++)
	        Landscape.currentCollisionMap[i].reset();
	    System.gc();
	    MusicSystem.method405(10);
	    MusicSystem.songTimeout = 0;
	    MusicSystem.currentSongId = -1;
	    SoundSystem.clearObjectSounds();
	    processGameStatus(10);
	}

	public static ImageRGB method927(int arg0, CacheArchive arg1, boolean arg2, int arg3) {
	    if(!ImageRGB.spriteExists(arg0, arg3, arg1))
	        return null;
	    if(!arg2)
	        MovedStatics.method922(3, -92, null, -119, -82, -28, -32);
	    return ActorDefinition.method578();
	}

	public static void method922(int x, int arg1, Buffer fileData, int y, int regionY, int regionX, int level) {
	    if(x >= 0 && x < 104 && y >= 0 && y < 104) {
	        OverlayDefinition.tile_flags[level][x][y] = (byte) 0;
	        for(; ; ) {
	            int opcode = fileData.getUnsignedByte();
	            if(opcode == 0) {
	                if(level == 0) {
                        tile_height[0][x][y] = -method888(regionX + x + 932731, regionY + 556238 + y) * 8;
                    } else {
                        tile_height[level][x][y] = -240 + tile_height[level + -1][x][y];
                    }

	                break;
	            }
	            if(opcode == 1) {
	                int tileHeight = fileData.getUnsignedByte();
	                if(tileHeight == 1)
	                    tileHeight = 0;
	                if(level != 0)
	                    tile_height[level][x][y] = tile_height[-1 + level][x][y] + -(8 * tileHeight);
	                else
	                    tile_height[0][x][y] = 8 * -tileHeight;
	                break;
	            }
	            if(opcode <= 49) {
	                MouseHandler.tile_overlayids[level][x][y] = fileData.getByte();
	                OverlayDefinition.tile_underlay_path[level][x][y] = (byte) ((opcode + -2) / 4);
	                Class35.tile_overlay_rotation[level][x][y] = (byte) BitUtils.bitWiseAND(arg1 + -2 + opcode, 3);
	            } else if(opcode <= 81)
	                OverlayDefinition.tile_flags[level][x][y] = (byte) (-49 + opcode);
	            else
	                tile_underlayids[level][x][y] = (byte) (-81 + opcode);
	        }
	    } else {
	        for(; ; ) {
	            int i = fileData.getUnsignedByte();
	            if(i == 0)
	                break;
	            if(i == 1) {
	                fileData.getUnsignedByte();
	                break;
	            }
	            if(i <= 49)
	                fileData.getUnsignedByte();
	        }
	    }
	}

	// Area IDs:
	// 0 = Game area (the area that renders in 3D)
	// 1 = Tab area (the widgets that display within the tab area)
	// 2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
	public static void handleInterfaceActions(int areaId, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, GameInterface[] gameInterfaces, int parentId, int scrollPosition, int scrollWidth) {
	    // Only try to handle actions if mouse is within this widget's boundaries
	    if(minX <= mouseX && mouseY >= minY && maxX > mouseX && maxY > mouseY) {
	        for(int i = 0; gameInterfaces.length > i; i++) {
	            GameInterface gameInterface = gameInterfaces[i];
	            if(gameInterface != null && parentId == gameInterface.parentId) {
	                int i_1_ = gameInterface.currentY - (-minY + scrollPosition);
	                int i_2_ = -scrollWidth + gameInterface.currentX + minX;
	                if(gameInterface.type == GameInterfaceType.IF1_TOOLTIP && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_)
	                    Item.anInt3065 = i;
	                if((gameInterface.hoveredSiblingId >= 0 || gameInterface.hoveredTextColor != 0) && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_) {
	                    if(gameInterface.hoveredSiblingId >= 0)
	                        OverlayDefinition.hoveredWidgetChildId = gameInterface.hoveredSiblingId;
	                    else
	                        OverlayDefinition.hoveredWidgetChildId = i;
	                }
	                if(gameInterface.type == GameInterfaceType.LAYER) {
	                    if(!gameInterface.isHidden || Class29.isHovering(areaId, i) || PacketBuffer.hiddenButtonTest) {
	                        handleInterfaceActions(areaId, mouseX, mouseY, i_2_, i_1_, i_2_ + gameInterface.originalWidth, i_1_ + gameInterface.originalHeight, gameInterfaces, i, gameInterface.scrollPosition, gameInterface.scrollWidth);
	                        if(gameInterface.children != null)
	                            handleInterfaceActions(areaId, mouseX, mouseY, i_2_, i_1_, gameInterface.originalWidth + i_2_, i_1_ + gameInterface.originalHeight, gameInterface.children, gameInterface.id, gameInterface.scrollPosition, gameInterface.scrollWidth);
	                        if(gameInterface.originalHeight < gameInterface.scrollHeight)
	                            GameInterface.scrollInterface(gameInterface.originalHeight, mouseY, mouseX, gameInterface.scrollHeight, gameInterface, gameInterface.originalWidth + i_2_, areaId, i_1_);
	                    }
	                } else {
	                    if (Configuration.DEBUG_WIDGETS && gameInterface.type != GameInterfaceType.IF1_TOOLTIP && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && gameInterface.originalHeight + i_1_ > mouseY) {
	                        GenericTile.hoveredWidgetId = gameInterface.id;
	                    }

                        // standard button type? this is used for 'Open House Options'
                        // also used for clickable text (e.g. music list)
	                    if(gameInterface.actionType == 1 && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && gameInterface.originalHeight + i_1_ > mouseY) {
	                        boolean bool = false;

                            // is this text vs not text? contentType is definitely 0 for text on music player
	                        if(gameInterface.contentType != 0)
	                            bool = ProducingGraphicsBuffer_Sub1.method1051(300, gameInterface);

	                        if(!bool) {
	                            addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 42, "");
	                        }
	                    }

                        // spells
	                    if(gameInterface.actionType == 2 && Main.widgetSelected == 0 && mouseX >= i_2_ && mouseY >= i_1_ && mouseX < gameInterface.originalWidth + i_2_ && mouseY < i_1_ + gameInterface.originalHeight) {
	                        addActionRow(gameInterface.targetVerb, 0, 0, gameInterface.id, ActionRowType.SELECT_SPELL_ON_WIDGET.getId(), Native.green + gameInterface.spellName);
	                    }

                        // close button
	                    if(gameInterface.actionType == 3 && mouseX >= i_2_ && mouseY >= i_1_ && i_2_ + gameInterface.originalWidth > mouseX && mouseY < i_1_ + gameInterface.originalHeight) {
	                        int actionType;
	                        if(areaId != 3)
	                            actionType = 9;
	                        else
                                actionType = 40;
	                        addActionRow(English.close, 0, 0, gameInterface.id, actionType, "");
	                    }

                        // toggle varp
	                    if(gameInterface.actionType == 4 && mouseX >= i_2_ && i_1_ <= mouseY && mouseX < gameInterface.originalWidth + i_2_ && gameInterface.originalHeight + i_1_ > mouseY) {
	                        addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, ActionRowType.BUTTON_TOGGLE_VARP.getId(), "");
	                    }

                        // sets the varp to another value (stored in the `alternateRhs` of the button) when clicked
	                    if(gameInterface.actionType == 5 && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && i_1_ + gameInterface.originalHeight > mouseY) {
	                        addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, ActionRowType.BUTTON_SET_VARP_VALUE.getId(), "");
	                    }

	                    if(gameInterface.actionType == 6 && lastContinueTextWidgetId == -1 && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_) {
	                        addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 54, "");
	                    }
	
	                    if(gameInterface.type == GameInterfaceType.INVENTORY) {
	                        int i_4_ = 0;
	                        for(int i_5_ = 0; i_5_ < gameInterface.originalHeight; i_5_++) {
	                            for(int i_6_ = 0; i_6_ < gameInterface.originalWidth; i_6_++) {
	                                int i_7_ = i_6_ * (gameInterface.itemSpritePadsX + 32) + i_2_;
	                                int i_8_ = i_1_ + (32 + gameInterface.itemSpritePadsY) * i_5_;
	                                if(i_4_ < 20) {
	                                    i_7_ += gameInterface.images[i_4_];
	                                    i_8_ += gameInterface.imageX[i_4_];
	                                }
	                                if(mouseX >= i_7_ && i_8_ <= mouseY && i_7_ + 32 > mouseX && mouseY < 32 + i_8_) {
	                                    RSRuntimeException.lastActiveInvInterface = gameInterface.id;
	                                    Class55.mouseInvInterfaceIndex = i_4_;
	                                    if(gameInterface.items[i_4_] > 0) {
	                                        ItemDefinition itemDefinition = ItemDefinition.forId(-1 + gameInterface.items[i_4_], 10);
	                                        if(MovedStatics.itemSelected != 1 || !gameInterface.isInventory) {
	                                            if(Main.widgetSelected == 1 && gameInterface.isInventory) {
	                                                if((ItemDefinition.selectedMask & 0x10) == 16) {
	                                                    addActionRow(Native.selectedSpellVerb, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.CAST_MAGIC_ON_WIDGET_ITEM.getId(), Native.selectedSpellName + Native.toLightRed + itemDefinition.name);
	                                                }
	                                            } else {
	                                                String[] class1s = itemDefinition.interfaceOptions;
	                                                if(Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                                    class1s = getAllOptionsWithIndices(class1s);
	                                                if(gameInterface.isInventory) {
	                                                    for(int i_9_ = 4; i_9_ >= 3; i_9_--) {
	                                                        if(class1s != null && class1s[i_9_] != null) {
	                                                            int actionType;
	                                                            if(i_9_ != 3)
	                                                                actionType = ActionRowType.DROP_ITEM.getId();
	                                                            else
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId();
	                                                            addActionRow(class1s[i_9_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        } else if(i_9_ == 4) {
	                                                            addActionRow(English.drop, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                if(gameInterface.itemUsable) {
	                                                    addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.SELECT_ITEM_ON_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                                                }
	                                                if(gameInterface.isInventory && class1s != null) {
	                                                    for(int i_11_ = 2; i_11_ >= 0; i_11_--) {
	                                                        if(class1s[i_11_] != null) {
	                                                            int actionType = 0;
	                                                            if(i_11_ == 0)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId();
	                                                            if(i_11_ == 1)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId();
	                                                            if(i_11_ == 2)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId();
	                                                            addActionRow(class1s[i_11_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                class1s = gameInterface.configActions;
	                                                if(Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                                    class1s = getAllOptionsWithIndices(class1s);
	                                                if(class1s != null) {
	                                                    for(int i_13_ = 4; i_13_ >= 0; i_13_--) {
	                                                        if(class1s[i_13_] != null) {
	                                                            int actionType = 0;
	                                                            if(i_13_ == 0)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1.getId();
	                                                            if(i_13_ == 1)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2.getId();
	                                                            if(i_13_ == 2)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3.getId();
	                                                            if(i_13_ == 3)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4.getId();
	                                                            if(i_13_ == 4)
	                                                                actionType = ActionRowType.INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5.getId();
	                                                            addActionRow(class1s[i_13_], itemDefinition.id, i_4_, gameInterface.id, actionType, Native.lightRed + itemDefinition.name);
	                                                        }
	                                                    }
	                                                }
	                                                StringBuilder examineText = new StringBuilder();
	                                                examineText.append(MessageFormat.format("<col=ff9040>{0}</col>", itemDefinition.name));
	                                                if (Configuration.DEBUG_CONTEXT) {
	                                                    examineText.append(" <col=00ff00>(</col>");
	                                                    examineText.append(
	                                                            MessageFormat.format("<col=ffffff>{0}</col>",
	                                                                    Integer.toString(itemDefinition.id)
	                                                            )
	                                                    );
	                                                    examineText.append("<col=00ff00>)</col>");
	                                                }
	                                                addActionRow(English.examine, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.EXAMINE_ITEM_ON_V1_WIDGET.getId(), examineText.toString());
	                                            }
	                                        } else if(ISAAC.anInt525 != gameInterface.id || i_4_ != LinkedList.selectedInventorySlot) {
	                                            addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, ActionRowType.USE_ITEM_ON_INVENTORY_ITEM.getId(), Native.selectedItemName + Native.toLightRed + itemDefinition.name);
	                                        }
	                                    }
	                                }
	                                i_4_++;
	                            }
	                        }
	                    }
	                    if(gameInterface.isNewInterfaceFormat && gameInterface.itemId != -1 && mouseX >= i_2_ && mouseY >= i_1_ && mouseX < gameInterface.originalWidth + i_2_ && mouseY < i_1_ + gameInterface.originalHeight) {
	                        ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
	                        if(gameInterface.isInventory) {
	                            String[] class1s = itemDefinition.interfaceOptions;
	                            if(Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS)
	                                class1s = getAllOptionsWithIndices(class1s);
	                            if(class1s == null || class1s[4] == null)
	                                addActionRow(English.drop, itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed +itemDefinition.name);
	                            else
	                                addActionRow(class1s[4], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.DROP_ITEM.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[3] != null)
	                                addActionRow(class1s[3], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[2] != null)
	                                addActionRow(class1s[2], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[1] != null)
	                                addActionRow(class1s[1], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2.getId(), Native.lightRed + itemDefinition.name);
	                            if(class1s != null && class1s[0] != null)
	                                addActionRow(class1s[0], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, ActionRowType.INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1.getId(), Native.lightRed + itemDefinition.name);
	                        }
	                        if(gameInterface.id >= 0)
	                            addActionRow(English.examine, itemDefinition.id, -1, gameInterface.id, ActionRowType.EXAMINE_ITEM_ON_V2_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                        else
	                            addActionRow(English.examine, itemDefinition.id, gameInterface.id & 0x7fff, gameInterface.parentId, ActionRowType.EXAMINE_ITEM_ON_V2_WIDGET.getId(), Native.lightRed + itemDefinition.name);
	                    }
	                    if(gameInterface.hasListeners && gameInterface.aClass1Array2661 != null && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && mouseY < i_1_ + gameInterface.originalHeight) {
	                        String class1 = "";
	                        if(gameInterface.itemId != -1) {
	                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(gameInterface.itemId, 0);
	                            class1 = Native.lightRed + class40_sub5_sub16.name;
	                        }
	                        for(int i_15_ = gameInterface.aClass1Array2661.length - 1; i_15_ >= 0; i_15_--) {
	                            if(gameInterface.aClass1Array2661[i_15_] != null) {
	                                if(gameInterface.id < 0)
	                                    addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0x7fff & gameInterface.id, gameInterface.parentId, 50, class1);
	                                else
	                                    addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0, gameInterface.id, 50, class1);
	                            }
	                        }
	                    }
	                }
	            }
	        }
	    }
	
	}

	public static int modifiedWidgetId = 0;
	public static int cameraOffsetY = 0;

	public static void method211() {
	    ISAAC.aClass9_516.clear();
	    MouseHandler.modelCache.clear();
	    Buffer.rgbImageCache.clear();
	
	}

	public static void setHighMemory() {
	    VertexNormal.lowMemory = false;
	    Scene.lowMemory = false;
	
	}

	public static void animateNpcs() {
	    for(int i = 0; i < Player.npcCount; i++) {
	        int i_0_ = Player.npcIds[i];
	        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_0_];
	        if(class40_sub5_sub17_sub4_sub2 != null)
	            Class13.handleActorAnimation(class40_sub5_sub17_sub4_sub2);
	    }
	
	}

	public static int itemSelected = 0;
	public static ProducingGraphicsBuffer flameLeftBackground;
	public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array296;
	public static FontMetrics fontMetrics;
	public static CacheArchive aCacheArchive_284;
	public static Calendar aCalendar279 = Calendar.getInstance();
	public static int connectionStage = 0;
	public static int anInt292 = 0;
	public static int[] anIntArray297 = new int[5];

	public static void drawMenu(int xOffSet, int yOffSet) {
	    int height = CollisionMap.menuHeight;
	    int width = VertexNormal.menuWidth;
	    int offsetX = InteractiveObject.menuOffsetX - (xOffSet);
	    int offsetY = (-yOffSet) + Main.menuOffsetY;
	    int colour = 0x5d5447;
	    ChatBox.redrawChatbox = true;
	    GameInterface.redrawTabArea = true;
	    Rasterizer.drawFilledRectangleAlpha(offsetX, offsetY, width, height, colour, 120);
	    Rasterizer.drawFilledRectangle(1 + offsetX, 1 + offsetY, -2 + width, 16, 0);
	    Rasterizer.drawUnfilledRectangle(offsetX + 1, 18 + offsetY, -2 + width, -19 + height, 0);
	    TypeFace.fontBold.drawString(English.chooseOption, offsetX + 3, 14 + offsetY, colour);
	    int x = Class13.mouseX - (xOffSet);
	    int y = (-yOffSet) + Landscape.mouseY;
	    if(Projectile.menuScreenArea == 0) {
	        x -= 4;
	        y -= 4;
	    }
	    if(Projectile.menuScreenArea == 1) {
	        y -= 205;
	        x -= 553;
	    }
	    if(Projectile.menuScreenArea == 2) {
	        y -= 357;
	        x -= 17;
	    }
	    for(int action = 0; action < ActorDefinition.menuActionRow; action++) {
	        int actionY = 15 * (-action + ActorDefinition.menuActionRow + -1) + offsetY + 31;
	        int actionColour = 16777215;
	        if(x > offsetX && offsetX + width > x && y > -13 + actionY && actionY + 3 > y)
	            actionColour = 16776960;
	        TypeFace.fontBold.drawShadowedString(Landscape.menuActionTexts[action], offsetX + 3, actionY, true, actionColour);
	    }
	}

	public static void manageTextInputs() {
	    while(method416()) {
	        if(ItemDefinition.anInt2854 == 28) {
	            break;
	        }
	        if(Console.console.consoleOpen) {
	            Console.console.handleInput();
	            break;
	        }
	        if(GameInterface.gameScreenInterfaceId != -1 && HuffmanEncoding.reportAbuseInterfaceID == GameInterface.gameScreenInterfaceId) {
	            if(ItemDefinition.anInt2854 == 85 && Native.reportedName.length() > 0)
	                Native.reportedName = Native.reportedName.substring(0, -1 + Native.reportedName.length());
	            if((Class40_Sub5_Sub15.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && Native.reportedName.length() < 12)
	                Native.reportedName = Native.reportedName + (char) Class59.anInt1388;
	        } else if(ChatBox.messagePromptRaised) {
	            if(ItemDefinition.anInt2854 == 85 && ChatBox.chatMessage.length() > 0) {
	                ChatBox.chatMessage = ChatBox.chatMessage.substring(0, -1 + ChatBox.chatMessage.length());
	                ChatBox.redrawChatbox = true;
	            }
	            if(Player.method793(Class59.anInt1388) && ChatBox.chatMessage.length() < 80) {
	                ChatBox.chatMessage = ChatBox.chatMessage + (char) Class59.anInt1388;
	                ChatBox.redrawChatbox = true;
	            }
	            if(ItemDefinition.anInt2854 == 84) {
	                ChatBox.messagePromptRaised = false;
	                ChatBox.redrawChatbox = true;
	                if(Class37.anInt876 == 1) {
	                    long l = RSString.nameToLong(ChatBox.chatMessage);
	                    addFriend(l);
	                }
	                if(Class37.anInt876 == 2 && Player.friendsCount > 0) {
	                    long l = RSString.nameToLong(ChatBox.chatMessage);
	                    GameShell.method28(l);
	                }
	                if(Class37.anInt876 == 3 && ChatBox.chatMessage.length() > 0) {
	                    SceneCluster.packetBuffer.putPacket(207);
	                    SceneCluster.packetBuffer.putByte(0);
	                    int i = SceneCluster.packetBuffer.currentPosition;
	                    SceneCluster.packetBuffer.putLongBE(PacketBuffer.aLong2241);
	                    ChatBox.filterInput();
	                    ProducingGraphicsBuffer_Sub1.method1052(ChatBox.chatMessage, SceneCluster.packetBuffer);
	                    SceneCluster.packetBuffer.finishVarByte(-i + SceneCluster.packetBuffer.currentPosition);
	                    if(ChatBox.privateChatMode == 2) {
	                        ChatBox.privateChatMode = 1;
	                        redrawChatbox = true;
	                        SceneCluster.packetBuffer.putPacket(32);
	                        SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
	                        SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
	                        SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
	                    }
	                }
	                if(Class37.anInt876 == 4 && anInt1008 < 100) {
	                    long l = RSString.nameToLong(ChatBox.chatMessage);
	                    Class17.method275(l);
	                }
	                if(Class37.anInt876 == 5 && anInt1008 > 0) {
	                    long l = RSString.nameToLong(ChatBox.chatMessage);
	                    method838(l);
	                }
	            }
	        } else if(ChatBox.inputType == 1) {
	            if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
	                ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 1);
	                ChatBox.redrawChatbox = true;
	            }
	            if(HuffmanEncoding.method1027(Class59.anInt1388) && ChatBox.inputMessage.length() < 10) {
	                ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
	                ChatBox.redrawChatbox = true;
	            }
	            if(ItemDefinition.anInt2854 == 84) {
	                if(ChatBox.inputMessage.length() > 0) {
	                    int inputValue = 0;
	                    try {
	                        inputValue = Integer.parseInt(ChatBox.inputMessage);
	                    } catch(Exception _ex) {
	                        /* empty */
	                    }
	                    SceneCluster.packetBuffer.putPacket(238);
	                    SceneCluster.packetBuffer.putIntBE(inputValue);
	                }
	                ChatBox.redrawChatbox = true;
	                ChatBox.inputType = 0;
	            }
	        } else if(ChatBox.inputType == 2) {
	            if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
	                ChatBox.inputMessage = ChatBox.inputMessage.substring(0, -1 + ChatBox.inputMessage.length());
	                ChatBox.redrawChatbox = true;
	            }
	            if((Class40_Sub5_Sub15.method735(Class59.anInt1388) || Class59.anInt1388 == 32) && ChatBox.inputMessage.length() < 12) {
	                ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
	                ChatBox.redrawChatbox = true;
	            }
	            if(ItemDefinition.anInt2854 == 84) {
	                if(ChatBox.inputMessage.length() > 0) {
	                    SceneCluster.packetBuffer.putPacket(86);
	                    SceneCluster.packetBuffer.putLongBE(RSString.nameToLong(ChatBox.inputMessage));
	                }
	                ChatBox.inputType = 0;
	                ChatBox.redrawChatbox = true;
	            }
	        } else if(ChatBox.inputType == 3) {
	            if(ItemDefinition.anInt2854 == 85 && ChatBox.inputMessage.length() > 0) {
	                ChatBox.inputMessage = ChatBox.inputMessage.substring(0, ChatBox.inputMessage.length() - 10);
	                ChatBox.redrawChatbox = true;
	            }
	            if(Player.method793(Class59.anInt1388) && ChatBox.inputMessage.length() < 40) {
	                ChatBox.inputMessage = ChatBox.inputMessage + (char) Class59.anInt1388;
	                ChatBox.redrawChatbox = true;
	            }
	        } else if(GameInterface.chatboxInterfaceId == -1 && GameInterface.fullscreenInterfaceId == -1) {
	            if(ItemDefinition.anInt2854 == 85 && ChatBox.chatboxInput.length() > 0) {
	                ChatBox.chatboxInput = ChatBox.chatboxInput.substring(0, ChatBox.chatboxInput.length() - 1);
	                ChatBox.redrawChatbox = true;
	            }
	            if(Player.method793(Class59.anInt1388) && ChatBox.chatboxInput.length() < 80) {
	                ChatBox.chatboxInput = ChatBox.chatboxInput + (char) Class59.anInt1388;
	                ChatBox.redrawChatbox = true;
	            }
	            if(ItemDefinition.anInt2854 == 84 && ChatBox.chatboxInput.length() > 0) {
	                if(InteractiveObject.playerRights > 1) {
	                    if(ChatBox.chatboxInput.equals(English.commandClientDrop))
	                        Class59.dropClient();
	                    if(ChatBox.chatboxInput.equals(English.commandFpson)) {
	                        InteractiveObject.showFps = true;
	                        ChatBox.inputType = 3;
	                    }
	                    if(ChatBox.chatboxInput.startsWith("::region")) {
	                        for(int qq = 0; qq < 469; qq++) {
	                            if(GameInterface.decodeGameInterface(qq)) {
	                                GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[qq];
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
	                        InteractiveObject.showFps = false;
	                    if(ChatBox.chatboxInput.equals(English.commandNoclip)) {
	                        for(int i = 0; i < 4; i++) {
	                            for(int i_9_ = 1; i_9_ < 103; i_9_++) {
	                                for(int i_10_ = 1; i_10_ < 103; i_10_++)
	                                    Landscape.currentCollisionMap[i].clippingData[i_9_][i_10_] = 0;
	                            }
	                        }
	                    }
	                    if(ChatBox.chatboxInput.equals(English.commandErrorTest) && Class44.modewhere == 2)
	                        throw new RuntimeException();
	                    if(ChatBox.chatboxInput.equals(Native.cmd_hiddenbuttontest))
	                        PacketBuffer.hiddenButtonTest = true;
	                }
	                if(ChatBox.chatboxInput.startsWith(Native.cmd_prefix)) {
	                    SceneCluster.packetBuffer.putPacket(248);
	                    SceneCluster.packetBuffer.putByte(-1 + ChatBox.chatboxInput.length());
	                    SceneCluster.packetBuffer.putString(ChatBox.chatboxInput.substring(2));
	                } else {
	                    int i = 0;
	                    String class1 = ChatBox.chatboxInput.toLowerCase();
	                    int i_11_ = 0;
	                    if(class1.startsWith(English.effectYellow)) {
	                        i_11_ = 0;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectYellow.length());
	                    } else if(class1.startsWith(English.effectRed)) {
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectRed.length());
	                        i_11_ = 1;
	                    } else if(class1.startsWith(English.effectGreen)) {
	                        i_11_ = 2;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGreen.length());
	                    } else if(class1.startsWith(English.effectCyan)) {
	                        i_11_ = 3;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectCyan.length());
	                    } else if(class1.startsWith(English.effectPurple)) {
	                        i_11_ = 4;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectPurple.length());
	                    } else if(class1.startsWith(English.effectWhite)) {
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWhite.length());
	                        i_11_ = 5;
	                    } else if(class1.startsWith(Native.effectFlash1)) {
	                        i_11_ = 6;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.effectFlash1.length());
	                    } else if(class1.startsWith(English.effectFlash2)) {
	                        i_11_ = 7;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectFlash2.length());
	                    } else if(class1.startsWith(English.effectFlash3)) {
	                        i_11_ = 8;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectFlash3.length());
	                    } else if(class1.startsWith(English.effectGlow1)) {
	                        i_11_ = 9;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow1.length());
	                    } else if(class1.startsWith(English.effectGlow2)) {
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow2.length());
	                        i_11_ = 10;
	                    } else if(class1.startsWith(English.effectGlow3)) {
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectGlow3.length());
	                        i_11_ = 11;
	                    }
	                    class1 = ChatBox.chatboxInput.toLowerCase();
	                    if(class1.startsWith(English.effectWave)) {
	                        i = 1;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWave.length());
	                    } else if(class1.startsWith(English.effectWave2)) {
	                        i = 2;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectWave2.length());
	                    } else if(class1.startsWith(English.effectShake)) {
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectShake.length());
	                        i = 3;
	                    } else if(class1.startsWith(Native.effectScroll)) {
	                        i = 4;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(Native.effectScroll.length());
	                    } else if(class1.startsWith(English.effectSlide)) {
	                        i = 5;
	                        ChatBox.chatboxInput = ChatBox.chatboxInput.substring(English.effectSlide.length());
	                    }
	                    SceneCluster.packetBuffer.putPacket(75);
	                    SceneCluster.packetBuffer.putByte(0);
	                    int i_12_ = SceneCluster.packetBuffer.currentPosition;
	                    SceneCluster.packetBuffer.putByte(i_11_);
	                    SceneCluster.packetBuffer.putByte(i);
	                    ChatBox.filterInput();
	                    ProducingGraphicsBuffer_Sub1.method1052(ChatBox.chatboxInput, SceneCluster.packetBuffer);
	                    SceneCluster.packetBuffer.finishVarByte(SceneCluster.packetBuffer.currentPosition + -i_12_);
	                    if(ChatBox.publicChatMode == 2) {
	                        redrawChatbox = true;
	                        ChatBox.publicChatMode = 3;
	                        SceneCluster.packetBuffer.putPacket(32);
	                        SceneCluster.packetBuffer.putByte(ChatBox.publicChatMode);
	                        SceneCluster.packetBuffer.putByte(ChatBox.privateChatMode);
	                        SceneCluster.packetBuffer.putByte(ChatBox.tradeMode);
	                    }
	                }
	                ChatBox.redrawChatbox = true;
	                ChatBox.chatboxInput = "";
	            }
	        }
	    }
	
	}

	private static char VALID_CHARACTERS[] = {' ', 'e', 't', 'a', 'o', 'i', 'h', 'n', 's', 'r', 'd', 'l', 'u', 'm', 'w',
	'c', 'y', 'f', 'g', 'p', 'b', 'v', 'k', 'x', 'j', 'q', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
	'9', ' ', '!', '?', '.', ',', ':', ';', '(', ')', '-', '&', '*', '\\', '\'', '@', '#', '+', '=', '\243',
	'$', '%', '"', '[', ']'};

	public static void method586(int arg0) {
	    ISAAC.cachedActorDefinitions.clear();
	    aClass9_1611.clear();
	    if(arg0 <= 63)
	        English.errorConnectingToServer = null;
	}

	public static NodeCache aClass9_2439 = new NodeCache(64);
	public static int currentCameraPositionH;
	public static int anInt2452 = 0;
	public static int loadingPercent = 0;
	public static int cameraY;

	public static void handleVarPlayers(int varPlayerIndex) {
	    do {
	        AnimationSequence.anInt2480 = pulseCycle;
	        SoundSystem.setObjectSounds();
	        int varPlayerType = VarPlayerDefinition.getDefinition(varPlayerIndex).type;
	        if(varPlayerType != 0) {
	            int varPlayerValue = VarPlayerDefinition.varPlayers[varPlayerIndex];
	            if(varPlayerType == 1) {
	                if(varPlayerValue == 1) {
	                    Rasterizer3D.createPalette(0.9);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.9);
	                }
	                if(varPlayerValue == 2) {
	                    Rasterizer3D.createPalette(0.8);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.8);
	                }
	                if(varPlayerValue == 3) {
	                    Rasterizer3D.createPalette(0.7);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.7);
	                }
	                if(varPlayerValue == 4) {
	                    Rasterizer3D.createPalette(0.6);
	                    ((Class35) Rasterizer3D.interface3).setBrightness(0.6);
	                }
	                GameObject.clearImageCache();
	                clearScreen = true;
	            }
	            if(varPlayerType == 3) {
	                int i_22_ = 0;
	                if(varPlayerValue == 0)
	                    i_22_ = 255;
	                if(varPlayerValue == 1)
	                    i_22_ = 192;
	                if(varPlayerValue == 2)
	                    i_22_ = 128;
	                if(varPlayerValue == 3)
	                    i_22_ = 64;
	                if(varPlayerValue == 4)
	                    i_22_ = 0;
	                if(i_22_ != MusicSystem.musicVolume) {
	                    if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
	                        if(i_22_ == 0) {
	                            MusicSystem.method402(false);
	                            MusicSystem.songTimeout = 0;
	                        } else
	                            MusicSystem.method456(i_22_);
	                    } else {
	                        MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, i_22_, 0, CacheArchive.musicCacheArchive);
	                        MusicSystem.songTimeout = 0;
	                    }
	                    MusicSystem.musicVolume = i_22_;
	                }
	            }
	            if(varPlayerType == 9)
	                Class43.bankInsertMode = varPlayerValue;
	            if(varPlayerType == 10) {
	            	SoundSystem.updateAreaSoundEffectVolume(varPlayerValue);
	            }
	            if(varPlayerType == 8) {
	                ChatBox.redrawChatbox = true;
	                CollisionMap.anInt165 = varPlayerValue;
	            }
	            if(varPlayerType == 4) {
	            	SoundSystem.updateSoundEffectVolume(varPlayerValue);
	            }
	            if(varPlayerType == 6)
	                anInt2280 = varPlayerValue;
	            if(varPlayerType != 5)
	                break;
	            ProducingGraphicsBuffer.oneMouseButton = varPlayerValue;
	        }
	
	        break;
	    } while(false);
	}

	public static String method307(Buffer arg0, int arg1, int arg2) {
	    try {
	        if(arg1 != -1)
	            MovedStatics.aBooleanArray548 = null;
	        int length = arg0.getSmart();
	        if(length > arg2)
	            length = arg2;
	        byte[] chars = new byte[length];
	        arg0.currentPosition += IdentityKit.aHuffmanEncoding_2590.method1023(arg0.buffer, length, 0, chars, arg0.currentPosition, -1);
	        return new String(chars);
	    } catch(Exception exception) {
	        return English.cabbage;
	    }
	}

	public static void method305() {
	//        if(ScreenController.frameMode == ScreenMode.FIXED){
	
	            RSCanvas.chatBoxImageProducer.prepareRasterizer();
	//        }
	        Class44.chatboxBackgroundImage.drawImage(0, 0);
	        chatboxLineOffsets = Rasterizer3D.setLineOffsets(chatboxLineOffsets);
	    }

	public static void method299(int arg1) {
	    int[] is = minimapImage.pixels;
	    int i = is.length;
	    for(int i_0_ = 0; i > i_0_; i_0_++)
	        is[i_0_] = 0;
	    for(int i_1_ = 1; i_1_ < 103; i_1_++) {
	        int i_2_ = 24628 + (-(512 * i_1_) + 52736) * 4;
	        for(int i_3_ = 1; i_3_ < 103; i_3_++) {
	            if((0x18 & OverlayDefinition.tile_flags[arg1][i_3_][i_1_]) == 0)
	                Npc.currentScene.method96(is, i_2_, 512, arg1, i_3_, i_1_);
	            if(arg1 < 3 && (OverlayDefinition.tile_flags[1 + arg1][i_3_][i_1_] & 0x8) != 0)
	                Npc.currentScene.method96(is, i_2_, 512, 1 + arg1, i_3_, i_1_);
	            i_2_ += 4;
	        }
	    }
	    minimapImage.method723();
	    int i_4_ = (-10 + (int) (Math.random() * 20.0) + 238 << 8) + (228 + (int) (Math.random() * 20.0) << 16) + 238 + (int) (20.0 * Math.random()) + -10;
	    int i_5_ = -10 + (int) (20.0 * Math.random()) + 238 << 16;
	    for(int i_6_ = 1; i_6_ < 103; i_6_++) {
	        for(int i_7_ = 1; i_7_ < 103; i_7_++) {
	            if((OverlayDefinition.tile_flags[arg1][i_7_][i_6_] & 0x18) == 0)
	                Actor.method781(1850, arg1, i_7_, i_4_, i_5_, i_6_);
	            if(arg1 < 3 && (0x8 & OverlayDefinition.tile_flags[1 + arg1][i_7_][i_6_]) != 0)
	                Actor.method781(1850, 1 + arg1, i_7_, i_4_, i_5_, i_6_);
	        }
	    }
	    GameObject.minimapHintCount = 0;
	    for(int i_8_ = 0; i_8_ < 104; i_8_++) {
	        for(int i_9_ = 0; i_9_ < 104; i_9_++) {
	            int i_10_ = Npc.currentScene.getFloorDecorationHash(Player.worldLevel, i_8_, i_9_);
	            if(i_10_ != 0) {
	                i_10_ = 0x7fff & i_10_ >> 14;
	                int i_11_ = GameObjectDefinition.getDefinition(i_10_).icon;
	                if(i_11_ >= 0) {
	                    int i_12_ = i_9_;
	                    int i_13_ = i_8_;
	                    if(i_11_ != 22 && i_11_ != 29 && i_11_ != 34 && i_11_ != 36 && i_11_ != 46 && i_11_ != 47 && i_11_ != 48) {
	                        int[][] is_14_ = Landscape.currentCollisionMap[Player.worldLevel].clippingData;
	                        for(int i_15_ = 0; i_15_ < 10; i_15_++) {
	                            int i_16_ = (int) (Math.random() * 4.0);
	                            if(i_16_ == 0 && i_13_ > 0 && i_13_ > -3 + i_8_ && (is_14_[-1 + i_13_][i_12_] & 0x1280108) == 0)
	                                i_13_--;
	                            if(i_16_ == 1 && i_13_ < 103 && i_13_ < i_8_ + 3 && (is_14_[i_13_ + 1][i_12_] & 0x1280180) == 0)
	                                i_13_++;
	                            if(i_16_ == 2 && i_12_ > 0 && i_12_ > -3 + i_9_ && (is_14_[i_13_][i_12_ - 1] & 0x1280102) == 0)
	                                i_12_--;
	                            if(i_16_ == 3 && i_12_ < 103 && 3 + i_9_ > i_12_ && (0x1280120 & is_14_[i_13_][1 + i_12_]) == 0)
	                                i_12_++;
	                        }
	                    }
	                    MouseHandler.minimapHint[GameObject.minimapHintCount] = aClass40_Sub5_Sub14_Sub4Array296[i_11_];
	                    Actor.minimapHintX[GameObject.minimapHintCount] = i_13_;
	                    LinkedList.minimapHintY[GameObject.minimapHintCount] = i_12_;
	                    GameObject.minimapHintCount++;
	                }
	            }
	        }
	    }
	}

	public static boolean[] aBooleanArray548 = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, false};
	public static IndexedImage[] aClass40_Sub5_Sub14_Sub2Array535;
	public static int anInt537 = 0;
	public static boolean membersWorld = false;
	public static boolean accountFlagged = false;
	public static int anInt545;
	public static GameInterface aGameInterface_1887;
	public static int duplicateClickCount = 0;

	public static IndexedImage[] method315() {
	    IndexedImage[] class40_sub5_sub14_sub2s = new IndexedImage[anInt2581];
	    for(int i = 0; anInt2581 > i; i++) {
	        IndexedImage class40_sub5_sub14_sub2 = class40_sub5_sub14_sub2s[i] = new IndexedImage();
	        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
	        class40_sub5_sub14_sub2.maxHeight = GameShell.anInt31;
	        class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[i];
	        class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[i];
	        class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[i];
	        class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[i];
	        class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
	        class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[i];
	    }
	    ActorDefinition.method569();
	    return class40_sub5_sub14_sub2s;
	}

	public static ImageRGB[] method319() {
	    ImageRGB[] class40_sub5_sub14_sub4s = new ImageRGB[anInt2581];
	    for(int i = 0; i < anInt2581; i++) {
	        ImageRGB class40_sub5_sub14_sub4 = class40_sub5_sub14_sub4s[i] = new ImageRGB();
	        class40_sub5_sub14_sub4.maxWidth = ItemDefinition.anInt2846;
	        class40_sub5_sub14_sub4.maxHeight = GameShell.anInt31;
	        class40_sub5_sub14_sub4.offsetX = Class57.anIntArray1347[i];
	        class40_sub5_sub14_sub4.offsetY = Actor.anIntArray3111[i];
	        class40_sub5_sub14_sub4.imageWidth = Class17.anIntArray456[i];
	        class40_sub5_sub14_sub4.imageHeight = Npc.anIntArray3312[i];
	        byte[] is = GroundItemTile.aByteArrayArray1370[i];
	        int i_4_ = class40_sub5_sub14_sub4.imageHeight * class40_sub5_sub14_sub4.imageWidth;
	        class40_sub5_sub14_sub4.pixels = new int[i_4_];
	        for(int i_5_ = 0; i_5_ < i_4_; i_5_++)
	            class40_sub5_sub14_sub4.pixels[i_5_] = Buffer.anIntArray1972[BitUtils.bitWiseAND(255, is[i_5_])];
	    }
	    ActorDefinition.method569();
	    return class40_sub5_sub14_sub4s;
	}

	public static void method311(Component arg1) {
	    arg1.removeKeyListener(Class59.keyFocusListener);
	    arg1.removeFocusListener(Class59.keyFocusListener);
	}

	public static void method450() {
	    if (Player.headIconDrawType == 2) {
	        MovedStatics.method312(2 * ActorDefinition.anInt2404, Class35.anInt1730 + (-Class26.baseY + anInt175 << 7), (ProducingGraphicsBuffer.anInt1637 + -baseX << 7) + Landscape.anInt1170, 4976905);
	        if (ISAAC.anInt522 > -1 && pulseCycle % 20 < 10)
	            aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
	    }
	}

	public static void method312(int arg0, int arg1, int arg2, int arg3) {
	    if(arg2 < 128 || arg1 < 128 || arg2 > 13056 || arg1 > 13056) {
	        Class44.anInt1048 = -1;
	        ISAAC.anInt522 = -1;
	    } else {
	        int i = Class37.getFloorDrawHeight(Player.worldLevel, arg2, arg1) + -arg0;
	        arg1 -= cameraY;
	        i -= SceneCluster.cameraZ;
	        int i_1_ = Model.COSINE[Class26.anInt627];
	        int i_2_ = Model.SINE[Class26.anInt627];
	        arg2 -= Class12.cameraX;
	        int i_3_ = Model.SINE[ProducingGraphicsBuffer_Sub1.anInt2210];
	        int i_4_ = Model.COSINE[ProducingGraphicsBuffer_Sub1.anInt2210];
	        int i_5_ = arg1 * i_3_ + arg2 * i_4_ >> 16;
	        arg1 = i_4_ * arg1 - arg2 * i_3_ >> 16;
	        if(arg3 != 4976905)
	            English.password = null;
	        arg2 = i_5_;
	        i_5_ = i * i_1_ - arg1 * i_2_ >> 16;
	        arg1 = arg1 * i_1_ + i * i_2_ >> 16;
	        i = i_5_;
	        if(arg1 < 50) {
	            Class44.anInt1048 = -1;
	            ISAAC.anInt522 = -1;
	        } else {
	            if(ScreenController.frameMode == ScreenMode.FIXED){
	                ISAAC.anInt522 = 256 + (arg2 << 9) / arg1;
	                Class44.anInt1048 = (i << 9) / arg1 + 167;
	            } else {
	                ISAAC.anInt522 = ScreenController.drawWidth/2 + (arg2 << 9) / arg1;
	                Class44.anInt1048 = (i << 9) / arg1 +  ScreenController.drawHeight/2;
	            }
	
	        }
	    }
	}

	public static void method313() {
	    for(int i = -1; Player.localPlayerCount > i; i++) {
	        int i_6_;
	        if(i == -1)
	            i_6_ = 2047;
	        else
	            i_6_ = Player.trackedPlayerIndices[i];
	        Player class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i_6_];
	        if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.anInt3078 > 0) {
	            class40_sub5_sub17_sub4_sub1.anInt3078--;
	            if(class40_sub5_sub17_sub4_sub1.anInt3078 == 0)
	                class40_sub5_sub17_sub4_sub1.forcedChatMessage = null;
	        }
	    }
	    for(int i_7_ = 0; i_7_ < Player.npcCount; i_7_++) {
	        int i_8_ = Player.npcIds[i_7_];
	        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[i_8_];
	        if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.anInt3078 > 0) {
	            class40_sub5_sub17_sub4_sub2.anInt3078--;
	            if(class40_sub5_sub17_sub4_sub2.anInt3078 == 0)
	                class40_sub5_sub17_sub4_sub2.forcedChatMessage = null;
	        }
	    }
	}

	public static int anInt1856;
	public static int[] anIntArray1847 = new int[2000];
	public static int[] anIntArray1846 = new int[5];
	public static long aLong1841;
}
