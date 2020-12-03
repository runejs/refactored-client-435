package com.jagex.runescape.cache.cs;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.node.NodeCache;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.SpotAnimDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.node.CachedNode;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.tile.GenericTile;

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
                byte[] data = CacheArchive.clientScriptCacheArchive.getFile(ll, 0);
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
            int i_15_ = 0;
            for (; ; ) {
                int i_16_ = 0;
                int i_17_ = 0;
                int opcode = opcodes[scriptDataIndex++];
                if (opcode == 0) {
                    return i;
                }
                if (opcode == 15) {
                    i_17_ = 1;
                }
                if (opcode == 16) {
                    i_17_ = 2;
                }
                if (opcode == 1) {
                    i_16_ = Player.playerLevels[opcodes[scriptDataIndex++]];
                }
                if (opcode == 2) {
                    i_16_ = Player.nextLevels[opcodes[scriptDataIndex++]];
                }
                if (opcode == 3) {
                    i_16_ = Player.playerExperience[opcodes[scriptDataIndex++]];
                }
                if (opcode == 17) {
                    i_17_ = 3;
                }
                if (opcode == 4) {
                    int i_19_ = opcodes[scriptDataIndex++] << 16;
                    i_19_ += opcodes[scriptDataIndex++];
                    GameInterface gameInterface = GameInterface.getInterface(i_19_);
                    int i_20_ = opcodes[scriptDataIndex++];
                    if (i_20_ != -1 && (!ItemDefinition.forId(i_20_, 10).members || Class22.membersWorld)) {
                        for (int i_21_ = 0; i_21_ < gameInterface.items.length; i_21_++) {
                            if (1 + i_20_ == gameInterface.items[i_21_]) {
                                i_16_ += gameInterface.itemAmounts[i_21_];
                            }
                        }
                    }
                }
                if (opcode == 5) {
                    int temp = opcodes[scriptDataIndex++];
                    i_16_ = GroundItemTile.varbitMasks[temp];
                }
                if (opcode == 6) {
                    i_16_ = Player.experienceForLevels[-1 + Player.nextLevels[opcodes[scriptDataIndex++]]];
                }
                if (opcode == 7) {
                    int temp = opcodes[scriptDataIndex++];
                    i_16_ = 100 * GroundItemTile.varbitMasks[temp] / 46875;
                }
                if (opcode == 8) {
                    i_16_ = Player.localPlayer.combatLevel;
                }
                if (opcode == 9) {
                    for (int i_22_ = 0; i_22_ < 25; i_22_++) {
                        if (Class22.aBooleanArray548[i_22_]) {
                            i_16_ += Player.nextLevels[i_22_];
                        }
                    }
                }
                if (opcode == 10) {
                    int i_23_ = opcodes[scriptDataIndex++] << 16;
                    i_23_ += opcodes[scriptDataIndex++];
                    GameInterface gameInterface = GameInterface.getInterface(i_23_);
                    int i_24_ = opcodes[scriptDataIndex++];
                    if (i_24_ != -1 && (!ItemDefinition.forId(i_24_, 10).members || Class22.membersWorld)) {
                        for (int i_25_ = 0; gameInterface.items.length > i_25_; i_25_++) {
                            if (i_24_ + 1 == gameInterface.items[i_25_]) {
                                i_16_ = 999999999;
                                break;
                            }
                        }
                    }
                }
                if (opcode == 11) {
                    i_16_ = ClientScriptRunner.runEnergy;
                }
                if (opcode == 12) {
                    i_16_ = GenericTile.anInt1222;
                }
                if (opcode == 13) {
                    int i_26_ = GroundItemTile.varbitMasks[opcodes[scriptDataIndex++]];
                    int i_27_ = opcodes[scriptDataIndex++];
                    i_16_ = (1 << i_27_ & i_26_) != 0 ? 1 : 0;
                }
                if (opcode == 14) {
                    int i_28_ = opcodes[scriptDataIndex++];
                    i_16_ = Class40_Sub5_Sub6.method585(i_28_, 1369);
                }
                if (opcode == 18) {
                    i_16_ = (Player.localPlayer.worldX >> 7) + SpotAnimDefinition.baseX;
                }
                if (opcode == 19) {
                    i_16_ = (Player.localPlayer.worldY >> 7) + Class26.baseY;
                }
                if (opcode == 20) {
                    i_16_ = opcodes[scriptDataIndex++];
                }
                if (i_17_ == 0) {
                    if (i_15_ == 0) {
                        i += i_16_;
                    }
                    if (i_15_ == 1) {
                        i -= i_16_;
                    }
                    if (i_15_ == 2 && i_16_ != 0) {
                        i /= i_16_;
                    }
                    if (i_15_ == 3) {
                        i *= i_16_;
                    }
                    i_15_ = 0;
                } else {
                    i_15_ = i_17_;
                }
            }
        } catch (Exception exception) {
            return -1;
        }
    }
}
