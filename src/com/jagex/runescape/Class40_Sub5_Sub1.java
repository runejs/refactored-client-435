package com.jagex.runescape;

import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.OverlayDefinition;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;

public class Class40_Sub5_Sub1 extends SubNode {
    public static Class45 aClass45_2268 = new Class45();
    public static RSString aClass1_2274 = RSString.CreateString("To");
    public static Class68 aClass68_2275;
    public static int anInt2276 = 0;
    public static RSString aClass1_2277 = RSString.CreateString(" )2> @cya@");
    public static int anInt2278 = 0;
    public static RSString aClass1_2279 = RSString.CreateString("Lade Ignorieren)2Liste)3)3)3");
    public static int anInt2280 = 0;

    public int[] anIntArray2262;
    public int anInt2263;
    public int anInt2266;
    public int anInt2267;
    public RSString[] aClass1Array2270;
    public int anInt2271;
    public int[] anIntArray2272;

    public static void method542(int arg0) {

        aClass1_2279 = null;
        aClass1_2277 = null;
        if(arg0 == -27934) {
            aClass1_2274 = null;
            aClass68_2275 = null;
            aClass45_2268 = null;
        }

    }

    public static void method543(CollisionMap arg0, int arg1, int arg2, int arg3, int arg4, Scene arg5, int arg6, int arg7, int arg8, int arg9) {
        int i = Class40_Sub6.tile_height[arg2][arg9][arg8];
        int i_0_ = Class40_Sub6.tile_height[arg2][1 + arg9][arg8];
        int i_1_ = Class40_Sub6.tile_height[arg2][arg9][1 + arg8];
        int i_2_ = (Class40_Sub6.tile_height[arg2][arg9 + 1][arg8 + 1]);
        GameObjectDefinition gameObjectDefinition = GameObjectDefinition.getDefinition(arg1);
        int i_3_ = i_2_ + i_0_ + (i + i_1_) >> 2;
        int i_4_ = (arg7 << 6) + arg4;
        int i_5_ = arg9 - (-(arg8 << 7) - (arg1 << 14) - 1073741824);
        if(gameObjectDefinition.hasActions == 0)
            i_5_ += -2147483648;
        if(gameObjectDefinition.supportsItems == 1)
            i_4_ += 256;
        if(arg4 == 22) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 22, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 22, (byte) 124, i_0_);
            arg5.addGroundDecoration(arg9, arg8, arg3, i_3_, i_5_, renderable, i_4_);
            if(gameObjectDefinition.solid && gameObjectDefinition.hasActions == 1)
                arg0.markBlocked((byte) -28, arg8, arg9);
        } else if(arg4 == 10 || arg4 == 11) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 10, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 10, (byte) 124, i_0_);
            if(renderable != null) {
                int i_6_;
                int i_7_;
                if(arg7 != 1 && arg7 != 3) {
                    i_7_ = gameObjectDefinition.sizeX;
                    i_6_ = gameObjectDefinition.sizeY;
                } else {
                    i_6_ = gameObjectDefinition.sizeX;
                    i_7_ = gameObjectDefinition.sizeY;
                }
                int i_8_ = 0;
                if(arg4 == 11)
                    i_8_ += 256;
                arg5.method137(arg3, arg9, arg8, i_3_, i_7_, i_6_, renderable, i_8_, i_5_, i_4_);
            }
            if(gameObjectDefinition.solid)
                arg0.method154(arg9, gameObjectDefinition.walkable, arg6 ^ ~0x5644, gameObjectDefinition.sizeY, arg7, arg8, gameObjectDefinition.sizeX);
        } else if(arg4 >= 12) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, arg4, (byte) 124, i_0_);
            arg5.method137(arg3, arg9, arg8, i_3_, 1, 1, renderable, 0, i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method154(arg9, gameObjectDefinition.walkable, arg6 ^ ~0x5648, gameObjectDefinition.sizeY, arg7, arg8, gameObjectDefinition.sizeX);
        } else if(arg4 == 0) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 0, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 0, (byte) 124, i_0_);
            arg5.method94(arg3, arg9, arg8, i_3_, renderable, null, Class32.anIntArray761[arg7], 0, i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method150(arg8, arg4, arg7, arg9, gameObjectDefinition.walkable, (byte) 95);
        } else if(arg4 == 1) {
            Renderable renderable;
            if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 1, (byte) 124, i_0_);
            else
                renderable = new GameObject(arg1, 1, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            arg5.method94(arg3, arg9, arg8, i_3_, renderable, null, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method150(arg8, arg4, arg7, arg9, gameObjectDefinition.walkable, (byte) 95);
        } else if(arg4 == 2) {
            int i_9_ = arg7 + 1 & 0x3;
            Renderable renderable;
            Renderable renderable_10_;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null) {
                renderable = new GameObject(arg1, 2, 4 + arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
                renderable_10_ = new GameObject(arg1, 2, i_9_, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            } else {
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7 + 4, i, 2, (byte) 124, i_0_);
                renderable_10_ = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, i_9_, i, 2, (byte) 124, i_0_);
            }
            arg5.method94(arg3, arg9, arg8, i_3_, renderable, renderable_10_, Class32.anIntArray761[arg7], Class32.anIntArray761[i_9_], i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method150(arg8, arg4, arg7, arg9, gameObjectDefinition.walkable, (byte) 95);
        } else if(arg4 == 3) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, 3, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, 3, (byte) 124, i_0_);
            arg5.method94(arg3, arg9, arg8, i_3_, renderable, null, Class40_Sub5_Sub15.anIntArray2788[arg7], 0, i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method150(arg8, arg4, arg7, arg9, gameObjectDefinition.walkable, (byte) 95);
        } else if(arg4 == 9) {
            Renderable renderable;
            if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                renderable = new GameObject(arg1, arg4, arg7, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
            else
                renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, arg7, i, arg4, (byte) 124, i_0_);
            arg5.method137(arg3, arg9, arg8, i_3_, 1, 1, renderable, 0, i_5_, i_4_);
            if(gameObjectDefinition.solid)
                arg0.method154(arg9, gameObjectDefinition.walkable, -117, gameObjectDefinition.sizeY, arg7, arg8, gameObjectDefinition.sizeX);
        } else {
            if(gameObjectDefinition.adjustToTerrain) {
                if(arg7 != 1) {
                    if(arg7 != 2) {
                        if(arg7 == 3) {
                            int i_11_ = i_1_;
                            i_1_ = i;
                            i = i_0_;
                            i_0_ = i_2_;
                            i_2_ = i_11_;
                        }
                    } else {
                        int i_12_ = i_1_;
                        i_1_ = i_0_;
                        i_0_ = i_12_;
                        i_12_ = i_2_;
                        i_2_ = i;
                        i = i_12_;
                    }
                } else {
                    int i_13_ = i_1_;
                    i_1_ = i_2_;
                    i_2_ = i_0_;
                    i_0_ = i;
                    i = i_13_;
                }
            }
            if(arg4 == 4) {
                Renderable renderable;
                if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                    renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
                else
                    renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                arg5.method109(arg3, arg9, arg8, i_3_, renderable, Class32.anIntArray761[arg7], 512 * arg7, 0, 0, i_5_, i_4_);
            } else if(arg4 == 5) {
                int i_14_ = 16;
                int i_15_ = arg5.method122(arg3, arg9, arg8);
                if(i_15_ > 0)
                    i_14_ = (GameObjectDefinition.getDefinition(i_15_ >> 14 & 0x7fff).setDecorDisplacement);
                Renderable renderable;
                if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                    renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                else
                    renderable = new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, (gameObjectDefinition.animationId), true);
                arg5.method109(arg3, arg9, arg8, i_3_, renderable, Class32.anIntArray761[arg7], 512 * arg7, Class27.anIntArray666[arg7] * i_14_, Class68_Sub1.anIntArray2207[arg7] * i_14_, i_5_, i_4_);
            } else if(arg6 == -22078) {
                if(arg4 == 6) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                        renderable = (new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true));
                    else
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                    arg5.method109(arg3, arg9, arg8, i_3_, renderable, 256, arg7, 0, 0, i_5_, i_4_);
                } else if(arg4 == 7) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId == -1 && gameObjectDefinition.configChangeDest == null)
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                    else
                        renderable = (new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true));
                    arg5.method109(arg3, arg9, arg8, i_3_, renderable, 512, arg7, 0, 0, i_5_, i_4_);
                } else if(arg4 == 8) {
                    Renderable renderable;
                    if(gameObjectDefinition.animationId != -1 || gameObjectDefinition.configChangeDest != null)
                        renderable = (new GameObject(arg1, 4, 0, i, i_0_, i_2_, i_1_, gameObjectDefinition.animationId, true));
                    else
                        renderable = gameObjectDefinition.getGameObjectModel(i_2_, i_1_, 0, i, 4, (byte) 124, i_0_);
                    arg5.method109(arg3, arg9, arg8, i_3_, renderable, 768, arg7, 0, 0, i_5_, i_4_);
                }
            }
        }

    }

    public static void method544(byte arg0) {
        if(GameFrame.clickType == 1) {
            if(Class57.anInt1338 >= 6 && Class57.anInt1338 <= 106 && RSString.anInt1668 >= 467 && RSString.anInt1668 <= 499) {
                Cache.aBoolean330 = true;
                Class35.publicChatMode = (1 + Class35.publicChatMode) % 4;
                Class52.redrawChatbox = true;
                Class32.packetBuffer.putPacket(32);
                Class34.anInt821++;
                Class32.packetBuffer.putByte(Class35.publicChatMode);
                Class32.packetBuffer.putByte(Class4.anInt185);
                Class32.packetBuffer.putByte(ItemDefinition.anInt2797);
            }
            if(Class57.anInt1338 >= 135 && Class57.anInt1338 <= 235 && RSString.anInt1668 >= 467 && RSString.anInt1668 <= 499) {
                Class52.redrawChatbox = true;
                Class4.anInt185 = (Class4.anInt185 + 1) % 3;
                Cache.aBoolean330 = true;
                Class34.anInt821++;
                Class32.packetBuffer.putPacket(32);
                Class32.packetBuffer.putByte(Class35.publicChatMode);
                Class32.packetBuffer.putByte(Class4.anInt185);
                Class32.packetBuffer.putByte(ItemDefinition.anInt2797);
            }
            if(Class57.anInt1338 >= 273 && Class57.anInt1338 <= 373 && RSString.anInt1668 >= 467 && RSString.anInt1668 <= 499) {
                ItemDefinition.anInt2797 = (ItemDefinition.anInt2797 + 1) % 3;
                Cache.aBoolean330 = true;
                Class52.redrawChatbox = true;
                Class32.packetBuffer.putPacket(32);
                Class34.anInt821++;
                Class32.packetBuffer.putByte(Class35.publicChatMode);
                Class32.packetBuffer.putByte(Class4.anInt185);
                Class32.packetBuffer.putByte(ItemDefinition.anInt2797);
            }
            if(Class57.anInt1338 >= 412 && Class57.anInt1338 <= 512 && RSString.anInt1668 >= 467 && RSString.anInt1668 <= 499) {
                if(HuffmanEncoding.openScreenWidgetId == -1) {
                    PacketBuffer.method516(127);
                    if(Class34.anInt854 != -1) {
                        Class67.aBoolean1601 = false;
                        HuffmanEncoding.anInt1548 = HuffmanEncoding.openScreenWidgetId = Class34.anInt854;
                        HuffmanEncoding.aClass1_1550 = HuffmanEncoding.blank_string;
                    }
                } else
                    Class44.method895(arg0 ^ ~0x65, 0, Class37.aClass1_873, HuffmanEncoding.blank_string);
            }
        }
    }

    public static void method545(int arg0, boolean arg1, int arg2, Player arg3, int arg4) {
        if(Player.localPlayer != arg3 && ActorDefinition.anInt2394 < 400) {
            RSString class1;
            if(arg3.anInt3257 == 0)
                class1 = (Class40_Sub5_Sub17_Sub6.method832(82, (new RSString[]{arg3.playerName, (SceneTile.method536((Player.localPlayer.anInt3260), arg3.anInt3260, -122)), HashTable.aClass1_569, SpotAnimDefinition.str_prefix_level, HashTable.method334(arg3.anInt3260, -1), Class51.aClass1_1199})));
            else
                class1 = (Class40_Sub5_Sub17_Sub6.method832(-60, (new RSString[]{arg3.playerName, HashTable.aClass1_569, Class26.aClass1_619, HashTable.method334(arg3.anInt3257, -1), Class51.aClass1_1199})));
            if(Class8.anInt301 == 1) {
                Node.anInt928++;
                OverlayDefinition.method558(arg4, Main.aClass1_1763, arg0, -501, arg2, 22, (Class40_Sub5_Sub17_Sub6.method832(55, (new RSString[]{Npc.aClass1_3295, Class40_Sub5_Sub17_Sub3.aClass1_3068, class1}))));
            } else if(Main.anInt1773 == 1) {
                if((ItemDefinition.anInt2815 & 0x8) == 8) {
                    OverlayDefinition.method558(arg4, Class38_Sub1.aClass1_1918, arg0, -501, arg2, 1, (Class40_Sub5_Sub17_Sub6.method832(124, (new RSString[]{FloorDecoration.aClass1_611, Class40_Sub5_Sub17_Sub3.aClass1_3068, class1}))));
                    Class22_Sub1.anInt1850++;
                }
            } else {
                for(int i = 4; i >= 0; i--) {
                    if(Main.aClass1Array1778[i] != null) {
                        int i_16_ = 0;
                        int i_17_ = 0;
                        if(Main.aClass1Array1778[i].equalsIgnoreCase(Class38_Sub1.aClass1_1917, true)) {
                            if((Player.localPlayer.anInt3260) < arg3.anInt3260)
                                i_17_ = 2000;
                            if((Player.localPlayer.anInt3266) != 0 && arg3.anInt3266 != 0) {
                                if((Player.localPlayer.anInt3266) != arg3.anInt3266)
                                    i_17_ = 0;
                                else
                                    i_17_ = 2000;
                            }
                        } else if(Class13.aBooleanArray414[i])
                            i_17_ = 2000;
                        if(i == 0)
                            i_16_ = 10 + i_17_;
                        if(i == 1)
                            i_16_ = 39 + i_17_;
                        if(i == 2)
                            i_16_ = i_17_ + 44;
                        if(i == 3)
                            i_16_ = i_17_ + 14;
                        if(i == 4)
                            i_16_ = 41 + i_17_;
                        OverlayDefinition.method558(arg4, Main.aClass1Array1778[i], arg0, -501, arg2, i_16_, (Class40_Sub5_Sub17_Sub6.method832(79, new RSString[]{Class26.aClass1_620, class1})));
                    }
                }
            }
            if(arg1 == false) {
                for(int i = 0; i < ActorDefinition.anInt2394; i++) {
                    if(Class38.anIntArray884[i] == 7) {
                        Landscape.aClass1Array1184[i] = (Class40_Sub5_Sub17_Sub6.method832(-78, new RSString[]{Class22_Sub2.aClass1_1876, VertexNormal.aClass1_1117, Class26.aClass1_620, class1}));
                        break;
                    }
                }
            }
        }

    }

    public static int method546(int arg0) {
        if(arg0 != 256)
            anInt2280 = 44;
        int i = Class37.method430((byte) -120, Player.anInt3267, Class12.cameraX, Class40_Sub5_Sub6.cameraY);
        if(i + -Class32.cameraZ < 800 && ((OverlayDefinition.tile_flags[Player.anInt3267][Class12.cameraX >> 7][Class40_Sub5_Sub6.cameraY >> 7]) & 0x4) != 0)
            return Player.anInt3267;
        return 3;
    }
}
