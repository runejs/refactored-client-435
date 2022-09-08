package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    // 54 is click here to continue (what else?)

    // 9 and 40 are interface close
    //      9 appears to be the longstanding chatbox dialogue close
    //      40 is anything else

    // 42 is some kind of tooltip. 
    //          Sends packet 64 (button click) to server and does further processing

    // 12 is NPC interaction
    // 4 is also NPC interaction
    
    // 2 is ??
    // 3 is pickup item (specific? or is it 1st item option)
    // 44 is ??
    // 16 is ??
    // 17 is ??
    // 20 is ??
    // 50 is ??
    // 32 is ?? (bit shifts the target by 14..)
    
    // 187 is ???? interacts with player in some way
    // 39 is second option on player (what is this? follow?)
    
    // 8 interacts with worlditem (e.g. light logs)
    // 54 is 'click to continue' on dialogue
    // 36 is ??

    // 47 is item on world item

    /**
     * Toggle the value of a varp.
     *
     * e.g. toggling run/walk
     */
    BUTTON_TOGGLE_VARP(23),

    /**
     * Set the value of a varp to the `alternateRhs` of the interface
     *
     * e.g. setting the brightness value, there are multiple button widgets targeting
     *          the same varp with a different `alternateRhs`
     */
    BUTTON_SET_VARP_VALUE(57),

    MAGIC_ON_PLAYER(1),
    // this one is read on the server as 'option 5' - which is correct?
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_2(6),

    WALK_HERE(7),
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
    /**
     * Used for the 'interact' options on an item on a V1 (old format) interface
     * 
     * For example, these are the 5 options when you right-click an item in a shop.
     */
    ITEM_ON_V1_WIDGET_INTERACTION_OPTION_1(53),
    ITEM_ON_V1_WIDGET_INTERACTION_OPTION_2(25),
    ITEM_ON_V1_WIDGET_INTERACTION_OPTION_3(55),
    ITEM_ON_V1_WIDGET_INTERACTION_OPTION_4(48),
    ITEM_ON_V1_WIDGET_INTERACTION_OPTION_5(24),
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_3(31),

    /**
     * The first NPC interaction option
     *
     * observed values: [ 'Talk to' ]
     */
    NPC_INTERACTION_OPTION_1(12),
    /**
     * The second NPC interaction option
     */
    NPC_INTERACTION_OPTION_2(30),
    /**
     * The third NPC interaction option
     *
     * observed values: [ 'Trade' ]
     */
    NPC_INTERACTION_OPTION_3(4),
    /**
     * The fourth NPC interaction option
     */
    NPC_INTERACTION_OPTION_4(34),
    /**
     * The fifth NPC interaction option
     */
    NPC_INTERACTION_OPTION_5(20),


    /**
     * The first Player interaction option
     */
    PLAYER_INTERACTION_OPTION_1(10),
    /**
     * The second Player interaction option
     */
    PLAYER_INTERACTION_OPTION_2(39),
    /**
     * The third Player interaction option
     */
    PLAYER_INTERACTION_OPTION_3(44),
    /**
     * The fourth Player interaction option
     */
    PLAYER_INTERACTION_OPTION_4(14),
    /**
     * The fifth Player interaction option
     */
    PLAYER_INTERACTION_OPTION_5(41),

    /**
     * Player uses an item on an object
     */
    ITEM_USE_ON_OBJECT(5),

    /**
     * The first object interaction option
     */
    OBJECT_INTERACTION_OPTION_1(16),
    /**
     * The second object interaction option
     */
    OBJECT_INTERACTION_OPTION_2(29),
    /**
     * The third object interaction option
     */
    OBJECT_INTERACTION_OPTION_3(17),
    /**
     * The fourth object interaction option
     */
    OBJECT_INTERACTION_OPTION_4(27),
    /**
     * The fifth object interaction option
     *
     * (jameskmonger) why is this so high? it sits with the Examine ids
     */
    OBJECT_INTERACTION_OPTION_5(1002),

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
     * Used for the 'interact' options on an item on a V2 (new format) interface
     */
    ITEM_ON_V2_WIDGET_INTERACTION_OPTION_1(52),

    /**
     * For when the player uses an inventory item on another.
     */
    ITEM_USE_ON_INVENTORY_ITEM(56),

    EXAMINE_NPC(1001),
    EXAMINE_ITEM(1003),
    EXAMINE_OBJECT(1004),
    EXAMINE_ITEM_ON_V1_WIDGET(1006),
    EXAMINE_ITEM_ON_V2_WIDGET(1007);

    private final int id;

    ActionRowType(int actionTypeId) {
        this.id = actionTypeId;
    }

    public int getId() {
        return this.id;
    }
}
