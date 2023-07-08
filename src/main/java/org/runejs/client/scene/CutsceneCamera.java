package org.runejs.client.scene;

public class CutsceneCamera {
    /**
     * The X coordinate of the tile that the camera is currently located above.
     */
    public int tilePosX;
    /**
     * The Y coordinate of the tile that the camera is currently located above.
     */
    public int tilePosY;
    /**
     * The current height of the camera.
     */
    public int height;

    /**
     * The X coordinate of the tile that the camera is currently looking at.
     */
    public int lookToTileX;

    /**
     * The Y coordinate of the tile that the camera is currently looking at.
     */
    public int lookToTileY;

    /**
     * The height that the camera is currently looking at.
     */
    public int lookToHeight;
}
