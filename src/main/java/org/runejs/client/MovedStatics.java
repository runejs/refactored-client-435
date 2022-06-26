package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.tab.parts.TabParts;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.net.UpdateServer;
import org.runejs.client.net.UpdateServerNode;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.net.ISAAC;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;
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

public class MovedStatics {

    public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[][] anIntArrayArray1435 = new int[104][104];
    public static ProducingGraphicsBuffer tabPieceUpperRight;
    public static boolean aBoolean1444 = false;
    public static int[] anIntArray1445;
    public static LinkedList aLinkedList_2268 = new LinkedList();
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
    public static int anInt2081;
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
    public static Class22 aClass22_189;
    public static int anInt194;
    public static int anInt195 = 1;
    public static int[] chatboxLineOffsets;
    public static int anInt199 = 0;
    public static int anInt200 = 127;
    public static volatile boolean aBoolean1575 = false;
    public static CacheArchive aCacheArchive_1577;
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
    public static int anInt255;
    public static boolean showChatPanelRedrawnText = false;
    public static int[][][] anIntArrayArrayArray262;
    public static int anInt1806;
    public static int lastContinueTextWidgetId = -1;
    public static GameSocket gameServerSocket;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2105;
    public static int[] anIntArray2106 = {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    public static int secondaryCameraVertical = 0;
    public static int anInt2110;
    public static int[] anIntArray2113 = new int[128];
    public static GameInterface aGameInterface_2116;
    public static int anInt2118 = 0;
    public static int placementX;
    public static int onBuildTimePlane = 0;
    public static int anInt1996 = 0;
    public static HashTable aClass23_805;
    public static int anInt813 = 0;
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
    public static NodeCache aClass9_998 = new NodeCache(100);
    public static int anInt1008 = 0;
    public static int anInt1010 = 2;
    public static int[] anIntArray1013;
    public static IndexedImage[] moderatorIcon;
    public static int[] anIntArray2764 = new int[128];
    public static ImageRGB minimapImage;
    public static int msSinceLastUpdate = 0;
    public static long lastUpdateInMillis;

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
            AnimationFrameGroup.loginScreenBox = null;
            Renderable.anIntArray2865 = null;
            Class8.flameLeftBackground = null;
            Class39.aProducingGraphicsBuffer_907 = null;
            GameObjectDefinition.aProducingGraphicsBuffer_2524 = null;
            Class39.aClass40_Sub5_Sub14_Sub4_918 = null;
            Class22.aClass40_Sub5_Sub14_Sub2Array535 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = null;
            MovedStatics.loginBoxGraphics = null;
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = null;
            anIntArray178 = null;
            KeyFocusListener.aProducingGraphicsBuffer_1285 = null;
            Class17.aProducingGraphicsBuffer_463 = null;
            anIntArray1013 = null;
            method405(10);
            GameShell.method19(true);
            ISAAC.aBoolean512 = false;
        }
    }

    public static int[] menuActionTypes = new int[500];
    public static ProducingGraphicsBuffer loginBoxGraphics;
    public static int[] anIntArray889 = new int[128];
    public static int anInt892;
    public static boolean showSidePanelRedrawnText = false;
    public static int[] anIntArray1916 = new int[50];
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
    public static int anInt1923 = 0;

    public static void method445(int arg0) {
        if (CollisionMap.anInt165 != 0) {
            int i = 0;
            if (AnimationFrameGroup.systemUpdateTime != 0)
                i = 1;
            for (int i_1_ = 0; i_1_ < 100; i_1_++) {
                if (ChatBox.chatMessages[i_1_] != null) {
                    int i_2_ = ChatBox.chatTypes[i_1_];
                    String class1 = ChatBox.chatPlayerNames[i_1_];
                    if (class1 != null && class1.startsWith(Native.whiteCrown))
                        class1 = class1.substring(5);
                    if (class1 != null && class1.startsWith(Native.goldCrown))
                        class1 = class1.substring(5);
                    if ((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                        int i_3_ = 329 + -(13 * i);
                        i++;
                        if (Class13.mouseX > 4 && i_3_ + -10 < Landscape.mouseY + -4 && -4 + Landscape.mouseY <= i_3_ + 3) {
                            int i_4_ = 25 + WallDecoration.fontNormal.getStringWidth(English.from + Native.prefixColon + class1 + ChatBox.chatMessages[i_1_]);
                            if (i_4_ > 450)
                                i_4_ = 450;
                            if (Class13.mouseX < 4 + i_4_) {
                                if (InteractiveObject.playerRights >= 1) {
                                    addActionRow(English.reportAbuse, 0, 0, 0, 2028, Native.white + class1);
                                }
                                addActionRow(English.addIgnore, 0, 0, 0, 2051, Native.white + class1);
                                addActionRow(English.addFriend, 0, 0, 0, 2045, Native.white + class1);
                            }
                        }
                        if (i >= 5)
                            return;
                    }
                    if ((i_2_ == 5 || i_2_ == 6) && ChatBox.privateChatMode < 2 && ++i >= 5)
                        return;
                }
            }
            if (arg0 != 9767)
                anInt1923 = 48;
        }
    }

    public static boolean method446(Signlink arg0, int arg1, boolean arg2, byte arg3) {
        if (arg3 != 30)
            Pathfinding.doWalkTo(47, -7, 96, -97, -111, true, -110, 57, -36, -84, -42);
        if (!Class39.method452(arg0, arg2))
            return false;
        if (arg1 > 0)
            RSString.aClass9_1684 = new NodeCache(arg1);
        return true;
    }

    public static void method450(byte arg0) {
        if (Player.headIconDrawType == 2) {
            if (arg0 >= -28)
                method445(-128);
            Class22_Sub1.method312(2 * ActorDefinition.anInt2404, TextureStore.anInt1730 + (-Class26.baseY + anInt175 << 7), (ProducingGraphicsBuffer.anInt1637 + -baseX << 7) + Landscape.anInt1170, 4976905);
            if (ISAAC.anInt522 > -1 && pulseCycle % 20 < 10)
                aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
        }
    }

    public static void method996(int arg0) {
        if (arg0 != 19655)
            English.systemUpdateIn = null;
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

    public static void method997(int arg0) {
        if (arg0 != 47)
            Scene.initiateVertexHeights(-42, (byte) 12, 92, 18, -72);
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

    public static void method1000(boolean arg0) {
        if (arg0) {
            for (Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.next(); class40_sub5_sub17_sub6 != null; class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.method909()) {
                if (Player.worldLevel == class40_sub5_sub17_sub6.anInt3239 && !class40_sub5_sub17_sub6.aBoolean3237) {
                    if (pulseCycle >= class40_sub5_sub17_sub6.anInt3230) {
                        class40_sub5_sub17_sub6.method834(8076, anInt199);
                        if (class40_sub5_sub17_sub6.aBoolean3237)
                            class40_sub5_sub17_sub6.remove();
                        else
                            Npc.currentScene.method134(class40_sub5_sub17_sub6.anInt3239, class40_sub5_sub17_sub6.anInt3244, class40_sub5_sub17_sub6.anInt3235, class40_sub5_sub17_sub6.anInt3231, 60, class40_sub5_sub17_sub6, 0, -1, false);
                    }
                } else
                    class40_sub5_sub17_sub6.remove();
            }
        }
    }

    public static int method546(int arg0) {
        if (!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        if (arg0 != 256)
            anInt2280 = 44;
        int i = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, Class40_Sub5_Sub6.cameraY);
        if (i + -SceneCluster.cameraZ < 800 && (Scene.tileFlags[Player.worldLevel][Class12.cameraX >> 7][Class40_Sub5_Sub6.cameraY >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

    public static void method233(boolean arg0) {
        OverlayDefinition.overlayDefinitionCache.clear();
        if (!arg0)
            method236(null, null, null);
    }

    public static void method236(CacheArchive arg1, CacheArchive arg2, CacheArchive arg3) {
        ClientScriptRunner.aCacheArchive_2162 = arg1;
        aCacheArchive_2364 = arg3;
        AnimationSequence.aCacheArchive_2484 = arg2;
    }

    public static int method368(byte arg0, boolean arg1, boolean arg2) {
        int i = 0;
        if (arg2) {
            i += UpdateServer.anInt464 + UpdateServer.anInt1618;
        }
        if (arg0 != -41) {
            mapDots = null;
        }
        if (arg1) {
            i += UpdateServer.anInt1006 + UpdateServer.anInt554;
        }
        return i;
    }

    public static void method455(int arg0, int arg1, int arg3) {
        for (int i = 0; i < 8; i++) {
            for (int i_0_ = 0; i_0_ < 8; i_0_++)
                Scene.tileHeights[arg1][arg3 + i][arg0 + i_0_] = 0;
        }
        if (arg3 > 0) {
            for (int i = 1; i < 8; i++)
                Scene.tileHeights[arg1][arg3][arg0 + i] = Scene.tileHeights[arg1][-1 + arg3][i + arg0];
        }
        if (arg0 > 0) {
            for (int i = 1; i < 8; i++)
                Scene.tileHeights[arg1][i + arg3][arg0] = Scene.tileHeights[arg1][i + arg3][-1 + arg0];
        }
        if (arg3 > 0 && Scene.tileHeights[arg1][-1 + arg3][arg0] != 0)
            Scene.tileHeights[arg1][arg3][arg0] = Scene.tileHeights[arg1][arg3 - 1][arg0];
        else if (arg0 > 0 && Scene.tileHeights[arg1][arg3][arg0 - 1] != 0)
            Scene.tileHeights[arg1][arg3][arg0] = Scene.tileHeights[arg1][arg3][-1 + arg0];
        else if (arg3 > 0 && arg0 > 0 && Scene.tileHeights[arg1][arg3 + -1][-1 + arg0] != 0)
            Scene.tileHeights[arg1][arg3][arg0] = Scene.tileHeights[arg1][-1 + arg3][arg0 - 1];
    }

    public static void method456(int arg0) {
        if (Class24.method340()) {
            if (Class26.aBoolean618)
                OverlayDefinition.anInt2342 = arg0;
            else
                method651(22741, arg0);
        }
    }

    public static boolean method459(int arg0, int arg1, byte arg2) {
        if (arg0 == 11)
            arg0 = 10;
        if (arg2 < 83)
            method459(125, 22, (byte) 101);
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
        if (arg0 >= 5 && arg0 <= 8)
            arg0 = 4;
        return gameObjectDefinition.method610(arg0, 7533);
    }

    public static IndexedImage method538(int arg0) {
        IndexedImage class40_sub5_sub14_sub2 = new IndexedImage();
        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub2.maxHeight = GameShell.anInt31;
        class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[0];
        class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[0];
        class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[0];
        class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
        class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[arg0];
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

    public static void method335(byte arg0) {
        Projectile projectile = (Projectile) Class43.projectileQueue.next();
        if (arg0 == 61) {
            for (/**/; projectile != null; projectile = (Projectile) Class43.projectileQueue.method909()) {
                if (Player.worldLevel == projectile.anInt2981 && pulseCycle <= projectile.endCycle) {
                    if (projectile.delay <= pulseCycle) {
                        if (projectile.entityIndex > 0) {
                            Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[-1 + projectile.entityIndex];
                            if (class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.worldX >= 0 && class40_sub5_sub17_sub4_sub2.worldX < 13312 && class40_sub5_sub17_sub4_sub2.worldY >= 0 && class40_sub5_sub17_sub4_sub2.worldY < 13312)
                                projectile.trackTarget(pulseCycle, arg0 + -61, class40_sub5_sub17_sub4_sub2.worldY, Class37.getFloorDrawHeight(projectile.anInt2981, class40_sub5_sub17_sub4_sub2.worldX, class40_sub5_sub17_sub4_sub2.worldY) - projectile.endHeight, class40_sub5_sub17_sub4_sub2.worldX);
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
                    projectile.remove();
            }
        }
    }

    public static int method160(int arg0, int arg1, int arg2, int arg3) {
        int i = arg0 & -1 + arg2;
        int i_0_ = arg3 / arg2;
        int i_1_ = arg2 - 1 & arg3;
        int i_2_ = arg0 / arg2;
        int i_3_ = CollisionMap.method157(arg1 + -15177, i_2_, i_0_);
        int i_4_ = CollisionMap.method157(arg1 ^ arg1, 1 + i_2_, i_0_);
        int i_5_ = CollisionMap.method157(0, i_2_, 1 + i_0_);
        int i_6_ = CollisionMap.method157(0, 1 + i_2_, 1 + i_0_);
        int i_7_ = GameShell.method32(i_3_, arg2, i_4_, true, i);
        int i_8_ = GameShell.method32(i_5_, arg2, i_6_, true, i);
        return GameShell.method32(i_7_, arg2, i_8_, true, i_1_);
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

    public static String[] method968(String[] arg0) {
        String[] class1s = new String[5];
        for (int i = 0; i < 5; i++) {
            class1s[i] = i + Native.aClass1_515;
            if (arg0 != null && arg0[i] != null)
                class1s[i] = class1s[i] + arg0[i];
        }
        return class1s;
    }

    public static void method973() {
        Scene.hueMultiplierBuffer = null;
        Scene.saturationBuffer = null;
        Scene.bufferLength = null;
        anIntArrayArrayArray262 = null;
        Scene.tileLightness = null;
        Scene.tileOverlayRotations = null;
        Scene.lightnessBuffer = null;
        Scene.objectShadowData = null;
        Scene.tileUnderlayPaths = null;
        Scene.tileOverlayIds = null;
        Scene.tileUnderlayIds = null;
        Scene.hueBuffer = null;
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
        Class40_Sub5_Sub6.aClass9_2439.clear();
        aClass9_998.clear();
    }

    public static void method399(int arg0, int arg2) {
        long l = (arg0 << 16) + arg2;
        UpdateServerNode updateServerNode = (UpdateServerNode) UpdateServer.queuedFileResponses.getNode(l);
        if (updateServerNode != null) {
            UpdateServer.activeQueuedRequests.unshift(updateServerNode);
        }
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
            AnimationBaseDefinition.method879(Class22.aClass40_Sub5_Sub14_Sub2Array535[i_9_]);
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
        if (Class40_Sub5_Sub6.anInt2452 > 0)
            Class40_Sub5_Sub6.anInt2452 -= 4;
        if (IdentityKit.anInt2613 > 0)
            IdentityKit.anInt2613 -= 4;
        if (Class40_Sub5_Sub6.anInt2452 == 0 && IdentityKit.anInt2613 == 0) {
            int i_15_ = (int) (2000.0 * Math.random());
            if (i_15_ == 0)
                Class40_Sub5_Sub6.anInt2452 = 1024;
            if (i_15_ == 1)
                IdentityKit.anInt2613 = 1024;
        }
    }

    public static void method838(int arg0, long arg1) {
        if (arg1 != 0) {
            for (int i = arg0; i < anInt1008; i++) {
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
    }

    public static ImageRGB[] method526(CacheArchive arg0, String arg2, String arg3) {
        int i = arg0.getHash(arg2);
        int i_4_ = arg0.method179(i, arg3);
        return GenericTile.method944((byte) -3, i, arg0, i_4_);
    }

    public static void method527(int currentTabId, int arg1, int[] tabWidgetIds, boolean arg3, int arg4) {
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
                    TextureStore.aClass40_Sub5_Sub14_Sub2_1744.drawImage(110, 8);
                if (currentTabId == 4)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(153, 8);
                if (currentTabId == 5)
                    WallDecoration.aClass40_Sub5_Sub14_Sub2_1270.drawImage(181, 8);
                if (currentTabId == 6)
                    aClass40_Sub5_Sub14_Sub2_2105.drawImage(209, 9);
            }
            if (tabWidgetIds[0] != -1 && arg4 != 0)
                AnimationFrameGroup.tabIcons[0].drawImage(29, 13);
            if (tabWidgetIds[1] != -1 && arg4 != 1)
                AnimationFrameGroup.tabIcons[1].drawImage(53, 11);
            if (tabWidgetIds[2] != -1 && arg4 != 2)
                AnimationFrameGroup.tabIcons[2].drawImage(82, 11);
            if (tabWidgetIds[3] != -1 && arg4 != 3)
                AnimationFrameGroup.tabIcons[3].drawImage(115, 12);
            if (tabWidgetIds[4] != -1 && arg4 != 4)
                AnimationFrameGroup.tabIcons[4].drawImage(153, 13);
            if (tabWidgetIds[5] != -1 && arg4 != 5)
                AnimationFrameGroup.tabIcons[5].drawImage(180, 11);
            if (tabWidgetIds[6] != -1 && arg4 != 6)
                AnimationFrameGroup.tabIcons[6].drawImage(208, 13);
        }
        RSCanvas.tabBottom.prepareRasterizer();
        tabBottomBack.drawImage(0, 0);
        if (arg1 != 4)
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
                AnimationFrameGroup.tabIcons[7].drawImage(74, 2);
            if (tabWidgetIds[9] != -1 && arg4 != 9)
                AnimationFrameGroup.tabIcons[8].drawImage(102, 3);
            if (tabWidgetIds[10] != -1 && arg4 != 10)
                AnimationFrameGroup.tabIcons[9].drawImage(137, 4);
            if (tabWidgetIds[11] != -1 && arg4 != 11)
                AnimationFrameGroup.tabIcons[10].drawImage(174, 2);
            if (tabWidgetIds[12] != -1 && arg4 != 12)
                AnimationFrameGroup.tabIcons[11].drawImage(201, 2);
            if (tabWidgetIds[13] != -1 && arg4 != 13)
                AnimationFrameGroup.tabIcons[12].drawImage(226, 2);
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

    public static int calculateDataLoaded(int arg1, int arg2) {
        long l = (long) ((arg1 << 16) + arg2);
        if (UpdateServer.activeNode == null || UpdateServer.activeNode.key != l)
            return 0;
        return 1 + UpdateServer.fileDataBuffer.currentPosition * 99 / (UpdateServer.fileDataBuffer.buffer.length + -UpdateServer.activeNode.versionSize);
    }

    public static boolean method416(byte arg0) {
        synchronized (Class59.keyFocusListener) {
            if (Class59.anInt1389 == GenericTile.anInt1214)
                return false;
            ItemDefinition.anInt2854 = anIntArray2113[Class59.anInt1389];
            Class59.anInt1388 = anIntArray2764[Class59.anInt1389];
            if (arg0 > -21)
                English.clickToContinue = null;
            Class59.anInt1389 = Class59.anInt1389 + 1 & 0x7f;
            return true;
        }
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
        if (Class8.itemSelected == 0 && Main.widgetSelected == 0) {
            String tileCoords = "";
            if (Configuration.DEBUG_CONTEXT) {
                tileCoords = MessageFormat.format("<col=8F8FFF>({0}, {1})</col>", Integer.toString(Scene.hoveredTileX + baseX), Integer.toString(Scene.hoveredTileY + Class26.baseY));
            }

            addActionRow(English.walkHere, 0, Class13.mouseX, Landscape.mouseY, 7, tileCoords);
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
                    if (Class8.itemSelected == 1) {
                        addActionRow(English.use, hash, x, y, 5, Native.aClass1_3295 + Native.toCyan + gameObjectDefinition.name);
                    } else if (Main.widgetSelected != 1) {
                        String[] options = gameObjectDefinition.actions;
                        if (Class60.aBoolean1402)
                            options = method968(options);
                        if (options != null) {
                            for (int i_7_ = 4; i_7_ >= 0; i_7_--) {
                                if (options[i_7_] != null) {
                                    int actionType = 0;
                                    if (i_7_ == 0)
                                        actionType = 16;
                                    if (i_7_ == 1)
                                        actionType = 29;
                                    if (i_7_ == 2)
                                        actionType = 17;
                                    if (i_7_ == 3)
                                        actionType = 27;
                                    if (i_7_ == 4)
                                        actionType = 1002;
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
                        addActionRow(English.examine, gameObjectDefinition.id << 14, x, y, 1004, examineText.toString());
                    } else if ((ItemDefinition.selectedMask & 0x4) == 4) {
                        addActionRow(Native.aClass1_1918, hash, x, y, 32, Native.aClass1_611 + Native.toCyan + gameObjectDefinition.name);
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
                        for (Item item = (Item) itemList.last(); item != null; item = (Item) itemList.previous()) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(item.itemId, 10);
                            if (Class8.itemSelected == 1) {
                                addActionRow(English.use, item.itemId, x, y, 47, Native.aClass1_3295 + Native.toLightRed + itemDefinition.name);
                            } else if (Main.widgetSelected != 1) {
                                String[] class1s = itemDefinition.groundOptions;
                                if (Class60.aBoolean1402)
                                    class1s = method968(class1s);
                                for (int i_15_ = 4; i_15_ >= 0; i_15_--) {
                                    if (class1s == null || class1s[i_15_] == null) {
                                        if (i_15_ == 2) {
                                            addActionRow(English.take, item.itemId, x, y, 3, Native.lightRed + itemDefinition.name);
                                        }
                                    } else {
                                        int i_16_ = 0;
                                        if (i_15_ == 0)
                                            i_16_ = 2;
                                        if (i_15_ == 1)
                                            i_16_ = 38;
                                        if (i_15_ == 2)
                                            i_16_ = 3;
                                        if (i_15_ == 3)
                                            i_16_ = 8;
                                        if (i_15_ == 4)
                                            i_16_ = 36;
                                        addActionRow(class1s[i_15_], item.itemId, x, y, i_16_, Native.lightRed +  itemDefinition.name);
                                    }
                                }
                                addActionRow(English.examine, item.itemId, x, y, 1003, Native.lightRed + itemDefinition.name);
                            } else if ((0x1 & ItemDefinition.selectedMask) == 1) {
                                addActionRow(Native.aClass1_1918, item.itemId, x, y, 15, Native.aClass1_611 + Native.toLightRed + itemDefinition.name);
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

    public static synchronized void method405(int arg1) {
        if(Class24.method340()) {
            method557(arg1);
            Class22_Sub1.musicCacheArchive = null;
            Class26.aBoolean618 = false;
        }
    }

    public static void method557(int arg0) {
        method886(0, 0, false, null, arg0);
    }

    public static int method884(int arg0, int arg1) {
        int i = 57 * arg1 + arg0;
        i ^= i << 13;
        int i_2_ = 1376312589 + (i * i * 15731 + 789221) * i & 0x7fffffff;
        return i_2_ >> 19 & 0xff;
    }

    public static void method885(CacheArchive arg0, boolean arg1, CacheArchive arg2) {
        IdentityKit.membersServer = arg1;
        Class8.aCacheArchive_284 = arg2;
        Class26.aCacheArchive_632 = arg0;
        ItemDefinition.count = Class26.aCacheArchive_632.fileLength(10);
    }

    public static void method886(int arg0, int arg1, boolean arg2, byte[] arg3, int arg4) {
        if(arg0 == 0 && aClass22_189 != null) {
            if(MouseHandler.anInt1450 < 0) {
                if(RSCanvas.anInt54 != 0) {
                    PacketBuffer.anInt2258 = arg1;
                    Player.aByteArray3270 = arg3;
                    PlayerAppearance.aBoolean687 = arg2;
                } else
                    RSString.method56(arg2, arg3, arg1);
            } else {
                Buffer.anInt1982 = arg4;
                if(MouseHandler.anInt1450 != 0) {
                    int i = Class29.method372(arg0 ^ 0x60, MouseHandler.anInt1450);
                    i -= Class39.anInt909;
                    RSCanvas.anInt54 = (i + 3600) / arg4;
                    if(RSCanvas.anInt54 < 1)
                        RSCanvas.anInt54 = 1;
                } else
                    RSCanvas.anInt54 = 1;
                PacketBuffer.anInt2258 = arg1;
                Player.aByteArray3270 = arg3;
                PlayerAppearance.aBoolean687 = arg2;
            }
        }
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

    public static void method651(int arg0, int arg1) {
        if(aClass22_189 != null) {
            if(RSCanvas.anInt54 != 0) {
                if(Player.aByteArray3270 != null)
                    PacketBuffer.anInt2258 = arg1;
            } else if(MouseHandler.anInt1450 >= 0) {
                MouseHandler.anInt1450 = arg1;
                aClass22_189.method304((byte) -111, arg1, 0);
            }
            if(arg0 != 22741)
                method652();
        }
    }

    public static void method652() {
        for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.next(); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method909()) {
            if(class40_sub3.anInt2031 > 0)
                class40_sub3.anInt2031--;
            if(class40_sub3.anInt2031 == 0) {
                if(class40_sub3.anInt2028 < 0 || method459(class40_sub3.anInt2036, class40_sub3.anInt2028, (byte) 103)) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2028, class40_sub3.anInt2039, class40_sub3.anInt2036, class40_sub3.anInt2025, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.remove();
                }
            } else {
                if(class40_sub3.anInt2033 > 0)
                    class40_sub3.anInt2033--;
                if(class40_sub3.anInt2033 == 0 && class40_sub3.anInt2039 >= 1 && class40_sub3.anInt2038 >= 1 && class40_sub3.anInt2039 <= 102 && class40_sub3.anInt2038 <= 102 && (class40_sub3.anInt2017 < 0 || method459(class40_sub3.anInt2030, class40_sub3.anInt2017, (byte) 106))) {
                    GenericTile.method945(class40_sub3.anInt2038, class40_sub3.anInt2017, class40_sub3.anInt2039, class40_sub3.anInt2030, class40_sub3.anInt2035, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.anInt2033 = -1;
                    if(class40_sub3.anInt2028 == class40_sub3.anInt2017 && class40_sub3.anInt2028 == -1)
                        class40_sub3.remove();
                    else if(class40_sub3.anInt2028 == class40_sub3.anInt2017 && class40_sub3.anInt2025 == class40_sub3.anInt2035 && class40_sub3.anInt2030 == class40_sub3.anInt2036)
                        class40_sub3.remove();
                }
            }
        }
    }

    public static int hslToInt(int hue, int saturation, int lightness) {
        if(saturation > 179)
            lightness /= 2;
        if(saturation > 192)
            lightness /= 2;
        if(saturation > 217)
            lightness /= 2;
        if(saturation > 243)
            lightness /= 2;
        return saturation / 2 + (lightness / 32 << 7) + (hue / 4 << 10);
    }

}
