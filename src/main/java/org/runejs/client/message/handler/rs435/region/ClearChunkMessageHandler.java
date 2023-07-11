package org.runejs.client.message.handler.rs435.region;

import org.runejs.client.Class40_Sub3;
import org.runejs.client.LinkedList;
import org.runejs.client.MovedStatics;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.region.ClearChunkInboundMessage;

/**
 * Clears a chunk of the map.
 */
public class ClearChunkMessageHandler implements MessageHandler<ClearChunkInboundMessage> {
    @Override
    public void handle(ClearChunkInboundMessage message) {
        MovedStatics.placementX = message.x;
        MovedStatics.placementY = message.y;
        for(int i_51_ = MovedStatics.placementX; i_51_ < 8 + MovedStatics.placementX; i_51_++) {
            for(int i_52_ = MovedStatics.placementY; 8 + MovedStatics.placementY > i_52_; i_52_++) {
                if(MovedStatics.groundItems[Player.worldLevel][i_51_][i_52_] != null) {
                    MovedStatics.groundItems[Player.worldLevel][i_51_][i_52_] = null;
                    MovedStatics.spawnGroundItem(i_52_, i_51_);
                }
            }
        }
        for(Class40_Sub3 class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.peekFirst(); class40_sub3 != null; class40_sub3 = (Class40_Sub3) LinkedList.aLinkedList_1064.pollFirst()) {
            if(class40_sub3.anInt2039 >= MovedStatics.placementX && MovedStatics.placementX + 8 > class40_sub3.anInt2039 && class40_sub3.anInt2038 >= MovedStatics.placementY && MovedStatics.placementY + 8 > class40_sub3.anInt2038 && Player.worldLevel == class40_sub3.anInt2018)
                class40_sub3.anInt2031 = 0;
        }
    }
}
