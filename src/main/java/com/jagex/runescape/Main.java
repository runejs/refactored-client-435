package com.jagex.runescape;

import com.jagex.runescape.cache.CacheIndex;
import com.jagex.runescape.cache.CacheArchive;
import com.jagex.runescape.cache.CacheFileChannel;
import com.jagex.runescape.cache.def.*;
import com.jagex.runescape.cache.media.*;
import com.jagex.runescape.cache.media.gameInterface.*;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.ScreenController;
import com.jagex.runescape.frame.ScreenMode;
import com.jagex.runescape.frame.console.Console;
import com.jagex.runescape.input.KeyFocusListener;
import com.jagex.runescape.input.MouseHandler;
import com.jagex.runescape.io.Buffer;
import com.jagex.runescape.language.English;
import com.jagex.runescape.language.Native;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.Rasterizer3D;
import com.jagex.runescape.media.renderable.GameObject;
import com.jagex.runescape.media.renderable.Model;
import com.jagex.runescape.media.renderable.Renderable;
import com.jagex.runescape.media.renderable.actor.Npc;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.media.renderable.actor.PlayerAppearance;
import com.jagex.runescape.net.ISAAC;
import com.jagex.runescape.net.IncomingPackets;
import com.jagex.runescape.net.PacketBuffer;
import com.jagex.runescape.scene.GroundItemTile;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.*;
import com.jagex.runescape.scene.util.CollisionMap;
import com.jagex.runescape.util.Signlink;
import tech.henning.fourthreefive.Configuration;

import java.awt.*;
import java.net.InetAddress;
import java.net.Socket;

public class Main extends GameShell {
    public static int anInt1756 = 0;
    public static int menuOffsetY;
    public static int anInt1764 = 0;
    public static int anInt1766 = 1;
    public static int anInt1769 = -1;
    public static int widgetSelected = 0;
    public static String[] playerActions = new String[5];
    public static boolean aBoolean1790;
    public static Signlink signlink;
    public static CacheIndex gameCache;
    public static CacheFileChannel dataChannel;
    public static CacheFileChannel metaChannel;
    public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
    private static int drawCount = 0;

    public static boolean method36(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, GameInterface[] arg8, boolean arg9) {
        Rasterizer.setBounds(arg2, arg1, arg5, arg6);
        boolean bool = arg9;
        for (int i = 0; arg8.length > i; i++) {
            GameInterface gameInterface = arg8[i];
            if (gameInterface != null && gameInterface.parentId == arg4) {
                if (gameInterface.contentType > 0)
                    GameInterface.updateGameInterface(gameInterface);
                int i_0_ = arg2 + gameInterface.currentX;
                if (!gameInterface.aBoolean2694)
                    i_0_ -= arg3;
                int i_1_ = arg1 + gameInterface.currentY;
                if (!gameInterface.aBoolean2694)
                    i_1_ -= arg7;
                int i_2_ = gameInterface.opacity;
                if (gameInterface == Wall.aGameInterface_353) {
                    i_2_ = 128;
                    GameInterface gameInterface_3_ = FramemapDefinition.method878(gameInterface);
                    int[] is = Class13.method247(gameInterface_3_, (byte) 117);
                    int[] is_4_ = Class13.method247(gameInterface, (byte) 97);
                    int i_5_ = Landscape.mouseY + -Class40_Sub5_Sub11.anInt2621 + is_4_[1] - is[1];
                    if (i_5_ < 0)
                        i_5_ = 0;
                    if (i_5_ + gameInterface.originalHeight > gameInterface_3_.originalHeight)
                        i_5_ = gameInterface_3_.originalHeight + -gameInterface.originalHeight;
                    i_1_ = i_5_ + is[1];
                    int i_6_ = Class13.mouseX + -Class40_Sub2.anInt1996 + -is[0] + is_4_[0];
                    if (i_6_ < 0)
                        i_6_ = 0;
                    if (i_6_ + gameInterface.originalWidth > gameInterface_3_.originalWidth)
                        i_6_ = -gameInterface.originalWidth + gameInterface_3_.originalWidth;
                    i_0_ = is[0] + i_6_;
                }
                if (!gameInterface.isNewInterfaceFormat || Rasterizer.viewportRight >= i_0_ && Rasterizer.viewportBottom >= i_1_ && Rasterizer.viewportLeft <= i_0_ + gameInterface.originalWidth && i_1_ + gameInterface.originalHeight >= Rasterizer.viewportTop) {
                    if (gameInterface.type == GameInterfaceType.LAYER) {
                        if (gameInterface.isHidden && !Class29.method371(8247, arg0, i))
                            continue;
                        if (!gameInterface.isNewInterfaceFormat) {
                            if (-gameInterface.originalHeight + gameInterface.scrollHeight < gameInterface.scrollPosition)
                                gameInterface.scrollPosition = -gameInterface.originalHeight + gameInterface.scrollHeight;
                            if (gameInterface.scrollPosition < 0)
                                gameInterface.scrollPosition = 0;
                        }
                        bool &= method36(arg0, i_1_, i_0_, gameInterface.anInt2746, i, gameInterface.originalHeight + i_1_, gameInterface.originalWidth + i_0_, gameInterface.scrollPosition, arg8, arg9);
                        if (gameInterface.children != null)
                            bool &= method36(arg0, i_1_, i_0_, gameInterface.anInt2746, gameInterface.id, i_1_ + gameInterface.originalHeight, gameInterface.originalWidth + i_0_, gameInterface.scrollPosition, gameInterface.children, true);
                        Rasterizer.setBounds(arg2, arg1, arg5, arg6);
                        if (gameInterface.originalHeight < gameInterface.scrollHeight)
                            GameInterface.drawScrollBar(i_0_ + gameInterface.originalWidth, i_1_, gameInterface.originalHeight, gameInterface.scrollPosition, gameInterface.scrollHeight, 0);
                    }
                    if (gameInterface.type == GameInterfaceType.UNKNOWN) {
                        continue;
                    }
                    if (gameInterface.type == GameInterfaceType.INVENTORY) {
                        int i_7_ = 0;
                        for (int i_8_ = 0; i_8_ < gameInterface.originalHeight; i_8_++) {
                            for (int i_9_ = 0; gameInterface.originalWidth > i_9_; i_9_++) {
                                int i_10_ = (gameInterface.itemSpritePadsX + 32) * i_9_ + i_0_;
                                int i_11_ = (32 + gameInterface.itemSpritePadsY) * i_8_ + i_1_;
                                if (i_7_ < 20) {
                                    i_10_ += gameInterface.images[i_7_];
                                    i_11_ += gameInterface.imageX[i_7_];
                                }
                                if (gameInterface.items[i_7_] <= 0) {
                                    if (gameInterface.imageY != null && i_7_ < 20) {
                                        ImageRGB imageRGB = gameInterface.method638((byte) 78, i_7_);
                                        if (imageRGB == null) {
                                            if (FramemapDefinition.aBoolean2177)
                                                bool = false;
                                        } else
                                            imageRGB.drawImage(i_10_, i_11_);
                                    }
                                } else {
                                    int i_12_ = 0;
                                    int i_13_ = -1 + gameInterface.items[i_7_];
                                    int i_14_ = 0;
                                    if (-32 + Rasterizer.viewportLeft < i_10_ && Rasterizer.viewportRight > i_10_ && Rasterizer.viewportTop + -32 < i_11_ && Rasterizer.viewportBottom > i_11_ || SceneTile.activeInterfaceType != 0 && GroundItemTile.selectedInventorySlot == i_7_) {
                                        int i_15_ = 0;
                                        if (Class8.itemSelected == 1 && i_7_ == LinkedList.anInt1061 && gameInterface.id == ISAAC.anInt525)
                                            i_15_ = 16777215;
                                        ImageRGB imageRGB = ItemDefinition.sprite(gameInterface.itemAmounts[i_7_], i_13_, i_15_);
                                        if (imageRGB == null)
                                            bool = false;
                                        else {
                                            if (SceneTile.activeInterfaceType != 0 && GroundItemTile.selectedInventorySlot == i_7_ && gameInterface.id == Class48.modifiedWidgetId) {
                                                i_14_ = Landscape.mouseY + -ItemDefinition.anInt2798;
                                                i_12_ = Class13.mouseX + -Renderable.anInt2869;
                                                if (i_12_ < 5 && i_12_ > -5)
                                                    i_12_ = 0;
                                                if (i_14_ < 5 && i_14_ > -5)
                                                    i_14_ = 0;
                                                if (Buffer.lastItemDragTime < 5) {
                                                    i_14_ = 0;
                                                    i_12_ = 0;
                                                }
                                                imageRGB.method728(i_12_ + i_10_, i_11_ + i_14_, 128);
                                                if (arg4 != -1) {
                                                    GameInterface gameInterface_16_ = arg8[arg4];
                                                    if (Rasterizer.viewportTop > i_14_ + i_11_ && gameInterface_16_.scrollPosition > 0) {
                                                        int i_17_ = MovedStatics.anInt199 * (Rasterizer.viewportTop + -i_11_ - i_14_) / 3;
                                                        if (10 * MovedStatics.anInt199 < i_17_)
                                                            i_17_ = 10 * MovedStatics.anInt199;
                                                        if (gameInterface_16_.scrollPosition < i_17_)
                                                            i_17_ = gameInterface_16_.scrollPosition;
                                                        gameInterface_16_.scrollPosition -= i_17_;
                                                        ItemDefinition.anInt2798 += i_17_;
                                                    }
                                                    if (32 + i_11_ + i_14_ > Rasterizer.viewportBottom && -gameInterface_16_.originalHeight + gameInterface_16_.scrollHeight > gameInterface_16_.scrollPosition) {
                                                        int i_18_ = MovedStatics.anInt199 * (-Rasterizer.viewportBottom + 32 + i_11_ + i_14_) / 3;
                                                        if (MovedStatics.anInt199 * 10 < i_18_)
                                                            i_18_ = 10 * MovedStatics.anInt199;
                                                        if (-gameInterface_16_.scrollPosition + gameInterface_16_.scrollHeight + -gameInterface_16_.originalHeight < i_18_)
                                                            i_18_ = -gameInterface_16_.originalHeight + gameInterface_16_.scrollHeight + -gameInterface_16_.scrollPosition;
                                                        ItemDefinition.anInt2798 -= i_18_;
                                                        gameInterface_16_.scrollPosition += i_18_;
                                                    }
                                                }
                                            } else if (Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 0 || GenericTile.anInt1233 != i_7_ || gameInterface.id != PlayerAppearance.anInt704)
                                                imageRGB.drawImage(i_10_, i_11_);
                                            else
                                                imageRGB.method728(i_10_, i_11_, 128);
                                            if (imageRGB.maxWidth == 33 || gameInterface.itemAmounts[i_7_] != 1) {
                                                int i_19_ = gameInterface.itemAmounts[i_7_];
                                                TypeFace.fontSmall.drawString(GameInterface.getShortenedAmountText(i_19_), i_12_ + 1 + i_10_, i_11_ + 10 + i_14_, 0);
                                                TypeFace.fontSmall.drawString(GameInterface.getShortenedAmountText(i_19_), i_10_ + i_12_, i_14_ + i_11_ + 9, 16776960);
                                            }
                                        }
                                    }
                                }
                                i_7_++;
                            }
                        }
                    } else if (gameInterface.type == GameInterfaceType.RECTANGLE) {
                        int i_20_;
                        if (ItemDefinition.method746(gameInterface)) {
                            i_20_ = gameInterface.alternateTextColor;
                            if (Class29.method371(8247, arg0, i) && gameInterface.alternateHoveredTextColor != 0)
                                i_20_ = gameInterface.alternateHoveredTextColor;
                        } else {
                            i_20_ = gameInterface.textColor;
                            if (Class29.method371(8247, arg0, i) && gameInterface.hoveredTextColor != 0)
                                i_20_ = gameInterface.hoveredTextColor;
                        }
                        if (i_2_ == 0) {
                            if (!gameInterface.filled)
                                Rasterizer.drawUnfilledRectangle(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, i_20_);
                            else
                                Rasterizer.drawFilledRectangle(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, i_20_);
                        } else if (!gameInterface.filled)
                            Rasterizer.drawUnfilledRectangleAlpha(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, i_20_, -(0xff & i_2_) + 256);
                        else
                            Rasterizer.drawFilledRectangleAlpha(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, i_20_, -(0xff & i_2_) + 256);
                    } else if (gameInterface.type == GameInterfaceType.TEXT) {
                        TypeFace class40_sub5_sub14_sub1 = gameInterface.getTypeFace();
                        if (class40_sub5_sub14_sub1 == null) {
                            if (FramemapDefinition.aBoolean2177)
                                bool = false;
                        } else {
                            String class1 = gameInterface.disabledText;
                            int i_21_;
                            if (ItemDefinition.method746(gameInterface)) {
                                i_21_ = gameInterface.alternateTextColor;
                                if (Class29.method371(8247, arg0, i) && gameInterface.alternateHoveredTextColor != 0)
                                    i_21_ = gameInterface.alternateHoveredTextColor;
                                if (gameInterface.alternateText.length() > 0)
                                    class1 = gameInterface.alternateText;
                            } else {
                                i_21_ = gameInterface.textColor;
                                if (Class29.method371(8247, arg0, i) && gameInterface.hoveredTextColor != 0)
                                    i_21_ = gameInterface.hoveredTextColor;
                            }
                            if (gameInterface.isNewInterfaceFormat && gameInterface.itemId != -1) {
                                ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(gameInterface.itemId, 10);
                                class1 = class40_sub5_sub16.name;
                                if (class1 == null)
                                    class1 = "null";
                                if (class40_sub5_sub16.stackable == 1 || gameInterface.itemAmount != 1)
                                    class1 = class1 + Native.aClass1_674 + LinkedList.method903(gameInterface.itemAmount, (byte) -109);
                            }
                            if (gameInterface.actionType == 6 && MovedStatics.anInt1819 == gameInterface.id) {
                                i_21_ = gameInterface.textColor;
                                class1 = English.pleaseWait;
                            }
                            if (Rasterizer.destinationWidth == 479) {
                                if (i_21_ == 16776960)
                                    i_21_ = 255;
                                if (i_21_ == 49152)
                                    i_21_ = 16777215;
                            }
//                            System.out.println(class1);
                            class1 = SceneTile.method532((byte) 20, gameInterface, class1);
//                            System.out.println(class1);
                            class40_sub5_sub14_sub1.drawText(class1, i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, i_21_, gameInterface.textShadowed, gameInterface.xTextAlignment, gameInterface.yTextAlignment, gameInterface.lineHeight);
                        }
                    } else if (gameInterface.type == GameInterfaceType.GRAPHIC) {
                        if (gameInterface.isNewInterfaceFormat) {
                            int i_22_ = 0;
                            int i_23_ = 0;
                            ImageRGB class40_sub5_sub14_sub4;
                            if (gameInterface.itemId == -1)
                                class40_sub5_sub14_sub4 = gameInterface.getImageRgb(false);
                            else {
                                class40_sub5_sub14_sub4 = ItemDefinition.sprite(gameInterface.itemAmount, gameInterface.itemId, 0);
                                i_22_ = class40_sub5_sub14_sub4.maxWidth;
                                i_23_ = class40_sub5_sub14_sub4.maxHeight;
                                class40_sub5_sub14_sub4.maxHeight = 32;
                                class40_sub5_sub14_sub4.maxWidth = 32;
                            }
                            if (class40_sub5_sub14_sub4 != null) {
                                int i_24_ = class40_sub5_sub14_sub4.imageHeight;
                                int i_25_ = class40_sub5_sub14_sub4.imageWidth;
                                if (gameInterface.aBoolean2641) {
                                    int[] is = new int[4];
                                    Rasterizer.method661(is);
                                    int i_27_ = i_0_;
                                    if (is[0] > i_27_)
                                        i_27_ = is[0];
                                    int i_28_ = i_1_;
                                    if (is[1] > i_28_)
                                        i_28_ = is[1];
                                    int i_29_ = gameInterface.originalWidth + i_0_;
                                    if (is[2] < i_29_)
                                        i_29_ = is[2];
                                    int i_30_ = gameInterface.originalHeight + i_1_;
                                    if (i_30_ > is[3])
                                        i_30_ = is[3];
                                    Rasterizer.setBounds(i_27_, i_28_, i_30_, i_29_);
                                    int i_31_ = (gameInterface.originalWidth - (1 + -i_25_)) / i_25_;
                                    int i_32_ = (gameInterface.originalHeight - (1 + -i_24_)) / i_24_;
                                    for (int i_33_ = 0; i_31_ > i_33_; i_33_++) {
                                        for (int i_34_ = 0; i_32_ > i_34_; i_34_++) {
                                            if (gameInterface.anInt2751 == 0) {
                                                if (i_2_ == 0)
                                                    class40_sub5_sub14_sub4.drawImage(i_33_ * i_25_ + i_0_, i_34_ * i_24_ + i_1_);
                                                else
                                                    class40_sub5_sub14_sub4.method728(i_0_ + i_33_ * i_25_, i_1_ + i_24_ * i_34_, -(i_2_ & 0xff) + 256);
                                            } else
                                                class40_sub5_sub14_sub4.method720(i_25_ / 2 + i_33_ * i_25_ + i_0_, i_24_ / 2 + i_1_ + i_24_ * i_34_, gameInterface.anInt2751, 4096);
                                        }
                                    }
                                    Rasterizer.method657(is);
                                } else {
                                    int i_26_ = 4096 * gameInterface.originalWidth / i_25_;
                                    if (gameInterface.anInt2751 == 0) {
                                        if (i_2_ == 0) {
                                            if (gameInterface.originalWidth == i_25_ && gameInterface.originalHeight == i_24_)
                                                class40_sub5_sub14_sub4.drawImage(i_0_, i_1_);
                                            else
                                                class40_sub5_sub14_sub4.method732(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight);
                                        } else
                                            class40_sub5_sub14_sub4.method716(i_0_, i_1_, gameInterface.originalWidth, gameInterface.originalHeight, 256 + -(0xff & i_2_));
                                    } else
                                        class40_sub5_sub14_sub4.method720(gameInterface.originalWidth / 2 + i_0_, gameInterface.originalHeight / 2 + i_1_, gameInterface.anInt2751, i_26_);
                                }
                            } else if (FramemapDefinition.aBoolean2177)
                                bool = false;
                            if (gameInterface.itemId != -1) {
                                if (gameInterface.itemAmount != 1 || i_22_ == 33) {
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), i_0_ + 1, i_1_ + 10, 0);
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), i_0_, 9 + i_1_, 16776960);
                                }
                                class40_sub5_sub14_sub4.maxWidth = i_22_;
                                class40_sub5_sub14_sub4.maxHeight = i_23_;
                            }
                        } else {
                            ImageRGB imageRGB = gameInterface.getImageRgb(ItemDefinition.method746(gameInterface));
                            if (imageRGB != null)
                                imageRGB.drawImage(i_0_, i_1_);
                            else if (FramemapDefinition.aBoolean2177)
                                bool = false;
                        }
                    } else if (gameInterface.type == GameInterfaceType.MODEL) {
                        boolean bool_35_ = ItemDefinition.method746(gameInterface);
                        Object object = null;
                        int i_36_;
                        if (!bool_35_)
                            i_36_ = gameInterface.animation;
                        else
                            i_36_ = gameInterface.alternateAnimation;

                        Model model;
                        if (gameInterface.modelType != InterfaceModelType.PLAYER) {
                            if (i_36_ == -1) {
                                model = gameInterface.method646((byte) 46, null, -1, bool_35_, Player.localPlayer.playerAppearance);
                                if (model == null && FramemapDefinition.aBoolean2177)
                                    bool = false;
                            } else {
                                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.method1050(i_36_, 2);
                                model = gameInterface.method646((byte) 76, animationSequence, gameInterface.animationFrame, bool_35_, Player.localPlayer.playerAppearance);
                                if (model == null && FramemapDefinition.aBoolean2177)
                                    bool = false;
                            }
                        } else if (gameInterface.modelId != 0)
                            model = Player.localPlayer.getRotatedModel();
                        else
                            model = Player.activePlayerAppearance.getAnimatedModel(null, null, -1, -1);
                        int i_37_ = gameInterface.rotationX;
                        int i_38_ = gameInterface.rotationY;
                        int i_39_ = gameInterface.offsetY2d;
                        int i_40_ = gameInterface.rotationZ;
                        int i_41_ = gameInterface.offsetX2d;
                        int i_42_ = gameInterface.modelZoom;
                        if (gameInterface.itemId != -1) {
                            ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(gameInterface.itemId, 10);
                            if (class40_sub5_sub16 != null) {
                                class40_sub5_sub16 = class40_sub5_sub16.method743(gameInterface.itemAmount);
                                model = class40_sub5_sub16.asGroundStack(true, 1);
                                i_38_ = class40_sub5_sub16.zan2d;
                                i_39_ = class40_sub5_sub16.yOffset2d;
                                i_41_ = class40_sub5_sub16.xOffset2d;
                                i_37_ = class40_sub5_sub16.xan2d;
                                i_42_ = class40_sub5_sub16.zoom2d;
                                i_40_ = class40_sub5_sub16.yan2d;
                                if (gameInterface.originalWidth > 0)
                                    i_42_ = 32 * i_42_ / gameInterface.originalWidth;
                            }
                        }
                        Rasterizer3D.setBounds(i_0_ + gameInterface.originalWidth / 2, gameInterface.originalHeight / 2 + i_1_);

                        int i_43_ = i_42_ * Rasterizer3D.sinetable[i_37_] >> 16;
                        int i_44_ = i_42_ * Rasterizer3D.cosinetable[i_37_] >> 16;
                        if (model != null) {
                            if (gameInterface.isNewInterfaceFormat) {
                                model.method799();
                                if (gameInterface.orthogonal)
                                    model.method801(0, i_40_, i_38_, i_37_, i_41_, i_39_ + i_43_ + model.modelHeight / 2, i_44_ + i_39_, i_42_);
                                else
                                    model.method812(0, i_40_, i_38_, i_37_, i_41_, i_39_ + model.modelHeight / 2 + i_43_, i_44_ + i_39_);
                            } else
                                model.method812(0, i_40_, 0, i_37_, 0, i_43_, i_44_);
                        }
                        Rasterizer3D.method702();
                    } else {
                        if (gameInterface.type == GameInterfaceType.TEXT_INVENTORY) {
                            TypeFace class40_sub5_sub14_sub1 = gameInterface.getTypeFace();
                            if (class40_sub5_sub14_sub1 == null) {
                                if (FramemapDefinition.aBoolean2177)
                                    bool = false;
                                continue;
                            }
                            int i_45_ = 0;
                            for (int i_46_ = 0; i_46_ < gameInterface.originalHeight; i_46_++) {
                                for (int i_47_ = 0; i_47_ < gameInterface.originalWidth; i_47_++) {
                                    if (gameInterface.items[i_45_] > 0) {
                                        ItemDefinition class40_sub5_sub16 = ItemDefinition.forId(-1 + gameInterface.items[i_45_], 10);
                                        String class1 = class40_sub5_sub16.name;
                                        if (class1 == null)
                                            class1 = "null";
                                        if (class40_sub5_sub16.stackable == 1 || gameInterface.itemAmounts[i_45_] != 1)
                                            class1 = class1 + Native.aClass1_674 + LinkedList.method903(gameInterface.itemAmounts[i_45_], (byte) -105);
                                        int i_48_ = i_47_ * (gameInterface.itemSpritePadsX + 115) + i_0_;
                                        int i_49_ = i_46_ * (gameInterface.itemSpritePadsY + 12) + i_1_;
                                        if (gameInterface.xTextAlignment == 0)
                                            class40_sub5_sub14_sub1.drawShadowedString(class1, i_48_, i_49_, gameInterface.textShadowed, gameInterface.textColor);
                                        else if (gameInterface.xTextAlignment == 1)
                                            class40_sub5_sub14_sub1.drawShadowedStringCenter(class1, i_48_ + gameInterface.originalWidth / 2, i_49_, gameInterface.textColor, gameInterface.textShadowed);
                                        else
                                            class40_sub5_sub14_sub1.drawShadowedStringRight(class1, -1 + gameInterface.originalWidth + i_48_, i_49_, gameInterface.textColor, gameInterface.textShadowed);
                                    }
                                    i_45_++;
                                }
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.IF1_TOOLTIP && Class37.method438(arg0, i) && RSString.anInt1711 == WallDecoration.anInt1257) {
                            int i_50_ = 0;
                            int i_51_ = 0;
                            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
                            String class1 = gameInterface.disabledText;
                            class1 = SceneTile.method532((byte) 20, gameInterface, class1);
                            while (class1.length() > 0) {
                                int i_52_ = class1.indexOf(Native.lineBreak);
                                String class1_53_;
                                if (i_52_ == -1) {
                                    class1_53_ = class1;
                                    class1 = "";
                                } else {
                                    class1_53_ = class1.substring(0, i_52_);
                                    class1 = class1.substring(2 + i_52_);
                                }
                                int i_54_ = class40_sub5_sub14_sub1.getTextDisplayedWidth(class1_53_);
                                i_51_ += class40_sub5_sub14_sub1.characterDefaultHeight + 1;
                                if (i_50_ < i_54_)
                                    i_50_ = i_54_;
                            }
                            i_51_ += 7;
                            int i_55_ = 5 + gameInterface.originalHeight + i_1_;
                            if (i_55_ + i_51_ > arg5)
                                i_55_ = arg5 + -i_51_;
                            i_50_ += 6;
                            int i_56_ = -5 + gameInterface.originalWidth + i_0_ - i_50_;
                            if (i_56_ < 5 + i_0_)
                                i_56_ = 5 + i_0_;
                            if (i_50_ + i_56_ > arg6)
                                i_56_ = -i_50_ + arg6;
                            Rasterizer.drawFilledRectangle(i_56_, i_55_, i_50_, i_51_, 16777120);
                            Rasterizer.drawUnfilledRectangle(i_56_, i_55_, i_50_, i_51_, 0);
                            class1 = gameInterface.disabledText;
                            int i_57_ = 2 + i_55_ + class40_sub5_sub14_sub1.characterDefaultHeight;
                            class1 = SceneTile.method532((byte) 20, gameInterface, class1);
                            while (class1.length() > 0) {
                                int i_58_ = class1.indexOf(Native.lineBreak);
                                String class1_59_;
                                if (i_58_ == -1) {
                                    class1_59_ = class1;
                                    class1 = "";
                                } else {
                                    class1_59_ = class1.substring(0, i_58_);
                                    class1 = class1.substring(i_58_ + 2);
                                }
                                class40_sub5_sub14_sub1.drawShadowedString(class1_59_, i_56_ + 3, i_57_, false, 0);
                                i_57_ += 1 + class40_sub5_sub14_sub1.characterDefaultHeight;
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.LINE)
                            Rasterizer.drawDiagonalLine(i_0_, i_1_, gameInterface.originalWidth + i_0_, gameInterface.originalHeight + i_1_, gameInterface.textColor);
                    }
                }
            }
        }
        return bool;
    }

    public static void method37(CacheArchive cacheArchive, int arg2) {
        if (Class48.aClass40_Sub1_1132 == null) {
            MovedStatics.method327(true, null, 255, 255, (byte) 0, 0, (byte) 90);
            Class24.aClass6_Sub1Array580[arg2] = cacheArchive;
        } else {
            Class48.aClass40_Sub1_1132.currentPosition = 5 + arg2 * 4;
            int i = Class48.aClass40_Sub1_1132.getIntBE();
            cacheArchive.method200(i, 99);
        }
    }

    public static void renderFlames(int arg0) {
        if (Class40_Sub5_Sub6.anInt2452 <= 0) {
            if (IdentityKit.anInt2613 > 0) {
                for (int i = 0; i < 256; i++) {
                    if (IdentityKit.anInt2613 > 768)
                        Class42.anIntArray1013[i] = UnderlayDefinition.method614(Class51.anIntArray1198[i], Class40_Sub5_Sub17_Sub6.anIntArray3248[i], -IdentityKit.anInt2613 + 1024);
                    else if (IdentityKit.anInt2613 > 256)
                        Class42.anIntArray1013[i] = Class40_Sub5_Sub17_Sub6.anIntArray3248[i];
                    else
                        Class42.anIntArray1013[i] = UnderlayDefinition.method614(Class40_Sub5_Sub17_Sub6.anIntArray3248[i], Class51.anIntArray1198[i], -IdentityKit.anInt2613 + 256);
                }
            } else {
                System.arraycopy(Class51.anIntArray1198, 0, Class42.anIntArray1013, 0, 256);
            }
        } else {
            for (int i = 0; i < 256; i++) {
                if (Class40_Sub5_Sub6.anInt2452 <= 768) {
                    if (Class40_Sub5_Sub6.anInt2452 > 256)
                        Class42.anIntArray1013[i] = Renderable.anIntArray2865[i];
                    else
                        Class42.anIntArray1013[i] = UnderlayDefinition.method614(Renderable.anIntArray2865[i], Class51.anIntArray1198[i], -Class40_Sub5_Sub6.anInt2452 + 256);
                } else
                    Class42.anIntArray1013[i] = UnderlayDefinition.method614(Class51.anIntArray1198[i], Renderable.anIntArray2865[i], -Class40_Sub5_Sub6.anInt2452 + 1024);
            }
        }
        int i = 256;
        System.arraycopy(Class39.aClass40_Sub5_Sub14_Sub4_918.pixels, 0, Class8.flameLeftBackground.pixels, 0, 33920);
        int i_61_ = 0;
        int i_62_ = 1152;
        for (int i_63_ = 1; i - 1 > i_63_; i_63_++) {
            int i_64_ = (-i_63_ + i) * Class17.anIntArray466[i_63_] / i;
            int i_65_ = i_64_ + 22;
            if (i_65_ < 0)
                i_65_ = 0;
            i_61_ += i_65_;
            for (int i_66_ = i_65_; i_66_ < 128; i_66_++) {
                int i_67_ = MovedStatics.anIntArray178[i_61_++];
                if (i_67_ != 0) {
                    int i_68_ = -i_67_ + 256;
                    int i_69_ = i_67_;
                    i_67_ = Class42.anIntArray1013[i_67_];
                    int i_70_ = Class8.flameLeftBackground.pixels[i_62_];
                    Class8.flameLeftBackground.pixels[i_62_++] = HuffmanEncoding.method1021(-16711936, HuffmanEncoding.method1021(i_67_, 16711935) * i_69_ + i_68_ * HuffmanEncoding.method1021(i_70_, 16711935)) + HuffmanEncoding.method1021(HuffmanEncoding.method1021(65280, i_70_) * i_68_ + i_69_ * HuffmanEncoding.method1021(65280, i_67_), 16711680) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += i_65_;
        }
        i_62_ = 1176;
        i_61_ = arg0;
        for (int i_71_ = 0; i_71_ < 33920; i_71_++)
            GameObject.flameRightBackground.pixels[i_71_] = SceneTile.aClass40_Sub5_Sub14_Sub4_2043.pixels[i_71_];
        for (int i_72_ = 1; i_72_ < -1 + i; i_72_++) {
            int i_73_ = (-i_72_ + i) * Class17.anIntArray466[i_72_] / i;
            int i_74_ = 103 + -i_73_;
            i_62_ += i_73_;
            for (int i_75_ = 0; i_75_ < i_74_; i_75_++) {
                int i_76_ = MovedStatics.anIntArray178[i_61_++];
                if (i_76_ != 0) {
                    int i_77_ = i_76_;
                    int i_78_ = GameObject.flameRightBackground.pixels[i_62_];
                    int i_79_ = 256 + -i_76_;
                    i_76_ = Class42.anIntArray1013[i_76_];
                    GameObject.flameRightBackground.pixels[i_62_++] = HuffmanEncoding.method1021(i_77_ * HuffmanEncoding.method1021(65280, i_76_) + i_79_ * HuffmanEncoding.method1021(65280, i_78_), 16711680) + HuffmanEncoding.method1021(i_79_ * HuffmanEncoding.method1021(16711935, i_78_) + HuffmanEncoding.method1021(16711935, i_76_) * i_77_, -16711936) >> 8;
                } else
                    i_62_++;
            }
            i_62_ += 128 - (i_74_ + i_73_);
            i_61_ += -i_74_ + 128;
        }
    }

    public static void main(String[] args) {
        Configuration.read();
        Native.username = Configuration.getUsername();
        Native.password = Configuration.getPassword();
        String[] params = new String[]{"1", "live", "live", "highmem", "members"};
        if(args.length != 0) {
            params = args;
        }
        try {
            if (params.length != 5)
                Class37.method432();
            Player.worldId = Integer.parseInt(params[0]);
            if (!params[1].equals("live")) {
                if (params[1].equals("office"))
                    Class44.modewhere = 1;
                else if (params[1].equals("local"))
                    Class44.modewhere = 2;
                else
                    Class37.method432();
            } else
                Class44.modewhere = 0;
            if (params[2].equals("live"))
                Class44.modewhat = 0;
            else if (!params[2].equals("rc")) {
                if (params[2].equals("wip"))
                    Class44.modewhat = 2;
                else
                    Class37.method432();
            } else
                Class44.modewhat = 1;
            if (params[3].equals("lowmem"))
                Class59.setLowMemory();
            else if (params[3].equals("highmem"))
                Class8.setHighMemory();
            else
                Class37.method432();
            if (!params[4].equals("free")) {
                if (params[4].equals("members"))
                    Class22.membersWorld = true;
                else
                    Class37.method432();
            } else
                Class22.membersWorld = false;
            Main main = new Main();
            main.openClientApplet("runescape", 13, 32 + Class44.modewhat, InetAddress.getByName(Configuration.SERVER_ADDRESS), 435);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static int method42(int arg0, int arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
        arg5 &= 0x3;
        if ((arg0 & arg1) == 1) {
            int i = arg2;
            arg2 = arg4;
            arg4 = i;
        }
        if (arg5 == 0)
            return arg3;
        if (arg5 == 1)
            return arg6;
        if (arg5 == 2)
            return 7 - (arg3 + arg2) + 1;
        return 7 + -arg6 + 1 + -arg4;
    }

    public static void method43(CacheArchive arg0) {
        Class64.aCacheArchive_1521 = arg0;
        Class59.anInt1383 = Class64.aCacheArchive_1521.fileLength(16);
    }

    public static void method44() {
        Class51.aLong1203 = 0L;
        Class12.mouseCapturer.coord = 0;
        Class22_Sub2.duplicateClickCount = 0;
        Class35.aBoolean1735 = true;
        MovedStatics.aBoolean571 = true;
        MovedStatics.method540();
        MovedStatics.anInt324 = -1;
        MovedStatics.menuOpen = false;
        RSString.anInt1690 = -1;
        IncomingPackets.incomingPacket = -1;
        Class40_Sub5_Sub15.systemUpdateTime = 0;
        Class35.anInt1728 = 0;
        Player.headIconDrawType = 0;
        SceneCluster.packetBuffer.currentPosition = 0;
        SceneCluster.idleLogout = 0;
        Class49.anInt1151 = -1;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
        ActorDefinition.menuActionRow = 0;
        Class40_Sub5_Sub13.method650(0);
        for (int i = 0; i < 100; i++)
            ChatBox.chatMessages[i] = null;
        Class8.itemSelected = 0;
        Class57.anInt1342 = -40 + (int) (80.0 * Math.random());
        Class48.cameraOffsetY = -55 + (int) (Math.random() * 110.0);
        VarbitDefinition.destinationX = 0;
        Class43.cameraYawOffset = (int) (Math.random() * 120.0) + -60;
        Buffer.anInt1985 = -1;
        Player.npcCount = 0;
        PacketBuffer.currentSound = 0;
        widgetSelected = 0;
        GroundItemTile.cameraHorizontal = 0x7ff & -10 + (int) (20.0 * Math.random());
        Class51.mapZoomOffset = -20 + (int) (Math.random() * 30.0);
        MovedStatics.minimapState = 0;
        Buffer.cameraOffsetX = -50 + (int) (Math.random() * 100.0);
        Player.localPlayerCount = 0;
        Class55.destinationY = 0;
        for (int i = 0; i < 2048; i++) {
            Player.trackedPlayers[i] = null;
            Player.trackedPlayerAppearanceCache[i] = null;
        }
        for (int i = 0; i < 32768; i++)
            Player.npcs[i] = null;
        Player.localPlayer = Player.trackedPlayers[2047] = new Player();
        Class43.aLinkedList_1022.method906(0);
        Class57.aLinkedList_1332.method906(0);
        for (int i = 0; i < 4; i++) {
            for (int i_82_ = 0; i_82_ < 104; i_82_++) {
                for (int i_83_ = 0; i_83_ < 104; i_83_++)
                    Wall.groundItems[i][i_82_][i_83_] = null;
            }
        }
        LinkedList.aLinkedList_1064 = new LinkedList();
        Player.friendsCount = 0;
        Player.friendListStatus = 0;
        GameInterface.resetInterface(ChatBox.dialogueId);
        ChatBox.dialogueId = -1;
        GameInterface.resetInterface(GameInterface.chatboxInterfaceId);
        GameInterface.chatboxInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.gameScreenInterfaceId);
        GameInterface.gameScreenInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.fullscreenInterfaceId);
        GameInterface.fullscreenInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.fullscreenSiblingInterfaceId);
        GameInterface.fullscreenSiblingInterfaceId = -1;
        GameInterface.resetInterface(GameInterface.tabAreaInterfaceId);
        GameInterface.tabAreaInterfaceId = -1;
        GameInterface.resetInterface(GroundItemTile.walkableWidgetId);
        ChatBox.inputType = 0;
        ChatBox.messagePromptRaised = false;
        MovedStatics.menuOpen = false;
        GroundItemTile.walkableWidgetId = -1;
        Native.clickToContinueString = null;
        MovedStatics.anInt1819 = -1;
        Class51.anInt1205 = -1;
        Class40_Sub6.anInt2118 = 0;
        Player.currentTabId = 3;
        Player.activePlayerAppearance.setPlayerAppearance(null, false, new int[5], -1);
        for (int i = 0; i < 5; i++) {
            playerActions[i] = null;
            Class13.playerArray[i] = false;
        }
        ISAAC.aBoolean519 = true;
    }

    public static void method353(byte arg0) {
        Class40_Sub5_Sub11.anInt2628++;
        Class40_Sub5_Sub17_Sub6.method833(0, true);
        ItemDefinition.method749(true);
        Class40_Sub5_Sub17_Sub6.method833(0, false);
        ItemDefinition.method749(false);
        MovedStatics.method335((byte) 61);
        MovedStatics.method1000(true);
        if(!Player.cutsceneActive) {
            int i = Class65.cameraVertical;
            if(Class40_Sub6.secondaryCameraVertical / 256 > i) {
                i = Class40_Sub6.secondaryCameraVertical / 256;
            }
            int i_0_ = 0x7ff & GroundItemTile.cameraHorizontal + Class57.anInt1342;
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[4] && 128 + anIntArray2[4] > i) {
                i = 128 + anIntArray2[4];
            }
            Class49.setCameraPosition(i, Class40_Sub5_Sub6.currentCameraPositionH, -50 + Class37.getFloorDrawHeight(Player.worldLevel, Player.localPlayer.worldX, Player.localPlayer.worldY), i_0_, Class34.currentCameraPositionV, -1, 3 * i + 600);
        }
        int i;
        if(!Player.cutsceneActive) {
            i = Class40_Sub5_Sub17_Sub1.method764((byte) -107);
        } else {
            i = MovedStatics.method546(256);
        }
        int i_1_ = Class12.cameraX;
        int i_2_ = ProducingGraphicsBuffer_Sub1.anInt2210;
        int i_3_ = SceneCluster.cameraZ;
        int i_4_ = Class26.anInt627;
        int i_5_ = Class40_Sub5_Sub6.cameraY;
        for(int i_6_ = 0; i_6_ < 5; i_6_++) {
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[i_6_]) {
                int i_7_ = (int) ((double) (Class8.anIntArray297[i_6_] * 2 + 1) * Math.random() - (double) Class8.anIntArray297[i_6_] + Math.sin((double) Class22_Sub1.anIntArray1846[i_6_] * ((double) GroundItemTile.anIntArray1358[i_6_] / 100.0)) * (double) anIntArray2[i_6_]);
                if(i_6_ == 1) {
                    SceneCluster.cameraZ += i_7_;
                }
                if(i_6_ == 0) {
                    Class12.cameraX += i_7_;
                }
                if(i_6_ == 2) {
                    Class40_Sub5_Sub6.cameraY += i_7_;
                }
                if(i_6_ == 4) {
                    Class26.anInt627 += i_7_;
                    if(Class26.anInt627 < 128) {
                        Class26.anInt627 = 128;
                    }
                    if(Class26.anInt627 > 383) {
                        Class26.anInt627 = 383;
                    }
                }
                if(i_6_ == 3) {
                    ProducingGraphicsBuffer_Sub1.anInt2210 = 0x7ff & i_7_ + ProducingGraphicsBuffer_Sub1.anInt2210;
                }
            }
        }
        Class65.method1018();
        Model.cursorY = Landscape.mouseY - 4;
        Model.gameScreenClickable = true;
        Model.cursorX = Class13.mouseX - 4;
        Model.resourceCount = 0;
        Rasterizer.resetPixels();
        Npc.currentScene.render(Class12.cameraX, SceneCluster.cameraZ, Class40_Sub5_Sub6.cameraY, Class26.anInt627, ProducingGraphicsBuffer_Sub1.anInt2210, i);
        Npc.currentScene.clearInteractiveObjectCache();
        Class33.method404((byte) -28);
        MovedStatics.method450((byte) -67);
        ((Class35) Rasterizer3D.anInterface3_2939).method425((byte) 6, MovedStatics.anInt199);
        KeyFocusListener.draw3dScreen();

        if(ScreenController.frameMode == ScreenMode.FIXED) {
            Console.console.drawConsole(512, 334);
            Console.console.drawConsoleArea(512, 334);
        } else {
            ScreenController.RenderResizableUI();
            Console.console.drawConsole(ScreenController.frameWidth, 334);
            Console.console.drawConsoleArea(ScreenController.frameWidth, 334);
        }


        if(ISAAC.aBoolean519 && MovedStatics.method368((byte) -41, false, true) == 0) {
            ISAAC.aBoolean519 = false;
        }
        if(ISAAC.aBoolean519) {
            Class65.method1018();
            Rasterizer.resetPixels();
            Class51.method940(0, English.loadingPleaseWait, false, null);
        }

        Player.drawGameScreenGraphics(110);
        Class12.cameraX = i_1_;
        Class40_Sub5_Sub6.cameraY = i_5_;
        ProducingGraphicsBuffer_Sub1.anInt2210 = i_2_;
        Class26.anInt627 = i_4_;
        SceneCluster.cameraZ = i_3_;
        if(arg0 >= -98) {
            GameInterface.drawScrollBar(0, -27, 3, 10, 23, -36);
        }
    }

    public static void method357(CacheArchive arg0, int arg1, CacheArchive arg2) {
        GroundItemTile.aCacheArchive_1375 = arg2;
        ActorDefinition.count = GroundItemTile.aCacheArchive_1375.fileLength(9);

        MovedStatics.aCacheArchive_1577 = arg0;
        if(arg1 == -10978) {
            return;
        }
        drawGameScreen();

    }

    public static IndexedImage method359(String arg0, String arg1, CacheArchive arg2) {
        int i = arg2.getHash(arg0);
        int i_23_ = arg2.method179(i, arg1);
        return method363(arg2, (byte) -42, i_23_, i);
    }

    public static IndexedImage method363(CacheArchive arg0, byte arg1, int arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg2, arg3, arg0)) {
            return null;
        }
        return MovedStatics.method538(0);

    }

    public static void method364(byte arg0, boolean arg1) {
        if(arg0 != -34) {
            MovedStatics.method368((byte) 123, true, false);
        }
        Class22.anInt537++;
        if(Class22.anInt537 >= 50 || arg1) {
            Class22.anInt537 = 0;
            if(!Class37.aBoolean871 && Class40_Sub6.gameConnection != null) {
                SceneCluster.packetBuffer.putPacket(13);
                try {
                    Class40_Sub6.gameConnection.method1010(SceneCluster.packetBuffer.currentPosition, (byte) -19, 0, SceneCluster.packetBuffer.buffer);
                    SceneCluster.packetBuffer.currentPosition = 0;
                } catch(java.io.IOException ioexception) {
                    Class37.aBoolean871 = true;
                }
            }
        }
    }

    public static void drawGameScreen() {
        if(Class40_Sub5_Sub11.clearScreen) {
            Class40_Sub5_Sub11.clearScreen = false;
            ItemDefinition.drawWelcomeScreenGraphics();
            GameInterface.drawTabIcons = true;
            ChatBox.redrawChatbox = true;
            GameInterface.redrawTabArea = true;
            MovedStatics.redrawChatbox = true;
            drawCount++;
        } else if(drawCount != 0) {
            Class40_Sub5_Sub17_Sub1.method763(MouseHandler.aCanvas1469, CacheArchive.gameImageCacheArchive);
        }
        if(GameInterface.chatboxInterfaceId == -1) {
            Class12.chatboxInterface.scrollPosition = -77 + -ChatBox.chatboxScroll + ChatBox.chatboxScrollMax;
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332) {
                GameInterface.scrollInterface(77, Landscape.mouseY + -357, -17 + Class13.mouseX, ChatBox.chatboxScrollMax, Class12.chatboxInterface, 463, -1, 0);
            }
            int currentScroll = ChatBox.chatboxScrollMax - 77 - Class12.chatboxInterface.scrollPosition;
            if(currentScroll < 0) {
                currentScroll = 0;
            }
            if(currentScroll > ChatBox.chatboxScrollMax + -77) {
                currentScroll = -77 + ChatBox.chatboxScrollMax;
            }
            if(currentScroll != ChatBox.chatboxScroll) {
                ChatBox.chatboxScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }
        if(GameInterface.chatboxInterfaceId == -1 && ChatBox.inputType == 3) {
            Class12.chatboxInterface.scrollPosition = ChatBox.itemSearchScroll;
            int scrollMax = 14 * ChatBox.itemSearchResultCount + 7;
            if(Class13.mouseX > 448 && Class13.mouseX < 560 && Landscape.mouseY > 332) {
                GameInterface.scrollInterface(77, Landscape.mouseY - 357, -17 + Class13.mouseX, scrollMax, Class12.chatboxInterface, 463, -1, 0);
            }
            int currentScroll = Class12.chatboxInterface.scrollPosition;
            if(currentScroll < 0) {
                currentScroll = 0;
            }
            if(currentScroll > scrollMax - 77) {
                currentScroll = scrollMax - 77;
            }
            if(currentScroll != ChatBox.itemSearchScroll) {
                ChatBox.itemSearchScroll = currentScroll;
                ChatBox.redrawChatbox = true;
            }
        }
        if(ScreenController.frameMode == ScreenMode.FIXED) {

            if(MovedStatics.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 1) {
                GameInterface.redrawTabArea = true;
            }
            if(GameInterface.tabAreaInterfaceId != -1) {
                boolean bool = Renderable.handleSequences(GameInterface.tabAreaInterfaceId);
                if(bool) {
                    GameInterface.redrawTabArea = true;
                }
            }
            method353((byte) -114);

            if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == -3) {
                GameInterface.redrawTabArea = true;
            }
            if(SceneTile.activeInterfaceType == 2) {
                GameInterface.redrawTabArea = true;
            }
            Class43.drawTabArea(-29);

            if(GameInterface.chatboxInterfaceId != -1) {
                boolean bool = Renderable.handleSequences(GameInterface.chatboxInterfaceId);
                if(bool) {
                    ChatBox.redrawChatbox = true;
                }
            }
            if(Class40_Sub5_Sub17_Sub1.atInventoryInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if(SceneTile.activeInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if(Native.clickToContinueString != null) {
                ChatBox.redrawChatbox = true;
            }
            if(MovedStatics.menuOpen && Class40_Sub5_Sub17_Sub1.menuScreenArea == 2) {
                ChatBox.redrawChatbox = true;
            }
            if(ChatBox.redrawChatbox) {
                ChatBox.redrawChatbox = false;
                ChatBox.renderChatbox();
                //            Console.console.drawConsoleArea();
            }

            Class37.renderMinimap();


            if(Class51.anInt1205 != -1) {
                GameInterface.drawTabIcons = true;
            }
            if(GameInterface.drawTabIcons) {
                if(Class51.anInt1205 != -1 && Class51.anInt1205 == Player.currentTabId) {
                    Class51.anInt1205 = -1;
                    SceneCluster.packetBuffer.putPacket(44);
                    SceneCluster.packetBuffer.putByte(Player.currentTabId);
                }
                GameInterface.drawTabIcons = false;
                Class40_Sub3.aBoolean2026 = true;
                Class40_Sub2.method527(Player.currentTabId, 4, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
            }
            if(MovedStatics.redrawChatbox) {
                Class40_Sub3.aBoolean2026 = true;
                MovedStatics.redrawChatbox = false;
                GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            Landscape.method934(Player.localPlayer.worldX, Player.worldLevel, MovedStatics.anInt199, Player.localPlayer.worldY);
            MovedStatics.anInt199 = 0;

        } else {


            if(GameInterface.tabAreaInterfaceId != -1) {
                Renderable.handleSequences(GameInterface.tabAreaInterfaceId);
            }

            if(GameInterface.chatboxInterfaceId != -1) {
                boolean bool = Renderable.handleSequences(GameInterface.chatboxInterfaceId);
            }
            method353((byte) -114);
            ChatBox.renderChatbox();

            Class43.drawTabArea(-29);

            Class37.renderMinimap();


            if(Class51.anInt1205 != -1) {
                GameInterface.drawTabIcons = true;
            }
            if(GameInterface.drawTabIcons) {
                if(Class51.anInt1205 != -1 && Class51.anInt1205 == Player.currentTabId) {
                    Class51.anInt1205 = -1;
                    SceneCluster.packetBuffer.putPacket(44);
                    SceneCluster.packetBuffer.putByte(Player.currentTabId);
                }
                GameInterface.drawTabIcons = false;
                Class40_Sub3.aBoolean2026 = true;
                Class40_Sub2.method527(Player.currentTabId, 4, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
            }
            if(MovedStatics.redrawChatbox) {
                Class40_Sub3.aBoolean2026 = true;
                MovedStatics.redrawChatbox = false;
                GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            Landscape.method934(Player.localPlayer.worldX, Player.worldLevel, MovedStatics.anInt199, Player.localPlayer.worldY);
            MovedStatics.anInt199 = 0;
        }

    }

    public static void displayMessageForResponseCode(int responseCode) {
        if(responseCode == -3) {
            Class33.setLoginScreenMessage(English.connectionTimedOut, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == -2) {
            Class33.setLoginScreenMessage("", English.errorConnectingToServer, "");
        } else if(responseCode == -1) {
            Class33.setLoginScreenMessage(English.noResponseFromServer, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 3) {
            Class33.setLoginScreenMessage("", English.invalidUsernameOrPassword, "");
        } else if(responseCode == 4) {
            Class33.setLoginScreenMessage(English.yourAccountHasBeenDisabled, English.pleaseCheckYourMessageCenterForDetails, "");
        } else if(responseCode == 5) {
            Class33.setLoginScreenMessage(English.yourAccountIsAlreadyLoggedIn, English.tryAgainIn60Secs, "");
        } else if(responseCode == 6) {
            Class33.setLoginScreenMessage(English.runeScapeHasBeenUpdated, English.pleaseReloadThisPage, "");
        } else if(responseCode == 7) {
            Class33.setLoginScreenMessage(English.theWorldIsFull, English.pleaseUseADifferentWorld, "");
        } else if(responseCode == 8) {
            Class33.setLoginScreenMessage(English.unableToConnect, English.loginServerOffline, "");
        } else if(responseCode == 9) {
            Class33.setLoginScreenMessage(English.loginLimitExceeded, English.tooManyConnectionsFromYourAddress, "");
        } else if(responseCode == 10) {
            Class33.setLoginScreenMessage(English.unableToConnect, English.badSessionId, "");
        } else if(responseCode == 11) {
            Class33.setLoginScreenMessage(English.weSuspectSomeoneKnowsYourPassword, English.pressChangeYourPasswordOnFrontPage, "");
        } else if(responseCode == 12) {
            Class33.setLoginScreenMessage(English.youNeedMembersAccountToLoginToThisWorld, English.pleaseSubscribeOrUseDifferentWorld, "");
        } else if(responseCode == 13) {
            Class33.setLoginScreenMessage(English.couldNotCompleteLogin, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 14) {
            Class33.setLoginScreenMessage(English.theServerIsBeingUpdated, English.pleaseWait1MinuteAndTryAgain, "");
        } else if(responseCode == 16) {
            Class33.setLoginScreenMessage(English.tooManyIncorrectLoginsFromYourAddress, English.pleaseWait5MinutesBeforeTryingAgain, "");
        } else if(responseCode == 17) {
            Class33.setLoginScreenMessage(English.youAreStandingInMembersOnlyArea, English.toPlayOnThisWorldMoveToFreeArea, "");
        } else if(responseCode == 18) {
            Class33.setLoginScreenMessage(English.accountLockedAsWeSuspectItHasBeenStolen, English.pressRecoverLockedAccountOnFrontPage, "");
        } else if(responseCode == 20) {
            Class33.setLoginScreenMessage(English.invalidLoginserverRequested, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 22) {
            Class33.setLoginScreenMessage(English.malformedLoginPacket, English.pleaseTryAgain, "");
        } else if(responseCode == 23) {
            Class33.setLoginScreenMessage(English.noReplyFromLoginserver, English.pleaseWait1MinuteAndTryAgain, "");
        } else if(responseCode == 24) {
            Class33.setLoginScreenMessage(English.errorLoadingYourProfile, English.pleaseContactCustomerSupport, "");
        } else if(responseCode == 25) {
            Class33.setLoginScreenMessage(English.unexpectedLoginserverResponse, English.pleaseTryUsingDifferentWorld, "");
        } else if(responseCode == 26) {
            Class33.setLoginScreenMessage(English.thisComputersAddressHasBeenBlocked, English.asItWasUsedToBreakOurRules, "");
        } else if(responseCode == 27) {
            Class33.setLoginScreenMessage("", English.serviceUnavailable, "");
        } else {
            Class33.setLoginScreenMessage(English.unexpectedServerResponse, English.pleaseTryUsingDifferentWorld, "");
        }
        OverlayDefinition.method559(10);
    }

    public static void method164() {
        Renderable.handleSequences(GameInterface.fullscreenInterfaceId);
        if(GameInterface.fullscreenSiblingInterfaceId != -1)
            Renderable.handleSequences(GameInterface.fullscreenSiblingInterfaceId);
        MovedStatics.anInt199 = 0;
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213.prepareRasterizer();
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(Player.viewportOffsets);
        Rasterizer.resetPixels();
        Class40_Sub5_Sub6.drawInterface(0, GameInterface.fullscreenInterfaceId, 503, (byte) -5, 0, 0, 765);
        if(GameInterface.fullscreenSiblingInterfaceId != -1)
            Class40_Sub5_Sub6.drawInterface(0, GameInterface.fullscreenSiblingInterfaceId, 503, (byte) -5, 0, 0, 765);
        if(!MovedStatics.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else
            if(ScreenController.frameMode == ScreenMode.FIXED && Class40_Sub5_Sub17_Sub1.menuScreenArea == 0){
                Class40_Sub5_Sub6.drawMenu(4,4); // might be 0,0
            }
        try {
            Graphics graphics = MouseHandler.aCanvas1469.getGraphics();
            ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213.drawGraphics(0, 0, graphics);
        } catch(Exception exception) {
            MouseHandler.aCanvas1469.repaint();
        }
    }

    public static void method165(int arg0) {
        int i = 64 + SceneCluster.anInt767 * 128;
        int i_3_ = 64 + 128 * Class22.anInt545;
        int i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, i_3_, i) + -MovedStatics.anInt194;
        if(i_3_ > Class12.cameraX) {
            Class12.cameraX += Class59.anInt1386 * (i_3_ + -Class12.cameraX) / 1000 + MovedStatics.anInt188;
            if(Class12.cameraX > i_3_) {
                Class12.cameraX = i_3_;
            }
        }
        if(i_4_ > SceneCluster.cameraZ) {
            SceneCluster.cameraZ += Class59.anInt1386 * (i_4_ - SceneCluster.cameraZ) / 1000 + MovedStatics.anInt188;
            if(i_4_ < SceneCluster.cameraZ)
                SceneCluster.cameraZ = i_4_;
        }
        if(Class12.cameraX > i_3_) {
            Class12.cameraX -= MovedStatics.anInt188 + Class59.anInt1386 * (Class12.cameraX + -i_3_) / 1000;
            if(i_3_ > Class12.cameraX) {
                Class12.cameraX = i_3_;
            }
        }
        if(Class40_Sub5_Sub6.cameraY < i) {
            Class40_Sub5_Sub6.cameraY += MovedStatics.anInt188 + Class59.anInt1386 * (-Class40_Sub5_Sub6.cameraY + i) / 1000;
            if(Class40_Sub5_Sub6.cameraY > i)
                Class40_Sub5_Sub6.cameraY = i;
        }
        if(SceneCluster.cameraZ > i_4_) {
            SceneCluster.cameraZ -= (SceneCluster.cameraZ + -i_4_) * Class59.anInt1386 / 1000 + MovedStatics.anInt188;
            if(i_4_ > SceneCluster.cameraZ)
                SceneCluster.cameraZ = i_4_;
        }
        i_3_ = 64 + MovedStatics.anInt564 * 128;
        if(Class40_Sub5_Sub6.cameraY > i) {
            Class40_Sub5_Sub6.cameraY -= MovedStatics.anInt188 + Class59.anInt1386 * (Class40_Sub5_Sub6.cameraY - i) / 1000;
            if(Class40_Sub5_Sub6.cameraY < i)
                Class40_Sub5_Sub6.cameraY = i;
        }
        i = UnderlayDefinition.anInt2576 * 128 + 64;
        i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, i_3_, i) - MovedStatics.anInt892;
        int i_5_ = -SceneCluster.cameraZ + i_4_;
        int i_6_ = i - Class40_Sub5_Sub6.cameraY;
        int i_7_ = i_3_ - Class12.cameraX;
        int i_8_ = (int) Math.sqrt((double) (i_7_ * i_7_ + i_6_ * i_6_));
        int i_9_ = 0x7ff & (int) (Math.atan2((double) i_5_, (double) i_8_) * 325.949);
        if(i_9_ < 128)
            i_9_ = 128;
        int i_10_ = 0x7ff & (int) (-325.949 * Math.atan2((double) i_7_, (double) i_6_));
        if(i_9_ > 383)
            i_9_ = 383;
        int i_11_ = -ProducingGraphicsBuffer_Sub1.anInt2210 + i_10_;
        if(i_11_ > 1024)
            i_11_ -= 2048;
        if(i_11_ < -1024)
            i_11_ += 2048;
        if(i_11_ > 0) {
            ProducingGraphicsBuffer_Sub1.anInt2210 += Class22_Sub1.anInt1856 * i_11_ / 1000 + Class60.anInt1413;
            ProducingGraphicsBuffer_Sub1.anInt2210 &= 0x7ff;
        }
        if(arg0 > 0) {
            if(i_11_ < 0) {
                ProducingGraphicsBuffer_Sub1.anInt2210 -= Class60.anInt1413 + Class22_Sub1.anInt1856 * -i_11_ / 1000;
                ProducingGraphicsBuffer_Sub1.anInt2210 &= 0x7ff;
            }
            if(i_9_ > Class26.anInt627) {
                Class26.anInt627 += Class60.anInt1413 + Class22_Sub1.anInt1856 * (i_9_ - Class26.anInt627) / 1000;
                if(Class26.anInt627 > i_9_)
                    Class26.anInt627 = i_9_;
            }
            if(Class26.anInt627 > i_9_) {
                Class26.anInt627 -= Class22_Sub1.anInt1856 * (Class26.anInt627 + -i_9_) / 1000 + Class60.anInt1413;
                if(Class26.anInt627 < i_9_)
                    Class26.anInt627 = i_9_;
            }
            int i_12_ = i_10_ + -ProducingGraphicsBuffer_Sub1.anInt2210;
            if(i_12_ > 1024)
                i_12_ -= 2048;
            if(i_12_ < -1024)
                i_12_ += 2048;
            if(i_12_ < 0 && i_11_ > 0 || i_12_ > 0 && i_11_ < 0)
                ProducingGraphicsBuffer_Sub1.anInt2210 = i_10_;
        }
    }

    public void method35(int arg1) {
        if (Wall.anInt350 != OverlayDefinition.anInt2340)
            Wall.anInt350 = OverlayDefinition.anInt2340;
        else
            Wall.anInt350 = CollisionMap.anInt172;
        Class29.aClass64_676 = null;
        ProducingGraphicsBuffer.aSignlinkNode_1632 = null;
        Class8.anInt292++;
        Class8.anInt290 = 0;
        if (Class8.anInt292 < 2 || arg1 != 7 && arg1 != 9) {
            if (Class8.anInt292 < 2 || arg1 != 6) {
                if (Class8.anInt292 >= 4) {
                    if (Class51.anInt1197 <= 5) {
                        this.openErrorPage((byte) 104, "js5connect");
                        Class51.anInt1197 = 1000;
                    } else
                        ISAAC.anInt509 = 3000;
                }
            } else {
                this.openErrorPage((byte) 86, "js5connect_outofdate");
                Class51.anInt1197 = 1000;
            }
        } else if (Class51.anInt1197 > 5)
            ISAAC.anInt509 = 3000;
        else {
            this.openErrorPage((byte) 122, "js5connect_full");
            Class51.anInt1197 = 1000;
        }
    }

    public void processGameLoop() {
        MovedStatics.pulseCycle++;
        method39();
        Class13.method242((byte) -91);
        Class33.method413((byte) -116);
        RSRuntimeException.method1054((byte) 125);
        GameInterface.method639(122);
        Class64.method1015();

        if (Class51.anInt1197 == 0) {
            Class40_Sub3.startup(100);
            Class60.method992();
        } else if (Class51.anInt1197 == 5) {
            Class40_Sub3.startup(100);
            Class60.method992();
        } else if (Class51.anInt1197 == 10) {
            Class60.updateLogin();
        } else if (Class51.anInt1197 == 20) {
            Class60.updateLogin();
            SpotAnimDefinition.method552(true);
        } else if (Class51.anInt1197 == 25)
            Landscape.loadRegion();
        if (Class51.anInt1197 == 30) {
            ScreenController.refreshFrameSize();
            Npc.updateGame();
        } else if (Class51.anInt1197 == 35) {
            ScreenController.refreshFrameSize();
            Npc.updateGame();
        } else if (Class51.anInt1197 == 40) {
            SpotAnimDefinition.method552(true);
        }
    }

    public void method39() {
        if (1000 != Class51.anInt1197) {
            boolean bool = FloorDecoration.method346((byte) 48);
            if (!bool)
                method40();
        }
    }

    public void method34(int arg0) { // TODO: Might be Startup
        if (MovedStatics.aBoolean1575) {
            Class22_Sub1.method311(MouseHandler.aCanvas1469);
            Class55.method965(32, MouseHandler.aCanvas1469);
            this.setCanvas((byte) 86);
            GameInterface.method642(MouseHandler.aCanvas1469, -10);
            RSRuntimeException.method1056(MouseHandler.aCanvas1469, (byte) 33);
        }
        if (Class51.anInt1197 == 0)
            GameObject.drawLoadingText(MovedStatics.anInt1607, null, Native.currentLoadingText);
        else if (Class51.anInt1197 == 5) {
            WallDecoration.method951(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.anInt1197 == 10) {
            WallDecoration.method951(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.anInt1197 == 20) {
            WallDecoration.method951(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.anInt1197 == 25) {
            if (ProducingGraphicsBuffer.anInt1634 == 1) {
                if (Class37.anInt874 > PacketBuffer.anInt2231)
                    PacketBuffer.anInt2231 = Class37.anInt874;
                int i = (-Class37.anInt874 + PacketBuffer.anInt2231) * 50 / PacketBuffer.anInt2231;
                Class51.method940(0, English.loadingPleaseWait, true, Native.leftParenthasis + i + Native.aClass1_698);
            } else if (ProducingGraphicsBuffer.anInt1634 == 2) {
                if (IdentityKit.anInt2591 > GameObject.anInt3048)
                    GameObject.anInt3048 = IdentityKit.anInt2591;
                int i = 50 * (-IdentityKit.anInt2591 + GameObject.anInt3048) / GameObject.anInt3048 + 50;
                Class51.method940(0, English.loadingPleaseWait, true, Native.leftParenthasis + i + Native.aClass1_698);
            } else
                Class51.method940(0, English.loadingPleaseWait, false, null);
        } else if (Class51.anInt1197 == 30) {
            drawGameScreen();

        } else if (Class51.anInt1197 == 35) {
            method164();
        } else if (Class51.anInt1197 == 40)
            Class51.method940(0, English.connectionLost, false, English.pleaseWaitAttemptingToReestablish);
        Npc.anInt3294 = 0;
    }

    public void method40() {
        if (Class34.anInt813 >= 4) {
            this.openErrorPage((byte) 120, "js5crc");
            Class51.anInt1197 = 1000;
        } else {
            if (MovedStatics.anInt2278 >= 4) {
                if (Class51.anInt1197 > 5) {
                    MovedStatics.anInt2278 = 3;
                    ISAAC.anInt509 = 3000;
                } else {
                    this.openErrorPage((byte) 58, "js5io");
                    Class51.anInt1197 = 1000;
                    return;
                }
            }
            if (ISAAC.anInt509-- <= 0) {
                do {
                    try {
                        if (Class8.anInt290 == 0) {
                            ProducingGraphicsBuffer.aSignlinkNode_1632 = signlink.method395(5 ^ 0x6, Wall.anInt350);
                            Class8.anInt290++;
                        }
                        if (Class8.anInt290 == 1) {
                            if (ProducingGraphicsBuffer.aSignlinkNode_1632.anInt434 == 2) {
                                method35(-1);
                                break;
                            }
                            if (ProducingGraphicsBuffer.aSignlinkNode_1632.anInt434 == 1)
                                Class8.anInt290++;
                        }
                        if (Class8.anInt290 == 2) {
                            Class29.aClass64_676 = new Class64((Socket) ProducingGraphicsBuffer.aSignlinkNode_1632.value, signlink);
                            Buffer class40_sub1 = new Buffer(5);
                            class40_sub1.putByte(15);
                            class40_sub1.putIntBE(435);
                            Class29.aClass64_676.method1010(5, (byte) -19, 0, class40_sub1.buffer);
                            Class8.anInt290++;
                            Class22_Sub1.aLong1841 = System.currentTimeMillis();
                        }
                        if (Class8.anInt290 == 3) {
                            if (Class51.anInt1197 > 5 && Class29.aClass64_676.method1014(5 + -131) <= 0) {
                                if (System.currentTimeMillis() + -Class22_Sub1.aLong1841 > 30000L) {
                                    method35(-2);
                                    break;
                                }
                            } else {
                                int i = Class29.aClass64_676.read();
                                if (i != 0) {
                                    method35(i);
                                    break;
                                }
                                Class8.anInt290++;
                            }
                        }
                        if (Class8.anInt290 != 4)
                            break;
                        Class17.method273(Class29.aClass64_676, 105, Class51.anInt1197 > 20);
                        ProducingGraphicsBuffer.aSignlinkNode_1632 = null;
                        Class8.anInt290 = 0;
                        Class29.aClass64_676 = null;
                        Class8.anInt292 = 0;
                    } catch (java.io.IOException ioexception) {
                        ioexception.printStackTrace();
                        method35(-3);
                        break;
                    }
                    break;
                } while (false);
            }
        }
    }

    public void method24() {
        if (Class12.mouseCapturer != null)
            Class12.mouseCapturer.aBoolean913 = false;
        Class12.mouseCapturer = null;
        if (Class40_Sub6.gameConnection != null) {
            Class40_Sub6.gameConnection.method1009();
            Class40_Sub6.gameConnection = null;
        }
        ItemDefinition.method744();
        Class13.method249(true);
        Class33.method407(false);
        Class60.method989();
        ActorDefinition.method567();
        GenericTile.method947(-1);
        do {
            try {
                if (dataChannel != null)
                    dataChannel.close();
                if (indexChannels != null) {
                    for (int i = 0; i < indexChannels.length; i++) {
                        if (indexChannels[i] != null)
                            indexChannels[i].close();
                    }
                }
                if (metaChannel == null)
                    break;
                metaChannel.close();
            } catch (java.io.IOException ioexception) {
                break;
            }
            break;
        } while (false);
    }


    public void startup(boolean arg0) {
        CollisionMap.anInt172 = Class44.modewhere == 0 ? 443 : 50000 + Player.worldId;
        OverlayDefinition.anInt2340 = Class44.modewhere != 0 ? Player.worldId + 40000 : Configuration.GAME_PORT;
        if (!arg0)
            aBoolean1790 = true;
        Wall.anInt350 = OverlayDefinition.anInt2340;
        MovedStatics.method997(47);
        GameInterface.method642(MouseHandler.aCanvas1469, -10);
        RSRuntimeException.method1056(MouseHandler.aCanvas1469, (byte) 70);
        RSCanvas.anInt57 = Signlink.anInt737;
        try {
            if (signlink.cacheDataAccessFile != null) {
                dataChannel = new CacheFileChannel(signlink.cacheDataAccessFile, 5200);
                for (int i = 0; i < 13; i++)
                    indexChannels[i] = new CacheFileChannel(signlink.dataIndexAccessFiles[i], 6000);
                metaChannel = new CacheFileChannel(signlink.metaIndexAccessFile, 6000);
                gameCache = new CacheIndex(255, dataChannel, metaChannel, 500000);
                signlink.dataIndexAccessFiles = null;
                signlink.metaIndexAccessFile = null;
                signlink.cacheDataAccessFile = null;
            }
        } catch (java.io.IOException ioexception) {
            gameCache = null;
            dataChannel = null;
            metaChannel = null;
        }
        if (Class44.modewhere != 0)
            InteractiveObject.showFps = true;
        Class12.chatboxInterface = new GameInterface();
    }
}
