package org.runejs.client.message.inbound.misc;

import org.runejs.client.message.InboundMessage;

/**
 * A message sent to update the client's level and experience in a skill.
 */
public class UpdateSkillMessage implements InboundMessage {
    /**
     * The skill to update.
     */
    public final int skillId;

    /**
     * The new level of the skill.
     */
    public final int skillLevel;

    /**
     * The new experience of the skill.
     */
    public final int skillExperience;

    /**
     * Constructs a new {@link UpdateSkillMessage}.
     *
     * @param skillId The skill to update.
     * @param skillLevel The new level of the skill.
     * @param skillExperience The new experience of the skill.
     */
    public UpdateSkillMessage(int skillId, int skillLevel, int skillExperience) {
        this.skillId = skillId;
        this.skillLevel = skillLevel;
        this.skillExperience = skillExperience;
    }
}
