package org.runejs.client.cache.def;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.node.CachedNode;
import org.runejs.client.*;
import org.runejs.client.node.NodeCache;

public class ItemDefinition extends CachedNode implements EntityDefinition {
    public static int count;
    private static CacheArchive definitionArchive;
    private static NodeCache definitionCache = new NodeCache(64);
    private static NodeCache modelCache = new NodeCache(50);
    private static NodeCache imageCache = new NodeCache(100);
    private static CacheArchive modelArchive;

    public int stackable;
    public String name;
    public String[] interfaceOptions;
    public int primaryMaleHeadPiece = -1;
    public int[] originalColours;
    public String[] groundOptions;
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
        interfaceOptions = new String[]{null, null, null, null, English.drop};
        stackable = 0;
        maleOffset = 0;
        name = "null";
        yOffset2d = 0;
        cost = 1;
        xOffset2d = 0;
        femaleOffset = 0;
        ambient = 0;
        maleModel1 = -1;
        yan2d = 0;
        groundOptions = new String[]{null, null, English.take, null, null};
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


    public static ItemDefinition forId(int id, int arg1) {
        ItemDefinition definition = (ItemDefinition) definitionCache.get(id);
        if(definition != null) {
            return definition;
        }
        byte[] is = definitionArchive.getFile(arg1, id);
        definition = new ItemDefinition();
        definition.id = id;
        if(is != null) {
            definition.readValues(new Buffer(is));
        }
        if(definition.noteTemplateId != -1) {
            definition.itemToNote(forId(definition.noteTemplateId, 10), forId(definition.notedId, 10));
        }
        if(!MovedStatics.membersServer && definition.members) {
            definition.interfaceOptions = null;
            definition.teamIndex = 0;
            definition.groundOptions = null;
            definition.name = English.membersObject;
        }
        definitionCache.put(id, definition);
        return definition;
    }

    public static ImageRGB sprite(int stackSize, int id, int backColour) {
        if(backColour == 0) {
            ImageRGB sprite = (ImageRGB) imageCache.get((long) id);
            if(sprite != null && sprite.maxHeight != stackSize && sprite.maxHeight != -1) {
                sprite.unlink();
                sprite = null;
            }
            if(sprite != null)
                return sprite;
        }
        ItemDefinition definition = forId(id, 10);
        if(definition.stackIds == null)
            stackSize = -1;
        if(stackSize > 1) {
            int stackId = -1;
            for(int i = 0; i < 10; i++) {
                if(stackSize >= definition.stackableAmounts[i] && definition.stackableAmounts[i] != 0)
                    stackId = definition.stackIds[i];
            }
            if(stackId != -1)
                definition = forId(stackId, 10);
        }
        Model model = definition.asGroundStack(true, 1);
        if(model == null)
            return null;
        ImageRGB notedSprite = null;
        if(definition.noteTemplateId != -1) {
            notedSprite = sprite(10, definition.notedId, -1);
            if(notedSprite == null)
                return null;
        }
        int[] pixels = Rasterizer.destinationPixels;
        int i = Rasterizer.destinationHeight;
        int i_1_ = Rasterizer.destinationWidth;
        int i_2_ = Rasterizer.viewportLeft;
        int i_4_ = Rasterizer.viewportRight;
        int i_5_ = Rasterizer.viewportTop;
        int i_6_ = Rasterizer.viewportBottom;
        int[] lineOffsets = Rasterizer3D.getLineOffsets();
        int i_8_ = Rasterizer3D.bottomY;
        int i_9_ = Rasterizer3D.viewportRx;
        ImageRGB rendered = new ImageRGB(32, 32);
        Rasterizer.prepare(rendered.pixels, 32, 32);
        MovedStatics.anIntArray3253 = Rasterizer3D.setLineOffsets(MovedStatics.anIntArray3253);
        Rasterizer.drawFilledRectangle(0, 0, 32, 32, 0);
        int i_11_ = definition.zoom2d;
        if(backColour == -1)
            i_11_ *= 1.5;
        if(backColour > 0)
            i_11_ *= 1.04;
        Rasterizer3D.notTextured = false;
        int i_12_ = Rasterizer3D.sinetable[definition.xan2d] * i_11_ >> 16;
        int i_13_ = i_11_ * Rasterizer3D.cosinetable[definition.xan2d] >> 16;
        model.method799();
        model.drawModel(0, definition.yan2d, definition.zan2d, definition.xan2d, definition.xOffset2d, definition.yOffset2d + model.modelHeight / 2 + i_12_, i_13_ + definition.yOffset2d);
        for(int i_14_ = 31; i_14_ >= 0; i_14_--) {
            for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                if(rendered.pixels[i_14_ + 32 * i_13_] == 0) {
                    if(i_14_ > 0 && rendered.pixels[i_13_ * 32 + -1 + i_14_] > 1)
                        rendered.pixels[i_13_ * 32 + i_14_] = 1;
                    else if(i_13_ > 0 && rendered.pixels[i_14_ + (i_13_ + -1) * 32] > 1)
                        rendered.pixels[i_13_ * 32 + i_14_] = 1;
                    else if(i_14_ < 31 && rendered.pixels[i_13_ * 32 + i_14_ + 1] > 1)
                        rendered.pixels[i_14_ + i_13_ * 32] = 1;
                    else if(i_13_ < 31 && rendered.pixels[(i_13_ + 1) * 32 + i_14_] > 1)
                        rendered.pixels[i_14_ + 32 * i_13_] = 1;
                }
            }
        }
        if(backColour > 0) {
            for(int i_15_ = 31; i_15_ >= 0; i_15_--) {
                for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                    if(rendered.pixels[i_15_ + i_13_ * 32] == 0) {
                        if(i_15_ > 0 && rendered.pixels[32 * i_13_ + -1 + i_15_] == 1)
                            rendered.pixels[i_15_ + i_13_ * 32] = backColour;
                        else if(i_13_ <= 0 || rendered.pixels[i_15_ + (i_13_ + -1) * 32] != 1) {
                            if(i_15_ >= 31 || rendered.pixels[1 + i_15_ + i_13_ * 32] != 1) {
                                if(i_13_ < 31 && rendered.pixels[i_15_ + 32 + 32 * i_13_] == 1)
                                    rendered.pixels[i_13_ * 32 + i_15_] = backColour;
                            } else
                                rendered.pixels[i_15_ + i_13_ * 32] = backColour;
                        } else
                            rendered.pixels[i_15_ + i_13_ * 32] = backColour;
                    }
                }
            }
        } else if(backColour == 0) {
            for(int i_16_ = 31; i_16_ >= 0; i_16_--) {
                for(i_13_ = 31; i_13_ >= 0; i_13_--) {
                    if(rendered.pixels[i_13_ * 32 + i_16_] == 0 && i_16_ > 0 && i_13_ > 0 && rendered.pixels[i_16_ - (1 + -((-1 + i_13_) * 32))] > 0)
                        rendered.pixels[i_16_ + 32 * i_13_] = 3153952;
                }
            }
        }
        if(definition.noteTemplateId != -1) {
            int i_17_ = notedSprite.maxHeight;
            int i_18_ = notedSprite.maxWidth;
            notedSprite.maxHeight = 32;
            notedSprite.maxWidth = 32;
            notedSprite.drawImage(0, 0);
            notedSprite.maxWidth = i_18_;
            notedSprite.maxHeight = i_17_;
        }
        if(backColour == 0)
            imageCache.put((long) id, rendered);
        Rasterizer.prepare(pixels, i_1_, i);
        Rasterizer.setBounds(i_2_, i_5_, i_4_, i_6_);
        Rasterizer3D.setLineOffsets(lineOffsets);
        Rasterizer3D.bottomY = i_8_;
        Rasterizer3D.viewportRx = i_9_;
        Rasterizer3D.resetBoundsTo3dViewport();
        Rasterizer3D.notTextured = true;
        if(definition.stackable == 1)
            rendered.maxWidth = 33;
        else
            rendered.maxWidth = 32;
        rendered.maxHeight = stackSize;
        return rendered;

    }

    public static void clearItemCache() {
        definitionCache.clear();
        modelCache.clear();
        imageCache.clear();
    }

    public static void initializeItemDefinitionCache(CacheArchive definitionCache, boolean arg1, CacheArchive arg2) {
        MovedStatics.membersServer = arg1;
        modelArchive = arg2;
        definitionArchive = definitionCache;
        count = definitionArchive.fileLength(10);
    }

    public static void clearImageCache() {
        imageCache.clear();
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
        if(!modelArchive.loaded(primaryId, 0)) {
            ready = false;
        }
        if(secondaryId != -1 && !modelArchive.loaded(secondaryId, 0)) {
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
        if(!modelArchive.loaded(i, 0)) {
            bool = false;
        }
        if(i_1_ != -1 && !modelArchive.loaded(i_1_, 0)) {
            bool = false;
        }
        if(i_2_ != -1 && !modelArchive.loaded(i_2_, 0)) {
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
        Model primary = Model.getModel(modelArchive, primaryId);
        if(secondaryId != -1) {
            Model secondary = Model.getModel(modelArchive, secondaryId);
            if(tertiaryId == -1) {
                Model[] tertiary = {primary, secondary};
                primary = new Model(tertiary, 2);
            } else {
                Model model3 = Model.getModel(modelArchive, tertiaryId);
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
            for(int i_8_ = 0; originalColours.length > i_8_; i_8_++) {
                primary.replaceColor(originalColours[i_8_], destColors[i_8_]);
            }
        }
        return primary;

    }


    public ItemDefinition method743(int arg1) {
        if(stackIds != null && arg1 > 1) {
            int i = -1;
            for(int i_9_ = 0; i_9_ < 10; i_9_++) {
                if(arg1 >= stackableAmounts[i_9_] && stackableAmounts[i_9_] != 0) {
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
        Model primary = Model.getModel(modelArchive, primaryId);
        if(secondaryId != -1) {
            Model secondary = Model.getModel(modelArchive, secondaryId);
            Model[] models = {primary, secondary};
            primary = new Model(models, 2);
        }
        if(originalColours != null) {
            for(int j = 0; originalColours.length > j; j++) {
                primary.replaceColor(originalColours[j], destColors[j]);
            }
        }
        return primary;

    }

    public void readValue(int opcode, Buffer buffer) {
        if(opcode == 1) {
            inventoryModelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            name = buffer.getString();
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
            groundOptions[-30 + opcode] = buffer.getString();
            if(groundOptions[opcode + -30].equalsIgnoreCase("Hidden")) {
                groundOptions[opcode + -30] = null;
            }
        } else if(opcode >= 35 && opcode < 40) {
            interfaceOptions[opcode + -35] = buffer.getString();
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
            zan2d = buffer.getUnsignedShortBE();
        } else if(opcode == 97) {
            notedId = buffer.getUnsignedShortBE();
        } else if(opcode == 98) {
            noteTemplateId = buffer.getUnsignedShortBE();
        } else if(opcode >= 100 && opcode < 110) {
            if(stackIds == null) {
                stackableAmounts = new int[10];
                stackIds = new int[10];
            }
            stackIds[-100 + opcode] = buffer.getUnsignedShortBE();
            stackableAmounts[-100 + opcode] = buffer.getUnsignedShortBE();
        } else if(opcode == 110) {
            groundScaleX = buffer.getUnsignedShortBE();
        } else if(opcode == 111) {
            groundScaleY = buffer.getUnsignedShortBE();
        } else if(opcode == 112) {
            groundScaleZ = buffer.getUnsignedShortBE();
        } else if(opcode == 113) {
            ambient = buffer.getByte();
        } else if(opcode == 114) {
            contrast = buffer.getByte() * 5;
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
        Model model = (Model) modelCache.get(id);
        if(model != null) {
            return model;
        }
        model = Model.getModel(modelArchive, inventoryModelId);
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
            modelCache.put(id, model);
        }
        return model;

    }

    @Override
    public String getName() {
        return name;
    }
}
