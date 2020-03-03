package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.repositories.BierRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class DefaultBierService implements BierService {

    private final BierRepository bierRepository;

    public DefaultBierService(BierRepository bierRepository) {
        this.bierRepository = bierRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public long findAantalBieren() {
        return bierRepository.findAantalBieren();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Bier> findById(long id) {
        return bierRepository.findById(id);
    }

    @Override
    public void update(Bier bier) {
        bierRepository.update(bier);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Bier> findByIds(Set<Long> ids) {
        return bierRepository.findByIds(ids);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Bier> findByNaam(String naam) {
        return bierRepository.findByNaam(naam);
    }
}
