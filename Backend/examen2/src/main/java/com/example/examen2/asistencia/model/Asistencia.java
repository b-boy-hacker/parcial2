package com.example.examen2.asistencia.model;

import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "programacion_academica_id")
    private ProgramacionAcademica programacionAcademica;

    private Date fecha;
    private String estado;
    private String observaciones;
    private String fotoUrl; // URL de la foto de asistencia
    private double latitud;  // Coordenada GPS de latitud del docente
    private double longitud; // Coordenada GPS de longitud del docente

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProgramacionAcademica getProgramacionAcademica() {
        return programacionAcademica;
    }

    public void setProgramacionAcademica(ProgramacionAcademica programacionAcademica) {
        this.programacionAcademica = programacionAcademica;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(String fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }
}
