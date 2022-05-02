package com.cenfotec.GrilloFeliz.entities;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private int matricula;
    private String alergias;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HIJO_ID", referencedColumnName = "ID")
    private Padre padre;


    public Hijo() {
    }

    public Hijo(Long id, String nombre, int matricula, String alergias) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.alergias = alergias;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Padre getPadre() {
        return padre;
    }

    public void setPadre(Padre padre) {
        this.padre = padre;
    }
}
