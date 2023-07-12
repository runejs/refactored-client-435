package org.runejs.client.net;

/**
 * Defines known packet types. If you were to add a new packet, or find a new one, just add it here,
 * and handle it in IncomingPackets.parseIncomingPackets()
 * @see IncomingPackets
 */
public enum PacketType {
    /**
     * Sets a varp to an int
     */
    SET_VARP_INT(2, 5),
    MOVE_WIDGET_CHILD(3, 8),
    SET_CURRENT_TAB(6, 1),
    CLOSE_CUTSCENE(7, 0),
    UPDATE_ALL_WIDGET_ITEMS(12, -2),
    RESET_VARBITS(14, 0),
    UPDATE_RUN_ENERGY(18, 1),
    LOAD_CONSTRUCTED_MAP_REGION(23, -2),
    PLAY_WIDGET_ANIMATION(24, 6),
    RESET_ACTOR_ANIMATIONS(27, 0),
    UPDATE_SKILL(34, 6),
    PLAY_QUICK_SONG(40, 5),
    SET_MULTI_COMBAT(48, 1),
    PRIVATE_MESSAGE_RECEIVED(51, -1),
    SHOW_WALKABLE_SCREEN_WIDGET(56, 2),
    FORCE_PRIVATE_MESSAGE(71, -1),
    CHATBOX_MESSAGE_RECEIVED(82, -1),


    /**
     * This packet contains a series of child packets within it.
     *
     * They contain the unencrypted opcode, followed by the normal packet body.
     *
     * They are executed in order.
     */
    BULK_WORLD_UPDATE(63, -2),
    PLAY_SOUND_AT_POSITION(9, 5),
    UPDATE_GROUND_ITEM_AMOUNT(99, 7),
    TRANSFORM_PLAYER_TO_OBJECT(229, 14),
    ROTATE_ANIMATE_OBJECT(49, 4),
    REMOVE_OBJECT(143, 2),
    SPAWN_OBJECT(241, 4),
    ADD_GROUND_ITEM(175, 5),
    ADD_GROUND_ITEM_EXCLUDE_SOME_PLAYER(19, 7),
    REMOVE_GROUND_ITEM(74, 3),
    CREATE_PROJECTILE(1, 15),
    CREATE_STATIONARY_GFX(202, 6),


    CLEAR_MAP_CHUNK(64, 2),
    SET_FRIEND_LIST_STATUS(70, 1),
    RESET_VARPS(72, 0),
    RECEIVE_CONSOLE_LOG(83, -1),
    SHOW_TAB_AND_SCREEN_WIDGETS(84, 4),
    RECEIVE_CONSOLE_COMMAND(85, -1),
    FLASH_TAB_ICON(88, 1),
    UPDATE_PLAYERS(92, -2),
    UPDATE_WIDGET_TEXT(110, -2),
    SET_WIDGET_HIDDEN(115, 5),
    SET_SYSTEM_UPDATE_TIME(116, 2),
    SET_WIDGET_MODEL_ROTATION_SPEED(117, 8),
    SHOW_SCREEN_WIDGET(118, 2),
    SET_WIDGET_ITEM_MODEL(120, 8),
    SHOW_TEXT_INPUT_WIDGET(124, 0),
    UPDATE_NPCS(128, -2),
    SET_LOCAL_PLAYER_POS(129, 3),
    CLEAR_LOCAL_PLAYER_DESTINATION(233, 0),
    SET_REPORT_ABUSE_WIDGET(130, 2),
    PLAY_SOUND(131, 5),
    SHOW_NUMBER_INPUT_WIDGET(132, 0),
    /**
     * Set the widget to be displayed when a user selects a given tab.
     */
    SET_TAB_WIDGET(140, 3),
    ROTATE_WIDGET_MODEL(142, 10),
    FRIEND_LOGGED_IN(156, 10),
    SET_HINT_ICON(186, 6),
    SET_CHAT_MODES(196, 3),
    SET_WIDGET_NPC_HEAD(160, 6),
    SET_MAP_CHUNK(166, -2),
    UPDATE_CARRY_WEIGHT(171, 2),
    CLEAR_WIDGET_ITEMS(174, 4),
    CLOSE_ALL_WIDGETS(180, 0),
    LOGOUT(181, 0),
    SET_WIDGET_SCROLL_POSITION(182, 6),
    SHOW_PERMANENT_CHATBOX_WIDGET(185, 2),
    SHOW_FULLSCREEN_INTERFACE(195, 4),
    SHOW_CHATBOX_WIDGET(208, 2),
    SET_WIDGET_PLAYER_HEAD(210, 4),
    UPDATE_IGNORE_LIST(211, -2),
    UPDATE_SPECIFIC_WIDGET_ITEMS(214, -2),
    PLAY_SONG(217, 2),
    /**
     * Sets a varp to a byte
     */
    SET_VARP_BYTE(222, 3),
    UPDATE_PLAYER_OPTIONS(223, -1),
    UPDATE_WIDGET_TEXT_COLOR(231, 6),
    /**
     * Initiate the cutscene camera and turn it towards a location.
     */
    CUTSCENE_CAMERA_LOOK_TO(234, 6),
    SET_MINIMAP_STATE(235, 1),
    /**
     * Display a widget over the tab area.
     */
    SHOW_TAB_WIDGET(237, 2),
    SET_WIDGET_MODEL(250, 6),
    /**
     * Initiate the cutscene camera and move it to a location.
     */
    CUTSCENE_CAMERA_MOVE_TO(253, 6),
    UPDATE_REFERENCE_POSITION(254, 2),
    SHAKE_CAMERA(255, 4);

    /**
     * The packet opcode after ISAAC decryption.
     */
    private final int opcode;

    /**
     * The packet size in bytes of this specific packet.
     * @implNote If the size is greater than 0, then the packet size is set as-is.
     *           If this value is -1, the server is sending the size between 0 and 255 in the next 1 byte.
     *           If this value is -2, the server is sending the size between 0 and 65525 in the next 2 bytes.
     */
    private final int size;

    /**
     * An array listing all packet sizes, in case the packet hasn't been registered yet.
     * TODO remove this when all packets have been defined properly
     */
    public static int[] incomingPacketSizes = new int[] {
            0, 15, 6, 8, 0, 0, 1, 0, 0, 5,  // 0
            0, 0, -2, 0, 0, 0, 0, 0, 1, 7,  // 10
            0, 0, 0, -2, 6, 0, 0, 0, 0, 0,  // 20
            0, 0, 0, 0, 6, 0, 0, 0, 0, 0,  // 30
            5, 0, 0, 0, 0, 0, 0, 0, 1, 4,  // 40
            0, -1, 0, 0, 0, 0, 2, 0, 4, 0,  // 50
            0, 0, 0, -2, 2, 0, 0, 0, 0, 0,  // 60
            1, -1, 0, 0, 3, 0, 0, 0, 0, 0,  // 70
            0, 0, -1, -1, 4, -1, 0, 0, 1, 0,  // 80
            0, 0, -2, 0, 0, 0, 0, 0, 0, 7,  // 90
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  // 100
            -2, 0, 0, 0, 0, 5, 2, 8, 2, 0,  // 110
            8, 0, 0, 0, 0, 0, 0, 0, -2, 3,  // 120
            2, 5, 0, 0, 0, 0, 0, 0, 0, 0,  // 130
            3, 0, 10, 2, 0, 0, 0, 0, 0, 0,  // 140
            0, 0, 0, 0, 0, 0, 10, 0, 0, 0,  // 150
            6, 0, 0, 0, 0, 0, -2, 0, 0, 0,  // 160
            0, 2, 0, 0, 4, 5, 0, 0, 0, 0,  // 170
            0, 0, 6, 0, 0, 2, 6, 0, 0, 0,  // 180
            0, 0, 0, 0, 6, 4, 3, 0, 0, 0,  // 190
            0, 0, 6, 0, 0, 0, 0, 0, 2, 0,  // 200
            4, -2, 0, 0, -2, 0, 0, 2, 0, 0,  // 210
            0, 0, 3, -1, 0, 0, 0, 0, 0, 14,  // 220
            0, 6, 0, 0, 6, 1, 0, 2, 0, 0,  // 230
            -2, 4, 0, 0, 0, 0, 0, 0, 0, 0,  // 240
            6, 0, 0, 6, 2, 4 };

    PacketType(int opcode, int size) {
        this.opcode = opcode;
        this.size = size;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getSize() {
        return size;
    }

    public static int findPacketSize(int id) {
        for (PacketType packetType : values()) {
            if (packetType.opcode == id) {
                return packetType.size;
            }
        }

        return incomingPacketSizes[id];
    }
}
