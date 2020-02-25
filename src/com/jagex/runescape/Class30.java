package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;

public class Class30 {
    public static int[] anIntArray680 = new int[50];
    public static int anInt681;
    public static RSString aClass1_682 = RSString.CreateString("Off");
    public static int[] anIntArray684 = new int[50];
    public static int[] anIntArray685 = new int[50];
    public static RSString aClass1_686 = RSString.CreateString("*6n");
    public static boolean aBoolean687;
    public static int[] anIntArray688 = new int[50];
    public static Class67 aClass67_693;
    public static int[] anIntArray695 = new int[50];
    public static RSString[] aClass1Array697 = new RSString[50];
    public static RSString aClass1_698 = RSString.CreateString("(U(Y");
    public static RSString aClass1_701 = RSString.CreateString("Trade)4compete");
    public static int anInt704 = 0;
    public static int anInt708 = -1;
    public static int[] anIntArray712 = new int[50];
    public static Class68 aClass68_714;
    public static int[] anIntArray715 = new int[50];
    public static RSString aClass1_716 = RSString.CreateString("scape main");
    public static Class64 aClass64_717;

    public boolean aBoolean683;
    public int[] anIntArray692;
    public int anInt696;
    public int[] anIntArray713;
    public long aLong718;
    public long aLong719;

    public static void method376(int arg0) {
        anIntArray712 = null;
        anIntArray688 = null;
        aClass64_717 = null;
        if(arg0 != 13429)
            method381(-90, null);
        anIntArray695 = null;
        anIntArray685 = null;
        anIntArray715 = null;
        aClass1_686 = null;
        aClass1Array697 = null;
        aClass67_693 = null;
        anIntArray684 = null;
        anIntArray680 = null;
        aClass68_714 = null;
        aClass1_701 = null;
        aClass1_682 = null;
        aClass1_698 = null;
        aClass1_716 = null;
    }

    public static void method381(int arg0, Actor arg1) {
        if(arg0 != 22378)
            method376(90);
        if(Node.pulseCycle == arg1.anInt3107 || arg1.playingAnimation == -1 || arg1.playingAnimationDelay != 0 || arg1.anInt3115 + 1 > (Class68_Sub1.method1050(arg1.playingAnimation, 2).animationLengths[arg1.anInt3104])) {
            int i = -arg1.anInt3112 + arg1.anInt3107;
            int i_16_ = -arg1.anInt3112 + Node.pulseCycle;
            int i_17_ = arg1.anInt3125 * 128 + (64 * arg1.anInt3096);
            int i_18_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3081;
            int i_19_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3099;
            int i_20_ = 128 * arg1.anInt3127 + arg1.anInt3096 * 64;
            arg1.anInt3098 = ((i - i_16_) * i_17_ + i_16_ * i_19_) / i;
            arg1.anInt3089 = (i_18_ * (i + -i_16_) + i_16_ * i_20_) / i;
        }
        if(arg1.anInt3073 == 0)
            arg1.anInt3080 = 1024;
        arg1.anInt3074 = 0;
        if(arg1.anInt3073 == 1)
            arg1.anInt3080 = 1536;
        if(arg1.anInt3073 == 2)
            arg1.anInt3080 = 0;
        if(arg1.anInt3073 == 3)
            arg1.anInt3080 = 512;
        arg1.anInt3118 = arg1.anInt3080;
    }

    public int method374(int arg0) {
        if(arg0 != -20874)
            return 109;
        if(anInt696 != -1)
            return (ActorDefinition.getDefinition((byte) -105, anInt696).id + 305419896);
        return (anIntArray692[1] + (anIntArray692[11] << 5) + ((anIntArray713[4] << 20) + ((anIntArray713[0] << 25) + (anIntArray692[0] << 15)) + (anIntArray692[8] << 10)));
    }

    public void method375(int arg0, Buffer arg1) {
        arg1.putByte(aBoolean683 ? 1 : 0);
        for(int i = arg0; i < 7; i++) {
            int i_0_ = anIntArray692[Class40_Sub5_Sub15.anIntArray2777[i]];
            if(i_0_ != 0)
                arg1.putByte(-256 + i_0_);
            else
                arg1.putByte(-1);
        }
        for(int i = 0; i < 5; i++)
            arg1.putByte(anIntArray713[i]);
    }

    public Model method377(AnimationSequence arg0, AnimationSequence arg1, int arg2, int arg3, byte arg4) {
        if(anInt696 != -1)
            return ActorDefinition.getDefinition((byte) -101, anInt696).method568((byte) -50, arg0, arg1, arg2, arg3);
        long l = aLong718;
        int[] is = anIntArray692;
        if(arg0 != null && (arg0.anInt2477 >= 0 || arg0.anInt2489 >= 0)) {
            is = new int[12];
            for(int i = 0; i < 12; i++)
                is[i] = anIntArray692[i];
            if(arg0.anInt2477 >= 0) {
                l += (long) (arg0.anInt2477 + -anIntArray692[5] << 8);
                is[5] = arg0.anInt2477;
            }
            if(arg0.anInt2489 >= 0) {
                l += (long) (arg0.anInt2489 + -anIntArray692[3] << 16);
                is[3] = arg0.anInt2489;
            }
        }
        if(arg4 >= -84)
            return null;
        Model model = ((Model) CacheIndex.aClass9_229.method231(l, (byte) 66));
        if(model == null) {
            boolean bool = false;
            for(int i = 0; i < 12; i++) {
                int i_1_ = is[i];
                if(i_1_ >= 256 && i_1_ < 512 && !Buffer.method501(-256 + i_1_).isBodyModelCached())
                    bool = true;
                if(i_1_ >= 512 && !ItemDefinition.forId(i_1_ + -512, 10).method739(aBoolean683, (byte) 127))
                    bool = true;
            }
            if(bool) {
                if(aLong719 != -1L)
                    model = ((Model) CacheIndex.aClass9_229.method231(aLong719, (byte) 123));
                if(model == null)
                    return null;
            }
            if(model == null) {
                Model[] class40_sub5_sub17_sub5s = new Model[12];
                int i = 0;
                for(int i_2_ = 0; i_2_ < 12; i_2_++) {
                    int i_3_ = is[i_2_];
                    if(i_3_ >= 256 && i_3_ < 512) {
                        Model class40_sub5_sub17_sub5_4_ = Buffer.method501(i_3_ + -256).method630(false);
                        if(class40_sub5_sub17_sub5_4_ != null)
                            class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5_4_;
                    }
                    if(i_3_ >= 512) {
                        Model class40_sub5_sub17_sub5_5_ = ItemDefinition.forId(i_3_ - 512, 10).method740(aBoolean683, -32);
                        if(class40_sub5_sub17_sub5_5_ != null)
                            class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5_5_;
                    }
                }
                model = new Model(class40_sub5_sub17_sub5s, i);
                for(int i_6_ = 0; i_6_ < 5; i_6_++) {
                    if(anIntArray713[i_6_] != 0) {
                        model.replaceColor((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_6_][0]), (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_6_][anIntArray713[i_6_]]));
                        if(i_6_ == 1)
                            model.replaceColor(Class35.anIntArray1738[0], (Class35.anIntArray1738[anIntArray713[i_6_]]));
                    }
                }
                model.method810();
                model.method802(64, 850, -30, -50, -30, true);
                CacheIndex.aClass9_229.method230(-7208, l, model);
                aLong719 = l;
            }
        }
        Model class40_sub5_sub17_sub5_7_;
        if(arg0 != null || arg1 != null) {
            if(arg0 == null || arg1 == null) {
                if(arg0 == null)
                    class40_sub5_sub17_sub5_7_ = arg1.method599(arg2, model, false);
                else
                    class40_sub5_sub17_sub5_7_ = arg0.method599(arg3, model, false);
            } else
                class40_sub5_sub17_sub5_7_ = arg0.method590(model, arg1, arg3, arg2, (byte) 63);
        } else
            return model;
        return class40_sub5_sub17_sub5_7_;

    }

    public void method378(int arg0) {
        int i = anIntArray692[9];
        int i_8_ = anIntArray692[5];
        long l = aLong718;
        anIntArray692[5] = i;
        anIntArray692[9] = i_8_;
        aLong718 = 0L;
        for(int i_9_ = 0; i_9_ < 12; i_9_++) {
            aLong718 <<= 4;
            if(anIntArray692[i_9_] >= 256)
                aLong718 += (long) (anIntArray692[i_9_] + -256);
        }
        if(anIntArray692[0] >= 256)
            aLong718 += (long) (-256 + anIntArray692[0] >> 4);
        if(anIntArray692[1] >= 256)
            aLong718 += (long) (-256 + anIntArray692[1] >> 8);
        for(int i_10_ = 0; i_10_ < 5; i_10_++) {
            aLong718 <<= 3;
            aLong718 += (long) anIntArray713[i_10_];
        }
        if(arg0 <= 94)
            method375(70, null);
        aLong718 <<= 1;
        Class30 class30 = this;
        class30.aLong718 = class30.aLong718 + (long) (aBoolean683 ? 1 : 0);
        anIntArray692[5] = i_8_;
        anIntArray692[9] = i;
        if(l != 0L && l != aLong718)
            CacheIndex.aClass9_229.removeAll(l, 108);
    }

    public Model method379(int arg0) {
        if(anInt696 != -1)
            return ActorDefinition.getDefinition((byte) -117, anInt696).getHeadModel((byte) 111);
        boolean bool = false;
        for(int i = 0; i < 12; i++) {
            int i_11_ = anIntArray692[i];
            if(i_11_ >= 256 && i_11_ < 512 && !Buffer.method501(i_11_ - 256).method624(false))
                bool = true;
            if(i_11_ >= 512 && !ItemDefinition.forId(-512 + i_11_, 10).method738((byte) 44, aBoolean683))
                bool = true;
        }
        if(arg0 <= 20)
            anInt681 = 106;
        if(bool)
            return null;
        Model[] class40_sub5_sub17_sub5s = new Model[12];
        int i = 0;
        for(int i_12_ = 0; i_12_ < 12; i_12_++) {
            int i_13_ = anIntArray692[i_12_];
            if(i_13_ >= 256 && i_13_ < 512) {
                Model class40_sub5_sub17_sub5 = Buffer.method501(-256 + i_13_).method629((byte) -100);
                if(class40_sub5_sub17_sub5 != null)
                    class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5;
            }
            if(i_13_ >= 512) {
                Model class40_sub5_sub17_sub5 = ItemDefinition.forId(i_13_ - 512, 10).method747(aBoolean683, (byte) 25);
                if(class40_sub5_sub17_sub5 != null)
                    class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5;
            }
        }
        Model class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, i);
        for(int i_14_ = 0; i_14_ < 5; i_14_++) {
            if(anIntArray713[i_14_] != 0) {
                class40_sub5_sub17_sub5.replaceColor(Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_14_][0], (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[i_14_][anIntArray713[i_14_]]));
                if(i_14_ == 1)
                    class40_sub5_sub17_sub5.replaceColor(Class35.anIntArray1738[0], Class35.anIntArray1738[anIntArray713[i_14_]]);
            }
        }
        return class40_sub5_sub17_sub5;

    }

    public void method380(int[] arg0, boolean isFemale, int arg2, int[] arg3, int arg4) {
        if(arg0 == null) {
            arg0 = new int[12];
            for(int i = 0; i < 7; i++) {
                for(int i_15_ = 0; PacketBuffer.anInt2257 > i_15_; i_15_++) {
                    IdentityKit identityKit = Buffer.method501(i_15_);
                    if(identityKit != null && !identityKit.nonSelectable && (identityKit.bodyPartId == i + (!isFemale ? 0 : 7))) {
                        arg0[Class40_Sub5_Sub15.anIntArray2777[i]] = i_15_ + 256;
                        break;
                    }
                }
            }
        }
        anInt696 = arg4;
        aBoolean683 = isFemale;
        anIntArray692 = arg0;
        anIntArray713 = arg3;
        if(arg2 == 7)
            method378(97);
    }

    public void method382(int arg0, boolean arg1, int arg2) {
        if(arg0 != 1 || !aBoolean683) {
            int i = anIntArray692[Class40_Sub5_Sub15.anIntArray2777[arg0]];
            if(i != 0) {
                i -= 256;
                if(arg2 > 3) {
                    IdentityKit identityKit;
                    do {
                        if(arg1) {
                            i++;
                            if(i >= PacketBuffer.anInt2257)
                                i = 0;
                        } else if(--i < 0)
                            i = -1 + PacketBuffer.anInt2257;
                        identityKit = Buffer.method501(i);
                    } while(identityKit == null || identityKit.nonSelectable || (identityKit.bodyPartId != arg0 + (!aBoolean683 ? 0 : 7)));
                    anIntArray692[Class40_Sub5_Sub15.anIntArray2777[arg0]] = i + 256;
                    method378(117);
                }
            }
        }
    }

    public void method383(boolean arg0, byte arg1) {
        if(!aBoolean683 != !arg0) {
            if(arg1 != -110)
                method382(57, false, 67);
            method380(null, arg0, 7, anIntArray713, -1);
        }
    }

    public void method384(int arg0, boolean arg1, int arg2) {
        int i = -67 % ((-30 - arg0) / 56);
        int i_21_ = anIntArray713[arg2];
        if(!arg1) {
            if(--i_21_ < 0)
                i_21_ = -1 + (Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[arg2]).length;
        } else if((Class40_Sub5_Sub17_Sub6.anIntArrayArray3238[arg2]).length <= ++i_21_)
            i_21_ = 0;
        anIntArray713[arg2] = i_21_;
        method378(119);
    }
}
