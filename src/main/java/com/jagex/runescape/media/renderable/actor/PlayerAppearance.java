package com.jagex.runescape.media.renderable.actor;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;

public class PlayerAppearance {

    public static int[] anIntArray680 = new int[50];
    public static int anInt681;
    public static int[] anIntArray684 = new int[50];
    public static int[] anIntArray685 = new int[50];
    public static boolean aBoolean687;
    public static int[] anIntArray688 = new int[50];
    public static int[] anIntArray695 = new int[50];
    public static String[] aClass1Array697 = new String[50];
    public static int anInt704 = 0;
    public static int anInt708 = -1;
    public static int[] anIntArray712 = new int[50];
    public static ProducingGraphicsBuffer tabPieveLowerRight;
    public static int[] anIntArray715 = new int[50];
    public static GameSocket gameSocket;

    public static int identityKitLength;
    public static int[][] playerColours = {{6798, 107, 10283, 16, 4797, 7744, 5799, 4634, 33697, 22433, 2983, 54193}, {8741, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003, 25239}, {25238, 8742, 12, 64030, 43162, 7735, 8404, 1701, 38430, 24094, 10153, 56621, 4783, 1341, 16578, 35003}, {4626, 11146, 6439, 12, 4758, 10270}, {4550, 4537, 5681, 5673, 5790, 6806, 8076, 4574}};
    public static int[] playerSkinColors = new int[]{9104, 10275, 7595, 3610, 7975, 8526, 918, 38802, 24466, 10145, 58654, 5027, 1457, 16565, 34991, 25486};

    public final int[] appearanceIndices = {8, 11, 4, 6, 9, 7, 10};

    public boolean gender;
    public int[] appearance;
    public int transformationNpcId;
    public int[] appearanceColors;
    public long appearanceHash;
    public long cachedModel;



    public static void method381(Actor arg1) {
        if(MovedStatics.pulseCycle == arg1.anInt3107 || arg1.playingAnimation == -1 || arg1.playingAnimationDelay != 0 ||
                arg1.anInt3115 + 1 > ProducingGraphicsBuffer_Sub1.getAnimationSequence(arg1.playingAnimation).frameLengths[arg1.anInt3104]) {
            int i = -arg1.anInt3112 + arg1.anInt3107;
            int i_16_ = -arg1.anInt3112 + MovedStatics.pulseCycle;
            int i_17_ = arg1.anInt3125 * 128 + 64 * arg1.anInt3096;
            int i_18_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3081;
            int i_19_ = arg1.anInt3096 * 64 + 128 * arg1.anInt3099;
            int i_20_ = 128 * arg1.anInt3127 + arg1.anInt3096 * 64;
            arg1.worldX = ((i - i_16_) * i_17_ + i_16_ * i_19_) / i;
            arg1.worldY = (i_18_ * (i + -i_16_) + i_16_ * i_20_) / i;
        }
        if(arg1.anInt3073 == 0)
            arg1.initialFaceDirection = 1024;
        arg1.anInt3074 = 0;
        if(arg1.anInt3073 == 1)
            arg1.initialFaceDirection = 1536;
        if(arg1.anInt3073 == 2)
            arg1.initialFaceDirection = 0;
        if(arg1.anInt3073 == 3)
            arg1.initialFaceDirection = 512;
        arg1.anInt3118 = arg1.initialFaceDirection;
    }



    public int getHeadModelId() {
        if(transformationNpcId != -1)
            return ActorDefinition.getDefinition(transformationNpcId).id + 305419896;
        return appearance[1] + (appearance[11] << 5) + (appearanceColors[4] << 20) + (appearanceColors[0] << 25) + (appearance[0] << 15) + (appearance[8] << 10);
    }

    public void sendAppearanceData(int startIndex, Buffer buffer) {
        buffer.putByte(gender ? 1 : 0);
        for(int i = startIndex; i < 7; i++) {
            int i_0_ = appearance[appearanceIndices[i]];
            if(i_0_ != 0)
                buffer.putByte(-256 + i_0_);
            else
                buffer.putByte(-1);
        }
        for(int i = 0; i < 5; i++)
            buffer.putByte(appearanceColors[i]);
    }

    public Model getAnimatedModel(AnimationSequence animation1, AnimationSequence animation2, int unknown1, int unknown2) {
        if(transformationNpcId != -1) {
            return ActorDefinition.getDefinition(transformationNpcId).getChildModel(animation1, animation2, unknown1, unknown2);
        }

        long hash = appearanceHash;
        int[] appearance = this.appearance;
        if(animation1 != null && (animation1.offHandModel >= 0 || animation1.mainHandModel >= 0)) {
            appearance = new int[12];
            for(int i = 0; i < 12; i++)
                appearance[i] = this.appearance[i];
            if(animation1.offHandModel >= 0) {
                hash += (animation1.offHandModel - this.appearance[5] << 8);
                appearance[5] = animation1.offHandModel;
            }
            if(animation1.mainHandModel >= 0) {
                hash += (animation1.mainHandModel - this.appearance[3] << 16);
                appearance[3] = animation1.mainHandModel;
            }
        }

        Model cachedModel = (Model) MovedStatics.modelCache.get(hash);
        if(cachedModel == null) {
            boolean invalid = false;
            for(int bodyPart = 0; bodyPart < 12; bodyPart++) {
                int appearanceModel = appearance[bodyPart];
                if(appearanceModel >= 256 && appearanceModel < 512 && !IdentityKit.cache(-256 + appearanceModel).isBodyModelCached())
                    invalid = true;
                if(appearanceModel >= 512 && !ItemDefinition.forId(appearanceModel + -512, 10).equipmentReady(gender))
                    invalid = true;
            }
            if(invalid) {
                if(this.cachedModel != -1L)
                    cachedModel = (Model) MovedStatics.modelCache.get(this.cachedModel);
                if(cachedModel == null)
                    return null;
            }
            if(cachedModel == null) {
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

                cachedModel = new Model(models, count);
                for(int part = 0; part < 5; part++) {
                    if(appearanceColors[part] != 0) {
                        cachedModel.replaceColor(playerColours[part][0], playerColours[part][appearanceColors[part]]);
                        if(part == 1)
                            cachedModel.replaceColor(playerSkinColors[0], playerSkinColors[appearanceColors[part]]);
                    }
                }
                cachedModel.createBones();
                cachedModel.applyLighting(64, 850, -30, -50, -30, true);
                MovedStatics.modelCache.put(hash, cachedModel);
                this.cachedModel = hash;
            }
        }
        Model finalModel;
        if(animation1 != null || animation2 != null) {
            if(animation1 == null || animation2 == null) {
                if(animation1 == null)
                    finalModel = animation2.method599(unknown1, cachedModel, false);
                else
                    finalModel = animation1.method599(unknown2, cachedModel, false);
            } else
                finalModel = animation1.method590(cachedModel, animation2, unknown2, unknown1, (byte) 63);
        } else
            return cachedModel;
        return finalModel;

    }

    public void updateAppearanceCache() {
        int appearance9 = appearance[9];
        int appearance5 = appearance[5];
        long originalAppearanceHash = appearanceHash;
        appearance[5] = appearance9;
        appearance[9] = appearance5;
        appearanceHash = 0L;

        for(int appearanceIndex = 0; appearanceIndex < 12; appearanceIndex++) {
            appearanceHash <<= 4;
            if(appearance[appearanceIndex] >= 256)
                appearanceHash += (appearance[appearanceIndex] + -256);
        }

        if(appearance[0] >= 256) {
            appearanceHash += (-256 + appearance[0] >> 4);
        }

        if(appearance[1] >= 256) {
            appearanceHash += (-256 + appearance[1] >> 8);
        }

        for(int colorIndex = 0; colorIndex < 5; colorIndex++) {
            appearanceHash <<= 3;
            appearanceHash += appearanceColors[colorIndex];
        }

        appearanceHash <<= 1;
        this.appearanceHash = this.appearanceHash + (gender ? 1 : 0);
        appearance[5] = appearance5;
        appearance[9] = appearance9;

        if(originalAppearanceHash != 0L && originalAppearanceHash != appearanceHash) {
            MovedStatics.modelCache.remove(originalAppearanceHash);
        }
    }

    public Model getStaticModel() {
        if(transformationNpcId != -1) {
            return ActorDefinition.getDefinition(transformationNpcId).getHeadModel();
        }

        boolean bool = false;
        for(int i = 0; i < 12; i++) {
            int appearanceId = appearance[i];
            if(appearanceId >= 256 && appearanceId < 512 && !IdentityKit.cache(appearanceId - 256).method624()) {
                bool = true;
            }
            if(appearanceId >= 512 && !ItemDefinition.forId(-512 + appearanceId, 10).headPieceReady(gender)) {
                bool = true;
            }
        }

        if(bool) {
            return null;
        }

        Model[] models = new Model[12];
        int i = 0;

        for(int equipmentSlot = 0; equipmentSlot < 12; equipmentSlot++) {
            int slotAppearance = appearance[equipmentSlot];
            if(slotAppearance >= 256 && slotAppearance < 512) {
                Model model = IdentityKit.cache(-256 + slotAppearance).method629();
                if(model != null)
                    models[i++] = model;
            }
            if(slotAppearance >= 512) {
                Model model = ItemDefinition.forId(slotAppearance - 512, 10).asHeadPiece(gender);
                if(model != null)
                    models[i++] = model;
            }
        }

        Model finalModel = new Model(models, i);
        for(int colorIndex = 0; colorIndex < 5; colorIndex++) {
            if(appearanceColors[colorIndex] != 0) {
                finalModel.replaceColor(playerColours[colorIndex][0], playerColours[colorIndex][appearanceColors[colorIndex]]);
                if(colorIndex == 1)
                    finalModel.replaceColor(playerSkinColors[0], playerSkinColors[appearanceColors[colorIndex]]);
            }
        }

        return finalModel;
    }

    public void setPlayerAppearance(int[] appearance, boolean gender, int[] appearanceColors, int transformationNpcId) {
        if(appearance == null) {
            appearance = new int[12];
            for(int appearanceIndex = 0; appearanceIndex < 7; appearanceIndex++) {
                for(int identityKitIndex = 0; identityKitLength > identityKitIndex; identityKitIndex++) {
                    IdentityKit identityKit = IdentityKit.cache(identityKitIndex);
                    if(!identityKit.nonSelectable && identityKit.bodyPartId == appearanceIndex + (!gender ? 0 : 7)) {
                        appearance[appearanceIndices[appearanceIndex]] = identityKitIndex + 256;
                        break;
                    }
                }
            }
        }

        this.transformationNpcId = transformationNpcId;
        this.gender = gender;
        this.appearance = appearance;
        this.appearanceColors = appearanceColors;

        updateAppearanceCache();
    }

    public void loadCachedAppearance(int unknown1, boolean unknown2) {
        if(unknown1 != 1 || !gender) {
            int i = appearance[appearanceIndices[unknown1]];
            if(i != 0) {
                i -= 256;
                IdentityKit identityKit;
                do {
                    if(unknown2) {
                        i++;
                        if(i >= identityKitLength)
                            i = 0;
                    } else if(--i < 0)
                        i = -1 + identityKitLength;
                    identityKit = IdentityKit.cache(i);
                } while(identityKit == null || identityKit.nonSelectable || identityKit.bodyPartId != unknown1 + (!gender ? 0 : 7));
                appearance[appearanceIndices[unknown1]] = i + 256;
                updateAppearanceCache();
            }
        }
    }

    public void setGender(boolean gender) {
        if(this.gender == !gender) {
            setPlayerAppearance(null, gender, appearanceColors, -1);
        }
    }

    public void updateAppearanceColors(boolean reset, int appearanceIndex) {
        int appearanceColor = appearanceColors[appearanceIndex];
        if(!reset) {
            if(--appearanceColor < 0)
                appearanceColor = -1 + playerColours[appearanceIndex].length;
        } else if(playerColours[appearanceIndex].length <= ++appearanceColor)
            appearanceColor = 0;
        appearanceColors[appearanceIndex] = appearanceColor;
        updateAppearanceCache();
    }
}
