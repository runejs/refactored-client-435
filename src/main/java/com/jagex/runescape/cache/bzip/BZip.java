package com.jagex.runescape.cache.bzip;

public class BZip {

    private final static BZipContext context = new BZipContext();

    public static int decompressBzip(byte[] decompressed, int decompressedLength, byte[] bzippedData, int arg4) {
        synchronized(context) {
            context.compressed = bzippedData;
            context.nextIn = arg4;
            context.aByteArray837 = decompressed;
            context.anInt825 = 0;
            context.anInt823 = decompressedLength;
            context.bsLive = 0;
            context.bsBuff = 0;
            context.totalInLo32 = 0;
            context.anInt846 = 0;
            decompress(context);
            decompressedLength -= context.anInt823;
            context.compressed = null;
            context.aByteArray837 = null;
            return decompressedLength;
        }
    }

    public static void decompress(BZipContext bzip2Context) {
        int gMinLen = 0;
        int[] gLimit = null;
        int[] gBase = null;
        int[] gPerm = null;
        bzip2Context.blockSize100k = 1;
        if(BZipContext.tt == null) {
            BZipContext.tt = new int[bzip2Context.blockSize100k * 0x186a0];
        }
        boolean flag19 = true;
        while(flag19) {
            byte uc = getUChar(bzip2Context);
            if(uc == 23) {
                return;
            }
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getUChar(bzip2Context);
            uc = getBit(bzip2Context);
            bzip2Context.origPtr = 0;
            uc = getUChar(bzip2Context);
            bzip2Context.origPtr = bzip2Context.origPtr << 8 | uc & 0xff;
            uc = getUChar(bzip2Context);
            bzip2Context.origPtr = bzip2Context.origPtr << 8 | uc & 0xff;
            uc = getUChar(bzip2Context);
            bzip2Context.origPtr = bzip2Context.origPtr << 8 | uc & 0xff;
            for(int i = 0; i < 16; i++) {
                byte bit = getBit(bzip2Context);
                bzip2Context.inUse16[i] = bit == 1;
            }

            for(int i = 0; i < 256; i++) {
                bzip2Context.inUse[i] = false;
            }

            for(int i = 0; i < 16; i++) {
                if(bzip2Context.inUse16[i]) {
                    for(int j = 0; j < 16; j++) {
                        byte byte2 = getBit(bzip2Context);
                        if(byte2 == 1) {
                            bzip2Context.inUse[i * 16 + j] = true;
                        }
                    }

                }
            }

            makeMaps(bzip2Context);
            int alphaSize = bzip2Context.nInUse + 2;
            int nGroups = getBits(3, bzip2Context);
            int nSelectors = getBits(15, bzip2Context);
            for(int i = 0; i < nSelectors; i++) {
                int count = 0;
                do {
                    byte terminator = getBit(bzip2Context);
                    if(terminator == 0) {
                        break;
                    }
                    count++;
                } while(true);
                bzip2Context.selectorMtf[i] = (byte) count;
            }

            byte[] pos = new byte[6];
            for(byte v = 0; v < nGroups; v++) {
                pos[v] = v;
            }

            for(int i = 0; i < nSelectors; i++) {
                byte v = bzip2Context.selectorMtf[i];
                byte temp = pos[v];
                for(; v > 0; v--) {
                    pos[v] = pos[v - 1];
                }

                pos[0] = temp;
                bzip2Context.selector[i] = temp;
            }

            for(int t = 0; t < nGroups; t++) {
                int curr = getBits(5, bzip2Context);
                for(int i = 0; i < alphaSize; i++) {
                    do {
                        byte bit = getBit(bzip2Context);
                        if(bit == 0) {
                            break;
                        }
                        bit = getBit(bzip2Context);
                        if(bit == 0) {
                            curr++;
                        } else {
                            curr--;
                        }
                    } while(true);
                    bzip2Context.aByteArrayArray822[t][i] = (byte) curr;
                }

            }

            for(int t = 0; t < nGroups; t++) {
                byte minLen = 32;
                int maxLen = 0;
                for(int i = 0; i < alphaSize; i++) {
                    if(bzip2Context.aByteArrayArray822[t][i] > maxLen) {
                        maxLen = bzip2Context.aByteArrayArray822[t][i];
                    }
                    if(bzip2Context.aByteArrayArray822[t][i] < minLen) {
                        minLen = bzip2Context.aByteArrayArray822[t][i];
                    }
                }

                method294(bzip2Context.limit[t], bzip2Context.base[t], bzip2Context.perm[t],
                        bzip2Context.aByteArrayArray822[t], minLen, maxLen, alphaSize
                );
                bzip2Context.minLens[t] = minLen;
            }

            int eob = bzip2Context.nInUse + 1;
            //int l5 = 0x186a0 * class1.blockSize100k;
            int groupNo = -1;
            int groupPos = 0;
            for(int i = 0; i <= 255; i++) {
                bzip2Context.unzftab[i] = 0;
            }

            int kk = 4095;
            for(int ii = 15; ii >= 0; ii--) {
                for(int jj = 15; jj >= 0; jj--) {
                    bzip2Context.mtfa[kk] = (byte) (ii * 16 + jj);
                    kk--;
                }

                bzip2Context.mtfbase[ii] = kk + 1;
            }

            int nblock = 0;
            if(groupPos == 0) {
                groupNo++;
                groupPos = 50;
                byte gSel = bzip2Context.selector[groupNo];
                gMinLen = bzip2Context.minLens[gSel];
                gLimit = bzip2Context.limit[gSel];
                gPerm = bzip2Context.perm[gSel];
                gBase = bzip2Context.base[gSel];
            }
            groupPos--;
            int zn = gMinLen;
            int zvec;
            byte zj;
            for(zvec = getBits(zn, bzip2Context); zvec > gLimit[zn]; zvec = zvec << 1 | zj) {
                zn++;
                zj = getBit(bzip2Context);
            }

            for(int nextSym = gPerm[zvec - gBase[zn]]; nextSym != eob; ) {
                if(nextSym == 0 || nextSym == 1) {
                    int es = -1;
                    int n = 1;
                    do {
                        if(nextSym == 0) {
                            es += n;
                        } else if(nextSym == 1) {
                            es += 2 * n;
                        }
                        n *= 2;
                        if(groupPos == 0) {
                            groupNo++;
                            groupPos = 50;
                            byte gSel = bzip2Context.selector[groupNo];
                            gMinLen = bzip2Context.minLens[gSel];
                            gLimit = bzip2Context.limit[gSel];
                            gPerm = bzip2Context.perm[gSel];
                            gBase = bzip2Context.base[gSel];
                        }
                        groupPos--;
                        int zn_ = gMinLen;
                        int zvec_;
                        byte byte10;
                        for(zvec_ = getBits(zn_, bzip2Context); zvec_ > gLimit[zn_]; zvec_ = zvec_ << 1 | byte10) {
                            zn_++;
                            byte10 = getBit(bzip2Context);
                        }

                        nextSym = gPerm[zvec_ - gBase[zn_]];
                    } while(nextSym == 0 || nextSym == 1);
                    es++;
                    byte ec = bzip2Context.seqToUnseq[bzip2Context.mtfa[bzip2Context.mtfbase[0]] & 0xff];
                    bzip2Context.unzftab[ec & 0xff] += es;
                    for(; es > 0; es--) {
                        BZipContext.tt[nblock] = ec & 0xff;
                        nblock++;
                    }

                } else {
                    int nn = nextSym - 1;
                    byte uc_;
                    if(nn < 16) {
                        int j10 = bzip2Context.mtfbase[0];
                        uc_ = bzip2Context.mtfa[j10 + nn];
                        for(; nn > 3; nn -= 4) {
                            int k11 = j10 + nn;
                            bzip2Context.mtfa[k11] = bzip2Context.mtfa[k11 - 1];
                            bzip2Context.mtfa[k11 - 1] = bzip2Context.mtfa[k11 - 2];
                            bzip2Context.mtfa[k11 - 2] = bzip2Context.mtfa[k11 - 3];
                            bzip2Context.mtfa[k11 - 3] = bzip2Context.mtfa[k11 - 4];
                        }

                        for(; nn > 0; nn--) {
                            bzip2Context.mtfa[j10 + nn] = bzip2Context.mtfa[(j10 + nn) - 1];
                        }

                        bzip2Context.mtfa[j10] = uc_;
                    } else {
                        int l10 = nn / 16;
                        int i11 = nn % 16;
                        int k10 = bzip2Context.mtfbase[l10] + i11;
                        uc_ = bzip2Context.mtfa[k10];
                        for(; k10 > bzip2Context.mtfbase[l10]; k10--) {
                            bzip2Context.mtfa[k10] = bzip2Context.mtfa[k10 - 1];
                        }

                        bzip2Context.mtfbase[l10]++;
                        for(; l10 > 0; l10--) {
                            bzip2Context.mtfbase[l10]--;
                            bzip2Context.mtfa[bzip2Context.mtfbase[l10]] = bzip2Context.mtfa[
                                    (bzip2Context.mtfbase[l10 - 1] + 16) - 1];
                        }

                        bzip2Context.mtfbase[0]--;
                        bzip2Context.mtfa[bzip2Context.mtfbase[0]] = uc_;
                        if(bzip2Context.mtfbase[0] == 0) {
                            int i10 = 4095;
                            for(int k9 = 15; k9 >= 0; k9--) {
                                for(int l9 = 15; l9 >= 0; l9--) {
                                    bzip2Context.mtfa[i10] = bzip2Context.mtfa[bzip2Context.mtfbase[k9] + l9];
                                    i10--;
                                }

                                bzip2Context.mtfbase[k9] = i10 + 1;
                            }

                        }
                    }
                    bzip2Context.unzftab[bzip2Context.seqToUnseq[uc_ & 0xff] & 0xff]++;
                    BZipContext.tt[nblock] = bzip2Context.seqToUnseq[uc_ & 0xff] & 0xff;
                    nblock++;
                    if(groupPos == 0) {
                        groupNo++;
                        groupPos = 50;
                        byte byte14 = bzip2Context.selector[groupNo];
                        gMinLen = bzip2Context.minLens[byte14];
                        gLimit = bzip2Context.limit[byte14];
                        gPerm = bzip2Context.perm[byte14];
                        gBase = bzip2Context.base[byte14];
                    }
                    groupPos--;
                    int k7 = gMinLen;
                    int j8;
                    byte byte11;
                    for(j8 = getBits(k7, bzip2Context); j8 > gLimit[k7]; j8 = j8 << 1 | byte11) {
                        k7++;
                        byte11 = getBit(bzip2Context);
                    }

                    nextSym = gPerm[j8 - gBase[k7]];
                }
            }

            bzip2Context.stateOutLen = 0;
            bzip2Context.stateOutCh = 0;
            bzip2Context.cftab[0] = 0;
            System.arraycopy(bzip2Context.unzftab, 0, bzip2Context.cftab, 1, 256);

            for(int k2 = 1; k2 <= 256; k2++) {
                bzip2Context.cftab[k2] += bzip2Context.cftab[k2 - 1];
            }

            for(int l2 = 0; l2 < nblock; l2++) {
                byte byte7 = (byte) (BZipContext.tt[l2] & 0xff);
                BZipContext.tt[bzip2Context.cftab[byte7 & 0xff]] |= l2 << 8;
                bzip2Context.cftab[byte7 & 0xff]++;
            }

            bzip2Context.tPos = BZipContext.tt[bzip2Context.origPtr] >> 8;
            bzip2Context.nBlockUsed = 0;
            bzip2Context.tPos = BZipContext.tt[bzip2Context.tPos];
            bzip2Context.anInt811 = (byte) (bzip2Context.tPos & 0xff);
            bzip2Context.tPos >>= 8;
            bzip2Context.nBlockUsed++;
            bzip2Context.nBlock = nblock;
            method291(bzip2Context);
            flag19 = bzip2Context.nBlockUsed == bzip2Context.nBlock + 1 && bzip2Context.stateOutLen == 0;
        }
    }

    public static byte getUChar(BZipContext context) {
        return (byte) getBits(8, context);
    }

    public static int getBits(int bitCount, BZipContext context) {
        int bits;
        for(; ; ) {
            if(context.bsLive >= bitCount) {
                int i = context.bsBuff >> context.bsLive - bitCount & (1 << bitCount) - 1;
                context.bsLive -= bitCount;
                bits = i;
                break;
            }
            context.bsBuff = context.bsBuff << 8 | context.compressed[context.nextIn] & 0xff;
            context.bsLive += 8;
            context.nextIn++;
            context.totalInLo32++;
        }
        return bits;
    }

    public static void makeMaps(BZipContext context) {
        context.nInUse = 0;
        for(int i = 0; i < 256; i++) {
            if(context.inUse[i]) {
                context.seqToUnseq[context.nInUse] = (byte) i;
                context.nInUse++;
            }
        }
    }

    public static void method291(BZipContext arg0) {
        byte i = arg0.stateOutCh;
        int i_0_ = arg0.stateOutLen;
        int i_1_ = arg0.nBlockUsed;
        int i_2_ = arg0.anInt811;
        int[] is = BZipContext.tt;
        int i_3_ = arg0.tPos;
        byte[] is_4_ = arg0.aByteArray837;
        int i_5_ = arg0.anInt825;
        int i_6_ = arg0.anInt823;
        int i_7_ = i_6_;
        int i_8_ = arg0.nBlock + 1;
        while_10_:
        for(; ; ) {
            if(i_0_ > 0) {
                for(; ; ) {
                    if(i_6_ == 0) {
                        break while_10_;
                    }
                    if(i_0_ == 1) {
                        break;
                    }
                    is_4_[i_5_] = i;
                    i_0_--;
                    i_5_++;
                    i_6_--;
                }
                if(i_6_ == 0) {
                    i_0_ = 1;
                    break;
                }
                is_4_[i_5_] = i;
                i_5_++;
                i_6_--;
            }
            boolean bool = true;
            while(bool) {
                bool = false;
                if(i_1_ == i_8_) {
                    i_0_ = 0;
                    break while_10_;
                }
                i = (byte) i_2_;
                i_3_ = is[i_3_];
                int i_9_ = (byte) (i_3_ & 0xff);
                i_3_ >>= 8;
                i_1_++;
                if(i_9_ != i_2_) {
                    i_2_ = i_9_;
                    if(i_6_ == 0) {
                        i_0_ = 1;
                        break while_10_;
                    }
                    is_4_[i_5_] = i;
                    i_5_++;
                    i_6_--;
                    bool = true;
                } else if(i_1_ == i_8_) {
                    if(i_6_ == 0) {
                        i_0_ = 1;
                        break while_10_;
                    }
                    is_4_[i_5_] = i;
                    i_5_++;
                    i_6_--;
                    bool = true;
                }
            }
            i_0_ = 2;
            i_3_ = is[i_3_];
            int i_10_ = (byte) (i_3_ & 0xff);
            i_3_ >>= 8;
            if(++i_1_ != i_8_) {
                if(i_10_ == i_2_) {
                    i_0_ = 3;
                    i_3_ = is[i_3_];
                    i_10_ = (byte) (i_3_ & 0xff);
                    i_3_ >>= 8;
                    if(++i_1_ != i_8_) {
                        if(i_10_ == i_2_) {
                            i_3_ = is[i_3_];
                            i_10_ = (byte) (i_3_ & 0xff);
                            i_3_ >>= 8;
                            i_1_++;
                            i_0_ = (i_10_ & 0xff) + 4;
                            i_3_ = is[i_3_];
                            i_2_ = (byte) (i_3_ & 0xff);
                            i_3_ >>= 8;
                            i_1_++;
                        } else {
                            i_2_ = i_10_;
                        }
                    }
                } else {
                    i_2_ = i_10_;
                }
            }
        }
        arg0.anInt846 += i_7_ - i_6_;
        arg0.stateOutCh = i;
        arg0.stateOutLen = i_0_;
        arg0.nBlockUsed = i_1_;
        arg0.anInt811 = i_2_;
        BZipContext.tt = is;
        arg0.tPos = i_3_;
        arg0.aByteArray837 = is_4_;
        arg0.anInt825 = i_5_;
        arg0.anInt823 = i_6_;
    }

    public static byte getBit(BZipContext context) {
        return (byte) getBits(1, context);
    }

    public static void method294(int[] arg0, int[] arg1, int[] arg2, byte[] arg3, int arg4, int arg5, int arg6) {
        int i = 0;
        for(int i_84_ = arg4; i_84_ <= arg5; i_84_++) {
            for(int i_85_ = 0; i_85_ < arg6; i_85_++) {
                if(arg3[i_85_] == i_84_) {
                    arg2[i] = i_85_;
                    i++;
                }
            }
        }
        for(int i_86_ = 0; i_86_ < 23; i_86_++) {
            arg1[i_86_] = 0;
        }
        for(int i_87_ = 0; i_87_ < arg6; i_87_++) {
            arg1[arg3[i_87_] + 1]++;
        }
        for(int i_88_ = 1; i_88_ < 23; i_88_++) {
            arg1[i_88_] += arg1[i_88_ - 1];
        }
        for(int i_89_ = 0; i_89_ < 23; i_89_++) {
            arg0[i_89_] = 0;
        }
        int i_90_ = 0;
        for(int i_91_ = arg4; i_91_ <= arg5; i_91_++) {
            i_90_ += arg1[i_91_ + 1] - arg1[i_91_];
            arg0[i_91_] = i_90_ - 1;
            i_90_ <<= 1;
        }
        for(int i_92_ = arg4 + 1; i_92_ <= arg5; i_92_++) {
            arg1[i_92_] = (arg0[i_92_ - 1] + 1 << 1) - arg1[i_92_];
        }
    }
}
