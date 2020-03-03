package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Brouwer;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface BrouwersService {

    List<Brouwer> findAll();
    Optional<Brouwer> findById();

}
