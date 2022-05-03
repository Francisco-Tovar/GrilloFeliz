package com.cenfotec.GrilloFeliz.controllers;

import com.cenfotec.GrilloFeliz.entities.Hijo;
import com.cenfotec.GrilloFeliz.entities.Libro;
import com.cenfotec.GrilloFeliz.entities.Padre;
import com.cenfotec.GrilloFeliz.services.HijoService;
import com.cenfotec.GrilloFeliz.services.LibroService;
import com.cenfotec.GrilloFeliz.services.PadreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HijoController {

    @Autowired HijoService hijoService;
    @Autowired PadreService padreService;
    @Autowired LibroService libroService;

    public Model agregarOpciones(Model model){
        List options = new ArrayList<String>();
        options.add("Club de lectura");
        options.add("Guarderia");
        options.add("Club y guarderia");
        model.addAttribute("matricula", options);

        List padres = padreService.getAll();
        model.addAttribute("padres", padres);

        List libros = libroService.getAllLibros(100);
        model.addAttribute("libros", libros);

        return model;
    }


    @RequestMapping(value = "/registrarHijo", method = RequestMethod.GET)
    public String navegarRegistroHijo(Model model){
        model = agregarOpciones(model);
        model.addAttribute(new Hijo());
        return "registrarHijo";
    }

    @RequestMapping(value = "/registrarHijo", method = RequestMethod.POST)
    public String accionRegistroHijo(Hijo hijo, BindingResult result, Model model){
        hijoService.save(hijo);
        return "exito";
    }

    @RequestMapping("/listarConteo")
    public String listarHijos(Model model){
        model.addAttribute("hijos", hijoService.getAll());
        return "listarConteo";
    }

    @RequestMapping(value = "/editarHijo/{id}")
    public String navEditarHijo(Model model, @PathVariable int id){
        model = agregarOpciones(model);
        Optional<Hijo> hijoToEdit = hijoService.getById(id);
        if (hijoToEdit.isPresent()) {
            model.addAttribute("hijo", hijoToEdit);
            return "editarHijo";
        }else{
            return "notFound";
        }
    }

    @RequestMapping(value = "/editarHijo/{id}", method = RequestMethod.POST)
    public String guardarCambios(Hijo hijo, BindingResult result,Model model, @PathVariable int id) {
        Optional<Hijo> hijoToEdit = hijoService.getById(id);
        if (hijoToEdit.isPresent()){
            hijo.setPadre(hijoToEdit.get().getPadre());
            hijo.setLibros(hijoToEdit.get().getLibros());
            hijoService.update(hijo);
            return "exito";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/adjudicarLibroLeido/{id}")
    public String navAdjudicarLectura(Model model,@PathVariable int id){
        model = agregarOpciones(model);
        Optional<Hijo> hijoToEdit = hijoService.getById(id);
        if (hijoToEdit.isPresent()) {
            model.addAttribute("hijo", hijoToEdit);
            return "adjudicarLibroLeido";
        }else{
            return "notFound";
        }
    }

    @RequestMapping(value = "/adjudicarLibroLeido/{id}", method = RequestMethod.POST)
    public String guardarLectura(Hijo hijo, BindingResult result,Model model, @PathVariable int id) {
        Optional<Hijo> hijoToEdit = hijoService.getById(id);
        if (hijoToEdit.isPresent()){
            hijo.setPadre(hijoToEdit.get().getPadre());
            Libro temp = hijo.getLibros().get(0);
            hijo.setLibros(hijoToEdit.get().getLibros());
            hijo.addLibro(temp);
            hijoService.update(hijo);
            return "exito";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/listarLecturas/{id}")
    public String navListarLecturas(Model model, @PathVariable int id){
        Optional<Hijo> hijoToEdit = hijoService.getById(id);
        if (hijoToEdit.isPresent()) {
            List<Hijo> hijos = new ArrayList<>();
            hijos.add(hijoToEdit.get());
            model.addAttribute("hijos", hijos);
            return "listarLecturas";
        }else{
            return "notFound";
        }
    }


}//end
