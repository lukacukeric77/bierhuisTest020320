package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bier;
import be.vdab.bierhuis.domain.Brouwer;
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
@RequestMapping("brouwers")
class BrouwersController {

    private final BierService bierService;
    private final BrouwersService brouwersService;

    public BrouwersController(BierService bierService, BrouwersService brouwersService) {
        this.bierService = bierService;
        this.brouwersService = brouwersService;
    }

    @GetMapping
    public ModelAndView brouwers(){
        return new ModelAndView("brouwers", "brouwers", brouwersService.findAllBrouwers());

    }

    @GetMapping("{id}")
    public ModelAndView bierVinder(@PathVariable long id){
        ModelAndView modelAndView = new ModelAndView("bieren");
        modelAndView.addObject("bieren", bierService.findAllBierenByIdOfBrouwer(id));
        Optional<Brouwer> optionalBrouwer = brouwersService.findBrewerByItsId(id);
        optionalBrouwer.ifPresent(brouwer -> {
            modelAndView.addObject("brouwer", brouwer);
        });
                return modelAndView;
    }

    @GetMapping("{id}/{idOfBier}")
    public ModelAndView bierDetails(@PathVariable long idOfBier){
        ModelAndView modelAndView = new ModelAndView("bier");
        Optional<Bier> optionalBier = bierService.findBierById(idOfBier);
        optionalBier.ifPresent(bier -> modelAndView.addObject("bier", bier));
        modelAndView.addObject("aantalForm", new AantalForm(null));
        return modelAndView;
    }

    @PostMapping("{id}/{idOfBier}")
    public ModelAndView toevoegenForm(){
        return null;
    }
}
