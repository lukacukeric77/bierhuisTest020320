package be.vdab.bierhuis.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.math.BigInteger;

public class AantalForm {
    private final Long aantal;

    public AantalForm(Long aantal) {
        this.aantal = aantal;
    }

    @NotNull @Positive
    public Long getAantal() {
        return aantal;
    }
}
