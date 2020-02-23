package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class13 {
    public static int anInt400;
    public static int anInt401;
    public static int worldid;
    public static int[] anIntArray403 = new int[25];
    public static RSString aClass1_404 = RSString.CreateString("Enter name of friend to delete from list");
    public static RSString aClass1_405;
    public static Cache aClass9_406;
    public static int anInt407;
    public static int anInt408;
    public static int anInt409;
    public static int anInt410;
    public static RSString aClass1_411;
    public static RSString aClass1_412;
    public static int anInt413;
    public static boolean[] aBooleanArray414;
    public static int anInt415;
    public static int anInt416;
    public static RSString aClass1_417;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_418;
    public static int anInt419;
    public static int mouseX;
    public static int[] anIntArray421;
    public static RSString aClass1_422;

    static {
        worldid = 1;
        aClass1_411 = RSString.CreateString("Unerwartete Antwort vom Anmelde)2Server)3");
        aBooleanArray414 = new boolean[5];
        aClass1_417 = aClass1_404;
        aClass1_412 = RSString.CreateString("Loading friend list");
        aClass1_405 = aClass1_412;
        aClass9_406 = new Cache(64);
        anInt419 = 2;
        aClass1_422 = RSString.CreateString("oder ung-Ultiges Passwort)3");
        mouseX = 0;
    }

    public static void method241(Actor arg0, int arg1, byte arg2) {
        anInt400++;
        if((arg0.anInt3098 ^ 0xffffffff) > -129 || arg0.anInt3089 < 128 || arg0.anInt3098 >= 13184 || (arg0.anInt3089 ^ 0xffffffff) <= -13185) {
            arg0.anInt3141 = -1;
            arg0.anInt3112 = 0;
            arg0.anInt3107 = 0;
            arg0.anInt3091 = -1;
            arg0.anInt3098 = arg0.anInt3096 * 64 + 128 * arg0.anIntArray3088[0];
            arg0.anInt3089 = arg0.anIntArray3135[0] * 128 + 64 * arg0.anInt3096;
            arg0.method790(0);
        }
        if(arg0 == Player.localPlayer && ((arg0.anInt3098 ^ 0xffffffff) > -1537 || (arg0.anInt3089 ^ 0xffffffff) > -1537 || arg0.anInt3098 >= 11776 || arg0.anInt3089 >= 11776)) {
            arg0.anInt3091 = -1;
            arg0.anInt3107 = 0;
            arg0.anInt3112 = 0;
            arg0.anInt3141 = -1;
            arg0.anInt3098 = arg0.anIntArray3088[0] * 128 + (arg0.anInt3096 * 64);
            arg0.anInt3089 = 64 * arg0.anInt3096 + arg0.anIntArray3135[0] * 128;
            arg0.method790(0);
        }
        if(arg0.anInt3112 > Node.anInt926)
            Class40_Sub5_Sub11.method631(arg0, false);
        else if(arg0.anInt3107 < Node.anInt926)
            Class44.method898(255, arg0);
        else
            Class30.method381(22378, arg0);
        Class40_Sub5_Sub17_Sub1.method762(-1, arg0);
        Class40_Sub5_Sub15.method736(true, arg0);
        if(arg2 != 107)
            method249(false);
    }

    public static void method242(byte arg0) {

        anInt410++;
        if(arg0 > -88)
            method247(null, (byte) 34);
        for(; ; ) {
            Class40_Sub6 class40_sub6;
            synchronized(RSCanvas.aClass45_53) {
                class40_sub6 = ((Class40_Sub6) IdentityKit.aClass45_2604.method913(25447));
            }
            if(class40_sub6 == null)
                break;
            class40_sub6.aClass6_Sub1_2104.method198((byte) -115, false, class40_sub6.aByteArray2102, (int) class40_sub6.key, class40_sub6.aClass56_2117);
        }

    }

    public static void method243(byte arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        anInt407++;
        if(Class68.method1043(arg4)) {
            Class48.method925(arg3, Class59.aWidgetArrayArray1390[arg4], arg5, 0, arg7, 0, -1, arg8, arg6, arg1, 0, arg2);
            if(arg0 != 89)
                aClass1_405 = null;
        }
    }

    public static int method244(int arg0, int arg1, int arg2, int arg3) {

        int i = 69 % ((-65 - arg2) / 53);
        anInt413++;
        if((arg1 ^ 0xffffffff) < -180)
            arg0 /= 2;
        if((arg1 ^ 0xffffffff) < -193)
            arg0 /= 2;
        if(arg1 > 217)
            arg0 /= 2;
        if((arg1 ^ 0xffffffff) < -244)
            arg0 /= 2;
        int i_0_ = arg1 / 2 + ((arg0 / 32 << 906471527) + (arg3 / 4 << 1215235370));
        return i_0_;

    }

    public static void method245(int arg0) {
        for(int i = 0; i < Actor.anInt3153; i++) {
            int i_1_ = Class24.anIntArray578[i];
            Npc class40_sub5_sub17_sub4_sub2 = Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_1_];
            int i_2_ = Cache.outgoingbuffer.getUnsignedByte();
            if((0x1 & i_2_ ^ 0xffffffff) != -1) {
                int i_3_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_4_ = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                class40_sub5_sub17_sub4_sub2.method785(i_4_, Node.anInt926, i_3_, -121);
                class40_sub5_sub17_sub4_sub2.anInt3139 = Node.anInt926 + 300;
                class40_sub5_sub17_sub4_sub2.anInt3130 = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                class40_sub5_sub17_sub4_sub2.anInt3101 = Cache.outgoingbuffer.getUnsignedByte();
            }
            if((0x20 & i_2_) != 0) {
                class40_sub5_sub17_sub4_sub2.anInt3091 = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortLE();
                int i_5_ = Cache.outgoingbuffer.getIntBE();
                class40_sub5_sub17_sub4_sub2.anInt3129 = 0;
                class40_sub5_sub17_sub4_sub2.anInt3093 = Node.anInt926 + (0xffff & i_5_);
                class40_sub5_sub17_sub4_sub2.anInt3110 = i_5_ >> -1206933168;
                class40_sub5_sub17_sub4_sub2.anInt3140 = 0;
                if(class40_sub5_sub17_sub4_sub2.anInt3093 > Node.anInt926)
                    class40_sub5_sub17_sub4_sub2.anInt3140 = -1;
                if(class40_sub5_sub17_sub4_sub2.anInt3091 == 65535)
                    class40_sub5_sub17_sub4_sub2.anInt3091 = -1;
            }
            if((i_2_ & 0x4 ^ 0xffffffff) != -1) {
                class40_sub5_sub17_sub4_sub2.anInt3137 = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if((class40_sub5_sub17_sub4_sub2.anInt3137 ^ 0xffffffff) == -65536)
                    class40_sub5_sub17_sub4_sub2.anInt3137 = -1;
            }
            if((0x2 & i_2_) != 0) {
                int i_6_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetByte();
                int i_7_ = Cache.outgoingbuffer.getUnsignedByte();
                class40_sub5_sub17_sub4_sub2.method785(i_7_, Node.anInt926, i_6_, -119);
                class40_sub5_sub17_sub4_sub2.anInt3139 = Node.anInt926 + 300;
                class40_sub5_sub17_sub4_sub2.anInt3130 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
                class40_sub5_sub17_sub4_sub2.anInt3101 = Cache.outgoingbuffer.putUnsignedPreNegativeOffsetByte();
            }
            if((0x40 & i_2_ ^ 0xffffffff) != -1) {
                class40_sub5_sub17_sub4_sub2.aClass1_3090 = Cache.outgoingbuffer.getRSString();
                class40_sub5_sub17_sub4_sub2.anInt3078 = 100;
            }
            if((i_2_ & 0x80) != 0) {
                class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300 = ActorDefinition.getDefinition((byte) -122, Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE());
                class40_sub5_sub17_sub4_sub2.anInt3083 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.anInt2389);
                class40_sub5_sub17_sub4_sub2.anInt3113 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.degreesToTurn);
                class40_sub5_sub17_sub4_sub2.anInt3075 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.rotate90RightAnimation);
                class40_sub5_sub17_sub4_sub2.anInt3126 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.stanceAnimation);
                class40_sub5_sub17_sub4_sub2.anInt3131 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.walkAnimation);
                class40_sub5_sub17_sub4_sub2.anInt3145 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.anInt2421);
                class40_sub5_sub17_sub4_sub2.anInt3096 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.tileSpacesOccupied);
                class40_sub5_sub17_sub4_sub2.anInt3132 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.rotate90LeftAnimation);
                class40_sub5_sub17_sub4_sub2.anInt3079 = (class40_sub5_sub17_sub4_sub2.aClass40_Sub5_Sub5_3300.rotate180Animation);
            }
            if((i_2_ & 0x8) != 0) {
                class40_sub5_sub17_sub4_sub2.anInt3148 = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                class40_sub5_sub17_sub4_sub2.anInt3100 = Cache.outgoingbuffer.getUnsignedShortLE();
            }
            if((0x10 & i_2_ ^ 0xffffffff) != -1) {
                int i_8_ = Cache.outgoingbuffer.getUnsignedNegativeOffsetShortBE();
                if(i_8_ == 65535)
                    i_8_ = -1;
                int i_9_ = Cache.outgoingbuffer.getUnsignedInvertedByte();
                if(i_8_ == class40_sub5_sub17_sub4_sub2.anInt3141 && i_8_ != -1) {
                    int i_10_ = Class68_Sub1.method1050(i_8_, 2).anInt2483;
                    if(i_10_ == 1) {
                        class40_sub5_sub17_sub4_sub2.anInt3115 = 0;
                        class40_sub5_sub17_sub4_sub2.anInt3095 = 0;
                        class40_sub5_sub17_sub4_sub2.anInt3104 = 0;
                        class40_sub5_sub17_sub4_sub2.anInt3122 = i_9_;
                    }
                    if((i_10_ ^ 0xffffffff) == -3)
                        class40_sub5_sub17_sub4_sub2.anInt3095 = 0;
                } else if(i_8_ == -1 || class40_sub5_sub17_sub4_sub2.anInt3141 == -1 || (Class68_Sub1.method1050(i_8_, 2).anInt2494 >= (Class68_Sub1.method1050(class40_sub5_sub17_sub4_sub2.anInt3141, 2).anInt2494))) {
                    class40_sub5_sub17_sub4_sub2.anInt3141 = i_8_;
                    class40_sub5_sub17_sub4_sub2.anInt3115 = 0;
                    class40_sub5_sub17_sub4_sub2.anInt3122 = i_9_;
                    class40_sub5_sub17_sub4_sub2.anInt3104 = 0;
                    class40_sub5_sub17_sub4_sub2.anInt3095 = 0;
                    class40_sub5_sub17_sub4_sub2.anInt3094 = class40_sub5_sub17_sub4_sub2.anInt3109;
                }
            }
        }
        anInt409++;
        if(arg0 != 3799)
            worldid = -59;
    }

    public static synchronized byte[] method246(int arg1) {

        anInt408++;
        if(arg1 == 100 && Class10.anInt356 > 0) {
            byte[] is = Class58.aByteArrayArray1377[--Class10.anInt356];
            Class58.aByteArrayArray1377[Class10.anInt356] = null;
            return is;
        }
        if(arg1 == 5000 && Main.anInt1764 > 0) {
            byte[] is = Class44.aByteArrayArray1039[--Main.anInt1764];
            Class44.aByteArrayArray1039[Main.anInt1764] = null;
            return is;
        }
        if((arg1 ^ 0xffffffff) == -30001 && Class40_Sub5_Sub4.anInt2359 > 0) {
            byte[] is = (RSCanvas.aByteArrayArray47[--Class40_Sub5_Sub4.anInt2359]);
            RSCanvas.aByteArrayArray47[Class40_Sub5_Sub4.anInt2359] = null;
            return is;
        }
        return new byte[arg1];

    }

    public static int[] method247(Widget arg0, byte arg1) {

        if(arg1 <= 74)
            anInt419 = -37;
        int i;
        if(arg0.anInt2689 < 0)
            i = arg0.anInt2648 >> 567649872;
        else
            i = arg0.anInt2689 >> -1265498640;
        anInt401++;
        if(!Class68.method1043(i))
            return null;
        int i_11_ = arg0.anInt2656;
        int i_12_ = arg0.anInt2696;
        int i_13_ = arg0.anInt2648;
        while(i_13_ != -1) {
            Widget widget = (Class59.aWidgetArrayArray1390[i][i_13_ & 0xffff]);
            i_11_ += widget.anInt2656;
            if(!arg0.aBoolean2694)
                i_11_ -= widget.anInt2746;
            i_12_ += widget.anInt2696;
            i_13_ = widget.anInt2648;
            if(!arg0.aBoolean2694)
                i_12_ -= widget.scrollPosition;
        }
        int[] is = new int[2];
        is[0] = i_11_;
        is[1] = i_12_;
        return is;

    }

    public static void method248(int arg0) {

        anIntArray421 = null;
        aClass1_422 = null;
        aClass1_404 = null;
        aClass40_Sub5_Sub14_Sub2_418 = null;
        aClass1_405 = null;
        aClass1_411 = null;
        aClass1_417 = null;
        anIntArray403 = null;
        aBooleanArray414 = null;
        aClass9_406 = null;
        if(arg0 != 65535)
            method244(11, 13, 49, 49);
        aClass1_412 = null;

    }

    public static void method249(boolean arg0) {

        if(arg0 != true)
            method244(-58, 116, -89, 98);
        if(GameObject.aClass62_3019 != null) {
            synchronized(GameObject.aClass62_3019) {
                GameObject.aClass62_3019 = null;
            }
        }
        anInt416++;

    }
}
