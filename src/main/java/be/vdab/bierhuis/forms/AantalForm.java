package be.vdab.bierhuis.forms;

import java.math.BigDecimal;
import java.math.BigInteger;

public class AantalForm {
    private final long aantal;
    private final long idOfBier;

    public AantalForm(long aantal, long idOfBier) {
        this.aantal = aantal;
        this.idOfBier = idOfBier;
    }

    public long getAantal() {
        return aantal;
    }

    public long getIdOfBier() {
        return idOfBier;
    }

}
