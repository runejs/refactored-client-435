/* Class24 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

public class Class24 {
    public static RSString aClass1_575;
    public static int anInt576;
    public static int[] anIntArray577;
    public static int[] anIntArray578 = new int[2048];
    public static int anInt579;
    public static Class6_Sub1[] aClass6_Sub1Array580;
    public static int[] anIntArray581;
    public static int anInt582;
    public static int[] INCOMINGPACKETSIZES;
    public static int anInt584;
    public static int anInt585;
    public static int anInt586;

    static {
        aClass1_575 = Class58.method978("Freund hinzuf-Ugen");
        aClass6_Sub1Array580 = new Class6_Sub1[256];
        anIntArray581 = new int[4000];
        INCOMINGPACKETSIZES = (new int[]{0, 15, 6, 8, 0, 0, 1, 0, 0, 5, 0, 0, -2, 0, 0, 0, 0, 0, 1, 7, 0, 0, 0, -2, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 1, 4, 0, -1, 0, 0, 0, 0, 2, 0, 4, 0, 0, 0, 0, -2, 2, 0, 0, 0, 0, 0, 1, -1, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, -1, 0, 4, 0, 0, 0, 1, 0, 0, 0, -2, 0, 0, 0, 0, 0, 0, 7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 5, 2, 8, 2, 0, 8, 0, 0, 0, 0, 0, 0, 0, -2, 3, 2, 5, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 10, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 0, 0, 0, 6, 0, 0, 0, 0, 0, -2, 0, 0, 0, 0, 2, 0, 0, 4, 5, 0, 0, 0, 0, 0, 0, 6, 0, 0, 2, 6, 0, 0, 0, 0, 0, 0, 0, 6, 4, 3, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 2, 0, 4, -2, 0, 0, -2, 0, 0, 2, 0, 0, 0, 0, 3, -1, 0, 0, 0, 0, 0, 14, 0, 6, 0, 0, 6, 1, 0, 2, 0, 0, -2, 4, 0, 0, 0, 0, 0, 0, 0, 0, 6, 0, 0, 6, 2, 4});
    }

    public static IndexedColorSprite[] method337(int arg0, Class6 arg1, int arg2, int arg3) {
        try {
            anInt582++;
            if(!Class52.method948(arg2, arg3, arg1, arg0 ^ ~0x1132))
                return null;
            if(arg0 != 7729)
                INCOMINGPACKETSIZES = null;
            return Class22_Sub2.method315(arg0 ^ 0x1e31);
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ib.D(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public static int method338(int arg0, boolean arg1, int arg2, int arg3) {
        try {
            arg0 &= 0x3;
            if(arg1 != false)
                return 68;
            anInt585++;
            if((arg0 ^ 0xffffffff) == -1)
                return arg2;
            if((arg0 ^ 0xffffffff) == -2)
                return arg3;
            if(arg0 == 2)
                return -arg2 + 7;
            return 7 + -arg3;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("ib.A(" + arg0 + ',' + arg1 + ',' + arg2 + ',' + arg3 + ')'));
        }
    }

    public static void method339(byte arg0) {
        try {
            anIntArray577 = null;
            INCOMINGPACKETSIZES = null;
            anIntArray578 = null;
            aClass6_Sub1Array580 = null;
            if(arg0 != -41)
                aClass6_Sub1Array580 = null;
            anIntArray581 = null;
            aClass1_575 = null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ib.C(" + arg0 + ')');
        }
    }

    public static boolean method340(int arg0) {
        try {
            int i = -98 % ((-50 - arg0) / 51);
            anInt584++;
            return Class5.aClass22_189 != null;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "ib.E(" + arg0 + ')');
        }
    }

    public static void method341(int arg0, Scene arg1, int arg2, int arg3, int arg4, int arg5, byte[] arg6, int arg7, CollisionMap[] arg8, int arg9, int arg10) {
        do {
            try {
                anInt579++;
                Buffer class40_sub1 = new Buffer(arg6);
                int i = -1;
                for(; ; ) {
                    int i_0_ = class40_sub1.method502((byte) 126);
                    if((i_0_ ^ 0xffffffff) == -1)
                        break;
                    int i_1_ = 0;
                    i += i_0_;
                    for(; ; ) {
                        int i_2_ = class40_sub1.method502((byte) -76);
                        if((i_2_ ^ 0xffffffff) == -1)
                            break;
                        i_1_ += -1 + i_2_;
                        int i_3_ = i_1_ >> -2138212372;
                        int i_4_ = 0x3f & i_1_ >> 1523026630;
                        int i_5_ = class40_sub1.method468(false);
                        int i_6_ = i_5_ >> -2057515582;
                        int i_7_ = i_1_ & 0x3f;
                        int i_8_ = i_5_ & 0x3;
                        if(i_3_ == arg5 && (arg0 ^ 0xffffffff) >= (i_4_ ^ 0xffffffff) && (i_4_ ^ 0xffffffff) > (8 + arg0 ^ 0xffffffff) && (arg9 ^ 0xffffffff) >= (i_7_ ^ 0xffffffff) && (arg9 + 8 ^ 0xffffffff) < (i_7_ ^ 0xffffffff)) {
                            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                            int i_9_ = (Main.method42(arg2 ^ 0x1, i_8_, gameObjectDefinition.anInt2503, i_4_ & 0x7, gameObjectDefinition.anInt2515, arg4, 0x7 & i_7_) + arg10);
                            int i_10_ = ((Class40_Sub5_Sub4.method564(i_7_ & 0x7, gameObjectDefinition.anInt2515, i_4_ & 0x7, gameObjectDefinition.anInt2503, arg4, i_8_, (byte) -123)) + arg7);
                            if((i_9_ ^ 0xffffffff) < -1 && (i_10_ ^ 0xffffffff) < -1 && i_9_ < 103 && i_10_ < 103) {
                                CollisionMap collisionMap = null;
                                int i_11_ = arg3;
                                if(((Floor.tile_flags[1][i_9_][i_10_]) & 0x2) == 2)
                                    i_11_--;
                                if((i_11_ ^ 0xffffffff) <= -1)
                                    collisionMap = arg8[i_11_];
                                Class40_Sub5_Sub17_Sub1.renderObject(i, i_6_, (i_8_ + arg4 & 0x3), arg3, arg1, -127, i_10_, i_9_, collisionMap);
                            }
                        }
                    }
                }
                if(arg2 == 0)
                    break;
                aClass6_Sub1Array580 = null;
            } catch(RuntimeException runtimeexception) {
                throw Class8.method216(runtimeexception, ("ib.B(" + arg0 + ',' + (arg1 != null ? "{...}" : "null") + ',' + arg2 + ',' + arg3 + ',' + arg4 + ',' + arg5 + ',' + (arg6 != null ? "{...}" : "null") + ',' + arg7 + ',' + (arg8 != null ? "{...}" : "null") + ',' + arg9 + ',' + arg10 + ')'));
            }
            break;
        } while(false);
    }
}
