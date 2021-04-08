package com.jagex.runescape;

import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.VertexNormal;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.node.Node;

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
    public Node nodePlusOne = new Node();
    public Node aClass40_1068;

    public LinkedList() {

        nodePlusOne.previous = nodePlusOne;
        nodePlusOne.next = nodePlusOne;

    }


    public static String method903(int arg0) {
        String class1 = Integer.toString(arg0);
        for(int i = -3 + class1.length(); i > 0; i -= 3) {
            class1 = class1.substring(0, i) + Native.aClass1_795 + class1.substring(i);
        }
        if(class1.length() > 8) {
            class1 = Native.green + class1.substring(0, -8 + class1.length()) + English.suffixMillion +
                    Native.aClass1_1213 + class1 + Native.rightParenthasis;
        } else if(class1.length() > 4) {
            class1 = Native.cyan + class1.substring(0, class1.length() + -4) + Native.aClass1_2593 +
                    Native.aClass1_1213 + class1 + Native.rightParenthasis;
        }
        return Native.aClass1_1123 + class1;
    }

    public static void method907() {
        Class57.aClass9_1331.clear();
    }

    // TODO find better place for this?
    public static void drawChatBoxGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            RSCanvas.chatBoxImageProducer.drawGraphics(17, 357, graphics);

        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method910() {
        if(VertexNormal.lowMemory && MovedStatics.onBuildTimePlane != Player.worldLevel) {
            Actor.method789(Player.localPlayer.pathY[0], Class17.regionY, Class51.regionX, Player.localPlayer.pathX[0],
                    Player.worldLevel
            );
        } else if(Buffer.anInt1985 != Player.worldLevel) {
            Buffer.anInt1985 = Player.worldLevel;
            Class22.method299(Player.worldLevel);
        }
    }

    public Node method899() {
        Node class40 = nodePlusOne.previous;
        if(class40 == nodePlusOne) {
            return null;
        }
        class40.remove();
        return class40;
    }

    public Node last() {
        Node class40 = nodePlusOne.previous;
        if(class40 == nodePlusOne) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        return class40;
    }

    public Node method902() {
        Node class40 = nodePlusOne.next;
        if(nodePlusOne == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void pushBack(Node node) {
        if(node.previous != null) {
            node.remove();
        }
        node.previous = nodePlusOne.previous;
        node.next = nodePlusOne;
        node.previous.next = node;
        node.next.previous = node;
    }

    public void removeNode(Node nodeToRemove) {
        if(nodeToRemove.previous != null) {
            nodeToRemove.remove();
        }
        nodeToRemove.next = nodePlusOne.next;
        nodeToRemove.previous = nodePlusOne;
        nodeToRemove.previous.next = nodeToRemove;
        nodeToRemove.next.previous = nodeToRemove;
    }

    public void method906() {
        while(true) {
            Node class40 = nodePlusOne.next;
            if(class40 == nodePlusOne) {
                break;
            }
            class40.remove();
        }
    }

    public Node method909() {
        Node class40 = aClass40_1068;
        if(nodePlusOne == class40) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.next;
        return class40;
    }

    public void method911(Node arg1, Node arg2) {
        if(arg2.previous != null) {
            arg2.remove();
        }
        arg2.next = arg1;
        arg2.previous = arg1.previous;
        arg2.previous.next = arg2;
        arg2.next.previous = arg2;
    }

    public Node previous() {
        Node class40 = aClass40_1068;
        if(class40 == nodePlusOne) {
            aClass40_1068 = null;
            return null;
        }
        aClass40_1068 = class40.previous;
        return class40;
    }

    public Node method913() {
        Node class40 = nodePlusOne.next;
        if(nodePlusOne == class40) {
            return null;
        }
        class40.remove();
        return class40;
    }
}
