package org.runejs.client;

import org.runejs.client.node.OnDemandRequest;

public class OnDemandRequestProcessor implements Runnable {
    /**
     * Cache archive cache?
     */
    public static LinkedList aLinkedList_53 = new LinkedList();

    private static int anInt1987 = 0;

    private static LinkedList aLinkedList_2604 = new LinkedList();

    private static Object lock = new Object();

    public static void create(int arg0) {
        synchronized (lock) {
            if (anInt1987 == 0)
                Game.signlink.putThreadNode(5, new OnDemandRequestProcessor());
            anInt1987 = arg0;
        }
    }

    public static void wait(int arg0) {
        synchronized(lock) {
            if((anInt1987 ^ 0xffffffff) != arg0) {
                anInt1987 = 1;
                try {
                    lock.wait();
                } catch(InterruptedException interruptedexception) {
                    /* empty */
                }
            }
        }
    }

    public static void handleRequests() {
        for(; ; ) {
            OnDemandRequest onDemandRequest;
            synchronized(aLinkedList_53) {
                onDemandRequest = (OnDemandRequest) aLinkedList_2604.removeFirst();
            }
            if(onDemandRequest == null)
                break;
            onDemandRequest.cacheArchive.method198(false, onDemandRequest.data, (int) onDemandRequest.key, onDemandRequest.cacheIndex);
        }
    }

    public void run() {
        try {
            for(; ; ) {
                OnDemandRequest onDemandRequest;
                synchronized(aLinkedList_53) {
                    onDemandRequest = (OnDemandRequest) aLinkedList_53.peekFirst();
                }
                if(onDemandRequest == null) {
                    MovedStatics.threadSleep(100L);
                    synchronized(lock) {
                        if(anInt1987 <= 1) {
                            anInt1987 = 0;
                            lock.notifyAll();
                            break;
                        }
                        anInt1987--;
                    }
                } else {
                    if(onDemandRequest.type == 0) {
                        onDemandRequest.cacheIndex.put(onDemandRequest.data, onDemandRequest.data.length, (int) onDemandRequest.key);
                        synchronized(aLinkedList_53) {
                            onDemandRequest.unlink();
                        }
                    } else if(onDemandRequest.type == 1) {
                        onDemandRequest.data = onDemandRequest.cacheIndex.get((int) onDemandRequest.key);
                        synchronized(aLinkedList_53) {
                            aLinkedList_2604.addLast(onDemandRequest);
                        }
                    }
                    synchronized(lock) {
                        if(anInt1987 <= 1) {
                            anInt1987 = 0;
                            lock.notifyAll();
                            break;
                        }
                        anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }
}
