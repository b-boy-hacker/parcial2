package com.example.examen2.carrera.model;

public class CarreraDT0 {
    private Long id;
    private String nombre;
    private String codigo;
    private FacultadDT0 facultad;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public FacultadDT0 getFacultad() {
        return facultad;
    }

    public void setFacultad(FacultadDT0 facultad) {
        this.facultad = facultad;
    }
}
