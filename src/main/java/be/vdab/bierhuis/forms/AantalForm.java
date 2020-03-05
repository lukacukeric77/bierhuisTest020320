package be.vdab.bierhuis.forms;

import java.math.BigInteger;

public class AantalForm {
    private final BigInteger aantal;

    public AantalForm(BigInteger aantal) {
        this.aantal = aantal;
    }

    public BigInteger getAantal() {
        return aantal;
    }
}
