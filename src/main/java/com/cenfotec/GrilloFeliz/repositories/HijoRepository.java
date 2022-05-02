package com.cenfotec.GrilloFeliz.repositories;

import com.cenfotec.GrilloFeliz.entities.Hijo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HijoRepository extends JpaRepository <Hijo, Long> { }
