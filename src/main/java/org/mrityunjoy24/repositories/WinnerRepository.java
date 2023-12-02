package org.mrityunjoy24.repositories;

import org.mrityunjoy24.models.Bid;

import java.util.ArrayList;
import java.util.List;

public class WinnerRepository implements IRepository<Bid>{
    private List<Bid> winnerList = new ArrayList<>();
    @Override
    public void save(Bid winnerBid) {
        winnerList.add(winnerBid);
    }

    @Override
    public Bid getById(int id) {
        return null;
    }

    @Override
    public List<Bid> getAll() {
        return winnerList;
    }
}
