package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;

import java.util.List;
import java.util.Optional;

public interface BierService {

    long findAantalBieren();
    List<Bier> findAllBierenByIdOfBrouwer (long id);
    Optional<Bier> findBierById(long id);
    void updateBesteldInBier(long ammount, long id);
}
