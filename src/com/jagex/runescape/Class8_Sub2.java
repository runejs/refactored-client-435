package com.jagex.runescape;
//import sun.audio.AudioPlayer;

public class Class8_Sub2 extends Class8 {
    public InputStream_Sub1 anInputStream_Sub1_1834;

    public Class8_Sub2() {
        super(8000);
        anInputStream_Sub1_1834 = new InputStream_Sub1();
        // AudioPlayer.player.start(anInputStream_Sub1_1834);
    }

    public void method213() {

        // AudioPlayer.player.stop(anInputStream_Sub1_1834);
        synchronized(anInputStream_Sub1_1834) {
            anInputStream_Sub1_1834.aBoolean72 = true;
        }
    }
}
