package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.repositories.BestelBonRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultBestelBonService implements BestelBonService{

    private final BestelBonRepository repository;

    public DefaultBestelBonService(BestelBonRepository repository) {
        this.repository = repository;
    }

    @Override
    public long create(Bestelbon bestelbon) {
        return repository.createBestelBon(bestelbon);
    }
}
