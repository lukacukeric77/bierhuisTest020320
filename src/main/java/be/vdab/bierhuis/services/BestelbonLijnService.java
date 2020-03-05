package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbonlijn;

import java.util.List;

public interface BestelbonLijnService {

    void create(Bestelbonlijn bestelbonlijn);
    List<Bestelbonlijn> findAll();

}
