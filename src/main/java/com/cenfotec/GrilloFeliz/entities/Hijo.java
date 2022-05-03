package com.cenfotec.GrilloFeliz.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hijo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String matricula;
    private String alergias;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "HIJO_ID", referencedColumnName = "ID")
    private Padre padre;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "LIBRO_ID", referencedColumnName = "ID")
    private List<Libro> libros;


    public Hijo() {
    }

    public Hijo(Long id, String nombre, String matricula, String alergias, Padre padre) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.alergias = alergias;
        this.padre = padre;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
    public void addLibro(Libro libro){

        this.libros.add(libro);
    }

    public int getLibrosCount(){
        return this.libros.size();
    }
}
