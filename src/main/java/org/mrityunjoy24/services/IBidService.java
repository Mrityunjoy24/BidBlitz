package org.mrityunjoy24.services;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.models.User;

import java.util.List;

public interface IBidService {
    Bid submitBid(int memberId, int eventId, List<Integer> amount);

    Bid declareWinner(int eventId);
}
