package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.VarbitDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class24 {
    public static int[] anIntArray577;
    public static CacheIndex_Sub1[] aClass6_Sub1Array580 = new CacheIndex_Sub1[256];
    public static int[] walkingQueueX = new int[4000];

    public static IndexedImage[] method337(CacheIndex arg1, int arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg2, arg3, arg1))
            return null;
        return Class22_Sub2.method315();
    }

    public static int method338(int arg0, boolean arg1, int arg2, int arg3) {
        arg0 &= 0x3;
        if(arg1)
            return 68;
        if(arg0 == 0)
            return arg2;
        if(arg0 == 1)
            return arg3;
        if(arg0 == 2)
            return -arg2 + 7;
        return 7 + -arg3;
    }

    public static void method339() {
        anIntArray577 = null;
        IncomingPackets.INCOMING_PACKET_SIZES = null;
        Player.actorUpdatingIndices = null;
        aClass6_Sub1Array580 = null;
        walkingQueueX = null;
    }

    public static boolean method340() {
        return Class5.aClass22_189 != null;

    }

    public static void method341(int arg0, Scene arg1, int arg2, int arg3, int arg4, int arg5, byte[] arg6, int arg7, CollisionMap[] arg8, int arg9, int arg10) {
        do {
            Buffer class40_sub1 = new Buffer(arg6);
            int i = -1;
            for(; ; ) {
                int i_0_ = class40_sub1.getSmart();
                if(i_0_ == 0)
                    break;
                int i_1_ = 0;
                i += i_0_;
                for(; ; ) {
                    int i_2_ = class40_sub1.getSmart();
                    if(i_2_ == 0)
                        break;
                    i_1_ += -1 + i_2_;
                    int i_3_ = i_1_ >> 12;
                    int i_4_ = 0x3f & i_1_ >> 6;
                    int i_5_ = class40_sub1.getUnsignedByte();
                    int i_6_ = i_5_ >> 2;
                    int i_7_ = i_1_ & 0x3f;
                    int i_8_ = i_5_ & 0x3;
                    if(i_3_ == arg5 && (arg0 <= i_4_) && (i_4_ < 8 + arg0) && (arg9 <= i_7_) && (arg9 + 8 > i_7_)) {
                        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(i);
                        int i_9_ = (Main.method42(arg2 ^ 0x1, i_8_, gameObjectDefinition.sizeX, i_4_ & 0x7, gameObjectDefinition.sizeY, arg4, 0x7 & i_7_) + arg10);
                        int i_10_ = ((VarbitDefinition.method564(i_7_ & 0x7, gameObjectDefinition.sizeY, i_4_ & 0x7, gameObjectDefinition.sizeX, arg4, i_8_)) + arg7);
                        if(i_9_ > 0 && i_10_ > 0 && i_9_ < 103 && i_10_ < 103) {
                            CollisionMap collisionMap = null;
                            int i_11_ = arg3;
                            if(((OverlayDefinition.tile_flags[1][i_9_][i_10_]) & 0x2) == 2)
                                i_11_--;
                            if(i_11_ >= 0)
                                collisionMap = arg8[i_11_];
                            Class40_Sub5_Sub17_Sub1.addObject(i, i_9_, i_10_, arg3, (i_8_ + arg4 & 0x3), i_6_, arg1, collisionMap);
                        }
                    }
                }
            }
            if(arg2 == 0)
                break;
            aClass6_Sub1Array580 = null;

            break;
        } while(false);
    }
}
