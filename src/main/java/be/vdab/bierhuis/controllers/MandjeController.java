package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.domain.Bestelbonlijn;
import be.vdab.bierhuis.services.BestelbonLijnService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("mandje")
public class MandjeController {
    private final Mandje mandje;
    private final BestelbonLijnService bestelbonLijnService;

    public MandjeController(Mandje mandje, BestelbonLijnService bestelbonLijnService) {
        this.mandje = mandje;
        this.bestelbonLijnService = bestelbonLijnService;
    }

    @GetMapping
    public ModelAndView showMandje(){
        List<Bestelbonlijn> bestelbonlijns = bestelbonLijnService.findAll();
        ModelAndView modelAndView = new ModelAndView("mandje");
        modelAndView.addObject("allBestelbonlijnen", bestelbonlijns);
        if (mandje.isFilled()){
            modelAndView.addObject("bestelbonenInMandje",
                    bestelbonlijns.stream().filter(bestelbonlijn -> mandje.hasInside(bestelbonlijn.getBierid())).collect(Collectors.toList()));
        }
        return modelAndView;
    }


}
