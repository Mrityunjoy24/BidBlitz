package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Event;

import java.util.Date;

public interface IEventService {
    Event createEvent(int id, String name, String prize, Date date);

    Object getEventById(int eventId);

    String listWinners(String orderBy);
}
