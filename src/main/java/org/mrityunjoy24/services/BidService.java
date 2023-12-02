package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.models.Event;
import org.mrityunjoy24.models.Registration;
import org.mrityunjoy24.models.User;
import org.mrityunjoy24.repositories.BidRepository;
import org.mrityunjoy24.repositories.IRepository;

import java.util.Date;
import java.util.List;

public class BidService implements IBidService {
    private int id = 1;
    private final IRepository registrationRepository, winnerRepository;
    private final BidRepository bidRepository;
    private final IEventService eventService;
    private final IUserService userService;

    public BidService(BidRepository bidRepository, IUserService userService, IEventService eventService, IRepository registrationRepository,IRepository winnerRepository ) {
        this.bidRepository = bidRepository;
        this.eventService = eventService;
        this.userService = userService;
        this.registrationRepository = registrationRepository;
        this.winnerRepository = winnerRepository;
    }
    @Override
    public Bid submitBid(int memberId, int eventId, List<Integer> amount) {
        User user = userService.getUserById(memberId);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + memberId);
        }
        Event event = (Event) eventService.getEventById(eventId);

        if (event == null) {
            throw new RuntimeException("Event not found with id: " + eventId);
        }

        List<Registration> registrations = registrationRepository.getAll();

        if (registrations.stream().noneMatch(registration -> registration.getEvent().getId() == eventId && registration.getUser().getId() == memberId)) {
            throw new RuntimeException("User with id: " + memberId + " not registered for event id: " + eventId);
        }

        Bid bid = new Bid(id++, user, event, amount, new Date());
        bidRepository.save(bid);

        return bid;
    }

    @Override
    public Bid declareWinner(int eventId){

        List<Bid> bids = bidRepository.getBidsByEventId(eventId);

        int minBid = Integer.MAX_VALUE;
        Bid winnerBid = null;

        for(Bid bid : bids){
            int bidAmount = bid.getBidAmounts().get(0);
            if(bidAmount < minBid){
                minBid = bidAmount;
                winnerBid = bid;
            }
            else if(bidAmount == minBid && bid.getCreatedAt().before(winnerBid.getCreatedAt())) {
                winnerBid = bid;
            }
        }

        if(winnerBid == null){
            throw new RuntimeException("No bids found for event id: " + eventId);
        }

        winnerRepository.save(winnerBid);
        return winnerBid;
    }
}
