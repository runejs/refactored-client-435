package com.jagex.runescape;

import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.cs.InvokedScript;
import com.jagex.runescape.cache.cs.ClientScript;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.cache.def.UnderlayDefinition;
import com.jagex.runescape.cache.media.gameInterface.*;
import com.jagex.runescape.node.Node;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.tile.WallDecoration;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;

public class ClientScriptRunner extends Node {
    public static String[] scriptStringValues = new String[1000];
    public static int runEnergy = 0;
    public static CacheArchive aCacheArchive_2162;
    public static int crossX = 0;
    public static String[] localStrings;
    public static int[] localInts;
    public static int[] scriptIntValues = new int[1000];
    public static InvokedScript[] invokedScripts = new InvokedScript[50];
    public static int invokedScriptIndex = 0;

    public int[] opcodes;
    public int[] errorCodes;
    public SignlinkNode[] functionNodes;
    public SignlinkNode[] valueNodes;
    public byte[][][] argumentValues;
    public int scriptCount;
    public int[] values;
    public int scriptId;

    public static String method872(int arg0, int arg1) {
        if(arg0 > arg1)
            return Integer.toString(arg1);
        return Native.aClass1_478;
    }

    public static void method873(int arg1, int arg2) {
        if(arg2 != 45)
            runEnergy = 53;
        int i = 0;
        for(int i_0_ = 0; i_0_ < 100; i_0_++) {
            if(ChatBox.chatMessages[i_0_] != null) {
                int i_1_ = ChatBox.chatTypes[i_0_];
                int i_2_ = 4 + ChatBox.chatboxScroll + -(i * 14) + 70;
                if(i_2_ < -20)
                    break;
                if(i_1_ == 0)
                    i++;
                String class1 = ChatBox.chatPlayerNames[i_0_];
                if(class1 != null && class1.startsWith(Native.whiteCrown))
                    class1 = class1.substring(5);
                if(class1 != null && class1.startsWith(Native.goldCrown))
                    class1 = class1.substring(5);
                if((i_1_ == 1 || i_1_ == 2) && (i_1_ == 1 || ChatBox.publicChatMode == 0 || ChatBox.publicChatMode == 1 && Player.hasFriend(class1))) {
                    if(arg1 > i_2_ - 14 && arg1 <= i_2_ && !class1.equals(Player.localPlayer.playerName)) {
                        if(InteractiveObject.playerRights >= 1) {
                            OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 28, Native.white + class1);
                        }
                        OverlayDefinition.addActionRow(English.addIgnore, 0, 0, 0, 51, Native.white + class1);
                        OverlayDefinition.addActionRow(English.addFriend, 0, 0, 0, 45, Native.white + class1);
                    }
                    i++;
                }
                if((i_1_ == 3 || i_1_ == 7) && CollisionMap.anInt165 == 0 && (i_1_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                    i++;
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        if(InteractiveObject.playerRights >= 1) {
                            OverlayDefinition.addActionRow(English.reportAbuse, 0, 0, 0, 28, Native.white + class1);
                        }
                        OverlayDefinition.addActionRow(English.addIgnore, 0, 0, 0, 51, Native.white + class1);
                        OverlayDefinition.addActionRow(English.addFriend, 0, 0, 0, 45, Native.white + class1);
                    }
                }
                if(i_1_ == 4 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Player.hasFriend(class1))) {
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        OverlayDefinition.addActionRow(English.acceptTrade, 0, 0, 0, 26, Native.white + class1);
                    }
                    i++;
                }
                if((i_1_ == 5 || i_1_ == 6) && CollisionMap.anInt165 == 0 && ChatBox.privateChatMode < 2)
                    i++;
                if(i_1_ == 8 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Player.hasFriend(class1))) {
                    if(i_2_ + -14 < arg1 && arg1 <= i_2_) {
                        OverlayDefinition.addActionRow(English.acceptChallenge, 0, 0, 0, 46, Native.white + class1);
                    }
                    i++;
                }
            }
        }
    }

    // @TODO figure this out - it works entirely different from even 459... Why?
    //  Should we just rip the 459 version as it's most likely better anyhow?
    public static void parseClientScriptPacket(Signlink signlink, Buffer buffer) {
        ClientScriptRunner clientScriptRunner = new ClientScriptRunner();

        clientScriptRunner.scriptCount = buffer.getUnsignedByte();
        clientScriptRunner.scriptId = buffer.getIntBE();

        clientScriptRunner.opcodes = new int[clientScriptRunner.scriptCount];
        clientScriptRunner.valueNodes = new SignlinkNode[clientScriptRunner.scriptCount];
        clientScriptRunner.values = new int[clientScriptRunner.scriptCount];
        clientScriptRunner.argumentValues = new byte[clientScriptRunner.scriptCount][][];
        clientScriptRunner.functionNodes = new SignlinkNode[clientScriptRunner.scriptCount];
        clientScriptRunner.errorCodes = new int[clientScriptRunner.scriptCount];

        // lol wut...
        // I see why this was replaced by 459
        // this must be the CS2 beta since we only have 1 CS2 script in our game cache - and it's a test script :)
        // final version appears to have been changed a good bit - rip the final 459 system maybe?
        for(int i = 0; i < clientScriptRunner.scriptCount; i++) {
            try {
                int opcode = buffer.getUnsignedByte();
                if(opcode == 0 || opcode == 1 || opcode == 2) {
                    int val = 0;
                    String typeString = new String(buffer.getRSString().method80());
                    String valName = new String(buffer.getRSString().method80());
                    if(opcode == 1) {
                        val = buffer.getIntBE();
                    }
                    clientScriptRunner.opcodes[i] = opcode;
                    clientScriptRunner.values[i] = val;
                    clientScriptRunner.valueNodes[i] = signlink.method392(Class26.stringToType(typeString), valName);
                } else if(opcode == 3 || opcode == 4) {
                    String typeString = new String(buffer.getRSString().method80());
                    String functionName = new String(buffer.getRSString().method80());
                    int argCount = buffer.getUnsignedByte();
                    String[] argNames = new String[argCount];
                    for(int j = 0; argCount > j; j++) {
                        argNames[j] = new String(buffer.getRSString().method80());
                    }
                    byte[][] argValueData = new byte[argCount][];
                    if(opcode == 3) {
                        for(int j = 0; j < argCount; j++) {
                            int argValueLength = buffer.getIntBE();
                            argValueData[j] = new byte[argValueLength];
                            buffer.getBytes(argValueLength, 0, argValueData[j]);
                        }
                    }
                    clientScriptRunner.opcodes[i] = opcode;
                    Class[] argTypes = new Class[argCount];
                    for(int j = 0; j < argCount; j++) {
                        argTypes[j] = Class26.stringToType(argNames[j]);
                    }

                    clientScriptRunner.functionNodes[i] = signlink.method386(argTypes, functionName, Class26.stringToType(typeString));
                    clientScriptRunner.argumentValues[i] = argValueData;
                }
            } catch(ClassNotFoundException classnotfoundexception) {
                clientScriptRunner.errorCodes[i] = -1;
            } catch(SecurityException securityexception) {
                clientScriptRunner.errorCodes[i] = -2;
            } catch(NullPointerException nullpointerexception) {
                clientScriptRunner.errorCodes[i] = -3;
            } catch(Exception exception) {
                clientScriptRunner.errorCodes[i] = -4;
            } catch(Throwable throwable) {
                clientScriptRunner.errorCodes[i] = -5;
            }
        }

        KeyFocusListener.aLinkedList_1278.pushBack(clientScriptRunner, 92);
    }

    public static void createClientScriptCheckPacket(int packetId, PacketBuffer buffer) {
        for(; ; ) {
            ClientScriptRunner clientScriptRunner = (ClientScriptRunner) KeyFocusListener.aLinkedList_1278.method902((byte) -90);
            if(clientScriptRunner == null) {
                break;
            }

            boolean bool = false;

            for(int i = 0; clientScriptRunner.scriptCount > i; i++) {
                if(clientScriptRunner.valueNodes[i] != null) {
                    if(clientScriptRunner.valueNodes[i].anInt434 == 2)
                        clientScriptRunner.errorCodes[i] = -5;
                    if(clientScriptRunner.valueNodes[i].anInt434 == 0)
                        bool = true;
                }
                if(clientScriptRunner.functionNodes[i] != null) {
                    if(clientScriptRunner.functionNodes[i].anInt434 == 2)
                        clientScriptRunner.errorCodes[i] = -6;
                    if(clientScriptRunner.functionNodes[i].anInt434 == 0)
                        bool = true;
                }
            }

            if(bool) {
                break;
            }

            buffer.putPacket(packetId);
            buffer.putByte(0);
            int bufferPos = buffer.currentPosition;
            buffer.putIntBE(clientScriptRunner.scriptId);

            for(int i = 0; clientScriptRunner.scriptCount > i; i++) {
                if(clientScriptRunner.errorCodes[i] == 0) {
                    try {
                        int opcode = clientScriptRunner.opcodes[i];

                        if(opcode == 0) {
                            Field field = (Field) clientScriptRunner.valueNodes[i].value;
                            int fieldValue = field.getInt(null);
                            buffer.putByte(0);
                            buffer.putIntBE(fieldValue);
                        } else if(opcode == 1) {
                            Field field = (Field) clientScriptRunner.valueNodes[i].value;
                            field.setInt(null, clientScriptRunner.values[i]);
                            buffer.putByte(0);
                        } else if(opcode == 2) {
                            Field field = (Field) clientScriptRunner.valueNodes[i].value;
                            int fieldModifiers = field.getModifiers();
                            buffer.putByte(0);
                            buffer.putIntBE(fieldModifiers);
                        } else if(opcode == 3) {
                            Method method = (Method) clientScriptRunner.functionNodes[i].value;
                            byte[][] argumentValueData = clientScriptRunner.argumentValues[i];
                            Object[] objects = new Object[argumentValueData.length];
                            for(int valueIndex = 0; argumentValueData.length > valueIndex; valueIndex++) {
                                ObjectInputStream objectinputstream = new ObjectInputStream(new ByteArrayInputStream(argumentValueData[valueIndex]));
                                objects[valueIndex] = objectinputstream.readObject();
                            }
                            Object object = method.invoke(null, objects);
                            if(object == null)
                                buffer.putByte(0);
                            else if(object instanceof Number) {
                                buffer.putByte(1);
                                buffer.putLongBE(((Number) object).longValue());
                            } else if(object instanceof RSString) {
                                buffer.putByte(2);
                                buffer.method505((RSString) object);
                            } else
                                buffer.putByte(4);
                        } else if(opcode == 4) {
                            Method method = (Method) clientScriptRunner.functionNodes[i].value;
                            int methodModifiers = method.getModifiers();
                            buffer.putByte(0);
                            buffer.putIntBE(methodModifiers);
                        }
                    } catch(ClassNotFoundException classnotfoundexception) {
                        buffer.putByte(-10);
                    } catch(java.io.InvalidClassException invalidclassexception) {
                        buffer.putByte(-11);
                    } catch(java.io.StreamCorruptedException streamcorruptedexception) {
                        buffer.putByte(-12);
                    } catch(java.io.OptionalDataException optionaldataexception) {
                        buffer.putByte(-13);
                    } catch(IllegalAccessException illegalaccessexception) {
                        buffer.putByte(-14);
                    } catch(IllegalArgumentException illegalargumentexception) {
                        buffer.putByte(-15);
                    } catch(java.lang.reflect.InvocationTargetException invocationtargetexception) {
                        buffer.putByte(-16);
                    } catch(SecurityException securityexception) {
                        buffer.putByte(-17);
                    } catch(java.io.IOException ioexception) {
                        buffer.putByte(-18);
                    } catch(NullPointerException nullpointerexception) {
                        buffer.putByte(-19);
                    } catch(Exception exception) {
                        buffer.putByte(-20);
                    } catch(Throwable throwable) {
                        buffer.putByte(-21);
                    }
                } else {
                    buffer.putByte(clientScriptRunner.errorCodes[i]);
                }
            }

            buffer.method473(bufferPos);
            buffer.finishVarByte(-bufferPos + buffer.currentPosition);
            clientScriptRunner.remove();
        }
    }

    public static void runClientScripts(Object[] listeners, int arg1, int arg2, GameInterface gameInterface1, int arg4) {
        ClientScript clientScript = ClientScript.decodeClientScript(((Integer) listeners[0]).intValue(), 76);
        int[] intOperands = clientScript.intOperands;
        int[] scriptOpcodes = clientScript.opcodes;
        int intValueIndex = 0;
        int stringValueIndex = 0;
        int scriptIndex = -1;
        int scriptOpcode;

        try {
            localInts = new int[clientScript.localIntCount];
            localStrings = new String[clientScript.localStringCount];
            int localIntIndex = 0;
            int localStringIndex = 0;

            for(int listenerIndex = 1; listenerIndex < listeners.length; listenerIndex++) {
                if(listeners[listenerIndex] instanceof Integer) {
                    int intValue = ((Integer) listeners[listenerIndex]).intValue();
                    if(intValue == -2147483647) { // 0
                        intValue = arg4;
                    }
                    if(intValue == -2147483646) { // 1
                        intValue = arg2;
                    }
                    if(intValue == -2147483645) { // 2
                        intValue = gameInterface1.id;
                    }
                    if(intValue == -2147483644) { // 3
                        intValue = arg1;
                    }
                    localInts[localIntIndex++] = intValue;
                } else if(listeners[listenerIndex] instanceof String) {
                    localStrings[localStringIndex++] = (String) listeners[listenerIndex];
                }
            }

            for(; ; ) {
                scriptOpcode = scriptOpcodes[++scriptIndex];
                if(scriptOpcode < 100) {
                    if(scriptOpcode == 0) {
                        scriptIntValues[intValueIndex++] = intOperands[scriptIndex];
                        continue;
                    }
                    if(scriptOpcode == 1) {
                        int operand = intOperands[scriptIndex];
                        scriptIntValues[intValueIndex++] = GroundItemTile.varbitMasks[operand];
                        continue;
                    }
                    if(scriptOpcode == 2) {
                        int operand = intOperands[scriptIndex];
                        GroundItemTile.varbitMasks[operand] = scriptIntValues[--intValueIndex];
                        continue;
                    }
                    if(scriptOpcode == 3) {
                        scriptStringValues[stringValueIndex++] = clientScript.stringOperands[scriptIndex];
                        continue;
                    }
                    if(scriptOpcode == 6) {
                        scriptIndex += intOperands[scriptIndex];
                        continue;
                    }
                    if(scriptOpcode == 7) {
                        intValueIndex -= 2;
                        if(scriptIntValues[intValueIndex] != scriptIntValues[1 + intValueIndex]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 8) {
                        intValueIndex -= 2;
                        if(scriptIntValues[intValueIndex] == scriptIntValues[1 + intValueIndex]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 9) {
                        intValueIndex -= 2;
                        if(scriptIntValues[1 + intValueIndex] > scriptIntValues[intValueIndex]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 10) {
                        intValueIndex -= 2;
                        if(scriptIntValues[1 + intValueIndex] < scriptIntValues[intValueIndex]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 21) {
                        if(invokedScriptIndex != 0) {
                            InvokedScript invokedScript = invokedScripts[--invokedScriptIndex];
                            localStrings = invokedScript.localStrings;
                            localInts = invokedScript.localInts;
                            scriptIndex = invokedScript.scriptIndex;
                            clientScript = invokedScript.script;
                            intOperands = clientScript.intOperands;
                            scriptOpcodes = clientScript.opcodes;
                            continue;
                        }
                        break;
                    }
                    if(scriptOpcode == 25) {
                        int operand = intOperands[scriptIndex];
                        scriptIntValues[intValueIndex++] = Class40_Sub5_Sub6.method585(operand, 1369);
                        continue;
                    }
                    if(scriptOpcode == 27) {
                        int operand = intOperands[scriptIndex];
                        MovedStatics.method522(scriptIntValues[--intValueIndex], operand);
                        continue;
                    }
                    if(scriptOpcode == 31) {
                        intValueIndex -= 2;
                        if(scriptIntValues[intValueIndex] <= scriptIntValues[intValueIndex + 1]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 32) {
                        intValueIndex -= 2;
                        if(scriptIntValues[1 + intValueIndex] <= scriptIntValues[intValueIndex]) {
                            scriptIndex += intOperands[scriptIndex];
                        }
                        continue;
                    }
                    if(scriptOpcode == 33) {
                        scriptIntValues[intValueIndex++] = localInts[intOperands[scriptIndex]];
                        continue;
                    }
                    if(scriptOpcode == 34) {
                        localInts[intOperands[scriptIndex]] = scriptIntValues[--intValueIndex];
                        continue;
                    }
                    if(scriptOpcode == 35) {
                        scriptStringValues[stringValueIndex++] = localStrings[intOperands[scriptIndex]];
                        continue;
                    }
                    if(scriptOpcode == 36) {
                        localStrings[intOperands[scriptIndex]] = scriptStringValues[--stringValueIndex];
                        continue;
                    }
                    if(scriptOpcode == 37) {
                        int operand = intOperands[scriptIndex];
                        stringValueIndex -= operand;
                        System.out.println("THIS DOES SOMETHING, GO FIX!");
                        // TODO: Figure out what this actually does
//                        RSString class1 = (RSString.method627(operand, stringValueIndex, Class40_Sub11.aClass1Array2153));
//                        Class40_Sub11.aClass1Array2153[stringValueIndex++] = class1;
                        continue;
                    }
                    if(scriptOpcode == 38) {
                        intValueIndex--;
                        continue;
                    }
                    if(scriptOpcode == 39) {
                        stringValueIndex--;
                        continue;
                    }
                    if(scriptOpcode == 40) {
                        int operand = intOperands[scriptIndex];
                        ClientScript invokeScript = ClientScript.decodeClientScript(operand, 73);
                        int[] invokeScriptInts = new int[invokeScript.localIntCount];
                        String[] invokeScriptStrings = new String[invokeScript.localStringCount];
                        for(int intIndex = 0; invokeScript.intStackCount > intIndex; intIndex++) {
                            invokeScriptInts[intIndex] = scriptIntValues[intValueIndex - (invokeScript.intStackCount + -intIndex)];
                        }
                        for(int strIndex = 0; invokeScript.stringStackCount > strIndex; strIndex++) {
                            invokeScriptStrings[strIndex] = scriptStringValues[stringValueIndex - invokeScript.stringStackCount + strIndex];
                        }
                        stringValueIndex -= invokeScript.stringStackCount;
                        intValueIndex -= invokeScript.intStackCount;
                        InvokedScript invokedScript = new InvokedScript();
                        invokedScript.localStrings = localStrings;
                        invokedScript.script = clientScript;
                        invokedScript.localInts = localInts;
                        clientScript = invokeScript;
                        invokedScript.scriptIndex = scriptIndex;
                        invokedScripts[invokedScriptIndex++] = invokedScript;
                        intOperands = clientScript.intOperands;
                        localStrings = invokeScriptStrings;
                        scriptIndex = -1;
                        localInts = invokeScriptInts;
                        scriptOpcodes = clientScript.opcodes;
                        continue;
                    }
                    if(scriptOpcode == 42) {
                        scriptIntValues[intValueIndex++] = Class22_Sub1.anIntArray1847[intOperands[scriptIndex]];
                        continue;
                    }
                    if(scriptOpcode == 43) {
                        Class22_Sub1.anIntArray1847[intOperands[scriptIndex]] = scriptIntValues[--intValueIndex];
                        continue;
                    }
                }

                boolean bool = intOperands[scriptIndex] == 1;
                if(scriptOpcode < 1000) {
                    if(scriptOpcode == 100) { // create interface
                        intValueIndex -= 3;
                        int interfaceData = scriptIntValues[intValueIndex];
                        int interfaceType = scriptIntValues[intValueIndex + 1];
                        int childCount = scriptIntValues[intValueIndex + 2];
                        GameInterface gameInterface = GameInterface.getInterface(interfaceData);
                        if(gameInterface.children == null) {
                            gameInterface.children = new GameInterface[1 + childCount];
                        }
                        if(gameInterface.children.length <= childCount) {
                            GameInterface[] childInterfaces = new GameInterface[1 + childCount];
                            for(int childId = 0; gameInterface.children.length > childId; childId++) {
                                childInterfaces[childId] = gameInterface.children[childId];
                            }
                            gameInterface.children = childInterfaces;
                        }
                        GameInterface childInterface = new GameInterface();
                        childInterface.parentId = gameInterface.id;
                        childInterface.type = GameInterfaceType.get(interfaceType);
                        childInterface.id = ((0xffff & gameInterface.id) << 15) + -2147483648 + childCount;
                        gameInterface.children[childCount] = childInterface;
                        if(bool) {
                            MovedStatics.aGameInterface_2116 = childInterface;
                        } else {
                            Class22_Sub2.aGameInterface_1887 = childInterface;
                        }
                    } else if(scriptOpcode == 101) {
                        GameInterface gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : MovedStatics.aGameInterface_2116;
                        GameInterface childInterface = GameInterface.getInterface(gameInterface.parentId);
                        childInterface.children[HuffmanEncoding.method1021(gameInterface.id, 32767)] = null;
                    } else {
                        if(scriptOpcode != 102) {
                            break;
                        }
                        GameInterface gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                        gameInterface.children = null;
                    }
                } else if(scriptOpcode >= 1000 && scriptOpcode < 1100 || scriptOpcode >= 2000 && scriptOpcode < 2100) {
                    GameInterface gameInterface;
                    if(scriptOpcode >= 2000) {
                        gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                        scriptOpcode -= 1000;
                    } else {
                        gameInterface = bool ? MovedStatics.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                    }
                    if(scriptOpcode == 1000) {
                        intValueIndex -= 2;
                        gameInterface.currentX = scriptIntValues[intValueIndex];
                        gameInterface.currentY = scriptIntValues[intValueIndex + 1];
                    } else if(scriptOpcode == 1001) {
                        intValueIndex -= 2;
                        gameInterface.originalWidth = scriptIntValues[intValueIndex];
                        gameInterface.originalHeight = scriptIntValues[1 + intValueIndex];
                    } else if(scriptOpcode == 1003) {
                        gameInterface.isHidden = scriptIntValues[--intValueIndex] == 1;
                    } else {
                        if(scriptOpcode != 1004) {
                            break;
                        }
                        gameInterface.hasListeners = scriptIntValues[--intValueIndex] == 1;
                    }
                } else if(scriptOpcode >= 1100 && scriptOpcode < 1200 || scriptOpcode >= 2100 && scriptOpcode < 2200) {
                    GameInterface gameInterface;
                    if(scriptOpcode < 2000) {
                        gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : MovedStatics.aGameInterface_2116;
                    } else {
                        gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                        scriptOpcode -= 1000;
                    }
                    if(scriptOpcode == 1100) {
                        intValueIndex -= 2;
                        gameInterface.scrollWidth = scriptIntValues[intValueIndex];
                        gameInterface.scrollPosition = scriptIntValues[1 + intValueIndex];
                    } else if(scriptOpcode == 1101) {
                        int i_24_ = scriptIntValues[--intValueIndex];
                        int i_25_ = (0x7e0b & i_24_) >> 10;
                        int i_26_ = i_24_ & 0x1f;
                        int i_27_ = i_24_ >> 5 & 0x1f;
                        gameInterface.textColor = (i_27_ << 11) + (i_25_ << 19) + (i_26_ << 3);
                    } else if(scriptOpcode == 1102) {
                        gameInterface.filled = scriptIntValues[--intValueIndex] == 1;
                    } else if(scriptOpcode == 1103) {
                        gameInterface.opacity = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1104) {
                        intValueIndex--;
                    } else if(scriptOpcode == 1105) {
                        gameInterface.spriteId = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1106) {
                        gameInterface.textureId = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1107) {
                        gameInterface.tiled = scriptIntValues[--intValueIndex] == 1;
                    } else if(scriptOpcode == 1108) {
                        gameInterface.modelType = InterfaceModelType.MODEL;
                        gameInterface.modelId = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1109) {
                        intValueIndex -= 6;
                        gameInterface.offsetX2d = scriptIntValues[intValueIndex];
                        gameInterface.offsetY2d = scriptIntValues[1 + intValueIndex];
                        gameInterface.rotationX = scriptIntValues[intValueIndex + 2];
                        gameInterface.rotationZ = scriptIntValues[3 + intValueIndex];
                        gameInterface.rotationY = scriptIntValues[4 + intValueIndex];
                        gameInterface.modelZoom = scriptIntValues[5 + intValueIndex];
                    } else if(scriptOpcode == 1110) {
                        gameInterface.animation = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1111) {
                        gameInterface.orthogonal = scriptIntValues[--intValueIndex] == 1;
                    } else if(scriptOpcode == 1112) {
                        gameInterface.disabledText = scriptStringValues[--stringValueIndex];
                    } else if(scriptOpcode == 1113) {
                        gameInterface.fontId = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1114) {
                        intValueIndex -= 3;
                        gameInterface.xTextAlignment = scriptIntValues[intValueIndex];
                        gameInterface.yTextAlignment = scriptIntValues[intValueIndex + 1];
                        gameInterface.lineHeight = scriptIntValues[intValueIndex + 2];
                    } else {
                        if(scriptOpcode != 1115) {
                            break;
                        }
                        gameInterface.textShadowed = scriptIntValues[--intValueIndex] == 1;
                    }
                } else if((scriptOpcode < 1200 || scriptOpcode >= 1300) && (scriptOpcode < 2200 || scriptOpcode >= 2300)) {
                    if((scriptOpcode < 1300 || scriptOpcode >= 1400) && (scriptOpcode < 2300 || scriptOpcode >= 2400)) {
                        if(scriptOpcode < 1500) {
                            if(scriptOpcode == 1400) {
                                intValueIndex -= 2;
                                int i_28_ = scriptIntValues[intValueIndex + 1];
                                int i_29_ = scriptIntValues[intValueIndex];
                                GameInterface gameInterface = GameInterface.getInterface(i_29_);
                                if(gameInterface.children == null || gameInterface.children.length <= i_28_ || gameInterface.children[i_28_] == null) {
                                    scriptIntValues[intValueIndex++] = 0;
                                } else {
                                    scriptIntValues[intValueIndex++] = 1;
                                    if(bool) {
                                        MovedStatics.aGameInterface_2116 = gameInterface.children[i_28_];
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface.children[i_28_];
                                    }
                                }
                            } else if(scriptOpcode == 1401) {
                                intValueIndex -= 3;
                                int i_30_ = scriptIntValues[intValueIndex];
                                int i_31_ = scriptIntValues[2 + intValueIndex];
                                int i_32_ = scriptIntValues[intValueIndex + 1];
                                GameInterface gameInterface = GameInterface.method361(GameInterface.cachedInterfaces[i_30_], i_31_, true, 0, -1, 0, i_32_, 398);
                                if(gameInterface == null) {
                                    scriptIntValues[intValueIndex++] = 0;
                                } else {
                                    scriptIntValues[intValueIndex++] = 1;
                                    if(bool) {
                                        MovedStatics.aGameInterface_2116 = gameInterface;
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface;
                                    }
                                }
                            } else {
                                if(scriptOpcode != 1402) {
                                    break;
                                }
                                intValueIndex -= 3;
                                GameInterface gameInterface = GameInterface.getInterface(scriptIntValues[intValueIndex]);
                                int i_33_ = scriptIntValues[2 + intValueIndex];
                                int i_34_ = scriptIntValues[intValueIndex + 1];
                                GameInterface gameInterface_35_ = GameInterface.method361(gameInterface.children, i_33_, true, gameInterface.scrollPosition, gameInterface.id, gameInterface.scrollWidth, i_34_, 398);
                                if(gameInterface_35_ == null) {
                                    scriptIntValues[intValueIndex++] = 0;
                                } else {
                                    scriptIntValues[intValueIndex++] = 1;
                                    if(bool) {
                                        MovedStatics.aGameInterface_2116 = gameInterface_35_;
                                    } else {
                                        Class22_Sub2.aGameInterface_1887 = gameInterface_35_;
                                    }
                                }
                            }
                        } else if(scriptOpcode < 1600) {
                            GameInterface gameInterface = bool ? MovedStatics.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                            if(scriptOpcode == 1500) {
                                scriptIntValues[intValueIndex++] = gameInterface.currentX;
                            } else if(scriptOpcode == 1501) {
                                scriptIntValues[intValueIndex++] = gameInterface.currentY;
                            } else if(scriptOpcode == 1502) {
                                scriptIntValues[intValueIndex++] = gameInterface.originalWidth;
                            } else if(scriptOpcode == 1503) {
                                scriptIntValues[intValueIndex++] = gameInterface.originalHeight;
                            } else if(scriptOpcode == 1504) {
                                scriptIntValues[intValueIndex++] = !gameInterface.isHidden ? 0 : 1;
                            } else {
                                if(scriptOpcode != 1505) {
                                    break;
                                }
                                scriptIntValues[intValueIndex++] = gameInterface.parentId;
                            }
                        } else if(scriptOpcode >= 1700) {
                            if(scriptOpcode < 2500) {
                                if(scriptOpcode == 2401) {
                                    intValueIndex -= 3;
                                    int i_36_ = scriptIntValues[1 + intValueIndex];
                                    int i_37_ = scriptIntValues[intValueIndex];
                                    int i_38_ = scriptIntValues[intValueIndex + 2];
                                    GameInterface gameInterface = GameInterface.method361(GameInterface.cachedInterfaces[i_37_], i_38_, false, 0, -1, 0, i_36_, 398);
                                    if(gameInterface == null) {
                                        scriptIntValues[intValueIndex++] = -1;
                                    } else {
                                        scriptIntValues[intValueIndex++] = gameInterface.id;
                                    }
                                } else {
                                    if(scriptOpcode != 2402) {
                                        break;
                                    }
                                    intValueIndex -= 3;
                                    GameInterface gameInterface = GameInterface.getInterface(scriptIntValues[intValueIndex]);
                                    int i_39_ = scriptIntValues[1 + intValueIndex];
                                    int i_40_ = scriptIntValues[intValueIndex + 2];
                                    GameInterface gameInterface_41_ = GameInterface.method361(GameInterface.cachedInterfaces[gameInterface.id >> 16], i_40_, false, gameInterface.scrollPosition, 0xffff & gameInterface.id, gameInterface.scrollWidth, i_39_, 398);
                                    if(gameInterface_41_ == null) {
                                        scriptIntValues[intValueIndex++] = -1;
                                    } else {
                                        scriptIntValues[intValueIndex++] = gameInterface_41_.id;
                                    }
                                }
                            } else if(scriptOpcode >= 2600) {
                                if(scriptOpcode < 2700) {
                                    GameInterface gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                                    if(scriptOpcode == 2600) {
                                        scriptIntValues[intValueIndex++] = gameInterface.scrollWidth;
                                    } else {
                                        if(scriptOpcode != 2601) {
                                            break;
                                        }
                                        scriptIntValues[intValueIndex++] = gameInterface.scrollPosition;
                                    }
                                } else {
                                    if(scriptOpcode < 2800) {
                                        break;
                                    }
                                    if(scriptOpcode < 3100) {
                                        if(scriptOpcode == 3000) {
                                            int i_42_ = scriptIntValues[--intValueIndex];
                                            if(MovedStatics.lastContinueTextWidgetId == -1) {
                                                PacketBuffer.method517(0, i_42_);
                                                MovedStatics.lastContinueTextWidgetId = i_42_;
                                            }
                                        } else if(scriptOpcode == 3001 || scriptOpcode == 3003) {
                                            intValueIndex -= 2;
                                            int i_43_ = scriptIntValues[intValueIndex];
                                            int i_44_ = scriptIntValues[intValueIndex + 1];
                                            Class33.method406(0, i_44_, i_43_, -128);
                                        } else if(scriptOpcode == 3002) {
                                            GameInterface gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : MovedStatics.aGameInterface_2116;
                                            if(MovedStatics.lastContinueTextWidgetId == -1) {
                                                PacketBuffer.method517(gameInterface.id & 0x7fff, gameInterface.parentId);
                                                MovedStatics.lastContinueTextWidgetId = gameInterface.id;
                                            }
                                        } else {
                                            if(scriptOpcode != 3003) {
                                                break;
                                            }
                                            GameInterface gameInterface = bool ? MovedStatics.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                                            int i_45_ = scriptIntValues[--intValueIndex];
                                            Class33.method406(0x7fff & gameInterface.id, i_45_, gameInterface.parentId, -121);
                                        }
                                    } else if(scriptOpcode >= 3200) {
                                        if(scriptOpcode < 3300) {
                                            if(scriptOpcode == 3200) {
                                                intValueIndex -= 3;
                                                WallDecoration.method950(scriptIntValues[intValueIndex], scriptIntValues[intValueIndex + 1], scriptIntValues[2 + intValueIndex]);
                                            } else if(scriptOpcode == 3201) {
                                                Class51.method942(scriptIntValues[--intValueIndex]);
                                            } else {
                                                if(scriptOpcode != 3202) {
                                                    break;
                                                }
                                                intValueIndex -= 2;
                                                Class57.method975(scriptIntValues[intValueIndex + 1], scriptIntValues[intValueIndex]);
                                            }
                                        } else if(scriptOpcode < 3400) {
                                            if(scriptOpcode != 3300) {
                                                break;
                                            }
                                            scriptIntValues[intValueIndex++] = MovedStatics.pulseCycle;
                                        } else if(scriptOpcode < 4100) {
                                            if(scriptOpcode == 4000) {
                                                intValueIndex -= 2;
                                                int i_46_ = scriptIntValues[intValueIndex];
                                                int i_47_ = scriptIntValues[intValueIndex + 1];
                                                scriptIntValues[intValueIndex++] = i_46_ + i_47_;
                                            } else if(scriptOpcode == 4001) {
                                                intValueIndex -= 2;
                                                int i_48_ = scriptIntValues[1 + intValueIndex];
                                                int i_49_ = scriptIntValues[intValueIndex];
                                                scriptIntValues[intValueIndex++] = i_49_ + -i_48_;
                                            } else if(scriptOpcode == 4002) {
                                                intValueIndex -= 2;
                                                int i_50_ = scriptIntValues[intValueIndex + 1];
                                                int i_51_ = scriptIntValues[intValueIndex];
                                                scriptIntValues[intValueIndex++] = i_51_ * i_50_;
                                            } else if(scriptOpcode == 4003) {
                                                intValueIndex -= 2;
                                                int i_52_ = scriptIntValues[intValueIndex];
                                                int i_53_ = scriptIntValues[intValueIndex + 1];
                                                scriptIntValues[intValueIndex++] = i_52_ / i_53_;
                                            } else if(scriptOpcode == 4004) {
                                                int i_54_ = scriptIntValues[--intValueIndex];
                                                scriptIntValues[intValueIndex++] = (int) (Math.random() * (double) i_54_);
                                            } else if(scriptOpcode == 4005) {
                                                int i_55_ = scriptIntValues[--intValueIndex];
                                                scriptIntValues[intValueIndex++] = (int) ((double) (1 + i_55_) * Math.random());
                                            } else if(scriptOpcode == 4006) {
                                                intValueIndex -= 5;
                                                int i_56_ = scriptIntValues[1 + intValueIndex];
                                                int i_57_ = scriptIntValues[intValueIndex];
                                                int i_58_ = scriptIntValues[intValueIndex + 3];
                                                int i_59_ = scriptIntValues[intValueIndex + 4];
                                                int i_60_ = scriptIntValues[2 + intValueIndex];
                                                scriptIntValues[intValueIndex++] = i_57_ + (i_59_ + -i_60_) * (-i_57_ + i_56_) / (i_58_ - i_60_);
                                            } else if(scriptOpcode == 4007) {
                                                intValueIndex -= 2;
                                                int i_61_ = scriptIntValues[intValueIndex];
                                                int i_62_ = scriptIntValues[intValueIndex + 1];
                                                scriptIntValues[intValueIndex++] = i_61_ + i_62_ * i_61_ / 100;
                                            } else if(scriptOpcode == 4008) {
                                                intValueIndex -= 2;
                                                int i_63_ = scriptIntValues[intValueIndex];
                                                int i_64_ = scriptIntValues[intValueIndex + 1];
                                                scriptIntValues[intValueIndex++] = UnderlayDefinition.bitWiseOR(1 << i_64_, i_63_);
                                            } else if(scriptOpcode == 4009) {
                                                intValueIndex -= 2;
                                                int i_65_ = scriptIntValues[intValueIndex];
                                                int i_66_ = scriptIntValues[1 + intValueIndex];
                                                scriptIntValues[intValueIndex++] = HuffmanEncoding.method1021(i_65_, -1 + -(1 << i_66_));
                                            } else if(scriptOpcode == 4010) {
                                                intValueIndex -= 2;
                                                int i_67_ = scriptIntValues[intValueIndex];
                                                int i_68_ = scriptIntValues[1 + intValueIndex];
                                                scriptIntValues[intValueIndex++] = HuffmanEncoding.method1021(1 << i_68_, i_67_) != 0 ? 1 : 0;
                                            } else if(scriptOpcode == 4011) {
                                                intValueIndex -= 2;
                                                int i_69_ = scriptIntValues[intValueIndex + 1];
                                                int i_70_ = scriptIntValues[intValueIndex];
                                                scriptIntValues[intValueIndex++] = i_70_ % i_69_;
                                            } else if(scriptOpcode == 4012) {
                                                intValueIndex -= 2;
                                                int i_71_ = scriptIntValues[intValueIndex];
                                                int i_72_ = scriptIntValues[intValueIndex + 1];
                                                if(i_71_ == 0) {
                                                    scriptIntValues[intValueIndex++] = 0;
                                                } else {
                                                    scriptIntValues[intValueIndex++] = (int) Math.pow((double) i_71_, (double) i_72_);
                                                }
                                            } else {
                                                if(scriptOpcode != 4013) {
                                                    break;
                                                }
                                                intValueIndex -= 2;
                                                int i_73_ = scriptIntValues[intValueIndex];
                                                int i_74_ = scriptIntValues[1 + intValueIndex];
                                                if(i_73_ == 0) {
                                                    scriptIntValues[intValueIndex++] = 0;
                                                } else if(i_74_ == 0) {
                                                    scriptIntValues[intValueIndex++] = Integer.MAX_VALUE;
                                                } else {
                                                    scriptIntValues[intValueIndex++] = (int) Math.pow((double) i_73_, 1.0 / (double) i_74_);
                                                }
                                            }
                                        } else {
                                            if(scriptOpcode >= 4200) {
                                                break;
                                            }
                                            if(scriptOpcode == 4100) {
                                                String class1 = scriptStringValues[--stringValueIndex];
                                                int i_75_ = scriptIntValues[--intValueIndex];
                                                scriptStringValues[stringValueIndex++] = class1 + i_75_;
                                            } else if(scriptOpcode == 4101) {
                                                stringValueIndex -= 2;
                                                String class1 = scriptStringValues[stringValueIndex + 1];
                                                String class1_76_ = scriptStringValues[stringValueIndex];
                                                scriptStringValues[stringValueIndex++] = class1_76_ + class1;
                                            } else if(scriptOpcode == 4102) {
                                                String class1 = scriptStringValues[--stringValueIndex];
                                                int i_77_ = scriptIntValues[--intValueIndex];
                                                scriptStringValues[stringValueIndex++] = class1 + HuffmanEncoding.method1024(true, (byte) -85, i_77_);
                                            } else if(scriptOpcode == 4103) {
                                                String class1 = scriptStringValues[--stringValueIndex];
                                                scriptStringValues[stringValueIndex++] = class1.toLowerCase();
                                            } else if(scriptOpcode == 4104) {
                                                int i_78_ = scriptIntValues[--intValueIndex];
                                                long l = 86400000L * ((long) i_78_ + 11745L);
                                                Class8.aCalendar279.setTime(new Date(l));
                                                int i_79_ = Class8.aCalendar279.get(Calendar.DATE);
                                                int i_80_ = Class8.aCalendar279.get(Calendar.MONTH);
                                                int i_81_ = Class8.aCalendar279.get(Calendar.YEAR);
                                                scriptStringValues[stringValueIndex++] = i_79_ + "-" + Class40_Sub5_Sub17_Sub1.aClass1Array2964[i_80_] + "-" + i_81_;
                                            } else if(scriptOpcode == 4105) {
                                                stringValueIndex -= 2;
                                                String class1 = scriptStringValues[stringValueIndex];
                                                String class1_82_ = scriptStringValues[stringValueIndex + 1];
                                                if(Player.localPlayer.playerAppearance == null || !Player.localPlayer.playerAppearance.gender) {
                                                    scriptStringValues[stringValueIndex++] = class1;
                                                } else {
                                                    scriptStringValues[stringValueIndex++] = class1_82_;
                                                }
                                            } else if(scriptOpcode == 4106) {
                                                int i_83_ = scriptIntValues[--intValueIndex];
                                                scriptStringValues[stringValueIndex++] = Integer.toString(i_83_).toString();
                                            } else {
                                                if(scriptOpcode != 4107) {
                                                    break;
                                                }
                                                stringValueIndex -= 2;
                                                scriptIntValues[intValueIndex++] = scriptStringValues[stringValueIndex].compareTo(scriptStringValues[stringValueIndex + 1]);
                                            }
                                        }
                                    } else if(scriptOpcode == 3100) {
                                        String str = scriptStringValues[--stringValueIndex];
                                        ChatBox.addChatMessage("", str, 0);
                                    } else {
                                        if(scriptOpcode != 3101) {
                                            break;
                                        }
                                        intValueIndex -= 2;
                                        ActorDefinition.playAnimation(scriptIntValues[intValueIndex], scriptIntValues[intValueIndex + 1], Player.localPlayer);
                                    }
                                }
                            } else {
                                GameInterface gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                                if(scriptOpcode == 2500) {
                                    scriptIntValues[intValueIndex++] = gameInterface.currentX;
                                } else if(scriptOpcode == 2501) {
                                    scriptIntValues[intValueIndex++] = gameInterface.currentY;
                                } else if(scriptOpcode == 2502) {
                                    scriptIntValues[intValueIndex++] = gameInterface.originalWidth;
                                } else if(scriptOpcode == 2503) {
                                    scriptIntValues[intValueIndex++] = gameInterface.originalHeight;
                                } else if(scriptOpcode == 2504) {
                                    scriptIntValues[intValueIndex++] = gameInterface.isHidden ? 1 : 0;
                                } else {
                                    if(scriptOpcode != 2505) {
                                        break;
                                    }
                                    scriptIntValues[intValueIndex++] = gameInterface.parentId;
                                }
                            }
                        } else {
                            GameInterface gameInterface = bool ? MovedStatics.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                            if(scriptOpcode == 1600) {
                                scriptIntValues[intValueIndex++] = gameInterface.scrollWidth;
                            } else {
                                if(scriptOpcode != 1601) {
                                    break;
                                }
                                scriptIntValues[intValueIndex++] = gameInterface.scrollPosition;
                            }
                        }
                    } else {
                        GameInterface gameInterface;
                        if(scriptOpcode >= 2000) {
                            gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                            scriptOpcode -= 1000;
                        } else {
                            gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : MovedStatics.aGameInterface_2116;
                        }
                        if(scriptOpcode >= 1300 && scriptOpcode <= 1309 || scriptOpcode >= 1314 && scriptOpcode <= 1317) {
                            String class1 = scriptStringValues[--stringValueIndex];
                            Object[] objects = new Object[class1.length() + 1];
                            for(int i_84_ = objects.length - 1; i_84_ >= 1; i_84_--) {
                                if(class1.charAt(-1 + i_84_) == 115) {
                                    objects[i_84_] = scriptStringValues[--stringValueIndex];
                                } else {
                                    objects[i_84_] = new Integer(scriptIntValues[--intValueIndex]);
                                }
                            }
                            objects[0] = new Integer(scriptIntValues[--intValueIndex]);
                            if(scriptOpcode == 1303) {
                                gameInterface.anObjectArray2707 = objects;
                            }
                            if(scriptOpcode == 1317) {
                                gameInterface.anObjectArray2680 = objects;
                            }
                            if(scriptOpcode == 1304) {
                                gameInterface.anObjectArray2658 = objects;
                            }
                            if(scriptOpcode == 1302) {
                                gameInterface.anObjectArray2644 = objects;
                            }
                            if(scriptOpcode == 1316) {
                                gameInterface.anObjectArray2747 = objects;
                            }
                            if(scriptOpcode == 1301) {
                                gameInterface.anObjectArray2681 = objects;
                            }
                            if(scriptOpcode == 1300) {
                                gameInterface.onLoadListeners = objects;
                            }
                            if(scriptOpcode == 1315) {
                                gameInterface.anObjectArray2695 = objects;
                            }
                            if(scriptOpcode == 1306) {
                                gameInterface.anObjectArray2669 = objects;
                            }
                            if(scriptOpcode == 1305) {
                                gameInterface.anObjectArray2672 = objects;
                            }
                            if(scriptOpcode == 1309) {
                                gameInterface.anObjectArray2712 = objects;
                            }
                            if(scriptOpcode == 1308) {
                                gameInterface.anObjectArray2650 = objects;
                            }
                        } else if(scriptOpcode == 1310) {
                            int i_85_ = -1 + scriptIntValues[--intValueIndex];
                            if(i_85_ >= 0 && i_85_ <= 9) {
                                if(gameInterface.aClass1Array2661 == null || gameInterface.aClass1Array2661.length <= i_85_) {
                                    String[] class1s = new String[1 + i_85_];
                                    if(gameInterface.aClass1Array2661 != null) {
                                        for(int i_86_ = 0; gameInterface.aClass1Array2661.length > i_86_; i_86_++) {
                                            class1s[i_86_] = gameInterface.aClass1Array2661[i_86_];
                                        }
                                    }
                                    gameInterface.aClass1Array2661 = class1s;
                                }
                                gameInterface.aClass1Array2661[i_85_] = scriptStringValues[--stringValueIndex];
                            } else {
                                stringValueIndex--;
                            }
                        } else if(scriptOpcode == 1311) {
                            gameInterface.anInt2738 = scriptIntValues[--intValueIndex];
                        } else if(scriptOpcode == 1312) {
                            gameInterface.lockScroll = scriptIntValues[--intValueIndex] == 1;
                        } else {
                            if(scriptOpcode != 1313) {
                                break;
                            }
                            intValueIndex--;
                        }
                    }
                } else {
                    GameInterface gameInterface;
                    if(scriptOpcode < 2000) {
                        gameInterface = !bool ? Class22_Sub2.aGameInterface_1887 : MovedStatics.aGameInterface_2116;
                    } else {
                        gameInterface = GameInterface.getInterface(scriptIntValues[--intValueIndex]);
                        scriptOpcode -= 1000;
                    }
                    if(scriptOpcode == 1200) {
                        intValueIndex -= 3;
                        int i_87_ = scriptIntValues[intValueIndex];
                        int i_88_ = scriptIntValues[intValueIndex + 2];
                        if(i_87_ == -1) {
                            gameInterface.modelType = InterfaceModelType.NULL;
                        } else {
                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(i_87_, 10);
                            gameInterface.modelType = InterfaceModelType.ITEM;
                            gameInterface.rotationX = class40_sub5_sub16.xan2d;
                            gameInterface.rotationY = class40_sub5_sub16.zan2d;
                            gameInterface.modelZoom = 100 * class40_sub5_sub16.zoom2d / i_88_;
                            gameInterface.rotationZ = class40_sub5_sub16.yan2d;
                            gameInterface.offsetY2d = class40_sub5_sub16.yOffset2d;
                            gameInterface.offsetX2d = class40_sub5_sub16.xOffset2d;
                            gameInterface.modelId = i_87_;
                        }
                    } else if(scriptOpcode == 1201) {
                        gameInterface.modelType = InterfaceModelType.NPC_CHATHEAD;
                        gameInterface.modelId = scriptIntValues[--intValueIndex];
                    } else if(scriptOpcode == 1202) {
                        gameInterface.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
                        gameInterface.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
                    } else {
                        if(scriptOpcode != 1203) {
                            break;
                        }
                        GameInterface desiredInterface = !bool ? MovedStatics.aGameInterface_2116 : Class22_Sub2.aGameInterface_1887;
                        gameInterface.anInt2738 = desiredInterface.id;
                    }
                }
            }
        } catch(Exception exception) {
            /* empty */
        }

    }
}
