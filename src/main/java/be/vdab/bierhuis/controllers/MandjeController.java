package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.services.BestelbonLijnService;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final BestelbonLijnService bestelbonLijnService;
    private final BierService bierService;

    public MandjeController(Mandje mandje, BestelbonLijnService bestelbonLijnService, BierService bierService) {
        this.mandje = mandje;
        this.bestelbonLijnService = bestelbonLijnService;
        this.bierService = bierService;
    }

    @GetMapping
    public ModelAndView showMandje() {
        ModelAndView modelAndView = new ModelAndView("mandje");
        Set<Long> keys = mandje.getKeys();
        Map<Long, Bier> aantalsWithBiers = new LinkedHashMap<>();
        for (Long key : keys) {
            Optional<Bier> optionalBier = bierService.findBierById(key);
            optionalBier.ifPresent(bier -> aantalsWithBiers.put(mandje.getAantal(key), bier));
        }
        modelAndView.addObject("aantalsWithBiers", aantalsWithBiers);
//        modelAndView.addObject("mandje", mandje.getMandje());


        return modelAndView;
    }


}
