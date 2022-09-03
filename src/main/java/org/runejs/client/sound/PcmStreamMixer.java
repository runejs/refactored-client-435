package org.runejs.client.sound;

import org.runejs.client.LinkedList;
import org.runejs.client.node.Node;

public class PcmStreamMixer extends PcmStream {
    private int anInt2872 = 16;
    private LinkedList[] substreams = new LinkedList[8];
    private LinkedList head = new LinkedList();
    private int anInt2875 = 0;
    private int anInt2876 = -1;
    private int anInt2877 = 0;

    public PcmStreamMixer() {
        for(int i = 0; i < 8; i++)
            this.substreams[i] = new LinkedList();
    }

    /*
     * method845 is capped at 255, so this bitshift means it is bound from 0->7. As a result, we can get via the array.
     */
    private static int method849(PcmStream arg0) {
        return arg0.method845() >> 5;
    }

    public synchronized void addSubStream(PcmStream arg0) {
        LinkedList linkedList = this.substreams[method849(arg0)];
        linkedList.addFirst(0, arg0);
    }

    @Override
    public synchronized void skip(int arg0) {
        do {
            if(this.anInt2876 < 0) {
                this.skip0(arg0);
                break;
            }
            if(this.anInt2877 + arg0 < this.anInt2876) {
                this.anInt2877 += arg0;
                this.skip0(arg0);
                break;
            }
            int i = this.anInt2876 - this.anInt2877;
            this.skip0(i);
            arg0 -= i;
            this.anInt2877 += i;
            this.loop0();
            PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) this.head.peekFirst((byte) -90);
            synchronized(class40_sub8) {
                int i_0_ = class40_sub8.update(this);
                if(i_0_ < 0) {
                    class40_sub8.anInt2133 = 0;
                    this.remove(class40_sub8);
                } else {
                    class40_sub8.anInt2133 = i_0_;
                    this.update0(class40_sub8.next, class40_sub8);
                }
            }
        } while(arg0 != 0);
    }

    private void update0(Node arg0, PcmStreamMixerListener arg1) {
        for(/**/; arg0 != this.head.last && ((PcmStreamMixerListener) arg0).anInt2133 <= arg1.anInt2133; arg0 = arg0.next) {
            /* empty */
        }
        this.head.addBefore(-31793, arg0, arg1);
        this.anInt2876 = ((PcmStreamMixerListener) this.head.last.next).anInt2133;
    }

    private int fill0(int[] arg0, int arg1, int arg2) {
        this.anInt2875 -= arg2;
        if(this.anInt2875 <= 0) {
            this.anInt2875 += SoundSystem.SAMPLE_RATE >> 4;
            for(int i = 0; i < 8; i++) {
                LinkedList linkedList = this.substreams[i];
                for(PcmStream class40_sub9 = (PcmStream) linkedList.peekFirst((byte) -90); class40_sub9 != null; class40_sub9 = (PcmStream) linkedList.pollFirst(-4)) {
                    int i_1_ = method849(class40_sub9);
                    if(i_1_ != i)
                        this.substreams[i_1_].addFirst(0, class40_sub9);
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            LinkedList linkedList = this.substreams[i];
            for(PcmStream stream = (PcmStream) linkedList.peekFirst((byte) -90); stream != null; stream = (PcmStream) linkedList.pollFirst(-4)) {
                stream.active = false;
                if(stream.sound != null)
                    stream.sound.position = 0;
            }
        }
        int i = 0;
        int i_2_ = 255;
        int i_3_ = 7;
        while(i_2_ != 0) {
            int i_4_;
            int i_5_;
            if(i_3_ < 0) {
                i_4_ = i_3_ & 0x3;
                i_5_ = -(i_3_ >> 2);
            } else {
                i_4_ = i_3_;
                i_5_ = 0;
            }
            for(int i_6_ = i_2_ >>> i_4_ & 0x11111111; i_6_ != 0; i_6_ >>>= 4) {
                if((i_6_ & 0x1) != 0) {
                    i_2_ &= 1 << i_4_ ^ 0xffffffff;
                    LinkedList linkedList = this.substreams[i_4_];
                    for(PcmStream stream = (PcmStream) linkedList.peekFirst((byte) -90); stream != null; stream = (PcmStream) linkedList.pollFirst(-4)) {
                        if(!stream.active) {
                            AbstractSound class40_sub12 = stream.sound;
                            if(class40_sub12 != null && class40_sub12.position > i_5_)
                                i_2_ |= 1 << i_4_;
                            else {
                                if(i < this.anInt2872) {
                                    int i_7_ = stream.fill(arg0, arg1, arg2);
                                    i += i_7_;
                                    if(class40_sub12 != null)
                                        class40_sub12.position += i_7_;
                                } else
                                    stream.skip(arg2);
                                stream.active = true;
                            }
                        }
                    }
                }
                i_4_ += 4;
                i_5_++;
            }
            i_3_--;
        }
        return i;
    }

    private void remove(PcmStreamMixerListener arg0) {
        arg0.unlink();
        arg0.remove2();
        Node class40 = this.head.last.next;
        if(class40 == this.head.last)
            this.anInt2876 = -1;
        else
            this.anInt2876 = ((PcmStreamMixerListener) class40).anInt2133;
    }

    private void skip0(int arg0) {
        this.anInt2875 -= arg0;
        if(this.anInt2875 < 0)
            this.anInt2875 = 0;
        for(int i = 0; i < 8; i++) {
            LinkedList linkedList = this.substreams[i];
            for(PcmStream stream = (PcmStream) linkedList.peekFirst((byte) -90); stream != null; stream = (PcmStream) linkedList.pollFirst(-4))
                stream.skip(arg0);
        }
    }

    private void loop0() {
        if(this.anInt2877 > 0) {
            for(PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) this.head.peekFirst((byte) -90); class40_sub8 != null; class40_sub8 = (PcmStreamMixerListener) this.head.pollFirst(-4))
                class40_sub8.anInt2133 -= this.anInt2877;
            this.anInt2876 -= this.anInt2877;
            this.anInt2877 = 0;
        }
    }

    @Override
    public synchronized int fill(int[] arg0, int arg1, int arg2) {
        for(; ; ) {
            if(this.anInt2876 < 0)
                return this.fill0(arg0, arg1, arg2);
            if(this.anInt2877 + arg2 < this.anInt2876) {
                this.anInt2877 += arg2;
                return this.fill0(arg0, arg1, arg2);
            }
            int i = this.anInt2876 - this.anInt2877;
            int i_8_ = this.fill0(arg0, arg1, i);
            arg1 += i;
            arg2 -= i;
            this.anInt2877 += i;
            this.loop0();
            PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) this.head.peekFirst((byte) -90);
            synchronized(class40_sub8) {
                int i_9_ = class40_sub8.update(this);
                if(i_9_ < 0) {
                    class40_sub8.anInt2133 = 0;
                    this.remove(class40_sub8);
                } else {
                    class40_sub8.anInt2133 = i_9_;
                    this.update0(class40_sub8.next, class40_sub8);
                }
            }
            if(arg2 == 0)
                return i_8_;
        }
    }

    public synchronized void removeSubStream(PcmStream arg0) {
        arg0.unlink();
    }
}
