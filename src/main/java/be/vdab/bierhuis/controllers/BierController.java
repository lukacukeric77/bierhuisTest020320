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
class BierController {

    private final BierService bierService;
    private final Mandje mandje;

    public BierController(BierService bierService, Mandje mandje) {
        this.bierService = bierService;
        this.mandje = mandje;
    }

    @GetMapping("{idOfBier}")
    public ModelAndView bierDetails(@PathVariable long idOfBier) {
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findBierById(idOfBier);
        optionalBier.ifPresent(bier -> modelAndView.addObject("bier", bier));
        modelAndView.addObject(new AantalForm(0, idOfBier));
        return modelAndView;
    }

    @PostMapping ("form")
    public String tovoegenMaandje(@Valid AantalForm aantalForm, Errors errors) {
        if (errors.hasErrors()){
            return "redirect:/{idOfBier}";
        }
        mandje.fillIn(aantalForm.getIdOfBier(), aantalForm.getAantal());
        return "redirect:/mandje";
    }
}
