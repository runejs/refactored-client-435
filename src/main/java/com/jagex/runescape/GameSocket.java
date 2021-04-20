package com.jagex.runescape;

import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class GameSocket implements Runnable {
    public InputStream socketInputStream;
    public OutputStream socketOutputStream;
    public Socket socket;
    public SignlinkNode signLinkNode;
    public Signlink signLink;
    public boolean socketError;

    public int anInt1509 = 0;
    public int anInt1520 = 0;
    public boolean socketInitialized;
    public byte[] aByteArray1504;

    public GameSocket(Socket socket, Signlink signLink) throws IOException {
        socketInitialized = false;
        socketError = false;
        this.signLink = signLink;
        this.socket = socket;
        this.socket.setSoTimeout(30000);
        this.socket.setTcpNoDelay(true);
        socketInputStream = this.socket.getInputStream();
        socketOutputStream = this.socket.getOutputStream();
    }


    public void method1008(int arg0, int arg1, int arg2, byte[] arg3) throws IOException {
        if (!socketInitialized && arg2 < -126) {
            while (arg1 > 0) {
                int i = socketInputStream.read(arg3, arg0, arg1);
                if (i <= 0)
                    throw new EOFException();
                arg1 -= i;
                arg0 += i;
            }
        }
    }

    public void method1009() {
        if (!socketInitialized) {
            synchronized (this) {
                socketInitialized = true;
                this.notifyAll();
            }
            if (signLinkNode != null) {
                while (signLinkNode.anInt434 == 0)
                    Class43.sleep(1L);
                if (signLinkNode.anInt434 == 1) {
                    try {
                        ((Thread) signLinkNode.value).join();
                    } catch (InterruptedException interruptedexception) {
                        interruptedexception.printStackTrace();
                        /* empty */
                    }
                }
            }
            signLinkNode = null;
        }
    }

    public void method1010(int arg0, int arg2, byte[] arg3) throws IOException {
        if (!socketInitialized) {
            if (socketError) {
                socketError = false;
                throw new IOException();
            }
            if (aByteArray1504 == null)
                aByteArray1504 = new byte[5000];
            synchronized (this) {
                for (int i = 0; i < arg0; i++) {
                    aByteArray1504[anInt1509] = arg3[arg2 + i];
                    anInt1509 = (1 + anInt1509) % 5000;
                    if (anInt1509 == (4900 + anInt1520) % 5000)
                        throw new IOException();
                }
                if (signLinkNode == null)
                    signLinkNode = signLink.createCanvasNode(3, this);
                this.notifyAll();
            }
        }
    }

    public void finalize() {
        method1009();
    }

    public void run() {
        try {
            for (; ; ) {
                int i;
                int i_0_;
                synchronized (this) {
                    if (anInt1509 == anInt1520) {
                        if (socketInitialized) {
                            break;
                        }
                        try {
                            this.wait();
                        } catch (InterruptedException interruptedexception) {
                            /* empty */
                            interruptedexception.printStackTrace();
                        }
                    }
                    if (anInt1509 >= anInt1520)
                        i = anInt1509 - anInt1520;
                    else
                        i = -anInt1520 + 5000;
                    i_0_ = anInt1520;
                }
                if (i > 0) {
                    try {
                        socketOutputStream.write(aByteArray1504, i_0_, i);
                    } catch (IOException ioexception) {
                        socketError = true;
                    }
                    anInt1520 = (i + anInt1520) % 5000;
                    try {
                        if (anInt1520 == anInt1509)
                            socketOutputStream.flush();
                    } catch (IOException ioexception) {
                        ioexception.printStackTrace();
                        socketError = true;
                    }
                }
            }
            try {
                if (socketInputStream != null)
                    socketInputStream.close();
                if (socketOutputStream != null)
                    socketOutputStream.close();
                if (socket != null)
                    socket.close();
            } catch (IOException ioexception) {
                /* empty */
                ioexception.printStackTrace();
            }
            aByteArray1504 = null;
        } catch (Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }

    public int method1014(int arg0) throws IOException {
        if (arg0 >= -120)
            signLink = null;
        if (socketInitialized)
            return 0;
        return socketInputStream.available();
    }

    public int read() throws IOException {
        if (socketInitialized)
            return 0;
        return socketInputStream.read();
    }
}
