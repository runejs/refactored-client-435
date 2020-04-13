package com.jagex.runescape.media.renderable;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetType;

public abstract class Renderable extends SubNode {
    public static CacheIndex_Sub1 aClass6_Sub1_2857;
    public static long aLong2858 = 0L;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_2860;
    public static String aClass1_2862 ="@cya@";
    public static String aClass1_2864 =" from your friend list first";
    public static int[] anIntArray2865;
    public static int anInt2866;
    public static int anInt2869;

    static {
        anInt2869 = 0;
    }

    public int modelHeight = 1000;

    public static boolean handleSequences(int arg1) {
        if(!Class68.method1043(arg1))
            return false;
        Widget[] widgets = Widget.interfaces[arg1];
        boolean bool = false;
        for(int i = 0; widgets.length > i; i++) {
            Widget widget = widgets[i];
            if(widget != null && widget.type == WidgetType.MODEL) {
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
                        while(animationSequence.animationLengths[widget.anInt2654] < widget.anInt2660) {
                            bool = true;
                            widget.anInt2660 -= animationSequence.animationLengths[widget.anInt2654];
                            widget.anInt2654++;
                            if(widget.anInt2654 >= animationSequence.anIntArray2485.length) {
                                widget.anInt2654 -= animationSequence.frameStep;
                                if(widget.anInt2654 < 0 || animationSequence.anIntArray2485.length <= widget.anInt2654)
                                    widget.anInt2654 = 0;
                            }
                        }
                    }
                }
                if(widget.anInt2722 != 0) {
                    bool = true;
                    int i_2_ = widget.anInt2722 >> 16;
                    int i_3_ = widget.anInt2722 << 16 >> 16;
                    i_2_ *= Class5.anInt199;
                    widget.rotationX = 0x7ff & i_2_ + widget.rotationX;
                    i_3_ *= Class5.anInt199;
                    widget.rotationZ = 0x7ff & widget.rotationZ + i_3_;
                }
            }
        }
        return bool;
    }

    public void renderAtPoint(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8) {
        Model class40_sub5_sub17_sub5 = getRotatedModel();
        if(class40_sub5_sub17_sub5 != null) {
            modelHeight = class40_sub5_sub17_sub5.modelHeight;
            class40_sub5_sub17_sub5.renderAtPoint(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        }
    }

    public Model getRotatedModel() {
        return null;
    }
}
