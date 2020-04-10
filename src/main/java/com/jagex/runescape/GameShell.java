package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.def.IdentityKit;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.cache.media.Widget.WidgetType;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.GenericTile;
import com.jagex.runescape.scene.tile.Wall;
import com.jagex.runescape.util.Signlink;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URL;

public abstract class GameShell extends Canvas implements Runnable, FocusListener, WindowListener {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_1;
    public static int[] anIntArray2 = new int[5];
    public static long[] aLongArray4 = new long[32];
    public static RSString clickToContinueString = null;
    public static RSString aClass1_28 = RSString.CreateString("null");
    public static int anInt31;
    public static RSString aClass1_34 = RSString.CreateString("null");
    public boolean aBoolean43 = false;

    public static void method18() {
        clickToContinueString = null;
        aClass1_34 = null;
        aClass1_28 = null;
        aLongArray4 = null;
        aClass40_Sub5_Sub14_Sub2_1 = null;
        anIntArray2 = null;
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
                ioexception.printStackTrace();
                try {
                    Class57.aClass64_1345.method1009();
                } catch(Exception exception) {
                    exception.printStackTrace();
                    /* empty */
                }
                Class57.aClass64_1345 = null;
                Class40_Sub5_Sub1.anInt2278++;
            }
        }

    }

    public static void method20(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, Widget[] arg7, int arg8, int arg9) {

        if(arg6 != 1)
            providesignlink(null);
        for(int i = 0; i < arg7.length; i++) {
            Widget widget = arg7[i];
            if(widget != null && (widget.type == WidgetType.LAYER || widget.aBoolean2688) && widget != null && arg5 == widget.parentId && (!widget.isHidden || PacketBuffer.hiddenButtonTest)) {
                int i_1_ = arg4 + widget.currentX;
                int i_2_ = arg0 + widget.currentY;
                if(!widget.aBoolean2694)
                    i_2_ -= arg9;
                int i_3_ = i_2_ + widget.originalHeight;
                int i_4_ = arg0 >= i_2_ ? arg0 : i_2_;
                if(!widget.aBoolean2694)
                    i_1_ -= arg2;
                int i_5_ = i_1_ + widget.originalWidth;
                int i_6_ = arg4 < i_1_ ? i_1_ : arg4;
                int i_7_ = arg1 > i_3_ ? i_3_ : arg1;
                int i_8_ = i_5_ < arg8 ? i_5_ : arg8;
                if(widget.type == WidgetType.LAYER) {
                    method20(i_4_, i_7_, widget.anInt2746, arg3, i_6_, i, 1, arg7, i_8_, widget.scrollPosition);
                    if(widget.aWidgetArray2713 != null)
                        method20(i_4_, i_7_, widget.anInt2746, arg3, i_6_, widget.id, 1, (widget.aWidgetArray2713), i_8_, widget.scrollPosition);
                }
                if(widget.aBoolean2688) {
                    boolean bool;
                    bool = (Class13.mouseX >= i_6_) && (i_4_ <= Landscape.mouseY) && i_8_ > Class13.mouseX && (i_7_ > Landscape.mouseY);
                    boolean bool_9_ = false;
                    if(SpotAnimDefinition.mouseButtonPressed == 1 && bool)
                        bool_9_ = true;
                    boolean bool_10_ = false;
                    if(widget.anInt2738 != -1 && bool_9_ && Wall.aWidget_353 == null) {
                        Class40_Sub2.anInt1996 = Class13.mouseX;
                        Wall.aWidget_353 = widget;
                        Class40_Sub5_Sub11.anInt2621 = Landscape.mouseY;
                    }
                    if(MouseHandler.clickType == 1 && (i_6_ <= Class57.clickX) && ((RSString.clickY >= i_4_)) && Class57.clickX < i_8_ && RSString.clickY < i_7_)
                        bool_10_ = true;
                    if(Wall.aWidget_353 != null) {
                        bool_9_ = false;
                        bool = false;
                        bool_10_ = false;
                    }
                    if(!widget.aBoolean2730 && bool_10_ && (0x1 & arg3) != 0) {
                        widget.aBoolean2730 = true;
                        if(widget.anObjectArray2681 != null)
                            Widget.method891((widget.anObjectArray2681), 0, RSString.clickY + -i_2_, widget, Class57.clickX - i_1_, false);
                    }
                    if(widget.aBoolean2730 && bool_9_ && (arg3 & 0x4) != 0 && widget.anObjectArray2747 != null)
                        Widget.method891((widget.anObjectArray2747), 0, -i_2_ + Landscape.mouseY, widget, -i_1_ + Class13.mouseX, false);
                    if(widget.aBoolean2730 && !bool_9_ && (0x2 & arg3) != 0) {
                        widget.aBoolean2730 = false;
                        if(widget.anObjectArray2707 != null)
                            Widget.method891((widget.anObjectArray2707), 0, Landscape.mouseY - i_2_, widget, Class13.mouseX - i_1_, false);
                    }
                    if(bool_9_ && (arg3 & 0x8) != 0 && widget.anObjectArray2644 != null)
                        Widget.method891((widget.anObjectArray2644), 0, -i_2_ + Landscape.mouseY, widget, -i_1_ + Class13.mouseX, false);
                    if(!widget.aBoolean2682 && bool && (0x10 & arg3) != 0) {
                        widget.aBoolean2682 = true;
                        if(widget.anObjectArray2658 != null)
                            Widget.method891((widget.anObjectArray2658), 0, Landscape.mouseY - i_2_, widget, Class13.mouseX - i_1_, false);
                    }
                    if(widget.aBoolean2682 && bool && (0x40 & arg3) != 0 && widget.anObjectArray2680 != null)
                        Widget.method891((widget.anObjectArray2680), 0, -i_2_ + Landscape.mouseY, widget, -i_1_ + Class13.mouseX, false);
                    if(widget.aBoolean2682 && !bool && (arg3 & 0x20) != 0) {
                        widget.aBoolean2682 = false;
                        if(widget.anObjectArray2672 != null)
                            Widget.method891((widget.anObjectArray2672), 0, -i_2_ + Landscape.mouseY, widget, -i_1_ + Class13.mouseX, false);
                    }
                    if(widget.anObjectArray2712 != null && (arg3 & 0x80) != 0)
                        Widget.method891((widget.anObjectArray2712), 0, 0, widget, 0, false);
                    if(AnimationSequence.anInt2480 == Node.pulseCycle && widget.anObjectArray2650 != null && (arg3 & 0x100) != 0)
                        Widget.method891((widget.anObjectArray2650), 0, 0, widget, 0, false);
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

    public static void method28(long arg0) {
        if(arg0 != 0) {
            int i = 0;
            for(/**/; ((Item.friendsCount > i)); i++) {
                if(Class59.aLongArray1397[i] == arg0) {
                    Item.friendsCount--;
                    ISAAC.redrawTabArea = true;
                    for(int i_13_ = i; i_13_ < Item.friendsCount; i_13_++) {
                        Class40_Sub11.friendUsernames[i_13_] = Class40_Sub11.friendUsernames[1 + i_13_];
                        Class40_Sub7.friendWorlds[i_13_] = Class40_Sub7.friendWorlds[i_13_ + 1];
                        Class59.aLongArray1397[i_13_] = Class59.aLongArray1397[1 + i_13_];
                    }
                    SceneCluster.packetBuffer.putPacket(255);
                    SceneCluster.packetBuffer.putLongBE(arg0);
                    break;
                }
            }
        }
    }

    public static int method32(int arg0, int arg1, int arg2, boolean arg3, int arg4) {
        if(!arg3)
            return -109;
        int i = (65536 + -(Rasterizer3D.cosinetable[1024 * arg4 / arg1]) >> 1);
        return (((65536 + -i) * arg0 >> 16) + (arg2 * i >> 16));
    }

    public void run() {
        try {
            if(Signlink.aString735 != null) {
                String string = Signlink.aString735.toLowerCase();
                if(string.indexOf("sun") == -1 && string.indexOf("apple") == -1) {
                    if(string.indexOf("ibm") != -1 && (Signlink.aString739 == null || Signlink.aString739.equals("1.4.2"))) {
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
            Class68_Sub1.aClass68_2213 = Class40_Sub5_Sub13.method649((IdentityKit.height), Class12.width, MouseHandler.aCanvas1469, -4875);
            method31(true);
            SceneCluster.aClass38_768 = Class56.method972((byte) 47);
            SceneCluster.aClass38_768.method443(-10115);
            while(CacheIndex.aLong219 == 0L || System.currentTimeMillis() < CacheIndex.aLong219) {
                Class40_Sub3.anInt2020 = SceneCluster.aClass38_768.method442(Class39.anInt912, (Class40_Sub3.anInt2024), 9799);
                for(int i = 0; (i < Class40_Sub3.anInt2020); i++)
                    method29(true);
                method26((byte) 88);
            }
        } catch(Exception exception) {
            CacheIndex.method169(null, (byte) -121, exception);
            openErrorPage((byte) 62, "crash");
        }
        method17();

    }

    public abstract void reset();

    public synchronized void method17() {
        if(!PacketBuffer.aBoolean2255) {
            PacketBuffer.aBoolean2255 = true;
            try {
                MouseHandler.aCanvas1469.removeFocusListener(this);
            } catch(Exception exception) {
                /* empty */
            }
            try {
                method24();
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
            reset();
        }
    }

    public void stop() {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255)
            CacheIndex.aLong219 = System.currentTimeMillis() + 4000L;
    }

    public boolean verifyHost(int arg0) {
        String string = getDocumentBase().getHost().toLowerCase();
        if(arg0 != 31)
            return false;
        if(string.endsWith("runescape.com"))
            return true;
        if(string.endsWith("127.0.0.1"))
            return true;
        for(/**/; (string.length() > 0 && string.charAt(string.length() - 1) >= '0' && (string.charAt(string.length() + -1) <= 57)); string = string.substring(0, string.length() - 1)) {
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
//                getAppletContext().showDocument(new URL(getCodeBase(), ("error_game_" + gameError + ".ws")));
            } catch(Exception exception) {
            }
            if(arg0 > 26)
                return;
            displayClientFrame((byte) 96, 68, 28, 85, -56);
        }

    }

    public void start() {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255)
            CacheIndex.aLong219 = 0L;
    }

    public abstract void method23();

    public void focusLost(FocusEvent arg0) {
        GenericTile.aBoolean1215 = false;
    }

    public abstract void method24();

    public synchronized void paint(Graphics arg0) {
        if(this == Class4.anApplet_Sub1_179 && !PacketBuffer.aBoolean2255) {
            Class40_Sub5_Sub11.clearScreen = true;
            if(Signlink.aString739 == null || !Signlink.aString739.startsWith("1.5") || -Class4.aLong174 + System.currentTimeMillis() <= 1000L)
                return;
            Rectangle rectangle = arg0.getClipBounds();
            if(rectangle == null || (rectangle.width >= Class12.width && ((rectangle.height >= IdentityKit.height))))
                Class67.aBoolean1575 = true;
        }
    }

    public void destroy() {
        if(Class4.anApplet_Sub1_179 == this && !PacketBuffer.aBoolean2255) {
            CacheIndex.aLong219 = System.currentTimeMillis();
            Class43.method890(5000L, -123);
            Actor.aClass31_3152 = null;
            method17();
        }
    }

    public void focusGained(FocusEvent arg0) {
        GenericTile.aBoolean1215 = true;
        Class40_Sub5_Sub11.clearScreen = true;
    }

    public URL getDocumentBase() {
        try {
            return new URL("http://" + Configuration.SERVER_ADDRESS + ":" + (Configuration.HTTP_PORT));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
            CacheIndex.method169(null, (byte) -126, exception);
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
            long l = System.currentTimeMillis();
            long l_11_ = aLongArray4[Class30.anInt681];
            aLongArray4[Class30.anInt681] = l;
            if(l_11_ != 0 && (l > l_11_)) {
                int i = (int) (-l_11_ + l);
                GenericTile.fps = ((i >> 1) + 32000) / i;
            }
            Class30.anInt681 = Class30.anInt681 + 1 & 0x1f;
            if(Node.anInt938++ > 50) {
                Node.anInt938 -= 50;
                Class40_Sub5_Sub11.clearScreen = true;
                MouseHandler.aCanvas1469.setSize(Class12.width, IdentityKit.height);
                MouseHandler.aCanvas1469.setVisible(true);
                if(Class35.aFrame1732 == null)
                    MouseHandler.aCanvas1469.setLocation(0, 0);
                else {
                    Insets insets = Class35.aFrame1732.getInsets();
                    MouseHandler.aCanvas1469.setLocation(insets.left, insets.top);
                }
            }
            method34(arg0 + -210);
        }
    }

//    public AppletContext getAppletContext() {
//        if(Class35.aFrame1732 != null)
//            return null;
//        if(ISAAC.aClass31_521 != null && ISAAC.aClass31_521.anApplet740 != this)
//            return ISAAC.aClass31_521.anApplet740.getAppletContext();
//        return super.getAppletContext();
//    }

    public void method29(boolean arg0) {
        long l = System.currentTimeMillis();
        long l_14_ = Class67.aLongArray1614[MouseHandler.anInt1468];
        if(l_14_ != 0L && l > l_14_) {
            /* empty */
        }
        Class67.aLongArray1614[MouseHandler.anInt1468] = l;
        MouseHandler.anInt1468 = 0x1f & MouseHandler.anInt1468 + 1;
        synchronized(this) {
            HashTable.aBoolean571 = GenericTile.aBoolean1215;
        }
        method23();
        if(arg0)
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
//            Class35.aFrame1732.setLocationRelativeTo(null);
            Actor.aClass31_3152 = ISAAC.aClass31_521 = new Signlink(true, null, inetAddress, fileStoreId, cacheFolder, cacheIndexes);
            ISAAC.aClass31_521.method394(1, 0, this);
        } catch(Exception exception) {
            CacheIndex.method169(null, (byte) -127, exception);
        }
    }

    public URL getCodeBase() {
        return this.getDocumentBase();
    }

    public abstract void method31(boolean bool);

    public void update(Graphics graphics) {
        paint(graphics);

    }

    public void windowClosing(WindowEvent windowEvent) {
        destroy();
    }

//    public String getParameter(String parameter) {
//        if(Class35.aFrame1732 != null)
//            return null;
//        if(ISAAC.aClass31_521 != null && this != ISAAC.aClass31_521.anApplet740)
//            return ISAAC.aClass31_521.anApplet740.getParameter(parameter);
//        return super.getParameter(parameter);
//    }

    public void windowDeactivated(WindowEvent windowEvent) {
    }

    public synchronized void setCanvas(byte arg0) {
        Container container  = Class35.aFrame1732;
//        else
//            container = ISAAC.aClass31_521.anApplet740;
        if(MouseHandler.aCanvas1469 != null) {
            MouseHandler.aCanvas1469.removeFocusListener(this);
            container.remove(MouseHandler.aCanvas1469);
        }
        MouseHandler.aCanvas1469 = new RSCanvas(this);
        container.add(MouseHandler.aCanvas1469);
        MouseHandler.aCanvas1469.setSize(Class12.width, IdentityKit.height);
        MouseHandler.aCanvas1469.setVisible(true);
        if(Class35.aFrame1732 != null) {
            Insets insets = Class35.aFrame1732.getInsets();
            MouseHandler.aCanvas1469.setLocation(insets.left, insets.top);
        } else
            MouseHandler.aCanvas1469.setLocation(0, 0);
        MouseHandler.aCanvas1469.addFocusListener(this);
        if(arg0 < 85)
            run();
        MouseHandler.aCanvas1469.requestFocus();
        Class40_Sub5_Sub11.clearScreen = true;
        Class67.aBoolean1575 = false;
        Class4.aLong174 = System.currentTimeMillis();
    }

    public abstract void method34(int i);

    public void windowDeiconified(WindowEvent windowEvent) {
    }

    public void windowClosed(WindowEvent windowEvent) {
    }

    public void windowActivated(WindowEvent windowEvent) {
    }
}
