package org.runejs.client.cache.def;

import org.runejs.client.*;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.frame.Minimap;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.node.CachedNode;
import org.runejs.client.node.NodeCache;
import org.runejs.client.util.BitUtils;

import java.awt.*;

public class ActorDefinition extends CachedNode implements EntityDefinition {

    public static int count;
    public static NodeCache actorDefinitionNodeCache = new NodeCache(64);
    public static NodeCache actorChildModelCache = new NodeCache(50);
    public static CacheArchive aCacheArchive_1375;
    public static CacheArchive aCacheArchive_1577;

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

    public static void method569() {
        MovedStatics.anIntArray456 = null;
        MovedStatics.aByteArrayArray1370 = null;
        Npc.anIntArray3312 = null;
        MovedStatics.anIntArray3111 = null;
        Buffer.anIntArray1972 = null;
        MovedStatics.anIntArray1347 = null;
    }

    public static void playAnimation(int animationId, int animationDelay, Player player) {
        if(player.playingAnimation == animationId && animationId != -1) {
            int i = AnimationSequence.getAnimationSequence(animationId).replyMode;
            if(i == 1) {
                player.anInt3104 = 0;
                player.anInt3095 = 0;
                player.playingAnimationDelay = animationDelay;
                player.anInt3115 = 0;
            }
            if(i == 2) {
                player.anInt3095 = 0;
            }
        } else if(animationId == -1 || player.playingAnimation == -1 || AnimationSequence.getAnimationSequence(animationId).forcedPriority >= AnimationSequence.getAnimationSequence(player.playingAnimation).forcedPriority) {
            player.anInt3094 = player.anInt3109;
            player.anInt3104 = 0;
            player.anInt3115 = 0;
            player.anInt3095 = 0;
            player.playingAnimationDelay = animationDelay;
            player.playingAnimation = animationId;
        }
    }

    public static void drawMapBack() {
        try {
            if(ScreenController.frameMode == ScreenMode.FIXED) {
                Graphics graphics = Game.gameCanvas.getGraphics();
                Minimap.mapbackProducingGraphicsBuffer.drawGraphics(550, 4, graphics);
            }
        } catch(Exception exception) {
            Game.gameCanvas.repaint();
        }
    }

    public static ImageRGB method578() {
        ImageRGB class40_sub5_sub14_sub4 = new ImageRGB();
        class40_sub5_sub14_sub4.maxWidth = MovedStatics.imageMaxWidth;
        class40_sub5_sub14_sub4.maxHeight = MovedStatics.imageMaxHeight;
        class40_sub5_sub14_sub4.offsetX = MovedStatics.anIntArray1347[0];
        class40_sub5_sub14_sub4.offsetY = MovedStatics.anIntArray3111[0];
        class40_sub5_sub14_sub4.imageWidth = MovedStatics.anIntArray456[0];
        class40_sub5_sub14_sub4.imageHeight = Npc.anIntArray3312[0];
        byte[] is = MovedStatics.aByteArrayArray1370[0];
        int i = class40_sub5_sub14_sub4.imageWidth * class40_sub5_sub14_sub4.imageHeight;
        class40_sub5_sub14_sub4.pixels = new int[i];
        for(int i_5_ = 0; i_5_ < i; i_5_++) {
            class40_sub5_sub14_sub4.pixels[i_5_] = Buffer.anIntArray1972[BitUtils.bitWiseAND(255, is[i_5_])];
        }
        method569();
        return class40_sub5_sub14_sub4;
    }

    public static ActorDefinition getDefinition(int id) {
        ActorDefinition definition = (ActorDefinition) actorDefinitionNodeCache.get(id);
        if(definition != null)
            return definition;
        byte[] data = aCacheArchive_1375.getFile(9, id);
        definition = new ActorDefinition();
        definition.id = id;
        if(data != null)
            definition.readValues(new Buffer(data));
        actorDefinitionNodeCache.put(id, definition);
        return definition;
    }

    public static void clearActorCache() {
        actorDefinitionNodeCache.clear();
        actorChildModelCache.clear();
    }

    public static void initializeActorCache(CacheArchive arg0, CacheArchive arg2) {
        aCacheArchive_1375 = arg2;
        count = aCacheArchive_1375.fileLength(9);

        aCacheArchive_1577 = arg0;
    }

    public Model getChildModel(AnimationSequence animation1, AnimationSequence animation2, int arg3, int arg4) {
        if(childIds != null) {
            ActorDefinition actorDefinition = getChildDefinition();
            if(actorDefinition == null) {
                return null;
            }
            return actorDefinition.getChildModel(animation1, animation2, arg3, arg4);
        }
        Model model1 = (Model) actorChildModelCache.get(id);
        if(model1 == null) {
            boolean bool = false;
            for(int model : models) {
                if(!aCacheArchive_1577.loaded(model, 0)) {
                    bool = true;
                }
            }
            if(bool) {
                return null;
            }
            Model[] class40_sub5_sub17_sub5s = new Model[models.length];
            for(int i = 0; models.length > i; i++) {
                class40_sub5_sub17_sub5s[i] = Model.getModel(aCacheArchive_1577, models[i]);
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
            actorChildModelCache.put(id, model1);
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

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            models = new int[length];
            for(int idx = 0; idx < length; ++idx) {
                models[idx] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 2) {
            name = buffer.getString();
        } else if(opcode == 12) {
            boundaryDimension = buffer.getUnsignedByte();
        } else if(opcode == 13) {
            stanceAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 14) {
            walkAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 15) {
            rotateLeftAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 16) {
            rotateRightAnimation = buffer.getUnsignedShortBE();
        } else if(opcode == 17) {
            walkAnimation = buffer.getUnsignedShortBE();
            rotate180Animation = buffer.getUnsignedShortBE();
            rotate90RightAnimation = buffer.getUnsignedShortBE();
            rotate90LeftAnimation = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            options[opcode - 30] = buffer.getString();
            if(options[opcode - 30].equalsIgnoreCase(English.hidden)) {
                options[-30 + opcode] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            originalModelColors = new int[length];
            modifiedModelColors = new int[length];
            for(int i_2_ = 0; i_2_ < length; i_2_++) {
                modifiedModelColors[i_2_] = buffer.getUnsignedShortBE();
                originalModelColors[i_2_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 60) {
            int length = buffer.getUnsignedByte();
            headModelIndexes = new int[length];
            for(int i_4_ = 0; length > i_4_; i_4_++) {
                headModelIndexes[i_4_] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 93) {
            renderOnMinimap = false;
        } else if(opcode == 95) {
            combatLevel = buffer.getUnsignedShortBE();
        } else if(opcode == 97) {
            resizeX = buffer.getUnsignedShortBE();
        } else if(opcode == 98) {
            resizeY = buffer.getUnsignedShortBE();
        } else if(opcode == 99) {
            hasRenderPriority = true;
        } else if(opcode == 100) {
            ambient = buffer.getByte();
        } else if(opcode == 101) {
            contrast = buffer.getByte() * 5;
        } else if(opcode == 102) {
            headIcon = buffer.getUnsignedShortBE();
        } else if(opcode == 103) {
            degreesToTurn = buffer.getUnsignedShortBE();
        } else if(opcode == 106) {
            varbitId = buffer.getUnsignedShortBE();
            if(varbitId == 65535) {
                varbitId = -1;
            }
            varPlayerIndex = buffer.getUnsignedShortBE();
            if(varPlayerIndex == 65535) {
                varPlayerIndex = -1;
            }
            int childrenCount = buffer.getUnsignedByte();
            childIds = new int[childrenCount + 1];
            for(int idx = 0; childrenCount >= idx; idx++) {
                childIds[idx] = buffer.getUnsignedShortBE();
                if(childIds[idx] == 0xFFFF) {
                    childIds[idx] = -1;
                }
            }
        } else if(opcode == 107) {
            isClickable = false;
        }
    }

    public void readValues(Buffer npcDefinitionBuffer) {
        while(true) {
            int opcode = npcDefinitionBuffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(npcDefinitionBuffer, opcode);
        }
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
            if(!aCacheArchive_1577.loaded(headModelIndex, 0)) {
                cached = true;
            }
        }
        if(cached) {
            return null;
        }
        Model[] models = new Model[headModelIndexes.length];
        for(int i = 0; i < headModelIndexes.length; i++) {
            models[i] = Model.getModel(aCacheArchive_1577, headModelIndexes[i]);
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
    public String getName() {
        return name;
    }
}
