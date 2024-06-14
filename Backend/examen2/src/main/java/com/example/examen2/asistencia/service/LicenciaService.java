package com.example.examen2.asistencia.service;

import com.example.examen2.asistencia.model.Licencia;
import com.example.examen2.asistencia.repository.LicenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenciaService {

    @Autowired
    private LicenciaRepository licenciaRepository;

    public List<Licencia> getAllLicencias() {
        return licenciaRepository.findAll();
    }

    public Licencia createLicencia(Licencia licencia) {
        return licenciaRepository.save(licencia);
    }

    public Licencia getLicenciaById(Long id) {
        return licenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Licencia no encontrada"));
    }

    public Licencia updateLicencia(Long id, Licencia licenciaDetails) {
        Licencia licencia = licenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Licencia no encontrada"));

        licencia.setFechaInicio(licenciaDetails.getFechaInicio());
        licencia.setFechaFin(licenciaDetails.getFechaFin());
        licencia.setMotivo(licenciaDetails.getMotivo());
        licencia.setEstado(licenciaDetails.getEstado());

        return licenciaRepository.save(licencia);
    }

    public void deleteLicencia(Long id) {
        Licencia licencia = licenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Licencia no encontrada"));
        licenciaRepository.delete(licencia);
    }
}
