package com.example.examen2.docente.model;

import com.example.examen2.common.model.Usuario;
import com.example.examen2.materia.model.Materia;
import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Docente extends Usuario {

    @ManyToMany
    @JoinTable(
            name = "docente_materia",
            joinColumns = @JoinColumn(name = "docente_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private Set<Materia> materias;

    @OneToMany(mappedBy = "docente")
    private Set<ProgramacionAcademica> programaciones;

    // Getters y Setters
    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }

    public Set<ProgramacionAcademica> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(Set<ProgramacionAcademica> programaciones) {
        this.programaciones = programaciones;
    }
}
