package org.mrityunjoy24.commands;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.models.User;
import org.mrityunjoy24.services.IBidService;

import java.util.List;

public class DeclareWinnerCommand implements ICommands{

    private IBidService bidService;
    public DeclareWinnerCommand(IBidService bidService) {
        this.bidService = bidService;
    }

    @Override
    public String execute(List<String> tokens) throws Exception {
        String id = tokens.get(1);
        int eventId = Integer.parseInt(id);
        Bid bid = bidService.declareWinner(eventId);
        //Akshay wins the IPHONE-14 with lowest bid 100
        return bid.getUser().getName() + " wins the " + bid.getEvent().getPrize() + " with lowest bid " + bid.getBidAmounts().get(0);
    }
}
