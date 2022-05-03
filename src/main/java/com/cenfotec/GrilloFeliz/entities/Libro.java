package com.cenfotec.GrilloFeliz.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode
@Entity
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "autor")
    private String autor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LIBRO_ID",referencedColumnName = "ID")
    private Hijo hijo;

}
