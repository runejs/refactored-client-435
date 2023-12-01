package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.def.loading.DefinitionLoader;
import org.runejs.client.cache.def.loading.rs435.ActorDefinitionLoader;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;

public class ActorDefinition extends CachedNode implements EntityDefinition {
    private static DefinitionLoader<ActorDefinition> loader = new ActorDefinitionLoader();

    public static int count;
    private static NodeCache actorDefinitionCache = new NodeCache(64);
    private static NodeCache actorModelCache = new NodeCache(50);
    private static CacheArchive actorDefinitionArchive;
    private static CacheArchive actorModelArchive;

    public boolean isClickable = true;
    public int boundaryDimension = 1;
    public int[] headModelIndexes;
    public String[] options = new String[5];
    public int headIcon = -1;
    public int stanceAnimation = -1;
    public int varPlayerIndex = -1;
    public int ambient = 0;
    public int rotateRightAnimation = -1;
    public int degreesToTurn = 32;
    public int combatLevel = -1;
    public int[] originalModelColors;
    public boolean hasRenderPriority = false;
    public String name = "null";
    public int[] models;
    public int rotate180Animation = -1;
    public int resizeX = 128;
    public int contrast = 0;
    public int varbitId = -1;
    public int rotate90LeftAnimation = -1;
    public int resizeY = 128;
    public int rotate90RightAnimation = -1;
    public int rotateLeftAnimation = -1;
    public int walkAnimation = -1;
    public int[] childIds;
    public int id;
    public int[] modifiedModelColors;
    public boolean renderOnMinimap = true;

    public static ActorDefinition getDefinition(int id) {
        ActorDefinition definition = (ActorDefinition) actorDefinitionCache.get(id);
        if(definition != null)
            return definition;
        byte[] data = actorDefinitionArchive.getFile(9, id);
        definition = new ActorDefinition();
        definition.id = id;
        if(data != null) {
            loader.load(definition, new Buffer(data));
        }
        actorDefinitionCache.put(id, definition);
        return definition;
    }

    public static void clearActorCache() {
        actorDefinitionCache.clear();
        actorModelCache.clear();
    }

    public static void initializeActorCache(CacheArchive models, CacheArchive definitions) {
        actorDefinitionArchive = definitions;
        count = actorDefinitionArchive.fileLength(9);

        actorModelArchive = models;
    }

    public Model getChildModel(AnimationSequence animation1, AnimationSequence animation2, int arg3, int arg4) {
        if(childIds != null) {
            ActorDefinition actorDefinition = getChildDefinition();
            if(actorDefinition == null) {
                return null;
            }
            return actorDefinition.getChildModel(animation1, animation2, arg3, arg4);
        }
        Model model1 = (Model) actorModelCache.get(id);
        if(model1 == null) {
            boolean bool = false;
            for(int model : models) {
                if(!actorModelArchive.loaded(model, 0)) {
                    bool = true;
                }
            }
            if(bool) {
                return null;
            }
            Model[] class40_sub5_sub17_sub5s = new Model[models.length];
            for(int i = 0; models.length > i; i++) {
                class40_sub5_sub17_sub5s[i] = Model.getModel(actorModelArchive, models[i]);
            }
            if(class40_sub5_sub17_sub5s.length == 1) {
                model1 = class40_sub5_sub17_sub5s[0];
            } else {
                model1 = new Model(class40_sub5_sub17_sub5s, class40_sub5_sub17_sub5s.length);
            }
            if(modifiedModelColors != null) {
                for(int i = 0; i < modifiedModelColors.length; i++) {
                    assert model1 != null;
                    model1.replaceColor(modifiedModelColors[i], originalModelColors[i]);
                }
            }
            assert model1 != null;
            model1.createBones();
            model1.applyLighting(ambient + 64, 850 + contrast, -30, -50, -30, true);
            actorModelCache.put(id, model1);
        }
        Model class40_sub5_sub17_sub5_0_;
        if(animation1 != null && animation2 != null) {
            class40_sub5_sub17_sub5_0_ = animation1.method590(model1, animation2, arg4, arg3, (byte) 63);
        } else if(animation1 != null) {
            class40_sub5_sub17_sub5_0_ = animation1.method599(arg4, model1, false);
        } else if(animation2 == null) {
            class40_sub5_sub17_sub5_0_ = model1.method817(true);
        } else {
            class40_sub5_sub17_sub5_0_ = animation2.method599(arg3, model1, false);
        }
        if(resizeX != 128 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.scaleT(resizeX, resizeY, resizeX);
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public boolean isVisible() {
        if(childIds == null) {
            return true;
        }
        int index = -1;
        if(varbitId != -1) {
            index = VarbitDefinition.getVarbitValue(varbitId);
        } else if(varPlayerIndex != -1) {
            index = VarPlayerDefinition.varPlayers[varPlayerIndex];
        }
        return index >= 0 && childIds.length > index && childIds[index] != -1;
    }

    public Model getHeadModel() {
        if(childIds != null) {
            ActorDefinition definition = getChildDefinition();
            if(definition == null) {
                return null;
            }
            return definition.getHeadModel();
        }
        if(headModelIndexes == null) {
            return null;
        }
        boolean cached = false;
        for(int headModelIndex : headModelIndexes) {
            if(!actorModelArchive.loaded(headModelIndex, 0)) {
                cached = true;
            }
        }
        if(cached) {
            return null;
        }
        Model[] models = new Model[headModelIndexes.length];
        for(int i = 0; i < headModelIndexes.length; i++) {
            models[i] = Model.getModel(actorModelArchive, headModelIndexes[i]);
        }
        Model headModel;
        if(models.length == 1) {
            headModel = models[0];
        } else {
            headModel = new Model(models, models.length);
        }
        if(modifiedModelColors != null) {
            for(int i = 0; i < modifiedModelColors.length; i++) {
                assert headModel != null;
                headModel.replaceColor(modifiedModelColors[i], originalModelColors[i]);
            }
        }
        return headModel;
    }

    public ActorDefinition getChildDefinition() {
        int childId = -1;
        if(varbitId != -1) {
            childId = VarbitDefinition.getVarbitValue(varbitId);
        } else if(varPlayerIndex != -1) {
            childId = VarPlayerDefinition.varPlayers[varPlayerIndex];
        }
        if(childId < 0 || childId >= childIds.length || childIds[childId] == -1) {
            return null;
        }
        return getDefinition(childIds[childId]);
    }

    @Override
    public int getId() { return this.id; }

    @Override
    public String getName() { return this.name; }
}
