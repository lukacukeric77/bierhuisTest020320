package be.vdab.bierhuis.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class Bestelbonlijn {

    private final long bestelbonid;
    private final long bierid;
    private final BigInteger aantal;
    private final BigDecimal prijs;

    public Bestelbonlijn(long bestelbonid, long bierid, BigInteger aantal, BigDecimal prijs) {
        this.bestelbonid = bestelbonid;
        this.bierid = bierid;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    public long getBestelbonid() {
        return bestelbonid;
    }

    public long getBierid() {
        return bierid;
    }

    public BigInteger getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }
}
