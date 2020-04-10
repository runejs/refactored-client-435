package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.tile.Wall;

public class FramemapDefinition extends Node {
    public static boolean aBoolean2177 = false;
    public static RSString aClass1_2179 = RSString.CreateString("cross");
    public static int anInt2183 = 0;
    public static RSString aClass1_2188 = RSString.CreateString("You need a members account to login to this world)3");
    public static RSString aClass1_2189 = RSString.CreateString("Service unavailable)3");


    public int[][] frameMaps;
    public int length;
    public int id;
    public int[] types;

    public FramemapDefinition(int id, byte[] data) {
        this.id = id;
        Buffer buffer = new Buffer(data);
        length = buffer.getUnsignedByte();
        types = new int[length];
        frameMaps = new int[length][];
        for(int i = 0; i < length; i++)
            types[i] = buffer.getUnsignedByte();
        for(int i = 0; length > i; i++)
            frameMaps[i] = new int[buffer.getUnsignedByte()];
        for(int i = 0; i < length; i++) {
            for(int i_38_ = 0; frameMaps[i].length > i_38_; i_38_++)
                frameMaps[i][i_38_] = buffer.getUnsignedByte();
        }

    }

    public static ImageRGB method876(int arg1, int arg2, int arg3) {
        if(arg3 == 0) {
            ImageRGB class40_sub5_sub14_sub4 = ((ImageRGB) Buffer.aClass9_1933.get((long) arg2, (byte) 56));
            if(class40_sub5_sub14_sub4 != null && class40_sub5_sub14_sub4.maxHeight != arg1 && class40_sub5_sub14_sub4.maxHeight != -1) {
                class40_sub5_sub14_sub4.method457(-1);
                class40_sub5_sub14_sub4 = null;
            }
            if(class40_sub5_sub14_sub4 != null)
                return class40_sub5_sub14_sub4;
        }
        ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(arg2, 10);
        if(class40_sub5_sub16.stackIds == null)
            arg1 = -1;
        if(arg1 > 1) {
            int i = -1;
            for(int i_0_ = 0; i_0_ < 10; i_0_++) {
                if(arg1 >= class40_sub5_sub16.stackableAmounts[i_0_] && class40_sub5_sub16.stackableAmounts[i_0_] != 0)
                    i = class40_sub5_sub16.stackIds[i_0_];
            }
            if(i != -1)
                class40_sub5_sub16 = ItemDefinition.forId(i, 10);
        }
        Model class40_sub5_sub17_sub5 = class40_sub5_sub16.asGroundStack(true, 1);
        if(class40_sub5_sub17_sub5 == null)
            return null;
        ImageRGB class40_sub5_sub14_sub4 = null;
        if(class40_sub5_sub16.noteTemplateId != -1) {
            class40_sub5_sub14_sub4 = method876(10, class40_sub5_sub16.notedId, -1);
            if(class40_sub5_sub14_sub4 == null)
                return null;
        }
        int[] is = Rasterizer.destinationPixels;
        int i = Rasterizer.destinationHeight;
        int i_1_ = Rasterizer.destinationWidth;
        int i_2_ = Rasterizer.viewportLeft;
        int i_4_ = Rasterizer.viewportRight;
        int i_5_ = Rasterizer.viewportTop;
        int i_6_ = Rasterizer.viewportBottom;
        int[] is_7_ = Rasterizer3D.method713();
        int i_8_ = Rasterizer3D.bottomY;
        int i_9_ = Rasterizer3D.viewportRx;
        ImageRGB class40_sub5_sub14_sub4_10_ = new ImageRGB(32, 32);
        Rasterizer.prepare(class40_sub5_sub14_sub4_10_.pixels, 32, 32);
        Class40_Sub5_Sub17_Sub6.anIntArray3253 = Rasterizer3D.method708(Class40_Sub5_Sub17_Sub6.anIntArray3253);
        Rasterizer.drawFilledRectangle(0, 0, 32, 32, 0);
        int i_11_ = class40_sub5_sub16.zoom2d;
        if(arg3 == -1)
            i_11_ *= 1.5;
        if(arg3 > 0)
            i_11_ *= 1.04;
        Rasterizer3D.notTextured = false;
        int i_12_ = ((Rasterizer3D.sinetable[class40_sub5_sub16.xan2d]) * i_11_ >> 16);
        int i_13_ = (i_11_ * (Rasterizer3D.cosinetable[class40_sub5_sub16.xan2d]) >> 16);
        class40_sub5_sub17_sub5.method799();
        class40_sub5_sub17_sub5.method812(0, class40_sub5_sub16.yan2d, class40_sub5_sub16.zan2d, class40_sub5_sub16.xan2d, class40_sub5_sub16.xOffset2d, (class40_sub5_sub16.yOffset2d + class40_sub5_sub17_sub5.modelHeight / 2 + i_12_), i_13_ + class40_sub5_sub16.yOffset2d);
        for(int i_14_ = 31; i_14_ >= 0; i_14_--) {
            for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                if((class40_sub5_sub14_sub4_10_.pixels[i_14_ + 32 * i_13_]) == 0) {
                    if(i_14_ > 0 && (class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + (-1 + i_14_)]) > 1)
                        class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + i_14_] = 1;
                    else if(i_13_ > 0 && (class40_sub5_sub14_sub4_10_.pixels[i_14_ + ((i_13_ + -1) * 32)]) > 1)
                        class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + i_14_] = 1;
                    else if(i_14_ < 31 && (class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + i_14_ + 1]) > 1)
                        class40_sub5_sub14_sub4_10_.pixels[i_14_ + i_13_ * 32] = 1;
                    else if(i_13_ < 31 && (class40_sub5_sub14_sub4_10_.pixels[(i_13_ + 1) * 32 + i_14_]) > 1)
                        class40_sub5_sub14_sub4_10_.pixels[i_14_ + 32 * i_13_] = 1;
                }
            }
        }
        if(arg3 > 0) {
            for(int i_15_ = 31; i_15_ >= 0; i_15_--) {
                for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                    if((class40_sub5_sub14_sub4_10_.pixels[i_15_ + (i_13_ * 32)]) == 0) {
                        if(i_15_ > 0 && (class40_sub5_sub14_sub4_10_.pixels[32 * i_13_ + (-1 + i_15_)]) == 1)
                            class40_sub5_sub14_sub4_10_.pixels[i_15_ + i_13_ * 32] = arg3;
                        else if(i_13_ <= 0 || (class40_sub5_sub14_sub4_10_.pixels[i_15_ + ((i_13_ + -1) * 32)]) != 1) {
                            if(i_15_ >= 31 || (class40_sub5_sub14_sub4_10_.pixels[1 + i_15_ + (i_13_ * 32)]) != 1) {
                                if(i_13_ < 31 && (class40_sub5_sub14_sub4_10_.pixels[i_15_ + (32 + 32 * i_13_)]) == 1)
                                    class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + i_15_] = arg3;
                            } else
                                class40_sub5_sub14_sub4_10_.pixels[i_15_ + (i_13_ * 32)] = arg3;
                        } else
                            class40_sub5_sub14_sub4_10_.pixels[i_15_ + (i_13_ * 32)] = arg3;
                    }
                }
            }
        } else if(arg3 == 0) {
            for(int i_16_ = 31; i_16_ >= 0; i_16_--) {
                for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                    if((class40_sub5_sub14_sub4_10_.pixels[i_13_ * 32 + i_16_]) == 0 && i_16_ > 0 && i_13_ > 0 && (class40_sub5_sub14_sub4_10_.pixels[i_16_ - (1 + -((-1 + i_13_) * 32))]) > 0)
                        class40_sub5_sub14_sub4_10_.pixels[i_16_ + 32 * i_13_] = 3153952;
                }
            }
        }
        if(class40_sub5_sub16.noteTemplateId != -1) {
            int i_17_ = class40_sub5_sub14_sub4.maxHeight;
            int i_18_ = class40_sub5_sub14_sub4.maxWidth;
            class40_sub5_sub14_sub4.maxHeight = 32;
            class40_sub5_sub14_sub4.maxWidth = 32;
            class40_sub5_sub14_sub4.drawImage(0, 0);
            class40_sub5_sub14_sub4.maxWidth = i_18_;
            class40_sub5_sub14_sub4.maxHeight = i_17_;
        }
        if(arg3 == 0)
            Buffer.aClass9_1933.put((long) arg2, class40_sub5_sub14_sub4_10_);
        Rasterizer.prepare(is, i_1_, i);
        Rasterizer.setBounds(i_2_, i_5_, i_6_, i_4_);
        Rasterizer3D.method708(is_7_);
        Rasterizer3D.bottomY = i_8_;
        Rasterizer3D.viewportRx = i_9_;
        Rasterizer3D.method702();
        Rasterizer3D.notTextured = true;
        if(class40_sub5_sub16.stackable == 1)
            class40_sub5_sub14_sub4_10_.maxWidth = 33;
        else
            class40_sub5_sub14_sub4_10_.maxWidth = 32;
        class40_sub5_sub14_sub4_10_.maxHeight = arg1;
        return class40_sub5_sub14_sub4_10_;

    }

    public static void method877() {
        aClass1_2188 = null;
        aClass1_2179 = null;
        aClass1_2189 = null;
    }

    public static Widget method878(Widget arg1) {
        int i;
        if(arg1.id < 0)
            i = arg1.parentId >> 16;
        else
            i = arg1.id >> 16;
        if(!Class68.method1043(i))
            return null;
        if(arg1.anInt2738 >= 0)
            return (Widget.interfaces[i][0xffff & arg1.anInt2738]);
        Widget widget = (Widget.interfaces[i][(0x7fff99d9 & arg1.anInt2738) >> 15]);
        return (widget.aWidgetArray2713[arg1.anInt2738 & 0x7fff]);
    }

    public static void method879(IndexedImage arg1) {
        int i = 0;
        for(/**/; i < Landscape.anIntArray1168.length; i++)
            Landscape.anIntArray1168[i] = 0;
        int i_19_ = 256;
        for(int i_20_ = 0; i_20_ < 5000; i_20_++) {
            int i_21_ = (int) ((double) i_19_ * (128.0 * Math.random()));
            Landscape.anIntArray1168[i_21_] = (int) (256.0 * Math.random());
        }
        for(int i_22_ = 0; i_22_ < 20; i_22_++) {
            for(int i_23_ = 1; (-1 + i_19_ > i_23_); i_23_++) {
                for(int i_24_ = 1; i_24_ < 127; i_24_++) {
                    int i_25_ = (i_23_ << 7) + i_24_;
                    Class61.anIntArray1445[i_25_] = (Landscape.anIntArray1168[i_25_ - 128] + Landscape.anIntArray1168[i_25_ + -1] + (Landscape.anIntArray1168[i_25_ + 1] + Landscape.anIntArray1168[128 + i_25_])) / 4;
                }
            }
            int[] is = Landscape.anIntArray1168;
            Landscape.anIntArray1168 = Class61.anIntArray1445;
            Class61.anIntArray1445 = is;
        }
        if(arg1 != null) {
            int i_26_ = 0;
            for(int i_27_ = 0; arg1.imgHeight > i_27_; i_27_++) {
                for(int i_28_ = 0; (i_28_ < arg1.imgWidth); i_28_++) {
                    if(arg1.imgPixels[i_26_++] != 0) {
                        int i_29_ = arg1.yDrawOffset + i_27_ + 16;
                        int i_30_ = arg1.xDrawOffset + (i_28_ + 16);
                        int i_31_ = i_30_ + (i_29_ << 7);
                        Landscape.anIntArray1168[i_31_] = 0;
                    }
                }
            }
        }
    }

    public static void spawnGroundItem(int arg1, int arg2) {
        LinkedList linkedList = (Wall.groundItems[Player.worldLevel][arg2][arg1]);
        if(linkedList == null)
            Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
        else {
            int i = -99999999;
            Item item = null;
            for(Item item_32_ = ((Item) linkedList.method902((byte) -90)); item_32_ != null; item_32_ = (Item) linkedList.method909(-4)) {
                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId((item_32_.itemId), 10);
                int i_33_ = class40_sub5_sub16.cost;
                if(class40_sub5_sub16.stackable == 1)
                    i_33_ *= item_32_.itemCount + 1;
                if((i_33_ > i)) {
                    i = i_33_;
                    item = item_32_;
                }
            }
            if(item == null)
                Npc.currentScene.method125(Player.worldLevel, arg2, arg1);
            else {
                Item item_34_ = null;
                Item item_35_ = null;
                linkedList.method905(0, item);
                for(Item item_36_ = ((Item) linkedList.method902((byte) -90)); item_36_ != null; item_36_ = ((Item) linkedList.method909(-4))) {
                    if(item.itemId != item_36_.itemId) {
                        if(item_35_ == null)
                            item_35_ = item_36_;
                        if((item_35_.itemId != item_36_.itemId) && item_34_ == null)
                            item_34_ = item_36_;
                    }
                }
                int i_37_ = 1610612736 + (arg1 << 7) + arg2;
                Npc.currentScene.addGroundItemTile(arg2, arg1, Player.worldLevel, Class37.getFloorDrawHeight((Player.worldLevel), 64 + 128 * arg2, 64 + 128 * arg1), i_37_, item, item_35_, item_34_);
            }
        }

    }
}
