package org.mrityunjoy24.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandInvoker {

    private Map<String, ICommands> commandsMap = new HashMap<>();

    public void addCommand(String commandName,ICommands command){
        commandsMap.put(commandName,command);
    }

    public ICommands getCommandByName(String commandName){
        return commandsMap.get(commandName);
    }
}
