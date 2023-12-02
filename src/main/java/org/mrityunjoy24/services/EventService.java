package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.models.Event;
import org.mrityunjoy24.repositories.IRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EventService implements IEventService{
    private IRepository eventRepository, winnerRepository;


    public EventService(IRepository eventRepository, IRepository winnerRepository) {
        this.eventRepository = eventRepository;
        this.winnerRepository = winnerRepository;
    }

    @Override
    public Event createEvent(int id, String name, String prize, Date date) {
        Event event = new Event(id, name, prize, date);
        eventRepository.save(event);

        return event;
    }

    @Override
    public Event getEventById(int eventId) {
        return (Event) eventRepository.getById(eventId);
    }

    @Override
    public String listWinners(String orderBy) {
        List<Bid> winnerBids = winnerRepository.getAll();

        if (orderBy.equals("asc")) {
            winnerBids.sort((o1, o2) -> o1.getEvent().getEventDate().before(o2.getEvent().getEventDate()) ? -1 : 1);
        } else if (orderBy.equals("desc")) {
            winnerBids.sort((o1, o2) -> o1.getEvent().getEventDate().after(o2.getEvent().getEventDate()) ? -1 : 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Bid bid : winnerBids) {

            String date = new SimpleDateFormat("yyyy-MM-dd").format(bid.getEvent().getEventDate());
            sb.append("{")
                    .append(bid.getEvent().getId()).append(", ")
                    .append(bid.getUser().getName()).append(", ")
                    .append(bid.getBidAmounts().get(0)).append(", ")
                    .append(date)
                    .append("}\n");
        }

        return sb.toString();
    }
}
