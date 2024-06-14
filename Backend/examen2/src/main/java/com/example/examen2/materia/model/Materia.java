package com.example.examen2.materia.model;

import com.example.examen2.carrera.model.Carrera;
import com.example.examen2.docente.model.Docente;
import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer creditos;

    @ManyToOne
    @JoinColumn(name = "carrera_id")
    @JsonBackReference
    private Carrera carrera;

    @ManyToMany(mappedBy = "materias")
    private Set<Docente> docentes;

    @OneToMany(mappedBy = "materia")
    private Set<ProgramacionAcademica> programaciones;

    // Getters y Setters
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

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Set<Docente> getDocentes() {
        return docentes;
    }

    public void setDocentes(Set<Docente> docentes) {
        this.docentes = docentes;
    }

    public Set<ProgramacionAcademica> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(Set<ProgramacionAcademica> programaciones) {
        this.programaciones = programaciones;
    }
}
