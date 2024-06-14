package com.example.examen2.programacionacademica.service;

import com.example.examen2.programacionacademica.model.SesionClase;
import com.example.examen2.programacionacademica.repository.SesionClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SesionClaseService {

    @Autowired
    private SesionClaseRepository sesionClaseRepository;

    public List<SesionClase> getAllSesiones() {
        return sesionClaseRepository.findAll();
    }

    public SesionClase createSesion(SesionClase sesionClase) {
        return sesionClaseRepository.save(sesionClase);
    }

    public SesionClase getSesionById(Long id) {
        return sesionClaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Sesión no encontrada"));
    }

    public SesionClase updateSesion(Long id, SesionClase sesionDetails) {
        SesionClase sesion = sesionClaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Sesión no encontrada"));

        sesion.setDiaSemana(sesionDetails.getDiaSemana());
        sesion.setHoraInicio(sesionDetails.getHoraInicio());
        sesion.setHoraFin(sesionDetails.getHoraFin());

        return sesionClaseRepository.save(sesion);
    }

    public void deleteSesion(Long id) {
        SesionClase sesion = sesionClaseRepository.findById(id).orElseThrow(() -> new RuntimeException("Sesión no encontrada"));
        sesionClaseRepository.delete(sesion);
    }
}
