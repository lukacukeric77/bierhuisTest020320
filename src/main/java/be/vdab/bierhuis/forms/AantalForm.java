package be.vdab.bierhuis.forms;

import java.util.concurrent.atomic.AtomicInteger;

public class AantalForm {
    private final AtomicInteger aantal;

    public AantalForm(AtomicInteger aantal) {
        this.aantal = aantal;
    }

    public AtomicInteger getAantal() {
        return aantal;
    }
}
