package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.services.BestelBonService;
import be.vdab.bierhuis.services.BestelbonLijnService;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final BestelbonLijnService bestelbonLijnService;
    private final BierService bierService;
    private final BestelBonService bestelBonService;
    private Set<Bestelbonlijn> bestelbonlijnSet = new LinkedHashSet<>();

    public MandjeController(Mandje mandje, BestelbonLijnService bestelbonLijnService,
                            BierService bierService, BestelBonService bestelBonService) {
        this.mandje = mandje;
        this.bestelbonLijnService = bestelbonLijnService;
        this.bierService = bierService;
        this.bestelBonService = bestelBonService;
    }

    @GetMapping
    public ModelAndView showMandje() {
        ModelAndView modelAndView = new ModelAndView("mandje");
        Set<Long> keys = mandje.getKeys();
        Map<Bier, Long> aantalsWithBiers = new LinkedHashMap<>();
        for (Long key : keys) {
            Optional<Bier> optionalBier = bierService.findBierById(key);
            optionalBier.ifPresent(bier -> {
                aantalsWithBiers.put(bier, mandje.getAantal(key));
                Bestelbonlijn bestelbonlijn = new Bestelbonlijn(0, bier.getId(),
                        mandje.getAantal(key), bier.getPrijs());
                bestelbonlijnSet.add(bestelbonlijn);
            });

        }
        modelAndView.addObject("aantalsWithBiers", aantalsWithBiers);
        modelAndView.addObject("bestelbonForm", new Bestelbon(0, "",
                "", "", 0, ""));

        return modelAndView;
    }

    @PostMapping("form")
    public ModelAndView bestelbonForm(@Valid Bestelbon bestelbon, Errors errors, HttpSession session){
        if (errors.hasErrors()){
//            return "redirect:/brouwers"; // change, brouwers is here to notify mistake
            return null;
        }
        long idBestelBon = bestelBonService.create(bestelbon);
        for (Bestelbonlijn bestelbonlijn : bestelbonlijnSet){
            bestelbonlijn.setBestelbonid(idBestelBon);
        }
            ModelAndView modelAndView = new ModelAndView("check", "bestelbonlijst", bestelbonlijnSet);
                session.invalidate();
            return modelAndView;
//            bestelbonLijnService.create(bestelbonlijn);
//        }
//        session.invalidate();
//        return "redirect:/";  // change to what is required
//        return null;

    }


}
