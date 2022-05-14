package org.example.model;

import java.math.BigDecimal;

public class Slot {
    private final String id;
    private final String title;
    private final String description;
    private final String hyperLink;
    private final BigDecimal rate;

    public Slot(String id, String title, String description, String hyperLink, BigDecimal rate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.hyperLink = hyperLink;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getHyperLink() {
        return hyperLink;
    }

    public BigDecimal getRate() {
        return rate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
