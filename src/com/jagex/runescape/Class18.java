package com.jagex.runescape;

public class Class18 {
    public static void method278(byte[] arg0, int arg1, byte[] arg2, int arg3, int arg4) {
        if(arg0 == arg2) {
            if(arg1 == arg3)
                return;
            if(arg3 > arg1 && arg3 < arg1 + arg4) {
                arg4--;
                arg1 += arg4;
                arg3 += arg4;
                arg4 = arg1 - arg4;
                arg4 += 7;
                while(arg1 >= arg4) {
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                    arg2[arg3--] = arg0[arg1--];
                }
                arg4 -= 7;
                while(arg1 >= arg4)
                    arg2[arg3--] = arg0[arg1--];
                return;
            }
        }
        arg4 += arg1;
        arg4 -= 7;
        while(arg1 < arg4) {
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
            arg2[arg3++] = arg0[arg1++];
        }
        arg4 += 7;
        while(arg1 < arg4)
            arg2[arg3++] = arg0[arg1++];
    }
}
