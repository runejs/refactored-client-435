package org.runejs.client.util;

public class SignlinkNode {
    public enum Status {
        NOT_INITIALIZED(0),
        INITIALIZED(1),
        ERRORED(2);

        private final int value;

        Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

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

    public volatile Status status = Status.NOT_INITIALIZED;

    public Object objectData;
    public SignlinkNode prev;
    public volatile Object value;
}
