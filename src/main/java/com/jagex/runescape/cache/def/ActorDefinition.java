package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.cache.CacheIndex_Sub1;
import com.jagex.runescape.cache.media.AnimationSequence;
import com.jagex.runescape.cache.media.ImageRGB;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.actor.Actor;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.util.Signlink;
import com.jagex.runescape.util.SignlinkNode;

import java.awt.*;

public class ActorDefinition extends SubNode implements EntityDefinition {
    public static CacheIndex_Sub1 aClass6_Sub1_2377;
    public static int[] anIntArray2386;
    public static int menuActionRow = 0;
    public static RSString aClass1_2401 = RSString.CreateString("Please wait 1 minute and try again)3");
    public static int anInt2404 = 0;
    public static RSString aClass1_2410 = RSString.CreateString("Please wait 1 minute and try again)3");
    public static byte[] aByteArray2416 = new byte[520];
    public static RSString aClass1_2423 = RSString.CreateString("(X100(U(Y");
    public static int openFullScreenWidgetId = -1;
    public static int count;

    public boolean isClickable = true;
    public int boundaryDimension = 1;
    public int[] headModelIndexes;
    public RSString[] options = new RSString[5];
    public int headIcon = -1;
    public int stanceAnimation = -1;
    public int varpIndex = -1;
    public int ambient = 0;
    public int rotateRightAnimation = -1;
    public int degreesToTurn = 32;
    public int combatLevel = -1;
    public int[] originalModelColors;
    public boolean hasRenderPriority = false;
    public RSString name = RSString.CreateString("null");
    public int[] models;
    public int rotate180Animation = -1;
    public int resizeX = 128;
    public int contrast = 0;
    public int varBitId = -1;
    public int rotate90LeftAnimation = -1;
    public int resizeY = 128;
    public int rotate90RightAnimation = -1;
    public int rotateLeftAnimation = -1;
    public int walkAnimation = -1;
    public int[] childrenIds;
    public int id;
    public int[] modifiedModelColors;
    public boolean renderOnMinimap = true;

    public static void method567() {
        if(Class57.aClass64_1345 != null) {
            Class57.aClass64_1345.method1009();
        }
    }

    public static void method569() {
        Class17.anIntArray456 = null;
        GroundItemTile.aByteArrayArray1370 = null;
        Npc.anIntArray3312 = null;
        Actor.anIntArray3111 = null;
        Buffer.anIntArray1972 = null;
        Class57.anIntArray1347 = null;
    }

    public static void method570(int arg0, int arg1, Player player) {
        if(player.playingAnimation == arg0 && arg0 != -1) {
            int i = Class68_Sub1.method1050(arg0, 2).anInt2483;
            if(i == 1) {
                player.anInt3104 = 0;
                player.anInt3095 = 0;
                player.playingAnimationDelay = arg1;
                player.anInt3115 = 0;
            }
            if(i == 2) {
                player.anInt3095 = 0;
            }
        } else if(arg0 == -1 || player.playingAnimation == -1 || (Class68_Sub1.method1050(arg0, 2).anInt2494 >= (Class68_Sub1.method1050(player.playingAnimation, 2).anInt2494))) {
            player.anInt3094 = player.anInt3109;
            player.anInt3104 = 0;
            player.anInt3115 = 0;
            player.anInt3095 = 0;
            player.playingAnimationDelay = arg1;
            player.playingAnimation = arg0;
        }
    }

    public static void method574() {
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            RSString.aClass68_1665.drawGraphics(550, 4, graphics);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static int method576() {
        return 19;
    }

    public static ImageRGB method578() {
        ImageRGB class40_sub5_sub14_sub4 = new ImageRGB();
        class40_sub5_sub14_sub4.maxWidth = ItemDefinition.anInt2846;
        class40_sub5_sub14_sub4.maxHeight = GameShell.anInt31;
        class40_sub5_sub14_sub4.offsetX = Class57.anIntArray1347[0];
        class40_sub5_sub14_sub4.offsetY = Actor.anIntArray3111[0];
        class40_sub5_sub14_sub4.image_width = Class17.anIntArray456[0];
        class40_sub5_sub14_sub4.image_height = Npc.anIntArray3312[0];
        byte[] is = GroundItemTile.aByteArrayArray1370[0];
        int i = (class40_sub5_sub14_sub4.image_width * class40_sub5_sub14_sub4.image_height);
        class40_sub5_sub14_sub4.pixels = new int[i];
        for(int i_5_ = 0; i_5_ < i; i_5_++) {
            class40_sub5_sub14_sub4.pixels[i_5_] = (Buffer.anIntArray1972[HuffmanEncoding.method1021(255, is[i_5_])]);
        }
        method569();
        return class40_sub5_sub14_sub4;
    }

    // run client script???
    public static void method580(Signlink arg0, Buffer arg2) {
        Class40_Sub11 class40_sub11 = new Class40_Sub11();
        class40_sub11.anInt2160 = arg2.getUnsignedByte();
        class40_sub11.anInt2166 = arg2.getIntBE();
        class40_sub11.anIntArray2154 = new int[class40_sub11.anInt2160];
        class40_sub11.aSignlinkNodeArray2157 = new SignlinkNode[class40_sub11.anInt2160];
        class40_sub11.anIntArray2165 = new int[class40_sub11.anInt2160];
        class40_sub11.aByteArrayArrayArray2159 = new byte[class40_sub11.anInt2160][][];
        class40_sub11.aSignlinkNodeArray2156 = new SignlinkNode[class40_sub11.anInt2160];
        class40_sub11.anIntArray2155 = new int[class40_sub11.anInt2160];
        for(int i_6_ = 0; (i_6_ < class40_sub11.anInt2160); i_6_++) {
            try {
                int i_7_ = arg2.getUnsignedByte();
                if(i_7_ == 0 || i_7_ == 1 || i_7_ == 2) {
                    int i_14_ = 0;
                    String string = new String(arg2.getRSString().method80());
                    String string_15_ = new String(arg2.getRSString().method80());
                    if(i_7_ == 1) {
                        i_14_ = arg2.getIntBE();
                    }
                    class40_sub11.anIntArray2154[i_6_] = i_7_;
                    class40_sub11.anIntArray2165[i_6_] = i_14_;
                    class40_sub11.aSignlinkNodeArray2157[i_6_] = arg0.method392(Class26.method349(string), string_15_, true);
                } else if(i_7_ == 3 || i_7_ == 4) {
                    String string = new String(arg2.getRSString().method80());
                    String string_8_ = new String(arg2.getRSString().method80());
                    int i_9_ = arg2.getUnsignedByte();
                    String[] strings = new String[i_9_];
                    for(int i_10_ = 0; i_9_ > i_10_; i_10_++) {
                        strings[i_10_] = new String(arg2.getRSString().method80());
                    }
                    byte[][] is = new byte[i_9_][];
                    if(i_7_ == 3) {
                        for(int i_11_ = 0; ((i_11_ < i_9_)); i_11_++) {
                            int i_12_ = arg2.getIntBE();
                            is[i_11_] = new byte[i_12_];
                            arg2.getBytes(i_12_, 0, is[i_11_]);
                        }
                    }
                    class40_sub11.anIntArray2154[i_6_] = i_7_;
                    Class[] var_classes = new Class[i_9_];
                    for(int i_13_ = 0; (i_13_ < i_9_); i_13_++) {
                        var_classes[i_13_] = Class26.method349(strings[i_13_]);
                    }
                    class40_sub11.aSignlinkNodeArray2156[i_6_] = arg0.method386(var_classes, string_8_, Class26.method349(string), (byte) -64);
                    class40_sub11.aByteArrayArrayArray2159[i_6_] = is;
                }
            } catch(ClassNotFoundException classnotfoundexception) {
                class40_sub11.anIntArray2155[i_6_] = -1;
            } catch(SecurityException securityexception) {
                class40_sub11.anIntArray2155[i_6_] = -2;
            } catch(NullPointerException nullpointerexception) {
                class40_sub11.anIntArray2155[i_6_] = -3;
            } catch(Exception exception) {
                class40_sub11.anIntArray2155[i_6_] = -4;
            } catch(Throwable throwable) {
                class40_sub11.anIntArray2155[i_6_] = -5;
            }
        }
        KeyFocusListener.aLinkedList_1278.pushBack(class40_sub11, 92);
    }

    public static void method581() {
        anIntArray2386 = null;
        aClass6_Sub1_2377 = null;
        English.unexpectedServerResponse = null;
        English.checkingForUpdates = null;
        aClass1_2423 = null;
        aClass1_2410 = null;
        aByteArray2416 = null;
        aClass1_2401 = null;
        English.loadedFonts = null;
        English.moderatorOptionMutePlayerFor48HoursON = null;
    }

    public static ActorDefinition getDefinition(int id) {
        ActorDefinition definition = ((ActorDefinition) ISAAC.aClass9_510.get(id, (byte) 119));
        if(definition != null)
            return definition;
        byte[] data = GroundItemTile.aCacheIndex_1375.getFile(id, 9);
        definition = new ActorDefinition();
        definition.id = id;
        if(data != null)
            definition.readValues(new Buffer(data));
        ISAAC.aClass9_510.put(id, definition);
        return definition;
    }

    public Model getChildModel(AnimationSequence arg1, AnimationSequence arg2, int arg3, int arg4) {
        if(childrenIds != null) {
            ActorDefinition class40_sub5_sub5 = getChildDefinition(-1);
            if(class40_sub5_sub5 == null) {
                return null;
            }
            return class40_sub5_sub5.getChildModel(arg1, arg2, arg3, arg4);
        }
        Model class40_sub5_sub17_sub5 = ((Model) Class67.aClass9_1611.get(id, (byte) 75));
        if(class40_sub5_sub17_sub5 == null) {
            boolean bool = false;
            for(int model : models) {
                if(!Class67.aCacheIndex_1577.loaded(model, 0)) {
                    bool = true;
                }
            }
            if(bool) {
                return null;
            }
            Model[] class40_sub5_sub17_sub5s = new Model[models.length];
            for(int i = 0; models.length > i; i++) {
                class40_sub5_sub17_sub5s[i] = Model.getModel((Class67.aCacheIndex_1577), models[i], 0);
            }
            if(class40_sub5_sub17_sub5s.length == 1) {
                class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5s[0];
            } else {
                class40_sub5_sub17_sub5 = (new Model(class40_sub5_sub17_sub5s, class40_sub5_sub17_sub5s.length));
            }
            if(modifiedModelColors != null) {
                for(int i = 0; (i < modifiedModelColors.length); i++) {
                    assert class40_sub5_sub17_sub5 != null;
                    class40_sub5_sub17_sub5.replaceColor(modifiedModelColors[i], originalModelColors[i]);
                }
            }
            assert class40_sub5_sub17_sub5 != null;
            class40_sub5_sub17_sub5.createBones();
            class40_sub5_sub17_sub5.applyLighting(ambient + 64, 850 + contrast, -30, -50, -30, true);
            Class67.aClass9_1611.put(id, class40_sub5_sub17_sub5);
        }
        Model class40_sub5_sub17_sub5_0_;
        if(arg1 != null && arg2 != null) {
            class40_sub5_sub17_sub5_0_ = arg1.method590(class40_sub5_sub17_sub5, arg2, arg4, arg3, (byte) 63);
        } else if(arg1 != null) {
            class40_sub5_sub17_sub5_0_ = arg1.method599(arg4, class40_sub5_sub17_sub5, false);
        } else if(arg2 == null) {
            class40_sub5_sub17_sub5_0_ = class40_sub5_sub17_sub5.method817(true);
        } else {
            class40_sub5_sub17_sub5_0_ = arg2.method599(arg3, class40_sub5_sub17_sub5, false);
        }
        if(resizeX != 128 || resizeY != 128) {
            class40_sub5_sub17_sub5_0_.scaleT(resizeX, resizeY, resizeX);
        }
        return class40_sub5_sub17_sub5_0_;

    }

    public boolean method571(int arg0) {
        if(childrenIds == null) {
            return true;
        }
        int i = arg0;
        if(varBitId != -1) {
            i = Class40_Sub5_Sub6.method585(varBitId, 1369);
        } else if(varpIndex != -1) {
            i = GroundItemTile.varbitmasks[varpIndex];
        }
        return i >= 0 && childrenIds.length > i && childrenIds[i] != -1;
    }

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            models = new int[length];
            for(int idx = 0; idx < length; ++idx) {
                models[idx] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 2) {
            name = buffer.getRSString();
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
            options[opcode - 30] = buffer.getRSString();
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
            contrast = (buffer.getByte()) * 5;
        } else if(opcode == 102) {
            headIcon = (buffer.getUnsignedShortBE());
        } else if(opcode == 103) {
            degreesToTurn = (buffer.getUnsignedShortBE());
        } else if(opcode == 106) {
            varBitId = (buffer.getUnsignedShortBE());
            if(varBitId == 65535) {
                varBitId = -1;
            }
            varpIndex = (buffer.getUnsignedShortBE());
            if(varpIndex == 65535) {
                varpIndex = -1;
            }
            int childrenCount = (buffer.getUnsignedByte());
            childrenIds = new int[childrenCount + 1];
            for(int idx = 0; childrenCount >= idx; idx++) {
                childrenIds[idx] = (buffer.getUnsignedShortBE());
                if(childrenIds[idx] == 0xFFFF) {
                    childrenIds[idx] = -1;
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
        if(childrenIds != null) {
            ActorDefinition definition = getChildDefinition(-1);
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
            if(!Class67.aCacheIndex_1577.loaded(headModelIndex, 0)) {
                cached = true;
            }
        }
        if(cached) {
            return null;
        }
        Model[] models = new Model[headModelIndexes.length];
        for(int i = 0; i < headModelIndexes.length; i++) {
            models[i] = Model.getModel(Class67.aCacheIndex_1577, headModelIndexes[i], 0);
        }
        Model headModel;
        if(models.length == 1) {
            headModel = models[0];
        } else {
            headModel = (new Model(models, models.length));
        }
        if(modifiedModelColors != null) {
            for(int i = 0; i < modifiedModelColors.length; i++) {
                assert headModel != null;
                headModel.replaceColor(modifiedModelColors[i], originalModelColors[i]);
            }
        }
        return headModel;
    }

    public ActorDefinition getChildDefinition(int arg0) {
        int childId = arg0;
        if(varBitId != -1) {
            childId = Class40_Sub5_Sub6.method585(varBitId, 1369);
        } else if(varpIndex != -1) {
            childId = GroundItemTile.varbitmasks[varpIndex];
        }
        if(childId < 0 || childId >= childrenIds.length || childrenIds[childId] == -1) {
            return null;
        }
        return getDefinition(childrenIds[childId]);
    }

    @Override
    public RSString getName() {
        return name;
    }
}
