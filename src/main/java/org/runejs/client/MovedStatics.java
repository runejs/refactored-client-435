package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceArea;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.frame.Minimap;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
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
import org.runejs.client.scene.*;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;
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
    public static int[] anIntArray1445;
    public static ProducingGraphicsBuffer chatboxRight;
    public static int anInt2280 = 0;
    public static int chatEffectsDisabled = 0;
    public static int anInt321 = 5063219;
    public static boolean redrawChatbox = false;
    public static CacheArchive aCacheArchive_654;
    public static int[] anIntArray666 = new int[]{1, 0, -1, 0};
    public static int pulseCycle = 0;
    public static int anInt938 = 500;
    public static boolean aBoolean2083 = false;
    public static ProducingGraphicsBuffer tabImageProducer;
    /**
     * The image used for the highlighted (selected) tab button,
     * for one of the tabs on the left-hand side of the bottom,
     * but not the furthest-left (see `tabHighlightImageBottomLeftEdge` for that).
     */
    public static IndexedImage tabHighlightImageBottomLeft;
    public static boolean aBoolean565 = false;
    public static boolean aBoolean571;
    public static int anInt573 = -1;
    public static boolean menuOpen = false;
    public static volatile long aLong174 = 0L;

    /**
     * Position of the hint icon in world coordinates (e.g. 3222,3222).
     */
    public static int hintIconPosY = 0;
    public static int[] anIntArray178;
    public static int[] chatboxLineOffsets;
    public static int anInt199 = 0;
    public static volatile boolean aBoolean1575 = false;
    public static CacheArchive aCacheArchive_1577;
    public static int anInt1586 = -1;
    public static boolean reportMutePlayer = false;
    public static int anInt1607 = 10;
    public static NodeCache aClass9_1611 = new NodeCache(50);
    public static long[] tickSamples = new long[32];
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-left tab on the top row.
     */
    public static IndexedImage tabHighlightImageTopLeftEdge;
    public static IndexedImage tabBottomBack;
    /**
     * Up/down arrow images for the scrollbar.
     */
    public static IndexedImage[] scrollbarArrowImages;
    public static NodeCache modelCache = new NodeCache(260);
    public static boolean showChatPanelRedrawnText = false;
    public static int lastContinueTextWidgetId = -1;
    public static GameSocket gameServerSocket;
    public static int[][][] tile_height = new int[4][105][105];
    /**
     * The image used for the highlighted (selected) tab button,
     * for the furthest-right tab on the top row.
     */
    public static IndexedImage tabHighlightImageTopRightEdge;
    /**
     * The overhead chat colours in RGB.
     *
     * Yellow, Red, Green, Cyan, Purple, White
     */
    public static int[] OVERHEAD_CHAT_COLORS = {16776960, 16711680, 65280, 65535, 16711935, 16777215};
    public static int[] anIntArray2113 = new int[128];
    public static GameInterface aGameInterface_2116;
    public static int anInt2118 = 0;
    public static int placementX;
    public static int onBuildTimePlane = 0;
    public static int anInt1996 = 0;
    public static HashTable aClass23_805;
    public static int anInt848 = 0;
    public static int[] anIntArray852;
    public static long aLong853;
    public static int anInt854 = -1;
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
    /**
     * The hint (arrow) icon sprites.
     */
    public static ImageRGB[] hintIconSprites;
    public static int anInt2581;
    public static CacheArchive aCacheArchive_2582;
    public static ImageRGB minimapEdge;
    /**
     * Images for scenery on the minimap (e.g. trees, ladders, etc)
     */
    public static IndexedImage[] mapSceneIcons;
    public static int baseX;
    public static NodeCache aClass9_998 = new NodeCache(100);
    public static int anInt1008 = 0;
    public static int[] anIntArray1013;
    public static IndexedImage[] moderatorIcon;
    public static int[] anIntArray2764 = new int[128];
    public static int imageMaxHeight;
    public static IndexedImage inventoryBackgroundImage;
    public static int hoveredWidgetId = -1;
    public static int[] anIntArray1564 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static ProducingGraphicsBuffer chatModes;
    public static int anInt1545 = 0;
    public static int[] sidebarOffsets;
    public static int menuActionRow = 0;
    /**
     * Draw height of the icon in 3d positions.
     */
    public static int hintIconPosZ = 0;
    public static int anInt2183 = 0;
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2524;

    public static void method440() {
        if (ISAAC.aBoolean512) {
            Class51.anIntArray1198 = null;
            GameObject.flameRightBackground = null;
            ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = null;
            Class51.aProducingGraphicsBuffer_1206 = null;
            Landscape.anIntArray1168 = null;
            SpotAnim.anIntArray3255 = null;
            Class59.imgLoginScreenButton = null;
            anIntArray1445 = null;
            Class40_Sub5_Sub15.loginScreenBox = null;
            Renderable.anIntArray2865 = null;
            MovedStatics.flameLeftBackground = null;
            Class39.aProducingGraphicsBuffer_907 = null;
            aProducingGraphicsBuffer_2524 = null;
            Class39.aClass40_Sub5_Sub14_Sub4_918 = null;
            MovedStatics.aClass40_Sub5_Sub14_Sub2Array535 = null;
            SpotAnim.anIntArray3248 = null;
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
    public static boolean showSidePanelRedrawnText = false;
    /**
     * The image used for the highlighted (selected) tab button,
     * for the central tab on the bottom row.
     */
    public static IndexedImage tabHighlightImageBottomMiddle;

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
                        if (MouseHandler.mouseX > 4 && i_3_ + -10 < MouseHandler.mouseY + -4 && -4 + MouseHandler.mouseY <= i_3_ + 3) {
                            int i_4_ = 25 + WallDecoration.fontNormal.getStringWidth(English.from + Native.prefixColon + username + ChatBox.chatMessages[i_1_]);
                            if (i_4_ > 450)
                                i_4_ = 450;
                            if (MouseHandler.mouseX < 4 + i_4_) {
                                int actionRowOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
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
            inventoryBackgroundImage.drawImage(0, 0);

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


        sidebarOffsets = Rasterizer3D.setLineOffsets(sidebarOffsets);
    }

    public static void method997() {
        // (Jameskmonger) I think this is something to do with keycode remapping, though Im not sure
        if (Signlink.javaVendor.toLowerCase().indexOf("microsoft") == -1) {
            anIntArray1564[44] = 71;
            anIntArray1564[45] = 26;
            anIntArray1564[46] = 72;
            anIntArray1564[47] = 73;
            anIntArray1564[59] = 57;
            anIntArray1564[61] = 27;
            anIntArray1564[91] = 42;
            anIntArray1564[92] = 74;
            anIntArray1564[93] = 43;
            if (Signlink.aMethod729 == null) {
                anIntArray1564[192] = 58;
                anIntArray1564[222] = 59;
            } else {
                anIntArray1564[192] = 28;
                anIntArray1564[222] = 58;
                anIntArray1564[520] = 59;
            }
        } else {
            anIntArray1564[186] = 57;
            anIntArray1564[187] = 27;
            anIntArray1564[188] = 71;
            anIntArray1564[189] = 26;
            anIntArray1564[190] = 72;
            anIntArray1564[191] = 73;
            anIntArray1564[192] = 58;
            anIntArray1564[219] = 42;
            anIntArray1564[220] = 74;
            anIntArray1564[221] = 43;
            anIntArray1564[222] = 59;
            anIntArray1564[223] = 28;
        }

    }

    public static void initiateVertexHeights(int offsetY, int sizeY, int sizeX, int offsetX) {
        for (int y = offsetY; y <= offsetY + sizeY; y++) {
            for (int x = offsetX; sizeX + offsetX >= x; x++) {
                if (x >= 0 && x < 104 && y >= 0 && y < 104) {
                    Landscape.tileShadowIntensity[0][x][y] = (byte) 127;
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

    public static void renderSpotAnims() {
        for (SpotAnim spotAnim = (SpotAnim) Class57.aLinkedList_1332.peekFirst(); spotAnim != null; spotAnim = (SpotAnim) Class57.aLinkedList_1332.pollFirst()) {
            if (Player.worldLevel == spotAnim.plane && !spotAnim.animationFinished) {
                if (pulseCycle >= spotAnim.startCycle) {
                    spotAnim.method834(anInt199);
                    if (spotAnim.animationFinished)
                        spotAnim.unlink();
                    else
                        Npc.currentScene.method134(spotAnim.plane, spotAnim.x, spotAnim.y, spotAnim.z, 60, spotAnim, 0, -1, false);
                }
            } else
                spotAnim.unlink();
        }
    }

    /**
     * get cutscene camera plane?
     */
    public static int method546() {
        if (!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }

        Point3d cameraPos = Main.cutsceneCamera.getPosition();

        int i = Scene.getFloorDrawHeight(Player.worldLevel, cameraPos.x, cameraPos.y);
        if (i + -cameraPos.z < 800 && (OverlayDefinition.tile_flags[Player.worldLevel][cameraPos.x >> 7][cameraPos.y >> 7] & 0x4) != 0)
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
        class40_sub5_sub14_sub2.maxWidth = ItemDefinition.imageMaxWidth;
        class40_sub5_sub14_sub2.maxHeight = imageMaxHeight;
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

    public static void renderProjectiles() {
        Projectile projectile = (Projectile) Class43.projectileQueue.peekFirst();
        for (/**/; projectile != null; projectile = (Projectile) Class43.projectileQueue.pollFirst()) {
            if (Player.worldLevel == projectile.anInt2981 && pulseCycle <= projectile.endCycle) {
                if (projectile.delay <= pulseCycle) {
                    if (projectile.entityIndex > 0) {
                        Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[-1 + projectile.entityIndex];
                        if (class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.worldX >= 0 && class40_sub5_sub17_sub4_sub2.worldX < 13312 && class40_sub5_sub17_sub4_sub2.worldY >= 0 && class40_sub5_sub17_sub4_sub2.worldY < 13312)
                            projectile.trackTarget(pulseCycle, 61 + -61, class40_sub5_sub17_sub4_sub2.worldY, Scene.getFloorDrawHeight(projectile.anInt2981, class40_sub5_sub17_sub4_sub2.worldX, class40_sub5_sub17_sub4_sub2.worldY) - projectile.endHeight, class40_sub5_sub17_sub4_sub2.worldX);
                    }
                    if (projectile.entityIndex < 0) {
                        int i = -1 + -projectile.entityIndex;
                        Player class40_sub5_sub17_sub4_sub1;
                        if (i != PlayerAppearance.anInt708)
                            class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i];
                        else
                            class40_sub5_sub17_sub4_sub1 = Player.localPlayer;
                        if (class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.worldX >= 0 && class40_sub5_sub17_sub4_sub1.worldX < 13312 && class40_sub5_sub17_sub4_sub1.worldY >= 0 && class40_sub5_sub17_sub4_sub1.worldY < 13312)
                            projectile.trackTarget(pulseCycle, 0, class40_sub5_sub17_sub4_sub1.worldY, Scene.getFloorDrawHeight(projectile.anInt2981, class40_sub5_sub17_sub4_sub1.worldX, class40_sub5_sub17_sub4_sub1.worldY) - projectile.endHeight, class40_sub5_sub17_sub4_sub1.worldX);
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
        int i1 = interpolateForPerlin(a, scale, b, true, muX);
        int i2 = interpolateForPerlin(c, scale, d, true, muX);
        return interpolateForPerlin(i1, scale, i2, true, muY);
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
        ItemDefinition.imageMaxWidth = buffer.getUnsignedShortBE();
        imageMaxHeight = buffer.getUnsignedShortBE();
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

    public static void method527(int currentTabId, int[] tabWidgetIds, boolean arg3, int arg4) {
        InteractiveObject.tabTop.prepareRasterizer();
        Buffer.tabTopBack.drawImage(0, 0);
        if (arg3) {
            if (tabWidgetIds[currentTabId] != -1) {
                if (currentTabId == 0)
                    tabHighlightImageTopLeftEdge.drawImage(22, 10);
                if (currentTabId == 1)
                    GameInterface.tabHighlightImageTopLeft.drawImage(54, 8);
                if (currentTabId == 2)
                    GameInterface.tabHighlightImageTopLeft.drawImage(82, 8);
                if (currentTabId == 3)
                    Class35.tabHighlightImageTopMiddle.drawImage(110, 8);
                if (currentTabId == 4)
                    WallDecoration.tabHighlightImageTopRight.drawImage(153, 8);
                if (currentTabId == 5)
                    WallDecoration.tabHighlightImageTopRight.drawImage(181, 8);
                if (currentTabId == 6)
                    tabHighlightImageTopRightEdge.drawImage(209, 9);
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
                    Renderable.tabHighlightImageBottomLeftEdge.drawImage(42, 0);
                if (currentTabId == 8)
                    tabHighlightImageBottomLeft.drawImage(74, 0);
                if (currentTabId == 9)
                    tabHighlightImageBottomLeft.drawImage(102, 0);
                if (currentTabId == 10)
                    tabHighlightImageBottomMiddle.drawImage(130, 1);
                if (currentTabId == 11)
                    Class13.tabHighlightImageBottomRight.drawImage(173, 0);
                if (currentTabId == 12)
                    Class13.tabHighlightImageBottomRight.drawImage(201, 0);
                if (currentTabId == 13)
                    ISAAC.tabHighlightImageBottomRightEdge.drawImage(229, 0);
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

    public static void method1013() {
        int lasthash = -1;
        if (MovedStatics.itemSelected == 0 && Main.widgetSelected == 0) {
            String tileCoords = "";
            if (Configuration.DEBUG_CONTEXT) {
                tileCoords = MessageFormat.format("<col=8F8FFF>({0}, {1})</col>", Integer.toString(Scene.hoveredTileX + baseX), Integer.toString(Scene.hoveredTileY + Class26.baseY));
            }

            addActionRow(English.walkHere, 0, MouseHandler.mouseX, MouseHandler.mouseY, ActionRowType.WALK_HERE.getId(), tileCoords);
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
                                processNpcMenuOptions(npc1.actorDefinition, x, y, Player.npcIds[i_9_]);
                        }
                        for (int i_11_ = 0; i_11_ < Player.localPlayerCount; i_11_++) {
                            Player player = Player.trackedPlayers[Player.trackedPlayerIndices[i_11_]];
                            if (player != null && npc.worldX == player.worldX && player.worldY == npc.worldY)
                                Player.processPlayerMenuOptions(player, x, y, Player.trackedPlayerIndices[i_11_]);
                        }
                    }
                    processNpcMenuOptions(npc.actorDefinition, x, y, index);
                }
                if (type == 0) {
                    Player player1 = Player.trackedPlayers[index];
                    if ((0x7f & player1.worldX) == 64 && (0x7f & player1.worldY) == 64) {
                        for (int i_12_ = 0; i_12_ < Player.npcCount; i_12_++) {
                            Npc npc = Player.npcs[Player.npcIds[i_12_]];
                            if (npc != null && npc.actorDefinition.boundaryDimension == 1 && npc.worldX == player1.worldX && npc.worldY == player1.worldY)
                                processNpcMenuOptions(npc.actorDefinition, x, y, Player.npcIds[i_12_]);
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

    public static int method614(int arg1, int arg2, int arg3) {
        int i_7_ = 256 + -arg3;
        return (arg3 * (0xff00 & arg2) + i_7_ * (0xff00 & arg1) & 0xff0000) + (~0xff00ff & (0xff00ff & arg1) * i_7_ + arg3 * (0xff00ff & arg2)) >> 8;
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
                Main.loginStatus = 0;
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
                Main.anInt874 = 0;
                PacketBuffer.anInt2231 = 1;
                Main.anInt2591 = 0;
                GameObject.anInt3048 = 1;
                ProducingGraphicsBuffer.anInt1634 = 0;
            }
            if (statusCode == 0 || statusCode == 35) {
                method344(-40);
                method440();
                if (ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 == null)
                    ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = createGraphicsBuffer(765, 503, MouseHandler.gameCanvas);
            }
            if (statusCode == 5 || statusCode == 10 || statusCode == 20) {
                ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213 = null;
                method344(-69);
                Class60.renderLoginScreen(MouseHandler.gameCanvas, CacheArchive.huffmanCacheArchive, CacheArchive.gameImageCacheArchive);
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
        if (menuActionRow < 500) {
            if (arg6.length() <= 0)
                Landscape.menuActionTexts[menuActionRow] = string;
            else
                Landscape.menuActionTexts[menuActionRow] = string + Native.whitespace + arg6;
            menuActionTypes[menuActionRow] = actionType;
            Class33.selectedMenuActions[menuActionRow] = menuAction;
            InteractiveObject.firstMenuOperand[menuActionRow] = firstMenuOperand;
            Class59.secondMenuOperand[menuActionRow] = secondMenuOperand;
            menuActionRow++;
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
                    method945(class40_sub3.anInt2038, class40_sub3.anInt2028, class40_sub3.anInt2039, class40_sub3.anInt2036, class40_sub3.anInt2025, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
                    class40_sub3.unlink();
                }
            } else {
                if(class40_sub3.anInt2033 > 0)
                    class40_sub3.anInt2033--;
                if(class40_sub3.anInt2033 == 0 && class40_sub3.anInt2039 >= 1 && class40_sub3.anInt2038 >= 1 && class40_sub3.anInt2039 <= 102 && class40_sub3.anInt2038 <= 102 && (class40_sub3.anInt2017 < 0 || method459(class40_sub3.anInt2030, class40_sub3.anInt2017))) {
                    method945(class40_sub3.anInt2038, class40_sub3.anInt2017, class40_sub3.anInt2039, class40_sub3.anInt2030, class40_sub3.anInt2035, 103, class40_sub3.anInt2027, class40_sub3.anInt2018);
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

	public static ImageRGB method927(int arg0, CacheArchive arg1, int arg3) {
	    if(!ImageRGB.spriteExists(arg0, arg3, arg1))
	        return null;
	    return ActorDefinition.method578();
	}

    public static void handleInterfaceActions(GameInterfaceArea area, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, GameInterface[] gameInterfaces, int parentId, int scrollPosition, int scrollWidth) {
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
                        int areaId = area.getId();

	                    if(!gameInterface.isHidden || GameInterface.isHovering(areaId, i) || PacketBuffer.hiddenButtonTest) {
	                        handleInterfaceActions(area, mouseX, mouseY, i_2_, i_1_, i_2_ + gameInterface.originalWidth, i_1_ + gameInterface.originalHeight, gameInterfaces, i, gameInterface.scrollPosition, gameInterface.scrollWidth);
	                        if(gameInterface.children != null)
	                            handleInterfaceActions(area, mouseX, mouseY, i_2_, i_1_, gameInterface.originalWidth + i_2_, i_1_ + gameInterface.originalHeight, gameInterface.children, gameInterface.id, gameInterface.scrollPosition, gameInterface.scrollWidth);
	                        if(gameInterface.originalHeight < gameInterface.scrollHeight)
	                            GameInterface.scrollInterface(gameInterface.originalHeight, mouseY, mouseX, gameInterface.scrollHeight, gameInterface, gameInterface.originalWidth + i_2_, areaId, i_1_);
	                    }
	                } else {
	                    if (Configuration.DEBUG_WIDGETS && gameInterface.type != GameInterfaceType.IF1_TOOLTIP && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && gameInterface.originalHeight + i_1_ > mouseY) {
	                        hoveredWidgetId = gameInterface.id;
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
	                        if(area != GameInterfaceArea.PERMANENT_CHAT_BOX_WIDGET)
	                            actionType = ActionRowType.CLOSE_WIDGET.getId();
	                        else
                                actionType = ActionRowType.CLOSE_PERMANENT_CHATBOX_WIDGET.getId();
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

                        // "Please wait..." buttons
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
	                                    Main.mouseInvInterfaceIndex = i_4_;
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
    /**
     * Images for function icons on the minimap (e.g. quests, instructors)
     */
	public static ImageRGB[] mapFunctionIcons;
	public static FontMetrics fontMetrics;
	public static CacheArchive aCacheArchive_284;
	public static Calendar aCalendar279 = Calendar.getInstance();
	public static int connectionStage = 0;
	public static int anInt292 = 0;

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
	    int x = MouseHandler.mouseX - (xOffSet);
	    int y = (-yOffSet) + MouseHandler.mouseY;
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
	    for(int action = 0; action < menuActionRow; action++) {
	        int actionY = 15 * (-action + menuActionRow + -1) + offsetY + 31;
	        int actionColour = 16777215;
	        if(x > offsetX && offsetX + width > x && y > -13 + actionY && actionY + 3 > y)
	            actionColour = 16776960;
	        TypeFace.fontBold.drawShadowedString(Landscape.menuActionTexts[action], offsetX + 3, actionY, true, actionColour);
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
	public static int anInt2452 = 0;
	public static int loadingPercent = 0;

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
	                int newMusicVolume = 0;
	                if(varPlayerValue == 0)
	                    newMusicVolume = 255;
	                if(varPlayerValue == 1)
	                    newMusicVolume = 192;
	                if(varPlayerValue == 2)
	                    newMusicVolume = 128;
	                if(varPlayerValue == 3)
	                    newMusicVolume = 64;
	                if(varPlayerValue == 4)
	                    newMusicVolume = 0;
	                if(newMusicVolume != MusicSystem.musicVolume) {
	                    if(MusicSystem.musicVolume != 0 || MusicSystem.currentSongId == -1) {
	                        if(newMusicVolume == 0) {
	                            MusicSystem.method402(false);
	                            MusicSystem.songTimeout = 0;
	                        } else
	                            MusicSystem.method456(newMusicVolume);
	                    } else {
	                        MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, newMusicVolume, 0, CacheArchive.musicCacheArchive);
	                        MusicSystem.songTimeout = 0;
	                    }
	                    MusicSystem.musicVolume = newMusicVolume;
                        Configuration.setSoundMuted(newMusicVolume == 0);
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
	                chatEffectsDisabled = varPlayerValue;
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
	    int[] is = Minimap.minimapImage.pixels;
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
	    Minimap.minimapImage.method723();
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
	    Minimap.minimapHintCount = 0;
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
	                    Minimap.minimapHint[Minimap.minimapHintCount] = mapFunctionIcons[i_11_];
	                    Minimap.minimapHintX[Minimap.minimapHintCount] = i_13_;
	                    Minimap.minimapHintY[Minimap.minimapHintCount] = i_12_;
	                    Minimap.minimapHintCount++;
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
	public static GameInterface aGameInterface_1887;

    public static void method311(Component arg1) {
	    arg1.removeKeyListener(Class59.keyFocusListener);
	    arg1.removeFocusListener(Class59.keyFocusListener);
	}

    /**
     * Draws the 2d yellow arrow hint icon in the world.
     */
    public static void drawPositionHintIcon() {
        if (Player.headIconDrawType != 2) {
            return;
        }

        Point2d screenPos = MovedStatics.getProjectedScreenPosition(2 * hintIconPosZ, Class35.hintIconInnerPosY + (-Class26.baseY + hintIconPosY << 7), (ProducingGraphicsBuffer.hintIconPosX + -baseX << 7) + Landscape.hintIconInnerPosX);

        if (screenPos == null) {
            return;
        }

        if (pulseCycle % 20 < 10)
            hintIconSprites[0].drawImage(screenPos.x - 12, screenPos.y - 28);
    }

    /**
     * Project 3d pos to 3d
     */
    public static Point2d getProjectedScreenPosition(int z, int y, int x) {
        if (x < 128 || y < 128 || x > 13056 || y > 13056) {
            return null;
        }

        int drawHeight = Scene.getFloorDrawHeight(Player.worldLevel, x, y) - z;

        Point3d cameraPos = Main.getActiveCamera().getPosition();
        CameraRotation rotation = Main.getActiveCamera().getRotation();

        x -= cameraPos.x;
        y -= cameraPos.y;
        drawHeight -= cameraPos.z;
        int cosinePitch = Model.COSINE[rotation.pitch];
        int sinePitch = Model.SINE[rotation.pitch];
        int sineYaw = Model.SINE[rotation.yaw];
        int cosineYaw = Model.COSINE[rotation.yaw];

        // rotate x/y/z according to camera pos
        int tmp = y * sineYaw + x * cosineYaw >> 16;
        y = cosineYaw * y - x * sineYaw >> 16;
        x = tmp;
        tmp = drawHeight * cosinePitch - y * sinePitch >> 16;
        y = y * cosinePitch + drawHeight * sinePitch >> 16;
        drawHeight = tmp;

        // TODO (jkm) why don't we draw below y=50?
        if (y < 50) {
            return null;
        }

        return new Point2d((x << 9) / y, (drawHeight << 9) / y)
            .add(getScreenMidpoint());
    }

    public static Point2d getScreenMidpoint() {
        if (ScreenController.frameMode == ScreenMode.FIXED) {
            return new Point2d(256, 167);
        } else {
            return new Point2d(ScreenController.drawWidth / 2, ScreenController.drawHeight / 2);
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
	public static int[] anIntArray1847 = new int[2000];
	public static long aLong1841;

    private static int interpolateForPerlin(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if (!arg3)
            return -109;
        int i = 65536 + -Rasterizer3D.cosinetable[1024 * arg4 / arg1] >> 1;
        return ((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16);
    }

    private static void method344(int arg0) {
        if(aBoolean2083) {
            chatboxLineOffsets = null;
            aBoolean2083 = false;
            RSCanvas.anIntArray66 = null;
            Minimap.minimapBackgroundImage = null;
            Landscape.anIntArray1186 = null;
            Class17.chatboxTop = null;
            RSCanvas.tabBottom = null;
            GameObject.tabPieceLeft = null;
            Class57.bottomChatBack = null;
            inventoryBackgroundImage = null;
            WallDecoration.tabHighlightImageTopRight = null;
            Class40_Sub5_Sub15.tabIcons = null;
            Class13.tabHighlightImageBottomRight = null;
            Minimap.mapbackProducingGraphicsBuffer = null;
            RSCanvas.anIntArray62 = null;
            sidebarOffsets = null;
            Class39.mapbackLeft = null;
            tabHighlightImageBottomMiddle = null;
            tabBottomBack = null;
            Landscape.framePieceRight = null;
            GameInterface.tabHighlightImageTopLeft = null;
            tabHighlightImageTopRightEdge = null;
            anIntArray852 = null;
            chatModes = null;
            Buffer.tabTopBack = null;
            tabImageProducer = null;
            tabHighlightImageTopLeftEdge = null;
            gameScreenImageProducer = null;
            ISAAC.tabHighlightImageBottomRightEdge = null;
            RSCanvas.chatBoxImageProducer = null;
            Class40_Sub7.mapBackRight = null;
            InteractiveObject.tabTop = null;
            if(arg0 < -28) {
                chatboxRight = null;
                tabPieceUpperRight = null;
                Class35.tabHighlightImageTopMiddle = null;
                tabHighlightImageBottomLeft = null;
                Renderable.tabHighlightImageBottomLeftEdge = null;
                Class24.fullScreenTextureArray = null;
                PlayerAppearance.tabPieveLowerRight = null;
                SpotAnim.framePieceTop = null;
                Class44.chatboxBackgroundImage = null;
            }
        }
    }

    private static void method945(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7) {
        if(arg5 != 103)
            GenericTile.anInt1214 = -81;
        if(arg2 >= 1 && arg0 >= 1 && arg2 <= 102 && arg0 <= 102) {
            if(!VertexNormal.lowMemory || Player.worldLevel == arg7) {
                int i = -1;
                int i_0_ = 0;
                boolean bool = false;
                boolean bool_1_ = false;
                if(arg6 == 0)
                    i_0_ = Npc.currentScene.method122(arg7, arg2, arg0);
                if(arg6 == 1)
                    i_0_ = Npc.currentScene.method91(arg7, arg2, arg0);
                if(arg6 == 2)
                    i_0_ = Npc.currentScene.getLocationHash(arg7, arg2, arg0);
                if(arg6 == 3)
                    i_0_ = Npc.currentScene.getFloorDecorationHash(arg7, arg2, arg0);
                if(i_0_ != 0) {
                    i = (i_0_ & 0x1ffff138) >> 14;
                    int i_2_ = Npc.currentScene.getArrangement(arg7, arg2, arg0, i_0_);
                    int i_3_ = i_2_ >> 6 & 0x3;
                    int i_4_ = 0x1f & i_2_;
                    if(arg6 == 0) {
                        Npc.currentScene.method124(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid)
                            Landscape.currentCollisionMap[arg7].markWall(arg2, i_3_, gameObjectDefinition.walkable, arg0, i_4_);
                    }
                    if(arg6 == 1)
                        Npc.currentScene.method127(arg7, arg2, arg0);
                    if(arg6 == 2) {
                        Npc.currentScene.removeInteractiveObject(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(arg2 + gameObjectDefinition.sizeX > 103 || arg0 + gameObjectDefinition.sizeX > 103 || arg2 + gameObjectDefinition.sizeY > 103 || gameObjectDefinition.sizeY + arg0 > 103)
                            return;
                        if(gameObjectDefinition.solid)
                            Landscape.currentCollisionMap[arg7].markSolidOccupant(arg2, arg0, gameObjectDefinition.sizeX, gameObjectDefinition.sizeY, i_3_, gameObjectDefinition.walkable);
                    }
                    if(arg6 == 3) {
                        Npc.currentScene.method131(arg7, arg2, arg0);
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1)
                            Landscape.currentCollisionMap[arg7].unmarkConcealed(arg2, arg0);
                    }
                }
                if(arg1 >= 0) {
                    int i_5_ = arg7;
                    if(i_5_ < 3 && (OverlayDefinition.tile_flags[1][arg2][arg0] & 0x2) == 2)
                        i_5_++;
                    CollisionMap.method543(Landscape.currentCollisionMap[arg7], arg1, i_5_, arg7, arg3, Npc.currentScene, -22078, arg4, arg0, arg2);
                }
            }
        }
    }

    public static void renderSplitPrivateMessages() {
        if(CollisionMap.anInt165 != 0) {
            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
            int i = 0;
            if(Class40_Sub5_Sub15.systemUpdateTime != 0)
                i = 1;
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(ChatBox.chatMessages[i_0_] != null) {
                    String class1 = ChatBox.chatPlayerNames[i_0_];
                    int i_1_ = 0;
                    int i_2_ = ChatBox.chatTypes[i_0_];
                    if(class1 != null && class1.startsWith(Native.whiteCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 1;
                    }
                    if(class1 != null && class1.startsWith(Native.goldCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 2;
                    }
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, -1 + i_3_, 65535);
                        i_4_ += class40_sub5_sub14_sub1.getStringWidth(English.from);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if(i_1_ == 1) {
                            moderatorIcon[0].drawImage(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if(i_1_ == 2) {
                            moderatorIcon[1].drawImage(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, -1 + i_3_, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 5 && ChatBox.privateChatMode < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_, 0);
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_ - 1, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 6 && ChatBox.privateChatMode < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_, 0);
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_ + -1, 65535);
                        if(i >= 5)
                            return;
                    }
                }
            }
        }
    }

    public static void draw3dScreen() {
        renderSplitPrivateMessages();
        if (LinkedList.crossType == 1) {
            Class37.cursorCross[OverlayDefinition.crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (LinkedList.crossType == 2) {
            Class37.cursorCross[4 + OverlayDefinition.crossIndex / 100].drawImage(GameInterface.crossX - 8 - 4, GameInterface.crossY - 8 - 4);
        }
        if (GameInterface.gameScreenInterfaceId != -1 || GroundItemTile.walkableWidgetId != -1) {
                int areaId = GameInterface.gameScreenInterfaceId != -1 ? 0 : 4;
                int id = GameInterface.gameScreenInterfaceId != -1 ? GameInterface.gameScreenInterfaceId : GroundItemTile.walkableWidgetId;
                Renderable.handleSequences(id);
                int yOffset = (ScreenController.drawHeight /2) - (334/2) - (184/2);
                int xOffset = (ScreenController.drawWidth /2) - (512/2) - (234/3);
                if(ScreenController.frameMode == ScreenMode.FIXED) {
                    yOffset = 0;
                    xOffset = 0;
                }
                Main.drawParentInterface(areaId, xOffset, yOffset, 512+ xOffset, 334 + yOffset, id);
        }
        Class65.method1018();
        Player.setTutorialIslandFlag();
        if (!menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else  {
            if(ScreenController.frameMode == ScreenMode.FIXED && Projectile.menuScreenArea == 0){
                drawMenu(4,4);
            }
        }
        if (anInt2118 == 1) {
            LinkedList.aClass40_Sub5_Sub14_Sub4_1057.drawImage(472, 296);
        }
        if (InteractiveObject.showFps) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }

            int colour = 0xffff00;
            if (GameShell.fps < 30 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (GameShell.fps < 20 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Fps: " + GameShell.fps, x, y, colour);
            colour = 0xffff00;
            y += 15;
            Runtime runtime = Runtime.getRuntime();
            int memoryUsed = (int) ((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
            if (memoryUsed > 32768 && VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            if (memoryUsed < 65536 && !VertexNormal.lowMemory) {
                colour = 0xff0000;
            }
            WallDecoration.fontNormal.drawStringRight("Mem: " + memoryUsed + "k", x, y, colour);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("MouseX: " + MouseHandler.mouseX, x, y ,0xffff00);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("MouseY: " + MouseHandler.mouseY, x, y ,0xffff00);
            y += 15;
            WallDecoration.fontNormal.drawStringRight("ClickX: " + MouseHandler.clickX, x, y ,0xffff00);
            y += 15;

            WallDecoration.fontNormal.drawStringRight("ClickY: " + MouseHandler.clickY, x, y ,0xffff00);
            y += 15;
            if (showSidePanelRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.sidePanelRedrawn, x, y, 16711680);
                y += 15;
                showSidePanelRedrawnText = false;
            }
            if (showChatPanelRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.chatPanelRedrawn, x, y, 16711680);
                y += 15;
                showChatPanelRedrawnText = false;
            }
            if (Class40_Sub3.showIconsRedrawnText) {
                WallDecoration.fontNormal.drawStringRight(English.iconsRedrawn, x, y, 16711680);
                Class40_Sub3.showIconsRedrawnText = false;
                y += 15;
            }
        }
        if (Configuration.DEBUG_WIDGETS) {
            int y = 20;
            int x = 507;
            if(ScreenController.frameMode != ScreenMode.FIXED) {
                x = ScreenController.drawWidth - 220;
            }
            int widgetParentId = hoveredWidgetId >> 16;
            int widgetChildId = hoveredWidgetId & 0x7fff;
            String typeAsString = "";

            // Gather widget metadata from the cached interfaces
            GameInterface[] parentInterface;
            GameInterface childInterface = null;
            if (widgetParentId >= 0 && widgetChildId < 469) {
                parentInterface = GameInterface.cachedInterfaces[widgetParentId];

                if (parentInterface != null) {
                    childInterface = parentInterface[widgetChildId];
                }

                if (childInterface != null) {
                    switch (childInterface.type) {
                        case TEXT:
                            typeAsString = "TEXT";
                            break;
                        case GRAPHIC:
                            typeAsString = "GRAPHIC";
                            break;
                        case MODEL:
                            typeAsString = "MODEL";
                            break;
                        case RECTANGLE:
                            typeAsString = "RECTANGLE";
                            break;
                        case INVENTORY:
                            typeAsString = "INVENTORY";
                            break;
                        case LINE:
                            typeAsString = "LINE";
                            break;
                        case TEXT_INVENTORY:
                            typeAsString = "TEXT_INVENTORY";
                            break;
                        case LAYER:
                            typeAsString = "LAYER";
                            break;
                        case IF1_TOOLTIP:
                            typeAsString = "IF1_TOOLTIP";
                            break;
                        default:
                            typeAsString = "UNKNOWN";
                    }
                }
            }

            WallDecoration.fontNormal.drawStringRight("Widget " + widgetParentId + ":" + widgetChildId, x, y, 0xffff00);
            y+= 15;
            if (childInterface != null) {
                WallDecoration.fontNormal.drawStringRight("Parent ID: " + childInterface.parentId, x, y, 0xffff00);
                y+= 15;
                WallDecoration.fontNormal.drawStringRight("Type: " + typeAsString, x, y, 0xffff00);
                y+= 15;
            }

        }
        if (Class40_Sub5_Sub15.systemUpdateTime != 0) {
            int seconds = Class40_Sub5_Sub15.systemUpdateTime / 50;
            int minutes = seconds / 60;
            seconds %= 60;
            if (seconds < 10) {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.prefixColonZero + seconds, 4, 329, 16776960);
            } else {
                WallDecoration.fontNormal.drawString(English.systemUpdateIn + minutes + Native.colon + seconds, 4, 329, 16776960);
            }
        }
    }

    public static void processNpcMenuOptions(ActorDefinition actorDefinition, int x, int y, int index) {
        if (menuActionRow < 400) {
            if (actorDefinition.childIds != null) {
                actorDefinition = actorDefinition.getChildDefinition();
            }
            if (actorDefinition != null && actorDefinition.isClickable) {
                String npcDisplayName = actorDefinition.name;
                if (actorDefinition.combatLevel != 0) {
                    npcDisplayName = npcDisplayName + SceneTile.getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel) + Native.leftParenthesisWithSpacePrefix + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                }
                if (itemSelected == 1) {
                    addActionRow(English.use, index, x, y, ActionRowType.USE_ITEM_ON_NPC.getId(), Native.selectedItemName + Native.toYellow + npcDisplayName);
                } else if (Main.widgetSelected == 1) {
                    if ((0x2 & ItemDefinition.selectedMask) == 2) {
                        addActionRow(Native.selectedSpellVerb, index, x, y, ActionRowType.CAST_MAGIC_ON_NPC.getId(), Native.selectedSpellName + Native.toYellow + npcDisplayName);
                    }
                } else {
                    String[] options = actorDefinition.options;
                    if (Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS) {
                        options = getAllOptionsWithIndices(options);
                    }

                    // add non-attack options to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && !options[i].equalsIgnoreCase(English.attack)) {
                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId();
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId();
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId();
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId();
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId();
                                }
                                addActionRow(options[i], index, x, y, actionType, Native.yellow + npcDisplayName);
                            }
                        }
                    }

                    // add 'Attack' option to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && options[i].equalsIgnoreCase(English.attack)) {
                                int actionTypeOffset = 0;

                                // deprioritise the action in the list if the NPC is higher level than the player
                                if (Player.localPlayer.combatLevel < actorDefinition.combatLevel) {
                                    actionTypeOffset = ActionRowType.LOW_PRIORITY_MODIFIER;
                                }

                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_1.getId() + actionTypeOffset;
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_2.getId() + actionTypeOffset;
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_3.getId() + actionTypeOffset;
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_4.getId() + actionTypeOffset;
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.INTERACT_WITH_NPC_OPTION_5.getId() + actionTypeOffset;
                                }
                                addActionRow(options[i], index, x, y, actionType, Native.yellow +npcDisplayName);
                            }
                        }
                    }
                    StringBuilder examineText = new StringBuilder();
                    examineText.append(MessageFormat.format("<col=ffff00>{0}</col>", actorDefinition.name));

                    if(actorDefinition.combatLevel != 0) {
                        String combatLevel = " " +
                            SceneTile.getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel)
                                + Native.leftParenthesis + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                        examineText.append(combatLevel);
                    }


                    if (Configuration.DEBUG_CONTEXT) {
                        examineText.append(" <col=00ff00>(</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}</col>",
                                        Integer.toString(actorDefinition.id)
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
                    addActionRow(English.examine, index, x, y, ActionRowType.EXAMINE_NPC.getId(), examineText.toString());
                }
            }
        }
    }

    public static ImageRGB method1028(CacheArchive arg0, String arg1, String arg3) {
        int i = arg0.getHash(arg1);
        int i_13_ = arg0.method179(i, arg3);
        return method927(i_13_, arg0, i);
    }

    public static void spawnGroundItem(int arg1, int arg2) {
        LinkedList linkedList = Wall.groundItems[Player.worldLevel][arg2][arg1];
        if(linkedList == null)
            Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
        else {
            int i = -99999999;
            Item item = null;
            for(Item item_32_ = (Item) linkedList.peekFirst(); item_32_ != null; item_32_ = (Item) linkedList.pollFirst()) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(item_32_.itemId, 10);
                int i_33_ = class40_sub5_sub16.cost;
                if(class40_sub5_sub16.stackable == 1)
                    i_33_ *= item_32_.itemCount + 1;
                if(i_33_ > i) {
                    i = i_33_;
                    item = item_32_;
                }
            }
            if(item == null)
                Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
            else {
                Item item_34_ = null;
                Item item_35_ = null;
                linkedList.addFirst(item);
                for(Item item_36_ = (Item) linkedList.peekFirst(); item_36_ != null; item_36_ = (Item) linkedList.pollFirst()) {
                    if(item.itemId != item_36_.itemId) {
                        if(item_35_ == null)
                            item_35_ = item_36_;
                        if(item_35_.itemId != item_36_.itemId && item_34_ == null)
                            item_34_ = item_36_;
                    }
                }
                int i_37_ = 1610612736 + (arg1 << 7) + arg2;
                Npc.currentScene.addGroundItemTile(arg2, arg1, Player.worldLevel, Scene.getFloorDrawHeight(Player.worldLevel, 64 + 128 * arg2, 64 + 128 * arg1), i_37_, item, item_35_, item_34_);
            }
        }

    }
}
