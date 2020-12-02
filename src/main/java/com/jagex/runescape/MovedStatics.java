package com.jagex.runescape;

import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;
import tech.henning.fourthreefive.Configuration;

public class MovedStatics {

	public static PacketBuffer packetBuffer = new PacketBuffer(5000);
    public static int[][] anIntArrayArray1435 = new int[104][104];
    public static ProducingGraphicsBuffer tabPieceUpperRight;
    public static boolean aBoolean1444 = false;
    public static int[] anIntArray1445;
    public static LinkedList aLinkedList_2268 = new LinkedList();
    public static ProducingGraphicsBuffer chatboxRight;
    public static int crossY = 0;
    public static int anInt2278 = 0;
    public static int anInt2280 = 0;
	public static volatile int mouseButtonPressed = 0;
	public static int anInt321 = 5063219;
	public static volatile int eventMouseY = -1;
	public static int anInt324 = 0;
	public static boolean redrawChatbox = false;
	public static ImageRGB[] mapDots;
	public static CacheIndex aCacheIndex_654;
	public static int minimapState = 0;
	public static int[] anIntArray666 = new int[]{1, 0, -1, 0};
	public static int pulseCycle = 0;
	public static int anInt938 = 500;
	public static int loginScreenFocus = 0;
	public static int anInt2081;
	public static boolean aBoolean2083 = false;
	public static ProducingGraphicsBuffer tabImageProducer;
	public static IndexedImage aClass40_Sub5_Sub14_Sub2_549;
	public static int anInt554 = 0;
	public static int anInt564;
	public static boolean aBoolean565 = false;
	public static boolean aBoolean571;
	public static int anInt573 = -1;

	public static void method440(byte arg0) {
	    if(ISAAC.aBoolean512) {
	        Class51.anIntArray1198 = null;
	        GameObject.flameRightBackground = null;
	        ProducingGraphicsBuffer.aProducingGraphicsBuffer_1631 = null;
	        Class51.aProducingGraphicsBuffer_1206 = null;
	        Landscape.anIntArray1168 = null;
	        Class40_Sub5_Sub17_Sub6.anIntArray3255 = null;
	        Class59.aClass40_Sub5_Sub14_Sub2_1387 = null;
	        anIntArray1445 = null;
	        Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775 = null;
	        Renderable.anIntArray2865 = null;
	        Class8.flameLeftBackground = null;
	        Class39.aProducingGraphicsBuffer_907 = null;
	        GameObjectDefinition.aProducingGraphicsBuffer_2524 = null;
	        Class39.aClass40_Sub5_Sub14_Sub4_918 = null;
	        Class22.aClass40_Sub5_Sub14_Sub2Array535 = null;
	        Class40_Sub5_Sub17_Sub6.anIntArray3248 = null;
	        MovedStatics.loginBoxGraphics = null;
	        SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = null;
	        Class4.anIntArray178 = null;
	        KeyFocusListener.aProducingGraphicsBuffer_1285 = null;
	        if(arg0 <= -65) {
	            Class17.aProducingGraphicsBuffer_463 = null;
	            Class42.anIntArray1013 = null;
	            Class33.method405(16969, 10);
	            GameShell.method19(true, 24041);
	            ISAAC.aBoolean512 = false;
	        }
	    }
	}

	public static void method441(CacheIndex arg0) {
	    Actor.aCacheIndex_3144 = arg0;
	}

	public static int[] menuActionTypes = new int[500];
	public static ProducingGraphicsBuffer loginBoxGraphics;
	public static int[] anIntArray889 = new int[128];
	public static int anInt892;
	public static boolean aBoolean893 = false;
	public static int[] anIntArray1916 = new int[50];
	public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
	public static int anInt1923 = 0;
	public static void method445(int arg0) {
	    if(CollisionMap.anInt165 != 0) {
	        int i = 0;
	        if(Class40_Sub5_Sub15.systemUpdateTime != 0)
	            i = 1;
	        for(int i_1_ = 0; i_1_ < 100; i_1_++) {
	            if(ChatBox.chatMessages[i_1_] != null) {
	                int i_2_ = ChatBox.chatTypes[i_1_];
	                String class1 = ChatBox.chatPlayerNames[i_1_];
	                if(class1 != null && class1.startsWith(Native.whiteCrown))
	                    class1 = class1.substring(5);
	                if(class1 != null && class1.startsWith(Native.goldCrown))
	                    class1 = class1.substring(5);
	                if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Class40_Sub2.hasFriend(class1))) {
	                    int i_3_ = 329 + -(13 * i);
	                    i++;
	                    if(Class13.mouseX > 4 && i_3_ + -10 < Landscape.mouseY + -4 && -4 + Landscape.mouseY <= i_3_ + 3) {
	                        int i_4_ = 25 + WallDecoration.fontNormal.getStringWidth(English.from + Native.prefixColon+ class1+ ChatBox.chatMessages[i_1_]);
	                        if(i_4_ > 450)
	                            i_4_ = 450;
	                        if(Class13.mouseX < 4 + i_4_) {
	                            if(InteractiveObject.playerRights >= 1) {
	                                OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 2028, Native.white + class1);
	                            }
	                            OverlayDefinition.addActionRow(English.addIgnore, 0, 0, 0, 2051, Native.white + class1);
	                            OverlayDefinition.addActionRow(English.addFriend, 0, 0, 0, 2045, Native.white + class1);
	                        }
	                    }
	                    if(i >= 5)
	                        return;
	                }
	                if((i_2_ == 5 || i_2_ == 6) && ChatBox.privateChatMode < 2 && ++i >= 5)
	                    return;
	            }
	        }
	        if(arg0 != 9767)
	            anInt1923 = 48;
	    }
	}

	public static boolean method446(Signlink arg0, int arg1, boolean arg2, byte arg3) {
	    if(arg3 != 30)
	        MovedStatics.doWalkTo(47, -7, 96, -97, -111, true, -110, 57, -36, -84, -42);
	    if(!Class39.method452(arg0, arg2))
	        return false;
	    if(arg1 > 0)
	        RSString.aClass9_1684 = new NodeCache(arg1);
	    return true;
	}

	public static boolean doWalkTo(int arg0, int arg1, int startX, int endX, int objectType, boolean flag, int arg7, int arg8, int startY, int endY, int clickType) {
	    for(int x = 0; x < 104; x++) {
	        for(int y = 0; y < 104; y++) {
	            Class57.wayPoints[x][y] = 0;
	            Landscape.distanceValues[x][y] = 99999999;
	        }
	    }
	    int currentX = startX;
	    int currentY = startY;
	    Class57.wayPoints[startX][startY] = 99;
	    Landscape.distanceValues[startX][startY] = 0;
	    int nextIndex = 0;
	    int currentIndex = 0;
	    Class24.walkingQueueX[nextIndex] = startX;
	    Wall.walkingQueueY[nextIndex++] = startY;
	    boolean foundDestination = false;
	    int maxPathSize = Class24.walkingQueueX.length;
	    int[][] clippingPaths = Landscape.currentCollisionMap[Player.worldLevel].clippingData;
	    while(currentIndex != nextIndex) {
	        currentY = Wall.walkingQueueY[currentIndex];
	        currentX = Class24.walkingQueueX[currentIndex];
	        currentIndex = (currentIndex + 1) % maxPathSize;
	        if(currentX == endX && currentY == endY) {
	            foundDestination = true;
	            break;
	        }
	        if(objectType != 0) {
	            if(objectType >= 5 && objectType != 10 || !Landscape.currentCollisionMap[Player.worldLevel].reachedWall(currentX, currentY, endX, endY, objectType + -1, arg7)) {
	                if(objectType < 10 && Landscape.currentCollisionMap[Player.worldLevel].reachedWallDecoration(currentX, currentY, endX, endY, -1 + objectType, arg7)) {
	                    foundDestination = true;
	                    break;
	                }
	            } else {
	                foundDestination = true;
	                break;
	            }
	        }
	        if(arg0 != 0 && arg8 != 0 && Landscape.currentCollisionMap[Player.worldLevel].reachedFacingObject(currentX, currentY, endX, endY, arg0, arg8, arg1)) {
	            foundDestination = true;
	            break;
	        }
	        int newDistanceValue = Landscape.distanceValues[currentX][currentY] + 1;
	        if(currentX > 0 && Class57.wayPoints[-1 + currentX][currentY] == 0 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0) {
	            Class24.walkingQueueX[nextIndex] = currentX - 1;
	            Wall.walkingQueueY[nextIndex] = currentY;
	            nextIndex = (1 + nextIndex) % maxPathSize;
	            Class57.wayPoints[-1 + currentX][currentY] = 2;
	            Landscape.distanceValues[currentX - 1][currentY] = newDistanceValue;
	        }
	        if(currentX < 103 && Class57.wayPoints[currentX + 1][currentY] == 0 && (clippingPaths[1 + currentX][currentY] & 0x1280180) == 0) {
	            Class24.walkingQueueX[nextIndex] = currentX + 1;
	            Wall.walkingQueueY[nextIndex] = currentY;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	            Class57.wayPoints[currentX + 1][currentY] = 8;
	            Landscape.distanceValues[currentX + 1][currentY] = newDistanceValue;
	        }
	        if(currentY > 0 && Class57.wayPoints[currentX][currentY - 1] == 0 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
	            Class24.walkingQueueX[nextIndex] = currentX;
	            Wall.walkingQueueY[nextIndex] = -1 + currentY;
	            Class57.wayPoints[currentX][-1 + currentY] = 1;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	            Landscape.distanceValues[currentX][currentY - 1] = newDistanceValue;
	        }
	        if(currentY < 103 && Class57.wayPoints[currentX][currentY + 1] == 0 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
	            Class24.walkingQueueX[nextIndex] = currentX;
	            Wall.walkingQueueY[nextIndex] = 1 + currentY;
	            Class57.wayPoints[currentX][currentY + 1] = 4;
	            Landscape.distanceValues[currentX][1 + currentY] = newDistanceValue;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	        }
	        if(currentX > 0 && currentY > 0 && Class57.wayPoints[-1 + currentX][currentY - 1] == 0 && (clippingPaths[currentX - 1][-1 + currentY] & 0x128010e) == 0 && (0x1280108 & clippingPaths[currentX + -1][currentY]) == 0 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
	            Class24.walkingQueueX[nextIndex] = -1 + currentX;
	            Wall.walkingQueueY[nextIndex] = currentY - 1;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	            Class57.wayPoints[currentX + -1][-1 + currentY] = 3;
	            Landscape.distanceValues[-1 + currentX][currentY + -1] = newDistanceValue;
	        }
	        if(currentX < 103 && currentY > 0 && Class57.wayPoints[currentX + 1][-1 + currentY] == 0 && (clippingPaths[1 + currentX][-1 + currentY] & 0x1280183) == 0 && (clippingPaths[currentX + 1][currentY] & 0x1280180) == 0 && (0x1280102 & clippingPaths[currentX][-1 + currentY]) == 0) {
	            Class24.walkingQueueX[nextIndex] = 1 + currentX;
	            Wall.walkingQueueY[nextIndex] = currentY - 1;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	            Class57.wayPoints[1 + currentX][-1 + currentY] = 9;
	            Landscape.distanceValues[currentX + 1][-1 + currentY] = newDistanceValue;
	        }
	        if(currentX > 0 && currentY < 103 && Class57.wayPoints[currentX + -1][currentY + 1] == 0 && (0x1280138 & clippingPaths[-1 + currentX][1 + currentY]) == 0 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
	            Class24.walkingQueueX[nextIndex] = -1 + currentX;
	            Wall.walkingQueueY[nextIndex] = 1 + currentY;
	            Class57.wayPoints[currentX - 1][1 + currentY] = 6;
	            Landscape.distanceValues[-1 + currentX][currentY + 1] = newDistanceValue;
	            nextIndex = (1 + nextIndex) % maxPathSize;
	        }
	        if(currentX < 103 && currentY < 103 && Class57.wayPoints[1 + currentX][1 + currentY] == 0 && (0x12801e0 & clippingPaths[currentX + 1][currentY + 1]) == 0 && (0x1280180 & clippingPaths[1 + currentX][currentY]) == 0 && (clippingPaths[currentX][1 + currentY] & 0x1280120) == 0) {
	            Class24.walkingQueueX[nextIndex] = 1 + currentX;
	            Wall.walkingQueueY[nextIndex] = currentY + 1;
	            nextIndex = (nextIndex + 1) % maxPathSize;
	            Class57.wayPoints[1 + currentX][1 + currentY] = 12;
	            Landscape.distanceValues[1 + currentX][1 + currentY] = newDistanceValue;
	        }
	    }
	    Class40_Sub5_Sub15.arbitraryDestination = 0;
	    if(!foundDestination) {
	        if(flag) {
	            int i_14_ = 1000;
	            int deviation = 10;
	            int maxStepsNonInclusive = 100;
	            for(int deviationX = endX + -deviation; endX + deviation >= deviationX; deviationX++) {
	                for(int deviationY = -deviation + endY; endY + deviation >= deviationY; deviationY++) {
	                    if(deviationX >= 0 && deviationY >= 0 && deviationX < 104 && deviationY < 104 && Landscape.distanceValues[deviationX][deviationY] < 100) {
	                        int i_19_ = 0;
	                        int i_20_ = 0;
	                        if(deviationY < endY)
	                            i_19_ = endY - deviationY;
	                        else if(deviationY > endY - (-arg8 + 1))
	                            i_19_ = deviationY + -arg8 + -endY + 1;
	                        if(deviationX < endX)
	                            i_20_ = -deviationX + endX;
	                        else if(-1 + arg0 + endX < deviationX)
	                            i_20_ = deviationX + -arg0 + -endX + 1;
	                        int i_21_ = i_19_ * i_19_ + i_20_ * i_20_;
	                        if(i_14_ > i_21_ || i_21_ == i_14_ && Landscape.distanceValues[deviationX][deviationY] < maxStepsNonInclusive) {
	                            currentY = deviationY;
	                            i_14_ = i_21_;
	                            currentX = deviationX;
	                            maxStepsNonInclusive = Landscape.distanceValues[deviationX][deviationY];
	                        }
	                    }
	                }
	            }
	            if(i_14_ == 1000)
	                return false;
	            if(startX == currentX && startY == currentY)
	                return false;
	            Class40_Sub5_Sub15.arbitraryDestination = 1;
	        } else {
	            return false;
	        }
	    }
	    currentIndex = 0;
	    Class24.walkingQueueX[currentIndex] = currentX;
	    Wall.walkingQueueY[currentIndex++] = currentY;
	    int initialSkipCheck;
	    int waypoint = initialSkipCheck = Class57.wayPoints[currentX][currentY];
	    while(currentX != startX || startY != currentY) {
	        if(waypoint != initialSkipCheck) {
	            initialSkipCheck = waypoint;
	            Class24.walkingQueueX[currentIndex] = currentX;
	            Wall.walkingQueueY[currentIndex++] = currentY;
	        }
	        if((waypoint & 0x1) != 0)
	            currentY++;
	        else if((waypoint & 0x4) != 0)
	            currentY--;
	        if((waypoint & 0x2) != 0)
	            currentX++;
	        else if((waypoint & 0x8) != 0)
	            currentX--;
	        waypoint = Class57.wayPoints[currentX][currentY];
	    }
	    if(currentIndex > 0) {
	        maxPathSize = currentIndex;
	        if(maxPathSize > 25)
	            maxPathSize = 25;
	        currentIndex--;
	        int x = Class24.walkingQueueX[currentIndex];
	        int y = Wall.walkingQueueY[currentIndex];
	        if(clickType == 0) {
	            SceneCluster.packetBuffer.putPacket(73);
	            SceneCluster.packetBuffer.putByte(3 + maxPathSize + maxPathSize);
	        }
	        if(clickType == 1) {
	            SceneCluster.packetBuffer.putPacket(236);
	            SceneCluster.packetBuffer.putByte(14 + maxPathSize + maxPathSize + 3);
	        }
	        if(clickType == 2) {
	            SceneCluster.packetBuffer.putPacket(89);
	            SceneCluster.packetBuffer.putByte(3 + maxPathSize + maxPathSize);
	        }
	        SceneCluster.packetBuffer.putShortLE(y + Class26.baseY);
	        SceneCluster.packetBuffer.putByte(Item.obfuscatedKeyStatus[82] ? 1 : 0);
	        SceneCluster.packetBuffer.putShortLE(SpotAnimDefinition.baseX + x);
	        VarbitDefinition.destinationX = Class24.walkingQueueX[0];
	        Class55.destinationY = Wall.walkingQueueY[0];
	        for(int counter = 1; maxPathSize > counter; counter++) {
	            currentIndex--;
	            SceneCluster.packetBuffer.putByte(Class24.walkingQueueX[currentIndex] - x);
	            SceneCluster.packetBuffer.putByte(-y + Wall.walkingQueueY[currentIndex]);
	        }
	        return true;
	    }
	    return clickType != 1;
	}

	public static void method450(byte arg0) {
	    if(Player.headIconDrawType == 2) {
	        if(arg0 >= -28)
	            method445(-128);
	        Class22_Sub1.method312(2 * ActorDefinition.anInt2404, Class35.anInt1730 + (-Class26.baseY + Class4.anInt175 << 7), (ProducingGraphicsBuffer.anInt1637 + -SpotAnimDefinition.baseX << 7) + Landscape.anInt1170, 4976905);
	        if(ISAAC.anInt522 > -1 && pulseCycle % 20 < 10)
	            UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
	    }
	}

    public static void method996(int arg0) {
        if(arg0 != 19655)
            English.systemUpdateIn = null;
        tabImageProducer.prepareRasterizer();
        FloorDecoration.inventoryBackgroundImage.drawImage(0, 0);
        ActorDefinition.sidebarOffsets = Rasterizer3D.setLineOffsets(ActorDefinition.sidebarOffsets);
    }

    public static void method997(int arg0) {
        if(arg0 != 47)
            initiateVertexHeights(-42, (byte) 12, 92, 18, -72);
        if(Signlink.aString735.toLowerCase().indexOf("microsoft") == -1) {
            HuffmanEncoding.anIntArray1564[44] = 71;
            HuffmanEncoding.anIntArray1564[45] = 26;
            HuffmanEncoding.anIntArray1564[46] = 72;
            HuffmanEncoding.anIntArray1564[47] = 73;
            HuffmanEncoding.anIntArray1564[59] = 57;
            HuffmanEncoding.anIntArray1564[61] = 27;
            HuffmanEncoding.anIntArray1564[91] = 42;
            HuffmanEncoding.anIntArray1564[92] = 74;
            HuffmanEncoding.anIntArray1564[93] = 43;
            if(Signlink.aMethod729 == null) {
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

    public static void initiateVertexHeights(int arg0, byte arg1, int arg2, int arg3, int arg4) {
        int i = -112 / ((50 - arg1) / 53);
        for(int i_0_ = arg0; i_0_ <= arg0 + arg2; i_0_++) {
            for(int i_1_ = arg4; arg3 + arg4 >= i_1_; i_1_++) {
                if(i_1_ >= 0 && i_1_ < 104 && i_0_ >= 0 && i_0_ < 104) {
                    InteractiveObject.aByteArrayArrayArray492[0][i_1_][i_0_] = (byte) 127;
                    if(arg4 == i_1_ && i_1_ > 0)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = Class40_Sub6.tile_height[0][-1 + i_1_][i_0_];
                    if(arg4 + arg3 == i_1_ && i_1_ < 103)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = Class40_Sub6.tile_height[0][i_1_ + 1][i_0_];
                    if(i_0_ == arg0 && i_0_ > 0)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = Class40_Sub6.tile_height[0][i_1_][i_0_ + -1];
                    if(i_0_ == arg0 + arg2 && i_0_ < 103)
                        Class40_Sub6.tile_height[0][i_1_][i_0_] = Class40_Sub6.tile_height[0][i_1_][1 + i_0_];
                }
            }
        }
    }

    public static void method1000(boolean arg0) {
        if(arg0) {
            for(Class40_Sub5_Sub17_Sub6 class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.method902((byte) -90); class40_sub5_sub17_sub6 != null; class40_sub5_sub17_sub6 = (Class40_Sub5_Sub17_Sub6) Class57.aLinkedList_1332.method909(-4)) {
                if(Player.worldLevel == class40_sub5_sub17_sub6.anInt3239 && !class40_sub5_sub17_sub6.aBoolean3237) {
                    if(pulseCycle >= class40_sub5_sub17_sub6.anInt3230) {
                        class40_sub5_sub17_sub6.method834(8076, Class5.anInt199);
                        if(class40_sub5_sub17_sub6.aBoolean3237)
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
        if(!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        if (arg0 != 256)
            anInt2280 = 44;
        int i = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, Class40_Sub5_Sub6.cameraY);
        if (i + -SceneCluster.cameraZ < 800 && (OverlayDefinition.tile_flags[Player.worldLevel][Class12.cameraX >> 7][Class40_Sub5_Sub6.cameraY >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

	public static void method233(boolean arg0) {
		Class33.aClass9_778.clear();
		if(!arg0)
			method236(null, null, null);
	}

	public static void method236(CacheIndex arg1, CacheIndex arg2, CacheIndex arg3) {
		ClientScriptRunner.aCacheIndex_2162 = arg1;
		VarbitDefinition.aCacheIndex_2364 = arg3;
		AnimationSequence.aCacheIndex_2484 = arg2;
	}

	public static int method368(byte arg0, boolean arg1, boolean arg2) {
		int i = 0;
		if(arg2) {
			i += Class17.anInt464 + ProducingGraphicsBuffer.anInt1618;
		}
		if(arg0 != -41) {
			mapDots = null;
		}
		if(arg1) {
			i += Class42.anInt1006 + anInt554;
		}
		return i;
	}

	public static void method455(int arg0, int arg1, int arg3) {
		for(int i = 0; i < 8; i++) {
			for(int i_0_ = 0; i_0_ < 8; i_0_++)
				Class40_Sub6.tile_height[arg1][arg3 + i][arg0 + i_0_] = 0;
		}
		if(arg3 > 0) {
			for(int i = 1; i < 8; i++)
				Class40_Sub6.tile_height[arg1][arg3][arg0 + i] = Class40_Sub6.tile_height[arg1][-1 + arg3][i + arg0];
		}
		if(arg0 > 0) {
			for(int i = 1; i < 8; i++)
				Class40_Sub6.tile_height[arg1][i + arg3][arg0] = Class40_Sub6.tile_height[arg1][i + arg3][-1 + arg0];
		}
		if(arg3 > 0 && Class40_Sub6.tile_height[arg1][-1 + arg3][arg0] != 0)
			Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3 - 1][arg0];
		else if(arg0 > 0 && Class40_Sub6.tile_height[arg1][arg3][arg0 - 1] != 0)
			Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][arg3][-1 + arg0];
		else if(arg3 > 0 && arg0 > 0 && Class40_Sub6.tile_height[arg1][arg3 + -1][-1 + arg0] != 0)
			Class40_Sub6.tile_height[arg1][arg3][arg0] = Class40_Sub6.tile_height[arg1][-1 + arg3][arg0 - 1];
	}

	public static void method456(int arg0) {
		if(Class24.method340()) {
			if(Class26.aBoolean618)
				OverlayDefinition.anInt2342 = arg0;
			else
				Class40_Sub5_Sub13.method651(22741, arg0);
		}
	}

	public static boolean method459(int arg0, int arg1, byte arg2) {
		if(arg0 == 11)
			arg0 = 10;
		if(arg2 < 83)
			method459(125, 22, (byte) 101);
		GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
		if(arg0 >= 5 && arg0 <= 8)
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

	public static void method327(boolean arg0, CacheIndex arg1, int arg2, int arg3, byte arg4, int arg5, byte arg6) {
		int i = 14 % ((arg6 - 5) / 62);
		long l = (long) (arg3 + (arg2 << 16));
		Class40_Sub5_Sub13 class40_sub5_sub13 = (Class40_Sub5_Sub13) Class51.aClass23_1194.method331(l, 6120);
		if(class40_sub5_sub13 == null) {
			class40_sub5_sub13 = (Class40_Sub5_Sub13) Class37.aClass23_869.method331(l, 6120);
			if(class40_sub5_sub13 == null) {
				class40_sub5_sub13 = (Class40_Sub5_Sub13) GameObjectDefinition.aClass23_2545.method331(l, 6120);
				if(class40_sub5_sub13 == null) {
					if(!arg0) {
						class40_sub5_sub13 = (Class40_Sub5_Sub13) Class34.aClass23_841.method331(l, 6120);
						if(class40_sub5_sub13 != null)
							return;
					}
					class40_sub5_sub13 = new Class40_Sub5_Sub13();
					class40_sub5_sub13.anInt2763 = arg5;
					class40_sub5_sub13.aByte2758 = arg4;
					class40_sub5_sub13.aClass6_Sub1_2754 = arg1;
					if(arg0) {
						Class51.aClass23_1194.put(l, class40_sub5_sub13);
						ProducingGraphicsBuffer.anInt1618++;
					} else {
						InteractiveObject.aNodeQueue_485.push(class40_sub5_sub13);
						GameObjectDefinition.aClass23_2545.put(l, class40_sub5_sub13);
						anInt554++;
					}
				} else if(arg0) {
					class40_sub5_sub13.clear();
					Class51.aClass23_1194.put(l, class40_sub5_sub13);
					anInt554--;
					ProducingGraphicsBuffer.anInt1618++;
				}
			}
		}
	}

	public static void method332(int arg0) {
		synchronized(CollisionMap.anObject162) {
			if(Buffer.anInt1987 == 0)
				ISAAC.aClass31_521.method394(5, 0, new Class44());
			Buffer.anInt1987 = arg0;
		}
	}

	public static RSString intToStr(int arg0) {
		return PacketBuffer.method521(false, 10, arg0);
	}

	public static void method335(byte arg0) {
		Class40_Sub5_Sub17_Sub1 class40_sub5_sub17_sub1 = (Class40_Sub5_Sub17_Sub1) Class43.aLinkedList_1022.method902((byte) -90);
		if(arg0 == 61) {
			for(/**/; class40_sub5_sub17_sub1 != null; class40_sub5_sub17_sub1 = (Class40_Sub5_Sub17_Sub1) Class43.aLinkedList_1022.method909(arg0 + -65)) {
				if(Player.worldLevel == class40_sub5_sub17_sub1.anInt2981 && pulseCycle <= class40_sub5_sub17_sub1.anInt2971) {
					if(class40_sub5_sub17_sub1.anInt2974 <= pulseCycle) {
						if(class40_sub5_sub17_sub1.anInt2961 > 0) {
							Npc class40_sub5_sub17_sub4_sub2 = Player.npcs[-1 + class40_sub5_sub17_sub1.anInt2961];
							if(class40_sub5_sub17_sub4_sub2 != null && class40_sub5_sub17_sub4_sub2.worldX >= 0 && class40_sub5_sub17_sub4_sub2.worldX < 13312 && class40_sub5_sub17_sub4_sub2.worldY >= 0 && class40_sub5_sub17_sub4_sub2.worldY < 13312)
								class40_sub5_sub17_sub1.method766(pulseCycle, arg0 + -61, class40_sub5_sub17_sub4_sub2.worldY, Class37.getFloorDrawHeight(class40_sub5_sub17_sub1.anInt2981, class40_sub5_sub17_sub4_sub2.worldX, class40_sub5_sub17_sub4_sub2.worldY) - class40_sub5_sub17_sub1.anInt2960, class40_sub5_sub17_sub4_sub2.worldX);
						}
						if(class40_sub5_sub17_sub1.anInt2961 < 0) {
							int i = -1 + -class40_sub5_sub17_sub1.anInt2961;
							Player class40_sub5_sub17_sub4_sub1;
							if(i != PlayerAppearance.anInt708)
								class40_sub5_sub17_sub4_sub1 = Player.trackedPlayers[i];
							else
								class40_sub5_sub17_sub4_sub1 = Player.localPlayer;
							if(class40_sub5_sub17_sub4_sub1 != null && class40_sub5_sub17_sub4_sub1.worldX >= 0 && class40_sub5_sub17_sub4_sub1.worldX < 13312 && class40_sub5_sub17_sub4_sub1.worldY >= 0 && class40_sub5_sub17_sub4_sub1.worldY < 13312)
								class40_sub5_sub17_sub1.method766(pulseCycle, 0, class40_sub5_sub17_sub4_sub1.worldY, Class37.getFloorDrawHeight(class40_sub5_sub17_sub1.anInt2981, class40_sub5_sub17_sub4_sub1.worldX, class40_sub5_sub17_sub4_sub1.worldY) - class40_sub5_sub17_sub1.anInt2960, class40_sub5_sub17_sub4_sub1.worldX);
						}
						class40_sub5_sub17_sub1.method765(51, Class5.anInt199);
						Npc.currentScene.method134(Player.worldLevel, (int) class40_sub5_sub17_sub1.aDouble2980, (int) class40_sub5_sub17_sub1.aDouble2993, (int) class40_sub5_sub17_sub1.aDouble2992, 60, class40_sub5_sub17_sub1, class40_sub5_sub17_sub1.anInt3013, -1, false);
					}
				} else
					class40_sub5_sub17_sub1.remove();
			}
		}
	}
}
