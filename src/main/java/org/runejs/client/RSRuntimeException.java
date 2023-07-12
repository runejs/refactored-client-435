package org.runejs.client;

public class RSRuntimeException extends RuntimeException {
    public Throwable aThrowable1652;
    public String aString1653;

    public RSRuntimeException(Throwable arg0, String arg1) {
        aString1653 = arg1;
        aThrowable1652 = arg0;
    }
}
