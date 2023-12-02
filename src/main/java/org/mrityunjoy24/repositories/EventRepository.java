package org.mrityunjoy24.repositories;

import org.mrityunjoy24.models.Event;
import org.mrityunjoy24.models.Registration;
import org.mrityunjoy24.models.User;

import java.util.*;

public class EventRepository implements IRepository<Event>{

    private Map<Integer, Event> eventsMap = new HashMap<>();
    private Map<Date, Event> eventsMapByDate = new HashMap<>();
    @Override
    public void save(Event event) {
        eventsMap.put(event.getId(), event);
        eventsMapByDate.put(event.getEventDate(), event);
    }

    @Override
    public Event getById(int id) {
        return eventsMap.get(id);
    }

    @Override
    public List<Event> getAll() {
        List<Event> events = new ArrayList<>();
        //iterate over the map and get all the registrations
        for(Map.Entry<Integer, Event> entry : eventsMap.entrySet()){
            events.add(entry.getValue());
        }
        return events;
    }

    public Event getByDate(Date date) {
        return eventsMapByDate.get(date);
    }
}
