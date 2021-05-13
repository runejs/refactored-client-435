package org.runejs.client.cache.def;

import org.runejs.client.MovedStatics;
import org.runejs.client.ProducingGraphicsBuffer_Sub1;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class SpotAnimDefinition extends CachedNode {

    public static CacheArchive gameDefinitionsCacheArchive;
    public static NodeCache spotAnimDefinitionCache = new NodeCache(64);
    public static NodeCache modelCache = new NodeCache(30);
    public int animationId;
    public int modelId;
    public int contrast = 0;
    public int ambient = 0;
    public int resizeX = 128;
    public int rotaton;
    public int[] recolorToFind;
    public int id;
    public int[] recolorToReplace;
    public int resizeY;

    public SpotAnimDefinition() {
        animationId = -1;
        recolorToFind = new int[6];
        rotaton = 0;
        resizeY = 128;
        recolorToReplace = new int[6];
    }

    public static SpotAnimDefinition forId(int id) {
        SpotAnimDefinition spotAnimDefinition = (SpotAnimDefinition) spotAnimDefinitionCache.get(id);
        if (spotAnimDefinition != null)
            return spotAnimDefinition;
        byte[] is = gameDefinitionsCacheArchive.getFile(13, id);
        spotAnimDefinition = new SpotAnimDefinition();
        spotAnimDefinition.id = id;
        if (is != null)
            spotAnimDefinition.readValues(new Buffer(is));
        spotAnimDefinitionCache.put(id, spotAnimDefinition);
        return spotAnimDefinition;
    }

    public static void clearSpotAnimDefinitionCache() {
        spotAnimDefinitionCache.clear();
        modelCache.clear();
    }

    public void readValues(Buffer buffer) {
        for (; ; ) {
            int opcode = buffer.getUnsignedByte();
            if (opcode == 0) {
                break;
            }
            readValue(opcode, buffer);
        }
    }

    public void readValue(int opcode, Buffer buffer) {
        if (opcode == 1) {
            modelId = buffer.getUnsignedShortBE();
        } else if (opcode == 2) {
            animationId = buffer.getUnsignedShortBE();
        } else if (opcode == 4) {
            resizeX = buffer.getUnsignedShortBE();
        } else if (opcode == 5) {
            resizeY = buffer.getUnsignedShortBE();
        } else if (opcode == 6) {
            rotaton = buffer.getUnsignedShortBE();
        } else if (opcode == 7) {
            ambient = buffer.getUnsignedByte();
        } else if (opcode == 8) {
            contrast = buffer.getUnsignedByte();
        } else if (opcode >= 40 && opcode < 50) {
            recolorToFind[-40 + opcode] = buffer.getUnsignedShortBE();
        } else if (opcode >= 50 && opcode < 60) {
            recolorToReplace[-50 + opcode] = buffer.getUnsignedShortBE();
        }
    }

    public Model method549(int arg0) {
        Model model = (Model) modelCache.get((long) id);
        if (model == null) {
            model = Model.getModel(MovedStatics. aCacheArchive_2582, modelId);
            if (model == null) {
                return null;
            }
            for (int i = 0; i < 6; i++) {
                if (recolorToFind[0] != 0) {
                    model.replaceColor(recolorToFind[i], recolorToReplace[i]);
                }
            }
            model.createBones();
            model.applyLighting(64 + ambient, contrast + 850, -30, -50, -30, true);
            modelCache.put((long) id, model);
        }
        Model class40_sub5_sub17_sub5_0_;
        if (animationId == -1 || arg0 == -1) {
            class40_sub5_sub17_sub5_0_ = model.method806(true);
        } else {
            class40_sub5_sub17_sub5_0_ = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId).method597((byte) -87, model, arg0);
        }
        if (resizeX != 128 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.scaleT(resizeX, resizeY, resizeX);
        }
        if (rotaton != 0) {
            if (rotaton == 90) {
                class40_sub5_sub17_sub5_0_.method813();
            }
            if (rotaton == 180) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
            if (rotaton == 270) {
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
                class40_sub5_sub17_sub5_0_.method813();
            }
        }
        return class40_sub5_sub17_sub5_0_;

    }
}
