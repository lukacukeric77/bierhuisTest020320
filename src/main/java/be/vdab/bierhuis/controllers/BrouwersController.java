package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.services.BierService;
import be.vdab.bierhuis.services.BrouwersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView modelAndView = new ModelAndView("bieren", "bieren", bierService.findAllBierenByIdOfBrouwer(id));
                modelAndView.addObject("brouwer", brouwersService.findBrewerByItsId(id));
                return modelAndView;
    }
}
