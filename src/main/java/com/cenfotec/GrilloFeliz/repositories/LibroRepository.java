package com.cenfotec.GrilloFeliz.repositories;
import com.cenfotec.GrilloFeliz.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer>{ }
