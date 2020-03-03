package be.vdab.bierhuis.repositories;

import be.vdab.bierhuis.domain.Brouwer;

import java.util.List;
import java.util.Optional;

public interface BrouwerRepository {

    List<Brouwer> findAllBrouwers();
    Optional<Brouwer> findBrewerByItsId(long id);

}
