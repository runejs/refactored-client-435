package org.runejs.client.sound;

import org.runejs.client.LinkedList;
import org.runejs.client.audio.Effect;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.util.Signlink;

public class SoundSystem {

	static final int SAMPLE_RATE = 22050;
	static long timeMs;
	static PcmStreamMixer pcmStreamMixer;

	private static int currentSound = 0;

	private static PcmPlayer pcmPlayer;

	private static Effect[] effects = new Effect[50];
	private static int[] sound = new int[50];
	private static int[] soundDelay = new int[50];
	private static int[] soundLocations = new int[50];
	private static int[] soundVolume = new int[50];

	private static int areaSoundEffectVolume = 127;
	private static int soundEffectVolume = 127;

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void reset() {
		SoundSystem.currentSound = 0;
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void initialiseSound(Signlink signlink) {
		SoundSystem.pcmStreamMixer = SoundSystem.method1003(signlink);
	}

	private static Class pcmClass;

	public static void handleSounds() {
		if (SoundSystem.pcmPlayer != null) {
			long currentTime = System.currentTimeMillis();
			if (SoundSystem.timeMs < currentTime) {
				SoundSystem.pcmPlayer.method212(currentTime);
				int elapsed = (int) (currentTime - SoundSystem.timeMs);
				SoundSystem.timeMs = currentTime;
				synchronized (pcmClass != null ? pcmClass : (pcmClass = PcmPlayer.class)) {
					PcmPlayer.handle(elapsed);
				}
			}
		}
	}

	public static void play(int soundId, int volume, int delay) {
		if (SoundSystem.soundEffectVolume != 0 && volume != 0 && SoundSystem.currentSound < 50) {
			SoundSystem.sound[SoundSystem.currentSound] = soundId;
			SoundSystem.soundVolume[SoundSystem.currentSound] = volume;
			SoundSystem.soundDelay[SoundSystem.currentSound] = delay;
			SoundSystem.effects[SoundSystem.currentSound] = null;
			SoundSystem.soundLocations[SoundSystem.currentSound] = 0;
			SoundSystem.currentSound++;
		}
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void play(int soundId, int volume, int delay, int location) {
		if (SoundSystem.areaSoundEffectVolume != 0 && volume > 0 && SoundSystem.currentSound < 50) {
			SoundSystem.sound[SoundSystem.currentSound] = soundId;
			SoundSystem.soundVolume[SoundSystem.currentSound] = volume;
			SoundSystem.soundDelay[SoundSystem.currentSound] = delay;
			SoundSystem.effects[SoundSystem.currentSound] = null;
			SoundSystem.soundLocations[SoundSystem.currentSound] = 0;
			SoundSystem.currentSound++;
		}
	}

	/*
	 * In 443, this here also sets the sampleRate to 0. However, checking OSRS,
	 * 435, and 578 this was not the case.
	 * 
	 */
	public static void stop() {
		if (SoundSystem.pcmPlayer != null) {
			SoundSystem.pcmPlayer.stop();
			SoundSystem.pcmPlayer = null;
		}
	}

	public static void processSounds() {
		for (int index = 0; index < SoundSystem.currentSound; index++) {
			SoundSystem.soundDelay[index]--;
			if (SoundSystem.soundDelay[index] < -10) {
				SoundSystem.currentSound--;
				for (int j = index; SoundSystem.currentSound > j; j++) {
					SoundSystem.sound[j] = SoundSystem.sound[j + 1];
					SoundSystem.effects[j] = SoundSystem.effects[1 + j];
					SoundSystem.soundVolume[j] = SoundSystem.soundVolume[1 + j];
					SoundSystem.soundDelay[j] = SoundSystem.soundDelay[1 + j];
					SoundSystem.soundLocations[j] = SoundSystem.soundLocations[1 + j];
				}
				index--;
			} else {
				Effect effect = SoundSystem.effects[index];
				if (effect == null) {
					effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, SoundSystem.sound[index], 0);
					if (effect == null)
						continue;
					SoundSystem.soundDelay[index] += effect.delay();
					SoundSystem.effects[index] = effect;
				}
				if (SoundSystem.soundDelay[index] < 0) {
					int i_10_;
					if (SoundSystem.soundLocations[index] != 0) {
						int i_11_ = 128 * (SoundSystem.soundLocations[index] & 0xff);
						int i_12_ = 0xff & SoundSystem.soundLocations[index] >> 16;
						int i_13_ = (SoundSystem.soundLocations[index] & 0xffb8) >> 8;
						int i_14_ = i_13_ * 128 + 64 + -Player.localPlayer.worldY;
						int i_15_ = i_12_ * 128 + 64 - Player.localPlayer.worldX;
						if (i_15_ < 0)
							i_15_ = -i_15_;
						if (i_14_ < 0)
							i_14_ = -i_14_;
						int i_16_ = -128 + i_15_ + i_14_;
						if (i_16_ > i_11_) {
							SoundSystem.soundDelay[index] = -100;
							continue;
						}
						if (i_16_ < 0)
							i_16_ = 0;
						i_10_ = (i_11_ + -i_16_) * SoundSystem.areaSoundEffectVolume / i_11_;
					} else
						i_10_ = SoundSystem.soundEffectVolume;
					RawSound class40_sub12_sub1 = effect.method428();
					RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_10_);
					class40_sub9_sub2.setNumLoops(-1 + SoundSystem.soundVolume[index]);
					SoundSystem.pcmStreamMixer.addSubStream(class40_sub9_sub2);
					SoundSystem.soundDelay[index] = -100;
				}
			}
		}
	}

	private static PcmStreamMixer method1003(Signlink arg0) {
		createPlayer(arg0);
		PcmStreamMixer mixer = new PcmStreamMixer();
		PcmPlayer.setMixer(mixer);
		return mixer;
	}

	/*
	 * Vastly simplified, it used to create new PcmPlayerBase(8000) in addition
	 * to other audio backends which are deprecated on error. However, this is
	 * not needed due to existing nullchecks in the code. After testing, it
	 * appears that the hierarchy of the PCM classes can be removed just fine.
	 */
	private static void createPlayer(Signlink arg2) {
		try {
			PcmPlayer class8_sub1 = new PcmPlayer();
			class8_sub1.method222(arg2, 2048);
			SoundSystem.pcmPlayer = class8_sub1;
		} catch (Throwable throwable) {
		}

	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void updateSoundEffectVolume(int varPlayerValue) {
		if (varPlayerValue == 0)
			SoundSystem.soundEffectVolume = 127;
		if (varPlayerValue == 1)
			SoundSystem.soundEffectVolume = 96;
		if (varPlayerValue == 2)
			SoundSystem.soundEffectVolume = 64;
		if (varPlayerValue == 3)
			SoundSystem.soundEffectVolume = 32;
		if (varPlayerValue == 4)
			SoundSystem.soundEffectVolume = 0;
	}

	/*
	 * This is an added method. This helps add easier modularity since it is
	 * easier to plug in.
	 */
	public static void updateAreaSoundEffectVolume(int varPlayerValue) {
		if (varPlayerValue == 0)
			SoundSystem.areaSoundEffectVolume = 127;
		if (varPlayerValue == 1)
			SoundSystem.areaSoundEffectVolume = 96;
		if (varPlayerValue == 2)
			SoundSystem.areaSoundEffectVolume = 64;
		if (varPlayerValue == 3)
			SoundSystem.areaSoundEffectVolume = 32;
		if (varPlayerValue == 4)
			SoundSystem.areaSoundEffectVolume = 0;
	}

	private static LinkedList objectSounds = new LinkedList();

	public static void addObjectSounds(int arg0, int arg2, int arg3, int arg4, GameObjectDefinition arg5) {
		ObjectSound class40_sub2 = new ObjectSound();
		class40_sub2.hearDistance = 128 * arg5.ambientSoundHearDistance;
		class40_sub2.unkn2 = arg5.unkn2;
		class40_sub2.soundEffectIds = arg5.soundEffectIds;
		class40_sub2.unkn1 = arg5.unkn1;
		int i = arg5.sizeX;
		int i_17_ = arg5.sizeY;
		class40_sub2.plane = arg2;
		class40_sub2.minX = arg4 * 128;
		if (arg3 == 1 || arg3 == 3) {
			i = arg5.sizeY;
			i_17_ = arg5.sizeX;
		}
		class40_sub2.minY = 128 * arg0;
		class40_sub2.maxY = (i_17_ + arg0) * 128;
		class40_sub2.maxX = (arg4 + i) * 128;
		class40_sub2.soundEffectId = arg5.ambientSoundId;
		if (arg5.childIds != null) {
			class40_sub2.gameObjectDefinition = arg5;
			class40_sub2.set();
		}
		SoundSystem.objectSounds.pushBack(class40_sub2, -126);
		if (class40_sub2.soundEffectIds != null)
			class40_sub2.anInt2014 = (int) ((class40_sub2.unkn2 - class40_sub2.unkn1) * Math.random()) + class40_sub2.unkn1;
	}

	public static void clearObjectSounds() {
		for (ObjectSound class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method909(-4)) {
			if (class40_sub2.stream1 != null) {
				SoundSystem.pcmStreamMixer.removeSubStream(class40_sub2.stream1);
				class40_sub2.stream1 = null;
			}
			if (class40_sub2.stream2 != null) {
				SoundSystem.pcmStreamMixer.removeSubStream(class40_sub2.stream2);
				class40_sub2.stream2 = null;
			}
		}
		SoundSystem.objectSounds.clear(0);
	}

	public static void setObjectSounds() {
		for (ObjectSound class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method909(-4)) {
			if (class40_sub2.gameObjectDefinition != null) {
				class40_sub2.set();
			}
		}
	}

	public static void updateObjectSounds(int pwx, int pwl, int redrawRate, int pwy) {
		for (ObjectSound class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) SoundSystem.objectSounds.method909(-4)) {
			if (class40_sub2.soundEffectId != -1 || class40_sub2.soundEffectIds != null) {
				int distance = 0;
				if (pwx <= class40_sub2.maxX) {
					if (pwx < class40_sub2.minX)
						distance += class40_sub2.minX - pwx;
				} else
					distance += -class40_sub2.maxX + pwx;
				if (pwy > class40_sub2.maxY)
					distance += -class40_sub2.maxY + pwy;
				else if (pwy < class40_sub2.minY)
					distance += -pwy + class40_sub2.minY;
				if (class40_sub2.hearDistance < -64 + distance || SoundSystem.areaSoundEffectVolume == 0 || pwl != class40_sub2.plane) {
					if (class40_sub2.stream1 != null) {
						SoundSystem.pcmStreamMixer.removeSubStream(class40_sub2.stream1);
						class40_sub2.stream1 = null;
					}
					if (class40_sub2.stream2 != null) {
						SoundSystem.pcmStreamMixer.removeSubStream(class40_sub2.stream2);
						class40_sub2.stream2 = null;
					}
				} else {
					distance -= 64;
					if (distance < 0)
						distance = 0;
					int i_49_ = (-distance + class40_sub2.hearDistance) * SoundSystem.areaSoundEffectVolume / class40_sub2.hearDistance;
					if (class40_sub2.stream1 == null) {
						if (class40_sub2.soundEffectId >= 0) {
							Effect effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, class40_sub2.soundEffectId, 0);
							if (effect != null) {
								RawSound class40_sub12_sub1 = effect.method428();
								RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
								class40_sub9_sub2.setNumLoops(-1);
								SoundSystem.pcmStreamMixer.addSubStream(class40_sub9_sub2);
								class40_sub2.stream1 = class40_sub9_sub2;
							}
						}
					} else
						class40_sub2.stream1.method857(i_49_);
					if (class40_sub2.stream2 == null) {
						if (class40_sub2.soundEffectIds != null && (class40_sub2.anInt2014 -= redrawRate) <= 0) {
							int i_50_ = (int) (class40_sub2.soundEffectIds.length * Math.random());
							Effect effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, class40_sub2.soundEffectIds[i_50_], 0);
							if (effect != null) {
								RawSound class40_sub12_sub1 = effect.method428();
								RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
								class40_sub9_sub2.setNumLoops(0);
								SoundSystem.pcmStreamMixer.addSubStream(class40_sub9_sub2);
								class40_sub2.anInt2014 = class40_sub2.unkn1 + (int) ((-class40_sub2.unkn1 + class40_sub2.unkn2) * Math.random());
								class40_sub2.stream2 = class40_sub9_sub2;
							}
						}
					} else {
						class40_sub2.stream2.method857(i_49_);
						if (!class40_sub2.stream2.hasNext())
							class40_sub2.stream2 = null;
					}
				}
			}
		}
	}
}
