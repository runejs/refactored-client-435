/* Class41 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class41 {
    public static int[] anIntArray977 = new int[500];
    public static int[] anIntArray978 = new int[500];
    public static int[] anIntArray979;
    public static int[] anIntArray980 = new int[500];

    static {
        anIntArray979 = new int[500];
    }

    public int anInt981 = -1;
    public int[] anIntArray982;
    public Class40_Sub13 aClass40_Sub13_983 = null;
    public int[] anIntArray984;
    public boolean aBoolean985 = false;
    public int[] anIntArray986;
    public int[] anIntArray987;

    public Class41(byte[] arg0, Class40_Sub13 arg1) {
        aClass40_Sub13_983 = arg1;
        Buffer class40_sub1 = new Buffer(arg0);
        Buffer class40_sub1_0_ = new Buffer(arg0);
        class40_sub1.currentPosition = 2;
        int i = class40_sub1.method468(false);
        int i_1_ = -1;
        int i_2_ = 0;
        class40_sub1_0_.currentPosition = class40_sub1.currentPosition + i;
        for(int i_3_ = 0; i_3_ < i; i_3_++) {
            int i_4_ = class40_sub1.method468(false);
            if(i_4_ > 0) {
                if(aClass40_Sub13_983.anIntArray2178[i_3_] != 0) {
                    for(int i_5_ = i_3_ - 1; i_5_ > i_1_; i_5_--) {
                        if(aClass40_Sub13_983.anIntArray2178[i_5_] == 0) {
                            anIntArray978[i_2_] = i_5_;
                            anIntArray979[i_2_] = 0;
                            anIntArray977[i_2_] = 0;
                            anIntArray980[i_2_] = 0;
                            i_2_++;
                            break;
                        }
                    }
                }
                anIntArray978[i_2_] = i_3_;
                int i_6_ = 0;
                if(aClass40_Sub13_983.anIntArray2178[i_3_] == 3)
                    i_6_ = 128;
                if((i_4_ & 0x1) != 0)
                    anIntArray979[i_2_] = class40_sub1_0_.method482((byte) -116);
                else
                    anIntArray979[i_2_] = i_6_;
                if((i_4_ & 0x2) != 0)
                    anIntArray977[i_2_] = class40_sub1_0_.method482((byte) 114);
                else
                    anIntArray977[i_2_] = i_6_;
                if((i_4_ & 0x4) != 0)
                    anIntArray980[i_2_] = class40_sub1_0_.method482((byte) 113);
                else
                    anIntArray980[i_2_] = i_6_;
                i_1_ = i_3_;
                i_2_++;
                if(aClass40_Sub13_983.anIntArray2178[i_3_] == 5)
                    aBoolean985 = true;
            }
        }
        if(class40_sub1_0_.currentPosition != arg0.length)
            throw new RuntimeException();
        anInt981 = i_2_;
        anIntArray984 = new int[i_2_];
        anIntArray982 = new int[i_2_];
        anIntArray987 = new int[i_2_];
        anIntArray986 = new int[i_2_];
        for(int i_7_ = 0; i_7_ < i_2_; i_7_++) {
            anIntArray984[i_7_] = anIntArray978[i_7_];
            anIntArray982[i_7_] = anIntArray979[i_7_];
            anIntArray987[i_7_] = anIntArray977[i_7_];
            anIntArray986[i_7_] = anIntArray980[i_7_];
        }
    }

    public static void method881() {
        anIntArray978 = null;
        anIntArray979 = null;
        anIntArray977 = null;
        anIntArray980 = null;
    }
}
