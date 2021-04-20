package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.scene.InteractiveObject;

import java.awt.*;
import java.io.*;

public class Class55 {
    public static int mouseInvInterfaceIndex = 0;
    public static Class48 aClass48_1289;
    public static volatile int eventClickX = 0;
    public static int anInt1296 = -1;
    public static int anInt1299 = 2301979;
    public static int destinationY = 0;

    public static String parseException(Throwable exception) throws IOException {
        String string;
        if(exception instanceof RSRuntimeException) {
            RSRuntimeException runtimeexception_sub1 = (RSRuntimeException) exception;
            string = runtimeexception_sub1.aString1653 + " | ";
            exception = runtimeexception_sub1.aThrowable1652;
        } else
            string = "";
        StringWriter stringwriter = new StringWriter();
        PrintWriter printwriter = new PrintWriter(stringwriter);
        exception.printStackTrace(printwriter);
        printwriter.close();
        String string_0_ = stringwriter.toString();
        BufferedReader bufferedreader = new BufferedReader(new StringReader(string_0_));
        String string_1_ = bufferedreader.readLine();
        for(; ; ) {
            String string_2_ = bufferedreader.readLine();
            if(string_2_ == null)
                break;
            int i = string_2_.indexOf('(');
            int i_3_ = string_2_.indexOf(')', i + 1);
            if(i >= 0 && i_3_ >= 0) {
                String string_4_ = string_2_.substring(1 + i, i_3_);
                int i_5_ = string_4_.indexOf(".java:");
                if(i_5_ >= 0) {
                    string_4_ = string_4_.substring(0, i_5_) + string_4_.substring(5 + i_5_);
                    string += string_4_ + ' ';
                    continue;
                }
                string_2_ = string_2_.substring(0, i);
            }
            string_2_ = string_2_.trim();
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf(' '));
            string_2_ = string_2_.substring(1 + string_2_.lastIndexOf('\t'));
            string += string_2_ + ' ';
        }
        string += "| " + string_1_;
        return string;
    }

    public static Class40_Sub5_Sub15 method960(int arg1) {
        Class40_Sub5_Sub15 class40_sub5_sub15 = (Class40_Sub5_Sub15) Class42.aClass9_998.get((long) arg1);
        if(class40_sub5_sub15 != null)
            return class40_sub5_sub15;
        class40_sub5_sub15 = Class35.method421(MovedStatics.aCacheArchive_2364, (byte) 79, arg1, ClientScriptRunner.aCacheArchive_2162, false);
        if(class40_sub5_sub15 != null)
            Class42.aClass9_998.put((long) arg1, class40_sub5_sub15);
        return class40_sub5_sub15;
    }


    public static int method963(int arg0, byte arg1, int arg2) {
        if(arg0 > arg2) {
            int i = arg2;
            arg2 = arg0;
            arg0 = i;
        }
        if(arg1 != -62)
            aClass48_1289 = null;
        int i;
        for(/**/; arg0 != 0; arg0 = i) {
            i = arg2 % arg0;
            arg2 = arg0;
        }
        return arg2;
    }

    public static void drawTabGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            MovedStatics.tabImageProducer.drawGraphics(553, 205, graphics);
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method965(int arg0, Component arg1) {
        if(arg0 == 32) {
            arg1.removeMouseListener(GameObject.frame);
            arg1.removeMouseMotionListener(GameObject.frame);
            arg1.removeFocusListener(GameObject.frame);
        }
    }

    public static void method966(int arg0, CacheArchive arg1, CacheArchive arg2) {
        UnderlayDefinition.aCacheArchive_2582 = arg1;
        int i = -87 / ((-20 - arg0) / 56);
        InteractiveObject.aCacheArchive_488 = arg2;
    }
}
