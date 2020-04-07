package com.jagex.runescape;

import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

public class Class38_Sub1 extends Class38 {
    public static RSString aClass1_1905 = RSString.CreateString(" has logged out)3");
    public static int[] anIntArray1909 = new int[99];
    public static int[] anIntArray1916 = new int[50];
    public static RSString aClass1_1917 = RSString.CreateString("Attack");
    public static RSString aClass1_1918 = null;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1919;
    public static RSString aClass1_1921 = RSString.CreateString("b12_full");
    public static RSString aClass1_1922 = RSString.CreateString("Loaded sprites");
    public static int anInt1923 = 0;

    static {
        int i = 0;
        for(int i_27_ = 0; i_27_ < 99; i_27_++) {
            int i_28_ = i_27_ + 1;
            int i_29_ = (int) ((double) i_28_ + 300.0 * Math.pow(2.0, (double) i_28_ / 7.0));
            i += i_29_;
            anIntArray1909[i_27_] = i / 4;
        }
    }

    public int anInt1900;
    public int anInt1903;
    public long[] aLongArray1910 = new long[10];
    public int anInt1912;
    public long aLong1914;
    public int anInt1915;

    public Class38_Sub1() {
        method443(-10115);
    }

    public static void method445(int arg0) {
        if(CollisionMap.anInt165 != 0) {
            int i = 0;
            if(Class40_Sub5_Sub15.systemUpdateTime != 0)
                i = 1;
            for(int i_1_ = 0; i_1_ < 100; i_1_++) {
                if(ChatBox.chatMessages[i_1_] != null) {
                    int i_2_ = ChatBox.chatTypes[i_1_];
                    RSString class1 = ChatBox.chatPlayerNames[i_1_];
                    if(class1 != null && class1.startsWith(Class51.whiteCrown))
                        class1 = class1.substring(5);
                    if(class1 != null && class1.startsWith(Widget.goldCrown))
                        class1 = class1.substring(5);
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || (ChatBox.privateChatMode == 1 && Class40_Sub2.hasFriend(class1)))) {
                        int i_3_ = 329 + -(13 * i);
                        i++;
                        if(Class13.mouseX > 4 && ((i_3_ + -10 < Landscape.mouseY + -4)) && ((-4 + Landscape.mouseY <= i_3_ + 3))) {
                            int i_4_ = 25 + (WallDecoration.fontNormal.getStringWidth(RSString.linkRSStrings((new RSString[]{Class40_Sub5_Sub6.aClass1_2458, Native.prefixColon, class1, (ChatBox.chatMessages[i_1_])}))));
                            if(i_4_ > 450)
                                i_4_ = 450;
                            if(Class13.mouseX < 4 + i_4_) {
                                if(InteractiveObject.playerRights >= 1) {
                                    OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 2028, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
                                }
                                OverlayDefinition.addActionRow(Class38.aClass1_885, 0, 0, 0, 2051, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
                                OverlayDefinition.addActionRow(FloorDecoration.aClass1_591, 0, 0, 0, 2045, (RSString.linkRSStrings(new RSString[]{Class26.aClass1_620, class1})));
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
            doWalkTo(47, -7, 96, -97, -111, true, -110, 57, -36, -84, -42);
        if(!Class39.method452(arg0, arg2))
            return false;
        if(arg1 > 0)
            RSString.aClass9_1684 = new Cache(arg1);
        return true;
    }

    public static void method447() {
        if(MouseHandler.clickType == 1) {
            if(Class57.clickX >= 539 && Class57.clickX <= 573 && RSString.clickY >= 169 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[0] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 0;
            }
            if(Class57.clickX >= 569 && Class57.clickX <= 599 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[1] != -1) {
                Class5.currentTabId = 1;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 597 && Class57.clickX <= 627 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[2] != -1) {
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 2;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 625 && Class57.clickX <= 669 && RSString.clickY >= 168 && RSString.clickY < 203 && Class40_Sub5_Sub11.tabWidgetIds[3] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 3;
            }
            if(Class57.clickX >= 666 && Class57.clickX <= 696 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[4] != -1) {
                Class5.currentTabId = 4;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 694 && Class57.clickX <= 724 && RSString.clickY >= 168 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[5] != -1) {
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 5;
            }
            if(Class57.clickX >= 722 && Class57.clickX <= 756 && RSString.clickY >= 169 && RSString.clickY < 205 && Class40_Sub5_Sub11.tabWidgetIds[6] != -1) {
                ISAAC.redrawTabArea = true;
                Class5.currentTabId = 6;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 540 && Class57.clickX <= 574 && RSString.clickY >= 466 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[7] != -1) {
                Class5.currentTabId = 7;
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 572 && Class57.clickX <= 602 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[8] != -1) {
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 8;
            }
            if(Class57.clickX >= 599 && Class57.clickX <= 629 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[9] != -1) {
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 9;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 627 && Class57.clickX <= 671 && RSString.clickY >= 467 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[10] != -1) {
                Class5.currentTabId = 10;
                IdentityKit.drawTabIcons = true;
                ISAAC.redrawTabArea = true;
            }
            if(Class57.clickX >= 669 && Class57.clickX <= 699 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[11] != -1) {
                Class5.currentTabId = 11;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
            if(Class57.clickX >= 696 && Class57.clickX <= 726 && RSString.clickY >= 466 && RSString.clickY < 503 && Class40_Sub5_Sub11.tabWidgetIds[12] != -1) {
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
                Class5.currentTabId = 12;
            }
            if(Class57.clickX >= 724 && Class57.clickX <= 758 && RSString.clickY >= 466 && RSString.clickY < 502 && Class40_Sub5_Sub11.tabWidgetIds[13] != -1) {
                Class5.currentTabId = 13;
                ISAAC.redrawTabArea = true;
                IdentityKit.drawTabIcons = true;
            }
        }
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
        int[][] clippingPaths = (Landscape.currentCollisionMap[Player.worldLevel].clippingData);
        while(currentIndex != nextIndex) {
            currentY = Wall.walkingQueueY[currentIndex];
            currentX = Class24.walkingQueueX[currentIndex];
            currentIndex = (currentIndex + 1) % maxPathSize;
            if(currentX == endX && currentY == endY) {
                foundDestination = true;
                break;
            }
            if(objectType != 0) {
                if(objectType >= 5 && objectType != 10 || !(Landscape.currentCollisionMap[Player.worldLevel].reachedWall(currentX, currentY, endX, endY, objectType + -1, arg7))) {
                    if(objectType < 10 && (Landscape.currentCollisionMap[Player.worldLevel].reachedWallDecoration(currentX, currentY, endX, endY, -1 + objectType, arg7))) {
                        foundDestination = true;
                        break;
                    }
                } else {
                    foundDestination = true;
                    break;
                }
            }
            if(arg0 != 0 && arg8 != 0 && (Landscape.currentCollisionMap[Player.worldLevel].reachedFacingObject(currentX, currentY, endX, endY, arg0, arg8, arg1))) {
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
            if(currentX < 103 && currentY > 0 && Class57.wayPoints[currentX + 1][-1 + currentY] == 0 && ((clippingPaths[1 + currentX][-1 + currentY] & 0x1280183) == 0) && (clippingPaths[currentX + 1][currentY] & 0x1280180) == 0 && (0x1280102 & clippingPaths[currentX][-1 + currentY]) == 0) {
                Class24.walkingQueueX[nextIndex] = 1 + currentX;
                Wall.walkingQueueY[nextIndex] = currentY - 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Class57.wayPoints[1 + currentX][-1 + currentY] = 9;
                Landscape.distanceValues[currentX + 1][-1 + currentY] = newDistanceValue;
            }
            if(currentX > 0 && currentY < 103 && Class57.wayPoints[currentX + -1][currentY + 1] == 0 && ((0x1280138 & clippingPaths[-1 + currentX][1 + currentY]) == 0) && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
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
                    for(int deviationY = -deviation + endY; (endY + deviation >= deviationY); deviationY++) {
                        if(deviationX >= 0 && deviationY >= 0 && deviationX < 104 && deviationY < 104 && (Landscape.distanceValues[deviationX][deviationY] < 100)) {
                            int i_19_ = 0;
                            int i_20_ = 0;
                            if(deviationY < endY)
                                i_19_ = endY - deviationY;
                            else if(deviationY > endY - (-arg8 + 1))
                                i_19_ = deviationY + -arg8 + -endY + 1;
                            if(deviationX < endX)
                                i_20_ = -deviationX + endX;
                            else if(-1 + arg0 + endX < deviationX)
                                i_20_ = deviationX + (-arg0 + -endX + 1);
                            int i_21_ = i_19_ * i_19_ + i_20_ * i_20_;
                            if(i_14_ > i_21_ || (i_21_ == i_14_ && (((Landscape.distanceValues[deviationX][deviationY]) < maxStepsNonInclusive)))) {
                                currentY = deviationY;
                                i_14_ = i_21_;
                                currentX = deviationX;
                                maxStepsNonInclusive = (Landscape.distanceValues[deviationX][deviationY]);
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
                SceneCluster.packetBuffer.putByte(3 + (maxPathSize + maxPathSize));
            }
            if(clickType == 1) {
                SceneCluster.packetBuffer.putPacket(236);
                SceneCluster.packetBuffer.putByte(14 + maxPathSize + maxPathSize + 3);
            }
            if(clickType == 2) {
                SceneCluster.packetBuffer.putPacket(89);
                SceneCluster.packetBuffer.putByte(3 + (maxPathSize + maxPathSize));
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

    public static void method449() {
        anIntArray1916 = null;
        aClass1_1918 = null;
        aClass1_1917 = null;
        anIntArray1909 = null;
        aClass40_Sub5_Sub14_Sub2_1919 = null;
        aClass1_1905 = null;
        aClass1_1922 = null;
        aClass1_1921 = null;
    }

    public static void method450(byte arg0) {
        if(Player.anInt3288 == 2) {
            if(arg0 >= -28)
                method445(-128);
            Class22_Sub1.method312(2 * ActorDefinition.anInt2404, (Class35.anInt1730 + (-Class26.baseY + Class4.anInt175 << 7)), ((Class68.anInt1637 + -SpotAnimDefinition.baseX) << 7) + Landscape.anInt1170, 4976905);
            if(ISAAC.anInt522 > -1 && Node.pulseCycle % 20 < 10)
                UnderlayDefinition.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
        }
    }

    public void method444(int arg0) {
        int i = 36 / ((arg0 + 76) / 48);
        for(int i_0_ = 0; i_0_ < 10; i_0_++)
            aLongArray1910[i_0_] = 0L;
    }

    public void method443(int arg0) {
        anInt1915 = 256;
        anInt1903 = 0;
        anInt1912 = 1;
        aLong1914 = System.currentTimeMillis();
        for(int i = 0; i < 10; i++)
            aLongArray1910[i] = aLong1914;
        if(arg0 != -10115)
            aClass1_1921 = null;
    }

    public int method442(int arg0, int arg1, int arg2) {
        int i = anInt1912;
        anInt1912 = 1;
        int i_5_ = anInt1915;
        anInt1915 = 300;
        aLong1914 = System.currentTimeMillis();
        if(aLongArray1910[anInt1900] == 0L) {
            anInt1915 = i_5_;
            anInt1912 = i;
        } else if(aLong1914 > aLongArray1910[anInt1900])
            anInt1915 = (int) ((long) (arg0 * 2560) / (-aLongArray1910[anInt1900] + aLong1914));
        if(anInt1915 < 25)
            anInt1915 = 25;
        if(anInt1915 > 256) {
            anInt1915 = 256;
            anInt1912 = (int) ((long) arg0 - (aLong1914 - aLongArray1910[anInt1900]) / 10L);
        }
        if(arg0 < anInt1912)
            anInt1912 = arg0;
        aLongArray1910[anInt1900] = aLong1914;
        anInt1900 = (anInt1900 + 1) % 10;
        if(anInt1912 > 1) {
            for(int i_6_ = 0; i_6_ < 10; i_6_++) {
                if(aLongArray1910[i_6_] != 0L)
                    aLongArray1910[i_6_] = (long) anInt1912 + aLongArray1910[i_6_];
            }
        }
        if(anInt1912 < arg1)
            anInt1912 = arg1;
        Class43.method890((long) anInt1912, arg2 ^ ~0x2613);
        int i_7_ = 0;
        for(/**/; anInt1903 < 256; anInt1903 += anInt1915)
            i_7_++;
        anInt1903 &= 0xff;
        return i_7_;

    }
}
