package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    // 23, 57, 54 are all some kind of interface click
    //     they do different things with the varps
    //     23 is toggle?
    //     57 ????? reads from alternateRhs and switches varp
    //     54 is click here to continue

    // 9 and 40 are interface close
    //      9 appears to be the longstanding chatbox dialogue close
    //      40 is anything else

    // 42 is some kind of tooltip. 
    //          Sends packet 64 (button click) to server and does further processing

    // the ITEM_ON_WIDGET_INTERACTION are for 'new format' widgets
    // 1007 is examine item on new format widget

    // 53, 25, 55, 48, 24 are options on old format widget
    // 1006 is examine item on old format widget

    // 12 is NPC interaction
    // 4 is also NPC interaction
    
    // 2 is ??
    // 3 is pickup item (specific? or is it 1st item option)
    // 44 is ??
    // 16 is ??
    // 17 is ??
    // 20 is ??
    // 50 is ??
    // 225 is ?? (bit shifts the target by 14..)
    
    // 187 is ???? interacts with player in some way
    // 39 is second option on player (what is this? follow?)
    
    // 8 interacts with worlditem (e.g. light logs)
    // 54 is 'click to continue' on dialogue
    // 36 is ??

    // 47 is item on world item


    MAGIC_ON_PLAYER(1),
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_2(6),
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
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_3(31),
    /**
     * The "Cast" option on a spell inside a spell list
     */
    SELECT_SPELL_ON_WIDGET(33),
    REMOVE_IGNORE(35),
    MAGIC_ON_WIDGET_ITEM(37),
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_4(43),
    // @TODO (jameskmonger) do these need CHATBOX_ prefix?
    CHATBOX_ADD_FRIEND(45),
    CHATBOX_ACCEPT_CHALLENGE(46),
    ITEM_ON_NPC(49),
    CHATBOX_ADD_IGNORE(51),
    /**
     * Used for the 'interact' options on an item on an interface
     */
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_1(52),

    EXAMINE_NPC(1001),
    EXAMINE_ITEM(1003),
    EXAMINE_OBJECT(1004),
    EXAMINE_ITEM_ON_V1_WIDGET(1006);

    private final int id;

    ActionRowType(int actionTypeId) {
        this.id = actionTypeId;
    }

    public int getId() {
        return this.id;
    }
}
