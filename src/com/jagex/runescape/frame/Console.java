package com.jagex.runescape.frame;

import com.jagex.runescape.Class40_Sub5_Sub17_Sub6;
import com.jagex.runescape.Class59;
import com.jagex.runescape.RSString;
import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.EntityDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.Widget;
import com.jagex.runescape.collection.Node;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.InteractiveObject;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.WallDecoration;

public class Console {
    public static Console console; // TODO: Temp until finding a better spot to store this
    private String[] consoleMessages;
    private int messageCount;
    public String consoleInput;
    public boolean consoleOpen;
    private static final int maxResults = 10;
    private int results;
    private String[] previousCommands;
    private int previousCommandIndex;
    private int previousCommandCount;
    public int currentScroll = 0;
    private boolean alpha = true;

    public Console() {
        this.messageCount = 0;
        this.consoleMessages = new String[500];
        this.previousCommands = new String[100];
        this.previousCommands[0] = "";
        this.consoleInput = "";
        this.consoleOpen = false;
        this.previousCommandCount = 1;
        this.previousCommandIndex = 1;
        this.printConsoleMessage("Welcome to the RuneJS console, type help for help.", false);
    }

    public int getMaxScroll() {
        return messageCount * 18 + 17;
    }

    public void drawConsole() {
        if(consoleOpen) {
            int scrollpos = getMaxScroll() - currentScroll - 310;
            if(messageCount > 17) {
                Widget.drawScrollBar(494, 0, 313, scrollpos, getMaxScroll(), 0);
            }
            if(alpha) {
                Rasterizer.drawFilledRectangleAlpha(0, 0, 512, 334, 0x513092, 97);
            } else {
                Rasterizer.drawFilledRectangle(0, 0, 512, 334, 0x513092);
            }
            Rasterizer.drawHorizontalLine(1, 315, 512, 0xffffff);
            Class40_Sub5_Sub17_Sub6.fontBold.setEffects(0xffffff, -1);
            Class40_Sub5_Sub17_Sub6.fontBold.drawBasicString("-->", 11, 330);
            Class40_Sub5_Sub17_Sub6.aClass40_Sub5_Sub14_Sub1_3236.drawBasicString("RuneJS #435", 420, 312);

            if(Node.pulseCycle % 20 < 10) {
                Class40_Sub5_Sub17_Sub6.fontBold.drawBasicString(consoleInput + "|", 38, 330);
            } else {
                Class40_Sub5_Sub17_Sub6.fontBold.drawBasicString(consoleInput, 38, 330);
            }
        }
    }

    public void drawConsoleArea() {
        if(consoleOpen) {
            WallDecoration.fontNormal.setEffectsAlpha(0xffffff, -1, 178);
            for(int i = messageCount, j = 308; i > 0; i--, j -= 18) {
                if(consoleMessages[i] == null) {
                    break;
                }
                int y = j;
                if(messageCount > 17) {
                    y = 290 - ((messageCount - i) * 18) + (18 + currentScroll);
                }
                if(y > 2 && y < 315)
                    WallDecoration.fontNormal.drawBasicString(consoleMessages[i], 9, y);
            }
        }
    }

    public void printConsoleMessage(String s, boolean userInput) {
        if(ChatBox.openChatboxWidgetId == -1)
            ChatBox.redrawChatbox = true;
        String[] strings = s.split("\n");
        boolean first = true;
        for(String line : strings) {
            if(first && userInput)
                consoleMessages[++messageCount] = "--> " + line;
            else {
                consoleMessages[++messageCount] = line;
            }
            first = false;
        }

    }

    public void parseConsoleCommand(String cmd) {
        currentScroll = 0;
        addToFrontOfHistory(cmd);
        previousCommandCount++;
        previousCommandIndex = 0;
        String[] cmdInput = cmd.split(" ");
        switch(cmdInput[0].toLowerCase()) {
            case "cls":
            case "clear":
                messageCount = 0;
                printConsoleMessage("<col=FFFFFF>Cleared</col>", false);
                break;
            case "alpha":
                this.alpha = !this.alpha;
                break;
            case "rights":
            case "playerrights":
                printConsoleMessage("<col=FFFFFF>Your player rights level: <col=00FF00>" + InteractiveObject.playerRights + "</col></col>", false);
                break;
            case "toggle_fps":
            case "fps":
                InteractiveObject.showFps = !InteractiveObject.showFps;
                if(InteractiveObject.showFps) {
                    printConsoleMessage("<col=00FF00>FPS is now shown</col>", false);
                } else {
                    printConsoleMessage("<col=FF0000>FPS is now hidden</col>", false);
                }
                break;
            case "show_fps":
                InteractiveObject.showFps = true;
                printConsoleMessage("<col=00FF00>FPS is now shown</col>", false);
                break;
            case "hide_fps":
                InteractiveObject.showFps = false;
                printConsoleMessage("<col=FF0000>FPS is now hidden</col>", false);
                break;
            case "search":
            case "find":
            case "s":
                searchObjects(cmdInput);
                break;
            case "exit":
            case "close":
            case "quit":
                consoleOpen = false;
                break;
            case "dropclient":
            case "clientdrop":
                Class59.dropClient(2578);
                break;
            case "help":
            case "commands":
                printCommands();
            default:
                SceneCluster.packetBuffer.putPacket(248);
                SceneCluster.packetBuffer.putByte(cmd.length() + 1);
                SceneCluster.packetBuffer.putString(cmd);
                break;
        }
    }

    private void printCommands() {
        printConsoleMessage("<col=FFFF00>Commands:</col>", false);
        printConsoleMessage("<col=00FF00>help | commands</col> - <col=FFFF00>Returns this list</col>", false);
        printConsoleMessage("<col=00FF00>alpha</col> - <col=FFFF00>Toggles console background transparency</col>", false);
        printConsoleMessage("<col=00FF00>clear | cls</col> - <col=FFFF00>Clears console output</col>", false);
        printConsoleMessage("<col=00FF00>rights | playerrights</col> - <col=FFFF00>Returns current player rights</col>", false);
        printConsoleMessage("<col=00FF00>fps | toggle_fps</col> - <col=FFFF00>Toggles the FPS counter</col>", false);
        printConsoleMessage("<col=00FF00>show_fps</col> - <col=FFFF00>Shows FPS counter</col>", false);
        printConsoleMessage("<col=00FF00>hide_fps</col> - <col=FFFF00>Hides FPS counter</col>", false);
        printConsoleMessage("<col=00FF00>search [item | npc | object] [name]</col> - <col=FFFF00>Returns list of results</col>", false);

    }

    private void searchObjects(String[] cmdInput) {
        if(cmdInput.length <= 2) {
            printConsoleMessage("<col=FFA500>Usage: search [item|npc|object] [name]</col>", false);
            return;
        }
        printConsoleMessage("<col=FFFF00>Searching...</col>", false);

        results = 0;
        switch(cmdInput[1].toLowerCase()) {
            case "item":
            case "items":
            case "i":
                for(int itemId = 0; ItemDefinition.count > itemId; itemId++) {
                    ItemDefinition definition = ItemDefinition.forId(itemId, 10);
                    if(definition.noteTemplateId == -1) {
                        filterAndAddDefinition(itemId, definition, cmdInput);
                        if((results >= maxResults))
                            break;
                    }
                }
                break;
            case "npc":
            case "npcs":
            case "n":
                for(int npcId = 0; ActorDefinition.count > npcId; npcId++) {
                    ActorDefinition definition = ActorDefinition.getDefinition(npcId);
                    filterAndAddDefinition(npcId, definition, cmdInput);
                    if((results >= maxResults))
                        break;
                }
                break;
            case "object":
            case "objects":
            case "o":
                for(int objectId = 0; GameObjectDefinition.count > objectId; objectId++) {
                    GameObjectDefinition definition = GameObjectDefinition.getDefinition(objectId);
                    filterAndAddDefinition(objectId, definition, cmdInput);
                    if((results >= maxResults))
                        break;
                }
                break;
        }

    }

    private void filterAndAddDefinition(int id, EntityDefinition def, String[] searchTerms) {
        if(def.getName() != null) {
            RSString objectName = def.getName().toLowerCase();
            String itemNameString = objectName.toString();
            for(int indx = 2; indx < searchTerms.length; indx++) {
                if(!itemNameString.contains(searchTerms[indx].toLowerCase()))
                    return;
            }
            printConsoleMessage("<col=FFFF00>" + def.getName() + " - " + id + "</col>", false);
            results++;
        }
    }

    public void loadPrev() {
        if(previousCommandIndex < previousCommandCount - 1) {
            consoleInput = previousCommands[++previousCommandIndex];
        }
    }

    public void loadNext() {
        if(previousCommandIndex > 0) {
            consoleInput = previousCommands[--previousCommandIndex];
        }
    }

    private void addToFrontOfHistory(String element) {
        String[] newArray = new String[previousCommands.length];
        newArray[0] = "";
        newArray[1] = element;
        for(int i = 2; i < previousCommands.length; i++) {
            if(previousCommands[i - 1] == null) {
                break;
            }
            newArray[i] = previousCommands[i - 1];
        }
        previousCommands = newArray;
    }

    public void resetToCurrent() {
        previousCommandIndex = 0;
        consoleInput = "";
    }

    public void handleInput() {
        if(ItemDefinition.anInt2854 == 98) {
            loadPrev();
        }
        if(ItemDefinition.anInt2854 == 99) {
            loadNext();
        }
        if(ItemDefinition.anInt2854 == 0) {
            resetToCurrent();
        }

        if(ItemDefinition.anInt2854 == 85 && (consoleInput.length() > 0)) {
            consoleInput = consoleInput.substring(0, Console.console.consoleInput.length() - 1);
        }
        if(Player.method793((byte) 120, Class59.anInt1388) && consoleInput.length() < 80) {
            consoleInput += (char) Class59.anInt1388;
        }
        if(ItemDefinition.anInt2854 == 84 && (consoleInput.length() > 0)) {
            printConsoleMessage(consoleInput, true);
            parseConsoleCommand(consoleInput);
            consoleInput = "";
        }
        ChatBox.redrawChatbox = true;
    }
}
