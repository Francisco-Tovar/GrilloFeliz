package com.cenfotec.GrilloFeliz.controllers;
import com.cenfotec.GrilloFeliz.entities.Padre;
import com.cenfotec.GrilloFeliz.services.PadreService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PadreController {

    @Autowired PadreService padreService;

    @RequestMapping(value = "/registrarPadre", method = RequestMethod.GET)
    public String navRegistroPadre(Model model){
        model.addAttribute(new Padre());
        return "registrarPadre";
    }

    @RequestMapping(value = "/registrarPadre", method = RequestMethod.POST)
    public String accRegistroPadre(Padre padre, BindingResult result, Model model){
        padreService.save(padre);
        return "exito";
    }

    @RequestMapping("/listarPadres")
    public String listarPadres(Model model){
        model.addAttribute("padres", padreService.getAll());
        return "listarPadres";
    }

    @RequestMapping(value = "/editarPadre/{id}")
    public String navEditarPadre(Model model, @PathVariable int id){
        Optional<Padre> padreToEdit = padreService.getById(id);
        if (padreToEdit.isPresent()) {
            model.addAttribute("padre", padreToEdit);
            return "editarPadre";
        }else{
            return "notFound";
        }

    }


}
