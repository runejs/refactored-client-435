package org.runejs.client.media;

public class ColorUtils {
    public static int adjustBrightness(int rgb, double brightness) {
        double r = (double) (rgb >> 16) / 256.0;
        double g = (double) (rgb >> 8 & 0xff) / 256.0;
        double b = (double) (rgb & 0xff) / 256.0;

        r = Math.pow(r, brightness);
        g = Math.pow(g, brightness);
        b = Math.pow(b, brightness);

        int outR = (int) (r * 256.0);
        int outG = (int) (g * 256.0);
        int outB = (int) (b * 256.0);

        return (outR << 16) + (outG << 8) + outB;
    }
}
