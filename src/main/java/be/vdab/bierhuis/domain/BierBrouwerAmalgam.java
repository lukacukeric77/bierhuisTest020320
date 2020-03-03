package be.vdab.bierhuis.domain;

import java.math.BigDecimal;

public class BierBrouwerAmalgam {

    private final long BierId;
    private final String BierNaam;
    private final long BierBrouwerId;
    private final long BierSoortId;
    private final BigDecimal BierAlcohol;
    private final BigDecimal BierPrijs;
    private final long BierBesteld;
    private final long BrouwerId;
    private final String BrouwerNaam;
    private final String BrouwerStraat;
    private final String BrouwerHuisNr;
    private final int BrouwerPostcode;
    private final String BrouwerGemeente;
    private final BigDecimal BrouwerOmzet;


    public BierBrouwerAmalgam(long bierId, String bierNaam, long bierBrouwerId, long bierSoortId, BigDecimal bierAlcohol, BigDecimal bierPrijs, long bierBesteld,
                              long brouwerId, String brouwerNaam, String brouwerStraat, String brouwerHuisNr, int brouwerPostcode, String brouwerGemeente, BigDecimal brouwerOmzet) {
        BierId = bierId;
        BierNaam = bierNaam;
        BierBrouwerId = bierBrouwerId;
        BierSoortId = bierSoortId;
        BierAlcohol = bierAlcohol;
        BierPrijs = bierPrijs;
        BierBesteld = bierBesteld;
        BrouwerId = brouwerId;
        BrouwerNaam = brouwerNaam;
        BrouwerStraat = brouwerStraat;
        BrouwerHuisNr = brouwerHuisNr;
        BrouwerPostcode = brouwerPostcode;
        BrouwerGemeente = brouwerGemeente;
        BrouwerOmzet = brouwerOmzet;
    }

    public long getBierId() {
        return BierId;
    }

    public String getBierNaam() {
        return BierNaam;
    }

    public long getBierBrouwerId() {
        return BierBrouwerId;
    }

    public long getBierSoortId() {
        return BierSoortId;
    }

    public BigDecimal getBierAlcohol() {
        return BierAlcohol;
    }

    public BigDecimal getBierPrijs() {
        return BierPrijs;
    }

    public long getBierBesteld() {
        return BierBesteld;
    }

    public long getBrouwerId() {
        return BrouwerId;
    }

    public String getBrouwerNaam() {
        return BrouwerNaam;
    }

    public String getBrouwerStraat() {
        return BrouwerStraat;
    }

    public String getBrouwerHuisNr() {
        return BrouwerHuisNr;
    }

    public int getBrouwerPostcode() {
        return BrouwerPostcode;
    }

    public String getBrouwerGemeente() {
        return BrouwerGemeente;
    }

    public BigDecimal getBrouwerOmzet() {
        return BrouwerOmzet;
    }
}
