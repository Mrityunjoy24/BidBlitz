package org.mrityunjoy24.commands;

import org.mrityunjoy24.models.Event;
import org.mrityunjoy24.services.IEventService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AddEventCommand implements ICommands{
    private IEventService eventService;
    public AddEventCommand(IEventService eventService) {
        this.eventService = eventService;
    }
    @Override
    public String execute(List<String> tokens) throws Exception {
        int id = Integer.parseInt(tokens.get(1));
        String name = tokens.get(2);
        String prize = tokens.get(3);
        String date = tokens.get(4);

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);

        Event event = eventService.createEvent(id, name, prize, date1);
        return event.getName() + " with prize " + event.getPrize() + " added successfully";
    }
}
