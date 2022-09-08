package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    MAGIC_ON_PLAYER(1),
    ITEM_ON_WIDGET_INTERACTION_OPTION_2(6),
    DROP_ITEM(11),
    REMOVE_FRIEND(13),
    MESSAGE_FRIEND(18),
    /**
     * The initial 'use' on an item in the inventory (to select it)
     */
    ITEM_ON_WIDGET_USE(19),
    MAGIC_ON_NPC(21),
    ITEM_ON_PLAYER(22),
    CHATBOX_ACCEPT_TRADE(26),
    CHATBOX_REPORT_ABUSE(28),
    ITEM_ON_WIDGET_INTERACTION_OPTION_3(31),
    REMOVE_IGNORE(35),
    MAGIC_ON_WIDGET_ITEM(37),
    ITEM_ON_WIDGET_INTERACTION_OPTION_4(43),
    // @TODO (jameskmonger) do these need CHATBOX_ prefix?
    CHATBOX_ADD_FRIEND(45),
    CHATBOX_ACCEPT_CHALLENGE(46),
    ITEM_ON_NPC(49),
    CHATBOX_ADD_IGNORE(51),
    /**
     * Used for the 'interact' options on an item on an interface
     */
    ITEM_ON_WIDGET_INTERACTION_OPTION_1(52),

    EXAMINE_NPC(1001),
    EXAMINE_ITEM(1003),
    EXAMINE_OBJECT(1004),
    EXAMINE_ITEM_ON_WIDGET(1006);

    private final int id;

    ActionRowType(int actionTypeId) {
        this.id = actionTypeId;
    }

    public int getId() {
        return this.id;
    }
}
