package com.jagex.runescape.cache.bzip;

public class BZipContext {

    public static int[] tt;
    public int origPtr;
    public int nBlockUsed;
    public byte[] selector = new byte[18002];
    public int nBlock;
    public int blockSize100k;
    public int anInt811;
    public int stateOutLen;
    public byte[] seqToUnseq;
    public int[] cftab;
    public int[] mtfbase = new int[16];
    public byte stateOutCh;
    public int tPos;
    public byte[][] aByteArrayArray822;
    public int anInt823;
    public boolean[] inUse16;
    public int anInt825;
    public int[] minLens;
    public boolean[] inUse;
    public byte[] compressed;
    public int totalInLo32;
    public int nextIn;
    public int[][] perm;
    public int bsBuff;
    public int[][] limit;
    public byte[] aByteArray837;
    public byte[] selectorMtf;
    public byte[] mtfa;
    public int[][] base;
    public int nInUse;
    public int[] unzftab;
    public int anInt846;
    public int bsLive;

    public BZipContext() {
        seqToUnseq = new byte[256];
        anInt825 = 0;
        inUse16 = new boolean[16];
        cftab = new int[257];
        aByteArrayArray822 = new byte[6][258];
        nextIn = 0;
        minLens = new int[6];
        perm = new int[6][258];
        unzftab = new int[256];
        inUse = new boolean[256];
        base = new int[6][258];
        limit = new int[6][258];
        mtfa = new byte[4096];
        selectorMtf = new byte[18002];
    }

}
