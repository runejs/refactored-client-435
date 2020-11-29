package com.jagex.runescape.cache.media.gameInterface;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.MemoryCache;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.Scene;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.SceneTile;
import com.jagex.runescape.scene.util.CollisionMap;
import tech.henning.fourthreefive.Configuration;

public class ClientScript extends SubNode {
    public static LinkedList aLinkedList_2268 = new LinkedList();
    public static ProducingGraphicsBuffer chatboxRight;
    public static int crossY = 0;
    public static int anInt2278 = 0;
    public static int anInt2280 = 0;
    public static MemoryCache clientScriptCache = new MemoryCache(128);

    public int[] intOperands;
    public int intStackCount;
    public int stringStackCount;
    public int localStringCount;
    public String[] stringOperands;
    public int localIntCount;
    public int[] opcodes;


    public static int method546(int arg0) {
        if(!Configuration.ROOFS_ENABLED) {
            return Player.worldLevel;
        }
        if (arg0 != 256)
            anInt2280 = 44;
        int i = Class37.getFloorDrawHeight(Player.worldLevel, Class12.cameraX, Class40_Sub5_Sub6.cameraY);
        if (i + -SceneCluster.cameraZ < 800 && (OverlayDefinition.tile_flags[Player.worldLevel][Class12.cameraX >> 7][Class40_Sub5_Sub6.cameraY >> 7] & 0x4) != 0)
            return Player.worldLevel;
        return 3;
    }

    public static ClientScript decodeClientScript(int arg0, int arg1) {
        long l = arg0 + (arg1 << 16);
        ClientScript clientScript = (ClientScript) clientScriptCache.get(l);
        if(clientScript != null) {
            return clientScript;
        }

        Buffer buffer = new Buffer(MemoryCache.clientScriptCacheIndex.method170(Native.emptyString, arg1 + Native.comma + arg0));
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
        clientScriptCache.put(l, clientScript);
        return clientScript;
    }
}
