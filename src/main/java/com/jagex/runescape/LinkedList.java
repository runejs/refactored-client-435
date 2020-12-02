package com.jagex.runescape;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.node.Node;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;

public class LinkedList {
    public static long aLong1051;
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_1057;
    public static int anInt1061;
    public static LinkedList aLinkedList_1064 = new LinkedList();
    public static int[] anIntArray1071;
    public static volatile int anInt1073 = 0;
    public static int crossType = 0;
    public static Buffer aClass40_Sub1_1081 = new Buffer(8);
    public static int[] minimapHintY = new int[1000];
    public Node aClass40_1056 = new Node();
    public Node aClass40_1068;

    public LinkedList() {

        aClass40_1056.previous = aClass40_1056;
        aClass40_1056.next = aClass40_1056;

    }



    public static String method903(int arg0, byte arg1) {
        if(arg1 >= -13)
            return null;
        String class1 = Integer.toString(arg0);
        for(int i = -3 + class1.length(); i > 0; i -= 3)
            class1 = class1.substring(0, i) + Native.aClass1_795 + class1.substring(i);
        if(class1.length() > 8)
            class1 = Native.green + class1.substring(0, -8 + class1.length()) + English.suffixMillion + Native.aClass1_1213 + class1 + Native.rightParenthasis;
        else if(class1.length() > 4)
            class1 = Native.cyan + class1.substring(0, class1.length() + -4) + Native.aClass1_2593 + Native.aClass1_1213 + class1 + Native.rightParenthasis;
        return Native.aClass1_1123 + class1;
    }

    public static void method907(int arg0) {
        Class57.aClass9_1331.clear();
        if(arg0 >= -36)
            aLinkedList_1064 = null;
    }

    public static void drawChatBoxGraphics() {
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            RSCanvas.chatboxProducingGraphicsBuffer.drawGraphics(17, 357, graphics);

        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static void method910(int arg0) {
        if(arg0 == -32322) {
            if(VertexNormal.lowMemory && Class40_Sub6.onBuildTimePlane != Player.worldLevel)
                Actor.method789(Player.localPlayer.pathY[0], -1000, Class17.regionY, Class51.regionX, Player.localPlayer.pathX[0], Player.worldLevel);
            else if(Buffer.anInt1985 != Player.worldLevel) {
                Buffer.anInt1985 = Player.worldLevel;
                Class22.method299((byte) 53, Player.worldLevel);
            }
        }
    }

    public Node method899(byte arg0) {
        int i = -68 / ((28 - arg0) / 50);
        Node class40 = aClass40_1056.previous;
        if(class40 == aClass40_1056)
            return null;
        class40.remove();
        return class40;
    }

    public Node last(byte arg0) {
        Node class40 = aClass40_1056.previous;
        if(class40 == aClass40_1056) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        if(arg0 > -53)
            return null;
        return class40;
    }

    public Node method902(byte arg0) {
        if(arg0 != -90)
            last((byte) 0);
        Node class40 = aClass40_1056.next;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void pushBack(Node node, int arg1) {
        if(node.previous != null)
            node.remove();
        node.previous = aClass40_1056.previous;
        int i = 106 % ((-7 - arg1) / 59);
        node.next = aClass40_1056;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void method905(int arg0, Node arg1) {
        if(arg1.previous != null)
            arg1.remove();
        if(arg0 != 0)
            method911(-96, null, null);
        arg1.next = aClass40_1056.next;
        arg1.previous = aClass40_1056;
        arg1.previous.next = arg1;
        arg1.next.previous = arg1;
    }

    public void method906(int arg0) {
        if(arg0 != 0)
            method903(-33, (byte) -75);
        for(; ; ) {
            Node class40 = aClass40_1056.next;
            if(class40 == aClass40_1056)
                break;
            class40.remove();
        }
    }

    public Node method909(int arg0) {
        Node class40 = aClass40_1068;
        if(aClass40_1056 == class40) {
            aClass40_1068 = null;
            return null;
        }
        if(arg0 != -4)
            method910(109);
        aClass40_1068 = class40.next;
        return class40;
    }

    public void method911(int arg0, Node arg1, Node arg2) {
        if(arg2.previous != null)
            arg2.remove();
        if(arg0 == -31793) {
            arg2.next = arg1;
            arg2.previous = arg1.previous;
            arg2.previous.next = arg2;
            arg2.next.previous = arg2;
        }
    }

    public Node previous(int arg0) {
        if(arg0 != 4)
            return null;
        Node class40 = aClass40_1068;
        if(class40 == aClass40_1056) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        return class40;
    }

    public Node method913(int arg0) {
        if(arg0 != 25447)
            method902((byte) -115);
        Node class40 = aClass40_1056.next;
        if(aClass40_1056 == class40)
            return null;
        class40.remove();
        return class40;
    }
}
