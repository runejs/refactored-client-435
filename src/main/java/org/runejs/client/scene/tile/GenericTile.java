package org.runejs.client.scene.tile;

public class GenericTile {
    public int texture;
    public int colourSE;
    public int rgbColor;
    public boolean flat;
    public int colourSW;
    public int colourNW;
    public int colourNE;

    public GenericTile(int colourSW, int colourSE, int colourNW, int colourNE, int texture, int rgbColor, boolean flat) {
        this.colourSW = colourSW;
        this.colourSE = colourSE;
        this.colourNW = colourNW;
        this.colourNE = colourNE;
        this.texture = texture;
        this.rgbColor = rgbColor;
        this.flat = flat;
    }
}
