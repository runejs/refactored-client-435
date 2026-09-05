package org.runejs.client;

public interface Interface3 {
    int[] getTexturePixels(int textureId);

    boolean isTextureOpaque(int textureId);

    int getAverageTextureColour(int i);

    boolean method15();

    /**
     * How many texture ids there are, whether or not each one is defined.
     */
    int textureCount();

    /**
     * Whether the texture scrolls over time (water, lava), so a copy of its pixels goes stale.
     */
    boolean isTextureAnimated(int textureId);
}
