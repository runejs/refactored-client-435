package org.runejs.client.sound;

import org.runejs.client.LinkedList;
import org.runejs.client.node.Node;

public class PcmStreamMixer extends PcmStream {
    public int anInt2872 = 16;
    public LinkedList[] aLinkedListArray2873 = new LinkedList[8];
    public LinkedList aLinkedList_2874 = new LinkedList();
    public int anInt2875 = 0;
    public int anInt2876 = -1;
    public int anInt2877 = 0;

    public PcmStreamMixer() {
        for(int i = 0; i < 8; i++)
            aLinkedListArray2873[i] = new LinkedList();
    }

    public static int method849(PcmStream arg0) {
        return arg0.method845() >> 5;
    }

    public synchronized void addSubStream(PcmStream arg0) {
        LinkedList linkedList = aLinkedListArray2873[method849(arg0)];
        linkedList.method905(0, arg0);
    }

    public synchronized void skip(int arg0) {
        do {
            if(anInt2876 < 0) {
                method851(arg0);
                break;
            }
            if(anInt2877 + arg0 < anInt2876) {
                anInt2877 += arg0;
                method851(arg0);
                break;
            }
            int i = anInt2876 - anInt2877;
            method851(i);
            arg0 -= i;
            anInt2877 += i;
            method852();
            PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) aLinkedList_2874.method902((byte) -90);
            synchronized(class40_sub8) {
                int i_0_ = class40_sub8.method842(this);
                if(i_0_ < 0) {
                    class40_sub8.anInt2133 = 0;
                    method850(class40_sub8);
                } else {
                    class40_sub8.anInt2133 = i_0_;
                    method847(class40_sub8.next, class40_sub8);
                }
            }
        } while(arg0 != 0);
    }

    public void method847(Node arg0, PcmStreamMixerListener arg1) {
        for(/**/; arg0 != aLinkedList_2874.aClass40_1056 && ((PcmStreamMixerListener) arg0).anInt2133 <= arg1.anInt2133; arg0 = arg0.next) {
            /* empty */
        }
        aLinkedList_2874.method911(-31793, arg0, arg1);
        anInt2876 = ((PcmStreamMixerListener) aLinkedList_2874.aClass40_1056.next).anInt2133;
    }

    public int method848(int[] arg0, int arg1, int arg2) {
        anInt2875 -= arg2;
        if(anInt2875 <= 0) {
            anInt2875 += SoundSystem.SAMPLE_RATE >> 4;
            for(int i = 0; i < 8; i++) {
                LinkedList linkedList = aLinkedListArray2873[i];
                for(PcmStream class40_sub9 = (PcmStream) linkedList.method902((byte) -90); class40_sub9 != null; class40_sub9 = (PcmStream) linkedList.method909(-4)) {
                    int i_1_ = method849(class40_sub9);
                    if(i_1_ != i)
                        aLinkedListArray2873[i_1_].method905(0, class40_sub9);
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            LinkedList linkedList = aLinkedListArray2873[i];
            for(PcmStream class40_sub9 = (PcmStream) linkedList.method902((byte) -90); class40_sub9 != null; class40_sub9 = (PcmStream) linkedList.method909(-4)) {
                class40_sub9.active = false;
                if(class40_sub9.sound != null)
                    class40_sub9.sound.position = 0;
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
                    LinkedList linkedList = aLinkedListArray2873[i_4_];
                    for(PcmStream class40_sub9 = (PcmStream) linkedList.method902((byte) -90); class40_sub9 != null; class40_sub9 = (PcmStream) linkedList.method909(-4)) {
                        if(!class40_sub9.active) {
                            AbstractSound class40_sub12 = class40_sub9.sound;
                            if(class40_sub12 != null && class40_sub12.position > i_5_)
                                i_2_ |= 1 << i_4_;
                            else {
                                if(i < anInt2872) {
                                    int i_7_ = class40_sub9.fill(arg0, arg1, arg2);
                                    i += i_7_;
                                    if(class40_sub12 != null)
                                        class40_sub12.position += i_7_;
                                } else
                                    class40_sub9.skip(arg2);
                                class40_sub9.active = true;
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

    public void method850(PcmStreamMixerListener arg0) {
        arg0.remove();
        arg0.method841();
        Node class40 = aLinkedList_2874.aClass40_1056.next;
        if(class40 == aLinkedList_2874.aClass40_1056)
            anInt2876 = -1;
        else
            anInt2876 = ((PcmStreamMixerListener) class40).anInt2133;
    }

    public void method851(int arg0) {
        anInt2875 -= arg0;
        if(anInt2875 < 0)
            anInt2875 = 0;
        for(int i = 0; i < 8; i++) {
            LinkedList linkedList = aLinkedListArray2873[i];
            for(PcmStream class40_sub9 = (PcmStream) linkedList.method902((byte) -90); class40_sub9 != null; class40_sub9 = (PcmStream) linkedList.method909(-4))
                class40_sub9.skip(arg0);
        }
    }

    public void method852() {
        if(anInt2877 > 0) {
            for(PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) aLinkedList_2874.method902((byte) -90); class40_sub8 != null; class40_sub8 = (PcmStreamMixerListener) aLinkedList_2874.method909(-4))
                class40_sub8.anInt2133 -= anInt2877;
            anInt2876 -= anInt2877;
            anInt2877 = 0;
        }
    }

    public synchronized int fill(int[] arg0, int arg1, int arg2) {
        for(; ; ) {
            if(anInt2876 < 0)
                return method848(arg0, arg1, arg2);
            if(anInt2877 + arg2 < anInt2876) {
                anInt2877 += arg2;
                return method848(arg0, arg1, arg2);
            }
            int i = anInt2876 - anInt2877;
            int i_8_ = method848(arg0, arg1, i);
            arg1 += i;
            arg2 -= i;
            anInt2877 += i;
            method852();
            PcmStreamMixerListener class40_sub8 = (PcmStreamMixerListener) aLinkedList_2874.method902((byte) -90);
            synchronized(class40_sub8) {
                int i_9_ = class40_sub8.method842(this);
                if(i_9_ < 0) {
                    class40_sub8.anInt2133 = 0;
                    method850(class40_sub8);
                } else {
                    class40_sub8.anInt2133 = i_9_;
                    method847(class40_sub8.next, class40_sub8);
                }
            }
            if(arg2 == 0)
                return i_8_;
        }
    }

    public synchronized void removeSubStream(PcmStream arg0) {
        arg0.remove();
    }
}
