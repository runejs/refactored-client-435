package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.Cache;
import com.jagex.runescape.cache.media.Widget.Widget;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.util.CollisionMap;

import java.awt.*;

public class ItemDefinition extends SubNode implements EntityDefinition {
    public static int anInt2798 = 0;
    public static int[] soundVolume = new int[50];
    public static int selectedMask;
    public static int anInt2846;
    public static int anInt2850 = -1;
    public static int anInt2854;
    public static int count;

    public int stackable;
    public RSString name;
    public RSString[] interfaceOptions;
    public int primaryMaleHeadPiece = -1;
    public int[] originalColours;
    public RSString[] groundOptions;
    public int inventoryModelId;
    public int xOffset2d;
    public int noteTemplateId;
    public int yOffset2d;
    public int notedId;
    public int groundScaleX;
    public int[] destColors;
    public int zoom2d;
    public int maleOffset;
    public int femaleModel1;
    public int maleModel1;
    public int secondaryFemaleHeadPiece;
    public int teamIndex;
    public int maleModel2;
    public int ambient;
    public int zan2d;
    public int cost;
    public int femaleOffset;
    public int yan2d;
    public int[] stackIds;
    public int groundScaleZ;
    public int[] stackableAmounts;
    public int maleModel0;
    public int contrast;
    public int secondaryMaleHeadPiece;
    public int xan2d;
    public int femaleModel2;
    public int femaleModel0;
    public boolean members;
    public int primaryFemaleHeadPiece;
    public int id;
    public int groundScaleY;

    public ItemDefinition() {
        interfaceOptions = new RSString[]{null, null, null, null, Cache.dropStringInstance};
        stackable = 0;
        maleOffset = 0;
        name = Class61.aClass1_1437;
        yOffset2d = 0;
        cost = 1;
        xOffset2d = 0;
        femaleOffset = 0;
        ambient = 0;
        maleModel1 = -1;
        yan2d = 0;
        groundOptions = new RSString[]{null, null, Class27.takeStringInstance, null, null};
        groundScaleX = 128;
        noteTemplateId = -1;
        secondaryFemaleHeadPiece = -1;
        zoom2d = 2000;
        maleModel2 = -1;
        teamIndex = 0;
        zan2d = 0;
        contrast = 0;
        femaleModel1 = -1;
        femaleModel2 = -1;
        xan2d = 0;
        groundScaleZ = 128;
        secondaryMaleHeadPiece = -1;
        femaleModel0 = -1;
        members = false;
        primaryFemaleHeadPiece = -1;
        groundScaleY = 128;
        notedId = -1;
        maleModel0 = -1;
    }

    public static void method742() {
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            Landscape.aClass68_1185.drawGraphics(0, 4, graphics);
            Class40_Sub5_Sub1.aClass68_2275.drawGraphics(0, 357, graphics);
            Class39.aClass68_908.drawGraphics(722, 4, graphics);
            GameObject.aClass68_3045.drawGraphics(743, 205, graphics);
            Class40_Sub5_Sub17_Sub6.aClass68_3243.drawGraphics(0, 0, graphics);
            Class40_Sub7.aClass68_2123.drawGraphics(516, 4, graphics);
            Class61.aClass68_1441.drawGraphics(516, 205, graphics);
            Class30.aClass68_714.drawGraphics(496, 357, graphics);
            Class17.aClass68_462.drawGraphics(0, 338, graphics);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static void method744() {
        if(Class59.keyFocusListener != null) {
            synchronized(Class59.keyFocusListener) {
                Class59.keyFocusListener = null;
            }
        }
    }

    public static void method745() {
        soundVolume = null;
    }

    public static boolean method746(Widget arg1) {
        if(arg1.alternateOperators == null) {
            return false;
        }
        for(int i = 0; arg1.alternateOperators.length > i; i++) {
            int i_10_ = HuffmanEncoding.method1029(i, false, arg1);
            int i_11_ = arg1.alternateRhs[i];
            if(arg1.alternateOperators[i] == 2) {
                if((i_11_ <= i_10_)) {
                    return false;
                }
            } else if(arg1.alternateOperators[i] == 3) {
                if((i_11_ >= i_10_)) {
                    return false;
                }
            } else if(arg1.alternateOperators[i] == 4) {
                if(i_11_ == i_10_) {
                    return false;
                }
            } else if(i_10_ != i_11_) {
                return false;
            }
        }
        return true;
    }

    public static void method748(int arg1) {
        for(Renderable.anInt2866 += arg1; (Renderable.anInt2866 >= CollisionMap.anInt141); Renderable.anInt2866 -= CollisionMap.anInt141) {
            SubNode.anInt2081 -= SubNode.anInt2081 >> 2;
        }
        SubNode.anInt2081 -= 1000 * arg1;
        if(SubNode.anInt2081 < 0) {
            SubNode.anInt2081 = 0;
        }
    }

    public static void method749(boolean arg0) {
        for(int i = 0; Player.npcCount > i; i++) {
            Npc npc = (Player.npcs[Player.npcIds[i]]);
            int i_15_ = (536870912 + (Player.npcIds[i] << 14));
            if(npc != null && npc.isVisible(1) && arg0 == (npc.actorDefinition.hasRenderPriority) && npc.actorDefinition.method571(-1)) {
                int i_16_ = (npc.worldX >> 7);
                int i_17_ = npc.worldY >> 7;
                if(i_16_ >= 0 && i_16_ < 104 && i_17_ >= 0 && i_17_ < 104) {
                    if(npc.anInt3096 == 1 && (npc.worldX & 0x7f) == 64 && ((npc.worldY & 0x7f) == 64)) {
                        if(Class61.anIntArrayArray1435[i_16_][i_17_] == Class40_Sub5_Sub11.anInt2628) {
                            continue;
                        }
                        Class61.anIntArrayArray1435[i_16_][i_17_] = Class40_Sub5_Sub11.anInt2628;
                    }
                    if(!npc.actorDefinition.isClickable) {
                        i_15_ += -2147483648;
                    }
                    Npc.currentScene.method134(Player.worldLevel, npc.worldX, npc.worldY, (Class37.getFloorDrawHeight(Player.worldLevel, (npc.worldX + ((-1 + npc.anInt3096) * 64)), (npc.anInt3096 * 64 + (-64 + (npc.worldY))))), -64 + (npc.anInt3096 * 64 + 60), npc, npc.anInt3118, i_15_, npc.aBoolean3105);
                }
            }
        }
    }

    public static ItemDefinition forId(int id, int arg1) {
        ItemDefinition definition = ((ItemDefinition) ISAAC.aClass9_516.get(id, (byte) 100));
        if(definition != null) {
            return definition;
        }
        byte[] is = Class26.aCacheIndex_632.getFile(id, arg1);
        definition = new ItemDefinition();
        definition.id = id;
        if(is != null) {
            definition.readValues(new Buffer(is));
        }
        if(definition.noteTemplateId != -1) {
            definition.itemToNote(forId(definition.noteTemplateId, 10), forId(definition.notedId, 10));
        }
        if(!IdentityKit.membersServer && definition.members) {
            definition.interfaceOptions = null;
            definition.teamIndex = 0;
            definition.groundOptions = null;
            definition.name = Item.aClass1_3069;
        }
        ISAAC.aClass9_516.put(id, definition);
        return definition;
    }

    public boolean headPieceReady(boolean female) {
        int primaryId = primaryMaleHeadPiece;
        int secondaryId = secondaryMaleHeadPiece;
        if(female) {
            secondaryId = secondaryFemaleHeadPiece;
            primaryId = primaryFemaleHeadPiece;
        }
        if(primaryId == -1) {
            return true;
        }
        boolean ready = true;
        if(!Class8.aCacheIndex_284.loaded(primaryId, 0)) {
            ready = false;
        }
        if(secondaryId != -1 && !Class8.aCacheIndex_284.loaded(secondaryId, 0)) {
            ready = false;
        }
        return ready;
    }

    public boolean equipmentReady(boolean arg0) {
        int i = maleModel0;
        int i_1_ = maleModel1;
        int i_2_ = maleModel2;
        if(arg0) {
            i_2_ = femaleModel2;
            i_1_ = femaleModel1;
            i = femaleModel0;
        }
        if(i == -1) {
            return true;
        }
        boolean bool = true;
        if(!Class8.aCacheIndex_284.loaded(i, 0)) {
            bool = false;
        }
        if(i_1_ != -1 && !Class8.aCacheIndex_284.loaded(i_1_, 0)) {
            bool = false;
        }
        if(i_2_ != -1 && !Class8.aCacheIndex_284.loaded(i_2_, 0)) {
            bool = false;
        }
        return bool;
    }

    public Model asEquipment(boolean isFemale) {
        int primaryId = maleModel0;
        int secondaryId = maleModel1;
        int tertiaryId = maleModel2;
        if(isFemale) {
            primaryId = femaleModel0;
            secondaryId = femaleModel1;
            tertiaryId = femaleModel2;
        }
        if(primaryId == -1) {
            return null;
        }
        Model primary = Model.getModel(Class8.aCacheIndex_284, primaryId, 0);
        if(secondaryId != -1) {
            Model secondary = Model.getModel(Class8.aCacheIndex_284, secondaryId, 0);
            if(tertiaryId == -1) {
                Model[] tertiary = {primary, secondary};
                primary = new Model(tertiary, 2);
            } else {
                Model model3 = Model.getModel(Class8.aCacheIndex_284, tertiaryId, 0);
                Model[] models = {primary, secondary, model3};
                primary = new Model(models, 3);
            }
        }
        if(!isFemale && maleOffset != 0) {
            primary.translate(0, maleOffset, 0);
        }
        if(isFemale && femaleOffset != 0) {
            primary.translate(0, femaleOffset, 0);
        }
        if(originalColours != null) {
            for(int i_8_ = 0; ((originalColours.length > i_8_)); i_8_++) {
                primary.replaceColor(originalColours[i_8_], destColors[i_8_]);
            }
        }
        return primary;

    }


    public ItemDefinition method743(int arg1) {
        if(stackIds != null && arg1 > 1) {
            int i = -1;
            for(int i_9_ = 0; i_9_ < 10; i_9_++) {
                if((arg1 >= stackableAmounts[i_9_]) && stackableAmounts[i_9_] != 0) {
                    i = stackIds[i_9_];
                }
            }
            if(i != -1) {
                return forId(i, 10);
            }
        }
        return this;

    }

    public Model asHeadPiece(boolean female) {
        int primaryId = primaryMaleHeadPiece;
        int secondaryId = secondaryMaleHeadPiece;
        if(female) {
            primaryId = primaryFemaleHeadPiece;
            secondaryId = secondaryFemaleHeadPiece;
        }
        if(primaryId == -1) {
            return null;
        }
        Model primary = Model.getModel(Class8.aCacheIndex_284, primaryId, 0);
        if(secondaryId != -1) {
            Model secondary = Model.getModel(Class8.aCacheIndex_284, secondaryId, 0);
            Model[] models = {primary, secondary};
            primary = new Model(models, 2);
        }
        if(originalColours != null) {
            for(int j = 0; ((originalColours.length > j)); j++) {
                primary.replaceColor(originalColours[j], destColors[j]);
            }
        }
        return primary;

    }

    public void readValue(int opcode, Buffer buffer) {
        if(opcode == 1) {
            inventoryModelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            name = buffer.getRSString();
        } else if(opcode == 4) {
            zoom2d = buffer.getUnsignedShortBE();
        } else if(opcode == 5) {
            xan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 6) {
            yan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            xOffset2d = buffer.getUnsignedShortBE();
            if(xOffset2d > 32767) {
                xOffset2d -= 65536;
            }
        } else if(opcode == 8) {
            yOffset2d = buffer.getUnsignedShortBE();
            if(yOffset2d > 32767) {
                yOffset2d -= 65536;
            }
        } else if(opcode == 10) {
            buffer.getUnsignedShortBE(); // Dummy
        } else if(opcode == 11) {
            stackable = 1;
        } else if(opcode == 12) {
            cost = buffer.getIntBE();
        } else if(opcode == 16) {
            members = true;
        } else if(opcode == 23) {
            maleModel0 = buffer.getUnsignedShortBE();
            maleOffset = buffer.getUnsignedByte();
        } else if(opcode == 24) {
            maleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode == 25) {
            femaleModel0 = buffer.getUnsignedShortBE();
            femaleOffset = buffer.getUnsignedByte();
        } else if(opcode == 26) {
            femaleModel1 = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            groundOptions[-30 + opcode] = buffer.getRSString();
            if(groundOptions[opcode + -30].equalsIgnoreCase(English.hidden)) {
                groundOptions[opcode + -30] = null;
            }
        } else if(opcode >= 35 && opcode < 40) {
            interfaceOptions[opcode + -35] = buffer.getRSString();
        } else if(opcode == 40) {
            int colorCount = buffer.getUnsignedByte();
            destColors = new int[colorCount];
            originalColours = new int[colorCount];
            for(int colorIndex = 0; colorIndex < colorCount; colorIndex++) {
                originalColours[colorIndex] = buffer.getUnsignedShortBE();
                destColors[colorIndex] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 78) {
            maleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 79) {
            femaleModel2 = buffer.getUnsignedShortBE();
        } else if(opcode == 90) {
            primaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 91) {
            primaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 92) {
            secondaryMaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 93) {
            secondaryFemaleHeadPiece = buffer.getUnsignedShortBE();
        } else if(opcode == 95) {
            zan2d = (buffer.getUnsignedShortBE());
        } else if(opcode == 97) {
            notedId = (buffer.getUnsignedShortBE());
        } else if(opcode == 98) {
            noteTemplateId = (buffer.getUnsignedShortBE());
        } else if(opcode >= 100 && opcode < 110) {
            if(stackIds == null) {
                stackableAmounts = new int[10];
                stackIds = new int[10];
            }
            stackIds[-100 + opcode] = (buffer.getUnsignedShortBE());
            stackableAmounts[-100 + opcode] = (buffer.getUnsignedShortBE());
        } else if(opcode == 110) {
            groundScaleX = (buffer.getUnsignedShortBE());
        } else if(opcode == 111) {
            groundScaleY = (buffer.getUnsignedShortBE());
        } else if(opcode == 112) {
            groundScaleZ = (buffer.getUnsignedShortBE());
        } else if(opcode == 113) {
            ambient = (buffer.getByte());
        } else if(opcode == 114) {
            contrast = ((buffer.getByte()) * 5);
        } else if(opcode == 115) {
            teamIndex = buffer.getUnsignedByte();
        }
    }

    public void readValues(Buffer itemDefinitionBuffer) {
        while(true) {
            int opcode = itemDefinitionBuffer.getUnsignedByte();
            if(opcode == 0) {
                break;
            }
            readValue(opcode, itemDefinitionBuffer);
        }
    }

    public void itemToNote(ItemDefinition noteTemplate, ItemDefinition note) {
        xan2d = noteTemplate.xan2d;
        xOffset2d = noteTemplate.xOffset2d;
        zan2d = noteTemplate.zan2d;
        name = note.name;
        cost = note.cost;
        stackable = 1;
        zoom2d = noteTemplate.zoom2d;
        members = note.members;
        destColors = noteTemplate.destColors;
        originalColours = noteTemplate.originalColours;
        yan2d = noteTemplate.yan2d;
        yOffset2d = noteTemplate.yOffset2d;
        inventoryModelId = noteTemplate.inventoryModelId;
    }

    public Model asGroundStack(boolean arg0, int amount) {
        if(stackIds != null && amount > 1) {
            int id = -1;
            for(int i = 0; i < 10; i++) {
                if(amount >= stackableAmounts[i] && stackableAmounts[i] != 0) {
                    id = stackIds[i];
                }
            }
            if(id != -1) {
                return forId(id, 10).asGroundStack(arg0, 1);
            }
        }
        Model model = ((Model) MouseHandler.modelCache.get(id, (byte) 87));
        if(model != null) {
            return model;
        }
        model = Model.getModel(Class8.aCacheIndex_284, inventoryModelId, 0);
        if(model == null) {
            return null;
        }
        if(groundScaleX != 128 || groundScaleY != 128 || groundScaleZ != 128) {
            model.scaleT(groundScaleX, groundScaleY, groundScaleZ);
        }
        if(originalColours != null) {
            for(int i = 0; i < originalColours.length; i++) {
                model.replaceColor(originalColours[i], destColors[i]);
            }
        }
        if(arg0) {
            model.applyLighting(ambient + 64, 768 + contrast, -50, -10, -50, true);
            model.singleTile = true;
            MouseHandler.modelCache.put(id, model);
        }
        return model;

    }

    @Override
    public RSString getName() {
        return name;
    }
}
