package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bestelbonlijn;

import java.util.List;

public interface BestelBonLijnenRepository {

    void create(Bestelbonlijn bestelbonlijn);
}
