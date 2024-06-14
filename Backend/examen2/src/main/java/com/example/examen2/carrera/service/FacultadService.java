package com.example.examen2.carrera.service;

import com.example.examen2.carrera.model.Facultad;
import com.example.examen2.carrera.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultadService {

    @Autowired
    private FacultadRepository facultadRepository;

    public List<Facultad> getAllFacultades() {
        return facultadRepository.findAll();
    }

    public Facultad createFacultad(Facultad facultad) {
        return facultadRepository.save(facultad);
    }

    public Facultad getFacultadById(Long id) {
        return facultadRepository.findById(id).orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
    }

    public Facultad updateFacultad(Long id, Facultad facultadDetails) {
        Facultad facultad = facultadRepository.findById(id).orElseThrow(() -> new RuntimeException("Facultad no encontrada"));

        facultad.setNombre(facultadDetails.getNombre());

        return facultadRepository.save(facultad);
    }

    public void deleteFacultad(Long id) {
        Facultad facultad = facultadRepository.findById(id).orElseThrow(() -> new RuntimeException("Facultad no encontrada"));
        facultadRepository.delete(facultad);
    }
}
