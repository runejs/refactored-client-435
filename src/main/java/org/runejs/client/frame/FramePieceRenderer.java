package org.runejs.client.frame;

import org.runejs.client.Game;
import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.media.RasterizerInstanced;

public abstract class FramePieceRenderer {
    protected RasterizerInstanced rasterizerInstanced;

    public final FramePieceAnchor anchor;
    public final int width;
    public final int height;

    public FramePieceRenderer(FramePieceAnchor anchor, int width, int height) {
        this.anchor = anchor;
        this.width = width;
        this.height = height;

        // TODO inject this, sometimes needs to be GameShell.game or something
        ProducingGraphicsBuffer graphics = MovedStatics.createGraphicsBuffer(width, height, Game.gameCanvas);
        this.rasterizerInstanced = new RasterizerInstanced(graphics);
    }

    /**
     * Draws the piece to the game screen.
     *
     * @param drawWidth The width of the window.
     * @param drawHeight The height of the window.
     */
    public void draw(RasterizerInstanced destination, int drawWidth, int drawHeight) {
        int[] position = this.anchor.getPosition(drawWidth, drawHeight, width, height);

        int x = position[0];
        int y = position[1];

        destination.copyPixels(rasterizerInstanced.destinationPixels, width, height, x, y);
    }

    /**
     * Copies the pixels from a ProducingGraphicsBuffer to the rasterizer.
     * 
     * See {@link RasterizerInstanced#copyPixels} for more information.
     * 
     * @param producer The ProducingGraphicsBuffer to copy from.
     * @param x The X position to copy to.
     * @param y The Y position to copy to.
     */
    protected void copyProducer(ProducingGraphicsBuffer producer, int x, int y) {
        rasterizerInstanced.copyPixels(producer.pixels, producer.width, producer.height, x, y);
    }

    /**
     * Copies the pixels from a ProducingGraphicsBuffer to the rasterizer.
     * 
     * See {@link RasterizerInstanced#copyPixelsCutOff} for more information.
     * 
     * @param producer The ProducingGraphicsBuffer to copy from.
     * @param x The X position to copy to.
     * @param y The Y position to copy to.
     * @param width The width of the area to copy.
     * @param height The height of the area to copy.
     * @param offsetX The X offset to copy from.
     * @param offsetY The Y offset to copy from.
     */
    protected void copyProducerCutOff(ProducingGraphicsBuffer producer, int x, int y, int width, int height, int offsetX, int offsetY) {
        rasterizerInstanced.copyPixelsCutOff(producer.pixels, producer.width, producer.height, x, y, width, height, offsetX, offsetY);
    }
}
