package com.example.examen2.programacionacademica.service;

import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import com.example.examen2.programacionacademica.repository.ProgramacionAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramacionAcademicaService {

    @Autowired
    private ProgramacionAcademicaRepository programacionAcademicaRepository;

    public List<ProgramacionAcademica> getAllProgramaciones() {
        return programacionAcademicaRepository.findAll();
    }

    public ProgramacionAcademica createProgramacion(ProgramacionAcademica programacionAcademica) {
        return programacionAcademicaRepository.save(programacionAcademica);
    }

    public ProgramacionAcademica getProgramacionById(Long id) {
        return programacionAcademicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Programación no encontrada"));
    }

    public ProgramacionAcademica updateProgramacion(Long id, ProgramacionAcademica programacionDetails) {
        ProgramacionAcademica programacion = programacionAcademicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Programación no encontrada"));

        programacion.setDocente(programacionDetails.getDocente());
        programacion.setMateria(programacionDetails.getMateria());
        programacion.setAula(programacionDetails.getAula());
        programacion.setSesiones(programacionDetails.getSesiones());

        return programacionAcademicaRepository.save(programacion);
    }

    public void deleteProgramacion(Long id) {
        ProgramacionAcademica programacion = programacionAcademicaRepository.findById(id).orElseThrow(() -> new RuntimeException("Programación no encontrada"));
        programacionAcademicaRepository.delete(programacion);
    }
}
