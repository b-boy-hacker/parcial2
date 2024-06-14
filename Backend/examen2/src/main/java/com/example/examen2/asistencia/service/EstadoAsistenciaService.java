package com.example.examen2.asistencia.service;

import com.example.examen2.asistencia.model.EstadoAsistencia;
import com.example.examen2.asistencia.repository.EstadoAsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoAsistenciaService {

    @Autowired
    private EstadoAsistenciaRepository estadoAsistenciaRepository;

    public List<EstadoAsistencia> getAllEstadosAsistencia() {
        return estadoAsistenciaRepository.findAll();
    }

    public EstadoAsistencia createEstadoAsistencia(EstadoAsistencia estadoAsistencia) {
        return estadoAsistenciaRepository.save(estadoAsistencia);
    }

    public EstadoAsistencia getEstadoAsistenciaById(Long id) {
        return estadoAsistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado de Asistencia no encontrado"));
    }

    public EstadoAsistencia updateEstadoAsistencia(Long id, EstadoAsistencia estadoAsistenciaDetails) {
        EstadoAsistencia estadoAsistencia = estadoAsistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado de Asistencia no encontrado"));

        estadoAsistencia.setNombre(estadoAsistenciaDetails.getNombre());

        return estadoAsistenciaRepository.save(estadoAsistencia);
    }

    public void deleteEstadoAsistencia(Long id) {
        EstadoAsistencia estadoAsistencia = estadoAsistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Estado de Asistencia no encontrado"));
        estadoAsistenciaRepository.delete(estadoAsistencia);
    }
}
