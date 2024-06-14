package com.example.examen2.materia.model;

import com.example.examen2.carrera.model.CarreraDT0;

public class MateriaDTO {
    private Long id;
    private String nombre;
    private Integer creditos;
    private CarreraDT0 carrera;

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

    public CarreraDT0 getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDT0 carrera) {
        this.carrera = carrera;
    }
}
