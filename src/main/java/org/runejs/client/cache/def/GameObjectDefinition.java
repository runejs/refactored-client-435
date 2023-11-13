package org.runejs.client.cache.def;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.GameObjectDefinitionLoader;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.OldEngine.ObjectDecompressor;
import org.runejs.client.scene.InteractiveObjectTemporary;

import java.io.IOException;

public class GameObjectDefinition extends CachedNode implements EntityDefinition {
    public static DefinitionLoader<GameObjectDefinition> loader = new GameObjectDefinitionLoader();

    public static int count;
    public static int[] OBJECT_TYPES = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
    private static boolean lowMemory = false;
    private static CacheArchive definitionArchive;
    private static CacheArchive modelArchive;
    private static NodeCache definitionCache = new NodeCache(64);
    private static NodeCache modelCacheStatic = new NodeCache(500);
    private static Model[] objectModelHolder = new Model[4];
    private static NodeCache modelCacheDynamic = new NodeCache(10);
    private static NodeCache animatedObjectModelCache = new NodeCache(30);

    public int unkn1;
    public int offsetX;
    public boolean solid;
    public int ambientSoundHearDistance;
    public int sizeX;
    public int offsetY;
    public int setDecorDisplacement;
    public int animationId;
    public int modelSizeX;
    public String[] actions;
    public int[] recolorToReplace;
    public int icon = -1;
    public int blockingMask;
    public int ambientSoundId;
    public int sizeY;
    public int[] recolorToFind;
    public int modelSizeY;
    public boolean hollow;
    public int offsetHeight;
    public boolean nonFlatShading;
    public boolean wall;
    public int[] objectTypes;
    public int[] soundEffectIds;
    public int[] objectModels;
    public int ambient;
    public boolean walkable;
    public boolean adjustToTerrain;
    public int supportsItems;
    public int[] childIds;
    public int configId;
    public int mapSceneID;
    public int id;
    public int modelSizeHeight;
    public boolean castsShadow;
    public int unkn2;
    public int contrast;
    public int hasActions;
    public boolean obstructsGround;
    public int varbitId;
    public String name;
    public boolean rotated;

    public GameObjectDefinition() {
        ambientSoundHearDistance = 0;
        blockingMask = 0;
        ambientSoundId = -1;
        unkn1 = 0;
        offsetX = 0;
        modelSizeX = 128;
        hollow = false;
        wall = false;
        adjustToTerrain = false;
        supportsItems = -1;
        animationId = -1;
        setDecorDisplacement = 16;
        actions = new String[5];
        offsetHeight = 0;
        solid = true;
        sizeY = 1;
        unkn2 = 0;
        offsetY = 0;
        nonFlatShading = false;
        mapSceneID = -1;
        walkable = true;
        sizeX = 1;
        obstructsGround = false;
        modelSizeHeight = 128;
        name = "null";
        castsShadow = true;
        contrast = 0;
        configId = -1;
        rotated = false;
        varbitId = -1;
        hasActions = -1;
        ambient = 0;
        modelSizeY = 128;
    }


    public static void addTemporaryObject(int objectId, int x, int orientation, int duration, int plane, int y, int typeKey, int type, int delay) {
        InteractiveObjectTemporary obj = null;
        for(InteractiveObjectTemporary other = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.peekFirst(); other != null; other = (InteractiveObjectTemporary) MovedStatics.interactiveObjectTemporaryNodeCache.pollFirst()) {
            if(other.plane == plane && x == other.x && other.y == y && other.typeKey == typeKey) {
                obj = other;
                break;
            }
        }
        if(obj == null) {
            obj = new InteractiveObjectTemporary();
            obj.x = x;
            obj.typeKey = typeKey;
            obj.plane = plane;
            obj.y = y;
            MovedStatics.storeTemporaryObject(obj);
            MovedStatics.interactiveObjectTemporaryNodeCache.addLast(obj);
        }
        obj.id = objectId;
        obj.duration = duration;
        obj.delay = delay;
        obj.orientation = orientation;
        obj.type = type;
    }

    public static GameObjectDefinition getDefinition(int objectId) {
        GameObjectDefinition gameObjectDefinition = (GameObjectDefinition) definitionCache.get(objectId);
        if(gameObjectDefinition != null) {
            return gameObjectDefinition;
        }
        byte[] is = definitionArchive.getFile(6, objectId);
        gameObjectDefinition = new GameObjectDefinition();
        gameObjectDefinition.id = objectId;
        if(is == null) {
            try {
                Buffer buffer = ObjectDecompressor.grabObjectDef(objectId);
                if(buffer != null) {
                    loader.load(gameObjectDefinition, buffer);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            loader.load(gameObjectDefinition, new Buffer(is));
        }
        gameObjectDefinition.method605();
        if(gameObjectDefinition.hollow) {
            gameObjectDefinition.solid = false;
            gameObjectDefinition.walkable = false;
        }
        definitionCache.put(objectId, gameObjectDefinition);
        return gameObjectDefinition;
    }

    public static void clearGameObjectModelCache() {
        definitionCache.clear();
        modelCacheStatic.clear();
        modelCacheDynamic.clear();
        animatedObjectModelCache.clear();
    }

    public static void clearStaticModelCache() {
        modelCacheStatic.clear();
    }

    public static void initializeGameObjectDefinitionCache(CacheArchive modelCache, boolean lowMemory, CacheArchive definitionCache) {
        GameObjectDefinition.definitionArchive = definitionCache;
        count = GameObjectDefinition.definitionArchive.fileLength(6);
        GameObjectDefinition.lowMemory = lowMemory;
        GameObjectDefinition.modelArchive = modelCache;
    }

    public static boolean isObjectLoaded(int type, int id) {
        GameObjectDefinition gameObjectDefinition = getDefinition(id);
        if (type == 11)
            type = 10;
        if (type >= 5 && type <= 8)
            type = 4;
        return gameObjectDefinition.isTypeModelLoaded(type);
    }

    public Model createTerrainObjectModel(int arg0, int arg1, int arg2, int arg3, int arg4, int arg6) {
        long l;
        if(objectTypes == null) {
            l = (id << 10) + arg2;
        } else {
            l = arg2 + (id << 10) + (arg4 << 3);
        }
        Model model = (Model) modelCacheDynamic.get(l);
        if(model == null) {
            model = createObjectModel(!nonFlatShading, false, arg2, arg4);
            if(model == null) {
                return null;
            }
            modelCacheDynamic.put(l, model);
        }
        if(adjustToTerrain || nonFlatShading) {
            model = new Model(adjustToTerrain, nonFlatShading, model);
        }
        if(adjustToTerrain) {
            int i = (arg0 + arg6 + arg3 + arg1) / 4;
            for(int i_0_ = 0; model.vertexCount > i_0_; i_0_++) {
                int i_1_ = model.verticesX[i_0_];
                int i_2_ = model.verticesZ[i_0_];
                int i_3_ = arg3 + (64 + i_1_) * (arg6 + -arg3) / 128;
                int i_4_ = arg1 + (64 + i_1_) * (-arg1 + arg0) / 128;
                int i_5_ = i_3_ + (i_2_ + 64) * (-i_3_ + i_4_) / 128;
                model.verticesY[i_0_] += i_5_ + -i;
            }
        }
        return model;
    }

    public boolean hasSounds() {
        if(childIds == null) {
            return ambientSoundId != -1 || soundEffectIds != null;
        }
        for(int i = 0; i < childIds.length; i++) {
            if(childIds[i] != -1) {
                GameObjectDefinition gameObjectDefinition = getDefinition(childIds[i]);
                if(gameObjectDefinition.ambientSoundId != -1 || gameObjectDefinition.soundEffectIds != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void method605() {
        if(hasActions == -1) {
            hasActions = 0;
            if(objectModels != null && (objectTypes == null || objectTypes[0] == 10)) {
                hasActions = 1;
            }
            for(int i = 0; i < 5; i++) {
                if(actions[i] != null) {
                    hasActions = 1;
                    break;
                }
            }
        }
        if(supportsItems == -1) {
            supportsItems = solid ? 1 : 0;
        }
    }

    public Model createObjectModel(boolean shaded, boolean hasBones, int orientation, int objectType) {
        Model model = null;
        if(objectTypes == null) {
            if(objectType != 10) {
                return null;
            }
            if(objectModels == null) {
                return null;
            }
            boolean bool = orientation > 3 ^ rotated;
            int modelCount = objectModels.length;
            for(int modelIndex = 0; modelCount > modelIndex; modelIndex++) {
                int modelId = objectModels[modelIndex];
                if(bool) {
                    modelId += 65536;
                }
                model = (Model) modelCacheStatic.get(modelId);
                if(model == null) {
                    model = Model.getModel(modelArchive, modelId & 0xffff);
                    if(model == null) {
                        return null;
                    }
                    if(bool) {
                        model.method818();
                    }
                    modelCacheStatic.put(modelId, model);
                }
                if(modelCount > 1) {
                    objectModelHolder[modelIndex] = model;
                }
            }
            if(modelCount > 1) {
                model = new Model(objectModelHolder, modelCount);
            }
        } else {
            int objectTypeIndex = -1;
            for(int typeIndex = 0; objectTypes.length > typeIndex; typeIndex++) {
                if(objectType == objectTypes[typeIndex]) {
                    objectTypeIndex = typeIndex;
                    break;
                }
            }
            if(objectTypeIndex == -1) {
                return null;
            }
            int modelId = objectModels[objectTypeIndex];
            boolean bool = rotated ^ orientation > 3;
            if(bool) {
                modelId += 65536;
            }
            model = (Model) modelCacheStatic.get(modelId);
            if(model == null) {
                model = Model.getModel(modelArchive, 0xffff & modelId);
                if(model == null) {
                    return null;
                }
                if(bool) {
                    model.method818();
                }
                modelCacheStatic.put(modelId, model);
            }
        }
        boolean bool;
        bool = modelSizeX != 128 || modelSizeHeight != 128 || modelSizeY != 128;
        boolean bool_11_;
        bool_11_ = offsetX != 0 || offsetHeight != 0 || offsetY != 0;
        Model finalModel = new Model(model, orientation == 0 && !bool && !bool_11_, recolorToFind == null, true);
        orientation &= 0x3;
        if(orientation == 1) {
            finalModel.method813();
        } else if(orientation == 2) {
            finalModel.method819();
        } else if(orientation == 3) {
            finalModel.method824();
        }
        if(recolorToFind != null) {
            for(int i = 0; i < recolorToFind.length; i++) {
                finalModel.replaceColor(recolorToFind[i], recolorToReplace[i]);
            }
        }
        if(bool) {
            finalModel.scaleT(modelSizeX, modelSizeHeight, modelSizeY);
        }
        if(bool_11_) {
            finalModel.translate(offsetX, offsetHeight, offsetY);
        }
        if(hasBones) {
            finalModel.createBones();
        }
        finalModel.applyLighting(ambient + 64, 768 + contrast * 5, -50, -10, -50, shaded);
        return finalModel;
    }

    public Model createAnimatedObjectModel(int vertexHeight, int vertexHeightRight, int arg3, int objectType, int orientation, AnimationSequence animationSequence, int vertexHeightTop, int vertexHeightTopRight) {
        long l;
        if(objectTypes == null) {
            l = orientation + (id << 10);
        } else {
            l = orientation + (id << 10) + (objectType << 3);
        }
        Model model = (Model) animatedObjectModelCache.get(l);
        if(model == null) {
            model = createObjectModel(true, true, orientation, objectType);
            if(model == null) {
                return null;
            }
            animatedObjectModelCache.put(l, model);
        }
        if(animationSequence == null && !adjustToTerrain) {
            return model;
        }
        if(animationSequence == null) {
            model = model.method817(true);
        } else {
            model = animationSequence.method593(arg3, false, model, orientation);
        }
        if(adjustToTerrain) {
            int i = (vertexHeightRight + vertexHeight - (-vertexHeightTopRight + -vertexHeightTop)) / 4;
            for(int i_13_ = 0; i_13_ < model.vertexCount; i_13_++) {
                int i_14_ = model.verticesZ[i_13_];
                int i_15_ = model.verticesX[i_13_];
                int i_16_ = vertexHeight + (64 + i_15_) * (vertexHeightRight - vertexHeight) / 128;
                int i_17_ = vertexHeightTop + (64 + i_15_) * (vertexHeightTopRight + -vertexHeightTop) / 128;
                int i_18_ = i_16_ + (i_14_ + 64) * (-i_16_ + i_17_) / 128;
                model.verticesY[i_13_] += -i + i_18_;
            }
        }
        return model;

    }

    public boolean isTypeModelLoaded(int type) {
        if(objectTypes != null) {
            for(int i = 0; objectTypes.length > i; i++) {
                if(objectTypes[i] == type) {
                    return modelArchive.loaded(objectModels[i] & 0xffff, 0);
                }
            }
            return true;
        }
        if(objectModels == null) {
            return true;
        }
        if(type != 10) {
            return true;
        }
        boolean bool = true;
        for(int i = 0; objectModels.length > i; i++) {
            bool &= modelArchive.loaded(0xffff & objectModels[i], 0);
        }
        return bool;
    }

    public GameObjectDefinition getChildDefinition() {
        int index = -1;
        if(varbitId == -1) {
            if(configId != -1) {
                index = VarPlayerDefinition.varPlayers[configId];
            }
        } else {
            index = VarbitDefinition.getVarbitValue(varbitId);

        }
        if(index < 0 || childIds.length <= index || childIds[index] == -1) {
            return null;
        }
        return getDefinition(childIds[index]);
    }

    public boolean method612() {
        if(objectModels == null) {
            return true;
        }
        boolean bool = true;
        for(int i = 0; objectModels.length > i; i++) {
            bool &= modelArchive.loaded(0xffff & objectModels[i], 0);
        }
        return bool;
    }

    @Override
    public int getId() { return this.id; }

    @Override
    public String getName() {
        return name;
    }
}
