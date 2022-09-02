package org.runejs.client;

import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.node.Node;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.media.renderable.actor.Player;

import java.awt.*;

public class LinkedList {
    public static ImageRGB aClass40_Sub5_Sub14_Sub4_1057;
    public static int anInt1061;
    public static LinkedList aLinkedList_1064 = new LinkedList();
    public static int[] terrainDataIds;
    public static volatile int anInt1073 = 0;
    public static int crossType = 0;
    public static int[] minimapHintY = new int[1000];
    public Node tail = new Node();
    public Node current;

    public LinkedList() {

        tail.previous = tail;
        tail.next = tail;

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

    public static void drawChatBoxGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            RSCanvas.chatBoxImageProducer.drawGraphics(17, 357, graphics);

        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method910(int arg0) {
        if(arg0 == -32322) {
            if(VertexNormal.lowMemory && MovedStatics.onBuildTimePlane != Player.worldLevel)
                Actor.method789(Player.localPlayer.pathY[0], -1000, Class17.regionY, Class51.regionX, Player.localPlayer.pathX[0], Player.worldLevel);
            else if(Buffer.anInt1985 != Player.worldLevel) {
                Buffer.anInt1985 = Player.worldLevel;
                MovedStatics.method299((byte) 53, Player.worldLevel);
            }
        }
    }

    public Node popLast(byte arg0) {
        Node node = tail.previous;

        if(node == tail)
            return null;

        node.remove();
        return node;
    }

    public Node peekLast(byte arg0) {
        Node node = tail.previous;

        if(node == tail) {
            current = null;
            return null;
        }

        current = node.previous;
        return node;
    }

    public Node peekFront(byte arg0) {
        Node node = tail.next;

        if(tail == node) {
            current = null;
            return null;
        }

        current = node.next;
        return node;
    }

    public void pushBack(Node node, int arg1) {
        if(node.previous != null)
            node.remove();

        node.previous = tail.previous;
        node.next = tail;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void pushFront(int arg0, Node node) {
        if(node.previous != null)
            node.remove();

        node.previous = tail;
        node.next = tail.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void clear(int arg0) {
        while (true) {
            Node next = tail.next;

            if(next == tail)
                return;

            next.remove();
        }
    }

    public Node next(int arg0) {
        Node node = current;

        if(node == tail) {
            current = null;
            return null;
        }

        current = node.next;
        return node;
    }

    public void method911(int arg0, Node arg1, Node arg2) {
        if(arg2.previous != null)
            arg2.remove();
        if(arg0 == -31793) {
            arg2.previous = arg1.previous;
            arg2.next = arg1;
            arg2.previous.next = arg2;
            arg2.next.previous = arg2;
        }
    }

    public Node previous(int arg0) {
        Node node = current;

        if(node == tail) {
            current = null;
            return null;
        }

        current = node.previous;
        return node;
    }

    public Node popFront(int arg0) {
        Node next = tail.next;

        if(tail == next)
            return null;

        next.remove();
        return next;
    }
}
