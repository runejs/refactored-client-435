package org.runejs.client;

public class Class18 {
    public static void method278(byte[] arg0, int arg1, byte[] buffer, int arg3, int arg4) {
        if(arg0 == buffer) {
            if(arg1 == arg3)
                return;
            if(arg3 > arg1 && arg3 < arg1 + arg4) {
                arg4--;
                arg1 += arg4;
                arg3 += arg4;
                arg4 = arg1 - arg4;
                arg4 += 7;
                while(arg1 >= arg4) {
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                    buffer[arg3--] = arg0[arg1--];
                }
                arg4 -= 7;
                while(arg1 >= arg4)
                    buffer[arg3--] = arg0[arg1--];
                return;
            }
        }
        arg4 += arg1;
        arg4 -= 7;
        while(arg1 < arg4) {
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
            buffer[arg3++] = arg0[arg1++];
        }
        arg4 += 7;
        while(arg1 < arg4)
            buffer[arg3++] = arg0[arg1++];
    }
}
