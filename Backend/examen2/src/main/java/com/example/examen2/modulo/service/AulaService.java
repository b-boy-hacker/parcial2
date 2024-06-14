package com.example.examen2.modulo.service;

import com.example.examen2.modulo.model.Aula;
import com.example.examen2.modulo.repository.AulaRepository;
import com.example.examen2.carrera.model.Facultad;
import com.example.examen2.carrera.repository.FacultadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AulaService {

    @Autowired
    private AulaRepository aulaRepository;

    @Autowired
    private FacultadRepository facultadRepository;

    public List<Aula> getAllAulas() {
        return aulaRepository.findAll();
    }

    public Aula createAula(Aula aula) {
        if (aula.getFacultad() != null) {
            Facultad facultad = facultadRepository.findById(aula.getFacultad().getId()).orElseThrow(() -> new RuntimeException("Facultad not found"));
            aula.setFacultad(facultad);
        }
        return aulaRepository.save(aula);
    }

    public Aula getAulaById(Long id) {
        return aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula not found"));
    }

    public Aula updateAula(Long id, Aula aulaDetails) {
        Aula aula = aulaRepository.findById(id).orElseThrow(() -> new RuntimeException("Aula not found"));
        aula.setNombre(aulaDetails.getNombre());
        aula.setLatitud(aulaDetails.getLatitud());
        aula.setLongitud(aulaDetails.getLongitud());
        if (aulaDetails.getFacultad() != null) {
            Facultad facultad = facultadRepository.findById(aulaDetails.getFacultad().getId()).orElseThrow(() -> new RuntimeException("Facultad not found"));
            aula.setFacultad(facultad);
        }
        return aulaRepository.save(aula);
    }

    public void deleteAula(Long id) {
        aulaRepository.deleteById(id);
    }
}
