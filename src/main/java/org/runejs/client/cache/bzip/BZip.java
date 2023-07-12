package org.runejs.client.cache.bzip;

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
        if (BZipContext.tt == null)
            BZipContext.tt = new int[bzip2Context.blockSize100k * 0x186a0];
        boolean flag19 = true;
        while (flag19) {
            byte uc = getUChar(bzip2Context);
            if (uc == 23)
                return;
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
            for (int i = 0; i < 16; i++) {
                byte bit = getBit(bzip2Context);
                bzip2Context.inUse16[i] = bit == 1;
            }

            for (int i = 0; i < 256; i++)
                bzip2Context.inUse[i] = false;

            for (int i = 0; i < 16; i++)
                if (bzip2Context.inUse16[i]) {
                    for (int j = 0; j < 16; j++) {
                        byte byte2 = getBit(bzip2Context);
                        if (byte2 == 1)
                            bzip2Context.inUse[i * 16 + j] = true;
                    }

                }

            makeMaps(bzip2Context);
            int alphaSize = bzip2Context.nInUse + 2;
            int nGroups = getBits(3, bzip2Context);
            int nSelectors = getBits(15, bzip2Context);
            for (int i = 0; i < nSelectors; i++) {
                int count = 0;
                do {
                    byte terminator = getBit(bzip2Context);
                    if (terminator == 0)
                        break;
                    count++;
                } while (true);
                bzip2Context.selectorMtf[i] = (byte) count;
            }

            byte[] pos = new byte[6];
            for (byte v = 0; v < nGroups; v++)
                pos[v] = v;

            for (int i = 0; i < nSelectors; i++) {
                byte v = bzip2Context.selectorMtf[i];
                byte temp = pos[v];
                for (; v > 0; v--)
                    pos[v] = pos[v - 1];

                pos[0] = temp;
                bzip2Context.selector[i] = temp;
            }

            for (int t = 0; t < nGroups; t++) {
                int curr = getBits(5, bzip2Context);
                for (int i = 0; i < alphaSize; i++) {
                    do {
                        byte bit = getBit(bzip2Context);
                        if (bit == 0)
                            break;
                        bit = getBit(bzip2Context);
                        if (bit == 0)
                            curr++;
                        else
                            curr--;
                    } while (true);
                    bzip2Context.codeLengths[t][i] = (byte) curr;
                }

            }

            for (int t = 0; t < nGroups; t++) {
                byte minLen = 32;
                int maxLen = 0;
                for (int i = 0; i < alphaSize; i++) {
                    if (bzip2Context.codeLengths[t][i] > maxLen)
                        maxLen = bzip2Context.codeLengths[t][i];
                    if (bzip2Context.codeLengths[t][i] < minLen)
                        minLen = bzip2Context.codeLengths[t][i];
                }

                createHuffmanDecodingTables(bzip2Context.limit[t], bzip2Context.base[t], bzip2Context.perm[t],
                        bzip2Context.codeLengths[t], minLen, maxLen, alphaSize);
                bzip2Context.minLens[t] = minLen;
            }

            int eob = bzip2Context.nInUse + 1;
            //int l5 = 0x186a0 * class1.blockSize100k;
            int groupNo = -1;
            int groupPos = 0;
            for (int i = 0; i <= 255; i++)
                bzip2Context.unzftab[i] = 0;

            int kk = 4095;
            for (int ii = 15; ii >= 0; ii--) {
                for (int jj = 15; jj >= 0; jj--) {
                    bzip2Context.mtfa[kk] = (byte) (ii * 16 + jj);
                    kk--;
                }

                bzip2Context.mtfbase[ii] = kk + 1;
            }

            int nblock = 0;
            if (groupPos == 0) {
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
            for (zvec = getBits(zn, bzip2Context); zvec > gLimit[zn]; zvec = zvec << 1 | zj) {
                zn++;
                zj = getBit(bzip2Context);
            }

            for (int nextSym = gPerm[zvec - gBase[zn]]; nextSym != eob;)
                if (nextSym == 0 || nextSym == 1) {
                    int es = -1;
                    int n = 1;
                    do {
                        if (nextSym == 0)
                            es += n;
                        else if (nextSym == 1)
                            es += 2 * n;
                        n *= 2;
                        if (groupPos == 0) {
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
                        for (zvec_ = getBits(zn_, bzip2Context); zvec_ > gLimit[zn_]; zvec_ = zvec_ << 1 | byte10) {
                            zn_++;
                            byte10 = getBit(bzip2Context);
                        }

                        nextSym = gPerm[zvec_ - gBase[zn_]];
                    } while (nextSym == 0 || nextSym == 1);
                    es++;
                    byte ec = bzip2Context.seqToUnseq[bzip2Context.mtfa[bzip2Context.mtfbase[0]] & 0xff];
                    bzip2Context.unzftab[ec & 0xff] += es;
                    for (; es > 0; es--) {
                        BZipContext.tt[nblock] = ec & 0xff;
                        nblock++;
                    }

                } else {
                    int nn = nextSym - 1;
                    byte uc_;
                    if (nn < 16) {
                        int j10 = bzip2Context.mtfbase[0];
                        uc_ = bzip2Context.mtfa[j10 + nn];
                        for (; nn > 3; nn -= 4) {
                            int k11 = j10 + nn;
                            bzip2Context.mtfa[k11] = bzip2Context.mtfa[k11 - 1];
                            bzip2Context.mtfa[k11 - 1] = bzip2Context.mtfa[k11 - 2];
                            bzip2Context.mtfa[k11 - 2] = bzip2Context.mtfa[k11 - 3];
                            bzip2Context.mtfa[k11 - 3] = bzip2Context.mtfa[k11 - 4];
                        }

                        for (; nn > 0; nn--)
                            bzip2Context.mtfa[j10 + nn] = bzip2Context.mtfa[(j10 + nn) - 1];

                        bzip2Context.mtfa[j10] = uc_;
                    } else {
                        int l10 = nn / 16;
                        int i11 = nn % 16;
                        int k10 = bzip2Context.mtfbase[l10] + i11;
                        uc_ = bzip2Context.mtfa[k10];
                        for (; k10 > bzip2Context.mtfbase[l10]; k10--)
                            bzip2Context.mtfa[k10] = bzip2Context.mtfa[k10 - 1];

                        bzip2Context.mtfbase[l10]++;
                        for (; l10 > 0; l10--) {
                            bzip2Context.mtfbase[l10]--;
                            bzip2Context.mtfa[bzip2Context.mtfbase[l10]] = bzip2Context.mtfa[(bzip2Context.mtfbase[l10 - 1] + 16) - 1];
                        }

                        bzip2Context.mtfbase[0]--;
                        bzip2Context.mtfa[bzip2Context.mtfbase[0]] = uc_;
                        if (bzip2Context.mtfbase[0] == 0) {
                            int i10 = 4095;
                            for (int k9 = 15; k9 >= 0; k9--) {
                                for (int l9 = 15; l9 >= 0; l9--) {
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
                    if (groupPos == 0) {
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
                    for (j8 = getBits(k7, bzip2Context); j8 > gLimit[k7]; j8 = j8 << 1 | byte11) {
                        k7++;
                        byte11 = getBit(bzip2Context);
                    }

                    nextSym = gPerm[j8 - gBase[k7]];
                }

            bzip2Context.stateOutLen = 0;
            bzip2Context.stateOutCh = 0;
            bzip2Context.cftab[0] = 0;
            System.arraycopy(bzip2Context.unzftab, 0, bzip2Context.cftab, 1, 256);

            for (int k2 = 1; k2 <= 256; k2++)
                bzip2Context.cftab[k2] += bzip2Context.cftab[k2 - 1];

            for (int l2 = 0; l2 < nblock; l2++) {
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
            finalDecompressionStep(bzip2Context);
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

    public static void finalDecompressionStep(BZipContext bz) {
        byte currentByte = bz.stateOutCh;
        int remainingBytes = bz.stateOutLen;
        int blockUsed = bz.nBlockUsed;
        int lastByte = bz.anInt811;
        int[] tt = BZipContext.tt;
        int tPos = bz.tPos;
        byte[] output = bz.aByteArray837;
        int outputPos = bz.anInt825;
        int outputRemaining = bz.anInt823;
        int outputStart = outputRemaining;
        int blockEnd = bz.nBlock + 1;
        outerLoop:
        for(; ; ) {
            if(remainingBytes > 0) {
                for(; ; ) {
                    if(outputRemaining == 0)
                        break outerLoop;
                    if(remainingBytes == 1)
                        break;
                    output[outputPos] = currentByte;
                    remainingBytes--;
                    outputPos++;
                    outputRemaining--;
                }
                if(outputRemaining == 0) {
                    remainingBytes = 1;
                    break;
                }
                output[outputPos] = currentByte;
                outputPos++;
                outputRemaining--;
            }
            boolean bool = true;
            while(bool) {
                bool = false;
                if(blockUsed == blockEnd) {
                    remainingBytes = 0;
                    break outerLoop;
                }
                currentByte = (byte) lastByte;
                tPos = tt[tPos];
                int nextByte = (byte) (tPos & 0xff);
                tPos >>= 8;
                blockUsed++;
                if(nextByte != lastByte) {
                    lastByte = nextByte;
                    if(outputRemaining == 0) {
                        remainingBytes = 1;
                        break outerLoop;
                    }
                    output[outputPos] = currentByte;
                    outputPos++;
                    outputRemaining--;
                    bool = true;
                } else if(blockUsed == blockEnd) {
                    if(outputRemaining == 0) {
                        remainingBytes = 1;
                        break outerLoop;
                    }
                    output[outputPos] = currentByte;
                    outputPos++;
                    outputRemaining--;
                    bool = true;
                }
            }
            remainingBytes = 2;
            tPos = tt[tPos];
            int nextByte = (byte) (tPos & 0xff);
            tPos >>= 8;
            if(++blockUsed != blockEnd) {
                if(nextByte == lastByte) {
                    remainingBytes = 3;
                    tPos = tt[tPos];
                    nextByte = (byte) (tPos & 0xff);
                    tPos >>= 8;
                    if(++blockUsed != blockEnd) {
                        if(nextByte == lastByte) {
                            tPos = tt[tPos];
                            nextByte = (byte) (tPos & 0xff);
                            tPos >>= 8;
                            blockUsed++;
                            remainingBytes = (nextByte & 0xff) + 4;
                            tPos = tt[tPos];
                            lastByte = (byte) (tPos & 0xff);
                            tPos >>= 8;
                            blockUsed++;
                        } else
                            lastByte = nextByte;
                    }
                } else
                    lastByte = nextByte;
            }
        }
        bz.anInt846 += outputStart - outputRemaining;
        bz.stateOutCh = currentByte;
        bz.stateOutLen = remainingBytes;
        bz.nBlockUsed = blockUsed;
        bz.anInt811 = lastByte;
        BZipContext.tt = tt;
        bz.tPos = tPos;
        bz.aByteArray837 = output;
        bz.anInt825 = outputPos;
        bz.anInt823 = outputRemaining;
    }

    public static byte getBit(BZipContext context) {
        return (byte) getBits(1, context);
    }

    private static void createHuffmanDecodingTables(int[] limit, int[] base, int[] perm, byte[] codeLengths, int minLen, int maxLen, int alphabetSize) {
        int i = 0;

        // Populate the mapping from canonical code index to output symbol
        for(int len = minLen; len <= maxLen; len++) {
            for(int symIndex = 0; symIndex < alphabetSize; symIndex++) {
                if(codeLengths[symIndex] == len) {
                    perm[i] = symIndex;
                    i++;
                }
            }
        }

        // reset base arrays
        for(int index = 0; index < 23; index++)
            base[index] = 0;
        for(int index = 0; index < alphabetSize; index++)
            base[codeLengths[index] + 1]++;
        for(int index = 1; index < 23; index++)
            base[index] += base[index - 1];

        // reset limit array
        for(int index = 0; index < 23; index++)
            limit[index] = 0;

        // Calculate the first and last Huffman code for each code length (codes at a given
        // length are sequential in value)
        int code = 0;
        for(int len = minLen; len <= maxLen; len++) {
            code += base[len + 1] - base[len];
            limit[len] = code - 1;
            code <<= 1;
        }

        // Update base array with appropriate values for decoding
        for(int len = minLen + 1; len <= maxLen; len++)
            base[len] = (limit[len - 1] + 1 << 1) - base[len];
    }
}
