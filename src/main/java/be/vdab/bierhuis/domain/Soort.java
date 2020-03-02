package be.vdab.bierhuis.domain;

public class Soort {

    private final long id;
    private final String naam;

    public Soort(long id, String naam) {
        this.id = id;
        this.naam = naam;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
