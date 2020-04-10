package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;

public class Class56 {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1315;
    public static int anInt1318 = 3353893;
    public static Class61[] aClass61Array1320 = new Class61[50];
    public static CacheIndex_Sub1 aClass6_Sub1_1323;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1329;

    public Class67 aClass67_1309;
    public Class67 aClass67_1313 = null;
    public int anInt1321;
    public int anInt1324;

    public Class56(int arg0, Class67 arg1, Class67 arg2, int arg3) {
        aClass67_1309 = null;
        anInt1321 = 65000;
        anInt1321 = arg3;
        aClass67_1313 = arg2;
        aClass67_1309 = arg1;
        anInt1324 = arg0;

    }

    public static void method967() {
        aClass61Array1320 = null;
        aClass40_Sub5_Sub14_Sub2_1315 = null;
        aClass6_Sub1_1323 = null;
        aClass40_Sub5_Sub14_Sub2_1329 = null;
    }

    public static RSString[] method968(RSString[] arg0, boolean arg1) {
        if(arg1)
            method972((byte) -104);
        RSString[] class1s = new RSString[5];
        for(int i = 0; i < 5; i++) {
            class1s[i] = (RSString.linkRSStrings(new RSString[]{HashTable.method334(i), ISAAC.aClass1_515}));
            if(arg0 != null && arg0[i] != null)
                class1s[i] = RSString.linkRSStrings((new RSString[]{class1s[i], arg0[i]}));
        }
        return class1s;
    }

    public static Class38 method972(byte arg0) {
        if(arg0 != 47)
            method968(null, true);
        try {
            return (Class38) Class.forName("com.jagex.runescape.Class38_Sub2").newInstance();
        } catch(Throwable throwable) {
            return new Class38_Sub1();
        }
    }

    public static void method973() {
        Class67.anIntArray1579 = null;
        SceneTile.anIntArray2048 = null;
        FloorDecoration.anIntArray612 = null;
        CacheIndex.anIntArrayArrayArray262 = null;
        AnimationSequence.anIntArrayArray2490 = null;
        Class35.tile_overlay_rotation = null;
        Class59.anIntArray1398 = null;
        InteractiveObject.aByteArrayArrayArray492 = null;
        OverlayDefinition.tile_underlay_path = null;
        MouseHandler.tile_overlayids = null;
        Class42.tile_underlayids = null;
        Class40_Sub5_Sub17_Sub6.anIntArray3250 = null;
    }

    public String toString() {
        return "com.jagex.runescape.cache.Cache:" + anInt1324;
    }

    public byte[] method969(int arg0) {
        synchronized(aClass67_1309) {
            try {
                if(aClass67_1313.method1032(0) < (long) (6 + arg0 * 6))
                    return null;
                aClass67_1313.method1031(0, (long) (6 * arg0));
                aClass67_1313.method1035(0, (byte) -49, 6, ActorDefinition.aByteArray2416);
                int i_0_ = ((0xff00 & (ActorDefinition.aByteArray2416[4] << 8)) + ((0xff & ActorDefinition.aByteArray2416[3]) << 16) + (0xff & ActorDefinition.aByteArray2416[5]));
                int i_1_ = ((0xff & ActorDefinition.aByteArray2416[2]) + (((ActorDefinition.aByteArray2416[0] & 0xff) << 16) + ((0xff & ActorDefinition.aByteArray2416[1]) << 8)));
                if(i_1_ < 0 || (i_1_ > anInt1321))
                    return null;
                if(i_0_ <= 0 || (aClass67_1309.method1032(0) / 520L < (long) i_0_))
                    return null;
                int i_2_ = 0;
                int i_3_ = 0;
                byte[] is = new byte[i_1_];
                while((i_1_ > i_2_)) {
                    if(i_0_ == 0)
                        return null;
                    aClass67_1309.method1031(0, (long) (i_0_ * 520));
                    int i_4_ = -i_2_ + i_1_;
                    if(i_4_ > 512)
                        i_4_ = 512;
                    aClass67_1309.method1035(0, (byte) -14, 8 + i_4_, (ActorDefinition.aByteArray2416));
                    int i_5_ = ((0xff00 & (ActorDefinition.aByteArray2416[0] << 8)) + (0xff & ActorDefinition.aByteArray2416[1]));
                    int i_6_ = ((ActorDefinition.aByteArray2416[6] & 0xff) + ((0xff & ActorDefinition.aByteArray2416[5]) << 8) + ((0xff & ActorDefinition.aByteArray2416[4]) << 16));
                    int i_7_ = ((0xff00 & (ActorDefinition.aByteArray2416[2] << 8)) + (0xff & ActorDefinition.aByteArray2416[3]));
                    int i_8_ = 0xff & ActorDefinition.aByteArray2416[7];
                    if(arg0 != i_5_ || i_3_ != i_7_ || anInt1324 != i_8_)
                        return null;
                    if(i_6_ < 0 || (aClass67_1309.method1032(0) / 520L < (long) i_6_))
                        return null;
                    i_3_++;
                    for(int i_9_ = 0; (i_9_ < i_4_); i_9_++)
                        is[i_2_++] = ActorDefinition.aByteArray2416[8 + i_9_];
                    i_0_ = i_6_;
                }
                return is;
            } catch(java.io.IOException ioexception) {
                return null;
            }
        }
    }

    public boolean method970(byte[] arg0, int arg1, boolean arg2, int arg3, byte arg4) {
        synchronized(aClass67_1309) {
            try {
                if(arg4 >= -80)
                    method969(91);
                int i;
                if(arg2) {
                    if(aClass67_1313.method1032(0) < (long) (6 + 6 * arg3))
                        return false;
                    aClass67_1313.method1031(0, (long) (arg3 * 6));
                    aClass67_1313.method1035(0, (byte) -111, 6, (ActorDefinition.aByteArray2416));
                    i = ((ActorDefinition.aByteArray2416[5] & 0xff) + (((ActorDefinition.aByteArray2416[3] & 0xff) << 16) + ((ActorDefinition.aByteArray2416[4] & 0xff) << 8)));
                    if(i <= 0 || (aClass67_1309.method1032(0) / 520L < (long) i))
                        return false;
                } else {
                    i = (int) ((519L + aClass67_1309.method1032(0)) / 520L);
                    if(i == 0)
                        i = 1;
                }
                ActorDefinition.aByteArray2416[0] = (byte) (arg1 >> 16);
                ActorDefinition.aByteArray2416[1] = (byte) (arg1 >> 8);
                ActorDefinition.aByteArray2416[2] = (byte) arg1;
                int i_10_ = 0;
                ActorDefinition.aByteArray2416[3] = (byte) (i >> 16);
                int i_11_ = 0;
                ActorDefinition.aByteArray2416[4] = (byte) (i >> 8);
                ActorDefinition.aByteArray2416[5] = (byte) i;
                aClass67_1313.method1031(0, (long) (arg3 * 6));
                aClass67_1313.method1033(0, -16777216, 6, ActorDefinition.aByteArray2416);
                int i_12_;
                for(/**/; i_10_ < arg1; i_10_ += i_12_) {
                    int i_13_ = 0;
                    if(arg2) {
                        aClass67_1309.method1031(0, (long) (520 * i));
                        try {
                            aClass67_1309.method1035(0, (byte) -106, 8, (ActorDefinition.aByteArray2416));
                        } catch(java.io.EOFException eofexception) {
                            break;
                        }
                        i_13_ = ((ActorDefinition.aByteArray2416[6] & 0xff) + (((ActorDefinition.aByteArray2416[4] << 16) & 0xff0000) + (0xff00 & (ActorDefinition.aByteArray2416[5]) << 8)));
                        i_12_ = ((ActorDefinition.aByteArray2416[1] & 0xff) + ((ActorDefinition.aByteArray2416[0] << 8) & 0xff00));
                        int i_14_ = ActorDefinition.aByteArray2416[7] & 0xff;
                        int i_15_ = ((ActorDefinition.aByteArray2416[3] & 0xff) + ((0xff & ActorDefinition.aByteArray2416[2]) << 8));
                        if(arg3 != i_12_ || i_11_ != i_15_ || anInt1324 != i_14_)
                            return false;
                        if(i_13_ < 0 || (aClass67_1309.method1032(0) / 520L < (long) i_13_))
                            return false;
                    }
                    if(i_13_ == 0) {
                        arg2 = false;
                        i_13_ = (int) ((519L + aClass67_1309.method1032(0)) / 520L);
                        if(i_13_ == 0)
                            i_13_++;
                        if(i == i_13_)
                            i_13_++;
                    }
                    ActorDefinition.aByteArray2416[0] = (byte) (arg3 >> 8);
                    if(-i_10_ + arg1 <= 512)
                        i_13_ = 0;
                    ActorDefinition.aByteArray2416[1] = (byte) arg3;
                    i_12_ = -i_10_ + arg1;
                    if(i_12_ > 512)
                        i_12_ = 512;
                    ActorDefinition.aByteArray2416[2] = (byte) (i_11_ >> 8);
                    ActorDefinition.aByteArray2416[3] = (byte) i_11_;
                    ActorDefinition.aByteArray2416[4] = (byte) (i_13_ >> 16);
                    ActorDefinition.aByteArray2416[5] = (byte) (i_13_ >> 8);
                    i_11_++;
                    ActorDefinition.aByteArray2416[6] = (byte) i_13_;
                    ActorDefinition.aByteArray2416[7] = (byte) anInt1324;
                    aClass67_1309.method1031(0, (long) (520 * i));
                    aClass67_1309.method1033(0, -16777216, 8, (ActorDefinition.aByteArray2416));
                    i = i_13_;
                    aClass67_1309.method1033(i_10_, -16777216, i_12_, arg0);
                }
                return true;
            } catch(java.io.IOException ioexception) {
                return false;
            }
        }
    }

    public boolean method971(byte[] arg0, int arg1, int arg2, int arg3) {
        synchronized(aClass67_1309) {
            if(arg2 < 0 || arg2 > anInt1321)
                throw new IllegalArgumentException();
            if(arg1 != 1862596560)
                method971(null, 96, -29, 88);
            boolean bool = method970(arg0, arg2, true, arg3, (byte) -120);
            if(!bool)
                bool = method970(arg0, arg2, false, arg3, (byte) -114);
            return bool;
        }
    }
}
