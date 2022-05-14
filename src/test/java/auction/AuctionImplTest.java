package auction;

import org.example.auction.impl.AuctionImpl;
import org.example.model.Bid;
import org.example.model.Bidder;
import org.example.model.Slot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AuctionImplTest {
    private AuctionImpl auction;

    @BeforeEach
    public void beforeEach() {
        auction = new AuctionImpl();
    }

    @Test
    public void placeBidWhenBidIsValidSuccess() {

        Bidder bidder = new Bidder("1");
        Bid bid = new Bid(bidder, new BigDecimal("10"));
        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));

        auction.placeBid(bid, slot1);

        List<Bid> bidList = auction.getAllBidsForSlot(slot1);
        assertNotNull(bidList);
        assertEquals(bidder.getId(), bidList.get(0).getBidder().getId());
    }

    @Test
    public void placeBidWhenBidIsNotValidFails() {
        Bid bid = null;
        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            auction.placeBid(bid, slot1);

        });
        assertTrue(exception.getMessage().contains("Invalid bid or slot! "));
    }

    @Test
    public void placeBidsWhenBidIsLessThanMaxBidFails() {

        Bidder bidder = new Bidder("1");
        Bidder bidder2 = new Bidder("2");

        Bid bid2 = new Bid(bidder2, new BigDecimal("0.7"));

        Bid bid = new Bid(bidder, new BigDecimal("10"));
        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));

        auction.placeBid(bid, slot1);
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            auction.placeBid(bid2, slot1);

        });
        assertTrue(exception.getMessage().contains("Bid on item is too low! It should be more than winning bid!"));
    }

    @Test
    public void placeBidsWhenBidIsMoreThanMaxBidSuccess() {
        Bidder bidder = new Bidder("1");
        Bidder bidder2 = new Bidder("2");

        Bid bid = new Bid(bidder, new BigDecimal("10"));
        Bid bid2 = new Bid(bidder2, new BigDecimal("11"));

        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));

        auction.placeBid(bid, slot1);
        auction.placeBid(bid2, slot1);
        Optional<Bid> winningBetForSlot = auction.getWinningBetForSlot(slot1);
        assertEquals(bid2.getBidder(), winningBetForSlot.get().getBidder());
    }


    @Test
    public void getAllBidsForSlotIfPlacedCorrectlySuccess() {
        Bidder bidder = new Bidder("1");
        Bidder bidder2 = new Bidder("2");
        Bidder bidder3 = new Bidder("3");
        Bidder bidder4 = new Bidder("4");

        Bid bid = new Bid(bidder, new BigDecimal("10"));
        Bid bid2 = new Bid(bidder2, new BigDecimal("11"));
        Bid bid3 = new Bid(bidder3, new BigDecimal("12"));
        Bid bid4 = new Bid(bidder4, new BigDecimal("13"));

        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));

        auction.placeBid(bid, slot1);
        auction.placeBid(bid2, slot1);
        auction.placeBid(bid3, slot1);
        auction.placeBid(bid4, slot1);

        List<Bid> allBidsForSlot = auction.getAllBidsForSlot(slot1);
        assertEquals(4, allBidsForSlot.size());
    }


    @Test
    public void getMaximumBestForSlotSuccess() {
        Bidder bidder = new Bidder("1");
        Bidder bidder2 = new Bidder("2");
        Bidder bidder3 = new Bidder("3");
        Bidder bidder4 = new Bidder("4");

        Bid bid = new Bid(bidder, new BigDecimal("10"));
        Bid bid2 = new Bid(bidder2, new BigDecimal("11"));
        Bid bid3 = new Bid(bidder3, new BigDecimal("12"));
        Bid bid4 = new Bid(bidder4, new BigDecimal("13"));

        Slot slot1 = new Slot("slot1", "advert1", "slot1", "http://aa.com", new BigDecimal("0.5"));

        auction.placeBid(bid, slot1);
        auction.placeBid(bid2, slot1);
        auction.placeBid(bid3, slot1);
        auction.placeBid(bid4, slot1);

        Optional<Bid> allBidsForSlot = auction.getWinningBetForSlot(slot1);
        assertEquals(bidder4, allBidsForSlot.get().getBidder());
    }
}
