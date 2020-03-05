package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.services.BestelbonLijnService;
import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mandje")
public class MandjeController {
    private final Mandje mandje;
    private final BestelbonLijnService bestelbonLijnService;

    public MandjeController(Mandje mandje, BestelbonLijnService bestelbonLijnService) {
        this.mandje = mandje;
        this.bestelbonLijnService = bestelbonLijnService;
    }


}
