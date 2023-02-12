package org.runejs.client.net;

import org.runejs.client.node.NodeCache;
import org.runejs.client.cache.def.OverlayDefinition;
import org.runejs.client.cache.def.UnderlayDefinition;
import org.runejs.client.cache.media.AnimationSequence;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.input.MouseHandler;
import org.runejs.client.media.Rasterizer3D;
import org.runejs.client.media.VertexNormal;
import org.runejs.client.media.renderable.actor.Actor;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.tile.FloorDecoration;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.util.BitUtils;
import org.runejs.client.*;

public class ISAAC {
    /**
     * The golden ratio.
     */
    private static final int GOLDEN_RATIO = 0x9e3779b9;

    public static int anInt509 = 0;
    public static NodeCache cachedActorDefinitions = new NodeCache(64);
    public static boolean aBoolean512;
    public static NodeCache aClass9_516 = new NodeCache(64);
    public static boolean aBoolean519 = true;
    public static int anInt522 = -1;
    public static IndexedImage aClass40_Sub5_Sub14_Sub2_524;
    public static int anInt525;
    public static int[] mapCoordinates;

    public int count;
    public int accumulator;
    public int counter;
    public int[] rsl;
    public int[] mem;
    public int result;

    public ISAAC(int[] seed) {
        mem = new int[256];
        rsl = new int[256];
        for(int i = 0; seed.length > i; i++)
            rsl[i] = seed[i];
        init(true);
    }

    public static void createRegion(Scene scene, CollisionMap[] collisionMaps) {
        for(int plane = 0; plane < 4; plane++) {
            for(int x = 0; x < 104; x++) {
                for(int y = 0; y < 104; y++) {
                    if((0x1 & OverlayDefinition.tile_flags[plane][x][y]) == 1) {
                        int markingPlane = plane;
                        if((0x2 & OverlayDefinition.tile_flags[1][x][y]) == 2)
                            markingPlane--;
                        if(markingPlane >= 0)
                            collisionMaps[markingPlane].markBlocked(y, x);
                    }
                }
            }
        }
        Class40_Sub5_Sub15.randomiserHue += (int) (5.0 * Math.random()) + -2;
        Actor.randomiserLightness += -2 + (int) (5.0 * Math.random());
        if(Class40_Sub5_Sub15.randomiserHue < -8)
            Class40_Sub5_Sub15.randomiserHue = -8;
        if(Class40_Sub5_Sub15.randomiserHue > 8)
            Class40_Sub5_Sub15.randomiserHue = 8;
        if(Actor.randomiserLightness < -16)
            Actor.randomiserLightness = -16;
        if(Actor.randomiserLightness > 16)
            Actor.randomiserLightness = 16;
        for(int _plane = 0; _plane < 4; _plane++) {
            byte[][] shadowIntensity = InteractiveObject.tileShadowIntensity[_plane];
            int directionalLightLength = (int) Math.sqrt(5100.0);
            int specularDistribution = directionalLightLength * 768 >> 8;
            for(int y = 1; y < 103; y++) {
                for(int x = 1; x < 103; x++) {
                    int heightDifferenceX = -MovedStatics.tile_height[_plane][x - 1][y] + MovedStatics.tile_height[_plane][1 + x][y];
                    int heightDifferenceY = MovedStatics.tile_height[_plane][x][y + 1] + -MovedStatics.tile_height[_plane][x][y + -1];
                    int normalisedLength = (int) Math.sqrt(heightDifferenceY * heightDifferenceY + heightDifferenceX * heightDifferenceX + 65536);
                    int normalisedZ = 65536 / normalisedLength;
                    int weightedShadowIntensity = (shadowIntensity[x][y] >> 1) + (shadowIntensity[x][-1 + y] >> 2) + (shadowIntensity[1 + x][y] >> 3) + (shadowIntensity[x - 1][y] >> 2) + (shadowIntensity[x][1 + y] >> 3);
                    int normalisedX = (heightDifferenceX << 8) / normalisedLength;
                    int normalisedY = (heightDifferenceY << 8) / normalisedLength;
                    int directionalLightIntensity = 96 + (normalisedX * -50 + -10 * normalisedZ + normalisedY * -50) / specularDistribution;
                    AnimationSequence.tileLightIntensity[x][y] = directionalLightIntensity + -weightedShadowIntensity;
                }
            }
            for(int i_15_ = 0; i_15_ < 104; i_15_++) {
                Class40_Sub5_Sub17_Sub6.blendedHue[i_15_] = 0;
                Class59.blendedSaturation[i_15_] = 0;
                SceneTile.blendedLightness[i_15_] = 0;
                MovedStatics.blendedHueMultiplier[i_15_] = 0;
                FloorDecoration.blendDirectionTracker[i_15_] = 0;
            }
            for(int x = -5; x < 109; x++) {
                for(int y = 0; y < 104; y++) {
                    int positiveX = 5 + x;
                    if(positiveX >= 0 && positiveX < 104) {
                        int underlayId = 0xff & MovedStatics.tile_underlayids[_plane][positiveX][y];
                        if(underlayId > 0) {
                            UnderlayDefinition underlayDefinition = UnderlayDefinition.getDefinition(underlayId - 1);
                            Class40_Sub5_Sub17_Sub6.blendedHue[y] += underlayDefinition.hue;
                            Class59.blendedSaturation[y] += underlayDefinition.saturation;
                            SceneTile.blendedLightness[y] += underlayDefinition.lightness;
                            MovedStatics.blendedHueMultiplier[y] += underlayDefinition.hueMultiplier;
                            FloorDecoration.blendDirectionTracker[y]++;
                        }
                    }
                    int negativeX = x - 5;
                    if(negativeX >= 0 && negativeX < 104) {
                        int underlayId = 0xff & MovedStatics.tile_underlayids[_plane][negativeX][y];
                        if(underlayId > 0) {
                            UnderlayDefinition underlayDefinition = UnderlayDefinition.getDefinition(underlayId - 1);
                            Class40_Sub5_Sub17_Sub6.blendedHue[y] -= underlayDefinition.hue;
                            Class59.blendedSaturation[y] -= underlayDefinition.saturation;
                            SceneTile.blendedLightness[y] -= underlayDefinition.lightness;
                            MovedStatics.blendedHueMultiplier[y] -= underlayDefinition.hueMultiplier;
                            FloorDecoration.blendDirectionTracker[y]--;
                        }
                    }
                }
                if(x >= 1 && x < 103) {
                    int hue = 0;
                    int saturation = 0;
                    int lightness = 0;
                    int direction = 0;
                    int hueMultiplier = 0;
                    for(int y = -5; y < 109; y++) {
                        int positiveY = y + 5;
                        int negativeY = y - 5;
                        if(positiveY >= 0 && positiveY < 104) {
                            hueMultiplier += MovedStatics.blendedHueMultiplier[positiveY];
                            saturation += Class59.blendedSaturation[positiveY];
                            direction += FloorDecoration.blendDirectionTracker[positiveY];
                            lightness += SceneTile.blendedLightness[positiveY];
                            hue += Class40_Sub5_Sub17_Sub6.blendedHue[positiveY];
                        }

                        if(negativeY >= 0 && negativeY < 104) {
                            saturation -= Class59.blendedSaturation[negativeY];
                            direction -= FloorDecoration.blendDirectionTracker[negativeY];
                            lightness -= SceneTile.blendedLightness[negativeY];
                            hueMultiplier -= MovedStatics.blendedHueMultiplier[negativeY];
                            hue -= Class40_Sub5_Sub17_Sub6.blendedHue[negativeY];
                        }
                        if(y >= 1 && y < 103 && (!VertexNormal.lowMemory || (0x2 & OverlayDefinition.tile_flags[0][x][y]) != 0 || (0x10 & OverlayDefinition.tile_flags[_plane][x][y]) == 0 && MovedStatics.onBuildTimePlane == Class59.getVisibilityPlaneFor(_plane, y, 0, x))) {
                            if(MovedStatics.lowestPlane > _plane)
                                MovedStatics.lowestPlane = _plane;
                            int underlayId = MovedStatics.tile_underlayids[_plane][x][y] & 0xff;
                            int overlayId = MouseHandler.tile_overlayids[_plane][x][y] & 0xff;
                            if(underlayId > 0 || overlayId > 0) {
                                int vertexHeightSW = MovedStatics.tile_height[_plane][x][y];
                                int vertexHeightSE = MovedStatics.tile_height[_plane][x + 1][y];
                                int vertexHeightNE = MovedStatics.tile_height[_plane][x + 1][1 + y];
                                int vertexHeightNW = MovedStatics.tile_height[_plane][x][y + 1];
                                int lightIntensitySW = AnimationSequence.tileLightIntensity[x][y];
                                int lightIntensitySE = AnimationSequence.tileLightIntensity[x + 1][y];
                                int lightIntensityNE = AnimationSequence.tileLightIntensity[x + 1][y + 1];
                                int hslBitsetOriginal = -1;
                                int lightIntensityNW = AnimationSequence.tileLightIntensity[x][y + 1];
                                int hslBitsetRandomised = -1;
                                if(underlayId > 0) {
                                    int h = 256 * hue / hueMultiplier;
                                    int s = saturation / direction;
                                    int l = lightness / direction;
                                    hslBitsetOriginal = Class13.generateHslBitset(s, l, h);
                                    l += Actor.randomiserLightness;
                                    h = h + Class40_Sub5_Sub15.randomiserHue & 0xff;
                                    if(l >= 0) {
                                        if(l > 255)
                                            l = 255;
                                    } else
                                        l = 0;
                                    hslBitsetRandomised = Class13.generateHslBitset(s, l, h);
                                }
                                if(_plane > 0) {
                                    boolean hideUnderlay = true;
                                    if(underlayId == 0 && OverlayDefinition.tile_underlay_path[_plane][x][y] != 0)
                                        hideUnderlay = false;
                                    if(overlayId > 0 && !OverlayDefinition.getDefinition(-1 + overlayId, 4).hideOverlay)
                                        hideUnderlay = false;
                                    if(hideUnderlay && vertexHeightSW == vertexHeightSE && vertexHeightNE == vertexHeightSW && vertexHeightSW == vertexHeightNW)
                                        MovedStatics.tileCullingBitsets[_plane][x][y] = BitUtils.bitWiseOR(MovedStatics.tileCullingBitsets[_plane][x][y], 0x924);
                                }
                                int underlayMinimapColour = 0;
                                if(hslBitsetRandomised != -1)
                                    underlayMinimapColour = Rasterizer3D.hsl2rgb[Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetRandomised, 96, (byte) 73)];
                                if(overlayId != 0) {
                                    int shape = 1 + OverlayDefinition.tile_underlay_path[_plane][x][y];
                                    byte rotation = Class35.tile_overlay_rotation[_plane][x][y];
                                    OverlayDefinition overlayDefinition = OverlayDefinition.getDefinition(-1 + overlayId, 4);
                                    int textureId = overlayDefinition.texture;
                                    int hslBitset;
                                    int overlayMinimapColour;
                                    if(textureId >= 0) {
                                        hslBitset = -1;
                                        overlayMinimapColour = Rasterizer3D.interface3.getAverageTextureColour(true, textureId);
                                    } else if(overlayDefinition.color == 16711935) {
                                        hslBitset = -2;
                                        textureId = -1;
                                        overlayMinimapColour = -2;
                                    } else {
                                        hslBitset = Class13.generateHslBitset(overlayDefinition.lightness, overlayDefinition.saturation, overlayDefinition.hue);
                                        int h = Class40_Sub5_Sub15.randomiserHue + overlayDefinition.hue & 0xff;
                                        int s = Actor.randomiserLightness + overlayDefinition.saturation;
                                        if(s < 0)
                                            s = 0;
                                        else if(s > 255)
                                            s = 255;
                                        overlayMinimapColour = Class13.generateHslBitset(overlayDefinition.lightness, s, h);
                                    }
                                    int rgb = 0;
                                    if(overlayMinimapColour != -2)
                                        rgb = Rasterizer3D.hsl2rgb[MovedStatics.mixLightnessSigned(overlayMinimapColour, 96, true)];
                                    if(overlayDefinition.secondaryColor != -1) {
                                        int i_54_ = 0xff & Class40_Sub5_Sub15.randomiserHue + overlayDefinition.otherHue;
                                        int i_55_ = overlayDefinition.otherSaturation + Actor.randomiserLightness;
                                        if(i_55_ >= 0) {
                                            if(i_55_ > 255)
                                                i_55_ = 255;
                                        } else
                                            i_55_ = 0;
                                        overlayMinimapColour = Class13.generateHslBitset(overlayDefinition.otherLightness, i_55_, i_54_);
                                        rgb = Rasterizer3D.hsl2rgb[MovedStatics.mixLightnessSigned(overlayMinimapColour, 96, true)];
                                    }
                                    scene.addTile(_plane, x, y, shape, rotation, textureId, vertexHeightSW, vertexHeightSE, vertexHeightNE, vertexHeightNW, Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensitySW, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensitySE, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensityNE, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensityNW, (byte) 73), MovedStatics.mixLightnessSigned(hslBitset, lightIntensitySW, true), MovedStatics.mixLightnessSigned(hslBitset, lightIntensitySE, true), MovedStatics.mixLightnessSigned(hslBitset, lightIntensityNE, true), MovedStatics.mixLightnessSigned(hslBitset, lightIntensityNW, true), underlayMinimapColour, rgb);
                                } else
                                    scene.addTile(_plane, x, y, 0, 0, -1, vertexHeightSW, vertexHeightSE, vertexHeightNE, vertexHeightNW, Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensitySW, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensitySE, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensityNE, (byte) 73), Class40_Sub5_Sub17_Sub6.mixLightness(hslBitsetOriginal, lightIntensityNW, (byte) 73), 0, 0, 0, 0, underlayMinimapColour, 0);
                            }
                        }
                    }
                }
            }
            for(int i_56_ = 1; i_56_ < 103; i_56_++) {
                for(int i_57_ = 1; i_57_ < 103; i_57_++)
                    scene.method130(_plane, i_57_, i_56_, Class59.getVisibilityPlaneFor(_plane, i_56_, 0, i_57_));
            }
            MovedStatics.tile_underlayids[_plane] = null;
            MouseHandler.tile_overlayids[_plane] = null;
            OverlayDefinition.tile_underlay_path[_plane] = null;
            Class35.tile_overlay_rotation[_plane] = null;
            InteractiveObject.tileShadowIntensity[_plane] = null;
        }
        scene.method118(-50, -10, -50);
        for(int i = 0; i < 104; i++) {
            for(int i_58_ = 0; i_58_ < 104; i_58_++) {
                if((OverlayDefinition.tile_flags[1][i][i_58_] & 0x2) == 2)
                    scene.method92(i, i_58_);
            }
        }
        int renderRule1 = 1;
        int i_59_ = 2;
        int i_60_ = 4;
        for(int plane = 0; plane < 4; plane++) {
            if(plane > 0) {
                renderRule1 <<= 3;
                i_60_ <<= 3;
                i_59_ <<= 3;
            }
            for(int _plane = 0; _plane <= plane; _plane++) {
                for(int y = 0; y <= 104; y++) {
                    for(int x = 0; x <= 104; x++) {
                        if((MovedStatics.tileCullingBitsets[_plane][x][y] & renderRule1) != 0) {
                            int i_65_;
                            for(i_65_ = y; i_65_ > 0 && (renderRule1 & MovedStatics.tileCullingBitsets[_plane][x][-1 + i_65_]) != 0; i_65_--) {
                                /* empty */
                            }
                            int i_66_;
                            for(i_66_ = y; i_66_ < 104 && (MovedStatics.tileCullingBitsets[_plane][x][i_66_ + 1] & renderRule1) != 0; i_66_++) {
                                /* empty */
                            }
                            int i_67_ = _plane;
                            int i_68_ = _plane;
                            while_4_:
                            for(/**/; i_67_ > 0; i_67_--) {
                                for(int i_69_ = i_65_; i_69_ <= i_66_; i_69_++) {
                                    if((MovedStatics.tileCullingBitsets[-1 + i_67_][x][i_69_] & renderRule1) == 0)
                                        break while_4_;
                                }
                            }
                            while_5_:
                            for(/**/; i_68_ < plane; i_68_++) {
                                for(int i_70_ = i_65_; i_70_ <= i_66_; i_70_++) {
                                    if((renderRule1 & MovedStatics.tileCullingBitsets[i_68_ + 1][x][i_70_]) == 0)
                                        break while_5_;
                                }
                            }
                            int i_71_ = (-i_65_ + i_66_ + 1) * (-i_67_ + i_68_ + 1);
                            if(i_71_ >= 8) {
                                int i_72_ = 240;
                                int i_73_ = -i_72_ + MovedStatics.tile_height[i_68_][x][i_65_];
                                int i_74_ = MovedStatics.tile_height[i_67_][x][i_65_];
                                Scene.method116(plane, 1, 128 * x, 128 * x, 128 * i_65_, 128 + 128 * i_66_, i_73_, i_74_);
                                for(int i_75_ = i_67_; i_75_ <= i_68_; i_75_++) {
                                    for(int i_76_ = i_65_; i_76_ <= i_66_; i_76_++)
                                        MovedStatics.tileCullingBitsets[i_75_][x][i_76_] = BitUtils.bitWiseAND(MovedStatics.tileCullingBitsets[i_75_][x][i_76_], renderRule1 ^ 0xffffffff);
                                }
                            }
                        }
                        if((i_59_ & MovedStatics.tileCullingBitsets[_plane][x][y]) != 0) {
                            int lowestOcclusionX;
                            for(lowestOcclusionX = x; lowestOcclusionX > 0 && (i_59_ & MovedStatics.tileCullingBitsets[_plane][lowestOcclusionX - 1][y]) != 0; lowestOcclusionX--) {
                                /* empty */
                            }
                            int highestOcclusionPlane = _plane;
                            int highestOcclusionX = x;
                            int lowestOcclusionPlane = _plane;
                            for(/**/; highestOcclusionX < 104; highestOcclusionX++) {
                                if((i_59_ & MovedStatics.tileCullingBitsets[_plane][1 + highestOcclusionX][y]) == 0)
                                    break;
                            }
                            while_6_:
                            for(/**/; lowestOcclusionPlane > 0; lowestOcclusionPlane--) {
                                for(int i_81_ = lowestOcclusionX; i_81_ <= highestOcclusionX; i_81_++) {
                                    if((MovedStatics.tileCullingBitsets[lowestOcclusionPlane + -1][i_81_][y] & i_59_) == 0)
                                        break while_6_;
                                }
                            }
                            while_7_:
                            for(/**/; highestOcclusionPlane < plane; highestOcclusionPlane++) {
                                for(int i_82_ = lowestOcclusionX; i_82_ <= highestOcclusionX; i_82_++) {
                                    if((i_59_ & MovedStatics.tileCullingBitsets[1 + highestOcclusionPlane][i_82_][y]) == 0)
                                        break while_7_;
                                }
                            }

                            int occlusionSurface = (highestOcclusionX - lowestOcclusionX + 1) * (-lowestOcclusionPlane + 1 + highestOcclusionPlane);
                            if(occlusionSurface >= 8) {
                                int lowestOcclusionVertexHeight = MovedStatics.tile_height[lowestOcclusionPlane][lowestOcclusionX][y];
                                int highestOcclusionVertexHeightOffset = 240;
                                int highestOcclusionVertexHeight = MovedStatics.tile_height[highestOcclusionPlane][lowestOcclusionX][y] - highestOcclusionVertexHeightOffset;
                                Scene.method116(plane, 2, 128 * lowestOcclusionX, 128 * highestOcclusionX + 128, 128 * y, y * 128, highestOcclusionVertexHeight, lowestOcclusionVertexHeight);
                                for(int occludedPlane = lowestOcclusionPlane; highestOcclusionPlane >= occludedPlane; occludedPlane++) {
                                    for(int occludedX = lowestOcclusionX; occludedX <= highestOcclusionX; occludedX++)
                                        MovedStatics.tileCullingBitsets[occludedPlane][occludedX][y] = BitUtils.bitWiseAND(MovedStatics.tileCullingBitsets[occludedPlane][occludedX][y], i_59_ ^ 0xffffffff);
                                }
                            }
                        }
                        if((MovedStatics.tileCullingBitsets[_plane][x][y] & i_60_) != 0) {
                            int i_89_ = x;
                            int i_90_ = x;
                            int i_91_ = y;
                            int i_92_ = y;
                            for(/**/; i_91_ > 0; i_91_--) {
                                if((MovedStatics.tileCullingBitsets[_plane][x][-1 + i_91_] & i_60_) == 0)
                                    break;
                            }
                            for(/**/; i_92_ < 104; i_92_++) {
                                if((i_60_ & MovedStatics.tileCullingBitsets[_plane][x][i_92_ + 1]) == 0)
                                    break;
                            }
                            while_8_:
                            for(/**/; i_89_ > 0; i_89_--) {
                                for(int i_93_ = i_91_; i_93_ <= i_92_; i_93_++) {
                                    if((i_60_ & MovedStatics.tileCullingBitsets[_plane][i_89_ + -1][i_93_]) == 0)
                                        break while_8_;
                                }
                            }
                            while_9_:
                            for(/**/; i_90_ < 104; i_90_++) {
                                for(int i_94_ = i_91_; i_92_ >= i_94_; i_94_++) {
                                    if((i_60_ & MovedStatics.tileCullingBitsets[_plane][1 + i_90_][i_94_]) == 0)
                                        break while_9_;
                                }
                            }
                            if((-i_89_ + i_90_ + 1) * (1 + i_92_ - i_91_) >= 4) {
                                int i_95_ = MovedStatics.tile_height[_plane][i_89_][i_91_];
                                Scene.method116(plane, 4, i_89_ * 128, i_90_ * 128 + 128, 128 * i_91_, i_92_ * 128 + 128, i_95_, i_95_);
                                for(int i_96_ = i_89_; i_96_ <= i_90_; i_96_++) {
                                    for(int i_97_ = i_91_; i_92_ >= i_97_; i_97_++)
                                        MovedStatics.tileCullingBitsets[_plane][i_96_][i_97_] = BitUtils.bitWiseAND(MovedStatics.tileCullingBitsets[_plane][i_96_][i_97_], i_60_ ^ 0xffffffff);
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public static void method285(byte arg0) {
        if(arg0 != 118)
            aBoolean519 = true;
        for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.peekFirst(); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.pollFirst()) {
            if(class40_sub3.anInt2031 == -1) {
                class40_sub3.anInt2033 = 0;
                Class39.method451(class40_sub3, 19813);
            } else
                class40_sub3.unlink();
        }
    }

    public static int method288(byte arg0) {
        if(arg0 < 117)
            method288((byte) 125);
        return 5;
    }

    public void isaac() {
        result += ++counter;
        for(int i = 0; i < 256; i++) {
            int x = mem[i];
            if((i & 0x2) == 0) {
                if((0x1 & i) == 0)
                    accumulator ^= accumulator << 13;
                else
                    accumulator ^= accumulator >>> 6;
            } else if((i & 0x1) != 0)
                accumulator ^= accumulator >>> 16;
            else
                accumulator ^= accumulator << 2;
            accumulator += mem[0xff & 128 + i];
            int y;
            mem[i] = y = mem[BitUtils.bitWiseAND(x, 1020) >> 2] + accumulator + result;
            rsl[i] = result = x + mem[BitUtils.bitWiseAND(y >> -488567000 >> -1522276318, 255)];
        }
    }

    /**
     * Gets the next random value.
     *
     * @return The next random value.
     */
    public int nextInt() {
        if(count-- == 0) {
            isaac();
            count = 255;
        }
        return rsl[count];
    }

    public void init(boolean arg0) {
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;

        int a = b = c = d = e = f = g = h = GOLDEN_RATIO;
        for(int i = 0; i < 4; i++) {
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            g ^= h << 8;
            b += g;
            a += f;
            h += a;
            h ^= a >>> 9;
            c += h;
            a += b;
        }
        for(int i = 0; i < 256; i += 8) {
            /*
             * fill in mem[] with messy
             * stuff
             */
            h += rsl[7 + i];
            d += rsl[3 + i];
            a += rsl[i];
            b += rsl[i + 1];
            e += rsl[4 + i];
            g += rsl[i + 6];
            f += rsl[5 + i];
            c += rsl[2 + i];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            e += b;
            c += d;
            c ^= d << 8;
            d += e;
            f += c;
            d ^= e >>> 16;
            e += f;
            g += d;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            g += h;
            a += f;
            g ^= h << 8;
            h += a;
            b += g;
            h ^= a >>> 9;
            a += b;
            c += h;
            mem[i] = a;
            mem[i + 1] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        if(!arg0)
            aClass9_516 = null;
        /* second pass makes all of seed affect all of mem */
        for(int i = 0; i < 256; i += 8) {
            h += mem[7 + i];
            g += mem[i + 6];
            c += mem[2 + i];
            d += mem[3 + i];
            f += mem[i + 5];
            a += mem[i];
            e += mem[4 + i];
            b += mem[i + 1];
            a ^= b << 11;
            d += a;
            b += c;
            b ^= c >>> 2;
            c += d;
            c ^= d << 8;
            f += c;
            e += b;
            d += e;
            d ^= e >>> 16;
            g += d;
            e += f;
            e ^= f << 10;
            h += e;
            f += g;
            f ^= g >>> 4;
            a += f;
            g += h;
            g ^= h << 8;
            h += a;
            h ^= a >>> 9;
            b += g;
            a += b;
            c += h;
            mem[i] = a;
            mem[1 + i] = b;
            mem[i + 2] = c;
            mem[3 + i] = d;
            mem[i + 4] = e;
            mem[i + 5] = f;
            mem[i + 6] = g;
            mem[7 + i] = h;
        }
        isaac();
        count = 256;
    }
}
