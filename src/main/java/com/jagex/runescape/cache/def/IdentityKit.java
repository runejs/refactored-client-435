package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.node.CachedNode;

public class IdentityKit extends CachedNode {
    public static HuffmanEncoding aHuffmanEncoding_2590;
    public static int anInt2591 = 0;
    public static int anInt2598 = 0;
    public static int[] sound = new int[50];
    public static LinkedList aLinkedList_2604 = new LinkedList();
    public static int height;
    public static int anInt2613 = 0;
    public static boolean membersServer;

    public int[] recolorToFind = new int[6];
    public int[] recolorToReplace;
    public int bodyPartId = -1;
    public int[] modelId;
    public boolean nonSelectable = false;
    public int[] models = {-1, -1, -1, -1, -1};

    public IdentityKit() {
        recolorToReplace = new int[6];
    }

    // ???
    public static IdentityKit cache(int arg1) {
        IdentityKit identityKit = (IdentityKit) ProducingGraphicsBuffer.aClass9_1615.get(arg1);
        if(identityKit != null) {
            return identityKit;
        }
        byte[] is = Class49.aCacheArchive_1150.getFile(arg1, 3);
        identityKit = new IdentityKit();
        if(is != null) {
            identityKit.readValues(new Buffer(is));
        }
        ProducingGraphicsBuffer.aClass9_1615.put(arg1, identityKit);
        return identityKit;
    }

    public void readValues(Buffer buffer) {
        while(true) {
            int opcode = buffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(buffer, opcode);
        }
    }

    public boolean isBodyModelCached() {
        if(modelId == null) {
            return true;
        }
        boolean isCached = true;
        for(int i = 0; modelId.length > i; i++) {
            if(!MovedStatics.aCacheArchive_654.loaded(modelId[i], 0)) {
                isCached = false;
            }
        }
        return isCached;
    }

    public boolean method624() {
        boolean bool = true;
        int i = 0;
        for(/**/; i < 5; i++) {
            if(models[i] != -1 && !MovedStatics.aCacheArchive_654.loaded(models[i], 0)) {
                bool = false;
            }
        }
        return bool;
    }

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            bodyPartId = buffer.getUnsignedByte();
        } else if(opcode == 2) {
            int modelCount = buffer.getUnsignedByte();
            modelId = new int[modelCount];
            for(int model = 0; model < modelCount; model++) {
                modelId[model] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 3) {
            nonSelectable = true;
        } else if(opcode >= 40 && opcode < 50) {
            recolorToFind[opcode + -40] = buffer.getUnsignedShortBE();
        } else if(opcode >= 50 && opcode < 60) {
            recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode >= 60 && opcode < 70) {
            models[-60 + opcode] = buffer.getUnsignedShortBE();
        }
    }

    public Model method629() {
        Model[] class40_sub5_sub17_sub5s = new Model[5];
        int i = 0;
        for(int i_7_ = 0; i_7_ < 5; i_7_++) {
            if(models[i_7_] != -1) {
                class40_sub5_sub17_sub5s[i++] = Model.getModel(MovedStatics.aCacheArchive_654, models[i_7_], 0);
            }
        }
        Model class40_sub5_sub17_sub5 = new Model(class40_sub5_sub17_sub5s, i);
        for(int i_8_ = 0; i_8_ < 6; i_8_++) {
            if(recolorToFind[i_8_] == 0) {
                break;
            }
            class40_sub5_sub17_sub5.replaceColor(recolorToFind[i_8_], recolorToReplace[i_8_]);
        }
        return class40_sub5_sub17_sub5;
    }

    public Model getBodyModel() {
        if(modelId == null) {
            return null;
        }
        Model[] models = new Model[modelId.length];
        for(int i = 0; i < modelId.length; i++) {
            models[i] = Model.getModel(MovedStatics.aCacheArchive_654, modelId[i], 0);
        }
        Model model;
        if(models.length == 1) {
            model = models[0];
        } else {
            model = new Model(models, models.length);
        }
        for(int i = 0; i < 6; i++) {
            if(recolorToFind[i] == 0) {
                break;
            }
            model.replaceColor(recolorToFind[i], recolorToReplace[i]);
        }
        return model;
    }
}
