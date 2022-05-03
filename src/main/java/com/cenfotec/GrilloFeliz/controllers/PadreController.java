package com.cenfotec.GrilloFeliz.controllers;
import com.cenfotec.GrilloFeliz.entities.Padre;
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
public class PadreController {

    @Autowired PadreService padreService;

    @RequestMapping(value = "/registrarPadre", method = RequestMethod.GET)
    public String navegarRegistroPadre(Model model){
        model.addAttribute(new Padre());
        return "registrarPadre";
    }

    @RequestMapping(value = "/registrarPadre", method = RequestMethod.POST)
    public String accionRegistroPadre(Padre padre, BindingResult result, Model model){
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

    @RequestMapping(value = "/editarPadre/{id}", method = RequestMethod.POST)
    public String guardarCambios(Padre padre, BindingResult result,Model model, @PathVariable int id) {
        Optional<Padre> padreToEdit = padreService.getById(id);
        if (padreToEdit.isPresent()){
            padre.setHijos(padreToEdit.get().getHijos());
            padreService.update(padre);
            return "exito";
        } else {
            return "notFound";
        }
    }

    @RequestMapping(value = "/listarHijos/{id}")
    public String navListarHijos(Model model, @PathVariable int id){
        Optional<Padre> padreToEdit = padreService.getById(id);
        if (padreToEdit.isPresent()) {
            List<Padre> padres = new ArrayList<>();
            padres.add(padreToEdit.get());
            model.addAttribute("padres", padres);
            return "listarHijos";
        }else{
            return "notFound";
        }
    }

    @RequestMapping("/buscarPadres")
    public String navbuscarPadres(Model model){
        model.addAttribute("padres", padreService.getAll());
        return "buscarPadres";
    }

    @RequestMapping(path = {"/buscarPadres"}, method = RequestMethod.GET)
    public String accBuscarPadres(Padre padre, Model model, String keyword) {
        if(keyword!=null) {
            Optional<Padre> list = padreService.getByNombre(keyword);
            if (list.isPresent()){
                List<Padre> lista = new ArrayList<>();
                lista.add(list.get());
                model.addAttribute("padres", lista);
            }else{
                model.addAttribute("padres", padreService.getAll());
            }
            return "buscarPadres";
        }else {
            List<Padre> list = padreService.getAll();
            model.addAttribute("padres", list);}
        return "buscarPadres";
    }


}//end
