package org.runejs.client.util;

import org.runejs.client.SizedAccessFile;
import org.runejs.client.GameShell;
import org.runejs.Configuration;
import org.runejs.client.cache.system.CacheLocator;
import org.runejs.client.cache.system.JagexCacheLocator;

import java.io.*;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class Signlink implements Runnable {
    public static Method setFocusCycleRoot;
    private static String homeDirectory;
    public static Method setFocusTraversalKeysEnabled;
    public static String javaVendor;
    public static int anInt737 = 3;
    public static String javaVersion;
    public boolean killed;
    public int uid = 0;
    public SizedAccessFile[] dataIndexAccessFiles;
    public SignlinkNode current = null;
    public SizedAccessFile metaIndexAccessFile;
    public InetAddress netAddress;
    public SignlinkNode next = null;
    public Thread signLinkThread;
    public SizedAccessFile cacheDataAccessFile;
    public GameShell gameShell;

    private CacheLocator cacheLocator = new JagexCacheLocator();

    public Signlink(boolean loadCache, GameShell gameShell, InetAddress netAddress, int fileStoreId, String cacheFolder, int cacheIndexes) throws IOException {
        metaIndexAccessFile = null;
        cacheDataAccessFile = null;
        this.gameShell = gameShell;
        this.netAddress = netAddress;
        javaVersion = "1.1";
        javaVendor = "Unknown";
        try {
            javaVendor = System.getProperty("java.vendor");
            javaVersion = System.getProperty("java.version");
            homeDirectory = System.getProperty("user.home");
            if(homeDirectory != null)
                homeDirectory += "/";
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(gameShell == null)
                setFocusTraversalKeysEnabled = Class.forName("java.awt.Component").getDeclaredMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
            else
                setFocusTraversalKeysEnabled = gameShell.getClass().getMethod("setFocusTraversalKeysEnabled", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        try {
            if(gameShell != null)
                setFocusCycleRoot = gameShell.getClass().getMethod("setFocusCycleRoot", Boolean.TYPE);
            else
                setFocusCycleRoot = Class.forName("java.awt.Container").getDeclaredMethod("setFocusCycleRoot", Boolean.TYPE);
        } catch(Exception exception) {
            /* empty */
        }
        if(loadCache) {
            String cachePath = cacheLocator.getCachePath(homeDirectory);
            cacheDataAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.dat2"), "rw", 52428800L);
            dataIndexAccessFiles = new SizedAccessFile[cacheIndexes];
            for(int currentIndex = 0; currentIndex < cacheIndexes; currentIndex++)
                dataIndexAccessFiles[currentIndex] = new SizedAccessFile(new File(cachePath + "main_file_cache.idx" + currentIndex), "rw", 1048576L);
            metaIndexAccessFile = new SizedAccessFile(new File(cachePath + "main_file_cache.idx255"), "rw", 1048576L);
            initializeUniqueIdentifier(cachePath);
        }
        killed = false;
        signLinkThread = new Thread(this);
        signLinkThread.setPriority(10);
        signLinkThread.setDaemon(true);
        signLinkThread.start();

    }

    public void killSignlinkThread() {
        synchronized(this) {
            killed = true;
            this.notifyAll();
        }
        try {
            signLinkThread.join();
        } catch(InterruptedException interruptedexception) {
            /* empty */
        }
        if(cacheDataAccessFile != null) {
            try {
                cacheDataAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(metaIndexAccessFile != null) {
            try {
                metaIndexAccessFile.close();
            } catch(IOException ioexception) {
                /* empty */
            }
        }
        if(dataIndexAccessFiles != null) {
            for(int i = 0; i < dataIndexAccessFiles.length; i++) {
                if(dataIndexAccessFiles[i] != null) {
                    try {
                        dataIndexAccessFiles[i].close();
                    } catch(IOException ioexception) {
                        /* empty */
                    }
                }
            }
        }
    }

    public SignlinkNode putNode(int integerData, SignlinkNode.Type type, Object objectData) {
        SignlinkNode signlinkNode = new SignlinkNode();
        signlinkNode.objectData = objectData;
        signlinkNode.integerData = integerData;
        signlinkNode.type = type;
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

    public SignlinkNode putMethodNode(Class[] argumentTypes, String functionName, Class functionType) {
        return putNode(0, SignlinkNode.Type.METHOD, new Object[]{functionType, functionName, argumentTypes});

    }

    public SignlinkNode putDataInputStreamNode(URL url) {
        return putNode(0, SignlinkNode.Type.DATA_INPUT_STREAM, url);
    }

    public SignlinkNode putFieldNode(Class variableType, String variableName) {
        return putNode(0, SignlinkNode.Type.FIELD, new Object[]{ variableType, variableName });
    }

    // TODO this will just throw an exception, since type 3 isn't handled
    public SignlinkNode putExceptionNode(int arg1) {
        return putNode(arg1, SignlinkNode.Type.EXCEPTION, null);
    }

    public SignlinkNode putThreadNode(int nodeId, Runnable runnableClass) {
        return putNode(nodeId, SignlinkNode.Type.THREAD, runnableClass);
    }

    public SignlinkNode putSocketNode(int port) {
        return putNode(port, SignlinkNode.Type.SOCKET, null);
    }

    public void initializeUniqueIdentifier(String cachePath) {
        try {
            File file = new File(cachePath + "uid.dat");
            if(!file.exists() || file.length() < 4) {
                DataOutputStream dataoutputstream = new DataOutputStream(new FileOutputStream(cachePath + "uid.dat"));
                dataoutputstream.writeInt((int) (9.9999999E7 * Math.random()));
                dataoutputstream.close();
            }
        } catch(Exception exception) {
            /* empty */
        }
        try {
            DataInputStream datainputstream = new DataInputStream(new FileInputStream(cachePath + "uid.dat"));
            uid = 1 + datainputstream.readInt();
            datainputstream.close();
        } catch(Exception exception) {
            /* empty */
        }
    }

    public void run() {
        for(; ; ) {
            SignlinkNode currentNode;
            synchronized(this) {
                for(; ; ) {
                    if(killed)
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
                SignlinkNode.Type type = currentNode.type;
                if (type == SignlinkNode.Type.SOCKET) {
                    // Create connection
                    currentNode.value = new Socket(netAddress, currentNode.integerData);
                } else if(type == SignlinkNode.Type.THREAD) {
                    // Start thread
                    Thread thread = new Thread((Runnable) currentNode.objectData);
                    thread.setDaemon(true);
                    thread.start();
                    thread.setPriority(currentNode.integerData);
                    currentNode.value = thread;
                } else if(type == SignlinkNode.Type.DATA_INPUT_STREAM)
                    currentNode.value = new DataInputStream(((URL) currentNode.objectData).openStream());
                else if(type == SignlinkNode.Type.METHOD) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredMethod((String) objects[1], (Class[]) objects[2]);
                } else if(type == SignlinkNode.Type.FIELD) {
                    Object[] objects = (Object[]) currentNode.objectData;
                    currentNode.value = ((Class) objects[0]).getDeclaredField((String) objects[1]);
                } else {
                    throw new Exception();
                }

                currentNode.status = SignlinkNode.Status.INITIALIZED;
            } catch(Exception exception) {
                currentNode.status = SignlinkNode.Status.ERRORED;
            }
        }

    }

    public SignlinkNode method396(int arg0) {

        if(arg0 < 81)
            return null;
        return null;

    }
}
