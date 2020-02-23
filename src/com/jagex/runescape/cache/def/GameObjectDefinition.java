package com.jagex.runescape.cache.def;

import com.jagex.runescape.*;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.media.renderable.Model;

public class GameObjectDefinition extends SubNode {
    public static Class68 aClass68_2524;
    public static RSString aClass1_2526 = RSString.CreateString("(Udns");
    public static int anInt2543 = 0;
    public static HashTable aClass23_2545 = new HashTable(4096);
    public static RSString aClass1_2556 = RSString.CreateString("blaugr-Un:");
    public static int chatboxScroll = 0;
    public static int anInt2558 = 0;
    public static int lastClickY = 0;
    public static RSString aClass1_2560 = RSString.CreateString(": ");
    public static long aLong2561 = 0L;

    public int anInt2499;
    public int offsetX;
    public boolean solid;
    public int anInt2502;
    public int sizeX;
    public int offsetY;
    public int offsetAmplifier;
    public int animationId;
    public int modelSizeX;
    public RSString[] actions;
    public int[] recolorToReplace;
    public int icon = -1;
    public int anInt2512;
    public int anInt2513;
    public int sizeY;
    public int[] recolorToFind;
    public int modelSizeY;
    public boolean isSolid;
    public int offsetHeight;
    public boolean nonFlatShading;
    public boolean wall;
    public int[] objectTypes;
    public int[] anIntArray2523;
    public int[] objectModels;
    public int ambient;
    public boolean walkable;
    public boolean adjustToTerrain;
    public int anInt2533;
    public int[] configChangeDest;
    public int configId;
    public int mapSceneID;
    public int anInt2538;
    public int modelSizeHeight;
    public boolean castsShadow;
    public int anInt2542;
    public int contrast;
    public int hasActions;
    public boolean unknown;
    public int varpID;
    public RSString name;
    public boolean unknown3;

    public GameObjectDefinition() {
        anInt2502 = 0;
        anInt2512 = 0;
        anInt2513 = -1;
        anInt2499 = 0;
        offsetX = 0;
        modelSizeX = 128;
        isSolid = false;
        wall = false;
        adjustToTerrain = false;
        anInt2533 = -1;
        animationId = -1;
        offsetAmplifier = 16;
        actions = new RSString[5];
        offsetHeight = 0;
        solid = true;
        sizeY = 1;
        anInt2542 = 0;
        offsetY = 0;
        nonFlatShading = false;
        mapSceneID = -1;
        walkable = true;
        sizeX = 1;
        unknown = false;
        modelSizeHeight = 128;
        name = Class44.aClass1_1043;
        castsShadow = true;
        contrast = 0;
        configId = -1;
        unknown3 = false;
        varpID = -1;
        hasActions = -1;
        ambient = 0;
        modelSizeY = 128;
    }

    public static void method602(Class6_Sub1 arg0, int arg1, Class56 arg2, byte arg3) {

        byte[] is = null;
        synchronized(RSCanvas.aClass45_53) {
            for(Class40_Sub6 class40_sub6 = ((Class40_Sub6) RSCanvas.aClass45_53.method902((byte) -90)); class40_sub6 != null; class40_sub6 = ((Class40_Sub6) RSCanvas.aClass45_53.method909(-4))) {
                if(((class40_sub6.key ^ 0xffffffffffffffffL) == ((long) arg1 ^ 0xffffffffffffffffL)) && arg2 == class40_sub6.aClass56_2117 && (class40_sub6.anInt2112 ^ 0xffffffff) == -1) {
                    is = class40_sub6.aByteArray2102;
                    break;
                }
            }
        }
        if(is != null) {
            arg0.method198((byte) -115, true, is, arg1, arg2);
        } else {
            if(arg3 > -91) {
                chatboxScroll = -20;
            }
            byte[] is_6_ = arg2.method969(arg1, (byte) 103);
            arg0.method198((byte) -115, true, is_6_, arg1, arg2);
        }

    }

    public static void method604(boolean arg0) {

        aClass23_2545 = null;
        aClass1_2556 = null;
        aClass1_2560 = null;
        aClass1_2526 = null;
        if(arg0 != true) {
            aClass1_2560 = null;
        }
        aClass68_2524 = null;

    }

    public static void method609(int arg0, boolean arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {

        Class40_Sub3 class40_sub3 = null;
        for(Class40_Sub3 class40_sub3_24_ = ((Class40_Sub3) Class45.aClass45_1064.method902((byte) -90)); class40_sub3_24_ != null; class40_sub3_24_ = (Class40_Sub3) Class45.aClass45_1064.method909(-4)) {
            if(class40_sub3_24_.anInt2018 == arg5 && arg2 == class40_sub3_24_.anInt2039 && (arg6 ^ 0xffffffff) == (class40_sub3_24_.anInt2038 ^ 0xffffffff) && (arg7 ^ 0xffffffff) == (class40_sub3_24_.anInt2027 ^ 0xffffffff)) {
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
            Class45.aClass45_1064.method904(class40_sub3, 97);
        }
        class40_sub3.anInt2017 = arg0;
        class40_sub3.anInt2031 = arg4;
        class40_sub3.anInt2033 = arg9;
        if(arg1 != true) {
            method602(null, 77, null, (byte) -89);
        }
        class40_sub3.anInt2035 = arg3;
        class40_sub3.anInt2030 = arg8;

    }

    public static GameObjectDefinition getDefinition(int arg0) {
        GameObjectDefinition gameObjectDefinition = ((GameObjectDefinition) Class58.aClass9_1364.method231((long) arg0, (byte) 61));
        SceneTile.anInt2040++;
        if(gameObjectDefinition != null) {
            return gameObjectDefinition;
        }
        byte[] is = Class40_Sub3.aClass6_2037.method172(arg0, 113, 6);
        gameObjectDefinition = new GameObjectDefinition();
        gameObjectDefinition.anInt2538 = arg0;
        if(is != null) {
            gameObjectDefinition.readValues(new Buffer(is));
        }
        gameObjectDefinition.method605(true);
        if(gameObjectDefinition.isSolid) {
            gameObjectDefinition.solid = false;
            gameObjectDefinition.walkable = false;
        }
        Class58.aClass9_1364.method230(-7208, (long) arg0, gameObjectDefinition);
        return gameObjectDefinition;

    }

    public Model getGameObjectModel(int arg0, int arg1, int arg2, int arg3, int arg4, byte arg5, int arg6) {
        long l;
        if(objectTypes == null) {
            l = (long) ((anInt2538 << 1723242090) + arg2);
        } else {
            l = (long) (arg2 + ((anInt2538 << -855239862) + (arg4 << 399635491)));
        }
        if(arg5 != 124) {
            actions = null;
        }
        Model model = ((Model) Class19.aClass9_470.method231(l, (byte) 87));
        if(model == null) {
            model = method606(!nonFlatShading, (byte) -61, false, arg2, arg4);
            if(model == null) {
                return null;
            }
            Class19.aClass9_470.method230(-7208, l, model);
        }
        if(adjustToTerrain || nonFlatShading) {
            model = new Model(adjustToTerrain, nonFlatShading, model);
        }
        if(adjustToTerrain) {
            int i = (arg0 + arg6 + (arg3 + arg1)) / 4;
            for(int i_0_ = 0; model.vertexCount > i_0_; i_0_++) {
                int i_1_ = model.verticesX[i_0_];
                int i_2_ = model.verticesZ[i_0_];
                int i_3_ = arg3 + ((64 + i_1_) * (arg6 + -arg3) / 128);
                int i_4_ = arg1 + ((64 + i_1_) * (-arg1 + arg0) / 128);
                int i_5_ = i_3_ + (i_2_ + 64) * (-i_3_ + i_4_) / 128;
                model.verticesY[i_0_] += i_5_ + -i;
            }
        }
        return model;

    }

    public boolean method601(byte arg0) {

        if(configChangeDest == null) {
            return (anInt2513 ^ 0xffffffff) != 0 || anIntArray2523 != null;
        }
        if(arg0 != 125) {
            varpID = -89;
        }
        for(int i = 0; i < configChangeDest.length; i++) {
            if((configChangeDest[i] ^ 0xffffffff) != 0) {
                GameObjectDefinition gameObjectDefinition = getDefinition(configChangeDest[i]);
                if((gameObjectDefinition.anInt2513 ^ 0xffffffff) != 0 || gameObjectDefinition.anIntArray2523 != null) {
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

    public void method605(boolean arg0) {
        if((hasActions ^ 0xffffffff) == 0) {
            hasActions = 0;
            if(objectModels != null && (objectTypes == null || (objectTypes[0] ^ 0xffffffff) == -11)) {
                hasActions = 1;
            }
            for(int i = 0; (i ^ 0xffffffff) > -6; i++) {
                if(actions[i] != null) {
                    hasActions = 1;
                }
            }
        }
        if((anInt2533 ^ 0xffffffff) == 0) {
            anInt2533 = solid ? 1 : 0;
        }
        if(arg0 != true) {
            readValues(null);
        }
    }

    public Model method606(boolean arg0, byte arg1, boolean arg2, int arg3, int arg4) {

        Model class40_sub5_sub17_sub5 = null;
        if(objectTypes == null) {
            if(arg4 != 10) {
                return null;
            }
            if(objectModels == null) {
                return null;
            }
            boolean bool = arg3 > 3 ^ unknown3;
            int i = objectModels.length;
            for(int i_7_ = 0; i > i_7_; i_7_++) {
                int i_8_ = objectModels[i_7_];
                if(bool) {
                    i_8_ += 65536;
                }
                class40_sub5_sub17_sub5 = ((Model) VertexNormal.aClass9_1102.method231((long) i_8_, (byte) 122));
                if(class40_sub5_sub17_sub5 == null) {
                    class40_sub5_sub17_sub5 = (Model.getModel(RSString.aClass6_1705, i_8_ & 0xffff, 0));
                    if(class40_sub5_sub17_sub5 == null) {
                        return null;
                    }
                    if(bool) {
                        class40_sub5_sub17_sub5.method818();
                    }
                    VertexNormal.aClass9_1102.method230(-7208, (long) i_8_, class40_sub5_sub17_sub5);
                }
                if(i > 1) {
                    Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub5Array2762[i_7_] = class40_sub5_sub17_sub5;
                }
            }
            if((i ^ 0xffffffff) < -2) {
                class40_sub5_sub17_sub5 = (new Model((Class40_Sub5_Sub13.aClass40_Sub5_Sub17_Sub5Array2762), i));
            }
        } else {
            int i = -1;
            for(int i_9_ = 0; ((objectTypes.length > i_9_)); i_9_++) {
                if(arg4 == objectTypes[i_9_]) {
                    i = i_9_;
                    break;
                }
            }
            if(i == -1) {
                return null;
            }
            int i_10_ = objectModels[i];
            boolean bool = unknown3 ^ arg3 > 3;
            if(bool) {
                i_10_ += 65536;
            }
            class40_sub5_sub17_sub5 = ((Model) VertexNormal.aClass9_1102.method231((long) i_10_, (byte) 48));
            if(class40_sub5_sub17_sub5 == null) {
                class40_sub5_sub17_sub5 = Model.getModel((RSString.aClass6_1705), 0xffff & i_10_, 0);
                if(class40_sub5_sub17_sub5 == null) {
                    return null;
                }
                if(bool) {
                    class40_sub5_sub17_sub5.method818();
                }
                VertexNormal.aClass9_1102.method230(-7208, (long) i_10_, class40_sub5_sub17_sub5);
            }
        }
        boolean bool;
        bool = modelSizeX != 128 || modelSizeHeight != 128 || modelSizeY != 128;
        boolean bool_11_;
        bool_11_ = (offsetX ^ 0xffffffff) != -1 || offsetHeight != 0 || offsetY != 0;
        Model class40_sub5_sub17_sub5_12_ = new Model(class40_sub5_sub17_sub5, arg3 == 0 && !bool && !bool_11_, recolorToFind == null, true);
        arg3 &= 0x3;
        if((arg3 ^ 0xffffffff) != -2) {
            if((arg3 ^ 0xffffffff) != -3) {
                if(arg3 == 3) {
                    class40_sub5_sub17_sub5_12_.method824();
                }
            } else {
                class40_sub5_sub17_sub5_12_.method819();
            }
        } else {
            class40_sub5_sub17_sub5_12_.method813();
        }
        if(recolorToFind != null) {
            for(int i = 0; i < recolorToFind.length; i++) {
                class40_sub5_sub17_sub5_12_.replaceColor(recolorToFind[i], recolorToReplace[i]);
            }
        }
        int i = -128 % ((53 - arg1) / 35);
        if(bool) {
            class40_sub5_sub17_sub5_12_.method821(modelSizeX, modelSizeHeight, modelSizeY);
        }
        if(bool_11_) {
            class40_sub5_sub17_sub5_12_.method828(offsetX, offsetHeight, offsetY);
        }
        if(arg2) {
            class40_sub5_sub17_sub5_12_.method810();
        }
        class40_sub5_sub17_sub5_12_.method802(ambient + 64, 768 + (contrast * 5), -50, -10, -50, arg0);
        return class40_sub5_sub17_sub5_12_;

    }

    public Model method607(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, Class40_Sub5_Sub7 arg6, int arg7, int arg8) {

        long l;
        if(objectTypes == null) {
            l = (long) (arg5 + (anInt2538 << 554173066));
        } else {
            l = (long) (arg5 + ((anInt2538 << 1528233034) + (arg4 << 272341539)));
        }
        Model class40_sub5_sub17_sub5 = ((Model) Class49.aClass9_1145.method231(l, (byte) 70));
        if(class40_sub5_sub17_sub5 == null) {
            class40_sub5_sub17_sub5 = method606(true, (byte) -25, true, arg5, arg4);
            if(class40_sub5_sub17_sub5 == null) {
                return null;
            }
            Class49.aClass9_1145.method230(-7208, l, class40_sub5_sub17_sub5);
        }
        if(arg6 == null && !adjustToTerrain) {
            return class40_sub5_sub17_sub5;
        }
        if(arg6 != null) {
            class40_sub5_sub17_sub5 = arg6.method593(arg3, false, class40_sub5_sub17_sub5, arg5);
        } else {
            class40_sub5_sub17_sub5 = class40_sub5_sub17_sub5.method817(true);
        }
        if(arg1 < 54) {
            return null;
        }
        if(adjustToTerrain) {
            int i = (arg2 + arg0 - (-arg8 + -arg7)) / 4;
            for(int i_13_ = 0; ((i_13_ < class40_sub5_sub17_sub5.vertexCount)); i_13_++) {
                int i_14_ = class40_sub5_sub17_sub5.verticesZ[i_13_];
                int i_15_ = class40_sub5_sub17_sub5.verticesX[i_13_];
                int i_16_ = arg0 + (64 + i_15_) * (arg2 - arg0) / 128;
                int i_17_ = arg7 + (64 + i_15_) * (arg8 + -arg7) / 128;
                int i_18_ = i_16_ + (i_14_ + 64) * (-i_16_ + i_17_) / 128;
                class40_sub5_sub17_sub5.verticesY[i_13_] += -i + i_18_;
            }
        }
        return class40_sub5_sub17_sub5;

    }

    public void readValue(Buffer buffer, int opcode) {
        if(opcode == 1) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(objectModels != null && !Class35.aBoolean1734) {
                    buffer.currentPosition += length * 3;
                } else {
                    objectTypes = new int[length];
                    objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        objectModels[index] = buffer.getUnsignedShortBE();
                        objectTypes[index] = buffer.getUnsignedByte();
                    }
                }
            }
        } else if(opcode == 2) {
            name = buffer.getRSString();
        } else if(opcode == 5) {
            int length = buffer.getUnsignedByte();
            if(length > 0) {
                if(objectModels != null && !Class35.aBoolean1734) {
                    buffer.currentPosition += 2 * length;
                } else {
                    objectTypes = null;
                    objectModels = new int[length];
                    for(int index = 0; length > index; index++) {
                        objectModels[index] = buffer.getUnsignedShortBE();
                    }
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
            offsetAmplifier = buffer.getUnsignedByte();
        } else if(opcode == 29) {
            ambient = buffer.getByte();
        } else if(opcode == 39) {
            contrast = 5 * buffer.getByte();
        } else if(opcode >= 30 && opcode < 35) {
            actions[opcode - 30] = buffer.getRSString();
            if(actions[opcode + -30].equalsIgnoreCase(Class59.string_Hidden, true)) {
                actions[(opcode + -30)] = null;
            }
        } else if(opcode == 40) {
            int length = buffer.getUnsignedByte();
            recolorToFind = new int[length];
            recolorToReplace = new int[length];
            for(int index = 0; index < length; index++) {
                recolorToFind[index] = (buffer.getUnsignedShortBE());
                recolorToReplace[index] = (buffer.getUnsignedShortBE());
            }
        } else if(opcode == 60) {
            icon = (buffer.getUnsignedShortBE());
        } else if(opcode == 62) {
            unknown3 = true;
        } else if(opcode == 64) {
            castsShadow = false;
        } else if(opcode == 65) {
            modelSizeX = (buffer.getUnsignedShortBE());
        } else if(opcode == 66) {
            modelSizeHeight = (buffer.getUnsignedShortBE());
        } else if(opcode == 67) {
            modelSizeY = (buffer.getUnsignedShortBE());
        } else if(opcode == 68) {
            mapSceneID = (buffer.getUnsignedShortBE());
        } else if(opcode == 69) {
            anInt2512 = (buffer.getUnsignedByte());
        } else if(opcode == 70) {
            offsetX = (buffer.getShortBE());
        } else if(opcode == 71) {
            offsetHeight = (buffer.getShortBE());
        } else if(opcode == 72) {
            offsetY = (buffer.getShortBE());
        } else if(opcode == 73) {
            unknown = true;
        } else if(opcode == 74) {
            isSolid = true;
        } else if(opcode == 75) {
            anInt2533 = buffer.getUnsignedByte();
        } else if(opcode == 77) {
            varpID = buffer.getUnsignedShortBE();
            if(varpID == 0xffff) {
                varpID = -1;
            }
            configId = buffer.getUnsignedShortBE();
            if(configId == 0xFFFF) {
                configId = -1;
            }
            int length = buffer.getUnsignedByte();
            configChangeDest = new int[1 + length];
            for(int index = 0; index <= length; ++index) {
                configChangeDest[index] = buffer.getUnsignedShortBE();
                if(0xFFFF == configChangeDest[index]) {
                    configChangeDest[index] = -1;
                }
            }
        } else if(opcode == 78) {
            anInt2513 = buffer.getUnsignedShortBE();
            anInt2502 = buffer.getUnsignedByte();
        } else if(opcode == 79) {
            anInt2499 = buffer.getUnsignedShortBE();
            anInt2542 = buffer.getUnsignedShortBE();
            anInt2502 = buffer.getUnsignedByte();
            int length = buffer.getUnsignedByte();
            anIntArray2523 = new int[length];
            for(int index = 0; index < length; ++index) {
                anIntArray2523[index] = buffer.getUnsignedShortBE();
            }
        }
    }

    public boolean method610(int arg0, int arg1) {

        if(arg1 != 7533) {
            anInt2543 = -28;
        }
        if(objectTypes != null) {
            for(int i = 0; objectTypes.length > i; i++) {
                if((arg0 ^ 0xffffffff) == (objectTypes[i] ^ 0xffffffff)) {
                    return RSString.aClass6_1705.loaded((objectModels[i] & 0xffff), 0);
                }
            }
            return true;
        }
        if(objectModels == null) {
            return true;
        }
        if((arg0 ^ 0xffffffff) != -11) {
            return true;
        }
        boolean bool = true;
        for(int i = 0; objectModels.length > i; i++) {
            bool &= RSString.aClass6_1705.loaded((0xffff & objectModels[i]), 0);
        }
        return bool;

    }

    public GameObjectDefinition method611(int arg0) {

        int i = -1;
        if(arg0 != -20) {
            method606(true, (byte) -93, false, 40, -55);
        }
        if(varpID == -1) {
            if(configId != -1) {
                i = Class58.varbitmasks[configId];
            }
        } else {
            i = Class40_Sub5_Sub6.method585(varpID, 1369);
        }
        if(i < 0 || configChangeDest.length <= i || configChangeDest[i] == -1) {
            return null;
        }
        return getDefinition(configChangeDest[i]);

    }

    public boolean method612(byte arg0) {

        if(objectModels == null) {
            return true;
        }
        boolean bool = true;
        for(int i = 0; objectModels.length > i; i++) {
            bool &= RSString.aClass6_1705.loaded((0xffff & objectModels[i]), 0);
        }
        int i = -67 % ((-65 - arg0) / 50);
        return bool;

    }
}
