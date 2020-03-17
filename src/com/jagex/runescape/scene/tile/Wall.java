package com.jagex.runescape.scene.tile;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.scene.util.CollisionMap;

public class Wall {
    public static RSString aClass1_338 = RSString.CreateString("backhmid1");
    public static RSString aClass1_343;
    public static RSString aClass1_344;
    public static RSString aClass1_346;
    public static int cameraVelocityHorizontal = 0;
    public static int anInt350;
    public static int[] anIntArray351;
    public static RSString aClass1_352;
    public static Widget aWidget_353;
    public static int[] anIntArray354;
    public static int anInt356;
    public static Class45[][][] aClass45ArrayArrayArray357;

    static {
        aClass1_346 = RSString.CreateString("The server is being updated)3");
        aClass1_344 = aClass1_346;
        aClass1_352 = RSString.CreateString("Neuer Benutzer");
        anIntArray351 = new int[4000];
        aClass1_343 = RSString.CreateString("Geben Sie Ihren Benutzernamen");
        anIntArray354 = new int[25];
        aWidget_353 = null;
        anInt356 = 0;
        aClass45ArrayArrayArray357 = new Class45[4][104][104];
    }

    public int x;
    public int hash;
    public int orientation;
    public Renderable secondary;
    public Renderable primary;
    public int z;
    public int orientation2;
    public int config = 0;
    public int y;

    public Wall() {
        hash = 0;
    }

    public static void method237(int arg0) {
        aClass1_352 = null;
        aClass1_344 = null;
        aClass1_338 = null;
        anIntArray354 = null;
        aClass45ArrayArrayArray357 = null;
        aClass1_343 = null;
        aClass1_346 = null;
        anIntArray351 = null;
        aWidget_353 = null;
        if(arg0 <= 54)
            method237(102);
    }

    public static void method238(int arg0) {
        if(CollisionMap.anInt165 != 0) {
            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
            int i = 0;
            if(Class40_Sub5_Sub15.anInt2782 != 0)
                i = 1;
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(Actor.chatMessages[i_0_] != null) {
                    RSString class1 = Renderable.chatPlayerNames[i_0_];
                    int i_1_ = 0;
                    int i_2_ = HuffmanEncoding.chatTypes[i_0_];
                    if(class1 != null && class1.startsWith(Class51.whiteCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 1;
                    }
                    if(class1 != null && class1.startsWith(Widget.goldCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 2;
                    }
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || Class4.anInt185 == 0 || (Class4.anInt185 == 1 && Class40_Sub2.hasFriend(class1, -32624)))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub6.aClass1_2458), i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub6.aClass1_2458), i_4_, -1 + i_3_, 65535);
                        i_4_ += class40_sub5_sub14_sub1.getStringWidth(Class40_Sub5_Sub6.aClass1_2458);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if(i_1_ == 1) {
                            Class40_Sub5_Sub13.moderatorIcon[0].drawImage(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if(i_1_ == 2) {
                            Class40_Sub5_Sub13.moderatorIcon[1].drawImage(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{class1, ISAAC.aClass1_515, (Actor.chatMessages[i_0_])})), i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{class1, ISAAC.aClass1_515, (Actor.chatMessages[i_0_])})), i_4_, -1 + i_3_, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 5 && Class4.anInt185 < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(Actor.chatMessages[i_0_], 4, i_5_, 0);
                        class40_sub5_sub14_sub1.drawString(Actor.chatMessages[i_0_], 4, i_5_ - 1, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 6 && Class4.anInt185 < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class40_Sub5_Sub1.aClass1_2274, Class48.aClass1_1123, class1, ISAAC.aClass1_515, (Actor.chatMessages[i_0_])})), 4, i_6_, 0);
                        class40_sub5_sub14_sub1.drawString((Class40_Sub5_Sub17_Sub6.method832(new RSString[]{Class40_Sub5_Sub1.aClass1_2274, Class48.aClass1_1123, class1, ISAAC.aClass1_515, (Actor.chatMessages[i_0_])})), 4, i_6_ + -1, 65535);
                        if(i >= 5)
                            return;
                    }
                }
            }
            if(arg0 != 4)
                method238(-13);
        }
    }
}
