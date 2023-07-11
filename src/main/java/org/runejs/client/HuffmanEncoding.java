package org.runejs.client;

import org.runejs.client.util.BitUtils;

public class HuffmanEncoding {

    public int[] chatDecryptKeys;
    public int[] chatMask;
    public byte[] chatBitSizes;

    public HuffmanEncoding(byte[] arg0) {

        int i = arg0.length;
        chatBitSizes = arg0;
        chatMask = new int[i];
        int[] is = new int[33];
        chatDecryptKeys = new int[8];
        int i_29_ = 0;
        for (int i_30_ = 0; i_30_ < i; i_30_++) {
            int i_31_ = arg0[i_30_];
            if (i_31_ != 0) {
                int i_32_ = 1 << -i_31_ + 32;
                int i_33_ = is[i_31_];
                chatMask[i_30_] = i_33_;
                int i_34_;
                if ((i_32_ & i_33_) == 0) {
                    for (int i_35_ = -1 + i_31_; i_35_ >= 1; i_35_--) {
                        int i_36_ = is[i_35_];
                        if (i_36_ != i_33_) {
                            break;
                        }
                        int i_37_ = 1 << -i_35_ + 32;
                        if ((i_36_ & i_37_) == 0) {
                            is[i_35_] = BitUtils.bitWiseOR(i_36_, i_37_);
                        } else {
                            is[i_35_] = is[-1 + i_35_];
                            break;
                        }
                    }
                    i_34_ = i_33_ | i_32_;
                } else {
                    i_34_ = is[-1 + i_31_];
                }
                is[i_31_] = i_34_;
                for (int i_38_ = i_31_ + 1; i_38_ <= 32; i_38_++) {
                    if (i_33_ == is[i_38_]) {
                        is[i_38_] = i_34_;
                    }
                }
                int i_39_ = 0;
                for (int i_40_ = 0; i_40_ < i_31_; i_40_++) {
                    int i_41_ = -2147483648 >>> i_40_;
                    if ((i_41_ & i_33_) != 0) {
                        if (chatDecryptKeys[i_39_] == 0) {
                            chatDecryptKeys[i_39_] = i_29_;
                        }
                        i_39_ = chatDecryptKeys[i_39_];
                    } else {
                        i_39_++;
                    }
                    if (chatDecryptKeys.length <= i_39_) {
                        int[] is_42_ = new int[chatDecryptKeys.length * 2];
                        for (int i_43_ = 0; chatDecryptKeys.length > i_43_; i_43_++) {
                            is_42_[i_43_] = chatDecryptKeys[i_43_];
                        }
                        chatDecryptKeys = is_42_;
                    }
                    i_41_ >>>= 1;
                }
                if (i_39_ >= i_29_) {
                    i_29_ = i_39_ + 1;
                }
                chatDecryptKeys[i_39_] = i_30_ ^ 0xffffffff;
            }
        }

    }


    public int method1023(byte[] arg0, int arg1, int arg2, byte[] arg3, int arg4, int arg5) {
        if (arg1 == 0) {
            return 0;
        }
        arg1 += arg2;
        int i = 0;
        int i_0_ = arg4;
        for (; ; ) {
            byte i_1_ = arg0[i_0_];
            if (i_1_ >= 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            int i_2_;
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x40 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((0x20 & i_1_) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x10 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((i_1_ & 0x8) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((0x4 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x2 & i_1_) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((i_1_ & 0x1) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            i_0_++;
        }

        return -arg4 + i_0_ + 1;
    }

    public int encrypt(int arg1, int bufferPos, int sourceLength, byte[] source, byte[] dest) {
        sourceLength += arg1;
        int i = 0;
        int i_6_ = bufferPos << 3;;
        for (/**/; arg1 < sourceLength; arg1++) {
            int textByte = 0xff & source[arg1];
            int mask = chatMask[textByte];
            int size = chatBitSizes[textByte];
            if (size == 0) {
                throw new RuntimeException("No codeword for data value " + textByte);
            }
            int bitOffset2 = i_6_ >> 3;
            int bitOffset = 0x7 & i_6_;
            i_6_ += size;
            i &= -bitOffset >> 31;
            int i_12_ = bitOffset2 + (size + bitOffset - 1 >> 3);
            bitOffset += 24;
            dest[bitOffset2] = (byte) (i = BitUtils.bitWiseOR(i, mask >>> bitOffset));
            if (bitOffset2 < i_12_) {
                bitOffset2++;
                bitOffset -= 8;
                dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                if (i_12_ > bitOffset2) {
                    bitOffset -= 8;
                    bitOffset2++;
                    dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                    if (bitOffset2 < i_12_) {
                        bitOffset2++;
                        bitOffset -= 8;
                        dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                        if (bitOffset2 < i_12_) {
                            bitOffset -= 8;
                            bitOffset2++;
                            dest[bitOffset2] = (byte) (i = mask << -bitOffset);
                        }
                    }
                }
            }
        }
        return (7 + i_6_ >> 3) - bufferPos;
    }
}
