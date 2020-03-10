package be.vdab.bierhuis.controllers;

import be.vdab.bierhuis.sessions.Mandje;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
class MandjeControlerAdvice {
    private final Mandje mandje;

    MandjeControlerAdvice(Mandje mandje) {
        this.mandje = mandje;
    }

    @ModelAttribute
    void mandjeAddedToModel(Model model){
        model.addAttribute(mandje);
    }
}
