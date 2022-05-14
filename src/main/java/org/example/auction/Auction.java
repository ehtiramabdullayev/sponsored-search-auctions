package org.example.auction;

import org.example.model.Bid;
import org.example.model.Slot;

import java.util.List;
import java.util.Optional;

public interface Auction {
    void placeBid(Bid bid, Slot slot);

    List<Bid> getAllBidsForSlot(Slot slot);

    Optional<Bid> getWinningBetForSlot(Slot slot);

}
