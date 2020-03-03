package be.vdab.bierhuis.domain;

import java.math.BigDecimal;

public class Bier {

    private final long id;
    private final String naam;
    private final long brouwerId;
    private final long soortId;
    private final BigDecimal alcohol;
    private final BigDecimal prijs;
    private final long besteld;

    public Bier(long id, String naam, long brouwerId, long soortId, BigDecimal alcohol, BigDecimal prijs, long besteld) {
        this.id = id;
        this.naam = naam;
        this.brouwerId = brouwerId;
        this.soortId = soortId;
        this.alcohol = alcohol;
        this.prijs = prijs;
        this.besteld = besteld;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public long getBrouwerId() {
        return brouwerId;
    }

    public long getSoortId() {
        return soortId;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getBesteld() {
        return besteld;
    }
}
