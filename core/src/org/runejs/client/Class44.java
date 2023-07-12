package org.runejs.client;

import org.runejs.client.node.Class40_Sub6;

public class Class44 implements Runnable {
    public void run() {
        try {
            for(; ; ) {
                Class40_Sub6 class40_sub6;
                synchronized(MovedStatics.aLinkedList_53) {
                    class40_sub6 = (Class40_Sub6) MovedStatics.aLinkedList_53.peekFirst();
                }
                if(class40_sub6 == null) {
                    MovedStatics.threadSleep(100L);
                    synchronized(MovedStatics.anObject162) {
                        if(MovedStatics.anInt1987 <= 1) {
                            MovedStatics.anInt1987 = 0;
                            MovedStatics.anObject162.notifyAll();
                            break;
                        }
                        MovedStatics.anInt1987--;
                    }
                } else {
                    if(class40_sub6.anInt2112 == 0) {
                        class40_sub6.cacheIndex.put(class40_sub6.aByteArray2102, class40_sub6.aByteArray2102.length, (int) class40_sub6.key);
                        synchronized(MovedStatics.aLinkedList_53) {
                            class40_sub6.unlink();
                        }
                    } else if(class40_sub6.anInt2112 == 1) {
                        class40_sub6.aByteArray2102 = class40_sub6.cacheIndex.get((int) class40_sub6.key);
                        synchronized(MovedStatics.aLinkedList_53) {
                            MovedStatics.aLinkedList_2604.addLast(class40_sub6);
                        }
                    }
                    synchronized(MovedStatics.anObject162) {
                        if(MovedStatics.anInt1987 <= 1) {
                            MovedStatics.anInt1987 = 0;
                            MovedStatics.anObject162.notifyAll();
                            break;
                        }
                        MovedStatics.anInt1987 = 600;
                    }
                }
            }
        } catch(Exception exception) {
            MovedStatics.printException(null, exception);
        }
    }
}
