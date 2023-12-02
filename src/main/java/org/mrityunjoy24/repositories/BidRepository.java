package org.mrityunjoy24.repositories;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.models.Registration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BidRepository implements IRepository<Bid>{

    private Map<Integer, Bid> bidsMap = new HashMap<>();
    private Map<Integer, List<Bid>> bidsByEventId = new HashMap<>();
    @Override
    public void save(Bid bid) {
        bidsMap.put(bid.getId(), bid);
        List<Bid> bidsByEvent = bidsByEventId.getOrDefault(bid.getEvent().getId(), new ArrayList<>());
        bidsByEvent.add(bid);
        bidsByEventId.put(bid.getEvent().getId(), bidsByEvent);
    }

    @Override
    public Bid getById(int id) {
        return bidsMap.get(id);
    }

    @Override
    public List<Bid> getAll() {
        List<Bid> bids = new ArrayList<>();
        //iterate over the map and get all the registrations
        for(Map.Entry<Integer, Bid> entry : bidsMap.entrySet()){
            bids.add(entry.getValue());
        }
        return bids;
    }

    public List<Bid> getBidsByEventId(int eventId){
        return bidsByEventId.get(eventId);
    }
}
