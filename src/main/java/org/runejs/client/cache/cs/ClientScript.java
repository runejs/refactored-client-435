package org.runejs.client.cache.cs;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.VarPlayerDefinition;
import org.runejs.client.cache.def.VarbitDefinition;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.node.CachedNode;

public class ClientScript extends CachedNode {

    private static NodeCache scriptCache = new NodeCache(128);

    public int[] intOperands;
    public int intArgCount;
    public int stringArgCount;
    public int stringLocalCount;
    public String[] stringOperands;
    public int intLocalCount;
    public int[] opcodes;

    public static void clearClientScriptCache() {
        scriptCache.clear();
    }


    public static void clientScriptDebugger() {
        int fileCount = CacheArchive.clientScriptCacheArchive.getLength();
        for(int fileId = 0; fileId < fileCount; fileId++) {
            if(CacheArchive.clientScriptCacheArchive.loaded(fileId, 0)) {
                byte[] data = CacheArchive.clientScriptCacheArchive.getFile(0, fileId);
                System.out.println(data.length);
            } else {
                System.out.println(fileId + " not loaded");
            }
        }
    }

    public static ClientScript get(int arg0, int arg1) {
        long scriptId = arg0 + (arg1 << 16);
        ClientScript script = (ClientScript) scriptCache.get(scriptId);
        if (script != null) {
            return script;
        }

        Buffer buffer = new Buffer(CacheArchive.clientScriptCacheArchive.getFileByName(arg1 + Native.comma + arg0, Native.emptyString));
        script = new ClientScript();
        buffer.currentPosition = buffer.buffer.length - 12;
        int opcodeCount = buffer.getIntBE();
        int operandIndex = 0;
        script.intLocalCount = buffer.getUnsignedShortBE();
        script.stringLocalCount = buffer.getUnsignedShortBE();
        script.intArgCount = buffer.getUnsignedShortBE();
        script.stringArgCount = buffer.getUnsignedShortBE();
        script.stringOperands = new String[opcodeCount];
        script.intOperands = new int[opcodeCount];
        buffer.currentPosition = 0;
        script.opcodes = new int[opcodeCount];
        while (buffer.currentPosition < -12 + buffer.buffer.length) {
            int opcode = buffer.getUnsignedShortBE();
            if (opcode == 3) {
                script.stringOperands[operandIndex] = buffer.getString();
            } else if (opcode >= 100 || opcode == 21 || opcode == 38 || opcode == 39) {
                script.intOperands[operandIndex] = buffer.getUnsignedByte();
            } else {
                script.intOperands[operandIndex] = buffer.getIntBE();
            }
            script.opcodes[operandIndex++] = opcode;
        }
        System.out.println("Caching script " + scriptId);
        scriptCache.put(scriptId, script);
        return script;
    }

    // execute if1 scripts (would be ideal to put this into another class ala Cs1ScriptRunner)
    public static int run(int id, GameInterface component) {
        if (component.scripts == null || id >= component.scripts.length) {
            return -2;
        }

        try {
            int[] script = component.scripts[id];
            int accumulator = 0;
            int pc = 0;
            int operator = 0;

            while (true) {
                int value = 0;
                int nextAccumulatorMode = 0;
                int opcode = script[pc++];

                if (opcode == 0) {
                    return accumulator;
                }

                if (opcode == 1) {
                    // stat_level
                    value = Player.boostedLevels[script[pc++]];
                } else if (opcode == 2) {
                    // stat_base_level
                    value = Player.baseLevels[script[pc++]];
                } else if (opcode == 3) {
                    // stat_xp
                    value = Player.experience[script[pc++]];
                } else if (opcode == 4) {
                    // inv_count
                    int componentId = script[pc++] << 16;
                    componentId += script[pc++];
                    GameInterface otherComponent = GameInterface.getInterface(componentId);
                    int objType = script[pc++];
                    if (objType != -1 && (!ItemDefinition.forId(objType, 10).members || MovedStatics.membersWorld)) {
                        for (int slot = 0; slot < otherComponent.invSlotObjId.length; slot++) {
                            if (otherComponent.invSlotObjId[slot] == objType + 1) {
                                value += otherComponent.invSlotObjCount[slot];
                            }
                        }
                    }
                } else if (opcode == 5) {
                    // testvar
                    int temp = script[pc++];
                    value = VarPlayerDefinition.varPlayers[temp];
                } else if (opcode == 6) {
                    // stat_xp_remaining
                    value = Player.experienceForLevels[-1 + Player.baseLevels[script[pc++]]];
                } else if (opcode == 7) {
                    int varPlayerIndex = script[pc++];
                    value = 100 * VarPlayerDefinition.varPlayers[varPlayerIndex] / 46875;
                } else if (opcode == 8) {
                    // comlevel
                    value = Player.localPlayer.combatLevel;
                } else if (opcode == 9) {
                    // stat_total
                    for (int skill = 0; skill < 25; skill++) {
                        if (ClientScriptRunner.ENABLED_SKILLS[skill]) {
                            value += Player.baseLevels[skill];
                        }
                    }
                } else if (opcode == 10) {
                    // inv_contains
                    int componentId = script[pc++] << 16;
                    componentId += script[pc++];
                    GameInterface otherComponent = GameInterface.getInterface(componentId);
                    int objType = script[pc++];
                    if (objType != -1 && (!ItemDefinition.forId(objType, 10).members || MovedStatics.membersWorld)) {
                        for (int slot = 0; otherComponent.invSlotObjId.length > slot; slot++) {
                            if (objType + 1 == otherComponent.invSlotObjId[slot]) {
                                value = 999999999;
                                break;
                            }
                        }
                    }
                } else if (opcode == 11) {
                    // runenergy
                    value = ClientScriptRunner.runEnergy;
                } else if (opcode == 12) {
                    // runweight
                    value = MovedStatics.runWeight;
                } else if (opcode == 13) {
                    // testbit
                    int varpValue = VarPlayerDefinition.varPlayers[script[pc++]];
                    int bit = script[pc++];
                    value = (1 << bit & varpValue) != 0 ? 1 : 0;
                } else if (opcode == 14) {
                    // getvarbit
                    int varbit = script[pc++];
                    value = VarbitDefinition.getVarbitValue(varbit);
                } else if (opcode == 15) {
                    nextAccumulatorMode = 1;
                } else if (opcode == 16) {
                    nextAccumulatorMode = 2;
                } else if (opcode == 17) {
                    nextAccumulatorMode = 3;
                } else if (opcode == 18) {
                    value = (Player.localPlayer.worldX >> 7) + MovedStatics.baseX;
                } else if (opcode == 19) {
                    value = (Player.localPlayer.worldY >> 7) + MovedStatics.baseY;
                } else if (opcode == 20) {
                    // push_int
                    value = script[pc++];
                }

                if (nextAccumulatorMode == 0) {
                    if (operator == 0) {
                        accumulator += value;
                    } else if (operator == 1) {
                        accumulator -= value;
                    } else if (operator == 2 && value != 0) {
                        accumulator /= value;
                    } else if (operator == 3) {
                        accumulator *= value;
                    }

                    operator = 0;
                } else {
                    operator = nextAccumulatorMode;
                }
            }
        } catch (Exception exception) {
            return -1;
        }
    }
}
