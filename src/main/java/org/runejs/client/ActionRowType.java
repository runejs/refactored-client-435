package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    MAGIC_ON_PLAYER(1),
    MAGIC_ON_NPC(21),
    ITEM_ON_PLAYER(22),
    CHATBOX_ACCEPT_TRADE(26),
    CHATBOX_REPORT_ABUSE(28),
    CHATBOX_ADD_FRIEND(45),
    CHATBOX_ACCEPT_CHALLENGE(46),
    ITEM_ON_NPC(49),
    CHATBOX_ADD_IGNORE(51),

    EXAMINE_NPC(1001),
    EXAMINE_ITEM(1003),
    EXAMINE_OBJECT(1004);

    private final int id;

    ActionRowType(int actionTypeId) {
        this.id = actionTypeId;
    }

    public int getId() {
        return this.id;
    }
}
