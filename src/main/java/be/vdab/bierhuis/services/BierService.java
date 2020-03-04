package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.BierBrouwerAmalgam;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierService {

    long findAantalBieren();
    List<Bier> findAllBierenByIdOfBrouwer (long id);
    Optional<Bier> findBierById(long id);
}
