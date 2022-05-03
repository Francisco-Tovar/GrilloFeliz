package com.cenfotec.GrilloFeliz.mutation;

import com.cenfotec.GrilloFeliz.entities.Libro;
import com.cenfotec.GrilloFeliz.services.LibroService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LibroMutation implements GraphQLMutationResolver {
    @Autowired
    private LibroService libroService;

    public Libro createLibro(String nombre,String descripcion, String autor){
        return this.libroService.createLibro(nombre, descripcion, autor);
    }
}