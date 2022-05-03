package com.cenfotec.GrilloFeliz.services;

import com.cenfotec.GrilloFeliz.entities.Libro;
import com.cenfotec.GrilloFeliz.entities.Padre;
import com.cenfotec.GrilloFeliz.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    LibroRepository libroRepository;

    public List<Libro> getAllLibros(int count){
        return  this.libroRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    public Optional<Libro> getLibro(int id){
        return this.libroRepository.findById(id);
    }

    public Libro createLibro(String nombre, String descripcion, String autor){
        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setDescripcion(descripcion);
        libro.setAutor(autor);
        return this.libroRepository.save(libro);
    }

    public void update (Libro libro){
        libroRepository.save(libro);
    }

    public Libro crear(Libro libro){
        return this.libroRepository.save(libro);
    }

    public void delete (int id){
        libroRepository.deleteById(id);
    }
}
