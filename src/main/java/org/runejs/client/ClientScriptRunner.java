package org.runejs.client;

import org.runejs.client.cache.cs.GoSubFrame;
import org.runejs.client.cache.cs.ClientScript;
import org.runejs.client.net.OutgoingPackets;
import org.runejs.client.node.Node;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.client.util.Signlink;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.def.VarbitDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

public class ClientScriptRunner extends Node {
    public static String[] scriptStack = new String[1000];
    public static int runEnergy = 0;
    public static String[] localStrings;
    public static int[] intLocals;
    public static int[] intStack = new int[1000];
    public static GoSubFrame[] callStack = new GoSubFrame[50];
    public static int fp = 0;
    public static LinkedList clientScriptRunnerCache = new LinkedList();
    public static Calendar calendar = Calendar.getInstance();
    public static boolean[] ENABLED_SKILLS = new boolean[]{true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, false};
    public static GameInterface primaryActiveComponent;
    public static int[] varcs = new int[2000];
    public static GameInterface secondaryActiveComponent;
    private static String[] MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

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
        return Native.asterisk;
    }

    public static void handleChatNamesRightClick(int arg1) {
        int offset = 0;
        for(int index = 0; index < 100; index++) {
            if(ChatBox.chatMessages[index] != null) {
                int chatType = ChatBox.chatTypes[index];
                int i_2_ = 4 + ChatBox.chatboxScroll + -(offset * 14) + 70;
                if(i_2_ < -20)
                    break;
                if(chatType == 0)
                    offset++;
                String username = ChatBox.chatPlayerNames[index];
                if(username != null && username.startsWith(Native.whiteCrown))
                    username = username.substring(5);
                if(username != null && username.startsWith(Native.goldCrown))
                    username = username.substring(5);
                if((chatType == 1 || chatType == 2) && (chatType == 1 || ChatBox.publicChatMode == 0 || ChatBox.publicChatMode == 1 && Player.hasFriend(username))) {
                    if(arg1 > i_2_ - 14 && arg1 <= i_2_ && !username.equals(Player.localPlayer.playerName)) {
                        if(Game.playerRights >= 1) {
                            MovedStatics.addActionRow(English.reportAbuse, 0, 0, 0, ActionRowType.REPORT_ABUSE.getId(), Native.white + username);
                        }

                        MovedStatics.addActionRow(English.addIgnore, 0, 0, 0, ActionRowType.ADD_IGNORE.getId(), Native.white + username);
                        MovedStatics.addActionRow(English.addFriend, 0, 0, 0, ActionRowType.ADD_FRIEND.getId(), Native.white + username);
                    }
                    offset++;
                }
                if((chatType == 3 || chatType == 7) && ChatBox.splitPrivateChat == 0 && (chatType == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(username))) {
                    offset++;
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        if(Game.playerRights >= 1) {
                            MovedStatics.addActionRow(English.reportAbuse, 0, 0, 0, ActionRowType.REPORT_ABUSE.getId(), Native.white + username);
                        }

                        MovedStatics.addActionRow(English.addIgnore, 0, 0, 0, ActionRowType.ADD_IGNORE.getId(), Native.white + username);
                        MovedStatics.addActionRow(English.addFriend, 0, 0, 0, ActionRowType.ADD_FRIEND.getId(), Native.white + username);
                    }
                }
                if(chatType == 4 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Player.hasFriend(username))) {
                    if(arg1 > -14 + i_2_ && arg1 <= i_2_) {
                        MovedStatics.addActionRow(English.acceptTrade, 0, 0, 0, ActionRowType.ACCEPT_TRADE.getId(), Native.white + username);
                    }
                    offset++;
                }
                if((chatType == 5 || chatType == 6) && ChatBox.splitPrivateChat == 0 && ChatBox.privateChatMode < 2)
                    offset++;
                if(chatType == 8 && (ChatBox.tradeMode == 0 || ChatBox.tradeMode == 1 && Player.hasFriend(username))) {
                    if(i_2_ + -14 < arg1 && arg1 <= i_2_) {
                        MovedStatics.addActionRow(English.acceptChallenge, 0, 0, 0, ActionRowType.ACCEPT_CHALLENGE.getId(), Native.white + username);
                    }
                    offset++;
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
                    clientScriptRunner.valueNodes[i] = signlink.putFieldNode(stringToType(typeString), valName);
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
                        argTypes[j] = stringToType(argNames[j]);
                    }

                    clientScriptRunner.functionNodes[i] = signlink.putMethodNode(argTypes, functionName, stringToType(typeString));
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

        clientScriptRunnerCache.addLast(clientScriptRunner);
    }

    public static void createClientScriptCheckPacket(int packetId, PacketBuffer buffer) {
        for(; ; ) {
            ClientScriptRunner clientScriptRunner = (ClientScriptRunner) clientScriptRunnerCache.peekFirst();
            if(clientScriptRunner == null) {
                break;
            }

            boolean bool = false;

            for(int i = 0; clientScriptRunner.scriptCount > i; i++) {
                if(clientScriptRunner.valueNodes[i] != null) {
                    if(clientScriptRunner.valueNodes[i].status == SignlinkNode.Status.ERRORED)
                        clientScriptRunner.errorCodes[i] = -5;
                    if(clientScriptRunner.valueNodes[i].status == SignlinkNode.Status.NOT_INITIALIZED)
                        bool = true;
                }
                if(clientScriptRunner.functionNodes[i] != null) {
                    if(clientScriptRunner.functionNodes[i].status == SignlinkNode.Status.ERRORED)
                        clientScriptRunner.errorCodes[i] = -6;
                    if(clientScriptRunner.functionNodes[i].status == SignlinkNode.Status.NOT_INITIALIZED)
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

            buffer.putCrc8(bufferPos);
            buffer.finishVarByte(-bufferPos + buffer.currentPosition);
            clientScriptRunner.unlink();
        }
    }

    public static void run(Object[] listeners, int arg1, int arg2, GameInterface gameInterface1, int arg4) {
        ClientScript script = ClientScript.get((Integer) listeners[0], 76);
        int[] intOperands = script.intOperands;
        int[] opcodes = script.opcodes;
        int isp = 0;
        int ssp = 0;
        int pc = -1;
        int opcode;

        try {
            intLocals = new int[script.intLocalCount];
            localStrings = new String[script.stringLocalCount];
            int localIntIndex = 0;
            int localStringIndex = 0;

            for(int listenerIndex = 1; listenerIndex < listeners.length; listenerIndex++) {
                if (listeners[listenerIndex] instanceof Integer) {
                    int intValue = ((Integer) listeners[listenerIndex]).intValue();
                    if (intValue == 0x80000001) {
                        intValue = arg4;
                    }
                    if (intValue == 0x80000002) {
                        intValue = arg2;
                    }
                    if (intValue == 0x80000003) {
                        intValue = gameInterface1.id;
                    }
                    if (intValue == 0x80000004) {
                        intValue = arg1;
                    }
                    intLocals[localIntIndex++] = intValue;
                } else if (listeners[listenerIndex] instanceof String) {
                    localStrings[localStringIndex++] = (String) listeners[listenerIndex];
                }
            }

            for (; ; ) {
                opcode = opcodes[++pc];

                // core language ops (not commands)
                if (opcode < 100) {
                    if (opcode == 0) {
                        // push_constant_int
                        intStack[isp++] = intOperands[pc];
                        continue;
                    } else if (opcode == 1) {
                        // push_varp
                        int operand = intOperands[pc];
                        intStack[isp++] = VarPlayerDefinition.varPlayers[operand];
                        continue;
                    } else if (opcode == 2) {
                        // pop_varp
                        int operand = intOperands[pc];
                        VarPlayerDefinition.varPlayers[operand] = intStack[--isp];
                        continue;
                    } else if (opcode == 3) {
                        // push_constant_string
                        scriptStack[ssp++] = script.stringOperands[pc];
                        continue;
                    } else if (opcode == 6) {
                        // branch
                        pc += intOperands[pc];
                        continue;
                    } else if (opcode == 7) {
                        // branch_not
                        isp -= 2;
                        if (intStack[isp] != intStack[1 + isp]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 8) {
                        // branch_equal
                        isp -= 2;
                        if (intStack[isp] == intStack[1 + isp]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 9) {
                        // branch_equals
                        isp -= 2;
                        if (intStack[1 + isp] > intStack[isp]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 10) {
                        // branch_greater_than
                        isp -= 2;
                        if (intStack[1 + isp] < intStack[isp]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 21) {
                        // return
                        if (fp != 0) {
                            GoSubFrame invokedScript = callStack[--fp];
                            localStrings = invokedScript.stringLocals;
                            intLocals = invokedScript.intLocals;
                            pc = invokedScript.pc;
                            script = invokedScript.script;
                            intOperands = script.intOperands;
                            opcodes = script.opcodes;
                            continue;
                        }
                        break;
                    } else if (opcode == 25) {
                        // push_varbit
                        int operand = intOperands[pc];
                        intStack[isp++] = VarbitDefinition.getVarbitValue(operand);
                        continue;
                    } else if (opcode == 27) {
                        // pop_varbit
                        int operand = intOperands[pc];
                        VarbitDefinition.setVarbitValue(intStack[--isp], operand);
                        continue;
                    } else if (opcode == 31) {
                        // branch_less_than_or_equals
                        isp -= 2;
                        if (intStack[isp] <= intStack[isp + 1]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 32) {
                        // branch_greater_than_or_equals
                        isp -= 2;
                        if (intStack[1 + isp] <= intStack[isp]) {
                            pc += intOperands[pc];
                        }
                        continue;
                    } else if (opcode == 33) {
                        // push_int_local
                        intStack[isp++] = intLocals[intOperands[pc]];
                        continue;
                    } else if (opcode == 34) {
                        // pop_int_local
                        intLocals[intOperands[pc]] = intStack[--isp];
                        continue;
                    } else if (opcode == 35) {
                        // push_string_local
                        scriptStack[ssp++] = localStrings[intOperands[pc]];
                        continue;
                    } else if (opcode == 36) {
                        // pop_string_local
                        localStrings[intOperands[pc]] = scriptStack[--ssp];
                        continue;
                    } else if (opcode == 37) {
                        // join_string
                        int operand = intOperands[pc];
                        ssp -= operand;
                        System.out.println("hey, go fix join_string!");
                        // TODO: we know what this does now, but the references have been refactored since
//                        RSString class1 = (RSString.method627(operand, ssp, Class40_Sub11.aClass1Array2153));
//                        Class40_Sub11.aClass1Array2153[ssp++] = class1;
                        continue;
                    } else if (opcode == 38) {
                        // pop_int_discard
                        isp--;
                        continue;
                    } else if (opcode == 39) {
                        // pop_string_discard
                        ssp--;
                        continue;
                    } else if (opcode == 40) {
                        // gosub_with_params
                        int scriptId = intOperands[pc];
                        ClientScript callee = ClientScript.get(scriptId, 73);
                        int[] calleeIntLocals = new int[callee.intLocalCount];
                        String[] calleeStringLocals = new String[callee.stringLocalCount];
                        for (int i = 0; callee.intArgCount > i; i++) {
                            calleeIntLocals[i] = intStack[isp - (callee.intArgCount + -i)];
                        }
                        for (int i = 0; callee.stringArgCount > i; i++) {
                            calleeStringLocals[i] = scriptStack[ssp - callee.stringArgCount + i];
                        }
                        ssp -= callee.stringArgCount;
                        isp -= callee.intArgCount;
                        GoSubFrame frame = new GoSubFrame();
                        frame.stringLocals = localStrings;
                        frame.script = script;
                        frame.intLocals = intLocals;
                        script = callee;
                        frame.pc = pc;
                        callStack[fp++] = frame;
                        intOperands = script.intOperands;
                        localStrings = calleeStringLocals;
                        pc = -1;
                        intLocals = calleeIntLocals;
                        opcodes = script.opcodes;
                        continue;
                    } else if (opcode == 42) {
                        // push_varc_int
                        intStack[isp++] = varcs[intOperands[pc]];
                        continue;
                    } else if (opcode == 43) {
                        // pop_varc_int
                        varcs[intOperands[pc]] = intStack[--isp];
                        continue;
                    }
                }

                // secondary pointer access (prefixed with ., e.g .cc_ commands)
                boolean secondary = intOperands[pc] == 1;

                if (opcode < 1000) {
                    if (opcode == 100) {
                        // cc_create
                        isp -= 3;
                        int componentId = intStack[isp];
                        int type = intStack[isp + 1];
                        int createdComponentId = intStack[isp + 2];
                        GameInterface component = GameInterface.getInterface(componentId);
                        if (component.createdComponents == null) {
                            component.createdComponents = new GameInterface[createdComponentId + 1];
                        }
                        if (component.createdComponents.length <= createdComponentId) {
                            GameInterface[] createdComponents = new GameInterface[createdComponentId + 1];
                            for (int i = 0; i < component.createdComponents.length; i++) {
                                createdComponents[i] = component.createdComponents[i];
                            }
                            component.createdComponents = createdComponents;
                        }
                        GameInterface createdComponent = new GameInterface();
                        createdComponent.layer = component.id;
                        createdComponent.type = GameInterfaceType.get(type);
                        createdComponent.id = ((0xffff & component.id) << 15) + 0x80000000 + createdComponentId;
                        component.createdComponents[createdComponentId] = createdComponent;
                        if (secondary) {
                            secondaryActiveComponent = createdComponent;
                        } else {
                            primaryActiveComponent = createdComponent;
                        }
                    } else if (opcode == 101) {
                        // cc_delete
                        GameInterface createdComponent = !secondary ? primaryActiveComponent : secondaryActiveComponent;
                        GameInterface component = GameInterface.getInterface(createdComponent.layer);
                        component.createdComponents[BitUtils.bitWiseAND(createdComponent.id, 32767)] = null;
                    } else if (opcode == 102) {
                        // cc_deleteall
                        GameInterface component = GameInterface.getInterface(intStack[--isp]);
                        component.createdComponents = null;
                    }
                } else if (opcode >= 1000 && opcode < 1100 || opcode >= 2000 && opcode < 2100) {
                    GameInterface component;
                    if (opcode >= 2000) {
                        // if_
                        component = GameInterface.getInterface(intStack[--isp]);
                        opcode -= 1000;
                    } else {
                        // cc_
                        component = secondary ? secondaryActiveComponent : primaryActiveComponent;
                    }

                    // add if/cc + name e.g. if_setposition
                    if (opcode == 1000) {
                        // setposition
                        isp -= 2;
                        component.x = intStack[isp];
                        component.y = intStack[isp + 1];
                    } else if (opcode == 1001) {
                        // setsize
                        isp -= 2;
                        component.width = intStack[isp];
                        component.height = intStack[1 + isp];
                    } else if (opcode == 1003) {
                        // sethide
                        component.hide = intStack[--isp] == 1;
                    } else if (opcode == 1004) {
                        // sethaslisteners (not official name)
                        component.hasListeners = intStack[--isp] == 1;
                    }
                } else if (opcode >= 1100 && opcode < 1200 || opcode >= 2100 && opcode < 2200) {
                    GameInterface component;
                    if (opcode < 2000) {
                        // cc_
                        component = !secondary ? primaryActiveComponent : secondaryActiveComponent;
                    } else {
                        // if_
                        component = GameInterface.getInterface(intStack[--isp]);
                        opcode -= 1000;
                    }

                    // add if/cc + name e.g. if_setscrollpos
                    if (opcode == 1100) {
                        // setscrollpos
                        isp -= 2;
                        component.scrollX = intStack[isp];
                        component.scrollY = intStack[1 + isp];
                    } else if (opcode == 1101) {
                        // setcolour
                        int color = intStack[--isp];
                        int i_25_ = (color & 0x7e0b) >> 10;
                        int i_27_ = color >> 5 & 0x1f;
                        int i_26_ = color & 0x1f;
                        component.textColor = (i_27_ << 11) + (i_25_ << 19) + (i_26_ << 3);
                    } else if (opcode == 1102) {
                        // setfill
                        component.fill = intStack[--isp] == 1;
                    } else if (opcode == 1103) {
                        // settrans
                        component.transparency = intStack[--isp];
                    } else if (opcode == 1104) {
                        // setlinewid (later on, guess not implemented now)
                        isp--;
                    } else if (opcode == 1105) {
                        // setgraphic
                        component.graphic = intStack[--isp];
                    } else if (opcode == 1106) {
                        // todo
                        component.textureId = intStack[--isp];
                    } else if (opcode == 1107) {
                        // settiling
                        component.tiled = intStack[--isp] == 1;
                    } else if (opcode == 1108) {
                        // setmodel
                        component.modelType = InterfaceModelType.MODEL;
                        component.modelId = intStack[--isp];
                    } else if (opcode == 1109) {
                        // setmodelangle
                        isp -= 6;
                        component.modelXOffset = intStack[isp];
                        component.modelYOffset = intStack[1 + isp];
                        component.modelXAngle = intStack[isp + 2];
                        component.modelYAngle = intStack[3 + isp];
                        component.modelZAngle = intStack[4 + isp];
                        component.modelZoom = intStack[5 + isp];
                    } else if (opcode == 1110) {
                        // setmodelanim
                        component.modelSeqId = intStack[--isp];
                    } else if (opcode == 1111) {
                        // setmodelorthog
                        component.modelOrthographic = intStack[--isp] == 1;
                    } else if (opcode == 1112) {
                        // settext
                        component.text = scriptStack[--ssp];
                    } else if (opcode == 1113) {
                        // settextfont
                        component.textFont = intStack[--isp];
                    } else if (opcode == 1114) {
                        // settextalign
                        isp -= 3;
                        component.textHorizontalAlignment = intStack[isp];
                        component.textVerticalAlignment = intStack[isp + 1];
                        component.textLineHeight = intStack[isp + 2];
                    } else if (opcode == 1115) {
                        // settextshadow
                        component.textShadow = intStack[--isp] == 1;
                    }
                } else if ((opcode < 1200 || opcode >= 1300) && (opcode < 2200 || opcode >= 2300)) {
                    if ((opcode < 1300 || opcode >= 1400) && (opcode < 2300 || opcode >= 2400)) {
                        if (opcode < 1500) {
                            if (opcode == 1400) {
                                // todo
                                isp -= 2;
                                int componentId = intStack[isp];
                                int i_28_ = intStack[isp + 1];
                                GameInterface component = GameInterface.getInterface(componentId);
                                if (component.createdComponents == null || component.createdComponents.length <= i_28_ || component.createdComponents[i_28_] == null) {
                                    intStack[isp++] = 0;
                                } else {
                                    intStack[isp++] = 1;
                                    if (secondary) {
                                        secondaryActiveComponent = component.createdComponents[i_28_];
                                    } else {
                                        primaryActiveComponent = component.createdComponents[i_28_];
                                    }
                                }
                            } else if (opcode == 1401) {
                                // todo
                                isp -= 3;
                                int i_30_ = intStack[isp];
                                int i_32_ = intStack[isp + 1];
                                int i_31_ = intStack[2 + isp];
                                GameInterface component = GameInterface.method361(GameInterface.components[i_30_], i_31_, true, 0, -1, 0, i_32_, 398);
                                if (component == null) {
                                    intStack[isp++] = 0;
                                } else {
                                    intStack[isp++] = 1;
                                    if (secondary) {
                                        secondaryActiveComponent = component;
                                    } else {
                                        primaryActiveComponent = component;
                                    }
                                }
                            } else if (opcode == 1402) {
                                // todo
                                isp -= 3;
                                GameInterface component = GameInterface.getInterface(intStack[isp]);
                                int i_34_ = intStack[isp + 1];
                                int i_33_ = intStack[2 + isp];
                                GameInterface gameInterface_35_ = GameInterface.method361(component.createdComponents, i_33_, true, component.scrollY, component.id, component.scrollX, i_34_, 398);
                                if (gameInterface_35_ == null) {
                                    intStack[isp++] = 0;
                                } else {
                                    intStack[isp++] = 1;
                                    if (secondary) {
                                        secondaryActiveComponent = gameInterface_35_;
                                    } else {
                                        primaryActiveComponent = gameInterface_35_;
                                    }
                                }
                            }
                        } else if (opcode < 1600) {
                            GameInterface component = secondary ? secondaryActiveComponent : primaryActiveComponent;
                            if (opcode == 1500) {
                                // cc_getx
                                intStack[isp++] = component.x;
                            } else if (opcode == 1501) {
                                // cc_gety
                                intStack[isp++] = component.y;
                            } else if (opcode == 1502) {
                                // cc_getwidth
                                intStack[isp++] = component.width;
                            } else if (opcode == 1503) {
                                // cc_getheight
                                intStack[isp++] = component.height;
                            } else if (opcode == 1504) {
                                // cc_gethide
                                intStack[isp++] = !component.hide ? 0 : 1;
                            } else if (opcode == 1505) {
                                // cc_setlayer
                                intStack[isp++] = component.layer;
                            }
                        } else if (opcode >= 1700) {
                            if (opcode < 2500) {
                                if (opcode == 2401) {
                                    // todo
                                    isp -= 3;
                                    int i_36_ = intStack[1 + isp];
                                    int i_37_ = intStack[isp];
                                    int i_38_ = intStack[isp + 2];
                                    GameInterface gameInterface = GameInterface.method361(GameInterface.components[i_37_], i_38_, false, 0, -1, 0, i_36_, 398);
                                    if (gameInterface == null) {
                                        intStack[isp++] = -1;
                                    } else {
                                        intStack[isp++] = gameInterface.id;
                                    }
                                } else if (opcode == 2402) {
                                    // todo
                                    isp -= 3;
                                    GameInterface component = GameInterface.getInterface(intStack[isp]);
                                    int i_39_ = intStack[1 + isp];
                                    int i_40_ = intStack[isp + 2];
                                    GameInterface gameInterface_41_ = GameInterface.method361(GameInterface.components[component.id >> 16], i_40_, false, component.scrollY, 0xffff & component.id, component.scrollX, i_39_, 398);
                                    if (gameInterface_41_ == null) {
                                        intStack[isp++] = -1;
                                    } else {
                                        intStack[isp++] = gameInterface_41_.id;
                                    }
                                }
                            } else if (opcode >= 2600) {
                                if (opcode < 2700) {
                                    GameInterface component = GameInterface.getInterface(intStack[--isp]);
                                    if (opcode == 2600) {
                                        // if_getscrollx
                                        intStack[isp++] = component.scrollX;
                                    } else if (opcode == 2601) {
                                        // if_getscrolly
                                        intStack[isp++] = component.scrollY;
                                    }
                                } else {
                                    if (opcode < 2800) {
                                        break;
                                    }
                                    if (opcode < 3100) {
                                        if (opcode == 3000) {
                                            // todo
                                            int i_42_ = intStack[--isp];
                                            if (MovedStatics.lastContinueTextWidgetId == -1) {
                                                GameInterface.sendPleaseWaitOptionClick(0, i_42_);
                                                MovedStatics.lastContinueTextWidgetId = i_42_;
                                            }
                                        } else if (opcode == 3001 || opcode == 3003) {
                                            // todo
                                            isp -= 2;
                                            int i_43_ = intStack[isp];
                                            int i_44_ = intStack[isp + 1];
                                            method406(0, i_44_, i_43_);
                                        } else if (opcode == 3002) {
                                            // todo
                                            GameInterface gameInterface = !secondary ? primaryActiveComponent : secondaryActiveComponent;
                                            if (MovedStatics.lastContinueTextWidgetId == -1) {
                                                GameInterface.sendPleaseWaitOptionClick(gameInterface.id & 0x7fff, gameInterface.layer);
                                                MovedStatics.lastContinueTextWidgetId = gameInterface.id;
                                            }
                                        } else if (opcode == 3003) {
                                            // todo
                                            GameInterface gameInterface = secondary ? secondaryActiveComponent : primaryActiveComponent;
                                            int i_45_ = intStack[--isp];
                                            method406(0x7fff & gameInterface.id, i_45_, gameInterface.layer);
                                        }
                                    } else if (opcode >= 3200) {
                                        if (opcode < 3300) {
                                            if (opcode == 3200) {
                                                // sound_synth
                                                isp -= 3;
                                                SoundSystem.play(intStack[isp], intStack[isp + 1], intStack[2 + isp]);
                                            } else if (opcode == 3201) {
                                                // sound_song
                                                MusicSystem.playSong(intStack[--isp]);
                                            } else if (opcode == 3202) {
                                                // sound_jingle
                                                isp -= 2;
                                                MusicSystem.playSoundJingle(intStack[isp + 1], intStack[isp]);
                                            }
                                        } else if (opcode < 3400) {
                                            if (opcode == 3300) {
                                                // clientclock
                                                intStack[isp++] = MovedStatics.pulseCycle;
                                            }
                                        } else if (opcode < 4100) {
                                            if (opcode == 4000) {
                                                // add
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                intStack[isp++] = a + b;
                                            } else if (opcode == 4001) {
                                                // sub
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[1 + isp];
                                                intStack[isp++] = a - b;
                                            } else if (opcode == 4002) {
                                                // multiply
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                intStack[isp++] = a * b;
                                            } else if (opcode == 4003) {
                                                // divide
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                intStack[isp++] = a / b;
                                            } else if (opcode == 4004) {
                                                // random
                                                int max = intStack[--isp];
                                                intStack[isp++] = (int) (Math.random() * (double) max);
                                            } else if (opcode == 4005) {
                                                // randominc
                                                int max = intStack[--isp];
                                                intStack[isp++] = (int) (Math.random() * (double) (1 + max));
                                            } else if (opcode == 4006) {
                                                // interpolate
                                                isp -= 5;
                                                int y1 = intStack[isp];
                                                int y2 = intStack[isp + 1];
                                                int x1 = intStack[isp + 2];
                                                int x2 = intStack[isp + 3];
                                                int x = intStack[isp + 4];
                                                intStack[isp++] = (x - x1) * (y2 - y1) / (x2 - x1) + y1;
                                            } else if (opcode == 4007) {
                                                // addpercent
                                                isp -= 2;
                                                int n = intStack[isp];
                                                int percent = intStack[isp + 1];
                                                intStack[isp++] = percent * n / 100 + n;
                                            } else if (opcode == 4008) {
                                                // setbit
                                                isp -= 2;
                                                int value = intStack[isp];
                                                int bit = intStack[isp + 1];
                                                intStack[isp++] = BitUtils.bitWiseOR(1 << bit, value);
                                            } else if (opcode == 4009) {
                                                // clearbit
                                                isp -= 2;
                                                int value = intStack[isp];
                                                int bit = intStack[isp + 1];
                                                intStack[isp++] = BitUtils.bitWiseAND(value, -1 + -(1 << bit));
                                            } else if (opcode == 4010) {
                                                // testbit
                                                isp -= 2;
                                                int value = intStack[isp];
                                                int bit = intStack[isp + 1];
                                                intStack[isp++] = BitUtils.bitWiseAND(1 << bit, value) != 0 ? 1 : 0;
                                            } else if (opcode == 4011) {
                                                // modulo
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                intStack[isp++] = a % b;
                                            } else if (opcode == 4012) {
                                                // pow
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                if (a == 0) {
                                                    intStack[isp++] = 0;
                                                } else {
                                                    intStack[isp++] = (int) Math.pow(a, b);
                                                }
                                            } else if (opcode == 4013) {
                                                // invpow
                                                isp -= 2;
                                                int a = intStack[isp];
                                                int b = intStack[isp + 1];
                                                if (a == 0) {
                                                    intStack[isp++] = 0;
                                                } else if (b == 0) {
                                                    intStack[isp++] = Integer.MAX_VALUE;
                                                } else {
                                                    intStack[isp++] = (int) Math.pow(a, 1.0 / (double) b);
                                                }
                                            }
                                        } else if (opcode < 4200) {
                                            if (opcode == 4100) {
                                                // append_num
                                                String a = scriptStack[--ssp];
                                                int b = intStack[--isp];
                                                scriptStack[ssp++] = a + b;
                                            } else if (opcode == 4101) {
                                                // append
                                                ssp -= 2;
                                                String a = scriptStack[ssp];
                                                String b = scriptStack[ssp + 1];
                                                scriptStack[ssp++] = a + b;
                                            } else if (opcode == 4102) {
                                                // append_signnum
                                                String a = scriptStack[--ssp];
                                                int b = intStack[--isp];
                                                scriptStack[ssp++] = a + toString(true, b);
                                            } else if (opcode == 4103) {
                                                // lowercase
                                                String value = scriptStack[--ssp];
                                                scriptStack[ssp++] = value.toLowerCase();
                                            } else if (opcode == 4104) {
                                                // fromdate
                                                int val = intStack[--isp];
                                                long timestamp = 86400000L * ((long) val + 11745L);
                                                calendar.setTime(new Date(timestamp));
                                                int day = calendar.get(Calendar.DATE);
                                                int month = calendar.get(Calendar.MONTH);
                                                int year = calendar.get(Calendar.YEAR);
                                                scriptStack[ssp++] = day + "-" + MONTHS[month] + "-" + year;
                                            } else if (opcode == 4105) {
                                                // text_gender
                                                ssp -= 2;
                                                String maleValue = scriptStack[ssp];
                                                String femaleValue = scriptStack[ssp + 1];
                                                if (Player.localPlayer.playerAppearance == null || !Player.localPlayer.playerAppearance.isFemale) {
                                                    scriptStack[ssp++] = maleValue;
                                                } else {
                                                    scriptStack[ssp++] = femaleValue;
                                                }
                                            } else if (opcode == 4106) {
                                                // tostring
                                                int value = intStack[--isp];
                                                scriptStack[ssp++] = Integer.toString(value);
                                            } else if (opcode == 4107) {
                                                // compare
                                                ssp -= 2;
                                                intStack[isp++] = scriptStack[ssp].compareTo(scriptStack[ssp + 1]);
                                            }
                                        }
                                    } else if (opcode == 3100) {
                                        // mes
                                        String str = scriptStack[--ssp];
                                        ChatBox.addChatMessage("", str, 0);
                                    } else if (opcode == 3101) {
                                        // anim
                                        isp -= 2;
                                        Player.playAnimation(intStack[isp], intStack[isp + 1], Player.localPlayer);
                                    }
                                }
                            } else {
                                GameInterface component = GameInterface.getInterface(intStack[--isp]);
                                if (opcode == 2500) {
                                    // if_getx
                                    intStack[isp++] = component.x;
                                } else if (opcode == 2501) {
                                    // if_gety
                                    intStack[isp++] = component.y;
                                } else if (opcode == 2502) {
                                    // if_getwidth
                                    intStack[isp++] = component.width;
                                } else if (opcode == 2503) {
                                    // if_getheight
                                    intStack[isp++] = component.height;
                                } else if (opcode == 2504) {
                                    // if_gethide
                                    intStack[isp++] = component.hide ? 1 : 0;
                                } else if (opcode == 2505) {
                                    // if_getlayer
                                    intStack[isp++] = component.layer;
                                }
                            }
                        } else {
                            GameInterface component = secondary ? secondaryActiveComponent : primaryActiveComponent;
                            if (opcode == 1600) {
                                // cc_getscrollx
                                intStack[isp++] = component.scrollX;
                            } else if (opcode == 1601) {
                                // cc_getscrolly
                                intStack[isp++] = component.scrollY;
                            }
                        }
                    } else {
                        GameInterface component;
                        if (opcode >= 2000) {
                            // if_
                            component = GameInterface.getInterface(intStack[--isp]);
                            opcode -= 1000;
                        } else {
                            // cc_
                            component = !secondary ? primaryActiveComponent : secondaryActiveComponent;
                        }

                        if (opcode >= 1300 && opcode <= 1309 || opcode >= 1314 && opcode <= 1317) {
                            String descriptor = scriptStack[--ssp];

                            // no triggers in this rev?

                            Object[] arguments = new Object[descriptor.length() + 1];
                            for (int i = arguments.length - 1; i >= 1; i--) {
                                if (descriptor.charAt(i - 1) == 115) { // ascii for 's'
                                    arguments[i] = scriptStack[--ssp];
                                } else {
                                    arguments[i] = intStack[--isp];
                                }
                            }

                            // script id
                            arguments[0] = intStack[--isp];

                            if (opcode == 1300) {
                                // todo
                                component.onLoadListener = arguments;
                            } else if (opcode == 1301) {
                                // todo
                                component.anObjectArray2681 = arguments;
                            } else if (opcode == 1302) {
                                // todo
                                component.anObjectArray2644 = arguments;
                            } else if (opcode == 1303) {
                                // todo
                                component.anObjectArray2707 = arguments;
                            } else if (opcode == 1304) {
                                // todo
                                component.anObjectArray2658 = arguments;
                            } else if (opcode == 1305) {
                                // todo
                                component.anObjectArray2672 = arguments;
                            } else if (opcode == 1306) {
                                // todo
                                component.anObjectArray2669 = arguments;
                            } else if (opcode == 1308) {
                                // todo
                                component.anObjectArray2650 = arguments;
                            } else if (opcode == 1309) {
                                // todo
                                component.anObjectArray2712 = arguments;
                            } else if (opcode == 1315) {
                                // todo
                                component.anObjectArray2695 = arguments;
                            } else if (opcode == 1316) {
                                // todo
                                component.anObjectArray2747 = arguments;
                            } else if (opcode == 1317) {
                                // todo
                                component.anObjectArray2680 = arguments;
                            }
                        } else if (opcode == 1310) {
                            // todo
                            int i_85_ = -1 + intStack[--isp];
                            if (i_85_ >= 0 && i_85_ <= 9) {
                                if (component.aClass1Array2661 == null || component.aClass1Array2661.length <= i_85_) {
                                    String[] class1s = new String[1 + i_85_];
                                    if (component.aClass1Array2661 != null) {
                                        for(int i_86_ = 0; component.aClass1Array2661.length > i_86_; i_86_++) {
                                            class1s[i_86_] = component.aClass1Array2661[i_86_];
                                        }
                                    }
                                    component.aClass1Array2661 = class1s;
                                }
                                component.aClass1Array2661[i_85_] = scriptStack[--ssp];
                            } else {
                                ssp--;
                            }
                        } else if (opcode == 1311) {
                            // todo
                            component.anInt2738 = intStack[--isp];
                        } else if (opcode == 1312) {
                            // todo
                            component.lockScroll = intStack[--isp] == 1;
                        } else if (opcode == 1313) {
                            // unused in this rev
                            isp--;
                        }
                    }
                } else {
                    GameInterface component;
                    if (opcode < 2000) {
                        // cc_
                        component = !secondary ? primaryActiveComponent : secondaryActiveComponent;
                    } else {
                        // if_
                        component = GameInterface.getInterface(intStack[--isp]);
                        opcode -= 1000;
                    }

                    // add if/cc + name e.g. if_setobject
                    if (opcode == 1200) {
                        // setobject
                        isp -= 3;
                        int objId = intStack[isp];
                        // [isp + 1] should be the obj count, guess it wasn't used yet
                        int objZoom = intStack[isp + 2];
                        if (objId == -1) {
                            component.modelType = InterfaceModelType.NULL;
                        } else {
                            ItemDefinition objType = ItemDefinition.forId(objId, 10);
                            component.modelType = InterfaceModelType.ITEM;
                            component.modelXAngle = objType.xan2d;
                            component.modelZAngle = objType.zan2d;
                            component.modelZoom = 100 * objType.zoom2d / objZoom;
                            component.modelYAngle = objType.yan2d;
                            component.modelYOffset = objType.yOffset2d;
                            component.modelXOffset = objType.xOffset2d;
                            component.modelId = objId;
                        }
                    } else if (opcode == 1201) {
                        // setnpchead
                        component.modelType = InterfaceModelType.NPC_CHATHEAD;
                        component.modelId = intStack[--isp];
                    } else if (opcode == 1202) {
                        // setplayerhead_self
                        component.modelType = InterfaceModelType.LOCAL_PLAYER_CHATHEAD;
                        component.modelId = Player.localPlayer.playerAppearance.getHeadModelId();
                    } else if (opcode == 1203) {
                        // todo
                        GameInterface activeComponent = !secondary ? secondaryActiveComponent : primaryActiveComponent;
                        component.anInt2738 = activeComponent.id;
                    }
                }
            }
        } catch (Exception exception) {
            /* empty */
        }
    }

    private static Class stringToType(String typeCode) throws ClassNotFoundException {
        if(typeCode.equals("B"))
            return Byte.TYPE;
        if(typeCode.equals("I"))
            return Integer.TYPE;
        if(typeCode.equals("S"))
            return Short.TYPE;
        if(typeCode.equals("J"))
            return Long.TYPE;
        if(typeCode.equals("Z"))
            return Boolean.TYPE;
        if(typeCode.equals("F"))
            return Float.TYPE;
        if(typeCode.equals("D"))
            return Double.TYPE;
        if(typeCode.equals("C"))
            return Character.TYPE;
        return Class.forName(typeCode);
    }

    // should belong in something like IntUtils.toString
    private static RSString toString(boolean arg0, int arg2) {
        return RSString.method521(arg0, 10, arg2);
    }

    public static void method406(int arg0, int arg1, int arg2) {
        if(arg1 == 1) {
            OutgoingPackets.buffer.putPacket(111);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 2) {
            OutgoingPackets.buffer.putPacket(9);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 3) {
            OutgoingPackets.buffer.putPacket(193);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 4) {
            OutgoingPackets.buffer.putPacket(53);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 5) {
            OutgoingPackets.buffer.putPacket(94);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 6) {
            OutgoingPackets.buffer.putPacket(213);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 7) {
            OutgoingPackets.buffer.putPacket(46);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 8) {
            OutgoingPackets.buffer.putPacket(130);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 9) {
            OutgoingPackets.buffer.putPacket(157);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
        if(arg1 == 10) {
            OutgoingPackets.buffer.putPacket(84);
            OutgoingPackets.buffer.putIntBE(arg2);
            OutgoingPackets.buffer.putShortBE(arg0);
        }
    }

    public static String method532(GameInterface gameInterface, String arg2) {
        if (arg2.contains(Native.percent)) {
            for (; ; ) {
                int i = arg2.indexOf(Native.percentOne);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + method872(999999999, ClientScript.run(0, gameInterface)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentTwo);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + method872(999999999, ClientScript.run(1, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentThree);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + method872(999999999, ClientScript.run(2, gameInterface)) + arg2.substring(2 + i);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentFour);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + method872(999999999, ClientScript.run(3, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                int i = arg2.indexOf(Native.percentFive);
                if (i == -1)
                    break;
                arg2 = arg2.substring(0, i) + method872(999999999, ClientScript.run(4, gameInterface)) + arg2.substring(i + 2);
            }
            for (; ; ) {
                // check client script results for value
                int i = arg2.indexOf(Native.percentDns);
                if (i == -1)
                    break;
                String str = "";
                if (MovedStatics.aSignlinkNode_394 != null) {
                    str = MovedStatics.method204(MovedStatics.aSignlinkNode_394.integerData);
                    if (MovedStatics.aSignlinkNode_394.value != null) {
                        byte[] is = ((String) MovedStatics.aSignlinkNode_394.value).getBytes(StandardCharsets.ISO_8859_1);
                        str = RSString.method279(is, 0, is.length).toString();
                    }
                }
                arg2 = arg2.substring(0, i) + str + arg2.substring(i + 4);
            }
        }
        return arg2;
    }

    public static void clearClientScriptRunnerCache() {
        clientScriptRunnerCache = new LinkedList();
    }
}
