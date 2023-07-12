package org.runejs.client.cache.def;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class IdentityKit extends CachedNode {
    public static CacheArchive identityKitCache;
    public static NodeCache identityKitNodeCache = new NodeCache(64);
    public static int identityKitLength;
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
        IdentityKit identityKit = (IdentityKit) identityKitNodeCache.get(arg1);
        if(identityKit != null) {
            return identityKit;
        }
        byte[] is = identityKitCache.getFile(3, arg1);
        identityKit = new IdentityKit();
        if(is != null) {
            identityKit.readValues(new Buffer(is));
        }
        identityKitNodeCache.put(arg1, identityKit);
        return identityKit;
    }

    public static void clearIdentityKitCache() {
        identityKitNodeCache.clear();
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
                class40_sub5_sub17_sub5s[i++] = Model.getModel(MovedStatics.aCacheArchive_654, models[i_7_]);
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
            models[i] = Model.getModel(MovedStatics.aCacheArchive_654, modelId[i]);
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
