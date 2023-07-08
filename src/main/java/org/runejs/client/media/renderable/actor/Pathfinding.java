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
    public static int[][] distanceValues = new int[104][104];
    public static int[][] wayPoints = new int[104][104];
    public static int[] walkingQueueX = new int[4000];
    public static int[] walkingQueueY = new int[4000];
    /**
     * Something to do with whether an extended search was used to find the destination.
     *
     * Used for the "analytics" data sent on minimap walk.
     *
     * TODO investigate and rename
     */
    public static int arbitraryDestination = 0;

    /**
     * Initiate a walk from a tile click.
     */
    public static boolean doTileWalkTo(int startX, int startY, int endX, int endY) {
        return doWalkTo(0, startX, startY, endX, endY, 0, 0, 0, 0, 0, true, null);
    }

    /**
     * Initiate a walk from a minimap click.
     */
    public static boolean doMinimapWalkTo(int startX, int startY, int endX, int endY, MapWalkAnalytics analytics) {
        return doWalkTo(1, startX, startY, endX, endY, 0, 0, 0, 0, 0, true, analytics);
    }

    /**
     * Initiate a walk from clicking on an object.
     */
    public static boolean doObjectWalkTo(int startX, int startY, int endX, int endY, int sizeX, int sizeY, int surroundingsMask, int type, int orientation) {
        return doWalkTo(2, startX, startY, endX, endY, sizeX, sizeY, surroundingsMask, type, orientation, true, null);
    }

    /**
     * Initiate a walk from clicking on an entity (player, npc, world item)
     */
    public static boolean doEntityWalkTo(int startX, int startY, int endX, int endY, int sizeX, int sizeY) {
        return doWalkTo(2, startX, startY, endX, endY, sizeX, sizeY, 0, 0, 0, false, null);
    }

    /**
     * Initiate a walk from clicking on a world item.
     *
     * Tries once to walk right on top of it, then tries to walk one tile away if the first failed.
     */
    public static boolean doWorldItemWalkTo(int startX, int startY, int endX, int endY) {
        boolean success = Pathfinding.doEntityWalkTo(startX, startY, endX, endY, 0, 0);

        if (success) {
            return true;
        }

        return Pathfinding.doEntityWalkTo(startX, startY, endX, endY, 1, 1);
    }

    /**
     *
     * @param clickType
     * @param startX
     * @param startY
     * @param endX
     * @param endY
     * @param goalDX
     * @param goalDY
     * @param surroundingsMask
     * @param objectType
     * @param objectOrientation
     * @param flag Whether the pathfinding should run an extended search to find the destination.
     *             TODO rename this
     * @param analytics The analytics data, or null if none is provided.
     *
     * @return
     */
    public static boolean doWalkTo(int clickType, int startX, int startY, int endX, int endY, int goalDX, int goalDY, int surroundingsMask, int objectType, int objectOrientation, boolean flag, MapWalkAnalytics analytics) {
        for(int x = 0; x < 104; x++) {
            for(int y = 0; y < 104; y++) {
                wayPoints[x][y] = 0b0000;
                distanceValues[x][y] = 99999999;
            }
        }
        int currentX = startX;
        int currentY = startY;
        wayPoints[startX][startY] = (0b0110 << 4) | 0b0011; // why was this value (99) chosen?
        distanceValues[startX][startY] = 0;
        int nextIndex = 0;
        int currentIndex = 0;
        walkingQueueX[nextIndex] = startX;
        walkingQueueY[nextIndex++] = startY;
        boolean foundDestination = false;
        int maxPathSize = walkingQueueX.length;
        int[][] clippingPaths = Landscape.currentCollisionMap[Player.worldLevel].clippingData;
        while(currentIndex != nextIndex) {
            currentY = walkingQueueY[currentIndex];
            currentX = walkingQueueX[currentIndex];
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
            int newDistanceValue = distanceValues[currentX][currentY] + 1;
            if(currentX > 0 && wayPoints[-1 + currentX][currentY] == 0b0000 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0) {
                walkingQueueX[nextIndex] = currentX - 1;
                walkingQueueY[nextIndex] = currentY;
                nextIndex = (1 + nextIndex) % maxPathSize;
                wayPoints[-1 + currentX][currentY] = 0b0010;
                distanceValues[currentX - 1][currentY] = newDistanceValue;
            }
            if(currentX < 103 && wayPoints[currentX + 1][currentY] == 0b0000 && (clippingPaths[1 + currentX][currentY] & 0x1280180) == 0) {
                walkingQueueX[nextIndex] = currentX + 1;
                walkingQueueY[nextIndex] = currentY;
                nextIndex = (nextIndex + 1) % maxPathSize;
                wayPoints[currentX + 1][currentY] = 0b1000;
                distanceValues[currentX + 1][currentY] = newDistanceValue;
            }
            if(currentY > 0 && wayPoints[currentX][currentY - 1] == 0b0000 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
                walkingQueueX[nextIndex] = currentX;
                walkingQueueY[nextIndex] = -1 + currentY;
                wayPoints[currentX][-1 + currentY] = 0b0001;
                nextIndex = (nextIndex + 1) % maxPathSize;
                distanceValues[currentX][currentY - 1] = newDistanceValue;
            }
            if(currentY < 103 && wayPoints[currentX][currentY + 1] == 0b0000 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
                walkingQueueX[nextIndex] = currentX;
                walkingQueueY[nextIndex] = 1 + currentY;
                wayPoints[currentX][currentY + 1] = 0b0100;
                distanceValues[currentX][1 + currentY] = newDistanceValue;
                nextIndex = (nextIndex + 1) % maxPathSize;
            }
            if(currentX > 0 && currentY > 0 && wayPoints[-1 + currentX][currentY - 1] == 0b0000 && (clippingPaths[currentX - 1][-1 + currentY] & 0x128010e) == 0 && (0x1280108 & clippingPaths[currentX + -1][currentY]) == 0 && (clippingPaths[currentX][-1 + currentY] & 0x1280102) == 0) {
                walkingQueueX[nextIndex] = -1 + currentX;
                walkingQueueY[nextIndex] = currentY - 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                wayPoints[currentX + -1][-1 + currentY] = 0b0011;
                distanceValues[-1 + currentX][currentY + -1] = newDistanceValue;
            }
            if(currentX < 103 && currentY > 0 && wayPoints[currentX + 1][-1 + currentY] == 0b0000 && (clippingPaths[1 + currentX][-1 + currentY] & 0x1280183) == 0 && (clippingPaths[currentX + 1][currentY] & 0x1280180) == 0 && (0x1280102 & clippingPaths[currentX][-1 + currentY]) == 0) {
                walkingQueueX[nextIndex] = 1 + currentX;
                walkingQueueY[nextIndex] = currentY - 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                wayPoints[1 + currentX][-1 + currentY] = 0b1001;
                distanceValues[currentX + 1][-1 + currentY] = newDistanceValue;
            }
            if(currentX > 0 && currentY < 103 && wayPoints[currentX + -1][currentY + 1] == 0b0000 && (0x1280138 & clippingPaths[-1 + currentX][1 + currentY]) == 0 && (0x1280108 & clippingPaths[currentX - 1][currentY]) == 0 && (clippingPaths[currentX][currentY + 1] & 0x1280120) == 0) {
                walkingQueueX[nextIndex] = -1 + currentX;
                walkingQueueY[nextIndex] = 1 + currentY;
                wayPoints[currentX - 1][1 + currentY] = 0b0110;
                distanceValues[-1 + currentX][currentY + 1] = newDistanceValue;
                nextIndex = (1 + nextIndex) % maxPathSize;
            }
            if(currentX < 103 && currentY < 103 && wayPoints[1 + currentX][1 + currentY] == 0b0000 && (0x12801e0 & clippingPaths[currentX + 1][currentY + 1]) == 0 && (0x1280180 & clippingPaths[1 + currentX][currentY]) == 0 && (clippingPaths[currentX][1 + currentY] & 0x1280120) == 0) {
                walkingQueueX[nextIndex] = 1 + currentX;
                walkingQueueY[nextIndex] = currentY + 1;
                nextIndex = (nextIndex + 1) % maxPathSize;
                wayPoints[1 + currentX][1 + currentY] = 0b1100;
                distanceValues[1 + currentX][1 + currentY] = newDistanceValue;
            }
        }
        arbitraryDestination = 0;
        if(!foundDestination) {
            if(flag) {
                int i_14_ = 1000;
                int deviation = 10;
                int maxStepsNonInclusive = 100;
                for(int deviationX = endX + -deviation; endX + deviation >= deviationX; deviationX++) {
                    for(int deviationY = -deviation + endY; endY + deviation >= deviationY; deviationY++) {
                        if(deviationX >= 0 && deviationY >= 0 && deviationX < 104 && deviationY < 104 && distanceValues[deviationX][deviationY] < 100) {
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
                            if(i_14_ > i_21_ || i_21_ == i_14_ && distanceValues[deviationX][deviationY] < maxStepsNonInclusive) {
                                currentY = deviationY;
                                i_14_ = i_21_;
                                currentX = deviationX;
                                maxStepsNonInclusive = distanceValues[deviationX][deviationY];
                            }
                        }
                    }
                }
                if(i_14_ == 1000)
                    return false;
                if(startX == currentX && startY == currentY)
                    return false;
                arbitraryDestination = 1;
            } else {
                return false;
            }
        }
        currentIndex = 0;
        walkingQueueX[currentIndex] = currentX;
        walkingQueueY[currentIndex++] = currentY;
        int initialSkipCheck;
        int waypoint = initialSkipCheck = wayPoints[currentX][currentY];
        while(currentX != startX || startY != currentY) {
            if(waypoint != initialSkipCheck) {
                initialSkipCheck = waypoint;
                walkingQueueX[currentIndex] = currentX;
                walkingQueueY[currentIndex++] = currentY;
            }
            if((waypoint & 0b0001) != 0)
                currentY++;
            else if((waypoint & 0b0100) != 0)
                currentY--;
            if((waypoint & 0b0010) != 0)
                currentX++;
            else if((waypoint & 0b1000) != 0)
                currentX--;
            waypoint = wayPoints[currentX][currentY];
        }
        if(currentIndex > 0) {
            maxPathSize = currentIndex;
            if(maxPathSize > 25)
                maxPathSize = 25;
            currentIndex--;
            int x = walkingQueueX[currentIndex];
            int y = walkingQueueY[currentIndex];

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
                int stepX = walkingQueueX[currentIndex] - x;
                int stepY = walkingQueueY[currentIndex] - y;

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

            MovedStatics.destinationX = walkingQueueX[0];
            Class55.destinationY = walkingQueueY[0];

            return true;
        }

        boolean isMapClick = clickType == 1;

        return !isMapClick;
    }

    public static class MapWalkAnalytics {
        /**
         * X coordinate of the click within the minimap
         */
        public final int minimapClickX;

        /**
         * Y coordinate of the click within the minimap
         */
        public final int minimapClickY;

        /**
         * The current randomised zoom level of the minimap
         */
        public final int minimapRandomZoom;

        /**
         * The current randomised rotation of the minimap
         */
        public final int minimapRandomRotation;

        /**
         * The current yaw of the camera
         */
        public final int cameraYaw;

        /**
         * TODO what is this
         */
        public final int worldX;

        /**
         * TODO what is this
         */
        public final int worldY;

        /**
         * Whether the pathfinding algorithm used "deep search" to find a path
         * 
         * TODO improve name
         */
        public final boolean usedDeepSearch;

        /**
         * Magic number, consistent through revisions (57)
         */
        public final int magicA;

        /**
         * Magic number, consistent through revisions (89)
         */
        public final int magicB;

        /**
         * Magic number, consistent through revisions (63)
         */
        public final int magicC;

        public MapWalkAnalytics(int minimapClickX, int minimapClickY, int minimapRandomZoom, int minimapRandomRotation, int cameraYaw, int worldX, int worldY, boolean usedDeepSearch, int magicA, int magicB, int magicC) {
            this.minimapClickX = minimapClickX;
            this.minimapClickY = minimapClickY;
            this.minimapRandomZoom = minimapRandomZoom;
            this.minimapRandomRotation = minimapRandomRotation;
            this.cameraYaw = cameraYaw;
            this.worldX = worldX;
            this.worldY = worldY;
            this.usedDeepSearch = usedDeepSearch;
            this.magicA = magicA;
            this.magicB = magicB;
            this.magicC = magicC;
        }
    }
}
