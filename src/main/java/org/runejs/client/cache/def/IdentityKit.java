package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.CacheDefinition;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.IdentityKitDefinitionLoader;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class IdentityKit extends CachedNode implements CacheDefinition {
    public static DefinitionLoader<IdentityKit> loader = new IdentityKitDefinitionLoader();

    public int id;
    private static CacheArchive identityKitArchive;
    private static NodeCache identityKitCache = new NodeCache(64);
    public static int count;
    private static CacheArchive modelArchive;
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
        IdentityKit identityKit = (IdentityKit) identityKitCache.get(arg1);
        if(identityKit != null) {
            return identityKit;
        }
        byte[] is = identityKitArchive.getFile(3, arg1);
        identityKit = new IdentityKit();
        identityKit.id = arg1;
        if(is != null) {
            loader.load(identityKit, new Buffer(is));
        }
        identityKitCache.put(arg1, identityKit);
        return identityKit;
    }

    public static void clearIdentityKitCache() {
        identityKitCache.clear();
    }

    public static void initializeIdentityKitDefinitionCache(CacheArchive definitionCache, CacheArchive arg2) {
        modelArchive = arg2;
        identityKitArchive = definitionCache;
        count = identityKitArchive.fileLength(3);
    }

    public boolean isBodyModelCached() {
        if(modelId == null) {
            return true;
        }
        boolean isCached = true;
        for(int i = 0; modelId.length > i; i++) {
            if(!modelArchive.loaded(modelId[i], 0)) {
                isCached = false;
            }
        }
        return isCached;
    }

    public boolean method624() {
        boolean bool = true;
        int i = 0;
        for(/**/; i < 5; i++) {
            if(models[i] != -1 && !modelArchive.loaded(models[i], 0)) {
                bool = false;
            }
        }
        return bool;
    }

    public Model method629() {
        Model[] class40_sub5_sub17_sub5s = new Model[5];
        int i = 0;
        for(int i_7_ = 0; i_7_ < 5; i_7_++) {
            if(models[i_7_] != -1) {
                class40_sub5_sub17_sub5s[i++] = Model.getModel(modelArchive, models[i_7_]);
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
            models[i] = Model.getModel(modelArchive, modelId[i]);
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

    @Override
    public int getId() {
        return this.id;
    }
}
