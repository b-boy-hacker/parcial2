package com.example.examen2.programacionacademica.model;

import com.example.examen2.asistencia.model.Asistencia;
import com.example.examen2.docente.model.Docente;
import com.example.examen2.materia.model.Materia;
import com.example.examen2.modulo.model.Aula;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class ProgramacionAcademica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @OneToMany(mappedBy = "programacionAcademica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SesionClase> sesiones;

    @OneToMany(mappedBy = "programacionAcademica")
    private Set<Asistencia> asistencias;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Set<SesionClase> getSesiones() {
        return sesiones;
    }

    public void setSesiones(Set<SesionClase> sesiones) {
        this.sesiones = sesiones;
    }

    public Set<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(Set<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
}
