package com.cenfotec.GrilloFeliz.services;

import com.cenfotec.GrilloFeliz.entities.Padre;
import com.cenfotec.GrilloFeliz.repositories.PadreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PadreService {

    @Autowired
    PadreRepository padreRepository;

    public void save (Padre padre){
        padreRepository.save(padre);
    }

    public List<Padre> getAll(){
        return padreRepository.findAll();
    }

    public Optional<Padre> getById(int id){
        return padreRepository.findById(Long.valueOf(id));
    }

    public Optional<Padre> getByNombre (String nombre){
        return padreRepository.findPadresByNombreContaining(nombre);

    }

    public void update (Padre padre){
        padreRepository.save(padre);
    }

    public void delete(int id){
        padreRepository.deleteById(Long.valueOf(id));
    }
}
