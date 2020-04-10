package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.tile.SceneTile;

public abstract class Class38 {
    public static RSString aClass1_881 = RSString.CreateString("mod_icons");
    public static RSString aClass1_882;
    public static RSString aClass1_883;
    public static int[] menuActionTypes = new int[500];
    public static RSString aClass1_885;
    public static RSString aClass1_886 = RSString.CreateString(" seconds)3");
    public static Class68 aClass68_887;
    public static RSString aClass1_888 = RSString.CreateString("No reply from loginserver)3");
    public static int[] anIntArray889 = new int[128];
    public static RSString aClass1_890 = RSString.CreateString("(U1");
    public static int anInt892;
    public static boolean aBoolean893 = false;
    public static RSString aClass1_894 = RSString.CreateString(" )2>");
    public static RSString aClass1_895 = RSString.CreateString("Add ignore");

    static {
        aClass1_883 = aClass1_886;
        aClass1_882 = aClass1_888;
        aClass1_885 = aClass1_895;
    }

    public static void method439() {
        aClass1_882 = null;
        aClass1_895 = null;
        aClass1_890 = null;
        aClass1_881 = null;
        aClass1_885 = null;
        menuActionTypes = null;
        anIntArray889 = null;
        aClass1_883 = null;
        aClass1_894 = null;
        aClass68_887 = null;
        aClass1_886 = null;
        aClass1_888 = null;
    }

    public static void method440(byte arg0) {
        if(ISAAC.aBoolean512) {
            Class51.anIntArray1198 = null;
            GameObject.aClass68_3042 = null;
            Class68.aClass68_1631 = null;
            Class51.aClass68_1206 = null;
            Landscape.anIntArray1168 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3255 = null;
            Class59.aClass40_Sub5_Sub14_Sub2_1387 = null;
            Class61.anIntArray1445 = null;
            Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2_2775 = null;
            Renderable.anIntArray2865 = null;
            Class8.aClass68_298 = null;
            Class39.aClass68_907 = null;
            GameObjectDefinition.aClass68_2524 = null;
            Class39.aClass40_Sub5_Sub14_Sub4_918 = null;
            Class22.aClass40_Sub5_Sub14_Sub2Array535 = null;
            Class40_Sub5_Sub17_Sub6.anIntArray3248 = null;
            aClass68_887 = null;
            SceneTile.aClass40_Sub5_Sub14_Sub4_2043 = null;
            Class4.anIntArray178 = null;
            KeyFocusListener.aClass68_1285 = null;
            if(arg0 <= -65) {
                Class17.aClass68_463 = null;
                Class42.anIntArray1013 = null;
                Class33.method405(16969, 10);
                GameShell.method19(true, 24041);
                ISAAC.aBoolean512 = false;
            }
        }
    }

    public static void method441(CacheIndex arg0) {
        Actor.aCacheIndex_3144 = arg0;
    }

    public abstract int method442(int i, int i_0_, int i_1_);

    public abstract void method443(int i);

    public abstract void method444(int i);
}
