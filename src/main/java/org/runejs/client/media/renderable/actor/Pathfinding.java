package org.runejs.client.media.renderable.actor;

import org.runejs.client.media.renderable.Item;
import org.runejs.client.message.outbound.WalkOutboundMessage;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.*;

import java.util.ArrayList;
import java.util.List;

public class Pathfinding {
    public static boolean doWalkTo(int clickType, int startX, int startY, int endX, int endY, int goalDX, int goalDY, int surroundingsMask, int objectType, int objectOrientation, boolean flag) {
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                Class57.wayPoints[x][y] = 0b0000;
                Landscape.distanceValues[x][y] = 99999999;
            }
        }
        int currentX = startX;
        int currentY = startY;
        Class57.wayPoints[startX][startY] = (0b0110 << 4) | 0b0011; // why was this value (99) chosen?
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
                if(objectType >= 5 && objectType != 10 || !Landscape.currentCollisionMap[Player.worldLevel].reachedWall(currentX, currentY, endX, endY, objectType + -1, objectOrientation)) {
                    if(objectType < 10 && Landscape.currentCollisionMap[Player.worldLevel].reachedWallDecoration(currentX, currentY, endX, endY, -1 + objectType, objectOrientation)) {
                        foundDestination = true;
                        break;
                    }
                } else {
                    foundDestination = true;
                    break;
                }
            }
            if(goalDX != 0 && goalDY != 0 && Landscape.currentCollisionMap[Player.worldLevel].reachedFacingObject(currentX, currentY, endX, endY, goalDX, goalDY, surroundingsMask)) {
                foundDestination = true;
                break;
            }
            int newDistanceValue = Landscape.distanceValues[currentX][currentY] + 1;
            if(currentX > 0 && Class57.wayPoints[-1 + currentX][currentY] == 0b0000 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0) {
                Class24.walkingQueueX[nextIndex] = currentX - 1;
                Wall.walkingQueueY[nextIndex] = currentY;
                nextIndex = (1 + nextIndex) % maxPathSize;
                Class57.wayPoints[-1 + currentX][currentY] = 0b0010;
                Landscape.distanceValues[currentX - 1][currentY] = newDistanceValue;
            }
            if(currentX < 103 && Class57.wayPoints[currentX + 1][currentY] == 0b0000 && (clippingPaths[1 + currentX][currentY] & 0x1280180) == 0) {
                Class24.walkingQueueX[nextIndex] = currentX + 1;
                Wall.walkingQueueY[nextIndex] = currentY;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Class57.wayPoints[currentX + 1][currentY] = 0b1000;
                Landscape.distanceValues[currentX + 1][currentY] = newDistanceValue;
            }
            if(currentY > 0 && Class57.wayPoints[currentX][currentY - 1] == 0b0000 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
                Class24.walkingQueueX[nextIndex] = currentX;
                Wall.walkingQueueY[nextIndex] = -1 + currentY;
                Class57.wayPoints[currentX][-1 + currentY] = 0b0001;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Landscape.distanceValues[currentX][currentY - 1] = newDistanceValue;
            }
            if(currentY < 103 && Class57.wayPoints[currentX][currentY + 1] == 0b0000 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
                Class24.walkingQueueX[nextIndex] = currentX;
                Wall.walkingQueueY[nextIndex] = 1 + currentY;
                Class57.wayPoints[currentX][currentY + 1] = 0b0100;
                Landscape.distanceValues[currentX][1 + currentY] = newDistanceValue;
                nextIndex = (nextIndex + 1) % maxPathSize;
            }
            if(currentX > 0 && currentY > 0 && Class57.wayPoints[-1 + currentX][currentY - 1] == 0b0000 && (clippingPaths[currentX - 1][-1 + currentY] & 0x128010e) == 0 && (0x1280108 & clippingPaths[currentX + -1][currentY]) == 0 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
                Class24.walkingQueueX[nextIndex] = -1 + currentX;
                Wall.walkingQueueY[nextIndex] = currentY - 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Class57.wayPoints[currentX + -1][-1 + currentY] = 0b0011;
                Landscape.distanceValues[-1 + currentX][currentY + -1] = newDistanceValue;
            }
            if(currentX < 103 && currentY > 0 && Class57.wayPoints[currentX + 1][-1 + currentY] == 0b0000 && (clippingPaths[1 + currentX][-1 + currentY] & 0x1280183) == 0 && (clippingPaths[currentX + 1][currentY] & 0x1280180) == 0 && (0x1280102 & clippingPaths[currentX][-1 + currentY]) == 0) {
                Class24.walkingQueueX[nextIndex] = 1 + currentX;
                Wall.walkingQueueY[nextIndex] = currentY - 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Class57.wayPoints[1 + currentX][-1 + currentY] = 0b1001;
                Landscape.distanceValues[currentX + 1][-1 + currentY] = newDistanceValue;
            }
            if(currentX > 0 && currentY < 103 && Class57.wayPoints[currentX + -1][currentY + 1] == 0b0000 && (0x1280138 & clippingPaths[-1 + currentX][1 + currentY]) == 0 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
                Class24.walkingQueueX[nextIndex] = -1 + currentX;
                Wall.walkingQueueY[nextIndex] = 1 + currentY;
                Class57.wayPoints[currentX - 1][1 + currentY] = 0b0110;
                Landscape.distanceValues[-1 + currentX][currentY + 1] = newDistanceValue;
                nextIndex = (1 + nextIndex) % maxPathSize;
            }
            if(currentX < 103 && currentY < 103 && Class57.wayPoints[1 + currentX][1 + currentY] == 0b0000 && (0x12801e0 & clippingPaths[currentX + 1][currentY + 1]) == 0 && (0x1280180 & clippingPaths[1 + currentX][currentY]) == 0 && (clippingPaths[currentX][1 + currentY] & 0x1280120) == 0) {
                Class24.walkingQueueX[nextIndex] = 1 + currentX;
                Wall.walkingQueueY[nextIndex] = currentY + 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                Class57.wayPoints[1 + currentX][1 + currentY] = 0b1100;
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
                            else if(deviationY > endY - (-goalDY + 1))
                                i_19_ = deviationY + -goalDY + -endY + 1;
                            if(deviationX < endX)
                                i_20_ = -deviationX + endX;
                            else if(-1 + goalDX + endX < deviationX)
                                i_20_ = deviationX + -goalDX + -endX + 1;
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
            if((waypoint & 0b0001) != 0)
                currentY++;
            else if((waypoint & 0b0100) != 0)
                currentY--;
            if((waypoint & 0b0010) != 0)
                currentX++;
            else if((waypoint & 0b1000) != 0)
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

            WalkOutboundMessage.WalkType walkType = WalkOutboundMessage.WalkType.TILE;

            if(clickType == 0) {
                walkType = WalkOutboundMessage.WalkType.TILE;
            }
            else if(clickType == 1) {
                walkType = WalkOutboundMessage.WalkType.MAP;
            }
            else if(clickType == 2) {
                walkType = WalkOutboundMessage.WalkType.INTERACTION;
            }

            List<WalkOutboundMessage.WalkStep> steps = new ArrayList<>();
            for(int counter = 1; maxPathSize > counter; counter++) {
                currentIndex--;
                int stepX = Class24.walkingQueueX[currentIndex] - x;
                int stepY = Wall.walkingQueueY[currentIndex] - y;

                steps.add(new WalkOutboundMessage.WalkStep(stepX, stepY));
            }

            OutgoingPackets.sendMessage(
                new WalkOutboundMessage(
                    walkType,
                    MovedStatics.baseX + x,
                    Class26.baseY + y,
                    Item.obfuscatedKeyStatus[82],
                    steps.toArray(new WalkOutboundMessage.WalkStep[steps.size()])
                )
            );

            MovedStatics.destinationX = Class24.walkingQueueX[0];
            Class55.destinationY = Wall.walkingQueueY[0];

            return true;
        }

        boolean isMapClick = clickType == 1;

        return !isMapClick;
    }
}
