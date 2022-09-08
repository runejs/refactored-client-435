package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    // 42
    //     interface

    // 50
    //     cs2 interface handling??

    // 40
    //      some kind of close button
    
    // 9
    //      some kind of close button

    // 54
    //      click to continue? (what else?)

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

    WALK_HERE(7),
    DROP_ITEM(11),

    MESSAGE_FRIEND(18),
    ADD_FRIEND(45),
    REMOVE_FRIEND(13),
    ADD_IGNORE(51),
    REMOVE_IGNORE(35),
    ACCEPT_TRADE(26),
    ACCEPT_CHALLENGE(46),
    REPORT_ABUSE(28),
    /**
     * The initial 'use' to select an item on a widget
     */
    SELECT_ITEM_ON_WIDGET(19),

    /**
     * The "Cast" option on a spell inside a spell list
     */
    SELECT_SPELL_ON_WIDGET(33),

    USE_ITEM_ON_PLAYER(22),

    USE_ITEM_ON_NPC(49),

    /**
     * For when the player uses an inventory item on another.
     *
     * TODO TODO TODO is this inventory or widget ??
     */
    USE_ITEM_ON_INVENTORY_ITEM(56),

    /**
     * Player uses an item on a world item
     */
    USE_ITEM_ON_WORLD_ITEM(47),

    /**
     * Player uses an item on an object
     */
    USE_ITEM_ON_OBJECT(5),

    CAST_MAGIC_ON_PLAYER(1),
    CAST_MAGIC_ON_NPC(21),
    CAST_MAGIC_ON_WIDGET_ITEM(37),
    CAST_MAGIC_ON_WORLD_ITEM(15),
    CAST_MAGIC_ON_OBJECT(32),

    /**
     * The first Player interaction option
     */
    INTERACT_WITH_PLAYER_OPTION_1(10),
    /**
     * The second Player interaction option
     */
    INTERACT_WITH_PLAYER_OPTION_2(39),
    /**
     * The third Player interaction option
     */
    INTERACT_WITH_PLAYER_OPTION_3(44),
    /**
     * The fourth Player interaction option
     */
    INTERACT_WITH_PLAYER_OPTION_4(14),
    /**
     * The fifth Player interaction option
     */
    INTERACT_WITH_PLAYER_OPTION_5(41),

    /**
     * The first NPC interaction option
     *
     * observed values: [ 'Talk to' ]
     */
    INTERACT_WITH_NPC_OPTION_1(12),
    /**
     * The second NPC interaction option
     */
    INTERACT_WITH_NPC_OPTION_2(30),
    /**
     * The third NPC interaction option
     *
     * observed values: [ 'Trade' ]
     */
    INTERACT_WITH_NPC_OPTION_3(4),
    /**
     * The fourth NPC interaction option
     */
    INTERACT_WITH_NPC_OPTION_4(34),
    /**
     * The fifth NPC interaction option
     */
    INTERACT_WITH_NPC_OPTION_5(20),

    /**
     * The first object interaction option
     */
    INTERACT_WITH_OBJECT_OPTION_1(16),
    /**
     * The second object interaction option
     */
    INTERACT_WITH_OBJECT_OPTION_2(29),
    /**
     * The third object interaction option
     */
    INTERACT_WITH_OBJECT_OPTION_3(17),
    /**
     * The fourth object interaction option
     */
    INTERACT_WITH_OBJECT_OPTION_4(27),
    /**
     * The fifth object interaction option
     *
     * (jameskmonger) why is this so high? it sits with the Examine ids
     */
    INTERACT_WITH_OBJECT_OPTION_5(1002),

    /**
     * The first world item interaction option
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_1(2),
    /**
     * The second world item interaction option
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_2(38),
    /**
     * The third world item interaction option
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_3(3),
    /**
     * The fourth world item interaction option
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_4(8),
    /**
     * The fifth world item interaction option
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_5(36),

    /**
     * Used for the 'interact' options on an item on a V1 (old format) interface
     *
     * For example, these are the 5 options when you right-click an item in a shop.
     */
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1(53),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2(25),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3(55),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4(48),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5(24),

    /**
     * Used for the 'interact' options on an item on a V2 (new format) interface
     */
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1(52),
    // this one is read on the server as 'option 5' - which is correct?
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2(6),
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3(31),
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4(43),

    EXAMINE_NPC(1001),
    EXAMINE_ITEM(1003),
    EXAMINE_OBJECT(1004),
    // TODO (jameskmonger) 1005 has some significance, what is it?
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
