package org.example.model;

import java.math.BigDecimal;
import java.util.Comparator;

public class Bid implements Comparator<Bid> {
    private final Bidder bidder;
    private final BigDecimal biddingPrice;

    public Bid(Bidder bidder, BigDecimal biddingPrice) {
        this.bidder = bidder;
        this.biddingPrice = biddingPrice;
    }

    public Bidder getBidder() {
        return bidder;
    }


    public BigDecimal getBiddingPrice() {
        return biddingPrice;
    }

    @Override
    public int compare(Bid b1, Bid b2) {
        return b2.biddingPrice.compareTo(b1.biddingPrice);
    }

}
