package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.PacketBuffer;

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

    public boolean gender;
    public int[] appearance;
    public int anInt696;
    public int[] appearanceColors;
    public long appearanceHash;
    public long cachedModel;

    public static void method376() {
        anIntArray712 = null;
        anIntArray688 = null;
        aClass64_717 = null;
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
            method376();
        if(Node.pulseCycle == arg1.anInt3107 || arg1.playingAnimation == -1 || arg1.playingAnimationDelay != 0 || arg1.anInt3115 + 1 > (Class68_Sub1.method1050(arg1.playingAnimation, 2).animationLengths[arg1.anInt3104])) {
            int i = -arg1.anInt3112 + arg1.anInt3107;
            int i_16_ = -arg1.anInt3112 + Node.pulseCycle;
            int i_17_ = arg1.anInt3125 * 128 + (64 * arg1.anInt3096);
            int i_18_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3081;
            int i_19_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3099;
            int i_20_ = 128 * arg1.anInt3127 + arg1.anInt3096 * 64;
            arg1.worldX = ((i - i_16_) * i_17_ + i_16_ * i_19_) / i;
            arg1.worldY = (i_18_ * (i + -i_16_) + i_16_ * i_20_) / i;
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
            return (ActorDefinition.getDefinition(anInt696).id + 305419896);
        return (appearance[1] + (appearance[11] << 5) + ((appearanceColors[4] << 20) + ((appearanceColors[0] << 25) + (appearance[0] << 15)) + (appearance[8] << 10)));
    }

    public void method375(int arg0, Buffer arg1) {
        arg1.putByte(gender ? 1 : 0);
        for(int i = arg0; i < 7; i++) {
            int i_0_ = appearance[Class40_Sub5_Sub15.anIntArray2777[i]];
            if(i_0_ != 0)
                arg1.putByte(-256 + i_0_);
            else
                arg1.putByte(-1);
        }
        for(int i = 0; i < 5; i++)
            arg1.putByte(appearanceColors[i]);
    }

    public Model getAnimatedModel(AnimationSequence arg0, AnimationSequence arg1, int arg2, int arg3, byte arg4) {
        if(anInt696 != -1)
            return ActorDefinition.getDefinition(anInt696).getChildModel(arg0, arg1, arg2, arg3);
        long hash = appearanceHash;
        int[] appearance = this.appearance;
        if(arg0 != null && (arg0.shieldModel >= 0 || arg0.weaponModel >= 0)) {
            appearance = new int[12];
            for(int i = 0; i < 12; i++)
                appearance[i] = this.appearance[i];
            if(arg0.shieldModel >= 0) {
                hash += (long) (arg0.shieldModel - this.appearance[5] << 8);
                appearance[5] = arg0.shieldModel;
            }
            if(arg0.weaponModel >= 0) {
                hash += (long) (arg0.weaponModel - this.appearance[3] << 16);
                appearance[3] = arg0.weaponModel;
            }
        }
        if(arg4 >= -84)
            return null;

        Model model = ((Model) CacheIndex.modelCache.get(hash, (byte) 66));
        if(model == null) {
            boolean invalid = false;
            for(int bodyPart = 0; bodyPart < 12; bodyPart++) {
                int appearanceModel = appearance[bodyPart];
                if(appearanceModel >= 256 && appearanceModel < 512 && !IdentityKit.cache(-256 + appearanceModel).isBodyModelCached())
                    invalid = true;
                if(appearanceModel >= 512 && !ItemDefinition.forId(appearanceModel + -512, 10).equipmentReady(gender))
                    invalid = true;
            }
            if(invalid) {
                if(cachedModel != -1L)
                    model = ((Model) CacheIndex.modelCache.get(cachedModel, (byte) 123));
                if(model == null)
                    return null;
            }
            if(model == null) {
                Model[] models = new Model[12];
                int count = 0;
                for(int index = 0; index < 12; index++) {
                    int part = appearance[index];
                    if(part >= 256 && part < 512) {
                        Model bodyModel = IdentityKit.cache(part - 256).getBodyModel();
                        if(bodyModel != null)
                            models[count++] = bodyModel;
                    }
                    if(part >= 512) {
                        Model equipment = ItemDefinition.forId(part - 512, 10).asEquipment(gender);
                        if(equipment != null)
                            models[count++] = equipment;
                    }
                }

                model = new Model(models, count);
                for(int part = 0; part < 5; part++) {
                    if(appearanceColors[part] != 0) {
                        model.replaceColor((Class40_Sub5_Sub17_Sub6.playerColours[part][0]), (Class40_Sub5_Sub17_Sub6.playerColours[part][appearanceColors[part]]));
                        if(part == 1)
                            model.replaceColor(Class35.SKIN_COLOURS[0], (Class35.SKIN_COLOURS[appearanceColors[part]]));
                    }
                }
                model.createBones();
                model.applyLighting(64, 850, -30, -50, -30, true);
                CacheIndex.modelCache.put(hash, model);
                cachedModel = hash;
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
        int i = appearance[9];
        int i_8_ = appearance[5];
        long l = appearanceHash;
        appearance[5] = i;
        appearance[9] = i_8_;
        appearanceHash = 0L;
        for(int i_9_ = 0; i_9_ < 12; i_9_++) {
            appearanceHash <<= 4;
            if(appearance[i_9_] >= 256)
                appearanceHash += (long) (appearance[i_9_] + -256);
        }
        if(appearance[0] >= 256)
            appearanceHash += (long) (-256 + appearance[0] >> 4);
        if(appearance[1] >= 256)
            appearanceHash += (long) (-256 + appearance[1] >> 8);
        for(int i_10_ = 0; i_10_ < 5; i_10_++) {
            appearanceHash <<= 3;
            appearanceHash += (long) appearanceColors[i_10_];
        }
        if(arg0 <= 94)
            method375(70, null);
        appearanceHash <<= 1;
        Class30 class30 = this;
        class30.appearanceHash = class30.appearanceHash + (long) (gender ? 1 : 0);
        appearance[5] = i_8_;
        appearance[9] = i;
        if(l != 0L && l != appearanceHash)
            CacheIndex.modelCache.removeAll(l, 108);
    }

    public Model method379(int arg0) {
        if(anInt696 != -1)
            return ActorDefinition.getDefinition(anInt696).getHeadModel();
        boolean bool = false;
        for(int i = 0; i < 12; i++) {
            int i_11_ = appearance[i];
            if(i_11_ >= 256 && i_11_ < 512 && !IdentityKit.cache(i_11_ - 256).method624())
                bool = true;
            if(i_11_ >= 512 && !ItemDefinition.forId(-512 + i_11_, 10).headPieceReady(gender))
                bool = true;
        }
        if(arg0 <= 20)
            anInt681 = 106;
        if(bool)
            return null;
        Model[] class40_sub5_sub17_sub5s = new Model[12];
        int i = 0;
        for(int i_12_ = 0; i_12_ < 12; i_12_++) {
            int i_13_ = appearance[i_12_];
            if(i_13_ >= 256 && i_13_ < 512) {
                Model class40_sub5_sub17_sub5 = IdentityKit.cache(-256 + i_13_).method629();
                if(class40_sub5_sub17_sub5 != null)
                    class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5;
            }
            if(i_13_ >= 512) {
                Model class40_sub5_sub17_sub5 = ItemDefinition.forId(i_13_ - 512, 10).asHeadPiece(gender);
                if(class40_sub5_sub17_sub5 != null)
                    class40_sub5_sub17_sub5s[i++] = class40_sub5_sub17_sub5;
            }
        }
        Model class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, i);
        for(int i_14_ = 0; i_14_ < 5; i_14_++) {
            if(appearanceColors[i_14_] != 0) {
                class40_sub5_sub17_sub5.replaceColor(Class40_Sub5_Sub17_Sub6.playerColours[i_14_][0], (Class40_Sub5_Sub17_Sub6.playerColours[i_14_][appearanceColors[i_14_]]));
                if(i_14_ == 1)
                    class40_sub5_sub17_sub5.replaceColor(Class35.SKIN_COLOURS[0], Class35.SKIN_COLOURS[appearanceColors[i_14_]]);
            }
        }
        return class40_sub5_sub17_sub5;

    }

    public void method380(int[] arg0, boolean isFemale, int arg2, int[] arg3, int arg4) {
        if(arg0 == null) {
            arg0 = new int[12];
            for(int i = 0; i < 7; i++) {
                for(int i_15_ = 0; PacketBuffer.anInt2257 > i_15_; i_15_++) {
                    IdentityKit identityKit = IdentityKit.cache(i_15_);
                    if(identityKit != null && !identityKit.nonSelectable && (identityKit.bodyPartId == i + (!isFemale ? 0 : 7))) {
                        arg0[Class40_Sub5_Sub15.anIntArray2777[i]] = i_15_ + 256;
                        break;
                    }
                }
            }
        }
        anInt696 = arg4;
        gender = isFemale;
        appearance = arg0;
        appearanceColors = arg3;
        if(arg2 == 7)
            method378(97);
    }

    public void method382(int arg0, boolean arg1, int arg2) {
        if(arg0 != 1 || !gender) {
            int i = appearance[Class40_Sub5_Sub15.anIntArray2777[arg0]];
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
                        identityKit = IdentityKit.cache(i);
                    } while(identityKit == null || identityKit.nonSelectable || (identityKit.bodyPartId != arg0 + (!gender ? 0 : 7)));
                    appearance[Class40_Sub5_Sub15.anIntArray2777[arg0]] = i + 256;
                    method378(117);
                }
            }
        }
    }

    public void method383(boolean arg0, byte arg1) {
        if(!gender != !arg0) {
            if(arg1 != -110)
                method382(57, false, 67);
            method380(null, arg0, 7, appearanceColors, -1);
        }
    }

    public void method384(boolean arg1, int arg2) {
        int i_21_ = appearanceColors[arg2];
        if(!arg1) {
            if(--i_21_ < 0)
                i_21_ = -1 + (Class40_Sub5_Sub17_Sub6.playerColours[arg2]).length;
        } else if((Class40_Sub5_Sub17_Sub6.playerColours[arg2]).length <= ++i_21_)
            i_21_ = 0;
        appearanceColors[arg2] = i_21_;
        method378(119);
    }
}
