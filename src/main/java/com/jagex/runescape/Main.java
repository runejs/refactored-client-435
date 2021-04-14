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
    public static CacheIndex metaIndex;
    public static CacheFileChannel dataChannel;
    public static CacheFileChannel metaChannel;
    public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
    private static int drawCount = 0;

    /**
     * This method is used to draw interfaces on the client. It uses the parent of -1,
     * which means it will render the widget on the top most level. It takes in a widget ID
     * and finds its children within the cached interfaces.
     *
     * @param areaId Mostly used for logical checks
     *   0 = Game area (the area that renders in 3D),
     *   1 = Tab area (the widgets that display within the tab area),
     *   2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
     *   3 = TODO unknown, might be permanent chat widgets
     * @param minX The top right X of this widget's boundaries
     * @param minY The top right Y of this widget's boundaries
     * @param maxX The bottom right Y of this widget's boundaries
     * @param maxY The bottom right X of this widget's boundaries
     * @param widgetId The widget ID
     * @return The status of the drawing cycle, true for success and false for failure
     */
    public static boolean drawParentInterface(int areaId, int minX, int minY, int maxX, int maxY, int widgetId) {
        if(!GameInterface.decodeGameInterface(widgetId))
            return false;

        return drawInterface(areaId, minX, minY, maxX, maxY, 0, 0, GameInterface.cachedInterfaces[widgetId], -1, true);
    }

    /**
     * Recursive function that draws all the widgets within a GameInterface array.
     * @param areaId Mostly used for logical checks
     *   0 = Game area (the area that renders in 3D),
     *   1 = Tab area (the widgets that display within the tab area),
     *   2 = Chat area (the chat itself, as well as all sorts of dialogues and anything that renders over the chat)
     *   3 = TODO unknown, might be permanent chat widgets
     * @param minX The top right X of this widget's boundaries
     * @param minY The top right Y of this widget's boundaries
     * @param maxX The bottom right X of this widget's boundaries
     * @param maxY The bottom right Y of this widget's boundaries
     * @param scrollPosition The current scroll position within this widget
     * @param scrollWidth The current scroll width within this widget (unused)
     * @param interfaceCollection The GameInterface collection to draw
     * @param parentId The parent ID, this will offset the widget's coordinates within its parent
     * @param drawSuccess The status of the drawing cycle, true for success and false for failure
     * @return The status of the drawing cycle, true for success and false for failure
     */
    public static boolean drawInterface(int areaId, int minX, int minY, int maxX, int maxY, int scrollPosition, int scrollWidth, GameInterface[] interfaceCollection, int parentId, boolean drawSuccess) {
        Rasterizer.setBounds(minX, minY, maxX, maxY);

        boolean result = drawSuccess;
        for (int i = 0; interfaceCollection.length > i; i++) {
            GameInterface gameInterface = interfaceCollection[i];
            if (gameInterface != null && gameInterface.parentId == parentId) {
                if (gameInterface.contentType > 0)
                    GameInterface.updateGameInterface(gameInterface);
                int absoluteX = minX + gameInterface.currentX;
                if (!gameInterface.lockScroll)
                    absoluteX -= scrollWidth;
                int absoluteY = minY + gameInterface.currentY;
                if (!gameInterface.lockScroll)
                    absoluteY -= scrollPosition;
                int opacity = gameInterface.opacity;
                if (gameInterface == Wall.aGameInterface_353) {
                    opacity = 128;
                    GameInterface gameInterface_3_ = FramemapDefinition.method878(gameInterface);
                    int[] is = Class13.method247(gameInterface_3_, (byte) 117);
                    int[] is_4_ = Class13.method247(gameInterface, (byte) 97);
                    int i_5_ = Landscape.mouseY + -Class40_Sub5_Sub11.anInt2621 + is_4_[1] - is[1];
                    if (i_5_ < 0)
                        i_5_ = 0;
                    if (i_5_ + gameInterface.originalHeight > gameInterface_3_.originalHeight)
                        i_5_ = gameInterface_3_.originalHeight + -gameInterface.originalHeight;
                    absoluteY = i_5_ + is[1];
                    int i_6_ = Class13.mouseX + -MovedStatics.anInt1996 + -is[0] + is_4_[0];
                    if (i_6_ < 0)
                        i_6_ = 0;
                    if (i_6_ + gameInterface.originalWidth > gameInterface_3_.originalWidth)
                        i_6_ = -gameInterface.originalWidth + gameInterface_3_.originalWidth;
                    absoluteX = is[0] + i_6_;
                }
                if (!gameInterface.isNewInterfaceFormat || Rasterizer.viewportRight >= absoluteX && Rasterizer.viewportBottom >= absoluteY && Rasterizer.viewportLeft <= absoluteX + gameInterface.originalWidth && absoluteY + gameInterface.originalHeight >= Rasterizer.viewportTop) {
                    if (gameInterface.type == GameInterfaceType.LAYER) {
                        if (gameInterface.isHidden && !Class29.isHovering(areaId, i))
                            continue;
                        if (!gameInterface.isNewInterfaceFormat) {
                            if (-gameInterface.originalHeight + gameInterface.scrollHeight < gameInterface.scrollPosition)
                                gameInterface.scrollPosition = -gameInterface.originalHeight + gameInterface.scrollHeight;
                            if (gameInterface.scrollPosition < 0)
                                gameInterface.scrollPosition = 0;
                        }
                        result &= drawInterface(areaId, absoluteX, absoluteY, gameInterface.originalWidth + absoluteX, gameInterface.originalHeight + absoluteY, gameInterface.scrollPosition, gameInterface.scrollWidth, interfaceCollection, i, drawSuccess);
                        if (gameInterface.children != null)
                            result &= drawInterface(areaId, absoluteX, absoluteY, gameInterface.originalWidth + absoluteX, absoluteY + gameInterface.originalHeight, gameInterface.scrollPosition, gameInterface.scrollWidth, gameInterface.children, gameInterface.id, true);
                        Rasterizer.setBounds(minX, minY, maxX, maxY);
                        if (gameInterface.originalHeight < gameInterface.scrollHeight)
                            GameInterface.drawScrollBar(absoluteX + gameInterface.originalWidth, absoluteY, gameInterface.originalHeight, gameInterface.scrollPosition, gameInterface.scrollHeight, 0);
                    }
                    if (gameInterface.type == GameInterfaceType.UNKNOWN) {
                        continue;
                    }
                    if (gameInterface.type == GameInterfaceType.INVENTORY) {
                        int i_7_ = 0;
                        for (int i_8_ = 0; i_8_ < gameInterface.originalHeight; i_8_++) {
                            for (int i_9_ = 0; gameInterface.originalWidth > i_9_; i_9_++) {
                                int i_10_ = (gameInterface.itemSpritePadsX + 32) * i_9_ + absoluteX;
                                int i_11_ = (32 + gameInterface.itemSpritePadsY) * i_8_ + absoluteY;
                                if (i_7_ < 20) {
                                    i_10_ += gameInterface.images[i_7_];
                                    i_11_ += gameInterface.imageX[i_7_];
                                }
                                if (gameInterface.items[i_7_] <= 0) {
                                    if (gameInterface.imageY != null && i_7_ < 20) {
                                        ImageRGB imageRGB = gameInterface.method638((byte) 78, i_7_);
                                        if (imageRGB == null) {
                                            if (FramemapDefinition.aBoolean2177)
                                                result = false;
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
                                            result = false;
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
                                                imageRGB.drawImageWithOpacity(i_12_ + i_10_, i_11_ + i_14_, 128);
                                                if (parentId != -1) {
                                                    GameInterface gameInterface_16_ = interfaceCollection[parentId];
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
                                                imageRGB.drawImageWithOpacity(i_10_, i_11_, 128);
                                            if (imageRGB.maxWidth == 33 || gameInterface.itemAmounts[i_7_] != 1) {
                                                int i_19_ = gameInterface.itemAmounts[i_7_];
//                                                TypeFace.fontSmall.drawString(GameInterface.getShortenedAmountText(i_19_), i_12_ + 1 + i_10_, i_11_ + 10 + i_14_, 0);
                                                TypeFace.fontSmall.drawShadowedString(GameInterface.getShortenedAmountText(i_19_), i_10_ + i_12_, i_14_ + i_11_ + 9, true, 16776960);
                                            }
                                        }
                                    }
                                }
                                i_7_++;
                            }
                        }
                    } else if (gameInterface.type == GameInterfaceType.RECTANGLE) {
                        int rectangleColor;
                        if (ItemDefinition.checkForAlternateAction(gameInterface)) {
                            rectangleColor = gameInterface.alternateTextColor;
                            if (Class29.isHovering(areaId, i) && gameInterface.alternateHoveredTextColor != 0)
                                rectangleColor = gameInterface.alternateHoveredTextColor;
                        } else {
                            rectangleColor = gameInterface.textColor;
                            if (Class29.isHovering(areaId, i) && gameInterface.hoveredTextColor != 0)
                                rectangleColor = gameInterface.hoveredTextColor;
                        }
                        if (opacity == 0) {
                            if (!gameInterface.filled)
                                Rasterizer.drawUnfilledRectangle(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, rectangleColor);
                            else
                                Rasterizer.drawFilledRectangle(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, rectangleColor);
                        } else if (!gameInterface.filled)
                            Rasterizer.drawUnfilledRectangleAlpha(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, rectangleColor, -(0xff & opacity) + 256);
                        else
                            Rasterizer.drawFilledRectangleAlpha(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, rectangleColor, -(0xff & opacity) + 256);
                    } else if (gameInterface.type == GameInterfaceType.TEXT) {
                        TypeFace font = gameInterface.getTypeFace();
                        if (font == null) {
                            if (FramemapDefinition.aBoolean2177)
                                result = false;
                        } else {
                            String text = gameInterface.disabledText;
                            int textColor;
                            if (ItemDefinition.checkForAlternateAction(gameInterface)) {
                                textColor = gameInterface.alternateTextColor;
                                if (Class29.isHovering(areaId, i) && gameInterface.alternateHoveredTextColor != 0)
                                    textColor = gameInterface.alternateHoveredTextColor;
                                if (gameInterface.alternateText.length() > 0)
                                    text = gameInterface.alternateText;
                            } else {
                                textColor = gameInterface.textColor;
                                if (Class29.isHovering(areaId, i) && gameInterface.hoveredTextColor != 0)
                                    textColor = gameInterface.hoveredTextColor;
                            }
                            if (gameInterface.isNewInterfaceFormat && gameInterface.itemId != -1) {
                                ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
                                text = itemDefinition.name;
                                if (text == null)
                                    text = "null";
                                if (itemDefinition.stackable == 1 || gameInterface.itemAmount != 1)
                                    text = text + Native.aClass1_674 + LinkedList.method903(gameInterface.itemAmount, (byte) -109);
                            }
                            if (gameInterface.actionType == 6 && MovedStatics.lastContinueTextWidgetId == gameInterface.id) {
                                textColor = gameInterface.textColor;
                                text = English.pleaseWait;
                            }
                            if (Rasterizer.destinationWidth == 479) {
                                if (textColor == 16776960)
                                    textColor = 255;
                                if (textColor == 49152)
                                    textColor = 16777215;
                            }

                            text = SceneTile.method532((byte) 20, gameInterface, text);
                            font.drawText(text, absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, textColor, gameInterface.textShadowed, gameInterface.xTextAlignment, gameInterface.yTextAlignment, gameInterface.lineHeight);
                        }
                    } else if (gameInterface.type == GameInterfaceType.GRAPHIC) {
                        if (gameInterface.isNewInterfaceFormat) {
                            int maxWidth = 0;
                            int maxHeight = 0;
                            ImageRGB spriteRgb;

                            if (gameInterface.itemId == -1)
                                spriteRgb = gameInterface.getImageRgb(false);
                            else {
                                spriteRgb = ItemDefinition.sprite(gameInterface.itemAmount, gameInterface.itemId, 0);
                                maxWidth = spriteRgb.maxWidth;
                                maxHeight = spriteRgb.maxHeight;

                                // TODO find out why this is done
                                spriteRgb.maxHeight = 32;
                                spriteRgb.maxWidth = 32;
                            }

                            if (spriteRgb != null) {
                                int spriteHeight = spriteRgb.imageHeight;
                                int spriteWidth = spriteRgb.imageWidth;

                                if (gameInterface.tiled) {
                                    int[] viewportDimensions = new int[4];
                                    Rasterizer.getViewportDimensions(viewportDimensions);

                                    // Cap sprite to viewport dimensions
                                    int spriteTopX = absoluteX;
                                    if (viewportDimensions[0] > spriteTopX)
                                        spriteTopX = viewportDimensions[0];
                                    int spriteTopY = absoluteY;
                                    if (viewportDimensions[1] > spriteTopY)
                                        spriteTopY = viewportDimensions[1];
                                    int spriteBottomX = gameInterface.originalWidth + absoluteX;
                                    if (viewportDimensions[2] < spriteBottomX)
                                        spriteBottomX = viewportDimensions[2];
                                    int spriteBottomY = gameInterface.originalHeight + absoluteY;
                                    if (spriteBottomY > viewportDimensions[3])
                                        spriteBottomY = viewportDimensions[3];

                                    Rasterizer.setBounds(spriteTopX, spriteTopY, spriteBottomX, spriteBottomY);
                                    int i_31_ = (gameInterface.originalWidth - (1 + -spriteWidth)) / spriteWidth;
                                    int i_32_ = (gameInterface.originalHeight - (1 + -spriteHeight)) / spriteHeight;
                                    for (int row = 0; i_31_ > row; row++) {
                                        for (int col = 0; i_32_ > col; col++) {
                                            if (gameInterface.textureId == 0) {
                                                if (opacity == 0)
                                                    spriteRgb.drawImage(row * spriteWidth + absoluteX, col * spriteHeight + absoluteY);
                                                else
                                                    spriteRgb.drawImageWithOpacity(absoluteX + row * spriteWidth, absoluteY + spriteHeight * col, -(opacity & 0xff) + 256);
                                            } else
                                                spriteRgb.drawImageWithTexture(spriteWidth / 2 + row * spriteWidth + absoluteX, spriteHeight / 2 + absoluteY + spriteHeight * col, gameInterface.textureId, 4096);
                                        }
                                    }
                                    Rasterizer.setViewportDimensions(viewportDimensions);
                                } else {
                                    int i_26_ = 4096 * gameInterface.originalWidth / spriteWidth;
                                    if (gameInterface.textureId == 0) {
                                        if (opacity == 0) {
                                            if (gameInterface.originalWidth == spriteWidth && gameInterface.originalHeight == spriteHeight)
                                                spriteRgb.drawImage(absoluteX, absoluteY);
                                            else
                                                spriteRgb.method732(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight);
                                        } else
                                            spriteRgb.method716(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, 256 + -(0xff & opacity));
                                    } else
                                        spriteRgb.drawImageWithTexture(gameInterface.originalWidth / 2 + absoluteX, gameInterface.originalHeight / 2 + absoluteY, gameInterface.textureId, i_26_);
                                }
                            } else if (FramemapDefinition.aBoolean2177)
                                result = false;
                            if (gameInterface.itemId != -1) {
                                // TODO find out why this renders when maxWidth == 33
                                if (gameInterface.itemAmount != 1 || maxWidth == 33) {
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), absoluteX + 1, absoluteY + 10, 0);
                                    TypeFace.fontSmall.drawString(Integer.toString(gameInterface.itemAmount), absoluteX, 9 + absoluteY, 16776960);
                                }
                                spriteRgb.maxWidth = maxWidth;
                                spriteRgb.maxHeight = maxHeight;
                            }
                        } else {
                            ImageRGB imageRGB = gameInterface.getImageRgb(ItemDefinition.checkForAlternateAction(gameInterface));
                            if (imageRGB != null)
                                imageRGB.drawImage(absoluteX, absoluteY);
                            else if (FramemapDefinition.aBoolean2177)
                                result = false;
                        }
                    } else if (gameInterface.type == GameInterfaceType.MODEL) {
                        boolean applyAlternateAction = ItemDefinition.checkForAlternateAction(gameInterface);
                        int animationId;
                        if (!applyAlternateAction)
                            animationId = gameInterface.animation;
                        else
                            animationId = gameInterface.alternateAnimation;

                        Model model;
                        if (gameInterface.modelType != InterfaceModelType.PLAYER) {
                            if (animationId == -1) {
                                model = gameInterface.getModelForInterface(null, -1, applyAlternateAction, Player.localPlayer.playerAppearance);
                            } else {
                                AnimationSequence animationSequence = ProducingGraphicsBuffer_Sub1.getAnimationSequence(animationId);
                                model = gameInterface.getModelForInterface(animationSequence, gameInterface.animationFrame, applyAlternateAction, Player.localPlayer.playerAppearance);
                            }
                            // TODO FramemapDefinition.aBoolean2177 might be object/model/sprite doesnt exist
                            if (model == null && FramemapDefinition.aBoolean2177)
                                result = false;
                        } else if (gameInterface.modelId != 0) {
                            model = Player.localPlayer.getRotatedModel();
                        } else {
                            model = Player.activePlayerAppearance.getAnimatedModel(null, null, -1, -1);
                        }

                        int rotationX = gameInterface.rotationX;
                        int rotationY = gameInterface.rotationY;
                        int offsetY2d = gameInterface.offsetY2d;
                        int rotationZ = gameInterface.rotationZ;
                        int offsetX2d = gameInterface.offsetX2d;
                        int modelZoom = gameInterface.modelZoom;
                        if (gameInterface.itemId != -1) {
                            ItemDefinition itemDefinition = ItemDefinition.forId(gameInterface.itemId, 10);
                            itemDefinition = itemDefinition.method743(gameInterface.itemAmount);
                            model = itemDefinition.asGroundStack(true, 1);
                            rotationY = itemDefinition.zan2d;
                            offsetY2d = itemDefinition.yOffset2d;
                            offsetX2d = itemDefinition.xOffset2d;
                            rotationX = itemDefinition.xan2d;
                            modelZoom = itemDefinition.zoom2d;
                            rotationZ = itemDefinition.yan2d;
                            if (gameInterface.originalWidth > 0)
                                modelZoom = 32 * modelZoom / gameInterface.originalWidth;
                        }
                        Rasterizer3D.setBounds(absoluteX + gameInterface.originalWidth / 2, gameInterface.originalHeight / 2 + absoluteY);

                        int camHeight = modelZoom * Rasterizer3D.sinetable[rotationX] >> 16;
                        int camDistance = modelZoom * Rasterizer3D.cosinetable[rotationX] >> 16;
                        if (model != null) {
                            if (gameInterface.isNewInterfaceFormat) {
                                model.method799();
                                // For some reason, drawOrthogonalModel does the same thing as drawModel
                                if (gameInterface.orthogonal)
                                    model.drawOrthogonalModel(0, rotationZ, rotationY, rotationX, offsetX2d, offsetY2d + camHeight + model.modelHeight / 2, camDistance + offsetY2d, modelZoom);
                                else
                                    model.drawModel(0, rotationZ, rotationY, rotationX, offsetX2d, offsetY2d + model.modelHeight / 2 + camHeight, camDistance + offsetY2d);
                            } else {
                                model.drawModel(0, rotationZ, 0, rotationX, 0, camHeight, camDistance);
                            }
                        }
                        Rasterizer3D.resetBoundsTo3dViewport();
                    } else {
                        if (gameInterface.type == GameInterfaceType.TEXT_INVENTORY) {
                            TypeFace font = gameInterface.getTypeFace();
                            if (font == null) {
                                if (FramemapDefinition.aBoolean2177)
                                    result = false;
                                continue;
                            }
                            int itemSlot = 0;
                            for (int row = 0; row < gameInterface.originalHeight; row++) {
                                for (int col = 0; col < gameInterface.originalWidth; col++) {
                                    if (gameInterface.items[itemSlot] > 0) {
                                        ItemDefinition itemDefinition = ItemDefinition.forId(-1 + gameInterface.items[itemSlot], 10);
                                        String itemName = itemDefinition.name;
                                        if (itemName == null)
                                            itemName = "null";
                                        if (itemDefinition.stackable == 1 || gameInterface.itemAmounts[itemSlot] != 1)
                                            itemName = itemName + Native.aClass1_674 + LinkedList.method903(gameInterface.itemAmounts[itemSlot], (byte) -105);
                                        int itemX = col * (gameInterface.itemSpritePadsX + 115) + absoluteX;
                                        int itemY = row * (gameInterface.itemSpritePadsY + 12) + absoluteY;
                                        if (gameInterface.xTextAlignment == 0)
                                            font.drawShadowedString(itemName, itemX, itemY, gameInterface.textShadowed, gameInterface.textColor);
                                        else if (gameInterface.xTextAlignment == 1)
                                            font.drawShadowedStringCenter(itemName, itemX + gameInterface.originalWidth / 2, itemY, gameInterface.textColor, gameInterface.textShadowed);
                                        else
                                            font.drawShadowedStringRight(itemName, -1 + gameInterface.originalWidth + itemX, itemY, gameInterface.textColor, gameInterface.textShadowed);
                                    }
                                    itemSlot++;
                                }
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.IF1_TOOLTIP && Class37.method438(areaId, i) && RSString.tooltipDelay == WallDecoration.durationHoveredOverWidget) {
                            int textWidth = 0;
                            int textHeight = 0;
                            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
                            String text = gameInterface.disabledText;
                            text = SceneTile.method532((byte) 20, gameInterface, text);
                            while (text.length() > 0) {
                                int lineBreakCharacter = text.indexOf(Native.lineBreak);
                                String textLine;
                                if (lineBreakCharacter == -1) {
                                    // Not a multiline text
                                    textLine = text;
                                    text = "";
                                } else {
                                    // Multiline text
                                    textLine = text.substring(0, lineBreakCharacter);
                                    text = text.substring(2 + lineBreakCharacter);
                                }
                                int lineWidth = class40_sub5_sub14_sub1.getTextDisplayedWidth(textLine);
                                textHeight += class40_sub5_sub14_sub1.characterDefaultHeight + 1;
                                if (textWidth < lineWidth)
                                    textWidth = lineWidth;
                            }
                            textHeight += 7;
                            int tooltipY = 5 + gameInterface.originalHeight + absoluteY;
                            if (tooltipY + textHeight > maxY)
                                tooltipY = maxY + -textHeight;
                            textWidth += 6;
                            int tooltipX = -5 + gameInterface.originalWidth + absoluteX - textWidth;
                            if (tooltipX < 5 + absoluteX)
                                tooltipX = 5 + absoluteX;
                            if (textWidth + tooltipX > maxX)
                                tooltipX = -textWidth + maxX;
                            Rasterizer.drawFilledRectangle(tooltipX, tooltipY, textWidth, textHeight, 16777120);
                            Rasterizer.drawUnfilledRectangle(tooltipX, tooltipY, textWidth, textHeight, 0);
                            text = gameInterface.disabledText;
                            int tooltipTitleY = 2 + tooltipY + class40_sub5_sub14_sub1.characterDefaultHeight;
                            text = SceneTile.method532((byte) 20, gameInterface, text);
                            while (text.length() > 0) {
                                int lineBreakCharacter = text.indexOf(Native.lineBreak);
                                String textLine;
                                if (lineBreakCharacter == -1) {
                                    textLine = text;
                                    text = "";
                                } else {
                                    textLine = text.substring(0, lineBreakCharacter);
                                    text = text.substring(lineBreakCharacter + 2);
                                }
                                class40_sub5_sub14_sub1.drawShadowedString(textLine, tooltipX + 3, tooltipTitleY, false, 0);
                                tooltipTitleY += 1 + class40_sub5_sub14_sub1.characterDefaultHeight;
                            }
                        }
                        if (gameInterface.type == GameInterfaceType.LINE)
                            Rasterizer.drawDiagonalLine(absoluteX, absoluteY, gameInterface.originalWidth + absoluteX, gameInterface.originalHeight + absoluteY, gameInterface.textColor);
                    }
                }
            }
        }
        return result;
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

    public static void renderFlames() {
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
        i_61_ = 0;
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
        MovedStatics.lastContinueTextWidgetId = -1;
        Class51.anInt1205 = -1;
        MovedStatics.anInt2118 = 0;
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
            if(MovedStatics.secondaryCameraVertical / 256 > i) {
                i = MovedStatics.secondaryCameraVertical / 256;
            }
            int i_0_ = 0x7ff & GroundItemTile.cameraHorizontal + Class57.anInt1342;
            if(Class40_Sub5_Sub17_Sub1.aBooleanArray2975[4] && 128 + anIntArray2[4] > i) {
                i = 128 + anIntArray2[4];
            }
            Class49.setCameraPosition(i, Class40_Sub5_Sub6.currentCameraPositionH, -50 + Class37.getFloorDrawHeight(Player.worldLevel, Player.localPlayer.worldX, Player.localPlayer.worldY), i_0_, MovedStatics.currentCameraPositionV, -1, 3 * i + 600);
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
            Console.console.drawConsole(ScreenController.drawWidth, 334);
            Console.console.drawConsoleArea(ScreenController.drawWidth, 334);
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
            if(!Class37.aBoolean871 && MovedStatics.gameConnection != null) {
                SceneCluster.packetBuffer.putPacket(13);
                try {
                    MovedStatics.gameConnection.method1010(SceneCluster.packetBuffer.currentPosition, (byte) -19, 0, SceneCluster.packetBuffer.buffer);
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
            Class40_Sub5_Sub17_Sub1.method763(MouseHandler.gameCanvas, CacheArchive.gameImageCacheArchive);
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
            if(ChatBox.dialogueId != -1) {
                boolean bool = Renderable.handleSequences(ChatBox.dialogueId);
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
                MovedStatics.method527(Player.currentTabId, 4, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
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
                Renderable.handleSequences(GameInterface.chatboxInterfaceId);
            }

            if(ChatBox.dialogueId != -1) {
                Renderable.handleSequences(ChatBox.dialogueId);
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
                MovedStatics.method527(Player.currentTabId, 4, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
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
        OverlayDefinition.updateOverlay(10);
    }

    public static void method164() {
        Renderable.handleSequences(GameInterface.fullscreenInterfaceId);
        if(GameInterface.fullscreenSiblingInterfaceId != -1)
            Renderable.handleSequences(GameInterface.fullscreenSiblingInterfaceId);
        MovedStatics.anInt199 = 0;
        ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213.prepareRasterizer();
        Player.viewportOffsets = Rasterizer3D.setLineOffsets(Player.viewportOffsets);
        Rasterizer.resetPixels();
        drawParentInterface(0, 0, 0, 765, 503, GameInterface.fullscreenInterfaceId);
        if(GameInterface.fullscreenSiblingInterfaceId != -1)
            drawParentInterface(0, 0, 0, 765, 503, GameInterface.fullscreenSiblingInterfaceId);
        if(!MovedStatics.menuOpen) {
            Class43.processRightClick();
            SceneTile.drawMenuTooltip(4);
        } else
            if(ScreenController.frameMode == ScreenMode.FIXED && Class40_Sub5_Sub17_Sub1.menuScreenArea == 0){
                Class40_Sub5_Sub6.drawMenu(4,4); // might be 0,0
            }
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213.drawGraphics(0, 0, graphics);
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
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
                    if (Class51.currentAction <= 5) {
                        this.openErrorPage((byte) 104, "js5connect");
                        ISAAC.anInt509 = 3000;
                    } else
                        ISAAC.anInt509 = 3000;
                }
            } else {
                this.openErrorPage((byte) 86, "js5connect_outofdate");
                Class51.currentAction = 1000;
            }
        } else if (Class51.currentAction > 5)
            ISAAC.anInt509 = 3000;
        else {
            this.openErrorPage((byte) 122, "js5connect_full");
            Class51.currentAction = 1000;
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

        if (Class51.currentAction == 0) {
            Class40_Sub3.startup(100);
            Class60.method992();
        } else if (Class51.currentAction == 5) {
            Class40_Sub3.startup(100);
            Class60.method992();
        } else if (Class51.currentAction == 10) {
            Class60.updateLogin();
        } else if (Class51.currentAction == 20) {
            Class60.updateLogin();
            SpotAnimDefinition.method552(true);
        } else if (Class51.currentAction == 25)
            Landscape.loadRegion();
        if (Class51.currentAction == 30) {
            ScreenController.refreshFrameSize();
            Npc.updateGame();
        } else if (Class51.currentAction == 35) {
            ScreenController.refreshFrameSize();
            Npc.updateGame();
        } else if (Class51.currentAction == 40) {
            SpotAnimDefinition.method552(true);
        }
    }

    public void method39() {
        if (1000 != Class51.currentAction) {
            boolean bool = FloorDecoration.method346((byte) 48);
            if (!bool)
                method40();
        }
    }

    public void method34(int arg0) { // TODO: Might be Startup
        if (MovedStatics.aBoolean1575) {
            Class22_Sub1.method311(MouseHandler.gameCanvas);
            Class55.method965(32, MouseHandler.gameCanvas);
            this.setCanvas((byte) 86);
            GameInterface.method642(MouseHandler.gameCanvas, -10);
            RSRuntimeException.method1056(MouseHandler.gameCanvas, (byte) 33);
        }
        if (Class51.currentAction == 0)
            GameObject.drawLoadingText(MovedStatics.anInt1607, null, Native.currentLoadingText);
        else if (Class51.currentAction == 5) {
            WallDecoration.drawLoadingScreen(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.currentAction == 10) {
            WallDecoration.drawLoadingScreen(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.currentAction == 20) {
            WallDecoration.drawLoadingScreen(-19010, TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.currentAction == 25) {
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
        } else if (Class51.currentAction == 30) {
            drawGameScreen();

        } else if (Class51.currentAction == 35) {
            method164();
        } else if (Class51.currentAction == 40)
            Class51.method940(0, English.connectionLost, false, English.pleaseWaitAttemptingToReestablish);
        Npc.anInt3294 = 0;
    }

    public void method40() {
        if (MovedStatics.anInt813 >= 4) {
            this.openErrorPage((byte) 120, "js5crc");
            Class51.currentAction = 1000;
        } else {
            if (MovedStatics.anInt2278 >= 4) {
                if (Class51.currentAction > 5) {
                    MovedStatics.anInt2278 = 3;
                    ISAAC.anInt509 = 3000;
                } else {
                    this.openErrorPage((byte) 58, "js5io");
                    Class51.currentAction = 1000;
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
                            if (Class51.currentAction > 5 && Class29.aClass64_676.method1014(5 + -131) <= 0) {
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
                        Class17.method273(Class29.aClass64_676, 105, Class51.currentAction > 20);
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
        if (MovedStatics.gameConnection != null) {
            MovedStatics.gameConnection.method1009();
            MovedStatics.gameConnection = null;
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
        GameInterface.method642(MouseHandler.gameCanvas, -10);
        RSRuntimeException.method1056(MouseHandler.gameCanvas, (byte) 70);
        RSCanvas.anInt57 = Signlink.anInt737;
        try {
            if (signlink.cacheDataAccessFile != null) {
                dataChannel = new CacheFileChannel(signlink.cacheDataAccessFile, 5200);
                for (int i = 0; i < 13; i++)
                    indexChannels[i] = new CacheFileChannel(signlink.dataIndexAccessFiles[i], 6000);
                metaChannel = new CacheFileChannel(signlink.metaIndexAccessFile, 6000);
                metaIndex = new CacheIndex(255, dataChannel, metaChannel, 500000);
                signlink.dataIndexAccessFiles = null;
                signlink.metaIndexAccessFile = null;
                signlink.cacheDataAccessFile = null;
            }
        } catch (java.io.IOException ioexception) {
            metaIndex = null;
            dataChannel = null;
            metaChannel = null;
        }
        if (Class44.modewhere != 0)
            InteractiveObject.showFps = true;
        Class12.chatboxInterface = new GameInterface();
    }
}
