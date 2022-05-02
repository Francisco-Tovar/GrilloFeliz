package com.cenfotec.GrilloFeliz.services;

import com.cenfotec.GrilloFeliz.entities.Hijo;
import com.cenfotec.GrilloFeliz.repositories.HijoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HijoService {

    @Autowired
    HijoRepository hijoRepository;

    public void save (Hijo hijo){
        hijoRepository.save(hijo);
    }

    public List<Hijo> getAll(){
        return hijoRepository.findAll();
    }

    public Optional<Hijo> getById (int id){
        return hijoRepository.findById(Long.valueOf(id));
    }

    public void update(Hijo hijo){
        hijoRepository.save(hijo);
    }

    public void delete (int id){
        hijoRepository.deleteById(Long.valueOf(id));
    }

}
