package org.runejs.client.frame;

import org.runejs.client.Landscape;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Point2d;

public class DebugTools {
    public static boolean walkpathEnabled = false;
    public static int[] walkpathX = null;
    public static int[] walkpathY = null;

    public static void drawWalkPath() {
        if (!walkpathEnabled || walkpathX == null) {
            return;
        }

        int lastTileX = walkpathX[0];
        int lastTileY = walkpathY[0];

        Point2d pathStartPos = MovedStatics.getProjectedScreenPosition(10, lastTileY * 128 + 64, lastTileX * 128 + 64);
        Point2d pathFinishPos = MovedStatics.getProjectedScreenPosition(10, walkpathY[walkpathY.length - 1] * 128 + 64, walkpathX[walkpathX.length - 1] * 128 + 64);

        Point2d lastTilePos = pathStartPos;
        for (int i = 1; i < walkpathX.length; i++) {
            int tileX = walkpathX[i];
            int tileY = walkpathY[i];

            Point2d nextPos = MovedStatics.getProjectedScreenPosition(0, tileY * 128 + 64, tileX * 128 + 64);

            if (lastTilePos != null && nextPos != null) {
                Rasterizer.drawDiagonalLine(lastTilePos.x, lastTilePos.y, nextPos.x, nextPos.y, 0x00FFAC);
            }

            // handle final walkpath label separately to avoid clipping issues
            if (nextPos != null && i != walkpathX.length - 1) {
                TypeFace.fontSmall.drawStringLeft(tileX + "," + tileY, nextPos.x, nextPos.y + 1, 0);
                TypeFace.fontSmall.drawStringLeft(tileX + "," + tileY, nextPos.x, nextPos.y, 0x00AAFF);
            }

            lastTileX = tileX;
            lastTileY = tileY;
            lastTilePos = nextPos;
        }

        if (pathStartPos != null) {
            Rasterizer.drawCircle(pathStartPos.x, pathStartPos.y, 2, 0xE055DE);
            TypeFace.fontSmall.drawStringLeft(walkpathX[0] + "," + walkpathY[0], pathStartPos.x, pathStartPos.y + 1, 0);
            TypeFace.fontSmall.drawStringLeft(walkpathX[0] + "," + walkpathY[0], pathStartPos.x, pathStartPos.y, 0x00AAFF);
        }

        if (pathFinishPos != null) {
            Rasterizer.drawCircle(pathFinishPos.x, pathFinishPos.y, 4, 0xE055DE);
            TypeFace.fontSmall.drawStringLeft(walkpathX[walkpathX.length - 1] + "," + walkpathY[walkpathY.length - 1], pathFinishPos.x, pathFinishPos.y + 1, 0);
            TypeFace.fontSmall.drawStringLeft(walkpathX[walkpathX.length - 1] + "," + walkpathY[walkpathY.length - 1], pathFinishPos.x, pathFinishPos.y, 0x00AAFF);
        }
    }

    public static int clippingRenderDistance = 0;

    public static void drawClipping() {
        if (clippingRenderDistance == 0) {
            return;
        }

        int tileX = Player.localPlayer.worldX >> 7;
        int tileY = Player.localPlayer.worldY >> 7;

        for (int x = Math.max(0, tileX - clippingRenderDistance); x < Math.min(104, tileX + clippingRenderDistance); x++) {
            for (int y = Math.max(0, tileY - clippingRenderDistance); y < Math.min(104, tileY + clippingRenderDistance); y++) {
                int data = Landscape.currentCollisionMap[Player.worldLevel].clippingData[x][y];

                Point2d screenPos = MovedStatics.getProjectedScreenPosition(0, y * 128 + 64, x * 128 + 64);

                if (screenPos == null) {
                    continue;
                }

                Point2d posSW = MovedStatics.getProjectedScreenPosition(0, y * 128, x * 128);
                Point2d posNW = MovedStatics.getProjectedScreenPosition(0, y * 128 + 128, x * 128);
                Point2d posSE = MovedStatics.getProjectedScreenPosition(0, y * 128, x * 128 + 128);
                Point2d posNE = MovedStatics.getProjectedScreenPosition(0, y * 128 + 128, x * 128 + 128);

                Point2d posSWA = MovedStatics.getProjectedScreenPosition(100, y * 128, x * 128);
                Point2d posNWA = MovedStatics.getProjectedScreenPosition(100, y * 128 + 128, x * 128);
                Point2d posSEA = MovedStatics.getProjectedScreenPosition(100, y * 128, x * 128 + 128);
                Point2d posNEA = MovedStatics.getProjectedScreenPosition(100, y * 128 + 128, x * 128 + 128);

                int blockWalkColor = 0xFF0000;
                int blockProjectileColor = 0x539FE9;

                if ((data & 0x2) == 0x2) {
                    if (posNE != null && posNW != null) {
                        Rasterizer.drawDiagonalLine(posNE.x, posNE.y, posNW.x, posNW.y, blockWalkColor);
                    }
                }

                if ((data & 0x8) == 0x8) {
                    if (posSE != null && posNE != null) {
                        Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posNE.x, posNE.y, blockWalkColor);
                    }
                }

                if ((data & 0x20) == 0x20) {
                    if (posSE != null && posSW != null) {
                        Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posSW.x, posSW.y, blockWalkColor);
                    }
                }

                if ((data & 0x80) == 0x80) {
                    if (posSW != null && posNW != null) {
                        Rasterizer.drawDiagonalLine(posSW.x, posSW.y, posNW.x, posNW.y, blockWalkColor);
                    }
                }

                if ((data & 0x100) == 0x100) {
                    if (posNE != null && posNW != null) {
                        Rasterizer.drawDiagonalLine(posNE.x, posNE.y, posNW.x, posNW.y, blockWalkColor);
                    }
                    if (posSE != null && posNE != null) {
                        Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posNE.x, posNE.y, blockWalkColor);
                    }
                    if (posSE != null && posSW != null) {
                        Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posSW.x, posSW.y, blockWalkColor);
                    }
                    if (posSW != null && posNW != null) {
                        Rasterizer.drawDiagonalLine(posSW.x, posSW.y, posNW.x, posNW.y, blockWalkColor);
                    }
                }

                if ((data & 0x400) == 0x400) {
                    if (posNEA != null && posNWA != null) {
                        Rasterizer.drawDiagonalLine(posNEA.x, posNEA.y, posNWA.x, posNWA.y, blockProjectileColor);

                        if (posNE != null) {
                            Rasterizer.drawDiagonalLine(posNE.x, posNE.y, posNEA.x, posNEA.y, blockProjectileColor);
                        }

                        if (posNW != null) {
                            Rasterizer.drawDiagonalLine(posNW.x, posNW.y, posNWA.x, posNWA.y, blockProjectileColor);
                        }
                    }
                }

                if ((data & 0x1000) == 0x1000) {
                    if (posSEA != null && posNEA != null) {
                        Rasterizer.drawDiagonalLine(posSEA.x, posSEA.y, posNEA.x, posNEA.y, blockProjectileColor);
                    }
                }

                if ((data & 0x4000) == 0x4000) {
                    if (posSEA != null && posSWA != null) {
                        Rasterizer.drawDiagonalLine(posSEA.x, posSEA.y, posSWA.x, posSWA.y, blockProjectileColor);
                    }
                }

                if ((data & 0x8000) == 0x8000) {
                    if (posSWA != null && posNWA != null) {
                        Rasterizer.drawDiagonalLine(posSWA.x, posSWA.y, posNWA.x, posNWA.y, blockProjectileColor);
                    }
                }

                if ((data & 0x20000) == 0x20000) {
                    if (posNEA != null && posNWA != null) {
                        Rasterizer.drawDiagonalLine(posNEA.x, posNEA.y, posNWA.x, posNWA.y, blockProjectileColor);

                        if (posNE != null) {
                            Rasterizer.drawDiagonalLine(posNE.x, posNE.y, posNEA.x, posNEA.y, blockProjectileColor);
                        }

                        if (posNW != null) {
                            Rasterizer.drawDiagonalLine(posNW.x, posNW.y, posNWA.x, posNWA.y, blockProjectileColor);
                        }
                    }
                    if (posSEA != null && posNEA != null) {
                        Rasterizer.drawDiagonalLine(posSEA.x, posSEA.y, posNEA.x, posNEA.y, blockProjectileColor);

                        if (posSE != null) {
                            Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posSEA.x, posSEA.y, blockProjectileColor);
                        }

                        if (posNE != null) {
                            Rasterizer.drawDiagonalLine(posNE.x, posNE.y, posNEA.x, posNEA.y, blockProjectileColor);
                        }
                    }
                    if (posSEA != null && posSWA != null) {
                        Rasterizer.drawDiagonalLine(posSEA.x, posSEA.y, posSWA.x, posSWA.y, blockProjectileColor);

                        if (posSE != null) {
                            Rasterizer.drawDiagonalLine(posSE.x, posSE.y, posSEA.x, posSEA.y, blockProjectileColor);
                        }

                        if (posSW != null) {
                            Rasterizer.drawDiagonalLine(posSW.x, posSW.y, posSWA.x, posSWA.y, blockProjectileColor);
                        }
                    }
                    if (posSWA != null && posNWA != null) {
                        Rasterizer.drawDiagonalLine(posSWA.x, posSWA.y, posNWA.x, posNWA.y, blockProjectileColor);

                        if (posSW != null) {
                            Rasterizer.drawDiagonalLine(posSW.x, posSW.y, posSWA.x, posSWA.y, blockProjectileColor);
                        }

                        if (posNW != null) {
                            Rasterizer.drawDiagonalLine(posNW.x, posNW.y, posNWA.x, posNWA.y, blockProjectileColor);
                        }
                    }
                }
            }
        }
    }
}
