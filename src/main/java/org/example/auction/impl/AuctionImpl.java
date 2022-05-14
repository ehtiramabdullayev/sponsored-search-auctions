package org.example.auction.impl;

import org.example.auction.Auction;
import org.example.model.Bid;
import org.example.model.Slot;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuctionImpl implements Auction {
    private final Map<Slot, List<Bid>> biddingMap;

    public AuctionImpl() {
        this.biddingMap = new ConcurrentHashMap<>();
    }


    @Override
    public void placeBid(Bid bid, Slot slot) {
        if (bid == null || slot == null || bid.getBidder() == null) throw new RuntimeException("Invalid bid or slot! ");

        Optional<Bid> winningBid = getWinningBetForSlot(slot);
        if (winningBid.isPresent() && bid.getBiddingPrice().compareTo(winningBid.get().getBiddingPrice()) < 0) {
            throw new RuntimeException("Bid on item is too low! It should be more than winning bid!");
        } else {
            List<Bid> slotBids = biddingMap.getOrDefault(slot, new LinkedList<>());
            slotBids.add(bid);
            biddingMap.put(slot, slotBids);
        }

    }

    @Override
    public List<Bid> getAllBidsForSlot(Slot slot) {
        if (slot == null) throw new RuntimeException("Invalid slot! ");
        return biddingMap.getOrDefault(slot, new ArrayList<>());
    }


    @Override
    public Optional<Bid> getWinningBetForSlot(Slot slot) {
        final List<Bid> placedBids = biddingMap.get(slot);
        if (placedBids == null) {
            return Optional.empty();
        }
        return Optional.of(placedBids
                .stream()
                .max(Comparator.comparing(Bid::getBiddingPrice))
                .get());
    }
}
