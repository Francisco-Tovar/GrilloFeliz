package com.cenfotec.GrilloFeliz.controllers;

import com.cenfotec.GrilloFeliz.entities.Hijo;
import com.cenfotec.GrilloFeliz.entities.Libro;
import com.cenfotec.GrilloFeliz.entities.Padre;
import com.cenfotec.GrilloFeliz.services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

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

    @RequestMapping("/listarLibros")
    public String listarLibros(Model model){
        model.addAttribute("libros", libroService.getAllLibros(100));
        return "listarlibros";
    }

    @RequestMapping(value = "/borrarLibro/{id}")
    public String borrarAuditoria(Libro libro, BindingResult result,Model model, @PathVariable int id) {
        libroService.delete(id);
        return "exito";
    }

    @RequestMapping(value = "/editarLibro/{id}")
    public String navEditarLibro(Model model, @PathVariable int id){
        Optional<Libro> libroToEdit = libroService.getLibro(id);
        if (libroToEdit.isPresent()) {
            model.addAttribute("libro", libroToEdit);
            return "editarLibro";
        }else{
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarLibro/{id}", method = RequestMethod.POST)
    public String guardarCambiosLibro(Libro libro, BindingResult result,Model model, @PathVariable int id) {
        Optional<Libro> libroToEdit = libroService.getLibro(id);
        if (libroToEdit.isPresent()){
            libroService.update(libro);
            return "exito";
        } else {
            return "notFound";
        }
    }

}
