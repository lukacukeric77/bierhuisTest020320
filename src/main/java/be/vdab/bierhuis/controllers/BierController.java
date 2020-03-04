package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.forms.AantalForm;
import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.services.BrouwersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("bier")
public class BierController {

    private final BierService bierService;

    public BierController(BierService bierService) {
        this.bierService = bierService;
    }

    @GetMapping("{idOfBier}")
    public ModelAndView bierDetails(@PathVariable long idOfBier){
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findBierById(idOfBier);
        optionalBier.ifPresent(bier -> modelAndView.addObject("bier", bier));
        modelAndView.addObject("aantalForm", new AantalForm(null));
        return modelAndView;
    }

    @PostMapping("{idOfBier}")
    public ModelAndView toevoegenForm(){
        return null;
    }

}
