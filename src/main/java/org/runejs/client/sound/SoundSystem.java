package org.runejs.client.sound;

import org.runejs.client.LinkedList;
import org.runejs.client.audio.Effect;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.util.Signlink;

public class SoundSystem {

	public static int sampleRate;

	
	/*
	The following was combined with the commented code in the synchronized block. Rather than 
	 
	public static Class aClass1654;//was synthetic

	public static Class method1058(String arg0) {//was synthetic
	    try {
	        return Class.forName(arg0);
	    } catch(ClassNotFoundException classnotfoundexception) {
	        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
	    }
	}*/
	public static Object lock = new Object();

	public static void handleSounds() {
	    if(SoundSystem.pcmPlayer != null) {
	        long l = System.currentTimeMillis();
	        if(SoundSystem.aLong288 < l) {
	            SoundSystem.pcmPlayer.method212(l);
	            int i = (int) (-SoundSystem.aLong288 + l);
	            SoundSystem.aLong288 = l;
	            //TODO synchronized(StaticAudio.aClass1654 != null ? StaticAudio.aClass1654 : (StaticAudio.aClass1654 = method1058("org.runejs.client.sound.PcmPlayerBase"))) {
	            synchronized(lock) {
	                SoundSystem.anInt2081 += sampleRate * i;
	                int i_0_ = (-(2000 * sampleRate) + SoundSystem.anInt2081) / 1000;
	                if(i_0_ > 0) {
	                    if(SoundSystem.pcmStream != null)
	                        SoundSystem.pcmStream.skip(i_0_);
	                    SoundSystem.anInt2081 -= i_0_ * 1000;
	                }
	            }
	        }
	    }
	}

	public static PcmStream pcmStream;
	public static long aLong288;
	public static PcmPlayer pcmPlayer;
	public static int anInt2081;

	public static void method748(int arg1) {
	    for(SoundSystem.anInt2866 += arg1; SoundSystem.anInt2866 >= sampleRate; SoundSystem.anInt2866 -= sampleRate) {
	        anInt2081 -= anInt2081 >> 2;
	    }
	    anInt2081 -= 1000 * arg1;
	    if(anInt2081 < 0) {
	        anInt2081 = 0;
	    }
	}

	public static int anInt2866;

	public static void createPlayer(Signlink arg2) {
	    try {    	
	        PcmPlayer class8_sub1 = new PcmPlayer();
	        class8_sub1.method222(arg2, 2048);
	        pcmPlayer = class8_sub1;        
	    } catch (Throwable throwable) {
	   // I dont think this was  needed. This was just a placeholder/empty class, however it is redundant since any code using pcmPlayer also has nullchecks.
	   // After testing, it appears that the hierarchy of the PCM classes can be removed just fine.
       //     pcmPlayer = new PcmPlayerBase(8000);	        
	    }
	
	}

	public static PcmStreamMixer method1003(Signlink arg0) {
	    createPlayer(arg0);
	    PcmStreamMixer mixer = new PcmStreamMixer();
	    SoundSystem.setMixer(mixer);
	    return mixer;
	}

	public static PcmStreamMixer pcmStreamMixer;
	public static Decimator decimator;
	public static int areaSoundEffectVolume = 127;
	public static int currentSound = 0;
	public static int[] sound = new int[50];

	public static int[] soundVolume = new int[50];
	public static int[] soundDelay = new int[50];
	public static Effect[] effects = new Effect[50];
	public static int[] soundLocations = new int[50];

	public static void method989() {
	    if(pcmPlayer != null) {
	        pcmPlayer.method213();
	        pcmPlayer = null;
	    }
	}

	public static void method950(int soundId, int volume, int delay) {
	    if (SoundSystem.soundEffectVolume != 0 && volume != 0 && currentSound < 50) {
	        sound[currentSound] = soundId;
	        soundVolume[currentSound] = volume;
	        soundDelay[currentSound] = delay;
	        effects[currentSound] = null;
	        soundLocations[currentSound] = 0;
	        currentSound++;
	    }
	}

	public static int soundEffectVolume = 127;
	
	public static void processSounds() {
	    for(int index = 0; index < currentSound; index++) {
	        soundDelay[index]--;
	        if(soundDelay[index] < -10) {
	            currentSound--;
	            for(int j = index; currentSound > j; j++) {
	                sound[j] = sound[j + 1];
	                effects[j] = effects[1 + j];
	                soundVolume[j] = soundVolume[1 + j];
	                soundDelay[j] = soundDelay[1 + j];
	                soundLocations[j] = soundLocations[1 + j];
	            }
	            index--;
	        } else {
	            Effect effect = effects[index];
	            if(effect == null) {
	                effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, sound[index], 0);
	                if(effect == null)
	                    continue;
	                soundDelay[index] += effect.delay();
	                effects[index] = effect;
	            }
	            if(soundDelay[index] < 0) {
	                int i_10_;
	                if(soundLocations[index] != 0) {
	                    int i_11_ = 128 * (soundLocations[index] & 0xff);
	                    int i_12_ = 0xff & soundLocations[index] >> 16;
	                    int i_13_ = (soundLocations[index] & 0xffb8) >> 8;
	                    int i_14_ = i_13_ * 128 + 64 + -Player.localPlayer.worldY;
	                    int i_15_ = i_12_ * 128 + 64 - Player.localPlayer.worldX;
	                    if(i_15_ < 0)
	                        i_15_ = -i_15_;
	                    if(i_14_ < 0)
	                        i_14_ = -i_14_;
	                    int i_16_ = -128 + i_15_ + i_14_;
	                    if(i_16_ > i_11_) {
	                        soundDelay[index] = -100;
	                        continue;
	                    }
	                    if(i_16_ < 0)
	                        i_16_ = 0;
	                    i_10_ = (i_11_ + -i_16_) * areaSoundEffectVolume / i_11_;
	                } else
	                    i_10_ = soundEffectVolume;
	                RawSound class40_sub12_sub1 = effect.method428().resample(decimator);
	                RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_10_);
	                class40_sub9_sub2.setNumLoops(-1 + soundVolume[index]);
	                pcmStreamMixer.addSubStream(class40_sub9_sub2);
	                soundDelay[index] = -100;
	            }
	        }
	    }
	}
	public static synchronized void setMixer(PcmStream arg0) {
	    pcmStream = arg0;
	}

	public static LinkedList objectSounds = new LinkedList();

	public static void setObjectSounds() {
	    for (ObjectSound class40_sub2 = (ObjectSound) objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) objectSounds.method909(-4)) {
	        if (class40_sub2.gameObjectDefinition != null) {
	            class40_sub2.set();
	        }
	    }
	}

	public static void addObjectSounds(int arg0, int arg2, int arg3, int arg4, GameObjectDefinition arg5) {
	    ObjectSound class40_sub2 = new ObjectSound();
	    class40_sub2.anInt2000 = 128 * arg5.anInt2502;
	    class40_sub2.anInt2002 = arg5.anInt2542;
	    class40_sub2.soundEffectIds = arg5.soundEffectIds;
	    class40_sub2.anInt2012 = arg5.anInt2499;
	    int i = arg5.sizeX;
	    int i_17_ = arg5.sizeY;
	    class40_sub2.plane = arg2;
	    class40_sub2.anInt1994 = arg4 * 128;
	    if(arg3 == 1 || arg3 == 3) {
	        i = arg5.sizeY;
	        i_17_ = arg5.sizeX;
	    }
	    class40_sub2.anInt2003 = 128 * arg0;
	    class40_sub2.anInt2007 = (i_17_ + arg0) * 128;
	    class40_sub2.anInt2013 = (arg4 + i) * 128;
	    class40_sub2.soundEffectId = arg5.ambientSoundId;
	    if(arg5.childIds != null) {
	        class40_sub2.gameObjectDefinition = arg5;
	        class40_sub2.set();
	    }
	    objectSounds.pushBack(class40_sub2, -126);
	    if(class40_sub2.soundEffectIds != null)
	        class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
	}

	public static void clearObjectSounds() {
	    for(ObjectSound class40_sub2 = (ObjectSound) objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) objectSounds.method909(-4)) {
	        if(class40_sub2.stream1 != null) {
	            pcmStreamMixer.removeSubStream(class40_sub2.stream1);
	            class40_sub2.stream1 = null;
	        }
	        if(class40_sub2.stream2 != null) {
	            pcmStreamMixer.removeSubStream(class40_sub2.stream2);
	            class40_sub2.stream2 = null;
	        }
	    }
	    objectSounds.clear(0);
	}

	public static void updateObjectSounds(int pwx, int pwl, int arg3, int pwy) {
	    for(ObjectSound class40_sub2 = (ObjectSound) objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) objectSounds.method909(-4)) {
	        if(class40_sub2.soundEffectId != -1 || class40_sub2.soundEffectIds != null) {
	            int i_48_ = 0;
	            if(pwx <= class40_sub2.anInt2013) {
	                if(pwx < class40_sub2.anInt1994)
	                    i_48_ += class40_sub2.anInt1994 - pwx;
	            } else
	                i_48_ += -class40_sub2.anInt2013 + pwx;
	            if(pwy > class40_sub2.anInt2007)
	                i_48_ += -class40_sub2.anInt2007 + pwy;
	            else if(pwy < class40_sub2.anInt2003)
	                i_48_ += -pwy + class40_sub2.anInt2003;
	            if(class40_sub2.anInt2000 < -64 + i_48_ || areaSoundEffectVolume == 0 || pwl != class40_sub2.plane) {
	                if(class40_sub2.stream1 != null) {
	                    pcmStreamMixer.removeSubStream(class40_sub2.stream1);
	                    class40_sub2.stream1 = null;
	                }
	                if(class40_sub2.stream2 != null) {
	                    pcmStreamMixer.removeSubStream(class40_sub2.stream2);
	                    class40_sub2.stream2 = null;
	                }
	            } else {
	                i_48_ -= 64;
	                if(i_48_ < 0)
	                    i_48_ = 0;
	                int i_49_ = (-i_48_ + class40_sub2.anInt2000) * areaSoundEffectVolume / class40_sub2.anInt2000;
	                if(class40_sub2.stream1 == null) {
	                    if(class40_sub2.soundEffectId >= 0) {
	                        Effect effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, class40_sub2.soundEffectId, 0);
	                        if(effect != null) {
	                            RawSound class40_sub12_sub1 = effect.method428().resample(decimator);
	                            RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
	                            class40_sub9_sub2.setNumLoops(-1);
	                            pcmStreamMixer.addSubStream(class40_sub9_sub2);
	                            class40_sub2.stream1 = class40_sub9_sub2;
	                        }
	                    }
	                } else
	                    class40_sub2.stream1.method857(i_49_);
	                if(class40_sub2.stream2 == null) {
	                    if(class40_sub2.soundEffectIds != null && (class40_sub2.anInt2014 -= arg3) <= 0) {
	                        int i_50_ = (int) ((double) class40_sub2.soundEffectIds.length * Math.random());
	                        Effect effect = Effect.readSoundEffect(CacheArchive.soundEffectCacheArchive, class40_sub2.soundEffectIds[i_50_], 0);
	                        if(effect != null) {
	                            RawSound class40_sub12_sub1 = effect.method428().resample(decimator);
	                            RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
	                            class40_sub9_sub2.setNumLoops(0);
	                            pcmStreamMixer.addSubStream(class40_sub9_sub2);
	                            class40_sub2.anInt2014 = class40_sub2.anInt2012 + (int) ((double) (-class40_sub2.anInt2012 + class40_sub2.anInt2002) * Math.random());
	                            class40_sub2.stream2 = class40_sub9_sub2;
	                        }
	                    }
	                } else {
	                    class40_sub2.stream2.method857(i_49_);
	                    if(!class40_sub2.stream2.hasNext())
	                        class40_sub2.stream2 = null;
	                }
	            }
	        }
	    }
	}

}
