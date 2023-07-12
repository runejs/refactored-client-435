package org.runejs.client.net;

import org.runejs.client.node.NodeCache;
import org.runejs.client.util.BitUtils;

public class ISAAC {
    /**
     * The golden ratio.
     */
    private static final int GOLDEN_RATIO = 0x9e3779b9;

    public static NodeCache cachedActorDefinitions = new NodeCache(64);
    public static boolean aBoolean512;
    public static NodeCache aClass9_516 = new NodeCache(64);

    public int count;
    public int accumulator;
    public int counter;
    public int[] rsl;
    public int[] mem;
    public int result;

    public ISAAC(int[] seed) {
        mem = new int[256];
        rsl = new int[256];
        for(int i = 0; seed.length > i; i++)
            rsl[i] = seed[i];
        init(true);
    }

    public void isaac() {
        result += ++counter;
        for(int i = 0; i < 256; i++) {
            int x = mem[i];
            if((i & 0x2) == 0) {
                if((0x1 & i) == 0)
                    accumulator ^= accumulator << 13;
                else
                    accumulator ^= accumulator >>> 6;
            } else if((i & 0x1) != 0)
                accumulator ^= accumulator >>> 16;
            else
                accumulator ^= accumulator << 2;
            accumulator += mem[0xff & 128 + i];
            int y;
            mem[i] = y = mem[BitUtils.bitWiseAND(x, 1020) >> 2] + accumulator + result;
            rsl[i] = result = x + mem[BitUtils.bitWiseAND(y >> -488567000 >> -1522276318, 255)];
        }
    }

    /**
     * Gets the next random value.
     *
     * @return The next random value.
     */
    public int nextInt() {
        if(count-- == 0) {
            isaac();
            count = 255;
        }
        return rsl[count];
    }

    public void init(boolean arg0) {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;

        int a = b = c = d = e = f = g = h = GOLDEN_RATIO;
        for(int i = 0; i < 4; i++) {
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            g ^= h << 8;
            b += g;
            a += f;
            h += a;
            h ^= a >>> 9;
            c += h;
            a += b;
        }
        for(int i = 0; i < 256; i += 8) {
            /*
             * fill in mem[] with messy
             * stuff
             */
            h += rsl[7 + i];
            d += rsl[3 + i];
            a += rsl[i];
            b += rsl[i + 1];
            e += rsl[4 + i];
            g += rsl[i + 6];
            f += rsl[5 + i];
            c += rsl[2 + i];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            e += b;
            c += d;
            c ^= d << 8;
            d += e;
            f += c;
            d ^= e >>> 16;
            e += f;
            g += d;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            a += f;
            g ^= h << 8;
            h += a;
            b += g;
            h ^= a >>> 9;
            a += b;
            c += h;
            mem[i] = a;
            mem[i + 1] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        if(!arg0)
            aClass9_516 = null;
        /* second pass makes all of seed affect all of mem */
        for(int i = 0; i < 256; i += 8) {
            h += mem[7 + i];
            g += mem[i + 6];
            c += mem[2 + i];
            d += mem[3 + i];
            f += mem[i + 5];
            a += mem[i];
            e += mem[4 + i];
            b += mem[i + 1];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            a += f;
            g += h;
            g ^= h << 8;
            h += a;
            h ^= a >>> 9;
            b += g;
            a += b;
            c += h;
            mem[i] = a;
            mem[1 + i] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        isaac();
        count = 256;
    }
}
