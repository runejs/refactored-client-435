package com.jagex.runescape;

import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.media.renderable.actor.Player;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Class40_Sub5_Sub6 extends SubNode {
    public static RSString aClass1_2434 = RSString.CreateString(":duelreq:");
    public static Class67[] aClass67Array2436 = new Class67[13];
    public static int anInt2437;
    public static RSString aClass1_2438 = RSString.CreateString("scroll:");
    public static Cache aClass9_2439 = new Cache(64);
    public static RSString aClass1_2440 = RSString.CreateString("Enter name:");
    public static int cameraY;
    public static RSString aClass1_2446 = aClass1_2440;
    public static RSString aClass1_2447 = RSString.CreateString("@yel@*V");
    public static int anInt2451 = 0;
    public static int anInt2452 = 0;
    public static RSString aClass1_2457 = (RSString.CreateString(" steht bereits auf Ihrer Ignorieren)2Liste(Q"));
    public static RSString aClass1_2458 = RSString.CreateString("From");
    public static RSString aClass1_2460 = RSString.CreateString("RuneScape has been updated(Q");
    public static RSString aClass1_2462 = RSString.CreateString("Error connecting to server)3");
    public byte[] aByteArray2441;

    public Class40_Sub5_Sub6(byte[] arg0) {
        aByteArray2441 = arg0;
    }

    public static void method582(boolean arg0) {
        aClass1_2446 = null;
        aClass1_2434 = null;
        aClass1_2447 = null;
        aClass1_2438 = null;
        aClass67Array2436 = null;
        aClass1_2458 = null;
        aClass1_2462 = null;
        aClass9_2439 = null;
        aClass1_2457 = null;
        aClass1_2460 = null;
        aClass1_2440 = null;
        if(arg0 != true)
            method582(false);
    }

    public static boolean drawInterface(int arg0, int arg1, int arg2, byte arg3, int arg4, int arg5, int arg6) {
        if(!Class68.method1043(arg1))
            return false;
        if(arg3 != -5)
            return true;
        return Main.method36(arg5, arg0, arg4, 0, -1, arg2, arg6, 0, (Class59.aWidgetArrayArray1390[arg1]), true);
    }

    public static void putHackCheckPacket(int arg0, int arg1, PacketBuffer arg2) {
        if(arg0 == -12) {
            for(; ; ) {
                Class40_Sub11 class40_sub11 = ((Class40_Sub11) Class54.aClass45_1278.method902((byte) -90));
                if(class40_sub11 == null)
                    break;
                boolean bool = false;
                for(int i = 0; ((class40_sub11.anInt2160 > i)); i++) {
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
                arg2.putPacket(arg1);
                arg2.putByte(0);
                int i = arg2.currentPosition;
                arg2.putIntBE(class40_sub11.anInt2166);
                for(int i_0_ = 0; class40_sub11.anInt2160 > i_0_; i_0_++) {
                    if((class40_sub11.anIntArray2155[i_0_] ^ 0xffffffff) != -1)
                        arg2.putByte(class40_sub11.anIntArray2155[i_0_]);
                    else {
                        try {
                            int i_1_ = class40_sub11.anIntArray2154[i_0_];
                            if(i_1_ == 0) {
                                Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                int i_2_ = field.getInt(null);
                                arg2.putByte(0);
                                arg2.putIntBE(i_2_);
                            } else if((i_1_ ^ 0xffffffff) == -2) {
                                Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                field.setInt(null, (class40_sub11.anIntArray2165[i_0_]));
                                arg2.putByte(0);
                            } else if(i_1_ == 2) {
                                Field field = (Field) (class40_sub11.aClass15Array2157[i_0_].anObject437);
                                int i_3_ = field.getModifiers();
                                arg2.putByte(0);
                                arg2.putIntBE(i_3_);
                            }
                            if((i_1_ ^ 0xffffffff) != -4) {
                                if((i_1_ ^ 0xffffffff) == -5) {
                                    Method method = ((Method) (class40_sub11.aClass15Array2156[i_0_].anObject437));
                                    int i_4_ = method.getModifiers();
                                    arg2.putByte(0);
                                    arg2.putIntBE(i_4_);
                                }
                            } else {
                                Method method = ((Method) (class40_sub11.aClass15Array2156[i_0_].anObject437));
                                byte[][] is = (class40_sub11.aByteArrayArrayArray2159[i_0_]);
                                Object[] objects = new Object[is.length];
                                for(int i_5_ = 0; ((is.length > i_5_)); i_5_++) {
                                    ObjectInputStream objectinputstream = (new ObjectInputStream(new ByteArrayInputStream(is[i_5_])));
                                    objects[i_5_] = objectinputstream.readObject();
                                }
                                Object object = method.invoke(null, objects);
                                if(object == null)
                                    arg2.putByte(0);
                                else if(!(object instanceof Number)) {
                                    if(object instanceof RSString) {
                                        arg2.putByte(2);
                                        arg2.method505((RSString) object);
                                    } else
                                        arg2.putByte(4);
                                } else {
                                    arg2.putByte(1);
                                    arg2.putLongBE(((Number) object).longValue());
                                }
                            }
                        } catch(ClassNotFoundException classnotfoundexception) {
                            arg2.putByte(-10);
                        } catch(java.io.InvalidClassException invalidclassexception) {
                            arg2.putByte(-11);
                        } catch(java.io.StreamCorruptedException streamcorruptedexception) {
                            arg2.putByte(-12);
                        } catch(java.io.OptionalDataException optionaldataexception) {
                            arg2.putByte(-13);
                        } catch(IllegalAccessException illegalaccessexception) {
                            arg2.putByte(-14);
                        } catch(IllegalArgumentException illegalargumentexception) {
                            arg2.putByte(-15);
                        } catch(java.lang.reflect.InvocationTargetException invocationtargetexception) {
                            arg2.putByte(-16);
                        } catch(SecurityException securityexception) {
                            arg2.putByte(-17);
                        } catch(java.io.IOException ioexception) {
                            arg2.putByte(-18);
                        } catch(NullPointerException nullpointerexception) {
                            arg2.putByte(-19);
                        } catch(Exception exception) {
                            arg2.putByte(-20);
                        } catch(Throwable throwable) {
                            arg2.putByte(-21);
                        }
                    }
                }
                arg2.method473(i);
                arg2.finishVarByte(-i + arg2.currentPosition);
                class40_sub11.method457(-1);
            }
        }

    }

    public static int method585(int arg0, int arg1) {
        Class40_Sub5_Sub4 class40_sub5_sub4 = Class34.method417(0, arg0);
        if(arg1 != 1369)
            return 27;
        int i = class40_sub5_sub4.anInt2370;
        int i_6_ = class40_sub5_sub4.anInt2358;
        int i_7_ = class40_sub5_sub4.anInt2368;
        int i_8_ = Class68_Sub1.anIntArray2199[i - i_7_];
        return Class58.varbitmasks[i_6_] >> i_7_ & i_8_;
    }

    public static void method586(int arg0) {
        ISAAC.aClass9_510.method235((byte) 64);
        Class67.aClass9_1611.method235((byte) -105);
        if(arg0 <= 63)
            aClass1_2462 = null;
    }

    public static void method587(int arg0) {
        if(arg0 == 2) {
            while(Class34.method416((byte) -125)) {
                if(Class66.anInt1560 != -1 && (Class66.anInt1548 == Class66.anInt1560)) {
                    if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1550.length() > 0))
                        Class66.aClass1_1550 = (Class66.aClass1_1550.substring(0, -1 + Class66.aClass1_1550.length()));
                    if((Class40_Sub5_Sub15.method735((byte) -37, Class59.anInt1388) || Class59.anInt1388 == 32) && Class66.aClass1_1550.length() < 12)
                        Class66.aClass1_1550 = Class66.aClass1_1550.method70(Class59.anInt1388, 0);
                } else if(!Class19.aBoolean490) {
                    if(Class40_Sub5_Sub15.inputType == 1) {
                        if(((ItemDefinition.anInt2854 ^ 0xffffffff) == -86) && (Class66.inputInputMessage.length() ^ 0xffffffff) < -1) {
                            Class66.inputInputMessage = (Class66.inputInputMessage.substring(0, (Class66.inputInputMessage.length() - 1)));
                            Class52.redrawChatbox = true;
                        }
                        if(Class66.method1027(Class59.anInt1388, -58) && Class66.inputInputMessage.length() < 10) {
                            Class66.inputInputMessage = Class66.inputInputMessage.method70(Class59.anInt1388, 0);
                            Class52.redrawChatbox = true;
                        }
                        if(ItemDefinition.anInt2854 == 84) {
                            if(Class66.inputInputMessage.length() > 0) {
                                int i = 0;
                                if(Class66.inputInputMessage.method82(arg0 + 105))
                                    i = Class66.inputInputMessage.method52();
                                Class32.packetBuffer.putPacket(238);
                                Class32.packetBuffer.putIntBE(i);
                            }
                            Class52.redrawChatbox = true;
                            Class40_Sub5_Sub15.inputType = 0;
                        }
                    } else if(Class40_Sub5_Sub15.inputType != 2) {
                        if(Class40_Sub5_Sub15.inputType == 3) {
                            if(ItemDefinition.anInt2854 == 85 && Class66.inputInputMessage.length() > 0) {
                                Class66.inputInputMessage = (Class66.inputInputMessage.substring(0, Class66.inputInputMessage.length() - 10));
                                Class52.redrawChatbox = true;
                            }
                            if((Player.method793((byte) 122, Class59.anInt1388)) && (Class66.inputInputMessage.length() ^ 0xffffffff) > -41) {
                                Class66.inputInputMessage = Class66.inputInputMessage.method70(Class59.anInt1388, 0);
                                Class52.redrawChatbox = true;
                            }
                        } else if((Class43.openChatboxWidgetId ^ 0xffffffff) == 0 && (ActorDefinition.anInt2433 ^ 0xffffffff) == 0) {
                            if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.chatboxInput.length() > 0)) {
                                Class66.chatboxInput = (Class66.chatboxInput.substring(0, Class66.chatboxInput.length() - 1));
                                Class52.redrawChatbox = true;
                            }
                            if((Player.method793((byte) 124, Class59.anInt1388)) && Class66.chatboxInput.length() < 80) {
                                Class66.chatboxInput = (Class66.chatboxInput.method70(Class59.anInt1388, arg0 + -2));
                                Class52.redrawChatbox = true;
                            }
                            if(ItemDefinition.anInt2854 == 84 && (Class66.chatboxInput.length() > 0)) {
                                if(true) {
                                    if(Class66.chatboxInput.equals(Class58.cmd_clientdrop))
                                        Class59.dropClient(2578);
                                    if(Class66.chatboxInput.equals(Class40_Sub3.cmd_fpson)) {
                                        Class19.showFps = true;
                                        Class40_Sub5_Sub15.inputType = 3;
                                    }
                                    if(Class66.chatboxInput.equals(Class40_Sub11.cmd_fpsoff))
                                        Class19.showFps = false;
                                    if(Class66.chatboxInput.equals(SpotAnimDefinition.cmd_noclip)) {
                                        for(int i = 0; i < 4; i++) {
                                            for(int i_9_ = 1; ((i_9_ ^ 0xffffffff) > -104); i_9_++) {
                                                for(int i_10_ = 1; i_10_ < 103; i_10_++)
                                                    Landscape.aCollisionMapArray1167[i].anIntArrayArray150[i_9_][i_10_] = 0;
                                            }
                                        }
                                    }
                                    if((Class66.chatboxInput.equals(Widget.cmd_errortest)) && (Class44.modewhere ^ 0xffffffff) == -3)
                                        throw new RuntimeException();
                                    if(Class66.chatboxInput.equals(Class4.cmd_hiddenbuttontest))
                                        PacketBuffer.hiddenButtonTest = true;
                                }
                                if(!Class66.chatboxInput.startsWith(Class33.cmd_prefix)) {
                                    int i = 0;
                                    Class40_Sub5_Sub4.anInt2362++;
                                    RSString class1 = Class66.chatboxInput.toLowerCase();
                                    int i_11_ = 0;
                                    if(class1.startsWith((Class40_Sub5_Sub11.aClass1_2620))) {
                                        i_11_ = 0;
                                        Class66.chatboxInput = (Class66.chatboxInput.substring(Class40_Sub5_Sub11.aClass1_2620.length()));
                                    } else if(!class1.startsWith(Class5.aClass1_204)) {
                                        if(!class1.startsWith((Player.aClass1_3256))) {
                                            if(class1.startsWith(Class45.aClass1_1076)) {
                                                i_11_ = 3;
                                                Class66.chatboxInput = (Class66.chatboxInput.substring((Class45.aClass1_1076.length())));
                                            } else if(!class1.startsWith((RSString.aClass1_1717))) {
                                                if(class1.startsWith((Node.aClass1_940))) {
                                                    Class66.chatboxInput = (Class66.chatboxInput.substring((Node.aClass1_940.length())));
                                                    i_11_ = 5;
                                                } else if(!class1.startsWith((Class43.aClass1_1019))) {
                                                    if(!class1.startsWith((UnderlayDefinition.aClass1_2566))) {
                                                        if(!class1.startsWith((Class57.aClass1_1343))) {
                                                            if(class1.startsWith((Landscape.aClass1_1181))) {
                                                                i_11_ = 9;
                                                                Class66.chatboxInput = (Class66.chatboxInput.substring((Landscape.aClass1_1181.length())));
                                                            } else if(!class1.startsWith(Widget.aClass1_2671)) {
                                                                if(class1.startsWith((Class51.aClass1_1196))) {
                                                                    Class66.chatboxInput = Class66.chatboxInput.substring(Class51.aClass1_1196.length());
                                                                    i_11_ = 11;
                                                                }
                                                            } else {
                                                                Class66.chatboxInput = (Class66.chatboxInput.substring(Widget.aClass1_2671.length()));
                                                                i_11_ = 10;
                                                            }
                                                        } else {
                                                            i_11_ = 8;
                                                            Class66.chatboxInput = (Class66.chatboxInput.substring((Class57.aClass1_1343.length())));
                                                        }
                                                    } else {
                                                        i_11_ = 7;
                                                        Class66.chatboxInput = (Class66.chatboxInput.substring((UnderlayDefinition.aClass1_2566.length())));
                                                    }
                                                } else {
                                                    i_11_ = 6;
                                                    Class66.chatboxInput = (Class66.chatboxInput.substring((Class43.aClass1_1019.length())));
                                                }
                                            } else {
                                                i_11_ = 4;
                                                Class66.chatboxInput = (Class66.chatboxInput.substring((RSString.aClass1_1717.length())));
                                            }
                                        } else {
                                            i_11_ = 2;
                                            Class66.chatboxInput = (Class66.chatboxInput.substring(Player.aClass1_3256.length()));
                                        }
                                    } else {
                                        Class66.chatboxInput = (Class66.chatboxInput.substring((Class5.aClass1_204.length())));
                                        i_11_ = 1;
                                    }
                                    class1 = Class66.chatboxInput.toLowerCase();
                                    if(class1.startsWith((VertexNormal.aClass1_1097))) {
                                        i = 1;
                                        Class66.chatboxInput = (Class66.chatboxInput.substring((VertexNormal.aClass1_1097.length())));
                                    } else if(class1.startsWith(GameFrame.aClass1_1474)) {
                                        i = 2;
                                        Class66.chatboxInput = (Class66.chatboxInput.substring(GameFrame.aClass1_1474.length()));
                                    } else if(class1.startsWith(RSCanvas.aClass1_51)) {
                                        Class66.chatboxInput = (Class66.chatboxInput.substring(RSCanvas.aClass1_51.length()));
                                        i = 3;
                                    } else if(!class1.startsWith(aClass1_2438)) {
                                        if(class1.startsWith(Class55.aClass1_1291)) {
                                            i = 5;
                                            Class66.chatboxInput = (Class66.chatboxInput.substring(Class55.aClass1_1291.length()));
                                        }
                                    } else {
                                        i = 4;
                                        Class66.chatboxInput = (Class66.chatboxInput.substring(aClass1_2438.length()));
                                    }
                                    Class32.packetBuffer.putPacket(75);
                                    Class32.packetBuffer.putByte(0);
                                    int i_12_ = (Class32.packetBuffer.currentPosition);
                                    Class32.packetBuffer.putByte(i_11_);
                                    Class32.packetBuffer.putByte(i);
                                    Class68_Sub1.method1052(65, Class66.chatboxInput, Class32.packetBuffer);
                                    Class32.packetBuffer.finishVarByte((Class32.packetBuffer.currentPosition) + -i_12_);
                                    if((Class35.publicChatMode ^ 0xffffffff) == -3) {
                                        Class34.anInt821++;
                                        Cache.aBoolean330 = true;
                                        Class35.publicChatMode = 3;
                                        Class32.packetBuffer.putPacket(32);
                                        Class32.packetBuffer.putByte(Class35.publicChatMode);
                                        Class32.packetBuffer.putByte(Class4.anInt185);
                                        Class32.packetBuffer.putByte(ItemDefinition.anInt2797);
                                    }
                                } else {
                                    Class32.packetBuffer.putPacket(248);
                                    Class32.packetBuffer.putByte(-1 + Class66.chatboxInput.length());
                                    Class32.packetBuffer.method505(Class66.chatboxInput.substring(2));
                                }
                                Class52.redrawChatbox = true;
                                Class66.chatboxInput = Class66.blank_string;
                            }
                        }
                    } else {
                        if(((ItemDefinition.anInt2854 ^ 0xffffffff) == -86) && Class66.inputInputMessage.length() > 0) {
                            Class66.inputInputMessage = (Class66.inputInputMessage.substring(0, -1 + Class66.inputInputMessage.length()));
                            Class52.redrawChatbox = true;
                        }
                        if((Class40_Sub5_Sub15.method735((byte) -37, Class59.anInt1388) || Class59.anInt1388 == 32) && Class66.inputInputMessage.length() < 12) {
                            Class66.inputInputMessage = (Class66.inputInputMessage.method70(Class59.anInt1388, arg0 ^ 0x2));
                            Class52.redrawChatbox = true;
                        }
                        if(ItemDefinition.anInt2854 == 84) {
                            if(Class66.inputInputMessage.length() > 0) {
                                Class32.packetBuffer.putPacket(86);
                                Class32.packetBuffer.putLongBE(Class66.inputInputMessage.method58((byte) 89));
                            }
                            Class40_Sub5_Sub15.inputType = 0;
                            Class52.redrawChatbox = true;
                        }
                    }
                } else {
                    if((ItemDefinition.anInt2854 ^ 0xffffffff) == -86 && (Class66.aClass1_1565.length() > 0)) {
                        Class66.aClass1_1565 = (Class66.aClass1_1565.substring(0, -1 + Class66.aClass1_1565.length()));
                        Class52.redrawChatbox = true;
                    }
                    if(Player.method793((byte) 120, Class59.anInt1388) && (Class66.aClass1_1565.length() ^ 0xffffffff) > -81) {
                        Class66.aClass1_1565 = Class66.aClass1_1565.method70(Class59.anInt1388, arg0 ^ 0x2);
                        Class52.redrawChatbox = true;
                    }
                    if((ItemDefinition.anInt2854 ^ 0xffffffff) == -85) {
                        Class19.aBoolean490 = false;
                        Class52.redrawChatbox = true;
                        if((Class37.anInt876 ^ 0xffffffff) == -2) {
                            long l = Class66.aClass1_1565.method58((byte) 104);
                            UnderlayDefinition.method617(l, (byte) -99);
                        }
                        if((Class37.anInt876 ^ 0xffffffff) == -3 && (Class40_Sub5_Sub17_Sub3.anInt3060 ^ 0xffffffff) < -1) {
                            long l = Class66.aClass1_1565.method58((byte) 121);
                            RSApplet.method28(l, 123);
                        }
                        if((Class37.anInt876 ^ 0xffffffff) == -4 && Class66.aClass1_1565.length() > 0) {
                            Class44.anInt1044++;
                            Class32.packetBuffer.putPacket(207);
                            Class32.packetBuffer.putByte(0);
                            int i = Class32.packetBuffer.currentPosition;
                            Class32.packetBuffer.putLongBE(PacketBuffer.aLong2241);
                            Class68_Sub1.method1052(119, Class66.aClass1_1565, Class32.packetBuffer);
                            Class32.packetBuffer.finishVarByte(-i + (Class32.packetBuffer.currentPosition));
                            if(Class4.anInt185 == 2) {
                                Class4.anInt185 = 1;
                                Cache.aBoolean330 = true;
                                Class34.anInt821++;
                                Class32.packetBuffer.putPacket(32);
                                Class32.packetBuffer.putByte(Class35.publicChatMode);
                                Class32.packetBuffer.putByte(Class4.anInt185);
                                Class32.packetBuffer.putByte(ItemDefinition.anInt2797);
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

    }

    public static void method588(int arg0) {
        if(arg0 == -1) {
            int i = Class19.anInt475;
            int i_13_ = CollisionMap.anInt168;
            int i_14_ = Main.anInt1758;
            int i_15_ = VertexNormal.anInt1086;
            int i_16_ = 6116423;
            Rasterizer.method656(i, i_14_, i_15_, i_13_, i_16_);
            Rasterizer.method656(1 + i, 1 + i_14_, -2 + i_15_, 16, 0);
            Rasterizer.method665(i + 1, 18 + i_14_, -2 + i_15_, -19 + i_13_, 0);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.drawString(Widget.aClass1_2684, i + 3, 14 + i_14_, i_16_);
            int i_17_ = Class13.mouseX;
            int i_18_ = Landscape.mouseY;
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 0) {
                i_17_ -= 4;
                i_18_ -= 4;
            }
            if(Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                i_18_ -= 205;
                i_17_ -= 553;
            }
            if((Class40_Sub5_Sub17_Sub1.menuScreenArea ^ 0xffffffff) == -3) {
                i_18_ -= 357;
                i_17_ -= 17;
            }
            for(int i_19_ = 0; i_19_ < ActorDefinition.anInt2394; i_19_++) {
                int i_20_ = (15 * (-i_19_ + ActorDefinition.anInt2394 + -1) + i_14_ + 31);
                int i_21_ = 16777215;
                if((i_17_ > i) && i + i_15_ > i_17_ && (i_18_ > -13 + i_20_) && (i_20_ + 3 > i_18_))
                    i_21_ = 16776960;
                Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3246.method683(Landscape.aClass1Array1184[i_19_], i + 3, i_20_, i_21_, true);
            }
        }
    }
}
