package org.runejs.client.media;

public class Palette {
    public final int[] hsl2rgb;

    public Palette(int[] hsl2rgb) {
        this.hsl2rgb = hsl2rgb;
    }

    public static Palette create(double brightness) {
        int[] hsl2rgb = new int[65536];

        brightness += Math.random() * 0.03 - 0.015;
        int index = 0;

        for(int y = 0; y < 512; y++) {
            double hue = (double) (y >> 3) / 64.0 + 0.0078125;
            double lightness = (double) (y & 0x7) / 8.0 + 0.0625;

            for(int x = 0; x < 128; x++) {
                double intensity = (double) x / 128.0;
                double red = intensity;
                double green = intensity;
                double blue = intensity;

                if(lightness != 0.0) {
                    double a;
                    if(intensity < 0.5) {
                        a = intensity * (1.0 + lightness);
                    } else {
                        a = intensity + lightness - intensity * lightness;
                    }
                    double b = 2.0 * intensity - a;
                    double fRed = hue + 0.3333333333333333;
                    if(fRed > 1.0) {
                        fRed--;
                    }
                    double fGreen = hue;
                    double fBlue = hue - 0.3333333333333333;
                    if(fBlue < 0.0) {
                        fBlue++;
                    }
                    if(6.0 * fRed < 1.0) {
                        red = b + (a - b) * 6.0 * fRed;
                    } else if(2.0 * fRed < 1.0) {
                        red = a;
                    } else if(3.0 * fRed < 2.0) {
                        red = b + (a - b) * (0.6666666666666666 - fRed) * 6.0;
                    } else {
                        red = b;
                    }
                    if(6.0 * fGreen < 1.0) {
                        green = b + (a - b) * 6.0 * fGreen;
                    } else if(2.0 * fGreen < 1.0) {
                        green = a;
                    } else if(3.0 * fGreen < 2.0) {
                        green = b + (a - b) * (0.6666666666666666 - fGreen) * 6.0;
                    } else {
                        green = b;
                    }
                    if(6.0 * fBlue < 1.0) {
                        blue = b + (a - b) * 6.0 * fBlue;
                    } else if(2.0 * fBlue < 1.0) {
                        blue = a;
                    } else if(3.0 * fBlue < 2.0) {
                        blue = b + (a - b) * (0.6666666666666666 - fBlue) * 6.0;
                    } else {
                        blue = b;
                    }
                }

                int outR = ((int) (red * 256.0) << 16);
                int outG = ((int) (green * 256.0) << 8);
                int outB = ((int) (blue * 256.0));

                int rgb = outR | outG | outB;
                rgb = ColorUtils.adjustBrightness(rgb, brightness);

                if(rgb == 0) {
                    rgb = 1;
                }

                hsl2rgb[index++] = rgb;
            }
        }

        return new Palette(hsl2rgb);
    }
}
