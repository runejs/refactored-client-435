package org.runejs.client.sound;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.node.Node;

public class ObjectSound extends Node {

    public int anInt1993;
    public int anInt1994;
    public int soundEffectId;
    public int anInt2000;
    public RawPcmStream stream1;
    public int anInt2002;
    public int anInt2003;
    public int[] soundEffectIds;
    public int anInt2007;
    public RawPcmStream aRawPcmStream_2010;
    public GameObjectDefinition gameObjectDefinition;
    public int anInt2012;
    public int anInt2013;
    public int anInt2014;
    
	public void method528() {
        int i = soundEffectId;
        GameObjectDefinition gameObjectDefinition = this.gameObjectDefinition.getChildDefinition();
        if(gameObjectDefinition == null) {
            anInt2000 = 0;
            anInt2012 = 0;
            anInt2002 = 0;
            soundEffectIds = null;
            soundEffectId = -1;
        } else {
            anInt2000 = 128 * gameObjectDefinition.anInt2502;
            anInt2012 = gameObjectDefinition.anInt2499;
            anInt2002 = gameObjectDefinition.anInt2542;
            soundEffectId = gameObjectDefinition.ambientSoundId;
            soundEffectIds = gameObjectDefinition.soundEffectIds;
        }
        if(i != soundEffectId && stream1 != null) {
            StaticAudio.aPcmStreamMixer_1152.removeSubStream(stream1);
            stream1 = null;
        }
    }

}
