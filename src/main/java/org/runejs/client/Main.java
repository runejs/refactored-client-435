package org.runejs.client;

import org.runejs.client.cache.CacheIndex;
import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.CacheFileChannel;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.frame.ScreenController;
import org.runejs.client.frame.ScreenMode;
import org.runejs.client.frame.console.Console;
import org.runejs.client.input.KeyFocusListener;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.io.Buffer;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.Rasterizer;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Item;
import org.runejs.client.media.renderable.Model;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Npc;
import org.runejs.client.media.renderable.actor.Pathfinding;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.*;
import org.runejs.client.scene.GroundItemTile;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCluster;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.sound.MusicSystem;
import org.runejs.client.sound.SoundSystem;
import org.runejs.client.util.BitUtils;
import org.runejs.client.util.Signlink;
import org.runejs.client.cache.def.*;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.cache.media.gameInterface.GameInterfaceType;
import org.runejs.client.cache.media.gameInterface.InterfaceModelType;
import org.runejs.client.scene.tile.*;
import org.runejs.Configuration;

import java.awt.*;
import java.io.IOException;
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
    public static Signlink signlink;
    public static CacheIndex metaIndex;
    public static CacheFileChannel dataChannel;
    public static CacheFileChannel metaChannel;
    public static CacheFileChannel[] indexChannels = new CacheFileChannel[13];
    public static int currentPort;
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
     *   3 = Permanent chat widget area (walkable chat widgets that replace the actual chat itself)
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
     *   3 = Permanent chat widget area (walkable chat widgets that replace the actual chat itself)
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
                    int[] is = Class13.method247(gameInterface_3_);
                    int[] is_4_ = Class13.method247(gameInterface);
                    int i_5_ = Landscape.mouseY + -MovedStatics.anInt2621 + is_4_[1] - is[1];
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
                                        ImageRGB imageRGB = gameInterface.method638(i_7_);
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
                                        if (MovedStatics.itemSelected == 1 && i_7_ == LinkedList.selectedInventorySlot && gameInterface.id == ISAAC.anInt525)
                                            i_15_ = 16777215;
                                        ImageRGB imageRGB = ItemDefinition.sprite(gameInterface.itemAmounts[i_7_], i_13_, i_15_);
                                        if (imageRGB == null)
                                            result = false;
                                        else {
                                            if (SceneTile.activeInterfaceType != 0 && GroundItemTile.selectedInventorySlot == i_7_ && gameInterface.id == MovedStatics.modifiedWidgetId) {
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
                                            } else if (Projectile.atInventoryInterfaceType == 0 || GenericTile.anInt1233 != i_7_ || gameInterface.id != PlayerAppearance.anInt704)
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
                                    text = text + Native.amountPrefixX + LinkedList.method903(gameInterface.itemAmount);
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

                            text = SceneTile.method532(gameInterface, text);
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
                                            itemName = itemName + Native.amountPrefixX + LinkedList.method903(gameInterface.itemAmounts[itemSlot]);
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
                            text = SceneTile.method532(gameInterface, text);
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
                            text = SceneTile.method532(gameInterface, text);
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

                    // Draw debug information for non layer widgets and non tooltip widgets
                    if (Configuration.DEBUG_WIDGETS && gameInterface.type != GameInterfaceType.LAYER && gameInterface.type != GameInterfaceType.IF1_TOOLTIP && GenericTile.hoveredWidgetId == gameInterface.id) {
                        Rasterizer.drawUnfilledRectangle(absoluteX, absoluteY, gameInterface.originalWidth, gameInterface.originalHeight, 0xffff00);
                    }
                }
            }
        }
        return result;
    }

    public static void renderFlames() {
        if (MovedStatics.anInt2452 <= 0) {
            if (IdentityKit.anInt2613 > 0) {
                for (int i = 0; i < 256; i++) {
                    if (IdentityKit.anInt2613 > 768)
                        MovedStatics.anIntArray1013[i] = MovedStatics.method614(Class51.anIntArray1198[i], Class40_Sub5_Sub17_Sub6.anIntArray3248[i], -IdentityKit.anInt2613 + 1024);
                    else if (IdentityKit.anInt2613 > 256)
                        MovedStatics.anIntArray1013[i] = Class40_Sub5_Sub17_Sub6.anIntArray3248[i];
                    else
                        MovedStatics.anIntArray1013[i] = MovedStatics.method614(Class40_Sub5_Sub17_Sub6.anIntArray3248[i], Class51.anIntArray1198[i], -IdentityKit.anInt2613 + 256);
                }
            } else {
                System.arraycopy(Class51.anIntArray1198, 0, MovedStatics.anIntArray1013, 0, 256);
            }
        } else {
            for (int i = 0; i < 256; i++) {
                if (MovedStatics.anInt2452 <= 768) {
                    if (MovedStatics.anInt2452 > 256)
                        MovedStatics.anIntArray1013[i] = Renderable.anIntArray2865[i];
                    else
                        MovedStatics.anIntArray1013[i] = MovedStatics.method614(Renderable.anIntArray2865[i], Class51.anIntArray1198[i], -MovedStatics.anInt2452 + 256);
                } else
                    MovedStatics.anIntArray1013[i] = MovedStatics.method614(Class51.anIntArray1198[i], Renderable.anIntArray2865[i], -MovedStatics.anInt2452 + 1024);
            }
        }
        int i = 256;
        System.arraycopy(Class39.aClass40_Sub5_Sub14_Sub4_918.pixels, 0, MovedStatics.flameLeftBackground.pixels, 0, 33920);
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
                    i_67_ = MovedStatics.anIntArray1013[i_67_];
                    int i_70_ = MovedStatics.flameLeftBackground.pixels[i_62_];
                    MovedStatics.flameLeftBackground.pixels[i_62_++] = BitUtils.bitWiseAND(-16711936, BitUtils.bitWiseAND(i_67_, 16711935) * i_69_ + i_68_ * BitUtils.bitWiseAND(i_70_, 16711935)) + BitUtils.bitWiseAND(BitUtils.bitWiseAND(65280, i_70_) * i_68_ + i_69_ * BitUtils.bitWiseAND(65280, i_67_), 16711680) >> 8;
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
                    i_76_ = MovedStatics.anIntArray1013[i_76_];
                    GameObject.flameRightBackground.pixels[i_62_++] = BitUtils.bitWiseAND(i_77_ * BitUtils.bitWiseAND(65280, i_76_) + i_79_ * BitUtils.bitWiseAND(65280, i_78_), 16711680) + BitUtils.bitWiseAND(i_79_ * BitUtils.bitWiseAND(16711935, i_78_) + BitUtils.bitWiseAND(16711935, i_76_) * i_77_, -16711936) >> 8;
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
                printHelp();

            Player.worldId = Integer.parseInt(params[0]);

            // Location argument (to set server IP based on JMod location?)
            if (params[1].equals("live")) {
                Class44.modewhere = 0;
            } else if (params[1].equals("office")) {
                Class44.modewhere = 1;
            } else if (params[1].equals("local")) {
                Class44.modewhere = 2;
            } else {
                printHelp();
            }

            if (params[2].equals("live"))
                Class44.modewhat = 0;
            else if (!params[2].equals("rc")) {
                if (params[2].equals("wip"))
                    Class44.modewhat = 2;
                else
                    printHelp();
            } else
                Class44.modewhat = 1;

            // Memory argument
            if (params[3].equals("lowmem")) {
                Class59.setLowMemory();
            } else if (params[3].equals("highmem")) {
                MovedStatics.setHighMemory();
            } else {
                printHelp();
            }

            // Player membership argument
            if (params[4].equals("free")) {
                MovedStatics.membersWorld = false;
            } else if (params[4].equals("members")) {
                MovedStatics.membersWorld = true;
            } else {
                printHelp();
            }

            Main main = new Main();
            main.openClientApplet("client435", 13, 32 + Class44.modewhat, InetAddress.getByName(Configuration.SERVER_ADDRESS), 435);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static void setConfigToDefaults() {
        Class51.aLong1203 = 0L;
        Class12.mouseCapturer.coord = 0;
        MovedStatics.duplicateClickCount = 0;
        Class35.aBoolean1735 = true;
        MovedStatics.aBoolean571 = true;
        MovedStatics.method540();
        IncomingPackets.secondLastOpcode = -1;
        MovedStatics.menuOpen = false;
        IncomingPackets.lastOpcode = -1;
        IncomingPackets.opcode = -1;
        Class40_Sub5_Sub15.systemUpdateTime = 0;
        IncomingPackets.cyclesSinceLastPacket = 0;
        Player.headIconDrawType = 0;
        SceneCluster.packetBuffer.currentPosition = 0;
        SceneCluster.idleLogout = 0;
        IncomingPackets.thirdLastOpcode = -1;
        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
        ActorDefinition.menuActionRow = 0;
        MovedStatics.method650(0);
        for (int i = 0; i < 100; i++)
            ChatBox.chatMessages[i] = null;
        MovedStatics.itemSelected = 0;
        Class57.anInt1342 = -40 + (int) (80.0 * Math.random());
        MovedStatics.cameraOffsetY = -55 + (int) (Math.random() * 110.0);
        MovedStatics.destinationX = 0;
        Class43.cameraYawOffset = (int) (Math.random() * 120.0) + -60;
        Buffer.anInt1985 = -1;
        Player.npcCount = 0;
        SoundSystem.reset();
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
        Class43.projectileQueue.clear();
        Class57.aLinkedList_1332.clear();
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

    public static void method353() {
        MovedStatics.anInt2628++;
        Class40_Sub5_Sub17_Sub6.method833(0, true);
        ItemDefinition.method749(true);
        Class40_Sub5_Sub17_Sub6.method833(0, false);
        ItemDefinition.method749(false);
        MovedStatics.method335();
        MovedStatics.method1000();
        if(!Player.cutsceneActive) {
            int i = Class65.cameraVertical;
            if(MovedStatics.secondaryCameraVertical / 256 > i) {
                i = MovedStatics.secondaryCameraVertical / 256;
            }
            int i_0_ = 0x7ff & GroundItemTile.cameraHorizontal + Class57.anInt1342;
            if(Projectile.aBooleanArray2975[4] && 128 + anIntArray2[4] > i) {
                i = 128 + anIntArray2[4];
            }
            Class49.setCameraPosition(i, MovedStatics.currentCameraPositionH, -50 + Class37.getFloorDrawHeight(Player.worldLevel, Player.localPlayer.worldX, Player.localPlayer.worldY), i_0_, MovedStatics.currentCameraPositionV, -1, 3 * i + 600);
        }
        int i;
        if(!Player.cutsceneActive) {
            i = Projectile.method764();
        } else {
            i = MovedStatics.method546();
        }
        int i_1_ = Class12.cameraX;
        int i_2_ = ProducingGraphicsBuffer_Sub1.anInt2210;
        int i_3_ = SceneCluster.cameraZ;
        int i_4_ = Class26.anInt627;
        int i_5_ = MovedStatics.cameraY;
        for(int i_6_ = 0; i_6_ < 5; i_6_++) {
            if(Projectile.aBooleanArray2975[i_6_]) {
                int i_7_ = (int) ((double) (MovedStatics.anIntArray297[i_6_] * 2 + 1) * Math.random() - (double) MovedStatics.anIntArray297[i_6_] + Math.sin((double) MovedStatics.anIntArray1846[i_6_] * ((double) GroundItemTile.anIntArray1358[i_6_] / 100.0)) * (double) anIntArray2[i_6_]);
                if(i_6_ == 1) {
                    SceneCluster.cameraZ += i_7_;
                }
                if(i_6_ == 0) {
                    Class12.cameraX += i_7_;
                }
                if(i_6_ == 2) {
                    MovedStatics.cameraY += i_7_;
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
        Npc.currentScene.render(Class12.cameraX, SceneCluster.cameraZ, MovedStatics.cameraY, Class26.anInt627, ProducingGraphicsBuffer_Sub1.anInt2210, i);
        Npc.currentScene.clearInteractiveObjectCache();
        Class33.method404();
        MovedStatics.method450();
        ((Class35) Rasterizer3D.interface3).method425(MovedStatics.anInt199);
        KeyFocusListener.draw3dScreen();

        if(ScreenController.frameMode == ScreenMode.FIXED) {
            Console.console.drawConsole(512, 334);
            Console.console.drawConsoleArea(512, 334);
        } else {
            ScreenController.RenderResizableUI();
            Console.console.drawConsole(ScreenController.drawWidth, 334);
            Console.console.drawConsoleArea(ScreenController.drawWidth, 334);
        }


        if(ISAAC.aBoolean519 && UpdateServer.getActiveCount(false, true) == 0) {
            ISAAC.aBoolean519 = false;
        }
        if(ISAAC.aBoolean519) {
            Class65.method1018();
            Rasterizer.resetPixels();
            Class51.method940(English.loadingPleaseWait, false, null);
        }

        Player.drawGameScreenGraphics();
        Class12.cameraX = i_1_;
        MovedStatics.cameraY = i_5_;
        ProducingGraphicsBuffer_Sub1.anInt2210 = i_2_;
        Class26.anInt627 = i_4_;
        SceneCluster.cameraZ = i_3_;
    }

    public static void method357(CacheArchive arg0, CacheArchive arg2) {
        GroundItemTile.aCacheArchive_1375 = arg2;
        ActorDefinition.count = GroundItemTile.aCacheArchive_1375.fileLength(9);

        MovedStatics.aCacheArchive_1577 = arg0;
    }

    public static IndexedImage method359(String arg0, String arg1, CacheArchive arg2) {
        int i = arg2.getHash(arg0);
        int i_23_ = arg2.method179(i, arg1);
        return method363(arg2, i_23_, i);
    }

    public static IndexedImage method363(CacheArchive arg0, int arg2, int arg3) {
        if(!ImageRGB.spriteExists(arg2, arg3, arg0)) {
            return null;
        }
        return MovedStatics.method538();

    }

    public static void method364(boolean arg1) {
        MovedStatics.anInt537++;
        if(MovedStatics.anInt537 >= 50 || arg1) {
            MovedStatics.anInt537 = 0;
            if(!Class37.aBoolean871 && MovedStatics.gameServerSocket != null) {
                SceneCluster.packetBuffer.putPacket(13);
                try {
                    MovedStatics.gameServerSocket.sendDataFromBuffer(SceneCluster.packetBuffer.currentPosition, 0, SceneCluster.packetBuffer.buffer);
                    SceneCluster.packetBuffer.currentPosition = 0;
                } catch(java.io.IOException ioexception) {
                    Class37.aBoolean871 = true;
                }
            }
        }
    }

    public static void drawGameScreen() {
        if(MovedStatics.clearScreen) {
            MovedStatics.clearScreen = false;
            ItemDefinition.drawWelcomeScreenGraphics();
            GameInterface.drawTabIcons = true;
            ChatBox.redrawChatbox = true;
            GameInterface.redrawTabArea = true;
            MovedStatics.redrawChatbox = true;
            drawCount++;
        } else if(drawCount != 0) {
            Projectile.method763(MouseHandler.gameCanvas, CacheArchive.gameImageCacheArchive);
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

            if(MovedStatics.menuOpen && Projectile.menuScreenArea == 1) {
                GameInterface.redrawTabArea = true;
            }
            if(GameInterface.tabAreaInterfaceId != -1) {
                boolean bool = Renderable.handleSequences(GameInterface.tabAreaInterfaceId);
                if(bool) {
                    GameInterface.redrawTabArea = true;
                }
            }
            method353();

            if(Projectile.atInventoryInterfaceType == -3) {
                GameInterface.redrawTabArea = true;
            }
            if(SceneTile.activeInterfaceType == 2) {
                GameInterface.redrawTabArea = true;
            }
            Class43.drawTabArea();

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
            if(Projectile.atInventoryInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if(SceneTile.activeInterfaceType == 3) {
                ChatBox.redrawChatbox = true;
            }
            if(Native.clickToContinueString != null) {
                ChatBox.redrawChatbox = true;
            }
            if(MovedStatics.menuOpen && Projectile.menuScreenArea == 2) {
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
                Class40_Sub3.showIconsRedrawnText = true;
                MovedStatics.method527(Player.currentTabId, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
            }
            if(MovedStatics.redrawChatbox) {
                Class40_Sub3.showIconsRedrawnText = true;
                MovedStatics.redrawChatbox = false;
                GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            SoundSystem.updateObjectSounds(Player.localPlayer.worldX, Player.worldLevel, MovedStatics.anInt199, Player.localPlayer.worldY);
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
            method353();
            ChatBox.renderChatbox();

            Class43.drawTabArea();

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
                Class40_Sub3.showIconsRedrawnText = true;
                MovedStatics.method527(Player.currentTabId, Player.tabWidgetIds, GameInterface.tabAreaInterfaceId == -1, MovedStatics.pulseCycle % 20 >= 10 ? Class51.anInt1205 : -1);
            }
            if(MovedStatics.redrawChatbox) {
                Class40_Sub3.showIconsRedrawnText = true;
                MovedStatics.redrawChatbox = false;
                GenericTile.method943(ChatBox.tradeMode, WallDecoration.fontNormal, ChatBox.privateChatMode, ChatBox.publicChatMode);
            }

            SoundSystem.updateObjectSounds(Player.localPlayer.worldX, Player.worldLevel, MovedStatics.anInt199, Player.localPlayer.worldY);
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
            Class33.setLoginScreenMessage(English.gameHasBeenUpdated, English.pleaseReloadThisPage, "");
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
        MovedStatics.processGameStatus(10);
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
            if(ScreenController.frameMode == ScreenMode.FIXED && Projectile.menuScreenArea == 0){
                MovedStatics.drawMenu(4,4); // might be 0,0
            }
        try {
            Graphics graphics = MouseHandler.gameCanvas.getGraphics();
            ProducingGraphicsBuffer_Sub1.aProducingGraphicsBuffer_2213.drawGraphics(0, 0, graphics);
        } catch(Exception exception) {
            MouseHandler.gameCanvas.repaint();
        }
    }

    public static void method165() {
        int i = 64 + SceneCluster.anInt767 * 128;
        int i_3_ = 64 + 128 * MovedStatics.anInt545;
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
        if(MovedStatics.cameraY < i) {
            MovedStatics.cameraY += MovedStatics.anInt188 + Class59.anInt1386 * (-MovedStatics.cameraY + i) / 1000;
            if(MovedStatics.cameraY > i)
                MovedStatics.cameraY = i;
        }
        if(SceneCluster.cameraZ > i_4_) {
            SceneCluster.cameraZ -= (SceneCluster.cameraZ + -i_4_) * Class59.anInt1386 / 1000 + MovedStatics.anInt188;
            if(i_4_ > SceneCluster.cameraZ)
                SceneCluster.cameraZ = i_4_;
        }
        i_3_ = 64 + MovedStatics.anInt564 * 128;
        if(MovedStatics.cameraY > i) {
            MovedStatics.cameraY -= MovedStatics.anInt188 + Class59.anInt1386 * (MovedStatics.cameraY - i) / 1000;
            if(MovedStatics.cameraY < i)
                MovedStatics.cameraY = i;
        }
        i = MovedStatics.anInt2576 * 128 + 64;
        i_4_ = Class37.getFloorDrawHeight(Player.worldLevel, i_3_, i) - MovedStatics.anInt892;
        int i_5_ = -SceneCluster.cameraZ + i_4_;
        int i_6_ = i - MovedStatics.cameraY;
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
            ProducingGraphicsBuffer_Sub1.anInt2210 += MovedStatics.anInt1856 * i_11_ / 1000 + Class60.anInt1413;
            ProducingGraphicsBuffer_Sub1.anInt2210 &= 0x7ff;
        }
        if(true) {
            if(i_11_ < 0) {
                ProducingGraphicsBuffer_Sub1.anInt2210 -= Class60.anInt1413 + MovedStatics.anInt1856 * -i_11_ / 1000;
                ProducingGraphicsBuffer_Sub1.anInt2210 &= 0x7ff;
            }
            if(i_9_ > Class26.anInt627) {
                Class26.anInt627 += Class60.anInt1413 + MovedStatics.anInt1856 * (i_9_ - Class26.anInt627) / 1000;
                if(Class26.anInt627 > i_9_)
                    Class26.anInt627 = i_9_;
            }
            if(Class26.anInt627 > i_9_) {
                Class26.anInt627 -= MovedStatics.anInt1856 * (Class26.anInt627 + -i_9_) / 1000 + Class60.anInt1413;
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

    public static void updateGame() {
        if(Class40_Sub5_Sub15.systemUpdateTime > 1)
            Class40_Sub5_Sub15.systemUpdateTime--;
        if(SceneCluster.idleLogout > 0)
            SceneCluster.idleLogout--;
        if(Class37.aBoolean871) {
            Class37.aBoolean871 = false;
            Class59.dropClient();
        } else {
            for(int i = 0; i < 100; i++) {
                if(!IncomingPackets.parseIncomingPackets())
                    break;
            }
            if(Class51.gameStatusCode == 30 || Class51.gameStatusCode == 35) {
                if(ISAAC.aBoolean519 && Class51.gameStatusCode == 30) {
                    MouseHandler.currentMouseButtonPressed = 0;
                    MouseHandler.clickType = 0;
                    while(MovedStatics.method416()) {
                        /* empty */
                    }
                    for(int i = 0; i < Item.obfuscatedKeyStatus.length; i++)
                        Item.obfuscatedKeyStatus[i] = false;
                }
                ClientScriptRunner.createClientScriptCheckPacket(205, SceneCluster.packetBuffer);
                synchronized(Class12.mouseCapturer.objectLock) {
                    if(MovedStatics.accountFlagged) {
                        if(MouseHandler.clickType != 0 || Class12.mouseCapturer.coord >= 40) {
                            int coordinateCount = 0;
                            SceneCluster.packetBuffer.putPacket(210);
                            SceneCluster.packetBuffer.putByte(0);
                            int originalOffset = SceneCluster.packetBuffer.currentPosition;
                            for(int c = 0; c < Class12.mouseCapturer.coord; c++) {
                                if(-originalOffset + SceneCluster.packetBuffer.currentPosition >= 240)
                                    break;
                                coordinateCount++;
                                int pixelOffset = Class12.mouseCapturer.coordsY[c];
                                if(pixelOffset >= 0) {
                                    if(pixelOffset > 502)
                                        pixelOffset = 502;
                                } else
                                    pixelOffset = 0;
                                int x = Class12.mouseCapturer.coordsX[c];
                                if(x < 0)
                                    x = 0;
                                else if(x > 764)
                                    x = 764;
                                int y = pixelOffset * 765 + x;
                                if(Class12.mouseCapturer.coordsY[c] == -1 && Class12.mouseCapturer.coordsX[c] == -1) {
                                    x = -1;
                                    y = -1;
                                    pixelOffset = 0x7ffff;
                                }
                                if(x == PacketBuffer.lastClickX && y == GameObjectDefinition.lastClickY) {
                                    if(MovedStatics.duplicateClickCount < 2047)
                                        MovedStatics.duplicateClickCount++;
                                } else {
                                    int differenceX = x - PacketBuffer.lastClickX;
                                    PacketBuffer.lastClickX = x;
                                    int differenceY = pixelOffset - GameObjectDefinition.lastClickY;
                                    GameObjectDefinition.lastClickY = pixelOffset;
                                    if(MovedStatics.duplicateClickCount < 8 && differenceX >= -32 && differenceX <= 31 && differenceY >= -32 && differenceY <= 31) {
                                        differenceX += 32;
                                        differenceY += 32;
                                        SceneCluster.packetBuffer.putShortBE(differenceY + (differenceX << 6) + (MovedStatics.duplicateClickCount << 12));
                                        MovedStatics.duplicateClickCount = 0;
                                    } else if(MovedStatics.duplicateClickCount < 8) {
                                        SceneCluster.packetBuffer.putMediumBE(y + 8388608 + (MovedStatics.duplicateClickCount << 19));
                                        MovedStatics.duplicateClickCount = 0;
                                    } else {
                                        SceneCluster.packetBuffer.putIntBE((MovedStatics.duplicateClickCount << 19) + -1073741824 + y);
                                        MovedStatics.duplicateClickCount = 0;
                                    }
                                }
                            }
                            SceneCluster.packetBuffer.finishVarByte(SceneCluster.packetBuffer.currentPosition + -originalOffset);
                            if(coordinateCount < Class12.mouseCapturer.coord) {
                                Class12.mouseCapturer.coord -= coordinateCount;
                                for(int i_9_ = 0; Class12.mouseCapturer.coord > i_9_; i_9_++) {
                                    Class12.mouseCapturer.coordsX[i_9_] = Class12.mouseCapturer.coordsX[coordinateCount + i_9_];
                                    Class12.mouseCapturer.coordsY[i_9_] = Class12.mouseCapturer.coordsY[i_9_ + coordinateCount];
                                }
                            } else
                                Class12.mouseCapturer.coord = 0;
                        }
                    } else {
                        Class12.mouseCapturer.coord = 0;
                    }
                }
                if(MouseHandler.clickType != 0) {
                    long l = (GameObjectDefinition.aLong2561 - Class51.aLong1203) / 50L;
                    int i = Class57.clickX;
                    int i_10_ = RSString.clickY;
                    Class51.aLong1203 = GameObjectDefinition.aLong2561;
                    if(i >= 0) {
                        if(i > 764)
                            i = 764;
                    } else
                        i = 0;
                    if(i_10_ >= 0) {
                        if(i_10_ > 502)
                            i_10_ = 502;
                    } else
                        i_10_ = 0;
                    int i_11_ = 0;
                    if(MouseHandler.clickType == 2)
                        i_11_ = 1;
                    if(l > 4095)
                        l = 4095L;
                    int i_12_ = (int) l;
                    SceneCluster.packetBuffer.putPacket(234);
                    int i_13_ = i_10_ * 765 + i;
                    SceneCluster.packetBuffer.putIntLE((i_11_ << 19) + (i_12_ << 20) + i_13_);
                }
                if(InteractiveObject.anInt487 > 0)
                    InteractiveObject.anInt487--;
                if(Item.obfuscatedKeyStatus[96] || Item.obfuscatedKeyStatus[97] || Item.obfuscatedKeyStatus[98] || Item.obfuscatedKeyStatus[99])
                    MovedStatics.aBoolean565 = true;
                if(MovedStatics.aBoolean565 && InteractiveObject.anInt487 <= 0) {
                    InteractiveObject.anInt487 = 20;
                    MovedStatics.aBoolean565 = false;
                    SceneCluster.packetBuffer.putPacket(58);
                    SceneCluster.packetBuffer.putShortBE(GroundItemTile.cameraHorizontal);
                    SceneCluster.packetBuffer.putShortBE(Class65.cameraVertical);
                }
                if(MovedStatics.aBoolean571 && !Class35.aBoolean1735) {
                    Class35.aBoolean1735 = true;
                    SceneCluster.packetBuffer.putPacket(160);
                    SceneCluster.packetBuffer.putByte(1);
                }
                if(!MovedStatics.aBoolean571 && Class35.aBoolean1735) {
                    Class35.aBoolean1735 = false;
                    SceneCluster.packetBuffer.putPacket(160);
                    SceneCluster.packetBuffer.putByte(0);
                }
                LinkedList.method910();
                if(Class51.gameStatusCode == 30 || Class51.gameStatusCode == 35) {
                    MovedStatics.method652();
                    SoundSystem.processSounds();
                    MusicSystem.processMusic();
                    IncomingPackets.cyclesSinceLastPacket++;
                    if (IncomingPackets.cyclesSinceLastPacket > 750) {
                        Class59.dropClient();
                    } else {
                        Class17.animatePlayers(-1);
                        MovedStatics.animateNpcs();
                        MovedStatics.method313();
                        if(LinkedList.crossType != 0) {
                            OverlayDefinition.crossIndex += 20;
                            if(OverlayDefinition.crossIndex >= 400)
                                LinkedList.crossType = 0;
                        }
                        if(Projectile.atInventoryInterfaceType != 0) {
                            RSRuntimeException.anInt1651++;
                            if(RSRuntimeException.anInt1651 >= 15) {
                                if(Projectile.atInventoryInterfaceType == 2)
                                    GameInterface.redrawTabArea = true;
                                if(Projectile.atInventoryInterfaceType == 3)
                                    ChatBox.redrawChatbox = true;
                                Projectile.atInventoryInterfaceType = 0;
                            }
                        }
                        MovedStatics.anInt199++;
                        if(SceneTile.activeInterfaceType != 0) {
                            Buffer.lastItemDragTime++;
                            if(Class13.mouseX > Renderable.anInt2869 + 5 || Renderable.anInt2869 + -5 > Class13.mouseX || ItemDefinition.anInt2798 + 5 < Landscape.mouseY || ItemDefinition.anInt2798 - 5 > Landscape.mouseY)
                                Class40_Sub5_Sub15.lastItemDragged = true;
                            if(MouseHandler.currentMouseButtonPressed == 0) {
                                if(SceneTile.activeInterfaceType == 3)
                                    ChatBox.redrawChatbox = true;
                                if(SceneTile.activeInterfaceType == 2)
                                    GameInterface.redrawTabArea = true;
                                SceneTile.activeInterfaceType = 0;
                                if(Class40_Sub5_Sub15.lastItemDragged && Buffer.lastItemDragTime >= 5) {
                                    RSRuntimeException.lastActiveInvInterface = -1;
                                    Class43.processRightClick();
                                    if(RSRuntimeException.lastActiveInvInterface == MovedStatics.modifiedWidgetId && Class55.mouseInvInterfaceIndex != GroundItemTile.selectedInventorySlot) {
                                        GameInterface childInterface = GameInterface.getInterface(MovedStatics.modifiedWidgetId);
                                        int moveItemInsertionMode = 0;
                                        if(Class43.bankInsertMode == 1 && childInterface.contentType == 206)
                                            moveItemInsertionMode = 1;
                                        if(childInterface.items[Class55.mouseInvInterfaceIndex] <= 0)
                                            moveItemInsertionMode = 0;
                                        if(childInterface.itemDeletesDraged) {
                                            int i_16_ = Class55.mouseInvInterfaceIndex;
                                            int i_17_ = GroundItemTile.selectedInventorySlot;
                                            childInterface.items[i_16_] = childInterface.items[i_17_];
                                            childInterface.itemAmounts[i_16_] = childInterface.itemAmounts[i_17_];
                                            childInterface.items[i_17_] = -1;
                                            childInterface.itemAmounts[i_17_] = 0;
                                        } else if(moveItemInsertionMode == 1) {
                                            int slotStart = GroundItemTile.selectedInventorySlot;
                                            int slotEnd = Class55.mouseInvInterfaceIndex;
                                            while(slotEnd != slotStart) {
                                                if(slotStart <= slotEnd) {
                                                    if(slotStart < slotEnd) {
                                                        childInterface.swapItems(1 + slotStart, false, slotStart);
                                                        slotStart++;
                                                    }
                                                } else {
                                                    childInterface.swapItems(-1 + slotStart, false, slotStart);
                                                    slotStart--;
                                                }
                                            }
                                        } else
                                            childInterface.swapItems(Class55.mouseInvInterfaceIndex, false, GroundItemTile.selectedInventorySlot);
                                        SceneCluster.packetBuffer.putPacket(83);
                                        SceneCluster.packetBuffer.putByte(moveItemInsertionMode);
                                        SceneCluster.packetBuffer.putShortBE(GroundItemTile.selectedInventorySlot);
                                        SceneCluster.packetBuffer.putShortLE(Class55.mouseInvInterfaceIndex);
                                        SceneCluster.packetBuffer.putIntME2(MovedStatics.modifiedWidgetId);
                                    }
                                } else {
                                    if((ProducingGraphicsBuffer.oneMouseButton == 1 || Class33.menuHasAddFriend(ActorDefinition.menuActionRow - 1)) && ActorDefinition.menuActionRow > 2)
                                        Class60.determineMenuSize();
                                    else if(ActorDefinition.menuActionRow > 0)
                                        GameInterface.processMenuActions(123, -1 + ActorDefinition.menuActionRow);
                                }
                                RSRuntimeException.anInt1651 = 10;
                                MouseHandler.clickType = 0;
                            }
                        }

                        if(Scene.clickedTileX != -1) {
                            int i = Scene.clickedTileX;
                            int i_18_ = Scene.clickedTileY;
                            boolean bool = Pathfinding.doWalkTo(0, 0, Player.localPlayer.pathY[0], i, 0, true, 0, 0, Player.localPlayer.pathX[0], i_18_, 0);
                            if(bool) {
                                MovedStatics.crossY = RSString.clickY;
                                OverlayDefinition.crossIndex = 0;
                                ClientScriptRunner.crossX = Class57.clickX;
                                LinkedList.crossType = 1;
                            }
                            Scene.clickedTileX = -1;
                        }

                        if(MouseHandler.clickType == 1 && Native.clickToContinueString != null) {
                            MouseHandler.clickType = 0;
                            ChatBox.redrawChatbox = true;
                            Native.clickToContinueString = null;
                        }

                        MouseHandler.processMenuClick();
                        if(GameInterface.fullscreenInterfaceId == -1) {
                            ScreenController.handleMinimapMouse();
                            ScreenController.handleTabClick();
                            ScreenController.handleChatButtonsClick();
                        }

                        if(MouseHandler.currentMouseButtonPressed == 1 || MouseHandler.clickType == 1)
                            Npc.anInt3294++;

                        int i = 34;
                        if(GameInterface.gameScreenInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(516, i, 338, GameInterface.gameScreenInterfaceId, 4, 4);

                        if(GameInterface.tabAreaInterfaceId == -1) {
                            if(Player.tabWidgetIds[Player.currentTabId] != -1)
                                GameInterface.runClientScriptsForParentInterface(743, i, 466, Player.tabWidgetIds[Player.currentTabId], 205, 553);
                        } else
                            GameInterface.runClientScriptsForParentInterface(743, i, 466, GameInterface.tabAreaInterfaceId, 205, 553);

                        if(GameInterface.chatboxInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i, 453, GameInterface.chatboxInterfaceId, 357, 17);
                        else if(ChatBox.dialogueId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i, 453, ChatBox.dialogueId, 357, 17);

                        if(GameInterface.gameScreenInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(516, i ^ 0xffffffff, 338, GameInterface.gameScreenInterfaceId, 4, 4);

                        if(GameInterface.tabAreaInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(743, i ^ 0xffffffff, 466, GameInterface.tabAreaInterfaceId, 205, 553);

                        else if(Player.tabWidgetIds[Player.currentTabId] != -1)
                            GameInterface.runClientScriptsForParentInterface(743, i ^ 0xffffffff, 466, Player.tabWidgetIds[Player.currentTabId], 205, 553);

                        if(GameInterface.chatboxInterfaceId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i ^ 0xffffffff, 453, GameInterface.chatboxInterfaceId, 357, 17);
                        else if(ChatBox.dialogueId != -1)
                            GameInterface.runClientScriptsForParentInterface(496, i ^ 0xffffffff, 453, ChatBox.dialogueId, 357, 17);

                        // If hovering over a widget
                        if(MovedStatics.anInt1586 != -1 || FloorDecoration.anInt614 != -1 || MovedStatics.anInt573 != -1) {
                            if(RSString.tooltipDelay > WallDecoration.durationHoveredOverWidget) {
                                WallDecoration.durationHoveredOverWidget++;
                                if(RSString.tooltipDelay == WallDecoration.durationHoveredOverWidget) {
                                    if(MovedStatics.anInt1586 != -1)
                                        ChatBox.redrawChatbox = true;
                                    if(FloorDecoration.anInt614 != -1)
                                        GameInterface.redrawTabArea = true;
                                }
                            }
                        } else if(WallDecoration.durationHoveredOverWidget > 0)
                            WallDecoration.durationHoveredOverWidget--;
                        Item.calculateCameraPosition();
                        if(Player.cutsceneActive)
                            method165();
                        for(int i_19_ = 0; i_19_ < 5; i_19_++)
                            MovedStatics.anIntArray1846[i_19_]++;
                        MovedStatics.manageTextInputs();
                        int i_20_ = Npc.method400(-1);
                        int i_21_ = Class17.method274();
                        if(i_20_ > 4500 && i_21_ > 4500) {
                            SceneCluster.idleLogout = 250;
                            MovedStatics.method650(4000);
                            SceneCluster.packetBuffer.putPacket(216);
                        }
                        Player.anInt3264++;
                        MovedStatics.anInt1923++;
                        if(MovedStatics.anInt1923 > 500) {
                            int i_22_ = (int) (8.0 * Math.random());
                            if((0x2 & i_22_) == 2)
                                MovedStatics.cameraOffsetY += ProducingGraphicsBuffer_Sub1.anInt2211;
                            if((i_22_ & 0x1) == 1)
                                Buffer.cameraOffsetX += MovedStatics.anInt1010;
                            MovedStatics.anInt1923 = 0;
                            if((0x4 & i_22_) == 4)
                                Class57.anInt1342 += MovedStatics.anInt195;
                        }
                        if(MovedStatics.cameraOffsetY < -55)
                            ProducingGraphicsBuffer_Sub1.anInt2211 = 2;
                        if(Player.anInt3264 > 500) {
                            int i_23_ = (int) (Math.random() * 8.0);
                            if((0x1 & i_23_) == 1)
                                Class43.cameraYawOffset += Class13.anInt419;
                            if((0x2 & i_23_) == 2)
                                Class51.mapZoomOffset += anInt1766;
                            Player.anInt3264 = 0;
                        }
                        if(MovedStatics.cameraOffsetY > 55)
                            ProducingGraphicsBuffer_Sub1.anInt2211 = -2;
                        if(Buffer.cameraOffsetX < -50)
                            MovedStatics.anInt1010 = 2;
                        if(Class43.cameraYawOffset < -60)
                            Class13.anInt419 = 2;
                        MovedStatics.anInt537++;
                        if(Buffer.cameraOffsetX > 50)
                            MovedStatics.anInt1010 = -2;
                        if(Class43.cameraYawOffset > 60)
                            Class13.anInt419 = -2;
                        if(Class57.anInt1342 < -40)
                            MovedStatics.anInt195 = 1;
                        if(Class57.anInt1342 > 40)
                            MovedStatics.anInt195 = -1;
                        if(Class51.mapZoomOffset < -20)
                            anInt1766 = 1;
                        if(Class51.mapZoomOffset > 10)
                            anInt1766 = -1;
                        if(MovedStatics.anInt537 > 50) {
                            SceneCluster.packetBuffer.putPacket(13);
                        }
                        do {
                            try {
                                if(MovedStatics.gameServerSocket == null || SceneCluster.packetBuffer.currentPosition <= 0)
                                    break;
                                MovedStatics.gameServerSocket.sendDataFromBuffer(SceneCluster.packetBuffer.currentPosition, 0, SceneCluster.packetBuffer.buffer);
                                MovedStatics.anInt537 = 0;
                                SceneCluster.packetBuffer.currentPosition = 0;
                            } catch(java.io.IOException ioexception) {
                                Class59.dropClient();
                                break;
                            }
                            break;
                        } while(false);
                    }
                }
            }
        }
    }

    public static void printHelp() {
        System.out.println("Usage: worldid, [live/office/local], [live/rc/wip], [lowmem/highmem], [free/members]");
        System.exit(1);
    }

    public static void handleLoginScreenActions() {
        try {
            if (Class40_Sub3.loginStatus == 0) { // Initialize
                if (MovedStatics.gameServerSocket != null) {
                    MovedStatics.gameServerSocket.kill();
                    MovedStatics.gameServerSocket = null;
                }
                Class37.aBoolean871 = false;
                Class40_Sub3.loginStatus = 1;
                anInt1756 = 0;
                FloorDecoration.gameServerSignlinkNode = null;
            }
            if (Class40_Sub3.loginStatus == 1) { // Create connection to server, and wait for it to become available
                if (FloorDecoration.gameServerSignlinkNode == null) {
                    FloorDecoration.gameServerSignlinkNode = signlink.createSocketNode(currentPort);
                }
                if (FloorDecoration.gameServerSignlinkNode.status == 2) {
                    throw new IOException();
                }
                if (FloorDecoration.gameServerSignlinkNode.status == 1) {
                    MovedStatics.gameServerSocket = new GameSocket((Socket) FloorDecoration.gameServerSignlinkNode.value, signlink);
                    Class40_Sub3.loginStatus = 2;
                    FloorDecoration.gameServerSignlinkNode = null;
                }
            }
            if (Class40_Sub3.loginStatus == 2) {
                long l = MovedStatics.aLong853 = RSString.nameToLong(Native.username.toString());
                SceneCluster.packetBuffer.currentPosition = 0;
                SceneCluster.packetBuffer.putByte(14);
                int i = (int) (0x1fL & l >> 16);
                SceneCluster.packetBuffer.putByte(i);
                MovedStatics.gameServerSocket.sendDataFromBuffer(2, 0, SceneCluster.packetBuffer.buffer);
                Class40_Sub3.loginStatus = 3;
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
            }
            if (Class40_Sub3.loginStatus == 3) {
                int i = MovedStatics.gameServerSocket.read();
                if (i != 0) {
                    displayMessageForResponseCode(i);
                    return;
                }
                IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                Class40_Sub3.loginStatus = 4;
            }
            if (Class40_Sub3.loginStatus == 4) {

                if (IncomingPackets.incomingPacketBuffer.currentPosition < 8) {
                    int i = MovedStatics.gameServerSocket.inputStreamAvailable();
                    if (i > -IncomingPackets.incomingPacketBuffer.currentPosition + 8) {
                        i = -IncomingPackets.incomingPacketBuffer.currentPosition + 8;
                    }
                    if (i > 0) {
                        MovedStatics.gameServerSocket.readDataToBuffer(IncomingPackets.incomingPacketBuffer.currentPosition, i, IncomingPackets.incomingPacketBuffer.buffer);
                        IncomingPackets.incomingPacketBuffer.currentPosition += i;
                    }
                }
                if (IncomingPackets.incomingPacketBuffer.currentPosition == 8) {
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    Renderable.aLong2858 = IncomingPackets.incomingPacketBuffer.getLongBE();
                    Class40_Sub3.loginStatus = 5;
                }
            }
            if (Class40_Sub3.loginStatus == 5) {
                int[] seeds = new int[4];
                seeds[0] = (int) (Math.random() * 9.9999999E7);
                seeds[1] = (int) (Math.random() * 9.9999999E7);
                seeds[2] = (int) (Renderable.aLong2858 >> 32);
                seeds[3] = (int) Renderable.aLong2858;
                SceneCluster.packetBuffer.currentPosition = 0;
                SceneCluster.packetBuffer.putByte(10);
                SceneCluster.packetBuffer.putIntBE(seeds[0]);
                SceneCluster.packetBuffer.putIntBE(seeds[1]);
                SceneCluster.packetBuffer.putIntBE(seeds[2]);
                SceneCluster.packetBuffer.putIntBE(seeds[3]);
                SceneCluster.packetBuffer.putIntBE(signlink.uid);
                SceneCluster.packetBuffer.putLongBE(RSString.nameToLong(Native.username.toString()));
                SceneCluster.packetBuffer.method505(Native.password);
                if (Configuration.RSA_ENABLED) {
                    SceneCluster.packetBuffer.applyRSA(Configuration.RSA_MODULUS, Configuration.RSA_PUBLIC_KEY);
                }


                // The actual login packet starts here

                MovedStatics.packetBuffer.currentPosition = 0;
                if (Class51.gameStatusCode == 40) {
                    // Reconnecting session
                    MovedStatics.packetBuffer.putByte(18);
                } else {
                    // New session
                    MovedStatics.packetBuffer.putByte(16);
                }
                MovedStatics.packetBuffer.putByte(57 + SceneCluster.packetBuffer.currentPosition);
                MovedStatics.packetBuffer.putIntBE(435);
                MovedStatics.packetBuffer.putByte(VertexNormal.lowMemory ? 1 : 0);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.skeletonCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.skinDefinitionCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameDefinitionsCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameInterfaceCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.soundEffectCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameWorldMapCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.musicCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.modelCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameImageCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.gameTextureCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.huffmanCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.jingleCacheArchive.crc8);
                MovedStatics.packetBuffer.putIntBE(CacheArchive.clientScriptCacheArchive.crc8);
                MovedStatics.packetBuffer.putBytes(0, SceneCluster.packetBuffer.currentPosition, SceneCluster.packetBuffer.buffer);
                MovedStatics.gameServerSocket.sendDataFromBuffer(MovedStatics.packetBuffer.currentPosition, 0, MovedStatics.packetBuffer.buffer);
                SceneCluster.packetBuffer.initOutCipher(seeds);
                for (int i = 0; i < 4; i++) {
                    seeds[i] += 50;
                }
                IncomingPackets.incomingPacketBuffer.initInCipher(seeds);
                Class40_Sub3.loginStatus = 6;
            }



            if (Class40_Sub3.loginStatus == 6 && MovedStatics.gameServerSocket.inputStreamAvailable() > 0) {
                int responseCode = MovedStatics.gameServerSocket.read();
                if (responseCode != 21 || Class51.gameStatusCode != 20) {
                    if (responseCode == 2) {
                        Class40_Sub3.loginStatus = 9;
                    } else {
                        if (responseCode == 15 && Class51.gameStatusCode == 40) {
                            Class37.method434();
                            return;
                        }
                        if (responseCode == 23 && OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            Class40_Sub3.loginStatus = 0;
                        } else {
                            displayMessageForResponseCode(responseCode);
                            return;
                        }
                    }
                } else {
                    Class40_Sub3.loginStatus = 7;
                }
            }
            if (Class40_Sub3.loginStatus == 7 && MovedStatics.gameServerSocket.inputStreamAvailable() > 0) {
                Class33.anInt784 = 180 + MovedStatics.gameServerSocket.read() * 60;
                Class40_Sub3.loginStatus = 8;

            }
            if (Class40_Sub3.loginStatus == 8) {
                anInt1756 = 0;
                Class33.setLoginScreenMessage(English.youHaveJustLeftAnotherWorld, English.yourProfileWillBeTransferredIn, (Class33.anInt784 / 60) + English.suffixSeconds);
                if (--Class33.anInt784 <= 0) {
                    Class40_Sub3.loginStatus = 0;
                }
            } else {
                if (Class40_Sub3.loginStatus == 9 && MovedStatics.gameServerSocket.inputStreamAvailable() >= 8) {
                    Configuration.USERNAME = Native.username.toString();
                    Configuration.PASSWORD = Native.password.toString();
                    InteractiveObject.playerRights = MovedStatics.gameServerSocket.read();
                    MovedStatics.accountFlagged = MovedStatics.gameServerSocket.read() == 1;
                    PlayerAppearance.anInt708 = MovedStatics.gameServerSocket.read();
                    PlayerAppearance.anInt708 <<= 8;
                    PlayerAppearance.anInt708 += MovedStatics.gameServerSocket.read();
                    Class44.anInt1049 = MovedStatics.gameServerSocket.read();
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 1, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.opcode = IncomingPackets.incomingPacketBuffer.getPacket();
                    MovedStatics.gameServerSocket.readDataToBuffer(0, 2, IncomingPackets.incomingPacketBuffer.buffer);
                    IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                    IncomingPackets.incomingPacketSize = IncomingPackets.incomingPacketBuffer.getUnsignedShortBE();
                    Class40_Sub3.loginStatus = 10;
                }
                if (Class40_Sub3.loginStatus == 10) {
                    if (MovedStatics.gameServerSocket.inputStreamAvailable() >= IncomingPackets.incomingPacketSize) {
                        IncomingPackets.incomingPacketBuffer.currentPosition = 0;
                        MovedStatics.gameServerSocket.readDataToBuffer(0, IncomingPackets.incomingPacketSize, IncomingPackets.incomingPacketBuffer.buffer);
                        setConfigToDefaults();
                        Class51.regionX = -1;
                        FloorDecoration.constructMapRegion(false);
                        IncomingPackets.opcode = -1;
                    }
                } else {
                    anInt1756++;
                    if (anInt1756 > 2000) {
                        if (OverlayDefinition.anInt2321 < 1) {
                            OverlayDefinition.anInt2321++;
                            if (OverlayDefinition.gameServerPort == currentPort) {
                                currentPort = CollisionMap.someOtherPort;
                            } else {
                                currentPort = OverlayDefinition.gameServerPort;
                            }
                            Class40_Sub3.loginStatus = 0;
                        } else {
                            displayMessageForResponseCode(-3);
                        }
                    }
                }
            }
        } catch (IOException ioexception) {
            if (OverlayDefinition.anInt2321 < 1) {
                if (currentPort == OverlayDefinition.gameServerPort) {
                    currentPort = CollisionMap.someOtherPort;
                } else {
                    currentPort = OverlayDefinition.gameServerPort;
                }
                OverlayDefinition.anInt2321++;
                Class40_Sub3.loginStatus = 0;
            } else {
                displayMessageForResponseCode(-2);
            }
        }
    }

    public void method35(int arg1) {
        if (currentPort != OverlayDefinition.gameServerPort)
            currentPort = OverlayDefinition.gameServerPort;
        else
            currentPort = CollisionMap.someOtherPort;
        Class29.updateServerSocket = null;
        ProducingGraphicsBuffer.updateServerSignlinkNode = null;
        MovedStatics.anInt292++;
        MovedStatics.connectionStage = 0;
        if (MovedStatics.anInt292 < 2 || arg1 != 7 && arg1 != 9) {
            if (MovedStatics.anInt292 < 2 || arg1 != 6) {
                if (MovedStatics.anInt292 >= 4) {
                    if (Class51.gameStatusCode <= 5) {
                        this.openErrorPage("js5connect");
                        ISAAC.anInt509 = 3000;
                    } else
                        ISAAC.anInt509 = 3000;
                }
            } else {
                this.openErrorPage("js5connect_outofdate");
                Class51.gameStatusCode = 1000;
            }
        } else if (Class51.gameStatusCode > 5)
            ISAAC.anInt509 = 3000;
        else {
            this.openErrorPage("js5connect_full");
            Class51.gameStatusCode = 1000;
        }
    }

    public void processGameLoop() {
        MovedStatics.pulseCycle++;
        handleUpdateServer();
        Class13.handleRequests();
        MusicSystem.handleMusic();
        SoundSystem.handleSounds();
        GameInterface.method639();
        MovedStatics.method1015();

        if (Class51.gameStatusCode == 0) {
            Class40_Sub3.startup();
            Class60.method992();
        } else if (Class51.gameStatusCode == 5) {
            Class40_Sub3.startup();
            Class60.method992();
        } else if (Class51.gameStatusCode == 10) {
            Class60.updateLogin();
        } else if (Class51.gameStatusCode == 20) {
            Class60.updateLogin();
            handleLoginScreenActions();
        } else if (Class51.gameStatusCode == 25)
            Landscape.loadRegion();
        if (Class51.gameStatusCode == 30) {
            ScreenController.refreshFrameSize();
            updateGame();
        } else if (Class51.gameStatusCode == 35) {
            ScreenController.refreshFrameSize();
            updateGame();
        } else if (Class51.gameStatusCode == 40) {
            // Connection lost
            handleLoginScreenActions();
        }
    }

    public void handleUpdateServer() {
        if (Class51.gameStatusCode != 1000) {
            boolean bool = UpdateServer.processUpdateServerResponse();
            if (!bool)
                connectUpdateServer();
        }
    }

    /**
     * Sets the text that is shown in the middle of the screen depending on the current status code
     */
    public void updateStatusText() {
        if (MovedStatics.aBoolean1575) {
            MovedStatics.method311(MouseHandler.gameCanvas);
            Class55.method965(32, MouseHandler.gameCanvas);
            this.setCanvas();
            GameInterface.method642(MouseHandler.gameCanvas);
            RSRuntimeException.method1056(MouseHandler.gameCanvas);
        }
        if (Class51.gameStatusCode == 0)
            GameObject.drawLoadingText(MovedStatics.anInt1607, null, Native.currentLoadingText);
        else if (Class51.gameStatusCode == 5) {
            WallDecoration.drawLoadingScreen(TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.gameStatusCode == 10) {
            WallDecoration.drawLoadingScreen(TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.gameStatusCode == 20) {
            WallDecoration.drawLoadingScreen(TypeFace.fontBold, TypeFace.fontSmall);
        } else if (Class51.gameStatusCode == 25) {
            if (ProducingGraphicsBuffer.anInt1634 == 1) {
                if (Class37.anInt874 > PacketBuffer.anInt2231)
                    PacketBuffer.anInt2231 = Class37.anInt874;
                int i = (-Class37.anInt874 + PacketBuffer.anInt2231) * 50 / PacketBuffer.anInt2231;
                Class51.method940(English.loadingPleaseWait, true, Native.leftParenthesis + i + Native.percent_b);
            } else if (ProducingGraphicsBuffer.anInt1634 == 2) {
                if (IdentityKit.anInt2591 > GameObject.anInt3048)
                    GameObject.anInt3048 = IdentityKit.anInt2591;
                int i = 50 * (-IdentityKit.anInt2591 + GameObject.anInt3048) / GameObject.anInt3048 + 50;
                Class51.method940(English.loadingPleaseWait, true, Native.leftParenthesis + i + Native.percent_b);
            } else
                Class51.method940(English.loadingPleaseWait, false, null);
        } else if (Class51.gameStatusCode == 30) {
            drawGameScreen();

        } else if (Class51.gameStatusCode == 35) {
            method164();
        } else if (Class51.gameStatusCode == 40)
            Class51.method940(English.connectionLost, false, English.pleaseWaitAttemptingToReestablish);
        Npc.anInt3294 = 0;
    }

    public void connectUpdateServer() {
        if (UpdateServer.crcMismatches >= 4) {
            this.openErrorPage("js5crc");
            Class51.gameStatusCode = 1000;
        } else {
            if (UpdateServer.ioExceptions >= 4) {
                if (Class51.gameStatusCode > 5) {
                    UpdateServer.ioExceptions = 3;
                    ISAAC.anInt509 = 3000;
                } else {
                    this.openErrorPage("js5io");
                    Class51.gameStatusCode = 1000;
                    return;
                }
            }
            if (ISAAC.anInt509-- <= 0) {
                do {
                    try {
                        if (MovedStatics.connectionStage == 0) {
                            ProducingGraphicsBuffer.updateServerSignlinkNode = signlink.createSocketNode(currentPort);
                            MovedStatics.connectionStage++;
                        }
                        if (MovedStatics.connectionStage == 1) {
                            if (ProducingGraphicsBuffer.updateServerSignlinkNode.status == 2) {
                                method35(-1);
                                break;
                            }
                            if (ProducingGraphicsBuffer.updateServerSignlinkNode.status == 1)
                                MovedStatics.connectionStage++;
                        }
                        if (MovedStatics.connectionStage == 2) {
                            Class29.updateServerSocket = new GameSocket((Socket) ProducingGraphicsBuffer.updateServerSignlinkNode.value, signlink);
                            Buffer buffer = new Buffer(5);
                            buffer.putByte(15);
                            buffer.putIntBE(435); // Cache revision
                            Class29.updateServerSocket.sendDataFromBuffer(5, 0, buffer.buffer);
                            MovedStatics.connectionStage++;
                            MovedStatics.aLong1841 = System.currentTimeMillis();
                        }
                        if (MovedStatics.connectionStage == 3) {
                            if (Class51.gameStatusCode > 5 && Class29.updateServerSocket.inputStreamAvailable() <= 0) {
                                if (System.currentTimeMillis() + -MovedStatics.aLong1841 > 30000L) {
                                    method35(-2);
                                    break;
                                }
                            } else {
                                int i = Class29.updateServerSocket.read();
                                if (i != 0) {
                                    method35(i);
                                    break;
                                }
                                MovedStatics.connectionStage++;
                            }
                        }
                        if (MovedStatics.connectionStage != 4)
                            break;

                        UpdateServer.handleUpdateServerConnection(Class29.updateServerSocket, Class51.gameStatusCode > 20);

                        ProducingGraphicsBuffer.updateServerSignlinkNode = null;
                        MovedStatics.connectionStage = 0;
                        Class29.updateServerSocket = null;
                        MovedStatics.anInt292 = 0;
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
        if (MovedStatics.gameServerSocket != null) {
            MovedStatics.gameServerSocket.kill();
            MovedStatics.gameServerSocket = null;
        }
        ItemDefinition.method744();
        Class13.method249();
        MusicSystem.syncedStop(false);
        SoundSystem.stop();
        UpdateServer.killUpdateServerSocket();
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


    public void startup() {
        // Define ports
        CollisionMap.someOtherPort = Class44.modewhere == 0 ? 443 : 50000 + Player.worldId;
        OverlayDefinition.gameServerPort = Class44.modewhere != 0 ? Player.worldId + 40000 : Configuration.GAME_PORT;
        currentPort = OverlayDefinition.gameServerPort;

        MovedStatics.method997();
        GameInterface.method642(MouseHandler.gameCanvas);
        RSRuntimeException.method1056(MouseHandler.gameCanvas);
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
