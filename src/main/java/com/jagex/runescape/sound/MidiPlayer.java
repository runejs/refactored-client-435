package com.jagex.runescape.sound;

import javax.sound.midi.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * An implementation of a MidiPlayer.
 *
 * @author Dane
 */
class MidiPlayer implements Receiver {

    private static final int PROGRAM_0 = 0;
    private static final int MSB_CHANNEL_VOLUME = 7;
    private static final int LSB_CHANNEL_VOLUME = 39;
    private static final int MSB_BANK_SELECT = 0;
    private static final int LSB_BANK_SELECT = 32;
    private static final int ALL_SOUND_OFF = 120;
    private static final int RESET_ALL_CONTROLLERS = 121;
    private static final int ALL_NOTES_OFF = 123;

    /**
     * An integer array of channel volumes in their bitpacked squared forms.
     *
     * @see <a href="https://www.midi.org/specifications-old/category/reference-tables">MIDI Specifications</a>
     */
    private final int[] volumes = new int[]{0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200, 0x3200};

    /**
     * The tracked volume
     */
    private int volume;

    /**
     * The {@link MidiSystem} receiver.
     */
    private Receiver receiver;

    /**
     * The {@link MidiSystem} sequencer.
     */
    private Sequencer sequencer;

    /**
     * Creates a new {@link MidiPlayer}.
     *
     * @throws MidiUnavailableException
     */
    public MidiPlayer() throws MidiUnavailableException {
        receiver = MidiSystem.getReceiver();
        sequencer = MidiSystem.getSequencer(false);
        sequencer.getTransmitter().setReceiver(this);
        sequencer.open();
    }

    /**
     * Plays the provided {@link InputStream}. It is safe to close the stream after calling this method.
     *
     * @param in   the input stream
     * @param loop whether the input should loop or not
     * @return the {@link Sequence} created from the input.
     * @throws InvalidMidiDataException
     * @throws IOException
     */
    public Sequence play(InputStream in, boolean loop) throws InvalidMidiDataException, IOException {
        if (sequencer == null) {
            return null;
        }
        reset();
        Sequence s = MidiSystem.getSequence(in);
        sequencer.setSequence(s);
        sequencer.setLoopCount(loop ? Sequencer.LOOP_CONTINUOUSLY : 0);
        sequencer.start();
        return s;
    }

    /**
     * Sets the volume.
     *
     * @param volume the volume
     * @throws InvalidMidiDataException
     */
    public void setVolume(int volume) throws InvalidMidiDataException {
        if (sequencer == null) {
            return;
        }

        if (volume < 0) {
            volume = 0;
        } else if (volume > 256) {
            volume = 256;
        }

        if (this.volume != volume) {
            this.volume = volume;

            for (int c = 0; c < 16; c++) {
                int data = getChannelVolume(c);
                send(c + ShortMessage.CONTROL_CHANGE, MSB_CHANNEL_VOLUME, data >> 7);
                send(c + ShortMessage.CONTROL_CHANGE, LSB_CHANNEL_VOLUME, data & 0x7F);
            }
        }
    }

    /**
     * Adds the <code>adjustment</code> to the volume.
     *
     * @param adjustment the adjustment
     * @throws InvalidMidiDataException
     */
    public void adjustVolume(int adjustment) throws InvalidMidiDataException {
        setVolume(volume + adjustment);
    }

    public int getVolume() {
        return volume;
    }

    private int getChannelVolume(int channel) {
        int data = volumes[channel];
        data = ((data * volume) >> 8) * data;
        return (int) (Math.sqrt(data) + 0.5);
    }

    public boolean isDone() {
        return sequencer.getTickPosition() >= sequencer.getTickLength();
    }

    public boolean isMuted() {
        return volume <= 0;
    }

    public void stop() throws InvalidMidiDataException {
        if (sequencer != null) {
            sequencer.stop();
            sequencer.close();
            reset();
        }
    }

    private void reset() throws InvalidMidiDataException {
        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.CONTROL_CHANGE, ALL_NOTES_OFF, 0);
        }

        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.CONTROL_CHANGE, ALL_SOUND_OFF, 0);
        }

        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.CONTROL_CHANGE, RESET_ALL_CONTROLLERS, 0);
        }

        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.CONTROL_CHANGE, MSB_BANK_SELECT, 0);
        }

        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.CONTROL_CHANGE, LSB_BANK_SELECT, 0);
        }

        for (int c = 0; c < 16; c++) {
            send(c + ShortMessage.PROGRAM_CHANGE, PROGRAM_0, 0);
        }
    }

    @Override
    public void send(MidiMessage m, long timeStamp) {
        byte[] data = m.getMessage();

        try {
            if (data.length < 3 || !send0(data[0], data[1], data[2])) {
                receiver.send(m, timeStamp);
            }
        } catch (InvalidMidiDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * An internal method used to override specific control changes.
     *
     * @param status the status
     * @param data1  the data1
     * @param data2  the data2
     * @return <code>true</code> if overriden, else <code>false</code>.
     * @throws InvalidMidiDataException
     */
    private boolean send0(int status, int data1, int data2) throws InvalidMidiDataException {
        if ((status & 0xF0) == ShortMessage.CONTROL_CHANGE) {
            if (data1 == RESET_ALL_CONTROLLERS) {
                send(status, data1, data2);

                int channel = status & 0xF;
                volumes[channel] = 12800;

                int data = getChannelVolume(channel);
                send(status, MSB_CHANNEL_VOLUME, data >> 7);
                send(status, LSB_CHANNEL_VOLUME, data & 0x7f);
                return true;
            }

            if (data1 == MSB_CHANNEL_VOLUME || data1 == LSB_CHANNEL_VOLUME) {
                int channel = status & 0xF;

                if (data1 == MSB_CHANNEL_VOLUME) {
                    volumes[channel] = (volumes[channel] & 0x7F) + (data2 << 7);
                } else {
                    volumes[channel] = (volumes[channel] & 0x3F80) + data2;
                }

                int data = getChannelVolume(channel);
                send(status, MSB_CHANNEL_VOLUME, data >> 7);
                send(status, LSB_CHANNEL_VOLUME, data & 0x7f);
                return true;
            }
        }
        return false;
    }

    /**
     * Sends the parameters to the {@link #receiver} with a timestamp of <code>-1</code>.
     *
     * @param status the status
     * @param data1  the data1
     * @param data2  the data2
     * @throws InvalidMidiDataException See {@link ShortMessage#ShortMessage(int, int, int, int)}
     */
    private void send(int status, int data1, int data2) throws InvalidMidiDataException {
        receiver.send(new ShortMessage(status, data1, data2), -1);
    }

    @Override
    public void close() {
        if (sequencer != null) {
            sequencer.close();
            sequencer = null;
        }

        if (receiver != null) {
            receiver.close();
            receiver = null;
        }
    }

}