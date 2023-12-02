package org.mrityunjoy24.commands;

import org.mrityunjoy24.services.IEventService;

import java.util.List;

public class ListWinnerCommand implements ICommands{
    private IEventService eventService;

    public ListWinnerCommand(IEventService eventService) {
        this.eventService = eventService;
    }
    @Override
    public String execute(List<String> tokens) throws Exception {
        String orderBy = tokens.get(1);
        return eventService.listWinners(orderBy);
    }
}
