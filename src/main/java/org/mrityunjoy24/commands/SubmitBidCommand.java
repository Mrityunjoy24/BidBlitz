package org.mrityunjoy24.commands;

import org.mrityunjoy24.models.Bid;
import org.mrityunjoy24.services.IBidService;

import java.util.List;

public class SubmitBidCommand implements ICommands{

    private IBidService bidService;

    public SubmitBidCommand(IBidService bidService) {
        this.bidService = bidService;
    }
    @Override
    public String execute(List<String> tokens) throws Exception {
        int memberId = Integer.parseInt(tokens.get(1));
        int eventId = Integer.parseInt(tokens.get(2));
        List<Integer> amount = tokens.subList(3, tokens.size()).stream().map(Integer::parseInt).toList();
        if(amount.isEmpty())
            throw new RuntimeException("Bid amount cannot be empty");

        Bid bid =  bidService.submitBid(memberId, eventId, amount);
        return "BIDS submitted successfully";
    }
}
