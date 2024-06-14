package com.example.examen2.reporte.service;

import com.example.examen2.reporte.model.Reporte;
import com.example.examen2.reporte.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> getAllReportes() {
        return reporteRepository.findAll();
    }

    public Reporte createReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte getReporteById(Long id) {
        return reporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
    }

    public Reporte updateReporte(Long id, Reporte reporteDetails) {
        Reporte reporte = reporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));

        reporte.setFechaGeneracion(reporteDetails.getFechaGeneracion());
        reporte.setData(reporteDetails.getData());
        reporte.setPeriodo(reporteDetails.getPeriodo());
        reporte.setTipoReporte(reporteDetails.getTipoReporte());

        return reporteRepository.save(reporte);
    }

    public void deleteReporte(Long id) {
        Reporte reporte = reporteRepository.findById(id).orElseThrow(() -> new RuntimeException("Reporte no encontrado"));
        reporteRepository.delete(reporte);
    }
}
