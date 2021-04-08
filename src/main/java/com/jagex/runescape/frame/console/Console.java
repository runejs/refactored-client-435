package com.jagex.runescape.frame.console;

import com.jagex.runescape.Class59;
import com.jagex.runescape.MovedStatics;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.TypeFace;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.ChatBox;
import com.jagex.runescape.frame.console.Commands.*;
import com.jagex.runescape.media.Rasterizer;
import com.jagex.runescape.media.renderable.Item;
import com.jagex.runescape.media.renderable.actor.Player;
import com.jagex.runescape.scene.SceneCluster;
import com.jagex.runescape.scene.tile.WallDecoration;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;

public class Console {
    private static final String CONSOLE_VERSION = "RuneJS #435";
    public static Console console; // TODO: Temp until finding a better spot to store this
    private final String[] consoleMessages;
    private final List<Command> commands;
    public String consoleInput;
    public boolean consoleOpen;
    public int currentScroll = 0;
    private int messageCount;
    private String[] previousCommands;
    private int previousCommandIndex;
    private int previousCommandCount;
    private int currentChatIndex;
    private boolean alpha = true;
    private int versionWidth = -1;
    private int tabCount = 0;
    private CommandList autoCompleteList;

    public Console() {
        this.messageCount = 0;
        this.consoleMessages = new String[5000];
        this.previousCommands = new String[100];
        this.previousCommands[0] = "";
        this.consoleInput = "";
        this.currentChatIndex = 0;
        this.consoleOpen = false;
        this.previousCommandCount = 1;
        this.previousCommandIndex = 1;
        this.commands = new CommandList();
        this.log("Welcome to the RuneJS console, type help for help.");
        this.initialiseCommands();
    }

    private void initialiseCommands() {
        commands.add(new HelpCommand(this.commands));
        commands.add(new AlphaCommand());
        commands.add(new ClearCommand());
        commands.add(new DebugCommand());
        commands.add(new DebugViewCommand());
        commands.add(new EchoCommand());
        commands.add(new PlayerRightsCommand());
        commands.add(new IpCommand());
        commands.add(new FpsCommand());
        commands.add(new RoofsCommand());
        commands.add(new ShowFpsCommand());
        commands.add(new HideFpsCommand());
        commands.add(new SearchCommand());
        commands.add(new ResizableCommand());
    }

    public int getMaxScroll() {
        return messageCount * 18 + 17;
    }

    public void drawConsole(int width, int height) {
        // height = 334
        // width = 512
        if(consoleOpen) {
            int scrollpos = getMaxScroll() - currentScroll - 310;
            if(messageCount > 17) {
                GameInterface.drawScrollBar(width - 18, 0, height - 21, scrollpos, getMaxScroll(), 0);
            }
            if(alpha) {
                Rasterizer.drawFilledRectangleAlpha(0, 0, width, height, 0x513092, 97);
            } else {
                Rasterizer.drawFilledRectangle(0, 0, width, height, 0x513092);
            }
            Rasterizer.drawHorizontalLine(1, height - 19, width, 0xffffff);
            TypeFace.fontBold.setEffects(0xffffff, -1);
            TypeFace.fontBold.drawBasicString(">", 11, height - 4);
            if(this.versionWidth == -1) {
                this.versionWidth = TypeFace.fontSmall.getStringWidth(CONSOLE_VERSION);
            }
            TypeFace.fontSmall.drawBasicString(CONSOLE_VERSION, (width - 25) - this.versionWidth, height - 22);

            if(MovedStatics.pulseCycle % 20 < 10) {
                TypeFace.fontBold.drawBasicString(
                        consoleInput.substring(0, currentChatIndex) + "|" + consoleInput.substring(currentChatIndex),
                        22, height - 4
                );
            } else {
                TypeFace.fontBold.drawBasicString(consoleInput.substring(0, currentChatIndex) + "<trans=0>|</trans>" +
                        consoleInput.substring(currentChatIndex), 22, height - 4);
            }
        }
    }

    public void drawConsoleArea(int width, int height) {
        if(consoleOpen) {
            WallDecoration.fontNormal.setEffectsAlpha(0xffffff, -1, 178);
            for(int i = messageCount, j = 308; i > 0; i--, j -= 18) {
                if(consoleMessages[i] == null) {
                    break;
                }
                int y = j;
                if(messageCount > 17) {
                    y = 290 - (messageCount - i) * 18 + 18 + currentScroll;
                }
                if(y > 2 && y < 315) {
                    WallDecoration.fontNormal.drawBasicString(consoleMessages[i], 9, y);
                }
            }
        }
    }

    public void log(String s) {
        log(s, false);
    }

    public void log(String s, boolean userInput) {
        if(GameInterface.chatboxInterfaceId == -1) {
            ChatBox.redrawChatbox = true;
        }
        String[] strings = s.split("\n");
        boolean first = true;
        for(String line : strings) {
            if(first && userInput) {
                consoleMessages[++messageCount] = "> " + line;
            } else {
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
        int index = this.commands.indexOf(cmdInput[0].toLowerCase());
        if(index == -1) {
            SceneCluster.packetBuffer.putPacket(246);
            SceneCluster.packetBuffer.putString(cmd);
        } else {
            this.commands.get(index).execute(this, cmdInput);
        }
    }

    public void loadPrev() {
        if(previousCommandIndex < previousCommandCount - 1) {
            consoleInput = previousCommands[++previousCommandIndex];
        }
        currentChatIndex = consoleInput.length();

    }

    public void loadNext() {
        if(previousCommandIndex > 0) {
            consoleInput = previousCommands[--previousCommandIndex];
        }
        currentChatIndex = consoleInput.length();

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
        currentChatIndex = 0;
    }

    public void handleInput() {
        //        console.log(ItemDefinition.anInt2854);
        if(Item.obfuscatedKeyStatus[82]) { //CTRL DOWN
            if(ItemDefinition.anInt2854 == 67) { // key v
                String result = "";
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                Transferable contents = clipboard.getContents(null);
                boolean hasStringText = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
                if(hasStringText) {
                    try {
                        result = (String) contents.getTransferData(DataFlavor.stringFlavor);
                    } catch(UnsupportedFlavorException | IOException ex) {
                        System.out.println(ex);
                        ex.printStackTrace();
                    }
                }
                consoleInput += result;
                currentChatIndex = consoleInput.length();
            }
            ChatBox.redrawChatbox = true;
            return;
        }
        if(ItemDefinition.anInt2854 == 80) { // key tab
            tabCount++;
            if(tabCount >= 1) {
                if(tabCount == 1) {
                    buildAutoCompletionList();
                    tabCount++;
                }
                if(tabCount - 2 > autoCompleteList.size() - 1) {
                    tabCount = 2;
                }
                if(autoCompleteList.size() > 0) {
                    this.consoleInput = autoCompleteList.get(tabCount - 2).getCommand();
                    currentChatIndex = consoleInput.length();
                }
            }
        } else {
            tabCount = 0;
        }
        if(ItemDefinition.anInt2854 == 98) { // key up
            loadPrev();
        }
        if(ItemDefinition.anInt2854 == 99) { // key down
            loadNext();
        }
        if(ItemDefinition.anInt2854 == 96) { // key right
            currentChatIndex--;
            if(currentChatIndex < 0) {
                currentChatIndex = 0;
            }
        }
        if(ItemDefinition.anInt2854 == 97) { // key left
            currentChatIndex++;
            if(currentChatIndex > consoleInput.length()) {
                currentChatIndex = consoleInput.length();
            }
        }
        if(ItemDefinition.anInt2854 == 0) { // Key esc
            resetToCurrent();
        }
        if(ItemDefinition.anInt2854 == 101) { // key delete
            if(consoleInput.length() != currentChatIndex) {
                consoleInput = consoleInput.substring(0, currentChatIndex) + consoleInput.substring(
                        currentChatIndex + 1);
            }
        }
        if(ItemDefinition.anInt2854 == 102) { // Key home
            currentChatIndex = 0;
        }
        if(ItemDefinition.anInt2854 == 103) { // Key end
            currentChatIndex = consoleInput.length();
        }

        if(ItemDefinition.anInt2854 == 85 && consoleInput.length() > 0) { // key backspace
            consoleInput = consoleInput.substring(0, currentChatIndex - 1) + consoleInput.substring(currentChatIndex);
            currentChatIndex--;
        }
        if(Player.method793((byte) 120, Class59.anInt1388) && consoleInput.length() < 80) { // any character
            consoleInput = consoleInput.substring(0, currentChatIndex) + (char) Class59.anInt1388 +
                    consoleInput.substring(currentChatIndex);
            currentChatIndex++;
        }
        if(ItemDefinition.anInt2854 == 84 && consoleInput.length() > 0) { // key enter
            log(consoleInput, true);
            parseConsoleCommand(consoleInput);
            consoleInput = "";
            currentChatIndex = 0;
        }
        ChatBox.redrawChatbox = true;
    }

    private void buildAutoCompletionList() {
        CommandList autoCompletionList = new CommandList();
        for(Command command : commands) {
            if(command.startsWith(consoleInput)) {
                autoCompletionList.add(command);
            }
        }
        this.autoCompleteList = autoCompletionList;
    }

    public void toggleAlpha() {
        this.alpha = !this.alpha;
    }

    public void setMessageCount(int count) {
        this.messageCount = count;
    }

    public void log(int i) {
        log(String.valueOf(i));
    }

    public void addCommand(String command, String help) {
        int index = this.commands.indexOf(command.toLowerCase());
        if(index == -1) {
            commands.add(new ServerCommand(command, help));
        }
    }
}
