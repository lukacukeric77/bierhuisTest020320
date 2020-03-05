package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bestelbon;
import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.forms.AantalForm;
import be.vdab.bierhuis.services.BestelbonLijnService;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.services.BrouwersService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("bier")
public class BierController {

    private final BierService bierService;
    private final BestelbonLijnService bestelbonLijnService;

    public BierController(BierService bierService, BestelbonLijnService bestelbonLijnService) {
        this.bierService = bierService;
        this.bestelbonLijnService = bestelbonLijnService;
    }

    @GetMapping("{idOfBier}")
    public ModelAndView bierDetails(@PathVariable long idOfBier) {
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findBierById(idOfBier);
        optionalBier.ifPresent(bier -> modelAndView.addObject("bier", bier));
        modelAndView.addObject("aantalForm", new AantalForm(0, idOfBier));
        return modelAndView;
    }

    @GetMapping("form")
    public String toevoegenForm(@Valid AantalForm aantalForm, Errors errors) {
        if (errors.hasErrors()) {
            return "{idOfBier}";
        }

            //write here something that will redirect you to mandje and include things in mandje;

//        return "redirect:/maandje";
        return "{idOfBier}";
    }
}
