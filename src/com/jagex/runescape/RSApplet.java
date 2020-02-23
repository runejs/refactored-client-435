package com.jagex.runescape;

import com.jagex.runescape.cache.media.IdentityKit;
import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.util.Signlink;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class RSApplet extends Applet implements Runnable, FocusListener, WindowListener {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1;
    public static int[] anIntArray2 = new int[5];
    public static long[] aLongArray4 = new long[32];
    public static RSString aClass1_8 = null;
    public static RSString aClass1_14 = RSString.CreateString("Anmelde)2Limit -Uberschritten)3");
    public static RSString aClass1_21 = RSString.CreateString("Bitte warten Sie eine Minute");
    public static RSString aClass1_25 = RSString.CreateString("Hier klicken)1 um fortzufahren)3)3)3");
    public static RSString aClass1_28 = RSString.CreateString("null");
    public static int anInt31;
    public static RSString aClass1_34 = RSString.CreateString("null");
    public static RSString aClass1_35 = (RSString.CreateString("Die Adresse dieses Computers wurde gesperrt)1"));
    public boolean aBoolean43 = false;

    public static void method18() {
        aClass1_35 = null;
        aClass1_8 = null;
        aClass1_34 = null;
        aClass1_28 = null;
        aLongArray4 = null;
        aClass1_14 = null;
        aClass40_Sub5_Sub14_Sub2_1 = null;
        aClass1_21 = null;
        anIntArray2 = null;
        aClass1_25 = null;
    }

    public static void method19(boolean arg0, int arg1) {

        if(arg1 != 24041)
            aClass1_28 = null;
        if(Class57.aClass64_1345 != null) {
            try {
                Buffer class40_sub1 = new Buffer(4);
                class40_sub1.putByte(arg0 ? 2 : 3);
                class40_sub1.putMediumBE(0);
                Class57.aClass64_1345.method1010(4, (byte) -19, 0, (class40_sub1.buffer));
            } catch(java.io.IOException ioexception) {
                try {
                    Class57.aClass64_1345.method1009(-18);
                } catch(Exception exception) {
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                Class40_Sub5_Sub1.anInt2278++;
            }
        }

    }

    public static void method20(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Class40_Sub5_Sub12[] arg7, int arg8, int arg9) {

        if(arg6 != 1)
            providesignlink(null);
        for(int i = 0; i < arg7.length; i++) {
            Class40_Sub5_Sub12 class40_sub5_sub12 = arg7[i];
            if(class40_sub5_sub12 != null && (class40_sub5_sub12.type == 0 || class40_sub5_sub12.aBoolean2688) && class40_sub5_sub12 != null && arg5 == class40_sub5_sub12.anInt2648 && (!class40_sub5_sub12.aBoolean2750 || PacketBuffer.aBoolean2236)) {
                int i_1_ = arg4 + class40_sub5_sub12.anInt2656;
                int i_2_ = arg0 + class40_sub5_sub12.anInt2696;
                if(!class40_sub5_sub12.aBoolean2694)
                    i_2_ -= arg9;
                int i_3_ = i_2_ + class40_sub5_sub12.anInt2643;
                int i_4_ = arg0 >= i_2_ ? arg0 : i_2_;
                if(!class40_sub5_sub12.aBoolean2694)
                    i_1_ -= arg2;
                int i_5_ = i_1_ + class40_sub5_sub12.anInt2692;
                int i_6_ = arg4 < i_1_ ? i_1_ : arg4;
                int i_7_ = arg1 > i_3_ ? i_3_ : arg1;
                int i_8_ = i_5_ < arg8 ? i_5_ : arg8;
                if(class40_sub5_sub12.type == 0) {
                    method20(i_4_, i_7_, class40_sub5_sub12.anInt2746, arg3, i_6_, i, 1, arg7, i_8_, class40_sub5_sub12.scrollPosition);
                    if(class40_sub5_sub12.aClass40_Sub5_Sub12Array2713 != null)
                        method20(i_4_, i_7_, class40_sub5_sub12.anInt2746, arg3, i_6_, class40_sub5_sub12.anInt2689, 1, (class40_sub5_sub12.aClass40_Sub5_Sub12Array2713), i_8_, class40_sub5_sub12.scrollPosition);
                }
                if(class40_sub5_sub12.aBoolean2688) {
                    boolean bool;
                    bool = (Class13.mouseX ^ 0xffffffff) <= (i_6_ ^ 0xffffffff) && (i_4_ ^ 0xffffffff) >= (Landscape.mouseY ^ 0xffffffff) && i_8_ > Class13.mouseX && (i_7_ ^ 0xffffffff) < (Landscape.mouseY ^ 0xffffffff);
                    boolean bool_9_ = false;
                    if(Class40_Sub5_Sub2.anInt2302 == 1 && bool)
                        bool_9_ = true;
                    boolean bool_10_ = false;
                    if((class40_sub5_sub12.anInt2738 ^ 0xffffffff) != 0 && bool_9_ && Class10.aClass40_Sub5_Sub12_353 == null) {
                        Class40_Sub2.anInt1996 = Class13.mouseX;
                        Class10.aClass40_Sub5_Sub12_353 = class40_sub5_sub12;
                        Class40_Sub5_Sub11.anInt2621 = Landscape.mouseY;
                    }
                    if(Class62.anInt1470 == 1 && (i_6_ ^ 0xffffffff) >= (Class57.anInt1338 ^ 0xffffffff) && ((RSString.anInt1668 ^ 0xffffffff) <= (i_4_ ^ 0xffffffff)) && Class57.anInt1338 < i_8_ && RSString.anInt1668 < i_7_)
                        bool_10_ = true;
                    if(Class10.aClass40_Sub5_Sub12_353 != null) {
                        bool_9_ = false;
                        bool = false;
                        bool_10_ = false;
                    }
                    if(!class40_sub5_sub12.aBoolean2730 && bool_10_ && (0x1 & arg3) != 0) {
                        class40_sub5_sub12.aBoolean2730 = true;
                        if(class40_sub5_sub12.anObjectArray2681 != null)
                            Class43.method891((class40_sub5_sub12.anObjectArray2681), 0, RSString.anInt1668 + -i_2_, class40_sub5_sub12, Class57.anInt1338 - i_1_, false);
                    }
                    if(class40_sub5_sub12.aBoolean2730 && bool_9_ && (arg3 & 0x4 ^ 0xffffffff) != -1 && class40_sub5_sub12.anObjectArray2747 != null)
                        Class43.method891((class40_sub5_sub12.anObjectArray2747), 0, -i_2_ + Landscape.mouseY, class40_sub5_sub12, -i_1_ + Class13.mouseX, false);
                    if(class40_sub5_sub12.aBoolean2730 && !bool_9_ && (0x2 & arg3 ^ 0xffffffff) != -1) {
                        class40_sub5_sub12.aBoolean2730 = false;
                        if(class40_sub5_sub12.anObjectArray2707 != null)
                            Class43.method891((class40_sub5_sub12.anObjectArray2707), 0, Landscape.mouseY - i_2_, class40_sub5_sub12, Class13.mouseX - i_1_, false);
                    }
                    if(bool_9_ && (arg3 & 0x8 ^ 0xffffffff) != -1 && class40_sub5_sub12.anObjectArray2644 != null)
                        Class43.method891((class40_sub5_sub12.anObjectArray2644), 0, -i_2_ + Landscape.mouseY, class40_sub5_sub12, -i_1_ + Class13.mouseX, false);
                    if(!class40_sub5_sub12.aBoolean2682 && bool && (0x10 & arg3) != 0) {
                        class40_sub5_sub12.aBoolean2682 = true;
                        if(class40_sub5_sub12.anObjectArray2658 != null)
                            Class43.method891((class40_sub5_sub12.anObjectArray2658), 0, Landscape.mouseY - i_2_, class40_sub5_sub12, Class13.mouseX - i_1_, false);
                    }
                    if(class40_sub5_sub12.aBoolean2682 && bool && (0x40 & arg3) != 0 && class40_sub5_sub12.anObjectArray2680 != null)
                        Class43.method891((class40_sub5_sub12.anObjectArray2680), 0, -i_2_ + Landscape.mouseY, class40_sub5_sub12, -i_1_ + Class13.mouseX, false);
                    if(class40_sub5_sub12.aBoolean2682 && !bool && (arg3 & 0x20) != 0) {
                        class40_sub5_sub12.aBoolean2682 = false;
                        if(class40_sub5_sub12.anObjectArray2672 != null)
                            Class43.method891((class40_sub5_sub12.anObjectArray2672), 0, -i_2_ + Landscape.mouseY, class40_sub5_sub12, -i_1_ + Class13.mouseX, false);
                    }
                    if(class40_sub5_sub12.anObjectArray2712 != null && (arg3 & 0x80) != 0)
                        Class43.method891((class40_sub5_sub12.anObjectArray2712), 0, 0, class40_sub5_sub12, 0, false);
                    if(Class40_Sub5_Sub7.anInt2480 == Node.anInt926 && class40_sub5_sub12.anObjectArray2650 != null && (arg3 & 0x100 ^ 0xffffffff) != -1)
                        Class43.method891((class40_sub5_sub12.anObjectArray2650), 0, 0, class40_sub5_sub12, 0, false);
                }
            }
        }

    }

    public static void providesignlink(Signlink arg0) {
        Actor.aClass31_3152 = ISAAC.aClass31_521 = arg0;
    }

    public static int method27(int arg0, int arg1) {
        return arg0 ^ arg1;
    }

    public static void method28(long arg0, int arg1) {
        if((arg0 ^ 0xffffffffffffffffL) != -1L) {
            int i = 0;
            int i_12_ = -18 % ((arg1 - 69) / 44);
            for(/**/; ((Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) < (i ^ 0xffffffff)); i++) {
                if(Class59.aLongArray1397[i] == arg0) {
                    Class53.anInt1258++;
                    Class40_Sub5_Sub17_Sub3.anInt3060--;
                    ISAAC.redrawTabArea = true;
                    for(int i_13_ = i; i_13_ < Class40_Sub5_Sub17_Sub3.anInt3060; i_13_++) {
                        Class40_Sub11.aClass1Array2147[i_13_] = Class40_Sub11.aClass1Array2147[1 + i_13_];
                        Class40_Sub7.anIntArray2131[i_13_] = Class40_Sub7.anIntArray2131[i_13_ + 1];
                        Class59.aLongArray1397[i_13_] = Class59.aLongArray1397[1 + i_13_];
                    }
                    Class32.packetBuffer.putPacket(255);
                    Class32.packetBuffer.putLongBE(arg0);
                    break;
                }
            }
        }

    }

    public static int method32(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if(arg3 != true)
            return -109;
        int i = (65536 + -(R3D.cosinetable[1024 * arg4 / arg1]) >> 1712636353);
        return (((65536 + -i) * arg0 >> 523531120) + (arg2 * i >> 1426525808));
    }

    public void run() {
        try {
            if(Signlink.aString735 != null) {
                String string = Signlink.aString735.toLowerCase();
                if(string.indexOf("sun") == -1 && (string.indexOf("apple") ^ 0xffffffff) == 0) {
                    if((string.indexOf("ibm") ^ 0xffffffff) != 0 && (Signlink.aString739 == null || Signlink.aString739.equals("1.4.2"))) {
                        openErrorPage((byte) 27, "wrongjava");
                        return;
                    }
                } else {
                    String string_0_ = Signlink.aString739;
                    if(string_0_.equals("1.1") || string_0_.startsWith("1.1.") || string_0_.equals("1.2") || string_0_.startsWith("1.2.")) {
                        openErrorPage((byte) 114, "wrongjava");
                        return;
                    }
                    Class40_Sub3.anInt2024 = 5;
                }
            }
            if(ISAAC.aClass31_521.anApplet740 != null) {
                Method method = Signlink.aMethod724;
                if(method != null) {
                    try {
                        method.invoke(ISAAC.aClass31_521.anApplet740, Boolean.TRUE);
                    } catch(Throwable throwable) {
                    }
                }
            }
            setCanvas((byte) 121);
            Class68_Sub1.aClass68_2213 = Class40_Sub5_Sub13.method649((IdentityKit.height), Class12.width, Class62.aCanvas1469, -4875);
            method31(true);
            Class32.aClass38_768 = Class56.method972((byte) 47);
            Class32.aClass38_768.method443(-10115);
            while(Class6.aLong219 == 0L || Class51.method937(1) < Class6.aLong219) {
                Class40_Sub3.anInt2020 = Class32.aClass38_768.method442(Class39.anInt912, (Class40_Sub3.anInt2024), 9799);
                for(int i = 0; (i ^ 0xffffffff) > (Class40_Sub3.anInt2020 ^ 0xffffffff); i++)
                    method29(true);
                method26((byte) 88);
            }
        } catch(Exception exception) {
            Class6.method169(null, (byte) -121, exception);
            openErrorPage((byte) 62, "crash");
        }
        method17(118);

    }

    public abstract void method16(int i);

    public synchronized void method17(int arg0) {
        if(!PacketBuffer.aBoolean2255) {
            if(arg0 <= 86)
                aClass1_14 = null;
            PacketBuffer.aBoolean2255 = true;
            try {
                Class62.aCanvas1469.removeFocusListener(this);
            } catch(Exception exception) {
                /* empty */
            }
            try {
                method24(0);
            } catch(Exception exception) {
                /* empty */
            }
            if(Class35.aFrame1732 != null) {
                try {
                    System.exit(0);
                } catch(Throwable throwable) {
                    /* empty */
                }
            }
            if(ISAAC.aClass31_521 != null) {
                try {
                    ISAAC.aClass31_521.method385(0);
                } catch(Exception exception) {
                    /* empty */
                }
            }
            method16(28065);
        }
    }

    public void stop() {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255)
            Class6.aLong219 = Class51.method937(1) + 4000L;
    }

    public abstract void init();

    public boolean verifyHost(int arg0) {
        String string = getDocumentBase().getHost().toLowerCase();
        if(arg0 != 31)
            return false;
        if(string.endsWith("runescape.com"))
            return true;
        if(string.endsWith("127.0.0.1"))
            return true;
        for(/**/; ((string.length() ^ 0xffffffff) < -1 && string.charAt(string.length() - 1) >= '0' && ((string.charAt(string.length() + -1) ^ 0xffffffff) >= -58)); string = string.substring(0, string.length() - 1)) {
            /* empty */
        }
        if(string.endsWith("192.168.1."))
            return true;
        openErrorPage((byte) 113, "invalidhost");
        return false;
    }

    public void windowOpened(WindowEvent arg0) {
    }

    public void openErrorPage(byte arg0, String gameError) {
        if(!aBoolean43) {
            aBoolean43 = true;
            System.out.println("error_game_" + gameError);
            try {
                getAppletContext().showDocument(new URL(getCodeBase(), ("error_game_" + gameError + ".ws")));
            } catch(Exception exception) {
            }
            if(arg0 > 26)
                return;
            displayClientFrame((byte) 96, 68, 28, 85, -56);
        }

    }

    public void start() {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255)
            Class6.aLong219 = 0L;
    }

    public abstract void method23(int i);

    public void focusLost(FocusEvent arg0) {
        Class52.aBoolean1215 = false;
    }

    public abstract void method24(int i);

    public synchronized void paint(Graphics arg0) {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255) {
            Class40_Sub5_Sub11.aBoolean2631 = true;
            if(Signlink.aString739 == null || !Signlink.aString739.startsWith("1.5") || -Class4.aLong174 + Class51.method937(1) <= 1000L)
                return;
            Rectangle rectangle = arg0.getClipBounds();
            if(rectangle == null || (rectangle.width >= Class12.width && ((rectangle.height ^ 0xffffffff) <= (IdentityKit.height ^ 0xffffffff))))
                Class67.aBoolean1575 = true;
        }
    }

    public void destroy() {
        if(Class4.anApplet_Sub1_179 == this && !PacketBuffer.aBoolean2255) {
            Class6.aLong219 = Class51.method937(1);
            Class43.method890(5000L, -123);
            Actor.aClass31_3152 = null;
            method17(121);
        }
    }

    public void focusGained(FocusEvent arg0) {
        Class52.aBoolean1215 = true;
        Class40_Sub5_Sub11.aBoolean2631 = true;
    }

    public URL getDocumentBase() {
        if(Class35.aFrame1732 != null)
            return null;
        if(ISAAC.aClass31_521 != null && this != ISAAC.aClass31_521.anApplet740)
            return ISAAC.aClass31_521.anApplet740.getDocumentBase();
        return super.getDocumentBase();
    }

    public void displayClientFrame(byte arg0, int clientVersion, int width, int height, int fileStoreId) {
        try {
            if(Class4.anApplet_Sub1_179 != null) {
                openErrorPage((byte) 74, "alreadyloaded");
                return;
            }
            Class12.width = height;
            Class39.anInt901 = clientVersion;
            IdentityKit.height = width;
            Class4.anApplet_Sub1_179 = this;
            if(ISAAC.aClass31_521 == null)
                Actor.aClass31_3152 = ISAAC.aClass31_521 = (new Signlink(false, this, InetAddress.getByName(getCodeBase().getHost()), fileStoreId, null, 0));
            ISAAC.aClass31_521.method394(1, 0, this);
        } catch(Exception exception) {
            Class6.method169(null, (byte) -126, exception);
            openErrorPage((byte) 31, "crash");
        }
        if(arg0 == 120)
            return;
        windowActivated(null);
    }

    public void windowIconified(WindowEvent arg0) {
    }

    public void method26(byte arg0) {
        if(arg0 == 88) {
            long l = Class51.method937(1);
            long l_11_ = aLongArray4[Class30.anInt681];
            aLongArray4[Class30.anInt681] = l;
            if((l_11_ ^ 0xffffffffffffffffL) != -1L && ((l_11_ ^ 0xffffffffffffffffL) > (l ^ 0xffffffffffffffffL))) {
                int i = (int) (-l_11_ + l);
                Class52.anInt1219 = ((i >> -17114751) + 32000) / i;
            }
            Class30.anInt681 = Class30.anInt681 + 1 & 0x1f;
            if(Node.anInt938++ > 50) {
                Node.anInt938 -= 50;
                Class40_Sub5_Sub11.aBoolean2631 = true;
                Class62.aCanvas1469.setSize(Class12.width, IdentityKit.height);
                Class62.aCanvas1469.setVisible(true);
                if(Class35.aFrame1732 == null)
                    Class62.aCanvas1469.setLocation(0, 0);
                else {
                    Insets insets = Class35.aFrame1732.getInsets();
                    Class62.aCanvas1469.setLocation(insets.left, insets.top);
                }
            }
            method34(arg0 + -210);
        }
    }

    public AppletContext getAppletContext() {
        if(Class35.aFrame1732 != null)
            return null;
        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
            return ISAAC.aClass31_521.anApplet740.getAppletContext();
        return super.getAppletContext();
    }

    public void method29(boolean arg0) {
        long l = Class51.method937(1);
        long l_14_ = Class67.aLongArray1614[Class62.anInt1468];
        if(l_14_ != 0L && l > l_14_) {
            /* empty */
        }
        Class67.aLongArray1614[Class62.anInt1468] = l;
        Class62.anInt1468 = 0x1f & Class62.anInt1468 + 1;
        synchronized(this) {
            HashTable.aBoolean571 = Class52.aBoolean1215;
        }
        method23(-22636);
        if(arg0 == true)
            return;
        windowIconified(null);
    }

    public void openClientApplet(String cacheFolder, int cacheIndexes, int height, int fileStoreId, InetAddress inetAddress, int clientVersion, int width) {
        try {
            Class39.anInt901 = clientVersion;
            Class12.width = width;
            Class4.anApplet_Sub1_179 = this;
            IdentityKit.height = height;
            Class35.aFrame1732 = new Frame();
            Class35.aFrame1732.setTitle("Jagex");
            Class35.aFrame1732.setResizable(false);
            Class35.aFrame1732.addWindowListener(this);
            Class35.aFrame1732.setVisible(true);
            Class35.aFrame1732.toFront();
            Insets insets = Class35.aFrame1732.getInsets();
            Class35.aFrame1732.setSize(insets.right + (width + insets.left), insets.bottom + insets.top + height);
            Actor.aClass31_3152 = ISAAC.aClass31_521 = new Signlink(true, null, inetAddress, fileStoreId, cacheFolder, cacheIndexes);
            ISAAC.aClass31_521.method394(1, 0, this);
        } catch(Exception exception) {
            Class6.method169(null, (byte) -127, exception);
        }
    }

    public URL getCodeBase() {
        if(Class35.aFrame1732 != null)
            return null;
        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
            return ISAAC.aClass31_521.anApplet740.getCodeBase();
        return super.getCodeBase();
    }

    public abstract void method31(boolean bool);

    public void update(Graphics graphics) {
        paint(graphics);

    }

    public void windowClosing(WindowEvent windowEvent) {
        destroy();
    }

    public String getParameter(String parameter) {
        if(Class35.aFrame1732 != null)
            return null;
        if(ISAAC.aClass31_521 != null && this != ISAAC.aClass31_521.anApplet740)
            return ISAAC.aClass31_521.anApplet740.getParameter(parameter);
        return super.getParameter(parameter);
    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public synchronized void setCanvas(byte arg0) {
        Container container;
        if(Class35.aFrame1732 != null)
            container = Class35.aFrame1732;
        else
            container = ISAAC.aClass31_521.anApplet740;
        if(Class62.aCanvas1469 != null) {
            Class62.aCanvas1469.removeFocusListener(this);
            container.remove(Class62.aCanvas1469);
        }
        Class62.aCanvas1469 = new RSCanvas(this);
        container.add(Class62.aCanvas1469);
        Class62.aCanvas1469.setSize(Class12.width, IdentityKit.height);
        Class62.aCanvas1469.setVisible(true);
        if(Class35.aFrame1732 != null) {
            Insets insets = Class35.aFrame1732.getInsets();
            Class62.aCanvas1469.setLocation(insets.left, insets.top);
        } else
            Class62.aCanvas1469.setLocation(0, 0);
        Class62.aCanvas1469.addFocusListener(this);
        if(arg0 < 85)
            run();
        Class62.aCanvas1469.requestFocus();
        Class40_Sub5_Sub11.aBoolean2631 = true;
        Class67.aBoolean1575 = false;
        Class4.aLong174 = Class51.method937(1);
    }

    public abstract void method34(int i);

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }
}
