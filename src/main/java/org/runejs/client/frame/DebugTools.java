package org.runejs.client.frame;

import org.runejs.client.MovedStatics;
import org.runejs.client.media.Rasterizer;
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

            Point2d nextPos = MovedStatics.getProjectedScreenPosition(10, tileY * 128 + 64, tileX * 128 + 64);

            if (lastTilePos != null && nextPos != null) {
                Rasterizer.drawDiagonalLine(lastTilePos.x, lastTilePos.y, nextPos.x, nextPos.y, 0x00FFAC);
            }

            lastTileX = tileX;
            lastTileY = tileY;
            lastTilePos = nextPos;
        }

        if (pathStartPos != null) {
            Rasterizer.drawCircle(pathStartPos.x, pathStartPos.y, 2, 0xE055DE);
        }

        if (pathFinishPos != null) {
            Rasterizer.drawCircle(pathFinishPos.x, pathFinishPos.y, 4, 0xE055DE);
        }
    }
}
