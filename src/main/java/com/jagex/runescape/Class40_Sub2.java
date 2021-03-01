package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.node.Node;

public class Class40_Sub2 extends Node {

    public int anInt1993;
    public int anInt1994;
    public int anInt1997;
    public int anInt2000;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2001;
    public int anInt2002;
    public int anInt2003;
    public int[] anIntArray2005;
    public int anInt2007;
    public Class40_Sub9_Sub2 aClass40_Sub9_Sub2_2010;
    public GameObjectDefinition gameObjectDefinition;
    public int anInt2012;
    public int anInt2013;
    public int anInt2014;

    public void method528() {
        int i = anInt1997;
        GameObjectDefinition gameObjectDefinition = this.gameObjectDefinition.getChildDefinition();
        if(gameObjectDefinition == null) {
            anInt2000 = 0;
            anInt2012 = 0;
            anInt2002 = 0;
            anIntArray2005 = null;
            anInt1997 = -1;
        } else {
            anInt2000 = 128 * gameObjectDefinition.anInt2502;
            anInt2012 = gameObjectDefinition.anInt2499;
            anInt2002 = gameObjectDefinition.anInt2542;
            anInt1997 = gameObjectDefinition.ambientSoundId;
            anIntArray2005 = gameObjectDefinition.anIntArray2523;
        }
        if(i != anInt1997 && aClass40_Sub9_Sub2_2001 != null) {
            Class49.aClass40_Sub9_Sub1_1152.method853(aClass40_Sub9_Sub2_2001);
            aClass40_Sub9_Sub2_2001 = null;
        }
    }
}
