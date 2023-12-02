package org.mrityunjoy24.commands;

import java.util.List;

public interface ICommands {
    String execute(List<String> tokens) throws Exception;
}