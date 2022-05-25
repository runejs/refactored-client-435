package org.runejs.client.sound;

import org.runejs.client.LinkedList;
import org.runejs.client.audio.Effect;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.node.NodeCache;
import org.runejs.client.util.Signlink;

public class StaticAudio {

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
	    if(StaticAudio.pcmPlayer != null) {
	        long l = System.currentTimeMillis();
	        if(StaticAudio.aLong288 < l) {
	            StaticAudio.pcmPlayer.method212(l);
	            int i = (int) (-StaticAudio.aLong288 + l);
	            StaticAudio.aLong288 = l;
	            //TODO synchronized(StaticAudio.aClass1654 != null ? StaticAudio.aClass1654 : (StaticAudio.aClass1654 = method1058("org.runejs.client.sound.PcmPlayerBase"))) {
	            synchronized(lock) {
	                StaticAudio.anInt2081 += sampleRate * i;
	                int i_0_ = (-(2000 * sampleRate) + StaticAudio.anInt2081) / 1000;
	                if(i_0_ > 0) {
	                    if(StaticAudio.pcmStream != null)
	                        StaticAudio.pcmStream.skip(i_0_);
	                    StaticAudio.anInt2081 -= i_0_ * 1000;
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
	    for(StaticAudio.anInt2866 += arg1; StaticAudio.anInt2866 >= sampleRate; StaticAudio.anInt2866 -= sampleRate) {
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
	    StaticAudio.setMixer(mixer);
	    return mixer;
	}

	public static PcmStreamMixer pcmStreamMixer;
	public static Decimator decimator;
	public static NodeCache musicCache;

	public static byte[] fetchMusic(int arg0, CacheArchive arg1, int arg2, int arg4) {
	    long l = (long) (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << 32) + (long) (arg2 << 16);
	    if(musicCache != null) {
	        ByteArrayNode class40_sub5_sub6 = (ByteArrayNode) musicCache.get(l);
	        if(class40_sub5_sub6 != null)
	            return class40_sub5_sub6.byteArray;
	    }
	    byte[] is = arg1.getFile(arg2, arg0);
	    if(is == null)
	        return null;
	    if(musicCache != null)
	        musicCache.put(l, new ByteArrayNode(is));
	    return is;
	}

	public static int areaSoundEffectVolume = 127;
	public static int currentSound = 0;
	public static int[] sound = new int[50];

	public static synchronized void method402(boolean arg0) {
	    if(StaticAudio.method340()) {
	        StaticAudio.method308();
	        StaticAudio.aBoolean618 = arg0;
	        StaticAudio.musicCacheArchive = null;
	    }
	}

	public static synchronized void method403(int arg0, boolean arg1, int arg2, int songId, CacheArchive cacheArchive, int arg5, int arg6, boolean arg7) {
	    if(StaticAudio.method340()) {
	        StaticAudio.aBoolean1790 = arg7;
	        StaticAudio.anInt255 = arg2;
	        StaticAudio.anInt3004 = arg5;
	        StaticAudio.aBoolean618 = arg1;
	        StaticAudio.musicCacheArchive = cacheArchive;
	        StaticAudio.anInt1806 = -1;
	        StaticAudio.anInt2342 = arg0;
	        StaticAudio.anInt2110 = arg6;
	        StaticAudio.anInt289 = songId;
	    }
	}

	public static synchronized void method412(boolean arg0, CacheArchive arg1, int arg2, String arg4, int arg5, String arg6, int arg7) {
	    if(StaticAudio.method340()) {
	        int i = arg1.getHash(arg4);
	        int i_16_ = arg1.method179(i, arg6);
	        method403(arg7, true, arg5, i, arg1, i_16_, arg2, arg0);
	    }
	}

	public static synchronized void handleMusic() {
	    if(StaticAudio.method340()) {
	        if(StaticAudio.aBoolean618) {
	            byte[] is = fetchMusic(StaticAudio.anInt3004, StaticAudio.musicCacheArchive, StaticAudio.anInt289, StaticAudio.anInt2110);
	            if(is != null) {
	                if(StaticAudio.anInt255 < 0) {
	                    if(StaticAudio.anInt1806 < 0)
	                        StaticAudio.method56(StaticAudio.aBoolean1790, is, StaticAudio.anInt2342);
	                    else
	                        StaticAudio.method566(StaticAudio.anInt2342, StaticAudio.aBoolean1790, StaticAudio.anInt1806, is);
	                } else
	                    StaticAudio.method886(0, StaticAudio.anInt2342, StaticAudio.aBoolean1790, is, StaticAudio.anInt255);
	                StaticAudio.aBoolean618 = false;
	                StaticAudio.musicCacheArchive = null;
	            }
	        }
	        StaticAudio.method984(0);
	    }
	}

	public static boolean initialiseMusic(int size) {
	    if (!StaticAudio.musicPlayerStarted())
	        return false;
	    if (size > 0)
	        musicCache = new NodeCache(size);
	    return true;
	}

	public static synchronized void method405(int arg1) {
	    if(StaticAudio.method340()) {
	        StaticAudio.method557(arg1);
	        StaticAudio.musicCacheArchive = null;
	        StaticAudio.aBoolean618 = false;
	    }
	}

	public static int songTimeout = 0;
	public static int currentSongId = -1;
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

	public static void playSoundJingle(int songTimeout, int songId) {
	    if(StaticAudio.musicVolume != 0 && songId != -1) {
	        StaticAudio.playMusicTrack(false, 1, songId, StaticAudio.musicVolume, 0, CacheArchive.jingleCacheArchive);
	        StaticAudio.songTimeout = songTimeout;
	    }
	}

	public static synchronized void playMusicTrack(boolean arg0, int arg1, int songid, int arg3, int arg4, CacheArchive arg5) {
	    if(StaticAudio.method340()) {
	        StaticAudio.aBoolean618 = true;
	        StaticAudio.anInt1806 = -1;
	        StaticAudio.anInt255 = -1;
	        StaticAudio.anInt2342 = arg3;
	        StaticAudio.anInt3004 = arg4;
	        StaticAudio.aBoolean1790 = arg0;
	        StaticAudio.anInt2110 = arg1;
	        StaticAudio.musicCacheArchive = arg5;
	        StaticAudio.anInt289 = songid;
	    }
	}

	public static void playSong(int songId) {
	    if(songId == -1 && songTimeout == 0)
	        method402(false);
	    else if(songId != -1 && songId != currentSongId && StaticAudio.musicVolume != 0 && songTimeout == 0)
	        method403(StaticAudio.musicVolume, true, 10, songId, CacheArchive.musicCacheArchive, 0, 0, false);
	    currentSongId = songId;
	}

	public static void method950(int soundId, int volume, int delay) {
	    if (StaticAudio.soundEffectVolume != 0 && volume != 0 && currentSound < 50) {
	        sound[currentSound] = soundId;
	        soundVolume[currentSound] = volume;
	        soundDelay[currentSound] = delay;
	        effects[currentSound] = null;
	        soundLocations[currentSound] = 0;
	        currentSound++;
	    }
	}

	public static CacheArchive musicCacheArchive;
	public static MidiPlayer midi;

	public static void method886(int arg0, int arg1, boolean arg2, byte[] arg3, int arg4) {
	    if(arg0 == 0 && midi != null) {
	        if(StaticAudio.anInt1450 < 0) {
	            if(StaticAudio.anInt54 != 0) {
	                StaticAudio.anInt2258 = arg1;
	                StaticAudio.aByteArray3270 = arg3;
	                StaticAudio.aBoolean687 = arg2;
	            } else
	                StaticAudio.method56(arg2, arg3, arg1);
	        } else {
	            Buffer.anInt1982 = arg4;
	            if(StaticAudio.anInt1450 != 0) {
	                int i = StaticAudio.method372(StaticAudio.anInt1450);
	                i -= StaticAudio.anInt909;
	                StaticAudio.anInt54 = (i + 3600) / arg4;
	                if(StaticAudio.anInt54 < 1)
	                    StaticAudio.anInt54 = 1;
	            } else
	                StaticAudio.anInt54 = 1;
	            StaticAudio.anInt2258 = arg1;
	            StaticAudio.aByteArray3270 = arg3;
	            StaticAudio.aBoolean687 = arg2;
	        }
	    }
	}

	public static void method651(int arg0, int arg1) {
	    if(midi != null) {
	        if(StaticAudio.anInt54 != 0) {
	            if(StaticAudio.aByteArray3270 != null)
	                StaticAudio.anInt2258 = arg1;
	        } else if(StaticAudio.anInt1450 >= 0) {
	            StaticAudio.anInt1450 = arg1;
	            midi.setVolume(arg1, 0);
	        }
	    }
	}

	public static void method1019() {
	    if(midi != null) {
	        StaticAudio.method308();   
	        if(StaticAudio.anInt54 > 0) {
	            midi.resetVolume(256);
	            StaticAudio.anInt54 = 0;
	        }
	        midi.close0((byte) 101);
	        midi = null;
	    }
	}

	public static void method984(int arg0) {
	    if(arg0 == 0) {
	        if(midi != null) {
	            if(StaticAudio.anInt1450 >= 0) {
	                if(StaticAudio.anInt54 > 0) {
	                    StaticAudio.anInt909 += Buffer.anInt1982;
	                    midi.setVolume(StaticAudio.anInt1450, StaticAudio.anInt909);
	                    StaticAudio.anInt54--;
	                    if(StaticAudio.anInt54 == 0) {
	                        midi.stop0();
	                        StaticAudio.anInt1450 = -1;
	                        StaticAudio.anInt54 = 20;
	                    }
	                }
	            } else if(StaticAudio.anInt54 > 0) {
	                StaticAudio.anInt54--;
	                if(StaticAudio.anInt54 == 0) {
	                    if(StaticAudio.aByteArray3270 == null)
	                        midi.resetVolume(256);
	                    else {
	                        midi.resetVolume(StaticAudio.anInt2258);
	                        StaticAudio.anInt1450 = StaticAudio.anInt2258;
	                        midi.play(StaticAudio.aByteArray3270, StaticAudio.aBoolean687, StaticAudio.anInt2258);
	                        StaticAudio.aByteArray3270 = null;
	                    }
	                    StaticAudio.anInt909 = 0;
	                }
	            }
	        }
	    }
	}

	public static boolean musicPlayerStarted() {
	        StaticAudio.anInt54 = 20;
	        try {
	            midi = new MidiPlayer();
	            return true;
	        } catch(Throwable throwable) {
	            return false;
	        }
	    }

	public static int anInt1450 = -1;

	public static void method566(int arg0, boolean arg1, int arg2, byte[] arg3) {
	    if(midi != null) {
	        if(anInt1450 >= 0) {
	            arg2 -= 20;
	            if(arg2 < 1)
	                arg2 = 1;
	            StaticAudio.anInt54 = arg2;
	            if(anInt1450 == 0)
	                Buffer.anInt1982 = 0;
	            else {
	                int i = StaticAudio.method372(anInt1450);
	                i -= StaticAudio.anInt909;
	                Buffer.anInt1982 = (-1 + arg2 + 3600 + i) / arg2;
	            }
	            StaticAudio.aByteArray3270 = arg3;
	            StaticAudio.anInt2258 = arg0;
	            StaticAudio.aBoolean687 = arg1;
	        } else if(StaticAudio.anInt54 == 0)
	            StaticAudio.method56(arg1, arg3, arg0);
	        else {
	            StaticAudio.anInt2258 = arg0;
	            StaticAudio.aBoolean687 = arg1;
	            StaticAudio.aByteArray3270 = arg3;
	        }
	    }
	}

	public static boolean method340() {
	    return midi != null;
	
	}

	public static int method372(int arg1) {
	    return (int) (0.5 + Math.log(0.00390625 * (double) arg1) * 868.5889638065036);
	}

	public static int musicVolume = 255;
	public static int soundEffectVolume = 127;
	public static boolean aBoolean618 = false;
	public static int anInt2342;

	public static void method456(int arg0) {
	    if (method340()) {
	        if (aBoolean618)
	            anInt2342 = arg0;
	        else
	            method651(22741, arg0);
	    }
	}

	public static int anInt909 = 0;

	public static void method56(boolean loop, byte[] arg2, int arg3) {
	    if(midi != null) {
	        if(anInt1450 >= 0) {
	            midi.stop0();
	            anInt909 = 0;
	            StaticAudio.aByteArray3270 = null;
	            StaticAudio.anInt54 = 20;
	            anInt1450 = -1;
	        }
	        if(arg2 != null) {
	            if(StaticAudio.anInt54 > 0) {
	                midi.resetVolume(arg3);
	                StaticAudio.anInt54 = 0;
	            }
	            anInt1450 = arg3;
	            midi.play(arg2, loop, arg3);
	        }
	    }
	}

	public static int anInt255;
	public static int anInt3004;
	public static int anInt289;
	public static int anInt1806;
	public static int anInt2110;

	public static void method308() {
	    method56(false, null, 0);
	}

	public static void method557(int arg0) {
	    method886(0, 0, false, null, arg0);
	}

	public static int anInt54 = 0;
	public static int anInt2258;
	public static byte[] aByteArray3270;
	public static boolean aBoolean687;
	public static boolean aBoolean1790;

	public static void processAudio() {
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
	    if(songTimeout > 0) {
	        songTimeout -= 20;
	        if(songTimeout < 0)
	            songTimeout = 0;
	        if(songTimeout == 0 && musicVolume != 0 && currentSongId != -1)
	            playMusicTrack(false, 0, currentSongId, musicVolume, 0, CacheArchive.musicCacheArchive);
	    }
	}

	public static void updateObjectSounds(int pwx, int pwl, int arg3, int pwy) {
	    for(ObjectSound class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method909(-4)) {
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

	public static void clearObjectSounds() {
	    for(ObjectSound class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method909(-4)) {
	        if(class40_sub2.stream1 != null) {
	            pcmStreamMixer.removeSubStream(class40_sub2.stream1);
	            class40_sub2.stream1 = null;
	        }
	        if(class40_sub2.stream2 != null) {
	            pcmStreamMixer.removeSubStream(class40_sub2.stream2);
	            class40_sub2.stream2 = null;
	        }
	    }
	    StaticAudio.objectSounds.clear(0);
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
	    StaticAudio.objectSounds.pushBack(class40_sub2, -126);
	    if(class40_sub2.soundEffectIds != null)
	        class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
	}

	public static void setObjectSounds() {
	    for (ObjectSound class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method902((byte) -90); class40_sub2 != null; class40_sub2 = (ObjectSound) StaticAudio.objectSounds.method909(-4)) {
	        if (class40_sub2.gameObjectDefinition != null) {
	            class40_sub2.set();
	        }
	    }
	}

	public static LinkedList objectSounds = new LinkedList();

	public static synchronized void setMixer(PcmStream arg0) {
	    pcmStream = arg0;
	}

}
