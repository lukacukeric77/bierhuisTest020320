package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierService {

    long findAantalBieren();
    Optional<Bier> findById (long id);
    void update(Bier bier);
    List<Bier> findByIds(Set<Long> ids);
    List<Bier> findByNaam(String naam);

}
