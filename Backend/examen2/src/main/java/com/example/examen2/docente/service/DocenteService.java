package com.example.examen2.docente.service;

import com.example.examen2.docente.model.Docente;
import com.example.examen2.docente.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocenteService {

    @Autowired
    private DocenteRepository docenteRepository;

    public List<Docente> getAllDocentes() {
        return docenteRepository.findAll();
    }

    public Docente createDocente(Docente docente) {
        return docenteRepository.save(docente);
    }

    public Docente getDocenteById(Long id) {
        return docenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
    }

    public Docente updateDocente(Long id, Docente docenteDetails) {
        Docente docente = docenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Docente no encontrado"));

        docente.setNombre(docenteDetails.getNombre());
        docente.setApellido(docenteDetails.getApellido());
        docente.setEmail(docenteDetails.getEmail());
        docente.setContrasena(docenteDetails.getContrasena());
        docente.setMaterias(docenteDetails.getMaterias());
        docente.setProgramaciones(docenteDetails.getProgramaciones());

        return docenteRepository.save(docente);
    }

    public void deleteDocente(Long id) {
        Docente docente = docenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Docente no encontrado"));
        docenteRepository.delete(docente);
    }
}
