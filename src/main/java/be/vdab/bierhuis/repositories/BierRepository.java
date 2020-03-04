package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.BierBrouwerAmalgam;
import be.vdab.bierhuis.domain.Brouwer;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BierRepository {

    long findAantalBieren();
    List<Bier> findAllBierenByIdOfBrouwer(long id);
    Optional<Bier> findBierById(long id);



}
