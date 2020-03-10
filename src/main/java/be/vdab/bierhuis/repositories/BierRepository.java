package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;

import java.util.List;
import java.util.Optional;

public interface BierRepository {

    long findAantalBieren();
    List<Bier> findAllBierenByIdOfBrouwer(long id);
    Optional<Bier> findBierById(long id);
    void updateBesteldInBier(long ammount, long id);
}
