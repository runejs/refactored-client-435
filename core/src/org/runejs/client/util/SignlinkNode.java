package org.runejs.client.util;

public class SignlinkNode {
    public int integerData;

    /**
     * 1 = Create connection, save the socket to value
     * 2 = Start the thread with objectData, save the thread to value
     * 4 = Create a data input stream, save the stream to value
     * 9 = Call a class constructor dynamically from objectData, where objectData[0] is the class, objectData[1] is a string param, and objectData[2] is an array param (??)
     * 10 = Call a class constructor dynamically from objectData, where objectData[0] is the class and objectData[1] is a string param
     * Other values will throw an Exception.
     */
    public int type;

    /**
     * 0 = Not initialized
     * 1 = Initialized
     * 2 = Errored
     */
    public volatile int status = 0;

    public Object objectData;
    public SignlinkNode prev;
    public volatile Object value;
}
