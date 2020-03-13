package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.forms.AantalForm;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("bier")
class BierController {

    private final BierService bierService;
    private final Mandje mandje;
    private long idOFbier = 0;

    public BierController(BierService bierService, Mandje mandje) {
        this.bierService = bierService;
        this.mandje = mandje;
    }

    @GetMapping("{idOfBier}")
    public ModelAndView bierDetails(@PathVariable long idOfBier) {
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findBierById(idOfBier);
        optionalBier.ifPresent(bier -> {
            idOFbier = bier.getId();
            modelAndView.addObject("bier", bier);
        });
        modelAndView.addObject(new AantalForm(0));
        return modelAndView;
    }

    @PostMapping ("form")
    public ModelAndView tovoegenMaandje(@Valid AantalForm aantalForm, Errors errors) {
        ModelAndView modelAndView = new ModelAndView("bier");
        if (errors.hasErrors()){
            return modelAndView;
        }

        mandje.fillIn(idOFbier, aantalForm.getAantal());
        return new ModelAndView("redirect:/mandje");
    }
}
