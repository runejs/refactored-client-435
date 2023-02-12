package org.runejs.client.scene.tile;

import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.cache.media.TypeFace;
import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.Renderable;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.scene.util.CollisionMap;
import org.runejs.client.Class40_Sub5_Sub15;

public class Wall {
    public static int cameraVelocityHorizontal = 0;
    public static int[] walkingQueueY = new int[4000];
    public static GameInterface aGameInterface_353 = null;
    public static int anInt356 = 0;
    public static LinkedList[][][] groundItems = new LinkedList[4][104][104];

    public int hash;
    public int x;
    public int y;
    public int z;
    public int orientationA;
    public int orientationB;
    public Renderable secondary;
    public Renderable primary;
    public int config = 0;

    public Wall() {
        hash = 0;
    }



    public static void renderSplitPrivateMessages() {
        if(CollisionMap.anInt165 != 0) {
            TypeFace class40_sub5_sub14_sub1 = WallDecoration.fontNormal;
            int i = 0;
            if(Class40_Sub5_Sub15.systemUpdateTime != 0)
                i = 1;
            for(int i_0_ = 0; i_0_ < 100; i_0_++) {
                if(ChatBox.chatMessages[i_0_] != null) {
                    String class1 = ChatBox.chatPlayerNames[i_0_];
                    int i_1_ = 0;
                    int i_2_ = ChatBox.chatTypes[i_0_];
                    if(class1 != null && class1.startsWith(Native.whiteCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 1;
                    }
                    if(class1 != null && class1.startsWith(Native.goldCrown)) {
                        class1 = class1.substring(5);
                        i_1_ = 2;
                    }
                    if((i_2_ == 3 || i_2_ == 7) && (i_2_ == 7 || ChatBox.privateChatMode == 0 || ChatBox.privateChatMode == 1 && Player.hasFriend(class1))) {
                        int i_3_ = 329 - 13 * i;
                        int i_4_ = 4;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(English.from, i_4_, -1 + i_3_, 65535);
                        i_4_ += class40_sub5_sub14_sub1.getStringWidth(English.from);
                        i_4_ += class40_sub5_sub14_sub1.method689(32);
                        if(i_1_ == 1) {
                            MovedStatics.moderatorIcon[0].drawImage(i_4_, i_3_ - 12);
                            i_4_ += 14;
                        }
                        if(i_1_ == 2) {
                            MovedStatics.moderatorIcon[1].drawImage(i_4_, -12 + i_3_);
                            i_4_ += 14;
                        }
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, i_3_, 0);
                        class40_sub5_sub14_sub1.drawString(class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], i_4_, -1 + i_3_, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 5 && ChatBox.privateChatMode < 2) {
                        int i_5_ = -(i * 13) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_, 0);
                        class40_sub5_sub14_sub1.drawString(ChatBox.chatMessages[i_0_], 4, i_5_ - 1, 65535);
                        if(i >= 5)
                            return;
                    }
                    if(i_2_ == 6 && ChatBox.privateChatMode < 2) {
                        int i_6_ = -(13 * i) + 329;
                        i++;
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_, 0);
                        class40_sub5_sub14_sub1.drawString(English.to + Native.whitespace_b + class1 + Native.COLON_CHARACTER + ChatBox.chatMessages[i_0_], 4, i_6_ + -1, 65535);
                        if(i >= 5)
                            return;
                    }
                }
            }
        }
    }
}
