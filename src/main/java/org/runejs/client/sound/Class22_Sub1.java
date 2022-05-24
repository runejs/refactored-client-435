package org.runejs.client.sound;

import org.runejs.client.SizedAccessFile;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;

public class Class22_Sub1 extends Class22 {
    public boolean aBoolean1835;
    public SignlinkNode aSignlinkNode_1836;
    public boolean aBoolean1852;
    public int anInt1860;
    public byte[] aByteArray1866;
    public Signlink aClass31_1872;

    public Class22_Sub1(Signlink arg0) {
        aClass31_1872 = arg0;
    }

    public void method301(int arg0, int arg1) {
    }

    public void method303(byte arg0) {
        if(aBoolean1835) {
            try {
//                Class28.method369(aClass31_1872.anApplet740, "midibox.src=\"c:/silence.mid\";", arg0 ^ 0x6f0f);
            } catch(Throwable throwable) {
                /* empty */
            }
            aBoolean1835 = false;
        }
        if(arg0 == -96)
            aSignlinkNode_1836 = null;
    }

    public void method302(int arg0) {
        if(aSignlinkNode_1836 != null && aSignlinkNode_1836.status != 0) {
            if(aSignlinkNode_1836.status == 1) {
                SizedAccessFile sizedAccessFile = (SizedAccessFile) aSignlinkNode_1836.value;
                try {
                    sizedAccessFile.write(aByteArray1866, 0, aByteArray1866.length);
                    sizedAccessFile.close();
                    try {
//                        Class28.method369(aClass31_1872.anApplet740, ("midibox.loop=" + (!aBoolean1852 ? "0" : "\"infinite\"") + "; midibox.src=\"" + class47.method915().getPath().replace('\\', '/') + "\"; midibox.volume=" + anInt1860 + ";"), -28497);
                        aBoolean1835 = true;
                    } catch(Throwable throwable) {
                        /* empty */
                    }
                } catch(Exception exception) {
                    try {
                        sizedAccessFile.close();
                    } catch(Exception exception_0_) {
                        /* empty */
                    }
                }
            }
            aSignlinkNode_1836 = null;
            if(arg0 != 0)
                StaticAudio.musicCacheArchive = null;
        }
    }

    public void method306(byte arg0) {
    }

    public void method304(byte arg0, int arg1, int arg2) {
        if(arg1 == 0)
            arg1 = 1;
        int i = StaticAudio.method372(120, arg1) + -arg2;
        if(aSignlinkNode_1836 == null) {
            do {
                if(aBoolean1835) {
                    try {
//                        Class28.method369(aClass31_1872.anApplet740, "midibox.volume=" + i + ";", -28497);
                    } catch(Throwable throwable) {
                        break;
                    }
                    break;
                }
            } while(false);
        } else
            anInt1860 = i;
    }

    public void method300(byte[] arg0, boolean arg1, int arg3) {
        aSignlinkNode_1836 = aClass31_1872.method396(86);
        if(aSignlinkNode_1836 != null) {
            if(arg3 == 0)
                arg3 = 1;
            anInt1860 = StaticAudio.method372(-15910 ^ ~0x3e59, arg3);
            aByteArray1866 = arg0;
            aBoolean1852 = arg1;
        }
    }
}
