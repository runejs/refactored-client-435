/* Class5 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class Class5 {
    public static Class22 aClass22_189;
    public static int anInt190;
    public static int[] anIntArray191;
    public static int anInt192;
    public static RSString aClass1_193;
    public static int anInt194;
    public static int anInt195 = 1;
    public static RSString aClass1_196;
    public static int anInt197;
    public static int[] anIntArray198;
    public static int anInt199;
    public static int anInt200;
    public static int anInt201;
    public static RSString aClass1_202;
    public static RSString aClass1_203;
    public static RSString aClass1_204;
    public static int anInt205;
    public static RSString aClass1_206;
    public static int anInt207;
    public static int anInt208;
    public static int anInt209;
    public static RSString aClass1_210;

    static {
        anIntArray191 = new int[100];
        anInt200 = 127;
        aClass1_196 = Class58.method978("backvmid3");
        aClass1_202 = Class58.method978("red:");
        aClass1_203 = Class58.method978("mapmarker");
        anInt208 = 3;
        anInt199 = 0;
        aClass1_206 = Class58.method978(" )2> @lre@");
        aClass1_210 = Class58.method978("Please contact customer support)3");
        aClass1_193 = aClass1_210;
        aClass1_204 = aClass1_202;
    }

    public static void method162(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, byte[] arg8, Class3[] arg9) {
        try {
            if(arg1 != 13941)
                method162(53, -59, 8, -121, -68, -3, -42, -91, null, null);
            for(int i = 0; (i ^ 0xffffffff) > -9; i++) {
                for(int i_0_ = 0; (i_0_ ^ 0xffffffff) > -9; i_0_++) {
                    if((arg5 + i ^ 0xffffffff) < -1 && (i + arg5 ^ 0xffffffff) > -104 && arg0 + i_0_ > 0 && i_0_ + arg0 < 103)
                        arg9[arg4].anIntArrayArray150[arg5 + i][i_0_ + arg0] = Class66.method1021((arg9[arg4].anIntArrayArray150[arg5 + i][i_0_ + arg0]), -16777217);
                }
            }
            anInt197++;
            Buffer class40_sub1 = new Buffer(arg8);
            for(int i = 0; i < 4; i++) {
                for(int i_1_ = 0; (i_1_ ^ 0xffffffff) > -65; i_1_++) {
                    for(int i_2_ = 0; (i_2_ ^ 0xffffffff) > -65; i_2_++) {
                        if((arg3 ^ 0xffffffff) == (i ^ 0xffffffff) && i_1_ >= arg2 && 8 + arg2 > i_1_ && i_2_ >= arg6 && 8 + arg6 > i_2_)
                            Class48.method922(arg5 + Class24.method338(arg7, false, i_1_ & 0x7, i_2_ & 0x7), arg7, class40_sub1, arg1 ^ ~0x363e, arg0 - -Class33.method410(i_1_ & 0x7, 0x7 & i_2_, arg7, false), 0, 0, arg4);
                        else
                            Class48.method922(-1, 0, class40_sub1, -116, -1, 0, 0, 0);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("bb.A(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + arg6 + ',' + arg7 + ',' + (arg8 != null ? "{...}" : "null") + ',' + (arg9 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method163(byte arg0) {
        try {
            aClass1_196 = null;
            if(arg0 == -94) {
                aClass1_204 = null;
                aClass1_202 = null;
                aClass1_206 = null;
                anIntArray191 = null;
                aClass22_189 = null;
                aClass1_203 = null;
                aClass1_193 = null;
                aClass1_210 = null;
                anIntArray198 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "bb.B(" + arg0 + ')');
        }
    }

    public static void method164(int arg0) {
        try {
            Class40_Sub5_Sub17.method754(arg0 + 29378, NpcDefinition.anInt2433);
            anInt205++;
            if(arg0 != (Class40_Sub5_Sub9.anInt2562 ^ 0xffffffff))
                Class40_Sub5_Sub17.method754(arg0 + 29378, Class40_Sub5_Sub9.anInt2562);
            anInt199 = 0;
            Class68_Sub1.aClass68_2213.method1046((byte) 90);
            Player.anIntArray3284 = R3D.method708(Player.anIntArray3284);
            Rasterizer.method663();
            Class40_Sub5_Sub6.method583(0, NpcDefinition.anInt2433, 503, (byte) -5, 0, 0, 765);
            if(Class40_Sub5_Sub9.anInt2562 != -1)
                Class40_Sub5_Sub6.method583(0, Class40_Sub5_Sub9.anInt2562, 503, (byte) -5, 0, 0, 765);
            if(!Class4.aBoolean173) {
                Class43.method894(false);
                Class40_Sub4.method537(4);
            } else
                Class40_Sub5_Sub6.method588(-1);
            try {
                Graphics graphics = Class62.aCanvas1469.getGraphics();
                Class68_Sub1.aClass68_2213.method1044(0, 0, graphics, 0);
            } catch(Exception exception) {
                Class62.aCanvas1469.repaint();
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "bb.D(" + arg0 + ')');
        }
    }

    public static void method165(int arg0) {
        anInt209++;
        int i = 64 + Class32.anInt767 * 128;
        int i_3_ = 64 + 128 * Class22.anInt545;
        int i_4_ = (Class37.method430((byte) -121, Player.anInt3267, i_3_, i) + -anInt194);
        if((i_3_ ^ 0xffffffff) < (Class12.anInt388 ^ 0xffffffff)) {
            Class12.anInt388 += (Class59.anInt1386 * (i_3_ + -Class12.anInt388) / 1000 + Class4.anInt188);
            if(Class12.anInt388 > i_3_) {
                Class12.anInt388 = i_3_;
            }
        }
        if((i_4_ ^ 0xffffffff) < (Class32.anInt769 ^ 0xffffffff)) {
            Class32.anInt769 += (Class59.anInt1386 * (i_4_ - Class32.anInt769) / 1000 + Class4.anInt188);
            if((i_4_ ^ 0xffffffff) > (Class32.anInt769 ^ 0xffffffff))
                Class32.anInt769 = i_4_;
        }
        if((Class12.anInt388 ^ 0xffffffff) < (i_3_ ^ 0xffffffff)) {
            Class12.anInt388 -= Class4.anInt188 - -(Class59.anInt1386 * (Class12.anInt388 + -i_3_) / 1000);
            if(i_3_ > Class12.anInt388) {
                Class12.anInt388 = i_3_;
            }
        }
        if((Class40_Sub5_Sub6.anInt2443 ^ 0xffffffff) > (i ^ 0xffffffff)) {
            Class40_Sub5_Sub6.anInt2443 += Class4.anInt188 - -(Class59.anInt1386 * (-Class40_Sub5_Sub6.anInt2443 + i) / 1000);
            if((Class40_Sub5_Sub6.anInt2443 ^ 0xffffffff) < (i ^ 0xffffffff))
                Class40_Sub5_Sub6.anInt2443 = i;
        }
        if(Class32.anInt769 > i_4_) {
            Class32.anInt769 -= ((Class32.anInt769 + -i_4_) * Class59.anInt1386 / 1000 + Class4.anInt188);
            if((i_4_ ^ 0xffffffff) < (Class32.anInt769 ^ 0xffffffff))
                Class32.anInt769 = i_4_;
        }
        i_3_ = 64 + HashTable.anInt564 * 128;
        if(Class40_Sub5_Sub6.anInt2443 > i) {
            Class40_Sub5_Sub6.anInt2443 -= Class4.anInt188 + (Class59.anInt1386 * (Class40_Sub5_Sub6.anInt2443 - i) / 1000);
            if(Class40_Sub5_Sub6.anInt2443 < i)
                Class40_Sub5_Sub6.anInt2443 = i;
        }
        i = Class40_Sub5_Sub9.anInt2576 * 128 - -64;
        i_4_ = Class37.method430((byte) -125, Player.anInt3267, i_3_, i) - Class38.anInt892;
        int i_5_ = -Class32.anInt769 + i_4_;
        int i_6_ = i - Class40_Sub5_Sub6.anInt2443;
        int i_7_ = i_3_ - Class12.anInt388;
        int i_8_ = (int) Math.sqrt((double) (i_7_ * i_7_ - -(i_6_ * i_6_)));
        int i_9_ = 0x7ff & (int) (Math.atan2((double) i_5_, (double) i_8_) * 325.949);
        if(i_9_ < 128)
            i_9_ = 128;
        int i_10_ = 0x7ff & (int) (-325.949 * Math.atan2((double) i_7_, (double) i_6_));
        if((i_9_ ^ 0xffffffff) < -384)
            i_9_ = 383;
        int i_11_ = -Class68_Sub1.anInt2210 + i_10_;
        if((i_11_ ^ 0xffffffff) < -1025)
            i_11_ -= 2048;
        if((i_11_ ^ 0xffffffff) > 1023)
            i_11_ += 2048;
        if((i_11_ ^ 0xffffffff) < -1) {
            Class68_Sub1.anInt2210 += Class22_Sub1.anInt1856 * i_11_ / 1000 + Class60.anInt1413;
            Class68_Sub1.anInt2210 &= 0x7ff;
        }
        if(arg0 > 0) {
            if(i_11_ < 0) {
                Class68_Sub1.anInt2210 -= Class60.anInt1413 - -(Class22_Sub1.anInt1856 * -i_11_ / 1000);
                Class68_Sub1.anInt2210 &= 0x7ff;
            }
            if(i_9_ > Class26.anInt627) {
                Class26.anInt627 += Class60.anInt1413 + (Class22_Sub1.anInt1856 * (i_9_ - Class26.anInt627) / 1000);
                if(Class26.anInt627 > i_9_)
                    Class26.anInt627 = i_9_;
            }
            if(Class26.anInt627 > i_9_) {
                Class26.anInt627 -= (Class22_Sub1.anInt1856 * (Class26.anInt627 + -i_9_) / 1000) + Class60.anInt1413;
                if(Class26.anInt627 < i_9_)
                    Class26.anInt627 = i_9_;
            }
            int i_12_ = i_10_ + -Class68_Sub1.anInt2210;
            if(i_12_ > 1024)
                i_12_ -= 2048;
            if((i_12_ ^ 0xffffffff) > 1023)
                i_12_ += 2048;
            if((i_12_ ^ 0xffffffff) > -1 && (i_11_ ^ 0xffffffff) < -1 || i_12_ > 0 && (i_11_ ^ 0xffffffff) > -1)
                Class68_Sub1.anInt2210 = i_10_;
        }
    }

    public static boolean method166(byte arg0, Class40_Sub5_Sub12 arg1) {
        try {
            anInt192++;
            int i = arg1.anInt2639;
            if(Class12.anInt380 == 2) {
                if((i ^ 0xffffffff) == -202) {
                    Class37.anInt876 = 1;
                    Class66.aClass1_1563 = Class40_Sub5_Sub12.aClass1_2740;
                    Class19.aBoolean490 = true;
                    Class40_Sub5_Sub15.anInt2780 = 0;
                    Class66.aClass1_1565 = Class66.aClass1_1567;
                    Class52.aBoolean1221 = true;
                }
                if(i == 202) {
                    Class37.anInt876 = 2;
                    Class66.aClass1_1563 = Class13.aClass1_417;
                    Class52.aBoolean1221 = true;
                    Class40_Sub5_Sub15.anInt2780 = 0;
                    Class19.aBoolean490 = true;
                    Class66.aClass1_1565 = Class66.aClass1_1567;
                }
            }
            if((i ^ 0xffffffff) == -206) {
                Class32.anInt771 = 250;
                return true;
            }
            if((i ^ 0xffffffff) == -502) {
                Class40_Sub5_Sub15.anInt2780 = 0;
                Class37.anInt876 = 4;
                Class52.aBoolean1221 = true;
                Class66.aClass1_1563 = Class51.aClass1_1200;
                Class66.aClass1_1565 = Class66.aClass1_1567;
                Class19.aBoolean490 = true;
            }
            if(i == 502) {
                Class52.aBoolean1221 = true;
                Class40_Sub5_Sub15.anInt2780 = 0;
                Class37.anInt876 = 5;
                Class19.aBoolean490 = true;
                Class66.aClass1_1565 = Class66.aClass1_1567;
                Class66.aClass1_1563 = Class12.aClass1_399;
            }
            if((i ^ 0xffffffff) <= -301 && (i ^ 0xffffffff) >= -314) {
                int i_13_ = (-300 + i) / 2;
                int i_14_ = 0x1 & i;
                Class45.aClass30_1082.method382(i_13_, i_14_ == 1, 14);
            }
            if((i ^ 0xffffffff) <= -315 && (i ^ 0xffffffff) >= -324) {
                int i_15_ = (i + -314) / 2;
                int i_16_ = i & 0x1;
                Class45.aClass30_1082.method384(-94, (i_16_ ^ 0xffffffff) == -2, i_15_);
            }
            if(arg0 != 88)
                method163((byte) 42);
            if((i ^ 0xffffffff) == -325)
                Class45.aClass30_1082.method383(false, (byte) -110);
            if(i == 325)
                Class45.aClass30_1082.method383(true, (byte) -110);
            if((i ^ 0xffffffff) == -327) {
                Class22_Sub1.anInt1869++;
                Class32.packetBuffer.putPacket(arg0 + 11365, 231);
                Class45.aClass30_1082.method375(arg0 ^ 0x58, Class32.packetBuffer);
                return true;
            }
            if(i == 620)
                Class67.aBoolean1601 = !Class67.aBoolean1601;
            if((i ^ 0xffffffff) <= -602 && (i ^ 0xffffffff) >= -614) {
                PacketBuffer.method516(123);
                if((Class66.aClass1_1550.method59(arg0 ^ ~0xc67) ^ 0xffffffff) < -1) {
                    Class32.packetBuffer.putPacket(11453, 202);
                    Class46.anInt1096++;
                    Class32.packetBuffer.putLong(Class66.aClass1_1550.method58((byte) 102), false);
                    Class32.packetBuffer.put(-601 + i, (byte) -128);
                    Class32.packetBuffer.put(Class67.aBoolean1601 ? 1 : 0, (byte) -128);
                }
            }
            return false;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("bb.F(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ')'));
        }
    }

    public static void method167(int arg0) {
        try {
            if(arg0 != 1023)
                method164(89);
            Class13.aClass9_406.method235((byte) -56);
            anInt207++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "bb.E(" + arg0 + ')');
        }
    }

    public static void method168(int arg0, int arg1, int arg2, int arg3, byte arg4, Class40_Sub5_Sub12 arg5, int arg6, int arg7, int arg8) {
        try {
            if(Class61.aBoolean1444)
                Landscape.anInt1171 = 32;
            else
                Landscape.anInt1171 = 0;
            anInt190++;
            Class61.aBoolean1444 = false;
            if((arg6 ^ 0xffffffff) >= (arg2 ^ 0xffffffff) && arg2 < arg6 + 16 && arg1 >= arg8 && 16 + arg8 > arg1) {
                arg5.anInt2731 -= NPC.anInt3294 * 4;
                if(arg7 == 1)
                    ISAAC.aBoolean505 = true;
                if(arg7 == 2 || (arg7 ^ 0xffffffff) == -4)
                    Class52.aBoolean1221 = true;
            } else if((arg2 ^ 0xffffffff) > (arg6 ^ 0xffffffff) || (arg6 - -16 ^ 0xffffffff) >= (arg2 ^ 0xffffffff) || arg1 < arg8 - -arg0 + -16 || arg1 >= arg8 - -arg0) {
                if(-Landscape.anInt1171 + arg6 <= arg2 && (arg2 ^ 0xffffffff) > (16 + (arg6 + Landscape.anInt1171) ^ 0xffffffff) && arg8 - -16 <= arg1 && arg1 < -16 + arg8 + arg0 && NPC.anInt3294 > 0) {
                    Class61.aBoolean1444 = true;
                    int i = (-32 + arg0) * arg0 / arg3;
                    if(arg7 == 2 || (arg7 ^ 0xffffffff) == -4)
                        Class52.aBoolean1221 = true;
                    if(arg7 == 1)
                        ISAAC.aBoolean505 = true;
                    if((i ^ 0xffffffff) > -9)
                        i = 8;
                    int i_17_ = -i + (arg0 + -32);
                    int i_18_ = -(i / 2) + (-arg8 + arg1) + -16;
                    arg5.anInt2731 = (arg3 + -arg0) * i_18_ / i_17_;
                }
            } else {
                arg5.anInt2731 += 4 * NPC.anInt3294;
                if(arg7 == 2 || (arg7 ^ 0xffffffff) == -4)
                    Class52.aBoolean1221 = true;
                if(arg7 == 1)
                    ISAAC.aBoolean505 = true;
            }
            int i = -61 / ((arg4 - -67) / 59);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("bb.G(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + (arg5 != null ? "{...}" : "null") + ',' + arg6 + ',' + arg7 + ',' + arg8 + ')'));
        }
    }
}
