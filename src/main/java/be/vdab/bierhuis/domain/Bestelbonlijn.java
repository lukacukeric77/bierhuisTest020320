package be.vdab.bierhuis.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicInteger;

public class Bestelbonlijn {

    private long bestelbonid;
    private final long bierid;
    private final long aantal;
    private final BigDecimal prijs;

    public Bestelbonlijn(long bestelbonid, long bierid, long aantal, BigDecimal prijs) {
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

    public long getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public void setBestelbonid(long bestelbonid) {
        this.bestelbonid = bestelbonid;
    }
}
