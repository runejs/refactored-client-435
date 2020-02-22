package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;

public class Class40_Sub5_Sub17_Sub1 extends Renderable {
    public static int anInt2956;
    public static int anInt2959;
    public static RSString aClass1_2963 = Class58.method978("Feb");
    public static RSString[] aClass1Array2964;
    public static RSString aClass1_2965;
    public static RSString aClass1_2966;
    public static RSString aClass1_2967;
    public static RSString aClass1_2969 = Class58.method978("Aug");
    public static int anInt2970;
    public static boolean[] aBooleanArray2975;
    public static RSString aClass1_2977;
    public static int anInt2978;
    public static int anInt2979;
    public static int anInt2983;
    public static RSString aClass1_2985;
    public static int anInt2986;
    public static int[] anIntArray2987;
    public static RSString aClass1_2988;
    public static RSString aClass1_2990;
    public static RSString aClass1_2991;
    public static int anInt2994;
    public static RSString aClass1_2998;
    public static int anInt2999;
    public static Class6_Sub1 aClass6_Sub1_3000;
    public static RSString aClass1_3002;
    public static int anInt3004;
    public static int anInt3005;
    public static int anInt3007;
    public static int anInt3008;
    public static RSString aClass1_3009;
    public static RSString aClass1_3010;
    public static RSString aClass1_3012;
    public static RSString aClass1_3014;
    public static RSString aClass1_3015;

    static {
        aClass1_2967 = Class58.method978("Dec");
        aBooleanArray2975 = new boolean[5];
        aClass1_2990 = Class58.method978("Mar");
        aClass1_2977 = Class58.method978("Regeln versto-8en hat)3");
        anInt2999 = 0;
        aClass1_2998 = Class58.method978("May");
        aClass1_3002 = Class58.method978("Loading wordpack )2 ");
        aClass1_2985 = Class58.method978("Jun");
        aClass1_2965 = Class58.method978("Oct");
        aClass1_2991 = Class58.method978("Jul");
        aClass1_3010 = Class58.method978("Connecting to server)3)3)3");
        aClass1_3009 = aClass1_3010;
        anIntArray2987 = new int[]{768, 1024, 1280, 512, 1536, 256, 0, 1792};
        aClass1_3012 = Class58.method978("Jan");
        aClass1_2966 = Class58.method978("Sep");
        aClass1_2988 = Class58.method978("Nov");
        aClass1_3014 = aClass1_3002;
        aClass1_3015 = Class58.method978("Apr");
        aClass1Array2964 = new RSString[]{aClass1_3012, aClass1_2963, aClass1_2990, aClass1_3015, aClass1_2998, aClass1_2985, aClass1_2991, aClass1_2969, aClass1_2966, aClass1_2965, aClass1_2988, aClass1_2967};
    }

    public int anInt2957;
    public int anInt2958;
    public int anInt2960;
    public int anInt2961;
    public int anInt2962;
    public boolean aBoolean2968;
    public int anInt2971;
    public double aDouble2972;
    public int anInt2973 = 0;
    public int anInt2974;
    public int anInt2976;
    public double aDouble2980;
    public int anInt2981;
    public int anInt2982;
    public int anInt2984;
    public int anInt2989;
    public double aDouble2992;
    public double aDouble2993;
    public double aDouble2995;
    public double aDouble2996;
    public int anInt2997;
    public double aDouble3001;
    public Class40_Sub5_Sub7 aClass40_Sub5_Sub7_3006;
    public double aDouble3011;
    public int anInt3013;

    public Class40_Sub5_Sub17_Sub1(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10) {
        aBoolean2968 = false;
        anInt2982 = 0;
            anInt2958 = arg2;
            anInt2957 = arg4;
            aBoolean2968 = false;
            anInt2960 = arg10;
            anInt2989 = arg8;
            anInt2962 = arg0;
            anInt2981 = arg1;
            anInt2971 = arg6;
            anInt2974 = arg5;
            anInt2961 = arg9;
            anInt2984 = arg3;
            anInt2997 = arg7;
            int i = Class37.method431(anInt2962, 13).anInt2287;
            if(i != -1)
                aClass40_Sub5_Sub7_3006 = Class68_Sub1.method1050(i, 2);
            else
                aClass40_Sub5_Sub7_3006 = null;

    }

    public static void method758(Class6 arg0, Class6 arg1, Class6 arg2, byte arg3) {
        do {
                Cache.aClass6_329 = arg2;
                Class40_Sub5_Sub4.aClass6_2349 = arg0;
                Class40_Sub5_Sub15.aClass6_2779 = arg1;
                Class59.aClass40_Sub5_Sub12ArrayArray1390 = (new Class40_Sub5_Sub12
                        [Class40_Sub5_Sub4.aClass6_2349.method175(-82)][]);
                anInt2994++;
                Class68.aBooleanArray1629 = (new boolean
                        [Class40_Sub5_Sub4.aClass6_2349.method175(-116)]);
                if(arg3 == 90)
                    break;
                aClass6_Sub1_3000 = null;

            break;
        } while(false);
    }

    public static void method759(boolean arg0) {

        anInt2959++;
            Cache.outgoingbuffer.initBitAccess(114);
            int i = Cache.outgoingbuffer.putBits(8, (byte) -65);
        if(GameObjectDefinition.anInt2558 > i) {
                for(int i_0_ = i; i_0_ < GameObjectDefinition.anInt2558; i_0_++)
                    Class6.anIntArray225[Class17.anInt460++] = Class40_Sub3.anIntArray2016[i_0_];
            }
        if(GameObjectDefinition.anInt2558 < i)
                throw new RuntimeException("gnpov1");
            GameObjectDefinition.anInt2558 = 0;
            if(arg0 == false) {
                for(int i_1_ = 0; i_1_ < i; i_1_++) {
                    int i_2_ = Class40_Sub3.anIntArray2016[i_1_];
                    Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[i_2_]);
                    int i_3_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                    if(i_3_ == 0) {
                        Class40_Sub3.anIntArray2016[GameObjectDefinition.anInt2558++] = i_2_;
                        class40_sub5_sub17_sub4_sub2.anInt3134 = Node.anInt926;
                    } else {
                        int i_4_ = Cache.outgoingbuffer.putBits(2, (byte) -65);
                        if((i_4_ ^ 0xffffffff) == -1) {
                            Class40_Sub3.anIntArray2016[GameObjectDefinition.anInt2558++] = i_2_;
                            class40_sub5_sub17_sub4_sub2.anInt3134 = Node.anInt926;
                            Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                        } else if((i_4_ ^ 0xffffffff) == -2) {
                            Class40_Sub3.anIntArray2016[GameObjectDefinition.anInt2558++] = i_2_;
                            class40_sub5_sub17_sub4_sub2.anInt3134 = Node.anInt926;
                            int i_5_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                            class40_sub5_sub17_sub4_sub2.method782(i_5_, (byte) -96, false);
                            int i_6_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                            if(i_6_ == 1)
                                Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                        } else if((i_4_ ^ 0xffffffff) == -3) {
                            Class40_Sub3.anIntArray2016[GameObjectDefinition.anInt2558++] = i_2_;
                            class40_sub5_sub17_sub4_sub2.anInt3134 = Node.anInt926;
                            int i_7_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                            class40_sub5_sub17_sub4_sub2.method782(i_7_, (byte) -96, true);
                            int i_8_ = Cache.outgoingbuffer.putBits(3, (byte) -65);
                            class40_sub5_sub17_sub4_sub2.method782(i_8_, (byte) -96, true);
                            int i_9_ = Cache.outgoingbuffer.putBits(1, (byte) -65);
                            if(i_9_ == 1)
                                Class24.anIntArray578[Actor.anInt3153++] = i_2_;
                        } else if(i_4_ == 3)
                            Class6.anIntArray225[Class17.anInt460++] = i_2_;
                    }
                }
            }

    }

    public static RSFont method760(int arg0, byte arg1, Class6 arg2, int arg3) {

        anInt2978++;
            int i = -104 / ((-22 - arg1) / 53);
            if(!Class52.method948(arg0, arg3, arg2, -3844))
                return null;
            return Class60.method987(114);

    }

    public static void method761(byte arg0) {

        aClass1Array2964 = null;
            aClass1_2966 = null;
            aClass1_2963 = null;
            aClass6_Sub1_3000 = null;
            aBooleanArray2975 = null;
            aClass1_2990 = null;
            aClass1_2977 = null;
            aClass1_2991 = null;
            aClass1_3002 = null;
            aClass1_3012 = null;
            int i = -48 % ((46 - arg0) / 37);
            aClass1_2985 = null;
            aClass1_2969 = null;
            aClass1_2965 = null;
            aClass1_3014 = null;
            anIntArray2987 = null;
            aClass1_3015 = null;
            aClass1_2967 = null;
            aClass1_2998 = null;
            aClass1_2988 = null;
            aClass1_3010 = null;
            aClass1_3009 = null;

    }

    public static void method762(int arg0, Actor arg1) {

        anInt3008++;
            if(arg0 != (arg1.anInt3113 ^ 0xffffffff)) {
                if(arg1.anInt3137 != -1 && (arg1.anInt3137 ^ 0xffffffff) > -32769) {
                    Npc class40_sub5_sub17_sub4_sub2 = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[arg1.anInt3137]);
                    if(class40_sub5_sub17_sub4_sub2 != null) {
                        int i = (-class40_sub5_sub17_sub4_sub2.anInt3089 + arg1.anInt3089);
                        int i_10_ = (-class40_sub5_sub17_sub4_sub2.anInt3098 + arg1.anInt3098);
                        if((i_10_ ^ 0xffffffff) != -1 || i != 0)
                            arg1.anInt3080 = 0x7ff & (int) (325.949 * Math.atan2((double) i_10_, (double) i));
                    }
                }
                if((arg1.anInt3137 ^ 0xffffffff) <= -32769) {
                    int i = -32768 + arg1.anInt3137;
                    if(i == Class30.anInt708)
                        i = 2047;
                    Player class40_sub5_sub17_sub4_sub1 = (Actor.aClass40_Sub5_Sub17_Sub4_Sub1Array3156[i]);
                    if(class40_sub5_sub17_sub4_sub1 != null) {
                        int i_11_ = (arg1.anInt3098 - class40_sub5_sub17_sub4_sub1.anInt3098);
                        int i_12_ = (-class40_sub5_sub17_sub4_sub1.anInt3089 + arg1.anInt3089);
                        if((i_11_ ^ 0xffffffff) != -1 || i_12_ != 0)
                            arg1.anInt3080 = (int) (Math.atan2((double) i_11_, (double) i_12_) * 325.949) & 0x7ff;
                    }
                }
                if((arg1.anInt3148 != 0 || (arg1.anInt3100 ^ 0xffffffff) != -1) && ((arg1.anInt3109 ^ 0xffffffff) == -1 || (arg1.anInt3074 ^ 0xffffffff) < -1)) {
                    int i = (arg1.anInt3089 - 64 * (arg1.anInt3100 - Class26.anInt635 - Class26.anInt635));
                    int i_13_ = (-((-Class40_Sub5_Sub2.anInt2307 + arg1.anInt3148 + -Class40_Sub5_Sub2.anInt2307) * 64) + arg1.anInt3098);
                    if((i_13_ ^ 0xffffffff) != -1 || (i ^ 0xffffffff) != -1)
                        arg1.anInt3080 = 0x7ff & (int) (325.949 * Math.atan2((double) i_13_, (double) i));
                    arg1.anInt3100 = 0;
                    arg1.anInt3148 = 0;
                }
                int i = 0x7ff & arg1.anInt3080 + -arg1.anInt3118;
                if((i ^ 0xffffffff) != -1) {
                    arg1.anInt3097++;
                    if(i > 1024) {
                        arg1.anInt3118 -= arg1.anInt3113;
                        boolean bool = true;
                        if(arg1.anInt3113 > i || ((2048 + -arg1.anInt3113 ^ 0xffffffff) > (i ^ 0xffffffff))) {
                            bool = false;
                            arg1.anInt3118 = arg1.anInt3080;
                        }
                        if(arg1.anInt3126 == arg1.anInt3077 && ((arg1.anInt3097 ^ 0xffffffff) < -26 || bool)) {
                            if(arg1.anInt3145 != -1)
                                arg1.anInt3077 = arg1.anInt3145;
                            else
                                arg1.anInt3077 = arg1.anInt3131;
                        }
                    } else {
                        arg1.anInt3118 += arg1.anInt3113;
                        boolean bool = true;
                        if(i < arg1.anInt3113 || (i ^ 0xffffffff) < (-arg1.anInt3113 + 2048 ^ 0xffffffff)) {
                            arg1.anInt3118 = arg1.anInt3080;
                            bool = false;
                        }
                        if(arg1.anInt3077 == arg1.anInt3126 && ((arg1.anInt3097 ^ 0xffffffff) < -26 || bool)) {
                            if(arg1.anInt3083 != -1)
                                arg1.anInt3077 = arg1.anInt3083;
                            else
                                arg1.anInt3077 = arg1.anInt3131;
                        }
                    }
                    arg1.anInt3118 &= 0x7ff;
                } else
                    arg1.anInt3097 = 0;
            }

    }

    public static void method763(Component arg0, byte arg1, Class6 arg2) {

        anInt2970++;
            if(!SubNode.aBoolean2083) {
                FloorDecoration.aClass40_Sub5_Sub14_Sub2_593 = Class27.method359(Class27.aClass1_638, Class8.aClass1_305, arg2, (byte) -64);
                Class44.aClass40_Sub5_Sub14_Sub2_1047 = Class27.method359(RSString.aClass1_1716, Class8.aClass1_305, arg2, (byte) -64);
                Class34.mapBack = Class27.method359(VertexNormal.aClass1_1113, Class8.aClass1_305, arg2, (byte) -64);
                Class57.aClass40_Sub5_Sub14_Sub2_1346 = Class27.method359(Class59.aClass1_1395, Class8.aClass1_305, arg2, (byte) -64);
                Class56.aClass40_Sub5_Sub14_Sub2_1329 = Class27.method359(Class6.aClass1_256, Class8.aClass1_305, arg2, (byte) -64);
                Buffer.aClass40_Sub5_Sub14_Sub2_1959 = Class27.method359(Class10.aClass1_338, Class8.aClass1_305, arg2, (byte) -64);
                RSCanvas.aClass68_64 = Class40_Sub5_Sub13.method649(96, 479, arg0, -4875);
                Class44.aClass40_Sub5_Sub14_Sub2_1047.method692(0, 0);
                RSString.aClass68_1665 = Class40_Sub5_Sub13.method649(156, 172, arg0, -4875);
                Rasterizer.method663();
                Class34.mapBack.method692(0, 0);
                SubNode.aClass68_2091 = Class40_Sub5_Sub13.method649(261, 190, arg0, -4875);
                FloorDecoration.aClass40_Sub5_Sub14_Sub2_593.method692(0, 0);
                Class40_Sub5_Sub4.aClass68_2350 = Class40_Sub5_Sub13.method649(334, 512, arg0, -4875);
                Rasterizer.method663();
                Class66.aClass68_1541 = Class40_Sub5_Sub13.method649(50, 496, arg0, -4875);
                RSCanvas.aClass68_59 = Class40_Sub5_Sub13.method649(37, 269, arg0, -4875);
                Class19.aClass68_482 = Class40_Sub5_Sub13.method649(45, 249, arg0, -4875);
                ImageRGB class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class61.aClass1_1440, (byte) 21, Class8.aClass1_305);
                Landscape.aClass68_1185 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class43.aClass1_1024, (byte) 21, Class8.aClass1_305);
                Class40_Sub5_Sub1.aClass68_2275 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class8.aClass1_281, (byte) 21, Class8.aClass1_305);
                Class39.aClass68_908 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class53.aClass1_1266, (byte) 21, Class8.aClass1_305);
                GameObject.aClass68_3045 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Main.aClass1_1788, (byte) 21, Class8.aClass1_305);
                Class40_Sub5_Sub17_Sub6.aClass68_3243 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class58.aClass1_1374, (byte) 21, Class8.aClass1_305);
                Class40_Sub7.aClass68_2123 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class40_Sub5_Sub10.aClass1_2588, (byte) 21, Class8.aClass1_305);
                Class61.aClass68_1441 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class5.aClass1_196, (byte) 21, Class8.aClass1_305);
                Class30.aClass68_714 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                class40_sub5_sub14_sub4.method727(0, 0);
                class40_sub5_sub14_sub4 = Class66.method1028(arg2, Class8.aClass1_304, (byte) 21, Class8.aClass1_305);
                Class17.aClass68_462 = Class40_Sub5_Sub13.method649((class40_sub5_sub14_sub4.image_heighteight), (class40_sub5_sub14_sub4.image_width), arg0, -4875);
                int i = -80 % ((arg1 - 9) / 40);
                class40_sub5_sub14_sub4.method727(0, 0);
                Class56.aClass40_Sub5_Sub14_Sub2_1315 = Class27.method359(SubNode.aClass1_2093, Class8.aClass1_305, arg2, (byte) -64);
                RSApplet.aClass40_Sub5_Sub14_Sub2_1 = Class27.method359(Class40_Sub5_Sub17_Sub6.aClass1_3254, Class8.aClass1_305, arg2, (byte) -64);
                Class35.aClass40_Sub5_Sub14_Sub2_1744 = Class27.method359(Class64.aClass1_1517, Class8.aClass1_305, arg2, (byte) -64);
                Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
                Class40_Sub6.aClass40_Sub5_Sub14_Sub2_2105.method695();
                Class53.aClass40_Sub5_Sub14_Sub2_1270 = RSApplet.aClass40_Sub5_Sub14_Sub2_1.method691();
                Class53.aClass40_Sub5_Sub14_Sub2_1270.method695();
                Renderable.aClass40_Sub5_Sub14_Sub2_2860 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
                Renderable.aClass40_Sub5_Sub14_Sub2_2860.method696();
                HashTable.aClass40_Sub5_Sub14_Sub2_549 = RSApplet.aClass40_Sub5_Sub14_Sub2_1.method691();
                HashTable.aClass40_Sub5_Sub14_Sub2_549.method696();
                Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919 = Class35.aClass40_Sub5_Sub14_Sub2_1744.method691();
                Class38_Sub1.aClass40_Sub5_Sub14_Sub2_1919.method696();
                ISAAC.aClass40_Sub5_Sub14_Sub2_524 = Class56.aClass40_Sub5_Sub14_Sub2_1315.method691();
                ISAAC.aClass40_Sub5_Sub14_Sub2_524.method695();
                ISAAC.aClass40_Sub5_Sub14_Sub2_524.method696();
                Class13.aClass40_Sub5_Sub14_Sub2_418 = RSApplet.aClass40_Sub5_Sub14_Sub2_1.method691();
                Class13.aClass40_Sub5_Sub14_Sub2_418.method695();
                Class13.aClass40_Sub5_Sub14_Sub2_418.method696();
                Class40_Sub5_Sub15.aClass40_Sub5_Sub14_Sub2Array2776 = Class40_Sub5_Sub2.method550(arg2, (byte) -78, (Class40_Sub5_Sub15.aClass1_2787), Class8.aClass1_305);
                Landscape.anIntArray1186 = new int[151];
                RSCanvas.anIntArray66 = new int[33];
                RSCanvas.anIntArray62 = new int[33];
                Class34.anIntArray852 = new int[151];
                for(int i_14_ = 0; (i_14_ ^ 0xffffffff) > -34; i_14_++) {
                    int i_15_ = 0;
                    int i_16_ = 999;
                    for(int i_17_ = 0; i_17_ < 34; i_17_++) {
                        if(((Class34.mapBack.imgPixels[(Class34.mapBack.anInt2921 * i_14_) + i_17_]) ^ 0xffffffff) == -1) {
                            if((i_16_ ^ 0xffffffff) == -1000)
                                i_16_ = i_17_;
                        } else if(i_16_ != 999) {
                            i_15_ = i_17_;
                            break;
                        }
                    }
                    RSCanvas.anIntArray62[i_14_] = i_16_;
                    RSCanvas.anIntArray66[i_14_] = -i_16_ + i_15_;
                }
                for(int i_18_ = 5; i_18_ < 156; i_18_++) {
                    int i_19_ = 0;
                    int i_20_ = 999;
                    for(int i_21_ = 25; i_21_ < 172; i_21_++) {
                        if((Class34.mapBack.imgPixels[i_21_ + (Class34.mapBack.anInt2921) * i_18_]) != 0 || i_21_ <= 34 && (i_18_ ^ 0xffffffff) >= -35) {
                            if((i_20_ ^ 0xffffffff) != -1000) {
                                i_19_ = i_21_;
                                break;
                            }
                        } else if((i_20_ ^ 0xffffffff) == -1000)
                            i_20_ = i_21_;
                    }
                    Landscape.anIntArray1186[-5 + i_18_] = i_20_ - 25;
                    Class34.anIntArray852[-5 + i_18_] = i_19_ + -i_20_;
                }
                SubNode.aBoolean2083 = true;
            }

    }

    public static int method764(byte arg0) {

        anInt2956++;
            int i = 3;
            if((Class26.anInt627 ^ 0xffffffff) > -311) {
                int i_22_ = Class40_Sub5_Sub6.anInt2443 >> -300913273;
                int i_23_ = Class12.anInt388 >> -1245518521;
                if(i_22_ > 103) {
                    i_22_ = 103;
                }
                if(i_23_ > 103) {
                    i_23_ = 103;
                }
                if(((Floor.tile_flags[Player.anInt3267][i_23_][i_22_]) & 0x4) != 0)
                    i = Player.anInt3267;
                int i_24_ = ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3098) >> -1546085145);
                int i_25_ = ((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3089) >> -26166617);
                int i_26_;
                if(i_24_ <= i_23_)
                    i_26_ = -i_24_ + i_23_;
                else
                    i_26_ = -i_23_ + i_24_;
                int i_27_;
                if((i_22_ ^ 0xffffffff) > (i_25_ ^ 0xffffffff))
                    i_27_ = i_25_ + -i_22_;
                else
                    i_27_ = -i_25_ + i_22_;
                if(i_26_ <= i_27_) {
                    int i_28_ = i_26_ * 65536 / i_27_;
                    int i_29_ = 32768;
                    while((i_25_ ^ 0xffffffff) != (i_22_ ^ 0xffffffff)) {
                        if(i_25_ <= i_22_) {
                            if(i_22_ > i_25_)
                                i_22_--;
                        } else
                            i_22_++;
                        if(i_22_ > 103) {
                            i_22_ = 103;
                        }
                        i_29_ += i_28_;
                        if(((Floor.tile_flags[Player.anInt3267][i_23_][i_22_]) & 0x4 ^ 0xffffffff) != -1)
                            i = Player.anInt3267;
                        if((i_29_ ^ 0xffffffff) <= -65537) {
                            if(i_23_ < i_24_)
                                i_23_++;
                            else if((i_24_ ^ 0xffffffff) > (i_23_ ^ 0xffffffff))
                                i_23_--;
                            i_29_ -= 65536;
                            if(((0x4 & (Floor.tile_flags[Player.anInt3267][i_23_][i_22_])) ^ 0xffffffff) != -1)
                                i = Player.anInt3267;
                        }
                    }
                } else {
                    int i_30_ = i_27_ * 65536 / i_26_;
                    int i_31_ = 32768;
                    while((i_24_ ^ 0xffffffff) != (i_23_ ^ 0xffffffff)) {
                        if(i_23_ >= i_24_) {
                            if((i_24_ ^ 0xffffffff) > (i_23_ ^ 0xffffffff))
                                i_23_--;
                        } else
                            i_23_++;
                        if(((Floor.tile_flags[Player.anInt3267][i_23_][i_22_]) & 0x4 ^ 0xffffffff) != -1)
                            i = Player.anInt3267;
                        i_31_ += i_30_;
                        if(i_31_ >= 65536) {
                            i_31_ -= 65536;
                            if(i_25_ > i_22_)
                                i_22_++;
                            else if(i_22_ > i_25_)
                                i_22_--;
                            if(((Floor.tile_flags[Player.anInt3267][i_23_][i_22_]) & 0x4 ^ 0xffffffff) != -1)
                                i = Player.anInt3267;
                        }
                    }
                }
            }
            if(arg0 > -101)
                aClass6_Sub1_3000 = null;
            if(((Floor.tile_flags[Player.anInt3267][(Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3098) >> -1782384953][(Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub4_Sub1_2760.anInt3089) >> -1953891737]) & 0x4) != 0)
                i = Player.anInt3267;
            return i;

    }

    public static void addObject(int objectId, int localX, int localY, int plane, int face, int type, Scene scene, CollisionMap collisionMap) {
        if(!VertexNormal.lowMemory || (0x2 & (Floor.tile_flags[0][localX][localY]) ^ 0xffffffff) != -1 || ((0x10 & (Floor.tile_flags[plane][localX][localY]) ^ 0xffffffff) == -1 && ((Class59.getVisibilityPlaneFor(plane, localY, 0, localX) ^ 0xffffffff) == (Class40_Sub6.onBuildTimePlane ^ 0xffffffff)))) {
            if(Class64.setZ > plane)
                Class64.setZ = plane;
            int vertexHeight = Class40_Sub6.tile_height[plane][localX][localY];
            int vertexHeightRight = Class40_Sub6.tile_height[plane][localX + 1][localY];
            int vertexHeightTopRight = Class40_Sub6.tile_height[plane][localX + 1][localY + 1];
            int vertexHeightTop = Class40_Sub6.tile_height[plane][localX][localY + 1];
            int vertexMix = vertexHeight + vertexHeightRight + vertexHeightTopRight + vertexHeightTop >> 2;
            GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(objectId);
            int hash = localX + (localY << 7) + (objectId << 14) + 1073741824;
            int objectConfig = (byte) ((face << 6) + type);
            if(gameObjectDefinition.anInt2533 == 1)
                objectConfig += 256;
            if((gameObjectDefinition.hasActions ^ 0xffffffff) == -1)
                hash += -2147483648;
            if(gameObjectDefinition.method601((byte) 125))
                Class37.method437(localY, true, plane, face, localX, gameObjectDefinition);
            if(type == 22) {
                if(!VertexNormal.lowMemory || (gameObjectDefinition.hasActions ^ 0xffffffff) != -1 || gameObjectDefinition.unknown) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 22, (byte) 124, vertexHeightRight);
                    else
                        renderable = new GameObject(objectId, 22, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true);
                    scene.addGroundDecoration(localX, localY, plane, vertexMix, hash, renderable, objectConfig);
                    if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1 && collisionMap != null)
                        collisionMap.markBlocked((byte) -28, localY, localX);
                }
            } else if(type == 10 || type == 11) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, (byte) 124, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 10, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                if(renderable != null) {
                    int i_40_;
                    int i_41_;
                    if((face ^ 0xffffffff) != -2 && face != 3) {
                        i_41_ = gameObjectDefinition.anInt2503;
                        i_40_ = gameObjectDefinition.anInt2515;
                    } else {
                        i_40_ = gameObjectDefinition.anInt2503;
                        i_41_ = gameObjectDefinition.anInt2515;
                    }
                    int i_42_ = 0;
                    if((type ^ 0xffffffff) == -12)
                        i_42_ += 256;
                    if(scene.method137(plane, localX, localY, vertexMix, i_41_, i_40_, renderable, i_42_, hash, objectConfig) && gameObjectDefinition.aBoolean2541) {
                        Model class40_sub5_sub17_sub5;
                        if(renderable instanceof Model)
                            class40_sub5_sub17_sub5 = ((Model) renderable);
                        else
                            class40_sub5_sub17_sub5 = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 10, (byte) 124, vertexHeightRight);
                        if(class40_sub5_sub17_sub5 != null) {
                            for(int i_43_ = 0; ((i_43_ ^ 0xffffffff) >= (i_41_ ^ 0xffffffff)); i_43_++) {
                                for(int i_44_ = 0; i_40_ >= i_44_; i_44_++) {
                                    int i_45_ = (class40_sub5_sub17_sub5.method805() / 4);
                                    if(i_45_ > 30)
                                        i_45_ = 30;
                                    if(i_45_ > (Class19.aByteArrayArrayArray492[plane][localX + i_43_][localY + i_44_]))
                                        Class19.aByteArrayArrayArray492[plane][i_43_ + localX][localY + i_44_] = (byte) i_45_;
                                }
                            }
                        }
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method154(localX, gameObjectDefinition.aBoolean2528, 120, gameObjectDefinition.anInt2515, face, localY, gameObjectDefinition.anInt2503);
            } else if(type >= 12) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.childrenIds != null)
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, (byte) 124, vertexHeightRight);
                scene.method137(plane, localX, localY, vertexMix, 1, 1, renderable, 0, hash, objectConfig);
                if((type ^ 0xffffffff) <= -13 && (type ^ 0xffffffff) >= -18 && type != 13 && (plane ^ 0xffffffff) < -1)
                    Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 2340));
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method154(localX, gameObjectDefinition.aBoolean2528, 108, gameObjectDefinition.anInt2515, face, localY, gameObjectDefinition.anInt2503);
            } else if(type == 0) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 0, (byte) 124, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 0, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.method94(plane, localX, localY, vertexMix, renderable, null, Class32.anIntArray761[face], 0, hash, objectConfig);
                if((face ^ 0xffffffff) != -1) {
                    if((face ^ 0xffffffff) == -2) {
                        if(gameObjectDefinition.aBoolean2541) {
                            Class19.aByteArrayArrayArray492[plane][localX][localY + 1] = (byte) 50;
                            Class19.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                        }
                        if(gameObjectDefinition.aBoolean2521)
                            Class6.anIntArrayArrayArray262[plane][localX][localY + 1] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY + 1]), 1170));
                    } else if((face ^ 0xffffffff) != -3) {
                        if(face == 3) {
                            if(gameObjectDefinition.aBoolean2541) {
                                Class19.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                                Class19.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                            }
                            if(gameObjectDefinition.aBoolean2521)
                                Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                        }
                    } else {
                        if(gameObjectDefinition.aBoolean2541) {
                            Class19.aByteArrayArrayArray492[plane][1 + localX][localY] = (byte) 50;
                            Class19.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                        }
                        if(gameObjectDefinition.aBoolean2521)
                            Class6.anIntArrayArrayArray262[plane][localX + 1][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX + 1][localY]), 585));
                    }
                } else {
                    if(gameObjectDefinition.aBoolean2541) {
                        Class19.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                        Class19.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                    }
                    if(gameObjectDefinition.aBoolean2521)
                        Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 585));
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method150(localY, type, face, localX, gameObjectDefinition.aBoolean2528, (byte) 95);
                if((gameObjectDefinition.anInt2505 ^ 0xffffffff) != -17)
                    scene.method115(plane, localX, localY, gameObjectDefinition.anInt2505);
            } else if((type ^ 0xffffffff) == -2) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 1, (byte) 124, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, 1, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.method94(plane, localX, localY, vertexMix, renderable, null, Class40_Sub5_Sub15.anIntArray2788[face], 0, hash, objectConfig);
                if(gameObjectDefinition.aBoolean2541) {
                    if(face == 0)
                        Class19.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                    else if(face == 1)
                        Class19.aByteArrayArrayArray492[plane][localX + 1][1 + localY] = (byte) 50;
                    else if((face ^ 0xffffffff) == -3)
                        Class19.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                    else if(face == 3)
                        Class19.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method150(localY, type, face, localX, gameObjectDefinition.aBoolean2528, (byte) 95);
            } else if((type ^ 0xffffffff) == -3) {
                int i_46_ = 0x3 & face + 1;
                Renderable renderable;
                Renderable renderable_47_;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null) {
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face + 4, vertexHeight, 2, (byte) 124, vertexHeightRight);
                    renderable_47_ = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, i_46_, vertexHeight, 2, (byte) 124, vertexHeightRight);
                } else {
                    renderable = new GameObject(objectId, 2, 4 + face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                    renderable_47_ = new GameObject(objectId, 2, i_46_, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                }
                scene.method94(plane, localX, localY, vertexMix, renderable, renderable_47_, Class32.anIntArray761[face], Class32.anIntArray761[i_46_], hash, objectConfig);
                if(gameObjectDefinition.aBoolean2521) {
                    if((face ^ 0xffffffff) != -1) {
                        if((face ^ 0xffffffff) == -2) {
                            Class6.anIntArrayArrayArray262[plane][localX][1 + localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][1 + localY]), 1170));
                            Class6.anIntArrayArrayArray262[plane][1 + localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][1 + localX][localY]), 585));
                        } else if((face ^ 0xffffffff) == -3) {
                            Class6.anIntArrayArrayArray262[plane][localX + 1][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX + 1][localY]), 585));
                            Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                        } else if(face == 3) {
                            Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 1170));
                            Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 585));
                        }
                    } else {
                        Class6.anIntArrayArrayArray262[plane][localX][localY] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY]), 585));
                        Class6.anIntArrayArrayArray262[plane][localX][(localY + 1)] = (Class40_Sub5_Sub9.method619((Class6.anIntArrayArrayArray262[plane][localX][localY + 1]), 1170));
                    }
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method150(localY, type, face, localX, gameObjectDefinition.aBoolean2528, (byte) 95);
                if((gameObjectDefinition.anInt2505 ^ 0xffffffff) != -17)
                    scene.method115(plane, localX, localY, gameObjectDefinition.anInt2505);
            } else if((type ^ 0xffffffff) == -4) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.childrenIds != null)
                    renderable = new GameObject(objectId, 3, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, 3, (byte) 124, vertexHeightRight);
                scene.method94(plane, localX, localY, vertexMix, renderable, null, Class40_Sub5_Sub15.anIntArray2788[face], 0, hash, objectConfig);
                if(gameObjectDefinition.aBoolean2541) {
                    if((face ^ 0xffffffff) != -1) {
                        if(face == 1)
                            Class19.aByteArrayArrayArray492[plane][1 + localX][localY + 1] = (byte) 50;
                        else if((face ^ 0xffffffff) == -3)
                            Class19.aByteArrayArrayArray492[plane][localX + 1][localY] = (byte) 50;
                        else if(face == 3)
                            Class19.aByteArrayArrayArray492[plane][localX][localY] = (byte) 50;
                    } else
                        Class19.aByteArrayArrayArray492[plane][localX][(localY + 1)] = (byte) 50;
                }
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method150(localY, type, face, localX, gameObjectDefinition.aBoolean2528, (byte) 95);
            } else if((type ^ 0xffffffff) == -10) {
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                    renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, face, vertexHeight, type, (byte) 124, vertexHeightRight);
                else
                    renderable = new GameObject(objectId, type, face, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, (gameObjectDefinition.animationId), true);
                scene.method137(plane, localX, localY, vertexMix, 1, 1, renderable, 0, hash, objectConfig);
                if(gameObjectDefinition.solid && collisionMap != null)
                    collisionMap.method154(localX, gameObjectDefinition.aBoolean2528, -36, gameObjectDefinition.anInt2515, face, localY, gameObjectDefinition.anInt2503);
            } else {
                if(gameObjectDefinition.adjustToTerrain) {
                    if(face == 1) {
                        int i_48_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeightRight;
                        vertexHeightRight = vertexHeight;
                        vertexHeight = i_48_;
                    } else if(face == 2) {
                        int i_49_ = vertexHeightTop;
                        vertexHeightTop = vertexHeightRight;
                        vertexHeightRight = i_49_;
                        i_49_ = vertexHeightTopRight;
                        vertexHeightTopRight = vertexHeight;
                        vertexHeight = i_49_;
                    } else if((face ^ 0xffffffff) == -4) {
                        int i_50_ = vertexHeightTop;
                        vertexHeightTop = vertexHeight;
                        vertexHeight = vertexHeightRight;
                        vertexHeightRight = vertexHeightTopRight;
                        vertexHeightTopRight = i_50_;
                    }
                }
                if(type == 4) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, (byte) 124, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.method109(plane, localX, localY, vertexMix, renderable, Class32.anIntArray761[face], 512 * face, 0, 0, hash, objectConfig);
                } else if((type ^ 0xffffffff) == -6) {
                    int i_51_ = scene.method122(plane, localX, localY);
                    int i_52_ = 16;
                    if((i_51_ ^ 0xffffffff) < -1)
                        i_52_ = (GameObjectDefinition.getDefinition((0x1fffedf2 & i_51_) >> 1054745038).anInt2505);
                    Renderable renderable;
                    if((gameObjectDefinition.animationId ^ 0xffffffff) == 0 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, (byte) 124, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.method109(plane, localX, localY, vertexMix, renderable, Class32.anIntArray761[face], face * 512, i_52_ * Class27.anIntArray666[face], (Class68_Sub1.anIntArray2207[face] * i_52_), hash, objectConfig);
                } else if(type == 6) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, (byte) 124, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.method109(plane, localX, localY, vertexMix, renderable, 256, face, 0, 0, hash, objectConfig);
                } else if((type ^ 0xffffffff) == -8) {
                    Renderable renderable;
                    if((gameObjectDefinition.animationId ^ 0xffffffff) == 0 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, (byte) 124, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.method109(plane, localX, localY, vertexMix, renderable, 512, face, 0, 0, hash, objectConfig);
                } else if(type == 8) {
                    Renderable renderable;
                    if((gameObjectDefinition.animationId ^ 0xffffffff) == 0 && gameObjectDefinition.childrenIds == null)
                        renderable = gameObjectDefinition.getGameObjectModel(vertexHeightTopRight, vertexHeightTop, 0, vertexHeight, 4, (byte) 124, vertexHeightRight);
                    else
                        renderable = (new GameObject(objectId, 4, 0, vertexHeight, vertexHeightRight, vertexHeightTopRight, vertexHeightTop, gameObjectDefinition.animationId, true));
                    scene.method109(plane, localX, localY, vertexMix, renderable, 768, face, 0, 0, hash, objectConfig);
                }
            }
        }

    }

    public Model method756(int arg0) {

        anInt2986++;
            int i = 119 / ((arg0 - 41) / 47);
            Class40_Sub5_Sub2 class40_sub5_sub2 = Class37.method431(anInt2962, 13);
            Model class40_sub5_sub17_sub5 = class40_sub5_sub2.method549(anInt2982, 2);
            if(class40_sub5_sub17_sub5 == null)
                return null;
            class40_sub5_sub17_sub5.method804(anInt2976);
            return class40_sub5_sub17_sub5;

    }

    public void method765(int arg0, int arg1) {
        anInt3007++;
        aBoolean2968 = true;
        aDouble2993 += (double) arg1 * aDouble3001;
        aDouble2980 += aDouble3011 * (double) arg1;
        if(arg0 >= 35) {
            aDouble2992 += (aDouble2996 * 0.5 * (double) arg1 * (double) arg1 + (double) arg1 * aDouble2972);
            aDouble2972 += (double) arg1 * aDouble2996;
            anInt3013 = 0x7ff & (int) (Math.atan2(aDouble3011, aDouble3001) * 325.949) + 1024;
            anInt2976 = 0x7ff & (int) (325.949 * Math.atan2(aDouble2972, aDouble2995));
            if(aClass40_Sub5_Sub7_3006 != null) {
                anInt2973 += arg1;
                while((aClass40_Sub5_Sub7_3006.anIntArray2466[anInt2982] ^ 0xffffffff) > (anInt2973 ^ 0xffffffff)) {
                    anInt2973 -= aClass40_Sub5_Sub7_3006.anIntArray2466[anInt2982];
                    anInt2982++;
                    if((aClass40_Sub5_Sub7_3006.anIntArray2485.length ^ 0xffffffff) >= (anInt2982 ^ 0xffffffff))
                        anInt2982 = 0;
                }
            }
        }
    }

    public void method766(int arg0, int arg1, int arg2, int arg3, int arg4) {
        if(!aBoolean2968) {
            double d = (double) (-anInt2958 + arg4);
            double d_32_ = (double) (-anInt2984 + arg2);
            double d_33_ = Math.sqrt(d * d + d_32_ * d_32_);
            aDouble2980 = (double) anInt2958 + d * (double) anInt2989 / d_33_;
            aDouble2993 = (double) anInt2984 + (double) anInt2989 * d_32_ / d_33_;
            aDouble2992 = (double) anInt2957;
        }
        double d = (double) (-arg0 + (1 + anInt2971));
        aDouble3001 = ((double) arg2 - aDouble2993) / d;
        aDouble3011 = ((double) arg4 - aDouble2980) / d;
        aDouble2995 = Math.sqrt(aDouble3001 * aDouble3001 + aDouble3011 * aDouble3011);
        anInt3005++;
        if(!aBoolean2968)
            aDouble2972 = -aDouble2995 * Math.tan((double) anInt2997 * 0.02454369);
        aDouble2996 = (-aDouble2992 + (double) arg3 - aDouble2972 * d) * 2.0 / (d * d);
        if(arg1 != 0)
            method759(true);
    }
}
