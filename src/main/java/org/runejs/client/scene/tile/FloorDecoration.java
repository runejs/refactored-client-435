package org.runejs.client.scene.tile;

import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.cache.media.IndexedImage;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.io.Buffer;
import org.runejs.client.media.renderable.GameObject;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.PlayerAppearance;
import org.runejs.client.net.ISAAC;
import org.runejs.client.scene.InteractiveObject;
import org.runejs.client.util.SignlinkNode;
import org.runejs.client.*;

public class FloorDecoration {
    public static IndexedImage inventoryBackgroundImage;
    public static ImageRGB[] aClass40_Sub5_Sub14_Sub4Array603;
    public static SignlinkNode gameServerSignlinkNode;
    public static int anInt614 = -1;

    public int config;
    public int hash;
    public int x;
    public Renderable renderable;
    public int y;
    public int z;

    public static void method344(int arg0) {
        if(MovedStatics.aBoolean2083) {
            MovedStatics.chatboxLineOffsets = null;
            MovedStatics.aBoolean2083 = false;
            RSCanvas.anIntArray66 = null;
            MovedStatics.minimapBackgroundImage = null;
            Landscape.anIntArray1186 = null;
            Class17.chatboxTop = null;
            RSCanvas.tabBottom = null;
            GameObject.tabPieceLeft = null;
            Class57.bottomChatBack = null;
            inventoryBackgroundImage = null;
            WallDecoration.tabHighlightImageTopRight = null;
            Class40_Sub5_Sub15.tabIcons = null;
            Class13.tabHighlightImageBottomRight = null;
            RSString.mapbackProducingGraphicsBuffer = null;
            RSCanvas.anIntArray62 = null;
            ActorDefinition.sidebarOffsets = null;
            Class39.mapbackLeft = null;
            MovedStatics.tabHighlightImageBottomMiddle = null;
            MovedStatics.tabBottomBack = null;
            Landscape.framePieceRight = null;
            GameInterface.tabHighlightImageTopLeft = null;
            MovedStatics.tabHighlightImageTopRightEdge = null;
            MovedStatics.anIntArray852 = null;
            HuffmanEncoding.chatModes = null;
            Buffer.tabTopBack = null;
            MovedStatics.tabImageProducer = null;
            MovedStatics.tabHighlightImageTopLeftEdge = null;
            MovedStatics.gameScreenImageProducer = null;
            ISAAC.tabHighlightImageBottomRightEdge = null;
            RSCanvas.chatBoxImageProducer = null;
            Class40_Sub7.mapBackRight = null;
            InteractiveObject.tabTop = null;
            if(arg0 < -28) {
                MovedStatics.chatboxRight = null;
                MovedStatics.tabPieceUpperRight = null;
                Class35.tabHighlightImageTopMiddle = null;
                MovedStatics.tabHighlightImageBottomLeft = null;
                Renderable.tabHighlightImageBottomLeftEdge = null;
                Class24.fullScreenTextureArray = null;
                PlayerAppearance.tabPieveLowerRight = null;
                SpotAnim.framePieceTop = null;
                Class44.chatboxBackgroundImage = null;
            }
        }
    }


}
