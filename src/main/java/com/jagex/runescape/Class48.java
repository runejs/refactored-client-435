package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetType;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import tech.henning.fourthreefive.Configuration;

import java.text.MessageFormat;

public class Class48 {
    public static int cameraOffsetY = 0;
    public static int modifiedWidgetId = 0;
    public static Buffer aClass40_Sub1_1132;

    public int[][] anIntArrayArray1128;
    public int anInt1131;
    public int anInt1133;

    public Class48(int arg0, int arg1) {

        int i = Class55.method963(arg1, (byte) -62, arg0);
        arg0 /= i;
        anInt1131 = arg0;
        arg1 /= i;
        anInt1133 = arg1;
        if(arg1 != arg0) {
            anIntArrayArray1128 = new int[arg0][14];
            for(int i_25_ = 0; i_25_ < arg0; i_25_++) {
                int[] is = anIntArrayArray1128[i_25_];
                double d = (double) i_25_ / (double) arg0 + 6.0;
                double d_26_ = (double) arg1 / (double) arg0;
                int i_27_ = (int) Math.floor(-7.0 + d + 1.0);
                int i_28_ = (int) Math.ceil(7.0 + d);
                if(i_27_ < 0)
                    i_27_ = 0;
                if(i_28_ > 14)
                    i_28_ = 14;
                for(/**/; i_28_ > i_27_; i_27_++) {
                    double d_29_ = d_26_;
                    double d_30_ = 3.141592653589793 * (-d + (double) i_27_);
                    if(d_30_ < -1.0E-4 || d_30_ > 1.0E-4)
                        d_29_ *= Math.sin(d_30_) / d_30_;
                    d_29_ *= 0.54 + 0.46 * Math.cos(0.2243994752564138 * (-d + (double) i_27_));
                    is[i_27_] = (int) Math.floor(0.5 + d_29_ * 65536.0);
                }
            }
        }

    }

    public static void method922(int arg0, int arg1, Buffer arg2, int arg4, int arg5, int arg6, int arg7) {
        if(arg0 >= 0 && arg0 < 104 && arg4 >= 0 && arg4 < 104) {
            OverlayDefinition.tile_flags[arg7][arg0][arg4] = (byte) 0;
            for(; ; ) {
                int i = arg2.getUnsignedByte();
                if(i == 0) {
                    if(arg7 == 0)
                        Class40_Sub6.tile_height[0][arg0][arg4] = -Class42.method888(arg6 + arg0 + 932731, (byte) -45, arg5 + 556238 + arg4) * 8;
                    else
                        Class40_Sub6.tile_height[arg7][arg0][arg4] = -240 + Class40_Sub6.tile_height[arg7 + -1][arg0][arg4];
                    break;
                }
                if(i == 1) {
                    int i_0_ = arg2.getUnsignedByte();
                    if(i_0_ == 1)
                        i_0_ = 0;
                    if(arg7 != 0)
                        Class40_Sub6.tile_height[arg7][arg0][arg4] = Class40_Sub6.tile_height[-1 + arg7][arg0][arg4] + -(8 * i_0_);
                    else
                        Class40_Sub6.tile_height[0][arg0][arg4] = 8 * -i_0_;
                    break;
                }
                if(i <= 49) {
                    MouseHandler.tile_overlayids[arg7][arg0][arg4] = arg2.getByte();
                    OverlayDefinition.tile_underlay_path[arg7][arg0][arg4] = (byte) ((i + -2) / 4);
                    Class35.tile_overlay_rotation[arg7][arg0][arg4] = (byte) HuffmanEncoding.method1021(arg1 + -2 + i, 3);
                } else if(i <= 81)
                    OverlayDefinition.tile_flags[arg7][arg0][arg4] = (byte) (-49 + i);
                else
                    Class42.tile_underlayids[arg7][arg0][arg4] = (byte) (-81 + i);
            }
        } else {
            for(; ; ) {
                int i = arg2.getUnsignedByte();
                if(i == 0)
                    break;
                if(i == 1) {
                    arg2.getUnsignedByte();
                    break;
                }
                if(i <= 49)
                    arg2.getUnsignedByte();
            }
        }
    }

    public static void method925(int arg0, Widget[] arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11) {
        if(arg2 <= arg8 && arg4 >= arg9 && arg11 > arg8 && arg0 > arg4) {
            for(int i = arg5; arg1.length > i; i++) {
                Widget widget = arg1[i];
                if(widget != null && arg6 == widget.parentId) {
                    int i_1_ = widget.currentY - (-arg9 + arg3);
                    int i_2_ = -arg10 + widget.currentX + arg2;
                    if(widget.type == WidgetType.IF1_TOOLTIP && i_2_ <= arg8 && i_1_ <= arg4 && arg8 < i_2_ + widget.originalWidth && arg4 < widget.originalHeight + i_1_)
                        Item.anInt3065 = i;
                    if((widget.hoveredSiblingId >= 0 || widget.hoveredTextColor != 0) && i_2_ <= arg8 && i_1_ <= arg4 && arg8 < i_2_ + widget.originalWidth && arg4 < widget.originalHeight + i_1_) {
                        if(widget.hoveredSiblingId >= 0)
                            OverlayDefinition.anInt2328 = widget.hoveredSiblingId;
                        else
                            OverlayDefinition.anInt2328 = i;
                    }
                    if(widget.type == WidgetType.LAYER) {
                        if(!widget.isHidden || Class29.method371(8247, arg7, i) || PacketBuffer.hiddenButtonTest) {
                            method925(i_1_ + widget.originalHeight, arg1, i_2_, widget.scrollPosition, arg4, arg5, i, arg7, arg8, i_1_, widget.anInt2746, i_2_ + widget.originalWidth);
                            if(widget.aWidgetArray2713 != null)
                                method925(i_1_ + widget.originalHeight, widget.aWidgetArray2713, i_2_, widget.scrollPosition, arg4, 0, widget.id, arg7, arg8, i_1_, widget.anInt2746, widget.originalWidth + i_2_);
                            if(widget.originalHeight < widget.scrollHeight)
                                Class5.scrollInterface(widget.originalHeight, arg4, arg8, widget.scrollHeight, widget, widget.originalWidth + i_2_, arg7, i_1_);
                        }
                    } else {
                        if(widget.actionType == 1 && i_2_ <= arg8 && i_1_ <= arg4 && widget.originalWidth + i_2_ > arg8 && widget.originalHeight + i_1_ > arg4) {
                            boolean bool = false;
                            if(widget.contentType != 0)
                                bool = ProducingGraphicsBuffer_Sub1.method1051(300, widget);
                            if(!bool) {
                                OverlayDefinition.addActionRow(widget.tooltip, 0, 0, widget.id, 42, "");
                            }
                        }
                        if(widget.actionType == 2 && Main.widgetSelected == 0 && arg8 >= i_2_ && arg4 >= i_1_ && arg8 < widget.originalWidth + i_2_ && arg4 < i_1_ + widget.originalHeight) {
                            OverlayDefinition.addActionRow(widget.targetVerb, 0, 0, widget.id, 33, Native.aClass1_1162+widget.spellName);
                        }
                        if(widget.actionType == 3 && arg8 >= i_2_ && arg4 >= i_1_ && i_2_ + widget.originalWidth > arg8 && arg4 < i_1_ + widget.originalHeight) {
                            int i_3_;
                            if(arg7 != 3)
                                i_3_ = 9;
                            else
                                i_3_ = 40;
                            OverlayDefinition.addActionRow(English.close, 0, 0, widget.id, i_3_, "");
                        }
                        if(widget.actionType == 4 && arg8 >= i_2_ && i_1_ <= arg4 && arg8 < widget.originalWidth + i_2_ && widget.originalHeight + i_1_ > arg4) {
                            OverlayDefinition.addActionRow(widget.tooltip, 0, 0, widget.id, 23, "");
                        }
                        if(widget.actionType == 5 && i_2_ <= arg8 && i_1_ <= arg4 && arg8 < i_2_ + widget.originalWidth && i_1_ + widget.originalHeight > arg4) {
                            OverlayDefinition.addActionRow(widget.tooltip, 0, 0, widget.id, 57, "");
                        }
                        if(widget.actionType == 6 && CacheIndex_Sub1.anInt1819 == -1 && i_2_ <= arg8 && i_1_ <= arg4 && arg8 < i_2_ + widget.originalWidth && arg4 < widget.originalHeight + i_1_) {
                            OverlayDefinition.addActionRow(widget.tooltip, 0, 0, widget.id, 54, "");
                        }
                        if(widget.type == WidgetType.INVENTORY) {
                            int i_4_ = 0;
                            for(int i_5_ = 0; i_5_ < widget.originalHeight; i_5_++) {
                                for(int i_6_ = 0; i_6_ < widget.originalWidth; i_6_++) {
                                    int i_7_ = i_6_ * (widget.itemSpritePadsX + 32) + i_2_;
                                    int i_8_ = i_1_ + (32 + widget.itemSpritePadsY) * i_5_;
                                    if(i_4_ < 20) {
                                        i_7_ += widget.images[i_4_];
                                        i_8_ += widget.imageX[i_4_];
                                    }
                                    if(arg8 >= i_7_ && i_8_ <= arg4 && i_7_ + 32 > arg8 && arg4 < 32 + i_8_) {
                                        RSRuntimeException.lastActiveInvInterface = widget.id;
                                        Class55.mouseInvInterfaceIndex = i_4_;
                                        if(widget.items[i_4_] > 0) {
                                            ItemDefinition itemDefinition = ItemDefinition.forId(-1 + widget.items[i_4_], 10);
                                            if(Class8.itemSelected != 1 || !widget.isInventory) {
                                                if(Main.widgetSelected == 1 && widget.isInventory) {
                                                    if((ItemDefinition.selectedMask & 0x10) == 16) {
                                                        OverlayDefinition.addActionRow(Native.aClass1_1918, itemDefinition.id, i_4_, widget.id, 37, Native.aClass1_611 + Native.aClass1_206 + itemDefinition.name);
                                                    }
                                                } else {
                                                    String[] class1s = itemDefinition.interfaceOptions;
                                                    if(Class60.aBoolean1402)
                                                        class1s = Class56.method968(class1s);
                                                    if(widget.isInventory) {
                                                        for(int i_9_ = 4; i_9_ >= 3; i_9_--) {
                                                            if(class1s != null && class1s[i_9_] != null) {
                                                                int i_10_;
                                                                if(i_9_ != 3)
                                                                    i_10_ = 11;
                                                                else
                                                                    i_10_ = 43;
                                                                OverlayDefinition.addActionRow(class1s[i_9_], itemDefinition.id, i_4_, widget.id, i_10_, Native.aClass1_1114 + itemDefinition.name);
                                                            } else if(i_9_ == 4) {
                                                                OverlayDefinition.addActionRow(English.drop, itemDefinition.id, i_4_, widget.id, 11, Native.aClass1_1114 + itemDefinition.name);
                                                            }
                                                        }
                                                    }
                                                    if(widget.itemUsable) {
                                                        OverlayDefinition.addActionRow(English.use, itemDefinition.id, i_4_, widget.id, 19, Native.aClass1_1114 + itemDefinition.name);
                                                    }
                                                    if(widget.isInventory && class1s != null) {
                                                        for(int i_11_ = 2; i_11_ >= 0; i_11_--) {
                                                            if(class1s[i_11_] != null) {
                                                                int i_12_ = 0;
                                                                if(i_11_ == 0)
                                                                    i_12_ = 52;
                                                                if(i_11_ == 1)
                                                                    i_12_ = 6;
                                                                if(i_11_ == 2)
                                                                    i_12_ = 31;
                                                                OverlayDefinition.addActionRow(class1s[i_11_], itemDefinition.id, i_4_, widget.id, i_12_, Native.aClass1_1114 + itemDefinition.name);
                                                            }
                                                        }
                                                    }
                                                    class1s = widget.configActions;
                                                    if(Class60.aBoolean1402)
                                                        class1s = Class56.method968(class1s);
                                                    if(class1s != null) {
                                                        for(int i_13_ = 4; i_13_ >= 0; i_13_--) {
                                                            if(class1s[i_13_] != null) {
                                                                int i_14_ = 0;
                                                                if(i_13_ == 0)
                                                                    i_14_ = 53;
                                                                if(i_13_ == 1)
                                                                    i_14_ = 25;
                                                                if(i_13_ == 2)
                                                                    i_14_ = 55;
                                                                if(i_13_ == 3)
                                                                    i_14_ = 48;
                                                                if(i_13_ == 4)
                                                                    i_14_ = 24;
                                                                OverlayDefinition.addActionRow(class1s[i_13_], itemDefinition.id, i_4_, widget.id, i_14_, Native.aClass1_1114 + itemDefinition.name);
                                                            }
                                                        }
                                                    }
                                                    StringBuilder examineText = new StringBuilder();
                                                    examineText.append(MessageFormat.format("<col=ff9040>{0}</col>", itemDefinition.name));
                                                    if (Configuration.DEBUG_CONTEXT) {
                                                        examineText.append(" <col=00ff00>(</col>");
                                                        examineText.append(
                                                                MessageFormat.format("<col=ffffff>{0}</col>",
                                                                        Integer.toString(itemDefinition.id)
                                                                )
                                                        );
                                                        examineText.append("<col=00ff00>)</col>");
                                                    }
                                                    OverlayDefinition.addActionRow(English.examine, itemDefinition.id, i_4_, widget.id, 1006, examineText.toString());
                                                }
                                            } else if(ISAAC.anInt525 != widget.id || i_4_ != LinkedList.anInt1061) {
                                                OverlayDefinition.addActionRow(English.use, itemDefinition.id, i_4_, widget.id, 56, Native.aClass1_3295+ Native.aClass1_206+ itemDefinition.name);
                                            }
                                        }
                                    }
                                    i_4_++;
                                }
                            }
                        }
                        if(widget.isIf3 && widget.itemId != -1 && arg8 >= i_2_ && arg4 >= i_1_ && arg8 < widget.originalWidth + i_2_ && arg4 < i_1_ + widget.originalHeight) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(widget.itemId, 10);
                            if(widget.isInventory) {
                                String[] class1s = itemDefinition.interfaceOptions;
                                if(Class60.aBoolean1402)
                                    class1s = Class56.method968(class1s);
                                if(class1s == null || class1s[4] == null)
                                    OverlayDefinition.addActionRow(English.drop, itemDefinition.id, -1 + widget.anInt2736, widget.id, 11, Native.aClass1_1114+itemDefinition.name);
                                else
                                    OverlayDefinition.addActionRow(class1s[4], itemDefinition.id, widget.anInt2736 + -1, widget.id, 11, Native.aClass1_1114+ itemDefinition.name);
                                if(class1s != null && class1s[3] != null)
                                    OverlayDefinition.addActionRow(class1s[3], itemDefinition.id, -1 + widget.anInt2736, widget.id, 43, Native.aClass1_1114+ itemDefinition.name);
                                if(class1s != null && class1s[2] != null)
                                    OverlayDefinition.addActionRow(class1s[2], itemDefinition.id, widget.anInt2736 - 1, widget.id, 31, Native.aClass1_1114+ itemDefinition.name);
                                if(class1s != null && class1s[1] != null)
                                    OverlayDefinition.addActionRow(class1s[1], itemDefinition.id, -1 + widget.anInt2736, widget.id, 6, Native.aClass1_1114+ itemDefinition.name);
                                if(class1s != null && class1s[0] != null)
                                    OverlayDefinition.addActionRow(class1s[0], itemDefinition.id, -1 + widget.anInt2736, widget.id, 52, Native.aClass1_1114+ itemDefinition.name);
                            }
                            if(widget.id >= 0)
                                OverlayDefinition.addActionRow(English.examine, itemDefinition.id, -1, widget.id, 1007, Native.aClass1_1114+ itemDefinition.name);
                            else
                                OverlayDefinition.addActionRow(English.examine, itemDefinition.id, widget.id & 0x7fff, widget.parentId, 1007, Native.aClass1_1114+ itemDefinition.name);
                        }
                        if(widget.aBoolean2688 && widget.aClass1Array2661 != null && i_2_ <= arg8 && i_1_ <= arg4 && widget.originalWidth + i_2_ > arg8 && arg4 < i_1_ + widget.originalHeight) {
                            String class1 = "";
                            if(widget.itemId != -1) {
                                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(widget.itemId, arg5 ^ 0xa);
                                class1 = Native.aClass1_1114 + class40_sub5_sub16.name;
                            }
                            for(int i_15_ = widget.aClass1Array2661.length - 1; i_15_ >= 0; i_15_--) {
                                if(widget.aClass1Array2661[i_15_] != null) {
                                    if(widget.id < 0)
                                        OverlayDefinition.addActionRow(widget.aClass1Array2661[i_15_], i_15_ + 1, 0x7fff & widget.id, widget.parentId, 50, class1);
                                    else
                                        OverlayDefinition.addActionRow(widget.aClass1Array2661[i_15_], i_15_ + 1, 0, widget.id, 50, class1);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static ImageRGB method927(int arg0, CacheIndex arg1, boolean arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg0, arg3, arg1))
            return null;
        if(!arg2)
            method922(3, -92, null, -119, -82, -28, -32);
        return ActorDefinition.method578();
    }

    public static void logout(int arg0) {
        if(Class40_Sub6.gameConnection != null) {
            Class40_Sub6.gameConnection.method1009();
            Class40_Sub6.gameConnection = null;
        }
        RSCanvas.method46(0);
        Npc.currentScene.initToNull();
        int i = 0;
        if(arg0 != -7225)
            aClass40_Sub1_1132 = null;
        for(/**/; i < 4; i++)
            Landscape.currentCollisionMap[i].reset();
        System.gc();
        Class33.method405(arg0 ^ ~0x5e71, 10);
        Class35.songTimeout = 0;
        MouseHandler.anInt1457 = -1;
        Class37.method436(arg0 + 7352);
        OverlayDefinition.method559(10);
        ScreenController.frameMode(ScreenMode.FIXED);
    }

    public int method921(int arg0, int arg1) {
        if(anIntArrayArray1128 != null)
            arg0 = 7 + anInt1133 * arg0 / anInt1131;
        if(arg1 != 54)
            return 55;
        return arg0;
    }

    public int method923(int arg0, int arg1) {
        if(arg1 != 4)
            return -128;
        if(anIntArrayArray1128 != null)
            arg0 = anInt1133 * arg0 / anInt1131;
        return arg0;
    }

    public byte[] method926(byte[] arg0, boolean arg1) {
        if(anIntArrayArray1128 != null) {
            int i = 14 + arg0.length * anInt1133 / anInt1131;
            int i_16_ = 0;
            int[] is = new int[i];
            int i_17_ = 0;
            for(int i_18_ = 0; i_18_ < arg0.length; i_18_++) {
                int i_19_ = arg0[i_18_];
                int[] is_20_ = anIntArrayArray1128[i_17_];
                for(int i_21_ = 0; i_21_ < 14; i_21_++)
                    is[i_21_ + i_16_] += is_20_[i_21_] * i_19_;
                i_17_ += anInt1133;
                int i_22_ = i_17_ / anInt1131;
                i_17_ -= i_22_ * anInt1131;
                i_16_ += i_22_;
            }
            arg0 = new byte[i];
            for(int i_23_ = 0; i > i_23_; i_23_++) {
                int i_24_ = 32768 + is[i_23_] >> 16;
                if(i_24_ >= -128) {
                    if(i_24_ > 127)
                        arg0[i_23_] = (byte) 127;
                    else
                        arg0[i_23_] = (byte) i_24_;
                } else
                    arg0[i_23_] = (byte) -128;
            }
        }
        if(arg1)
            method927(-84, null, true, -86);
        return arg0;
    }
}
