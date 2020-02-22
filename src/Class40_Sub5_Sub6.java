/* Class40_Sub5_Sub6 - Decompiled by JODE
 * Visit http://jode.sourceforge.net/
 */

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class40_Sub5_Sub6 extends SubNode {
    public static RSString aClass1_2434;
    public static int anInt2435;
    public static Class67[] aClass67Array2436 = new Class67[13];
    public static int anInt2437;
    public static RSString aClass1_2438;
    public static Cache aClass9_2439;
    public static RSString aClass1_2440;
    public static RSString aClass1_2442;
    public static int anInt2443;
    public static int anInt2444;
    public static int anInt2445;
    public static RSString aClass1_2446;
    public static RSString aClass1_2447;
    public static int anInt2448;
    public static int anInt2449;
    public static int anInt2450;
    public static int anInt2451;
    public static int anInt2452;
    public static int anInt2453;
    public static int anInt2454;
    public static int anInt2455;
    public static int anInt2456;
    public static RSString aClass1_2457;
    public static RSString aClass1_2458;
    public static RSString aClass1_2459;
    public static RSString aClass1_2460 = Class58.method978("RuneScape has been updated(Q");
    public static RSString aClass1_2461;
    public static RSString aClass1_2462;

    static {
        aClass1_2434 = Class58.method978(":duelreq:");
        aClass1_2447 = Class58.method978("@yel@*V");
        aClass1_2440 = Class58.method978("Enter name:");
        aClass1_2446 = aClass1_2440;
        aClass1_2442 = Class58.method978("scroll:");
        aClass1_2438 = aClass1_2442;
        anInt2452 = 0;
        anInt2451 = 0;
        aClass9_2439 = new Cache(64);
        aClass1_2457 = (Class58.method978(" steht bereits auf Ihrer Ignorieren)2Liste(Q"));
        aClass1_2459 = Class58.method978("From");
        aClass1_2458 = aClass1_2459;
        aClass1_2461 = Class58.method978("Error connecting to server)3");
        aClass1_2462 = aClass1_2461;
    }

    public byte[] aByteArray2441;

    public Class40_Sub5_Sub6(byte[] arg0) {
            aByteArray2441 = arg0;
    }

    public static void method582(boolean arg0) {
        aClass1_2461 = null;
        aClass1_2446 = null;
        aClass1_2434 = null;
        aClass1_2459 = null;
        aClass1_2447 = null;
        aClass1_2438 = null;
        aClass67Array2436 = null;
        aClass1_2458 = null;
        aClass1_2442 = null;
        aClass1_2462 = null;
        aClass9_2439 = null;
        aClass1_2457 = null;
        aClass1_2460 = null;
        aClass1_2440 = null;
        if(arg0 != true)
            method582(false);
    }

    public static boolean method583(int arg0, int arg1, int arg2, byte arg3, int arg4, int arg5, int arg6) {
            anInt2450++;
            if(!Class68.method1043(arg1, 127))
                return false;
            if(arg3 != -5)
                return true;
            return Main.method36(arg5, arg0, arg4, 0, -1, arg2, arg6, 0, (Class59.aClass40_Sub5_Sub12ArrayArray1390[arg1]), true);
    }

    public static void putHackCheckPacket(int arg0, int arg1, PacketBuffer arg2) {
        try {
            if(arg0 == -12) {
                anInt2444++;
                for(; ; ) {
                    Class40_Sub11 class40_sub11 = ((Class40_Sub11) Class54.aClass45_1278.method902((byte) -90));
                    if(class40_sub11 == null)
                        break;
                    boolean bool = false;
                    for(int i = 0; ((class40_sub11.anInt2160 ^ 0xffffffff) < (i ^ 0xffffffff)); i++) {
                        if(class40_sub11.aClass15Array2157[i] != null) {
                            if((class40_sub11.aClass15Array2157[i].anInt434 ^ 0xffffffff) == -3)
                                class40_sub11.anIntArray2155[i] = -5;
                            if(class40_sub11.aClass15Array2157[i].anInt434 == 0)
                                bool = true;
                        }
                        if(class40_sub11.aClass15Array2156[i] != null) {
                            if(class40_sub11.aClass15Array2156[i].anInt434 == 2)
                                class40_sub11.anIntArray2155[i] = -6;
                            if(class40_sub11.aClass15Array2156[i].anInt434 == 0)
                                bool = true;
                        }
                    }
                    if(bool)
                        break;
                    arg2.putPacket(11453, arg1);
                    arg2.put(0, (byte) -128);
                    int i = arg2.currentPosition;
                    arg2.putInt(123, class40_sub11.anInt2166);
                    for(int i_0_ = 0; class40_sub11.anInt2160 > i_0_; i_0_++) {
                        if((class40_sub11.anIntArray2155[i_0_] ^ 0xffffffff) != -1)
                            arg2.put(class40_sub11.anIntArray2155[i_0_], (byte) -128);
                        else {
                            try {
                                int i_1_ = class40_sub11.anIntArray2154[i_0_];
                                if(i_1_ == 0) {
                                    Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                    int i_2_ = field.getInt(null);
                                    arg2.put(0, (byte) -128);
                                    arg2.putInt(111, i_2_);
                                } else if((i_1_ ^ 0xffffffff) == -2) {
                                    Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                    field.setInt(null, (class40_sub11.anIntArray2165[i_0_]));
                                    arg2.put(0, (byte) -128);
                                } else if(i_1_ == 2) {
                                    Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                    int i_3_ = field.getModifiers();
                                    arg2.put(0, (byte) -128);
                                    arg2.putInt(66, i_3_);
                                }
                                if((i_1_ ^ 0xffffffff) != -4) {
                                    if((i_1_ ^ 0xffffffff) == -5) {
                                        Method method = ((Method) (class40_sub11.aClass15Array2156[i_0_].anObject437));
                                        int i_4_ = method.getModifiers();
                                        arg2.put(0, (byte) -128);
                                        arg2.putInt(77, i_4_);
                                    }
                                } else {
                                    Method method = ((Method) (class40_sub11.aClass15Array2156[i_0_].anObject437));
                                    byte[][] is = (class40_sub11.aByteArrayArrayArray2159[i_0_]);
                                    Object[] objects = new Object[is.length];
                                    for(int i_5_ = 0; ((is.length ^ 0xffffffff) < (i_5_ ^ 0xffffffff)); i_5_++) {
                                        ObjectInputStream objectinputstream = (new ObjectInputStream(new ByteArrayInputStream(is[i_5_])));
                                        objects[i_5_] = objectinputstream.readObject();
                                    }
                                    Object object = method.invoke(null, objects);
                                    if(object == null)
                                        arg2.put(0, (byte) -128);
                                    else if(!(object instanceof Number)) {
                                        if(object instanceof RSString) {
                                            arg2.put(2, (byte) -128);
                                            arg2.method505((RSString) object, (byte) -84);
                                        } else
                                            arg2.put(4, (byte) -128);
                                    } else {
                                        arg2.put(1, (byte) -128);
                                        arg2.putLong(((Number) object).longValue(), false);
                                    }
                                }
                            } catch(ClassNotFoundException classnotfoundexception) {
                                arg2.put(-10, (byte) -128);
                            } catch(java.io.InvalidClassException invalidclassexception) {
                                arg2.put(-11, (byte) -128);
                            } catch(java.io.StreamCorruptedException streamcorruptedexception) {
                                arg2.put(-12, (byte) -128);
                            } catch(java.io.OptionalDataException optionaldataexception) {
                                arg2.put(-13, (byte) -128);
                            } catch(IllegalAccessException illegalaccessexception) {
                                arg2.put(-14, (byte) -128);
                            } catch(IllegalArgumentException illegalargumentexception) {
                                arg2.put(-15, (byte) -128);
                            } catch(java.lang.reflect.InvocationTargetException invocationtargetexception) {
                                arg2.put(-16, (byte) -128);
                            } catch(SecurityException securityexception) {
                                arg2.put(-17, (byte) -128);
                            } catch(java.io.IOException ioexception) {
                                arg2.put(-18, (byte) -128);
                            } catch(NullPointerException nullpointerexception) {
                                arg2.put(-19, (byte) -128);
                            } catch(Exception exception) {
                                arg2.put(-20, (byte) -128);
                            } catch(Throwable throwable) {
                                arg2.put(-21, (byte) -128);
                            }
                        }
                    }
                    arg2.method473(81, i);
                    arg2.finishVarByte(-i + arg2.currentPosition, (byte) 16);
                    class40_sub11.method457(-1);
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, ("hd.B(" + arg0 + ',' + arg1 + ',' + (arg2 != null ? "{...}" : "null") + ')'));
        }
    }

    public static int method585(int arg0, int arg1) {
        try {
            Class40_Sub5_Sub4 class40_sub5_sub4 = Class34.method417(0, arg0);
            if(arg1 != 1369)
                return 27;
            anInt2456++;
            int i = class40_sub5_sub4.anInt2370;
            int i_6_ = class40_sub5_sub4.anInt2358;
            int i_7_ = class40_sub5_sub4.anInt2368;
            int i_8_ = Class68_Sub1.anIntArray2199[i - i_7_];
            return Class58.varbitmasks[i_6_] >> i_7_ & i_8_;
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "hd.D(" + arg0 + ',' + arg1 + ')');
        }
    }

    public static void method586(int arg0) {
        ISAAC.aClass9_510.method235((byte) 64);
        anInt2449++;
        Class67.aClass9_1611.method235((byte) -105);
        if(arg0 <= 63)
            aClass1_2462 = null;
    }

    public static void method587(int arg0) {
        try {
            anInt2445++;
            if(arg0 == 2) {
                while(Class34.method416((byte) -125)) {
                    if(Class66.anInt1560 != -1 && ((Class66.anInt1560 ^ 0xffffffff) == (Class66.anInt1548 ^ 0xffffffff))) {
                        if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1550.method59(arg0 ^ ~0xc3d) > 0))
                            Class66.aClass1_1550 = (Class66.aClass1_1550.method68(0, 0, -1 + Class66.aClass1_1550.method59(-3136)));
                        if((Class40_Sub5_Sub15.method735((byte) -37, Class59.anInt1388) || Class59.anInt1388 == 32) && Class66.aClass1_1550.method59(-3136) < 12)
                            Class66.aClass1_1550 = Class66.aClass1_1550.method70(Class59.anInt1388, 0);
                    } else if(!Class19.aBoolean490) {
                        if(Class40_Sub5_Sub15.anInt2780 == 1) {
                            if(((ItemDefinition.anInt2854 ^ 0xffffffff) == -86) && (Class66.aClass1_1543.method59(-3136) ^ 0xffffffff) < -1) {
                                Class66.aClass1_1543 = (Class66.aClass1_1543.method68(arg0 + -2, 0, (Class66.aClass1_1543.method59(-3136) - 1)));
                                Class52.aBoolean1221 = true;
                            }
                            if(Class66.method1027(Class59.anInt1388, -58) && Class66.aClass1_1543.method59(-3136) < 10) {
                                Class66.aClass1_1543 = Class66.aClass1_1543.method70(Class59.anInt1388, 0);
                                Class52.aBoolean1221 = true;
                            }
                            if(ItemDefinition.anInt2854 == 84) {
                                if(Class66.aClass1_1543.method59(-3136) > 0) {
                                    Buffer.anInt1937++;
                                    int i = 0;
                                    if(Class66.aClass1_1543.method82(arg0 + 105))
                                        i = Class66.aClass1_1543.method52((byte) -34);
                                    Class32.packetBuffer.putPacket(11453, 238);
                                    Class32.packetBuffer.putInt(68, i);
                                }
                                Class52.aBoolean1221 = true;
                                Class40_Sub5_Sub15.anInt2780 = 0;
                            }
                        } else if(Class40_Sub5_Sub15.anInt2780 != 2) {
                            if((Class40_Sub5_Sub15.anInt2780 ^ 0xffffffff) == -4) {
                                if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1543.method59(-3136) ^ 0xffffffff) < -1) {
                                    Class66.aClass1_1543 = (Class66.aClass1_1543.method68(0, 0, -1 + Class66.aClass1_1543.method59(-3136)));
                                    Class52.aBoolean1221 = true;
                                }
                                if((Player.method793((byte) 122, Class59.anInt1388)) && (Class66.aClass1_1543.method59(-3136) ^ 0xffffffff) > -41) {
                                    Class66.aClass1_1543 = Class66.aClass1_1543.method70(Class59.anInt1388, 0);
                                    Class52.aBoolean1221 = true;
                                }
                            } else if((Class43.anInt1028 ^ 0xffffffff) == 0 && (NpcDefinition.anInt2433 ^ 0xffffffff) == 0) {
                                if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1556.method59(-3136) > 0)) {
                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method68(0, 0, Class66.aClass1_1556.method59(arg0 + -3138) - 1));
                                    Class52.aBoolean1221 = true;
                                }
                                if((Player.method793((byte) 124, Class59.anInt1388)) && Class66.aClass1_1556.method59(arg0 ^ ~0xc3d) < 80) {
                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method70(Class59.anInt1388, arg0 + -2));
                                    Class52.aBoolean1221 = true;
                                }
                                if(ItemDefinition.anInt2854 == 84 && (Class66.aClass1_1556.method59(-3136) > 0)) {
                                    if(Class19.anInt493 == 2) {
                                        if(Class66.aClass1_1556.method54(Class58.aClass1_1359, arg0 + 120))
                                            Class59.method982(2578);
                                        if(Class66.aClass1_1556.method54(Class40_Sub3.aClass1_2015, 122))
                                            Class19.aBoolean496 = true;
                                        if(Class66.aClass1_1556.method54(Class40_Sub11.aClass1_2164, 122))
                                            Class19.aBoolean496 = false;
                                        if(Class66.aClass1_1556.method54(Class40_Sub5_Sub2.aClass1_2290, arg0 ^ 0x78)) {
                                            for(int i = 0; i < 4; i++) {
                                                for(int i_9_ = 1; ((i_9_ ^ 0xffffffff) > -104); i_9_++) {
                                                    for(int i_10_ = 1; i_10_ < 103; i_10_++)
                                                        Landscape.aCollisionMapArray1167[i].anIntArrayArray150[i_9_][i_10_] = 0;
                                                }
                                            }
                                        }
                                        if((Class66.aClass1_1556.method54(Class40_Sub5_Sub12.aClass1_2691, 122)) && (Class44.modewhere ^ 0xffffffff) == -3)
                                            throw new RuntimeException();
                                        if(Class66.aClass1_1556.method54(Class4.aClass1_177, 122))
                                            PacketBuffer.aBoolean2236 = true;
                                    }
                                    if(!Class66.aClass1_1556.method75((byte) 116, Class33.aClass1_786)) {
                                        int i = 0;
                                        Class40_Sub5_Sub4.anInt2362++;
                                        RSString class1 = Class66.aClass1_1556.method79(-128);
                                        int i_11_ = 0;
                                        if(class1.method75((byte) 116, (Class40_Sub5_Sub11.aClass1_2620))) {
                                            i_11_ = 0;
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, Class40_Sub5_Sub11.aClass1_2620.method59(-3136)));
                                        } else if(!class1.method75((byte) 116, Class5.aClass1_204)) {
                                            if(!class1.method75((byte) 116, (Player.aClass1_3256))) {
                                                if(class1.method75((byte) 116, Class45.aClass1_1076)) {
                                                    i_11_ = 3;
                                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Class45.aClass1_1076.method59(-3136))));
                                                } else if(!class1.method75((byte) 116, (RSString.aClass1_1717))) {
                                                    if(class1.method75((byte) 116, (Node.aClass1_940))) {
                                                        Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Node.aClass1_940.method59(-3136))));
                                                        i_11_ = 5;
                                                    } else if(!class1.method75((byte) 116, (Class43.aClass1_1019))) {
                                                        if(!class1.method75((byte) 116, (Class40_Sub5_Sub9.aClass1_2566))) {
                                                            if(!class1.method75((byte) 116, (Class57.aClass1_1343))) {
                                                                if(class1.method75((byte) 116, (Landscape.aClass1_1181))) {
                                                                    i_11_ = 9;
                                                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Landscape.aClass1_1181.method59(arg0 + -3138))));
                                                                } else if(!class1.method75((byte) 116, Class40_Sub5_Sub12.aClass1_2671)) {
                                                                    if(class1.method75((byte) 116, (Class51.aClass1_1196))) {
                                                                        Class66.aClass1_1556 = Class66.aClass1_1556.method50((byte) 95, Class51.aClass1_1196.method59(-3136));
                                                                        i_11_ = 11;
                                                                    }
                                                                } else {
                                                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, Class40_Sub5_Sub12.aClass1_2671.method59(-3136)));
                                                                    i_11_ = 10;
                                                                }
                                                            } else {
                                                                i_11_ = 8;
                                                                Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Class57.aClass1_1343.method59(-3136))));
                                                            }
                                                        } else {
                                                            i_11_ = 7;
                                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Class40_Sub5_Sub9.aClass1_2566.method59(-3136))));
                                                        }
                                                    } else {
                                                        i_11_ = 6;
                                                        Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Class43.aClass1_1019.method59(arg0 ^ ~0xc3d))));
                                                    }
                                                } else {
                                                    i_11_ = 4;
                                                    Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (RSString.aClass1_1717.method59(-3136))));
                                                }
                                            } else {
                                                i_11_ = 2;
                                                Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, Player.aClass1_3256.method59(-3136)));
                                            }
                                        } else {
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (Class5.aClass1_204.method59(arg0 ^ ~0xc3d))));
                                            i_11_ = 1;
                                        }
                                        class1 = Class66.aClass1_1556.method79(-128);
                                        if(class1.method75((byte) 116, (VertexNormal.aClass1_1097))) {
                                            i = 1;
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, (VertexNormal.aClass1_1097.method59(arg0 + -3138))));
                                        } else if(class1.method75((byte) 116, Class62.aClass1_1474)) {
                                            i = 2;
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, Class62.aClass1_1474.method59(-3136)));
                                        } else if(class1.method75((byte) 116, RSCanvas.aClass1_51)) {
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, RSCanvas.aClass1_51.method59(-3136)));
                                            i = 3;
                                        } else if(!class1.method75((byte) 116, aClass1_2438)) {
                                            if(class1.method75((byte) 116, Class55.aClass1_1291)) {
                                                i = 5;
                                                Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, Class55.aClass1_1291.method59(-3136)));
                                            }
                                        } else {
                                            i = 4;
                                            Class66.aClass1_1556 = (Class66.aClass1_1556.method50((byte) 95, aClass1_2438.method59(-3136)));
                                        }
                                        Class32.packetBuffer.putPacket(11453, 75);
                                        Class32.packetBuffer.put(0, (byte) -128);
                                        int i_12_ = (Class32.packetBuffer.currentPosition);
                                        Class32.packetBuffer.put(i_11_, (byte) -128);
                                        Class32.packetBuffer.put(i, (byte) -128);
                                        Class68_Sub1.method1052(65, Class66.aClass1_1556, Class32.packetBuffer);
                                        Class32.packetBuffer.finishVarByte((Class32.packetBuffer.currentPosition) + -i_12_, (byte) 16);
                                        if((Class35.anInt1737 ^ 0xffffffff) == -3) {
                                            Class34.anInt821++;
                                            Cache.aBoolean330 = true;
                                            Class35.anInt1737 = 3;
                                            Class32.packetBuffer.putPacket(11453, 32);
                                            Class32.packetBuffer.put(Class35.anInt1737, (byte) -128);
                                            Class32.packetBuffer.put(Class4.anInt185, (byte) -128);
                                            Class32.packetBuffer.put(ItemDefinition.anInt2797, (byte) -128);
                                        }
                                    } else {
                                        Class32.packetBuffer.putPacket(11453, 248);
                                        Class32.packetBuffer.put(-1 + Class66.aClass1_1556.method59(-3136), (byte) -128);
                                        Class32.packetBuffer.method505(Class66.aClass1_1556.method50((byte) 95, 2), (byte) 122);
                                        CollisionMap.anInt149++;
                                    }
                                    Class52.aBoolean1221 = true;
                                    Class66.aClass1_1556 = Class66.aClass1_1567;
                                }
                            }
                        } else {
                            if(((ItemDefinition.anInt2854 ^ 0xffffffff) == -86) && Class66.aClass1_1543.method59(arg0 ^ ~0xc3d) > 0) {
                                Class66.aClass1_1543 = (Class66.aClass1_1543.method68(0, 0, -1 + Class66.aClass1_1543.method59(-3136)));
                                Class52.aBoolean1221 = true;
                            }
                            if((Class40_Sub5_Sub15.method735((byte) -37, Class59.anInt1388) || Class59.anInt1388 == 32) && Class66.aClass1_1543.method59(-3136) < 12) {
                                Class66.aClass1_1543 = (Class66.aClass1_1543.method70(Class59.anInt1388, arg0 ^ 0x2));
                                Class52.aBoolean1221 = true;
                            }
                            if(ItemDefinition.anInt2854 == 84) {
                                if(Class66.aClass1_1543.method59(-3136) > 0) {
                                    Player.anInt3280++;
                                    Class32.packetBuffer.putPacket(11453, 86);
                                    Class32.packetBuffer.putLong(Class66.aClass1_1543.method58((byte) 89), false);
                                }
                                Class40_Sub5_Sub15.anInt2780 = 0;
                                Class52.aBoolean1221 = true;
                            }
                        }
                    } else {
                        if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1565.method59(arg0 ^ ~0xc3d) > 0)) {
                            Class66.aClass1_1565 = (Class66.aClass1_1565.method68(arg0 ^ 0x2, 0, -1 + Class66.aClass1_1565.method59(arg0 + -3138)));
                            Class52.aBoolean1221 = true;
                        }
                        if(Player.method793((byte) 120, Class59.anInt1388) && (Class66.aClass1_1565.method59(-3136) ^ 0xffffffff) > -81) {
                            Class66.aClass1_1565 = Class66.aClass1_1565.method70(Class59.anInt1388, arg0 ^ 0x2);
                            Class52.aBoolean1221 = true;
                        }
                        if((ItemDefinition.anInt2854 ^ 0xffffffff) == -85) {
                            Class19.aBoolean490 = false;
                            Class52.aBoolean1221 = true;
                            if((Class37.anInt876 ^ 0xffffffff) == -2) {
                                long l = Class66.aClass1_1565.method58((byte) 104);
                                Class40_Sub5_Sub9.method617(l, (byte) -99);
                            }
                            if((Class37.anInt876 ^ 0xffffffff) == -3 && (Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) < -1) {
                                long l = Class66.aClass1_1565.method58((byte) 121);
                                RSApplet.method28(l, 123);
                            }
                            if((Class37.anInt876 ^ 0xffffffff) == -4 && Class66.aClass1_1565.method59(-3136) > 0) {
                                Class44.anInt1044++;
                                Class32.packetBuffer.putPacket(11453, 207);
                                Class32.packetBuffer.put(0, (byte) -128);
                                int i = Class32.packetBuffer.currentPosition;
                                Class32.packetBuffer.putLong(PacketBuffer.aLong2241, false);
                                Class68_Sub1.method1052(119, Class66.aClass1_1565, Class32.packetBuffer);
                                Class32.packetBuffer.finishVarByte(-i + (Class32.packetBuffer.currentPosition), (byte) 16);
                                if(Class4.anInt185 == 2) {
                                    Class4.anInt185 = 1;
                                    Cache.aBoolean330 = true;
                                    Class34.anInt821++;
                                    Class32.packetBuffer.putPacket(11453, 32);
                                    Class32.packetBuffer.put(Class35.anInt1737, (byte) -128);
                                    Class32.packetBuffer.put(Class4.anInt185, (byte) -128);
                                    Class32.packetBuffer.put(ItemDefinition.anInt2797, (byte) -128);
                                }
                            }
                            if((Class37.anInt876 ^ 0xffffffff) == -5 && (Class42.anInt1008 ^ 0xffffffff) > -101) {
                                long l = Class66.aClass1_1565.method58((byte) 107);
                                Class17.method275(arg0 ^ 0x606c, l);
                            }
                            if((Class37.anInt876 ^ 0xffffffff) == -6 && (Class42.anInt1008 ^ 0xffffffff) < -1) {
                                long l = Class66.aClass1_1565.method58((byte) 109);
                                Class40_Sub6.method838(0, l);
                            }
                        }
                    }
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "hd.A(" + arg0 + ')');
        }
    }

    public static void method588(int arg0) {
        try {
            if(arg0 == -1) {
                anInt2454++;
                int i = Class19.anInt475;
                int i_13_ = CollisionMap.anInt168;
                int i_14_ = Main.anInt1758;
                int i_15_ = VertexNormal.anInt1086;
                int i_16_ = 6116423;
                Rasterizer.method656(i, i_14_, i_15_, i_13_, i_16_);
                Rasterizer.method656(1 + i, 1 + i_14_, -2 + i_15_, 16, 0);
                Rasterizer.method665(i + 1, 18 + i_14_, -2 + i_15_, -19 + i_13_, 0);
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method690(Class40_Sub5_Sub12.aClass1_2684, i + 3, 14 + i_14_, i_16_);
                int i_17_ = Class13.anInt420;
                int i_18_ = Landscape.anInt1166;
                if(Class40_Sub5_Sub17_Sub1.anInt2983 == 0) {
                    i_17_ -= 4;
                    i_18_ -= 4;
                }
                if(Class40_Sub5_Sub17_Sub1.anInt2983 == 1) {
                    i_18_ -= 205;
                    i_17_ -= 553;
                }
                if((Class40_Sub5_Sub17_Sub1.anInt2983 ^ 0xffffffff) == -3) {
                    i_18_ -= 357;
                    i_17_ -= 17;
                }
                for(int i_19_ = 0; i_19_ < NpcDefinition.anInt2394; i_19_++) {
                    int i_20_ = (15 * (-i_19_ + NpcDefinition.anInt2394 + -1) + i_14_ + 31);
                    int i_21_ = 16777215;
                    if((i_17_ ^ 0xffffffff) < (i ^ 0xffffffff) && i + i_15_ > i_17_ && (i_18_ ^ 0xffffffff) < (-13 + i_20_ ^ 0xffffffff) && (i_20_ + 3 ^ 0xffffffff) < (i_18_ ^ 0xffffffff))
                        i_21_ = 16776960;
                    Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method683(Landscape.aClass1Array1184[i_19_], i + 3, i_20_, i_21_, true);
                }
            }
        } catch(RuntimeException runtimeexception) {
            throw Class8.method216(runtimeexception, "hd.G(" + arg0 + ')');
        }
    }
}
