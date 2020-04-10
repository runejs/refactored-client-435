package com.jagex.runescape.util;

import com.jagex.runescape.Class47;
import com.jagex.runescape.Interface2;
import com.jagex.runescape.GameShell;
import com.jagex.runescape.Runnable_Impl1;
import tech.henning.fourthreefive.Configuration;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {
    public static Method aMethod724;
    public static String homeDirectory;
    public static Method aMethod729;
    public static String aString735;
    public static int anInt737 = 3;
    public static String aString739;
    public boolean aBoolean721;
    public int uid = 0;
    public Class47[] cacheIndex;
    public SignlinkNode current = null;
    public Runnable_Impl1 aRunnable_Impl1_727;
    public Class47 aClass47_728;
    public InetAddress anInetAddress730;
    public SignlinkNode next = null;
    public Interface2 anInterface2_732;
    public Thread aThread733;
    public String aString734 = null;
    public Class47 cacheData;
    public GameShell anApplet740;

    public Signlink(boolean arg0, GameShell arg1, InetAddress inetAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        aClass47_728 = null;
        cacheData = null;
        anApplet740 = null;
        anApplet740 = arg1;
        anInetAddress730 = inetAddress;
        aString739 = "1.1";
        aString735 = "Unknown";
        try {
            aString735 = System.getProperty("java.vendor");
            aString739 = System.getProperty("java.version");
            homeDirectory = System.getProperty("user.home");
            if(homeDirectory != null)
                homeDirectory += "/";
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 == null)
                aMethod729 = (Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE));
            else
                aMethod729 = (arg1.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE));
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(arg1 != null)
                aMethod724 = arg1.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                aMethod724 = (Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE));
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0) {
            method397(-3849);
            cacheData = new Class47(new File(aString734 + "main_file_cache.dat2"), "rw", 52428800L);
            cacheIndex = new Class47[cacheIndexes];
            for(int i = 0; i < cacheIndexes; i++)
                cacheIndex[i] = new Class47(new File(aString734 + "main_file_cache.idx" + i), "rw", 1048576L);
            aClass47_728 = new Class47(new File(aString734 + "main_file_cache.idx255"), "rw", 1048576L);
            method390(6);
        }
        aBoolean721 = false;
        aThread733 = new Thread(this);
        aThread733.setPriority(10);
        aThread733.setDaemon(true);
        aThread733.start();

    }

    public void method385(int arg0) {
        synchronized(this) {
            aBoolean721 = true;
            this.notifyAll();
        }
        try {
            aThread733.join();
            if(arg0 != 0)
                method396(-55);
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
        if(aRunnable_Impl1_727 != null)
            aRunnable_Impl1_727.method1((byte) -102);
        if(cacheData != null) {
            try {
                cacheData.method917(1);
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(aClass47_728 != null) {
            try {
                aClass47_728.method917(arg0 ^ 0x1);
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(cacheIndex != null) {
            for(int i = 0; i < cacheIndex.length; i++) {
                if(cacheIndex[i] != null) {
                    try {
                        cacheIndex[i].method917(arg0 ^ 0x1);
                    } catch(IOException ioexception) {
                        /* empty */
                    }
                }
            }
        }
    }

    public SignlinkNode method386(Class[] arg0, String arg1, Class arg2, byte arg3) {
        if(arg3 > -5)
            putNode(-109, 81, null);
        return putNode(0, 9, new Object[]{arg2, arg1, arg0});

    }

    public Interface2 method387(int arg0) {

        if(arg0 != -25100)
            return null;
        return anInterface2_732;

    }

    public SignlinkNode method388(boolean arg0, URL arg1) {

        if(arg0)
            method397(-42);
        return putNode(0, 4, arg1);

    }

    public SignlinkNode putNode(int arg1, int arg2, Object arg4) {

        SignlinkNode signlinkNode = new SignlinkNode();
        signlinkNode.objectData = arg4;
        signlinkNode.integerData = arg1;
        signlinkNode.type = arg2;
        synchronized(this) {
            if(next == null)
                next = current = signlinkNode;
            else {
                next.prev = signlinkNode;
                next = signlinkNode;
            }
            this.notify();
        }
        return signlinkNode;

    }

    public void method390(int arg0) {

        try {
            File file = new File(aString734 + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = (new DataOutputStream(new FileOutputStream(aString734 + "uid.dat")));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        if(arg0 != 6)
            uid = 116;
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(aString734 + "uid.dat"));
            uid = 1 + datainputstream.readInt();
            datainputstream.close();
        } catch(Exception exception) {
            /* empty */
        }

    }

    public Runnable_Impl1 method391(int arg0) {

        if(arg0 != 1048576)
            method396(-47);
        return aRunnable_Impl1_727;

    }

    public void run() {

        for(; ; ) {
            SignlinkNode currentNode;
            synchronized(this) {
                for(; ; ) {
                    if(aBoolean721)
                        return;
                    if(current != null) {
                        currentNode = current;
                        current = current.prev;
                        if(current == null)
                            next = null;
                        break;
                    }
                    try {
                        this.wait();
                    } catch(InterruptedException interruptedexception) {
                        /* empty */
                    }
                }
            }
            try {
                int type = currentNode.type;
                if(type == 1)
                    currentNode.value = new Socket(anInetAddress730, currentNode.integerData);
                else if(type == 2) {
                    Thread thread = new Thread((Runnable) currentNode.objectData);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(currentNode.integerData);
                    currentNode.value = thread;
                } else if(type == 4)
                    currentNode.value = new DataInputStream(((URL) currentNode.objectData).openStream());
                else if(type == 9) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = (((Class) objects[0]).getDeclaredMethod((String) objects[1], (Class[]) objects[2]));
                } else if(type == 10) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredField((String) objects[1]);
                } else
                    throw new Exception();
                currentNode.anInt434 = 1;
            } catch(Exception exception) {
                currentNode.anInt434 = 2;
            }
        }

    }

    public SignlinkNode method392(Class arg0, String arg1, boolean arg2) {

        if(!arg2)
            aString735 = null;
        return putNode(0, 10, new Object[]{arg0, arg1});

    }

    public SignlinkNode method393(int arg0, int arg1) {
        return putNode(arg1, 3, null);

    }

    public SignlinkNode method394(int arg0, int arg1, Runnable arg2) {

        if(arg1 != 0)
            method392(null, null, false);
        return putNode(arg0, 2, arg2);

    }

    public SignlinkNode method395(int arg0, int arg1) {

        if(arg0 != 3)
            method397(-29);
        return putNode(arg1, 1, null);

    }

    public SignlinkNode method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }

    public void method397(int arg0) {

        if(homeDirectory == null)
            homeDirectory = "~/";
        String[] cacheLocations = {"c:/rsrcache/", "/rsrcache/", "c:/windows/", "c:/winnt/", "d:/windows/", "d:/winnt/", "e:/windows/", "e:/winnt/", "f:/windows/", "f:/winnt/", "c:/", homeDirectory, "/tmp/", ""};
        if(arg0 != -3849)
            method392(null, null, false); // TODO: Does this even ever run?
        for(String cacheLocation : cacheLocations) {
            try {
                if(cacheLocation.length() > 0) {
                    File file = new File(cacheLocation);
                    if(!file.exists())
                        continue;
                }
                File file = new File(cacheLocation + Configuration.CACHE_NAME);
                if(file.exists() || file.mkdir()) {
                    aString734 = file.getPath() + "/";
                    return;
                }
            } catch(Exception exception) {
            }
        }
        throw new RuntimeException();

    }
}
