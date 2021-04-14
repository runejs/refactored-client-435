package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.cache.media.gameInterface.GameInterfaceType;
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
                        MovedStatics.tile_height[0][arg0][arg4] = -Class42.method888(arg6 + arg0 + 932731, (byte) -45, arg5 + 556238 + arg4) * 8;
                    else
                        MovedStatics.tile_height[arg7][arg0][arg4] = -240 + MovedStatics.tile_height[arg7 + -1][arg0][arg4];
                    break;
                }
                if(i == 1) {
                    int i_0_ = arg2.getUnsignedByte();
                    if(i_0_ == 1)
                        i_0_ = 0;
                    if(arg7 != 0)
                        MovedStatics.tile_height[arg7][arg0][arg4] = MovedStatics.tile_height[-1 + arg7][arg0][arg4] + -(8 * i_0_);
                    else
                        MovedStatics.tile_height[0][arg0][arg4] = 8 * -i_0_;
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

    // Area IDs:
    // 0 = Game area (the area that renders in 3D)
    // 1 = Tab area (the widgets that display within the tab area)
    // 2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
    public static void handleInterfaceActions(int areaId, int mouseX, int mouseY, int minX, int minY, int maxX, int maxY, GameInterface[] gameInterfaces, int parentId, int scrollPosition, int scrollWidth) {
        // Only try to handle actions if mouse is within this widget's boundaries
        if(minX <= mouseX && mouseY >= minY && maxX > mouseX && maxY > mouseY) {
            for(int i = 0; gameInterfaces.length > i; i++) {
                GameInterface gameInterface = gameInterfaces[i];
                if(gameInterface != null && parentId == gameInterface.parentId) {
                    int i_1_ = gameInterface.currentY - (-minY + scrollPosition);
                    int i_2_ = -scrollWidth + gameInterface.currentX + minX;
                    if(gameInterface.type == GameInterfaceType.IF1_TOOLTIP && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_)
                        Item.anInt3065 = i;
                    if((gameInterface.hoveredSiblingId >= 0 || gameInterface.hoveredTextColor != 0) && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_) {
                        if(gameInterface.hoveredSiblingId >= 0)
                            OverlayDefinition.anInt2328 = gameInterface.hoveredSiblingId;
                        else
                            OverlayDefinition.anInt2328 = i;
                    }
                    if(gameInterface.type == GameInterfaceType.LAYER) {
                        if(!gameInterface.isHidden || Class29.isHovering(areaId, i) || PacketBuffer.hiddenButtonTest) {
                            handleInterfaceActions(areaId, mouseX, mouseY, i_2_, i_1_, i_2_ + gameInterface.originalWidth, i_1_ + gameInterface.originalHeight, gameInterfaces, i, gameInterface.scrollPosition, gameInterface.scrollWidth);
                            if(gameInterface.children != null)
                                handleInterfaceActions(areaId, mouseX, mouseY, i_2_, i_1_, gameInterface.originalWidth + i_2_, i_1_ + gameInterface.originalHeight, gameInterface.children, gameInterface.id, gameInterface.scrollPosition, gameInterface.scrollWidth);
                            if(gameInterface.originalHeight < gameInterface.scrollHeight)
                                GameInterface.scrollInterface(gameInterface.originalHeight, mouseY, mouseX, gameInterface.scrollHeight, gameInterface, gameInterface.originalWidth + i_2_, areaId, i_1_);
                        }
                    } else {
                        if(gameInterface.actionType == 1 && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && gameInterface.originalHeight + i_1_ > mouseY) {
                            boolean bool = false;
                            if(gameInterface.contentType != 0)
                                bool = ProducingGraphicsBuffer_Sub1.method1051(300, gameInterface);
                            if(!bool) {
                                OverlayDefinition.addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 42, "");
                            }
                        }
                        if(gameInterface.actionType == 2 && Main.widgetSelected == 0 && mouseX >= i_2_ && mouseY >= i_1_ && mouseX < gameInterface.originalWidth + i_2_ && mouseY < i_1_ + gameInterface.originalHeight) {
                            OverlayDefinition.addActionRow(gameInterface.targetVerb, 0, 0, gameInterface.id, 33, Native.green + gameInterface.spellName);
                        }
                        if(gameInterface.actionType == 3 && mouseX >= i_2_ && mouseY >= i_1_ && i_2_ + gameInterface.originalWidth > mouseX && mouseY < i_1_ + gameInterface.originalHeight) {
                            int i_3_;
                            if(areaId != 3)
                                i_3_ = 9;
                            else
                                i_3_ = 40;
                            OverlayDefinition.addActionRow(English.close, 0, 0, gameInterface.id, i_3_, "");
                        }
                        if(gameInterface.actionType == 4 && mouseX >= i_2_ && i_1_ <= mouseY && mouseX < gameInterface.originalWidth + i_2_ && gameInterface.originalHeight + i_1_ > mouseY) {
                            OverlayDefinition.addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 23, "");
                        }
                        if(gameInterface.actionType == 5 && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && i_1_ + gameInterface.originalHeight > mouseY) {
                            OverlayDefinition.addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 57, "");
                        }
                        if(gameInterface.actionType == 6 && MovedStatics.lastContinueTextWidgetId == -1 && i_2_ <= mouseX && i_1_ <= mouseY && mouseX < i_2_ + gameInterface.originalWidth && mouseY < gameInterface.originalHeight + i_1_) {
                            OverlayDefinition.addActionRow(gameInterface.tooltip, 0, 0, gameInterface.id, 54, "");
                        }
                        if(gameInterface.type == GameInterfaceType.INVENTORY) {
                            int i_4_ = 0;
                            for(int i_5_ = 0; i_5_ < gameInterface.originalHeight; i_5_++) {
                                for(int i_6_ = 0; i_6_ < gameInterface.originalWidth; i_6_++) {
                                    int i_7_ = i_6_ * (gameInterface.itemSpritePadsX + 32) + i_2_;
                                    int i_8_ = i_1_ + (32 + gameInterface.itemSpritePadsY) * i_5_;
                                    if(i_4_ < 20) {
                                        i_7_ += gameInterface.images[i_4_];
                                        i_8_ += gameInterface.imageX[i_4_];
                                    }
                                    if(mouseX >= i_7_ && i_8_ <= mouseY && i_7_ + 32 > mouseX && mouseY < 32 + i_8_) {
                                        RSRuntimeException.lastActiveInvInterface = gameInterface.id;
                                        Class55.mouseInvInterfaceIndex = i_4_;
                                        if(gameInterface.items[i_4_] > 0) {
                                            ItemDefinition itemDefinition = ItemDefinition.forId(-1 + gameInterface.items[i_4_], 10);
                                            if(Class8.itemSelected != 1 || !gameInterface.isInventory) {
                                                if(Main.widgetSelected == 1 && gameInterface.isInventory) {
                                                    if((ItemDefinition.selectedMask & 0x10) == 16) {
                                                        OverlayDefinition.addActionRow(Native.aClass1_1918, itemDefinition.id, i_4_, gameInterface.id, 37, Native.aClass1_611 + Native.toLightRed + itemDefinition.name);
                                                    }
                                                } else {
                                                    String[] class1s = itemDefinition.interfaceOptions;
                                                    if(Class60.aBoolean1402)
                                                        class1s = MovedStatics.method968(class1s);
                                                    if(gameInterface.isInventory) {
                                                        for(int i_9_ = 4; i_9_ >= 3; i_9_--) {
                                                            if(class1s != null && class1s[i_9_] != null) {
                                                                int i_10_;
                                                                if(i_9_ != 3)
                                                                    i_10_ = 11;
                                                                else
                                                                    i_10_ = 43;
                                                                OverlayDefinition.addActionRow(class1s[i_9_], itemDefinition.id, i_4_, gameInterface.id, i_10_, Native.lightRed + itemDefinition.name);
                                                            } else if(i_9_ == 4) {
                                                                OverlayDefinition.addActionRow(English.drop, itemDefinition.id, i_4_, gameInterface.id, 11, Native.lightRed + itemDefinition.name);
                                                            }
                                                        }
                                                    }
                                                    if(gameInterface.itemUsable) {
                                                        OverlayDefinition.addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, 19, Native.lightRed + itemDefinition.name);
                                                    }
                                                    if(gameInterface.isInventory && class1s != null) {
                                                        for(int i_11_ = 2; i_11_ >= 0; i_11_--) {
                                                            if(class1s[i_11_] != null) {
                                                                int i_12_ = 0;
                                                                if(i_11_ == 0)
                                                                    i_12_ = 52;
                                                                if(i_11_ == 1)
                                                                    i_12_ = 6;
                                                                if(i_11_ == 2)
                                                                    i_12_ = 31;
                                                                OverlayDefinition.addActionRow(class1s[i_11_], itemDefinition.id, i_4_, gameInterface.id, i_12_, Native.lightRed + itemDefinition.name);
                                                            }
                                                        }
                                                    }
                                                    class1s = gameInterface.configActions;
                                                    if(Class60.aBoolean1402)
                                                        class1s = MovedStatics.method968(class1s);
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
                                                                OverlayDefinition.addActionRow(class1s[i_13_], itemDefinition.id, i_4_, gameInterface.id, i_14_, Native.lightRed + itemDefinition.name);
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
                                                    OverlayDefinition.addActionRow(English.examine, itemDefinition.id, i_4_, gameInterface.id, 1006, examineText.toString());
                                                }
                                            } else if(ISAAC.anInt525 != gameInterface.id || i_4_ != LinkedList.anInt1061) {
                                                OverlayDefinition.addActionRow(English.use, itemDefinition.id, i_4_, gameInterface.id, 56, Native.aClass1_3295+ Native.toLightRed + itemDefinition.name);
                                            }
                                        }
                                    }
                                    i_4_++;
                                }
                            }
                        }
                        if(gameInterface.isNewInterfaceFormat && gameInterface.itemId != -1 && mouseX >= i_2_ && mouseY >= i_1_ && mouseX < gameInterface.originalWidth + i_2_ && mouseY < i_1_ + gameInterface.originalHeight) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
                            if(gameInterface.isInventory) {
                                String[] class1s = itemDefinition.interfaceOptions;
                                if(Class60.aBoolean1402)
                                    class1s = MovedStatics.method968(class1s);
                                if(class1s == null || class1s[4] == null)
                                    OverlayDefinition.addActionRow(English.drop, itemDefinition.id, -1 + gameInterface.anInt2736, gameInterface.id, 11, Native.lightRed +itemDefinition.name);
                                else
                                    OverlayDefinition.addActionRow(class1s[4], itemDefinition.id, gameInterface.anInt2736 + -1, gameInterface.id, 11, Native.lightRed + itemDefinition.name);
                                if(class1s != null && class1s[3] != null)
                                    OverlayDefinition.addActionRow(class1s[3], itemDefinition.id, -1 + gameInterface.anInt2736, gameInterface.id, 43, Native.lightRed + itemDefinition.name);
                                if(class1s != null && class1s[2] != null)
                                    OverlayDefinition.addActionRow(class1s[2], itemDefinition.id, gameInterface.anInt2736 - 1, gameInterface.id, 31, Native.lightRed + itemDefinition.name);
                                if(class1s != null && class1s[1] != null)
                                    OverlayDefinition.addActionRow(class1s[1], itemDefinition.id, -1 + gameInterface.anInt2736, gameInterface.id, 6, Native.lightRed + itemDefinition.name);
                                if(class1s != null && class1s[0] != null)
                                    OverlayDefinition.addActionRow(class1s[0], itemDefinition.id, -1 + gameInterface.anInt2736, gameInterface.id, 52, Native.lightRed + itemDefinition.name);
                            }
                            if(gameInterface.id >= 0)
                                OverlayDefinition.addActionRow(English.examine, itemDefinition.id, -1, gameInterface.id, 1007, Native.lightRed + itemDefinition.name);
                            else
                                OverlayDefinition.addActionRow(English.examine, itemDefinition.id, gameInterface.id & 0x7fff, gameInterface.parentId, 1007, Native.lightRed + itemDefinition.name);
                        }
                        if(gameInterface.hasListeners && gameInterface.aClass1Array2661 != null && i_2_ <= mouseX && i_1_ <= mouseY && gameInterface.originalWidth + i_2_ > mouseX && mouseY < i_1_ + gameInterface.originalHeight) {
                            String class1 = "";
                            if(gameInterface.itemId != -1) {
                                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(gameInterface.itemId, 0);
                                class1 = Native.lightRed + class40_sub5_sub16.name;
                            }
                            for(int i_15_ = gameInterface.aClass1Array2661.length - 1; i_15_ >= 0; i_15_--) {
                                if(gameInterface.aClass1Array2661[i_15_] != null) {
                                    if(gameInterface.id < 0)
                                        OverlayDefinition.addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0x7fff & gameInterface.id, gameInterface.parentId, 50, class1);
                                    else
                                        OverlayDefinition.addActionRow(gameInterface.aClass1Array2661[i_15_], i_15_ + 1, 0, gameInterface.id, 50, class1);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static ImageRGB method927(int arg0, CacheArchive arg1, boolean arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg0, arg3, arg1))
            return null;
        if(!arg2)
            method922(3, -92, null, -119, -82, -28, -32);
        return ActorDefinition.method578();
    }

    public static void logout(int arg0) {
        if(MovedStatics.gameConnection != null) {
            MovedStatics.gameConnection.method1009();
            MovedStatics.gameConnection = null;
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
        OverlayDefinition.updateOverlay(10);
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
