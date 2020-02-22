package com.jagex.runescape;

import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

import java.awt.*;

public class ItemDefinition extends SubNode {
    public static int anInt2797;
    public static int anInt2798 = 0;
    public static int anInt2801;
    public static int anInt2802;
    public static int anInt2808;
    public static int anInt2809;
    public static int anInt2811;
    public static int[] anIntArray2814;
    public static int anInt2815;
    public static int anInt2826;
    public static int anInt2832;
    public static int anInt2835;
    public static int anInt2837;
    public static int anInt2838;
    public static int anInt2839;
    public static int anInt2842;
    public static int anInt2843;
    public static int anInt2846;
    public static int anInt2847;
    public static int anInt2850;
    public static int anInt2854;

    static {
        anInt2797 = 0;
        anIntArray2814 = new int[50];
        anInt2850 = -1;
    }

    public int stackable;
    public RSString name;
    public RSString[] inventoryOptions;
    public int anInt2800 = -1;
    public int[] modifiedModelColors;
    public RSString[] groundOptions;
    public int inventoryModelId;
    public int modelOffset1;
    public int noteTemplateId;
    public int modelOffset2;
    public int notedId;
    public int anInt2813;
    public int[] originalModelColors;
    public int modelZoom;
    public int anInt2818;
    public int femaleWearModel2;
    public int femaleWearModel1;
    public int anInt2822;
    public int teamIndex;
    public int colorEquip1;
    public int anInt2825;
    public int anInt2827;
    public int value;
    public int anInt2829;
    public int modelRotation2;
    public int[] stackableIds;
    public int anInt2833;
    public int[] stackableAmounts;
    public int anInt2836;
    public int anInt2840;
    public int anInt2841;
    public int modelRotation1;
    public int colorEquip2;
    public int anInt2848;
    public boolean members;
    public int anInt2851;
    public int anInt2852;
    public int anInt2853;

    public ItemDefinition() {
        inventoryOptions = new RSString[]{null, null, null, null, Cache.dropStringInstance};
        stackable = 0;
        anInt2818 = 0;
        name = Class61.aClass1_1437;
        modelOffset2 = 0;
        value = 1;
        modelOffset1 = 0;
        anInt2829 = 0;
        anInt2825 = 0;
        femaleWearModel1 = -1;
        modelRotation2 = 0;
        groundOptions = new RSString[]{null, null, Class27.takeStringInstance, null, null};
        anInt2813 = 128;
        noteTemplateId = -1;
        anInt2822 = -1;
        modelZoom = 2000;
        colorEquip1 = -1;
        teamIndex = 0;
        anInt2827 = 0;
        anInt2840 = 0;
        femaleWearModel2 = -1;
        colorEquip2 = -1;
        modelRotation1 = 0;
        anInt2833 = 128;
        anInt2841 = -1;
        anInt2848 = -1;
        members = false;
        anInt2851 = -1;
        anInt2853 = 128;
        notedId = -1;
        anInt2836 = -1;
    }

    public static void method742(int arg0) {
        try {
            Graphics graphics = Class62.aCanvas1469.getGraphics();
            Landscape.aClass68_1185.method1044(arg0 ^ arg0, 0, graphics, 4);
            Class40_Sub5_Sub1.aClass68_2275.method1044(arg0 + -205, 0, graphics, 357);
            Class39.aClass68_908.method1044(0, 722, graphics, 4);
            GameObject.aClass68_3045.method1044(arg0 + -205, 743, graphics, 205);
            Class40_Sub5_Sub17_Sub6.aClass68_3243.method1044(0, 0, graphics, 0);
            Class40_Sub7.aClass68_2123.method1044(0, 516, graphics, 4);
            Class61.aClass68_1441.method1044(0, 516, graphics, 205);
            Class30.aClass68_714.method1044(0, 496, graphics, 357);
            Class17.aClass68_462.method1044(0, 0, graphics, 338);
        } catch(Exception exception) {
            Class62.aCanvas1469.repaint();
        }
        anInt2808++;
    }

    public static void method744() {
        anInt2839++;
        if(Class59.aClass54_1392 != null) {
            synchronized(Class59.aClass54_1392) {
                Class59.aClass54_1392 = null;
            }
        }
    }

    public static void method745() {
        anIntArray2814 = null;
    }

    public static boolean method746(Class40_Sub5_Sub12 arg1) {
        anInt2838++;
        if(arg1.anIntArray2742 == null) {
            return false;
        }
        for(int i = 0; arg1.anIntArray2742.length > i; i++) {
            int i_10_ = Class66.method1029(i, false, arg1);
            int i_11_ = arg1.anIntArray2693[i];
            if((arg1.anIntArray2742[i] ^ 0xffffffff) == -3) {
                if((i_11_ ^ 0xffffffff) >= (i_10_ ^ 0xffffffff)) {
                    return false;
                }
            } else if((arg1.anIntArray2742[i] ^ 0xffffffff) == -4) {
                if((i_11_ ^ 0xffffffff) <= (i_10_ ^ 0xffffffff)) {
                    return false;
                }
            } else if((arg1.anIntArray2742[i] ^ 0xffffffff) == -5) {
                if(i_11_ == i_10_) {
                    return false;
                }
            } else if((i_11_ ^ 0xffffffff) != (i_10_ ^ 0xffffffff)) {
                return false;
            }
        }
        return true;
    }

    public static void method748(int arg1) {
        anInt2843++;
        for(Renderable.anInt2866 += arg1; (Renderable.anInt2866 >= CollisionMap.anInt141); Renderable.anInt2866 -= CollisionMap.anInt141) {
            SubNode.anInt2081 -= SubNode.anInt2081 >> -1244591038;
        }
        SubNode.anInt2081 -= 1000 * arg1;
        if((SubNode.anInt2081 ^ 0xffffffff) > -1) {
            SubNode.anInt2081 = 0;
        }
    }

    public static void method749(boolean arg0) {
        for(int i = 0; GameObjectDefinition.anInt2558 > i; i++) {
            Npc npc = (Class6_Sub1.aClass40_Sub5_Sub17_Sub4_Sub2Array1813[Class40_Sub3.anIntArray2016[i]]);
            int i_15_ = (536870912 + (Class40_Sub3.anIntArray2016[i] << 1399377262));
            if(npc != null && npc.method784(1) && !arg0 != (npc.aClass40_Sub5_Sub5_3300.hasRenderPriority) && npc.aClass40_Sub5_Sub5_3300.method571(-1)) {
                int i_16_ = (npc.anInt3098 >> -1699335129);
                int i_17_ = npc.anInt3089 >> 698755175;
                if((i_16_ ^ 0xffffffff) <= -1 && (i_16_ ^ 0xffffffff) > -105 && (i_17_ ^ 0xffffffff) <= -1 && i_17_ < 104) {
                    if((npc.anInt3096 ^ 0xffffffff) == -2 && (npc.anInt3098 & 0x7f ^ 0xffffffff) == -65 && ((npc.anInt3089 & 0x7f) == 64)) {
                        if((Class40_Sub5_Sub11.anInt2628 ^ 0xffffffff) == (Class61.anIntArrayArray1435[i_16_][i_17_] ^ 0xffffffff)) {
                            continue;
                        }
                        Class61.anIntArrayArray1435[i_16_][i_17_] = Class40_Sub5_Sub11.anInt2628;
                    }
                    if(!npc.aClass40_Sub5_Sub5_3300.isClickable) {
                        i_15_ += -2147483648;
                    }
                    Npc.aScene_3301.method134(Player.anInt3267, npc.anInt3098, npc.anInt3089, (Class37.method430((byte) -126, Player.anInt3267, (npc.anInt3098 + ((-1 + npc.anInt3096) * 64)), (npc.anInt3096 * 64 + (-64 + (npc.anInt3089))))), -64 + (npc.anInt3096 * 64 + 60), npc, npc.anInt3118, i_15_, npc.aBoolean3105);
                }
            }
        }
        anInt2811++;
    }

    public static ItemDefinition forId(int arg0, int arg1) {
        ItemDefinition definition = ((ItemDefinition) ISAAC.aClass9_516.method231((long) arg0, (byte) 100));
        if(definition != null) {
            return definition;
        }
        byte[] is = Class26.aClass6_632.method172(arg0, 112, arg1);
        definition = new ItemDefinition();
        definition.anInt2852 = arg0;
        if(is != null) {
            definition.readValues(new Buffer(is));
        }
        definition.method741();
        if(definition.noteTemplateId != -1) {
            definition.itemToNote(forId(definition.noteTemplateId, 10), forId(definition.notedId, 10));
        }
        if(!Class40_Sub5_Sub10.membersServer && definition.members) {
            definition.inventoryOptions = null;
            definition.teamIndex = 0;
            definition.groundOptions = null;
            definition.name = Class40_Sub5_Sub17_Sub3.aClass1_3069;
        }
        ISAAC.aClass9_516.method230(arg1 + -7218, (long) arg0, definition);
        return definition;
    }

    public boolean method738(byte arg0, boolean arg1) {
        anInt2832++;
        if(arg0 != 44) {
            inventoryOptions = null;
        }
        int i = anInt2800;
        int i_0_ = anInt2841;
        if(arg1) {
            i_0_ = anInt2822;
            i = anInt2851;
        }
        if(i == -1) {
            return true;
        }
        boolean bool = true;
        if(!Class8.aClass6_284.method173(i, (byte) -10, 0)) {
            bool = false;
        }
        if(i_0_ != -1 && !Class8.aClass6_284.method173(i_0_, (byte) -10, 0)) {
            bool = false;
        }
        return bool;
    }

    public boolean method739(boolean arg0, byte arg1) {
        anInt2826++;
        int i = anInt2836;
        int i_1_ = femaleWearModel1;
        int i_2_ = colorEquip1;
        if(arg0) {
            i_2_ = colorEquip2;
            i_1_ = femaleWearModel2;
            i = anInt2848;
        }
        if((i ^ 0xffffffff) == 0) {
            return true;
        }
        boolean bool = true;
        if(arg1 <= 126) {
            return false;
        }
        if(!Class8.aClass6_284.method173(i, (byte) -10, 0)) {
            bool = false;
        }
        if(i_1_ != -1 && !Class8.aClass6_284.method173(i_1_, (byte) -10, 0)) {
            bool = false;
        }
        if(i_2_ != -1 && !Class8.aClass6_284.method173(i_2_, (byte) -10, 0)) {
            bool = false;
        }
        return bool;
    }

    public Model method740(boolean arg0, int arg1) {
        anInt2837++;
        int i = anInt2836;
        int i_3_ = femaleWearModel1;
        int i_4_ = 11 / ((arg1 - 35) / 56);
        int i_5_ = colorEquip1;
        if(arg0) {
            i = anInt2848;
            i_3_ = femaleWearModel2;
            i_5_ = colorEquip2;
        }
        if(i == -1) {
            return null;
        }
        Model model1 = Model.getModel(Class8.aClass6_284, i, 0);
        if(i_3_ != -1) {
            Model model2 = Model.getModel(Class8.aClass6_284, i_3_, 0);
            if(i_5_ == -1) {
                Model[] models = {model1, model2};
                model1 = new Model(models, 2);
            } else {
                Model model3 = Model.getModel(Class8.aClass6_284, i_5_, 0);
                Model[] models = {model1, model2, model3};
                model1 = new Model(models, 3);
            }
        }
        if(!arg0 && (anInt2818 ^ 0xffffffff) != -1) {
            model1.method828(0, anInt2818, 0);
        }
        if(arg0 && anInt2829 != 0) {
            model1.method828(0, anInt2829, 0);
        }
        if(modifiedModelColors != null) {
            for(int i_8_ = 0; ((modifiedModelColors.length ^ 0xffffffff) < (i_8_ ^ 0xffffffff)); i_8_++) {
                model1.method803(modifiedModelColors[i_8_], originalModelColors[i_8_]);
            }
        }
        return model1;

    }

    public void method741() {
        anInt2801++;
    }

    public ItemDefinition method743(int arg1) {
        anInt2809++;
        if(stackableIds != null && (arg1 ^ 0xffffffff) < -2) {
            int i = -1;
            for(int i_9_ = 0; (i_9_ ^ 0xffffffff) > -11; i_9_++) {
                if((arg1 ^ 0xffffffff) <= (stackableAmounts[i_9_] ^ 0xffffffff) && (stackableAmounts[i_9_] ^ 0xffffffff) != -1) {
                    i = stackableIds[i_9_];
                }
            }
            if((i ^ 0xffffffff) != 0) {
                return forId(i, 10);
            }
        }
        return this;

    }

    public Model method747(boolean arg0, byte arg1) {
        int i = anInt2800;
        int i_12_ = anInt2841;
        if(arg1 != 25) {
            return null;
        }
        anInt2847++;
        if(arg0) {
            i = anInt2851;
            i_12_ = anInt2822;
        }
        if(i == -1) {
            return null;
        }
        Model model1 = Model.getModel(Class8.aClass6_284, i, 0);
        if(i_12_ != -1) {
            Model model2 = Model.getModel(Class8.aClass6_284, i_12_, 0);
            Model[] models = {model1, model2};
            model1 = new Model(models, 2);
        }
        if(modifiedModelColors != null) {
            for(int j = 0; ((modifiedModelColors.length ^ 0xffffffff) < (j ^ 0xffffffff)); j++) {
                model1.method803(modifiedModelColors[j], originalModelColors[j]);
            }
        }
        return model1;

    }

    public void readValue(int opcode, Buffer buffer) {
        if(opcode == 1) {
            inventoryModelId = buffer.getUnsignedShortBE();
        } else if(opcode == 2) {
            name = buffer.getRSString();
        } else if(opcode == 4) {
            modelZoom = buffer.getUnsignedShortBE();
        } else if(opcode == 5) {
            modelRotation1 = buffer.getUnsignedShortBE();
        } else if(opcode == 6) {
            modelRotation2 = buffer.getUnsignedShortBE();
        } else if(opcode == 7) {
            modelOffset1 = buffer.getUnsignedShortBE();
            if(modelOffset1 > 32767) {
                modelOffset1 -= 65536;
            }
        } else if(opcode == 8) {
            modelOffset2 = buffer.getUnsignedShortBE();
            if(modelOffset2 > 32767) {
                modelOffset2 -= 65536;
            }
        } else if(opcode == 11) {
            stackable = 1;
        } else if(opcode == 12) {
            value = buffer.getIntBE();
        } else if(opcode == 16) {
            members = true;
        } else if(opcode == 23) {
            anInt2836 = buffer.getUnsignedShortBE();
            anInt2818 = buffer.getUnsignedByte();
        } else if(opcode == 24) {
            femaleWearModel1 = buffer.getUnsignedShortBE();
        } else if(opcode == 25) {
            anInt2848 = buffer.getUnsignedShortBE();
            anInt2829 = buffer.getUnsignedByte();
        } else if(opcode == 26) {
            femaleWearModel2 = buffer.getUnsignedShortBE();
        } else if(opcode >= 30 && opcode < 35) {
            groundOptions[-30 + opcode] = buffer.getRSString();
            if(groundOptions[opcode + -30].equalsIgnoreCase(Class59.string_Hidden, true)) {
                groundOptions[opcode + -30] = null;
            }
        } else if(opcode >= 35 && opcode < 40) {
            inventoryOptions[opcode + -35] = buffer.getRSString();
        } else if(opcode == 40) {
            int colorCount = buffer.getUnsignedByte();
            originalModelColors = new int[colorCount];
            modifiedModelColors = new int[colorCount];
            for(int colorIndex = 0; colorIndex < colorCount; colorIndex++) {
                modifiedModelColors[colorIndex] = buffer.getUnsignedShortBE();
                originalModelColors[colorIndex] = buffer.getUnsignedShortBE();
            }
        } else if(opcode == 78) {
            colorEquip1 = buffer.getUnsignedShortBE();
        } else if(opcode == 79) {
            colorEquip2 = buffer.getUnsignedShortBE();
        } else if(opcode == 90) {
            anInt2800 = buffer.getUnsignedShortBE();
        } else if(opcode == 91) {
            anInt2851 = buffer.getUnsignedShortBE();
        } else if(opcode == 92) {
            anInt2841 = buffer.getUnsignedShortBE();
        } else if(opcode == 93) {
            anInt2822 = buffer.getUnsignedShortBE();
        } else if(opcode == 95) {
            anInt2827 = (buffer.getUnsignedShortBE());
        } else if(opcode == 97) {
            notedId = (buffer.getUnsignedShortBE());
        } else if(opcode == 98) {
            noteTemplateId = (buffer.getUnsignedShortBE());
        } else if(opcode >= 100 && opcode < 110) {
            if(stackableIds == null) {
                stackableAmounts = new int[10];
                stackableIds = new int[10];
            }
            stackableIds[-100 + opcode] = (buffer.getUnsignedShortBE());
            stackableAmounts[-100 + opcode] = (buffer.getUnsignedShortBE());
        } else if(opcode == 110) {
            anInt2813 = (buffer.getUnsignedShortBE());
        } else if(opcode == 111) {
            anInt2853 = (buffer.getUnsignedShortBE());
        } else if(opcode == 112) {
            anInt2833 = (buffer.getUnsignedShortBE());
        } else if(opcode == 113) {
            anInt2825 = (buffer.getByte());
        } else if(opcode == 114) {
            anInt2840 = ((buffer.getByte()) * 5);
        } else if(opcode == 115) {
            teamIndex = buffer.getUnsignedByte();
        }
        anInt2802++;
    }

    public void readValues(Buffer itemDefinitionBuffer) {
        for(; ; ) {
            int opcode = itemDefinitionBuffer.getUnsignedByte();
            if((opcode ^ 0xffffffff) == -1) {
                break;
            }
            readValue(opcode, itemDefinitionBuffer);
        }
    }

    public void itemToNote(ItemDefinition noteTemplate, ItemDefinition note) {
        modelRotation1 = noteTemplate.modelRotation1;
        modelOffset1 = noteTemplate.modelOffset1;
        anInt2827 = noteTemplate.anInt2827;
        name = note.name;
        anInt2835++;
        value = note.value;
        stackable = 1;
        modelZoom = noteTemplate.modelZoom;
        members = note.members;
        originalModelColors = noteTemplate.originalModelColors;
        modifiedModelColors = noteTemplate.modifiedModelColors;
        modelRotation2 = noteTemplate.modelRotation2;
        modelOffset2 = noteTemplate.modelOffset2;
        inventoryModelId = noteTemplate.inventoryModelId;
    }

    public Model method753(boolean arg0, int arg1, int arg2) {
        if(arg2 != 26910) {
            anIntArray2814 = null;
        }
        anInt2842++;
        if(stackableIds != null && arg1 > 1) {
            int i = -1;
            for(int i_19_ = 0; (i_19_ ^ 0xffffffff) > -11; i_19_++) {
                if(arg1 >= stackableAmounts[i_19_] && (stackableAmounts[i_19_] ^ 0xffffffff) != -1) {
                    i = stackableIds[i_19_];
                }
            }
            if(i != -1) {
                return forId(i, 10).method753(arg0, 1, 26910);
            }
        }
        if(arg0) {
            Model model = ((Model) Class62.aClass9_1455.method231((long) anInt2852, (byte) 87));
            if(model != null) {
                return model;
            }
        }
        Model model = Model.getModel(Class8.aClass6_284, inventoryModelId, 0);
        if(model == null) {
            return null;
        }
        if((anInt2813 ^ 0xffffffff) != -129 || anInt2853 != 128 || anInt2833 != 128) {
            model.method821(anInt2813, anInt2853, anInt2833);
        }
        if(modifiedModelColors != null) {
            for(int i = 0; i < modifiedModelColors.length; i++) {
                model.method803(modifiedModelColors[i], originalModelColors[i]);
            }
        }
        if(arg0) {
            model.method802(anInt2825 + 64, 768 + anInt2840, -50, -10, -50, true);
            model.aBoolean3164 = true;
            Class62.aClass9_1455.method230(-7208, (long) anInt2852, model);
        }
        return model;

    }
}
