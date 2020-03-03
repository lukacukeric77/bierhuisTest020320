package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.Brouwer;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierRepository {

    long findAantalBieren();
    Optional<Bier> findById (long id);
    void update(Bier bier);
    List<Bier> findByIds(Set<Long> ids);
    List<Bier> findByNaam(String naam);


}
