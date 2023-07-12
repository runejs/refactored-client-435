package org.runejs.client.message.handler.rs435.misc;

import org.runejs.client.cache.media.gameInterface.GameInterface;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.message.handler.MessageHandler;
import org.runejs.client.message.inbound.misc.UpdateSkillMessage;

/**
 * A {@link MessageHandler} that handles {@link UpdateSkillMessage}s.
 */
public class UpdateSkillMessageHandler implements MessageHandler<UpdateSkillMessage> {
    @Override
    public void handle(UpdateSkillMessage message) {
        GameInterface.redrawTabArea = true;

        int skillId = message.skillId;
        int skillLevel = message.skillLevel;
        int skillExperience = message.skillExperience;;

        Player.playerExperience[skillId] = skillExperience;
        Player.playerLevels[skillId] = skillLevel;
        Player.nextLevels[skillId] = 1;
        for(int levelIndex = 0; levelIndex < 98; levelIndex++) {
            if(Player.experienceForLevels[levelIndex] <= skillExperience)
                Player.nextLevels[skillId] = levelIndex + 2;
        }
    }
}
