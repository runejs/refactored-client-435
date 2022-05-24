package org.runejs.client.sound;

public abstract class Class22_Sub2 extends Class22 {
    public static int[] anIntArray774 = new int[]{12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800};


    public static int method323(int arg0) {
        int i = anIntArray774[arg0];
        i = (i * Class22_Sub2.anInt1040 >> 8) * i;
        return (int) (Math.sqrt(i) + 0.5);
    }

	public static int[] anIntArray889 = new int[128];
	public static int anInt1040 = 256;

    public abstract void method314(int i, int i_0_, int i_1_, long l);

    public void method317(int arg0, int arg1, long arg2) {
        do {
            arg0 = (int) ((double) arg0 * Math.pow(0.1, (double) arg1 * 5.0E-4) + 0.5);
            if(arg0 != Class22_Sub2.anInt1040) {
                Class22_Sub2.anInt1040 = arg0;
                for(int i = 0; i < 16; i++) {
                    int i_2_ = method323(i);
                    method314(176 + i, 7, i_2_ >> 7, arg2);
                    method314(176 + i, 39, i_2_ & 0x7f, arg2);
                }
            }
            break;
        } while(false);
    }

    public void method318(long arg1, int arg2) {
        Class22_Sub2.anInt1040 = arg2;
        for(int i = 0; i < 16; i++)
            anIntArray774[i] = 12800;
        for(int i = 0; i < 16; i++) {
            int i_3_ = method323(i);
            method314(176 + i, 7, i_3_ >> 7, arg1);
            method314(176 + i, 39, 0x7f & i_3_, arg1);
        }
    }

    public void method321(long arg1) {
        for(int i = 0; i < 128; i++) {
            int i_6_ = Class22_Sub2.anIntArray889[i];
            Class22_Sub2.anIntArray889[i] = 0;
            for(int i_7_ = 0; i_7_ < 16; i_7_++) {
                if((i_6_ & 1 << i_7_) != 0)
                    method314(144 + i_7_, i, 0, arg1);
            }
        }
        for(int i = 0; i < 16; i++)
            method314(i + 176, 123, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 120, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 121, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 0, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(176 + i, 32, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 192, 0, 0, arg1);
    }

    public boolean method322(int arg0, int arg1, int arg2, long arg3) {
        if((arg0 & 0xe0) == 128) {
            int i = 1 << (arg0 & 0xf);
            int i_8_ = Class22_Sub2.anIntArray889[arg1];
            if(arg0 >= 144 && arg2 != 0) {
                if((i_8_ & i) != 0)
                    method314(arg0, arg1, 0, arg3);
                else
                    Class22_Sub2.anIntArray889[arg1] = i_8_ | i;
            } else
                Class22_Sub2.anIntArray889[arg1] = i_8_ & (i ^ 0xffffffff);
            return false;
        }
        if((arg0 & 0xf0) == 176) {
            if(arg1 == 121) {
                method314(arg0, arg1, arg2, arg3);
                int i = arg0 & 0xf;
                anIntArray774[i] = 12800;
                int i_9_ = method323(i);
                method314(arg0, 7, i_9_ >> 7, arg3);
                method314(arg0, 39, i_9_ & 0x7f, arg3);
                return true;
            }
            if(arg1 == 7 || arg1 == 39) {
                int i = arg0 & 0xf;
                if(arg1 == 7)
                    anIntArray774[i] = (anIntArray774[i] & 0x7f) + (arg2 << 7);
                else
                    anIntArray774[i] = (anIntArray774[i] & 0x3f80) + arg2;
                int i_10_ = method323(i);
                method314(arg0, 7, i_10_ >> 7, arg3);
                method314(arg0, 39, i_10_ & 0x7f, arg3);
                return true;
            }
        }
        return false;
    }
}
