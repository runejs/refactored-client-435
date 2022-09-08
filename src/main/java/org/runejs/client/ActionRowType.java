package org.runejs.client;

/**
 * This represents a single row in the right-click action menu,
 * or the preview at the top left of the screen.
 *
 * @author jameskmonger
 */
public enum ActionRowType {
    // missing ActionRowTypes:

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

    // 1005 has some significance, what is it?

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

    /**
     * Walk to a tile.
     */
    WALK_HERE(7),

    /**
     * Drop an item from the inventory.
     */
    DROP_ITEM(11),

    /**
     * Send a private message to someone on the player's friends list.
     */
    MESSAGE_FRIEND(18),

    /**
     * Add someone to the player's friends list.
     */
    ADD_FRIEND(45),

    /**
     * Remove someone from the player's friends list.
     */
    REMOVE_FRIEND(13),

    /**
     * Add someone to the player's ignore list.
     */
    ADD_IGNORE(51),

    /**
     * Remove someone from the player's ignore list.
     */
    REMOVE_IGNORE(35),

    /**
     * Accept a trade request.
     */
    ACCEPT_TRADE(26),

    /**
     * Accept a duel request.
     */
    ACCEPT_CHALLENGE(46),

    /**
     * Report a player for abuse.
     */
    REPORT_ABUSE(28),
    
    /**
     * The initial 'use' to select an item on a widget
     * 
     * TODO TODO TODO is this inventory or widget ??
     */
    SELECT_ITEM_ON_WIDGET(19),

    /**
     * The "Cast" option on a spell inside a spell list
     */
    SELECT_SPELL_ON_WIDGET(33),

    /**
     * Use an item on another player.
     */
    USE_ITEM_ON_PLAYER(22),

    /**
     * Use an item on an NPC.
     */
    USE_ITEM_ON_NPC(49),

    /**
     * Use an item on an inventory item.
     *
     * TODO TODO TODO is this inventory or widget ??
     */
    USE_ITEM_ON_INVENTORY_ITEM(56),

    /**
     * Use an item on a world item (i.e. an item on the ground)
     */
    USE_ITEM_ON_WORLD_ITEM(47),

    /**
     * Use an item on an object.
     */
    USE_ITEM_ON_OBJECT(5),

    /**
     * Cast a spell on a player.
     */
    CAST_MAGIC_ON_PLAYER(1),

    /**
     * Cast a spell on an NPC.
     */
    CAST_MAGIC_ON_NPC(21),

    /**
     * Cast a spell on a widget item.
     * 
     * TODO TODO TODO inventory or widget?
     */
    CAST_MAGIC_ON_WIDGET_ITEM(37),

    /**
     * Cast a spell on a world item (i.e. an item on the ground)
     */
    CAST_MAGIC_ON_WORLD_ITEM(15),

    /**
     * Cast a spell on an object.
     */
    CAST_MAGIC_ON_OBJECT(32),

    /**
     * Interact with a player and choose option 1.
     */
    INTERACT_WITH_PLAYER_OPTION_1(10),
    
    /**
     * Interact with a player and choose option 2.
     */
    INTERACT_WITH_PLAYER_OPTION_2(39),
    
    /**
     * Interact with a player and choose option 3.
     */
    INTERACT_WITH_PLAYER_OPTION_3(44),
    
    /**
     * Interact with a player and choose option 4.
     */
    INTERACT_WITH_PLAYER_OPTION_4(14),
    
    /**
     * Interact with a player and choose option 5.
     */
    INTERACT_WITH_PLAYER_OPTION_5(41),

    
    /**
     * Interact with an NPC and choose option 1.
     *
     * observed values: [ 'Talk to' ]
     */
    INTERACT_WITH_NPC_OPTION_1(12),

    /**
     * Interact with an NPC and choose option 2.
     */
    INTERACT_WITH_NPC_OPTION_2(30),

    /**
     * Interact with an NPC and choose option 3.
     *
     * observed values: [ 'Trade' ]
     */
    INTERACT_WITH_NPC_OPTION_3(4),

    /**
     * Interact with an NPC and choose option 4.
     */
    INTERACT_WITH_NPC_OPTION_4(34),

    /**
     * Interact with an NPC and choose option 5.
     */
    INTERACT_WITH_NPC_OPTION_5(20),

    /**
     * Interact with an object and choose option 1.
     */
    INTERACT_WITH_OBJECT_OPTION_1(16),
    
    /**
     * Interact with an object and choose option 2.
     */
    INTERACT_WITH_OBJECT_OPTION_2(29),
    
    /**
     * Interact with an object and choose option 3.
     */
    INTERACT_WITH_OBJECT_OPTION_3(17),
    
    /**
     * Interact with an object and choose option 4.
     */
    INTERACT_WITH_OBJECT_OPTION_4(27),

    /**
     * Interact with an object and choose option 5.
     *
     * (jameskmonger) why is this so high? it sits with the Examine ids
     */
    INTERACT_WITH_OBJECT_OPTION_5(1002),

    /**
     * Interact with a world item and choose option 1.
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_1(2),

    /**
     * Interact with a world item and choose option 2.
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_2(38),
    
    /**
     * Interact with a world item and choose option 3.
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_3(3),
    
    /**
     * Interact with a world item and choose option 4.
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_4(8),
    
    /**
     * Interact with a world item and choose option 5.
     */
    INTERACT_WITH_WORLD_ITEM_OPTION_5(36),

    /**
     * Interact with an item on a V1 widget and choose option 1.
     * 
     * For example, the left-click option on an item on a shop interface.
     */
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_1(53),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_2(25),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_3(55),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_4(48),
    INTERACT_WITH_ITEM_ON_V1_WIDGET_OPTION_5(24),

    /**
     * Interact with an item on a V1 widget and choose option 2.
     */
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_1(52),
    
    /**
     * Interact with an item on a V1 widget and choose option 3.
     * 
     * (jameskmongeR) this one is read on the server as 'option 5' - which is correct?
     */
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_2(6),

    /**
     * Interact with an item on a V1 widget and choose option 3.
     */
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_3(31),
    
    /**
     * Interact with an item on a V1 widget and choose option 4.
     */
    INTERACT_WITH_ITEM_ON_V2_WIDGET_OPTION_4(43),

    /**
     * Examine an NPC.
     */
    EXAMINE_NPC(1001),
    
    /**
     * Examine an item.
     */
    EXAMINE_ITEM(1003),

    /**
     * Examine an object.
     */
    EXAMINE_OBJECT(1004),

    /**
     * Examine an item on a V1 widget.
     */
    EXAMINE_ITEM_ON_V1_WIDGET(1006),

    /**
     * Examine an item on a V2 widget.
     */
    EXAMINE_ITEM_ON_V2_WIDGET(1007);

    private final int id;

    ActionRowType(int actionTypeId) {
        this.id = actionTypeId;
    }

    public int getId() {
        return this.id;
    }
}
