package org.runejs.client.sound;

import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.node.Node;

public class ObjectSound extends Node {

	public int plane;
	public int minX;
	public int soundEffectId;
	public int hearDistance;
	public RawPcmStream stream1;
	public int unkn2;
	public int minY;
	public int[] soundEffectIds;
	public int maxY;
	public RawPcmStream stream2;
	public GameObjectDefinition gameObjectDefinition;
	public int unkn1;
	public int maxX;
	public int anInt2014;

	public void set() {
		int i = soundEffectId;
		GameObjectDefinition gameObjectDefinition = this.gameObjectDefinition.getChildDefinition();
		if (gameObjectDefinition == null) {
			hearDistance = 0;
			unkn1 = 0;
			unkn2 = 0;
			soundEffectIds = null;
			soundEffectId = -1;
		} else {
			hearDistance = 128 * gameObjectDefinition.ambientSoundHearDistance;
			unkn1 = gameObjectDefinition.unkn1;
			unkn2 = gameObjectDefinition.unkn2;
			soundEffectId = gameObjectDefinition.ambientSoundId;
			soundEffectIds = gameObjectDefinition.soundEffectIds;
		}
		if (i != soundEffectId && stream1 != null) {
			SoundSystem.pcmStreamMixer.removeSubStream(stream1);
			stream1 = null;
		}
	}

}
