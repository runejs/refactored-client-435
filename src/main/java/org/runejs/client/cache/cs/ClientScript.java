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
import org.runejs.client.scene.tile.GenericTile;

public class ClientScript extends CachedNode {

    public static NodeCache clientScriptCache = new NodeCache(128);

    public int[] intOperands;
    public int intStackCount;
    public int stringStackCount;
    public int localStringCount;
    public String[] stringOperands;
    public int localIntCount;
    public int[] opcodes;


    public static void clientScriptDebugger() {
        int len = CacheArchive.clientScriptCacheArchive.getLength();
        for(int ll = 0; ll < len; ll++) {
            if(CacheArchive.clientScriptCacheArchive.loaded(ll, 0)) {
                byte[] data = CacheArchive.clientScriptCacheArchive.getFile(0, ll);
                System.out.println(data.length);
            } else {
                System.out.println(ll + " not loaded");
            }
        }
    }

    public static ClientScript decodeClientScript(int arg0, int arg1) {
        long scriptId = arg0 + (arg1 << 16);
        ClientScript clientScript = (ClientScript) clientScriptCache.get(scriptId);
        if(clientScript != null) {
            return clientScript;
        }

        Buffer buffer = new Buffer(CacheArchive.clientScriptCacheArchive.method170(Native.emptyString, arg1 + Native.comma + arg0));
        clientScript = new ClientScript();
        buffer.currentPosition = buffer.buffer.length - 12;
        int opcodeCount = buffer.getIntBE();
        int operandIndex = 0;
        clientScript.localIntCount = buffer.getUnsignedShortBE();
        clientScript.localStringCount = buffer.getUnsignedShortBE();
        clientScript.intStackCount = buffer.getUnsignedShortBE();
        clientScript.stringStackCount = buffer.getUnsignedShortBE();
        clientScript.stringOperands = new String[opcodeCount];
        clientScript.intOperands = new int[opcodeCount];
        buffer.currentPosition = 0;
        clientScript.opcodes = new int[opcodeCount];
        while(buffer.currentPosition < -12 + buffer.buffer.length) {
            int opcode = buffer.getUnsignedShortBE();
            if(opcode == 3) {
                clientScript.stringOperands[operandIndex] = buffer.getString();
            } else if(opcode >= 100 || opcode == 21 || opcode == 38 || opcode == 39) {
                clientScript.intOperands[operandIndex] = buffer.getUnsignedByte();
            } else {
                clientScript.intOperands[operandIndex] = buffer.getIntBE();
            }
            clientScript.opcodes[operandIndex++] = opcode;
        }
        System.out.println("Caching script " + scriptId);
        clientScriptCache.put(scriptId, clientScript);
        return clientScript;
    }


    // TODO remove arg1 after checking its safe
    public static int parseClientScripts(int scriptIndex, boolean arg1, GameInterface gameInterface1) {
        if (gameInterface1.clientScripts == null || scriptIndex >= gameInterface1.clientScripts.length) {
            return -2;
        }
        try {
            int[] opcodes = gameInterface1.clientScripts[scriptIndex];
            int i = 0;
            int scriptDataIndex = 0;
            if (arg1) {
                HuffmanEncoding.anInt1559 = -63;
            }
            int operator = 0;
            while (true) {
                int operand = 0;
                int nextOperator = 0;
                int opcode = opcodes[scriptDataIndex++];
                if (opcode == 0) {
                    return i;
                }
                if (opcode == 15) {
                    nextOperator = 1;
                }
                if (opcode == 16) {
                    nextOperator = 2;
                }
                if (opcode == 1) {
                    operand = Player.playerLevels[opcodes[scriptDataIndex++]];
                }
                if (opcode == 2) {
                    operand = Player.nextLevels[opcodes[scriptDataIndex++]];
                }
                if (opcode == 3) {
                    operand = Player.playerExperience[opcodes[scriptDataIndex++]];
                }
                if (opcode == 17) {
                    nextOperator = 3;
                }
                if (opcode == 4) {
                    int i_19_ = opcodes[scriptDataIndex++] << 16;
                    i_19_ += opcodes[scriptDataIndex++];
                    GameInterface gameInterface = GameInterface.getInterface(i_19_);
                    int i_20_ = opcodes[scriptDataIndex++];
                    if (i_20_ != -1 && (!ItemDefinition.forId(i_20_, 10).members || MovedStatics.membersWorld)) {
                        for (int i_21_ = 0; i_21_ < gameInterface.items.length; i_21_++) {
                            if (1 + i_20_ == gameInterface.items[i_21_]) {
                                operand += gameInterface.itemAmounts[i_21_];
                            }
                        }
                    }
                }
                if (opcode == 5) {
                    int temp = opcodes[scriptDataIndex++];
                    operand = VarPlayerDefinition.varPlayers[temp];
                }
                if (opcode == 6) {
                    operand = Player.experienceForLevels[-1 + Player.nextLevels[opcodes[scriptDataIndex++]]];
                }
                if (opcode == 7) {
                    int varPlayerIndex = opcodes[scriptDataIndex++];
                    operand = 100 * VarPlayerDefinition.varPlayers[varPlayerIndex] / 46875;
                }
                if (opcode == 8) {
                    operand = Player.localPlayer.combatLevel;
                }
                if (opcode == 9) {
                    for (int i_22_ = 0; i_22_ < 25; i_22_++) {
                        if (MovedStatics.aBooleanArray548[i_22_]) {
                            operand += Player.nextLevels[i_22_];
                        }
                    }
                }
                if (opcode == 10) {
                    int i_23_ = opcodes[scriptDataIndex++] << 16;
                    i_23_ += opcodes[scriptDataIndex++];
                    GameInterface gameInterface = GameInterface.getInterface(i_23_);
                    int i_24_ = opcodes[scriptDataIndex++];
                    if (i_24_ != -1 && (!ItemDefinition.forId(i_24_, 10).members || MovedStatics.membersWorld)) {
                        for (int i_25_ = 0; gameInterface.items.length > i_25_; i_25_++) {
                            if (i_24_ + 1 == gameInterface.items[i_25_]) {
                                operand = 999999999;
                                break;
                            }
                        }
                    }
                }
                if (opcode == 11) {
                    operand = ClientScriptRunner.runEnergy;
                }
                if (opcode == 12) {
                    operand = GenericTile.carryWeight;
                }
                if (opcode == 13) {
                    int varPlayerValue = VarPlayerDefinition.varPlayers[opcodes[scriptDataIndex++]];
                    int leastSignificantBit = opcodes[scriptDataIndex++];
                    operand = (1 << leastSignificantBit & varPlayerValue) != 0 ? 1 : 0;
                }
                if (opcode == 14) {
                    int varbitId = opcodes[scriptDataIndex++];
                    operand = VarbitDefinition.getVarbitValue(varbitId);
                }
                if (opcode == 18) {
                    operand = (Player.localPlayer.worldX >> 7) + MovedStatics.baseX;
                }
                if (opcode == 19) {
                    operand = (Player.localPlayer.worldY >> 7) + Class26.baseY;
                }
                if (opcode == 20) {
                    operand = opcodes[scriptDataIndex++];
                }
                if (nextOperator == 0) {
                    if (operator == 0) {
                        i += operand;
                    }
                    if (operator == 1) {
                        i -= operand;
                    }
                    if (operator == 2 && operand != 0) {
                        i /= operand;
                    }
                    if (operator == 3) {
                        i *= operand;
                    }
                    operator = 0;
                } else {
                    operator = nextOperator;
                }
            }
        } catch (Exception exception) {
            return -1;
        }
    }
}
