package be.vdab.bierhuis.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AantalForm {
    private final long aantal;
//    private final long idOfBier;

    public AantalForm(long aantal) {
        this.aantal = aantal;
//        this.idOfBier = idOfBier;
    }

    @NotNull @Positive
    public long getAantal() {
        return aantal;
    }

//    public long getIdOfBier() {
//        return idOfBier;
//    }

}
