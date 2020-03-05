package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bestelbonlijn;

public interface BestelBonLijnenRepository {

    void create(Bestelbonlijn bestelbonlijn);
}
