package org.runejs.client.cache.def;

import org.runejs.client.*;
import org.runejs.client.cache.CacheIndex;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.node.Class40_Sub6;
import org.runejs.client.node.HashTable;
import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.OldEngine.ObjectDecompressor;

import java.io.IOException;

public class GameObjectDefinition extends CachedNode implements EntityDefinition {
    public static ProducingGraphicsBuffer aProducingGraphicsBuffer_2524;
    public static int anInt2543 = 0;
    public static int lastClickY = 0;
    public static long aLong2561 = 0L;
    public static int count;
    public static NodeCache objectDefinitionCache = new NodeCache(64);
    public static NodeCache objectModelCache = new NodeCache(500);
    public static Model[] objectModelHolder = new Model[4];
    public static NodeCache terrainObjectModelCache = new NodeCache(10);
    public static NodeCache animatedObjectModelCache = new NodeCache(30);

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

    public static void method602(CacheArchive arg0, int arg1, CacheIndex arg2) {
        byte[] is = null;
        synchronized(RSCanvas.aLinkedList_53) {
            for(Class40_Sub6 class40_sub6 = (Class40_Sub6) RSCanvas.aLinkedList_53.peekFront((byte) -90); class40_sub6 != null; class40_sub6 = (Class40_Sub6) RSCanvas.aLinkedList_53.next(-4)) {
                if((long) arg1 == class40_sub6.key && arg2 == class40_sub6.cacheIndex && class40_sub6.anInt2112 == 0) {
                    is = class40_sub6.aByteArray2102;
                    break;
                }
            }
        }
        if(is == null) {
            byte[] is_6_ = arg2.get(arg1);
            arg0.method198(true, is_6_, arg1, arg2);
        } else {
            arg0.method198(true, is, arg1, arg2);
        }
    }


    public static void method609(int objectId, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
        Class40_Sub3 class40_sub3 = null;
        for(Class40_Sub3 class40_sub3_24_ = (Class40_Sub3) LinkedList.aLinkedList_1064.peekFront((byte) -90); class40_sub3_24_ != null; class40_sub3_24_ = (Class40_Sub3) LinkedList.aLinkedList_1064.next(-4)) {
            if(class40_sub3_24_.anInt2018 == arg5 && arg2 == class40_sub3_24_.anInt2039 && class40_sub3_24_.anInt2038 == arg6 && class40_sub3_24_.anInt2027 == arg7) {
                class40_sub3 = class40_sub3_24_;
                break;
            }
        }
        if(class40_sub3 == null) {
            class40_sub3 = new Class40_Sub3();
            class40_sub3.anInt2039 = arg2;
            class40_sub3.anInt2027 = arg7;
            class40_sub3.anInt2018 = arg5;
            class40_sub3.anInt2038 = arg6;
            Class39.method451(class40_sub3, 19813);
            LinkedList.aLinkedList_1064.pushBack(class40_sub3, 97);
        }
        class40_sub3.anInt2017 = objectId;
        class40_sub3.anInt2031 = arg4;
        class40_sub3.anInt2033 = arg9;
        class40_sub3.anInt2035 = arg3;
        class40_sub3.anInt2030 = arg8;
    }

    public static GameObjectDefinition getDefinition(int objectId) {
        GameObjectDefinition gameObjectDefinition = (GameObjectDefinition) objectDefinitionCache.get(objectId);
        if(gameObjectDefinition != null) {
            return gameObjectDefinition;
        }
        byte[] is = CacheArchive.definitionCache.getFile(6, objectId);
        gameObjectDefinition = new GameObjectDefinition();
        gameObjectDefinition.id = objectId;
        if(is == null) {
            try {
                Buffer buffer = ObjectDecompressor.grabObjectDef(objectId);
                if(buffer != null) {

                    gameObjectDefinition.readValues(buffer);
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        } else {
            gameObjectDefinition.readValues(new Buffer(is));
        }
        gameObjectDefinition.method605();
        if(gameObjectDefinition.hollow) {
            gameObjectDefinition.solid = false;
            gameObjectDefinition.walkable = false;
        }
        objectDefinitionCache.put(objectId, gameObjectDefinition);
        return gameObjectDefinition;
    }

    public static void clearGameObjectModelCache() {
        objectDefinitionCache.clear();
        objectModelCache.clear();
        terrainObjectModelCache.clear();
        animatedObjectModelCache.clear();
    }

    public Model createTerrainObjectModel(int arg0, int arg1, int arg2, int arg3, int arg4, int arg6) {
        long l;
        if(objectTypes == null) {
            l = (id << 10) + arg2;
        } else {
            l = arg2 + (id << 10) + (arg4 << 3);
        }
        Model model = (Model) terrainObjectModelCache.get(l);
        if(model == null) {
            model = createObjectModel(!nonFlatShading, false, arg2, arg4);
            if(model == null) {
                return null;
            }
            terrainObjectModelCache.put(l, model);
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

    public void readValues(Buffer gameObjectDefinitionBuffer) {
        for(; ; ) {
            int opcode = gameObjectDefinitionBuffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(gameObjectDefinitionBuffer, opcode);
        }
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
                model = (Model) objectModelCache.get(modelId);
                if(model == null) {
                    model = Model.getModel(RSString.aCacheArchive_1705, modelId & 0xffff);
                    if(model == null) {
                        return null;
                    }
                    if(bool) {
                        model.method818();
                    }
                    objectModelCache.put(modelId, model);
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
            model = (Model) objectModelCache.get(modelId);
            if(model == null) {
                model = Model.getModel(RSString.aCacheArchive_1705, 0xffff & modelId);
                if(model == null) {
                    return null;
                }
                if(bool) {
                    model.method818();
                }
                objectModelCache.put(modelId, model);
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

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(objectModels == null || Class35.aBoolean1734) {
                    objectTypes = new int[length];
                    objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        objectModels[index] = buffer.getUnsignedShortBE();
                        objectTypes[index] = buffer.getUnsignedByte();
                    }
                } else {
                    buffer.currentPosition += length * 3;
                }
            }
        } else if(opcode == 2) {
            name = buffer.getString();
        } else if(opcode == 5) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(objectModels == null || Class35.aBoolean1734) {
                    objectTypes = null;
                    objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        objectModels[index] = buffer.getUnsignedShortBE();
                    }
                } else {
                    buffer.currentPosition += 2 * length;
                }
            }
        } else if(opcode == 14) {
            sizeX = buffer.getUnsignedByte();
        } else if(opcode == 15) {
            sizeY = buffer.getUnsignedByte();
        } else if(opcode == 17) {
            solid = false;
        } else if(opcode == 18) {
            walkable = false;
        } else if(opcode == 19) {
            hasActions = buffer.getUnsignedByte();
        } else if(opcode == 21) {
            adjustToTerrain = true;
        } else if(opcode == 22) {
            nonFlatShading = true;
        } else if(opcode == 23) {
            wall = true;
        } else if(opcode == 24) {
            animationId = buffer.getUnsignedShortBE();
            if(animationId == 0xFFFF) {
                animationId = -1;
            }
        } else if(opcode == 28) {
            setDecorDisplacement = buffer.getUnsignedByte();
        } else if(opcode == 29) {
            ambient = buffer.getByte();
        } else if(opcode == 39) {
            contrast = 5 * buffer.getByte();
        } else if(opcode >= 30 && opcode < 35) {
            actions[opcode - 30] = buffer.getString();
            if(actions[opcode + -30].equalsIgnoreCase(English.hidden)) {
                actions[opcode + -30] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            recolorToFind = new int[length];
            recolorToReplace = new int[length];
            for(int index = 0; index < length; index++) {
                recolorToFind[index] = buffer.getUnsignedShortBE();
                recolorToReplace[index] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 60) {
            icon = buffer.getUnsignedShortBE();
        } else if(opcode == 62) {
            rotated = true;
        } else if(opcode == 64) {
            castsShadow = false;
        } else if(opcode == 65) {
            modelSizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 66) {
            modelSizeHeight = buffer.getUnsignedShortBE();
        } else if(opcode == 67) {
            modelSizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 68) {
            mapSceneID = buffer.getUnsignedShortBE();
        } else if(opcode == 69) {
            blockingMask = buffer.getUnsignedByte();
        } else if(opcode == 70) {
            offsetX = buffer.getShortBE();
        } else if(opcode == 71) {
            offsetHeight = buffer.getShortBE();
        } else if(opcode == 72) {
            offsetY = buffer.getShortBE();
        } else if(opcode == 73) {
            obstructsGround = true;
        } else if(opcode == 74) {
            hollow = true;
        } else if(opcode == 75) {
            supportsItems = buffer.getUnsignedByte();
        } else if(opcode == 77) {
            varbitId = buffer.getUnsignedShortBE();
            if(varbitId == 0xffff) {
                varbitId = -1;
            }
            configId = buffer.getUnsignedShortBE();
            if(configId == 0xFFFF) {
                configId = -1;
            }
            int length = buffer.getUnsignedByte();
            childIds = new int[1 + length];
            for(int index = 0; index <= length; ++index) {
                childIds[index] = buffer.getUnsignedShortBE();
                if(0xFFFF == childIds[index]) {
                    childIds[index] = -1;
                }
            }
        } else if(opcode == 78) {
            ambientSoundId = buffer.getUnsignedShortBE();
            ambientSoundHearDistance = buffer.getUnsignedByte();
        } else if(opcode == 79) {
            unkn1 = buffer.getUnsignedShortBE();
            unkn2 = buffer.getUnsignedShortBE();
            ambientSoundHearDistance = buffer.getUnsignedByte();
            int length = buffer.getUnsignedByte();
            soundEffectIds = new int[length];
            for(int index = 0; index < length; ++index) {
                soundEffectIds[index] = buffer.getUnsignedShortBE();
            }
        }
    }

    public boolean method610(int arg0, int arg1) {
        if(objectTypes != null) {
            for(int i = 0; objectTypes.length > i; i++) {
                if(objectTypes[i] == arg0) {
                    return RSString.aCacheArchive_1705.loaded(objectModels[i] & 0xffff, 0);
                }
            }
            return true;
        }
        if(objectModels == null) {
            return true;
        }
        if(arg0 != 10) {
            return true;
        }
        boolean bool = true;
        for(int i = 0; objectModels.length > i; i++) {
            bool &= RSString.aCacheArchive_1705.loaded(0xffff & objectModels[i], 0);
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
            bool &= RSString.aCacheArchive_1705.loaded(0xffff & objectModels[i], 0);
        }
        return bool;
    }

    @Override
    public String getName() {
        return name;
    }
}
