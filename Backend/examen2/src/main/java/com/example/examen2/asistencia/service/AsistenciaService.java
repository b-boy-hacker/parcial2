package com.example.examen2.asistencia.service;

import com.example.examen2.asistencia.model.Asistencia;
import com.example.examen2.asistencia.repository.AsistenciaRepository;
import com.example.examen2.programacionacademica.model.ProgramacionAcademica;
import com.example.examen2.programacionacademica.repository.ProgramacionAcademicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @Autowired
    private ProgramacionAcademicaRepository programacionAcademicaRepository;

    private static final double EARTH_RADIUS = 6371.01; // Kilómetros

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencia createAsistencia(Asistencia asistencia) {
        // Obtener la programación académica
        ProgramacionAcademica programacionAcademica = asistencia.getProgramacionAcademica();

        // Obtener el aula asociada a la programación académica
        double aulaLatitud = programacionAcademica.getAula().getLatitud();
        double aulaLongitud = programacionAcademica.getAula().getLongitud();

        // Calcular la distancia entre el docente y el aula
        double distancia = calcularDistancia(aulaLatitud, aulaLongitud, asistencia.getLatitud(), asistencia.getLongitud());

        // Definir un rango de proximidad (por ejemplo, 0.1 kilómetros)
        if (distancia <= 0.1) {
            // Guardar la asistencia si está dentro del rango
            return asistenciaRepository.save(asistencia);
        } else {
            // Manejar el caso en que la distancia sea mayor al rango permitido
            throw new RuntimeException("El docente no está dentro del rango permitido para registrar asistencia.");
        }
    }

    public Asistencia getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
    }

    public Asistencia updateAsistencia(Long id, Asistencia asistenciaDetails) {
        Asistencia asistencia = asistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));

        asistencia.setFecha(asistenciaDetails.getFecha());
        asistencia.setEstado(asistenciaDetails.getEstado());
        asistencia.setObservaciones(asistenciaDetails.getObservaciones());
        asistencia.setFotoUrl(asistenciaDetails.getFotoUrl());
        asistencia.setLatitud(asistenciaDetails.getLatitud());
        asistencia.setLongitud(asistenciaDetails.getLongitud());

        return asistenciaRepository.save(asistencia);
    }

    public void deleteAsistencia(Long id) {
        Asistencia asistencia = asistenciaRepository.findById(id).orElseThrow(() -> new RuntimeException("Asistencia no encontrada"));
        asistenciaRepository.delete(asistencia);
    }

    // Método para calcular la distancia entre dos puntos GPS usando la fórmula del haversine
    private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return EARTH_RADIUS * c;
    }
}
