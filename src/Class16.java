/* Class16 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class16 {
    public static float aFloat438;
    public static int[][] anIntArrayArray440 = new int[2][8];
    public static float[][] aFloatArrayArray441 = new float[2][8];
    public static int anInt442;
    public int[][][] anIntArrayArrayArray439 = new int[2][2][4];
    public int[] anIntArray443;
    public int[] anIntArray444;
    public int[][][] anIntArrayArrayArray445 = new int[2][2][4];

    public Class16() {
        anIntArray444 = new int[2];
        anIntArray443 = new int[2];
    }

    public static void method268() {
        aFloatArrayArray441 = null;
        anIntArrayArray440 = null;
    }

    public static float method272(float arg0) {
        float f = 32.703197F * (float) Math.pow(2.0, (double) arg0);
        return f * 3.1415927F / 11025.0F;
    }

    public void method267(Buffer arg0, Class7 arg1) {
        int i = arg0.method468(false);
        anIntArray444[0] = i >> 4;
        anIntArray444[1] = i & 0xf;
        if(i != 0) {
            anIntArray443[0] = arg0.method469(65280);
            anIntArray443[1] = arg0.method469(65280);
            int i_0_ = arg0.method468(false);
            for(int i_1_ = 0; i_1_ < 2; i_1_++) {
                for(int i_2_ = 0; i_2_ < anIntArray444[i_1_]; i_2_++) {
                    anIntArrayArrayArray439[i_1_][0][i_2_] = arg0.method469(65280);
                    anIntArrayArrayArray445[i_1_][0][i_2_] = arg0.method469(65280);
                }
            }
            for(int i_3_ = 0; i_3_ < 2; i_3_++) {
                for(int i_4_ = 0; i_4_ < anIntArray444[i_3_]; i_4_++) {
                    if((i_0_ & 1 << i_3_ * 4 << i_4_) != 0) {
                        anIntArrayArrayArray439[i_3_][1][i_4_] = arg0.method469(65280);
                        anIntArrayArrayArray445[i_3_][1][i_4_] = arg0.method469(65280);
                    } else {
                        anIntArrayArrayArray439[i_3_][1][i_4_] = anIntArrayArrayArray439[i_3_][0][i_4_];
                        anIntArrayArrayArray445[i_3_][1][i_4_] = anIntArrayArrayArray445[i_3_][0][i_4_];
                    }
                }
            }
            if(i_0_ != 0 || anIntArray443[1] != anIntArray443[0])
                arg1.method207(arg0);
        } else
            anIntArray443[0] = anIntArray443[1] = 0;
    }

    public float method269(int arg0, int arg1, float arg2) {
        float f = ((float) anIntArrayArrayArray445[arg0][0][arg1] + arg2 * (float) (anIntArrayArrayArray445[arg0][1][arg1] - anIntArrayArrayArray445[arg0][0][arg1]));
        f *= 0.0015258789F;
        return 1.0F - (float) Math.pow(10.0, (double) (-f / 20.0F));
    }

    public int method270(int arg0, float arg1) {
        if(arg0 == 0) {
            float f = ((float) anIntArray443[0] + (float) (anIntArray443[1] - anIntArray443[0]) * arg1);
            f *= 0.0030517578F;
            aFloat438 = (float) Math.pow(0.1, (double) (f / 20.0F));
            anInt442 = (int) (aFloat438 * 65536.0F);
        }
        if(anIntArray444[arg0] == 0)
            return 0;
        float f = method269(arg0, 0, arg1);
        aFloatArrayArray441[arg0][0] = -2.0F * f * (float) Math.cos((double) method271(arg0, 0, arg1));
        aFloatArrayArray441[arg0][1] = f * f;
        for(int i = 1; i < anIntArray444[arg0]; i++) {
            f = method269(arg0, i, arg1);
            float f_5_ = (-2.0F * f * (float) Math.cos((double) method271(arg0, i, arg1)));
            float f_6_ = f * f;
            aFloatArrayArray441[arg0][i * 2 + 1] = aFloatArrayArray441[arg0][i * 2 - 1] * f_6_;
            aFloatArrayArray441[arg0][i * 2] = (aFloatArrayArray441[arg0][i * 2 - 1] * f_5_ + aFloatArrayArray441[arg0][i * 2 - 2] * f_6_);
            for(int i_7_ = i * 2 - 1; i_7_ >= 2; i_7_--)
                aFloatArrayArray441[arg0][i_7_] += (aFloatArrayArray441[arg0][i_7_ - 1] * f_5_ + aFloatArrayArray441[arg0][i_7_ - 2] * f_6_);
            aFloatArrayArray441[arg0][1] += aFloatArrayArray441[arg0][0] * f_5_ + f_6_;
            aFloatArrayArray441[arg0][0] += f_5_;
        }
        if(arg0 == 0) {
            for(int i = 0; i < anIntArray444[0] * 2; i++)
                aFloatArrayArray441[0][i] *= aFloat438;
        }
        for(int i = 0; i < anIntArray444[arg0] * 2; i++)
            anIntArrayArray440[arg0][i] = (int) (aFloatArrayArray441[arg0][i] * 65536.0F);
        return anIntArray444[arg0] * 2;
    }

    public float method271(int arg0, int arg1, float arg2) {
        float f = ((float) anIntArrayArrayArray439[arg0][0][arg1] + arg2 * (float) (anIntArrayArrayArray439[arg0][1][arg1] - anIntArrayArrayArray439[arg0][0][arg1]));
        f *= 1.2207031E-4F;
        return method272(f);
    }
}
