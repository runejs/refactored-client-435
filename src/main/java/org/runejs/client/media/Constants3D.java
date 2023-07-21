package org.runejs.client.media;

public class Constants3D {
    public static int[] cosinetable = new int[2048];
    public static int[] sinetable = new int[2048];
    /**
     * Some kind of colour information, Dane calls this "reciprocal16"
     */
    public static int[] anIntArray2929 = new int[2048];
    public static int[] shadowDecay = new int[512];

    static {
        for(int i = 1; i < 512; i++) {
            Constants3D.shadowDecay[i] = 32768 / i;
        }
        for(int i = 1; i < 2048; i++) {
            Constants3D.anIntArray2929[i] = 65536 / i;
        }
        for(int i = 0; i < 2048; i++) {
            // Pre-calculate sin and cos to save memory
            //
            // Circumference / Cuts = Cut radians
            // Cuts defines how many angles around the circle we want to store, so in this case:
            // PI * 2 / 2048 = 0.0030679615 radians
            //
            // Furthermore, 65536 * x is something we call fixed point arithmetics. It is used to store decimals as an integer instead of a double.
            // 65536 = 2^16, so 16 is the scaling factor
            // The original value can be restored by dividing x by (2^scalingFactor) or just bit-shifting x right by the scaling factor
            // Note that when bit-shifting, you lose all the decimals, and only get the whole number. This is the most common
            // practice wherever the sin and cos tables are used in the client
            //
            // Also, don't forget your basic maths: sin(x) = the length of the opposite side, cos(x) = the length of the adjacent side
            // sin(x) + cos(x) = r
            Constants3D.sinetable[i] = (int) (65536.0 * Math.sin((double) i * 0.0030679615));
            Constants3D.cosinetable[i] = (int) (65536.0 * Math.cos((double) i * 0.0030679615));
        }
    }
}
