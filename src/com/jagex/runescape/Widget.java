package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.util.Signlink;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.Date;

public class Widget extends SubNode {
    public static RSString aClass1_2637 = RSString.CreateString("glow2:");
    public static RSString aClass1_2671 = aClass1_2637;
    public static RSString aClass1_2674 = RSString.CreateString("Starting game engine)3)3)3");
    public static RSString aClass1_2684 = RSString.CreateString("Choose Option");
    public static RSString cmd_errortest = RSString.CreateString("::errortest");
    public static RSString aClass1_2716 = RSString.CreateString("Fehler beim Laden Ihres Charakter)2Profils");
    public static RSString goldCrown = RSString.CreateString("@cr2@");
    public static RSString aClass1_2740 = RSString.CreateString("Enter name of friend to add to list");
    public static int packetsize = 0;

    public boolean aBoolean2636 = false;
    public int anInt2639;
    public RSString aClass1_2640;
    public boolean aBoolean2641;
    public int anInt2642;
    public int anInt2643;
    public Object[] anObjectArray2644;
    public boolean aBoolean2645;
    public int anInt2647;
    public int anInt2648;
    public int anInt2649;
    public Object[] anObjectArray2650;
    public int anInt2651 = 1;
    public int anInt2653;
    public int anInt2654;
    public boolean itemUsable;
    public int anInt2656;
    public int anInt2657;
    public Object[] anObjectArray2658;
    public int anInt2659;
    public int anInt2660;
    public RSString[] aClass1Array2661;
    public int anInt2663;
    public RSString aClass1_2664;
    public boolean aBoolean2665;
    public int itemSpritePadsY;
    public RSString aClass1_2668;
    public Object[] anObjectArray2669;
    public int anInt2670;
    public Object[] anObjectArray2672;
    public int anInt2673;
    public RSString aClass1_2676;
    public Object[] anObjectArray2677;
    public int anInt2679;
    public Object[] anObjectArray2680;
    public Object[] anObjectArray2681;
    public boolean aBoolean2682;
    public int type;
    public int[] items;
    public int anInt2687;
    public boolean aBoolean2688;
    public int anInt2689;
    public int anInt2690;
    public int anInt2692;
    public int[] anIntArray2693;
    public boolean aBoolean2694;
    public Object[] anObjectArray2695;
    public int anInt2696;
    public RSString[] aClass1Array2698;
    public int[] images;
    public boolean aBoolean2701;
    public int anInt2702;
    public boolean itemSwapable;
    public int[] imageY;
    public Object[] anObjectArray2707;
    public int[] imageX;
    public RSString aClass1_2709;
    public int[] itemAmounts;
    public int anInt2711;
    public Object[] anObjectArray2712;
    public Widget[] aWidgetArray2713;
    public int anInt2714;
    public int anInt2715;
    public int anInt2718;
    public int anInt2719;
    public int anInt2720;
    public int anInt2721;
    public int anInt2722;
    public boolean itemDeletesDraged;
    public int anInt2725;
    public int anInt2726;
    public boolean isInventory;
    public int anInt2728;
    public boolean aBoolean2730;
    public int scrollPosition;
    public int anInt2732;
    public int anInt2733;
    public int anInt2734;
    public int anInt2736;
    public int anInt2737;
    public int anInt2738;
    public int[] anIntArray2742;
    public int anInt2743;
    public int anInt2744;
    public int anInt2745;
    public int anInt2746;
    public Object[] anObjectArray2747;
    public int[][] anIntArrayArray2748;
    public int itemSpritePadsX;
    public boolean aBoolean2750;
    public int anInt2751;

    public Widget() {
        anInt2639 = 0;
        anInt2657 = 0;
        aBoolean2665 = false;
        aBoolean2641 = false;
        aClass1_2664 = Class22_Sub2.aClass1_1877;
        anInt2654 = 0;
        aClass1_2676 = Class39.aClass1_919;
        itemSpritePadsY = 0;
        anInt2660 = 0;
        anInt2687 = 1;
        anInt2653 = -1;
        anInt2647 = 0;
        aBoolean2682 = false;
        anInt2673 = -1;
        anInt2690 = 0;
        anInt2702 = 0;
        aBoolean2694 = false;
        anInt2648 = -1;
        anInt2663 = 0;
        aBoolean2688 = false;
        anInt2670 = -1;
        anInt2696 = 0;
        anInt2711 = -1;
        anInt2649 = 0;
        isInventory = false;
        aClass1_2640 = Class22_Sub2.aClass1_1877;
        itemSwapable = false;
        anInt2719 = 0;
        anInt2692 = 0;
        anInt2659 = -1;
        anInt2733 = 0;
        anInt2721 = -1;
        aClass1_2709 = Class22_Sub2.aClass1_1877;
        anInt2679 = 0;
        anInt2734 = 0;
        aClass1_2668 = Class22_Sub2.aClass1_1877;
        anInt2689 = -1;
        anInt2732 = 0;
        itemUsable = false;
        aBoolean2645 = false;
        anInt2738 = -1;
        anInt2728 = 100;
        itemDeletesDraged = false;
        anInt2722 = 0;
        anInt2715 = 0;
        anInt2656 = 0;
        aBoolean2701 = false;
        anInt2744 = -1;
        aBoolean2730 = false;
        anInt2643 = 0;
        anInt2745 = 0;
        anInt2743 = 0;
        anInt2725 = 0;
        anInt2746 = 0;
        anInt2737 = 0;
        aBoolean2750 = false;
        anInt2726 = 0;
        anInt2720 = 0;
        scrollPosition = 0;
        anInt2736 = 0;
        anInt2718 = -1;
        itemSpritePadsX = 0;
        anInt2714 = 0;
        anInt2751 = 0;
    }

    public static void method639(int arg0) {
        synchronized(Class59.aClass54_1392) {
            Class59.anInt1389 = Class52.anInt1214;
            if(GameObjectDefinition.anInt2543 < 0) {
                for(int i = 0; (i ^ 0xffffffff) > -113; i++)
                    Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = false;
                GameObjectDefinition.anInt2543 = Class40_Sub13.anInt2183;
            } else {
                while((Class40_Sub13.anInt2183 ^ 0xffffffff) != (GameObjectDefinition.anInt2543 ^ 0xffffffff)) {
                    int i = RSString.anIntArray1706[Class40_Sub13.anInt2183];
                    Class40_Sub13.anInt2183 = 0x7f & Class40_Sub13.anInt2183 + 1;
                    if((i ^ 0xffffffff) > -1)
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i ^ 0xffffffff] = false;
                    else
                        Class40_Sub5_Sub17_Sub3.aBooleanArray3056[i] = true;
                }
            }
            Class52.anInt1214 = IdentityKit.anInt2598;
        }
        if(arg0 <= 121)
            aClass1_2674 = null;
    }

    public static void method640(byte arg0) {
        Class68.aClass9_1615.method235((byte) 49);
    }

    public static void method641(int arg0) {
        aClass1_2716 = null;
        aClass1_2671 = null;
        if(arg0 > -88)
            method648(85, (byte) 24);
        cmd_errortest = null;
        goldCrown = null;
        aClass1_2637 = null;
        aClass1_2674 = null;
        aClass1_2740 = null;
        aClass1_2684 = null;
    }

    public static void method642(Component arg0, int arg1) {
        if(arg1 != -10)
            method639(-106);
        Method method = Signlink.aMethod729;
        if(method != null) {
            try {
                method.invoke(arg0, Boolean.FALSE);
            } catch(Throwable throwable) {
                /* empty */
            }
        }
        arg0.addKeyListener(Class59.aClass54_1392);
        arg0.addFocusListener(Class59.aClass54_1392);
    }

    public static void method645(byte arg0) {
        Class58.aClass9_1364.method235((byte) 118);
        VertexNormal.aClass9_1102.method235((byte) -42);
        if(arg0 != -37)
            aClass1_2637 = null;
        Class19.aClass9_470.method235((byte) 103);
        Class49.aClass9_1145.method235((byte) 97);
    }

    public static RSString method648(int arg0, byte arg1) {
        if(arg1 != -100)
            return null;
        if(arg0 < 100000)
            return HashTable.method334(arg0, -1);
        if((arg0 ^ 0xffffffff) > -10000001)
            return (Class40_Sub5_Sub17_Sub6.method832(110, new RSString[]{HashTable.method334(arg0 / 1000, -1), IdentityKit.aClass1_2587}));
        return (Class40_Sub5_Sub17_Sub6.method832(-84, new RSString[]{HashTable.method334(arg0 / 1000000, arg1 ^ 0x63), Class22.aClass1_542}));
    }

    // Load/parse widgets
    public static void method891(Object[] arg0, int arg1, int arg2, Widget arg3, int arg4, boolean arg5) {

        Class43.anInt1015++;
        int i = 0;
        Class40_Sub5_Sub1 class40_sub5_sub1 = IdentityKit.method626(((Integer) arg0[0]).intValue(), 76, 27);
        int[] is = class40_sub5_sub1.anIntArray2262;
        int[] is_0_ = class40_sub5_sub1.anIntArray2272;
        int i_1_ = 0;
        int i_2_ = -1;
        int i_3_ = -1;
        try {
            anIntArray2086 = new int[class40_sub5_sub1.anInt2271];
            Class51.aClass1Array1204 = new RSString[class40_sub5_sub1.anInt2267];
            int i_4_ = 0;
            int i_5_ = 0;
            if(arg5 != false)
                Class43.cameraYawOffset = -119;
            for(int i_6_ = 1; i_6_ < arg0.length; i_6_++) {
                if(!(arg0[i_6_] instanceof Integer)) {
                    if(arg0[i_6_] instanceof RSString)
                        Class51.aClass1Array1204[i_5_++] = (RSString) arg0[i_6_];
                } else {
                    int i_7_ = ((Integer) arg0[i_6_]).intValue();
                    if((i_7_ ^ 0xffffffff) == 2147483646)
                        i_7_ = arg4;
                    if(i_7_ == -2147483646)
                        i_7_ = arg2;
                    if(i_7_ == -2147483645)
                        i_7_ = arg3.anInt2689;
                    if(i_7_ == -2147483644)
                        i_7_ = arg1;
                    anIntArray2086[i_4_++] = i_7_;
                }
            }
            for(; ; ) {
                i_3_ = is_0_[++i_2_];
                if((i_3_ ^ 0xffffffff) > -101) {
                    if((i_3_ ^ 0xffffffff) == -1) {
                        Class67.anIntArray1588[i++] = is[i_2_];
                        continue;
                    }
                    if(i_3_ == 1) {
                        int i_8_ = is[i_2_];
                        Class67.anIntArray1588[i++] = Class58.varbitmasks[i_8_];
                        continue;
                    }
                    if(i_3_ == 2) {
                        int i_9_ = is[i_2_];
                        Class58.varbitmasks[i_9_] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -4) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = class40_sub5_sub1.aClass1Array2270[i_2_];
                        continue;
                    }
                    if(i_3_ == 6) {
                        i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -8) {
                        i -= 2;
                        if(Class67.anIntArray1588[i] != Class67.anIntArray1588[1 + i])
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if(i_3_ == 8) {
                        i -= 2;
                        if((Class67.anIntArray1588[1 + i] ^ 0xffffffff) == (Class67.anIntArray1588[i] ^ 0xffffffff))
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -10) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] > Class67.anIntArray1588[i])
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -11) {
                        i -= 2;
                        if(Class67.anIntArray1588[1 + i] < Class67.anIntArray1588[i])
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -22) {
                        if((Class29.anInt678 ^ 0xffffffff) != -1) {
                            Class61 class61 = (Class56.aClass61Array1320[--Class29.anInt678]);
                            Class51.aClass1Array1204 = class61.aClass1Array1430;
                            anIntArray2086 = class61.anIntArray1420;
                            i_2_ = class61.anInt1433;
                            class40_sub5_sub1 = class61.aClass40_Sub5_Sub1_1419;
                            is = class40_sub5_sub1.anIntArray2262;
                            is_0_ = class40_sub5_sub1.anIntArray2272;
                            continue;
                        }
                        break;
                    }
                    if(i_3_ == 25) {
                        int i_10_ = is[i_2_];
                        Class67.anIntArray1588[i++] = Class40_Sub5_Sub6.method585(i_10_, 1369);
                        continue;
                    }
                    if(i_3_ == 27) {
                        int i_11_ = is[i_2_];
                        Class40_Sub2.method522(Class67.anIntArray1588[--i], i_11_, (byte) 118);
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -32) {
                        i -= 2;
                        if((Class67.anIntArray1588[i] <= Class67.anIntArray1588[i + 1]))
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -33) {
                        i -= 2;
                        if((Class67.anIntArray1588[1 + i] <= Class67.anIntArray1588[i]))
                            i_2_ += is[i_2_];
                        continue;
                    }
                    if(i_3_ == 33) {
                        Class67.anIntArray1588[i++] = anIntArray2086[is[i_2_]];
                        continue;
                    }
                    if(i_3_ == 34) {
                        anIntArray2086[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                    if(i_3_ == 35) {
                        Class40_Sub11.aClass1Array2153[i_1_++] = Class51.aClass1Array1204[is[i_2_]];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -37) {
                        Class51.aClass1Array1204[is[i_2_]] = Class40_Sub11.aClass1Array2153[--i_1_];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -38) {
                        int i_12_ = is[i_2_];
                        i_1_ -= i_12_;
                        RSString class1 = (IdentityKit.method627(63, i_12_, i_1_, Class40_Sub11.aClass1Array2153));
                        Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -39) {
                        i--;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -40) {
                        i_1_--;
                        continue;
                    }
                    if(i_3_ == 40) {
                        int i_13_ = is[i_2_];
                        Class40_Sub5_Sub1 class40_sub5_sub1_14_ = IdentityKit.method626(i_13_, 73, 65);
                        int[] is_15_ = new int[class40_sub5_sub1_14_.anInt2271];
                        RSString[] class1s = new RSString[class40_sub5_sub1_14_.anInt2267];
                        for(int i_16_ = 0; ((class40_sub5_sub1_14_.anInt2263 > i_16_)); i_16_++)
                            is_15_[i_16_] = (Class67.anIntArray1588[i - (class40_sub5_sub1_14_.anInt2263 + -i_16_)]);
                        for(int i_17_ = 0; class40_sub5_sub1_14_.anInt2266 > i_17_; i_17_++)
                            class1s[i_17_] = (Class40_Sub11.aClass1Array2153[(i_1_ - class40_sub5_sub1_14_.anInt2266 + i_17_)]);
                        i_1_ -= class40_sub5_sub1_14_.anInt2266;
                        i -= class40_sub5_sub1_14_.anInt2263;
                        Class61 class61 = new Class61();
                        class61.aClass1Array1430 = Class51.aClass1Array1204;
                        class61.aClass40_Sub5_Sub1_1419 = class40_sub5_sub1;
                        class61.anIntArray1420 = anIntArray2086;
                        class40_sub5_sub1 = class40_sub5_sub1_14_;
                        class61.anInt1433 = i_2_;
                        Class56.aClass61Array1320[Class29.anInt678++] = class61;
                        is = class40_sub5_sub1.anIntArray2262;
                        Class51.aClass1Array1204 = class1s;
                        i_2_ = -1;
                        anIntArray2086 = is_15_;
                        is_0_ = class40_sub5_sub1.anIntArray2272;
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -43) {
                        Class67.anIntArray1588[i++] = Class22_Sub1.anIntArray1847[is[i_2_]];
                        continue;
                    }
                    if((i_3_ ^ 0xffffffff) == -44) {
                        Class22_Sub1.anIntArray1847[is[i_2_]] = Class67.anIntArray1588[--i];
                        continue;
                    }
                }
                boolean bool;
                bool = (is[i_2_] ^ 0xffffffff) == -2;
                if((i_3_ ^ 0xffffffff) > -1001) {
                    if((i_3_ ^ 0xffffffff) == -101) {
                        i -= 3;
                        int i_18_ = Class67.anIntArray1588[i];
                        int i_19_ = Class67.anIntArray1588[i + 1];
                        int i_20_ = Class67.anIntArray1588[i + 2];
                        Widget widget = Class68.method1045(i_18_, (byte) -108);
                        if(widget.aWidgetArray2713 == null)
                            widget.aWidgetArray2713 = new Widget[1 + i_20_];
                        if((i_20_ ^ 0xffffffff) <= ((widget.aWidgetArray2713).length ^ 0xffffffff)) {
                            Widget[] widgets = new Widget[1 + i_20_];
                            for(int i_21_ = 0; (((widget.aWidgetArray2713).length > i_21_)); i_21_++)
                                widgets[i_21_] = (widget.aWidgetArray2713[i_21_]);
                            widget.aWidgetArray2713 = widgets;
                        }
                        Widget widget_22_ = new Widget();
                        widget_22_.anInt2648 = widget.anInt2689;
                        widget_22_.type = i_19_;
                        widget_22_.anInt2689 = ((0xffff & widget.anInt2689) << -1708169617) + (-2147483648 + i_20_);
                        widget.aWidgetArray2713[i_20_] = widget_22_;
                        if(!bool)
                            Class22_Sub2.aWidget_1887 = widget_22_;
                        else
                            Class40_Sub6.aWidget_2116 = widget_22_;
                    } else if(i_3_ == 101) {
                        Widget widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                        Widget widget_23_ = Class68.method1045((widget.anInt2648), (byte) -100);
                        widget_23_.aWidgetArray2713[Class66.method1021((widget.anInt2689), 32767)] = null;
                    } else {
                        if(i_3_ != 102)
                            break;
                        Widget widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -83);
                        widget.aWidgetArray2713 = null;
                    }
                } else if(((i_3_ ^ 0xffffffff) <= -1001 && (i_3_ ^ 0xffffffff) > -1101) || ((i_3_ ^ 0xffffffff) <= -2001 && i_3_ < 2100)) {
                    Widget widget;
                    if(i_3_ >= 2000) {
                        widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -64);
                        i_3_ -= 1000;
                    } else
                        widget = (bool ? Class40_Sub6.aWidget_2116 : Class22_Sub2.aWidget_1887);
                    if((i_3_ ^ 0xffffffff) == -1001) {
                        i -= 2;
                        widget.anInt2656 = Class67.anIntArray1588[i];
                        widget.anInt2696 = Class67.anIntArray1588[i + 1];
                    } else if((i_3_ ^ 0xffffffff) == -1002) {
                        i -= 2;
                        widget.anInt2692 = Class67.anIntArray1588[i];
                        widget.anInt2643 = Class67.anIntArray1588[1 + i];
                    } else if(i_3_ == 1003)
                        widget.aBoolean2750 = Class67.anIntArray1588[--i] == 1;
                    else {
                        if(i_3_ != 1004)
                            break;
                        widget.aBoolean2688 = Class67.anIntArray1588[--i] == 1;
                    }
                } else if((i_3_ ^ 0xffffffff) <= -1101 && i_3_ < 1200 || ((i_3_ ^ 0xffffffff) <= -2101 && (i_3_ ^ 0xffffffff) > -2201)) {
                    Widget widget;
                    if((i_3_ ^ 0xffffffff) > -2001)
                        widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                    else {
                        widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -65);
                        i_3_ -= 1000;
                    }
                    if(i_3_ == 1100) {
                        i -= 2;
                        widget.anInt2746 = Class67.anIntArray1588[i];
                        widget.scrollPosition = Class67.anIntArray1588[1 + i];
                    } else if(i_3_ == 1101) {
                        int i_24_ = Class67.anIntArray1588[--i];
                        int i_25_ = (0x7e0b & i_24_) >> 1185286442;
                        int i_26_ = i_24_ & 0x1f;
                        int i_27_ = i_24_ >> 2043942949 & 0x1f;
                        widget.anInt2647 = ((i_27_ << 1110799051) + (i_25_ << -2109315117) + (i_26_ << -170628573));
                    } else if(i_3_ == 1102)
                        widget.aBoolean2645 = Class67.anIntArray1588[--i] == 1;
                    else if((i_3_ ^ 0xffffffff) == -1104)
                        widget.anInt2745 = Class67.anIntArray1588[--i];
                    else if((i_3_ ^ 0xffffffff) == -1105)
                        i--;
                    else if(i_3_ == 1105)
                        widget.anInt2744 = Class67.anIntArray1588[--i];
                    else if((i_3_ ^ 0xffffffff) == -1107)
                        widget.anInt2751 = Class67.anIntArray1588[--i];
                    else if((i_3_ ^ 0xffffffff) == -1108)
                        widget.aBoolean2641 = ((Class67.anIntArray1588[--i] ^ 0xffffffff) == -2);
                    else if(i_3_ == 1108) {
                        widget.anInt2687 = 1;
                        widget.anInt2673 = Class67.anIntArray1588[--i];
                    } else if((i_3_ ^ 0xffffffff) == -1110) {
                        i -= 6;
                        widget.anInt2737 = Class67.anIntArray1588[i];
                        widget.anInt2679 = Class67.anIntArray1588[1 + i];
                        widget.anInt2690 = Class67.anIntArray1588[i + 2];
                        widget.anInt2657 = Class67.anIntArray1588[3 + i];
                        widget.anInt2725 = Class67.anIntArray1588[4 + i];
                        widget.anInt2728 = Class67.anIntArray1588[5 + i];
                    } else if((i_3_ ^ 0xffffffff) == -1111)
                        widget.anInt2659 = Class67.anIntArray1588[--i];
                    else if(i_3_ == 1111)
                        widget.aBoolean2701 = ((Class67.anIntArray1588[--i] ^ 0xffffffff) == -2);
                    else if(i_3_ == 1112)
                        widget.aClass1_2668 = Class40_Sub11.aClass1Array2153[--i_1_];
                    else if(i_3_ == 1113)
                        widget.anInt2642 = Class67.anIntArray1588[--i];
                    else if((i_3_ ^ 0xffffffff) == -1115) {
                        i -= 3;
                        widget.anInt2733 = Class67.anIntArray1588[i];
                        widget.anInt2715 = Class67.anIntArray1588[i + 1];
                        widget.anInt2732 = Class67.anIntArray1588[i + 2];
                    } else {
                        if((i_3_ ^ 0xffffffff) != -1116)
                            break;
                        widget.aBoolean2665 = Class67.anIntArray1588[--i] == 1;
                    }
                } else if((i_3_ < 1200 || (i_3_ ^ 0xffffffff) <= -1301) && ((i_3_ ^ 0xffffffff) > -2201 || i_3_ >= 2300)) {
                    if((i_3_ < 1300 || (i_3_ ^ 0xffffffff) <= -1401) && ((i_3_ ^ 0xffffffff) > -2301 || (i_3_ ^ 0xffffffff) <= -2401)) {
                        if(i_3_ < 1500) {
                            if(i_3_ == 1400) {
                                i -= 2;
                                int i_28_ = Class67.anIntArray1588[i + 1];
                                int i_29_ = Class67.anIntArray1588[i];
                                Widget widget = Class68.method1045(i_29_, (byte) -75);
                                if((widget.aWidgetArray2713) == null || ((widget.aWidgetArray2713).length <= i_28_) || (widget.aWidgetArray2713[i_28_]) == null)
                                    Class67.anIntArray1588[i++] = 0;
                                else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool)
                                        Class22_Sub2.aWidget_1887 = (widget.aWidgetArray2713[i_28_]);
                                    else
                                        Class40_Sub6.aWidget_2116 = (widget.aWidgetArray2713[i_28_]);
                                }
                            } else if((i_3_ ^ 0xffffffff) == -1402) {
                                i -= 3;
                                int i_30_ = Class67.anIntArray1588[i];
                                int i_31_ = Class67.anIntArray1588[2 + i];
                                int i_32_ = Class67.anIntArray1588[i + 1];
                                Widget widget = (Class27.method361((Class59.aWidgetArrayArray1390[i_30_]), i_31_, true, 0, -1, 0, i_32_, 398));
                                if(widget != null) {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool)
                                        Class22_Sub2.aWidget_1887 = widget;
                                    else
                                        Class40_Sub6.aWidget_2116 = widget;
                                } else
                                    Class67.anIntArray1588[i++] = 0;
                            } else {
                                if((i_3_ ^ 0xffffffff) != -1403)
                                    break;
                                i -= 3;
                                Widget widget = Class68.method1045((Class67.anIntArray1588[i]), (byte) -103);
                                int i_33_ = Class67.anIntArray1588[2 + i];
                                int i_34_ = Class67.anIntArray1588[i + 1];
                                Widget widget_35_ = (Class27.method361((widget.aWidgetArray2713), i_33_, true, widget.scrollPosition, widget.anInt2689, widget.anInt2746, i_34_, 398));
                                if(widget_35_ == null)
                                    Class67.anIntArray1588[i++] = 0;
                                else {
                                    Class67.anIntArray1588[i++] = 1;
                                    if(!bool)
                                        Class22_Sub2.aWidget_1887 = widget_35_;
                                    else
                                        Class40_Sub6.aWidget_2116 = widget_35_;
                                }
                            }
                        } else if(i_3_ < 1600) {
                            Widget widget = (bool ? Class40_Sub6.aWidget_2116 : (Class22_Sub2.aWidget_1887));
                            if(i_3_ == 1500)
                                Class67.anIntArray1588[i++] = widget.anInt2656;
                            else if((i_3_ ^ 0xffffffff) == -1502)
                                Class67.anIntArray1588[i++] = widget.anInt2696;
                            else if((i_3_ ^ 0xffffffff) == -1503)
                                Class67.anIntArray1588[i++] = widget.anInt2692;
                            else if(i_3_ == 1503)
                                Class67.anIntArray1588[i++] = widget.anInt2643;
                            else if((i_3_ ^ 0xffffffff) == -1505)
                                Class67.anIntArray1588[i++] = (!widget.aBoolean2750 ? 0 : 1);
                            else {
                                if((i_3_ ^ 0xffffffff) != -1506)
                                    break;
                                Class67.anIntArray1588[i++] = widget.anInt2648;
                            }
                        } else if((i_3_ ^ 0xffffffff) <= -1701) {
                            if((i_3_ ^ 0xffffffff) > -2501) {
                                if((i_3_ ^ 0xffffffff) == -2402) {
                                    i -= 3;
                                    int i_36_ = Class67.anIntArray1588[1 + i];
                                    int i_37_ = Class67.anIntArray1588[i];
                                    int i_38_ = Class67.anIntArray1588[i + 2];
                                    Widget widget = (Class27.method361((Class59.aWidgetArrayArray1390[i_37_]), i_38_, false, 0, -1, 0, i_36_, 398));
                                    if(widget != null)
                                        Class67.anIntArray1588[i++] = widget.anInt2689;
                                    else
                                        Class67.anIntArray1588[i++] = -1;
                                } else {
                                    if((i_3_ ^ 0xffffffff) != -2403)
                                        break;
                                    i -= 3;
                                    Widget widget = (Class68.method1045(Class67.anIntArray1588[i], (byte) -113));
                                    int i_39_ = Class67.anIntArray1588[1 + i];
                                    int i_40_ = Class67.anIntArray1588[i + 2];
                                    Widget widget_41_ = (Class27.method361((Class59.aWidgetArrayArray1390[(widget.anInt2689 >> -291405296)]), i_40_, false, widget.scrollPosition, 0xffff & (widget.anInt2689), widget.anInt2746, i_39_, 398));
                                    if(widget_41_ != null)
                                        Class67.anIntArray1588[i++] = (widget_41_.anInt2689);
                                    else
                                        Class67.anIntArray1588[i++] = -1;
                                }
                            } else if((i_3_ ^ 0xffffffff) <= -2601) {
                                if((i_3_ ^ 0xffffffff) > -2701) {
                                    Widget widget = (Class68.method1045(Class67.anIntArray1588[--i], (byte) -90));
                                    if((i_3_ ^ 0xffffffff) == -2601)
                                        Class67.anIntArray1588[i++] = widget.anInt2746;
                                    else {
                                        if(i_3_ != 2601)
                                            break;
                                        Class67.anIntArray1588[i++] = widget.scrollPosition;
                                    }
                                } else {
                                    if(i_3_ < 2800)
                                        break;
                                    if(i_3_ < 3100) {
                                        if(i_3_ == 3000) {
                                            int i_42_ = (Class67.anIntArray1588[--i]);
                                            if((CacheIndex_Sub1.anInt1819 ^ 0xffffffff) == 0) {
                                                PacketBuffer.method517(0, i_42_, -9225);
                                                CacheIndex_Sub1.anInt1819 = i_42_;
                                            }
                                        } else if(((i_3_ ^ 0xffffffff) == -3002) || ((i_3_ ^ 0xffffffff) == -3004)) {
                                            i -= 2;
                                            int i_43_ = (Class67.anIntArray1588[i]);
                                            int i_44_ = (Class67.anIntArray1588[i + 1]);
                                            Class33.method406(0, i_44_, i_43_, -128);
                                        } else if(i_3_ == 3002) {
                                            Widget widget = (!bool ? (Class22_Sub2.aWidget_1887) : (Class40_Sub6.aWidget_2116));
                                            if((CacheIndex_Sub1.anInt1819 ^ 0xffffffff) == 0) {
                                                PacketBuffer.method517((widget.anInt2689) & 0x7fff, (widget.anInt2648), -9225);
                                                CacheIndex_Sub1.anInt1819 = (widget.anInt2689);
                                            }
                                        } else {
                                            if((i_3_ ^ 0xffffffff) != -3004)
                                                break;
                                            Widget widget = (bool ? (Class40_Sub6.aWidget_2116) : (Class22_Sub2.aWidget_1887));
                                            int i_45_ = (Class67.anIntArray1588[--i]);
                                            Class33.method406((0x7fff & (widget.anInt2689)), i_45_, (widget.anInt2648), -121);
                                        }
                                    } else if(i_3_ >= 3200) {
                                        if((i_3_ ^ 0xffffffff) > -3301) {
                                            if((i_3_ ^ 0xffffffff) == -3201) {
                                                i -= 3;
                                                Class53.method950((Class67.anIntArray1588[i]), (byte) 55, (Class67.anIntArray1588[i + 1]), (Class67.anIntArray1588[2 + i]));
                                            } else if(i_3_ == 3201)
                                                Class51.method942(257, (Class67.anIntArray1588[--i]));
                                            else {
                                                if((i_3_ ^ 0xffffffff) != -3203)
                                                    break;
                                                i -= 2;
                                                Class57.method975((Class67.anIntArray1588[i + 1]), (byte) 110, (Class67.anIntArray1588[i]));
                                            }
                                        } else if(i_3_ < 3400) {
                                            if(i_3_ != 3300)
                                                break;
                                            Class67.anIntArray1588[i++] = anInt926;
                                        } else if(i_3_ < 4100) {
                                            if((i_3_ ^ 0xffffffff) == -4001) {
                                                i -= 2;
                                                int i_46_ = (Class67.anIntArray1588[i]);
                                                int i_47_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_46_ + i_47_;
                                            } else if((i_3_ ^ 0xffffffff) == -4002) {
                                                i -= 2;
                                                int i_48_ = (Class67.anIntArray1588[1 + i]);
                                                int i_49_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_49_ + -i_48_;
                                            } else if((i_3_ ^ 0xffffffff) == -4003) {
                                                i -= 2;
                                                int i_50_ = (Class67.anIntArray1588[i + 1]);
                                                int i_51_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_51_ * i_50_;
                                            } else if((i_3_ ^ 0xffffffff) == -4004) {
                                                i -= 2;
                                                int i_52_ = (Class67.anIntArray1588[i]);
                                                int i_53_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_52_ / i_53_;
                                            } else if(i_3_ == 4004) {
                                                int i_54_ = (Class67.anIntArray1588[--i]);
                                                Class67.anIntArray1588[i++] = (int) (Math.random() * (double) i_54_);
                                            } else if((i_3_ ^ 0xffffffff) == -4006) {
                                                int i_55_ = (Class67.anIntArray1588[--i]);
                                                Class67.anIntArray1588[i++] = (int) ((double) (1 + i_55_) * (Math.random()));
                                            } else if((i_3_ ^ 0xffffffff) == -4007) {
                                                i -= 5;
                                                int i_56_ = (Class67.anIntArray1588[1 + i]);
                                                int i_57_ = (Class67.anIntArray1588[i]);
                                                int i_58_ = (Class67.anIntArray1588[i + 3]);
                                                int i_59_ = (Class67.anIntArray1588[i + 4]);
                                                int i_60_ = (Class67.anIntArray1588[2 + i]);
                                                Class67.anIntArray1588[i++] = (i_57_ + ((i_59_ + -i_60_) * (-i_57_ + i_56_) / (i_58_ - i_60_)));
                                            } else if((i_3_ ^ 0xffffffff) == -4008) {
                                                i -= 2;
                                                int i_61_ = (Class67.anIntArray1588[i]);
                                                int i_62_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = i_61_ + (i_62_ * i_61_ / 100);
                                            } else if((i_3_ ^ 0xffffffff) == -4009) {
                                                i -= 2;
                                                int i_63_ = (Class67.anIntArray1588[i]);
                                                int i_64_ = (Class67.anIntArray1588[i + 1]);
                                                Class67.anIntArray1588[i++] = (Class40_Sub5_Sub9.method619(1 << i_64_, i_63_));
                                            } else if((i_3_ ^ 0xffffffff) == -4010) {
                                                i -= 2;
                                                int i_65_ = (Class67.anIntArray1588[i]);
                                                int i_66_ = (Class67.anIntArray1588[1 + i]);
                                                Class67.anIntArray1588[i++] = (Class66.method1021(i_65_, -1 + -(1 << i_66_)));
                                            } else if(i_3_ == 4010) {
                                                i -= 2;
                                                int i_67_ = (Class67.anIntArray1588[i]);
                                                int i_68_ = (Class67.anIntArray1588[1 + i]);
                                                Class67.anIntArray1588[i++] = (((Class66.method1021(1 << i_68_, i_67_)) ^ 0xffffffff) != -1 ? 1 : 0);
                                            } else if(i_3_ == 4011) {
                                                i -= 2;
                                                int i_69_ = (Class67.anIntArray1588[i + 1]);
                                                int i_70_ = (Class67.anIntArray1588[i]);
                                                Class67.anIntArray1588[i++] = i_70_ % i_69_;
                                            } else if((i_3_ ^ 0xffffffff) == -4013) {
                                                i -= 2;
                                                int i_71_ = (Class67.anIntArray1588[i]);
                                                int i_72_ = (Class67.anIntArray1588[i + 1]);
                                                if(i_71_ != 0)
                                                    Class67.anIntArray1588[i++] = (int) (Math.pow((double) i_71_, (double) i_72_));
                                                else
                                                    Class67.anIntArray1588[i++] = 0;
                                            } else {
                                                if(i_3_ != 4013)
                                                    break;
                                                i -= 2;
                                                int i_73_ = (Class67.anIntArray1588[i]);
                                                int i_74_ = (Class67.anIntArray1588[1 + i]);
                                                if(i_73_ != 0) {
                                                    if((i_74_ ^ 0xffffffff) != -1)
                                                        Class67.anIntArray1588[i++] = (int) (Math.pow((double) i_73_, (1.0 / (double) i_74_)));
                                                    else
                                                        Class67.anIntArray1588[i++] = 2147483647;
                                                } else
                                                    Class67.anIntArray1588[i++] = 0;
                                            }
                                        } else {
                                            if(i_3_ >= 4200)
                                                break;
                                            if(i_3_ == 4100) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                int i_75_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(118, (new RSString[]{class1, (HashTable.method334(i_75_, -1))})));
                                            } else if(i_3_ == 4101) {
                                                i_1_ -= 2;
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[i_1_ + 1]);
                                                RSString class1_76_ = (Class40_Sub11.aClass1Array2153[i_1_]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(53, (new RSString[]{class1_76_, class1})));
                                            } else if(i_3_ == 4102) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                int i_77_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(-115, (new RSString[]{class1, (Class66.method1024(true, (byte) -85, i_77_))})));
                                            } else if((i_3_ ^ 0xffffffff) == -4104) {
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = class1.method79();
                                            } else if((i_3_ ^ 0xffffffff) == -4105) {
                                                int i_78_ = (Class67.anIntArray1588[--i]);
                                                long l = (86400000L * ((long) i_78_ + 11745L));
                                                Class8.aCalendar279.setTime(new Date(l));
                                                int i_79_ = Class8.aCalendar279.get(5);
                                                int i_80_ = Class8.aCalendar279.get(2);
                                                int i_81_ = Class8.aCalendar279.get(1);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (Class40_Sub5_Sub17_Sub6.method832(-55, (new RSString[]{(HashTable.method334(i_79_, -1)), (Class27.aClass1_643), (Class40_Sub5_Sub17_Sub1.aClass1Array2964[i_80_]), (Class27.aClass1_643), (HashTable.method334(i_81_, -1))})));
                                            } else if((i_3_ ^ 0xffffffff) == -4106) {
                                                i_1_ -= 2;
                                                RSString class1 = (Class40_Sub11.aClass1Array2153[i_1_]);
                                                RSString class1_82_ = (Class40_Sub11.aClass1Array2153[i_1_ + 1]);
                                                if((Player.localPlayer.aClass30_3282) == null || !(Player.localPlayer.aClass30_3282.aBoolean683))
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1;
                                                else
                                                    Class40_Sub11.aClass1Array2153[i_1_++] = class1_82_;
                                            } else if(i_3_ == 4106) {
                                                int i_83_ = (Class67.anIntArray1588[--i]);
                                                Class40_Sub11.aClass1Array2153[i_1_++] = (HashTable.method334(i_83_, -1));
                                            } else {
                                                if(i_3_ != 4107)
                                                    break;
                                                i_1_ -= 2;
                                                Class67.anIntArray1588[i++] = (Class40_Sub11.aClass1Array2153[i_1_].method84((Class40_Sub11.aClass1Array2153[i_1_ + 1]), (byte) 109));
                                            }
                                        }
                                    } else if((i_3_ ^ 0xffffffff) == -3101) {
                                        RSString class1 = (Class40_Sub11.aClass1Array2153[--i_1_]);
                                        Class44.method895(84, 0, class1, (Landscape.aClass1_1183));
                                    } else {
                                        if(i_3_ != 3101)
                                            break;
                                        i -= 2;
                                        ActorDefinition.method570(Class67.anIntArray1588[i], (Class67.anIntArray1588[i + 1]), (Player.localPlayer), -1);
                                    }
                                }
                            } else {
                                Widget widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -103);
                                if((i_3_ ^ 0xffffffff) == -2501)
                                    Class67.anIntArray1588[i++] = widget.anInt2656;
                                else if((i_3_ ^ 0xffffffff) == -2502)
                                    Class67.anIntArray1588[i++] = widget.anInt2696;
                                else if((i_3_ ^ 0xffffffff) == -2503)
                                    Class67.anIntArray1588[i++] = widget.anInt2692;
                                else if(i_3_ == 2503)
                                    Class67.anIntArray1588[i++] = widget.anInt2643;
                                else if(i_3_ == 2504)
                                    Class67.anIntArray1588[i++] = (widget.aBoolean2750 ? 1 : 0);
                                else {
                                    if(i_3_ != 2505)
                                        break;
                                    Class67.anIntArray1588[i++] = widget.anInt2648;
                                }
                            }
                        } else {
                            Widget widget = (bool ? Class40_Sub6.aWidget_2116 : (Class22_Sub2.aWidget_1887));
                            if((i_3_ ^ 0xffffffff) == -1601)
                                Class67.anIntArray1588[i++] = widget.anInt2746;
                            else {
                                if(i_3_ != 1601)
                                    break;
                                Class67.anIntArray1588[i++] = widget.scrollPosition;
                            }
                        }
                    } else {
                        Widget widget;
                        if((i_3_ ^ 0xffffffff) <= -2001) {
                            widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -81);
                            i_3_ -= 1000;
                        } else
                            widget = (!bool ? Class22_Sub2.aWidget_1887 : (Class40_Sub6.aWidget_2116));
                        if((i_3_ ^ 0xffffffff) <= -1301 && i_3_ <= 1309 || i_3_ >= 1314 && i_3_ <= 1317) {
                            RSString class1 = Class40_Sub11.aClass1Array2153[--i_1_];
                            Object[] objects = new Object[class1.length() + 1];
                            for(int i_84_ = objects.length - 1; (i_84_ ^ 0xffffffff) <= -2; i_84_--) {
                                if(class1.method55(-1 + i_84_, arg5) != 115)
                                    objects[i_84_] = new Integer(Class67.anIntArray1588[--i]);
                                else
                                    objects[i_84_] = (Class40_Sub11.aClass1Array2153[--i_1_]);
                            }
                            objects[0] = new Integer(Class67.anIntArray1588[--i]);
                            if(i_3_ == 1303)
                                widget.anObjectArray2707 = objects;
                            if(i_3_ == 1317)
                                widget.anObjectArray2680 = objects;
                            if((i_3_ ^ 0xffffffff) == -1305)
                                widget.anObjectArray2658 = objects;
                            if((i_3_ ^ 0xffffffff) == -1303)
                                widget.anObjectArray2644 = objects;
                            if((i_3_ ^ 0xffffffff) == -1317)
                                widget.anObjectArray2747 = objects;
                            if(i_3_ == 1301)
                                widget.anObjectArray2681 = objects;
                            if(i_3_ == 1300)
                                widget.anObjectArray2677 = objects;
                            if((i_3_ ^ 0xffffffff) == -1316)
                                widget.anObjectArray2695 = objects;
                            if((i_3_ ^ 0xffffffff) == -1307)
                                widget.anObjectArray2669 = objects;
                            if((i_3_ ^ 0xffffffff) == -1306)
                                widget.anObjectArray2672 = objects;
                            if(i_3_ == 1309)
                                widget.anObjectArray2712 = objects;
                            if(i_3_ == 1308)
                                widget.anObjectArray2650 = objects;
                        } else if((i_3_ ^ 0xffffffff) == -1311) {
                            int i_85_ = -1 + Class67.anIntArray1588[--i];
                            if((i_85_ ^ 0xffffffff) > -1 || (i_85_ ^ 0xffffffff) < -10)
                                i_1_--;
                            else {
                                if((widget.aClass1Array2661 == null) || (((widget.aClass1Array2661).length <= i_85_))) {
                                    RSString[] class1s = new RSString[1 + i_85_];
                                    if(widget.aClass1Array2661 != null) {
                                        for(int i_86_ = 0; (((widget.aClass1Array2661).length > i_86_)); i_86_++)
                                            class1s[i_86_] = (widget.aClass1Array2661[i_86_]);
                                    }
                                    widget.aClass1Array2661 = class1s;
                                }
                                widget.aClass1Array2661[i_85_] = (Class40_Sub11.aClass1Array2153[--i_1_]);
                            }
                        } else if((i_3_ ^ 0xffffffff) == -1312)
                            widget.anInt2738 = Class67.anIntArray1588[--i];
                        else if(i_3_ == 1312)
                            widget.aBoolean2694 = (Class67.anIntArray1588[--i] ^ 0xffffffff) == -2;
                        else {
                            if((i_3_ ^ 0xffffffff) != -1314)
                                break;
                            i--;
                        }
                    }
                } else {
                    Widget widget;
                    if((i_3_ ^ 0xffffffff) > -2001)
                        widget = (!bool ? Class22_Sub2.aWidget_1887 : Class40_Sub6.aWidget_2116);
                    else {
                        widget = Class68.method1045((Class67.anIntArray1588[--i]), (byte) -65);
                        i_3_ -= 1000;
                    }
                    if(i_3_ == 1200) {
                        i -= 3;
                        int i_87_ = Class67.anIntArray1588[i];
                        int i_88_ = Class67.anIntArray1588[i + 2];
                        if((i_87_ ^ 0xffffffff) != 0) {
                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_87_, 10);
                            widget.anInt2687 = 4;
                            widget.anInt2690 = class40_sub5_sub16.modelRotation1;
                            widget.anInt2725 = class40_sub5_sub16.anInt2827;
                            widget.anInt2728 = (100 * class40_sub5_sub16.modelZoom / i_88_);
                            widget.anInt2657 = class40_sub5_sub16.modelRotation2;
                            widget.anInt2679 = class40_sub5_sub16.modelOffset2;
                            widget.anInt2737 = class40_sub5_sub16.modelOffset1;
                            widget.anInt2673 = i_87_;
                        } else
                            widget.anInt2687 = 0;
                    } else if((i_3_ ^ 0xffffffff) == -1202) {
                        widget.anInt2687 = 2;
                        widget.anInt2673 = Class67.anIntArray1588[--i];
                    } else if(i_3_ == 1202) {
                        widget.anInt2687 = 3;
                        widget.anInt2673 = Player.localPlayer.aClass30_3282.method374(-20874);
                    } else {
                        if(i_3_ != 1203)
                            break;
                        Widget widget_89_ = (!bool ? Class40_Sub6.aWidget_2116 : Class22_Sub2.aWidget_1887);
                        widget.anInt2738 = widget_89_.anInt2689;
                    }
                }
            }
        } catch(Exception exception) {
            /* empty */
        }

    }

    public void method636(int arg0, boolean arg1, int arg2) {
        int i = items[arg2];
        items[arg2] = items[arg0];
        items[arg0] = i;
        i = itemAmounts[arg2];
        itemAmounts[arg2] = itemAmounts[arg0];
        if(arg1 != false)
            anIntArrayArray2748 = null;
        itemAmounts[arg0] = i;
    }

    public void method637(Buffer arg0) {
        aBoolean2636 = false;
        type = arg0.getUnsignedByte();
        anInt2714 = arg0.getUnsignedByte();
        anInt2639 = arg0.getUnsignedShortBE();
        anInt2649 = anInt2656 = arg0.getShortBE();
        anInt2743 = anInt2696 = arg0.getShortBE();
        anInt2692 = arg0.getUnsignedShortBE();
        anInt2643 = arg0.getUnsignedShortBE();
        anInt2745 = arg0.getUnsignedByte();
        anInt2648 = arg0.getUnsignedShortBE();
        if((anInt2648 ^ 0xffffffff) == -65536)
            anInt2648 = -1;
        anInt2721 = arg0.getUnsignedShortBE();
        if(anInt2721 == 65535)
            anInt2721 = -1;
        int i = arg0.getUnsignedByte();
        if((i ^ 0xffffffff) < -1) {
            anIntArray2742 = new int[i];
            anIntArray2693 = new int[i];
            for(int i_0_ = 0; i > i_0_; i_0_++) {
                anIntArray2742[i_0_] = arg0.getUnsignedByte();
                anIntArray2693[i_0_] = arg0.getUnsignedShortBE();
            }
        }
        int i_1_ = arg0.getUnsignedByte();
        if((i_1_ ^ 0xffffffff) < -1) {
            anIntArrayArray2748 = new int[i_1_][];
            for(int i_2_ = 0; (i_2_ < i_1_); i_2_++) {
                int i_3_ = arg0.getUnsignedShortBE();
                anIntArrayArray2748[i_2_] = new int[i_3_];
                for(int i_4_ = 0; (i_3_ > i_4_); i_4_++) {
                    anIntArrayArray2748[i_2_][i_4_] = arg0.getUnsignedShortBE();
                    if((anIntArrayArray2748[i_2_][i_4_] ^ 0xffffffff) == -65536)
                        anIntArrayArray2748[i_2_][i_4_] = -1;
                }
            }
        }
        if((type ^ 0xffffffff) == -1) {
            anInt2720 = arg0.getUnsignedShortBE();
            aBoolean2750 = arg0.getUnsignedByte() == 1;
        }
        if((type ^ 0xffffffff) == -2) {
            arg0.getUnsignedShortBE();
            arg0.getUnsignedByte();
        }
        if(type == 2) {
            items = new int[anInt2643 * anInt2692];
            itemAmounts = new int[anInt2643 * anInt2692];
            itemSwapable = (arg0.getUnsignedByte() ^ 0xffffffff) == -2;
            isInventory = arg0.getUnsignedByte() == 1;
            itemUsable = arg0.getUnsignedByte() == 1;
            itemDeletesDraged = (arg0.getUnsignedByte() ^ 0xffffffff) == -2;
            itemSpritePadsX = arg0.getUnsignedByte();
            itemSpritePadsY = arg0.getUnsignedByte();
            imageX = new int[20];
            imageY = new int[20];
            images = new int[20];
            for(int sprite = 0; sprite < 20; sprite++) {
                int hasSprite = arg0.getUnsignedByte();
                if((hasSprite ^ 0xffffffff) == -2) {
                    images[sprite] = arg0.getShortBE();
                    imageX[sprite] = arg0.getShortBE();
                    imageY[sprite] = arg0.getIntBE();
                } else
                    imageY[sprite] = -1;
            }
            aClass1Array2698 = new RSString[5];
            for(int i_7_ = 0; i_7_ < 5; i_7_++) {
                aClass1Array2698[i_7_] = arg0.getRSString();
                if(aClass1Array2698[i_7_].length() == 0)
                    aClass1Array2698[i_7_] = null;
            }
        }
        if((type ^ 0xffffffff) == -4)
            aBoolean2645 = arg0.getUnsignedByte() == 1;
        if(type == 4 || type == 1) {
            anInt2733 = arg0.getUnsignedByte();
            anInt2715 = arg0.getUnsignedByte();
            anInt2732 = arg0.getUnsignedByte();
            anInt2642 = arg0.getUnsignedShortBE();
            aBoolean2665 = (arg0.getUnsignedByte() ^ 0xffffffff) == -2;
        }
        if((type ^ 0xffffffff) == -5) {
            aClass1_2668 = arg0.getRSString();
            aClass1_2640 = arg0.getRSString();
        }
        if(type == 1 || (type ^ 0xffffffff) == -4 || (type ^ 0xffffffff) == -5)
            anInt2647 = arg0.getIntBE();
        if((type ^ 0xffffffff) == -4 || (type ^ 0xffffffff) == -5) {
            anInt2726 = arg0.getIntBE();
            anInt2719 = arg0.getIntBE();
            anInt2663 = arg0.getIntBE();
        }
        if((type ^ 0xffffffff) == -6) {
            anInt2744 = arg0.getIntBE();
            anInt2670 = arg0.getIntBE();
        }
        if((type ^ 0xffffffff) == -7) {
            anInt2687 = 1;
            anInt2673 = arg0.getUnsignedShortBE();
            if(anInt2673 == 65535)
                anInt2673 = -1;
            anInt2651 = 1;
            anInt2711 = arg0.getUnsignedShortBE();
            if((anInt2711 ^ 0xffffffff) == -65536)
                anInt2711 = -1;
            anInt2659 = arg0.getUnsignedShortBE();
            if((anInt2659 ^ 0xffffffff) == -65536)
                anInt2659 = -1;
            anInt2653 = arg0.getUnsignedShortBE();
            if((anInt2653 ^ 0xffffffff) == -65536)
                anInt2653 = -1;
            anInt2728 = arg0.getUnsignedShortBE();
            anInt2690 = arg0.getUnsignedShortBE();
            anInt2657 = arg0.getUnsignedShortBE();
        }
        if(type == 7) {
            items = new int[anInt2692 * anInt2643];
            itemAmounts = new int[anInt2692 * anInt2643];
            anInt2733 = arg0.getUnsignedByte();
            anInt2642 = arg0.getUnsignedShortBE();
            aBoolean2665 = arg0.getUnsignedByte() == 1;
            anInt2647 = arg0.getIntBE();
            itemSpritePadsX = arg0.getShortBE();
            itemSpritePadsY = arg0.getShortBE();
            isInventory = (arg0.getUnsignedByte() ^ 0xffffffff) == -2;
            aClass1Array2698 = new RSString[5];
            for(int i_8_ = 0; i_8_ < 5; i_8_++) {
                aClass1Array2698[i_8_] = arg0.getRSString();
                if((aClass1Array2698[i_8_].length() ^ 0xffffffff) == -1)
                    aClass1Array2698[i_8_] = null;
            }
        }
        if((type ^ 0xffffffff) == -9)
            aClass1_2668 = arg0.getRSString();
        if((anInt2714 ^ 0xffffffff) == -3 || type == 2) {
            aClass1_2664 = arg0.getRSString();
            aClass1_2709 = arg0.getRSString();
            anInt2702 = arg0.getUnsignedShortBE();
        }
        if((anInt2714 ^ 0xffffffff) == -2 || (anInt2714 ^ 0xffffffff) == -5 || (anInt2714 ^ 0xffffffff) == -6 || (anInt2714 ^ 0xffffffff) == -7) {
            aClass1_2676 = arg0.getRSString();
            if((aClass1_2676.length() ^ 0xffffffff) == -1) {
                if((anInt2714 ^ 0xffffffff) == -2)
                    aClass1_2676 = Class39.aClass1_919;
                if((anInt2714 ^ 0xffffffff) == -5)
                    aClass1_2676 = RSRuntimeException.aClass1_1649;
                if((anInt2714 ^ 0xffffffff) == -6)
                    aClass1_2676 = RSRuntimeException.aClass1_1649;
                if(anInt2714 == 6)
                    aClass1_2676 = CollisionMap.aClass1_167;
            }
        }
    }

    public ImageRGB method638(byte arg0, int arg1) {
        Class40_Sub13.aBoolean2177 = false;
        if((arg1 ^ 0xffffffff) > -1 || imageY.length <= arg1)
            return null;
        int i = imageY[arg1];
        if((i ^ 0xffffffff) == 0)
            return null;
        int i_9_ = 124 % ((-15 - arg0) / 34);
        ImageRGB class40_sub5_sub14_sub4 = ((ImageRGB) Cache.aClass9_326.method231((long) i, (byte) 121));
        if(class40_sub5_sub14_sub4 != null)
            return class40_sub5_sub14_sub4;
        class40_sub5_sub14_sub4 = Class48.method927(0, Class40_Sub5_Sub15.aCacheIndex_2779, true, i);
        if(class40_sub5_sub14_sub4 != null)
            Cache.aClass9_326.method230(-7208, (long) i, class40_sub5_sub14_sub4);
        else
            Class40_Sub13.aBoolean2177 = true;
        return class40_sub5_sub14_sub4;
    }

    public ImageRGB method643(int arg0, boolean arg1) {
        Class40_Sub13.aBoolean2177 = false;
        int i;
        if(arg1)
            i = anInt2670;
        else
            i = anInt2744;
        if((i ^ 0xffffffff) == 0)
            return null;
        ImageRGB class40_sub5_sub14_sub4 = ((ImageRGB) Cache.aClass9_326.method231((long) i, (byte) 103));
        if(arg0 != 127)
            aBoolean2636 = false;
        if(class40_sub5_sub14_sub4 != null)
            return class40_sub5_sub14_sub4;
        class40_sub5_sub14_sub4 = Class48.method927(0, Class40_Sub5_Sub15.aCacheIndex_2779, true, i);
        if(class40_sub5_sub14_sub4 == null)
            Class40_Sub13.aBoolean2177 = true;
        else
            Cache.aClass9_326.method230(-7208, (long) i, class40_sub5_sub14_sub4);
        return class40_sub5_sub14_sub4;
    }

    public void method644(byte arg0, Buffer arg1) {
        arg1.getUnsignedByte();
        aBoolean2636 = true;
        type = arg1.getUnsignedByte();
        anInt2639 = arg1.getUnsignedShortBE();
        if(arg0 < 58)
            method642(null, -90);
        anInt2649 = anInt2656 = arg1.getShortBE();
        anInt2743 = anInt2696 = arg1.getShortBE();
        anInt2692 = arg1.getUnsignedShortBE();
        if(type == 9)
            anInt2643 = arg1.getShortBE();
        else
            anInt2643 = arg1.getUnsignedShortBE();
        anInt2648 = arg1.getUnsignedShortBE();
        if(anInt2648 == 65535)
            anInt2648 = -1;
        aBoolean2750 = (arg1.getUnsignedByte() ^ 0xffffffff) == -2;
        aBoolean2688 = (arg1.getUnsignedByte() ^ 0xffffffff) == -2;
        if(type == 0) {
            anInt2746 = arg1.getUnsignedShortBE();
            scrollPosition = arg1.getUnsignedShortBE();
        }
        if((type ^ 0xffffffff) == -6) {
            anInt2744 = arg1.getIntBE();
            anInt2751 = arg1.getUnsignedShortBE();
            aBoolean2641 = (arg1.getUnsignedByte() ^ 0xffffffff) == -2;
            anInt2745 = arg1.getUnsignedByte();
        }
        if(type == 6) {
            anInt2687 = 1;
            anInt2673 = arg1.getUnsignedShortBE();
            if((anInt2673 ^ 0xffffffff) == -65536)
                anInt2673 = -1;
            anInt2737 = arg1.getShortBE();
            anInt2679 = arg1.getShortBE();
            anInt2690 = arg1.getUnsignedShortBE();
            anInt2657 = arg1.getUnsignedShortBE();
            anInt2725 = arg1.getUnsignedShortBE();
            anInt2728 = arg1.getUnsignedShortBE();
            anInt2659 = arg1.getUnsignedShortBE();
            if((anInt2659 ^ 0xffffffff) == -65536)
                anInt2659 = -1;
            aBoolean2701 = arg1.getUnsignedByte() == 1;
        }
        if(type == 4) {
            anInt2642 = arg1.getUnsignedShortBE();
            aClass1_2668 = arg1.getRSString();
            anInt2732 = arg1.getUnsignedByte();
            anInt2733 = arg1.getUnsignedByte();
            anInt2715 = arg1.getUnsignedByte();
            aBoolean2665 = arg1.getUnsignedByte() == 1;
            anInt2647 = arg1.getIntBE();
        }
        if((type ^ 0xffffffff) == -4) {
            anInt2647 = arg1.getIntBE();
            aBoolean2645 = (arg1.getUnsignedByte() ^ 0xffffffff) == -2;
            anInt2745 = arg1.getUnsignedByte();
        }
        if(type == 9) {
            arg1.getUnsignedByte();
            anInt2647 = arg1.getIntBE();
        }
        if(aBoolean2688) {
            anObjectArray2677 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2681 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2644 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2707 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2658 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2672 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2669 = FloorDecoration.method345((byte) 89, arg1);
            FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2650 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2712 = FloorDecoration.method345((byte) 89, arg1);
            FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2695 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2747 = FloorDecoration.method345((byte) 89, arg1);
            anObjectArray2680 = FloorDecoration.method345((byte) 89, arg1);
            isInventory = arg1.getUnsignedByte() == 1;
            anInt2736 = arg1.getUnsignedShortBE();
            aBoolean2694 = arg1.getUnsignedByte() == 1;
            arg1.getUnsignedByte();
            int i = arg1.getUnsignedByte();
            if(i > 0) {
                aClass1Array2661 = new RSString[i];
                for(int i_10_ = 0; (i_10_ < i); i_10_++)
                    aClass1Array2661[i_10_] = arg1.getRSString();
            }
            anInt2738 = arg1.getUnsignedShortBE();
            if((anInt2738 ^ 0xffffffff) == -65536)
                anInt2738 = -1;
        }
    }

    public Model method646(byte arg0, Class40_Sub5_Sub7 arg1, int arg2, boolean arg3, Class30 arg4) {
        Class40_Sub13.aBoolean2177 = false;
        int i;
        int i_11_;
        if(arg3) {
            i_11_ = anInt2711;
            i = anInt2651;
        } else {
            i = anInt2687;
            i_11_ = anInt2673;
        }
        if((i ^ 0xffffffff) == -1)
            return null;
        if((i ^ 0xffffffff) == -2 && (i_11_ ^ 0xffffffff) == 0)
            return null;
        if(arg0 <= 25)
            aBoolean2688 = true;
        Model class40_sub5_sub17_sub5 = ((Model) Class53.aClass9_1264.method231((long) ((i << -983578160) + i_11_), (byte) 59));
        if(class40_sub5_sub17_sub5 == null) {
            if((i ^ 0xffffffff) == -2) {
                class40_sub5_sub17_sub5 = Model.getModel(Cache.aCacheIndex_329, i_11_, 0);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -3) {
                class40_sub5_sub17_sub5 = ActorDefinition.getDefinition((byte) -101, i_11_).getHeadModel((byte) 122);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -4) {
                if(arg4 == null)
                    return null;
                class40_sub5_sub17_sub5 = arg4.method379(30);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64, 768, -50, -10, -50, true);
            }
            if((i ^ 0xffffffff) == -5) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_11_, 10);
                class40_sub5_sub17_sub5 = class40_sub5_sub16.method753(false, 10, 26910);
                if(class40_sub5_sub17_sub5 == null) {
                    Class40_Sub13.aBoolean2177 = true;
                    return null;
                }
                class40_sub5_sub17_sub5.method810();
                class40_sub5_sub17_sub5.method802(64 + (class40_sub5_sub16.ambience), 768 + (class40_sub5_sub16.diffusion), -50, -10, -50, true);
            }
            Class53.aClass9_1264.method230(-7208, (long) ((i << -557905040) + i_11_), class40_sub5_sub17_sub5);
        }
        if(arg1 != null)
            class40_sub5_sub17_sub5 = arg1.method598(arg2, class40_sub5_sub17_sub5, true);
        return class40_sub5_sub17_sub5;
    }

    public TypeFace method647(byte arg0) {
        Class40_Sub13.aBoolean2177 = false;
        if((anInt2642 ^ 0xffffffff) == -65536)
            return null;
        TypeFace class40_sub5_sub14_sub1 = ((TypeFace) Class67.aClass9_1582.method231((long) anInt2642, (byte) 67));
        if(arg0 != 34)
            return null;
        if(class40_sub5_sub14_sub1 != null)
            return class40_sub5_sub14_sub1;
        class40_sub5_sub14_sub1 = Class40_Sub5_Sub17_Sub1.method760(0, (byte) 36, (Class40_Sub5_Sub15.aCacheIndex_2779), anInt2642);
        if(class40_sub5_sub14_sub1 == null)
            Class40_Sub13.aBoolean2177 = true;
        else
            Class67.aClass9_1582.method230(-7208, (long) anInt2642, class40_sub5_sub14_sub1);
        return class40_sub5_sub14_sub1;
    }
}
