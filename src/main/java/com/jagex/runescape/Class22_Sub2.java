package com.jagex.runescape;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.scene.GroundItemTile;

public abstract class Class22_Sub2 extends Class22 {
    public static RSString aClass1_1879 = Native.string_blank;
    public static RSString aClass1_1881 = Native.string_blank;
    public static Widget aWidget_1887;
    public static int duplicateClickCount = 0;
    public static RSString aClass1_1896 = Native.string_blank;
    public static int[] anIntArray774 = new int[]{12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800};


    public static IndexedImage[] method315() {
        IndexedImage[] class40_sub5_sub14_sub2s = new IndexedImage[UnderlayDefinition.anInt2581];
        for(int i = 0; UnderlayDefinition.anInt2581 > i; i++) {
            IndexedImage class40_sub5_sub14_sub2 = (class40_sub5_sub14_sub2s[i] = new IndexedImage());
            class40_sub5_sub14_sub2.maxWidth = ItemDefinition.anInt2846;
            class40_sub5_sub14_sub2.maxHeight = GameShell.anInt31;
            class40_sub5_sub14_sub2.xDrawOffset = Class57.anIntArray1347[i];
            class40_sub5_sub14_sub2.yDrawOffset = Actor.anIntArray3111[i];
            class40_sub5_sub14_sub2.imgWidth = Class17.anIntArray456[i];
            class40_sub5_sub14_sub2.imgHeight = Npc.anIntArray3312[i];
            class40_sub5_sub14_sub2.palette = Buffer.anIntArray1972;
            class40_sub5_sub14_sub2.imgPixels = GroundItemTile.aByteArrayArray1370[i];
        }
        ActorDefinition.method569();
        return class40_sub5_sub14_sub2s;
    }

    public static void method316(int arg0) {
        do {
            Class43.aClass9_1014.method235((byte) -104);
            Class34.aClass9_851.method235((byte) -113);
            if(arg0 == -11965)
                break;
            method323(-25);

            break;
        } while(false);
    }

    public static ImageRGB[] method319(byte arg0) {
        ImageRGB[] class40_sub5_sub14_sub4s = new ImageRGB[UnderlayDefinition.anInt2581];
        if(arg0 != -62)
            return null;
        for(int i = 0; (i < UnderlayDefinition.anInt2581); i++) {
            ImageRGB class40_sub5_sub14_sub4 = (class40_sub5_sub14_sub4s[i] = new ImageRGB());
            class40_sub5_sub14_sub4.maxWidth = ItemDefinition.anInt2846;
            class40_sub5_sub14_sub4.maxHeight = GameShell.anInt31;
            class40_sub5_sub14_sub4.offsetX = Class57.anIntArray1347[i];
            class40_sub5_sub14_sub4.offsetY = Actor.anIntArray3111[i];
            class40_sub5_sub14_sub4.image_width = Class17.anIntArray456[i];
            class40_sub5_sub14_sub4.image_height = Npc.anIntArray3312[i];
            byte[] is = GroundItemTile.aByteArrayArray1370[i];
            int i_4_ = (class40_sub5_sub14_sub4.image_height * class40_sub5_sub14_sub4.image_width);
            class40_sub5_sub14_sub4.pixels = new int[i_4_];
            for(int i_5_ = 0; (i_5_ < i_4_); i_5_++)
                class40_sub5_sub14_sub4.pixels[i_5_] = (Buffer.anIntArray1972[HuffmanEncoding.method1021(255, is[i_5_])]);
        }
        ActorDefinition.method569();
        return class40_sub5_sub14_sub4s;
    }

    public static void method320() {
        anIntArray774 = null;
        Native.supportedCharacters = null;
        Native.currentLoadingText = null;
        Native.string_blank = null;
        aClass1_1881 = null;
        aWidget_1887 = null;
        aClass1_1879 = null;
        Native.prefixYellowSTARV = null;
        Native.username = null;
        Native.supportedCharacters = null;
        English.pleaseUseADifferentWorld = null;
        English.walkHere = null;
        aClass1_1896 = null;
        Native.password = null;
    }

    public static int method323(int arg0) {
        int i = anIntArray774[arg0];
        i = (i * Class44.anInt1040 >> 8) * i;
        return (int) (Math.sqrt(i) + 0.5);
    }

    public abstract void method314(int i, int i_0_, int i_1_, long l);

    public void method317(int arg0, int arg1, long arg2, int arg3) {
        do {
            arg0 = (int) ((double) arg0 * Math.pow(0.1, (double) arg1 * 5.0E-4) + 0.5);
            if(arg0 != Class44.anInt1040) {
                Class44.anInt1040 = arg0;
                for(int i = 0; i < 16; i++) {
                    int i_2_ = method323(i);
                    method314(176 + i, 7, i_2_ >> 7, arg2);
                    method314(176 + i, 39, i_2_ & 0x7f, arg2);
                }
            }
            if(arg3 == 0)
                break;
            method318(95, 122L, 123);
            break;
        } while(false);
    }

    public void method318(int arg0, long arg1, int arg2) {
        Class44.anInt1040 = arg2;
        for(int i = 0; i < 16; i++)
            anIntArray774[i] = 12800;
        if(arg0 >= -80)
            Native.username = null;
        for(int i = 0; i < 16; i++) {
            int i_3_ = method323(i);
            method314(176 + i, 7, i_3_ >> 7, arg1);
            method314(176 + i, 39, 0x7f & i_3_, arg1);
        }
    }

    public void method321(byte arg0, long arg1) {
        for(int i = 0; i < 128; i++) {
            int i_6_ = Class38.anIntArray889[i];
            Class38.anIntArray889[i] = 0;
            for(int i_7_ = 0; i_7_ < 16; i_7_++) {
                if((i_6_ & 1 << i_7_) != 0)
                    method314(144 + i_7_, i, 0, arg1);
            }
        }
        for(int i = 0; i < 16; i++)
            method314(i + 176, 123, 0, arg1);
        if(arg0 <= 101)
            aClass1_1879 = null;
        for(int i = 0; i < 16; i++)
            method314(i + 176, 120, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 121, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 176, 0, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(176 + i, 32, 0, arg1);
        for(int i = 0; i < 16; i++)
            method314(i + 192, 0, 0, arg1);
    }

    public boolean method322(int arg0, int arg1, int arg2, long arg3) {
        if((arg0 & 0xe0) == 128) {
            int i = 1 << (arg0 & 0xf);
            int i_8_ = Class38.anIntArray889[arg1];
            if(arg0 >= 144 && arg2 != 0) {
                if((i_8_ & i) != 0)
                    method314(arg0, arg1, 0, arg3);
                else
                    Class38.anIntArray889[arg1] = i_8_ | i;
            } else
                Class38.anIntArray889[arg1] = i_8_ & (i ^ 0xffffffff);
            return false;
        }
        if((arg0 & 0xf0) == 176) {
            if(arg1 == 121) {
                method314(arg0, arg1, arg2, arg3);
                int i = arg0 & 0xf;
                anIntArray774[i] = 12800;
                int i_9_ = method323(i);
                method314(arg0, 7, i_9_ >> 7, arg3);
                method314(arg0, 39, i_9_ & 0x7f, arg3);
                return true;
            }
            if(arg1 == 7 || arg1 == 39) {
                int i = arg0 & 0xf;
                if(arg1 == 7)
                    anIntArray774[i] = (anIntArray774[i] & 0x7f) + (arg2 << 7);
                else
                    anIntArray774[i] = (anIntArray774[i] & 0x3f80) + arg2;
                int i_10_ = method323(i);
                method314(arg0, 7, i_10_ >> 7, arg3);
                method314(arg0, 39, i_10_ & 0x7f, arg3);
                return true;
            }
        }
        return false;
    }
}
