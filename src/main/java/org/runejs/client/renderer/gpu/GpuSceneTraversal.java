package org.runejs.client.renderer.gpu;

import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Point3d;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneRenderer;
import org.runejs.client.scene.Util3d;
import org.runejs.client.scene.camera.Camera;
import org.runejs.client.scene.camera.CameraRotation;
import org.runejs.client.scene.tile.ComplexTile;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.GenericTile;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.tile.Wall;
import org.runejs.client.scene.tile.WallDecoration;

/**
 * The per-frame walk over the scene when the GPU draws it. The depth buffer settles what is in front, so this walk
 * does none of the software renderer's ordering or occlusion work; it visits every tile on a drawn level, far to
 * near as the software walk does so the hover list ends up in the same order, and for each element either
 * streams its model (anything without a static range) or only tests it against the cursor (everything static).
 * Tile hover and click detection are the software renderer's, minus the drawing.
 */
final class GpuSceneTraversal {
    private final ModelEmitter emitter;

    private final int[] screenX = new int[6];
    private final int[] screenY = new int[6];

    private Scene scene;
    private Point3d position;
    private CameraRotation rotation;
    private Camera camera;
    private VertexStream opaque;
    private VertexStream alpha;

    GpuSceneTraversal(ModelEmitter emitter) {
        this.emitter = emitter;
    }

    void run(Scene scene, Camera camera, int plane, VertexStream opaque, VertexStream alpha) {
        this.scene = scene;
        this.camera = camera;
        this.position = camera.getPosition();
        this.rotation = camera.getRotation();
        this.opaque = opaque;
        this.alpha = alpha;
        scene.cycle++;

        int cameraTileX = position.tileX;
        int cameraTileY = position.tileY;
        int sizeX = scene.mapSizeX;
        int sizeY = scene.mapSizeY;
        int reach = Math.max(sizeX, sizeY);
        for (int z = scene.plane; z < scene.mapSizeZ; z++) {
            SceneTile[][] tiles = scene.tileArray[z];
            for (int dx = -reach; dx <= 0; dx++) {
                int westX = cameraTileX + dx;
                int eastX = cameraTileX - dx;
                boolean west = westX >= 0 && westX < sizeX;
                boolean east = dx != 0 && eastX >= 0 && eastX < sizeX;
                if (!west && !east) {
                    continue;
                }
                for (int dy = -reach; dy <= 0; dy++) {
                    int southY = cameraTileY + dy;
                    int northY = cameraTileY - dy;
                    boolean south = southY >= 0 && southY < sizeY;
                    boolean north = dy != 0 && northY >= 0 && northY < sizeY;
                    if (west) {
                        if (south) {
                            visit(tiles[westX][southY], plane);
                        }
                        if (north) {
                            visit(tiles[westX][northY], plane);
                        }
                    }
                    if (east) {
                        if (south) {
                            visit(tiles[eastX][southY], plane);
                        }
                        if (north) {
                            visit(tiles[eastX][northY], plane);
                        }
                    }
                }
            }
        }
        scene.clicked = false;
    }

    private void visit(SceneTile tile, int plane) {
        if (tile == null || tile.drawLevel > plane) {
            return;
        }
        visitContents(tile);
        if (tile.aSceneTile_2058 != null) {
            visitContents(tile.aSceneTile_2058);
        }
    }

    private void visitContents(SceneTile tile) {
        int x = tile.anInt2061;
        int y = tile.anInt2078;
        if (tile.plainTile != null) {
            hoverPlainTile(tile.plainTile, tile.anInt2069, x, y);
        } else if (tile.shapedTile != null) {
            hoverShapedTile(tile.shapedTile, x, y);
        }
        Wall wall = tile.wall;
        if (wall != null) {
            element(wall.primary, 0, wall.x, wall.z, wall.y, wall.hash, wall.gpuPrimary);
            element(wall.secondary, 0, wall.x, wall.z, wall.y, wall.hash, wall.gpuSecondary);
        }
        WallDecoration decoration = tile.wallDecoration;
        if (decoration != null) {
            int face = decoration.face;
            if ((decoration.configBits & 0x300) == 0) {
                element(decoration.renderable, face, decoration.x, decoration.z, decoration.y, decoration.hash, decoration.gpu);
            } else {
                element(decoration.renderable, face * 512 + 256,
                        decoration.x + SceneRenderer.WALL_DECORATION_INSET_X[face], decoration.z, decoration.y + SceneRenderer.WALL_DECORATION_INSET_Y[face],
                        decoration.hash, decoration.gpu);
                element(decoration.renderable, face * 512 + 1280 & 0x7ff,
                        decoration.x + SceneRenderer.WALL_DECORATION_OUTSET_X[face], decoration.z, decoration.y + SceneRenderer.WALL_DECORATION_OUTSET_Y[face],
                        decoration.hash, decoration.gpuOutset);
            }
        }
        FloorDecoration floor = tile.floorDecoration;
        if (floor != null) {
            element(floor.renderable, 0, floor.x, floor.z, floor.y, floor.hash, floor.gpu);
        }
        GroundItemTile items = tile.groundItemTile;
        if (items != null) {
            int height = items.z - items.anInt1371;
            element(items.secondGroundItem, 0, items.x, height, items.y, items.hash, null);
            element(items.thirdGroundItem, 0, items.x, height, items.y, items.hash, null);
            element(items.firstGroundItem, 0, items.x, height, items.y, items.hash, null);
        }
        for (int e = 0; e < tile.entityCount; e++) {
            InteractiveObject entity = tile.interactiveObjects[e];
            if (entity == null || entity.cycle == scene.cycle) {
                continue;
            }
            entity.cycle = scene.cycle;
            element(entity.renderable, entity.rotation, entity.worldX, entity.worldZ, entity.worldY, entity.hash, entity.gpu);
        }
    }

    /**
     * One placed model. Static ones are already on the GPU and only need the cursor test; the rest are streamed.
     *
     * @param x      world east coordinate of the model origin
     * @param height world height of the model origin
     * @param north  world north coordinate of the model origin
     */
    private void element(Renderable renderable, int modelRotation, int x, int height, int north, int hash, StaticRange range) {
        if (renderable == null) {
            return;
        }
        Model model = renderable instanceof Model ? (Model) renderable : renderable.getRotatedModel();
        if (model == null) {
            return;
        }
        model.method799();
        renderable.modelHeight = model.modelHeight;
        int dx = x - position.x;
        int dh = height - position.z;
        int dn = north - position.y;
        int bounds = model.testBounds(modelRotation, rotation, dx, dh, dn, hash);
        if ((bounds & Model.VISIBLE) == 0) {
            return;
        }
        if ((bounds & Model.CURSOR_INSIDE) != 0) {
            model.projectVertices(modelRotation, rotation, dx, dh, dn, false);
            model.hitTestFaces(hash);
        }
        if (range == null) {
            emitter.emit(model, modelRotation, x, height, north, opaque, alpha);
        }
    }

    private void hoverPlainTile(GenericTile tile, int plane, int tileX, int tileY) {
        int[][] heights = scene.landscape.tile_height[plane];
        int swX = (tileX << 7) - position.x;
        int swY = (tileY << 7) - position.y;
        int neX = swX + 128;
        int neY = swY + 128;
        int[] sw = Util3d.getProjectedPoint(camera, swX, swY, heights[tileX][tileY] - position.z);
        if (sw == null) {
            return;
        }
        int[] se = Util3d.getProjectedPoint(camera, neX, swY, heights[tileX + 1][tileY] - position.z);
        if (se == null) {
            return;
        }
        int[] ne = Util3d.getProjectedPoint(camera, neX, neY, heights[tileX + 1][tileY + 1] - position.z);
        if (ne == null) {
            return;
        }
        int[] nw = Util3d.getProjectedPoint(camera, swX, neY, heights[tileX][tileY + 1] - position.z);
        if (nw == null) {
            return;
        }
        int screenXSW = Rasterizer3D.center_x + (sw[0] << 9) / sw[1];
        int screenYSW = Rasterizer3D.center_y + (sw[2] << 9) / sw[1];
        int screenXSE = Rasterizer3D.center_x + (se[0] << 9) / se[1];
        int screenYSE = Rasterizer3D.center_y + (se[2] << 9) / se[1];
        int screenXNE = Rasterizer3D.center_x + (ne[0] << 9) / ne[1];
        int screenYNE = Rasterizer3D.center_y + (ne[2] << 9) / ne[1];
        int screenXNW = Rasterizer3D.center_x + (nw[0] << 9) / nw[1];
        int screenYNW = Rasterizer3D.center_y + (nw[2] << 9) / nw[1];
        if ((screenXNE - screenXNW) * (screenYSE - screenYNW) - (screenYNE - screenYNW) * (screenXSE - screenXNW) > 0) {
            hoverTriangle(tileX, tileY, screenYNE, screenYNW, screenYSE, screenXNE, screenXNW, screenXSE);
        }
        if ((screenXSW - screenXSE) * (screenYNW - screenYSE) - (screenYSW - screenYSE) * (screenXNW - screenXSE) > 0) {
            hoverTriangle(tileX, tileY, screenYSW, screenYSE, screenYNW, screenXSW, screenXSE, screenXNW);
        }
    }

    private void hoverShapedTile(ComplexTile tile, int tileX, int tileY) {
        int vertexCount = tile.originalVertexX.length;
        for (int vertex = 0; vertex < vertexCount; vertex++) {
            int[] projected = Util3d.getProjectedPoint(camera,
                    tile.originalVertexX[vertex] - position.x,
                    tile.originalVertexZ[vertex] - position.y,
                    tile.originalVertexY[vertex] - position.z);
            if (projected == null) {
                return;
            }
            screenX[vertex] = Rasterizer3D.center_x + (projected[0] << 9) / projected[1];
            screenY[vertex] = Rasterizer3D.center_y + (projected[2] << 9) / projected[1];
        }
        int triangleCount = tile.triangleA.length;
        for (int triangle = 0; triangle < triangleCount; triangle++) {
            int a = tile.triangleA[triangle];
            int b = tile.triangleB[triangle];
            int c = tile.triangleC[triangle];
            if ((screenX[a] - screenX[b]) * (screenY[c] - screenY[b]) - (screenY[a] - screenY[b]) * (screenX[c] - screenX[b]) > 0) {
                hoverTriangle(tileX, tileY, screenY[a], screenY[b], screenY[c], screenX[a], screenX[b], screenX[c]);
            }
        }
    }

    private void hoverTriangle(int tileX, int tileY, int yA, int yB, int yC, int xA, int xB, int xC) {
        if (scene.clicked && SceneRenderer.isMouseWithinTriangle(scene.clickX, scene.clickY, yA, yB, yC, xA, xB, xC)) {
            scene.clickedTileX = tileX;
            scene.clickedTileY = tileY;
        }
        if (SceneRenderer.isMouseWithinTriangle(MouseHandler.mouseX, MouseHandler.mouseY, yA, yB, yC, xA, xB, xC)) {
            scene.hoveredTileX = tileX;
            scene.hoveredTileY = tileY;
        }
    }
}
