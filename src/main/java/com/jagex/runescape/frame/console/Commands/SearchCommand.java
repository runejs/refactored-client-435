package com.jagex.runescape.frame.console.Commands;

import com.jagex.runescape.cache.def.ActorDefinition;
import com.jagex.runescape.cache.def.EntityDefinition;
import com.jagex.runescape.cache.def.GameObjectDefinition;
import com.jagex.runescape.cache.def.ItemDefinition;
import com.jagex.runescape.cache.media.gameInterface.GameInterface;
import com.jagex.runescape.frame.console.Command;
import com.jagex.runescape.frame.console.Console;

public class SearchCommand extends Command {
    private static final int maxResults = 300;
    private int results;
    public SearchCommand() {
        super("search", "Returns list of results");
    }

    @Override
    public void execute(Console console, String[] cmdInput) {
        if(cmdInput[1].equalsIgnoreCase("size")) {
            console.log("<col=FFFF00>Items loaded: "+ ItemDefinition.count +"</col>");
            console.log("<col=FFFF00>Npcs loaded: "+ ActorDefinition.count +"</col>");
            console.log("<col=FFFF00>Objects loaded: "+ GameObjectDefinition.count +"</col>");

        }
        if(cmdInput.length <= 2) {
            console.log("<col=FFA500>Usage: search [item|npc|object|widget] [name]</col>");
            return;
        }
        console.log("<col=FFFF00>Searching...</col>");

        results = 0;
        switch(cmdInput[1].toLowerCase()) {
            case "item":
            case "items":
            case "i":
                for(int itemId = 0; ItemDefinition.count > itemId; itemId++) {
                    ItemDefinition definition = ItemDefinition.forId(itemId, 10);
                    if(definition.noteTemplateId == -1) {
                        filterAndAddDefinition(itemId, definition, cmdInput, console);
                        if(results >= maxResults)
                            break;
                    }
                }
                break;
            case "npc":
            case "npcs":
            case "n":
                for(int npcId = 0; ActorDefinition.count > npcId; npcId++) {
                    ActorDefinition definition = ActorDefinition.getDefinition(npcId);
                    filterAndAddDefinition(npcId, definition, cmdInput, console);
                    if(results >= maxResults)
                        break;
                }
                break;
            case "object":
            case "objects":
            case "o":
                for(int objectId = 0; GameObjectDefinition.count > objectId; objectId++) {
                    GameObjectDefinition definition = GameObjectDefinition.getDefinition(objectId);
                    filterAndAddDefinition(objectId, definition, cmdInput, console);
                    if(results >= maxResults)
                        break;
                }
                break;
            case "widget":
            case "widgets":
            case "w":
                for (int qq = 0; qq < 469; qq++) {
                    if (GameInterface.decodeGameInterface(qq)) {
                        GameInterface[] gameInterfaces = GameInterface.cachedInterfaces[qq];
                        for (int y = 0; gameInterfaces.length > y; y++) {
                            GameInterface gameInterface = gameInterfaces[y];
                            if (gameInterface.disabledText != null) {
                                String text = gameInterface.disabledText.toString().toLowerCase();
                                for(int indx = 2; indx < cmdInput.length; indx++) {
                                    if(text.contains(cmdInput[indx].toLowerCase())) {
                                        console.log("<col=FFFF00>" + text + " - " + qq + ":"+y+"</col>");
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                break;
        }
    }

    private void filterAndAddDefinition(int id, EntityDefinition def, String[] searchTerms, Console console) {
        if(def.getName() != null) {
            String itemNameString = def.getName().toLowerCase();
            for(int indx = 2; indx < searchTerms.length; indx++) {
                if(!itemNameString.contains(searchTerms[indx].toLowerCase()))
                    return;
            }
            console.log("<col=FFFF00>" + def.getName() + " - " + id + "</col>");
            results++;
        }
    }
}
