package org.runejs.client.util;

import org.runejs.client.media.Rasterizer3D;

/**
 * Perlin noise, used in the client for procedural terrain heightmap.
 */
public class PerlinNoise {
    public static int get(int x, int y, int scale) {
        int muX = x & -1 + scale;
        int scaledY = y / scale;
        int muY = scale - 1 & y;
        int scaledX = x / scale;
        int a = randomNoiseWeightedSum(scaledX, scaledY);
        int b = randomNoiseWeightedSum(1 + scaledX, scaledY);
        int c = randomNoiseWeightedSum(scaledX, 1 + scaledY);
        int d = randomNoiseWeightedSum(1 + scaledX, 1 + scaledY);
        int i1 = interpolateForPerlin(a, scale, b, true, muX);
        int i2 = interpolateForPerlin(c, scale, d, true, muX);
        return interpolateForPerlin(i1, scale, i2, true, muY);
    }

    private static int interpolateForPerlin(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if (!arg3)
            return -109;
        int i = 65536 + -Rasterizer3D.cosinetable[1024 * arg4 / arg1] >> 1;
        return ((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16);
    }

    private static int randomNoiseWeightedSum(int arg1, int arg2) {
        int i = randomNoise(-1 + arg1, -1 + arg2) + randomNoise(1 + arg1, arg2 - 1) + randomNoise(-1 + arg1, 1 + arg2) + randomNoise(1 + arg1, arg2 + 1);
        int i_126_ = randomNoise(arg1 - 1, arg2) + randomNoise(arg1 + 1, arg2) - (-randomNoise(arg1, arg2 - 1) + -randomNoise(arg1, 1 + arg2));
        int i_127_ = randomNoise(arg1, arg2);
        return i / 16 - (-(i_126_ / 8) - i_127_ / 4);
    }

    private static int randomNoise(int x, int y) {
        int i = 57 * y + x;
        i ^= i << 13;
        int i_2_ = 1376312589 + (i * i * 15731 + 789221) * i & 0x7fffffff;
        return i_2_ >> 19 & 0xff;
    }
}
