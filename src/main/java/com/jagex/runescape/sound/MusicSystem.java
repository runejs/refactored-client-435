package com.jagex.runescape.sound;


import com.jagex.runescape.*;
import com.jagex.runescape.audio.Effect;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.IOException;
import java.io.InputStream;

/**
 * A simple class written to handle playing music and fading in/out.
 *
 * @author Dane
 */
public final class MusicSystem implements Runnable {

    /**
     * Default volume ranges from 0..4.
     */
    public static int defaultVolume = 3;

    /**
     * The next song to play.
     */
    private static String song;

    /**
     * The next jingle to play.
     */
    private static String jingle;

    /**
     * The instance of {@link MidiPlayer}.
     */
    private final MidiPlayer player;

    /**
     * The song that <b>should</b> be playing. If not, the audio will fade to transition to this song.
     */
    private String current = "none";

    /**
     * The actively playing song.
     */
    private String playing = "none";

    /**
     * The previously played song.
     */
    private String last = "none";

    /**
     * The current volume.
     */
    private int volume;

    /**
     * The run state.
     */
    private boolean running;

    private InputStream soundStream;


    /**
     * Creates a new {@link MusicSystem}.
     *
     * @throws MidiUnavailableException
     * @see MidiPlayer
     */
    public MusicSystem() throws MidiUnavailableException {
        this.running = true;
        //        this.soundStream = stream;
        this.player = new MidiPlayer();
        this.setDefault();

        Thread t = new Thread(this);
        t.setName("MusicSystem");
        t.setDaemon(true);
        t.start();
    }

    public static void processAudio() {
        for(int index = 0; index < PacketBuffer.currentSound; index++) {
            Class40_Sub3.soundDelay[index]--;
            if(Class40_Sub3.soundDelay[index] < -10) {
                PacketBuffer.currentSound--;
                for(int j = index; PacketBuffer.currentSound > j; j++) {
                    IdentityKit.sound[j] = IdentityKit.sound[j + 1];
                    PacketBuffer.effects[j] = PacketBuffer.effects[1 + j];
                    ItemDefinition.soundVolume[j] = ItemDefinition.soundVolume[1 + j];
                    Class40_Sub3.soundDelay[j] = Class40_Sub3.soundDelay[1 + j];
                    MovedStatics.anIntArray1916[j] = MovedStatics.anIntArray1916[1 + j];
                }
                index--;
            } else {
                Effect effect = PacketBuffer.effects[index];
                if(effect == null) {
                    effect = Effect.method429(CacheArchive.soundEffectCacheArchive, IdentityKit.sound[index], 0);
                    if(effect == null) {
                        continue;
                    }
                    Class40_Sub3.soundDelay[index] += effect.delay();
                    PacketBuffer.effects[index] = effect;
                }
                if(Class40_Sub3.soundDelay[index] < 0) {
                    int i_10_;
                    if(MovedStatics.anIntArray1916[index] != 0) {
                        int i_11_ = 128 * (MovedStatics.anIntArray1916[index] & 0xff);
                        int i_12_ = 0xff & MovedStatics.anIntArray1916[index] >> 16;
                        int i_13_ = (MovedStatics.anIntArray1916[index] & 0xffb8) >> 8;
                        int i_14_ = i_13_ * 128 + 64 + -Player.localPlayer.worldY;
                        int i_15_ = i_12_ * 128 + 64 - Player.localPlayer.worldX;
                        if(i_15_ < 0) {
                            i_15_ = -i_15_;
                        }
                        if(i_14_ < 0) {
                            i_14_ = -i_14_;
                        }
                        int i_16_ = -128 + i_15_ + i_14_;
                        if(i_16_ > i_11_) {
                            Class40_Sub3.soundDelay[index] = -100;
                            continue;
                        }
                        if(i_16_ < 0) {
                            i_16_ = 0;
                        }
                        i_10_ = (i_11_ + -i_16_) * RSCanvas.anInt65 / i_11_;
                    } else {
                        i_10_ = MovedStatics.anInt200;
                    }
                    Class40_Sub12_Sub1 class40_sub12_sub1 = effect.method428().method875(Class55.aClass48_1289);
                    Class40_Sub9_Sub2 class40_sub9_sub2 = Class40_Sub9_Sub2.method864(class40_sub12_sub1, 100, i_10_);
                    class40_sub9_sub2.method860(-1 + ItemDefinition.soundVolume[index]);
                    Class49.aClass40_Sub9_Sub1_1152.method846(class40_sub9_sub2);
                    Class40_Sub3.soundDelay[index] = -100;
                }
            }
        }
        if(Class35.songTimeout > 0) {
            Class35.songTimeout -= 20;
            if(Class35.songTimeout < 0) {
                Class35.songTimeout = 0;
            }
            if(Class35.songTimeout == 0 && RSCanvas.anInt60 != 0 && MouseHandler.anInt1457 != -1) {
                Class33.method414(
                        false, 0, MouseHandler.anInt1457, RSCanvas.anInt60, 0, CacheArchive.musicCacheArchive);
            }
        }
    }

    /**
     * Sets the volume to default.
     *
     * @see #defaultVolume
     */
    public void setDefault() {
        this.volume = defaultVolume * 64;
    }

    /**
     * Stops the {@link MusicSystem} thread.
     */
    public void stop() {
        play("shutdown");
    }

    /**
     * Plays the specified midi.
     *
     * @param midi the midi
     */
    public void play(String midi) {
        play(midi, false);
    }

    /**
     * Plays the specified midi with the additional option of being a jingle. A jingle is a temporary song that overrides
     * the currently playing song.
     *
     * @param midi   the midi
     * @param jingle play as a jingle?
     */
    public void play(String midi, boolean jingle) {
        if(jingle) {
            MusicSystem.jingle = midi;
        } else {
            MusicSystem.song = midi;
        }
    }

    /**
     * Gets the volume.
     *
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Sets the volume.
     *
     * @param volume the volume (integer value from 0..256)
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * The main loop for the {@link MusicSystem}. Contains logic for transitioning between songs.
     *
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    private void update() throws InvalidMidiDataException, IOException {
        if(jingle != null) {
            // fade out or switch to jingle
            if(!current.equals(jingle)) {
                current = jingle;
                playing = jingle;

                // no fade in, immediate
                player.setVolume(this.volume);

                player.play(this.soundStream, false);
            } else if(player.isDone()) {
                current = "";
                playing = "";
                jingle = null;
            }
            return;
        }

        // no music or jingles playing
        if(song == null) {
            if(player.isMuted()) {
                playing = "none";
            } else {
                player.adjustVolume(-1);
            }
            return;
        }

        boolean songChanging = !current.equals(song);

        if(songChanging) {
            current = song;

            if(current.equals("replay")) {
                current = last;
            }

            last = current;
        }

        boolean fadeOut = !playing.equals(current);

        if(fadeOut) {
            if(!player.isMuted()) {
                player.adjustVolume(-2);
                return;
            }

            playing = current;

            if(playing == null || playing.equals("none")) {
                return;
            }

            if("shutdown".equals(playing)) {
                song = null;
                running = false;
                current = "none";
                playing = "none";
                last = "none";
                return;
            }

            player.play(this.soundStream, true);

        } else {
            // fade in
            int volume = player.getVolume();

            if(volume < this.volume) {
                player.adjustVolume(4);
            } else if(volume > this.volume) {
                player.adjustVolume(-4);
            }
        }
    }

    @Override
    public void run() {
        while(running) {
            try {
                Thread.sleep(20);
            } catch(Exception e) {
                e.printStackTrace();
            }

            try {
                update();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        if(player != null) {
            try {
                player.stop();
            } catch(InvalidMidiDataException e) {
                e.printStackTrace();
            }
        }
    }

}
