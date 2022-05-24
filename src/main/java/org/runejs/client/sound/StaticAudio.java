package org.runejs.client.sound;

import java.awt.Component;

import org.runejs.client.Class22;
import org.runejs.client.Class22_Sub1;
import org.runejs.client.Class24;
import org.runejs.client.Class26;
import org.runejs.client.Class33;
import org.runejs.client.Class35;
import org.runejs.client.Class37;
import org.runejs.client.Class39;
import org.runejs.client.Class44;
import org.runejs.client.Class59;
import org.runejs.client.Landscape;
import org.runejs.client.LinkedList;
import org.runejs.client.Main;
import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer;
import org.runejs.client.Projectile;
import org.runejs.client.RSCanvas;
import org.runejs.client.RSString;
import org.runejs.client.audio.Effect;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.GameObjectDefinition;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.ISAAC;
import org.runejs.client.node.NodeCache;
import org.runejs.client.util.Signlink;

public class StaticAudio {

	public static int sampleRate;

	/*synthetic*/
	public static Class method1058(String arg0) {
	    try {
	        return Class.forName(arg0);
	    } catch(ClassNotFoundException classnotfoundexception) {
	        throw new NoClassDefFoundError(classnotfoundexception.getMessage());
	    }
	}

	public static void handleSounds() {
	    if(StaticAudio.aClass8_166 != null) {
	        long l = System.currentTimeMillis();
	        if(StaticAudio.aLong288 < l) {
	            StaticAudio.aClass8_166.method212(l);
	            int i = (int) (-StaticAudio.aLong288 + l);
	            StaticAudio.aLong288 = l;
	            synchronized(StaticAudio.aClass1654 != null ? StaticAudio.aClass1654 : (StaticAudio.aClass1654 = method1058("org.runejs.client.sound.Class8"))) {
	                StaticAudio.anInt2081 += sampleRate * i;
	                int i_0_ = (-(2000 * sampleRate) + StaticAudio.anInt2081) / 1000;
	                if(i_0_ > 0) {
	                    if(StaticAudio.aPcmStream_608 != null)
	                        StaticAudio.aPcmStream_608.skip(i_0_);
	                    StaticAudio.anInt2081 -= i_0_ * 1000;
	                }
	            }
	        }
	    }
	}

	public static PcmStream aPcmStream_608;
	public static long aLong288;
	public static Class8 aClass8_166;
	/*synthetic*/ public static Class aClass1654;
	//TODO replace class/synchronized with: public static Object lock = new Object();
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

	public static void method1040(Component arg0, int arg1, Signlink arg2) {
	    try {    	
	        Class8_Sub1 class8_sub1 = new Class8_Sub1_Sub2();
	        class8_sub1.method222(arg2, 2048);
	        aClass8_166 = class8_sub1;        
	    } catch (Throwable throwable) {
            aClass8_166 = new Class8(8000);	        
	    }
	
	}

	public static PcmStreamMixer method1003(Signlink arg0, Component arg1) {
	    method1040(arg1, 0, arg0);
	    PcmStreamMixer class40_sub9_sub1 = new PcmStreamMixer();
	    Class8.method218(class40_sub9_sub1);
	    return class40_sub9_sub1;
	
	}

	public static PcmStreamMixer aPcmStreamMixer_1152;
	public static LinkedList aLinkedList_2268 = new LinkedList();

	public static void addObjectSounds(int arg0, boolean arg1, int arg2, int arg3, int arg4, GameObjectDefinition arg5) {
	    Class40_Sub2 class40_sub2 = new Class40_Sub2();
	    class40_sub2.anInt2000 = 128 * arg5.anInt2502;
	    if(!arg1)
	        Class37.method438(119, -54);
	    class40_sub2.anInt2002 = arg5.anInt2542;
	    class40_sub2.anIntArray2005 = arg5.anIntArray2523;
	    class40_sub2.anInt2012 = arg5.anInt2499;
	    int i = arg5.sizeX;
	    int i_17_ = arg5.sizeY;
	    class40_sub2.anInt1993 = arg2;
	    class40_sub2.anInt1994 = arg4 * 128;
	    if(arg3 == 1 || arg3 == 3) {
	        i = arg5.sizeY;
	        i_17_ = arg5.sizeX;
	    }
	    class40_sub2.anInt2003 = 128 * arg0;
	    class40_sub2.anInt2007 = (i_17_ + arg0) * 128;
	    class40_sub2.anInt2013 = (arg4 + i) * 128;
	    class40_sub2.anInt1997 = arg5.ambientSoundId;
	    if(arg5.childIds != null) {
	        class40_sub2.gameObjectDefinition = arg5;
	        class40_sub2.method528();
	    }
	    aLinkedList_2268.pushBack(class40_sub2, -126);
	    if(class40_sub2.anIntArray2005 != null)
	        class40_sub2.anInt2014 = (int) ((double) (class40_sub2.anInt2002 - class40_sub2.anInt2012) * Math.random()) + class40_sub2.anInt2012;
	}

	public static void method436() {
	    for(Class40_Sub2 class40_sub2 = (Class40_Sub2) aLinkedList_2268.method902((byte) -90); class40_sub2 != null; class40_sub2 = (Class40_Sub2) aLinkedList_2268.method909(-4)) {
	        if(class40_sub2.aRawPcmStream_2001 != null) {
	            aPcmStreamMixer_1152.method853(class40_sub2.aRawPcmStream_2001);
	            class40_sub2.aRawPcmStream_2001 = null;
	        }
	        if(class40_sub2.aRawPcmStream_2010 != null) {
	            aPcmStreamMixer_1152.method853(class40_sub2.aRawPcmStream_2010);
	            class40_sub2.aRawPcmStream_2010 = null;
	        }
	    }
	    aLinkedList_2268.method906(0);
	}

	public static void method934(int arg0, int arg2, int arg3, int arg4) {
	    for(Class40_Sub2 class40_sub2 = (Class40_Sub2) aLinkedList_2268.method902((byte) -90); class40_sub2 != null; class40_sub2 = (Class40_Sub2) aLinkedList_2268.method909(-4)) {
	        if(class40_sub2.anInt1997 != -1 || class40_sub2.anIntArray2005 != null) {
	            int i_48_ = 0;
	            if(arg0 <= class40_sub2.anInt2013) {
	                if(arg0 < class40_sub2.anInt1994)
	                    i_48_ += class40_sub2.anInt1994 - arg0;
	            } else
	                i_48_ += -class40_sub2.anInt2013 + arg0;
	            if(arg4 > class40_sub2.anInt2007)
	                i_48_ += -class40_sub2.anInt2007 + arg4;
	            else if(arg4 < class40_sub2.anInt2003)
	                i_48_ += -arg4 + class40_sub2.anInt2003;
	            if(class40_sub2.anInt2000 < -64 + i_48_ || StaticAudio.soundEffectVolume == 0 || arg2 != class40_sub2.anInt1993) {
	                if(class40_sub2.aRawPcmStream_2001 != null) {
	                    aPcmStreamMixer_1152.method853(class40_sub2.aRawPcmStream_2001);
	                    class40_sub2.aRawPcmStream_2001 = null;
	                }
	                if(class40_sub2.aRawPcmStream_2010 != null) {
	                    aPcmStreamMixer_1152.method853(class40_sub2.aRawPcmStream_2010);
	                    class40_sub2.aRawPcmStream_2010 = null;
	                }
	            } else {
	                i_48_ -= 64;
	                if(i_48_ < 0)
	                    i_48_ = 0;
	                int i_49_ = (-i_48_ + class40_sub2.anInt2000) * StaticAudio.soundEffectVolume / class40_sub2.anInt2000;
	                if(class40_sub2.aRawPcmStream_2001 == null) {
	                    if(class40_sub2.anInt1997 >= 0) {
	                        Effect effect = Effect.method429(CacheArchive.soundEffectCacheArchive, class40_sub2.anInt1997, 0);
	                        if(effect != null) {
	                            RawSound class40_sub12_sub1 = effect.method428().resample(StaticAudio.aDecimator_1289);
	                            RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
	                            class40_sub9_sub2.method860(-1);
	                            aPcmStreamMixer_1152.method846(class40_sub9_sub2);
	                            class40_sub2.aRawPcmStream_2001 = class40_sub9_sub2;
	                        }
	                    }
	                } else
	                    class40_sub2.aRawPcmStream_2001.method857(i_49_);
	                if(class40_sub2.aRawPcmStream_2010 == null) {
	                    if(class40_sub2.anIntArray2005 != null && (class40_sub2.anInt2014 -= arg3) <= 0) {
	                        int i_50_ = (int) ((double) class40_sub2.anIntArray2005.length * Math.random());
	                        Effect effect = Effect.method429(CacheArchive.soundEffectCacheArchive, class40_sub2.anIntArray2005[i_50_], 0);
	                        if(effect != null) {
	                            RawSound class40_sub12_sub1 = effect.method428().resample(StaticAudio.aDecimator_1289);
	                            RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_49_);
	                            class40_sub9_sub2.method860(0);
	                            aPcmStreamMixer_1152.method846(class40_sub9_sub2);
	                            class40_sub2.anInt2014 = class40_sub2.anInt2012 + (int) ((double) (-class40_sub2.anInt2012 + class40_sub2.anInt2002) * Math.random());
	                            class40_sub2.aRawPcmStream_2010 = class40_sub9_sub2;
	                        }
	                    }
	                } else {
	                    class40_sub2.aRawPcmStream_2010.method857(i_49_);
	                    if(!class40_sub2.aRawPcmStream_2010.method863())
	                        class40_sub2.aRawPcmStream_2010 = null;
	                }
	            }
	        }
	    }
	}

	public static void method1030() {
	    for (Class40_Sub2 class40_sub2 = (Class40_Sub2) aLinkedList_2268.method902((byte) -90); class40_sub2 != null; class40_sub2 = (Class40_Sub2) aLinkedList_2268.method909(-4)) {
	        if (class40_sub2.gameObjectDefinition != null) {
	            class40_sub2.method528();
	        }
	    }
	}

	public static Decimator aDecimator_1289;
	public static NodeCache aClass9_1684;

	public static byte[] method74(int arg0, CacheArchive arg1, int arg2, int arg4) {
	    long l = (long) (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << 32) + (long) (arg2 << 16);
	    if(aClass9_1684 != null) {
	        Class40_Sub5_Sub6 class40_sub5_sub6 = (Class40_Sub5_Sub6) aClass9_1684.get(l);
	        if(class40_sub5_sub6 != null)
	            return class40_sub5_sub6.aByteArray2441;
	    }
	    byte[] is = arg1.getFile(arg2, arg0);
	    if(is == null)
	        return null;
	    if(aClass9_1684 != null)
	        aClass9_1684.put(l, new Class40_Sub5_Sub6(is));
	    return is;
	}

	public static int soundEffectVolume = 127;
	public static int currentSound = 0;
	public static int[] sound = new int[50];

	public static synchronized void method402(boolean arg0) {
	    if(Class24.method340()) {
	        Class22.method308();
	        Class26.aBoolean618 = arg0;
	        Class22_Sub1.musicCacheArchive = null;
	    }
	}

	public static synchronized void method403(int arg0, boolean arg1, int arg2, int songId, CacheArchive cacheArchive, int arg5, int arg6, boolean arg7) {
	    if(Class24.method340()) {
	        Main.aBoolean1790 = arg7;
	        MovedStatics.anInt255 = arg2;
	        Projectile.anInt3004 = arg5;
	        Class26.aBoolean618 = arg1;
	        Class22_Sub1.musicCacheArchive = cacheArchive;
	        MovedStatics.anInt1806 = -1;
	        OverlayDefinition.anInt2342 = arg0;
	        MovedStatics.anInt2110 = arg6;
	        MovedStatics.anInt289 = songId;
	    }
	}

	public static synchronized void method412(boolean arg0, CacheArchive arg1, int arg2, String arg4, int arg5, String arg6, int arg7) {
	    if(Class24.method340()) {
	        int i = arg1.getHash(arg4);
	        int i_16_ = arg1.method179(i, arg6);
	        method403(arg7, true, arg5, i, arg1, i_16_, arg2, arg0);
	    }
	}

	public static synchronized void handleMusic() {
	    if(Class24.method340()) {
	        if(Class26.aBoolean618) {
	            byte[] is = method74(Projectile.anInt3004, Class22_Sub1.musicCacheArchive, MovedStatics.anInt289, MovedStatics.anInt2110);
	            if(is != null) {
	                if(MovedStatics.anInt255 < 0) {
	                    if(MovedStatics.anInt1806 < 0)
	                        RSString.method56(Main.aBoolean1790, is, OverlayDefinition.anInt2342);
	                    else
	                        Class33.method566(OverlayDefinition.anInt2342, Main.aBoolean1790, MovedStatics.anInt1806, is);
	                } else
	                    MovedStatics.method886(0, OverlayDefinition.anInt2342, Main.aBoolean1790, is, MovedStatics.anInt255);
	                Class26.aBoolean618 = false;
	                Class22_Sub1.musicCacheArchive = null;
	            }
	        }
	        Class59.method984(0);
	    }
	}

	public static void method450(byte arg0) {
	    if (Player.headIconDrawType == 2) {
	        if (arg0 >= -28)
	            MovedStatics.method445(-128);
	        Class22_Sub1.method312(2 * ActorDefinition.anInt2404, Class35.anInt1730 + (-Class26.baseY + MovedStatics.anInt175 << 7), (ProducingGraphicsBuffer.anInt1637 + -MovedStatics.baseX << 7) + Landscape.anInt1170, 4976905);
	        if (ISAAC.anInt522 > -1 && MovedStatics.pulseCycle % 20 < 10)
	            MovedStatics.aClass40_Sub5_Sub14_Sub4Array2567[0].drawImage(ISAAC.anInt522 + -12, -28 + Class44.anInt1048);
	    }
	}

	public static boolean method446(Signlink arg0, int arg1, boolean arg2) {
	    if (!Class39.method452(arg0, arg2))
	        return false;
	    if (arg1 > 0)
	        aClass9_1684 = new NodeCache(arg1);
	    return true;
	}

	public static synchronized void method405(int arg1) {
	    if(Class24.method340()) {
	        MovedStatics.method557(arg1);
	        Class22_Sub1.musicCacheArchive = null;
	        Class26.aBoolean618 = false;
	    }
	}

	public static int songTimeout = 0;
	public static int currentSongId = -1;
	public static int[] soundVolume = new int[50];
	public static int[] soundDelay = new int[50];
	public static Effect[] effects = new Effect[50];
	public static int[] anIntArray1916 = new int[50];

	public static void method989() {
	    if(aClass8_166 != null) {
	        aClass8_166.method213();
	        aClass8_166 = null;
	    }
	}

	public static void method975(int songTimeout, int songId) {
	    if(RSCanvas.musicVolume != 0 && songId != -1) {
	        StaticAudio.method414(false, 1, songId, RSCanvas.musicVolume, 0, CacheArchive.jingleCacheArchive);
	        songTimeout = songTimeout;
	    }
	}

	public static synchronized void method414(boolean arg0, int arg1, int songid, int arg3, int arg4, CacheArchive arg5) {
	    if(Class24.method340()) {
	        Class26.aBoolean618 = true;
	        MovedStatics.anInt1806 = -1;
	        MovedStatics.anInt255 = -1;
	        OverlayDefinition.anInt2342 = arg3;
	        Projectile.anInt3004 = arg4;
	        Main.aBoolean1790 = arg0;
	        MovedStatics.anInt2110 = arg1;
	        Class22_Sub1.musicCacheArchive = arg5;
	        MovedStatics.anInt289 = songid;
	    }
	}

	public static void playSong(int songId) {
	    if(songId == -1 && songTimeout == 0)
	        method402(false);
	    else if(songId != -1 && songId != currentSongId && RSCanvas.musicVolume != 0 && songTimeout == 0)
	        method403(RSCanvas.musicVolume, true, 10, songId, CacheArchive.musicCacheArchive, 0, 0, false);
	    currentSongId = songId;
	}

	public static void method950(int soundId, int volume, int delay) {
	    if (MovedStatics.anInt200 != 0 && volume != 0 && currentSound < 50) {
	        sound[currentSound] = soundId;
	        soundVolume[currentSound] = volume;
	        soundDelay[currentSound] = delay;
	        effects[currentSound] = null;
	        anIntArray1916[currentSound] = 0;
	        currentSound++;
	    }
	}

}
