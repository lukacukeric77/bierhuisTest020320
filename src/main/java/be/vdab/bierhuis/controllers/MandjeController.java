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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("mandje")
class MandjeController {
    private final Mandje mandje;
    private final BestelbonLijnService bestelbonLijnService;
    private final BierService bierService;
    private final BestelBonService bestelBonService;
    private List<Bestelbonlijn> bestelbonlijnSet = new LinkedList<>();

    public MandjeController(Mandje mandje, BestelbonLijnService bestelbonLijnService,
                            BierService bierService, BestelBonService bestelBonService) {
        this.mandje = mandje;
        this.bestelbonLijnService = bestelbonLijnService;
        this.bierService = bierService;
        this.bestelBonService = bestelBonService;
    }

    @GetMapping
    public ModelAndView showMandje() {
        ModelAndView modelAndView = bestelBonGeneration();
        modelAndView.addObject(new Bestelbon(0, "",
                "", "", 0, ""));

        return modelAndView;
    }

    @PostMapping("form")
    public ModelAndView bestelbonForm(@Valid Bestelbon bestelbon,
                                Errors errors,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {

        if (errors.hasErrors()) {
            return bestelBonGeneration();
        }

        if (mandje.isFilled()) {                                                                        //if mandje is not empty...
            long idBestelBon = bestelBonService.create(bestelbon);                                      //...create a bestelbon in repository and get his id...
            for (Bestelbonlijn bestelbonlijn : bestelbonlijnSet) {                                      //...for each item in mandje...
                bestelbonlijn.setBestelbonid(idBestelBon);                                              //... add to each just created bestelbon's id on bestelbon.id...
                bestelbonLijnService.create(bestelbonlijn);                                             //... create a bestelbonlijn in repository...
                bierService.updateBesteldInBier(bestelbonlijn.getAantal(), bestelbonlijn.getBierid());  //... increase besteld on selected bierid, for ammount of antal
            }
            redirectAttributes.addAttribute("bestelBonID", idBestelBon);                             // fill attributes for transport; if this is not used, it will be null
            session.invalidate();                                                                       // drop the session, clean JSESSIONID cookie
            return new ModelAndView("redirect:/");                                           // redirect to welcome page - if it shows message, everything should be ok
        }
        return new ModelAndView("redirect:/");                                               // redirect to welcome page - if it shows normal page, no message, then mandje is empty
    }

    private ModelAndView bestelBonGeneration() {
        ModelAndView modelAndView = new ModelAndView("mandje");
        Set<Long> keys = mandje.getKeys();
        Set<Bestelbonlijn> workingSet = new LinkedHashSet<>();
        Map<Bier, Long> aantalsWithBiers = new LinkedHashMap<>();
        for (Long key : keys) {
            Optional<Bier> optionalBier = bierService.findBierById(key);
            optionalBier.ifPresent(bier -> {
                aantalsWithBiers.put(bier, mandje.getAantal(key));
                Bestelbonlijn bestelbonlijn = new Bestelbonlijn(0, bier.getId(),
                        mandje.getAantal(key), bier.getPrijs());
                workingSet.add(bestelbonlijn);
                bestelbonlijnSet = workingSet.stream().distinct().collect(Collectors.toList());
            });
        }
        modelAndView.addObject("aantalsWithBiers", aantalsWithBiers);
        return modelAndView;
    }


}
