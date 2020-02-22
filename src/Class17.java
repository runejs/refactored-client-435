/* Class17 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.awt.*;

public class Class17 {
    public static int anInt446;
    public static int anInt447;
    public static int anInt448;
    public static Cache aClass9_449;
    public static RSString aClass1_450 = Class58.method978("Loading sprites )2 ");
    public static RSString aClass1_451;
    public static RSString aClass1_452 = aClass1_450;
    public static int anInt453;
    public static int anInt454;
    public static RSString aClass1_455;
    public static int[] anIntArray456;
    public static RSString aClass1_457 = Class58.method978("Willkommen auf RuneScape");
    public static int anInt458;
    public static int anInt459;
    public static int anInt460;
    public static Font aFont461;
    public static Class68 aClass68_462;
    public static Class68 aClass68_463;
    public static int anInt464;
    public static RSString aClass1_465;
    public static int[] anIntArray466;

    static {
        aClass1_451 = Class58.method978("as it was used to break our rules)3");
        aClass1_455 = aClass1_451;
        aClass9_449 = new Cache(128);
        anInt464 = 0;
        aClass1_465 = Class58.method978(":0");
        anInt460 = 0;
        anIntArray466 = new int[256];
    }

    public static void method273(Class64 arg0, int arg1, boolean arg2) {
        try {
            anInt458++;
            if(Class57.aClass64_1345 != null) {
                try {
                    Class57.aClass64_1345.method1009(-127);
                } catch(Exception exception) {
                    /* empty */
                }
                Class57.aClass64_1345 = null;
            }
            Class57.aClass64_1345 = arg0;
            RSApplet.method19(arg2, 24041);
            Class45.aClass40_Sub1_1081.offset = 0;
            Class40_Sub5_Sub13.aClass40_Sub1_2752 = null;
            Landscape.anInt1157 = 0;
            PacketBuffer.aClass40_Sub5_Sub13_2250 = null;
            for(; ; ) {
                Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class37.aClass23_869.method329(false));
                if(class40_sub5_sub13 == null)
                    break;
                Class51.aClass23_1194.put(class40_sub5_sub13, (byte) 126, class40_sub5_sub13.key);
                anInt464--;
                Class68.anInt1618++;
            }
            for(; ; ) {
                Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class34.aClass23_841.method329(false));
                if(class40_sub5_sub13 == null)
                    break;
                Class19.aClass27_485.method367(true, class40_sub5_sub13);
                GameObjectDefinition.aClass23_2545.put(class40_sub5_sub13, (byte) -121, (class40_sub5_sub13.key));
                Class42.anInt1006--;
                HashTable.anInt554++;
            }
            if((Class8.aByte302 ^ 0xffffffff) != -1) {
                try {
                    Buffer class40_sub1 = new Buffer(4);
                    class40_sub1.put(4, (byte) -128);
                    class40_sub1.put(Class8.aByte302, (byte) -128);
                    class40_sub1.method474(0, -128);
                    Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.buffer));
                } catch(java.io.IOException ioexception) {
                    try {
                        Class57.aClass64_1345.method1009(-123);
                    } catch(Exception exception) {
                        /* empty */
                    }
                    Class57.aClass64_1345 = null;
                    Class40_Sub5_Sub1.anInt2278++;
                }
            }
            if(arg1 < 102)
                method273(null, 92, true);
            Class22.anInt547 = 0;
            Class45.aLong1051 = Class51.method937(1);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("f.E(" + (arg0 != null ? "{...}" : "null") + ',' + arg1 + ',' + arg2 + ')'));
        }
    }

    public static int method274(boolean arg0) {
        try {
            if(arg0 != true)
                aClass68_463 = null;
            anInt447++;
            return Class49.anInt1147++;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "f.A(" + arg0 + ')');
        }
    }

    public static void method275(int arg0, long arg1) {
        try {
            anInt454++;
            if(arg1 != 0L) {
                if(Class42.anInt1008 >= 100)
                    Class44.method895(arg0 ^ 0x603f, 0, Landscape.aClass1_1180, Class66.aClass1_1567);
                else {
                    RSString class1 = Class60.method991(arg0 ^ ~0x6004, arg1).method85(-4305);
                    for(int i = 0; (Class42.anInt1008 ^ 0xffffffff) < (i ^ 0xffffffff); i++) {
                        if((Class53.aLongArray1267[i] ^ 0xffffffffffffffffL) == (arg1 ^ 0xffffffffffffffffL)) {
                            Class44.method895(114, 0, (Class40_Sub5_Sub17_Sub6.method832(arg0 ^ ~0x604a, (new RSString[]{class1, Class68.aClass1_1628}))), Class66.aClass1_1567);
                            return;
                        }
                    }
                    for(int i = 0; Class40_Sub5_Sub17_Sub3.anInt3060 > i; i++) {
                        if((arg1 ^ 0xffffffffffffffffL) == (Class59.aLongArray1397[i] ^ 0xffffffffffffffffL)) {
                            Class44.method895(112, 0, (Class40_Sub5_Sub17_Sub6.method832(-100, (new RSString[]{Class44.aClass1_1032, class1, (Renderable.aClass1_2864)}))), Class66.aClass1_1567);
                            return;
                        }
                    }
                    if(!class1.method54((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.aClass1_3278), 122)) {
                        Class40_Sub11.anInt2150++;
                        if(arg0 != 24686)
                            aClass68_462 = null;
                        Class53.aLongArray1267[Class42.anInt1008++] = arg1;
                        ISAAC.aBoolean505 = true;
                        Class32.packetBuffer.putPacket(arg0 + -13233, 251);
                        Class32.packetBuffer.putLong(arg1, false);
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "f.B(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method276(int arg0) {
        try {
            anInt459++;
            for(int i = arg0; Class60.anInt1407 > i; i++) {
                int i_0_;
                if(i == -1)
                    i_0_ = 2047;
                else
                    i_0_ = Class57.anIntArray1334[i];
                Player class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub17_Sub4.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i_0_]);
                if(class40_sub5_sub17_sub4_sub1 != null)
                    Class13.method241(class40_sub5_sub17_sub4_sub1, 1, (byte) 107);
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "f.C(" + arg0 + ')');
        }
    }

    public static void method277(byte arg0) {
        try {
            aClass1_450 = null;
            aClass68_462 = null;
            aClass9_449 = null;
            if(arg0 >= 75) {
                aClass1_465 = null;
                aClass1_452 = null;
                aClass1_455 = null;
                aClass68_463 = null;
                aClass1_457 = null;
                anIntArray456 = null;
                aClass1_451 = null;
                aFont461 = null;
                anIntArray466 = null;
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "f.D(" + arg0 + ')');
        }
    }
}
