package com.cenfotec.GrilloFeliz.repositories;

import com.cenfotec.GrilloFeliz.entities.Padre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PadreRepository extends JpaRepository <Padre, Long> {

    Optional<Padre> findFirstByNombreContains(String nombre);
}
