package com.jagex.runescape;

public final class JSObject {

    static {
        String liveConnectLibrary = System.getProperty("netscape.jsj.dll", null);
        if(liveConnectLibrary != null) {
            System.loadLibrary(liveConnectLibrary);
            initClass();
        }
    }

    @SuppressWarnings("unused")
    private int internal;
    @SuppressWarnings("unused")
    private long long_internal;

    private JSObject(int jsobj_addr) {
        internal = jsobj_addr;
    }

    private JSObject(long jsobj_addr) {
        long_internal = jsobj_addr;
    }

    public static native JSObject getWindow();

    private static native void initClass();

    public native Object call(String methodName, Object[] args);

    @Override
    public native boolean equals(Object obj);

    public native Object eval(String s);

    @Override
    protected native void finalize();

    public native Object getMember(String name);

    public native Object getSlot(int index);

    public native void removeMember(String name);

    public native void setMember(String name, Object value);

    public native void setSlot(int index, Object value);

    @Override
    public native String toString();

}
