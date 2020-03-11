package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.repositories.BestelBonLijnenRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultBestelbonLijnService implements BestelbonLijnService {

    private final BestelBonLijnenRepository repository;

    public DefaultBestelbonLijnService(BestelBonLijnenRepository repository) {
        this.repository = repository;
    }

    @Override
    public void create(Bestelbonlijn bestelbonlijn) {
       repository.create(bestelbonlijn);
    }

}
