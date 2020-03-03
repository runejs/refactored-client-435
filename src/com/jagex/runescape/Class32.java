package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.util.CollisionMap;

public class Class32 {
    public static int anInt744;
    public static PacketBuffer packetBuffer;
    public static int anInt753;
    public static int anInt754;
    public static int[] anIntArray761 = {1, 2, 4, 8};
    public static int anInt765;
    public static RSString aClass1_766;
    public static int anInt767;
    public static Class38 aClass38_768;
    public static int cameraZ;
    public static int anInt770;
    public static int anInt771;
    public static RSString aClass1_772;
    public static CacheIndex_Sub1 aClass6_Sub1_773;
    public static int[] anIntArray774;

    static {
        packetBuffer = new PacketBuffer(5000);
        anInt770 = 0;
        aClass1_772 = RSString.CreateString("title)3jpg");
        aClass1_766 = RSString.CreateString("Ignorieren");
        anIntArray774 = new int[]{12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800, 12800};
        anInt771 = 0;
    }

    public int anInt742;
    public int anInt743;
    public int anInt745;
    public int anInt746;
    public int anInt748;
    public int anInt749;
    public int anInt750;
    public int anInt751;
    public int anInt752;
    public int anInt755;
    public int anInt756;
    public int anInt757;
    public int anInt758;
    public int anInt759;
    public int anInt760;
    public int anInt762;
    public int anInt763;
    public int anInt764;

    public static void method398(int arg0) {

        RSString class1 = null;
        for(int i = 0; ActorDefinition.anInt2394 > i; i++) {
            if(Landscape.aClass1Array1184[i].contains(VertexNormal.aClass1_1114) != -1) {
                class1 = (Landscape.aClass1Array1184[i].substring(Landscape.aClass1Array1184[i].contains(VertexNormal.aClass1_1114)));
                break;
            }
        }
        anInt765++;
        if(class1 == null)
            Class40_Sub5_Sub6.method588(-1);
        else {
            int i = VertexNormal.anInt1086;
            int i_0_ = InteractiveObject.anInt475;
            if(i > 190)
                i = 190;
            int i_1_ = CollisionMap.anInt168;
            int i_2_ = Main.anInt1758;
            if(i_0_ < 0)
                i_0_ = 0;
            int i_3_ = 6116423;
            Rasterizer.drawFilledRectangle(i_0_, i_2_, i, i_1_, i_3_);
            Rasterizer.drawFilledRectangle(i_0_ + 1, i_2_ + 1, arg0 + i, 16, 0);
            Rasterizer.drawUnfilledRectangle(i_0_ + 1, 18 + i_2_, -2 + i, i_1_ + -19, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawShadowedString(class1, 3 + i_0_, 14 + i_2_, i_3_, false);
            int i_4_ = Class13.mouseX;
            int i_5_ = Landscape.mouseY;
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                i_4_ -= 4;
                i_5_ -= 4;
            }
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                i_4_ -= 553;
                i_5_ -= 205;
            }
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                i_5_ -= 357;
                i_4_ -= 17;
            }
            for(int i_6_ = 0; ((i_6_ < ActorDefinition.anInt2394)); i_6_++) {
                int i_7_ = 31 + i_2_ + (ActorDefinition.anInt2394 + (-1 + -i_6_)) * 15;
                RSString class1_8_ = Landscape.aClass1Array1184[i_6_];
                int i_9_ = 16777215;
                if(class1_8_.method87(arg0 + 112, class1)) {
                    class1_8_ = class1_8_.substring(0, (class1_8_.length() - class1.length()));
                    if(class1_8_.method87(arg0 ^ ~0x6f, VertexNormal.aClass1_1117))
                        class1_8_ = (class1_8_.substring(0, (class1_8_.length() + -VertexNormal.aClass1_1117.length())));
                }
                if((i_0_ < i_4_) && (i_4_ < i_0_ + i) && -13 + i_7_ < i_5_ && 3 + i_7_ > i_5_)
                    i_9_ = 16776960;
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawShadowedString(class1_8_, 3 + i_0_, i_7_, i_9_, true);
            }
        }

    }

    public static void method399(int arg0, int arg1, int arg2) {
        anInt744++;
        long l = (long) ((arg0 << 16) + arg2);
        Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) GameObjectDefinition.aClass23_2545.method331(l, 6120));
        if(class40_sub5_sub13 != null) {
            InteractiveObject.aClass27_485.method367(true, class40_sub5_sub13);
            if(arg1 <= 11)
                aClass1_766 = null;
        }
    }

    public static int method400(int arg0) {

        if(arg0 != -1)
            packetBuffer = null;
        anInt753++;
        return Class45.anInt1073++;

    }

    public static void method401(int arg0) {

        anIntArray774 = null;
        aClass38_768 = null;
        aClass1_766 = null;
        aClass1_772 = null;
        anIntArray761 = null;
        packetBuffer = null;
        if(arg0 >= 29)
            aClass6_Sub1_773 = null;

    }
}
