package org.runejs.client.frame;

/**
 * Represents an anchor for a {@link FramePieceRenderer},
 * i.e. the position of the piece relative to the overall window.
 */
public class FramePieceAnchor {
    /**
     * The different anchor types.
     * 
     * These are bit flags, so they can be combined.
     */
    public static class Anchor {
        public static final int LEFT   = 0b0001;
        public static final int RIGHT  = 0b0010;
        public static final int TOP    = 0b0100;
        public static final int BOTTOM = 0b1000;
    }

    /**
     * The anchor type, composed of the {@link Anchor} flags.
     */
    public final int anchor;

    /**
     * The margin from the anchor in the X direction.
     */
    public final int marginX;

    /**
     * The margin from the anchor in the Y direction.
     */
    public final int marginY;

    public FramePieceAnchor(int anchor, int marginX, int marginY) {
        this.anchor = anchor;
        this.marginX = marginX;
        this.marginY = marginY;
    }

    /**
     * Gets the position of the piece relative to the overall window.
     * 
     * @param drawWidth The width of the window.
     * @param drawHeight The height of the window.
     * @param sizeX The width of the piece.
     * @param sizeY The height of the piece.
     * @return The position of the piece.
     */
    public int[] getPosition(int drawWidth, int drawHeight, int sizeX, int sizeY) {
        int x = 0;
        int y = 0;

        if ((anchor & Anchor.LEFT) == Anchor.LEFT) {
            x = marginX;
        } else if ((anchor & Anchor.RIGHT) == Anchor.RIGHT) {
            x = drawWidth - sizeX - marginX;
        }

        if ((anchor & Anchor.TOP) == Anchor.TOP) {
            y = marginY;
        } else if ((anchor & Anchor.BOTTOM) == Anchor.BOTTOM) {
            y = drawHeight - sizeY - marginY;
        }

        return new int[]{x, y};
    }
}
