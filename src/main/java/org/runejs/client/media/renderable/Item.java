package org.runejs.client.media.renderable;

import org.runejs.client.cache.def.*;
import org.runejs.client.frame.console.Console;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.Scene;
import org.runejs.client.scene.SceneCamera;
import org.runejs.client.*;

public class Item extends Renderable {
    public static boolean[] obfuscatedKeyStatus = new boolean[112];
    public static int anInt3065 = -1;

    public int itemCount;
    public int itemId;

    public static void calculateCameraPosition() {
        int originX = Game.playerCamera.getOriginX();
        int originY = Game.playerCamera.getOriginY();

        int localPlayer3dPosX = Player.localPlayer.worldX;
        int localPlayer3dPosY = Player.localPlayer.worldY;

        // if the local player's position in 3d space is too far from the camera's origin, snap it
        if (originX - localPlayer3dPosX < -500 || -localPlayer3dPosX + originX > 500 || originY + -localPlayer3dPosY < -500 || -localPlayer3dPosY + originY > 500) {
            originY = localPlayer3dPosY;
            originX = localPlayer3dPosX;
        }

        // otherwise, slowly move the camera origin towards local player pos
        if (originX != localPlayer3dPosX)
            originX += (-originX + localPlayer3dPosX) / 16;
        if (originY != localPlayer3dPosY)
            originY += (-originY + localPlayer3dPosY) / 16;

        // update the camera's Z origin - this wasn't originally here, but it makes sense to do it with the other origins
        int cameraOriginZ = Scene.getFloorDrawHeight(Player.worldLevel, Player.localPlayer.worldX, Player.localPlayer.worldY) - 50;

        Game.playerCamera.setOrigin(originX, originY, cameraOriginZ);

        // increase rotational velocity if key pressed, otherwise fall off
        if (obfuscatedKeyStatus[96] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityYaw += (-24 - SceneCamera.cameraVelocityYaw) / 2;
        else if (obfuscatedKeyStatus[97] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityYaw += (24 - SceneCamera.cameraVelocityYaw) / 2;
        else
            SceneCamera.cameraVelocityYaw /= 2;
        if (obfuscatedKeyStatus[98] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityPitch += (12 + -SceneCamera.cameraVelocityPitch) / 2;
        else if (obfuscatedKeyStatus[99] && !Console.console.consoleOpen)
            SceneCamera.cameraVelocityPitch += (-12 - SceneCamera.cameraVelocityPitch) / 2;
        else
            SceneCamera.cameraVelocityPitch /= 2;

        int zoomVelocity = SceneCamera.cameraVelocityZoom;
        SceneCamera.cameraVelocityZoom /= 1.5;

        // apply velocities to camera's target position
        int yaw = 0x7ff & (SceneCamera.cameraVelocityYaw / 2 + Game.playerCamera.getYaw() & 0x7ff);
        int pitch = Game.playerCamera.getPitch() + SceneCamera.cameraVelocityPitch / 2;
        int zoom = Game.playerCamera.getZoom() + zoomVelocity;

        Game.playerCamera.rotate(yaw, pitch);
        Game.playerCamera.setZoom(zoom);

        // figure out minimum allowed pitch based on surrounding heights
        int i_3_ = 0;
        int i_1_ = originY >> 7;
        int i_2_ = originX >> 7;
        int i_4_ = Scene.getFloorDrawHeight(Player.worldLevel, originX, originY);
        if (i_2_ > 3 && i_1_ > 3 && i_2_ < 100 && i_1_ < 100) {
            for (int i_5_ = -4 + i_2_; i_5_ <= 4 + i_2_; i_5_++) {
                for (int i_6_ = -4 + i_1_; 4 + i_1_ >= i_6_; i_6_++) {
                    int i_7_ = Player.worldLevel;
                    if (i_7_ < 3 && (0x2 & MovedStatics.tile_flags[1][i_5_][i_6_]) == 2)
                        i_7_++;
                    int i_8_ = i_4_ + -MovedStatics.tile_height[i_7_][i_5_][i_6_];
                    if (i_8_ > i_3_)
                        i_3_ = i_8_;
                }
            }
        }

        SceneCamera.setMaxSurroundingTerrainHeight(i_3_);
    }

    public static void method778(HuffmanEncoding arg1) {
        MovedStatics.aHuffmanEncoding_2590 = arg1;
    }


    public Model getRotatedModel() {
        return ItemDefinition.forId(itemId, 10).asGroundStack(true, itemCount);
    }
}
