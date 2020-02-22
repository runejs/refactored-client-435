package com.jagex.runescape;

import com.jagex.runescape.cache.media.IndexedImage;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class HashTable {
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_549;
    public static int anInt551;
    public static int anInt552;
    public static RSString aClass1_553;
    public static int anInt554 = 0;
    public static int anInt555;
    public static int anInt556;
    public static int anInt557;
    public static RSString aClass1_558;
    public static int anInt559;
    public static int anInt560;
    public static int anInt561;
    public static RSString aClass1_563;
    public static int anInt564;
    public static boolean aBoolean565 = false;
    public static int anInt568;
    public static RSString aClass1_569;
    public static int anInt570;
    public static boolean aBoolean571;
    public static int anInt573;

    static {
        aClass1_563 = (Class58.method978("und die Schaltfl-=che (WSpielkonto erstellen(W am"));
        aClass1_558 = Class58.method978("Ung-Ultige Session)2ID)3");
        aClass1_553 = Class58.method978("l");
        aClass1_569 = Class58.method978(" (X");
        anInt573 = -1;
    }

    public long aLong550;
    public int size;
    public Node aClass40_566;
    public Node[] nodes;
    public int anInt572 = 0;
    public Node aClass40_574;

    public HashTable(int arg0) {

        size = arg0;
            nodes = new Node[arg0];
        for(int i = 0; arg0 > i; i++) {
                Node class40 = nodes[i] = new Node();
                class40.aClass40_950 = class40;
                class40.aClass40_968 = class40;
            }

    }

    public static void method327(boolean arg0, Class6_Sub1 arg1, int arg2, int arg3, byte arg4, int arg5, byte arg6) {

        int i = 14 % ((arg6 - 5) / 62);
            long l = (long) (arg3 + (arg2 << -1726391664));
            Class40_Sub5_Sub13 class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class51.aClass23_1194.method331(l, 6120));
            anInt561++;
            if(class40_sub5_sub13 == null) {
                class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class37.aClass23_869.method331(l, 6120));
                if(class40_sub5_sub13 == null) {
                    class40_sub5_sub13 = ((Class40_Sub5_Sub13) GameObjectDefinition.aClass23_2545.method331(l, 6120));
                    if(class40_sub5_sub13 != null) {
                        if(arg0) {
                            class40_sub5_sub13.method539(0);
                            Class51.aClass23_1194.put(class40_sub5_sub13, (byte) 116, l);
                            anInt554--;
                            Class68.anInt1618++;
                        }
                    } else {
                        if(!arg0) {
                            class40_sub5_sub13 = ((Class40_Sub5_Sub13) Class34.aClass23_841.method331(l, 6120));
                            if(class40_sub5_sub13 != null)
                                return;
                        }
                        class40_sub5_sub13 = new Class40_Sub5_Sub13();
                        class40_sub5_sub13.anInt2763 = arg5;
                        class40_sub5_sub13.aByte2758 = arg4;
                        class40_sub5_sub13.aClass6_Sub1_2754 = arg1;
                        if(!arg0) {
                            Class19.aClass27_485.method352(126, class40_sub5_sub13);
                            GameObjectDefinition.aClass23_2545.put(class40_sub5_sub13, (byte) 109, l);
                            anInt554++;
                        } else {
                            Class51.aClass23_1194.put(class40_sub5_sub13, (byte) 54, l);
                            Class68.anInt1618++;
                        }
                    }
                }
            }

    }

    public static void method328(boolean arg0) {

        aClass40_Sub5_Sub14_Sub2_549 = null;
            aClass1_553 = null;
            aClass1_558 = null;
            if(arg0 != false)
                aClass1_569 = null;
            aClass1_563 = null;
            aClass1_569 = null;

    }

    public static void method332(int arg0) {

        anInt570++;
            synchronized(CollisionMap.anObject162) {
                if((Buffer.anInt1987 ^ 0xffffffff) == -1)
                    ISAAC.aClass31_521.method394(5, 0, new Class44());
                Buffer.anInt1987 = arg0;
            }

    }

    public static RSString method334(int arg0, int arg1) {

        if(arg1 != -1)
                return null;
            anInt559++;
            return PacketBuffer.method521(false, (byte) 8, 10, arg0);

    }

    public static void method335(byte arg0) {

        anInt555++;
            Class40_Sub5_Sub17_Sub1 class40_sub5_sub17_sub1 = ((Class40_Sub5_Sub17_Sub1) Class43.aClass45_1022.method902((byte) -90));
            if(arg0 == 61) {
                for(/**/; class40_sub5_sub17_sub1 != null; class40_sub5_sub17_sub1 = ((Class40_Sub5_Sub17_Sub1) Class43.aClass45_1022.method909(arg0 + -65))) {
                    if((Player.anInt3267 == class40_sub5_sub17_sub1.anInt2981) && (Node.anInt926 <= class40_sub5_sub17_sub1.anInt2971)) {
                        if(class40_sub5_sub17_sub1.anInt2974 <= Node.anInt926) {
                            if((class40_sub5_sub17_sub1.anInt2961 ^ 0xffffffff) < -1) {
                                Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[-1 + (class40_sub5_sub17_sub1.anInt2961)]);
                                if(class40_sub5_sub17_sub4_sub2 != null && (class40_sub5_sub17_sub4_sub2.anInt3098 ^ 0xffffffff) <= -1 && (class40_sub5_sub17_sub4_sub2.anInt3098 < 13312) && (class40_sub5_sub17_sub4_sub2.anInt3089 >= 0) && (class40_sub5_sub17_sub4_sub2.anInt3089 < 13312))
                                    class40_sub5_sub17_sub1.method766(Node.anInt926, arg0 + -61, (class40_sub5_sub17_sub4_sub2.anInt3089), ((Class37.method430((byte) -127, class40_sub5_sub17_sub1.anInt2981, (class40_sub5_sub17_sub4_sub2.anInt3098), (class40_sub5_sub17_sub4_sub2.anInt3089))) - class40_sub5_sub17_sub1.anInt2960), (class40_sub5_sub17_sub4_sub2.anInt3098));
                            }
                            if((class40_sub5_sub17_sub1.anInt2961 ^ 0xffffffff) > -1) {
                                int i = -1 + -class40_sub5_sub17_sub1.anInt2961;
                                Player class40_sub5_sub17_sub4_sub1;
                                if(i != Class30.anInt708)
                                    class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i]);
                                else
                                    class40_sub5_sub17_sub4_sub1 = (Class40_Sub5_Sub13.localPlayer);
                                if(class40_sub5_sub17_sub4_sub1 != null && (class40_sub5_sub17_sub4_sub1.anInt3098 >= 0) && (class40_sub5_sub17_sub4_sub1.anInt3098 < 13312) && (class40_sub5_sub17_sub4_sub1.anInt3089 >= 0) && (class40_sub5_sub17_sub4_sub1.anInt3089 < 13312))
                                    class40_sub5_sub17_sub1.method766(Node.anInt926, 0, (class40_sub5_sub17_sub4_sub1.anInt3089), ((Class37.method430((byte) -127, class40_sub5_sub17_sub1.anInt2981, (class40_sub5_sub17_sub4_sub1.anInt3098), (class40_sub5_sub17_sub4_sub1.anInt3089))) - class40_sub5_sub17_sub1.anInt2960), (class40_sub5_sub17_sub4_sub1.anInt3098));
                            }
                            class40_sub5_sub17_sub1.method765(51, Class5.anInt199);
                            Npc.aScene_3301.method134(Player.anInt3267, (int) class40_sub5_sub17_sub1.aDouble2980, (int) class40_sub5_sub17_sub1.aDouble2993, (int) class40_sub5_sub17_sub1.aDouble2992, 60, class40_sub5_sub17_sub1, class40_sub5_sub17_sub1.anInt3013, -1, false);
                        }
                    } else
                        class40_sub5_sub17_sub1.method457(-1);
                }
            }

    }

    public Node method329(boolean arg0) {

        anInt572 = 0;
            anInt552++;
            if(arg0 != false)
                return null;
            return method336((byte) -38);

    }

    public void put(Node arg0, byte arg1, long arg2) {

        anInt560++;
            if(arg0.aClass40_968 != null)
                arg0.method457(-1);
            Node class40 = nodes[(int) ((long) (-1 + size) & arg2)];
            arg0.aClass40_950 = class40;
            arg0.key = arg2;
            arg0.aClass40_968 = class40.aClass40_968;
            arg0.aClass40_968.aClass40_950 = arg0;
            arg0.aClass40_950.aClass40_968 = arg0;
            int i = -96 / ((arg1 + 54) / 54);

    }

    public Node method331(long arg0, int arg1) {

        aLong550 = arg0;
            if(arg1 != 6120)
                return null;
            anInt568++;
            Node class40 = nodes[(int) ((long) (size + -1) & arg0)];
            for(aClass40_566 = class40.aClass40_950; class40 != aClass40_566; aClass40_566 = aClass40_566.aClass40_950) {
                if(aClass40_566.key == arg0) {
                    Node class40_0_ = aClass40_566;
                    aClass40_566 = aClass40_566.aClass40_950;
                    return class40_0_;
                }
            }
            aClass40_566 = null;
            return null;

    }

    public Node method333() {
        anInt556++;
        if(aClass40_566 == null)
            return null;
        for(Node class40 = nodes[(int) (aLong550 & (long) (-1 + size))]; class40 != aClass40_566; aClass40_566 = aClass40_566.aClass40_950) {
            if((aClass40_566.key ^ 0xffffffffffffffffL) == (aLong550 ^ 0xffffffffffffffffL)) {
                Node class40_1_ = aClass40_566;
                aClass40_566 = aClass40_566.aClass40_950;
                return class40_1_;
            }
        }
        aClass40_566 = null;
        return null;
    }

    public Node method336(byte arg0) {

        anInt551++;
            if(arg0 > -26)
                aClass40_566 = null;
            if((anInt572 ^ 0xffffffff) < -1 && aClass40_574 != nodes[anInt572 - 1]) {
                Node class40 = aClass40_574;
                aClass40_574 = class40.aClass40_950;
                return class40;
            }
            while(size > anInt572) {
                Node class40 = nodes[anInt572++].aClass40_950;
                if(class40 != nodes[anInt572 - 1]) {
                    aClass40_574 = class40.aClass40_950;
                    return class40;
                }
            }
            return null;

    }
}
