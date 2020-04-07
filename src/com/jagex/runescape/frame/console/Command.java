package com.jagex.runescape.frame.console;

public abstract class Command {
    private String command;
    private String commands[];
    private boolean hasMultiple = false;
    private String description;

    public Command(String command, String description) {
        this.command = command;
        this.description = description;
    }

    public Command(String[] commands, String description) {
        this.commands = commands;
        this.hasMultiple = true;
        this.description = description;
    }

    public boolean startsWith(String str) {
        if(!hasMultiple) {
            return this.command.startsWith(str);
        }
        for(String command : this.commands) {
            if(command.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    public String getPrintableHelp() {
        StringBuilder info = new StringBuilder();
        if(hasMultiple) {
            info.append("<col=00FF00>");
            boolean first = true;
            for(String command : this.commands) {
                if(!first) {
                    info.append(" | ");
                }
                info.append(command);
                first = false;
            }
            info.append("</col>");
        } else {
            info.append("<col=00FF00>").append(this.command).append("</col>");
        }
        info.append(" - ");
        info.append("<col=00FF00>").append(this.description).append("</col>");
        return info.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Command) {
            return obj == this;
        }
        if(obj instanceof String) {
            if(!hasMultiple) {
                return this.command.equals(obj);
            }
            for(String command : this.commands) {
                if(command.equals(obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public abstract void execute(Console console, String[] cmdInput);

    public String getCommand(){
        if(!hasMultiple) {
            return this.command;
        }

        return this.commands[0];
    }
}
