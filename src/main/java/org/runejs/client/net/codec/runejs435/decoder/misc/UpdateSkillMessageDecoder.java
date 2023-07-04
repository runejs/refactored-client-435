package org.runejs.client.net.codec.runejs435.decoder.misc;

import org.runejs.client.message.inbound.misc.UpdateSkillMessage;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.net.codec.MessageDecoder;

/**
 * A {@link MessageDecoder} that decodes {@link UpdateSkillMessage}s.
 */
public class UpdateSkillMessageDecoder implements MessageDecoder<UpdateSkillMessage> {
    @Override
    public UpdateSkillMessage decode(PacketBuffer buffer) {
        int skillLevel = buffer.getUnsignedByte();
        int skillId = buffer.getUnsignedByte();
        int skillExperience = buffer.getIntLE();

        return new UpdateSkillMessage(skillId, skillLevel, skillExperience);
    }
}
