package be.vdab.bierhuis.services;

import be.vdab.bierhuis.domain.Bestelbon;
import org.springframework.stereotype.Service;

@Service
public interface BestelBonService {

    long create(Bestelbon bestelbon);

}
