package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Brouwer;
import be.vdab.bierhuis.repositories.BrouwerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultBreuwerService implements BrouwersService {

    private final BrouwerRepository repository;

    public DefaultBreuwerService(BrouwerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brouwer> findAllBrouwers() {
        return repository.findAllBrouwers();
    }

    @Override
    public Optional<Brouwer> findBrewerByItsId(long id) {
        return repository.findBrewerByItsId(id);
    }
}
