package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.repositories.BestelBonLijnenRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBestelbonLijnService implements BestelbonLijnService {

    private final BestelBonLijnenRepository repository;

    public DefaultBestelbonLijnService(BestelBonLijnenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Bestelbonlijn bestelbonlijn) {
       repository.create(bestelbonlijn);
    }

    @Override
    public List<Bestelbonlijn> findAll() {
        return repository.findAll();
    }
}