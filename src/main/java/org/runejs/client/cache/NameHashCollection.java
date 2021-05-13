package org.runejs.client.cache;

public class NameHashCollection {
    public int[] anIntArray996;

    public NameHashCollection(int[] nameHashes) {
        int i;
        for(i = 1; (nameHashes.length >> 1) + nameHashes.length >= i; i <<= 1) {
            /* empty */
        }
        anIntArray996 = new int[i + i];
        for(int i_8_ = 0; i + i > i_8_; i_8_++)
            anIntArray996[i_8_] = -1;
        for(int i_9_ = 0; nameHashes.length > i_9_; i_9_++) {
            int i_10_;
            for(i_10_ = nameHashes[i_9_] & i - 1; anIntArray996[i_10_ + i_10_ + 1] != -1; i_10_ = i_10_ + 1 & -1 + i) {
                /* empty */
            }
            anIntArray996[i_10_ + i_10_] = nameHashes[i_9_];
            anIntArray996[1 + i_10_ + i_10_] = i_9_;
        }

    }


    public int method882(int arg0) {
        int i = -2 + anIntArray996.length;
        int i_0_ = arg0 << 1 & i;
        for(; ; ) {
            int i_1_ = anIntArray996[i_0_];
            if(i_1_ == arg0)
                return anIntArray996[i_0_ + 1];
            if(i_1_ == -1)
                return -1;
            i_0_ = i_0_ + 2 & i;
        }
    }
}
