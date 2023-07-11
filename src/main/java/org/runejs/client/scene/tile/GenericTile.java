package org.runejs.client.scene.tile;

public class GenericTile {
    public int texture;
    public int colourB;
    public int rgbColor;
    public boolean flat;
    public int colourA;
    public int colourC;
    public int colourD;

    public GenericTile(int colourA, int colourB, int colourC, int colourD, int texture, int rgbColor, boolean flat) {
        this.colourA = colourA;
        this.colourB = colourB;
        this.colourC = colourC;
        this.colourD = colourD;
        this.texture = texture;
        this.rgbColor = rgbColor;
        this.flat = flat;
    }
}
