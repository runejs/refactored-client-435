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
    public static int selectedInventorySlot;
    public static LinkedList aLinkedList_1064 = new LinkedList();
    public static int[] terrainDataIds;
    public static volatile int anInt1073 = 0;
    public static int crossType = 0;
    public static int[] minimapHintY = new int[1000];

    /**
     * The last element in the LinkedList
     */
    public Node last = new Node();

    /**
     * The first element in the LinkedList
     */
    public Node first;

    public LinkedList() {
        last.previous = last;
        last.next = last;
    }

    public static String method903(int arg0) {
        String class1 = Integer.toString(arg0);
        for(int i = -3 + class1.length(); i > 0; i -= 3)
            class1 = class1.substring(0, i) + Native.comma_b + class1.substring(i);
        if(class1.length() > 8)
            class1 = Native.green + class1.substring(0, -8 + class1.length()) + English.suffixMillion + Native.whiteOpeningParenthesis + class1 + Native.rightParenthesis;
        else if(class1.length() > 4)
            class1 = Native.cyan + class1.substring(0, class1.length() + -4) + Native.suffixK + Native.whiteOpeningParenthesis + class1 + Native.rightParenthesis;
        return Native.whitespace_b + class1;
    }

    public static void drawChatBoxGraphics() {
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            RSCanvas.chatBoxImageProducer.drawGraphics(17, 357, graphics);

        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method910() {
        if(true) {
            if (VertexNormal.lowMemory && MovedStatics.onBuildTimePlane != Player.worldLevel)
                Actor.method789(Player.localPlayer.pathY[0], Class17.regionY, Class51.regionX, Player.localPlayer.pathX[0], Player.worldLevel);
            else if (Buffer.anInt1985 != Player.worldLevel) {
                Buffer.anInt1985 = Player.worldLevel;
                MovedStatics.method299(Player.worldLevel);
            }
        }
    }

    public Node removeLast() {
        Node node = last.previous;

        if(node == last)
            return null;

        node.unlink();
        return node;
    }

    public Node peekLast() {
        Node node = last.previous;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.previous;
        return node;
    }

    public Node peekFirst() {
        Node node = last.next;

        if(last == node) {
            first = null;
            return null;
        }

        first = node.next;
        return node;
    }

    /**
     * Appends a node to the end of the LinkedList
     */
    public void addLast(Node node) {
        if(node.previous != null)
            node.unlink();

        node.previous = last.previous;
        node.next = last;
        node.previous.next = node;
        node.next.previous = node;
    }

    /**
     * Adds a node at the start of the LinkedList
     */
    public void addFirst(Node node) {
        if(node.previous != null)
            node.unlink();

        node.previous = last;
        node.next = last.next;
        node.previous.next = node;
        node.next.previous = node;
    }

    /**
     * Removes all of the elements from this list. The list will be empty after this call returns.
     */
    public void clear() {
        while (true) {
            Node next = last.next;

            if(next == last)
                return;

            next.unlink();
        }
    }

    /**
     * Retrieves and removes the first element of this list, or returns null if this list is empty.
     */
    public Node pollFirst() {
        Node node = first;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.next;
        return node;
    }

    /**
     * Inserts a node before another node
     *
     * @param existingNode  The node before which `insertingNode` should be added
     * @param insertingNode The node to insert
     */
    public void addBefore(Node existingNode, Node insertingNode) {
        if(insertingNode.previous != null)
            insertingNode.unlink();

        if(true) {
            insertingNode.previous = existingNode.previous;
            insertingNode.next = existingNode;
            insertingNode.previous.next = insertingNode;
            insertingNode.next.previous = insertingNode;
        }
    }

    /**
     * Retrieves and removes the last element of this list, or returns null if this list is empty.
     */
    public Node pollLast() {
        Node node = first;

        if(node == last) {
            first = null;
            return null;
        }

        first = node.previous;
        return node;
    }

    /**
     * Removes and returns the first element from this list.
     */
    public Node removeFirst() {
        Node next = last.next;

        if(last == next)
            return null;

        next.unlink();
        return next;
    }
}
