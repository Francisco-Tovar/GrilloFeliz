package com.cenfotec.GrilloFeliz.controllers;

import com.cenfotec.GrilloFeliz.entities.Hijo;
import com.cenfotec.GrilloFeliz.entities.Libro;
import com.cenfotec.GrilloFeliz.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LibroController {

    @Autowired
    LibroService libroService;

    @RequestMapping(value = "/registrarLibro", method = RequestMethod.GET)
    public String navegarRegistroLibro(Model model){
        model.addAttribute(new Libro());
        return "registrarLibro";
    }

    @RequestMapping(value = "/registrarLibro", method = RequestMethod.POST)
    public String accionRegistroLibro(Libro libro, BindingResult result, Model model){
        libroService.crear(libro);
        return "exito";
    }

}
