package org.runejs.client.scene;

import org.runejs.client.LinkedList;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.scene.tile.*;

/**
 * This class was created as a naive attempt at splitting Scene into a renderer and a model.
 * 
 * Please think about what abstractions we can make around this class.
 */
public class SceneRenderer {

    public static int[] WALL_DECORATION_INSET_X = new int[]{53, -53, -53, 53};
    public static int[] WALL_DECORATION_INSET_Y = new int[]{-53, -53, 53, 53};
    public static int[] WALL_DECORATION_OUTSET_X = new int[]{-45, 45, 45, -45};
    public static int[] WALL_DECORATION_OUTSET_Y = new int[]{45, 45, -45, -45};

    public static int[] FRONT_WALL_TYPES = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
    public static int[] DIRECTION_ALLOW_WALL_CORNER_TYPE = new int[]{160, 192, 80, 96, 0, 144, 80, 48, 160};
    public static int[] BACK_WALL_TYPES = new int[]{76, 8, 137, 4, 0, 1, 38, 2, 19};
    public static int[] WALL_CORNER_TYPE_16_BLOCK_OBJ_SPANS = new int[]{0, 0, 2, 0, 0, 2, 1, 1, 0};
    public static int[] WALL_CORNER_TYPE_32_BLOCK_OBJ_SPANS = new int[]{2, 0, 0, 2, 0, 0, 0, 4, 4};
    public static int[] WALL_CORNER_TYPE_64_BLOCK_OBJ_SPANS = new int[]{0, 4, 4, 8, 0, 0, 8, 0, 0};
    public static int[] WALL_CORNER_TYPE_128_BLOCK_OBJ_SPANS = new int[]{1, 1, 0, 0, 0, 8, 0, 0, 8};
    private static final int TILE_DRAW_DISTANCE = 75;

    private final Scene scene;

    private int drawFromTileX;
    private int drawFromTileY;

    private int drawToTileX;
    private int drawToTileY;
    private boolean[][] currentTileVisibilityMap;
    private LinkedList tileList = new LinkedList();

    private int[] screenX = new int[6];
    private int[] screenY = new int[6];
    private int[] viewspaceX = new int[6];
    private int[] viewspaceZ = new int[6];
    private int[] viewspaceY = new int[6];

    private Camera currentCamera;
    private CameraTileVisibility tileVisibilityInfo;

    public SceneRenderer(Scene scene) {
        this.scene = scene;
    }

    public void precalculateTileVisibility(int viewportWidth, int viewportHeight, int minHeight, int maxHeight, int[] heightsForPitch) {
        tileVisibilityInfo = new CameraTileVisibility(viewportWidth, viewportHeight, TILE_DRAW_DISTANCE, minHeight, maxHeight, heightsForPitch);
    }

    public void render(Camera camera, int plane) {
        Point3d cameraPos = camera.getPosition();
        CameraRotation cameraRotation = camera.getRotation();

        currentCamera = camera;

        int cameraPosX = cameraPos.x;
        int cameraPosY = cameraPos.y;
        int cameraPosZ = cameraPos.z;

        // keep the camera within bounds
//        if (cameraPosX < 0) {
//            cameraPosX = 0;
//        } else if (cameraPosX >= mapSizeX * 128) {
//            cameraPosX = mapSizeX * 128 - 1;
//        }
//        if (cameraPosY < 0) {
//            cameraPosY = 0;
//        } else if (cameraPosY >= mapSizeY * 128) {
//            cameraPosY = mapSizeY * 128 - 1;
//        }

        int yaw = cameraRotation.yaw;
        int pitch = cameraRotation.pitch;

        this.scene.cycle++;
        currentTileVisibilityMap = tileVisibilityInfo.visibilityInfo[(pitch - 128) / 32][yaw / 64];
        drawFromTileX = currentCamera.getPosition().tileX - TILE_DRAW_DISTANCE;
        if (drawFromTileX < 0) {
            drawFromTileX = 0;
        }
        drawFromTileY = currentCamera.getPosition().tileY - TILE_DRAW_DISTANCE;
        if (drawFromTileY < 0) {
            drawFromTileY = 0;
        }
        drawToTileX = currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
        if (drawToTileX > this.scene.mapSizeX) {
            drawToTileX = this.scene.mapSizeX;
        }
        drawToTileY = currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
        if (drawToTileY > this.scene.mapSizeY) {
            drawToTileY = this.scene.mapSizeY;
        }
        processCulling(plane);
        this.scene.anInt109 = 0;
        for (int z = this.scene.plane; z < this.scene.mapSizeZ; z++) {
            SceneTile[][] sceneTiles = this.scene.tileArray[z];
            for (int x = drawFromTileX; x < drawToTileX; x++) {
                for (int y = drawFromTileY; y < drawToTileY; y++) {
                    SceneTile sceneTile = sceneTiles[x][y];
                    if (sceneTile != null) {
                        if (sceneTile.drawLevel > plane || !currentTileVisibilityMap[x - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE][y - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE] && this.scene.landscape.tile_height[z][x][y] - cameraPosZ < 70000) {
                            sceneTile.draw = false;
                            sceneTile.visible = false;
                            sceneTile.wallCullDirection = 0;
                        } else {
                            sceneTile.draw = true;
                            sceneTile.visible = true;
                            sceneTile.drawEntities = sceneTile.entityCount > 0;
                            this.scene.anInt109++;
                        }
                    }
                }
            }
        }
        for (int i = this.scene.plane; i < this.scene.mapSizeZ; i++) {
            SceneTile[][] sceneTiles = this.scene.tileArray[i];
            for (int i_25_ = -TILE_DRAW_DISTANCE; i_25_ <= 0; i_25_++) {
                int i_26_ = currentCamera.getPosition().tileX + i_25_;
                int i_27_ = currentCamera.getPosition().tileX - i_25_;
                if (i_26_ >= drawFromTileX || i_27_ < drawToTileX) {
                    for (int i_28_ = -TILE_DRAW_DISTANCE; i_28_ <= 0; i_28_++) {
                        int i_29_ = currentCamera.getPosition().tileY + i_28_;
                        int i_30_ = currentCamera.getPosition().tileY - i_28_;
                        if (i_26_ >= drawFromTileX) {
                            if (i_29_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_29_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                            if (i_30_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_26_][i_30_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                        }
                        if (i_27_ < drawToTileX) {
                            if (i_29_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_29_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                            if (i_30_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_27_][i_30_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, true);
                                }
                            }
                        }
                        if (this.scene.anInt109 == 0) {
                            this.scene.clicked = false;
                            return;
                        }
                    }
                }
            }
        }
        for (int i = this.scene.plane; i < this.scene.mapSizeZ; i++) {
            SceneTile[][] sceneTiles = this.scene.tileArray[i];
            for (int i_31_ = -TILE_DRAW_DISTANCE; i_31_ <= 0; i_31_++) {
                int i_32_ = currentCamera.getPosition().tileX + i_31_;
                int i_33_ = currentCamera.getPosition().tileX - i_31_;
                if (i_32_ >= drawFromTileX || i_33_ < drawToTileX) {
                    for (int i_34_ = -TILE_DRAW_DISTANCE; i_34_ <= 0; i_34_++) {
                        int i_35_ = currentCamera.getPosition().tileY + i_34_;
                        int i_36_ = currentCamera.getPosition().tileY - i_34_;
                        if (i_32_ >= drawFromTileX) {
                            if (i_35_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_35_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                            if (i_36_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_32_][i_36_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                        }
                        if (i_33_ < drawToTileX) {
                            if (i_35_ >= drawFromTileY) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_35_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                            if (i_36_ < drawToTileY) {
                                SceneTile sceneTile = sceneTiles[i_33_][i_36_];
                                if (sceneTile != null && sceneTile.draw) {
                                    renderTile(sceneTile, false);
                                }
                            }
                        }
                        if (this.scene.anInt109 == 0) {
                            this.scene.clicked = false;
                            return;
                        }
                    }
                }
            }
        }
        this.scene.clicked = false;
    }

    private void renderTile(SceneTile _tile, boolean arg1) {
        tileList.addLast(_tile);
        for (; ; ) {
            SceneTile groundTile = (SceneTile) tileList.removeFirst();
            if (groundTile == null) {
                break;
            }
            if (groundTile.visible) {
                int x = groundTile.anInt2061;
                int y = groundTile.anInt2078;
                int z = groundTile.anInt2066;
                int i_78_ = groundTile.anInt2069;
                SceneTile[][] sceneTiles = this.scene.tileArray[z];
                if (groundTile.draw) {
                    if (arg1) {
                        if (z > 0) {
                            SceneTile tile = this.scene.tileArray[z - 1][x][y];
                            if (tile != null && tile.visible) {
                                continue;
                            }
                        }
                        if (x <= currentCamera.getPosition().tileX && x > drawFromTileX) {
                            SceneTile tile = sceneTiles[x - 1][y];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x1) == 0)) {
                                continue;
                            }
                        }
                        if (x >= currentCamera.getPosition().tileX && x < drawToTileX - 1) {
                            SceneTile tile = sceneTiles[x + 1][y];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x4) == 0)) {
                                continue;
                            }
                        }
                        if (y <= currentCamera.getPosition().tileY && y > drawFromTileY) {
                            SceneTile tile = sceneTiles[x][y - 1];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x8) == 0)) {
                                continue;
                            }
                        }
                        if (y >= currentCamera.getPosition().tileY && y < drawToTileY - 1) {
                            SceneTile tile = sceneTiles[x][y + 1];
                            if (tile != null && tile.visible && (tile.draw || (groundTile.interactiveObjectsSizeOR & 0x2) == 0)) {
                                continue;
                            }
                        }
                    } else {
                        arg1 = true;
                    }
                    groundTile.draw = false;
                    if (groundTile.aSceneTile_2058 != null) {
                        SceneTile tile = groundTile.aSceneTile_2058;
                        if (tile.plainTile != null) {
                            if (!this.scene.isTileOccluded(x, y, 0)) {
                                renderPlainTile(tile.plainTile, 0, x, y);
                            }
                        } else if (tile.shapedTile != null && !this.scene.isTileOccluded(x, y, 0)) {
                            renderShapedTile(tile.shapedTile, x, y);
                        }
                        Wall wall = tile.wall;
                        if (wall != null) {
                            wall.primary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                        }
                        for (int e = 0; e < tile.entityCount; e++) {
                            InteractiveObject interactiveObject = tile.interactiveObjects[e];
                            if (interactiveObject != null) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, currentCamera.getRotation(), interactiveObject.worldX - currentCamera.getPosition().x, interactiveObject.worldZ - currentCamera.getPosition().z, interactiveObject.worldY - currentCamera.getPosition().y, interactiveObject.hash);
                            }
                        }
                    }
                    boolean bool = false;
                    if (groundTile.plainTile != null) {
                        if (!this.scene.isTileOccluded(x, y, i_78_)) {
                            bool = true;
                            try {
                                renderPlainTile(groundTile.plainTile, i_78_, x, y);
                            } catch (Exception e) {

                            }
                        }
                    } else if (groundTile.shapedTile != null && !this.scene.isTileOccluded(x, y, i_78_)) {
                        bool = true;
                        renderShapedTile(groundTile.shapedTile, x, y);
                    }
                    int i_86_ = 0;
                    int i_87_ = 0;
                    Wall wall = groundTile.wall;
                    WallDecoration wallDecoration = groundTile.wallDecoration;
                    if (wall != null || wallDecoration != null) {
                        if (currentCamera.getPosition().tileX == x) {
                            i_86_++;
                        } else if (currentCamera.getPosition().tileX < x) {
                            i_86_ += 2;
                        }
                        if (currentCamera.getPosition().tileY == y) {
                            i_86_ += 3;
                        } else if (currentCamera.getPosition().tileY > y) {
                            i_86_ += 6;
                        }
                        i_87_ = FRONT_WALL_TYPES[i_86_];
                        groundTile.anInt2064 = BACK_WALL_TYPES[i_86_];
                    }
                    if (wall != null) {
                        if ((wall.orientationA & DIRECTION_ALLOW_WALL_CORNER_TYPE[i_86_]) != 0) {
                            if (wall.orientationA == 16) {
                                groundTile.wallCullDirection = 3;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_16_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 3 - groundTile.wallUncullDirection;
                            } else if (wall.orientationA == 32) {
                                groundTile.wallCullDirection = 6;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_32_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 6 - groundTile.wallUncullDirection;
                            } else if (wall.orientationA == 64) {
                                groundTile.wallCullDirection = 12;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_64_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 12 - groundTile.wallUncullDirection;
                            } else {
                                groundTile.wallCullDirection = 9;
                                groundTile.wallUncullDirection = WALL_CORNER_TYPE_128_BLOCK_OBJ_SPANS[i_86_];
                                groundTile.wallCullOppositeDirection = 9 - groundTile.wallUncullDirection;
                            }
                        } else {
                            groundTile.wallCullDirection = 0;
                        }
                        if ((wall.orientationA & i_87_) != 0 && !this.scene.isWallOccluded(currentCamera, i_78_, x, y, wall.orientationA)) {
                            wall.primary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                        }
                        if ((wall.orientationB & i_87_) != 0 && !this.scene.isWallOccluded(currentCamera, i_78_, x, y, wall.orientationB)) {
                            wall.secondary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                        }
                    }
                    if (wallDecoration != null && !this.scene.isOccluded(i_78_, x, y, wallDecoration.renderable.modelHeight)) {
                        if ((wallDecoration.configBits & i_87_) != 0) {
                            wallDecoration.renderable.renderAtPoint(wallDecoration.face, currentCamera.getRotation(), wallDecoration.x - currentCamera.getPosition().x, wallDecoration.z - currentCamera.getPosition().z, wallDecoration.y - currentCamera.getPosition().y, wallDecoration.hash);
                        } else if ((wallDecoration.configBits & 0x300) != 0) {
                            int i_88_ = wallDecoration.x - currentCamera.getPosition().x;
                            int i_89_ = wallDecoration.z - currentCamera.getPosition().z;
                            int i_90_ = wallDecoration.y - currentCamera.getPosition().y;
                            int i_91_ = wallDecoration.face;
                            int i_92_;
                            if (i_91_ == 1 || i_91_ == 2) {
                                i_92_ = -i_88_;
                            } else {
                                i_92_ = i_88_;
                            }
                            int i_93_;
                            if (i_91_ == 2 || i_91_ == 3) {
                                i_93_ = -i_90_;
                            } else {
                                i_93_ = i_90_;
                            }
                            if ((wallDecoration.configBits & 0x100) != 0 && i_93_ < i_92_) {
                                int i_94_ = i_88_ + WALL_DECORATION_INSET_X[i_91_];
                                int i_95_ = i_90_ + WALL_DECORATION_INSET_Y[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 256, currentCamera.getRotation(), i_94_, i_89_, i_95_, wallDecoration.hash);
                            }
                            if ((wallDecoration.configBits & 0x200) != 0 && i_93_ > i_92_) {
                                int i_96_ = i_88_ + WALL_DECORATION_OUTSET_X[i_91_];
                                int i_97_ = i_90_ + WALL_DECORATION_OUTSET_Y[i_91_];
                                wallDecoration.renderable.renderAtPoint(i_91_ * 512 + 1280 & 0x7ff, currentCamera.getRotation(), i_96_, i_89_, i_97_, wallDecoration.hash);
                            }
                        }
                    }
                    if (bool) {
                        FloorDecoration floorDecoration = groundTile.floorDecoration;
                        if (floorDecoration != null) {
                            floorDecoration.renderable.renderAtPoint(0, currentCamera.getRotation(), floorDecoration.x - currentCamera.getPosition().x, floorDecoration.z - currentCamera.getPosition().z, floorDecoration.y - currentCamera.getPosition().y, floorDecoration.hash);
                        }
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if (groundItemTile != null && groundItemTile.anInt1371 == 0) {
                            if (groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                            if (groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                            if (groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                        }
                    }
                    int i_98_ = groundTile.interactiveObjectsSizeOR;
                    if (i_98_ != 0) {
                        if (x < currentCamera.getPosition().tileX && (i_98_ & 0x4) != 0) {
                            SceneTile sceneTile_99_ = sceneTiles[x + 1][y];
                            if (sceneTile_99_ != null && sceneTile_99_.visible) {
                                tileList.addLast(sceneTile_99_);
                            }
                        }
                        if (y < currentCamera.getPosition().tileY && (i_98_ & 0x2) != 0) {
                            SceneTile sceneTile_100_ = sceneTiles[x][y + 1];
                            if (sceneTile_100_ != null && sceneTile_100_.visible) {
                                tileList.addLast(sceneTile_100_);
                            }
                        }
                        if (x > currentCamera.getPosition().tileX && (i_98_ & 0x1) != 0) {
                            SceneTile sceneTile_101_ = sceneTiles[x - 1][y];
                            if (sceneTile_101_ != null && sceneTile_101_.visible) {
                                tileList.addLast(sceneTile_101_);
                            }
                        }
                        if (y > currentCamera.getPosition().tileY && (i_98_ & 0x8) != 0) {
                            SceneTile tile = sceneTiles[x][y - 1];
                            if (tile != null && tile.visible) {
                                tileList.addLast(tile);
                            }
                        }
                    }
                }
                if (groundTile.wallCullDirection != 0) {
                    boolean bool = true;
                    for (int i_103_ = 0; i_103_ < groundTile.entityCount; i_103_++) {
                        if (groundTile.interactiveObjects[i_103_].cycle != this.scene.cycle && (groundTile.sceneSpawnRequestsSize[i_103_] & groundTile.wallCullDirection) == groundTile.wallUncullDirection) {
                            bool = false;
                            break;
                        }
                    }
                    if (bool) {
                        Wall wall = groundTile.wall;
                        if (!this.scene.isWallOccluded(currentCamera, i_78_, x, y, wall.orientationA)) {
                            wall.primary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                        }
                        groundTile.wallCullDirection = 0;
                    }
                }
                if (groundTile.drawEntities) {
                    try {
                        int i_104_ = groundTile.entityCount;
                        groundTile.drawEntities = false;
                        int i_105_ = 0;
                        while_2_:
                        for (int i_106_ = 0; i_106_ < i_104_; i_106_++) {
                            InteractiveObject entity = groundTile.interactiveObjects[i_106_];
                            if (entity.cycle != this.scene.cycle) {
                                for (int i_107_ = entity.tileLeft; i_107_ <= entity.tileRight; i_107_++) {
                                    for (int i_108_ = entity.tileTop; i_108_ <= entity.tileBottom; i_108_++) {
                                        SceneTile tile = sceneTiles[i_107_][i_108_];
                                        if (tile.draw) {
                                            groundTile.drawEntities = true;
                                            continue while_2_;
                                        }
                                        if (tile.wallCullDirection != 0) {
                                            int i_110_ = 0;
                                            if (i_107_ > entity.tileLeft) {
                                                i_110_++;
                                            }
                                            if (i_107_ < entity.tileRight) {
                                                i_110_ += 4;
                                            }
                                            if (i_108_ > entity.tileTop) {
                                                i_110_ += 8;
                                            }
                                            if (i_108_ < entity.tileBottom) {
                                                i_110_ += 2;
                                            }
                                            if ((i_110_ & tile.wallCullDirection) == groundTile.wallCullOppositeDirection) {
                                                groundTile.drawEntities = true;
                                                continue while_2_;
                                            }
                                        }
                                    }
                                }
                                this.scene.interactiveObjects[i_105_++] = entity;
                                int i_111_ = currentCamera.getPosition().tileX - entity.tileLeft;
                                int i_112_ = entity.tileRight - currentCamera.getPosition().tileX;
                                if (i_112_ > i_111_) {
                                    i_111_ = i_112_;
                                }
                                int i_113_ = currentCamera.getPosition().tileY - entity.tileTop;
                                int i_114_ = entity.tileBottom - currentCamera.getPosition().tileY;
                                if (i_114_ > i_113_) {
                                    entity.anInt491 = i_111_ + i_114_;
                                } else {
                                    entity.anInt491 = i_111_ + i_113_;
                                }
                            }
                        }
                        while (i_105_ > 0) {
                            int i_115_ = -50;
                            int i_116_ = -1;
                            for (int i_117_ = 0; i_117_ < i_105_; i_117_++) {
                                InteractiveObject interactiveObject = this.scene.interactiveObjects[i_117_];
                                if (interactiveObject.cycle != this.scene.cycle) {
                                    if (interactiveObject.anInt491 > i_115_) {
                                        i_115_ = interactiveObject.anInt491;
                                        i_116_ = i_117_;
                                    } else if (interactiveObject.anInt491 == i_115_) {
                                        int i_118_ = interactiveObject.worldX - currentCamera.getPosition().x;
                                        int i_119_ = interactiveObject.worldY - currentCamera.getPosition().y;
                                        int i_120_ = this.scene.interactiveObjects[i_116_].worldX - currentCamera.getPosition().x;
                                        int i_121_ = this.scene.interactiveObjects[i_116_].worldY - currentCamera.getPosition().y;
                                        if (i_118_ * i_118_ + i_119_ * i_119_ > i_120_ * i_120_ + i_121_ * i_121_) {
                                            i_116_ = i_117_;
                                        }
                                    }
                                }
                            }
                            if (i_116_ == -1) {
                                break;
                            }
                            InteractiveObject interactiveObject = this.scene.interactiveObjects[i_116_];
                            interactiveObject.cycle = this.scene.cycle;
                            if (!this.scene.isAreaOccluded(i_78_, interactiveObject.tileLeft, interactiveObject.tileRight, interactiveObject.tileTop, interactiveObject.tileBottom, interactiveObject.renderable.modelHeight)) {
                                interactiveObject.renderable.renderAtPoint(interactiveObject.rotation, currentCamera.getRotation(), interactiveObject.worldX - currentCamera.getPosition().x, interactiveObject.worldZ - currentCamera.getPosition().z, interactiveObject.worldY - currentCamera.getPosition().y, interactiveObject.hash);
                            }
                            for (int i_122_ = interactiveObject.tileLeft; i_122_ <= interactiveObject.tileRight; i_122_++) {
                                for (int i_123_ = interactiveObject.tileTop; i_123_ <= interactiveObject.tileBottom; i_123_++) {
                                    SceneTile sceneTile_124_ = sceneTiles[i_122_][i_123_];
                                    if (sceneTile_124_.wallCullDirection != 0) {
                                        tileList.addLast(sceneTile_124_);
                                    } else if ((i_122_ != x || i_123_ != y) && sceneTile_124_.visible) {
                                        tileList.addLast(sceneTile_124_);
                                    }
                                }
                            }
                        }
                        if (groundTile.drawEntities) {
                            continue;
                        }
                    } catch (Exception exception) {
                        groundTile.drawEntities = false;
                    }
                }
                if (groundTile.visible) {
                    if (groundTile.wallCullDirection == 0) {
                        if (x <= currentCamera.getPosition().tileX && x > drawFromTileX) {
                            SceneTile sceneTile_125_ = sceneTiles[x - 1][y];
                            if (sceneTile_125_ != null && sceneTile_125_.visible) {
                                continue;
                            }
                        }
                        if (x >= currentCamera.getPosition().tileX && x < drawToTileX - 1) {
                            SceneTile sceneTile_126_ = sceneTiles[x + 1][y];
                            if (sceneTile_126_ != null && sceneTile_126_.visible) {
                                continue;
                            }
                        }
                        if (y <= currentCamera.getPosition().tileY && y > drawFromTileY) {
                            SceneTile sceneTile_127_ = sceneTiles[x][y - 1];
                            if (sceneTile_127_ != null && sceneTile_127_.visible) {
                                continue;
                            }
                        }
                        if (y >= currentCamera.getPosition().tileY && y < drawToTileY - 1) {
                            SceneTile sceneTile_128_ = sceneTiles[x][y + 1];
                            if (sceneTile_128_ != null && sceneTile_128_.visible) {
                                continue;
                            }
                        }
                        groundTile.visible = false;
                        this.scene.anInt109--;
                        GroundItemTile groundItemTile = groundTile.groundItemTile;
                        if (groundItemTile != null && groundItemTile.anInt1371 != 0) {
                            if (groundItemTile.secondGroundItem != null) {
                                groundItemTile.secondGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z - groundItemTile.anInt1371, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                            if (groundItemTile.thirdGroundItem != null) {
                                groundItemTile.thirdGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z - groundItemTile.anInt1371, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                            if (groundItemTile.firstGroundItem != null) {
                                groundItemTile.firstGroundItem.renderAtPoint(0, currentCamera.getRotation(), groundItemTile.x - currentCamera.getPosition().x, groundItemTile.z - currentCamera.getPosition().z - groundItemTile.anInt1371, groundItemTile.y - currentCamera.getPosition().y, groundItemTile.hash);
                            }
                        }
                        if (groundTile.anInt2064 != 0) {
                            WallDecoration wallDecoration = groundTile.wallDecoration;
                            if (wallDecoration != null && !this.scene.isOccluded(i_78_, x, y, wallDecoration.renderable.modelHeight)) {
                                if ((wallDecoration.configBits & groundTile.anInt2064) != 0) {
                                    wallDecoration.renderable.renderAtPoint(wallDecoration.face, currentCamera.getRotation(), wallDecoration.x - currentCamera.getPosition().x, wallDecoration.z - currentCamera.getPosition().z, wallDecoration.y - currentCamera.getPosition().y, wallDecoration.hash);
                                } else if ((wallDecoration.configBits & 0x300) != 0) {
                                    int i_129_ = wallDecoration.x - currentCamera.getPosition().x;
                                    int i_130_ = wallDecoration.z - currentCamera.getPosition().z;
                                    int i_131_ = wallDecoration.y - currentCamera.getPosition().y;
                                    int i_132_ = wallDecoration.face;
                                    int i_133_;
                                    if (i_132_ == 1 || i_132_ == 2) {
                                        i_133_ = -i_129_;
                                    } else {
                                        i_133_ = i_129_;
                                    }
                                    int i_134_;
                                    if (i_132_ == 2 || i_132_ == 3) {
                                        i_134_ = -i_131_;
                                    } else {
                                        i_134_ = i_131_;
                                    }
                                    if ((wallDecoration.configBits & 0x100) != 0 && i_134_ >= i_133_) {
                                        int i_135_ = i_129_ + WALL_DECORATION_INSET_X[i_132_];
                                        int i_136_ = i_131_ + WALL_DECORATION_INSET_Y[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 256, currentCamera.getRotation(), i_135_, i_130_, i_136_, wallDecoration.hash);
                                    }
                                    if ((wallDecoration.configBits & 0x200) != 0 && i_134_ <= i_133_) {
                                        int i_137_ = i_129_ + WALL_DECORATION_OUTSET_X[i_132_];
                                        int i_138_ = i_131_ + WALL_DECORATION_OUTSET_Y[i_132_];
                                        wallDecoration.renderable.renderAtPoint(i_132_ * 512 + 1280 & 0x7ff, currentCamera.getRotation(), i_137_, i_130_, i_138_, wallDecoration.hash);
                                    }
                                }
                            }
                            Wall wall = groundTile.wall;
                            if (wall != null) {
                                if ((wall.orientationB & groundTile.anInt2064) != 0 && !this.scene.isWallOccluded(currentCamera, i_78_, x, y, wall.orientationB)) {
                                    wall.secondary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                                }
                                if ((wall.orientationA & groundTile.anInt2064) != 0 && !this.scene.isWallOccluded(currentCamera, i_78_, x, y, wall.orientationA)) {
                                    wall.primary.renderAtPoint(0, currentCamera.getRotation(), wall.x - currentCamera.getPosition().x, wall.z - currentCamera.getPosition().z, wall.y - currentCamera.getPosition().y, wall.hash);
                                }
                            }
                        }
                        if (z < this.scene.mapSizeZ - 1) {
                            SceneTile sceneTile_139_ = this.scene.tileArray[z + 1][x][y];
                            if (sceneTile_139_ != null && sceneTile_139_.visible) {
                                tileList.addLast(sceneTile_139_);
                            }
                        }
                        if (x < currentCamera.getPosition().tileX) {
                            SceneTile sceneTile_140_ = sceneTiles[x + 1][y];
                            if (sceneTile_140_ != null && sceneTile_140_.visible) {
                                tileList.addLast(sceneTile_140_);
                            }
                        }
                        if (y < currentCamera.getPosition().tileY) {
                            SceneTile sceneTile_141_ = sceneTiles[x][y + 1];
                            if (sceneTile_141_ != null && sceneTile_141_.visible) {
                                tileList.addLast(sceneTile_141_);
                            }
                        }
                        if (x > currentCamera.getPosition().tileX) {
                            SceneTile sceneTile_142_ = sceneTiles[x - 1][y];
                            if (sceneTile_142_ != null && sceneTile_142_.visible) {
                                tileList.addLast(sceneTile_142_);
                            }
                        }
                        if (y > currentCamera.getPosition().tileY) {
                            SceneTile sceneTile_143_ = sceneTiles[x][y - 1];
                            if (sceneTile_143_ != null && sceneTile_143_.visible) {
                                tileList.addLast(sceneTile_143_);
                            }
                        }
                    }
                }
            }
        }
    }

    public void processCulling(int plane) {
        int i = this.scene.cullingClusterPointer[plane];
        SceneCluster[] sceneClusters = this.scene.cullingClusters[plane];
        this.scene.activeOccluderCount = 0;
        for (int i_172_ = 0; i_172_ < i; i_172_++) {
            SceneCluster sceneCluster = sceneClusters[i_172_];
            if (sceneCluster.searchMask == 1) {
                int i_173_ = sceneCluster.tileStartX - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
                if (i_173_ >= 0 && i_173_ <= 50) {
                    int i_174_ = sceneCluster.tileStartY - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
                    if (i_174_ < 0) {
                        i_174_ = 0;
                    }
                    int i_175_ = sceneCluster.tileEndY - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
                    if (i_175_ > 50) {
                        i_175_ = 50;
                    }
                    boolean bool = false;
                    while (i_174_ <= i_175_) {
                        if (currentTileVisibilityMap[i_173_][i_174_++]) {
                            bool = true;
                            break;
                        }
                    }
                    if (bool) {
                        int i_176_ = currentCamera.getPosition().x - sceneCluster.worldStartX;
                        if (i_176_ > 32) {
                            sceneCluster.tileDistanceEnum = 1;
                        } else {
                            if (i_176_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 2;
                            i_176_ = -i_176_;
                        }
                        sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - currentCamera.getPosition().y << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - currentCamera.getPosition().y << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - currentCamera.getPosition().z << 8) / i_176_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - currentCamera.getPosition().z << 8) / i_176_;
                        this.scene.processedCullingClusters[this.scene.activeOccluderCount++] = sceneCluster;
                    }
                }
            } else if (sceneCluster.searchMask == 2) {
                int i_177_ = sceneCluster.tileStartY - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
                if (i_177_ >= 0 && i_177_ <= 50) {
                    int i_178_ = sceneCluster.tileStartX - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
                    if (i_178_ < 0) {
                        i_178_ = 0;
                    }
                    int i_179_ = sceneCluster.tileEndX - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
                    if (i_179_ > 50) {
                        i_179_ = 50;
                    }
                    boolean bool = false;
                    while (i_178_ <= i_179_) {
                        if (currentTileVisibilityMap[i_178_++][i_177_]) {
                            bool = true;
                            break;
                        }
                    }
                    if (bool) {
                        int i_180_ = currentCamera.getPosition().y - sceneCluster.worldStartY;
                        if (i_180_ > 32) {
                            sceneCluster.tileDistanceEnum = 3;
                        } else {
                            if (i_180_ >= -32) {
                                continue;
                            }
                            sceneCluster.tileDistanceEnum = 4;
                            i_180_ = -i_180_;
                        }
                        sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - currentCamera.getPosition().x << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - currentCamera.getPosition().x << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraStartZ = (sceneCluster.worldEndZ - currentCamera.getPosition().z << 8) / i_180_;
                        sceneCluster.worldDistanceFromCameraEndZ = (sceneCluster.worldStartZ - currentCamera.getPosition().z << 8) / i_180_;
                        this.scene.processedCullingClusters[this.scene.activeOccluderCount++] = sceneCluster;
                    }
                }
            } else if (sceneCluster.searchMask == 4) {
                int i_181_ = sceneCluster.worldEndZ - currentCamera.getPosition().z;
                if (i_181_ > 128) {
                    int i_182_ = sceneCluster.tileStartY - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
                    if (i_182_ < 0) {
                        i_182_ = 0;
                    }
                    int i_183_ = sceneCluster.tileEndY - currentCamera.getPosition().tileY + TILE_DRAW_DISTANCE;
                    if (i_183_ > 50) {
                        i_183_ = 50;
                    }
                    if (i_182_ <= i_183_) {
                        int i_184_ = sceneCluster.tileStartX - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
                        if (i_184_ < 0) {
                            i_184_ = 0;
                        }
                        int i_185_ = sceneCluster.tileEndX - currentCamera.getPosition().tileX + TILE_DRAW_DISTANCE;
                        if (i_185_ > 50) {
                            i_185_ = 50;
                        }
                        boolean bool = false;
                        while_3_:
                        for (int i_186_ = i_184_; i_186_ <= i_185_; i_186_++) {
                            for (int i_187_ = i_182_; i_187_ <= i_183_; i_187_++) {
                                if (currentTileVisibilityMap[i_186_][i_187_]) {
                                    bool = true;
                                    break while_3_;
                                }
                            }
                        }
                        if (bool) {
                            sceneCluster.tileDistanceEnum = 5;
                            sceneCluster.worldDistanceFromCameraStartX = (sceneCluster.worldStartX - currentCamera.getPosition().x << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndX = (sceneCluster.worldEndX - currentCamera.getPosition().x << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraStartY = (sceneCluster.worldStartY - currentCamera.getPosition().y << 8) / i_181_;
                            sceneCluster.worldDistanceFromCameraEndY = (sceneCluster.worldEndY - currentCamera.getPosition().y << 8) / i_181_;
                            this.scene.processedCullingClusters[this.scene.activeOccluderCount++] = sceneCluster;
                        }
                    }
                }
            }
        }
    }

    private void renderPlainTile(GenericTile plainTile, int plane, int tileX, int tileY) {
        int nwX;
        int swX = nwX = (tileX << 7) - currentCamera.getPosition().x;
        int seY;
        int swY = seY = (tileY << 7) - currentCamera.getPosition().y;
        int neX;
        int seX = neX = swX + 128;
        int nwY;
        int neY = nwY = swY + 128;
        int swZ = this.scene.landscape.tile_height[plane][tileX][tileY] - currentCamera.getPosition().z;
        int seZ = this.scene.landscape.tile_height[plane][tileX + 1][tileY] - currentCamera.getPosition().z;
        int neZ = this.scene.landscape.tile_height[plane][tileX + 1][tileY + 1] - currentCamera.getPosition().z;
        int nwZ = this.scene.landscape.tile_height[plane][tileX][tileY + 1] - currentCamera.getPosition().z;

        int[] resultA = Util3d.getProjectedPoint(currentCamera, swX, swY, swZ);
        if (resultA == null) {
            return;
        }

        swX = resultA[0];
        swY = resultA[1];
        swZ = resultA[2];

        int[] resultB = Util3d.getProjectedPoint(currentCamera, seX, seY, seZ);
        if (resultB == null) {
            return;
        }

        seX = resultB[0];
        seY = resultB[1];
        seZ = resultB[2];

        int[] resultNE = Util3d.getProjectedPoint(currentCamera, neX, neY, neZ);
        if (resultNE == null) {
            return;
        }

        neX = resultNE[0];
        neY = resultNE[1];
        neZ = resultNE[2];

        int[] resultC = Util3d.getProjectedPoint(currentCamera, nwX, nwY, nwZ);
        if (resultC == null) {
            return;
        }

        nwX = resultC[0];
        nwY = resultC[1];
        nwZ = resultC[2];

        int screenXSW = Rasterizer3D.center_x + (swX << 9) / swY;
        int screenYSW = Rasterizer3D.center_y + (swZ << 9) / swY;
        int screenXSE = Rasterizer3D.center_x + (seX << 9) / seY;
        int screenYSE = Rasterizer3D.center_y + (seZ << 9) / seY;
        int screenXNE = Rasterizer3D.center_x + (neX << 9) / neY;
        int screenYNE = Rasterizer3D.center_y + (neZ << 9) / neY;
        int screenXNW = Rasterizer3D.center_x + (nwX << 9) / nwY;
        int screenYNW = Rasterizer3D.center_y + (nwZ << 9) / nwY;
        Rasterizer3D.alpha = 0;
        if ((screenXNE - screenXNW) * (screenYSE - screenYNW) - (screenYNE - screenYNW) * (screenXSE - screenXNW) > 0) {
            Rasterizer3D.restrict_edges = screenXNE < 0 || screenXNW < 0 || screenXSE < 0 || screenXNE > Rasterizer3D.viewportRx || screenXNW > Rasterizer3D.viewportRx || screenXSE > Rasterizer3D.viewportRx;
            if (this.scene.clicked && isMouseWithinTriangle(this.scene.clickX, this.scene.clickY, screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE)) {
                this.scene.clickedTileX = tileX;
                this.scene.clickedTileY = tileY;
            }
            if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE)) {
                this.scene.hoveredTileX = tileX;
                this.scene.hoveredTileY = tileY;
            }
            if (plainTile.texture == -1) {
                if (plainTile.colourNE != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE, plainTile.colourNE, plainTile.colourNW, plainTile.colourSE);
                }
            } else if (Scene.lowMemory) {
                int rgb = Rasterizer3D.interface3.getAverageTextureColour(plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE, Scene.adjustLightness(rgb, plainTile.colourNE), Scene.adjustLightness(rgb, plainTile.colourNW), Scene.adjustLightness(rgb, plainTile.colourSE));
            } else if (plainTile.flat) {
                Rasterizer3D.drawTexturedTriangle(screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE, plainTile.colourNE, plainTile.colourNW, plainTile.colourSE, swX, seX, nwX, swZ, seZ, nwZ, swY, seY, nwY, plainTile.texture);
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE, plainTile.colourNE, plainTile.colourNW, plainTile.colourSE, neX, nwX, seX, neZ, nwZ, seZ, neY, nwY, seY, plainTile.texture);
            }
        }
        if ((screenXSW - screenXSE) * (screenYNW - screenYSE) - (screenYSW - screenYSE) * (screenXNW - screenXSE) > 0) {
            Rasterizer3D.restrict_edges = screenXSW < 0 || screenXSE < 0 || screenXNW < 0 || screenXSW > Rasterizer3D.viewportRx || screenXSE > Rasterizer3D.viewportRx || screenXNW > Rasterizer3D.viewportRx;
            if (this.scene.clicked && isMouseWithinTriangle(this.scene.clickX, this.scene.clickY, screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW)) {
                this.scene.clickedTileX = tileX;
                this.scene.clickedTileY = tileY;
            }

            if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW)) {
                this.scene.hoveredTileX = tileX;
                this.scene.hoveredTileY = tileY;
            }
            if (plainTile.texture == -1) {
                if (plainTile.colourSW != 12345678) {
                    Rasterizer3D.drawShadedTriangle(screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW, plainTile.colourSW, plainTile.colourSE, plainTile.colourNW);
                }
            } else if (Scene.lowMemory) {
                int i_209_ = Rasterizer3D.interface3.getAverageTextureColour(plainTile.texture);
                Rasterizer3D.drawShadedTriangle(screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW, Scene.adjustLightness(i_209_, plainTile.colourSW), Scene.adjustLightness(i_209_, plainTile.colourSE), Scene.adjustLightness(i_209_, plainTile.colourNW));
            } else {
                Rasterizer3D.drawTexturedTriangle(screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW, plainTile.colourSW, plainTile.colourSE, plainTile.colourNW, swX, seX, nwX, swZ, seZ, nwZ, swY, seY, nwY, plainTile.texture);
            }
        }
    }

    public void renderShapedTile(ComplexTile shapedTile, int tileX, int tileY) {
        int sineX = currentCamera.getRotation().yawSine;
        int cosineX = currentCamera.getRotation().yawCosine;
        int sineY = currentCamera.getRotation().pitchSine;
        int cosineY = currentCamera.getRotation().pitchCosine;

        int triangleCount = shapedTile.originalVertexX.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int viewX = shapedTile.originalVertexX[triangle] - currentCamera.getPosition().x;
            int viewY = shapedTile.originalVertexY[triangle] - currentCamera.getPosition().z;
            int viewZ = shapedTile.originalVertexZ[triangle] - currentCamera.getPosition().y;
            int temp = viewZ * sineX + viewX * cosineX >> 16;
            viewZ = viewZ * cosineX - viewX * sineX >> 16;
            viewX = temp;
            temp = viewY * cosineY - viewZ * sineY >> 16;
            viewZ = viewY * sineY + viewZ * cosineY >> 16;
            viewY = temp;
            if (viewZ < 50) {
                return;
            }
            if (shapedTile.triangleTexture != null) {
                viewspaceX[triangle] = viewX;
                viewspaceY[triangle] = viewY;
                viewspaceZ[triangle] = viewZ;
            }
            screenX[triangle] = Rasterizer3D.center_x + (viewX << 9) / viewZ;
            screenY[triangle] = Rasterizer3D.center_y + (viewY << 9) / viewZ;
        }
        Rasterizer3D.alpha = 0;
        triangleCount = shapedTile.triangleA.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int a = shapedTile.triangleA[triangle];
            int b = shapedTile.triangleB[triangle];
            int c = shapedTile.triangleC[triangle];
            int screenXA = screenX[a];
            int screenXB = screenX[b];
            int screenXC = screenX[c];
            int screenYA = screenY[a];
            int screenYB = screenY[b];
            int screenYC = screenY[c];
            if ((screenXA - screenXB) * (screenYC - screenYB) - (screenYA - screenYB) * (screenXC - screenXB) > 0) {
                Rasterizer3D.restrict_edges = screenXA < 0 || screenXB < 0 || screenXC < 0 || screenXA > Rasterizer3D.viewportRx || screenXB > Rasterizer3D.viewportRx || screenXC > Rasterizer3D.viewportRx;
                if (this.scene.clicked && isMouseWithinTriangle(this.scene.clickX, this.scene.clickY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    this.scene.clickedTileX = tileX;
                    this.scene.clickedTileY = tileY;
                }

                if (isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, screenYA, screenYB, screenYC, screenXA, screenXB, screenXC)) {
                    this.scene.hoveredTileX = tileX;
                    this.scene.hoveredTileY = tileY;
                }

                if (shapedTile.triangleTexture == null || shapedTile.triangleTexture[triangle] == -1) {
                    if (shapedTile.triangleHSLA[triangle] != 0xbc614e) {
                        Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle]);
                    }
                } else if (Scene.lowMemory) {
                    int i_240_ = Rasterizer3D.interface3.getAverageTextureColour(shapedTile.triangleTexture[triangle]);
                    Rasterizer3D.drawShadedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, Scene.adjustLightness(i_240_, shapedTile.triangleHSLA[triangle]), Scene.adjustLightness(i_240_, shapedTile.triangleHSLB[triangle]), Scene.adjustLightness(i_240_, shapedTile.triangleHSLC[triangle]));
                } else if (shapedTile.flat) {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], viewspaceX[0], viewspaceX[1], viewspaceX[3], viewspaceY[0], viewspaceY[1], viewspaceY[3], viewspaceZ[0], viewspaceZ[1], viewspaceZ[3], shapedTile.triangleTexture[triangle]);
                } else {
                    Rasterizer3D.drawTexturedTriangle(screenYA, screenYB, screenYC, screenXA, screenXB, screenXC, shapedTile.triangleHSLA[triangle], shapedTile.triangleHSLB[triangle], shapedTile.triangleHSLC[triangle], viewspaceX[a], viewspaceX[b], viewspaceX[c], viewspaceY[a], viewspaceY[b], viewspaceY[c], viewspaceZ[a], viewspaceZ[b], viewspaceZ[c], shapedTile.triangleTexture[triangle]);
                }
            }
        }
    }

    private boolean isMouseWithinTriangle(int mouseX, int mouseY, int pointAY, int pointBY, int pointCY, int pointAX, int pointBX, int pointCX) {
        if (mouseY < pointAY && mouseY < pointBY && mouseY < pointCY) {
            return false;
        }
        if (mouseY > pointAY && mouseY > pointBY && mouseY > pointCY) {
            return false;
        }
        if (mouseX < pointAX && mouseX < pointBX && mouseX < pointCX) {
            return false;
        }
        if (mouseX > pointAX && mouseX > pointBX && mouseX > pointCX) {
            return false;
        }
        int b1 = (mouseY - pointAY) * (pointBX - pointAX) - (mouseX - pointAX) * (pointBY - pointAY);
        int b2 = (mouseY - pointCY) * (pointAX - pointCX) - (mouseX - pointCX) * (pointAY - pointCY);
        int b3 = (mouseY - pointBY) * (pointCX - pointBX) - (mouseX - pointBX) * (pointCY - pointBY);
        return b1 * b3 > 0 && b3 * b2 > 0;
    }
}
