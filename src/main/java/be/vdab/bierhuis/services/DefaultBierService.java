package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.BierBrouwerAmalgam;
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
    public List<Bier> findAllBierenByIdOfBrouwer(long id) {
        return bierRepository.findAllBierenByIdOfBrouwer(id);
    }

}
