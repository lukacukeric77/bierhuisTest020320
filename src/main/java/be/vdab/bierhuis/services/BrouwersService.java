package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Brouwer;

import java.util.List;
import java.util.Optional;

public interface BrouwersService {

    List<Brouwer> findAllBrouwers();
    Optional<Brouwer> findBrewerByItsId(long id);

}
