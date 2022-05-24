package org.runejs.client.sound;


import org.runejs.client.audio.Effect;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.media.renderable.actor.Player;

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
        for(int index = 0; index < StaticAudio.currentSound; index++) {
            StaticAudio.soundDelay[index]--;
            if(StaticAudio.soundDelay[index] < -10) {
                StaticAudio.currentSound--;
                for(int j = index; StaticAudio.currentSound > j; j++) {
                    StaticAudio.sound[j] = StaticAudio.sound[j + 1];
                    StaticAudio.effects[j] = StaticAudio.effects[1 + j];
                    StaticAudio.soundVolume[j] = StaticAudio.soundVolume[1 + j];
                    StaticAudio.soundDelay[j] = StaticAudio.soundDelay[1 + j];
                    StaticAudio.anIntArray1916[j] = StaticAudio.anIntArray1916[1 + j];
                }
                index--;
            } else {
                Effect effect = StaticAudio.effects[index];
                if(effect == null) {
                    effect = Effect.method429(CacheArchive.soundEffectCacheArchive, StaticAudio.sound[index], 0);
                    if(effect == null)
                        continue;
                    StaticAudio.soundDelay[index] += effect.delay();
                    StaticAudio.effects[index] = effect;
                }
                if(StaticAudio.soundDelay[index] < 0) {
                    int i_10_;
                    if(StaticAudio.anIntArray1916[index] != 0) {
                        int i_11_ = 128 * (StaticAudio.anIntArray1916[index] & 0xff);
                        int i_12_ = 0xff & StaticAudio.anIntArray1916[index] >> 16;
                        int i_13_ = (StaticAudio.anIntArray1916[index] & 0xffb8) >> 8;
                        int i_14_ = i_13_ * 128 + 64 + -Player.localPlayer.worldY;
                        int i_15_ = i_12_ * 128 + 64 - Player.localPlayer.worldX;
                        if(i_15_ < 0)
                            i_15_ = -i_15_;
                        if(i_14_ < 0)
                            i_14_ = -i_14_;
                        int i_16_ = -128 + i_15_ + i_14_;
                        if(i_16_ > i_11_) {
                            StaticAudio.soundDelay[index] = -100;
                            continue;
                        }
                        if(i_16_ < 0)
                            i_16_ = 0;
                        i_10_ = (i_11_ + -i_16_) * StaticAudio.soundEffectVolume / i_11_;
                    } else
                        i_10_ = StaticAudio.anInt200;
                    RawSound class40_sub12_sub1 = effect.method428().resample(StaticAudio.aDecimator_1289);
                    RawPcmStream class40_sub9_sub2 = RawPcmStream.create(class40_sub12_sub1, 100, i_10_);
                    class40_sub9_sub2.method860(-1 + StaticAudio.soundVolume[index]);
                    StaticAudio.aPcmStreamMixer_1152.method846(class40_sub9_sub2);
                    StaticAudio.soundDelay[index] = -100;
                }
            }
        }
        if(StaticAudio.songTimeout > 0) {
            StaticAudio.songTimeout -= 20;
            if(StaticAudio.songTimeout < 0)
                StaticAudio.songTimeout = 0;
            if(StaticAudio.songTimeout == 0 && StaticAudio.musicVolume != 0 && StaticAudio.currentSongId != -1)
                StaticAudio.method414(false, 0, StaticAudio.currentSongId, StaticAudio.musicVolume, 0, CacheArchive.musicCacheArchive);
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
        if (jingle) {
            MusicSystem.jingle = midi;
        } else {
            MusicSystem.song = midi;
        }
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
     * Gets the volume.
     *
     * @return the volume
     */
    public int getVolume() {
        return volume;
    }

    /**
     * The main loop for the {@link MusicSystem}. Contains logic for transitioning between songs.
     *
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    private void update() throws InvalidMidiDataException, IOException {
        if (jingle != null) {
            // fade out or switch to jingle
            if (!current.equals(jingle)) {
                current = jingle;
                playing = jingle;

                // no fade in, immediate
                player.setVolume(this.volume);

                    player.play(this.soundStream, false);
            } else if (player.isDone()) {
                current = "";
                playing = "";
                jingle = null;
            }
            return;
        }

        // no music or jingles playing
        if (song == null) {
            if (player.isMuted()) {
                playing = "none";
            } else {
                player.adjustVolume(-1);
            }
            return;
        }

        boolean songChanging = !current.equals(song);

        if (songChanging) {
            current = song;

            if (current.equals("replay")) {
                current = last;
            }

            last = current;
        }

        boolean fadeOut = !playing.equals(current);

        if (fadeOut) {
            if (!player.isMuted()) {
                player.adjustVolume(-2);
                return;
            }

            playing = current;

            if (playing == null || playing.equals("none")) {
                return;
            }

            if ("shutdown".equals(playing)) {
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

            if (volume < this.volume) {
                player.adjustVolume(4);
            } else if (volume > this.volume) {
                player.adjustVolume(-4);
            }
        }
    }

    @Override
    public void run() {
        while (running) {
            try {
                Thread.sleep(20);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                update();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (player != null) {
            try {
                player.stop();
            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }
        }
    }

}
