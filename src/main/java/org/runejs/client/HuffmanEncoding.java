package org.runejs.client;

import org.runejs.client.cache.CacheArchive;
import org.runejs.client.cache.media.ImageRGB;
import org.runejs.client.frame.ChatBox;
import org.runejs.client.language.English;
import org.runejs.client.language.Native;
import org.runejs.client.media.renderable.actor.Player;
import org.runejs.client.net.PacketBuffer;
import org.runejs.client.scene.tile.SceneTile;
import org.runejs.client.util.BitUtils;
import org.runejs.client.cache.def.ActorDefinition;
import org.runejs.client.cache.def.ItemDefinition;
import org.runejs.Configuration;

import java.text.MessageFormat;

public class HuffmanEncoding {
    public static ProducingGraphicsBuffer chatModes;
    public static int anInt1545 = 0;
    public static int reportAbuseInterfaceID = -1;
    public static int anInt1559 = 7759444;
    public static int[] anIntArray1564 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 0, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    public int[] chatDecryptKeys;
    public int[] chatMask;
    public byte[] chatBitSizes;

    public HuffmanEncoding(byte[] arg0) {

        int i = arg0.length;
        chatBitSizes = arg0;
        chatMask = new int[i];
        int[] is = new int[33];
        chatDecryptKeys = new int[8];
        int i_29_ = 0;
        for (int i_30_ = 0; i_30_ < i; i_30_++) {
            int i_31_ = arg0[i_30_];
            if (i_31_ != 0) {
                int i_32_ = 1 << -i_31_ + 32;
                int i_33_ = is[i_31_];
                chatMask[i_30_] = i_33_;
                int i_34_;
                if ((i_32_ & i_33_) == 0) {
                    for (int i_35_ = -1 + i_31_; i_35_ >= 1; i_35_--) {
                        int i_36_ = is[i_35_];
                        if (i_36_ != i_33_) {
                            break;
                        }
                        int i_37_ = 1 << -i_35_ + 32;
                        if ((i_36_ & i_37_) == 0) {
                            is[i_35_] = BitUtils.bitWiseOR(i_36_, i_37_);
                        } else {
                            is[i_35_] = is[-1 + i_35_];
                            break;
                        }
                    }
                    i_34_ = i_33_ | i_32_;
                } else {
                    i_34_ = is[-1 + i_31_];
                }
                is[i_31_] = i_34_;
                for (int i_38_ = i_31_ + 1; i_38_ <= 32; i_38_++) {
                    if (i_33_ == is[i_38_]) {
                        is[i_38_] = i_34_;
                    }
                }
                int i_39_ = 0;
                for (int i_40_ = 0; i_40_ < i_31_; i_40_++) {
                    int i_41_ = -2147483648 >>> i_40_;
                    if ((i_41_ & i_33_) != 0) {
                        if (chatDecryptKeys[i_39_] == 0) {
                            chatDecryptKeys[i_39_] = i_29_;
                        }
                        i_39_ = chatDecryptKeys[i_39_];
                    } else {
                        i_39_++;
                    }
                    if (chatDecryptKeys.length <= i_39_) {
                        int[] is_42_ = new int[chatDecryptKeys.length * 2];
                        for (int i_43_ = 0; chatDecryptKeys.length > i_43_; i_43_++) {
                            is_42_[i_43_] = chatDecryptKeys[i_43_];
                        }
                        chatDecryptKeys = is_42_;
                    }
                    i_41_ >>>= 1;
                }
                if (i_39_ >= i_29_) {
                    i_29_ = i_39_ + 1;
                }
                chatDecryptKeys[i_39_] = i_30_ ^ 0xffffffff;
            }
        }

    }


    public static RSString method1024(boolean arg0, byte arg1, int arg2) {
        if (arg1 > -30) {
            English.connectingToFriendserver = null;
        }
        return PacketBuffer.method521(arg0, 10, arg2);
    }

    public static void processNpcMenuOptions(ActorDefinition actorDefinition, int x, int y, int index) {
        if (ActorDefinition.menuActionRow < 400) {
            if (actorDefinition.childIds != null) {
                actorDefinition = actorDefinition.getChildDefinition();
            }
            if (actorDefinition != null && actorDefinition.isClickable) {
                String npcDisplayName = actorDefinition.name;
                if (actorDefinition.combatLevel != 0) {
                    npcDisplayName = npcDisplayName + SceneTile.getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel) + Native.leftParenthesisWithSpacePrefix + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                }
                if (MovedStatics.itemSelected == 1) {
                    MovedStatics.addActionRow(English.use, index, x, y, ActionRowType.ITEM_ON_NPC.getId(), Native.selectedItemName + Native.toYellow + npcDisplayName);
                } else if (Main.widgetSelected == 1) {
                    if ((0x2 & ItemDefinition.selectedMask) == 2) {
                        MovedStatics.addActionRow(Native.selectedSpellVerb, index, x, y, ActionRowType.MAGIC_ON_NPC.getId(), Native.selectedSpellName + Native.toYellow + npcDisplayName);
                    }
                } else {
                    String[] options = actorDefinition.options;
                    if (Class60.DEBUG_DISPLAY_ALL_ACTION_ROWS) {
                        options = MovedStatics.getAllOptionsWithIndices(options);
                    }

                    // add non-attack options to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && !options[i].equalsIgnoreCase(English.attack)) {
                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_1.getId();
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_2.getId();
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_3.getId();
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_4.getId();
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_5.getId();
                                }
                                MovedStatics.addActionRow(options[i], index, x, y, actionType, Native.yellow + npcDisplayName);
                            }
                        }
                    }

                    // add 'Attack' option to NPC
                    if (options != null) {
                        for (int i = 4; i >= 0; i--) {
                            if (options[i] != null && options[i].equalsIgnoreCase(English.attack)) {
                                int actionTypeOffset = 0;

                                // deprioritise the action in the list if the NPC is higher level than the player
                                if (Player.localPlayer.combatLevel < actorDefinition.combatLevel) {
                                    actionTypeOffset = 2000;
                                }

                                int actionType = 0;
                                if (i == 0) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_1.getId() + actionTypeOffset;
                                }
                                if (i == 1) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_2.getId() + actionTypeOffset;
                                }
                                if (i == 2) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_3.getId() + actionTypeOffset;
                                }
                                if (i == 3) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_4.getId() + actionTypeOffset;
                                }
                                if (i == 4) {
                                    actionType = ActionRowType.NPC_INTERACTION_OPTION_5.getId() + actionTypeOffset;
                                }
                                MovedStatics.addActionRow(options[i], index, x, y, actionType, Native.yellow +npcDisplayName);
                            }
                        }
                    }
                    StringBuilder examineText = new StringBuilder();
                    examineText.append(MessageFormat.format("<col=ffff00>{0}</col>", actorDefinition.name));

                    if(actorDefinition.combatLevel != 0) {
                        String combatLevel = " " +
                            SceneTile.getCombatLevelColour(Player.localPlayer.combatLevel, actorDefinition.combatLevel)
                                + Native.leftParenthesis + English.prefixLevel + actorDefinition.combatLevel + Native.rightParenthesis;
                        examineText.append(combatLevel);
                    }


                    if (Configuration.DEBUG_CONTEXT) {
                        examineText.append(" <col=00ff00>(</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}</col>",
                                        Integer.toString(actorDefinition.id)
                                )
                        );
                        examineText.append("<col=00ff00>) (</col>");
                        examineText.append(
                                MessageFormat.format("<col=ffffff>{0}, {1}</col>",
                                        Integer.toString(x + MovedStatics.baseX),
                                        Integer.toString(y + Class26.baseY)
                                )
                        );
                        examineText.append("<col=00ff00>)</col>");


                    }
                    MovedStatics.addActionRow(English.examine, index, x, y, ActionRowType.EXAMINE_NPC.getId(), examineText.toString());
                }
            }
        }
    }

    public static boolean method1027(int arg0) {
        return arg0 >= 48 && arg0 <= 57;
    }

    public static ImageRGB method1028(CacheArchive arg0, String arg1, byte arg2, String arg3) {
        int i = arg0.getHash(arg1);
        int i_13_ = arg0.method179(i, arg3);
        if (arg2 != 21) {
            ChatBox.chatTypes = null;
        }
        return MovedStatics.method927(i_13_, arg0, true, i);
    }

    public int method1023(byte[] arg0, int arg1, int arg2, byte[] arg3, int arg4, int arg5) {
        if (arg1 == 0) {
            return 0;
        }
        arg1 += arg2;
        int i = 0;
        int i_0_ = arg4;
        for (; ; ) {
            byte i_1_ = arg0[i_0_];
            if (i_1_ >= 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            int i_2_;
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x40 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((0x20 & i_1_) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x10 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((i_1_ & 0x8) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((0x4 & i_1_) != 0) {
                i = chatDecryptKeys[i];
            } else {
                i++;
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg1 <= arg2) {
                    break;
                }
                i = 0;
            }
            if ((0x2 & i_1_) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            if ((i_1_ & 0x1) == 0) {
                i++;
            } else {
                i = chatDecryptKeys[i];
            }
            if ((i_2_ = chatDecryptKeys[i]) < 0) {
                arg3[arg2++] = (byte) (i_2_ ^ 0xffffffff);
                if (arg2 >= arg1) {
                    break;
                }
                i = 0;
            }
            i_0_++;
        }

        return -arg4 + i_0_ + 1;
    }

    public int encrypt(int arg1, int bufferPos, int sourceLength, byte[] source, byte[] dest) {
        sourceLength += arg1;
        int i = 0;
        int i_6_ = bufferPos << 3;;
        for (/**/; arg1 < sourceLength; arg1++) {
            int textByte = 0xff & source[arg1];
            int mask = chatMask[textByte];
            int size = chatBitSizes[textByte];
            if (size == 0) {
                throw new RuntimeException("No codeword for data value " + textByte);
            }
            int bitOffset2 = i_6_ >> 3;
            int bitOffset = 0x7 & i_6_;
            i_6_ += size;
            i &= -bitOffset >> 31;
            int i_12_ = bitOffset2 + (size + bitOffset - 1 >> 3);
            bitOffset += 24;
            dest[bitOffset2] = (byte) (i = BitUtils.bitWiseOR(i, mask >>> bitOffset));
            if (bitOffset2 < i_12_) {
                bitOffset2++;
                bitOffset -= 8;
                dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                if (i_12_ > bitOffset2) {
                    bitOffset -= 8;
                    bitOffset2++;
                    dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                    if (bitOffset2 < i_12_) {
                        bitOffset2++;
                        bitOffset -= 8;
                        dest[bitOffset2] = (byte) (i = mask >>> bitOffset);
                        if (bitOffset2 < i_12_) {
                            bitOffset -= 8;
                            bitOffset2++;
                            dest[bitOffset2] = (byte) (i = mask << -bitOffset);
                        }
                    }
                }
            }
        }
        return (7 + i_6_ >> 3) - bufferPos;
    }
}
