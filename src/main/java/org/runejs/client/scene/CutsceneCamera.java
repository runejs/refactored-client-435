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
     * The base step value added to cutscene camera position movement.
     */
    public int positionBaseAdjust;

    /**
     * The scaling step value added to cutscene camera position movements.
     *
     * Multiplies the difference between the current and target position.
     */
    public int positionScaleAdjust;

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

    /**
     * The base step value added to cutscene camera rotations.
     */
    public int rotationBaseAdjust;

    /**
     * The scaling step value added to cutscene camera rotations.
     *
     * Multiplies the difference between the current and target rotation.
     */
    public int rotationScaleAdjust;
}
