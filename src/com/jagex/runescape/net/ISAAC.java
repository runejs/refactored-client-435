package com.jagex.runescape.net;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.tile.FloorDecoration;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;

public class ISAAC {
    /**
     * The golden ratio.
     */
    private static final int GOLDEN_RATIO = 0x9e3779b9;

    public static boolean redrawTabArea = false;
    public static RSString aClass1_506 = RSString.CreateString("titlebutton");
    public static int anInt509 = 0;
    public static Cache aClass9_510 = new Cache(64);
    public static boolean aBoolean512;
    public static RSString aClass1_515 = RSString.CreateString(": ");
    public static Cache aClass9_516 = new Cache(64);
    public static boolean aBoolean519 = true;
    public static Signlink aClass31_521;
    public static int anInt522 = -1;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_524;
    public static int anInt525;
    public static RSString aClass1_526 = RSString.CreateString("Invalid username or password)3");
    public static int[] mapCoordinates;

    public int count;
    public int accumulator;
    public int counter;
    public int[] rsl;
    public int[] mem;
    public int result;

    public ISAAC(int[] seed) {
        mem = new int[256];
        rsl = new int[256];
        for(int i = 0; seed.length > i; i++)
            rsl[i] = seed[i];
        init(true);
    }

    public static void method281(Scene arg0, int arg1, CollisionMap[] arg2) {
        for(int i = 0; i < 4; i++) {
            for(int i_0_ = 0; i_0_ < 104; i_0_++) {
                for(int i_1_ = 0; i_1_ < 104; i_1_++) {
                    if((0x1 & (OverlayDefinition.tile_flags[i][i_0_][i_1_])) == 1) {
                        int i_2_ = i;
                        if((0x2 & (OverlayDefinition.tile_flags[1][i_0_][i_1_])) == 2)
                            i_2_--;
                        if(i_2_ >= 0)
                            arg2[i_2_].markBlocked(i_1_, i_0_);
                    }
                }
            }
        }
        Class40_Sub5_Sub15.anInt2791 += (int) (5.0 * Math.random()) + -2;
        Actor.anInt3151 += -2 + (int) (5.0 * Math.random());
        if(Class40_Sub5_Sub15.anInt2791 < -8)
            Class40_Sub5_Sub15.anInt2791 = -8;
        if(Class40_Sub5_Sub15.anInt2791 > 8)
            Class40_Sub5_Sub15.anInt2791 = 8;
        if(Actor.anInt3151 < -16)
            Actor.anInt3151 = -16;
        if(Actor.anInt3151 > 16)
            Actor.anInt3151 = 16;
        for(int i = 0; i < 4; i++) {
            byte[][] is = InteractiveObject.aByteArrayArrayArray492[i];
            int i_3_ = (int) Math.sqrt(5100.0);
            int i_4_ = i_3_ * 768 >> 8;
            for(int i_5_ = 1; i_5_ < 103; i_5_++) {
                for(int i_6_ = 1; i_6_ < 103; i_6_++) {
                    int i_7_ = (-(Class40_Sub6.tile_height[i][i_6_ - 1][i_5_]) + (Class40_Sub6.tile_height[i][1 + i_6_][i_5_]));
                    int i_8_ = ((Class40_Sub6.tile_height[i][i_6_][i_5_ + 1]) + -(Class40_Sub6.tile_height[i][i_6_][i_5_ + -1]));
                    int i_9_ = (int) Math.sqrt(i_8_ * i_8_ + i_7_ * i_7_ + 65536);
                    int i_10_ = 65536 / i_9_;
                    int i_11_ = ((is[i_6_][i_5_] >> 1) + ((is[i_6_][-1 + i_5_] >> 2) + (is[1 + i_6_][i_5_] >> 3) + (is[i_6_ - 1][i_5_] >> 2) + (is[i_6_][1 + i_5_] >> 3)));
                    int i_12_ = (i_7_ << 8) / i_9_;
                    int i_13_ = (i_8_ << 8) / i_9_;
                    int i_14_ = 96 + (i_12_ * -50 + (-10 * i_10_) + i_13_ * -50) / i_4_;
                    AnimationSequence.anIntArrayArray2490[i_6_][i_5_] = i_14_ + -i_11_;
                }
            }
            for(int i_15_ = 0; i_15_ < 104; i_15_++) {
                Class40_Sub5_Sub17_Sub6.anIntArray3250[i_15_] = 0;
                Class59.anIntArray1398[i_15_] = 0;
                SceneTile.anIntArray2048[i_15_] = 0;
                Class67.anIntArray1579[i_15_] = 0;
                FloorDecoration.anIntArray612[i_15_] = 0;
            }
            for(int i_16_ = -5; i_16_ < 109; i_16_++) {
                for(int i_17_ = 0; i_17_ < 104; i_17_++) {
                    int i_18_ = 5 + i_16_;
                    if(i_18_ >= 0 && i_18_ < 104) {
                        int i_19_ = 0xff & (Class42.tile_underlayids[i][i_18_][i_17_]);
                        if(i_19_ > 0) {
                            UnderlayDefinition underlayDefinition = Class40_Sub3.method531((byte) -66, i_19_ - 1);
                            Class40_Sub5_Sub17_Sub6.anIntArray3250[i_17_] += underlayDefinition.anInt2565;
                            Class59.anIntArray1398[i_17_] += underlayDefinition.hue;
                            SceneTile.anIntArray2048[i_17_] += underlayDefinition.saturation;
                            Class67.anIntArray1579[i_17_] += underlayDefinition.hueMultiplier;
                            FloorDecoration.anIntArray612[i_17_]++;
                        }
                    }
                    int i_20_ = i_16_ - 5;
                    if(i_20_ >= 0 && i_20_ < 104) {
                        int i_21_ = 0xff & (Class42.tile_underlayids[i][i_20_][i_17_]);
                        if(i_21_ > 0) {
                            UnderlayDefinition underlayDefinition = Class40_Sub3.method531((byte) -95, -1 + i_21_);
                            Class40_Sub5_Sub17_Sub6.anIntArray3250[i_17_] -= underlayDefinition.anInt2565;
                            Class59.anIntArray1398[i_17_] -= underlayDefinition.hue;
                            SceneTile.anIntArray2048[i_17_] -= underlayDefinition.saturation;
                            Class67.anIntArray1579[i_17_] -= underlayDefinition.hueMultiplier;
                            FloorDecoration.anIntArray612[i_17_]--;
                        }
                    }
                }
                if(i_16_ >= 1 && i_16_ < 103) {
                    int i_22_ = 0;
                    int i_23_ = 0;
                    int i_24_ = 0;
                    int i_25_ = 0;
                    int i_26_ = 0;
                    for(int i_27_ = -5; i_27_ < 109; i_27_++) {
                        int i_28_ = i_27_ + 5;
                        int i_29_ = i_27_ + -5;
                        if(i_28_ >= 0 && i_28_ < 104) {
                            i_26_ += Class67.anIntArray1579[i_28_];
                            i_23_ += Class59.anIntArray1398[i_28_];
                            i_25_ += FloorDecoration.anIntArray612[i_28_];
                            i_24_ += SceneTile.anIntArray2048[i_28_];
                            i_22_ += (Class40_Sub5_Sub17_Sub6.anIntArray3250[i_28_]);
                        }
                        if(i_29_ >= 0 && i_29_ < 104) {
                            i_23_ -= Class59.anIntArray1398[i_29_];
                            i_25_ -= FloorDecoration.anIntArray612[i_29_];
                            i_24_ -= SceneTile.anIntArray2048[i_29_];
                            i_26_ -= Class67.anIntArray1579[i_29_];
                            i_22_ -= (Class40_Sub5_Sub17_Sub6.anIntArray3250[i_29_]);
                        }
                        if(i_27_ >= 1 && i_27_ < 103 && (!VertexNormal.lowMemory || (0x2 & (OverlayDefinition.tile_flags[0][i_16_][i_27_])) != 0 || ((0x10 & (OverlayDefinition.tile_flags[i][i_16_][i_27_])) == 0 && (Class40_Sub6.onBuildTimePlane == Class59.getVisibilityPlaneFor(i, i_27_, 0, i_16_))))) {
                            if(Class64.lowestPlane > i)
                                Class64.lowestPlane = i;
                            int i_30_ = ((Class42.tile_underlayids[i][i_16_][i_27_]) & 0xff);
                            int i_31_ = ((MouseHandler.tile_overlayids[i][i_16_][i_27_]) & 0xff);
                            if(i_30_ > 0 || i_31_ > 0) {
                                int i_32_ = (Class40_Sub6.tile_height[i][i_16_][i_27_]);
                                int i_33_ = (Class40_Sub6.tile_height[i][i_16_ + 1][i_27_]);
                                int i_34_ = (Class40_Sub6.tile_height[i][i_16_ + 1][1 + i_27_]);
                                int i_35_ = (Class40_Sub6.tile_height[i][i_16_][i_27_ + 1]);
                                int i_36_ = (AnimationSequence.anIntArrayArray2490[i_16_][i_27_]);
                                int i_37_ = (AnimationSequence.anIntArrayArray2490[i_16_ + 1][i_27_]);
                                int i_38_ = (AnimationSequence.anIntArrayArray2490[i_16_ + 1][i_27_ + 1]);
                                int i_39_ = -1;
                                int i_40_ = (AnimationSequence.anIntArrayArray2490[i_16_][i_27_ + 1]);
                                int i_41_ = -1;
                                if(i_30_ > 0) {
                                    int i_42_ = 256 * i_22_ / i_26_;
                                    int i_43_ = i_23_ / i_25_;
                                    int i_44_ = i_24_ / i_25_;
                                    i_39_ = Class13.method244(i_43_, i_44_, i_42_);
                                    i_44_ += (Actor.anInt3151);
                                    i_42_ = i_42_ + (Class40_Sub5_Sub15.anInt2791) & 0xff;
                                    if(i_44_ >= 0) {
                                        if(i_44_ > 255)
                                            i_44_ = 255;
                                    } else
                                        i_44_ = 0;
                                    i_41_ = Class13.method244(i_43_, i_44_, i_42_);
                                }
                                if(i > 0) {
                                    boolean bool = true;
                                    if(i_30_ == 0 && (OverlayDefinition.tile_underlay_path[i][i_16_][i_27_]) != 0)
                                        bool = false;
                                    if(i_31_ > 0 && !(Npc.loadFloor(-1 + i_31_, arg1 + -27320).aBoolean2338))
                                        bool = false;
                                    if(bool && (i_32_ == i_33_) && i_34_ == i_32_ && (i_32_ == i_35_))
                                        CacheIndex.anIntArrayArrayArray262[i][i_16_][i_27_] = (UnderlayDefinition.bitWiseOR((CacheIndex.anIntArrayArrayArray262[i][i_16_][i_27_]), 2340));
                                }
                                int i_45_ = 0;
                                if(i_41_ != -1)
                                    i_45_ = (Rasterizer3D.hsl2rgb[(Class40_Sub5_Sub17_Sub6.method831(i_41_, 96, (byte) 73))]);
                                if(i_31_ != 0) {
                                    int i_46_ = 1 + (OverlayDefinition.tile_underlay_path[i][i_16_][i_27_]);
                                    byte i_47_ = (Class35.tile_overlay_rotation[i][i_16_][i_27_]);
                                    OverlayDefinition class40_sub5_sub3 = Npc.loadFloor(-1 + i_31_, 4);
                                    int i_48_ = class40_sub5_sub3.anInt2322;
                                    int i_49_;
                                    int i_50_;
                                    if(i_48_ >= 0) {
                                        i_49_ = -1;
                                        i_50_ = Rasterizer3D.anInterface3_2939.method14(true, i_48_);
                                    } else if(class40_sub5_sub3.anInt2345 == 16711935) {
                                        i_49_ = -2;
                                        i_48_ = -1;
                                        i_50_ = -2;
                                    } else {
                                        i_49_ = (Class13.method244((class40_sub5_sub3.lightness), (class40_sub5_sub3.saturation), (class40_sub5_sub3.hue)));
                                        int i_51_ = (Class40_Sub5_Sub15.anInt2791 + (class40_sub5_sub3.hue)) & 0xff;
                                        int i_52_ = ((Actor.anInt3151) + (class40_sub5_sub3.saturation));
                                        if(i_52_ < 0)
                                            i_52_ = 0;
                                        else if(i_52_ > 255)
                                            i_52_ = 255;
                                        i_50_ = (Class13.method244((class40_sub5_sub3.lightness), i_52_, i_51_));
                                    }
                                    int i_53_ = 0;
                                    if(i_50_ != -2)
                                        i_53_ = (Rasterizer3D.hsl2rgb[Class34.method420(i_50_, 96, true)]);
                                    if(class40_sub5_sub3.anInt2336 != -1) {
                                        int i_54_ = 0xff & ((Class40_Sub5_Sub15.anInt2791) + (class40_sub5_sub3.anInt2334));
                                        int i_55_ = (class40_sub5_sub3.anInt2330 + (Actor.anInt3151));
                                        if(i_55_ >= 0) {
                                            if(i_55_ > 255)
                                                i_55_ = 255;
                                        } else
                                            i_55_ = 0;
                                        i_50_ = (Class13.method244((class40_sub5_sub3.anInt2346), i_55_, i_54_));
                                        i_53_ = (Rasterizer3D.hsl2rgb[Class34.method420(i_50_, 96, true)]);
                                    }
                                    arg0.addTile(i, i_16_, i_27_, i_46_, i_47_, i_48_, i_32_, i_33_, i_34_, i_35_, (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_36_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_37_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_38_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_40_, (byte) 73)), Class34.method420(i_49_, i_36_, true), Class34.method420(i_49_, i_37_, true), Class34.method420(i_49_, i_38_, true), Class34.method420(i_49_, i_40_, true), i_45_, i_53_);
                                } else
                                    arg0.addTile(i, i_16_, i_27_, 0, 0, -1, i_32_, i_33_, i_34_, i_35_, (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_36_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_37_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_38_, (byte) 73)), (Class40_Sub5_Sub17_Sub6.method831(i_39_, i_40_, (byte) 73)), 0, 0, 0, 0, i_45_, 0);
                            }
                        }
                    }
                }
            }
            for(int i_56_ = 1; i_56_ < 103; i_56_++) {
                for(int i_57_ = 1; i_57_ < 103; i_57_++)
                    arg0.method130(i, i_57_, i_56_, Class59.getVisibilityPlaneFor(i, i_56_, 0, i_57_));
            }
            Class42.tile_underlayids[i] = null;
            MouseHandler.tile_overlayids[i] = null;
            OverlayDefinition.tile_underlay_path[i] = null;
            Class35.tile_overlay_rotation[i] = null;
            InteractiveObject.aByteArrayArrayArray492[i] = null;
        }
        arg0.method118(-50, -10, -50);
        for(int i = 0; i < 104; i++) {
            for(int i_58_ = 0; i_58_ < 104; i_58_++) {
                if(((OverlayDefinition.tile_flags[1][i][i_58_]) & 0x2) == 2)
                    arg0.method92(i, i_58_);
            }
        }
        int i = 1;
        int i_59_ = 2;
        int i_60_ = 4;
        if(arg1 != 27324)
            method281(null, 6, null);
        for(int i_61_ = 0; i_61_ < 4; i_61_++) {
            if(i_61_ > 0) {
                i <<= 3;
                i_60_ <<= 3;
                i_59_ <<= 3;
            }
            for(int i_62_ = 0; (i_62_ <= i_61_); i_62_++) {
                for(int i_63_ = 0; i_63_ <= 104; i_63_++) {
                    for(int i_64_ = 0; i_64_ <= 104; i_64_++) {
                        if(((CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][i_63_]) & i) != 0) {
                            int i_65_;
                            for(i_65_ = i_63_; (i_65_ > 0 && (i & (CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][-1 + i_65_])) != 0); i_65_--) {
                                /* empty */
                            }
                            int i_66_;
                            for(i_66_ = i_63_; (i_66_ < 104 && ((CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][i_66_ + 1]) & i) != 0); i_66_++) {
                                /* empty */
                            }
                            int i_67_ = i_62_;
                            int i_68_ = i_62_;
                            while_4_:
                            for(/**/; i_67_ > 0; i_67_--) {
                                for(int i_69_ = i_65_; ((i_69_ <= i_66_)); i_69_++) {
                                    if(((CacheIndex.anIntArrayArrayArray262[-1 + i_67_][i_64_][i_69_]) & i) == 0)
                                        break while_4_;
                                }
                            }
                            while_5_:
                            for(/**/; i_68_ < i_61_; i_68_++) {
                                for(int i_70_ = i_65_; ((i_70_ <= i_66_)); i_70_++) {
                                    if((i & (CacheIndex.anIntArrayArrayArray262[i_68_ + 1][i_64_][i_70_])) == 0)
                                        break while_5_;
                                }
                            }
                            int i_71_ = ((-i_65_ + (i_66_ + 1)) * (-i_67_ + (i_68_ + 1)));
                            if(i_71_ >= 8) {
                                int i_72_ = 240;
                                int i_73_ = -i_72_ + (Class40_Sub6.tile_height[i_68_][i_64_][i_65_]);
                                int i_74_ = (Class40_Sub6.tile_height[i_67_][i_64_][i_65_]);
                                Scene.method116(i_61_, 1, 128 * i_64_, 128 * i_64_, 128 * i_65_, 128 + 128 * i_66_, i_73_, i_74_);
                                for(int i_75_ = i_67_; ((i_75_ <= i_68_)); i_75_++) {
                                    for(int i_76_ = i_65_; ((i_76_ <= i_66_)); i_76_++)
                                        CacheIndex.anIntArrayArrayArray262[i_75_][i_64_][i_76_] = (HuffmanEncoding.method1021((CacheIndex.anIntArrayArrayArray262[i_75_][i_64_][i_76_]), i ^ 0xffffffff));
                                }
                            }
                        }
                        if((i_59_ & (CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][i_63_])) != 0) {
                            int i_77_;
                            for(i_77_ = i_64_; (i_77_ > 0 && (i_59_ & (CacheIndex.anIntArrayArrayArray262[i_62_][i_77_ - 1][i_63_])) != 0); i_77_--) {
                                /* empty */
                            }
                            int i_78_ = i_62_;
                            int i_79_ = i_64_;
                            int i_80_ = i_62_;
                            for(/**/; i_79_ < 104; i_79_++) {
                                if((i_59_ & (CacheIndex.anIntArrayArrayArray262[i_62_][1 + i_79_][i_63_])) == 0)
                                    break;
                            }
                            while_6_:
                            for(/**/; i_80_ > 0; i_80_--) {
                                for(int i_81_ = i_77_; i_81_ <= i_79_; i_81_++) {
                                    if(((CacheIndex.anIntArrayArrayArray262[i_80_ + -1][i_81_][i_63_]) & i_59_) == 0)
                                        break while_6_;
                                }
                            }
                            while_7_:
                            for(/**/; i_78_ < i_61_; i_78_++) {
                                for(int i_82_ = i_77_; ((i_82_ <= i_79_)); i_82_++) {
                                    if((i_59_ & (CacheIndex.anIntArrayArrayArray262[1 + i_78_][i_82_][i_63_])) == 0)
                                        break while_7_;
                                }
                            }
                            int i_83_ = ((i_79_ - i_77_ + 1) * (-i_80_ + 1 + i_78_));
                            if(i_83_ >= 8) {
                                int i_84_ = (Class40_Sub6.tile_height[i_80_][i_77_][i_63_]);
                                int i_85_ = 240;
                                int i_86_ = ((Class40_Sub6.tile_height[i_78_][i_77_][i_63_]) - i_85_);
                                Scene.method116(i_61_, 2, 128 * i_77_, 128 * i_79_ + 128, 128 * i_63_, i_63_ * 128, i_86_, i_84_);
                                for(int i_87_ = i_80_; ((i_78_ >= i_87_)); i_87_++) {
                                    for(int i_88_ = i_77_; i_88_ <= i_79_; i_88_++)
                                        CacheIndex.anIntArrayArrayArray262[i_87_][i_88_][i_63_] = (HuffmanEncoding.method1021((CacheIndex.anIntArrayArrayArray262[i_87_][i_88_][i_63_]), i_59_ ^ 0xffffffff));
                                }
                            }
                        }
                        if(((CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][i_63_]) & i_60_) != 0) {
                            int i_89_ = i_64_;
                            int i_90_ = i_64_;
                            int i_91_ = i_63_;
                            int i_92_ = i_63_;
                            for(/**/; i_91_ > 0; i_91_--) {
                                if(((CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][-1 + i_91_]) & i_60_) == 0)
                                    break;
                            }
                            for(/**/; i_92_ < 104; i_92_++) {
                                if((i_60_ & (CacheIndex.anIntArrayArrayArray262[i_62_][i_64_][i_92_ + 1])) == 0)
                                    break;
                            }
                            while_8_:
                            for(/**/; i_89_ > 0; i_89_--) {
                                for(int i_93_ = i_91_; i_93_ <= i_92_; i_93_++) {
                                    if((i_60_ & (CacheIndex.anIntArrayArrayArray262[i_62_][i_89_ + -1][i_93_])) == 0)
                                        break while_8_;
                                }
                            }
                            while_9_:
                            for(/**/; i_90_ < 104; i_90_++) {
                                for(int i_94_ = i_91_; ((i_92_ >= i_94_)); i_94_++) {
                                    if((i_60_ & (CacheIndex.anIntArrayArrayArray262[i_62_][1 + i_90_][i_94_])) == 0)
                                        break while_9_;
                                }
                            }
                            if((-i_89_ + i_90_ + 1) * (1 + i_92_ - i_91_) >= 4) {
                                int i_95_ = (Class40_Sub6.tile_height[i_62_][i_89_][i_91_]);
                                Scene.method116(i_61_, 4, i_89_ * 128, i_90_ * 128 + 128, 128 * i_91_, i_92_ * 128 + 128, i_95_, i_95_);
                                for(int i_96_ = i_89_; ((i_96_ <= i_90_)); i_96_++) {
                                    for(int i_97_ = i_91_; ((i_92_ >= i_97_)); i_97_++)
                                        CacheIndex.anIntArrayArrayArray262[i_62_][i_96_][i_97_] = (HuffmanEncoding.method1021((CacheIndex.anIntArrayArrayArray262[i_62_][i_96_][i_97_]), i_60_ ^ 0xffffffff));
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static void method282() {
        aClass1_515 = null;
        aClass1_526 = null;
        aClass40_Sub5_Sub14_Sub2_524 = null;
        aClass1_506 = null;
        aClass9_510 = null;
        aClass9_516 = null;
        aClass31_521 = null;
        mapCoordinates = null;
    }

    public static void method283(long arg0, int arg1) {
        try {
            int i = -93 / ((-50 - arg1) / 45);
            Thread.sleep(arg0);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
    }

    public static void method285(byte arg0) {
        if(arg0 != 118)
            aBoolean519 = true;
        for(Class40_Sub3 class40_sub3 = ((Class40_Sub3) LinkedList.aLinkedList_1064.method902((byte) -90)); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.method909(-4)) {
            if(class40_sub3.anInt2031 == -1) {
                class40_sub3.anInt2033 = 0;
                Class39.method451(class40_sub3, 19813);
            } else
                class40_sub3.method457(arg0 ^ ~0x76);
        }
    }

    public static int method288(byte arg0) {
        if(arg0 < 117)
            method288((byte) 125);
        return 5;
    }

    public void isaac() {
        result += ++counter;
        for(int i = 0; i < 256; i++) {
            int x = mem[i];
            if((i & 0x2) == 0) {
                if((0x1 & i) == 0)
                    accumulator ^= accumulator << 13;
                else
                    accumulator ^= accumulator >>> 6;
            } else if((i & 0x1) != 0)
                accumulator ^= accumulator >>> 16;
            else
                accumulator ^= accumulator << 2;
            accumulator += mem[0xff & 128 + i];
            int y;
            mem[i] = y = mem[(HuffmanEncoding.method1021(x, 1020) >> 2)] + (accumulator + result);
            rsl[i] = result = (x + mem[HuffmanEncoding.method1021((y >> -488567000 >> -1522276318), 255)]);
        }
    }

    /**
     * Gets the next random value.
     *
     * @return The next random value.
     */
    public int nextInt() {
        if(count-- == 0) {
            isaac();
            count = 255;
        }
        return rsl[count];
    }

    public void init(boolean arg0) {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;

        int a = b = c = d = e = f = g = h = GOLDEN_RATIO;
        for(int i = 0; i < 4; i++) {
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            g ^= h << 8;
            b += g;
            a += f;
            h += a;
            h ^= a >>> 9;
            c += h;
            a += b;
        }
        for(int i = 0; i < 256; i += 8) {
            /*
             * fill in mem[] with messy
             * stuff
             */
            h += rsl[7 + i];
            d += rsl[3 + i];
            a += rsl[i];
            b += rsl[i + 1];
            e += rsl[4 + i];
            g += rsl[i + 6];
            f += rsl[5 + i];
            c += rsl[2 + i];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            e += b;
            c += d;
            c ^= d << 8;
            d += e;
            f += c;
            d ^= e >>> 16;
            e += f;
            g += d;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            a += f;
            g ^= h << 8;
            h += a;
            b += g;
            h ^= a >>> 9;
            a += b;
            c += h;
            mem[i] = a;
            mem[i + 1] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        if(!arg0)
            aClass9_516 = null;
        /* second pass makes all of seed affect all of mem */
        for(int i = 0; i < 256; i += 8) {
            h += mem[7 + i];
            g += mem[i + 6];
            c += mem[2 + i];
            d += mem[3 + i];
            f += mem[i + 5];
            a += mem[i];
            e += mem[4 + i];
            b += mem[i + 1];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            a += f;
            g += h;
            g ^= h << 8;
            h += a;
            h ^= a >>> 9;
            b += g;
            a += b;
            c += h;
            mem[i] = a;
            mem[1 + i] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        isaac();
        count = 256;
    }
}
