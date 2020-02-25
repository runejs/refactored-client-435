package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;

public abstract class Renderable extends SubNode {
    public static int anInt2855;
    public static RSString[] chatPlayerNames;
    public static CacheIndex_Sub1 aClass6_Sub1_2857;
    public static long aLong2858 = 0L;
    public static int anInt2859;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2860;
    public static RSString aClass1_2862 = RSString.CreateString("@cya@");
    public static int anInt2863;
    public static RSString aClass1_2864;
    public static int[] anIntArray2865;
    public static int anInt2866;
    public static int anInt2867;
    public static int anInt2868;
    public static int anInt2869;
    public static RSString aClass1_2870;
    public static RSString aClass1_2871;

    static {
        chatPlayerNames = new RSString[100];
        anInt2869 = 0;
        aClass1_2870 = RSString.CreateString(" from your friend list first");
        aClass1_2864 = aClass1_2870;
        aClass1_2871 = RSString.CreateString("Bitte versuchen Sie)1");
    }

    public int anInt2861 = 1000;

    public static boolean handleSequences(int arg0, int arg1) {

        anInt2859++;
        if(!Class68.method1043(arg1))
            return false;
        Widget[] widgets = Widget.interfaces[arg1];
        if(arg0 != 29378)
            anInt2866 = 125;
        boolean bool = false;
        for(int i = 0; widgets.length > i; i++) {
            Widget widget = widgets[i];
            if(widget != null && widget.type == 6) {
                if(widget.animation != -1 || widget.alternateAnimation != -1) {
                    boolean bool_0_ = ItemDefinition.method746(widget);
                    int i_1_;
                    if(bool_0_)
                        i_1_ = widget.alternateAnimation;
                    else
                        i_1_ = widget.animation;
                    if(i_1_ != -1) {
                        AnimationSequence animationSequence = Class68_Sub1.method1050(i_1_, 2);
                        widget.anInt2660 += Class5.anInt199;
                        while((animationSequence.animationLengths[widget.anInt2654]) < widget.anInt2660) {
                            bool = true;
                            widget.anInt2660 -= (animationSequence.animationLengths[widget.anInt2654]);
                            widget.anInt2654++;
                            if((widget.anInt2654 >= animationSequence.anIntArray2485.length)) {
                                widget.anInt2654 -= animationSequence.frameStep;
                                if(widget.anInt2654 < 0 || ((animationSequence.anIntArray2485).length <= widget.anInt2654))
                                    widget.anInt2654 = 0;
                            }
                        }
                    }
                }
                if(widget.anInt2722 != 0) {
                    bool = true;
                    int i_2_ = widget.anInt2722 >> 16;
                    int i_3_ = (widget.anInt2722 << 16 >> 16);
                    i_2_ *= Class5.anInt199;
                    widget.rotationX = 0x7ff & i_2_ + widget.rotationX;
                    i_3_ *= Class5.anInt199;
                    widget.rotationZ = 0x7ff & widget.rotationZ + i_3_;
                }
            }
        }
        return bool;

    }

    public static void method757(byte arg0) {

        aClass1_2871 = null;
        chatPlayerNames = null;
        if(arg0 > -112)
            method757((byte) 59);
        aClass40_Sub5_Sub14_Sub2_2860 = null;
        aClass6_Sub1_2857 = null;
        aClass1_2870 = null;
        anIntArray2865 = null;
        aClass1_2862 = null;
        aClass1_2864 = null;

    }

    public void method755(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        anInt2868++;
        Model class40_sub5_sub17_sub5 = getRotatedModel(-38);
        if(class40_sub5_sub17_sub5 != null) {
            anInt2861 = class40_sub5_sub17_sub5.anInt2861;
            class40_sub5_sub17_sub5.method755(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    public Model getRotatedModel(int arg0) {

        int i = 87 / ((arg0 - 41) / 47);
        anInt2855++;
        return null;

    }
}
