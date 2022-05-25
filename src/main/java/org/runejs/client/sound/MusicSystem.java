package org.runejs.client.sound;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.node.NodeCache;

public class MusicSystem {

	public static int currentSongId = -1;
	public static int musicVolume = 255;
	public static int songTimeout = 0;
	

	private static boolean aBoolean1790;
	private static int anInt1806;
	private static int anInt2110;
	private static int anInt2342;
	private static int anInt255;
	private static int anInt289;
	private static int anInt3004;
	private static byte[] data_;
	private static boolean fetchMusic = false;
	private static boolean loop_;
	private static MidiPlayer midi;
	private static NodeCache musicCache;
	private static CacheArchive musicFetcher;
	private static int timer = 0;
	private static int velocity = 0;
	private static int velocity_increment = 0;
	private static int volume1;
	private static int volume2 = -1;

	public static synchronized void handleMusic() {
		if (musicIsntNull()) {
			if (MusicSystem.fetchMusic) {
				byte[] is = fetchMusic(MusicSystem.anInt3004, MusicSystem.musicFetcher, MusicSystem.anInt289, MusicSystem.anInt2110);
				if (is != null) {
					if (MusicSystem.anInt255 < 0) {
						if (MusicSystem.anInt1806 < 0)
							method56(MusicSystem.aBoolean1790, is, MusicSystem.anInt2342);
						else
							method566(MusicSystem.anInt2342, MusicSystem.aBoolean1790, MusicSystem.anInt1806, is);
					} else
						method886(0, MusicSystem.anInt2342, MusicSystem.aBoolean1790, is, MusicSystem.anInt255);
					MusicSystem.fetchMusic = false;
					MusicSystem.musicFetcher = null;
				}
			}
			method984(0);
		}
	}

	public static boolean initialiseMusic(int size) {
		if (!musicPlayerStarted())
			return false;
		if (size > 0)
			MusicSystem.musicCache = new NodeCache(size);
		return true;
	}

	/**
	 * Called when setting volume to 0 or receiving a song of -1 via packet.
	 */
	public static synchronized void method402(boolean arg0) {
		if (musicIsntNull()) {
			MusicSystem.method308();
			MusicSystem.fetchMusic = arg0;
			MusicSystem.musicFetcher = null;
		}
	}

	public static synchronized void method405(int arg1) {
		if (musicIsntNull()) {
			MusicSystem.method557(arg1);
			MusicSystem.musicFetcher = null;
			MusicSystem.fetchMusic = false;
		}
	}

	public static synchronized void syncedStop(boolean arg0) {
		stop_();
	}

	public static synchronized void method412(boolean arg0, CacheArchive arg1, int arg2, String arg4, int arg5, String arg6, int arg7) {
		if (musicIsntNull()) {
			int i = arg1.getHash(arg4);
			int i_16_ = arg1.method179(i, arg6);
			method403(arg7, true, arg5, i, arg1, i_16_, arg2, arg0);
		}
	}

	public static void method456(int arg0) {
		if (MusicSystem.musicIsntNull()) {
			if (MusicSystem.fetchMusic)
				MusicSystem.anInt2342 = arg0;
			else
				MusicSystem.method651(22741, arg0);
		}
	}

	public static synchronized void playMusicTrack(boolean arg0, int arg1, int songid, int arg3, int arg4, CacheArchive arg5) {
		if (musicIsntNull()) {
			MusicSystem.fetchMusic = true;
			MusicSystem.anInt1806 = -1;
			MusicSystem.anInt255 = -1;
			MusicSystem.anInt2342 = arg3;
			MusicSystem.anInt3004 = arg4;
			MusicSystem.aBoolean1790 = arg0;
			MusicSystem.anInt2110 = arg1;
			MusicSystem.musicFetcher = arg5;
			MusicSystem.anInt289 = songid;
		}
	}

	public static void playSong(int songId) {
		if (songId == -1 && MusicSystem.songTimeout == 0)
			method402(false);
		else if (songId != -1 && songId != MusicSystem.currentSongId && MusicSystem.musicVolume != 0 && MusicSystem.songTimeout == 0)
			method403(MusicSystem.musicVolume, true, 10, songId, CacheArchive.musicCacheArchive, 0, 0, false);
		MusicSystem.currentSongId = songId;
	}

	public static void playSoundJingle(int songTimeout, int songId) {
		if (MusicSystem.musicVolume != 0 && songId != -1) {
			MusicSystem.playMusicTrack(false, 1, songId, MusicSystem.musicVolume, 0, CacheArchive.jingleCacheArchive);
			MusicSystem.songTimeout = songTimeout;
		}
	}

	public static void processMusic() {
		if (MusicSystem.songTimeout > 0) {
			MusicSystem.songTimeout -= 20;
			if (MusicSystem.songTimeout < 0)
				MusicSystem.songTimeout = 0;
			if (MusicSystem.songTimeout == 0 && MusicSystem.musicVolume != 0 && MusicSystem.currentSongId != -1)
				MusicSystem.playMusicTrack(false, 0, MusicSystem.currentSongId, MusicSystem.musicVolume, 0, CacheArchive.musicCacheArchive);
		}
	}

	static void stop_() {
		if (MusicSystem.midi != null) {
			method308();
			if (MusicSystem.timer > 0) {
				MusicSystem.midi.resetVolume(256);
				MusicSystem.timer = 0;
			}
			MusicSystem.midi.close0((byte) 101);
			MusicSystem.midi = null;
		}
	}
	
	private static byte[] fetchMusic(int arg0, CacheArchive arg1, int arg2, int arg4) {
		long l = (arg0 + 37 * arg2 & 0xffff) + ((long) arg4 << 32) + (arg2 << 16);
		if (MusicSystem.musicCache != null) {
			ByteArrayNode class40_sub5_sub6 = (ByteArrayNode) MusicSystem.musicCache.get(l);
			if (class40_sub5_sub6 != null)
				return class40_sub5_sub6.byteArray;
		}
		byte[] is = arg1.getFile(arg2, arg0);
		if (is == null)
			return null;
		if (MusicSystem.musicCache != null)
			MusicSystem.musicCache.put(l, new ByteArrayNode(is));
		return is;
	}

	private static void method308() {
		method56(false, null, 0);
	}

	private static int method372(int arg1) {
		return (int) (0.5 + Math.log(0.00390625 * arg1) * 868.5889638065036);
	}

	private static synchronized void method403(int arg0, boolean arg1, int arg2, int songId, CacheArchive cacheArchive, int arg5, int arg6, boolean arg7) {
		if (musicIsntNull()) {
			MusicSystem.aBoolean1790 = arg7;
			MusicSystem.anInt255 = arg2;
			MusicSystem.anInt3004 = arg5;
			MusicSystem.fetchMusic = arg1;
			MusicSystem.musicFetcher = cacheArchive;
			MusicSystem.anInt1806 = -1;
			MusicSystem.anInt2342 = arg0;
			MusicSystem.anInt2110 = arg6;
			MusicSystem.anInt289 = songId;
		}
	}

	private static void method557(int arg0) {
		method886(0, 0, false, null, arg0);
	}

	private static void method56(boolean loop, byte[] arg2, int arg3) {
		if (MusicSystem.midi != null) {
			if (MusicSystem.volume2 >= 0) {
				MusicSystem.midi.stop0();
				MusicSystem.velocity = 0;
				MusicSystem.data_ = null;
				MusicSystem.timer = 20;
				MusicSystem.volume2 = -1;
			}
			if (arg2 != null) {
				if (MusicSystem.timer > 0) {
					MusicSystem.midi.resetVolume(arg3);
					MusicSystem.timer = 0;
				}
				MusicSystem.volume2 = arg3;
				MusicSystem.midi.play(arg2, loop, arg3);
			}
		}
	}

	private static void method566(int arg0, boolean arg1, int arg2, byte[] arg3) {
		if (MusicSystem.midi != null) {
			if (MusicSystem.volume2 >= 0) {
				arg2 -= 20;
				if (arg2 < 1)
					arg2 = 1;
				MusicSystem.timer = arg2;
				if (MusicSystem.volume2 == 0)
					MusicSystem.velocity_increment = 0;
				else {
					int i = MusicSystem.method372(MusicSystem.volume2);
					i -= MusicSystem.velocity;
					MusicSystem.velocity_increment = (-1 + arg2 + 3600 + i) / arg2;
				}
				MusicSystem.data_ = arg3;
				MusicSystem.volume1 = arg0;
				MusicSystem.loop_ = arg1;
			} else if (MusicSystem.timer == 0)
				MusicSystem.method56(arg1, arg3, arg0);
			else {
				MusicSystem.volume1 = arg0;
				MusicSystem.loop_ = arg1;
				MusicSystem.data_ = arg3;
			}
		}
	}

	private static void method651(int arg0, int arg1) {
		if (MusicSystem.midi != null) {
			if (MusicSystem.timer != 0) {
				if (MusicSystem.data_ != null)
					MusicSystem.volume1 = arg1;
			} else if (MusicSystem.volume2 >= 0) {
				MusicSystem.volume2 = arg1;
				MusicSystem.midi.setVolume(arg1, 0);
			}
		}
	}

	private static void method886(int arg0, int arg1, boolean arg2, byte[] arg3, int arg4) {
		if (arg0 == 0 && MusicSystem.midi != null) {
			if (MusicSystem.volume2 < 0) {
				if (MusicSystem.timer != 0) {
					MusicSystem.volume1 = arg1;
					MusicSystem.data_ = arg3;
					MusicSystem.loop_ = arg2;
				} else
					MusicSystem.method56(arg2, arg3, arg1);
			} else {
				MusicSystem.velocity_increment = arg4;
				if (MusicSystem.volume2 != 0) {
					int i = MusicSystem.method372(MusicSystem.volume2);
					i -= MusicSystem.velocity;
					MusicSystem.timer = (i + 3600) / arg4;
					if (MusicSystem.timer < 1)
						MusicSystem.timer = 1;
				} else
					MusicSystem.timer = 1;
				MusicSystem.volume1 = arg1;
				MusicSystem.data_ = arg3;
				MusicSystem.loop_ = arg2;
			}
		}
	}

	private static void method984(int arg0) {
		if (arg0 == 0) {
			if (MusicSystem.midi != null) {
				if (MusicSystem.volume2 >= 0) {
					if (MusicSystem.timer > 0) {
						MusicSystem.velocity += MusicSystem.velocity_increment;
						MusicSystem.midi.setVolume(MusicSystem.volume2, MusicSystem.velocity);
						MusicSystem.timer--;
						if (MusicSystem.timer == 0) {
							MusicSystem.midi.stop0();
							MusicSystem.volume2 = -1;
							MusicSystem.timer = 20;
						}
					}
				} else if (MusicSystem.timer > 0) {
					MusicSystem.timer--;
					if (MusicSystem.timer == 0) {
						if (MusicSystem.data_ == null)
							MusicSystem.midi.resetVolume(256);
						else {
							MusicSystem.midi.resetVolume(MusicSystem.volume1);
							MusicSystem.volume2 = MusicSystem.volume1;
							MusicSystem.midi.play(MusicSystem.data_, MusicSystem.loop_, MusicSystem.volume1);
							MusicSystem.data_ = null;
						}
						MusicSystem.velocity = 0;
					}
				}
			}
		}
	}

	private static boolean musicIsntNull() {
		return MusicSystem.midi != null;

	}

	private static boolean musicPlayerStarted() {
		MusicSystem.timer = 20;
		try {
			MusicSystem.midi = new MidiPlayer();
			return true;
		} catch (Throwable throwable) {
			return false;
		}
	}
}
